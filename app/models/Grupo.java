package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import play.data.validation.Constraints.Required;
import play.data.validation.ValidationError;
import play.db.ebean.Model;
import utils.pagination.Pagination;


@Entity
@Table(name = "grupos")
public class Grupo extends Model {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="grupos_id_seq")
    public Integer id;
	
	@Required(message="Debe escribir el nombre")
	public String nombre;
	
	public static Model.Finder<Integer,Grupo> find = new Model.Finder<Integer,Grupo>(Integer.class, Grupo.class);
    
	public static Pagination<Grupo> page(String nombre) {    	
    	Pagination<Grupo> p = new Pagination<Grupo>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	
    	p.setExpressionList(
    			find.where()
                .ilike("nombre", "%" + nombre + "%")
	            );
    	return p;
    }
    
    public List<ValidationError> validate() {
        List<ValidationError> errors = new ArrayList<ValidationError>();
        if (Grupo.find.where().eq("nombre", this.nombre).ne("id", id).findRowCount() > 0) {
            errors.add(new ValidationError("nombre", "El nombre ya se encuentra en uso."));
        }
        return errors.isEmpty() ? null : errors;
    }
    
}
