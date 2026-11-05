package models.recupero;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import models.TipoResidencia;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.pagination.Pagination;

@Entity
@Table(name = "tipo_recupero_factura_historias")
public class TipoRecuperoFacturaHistoria extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="tipo_recupero_factura_historias_id_seq")
	public Long id;

	public String nombre;

	public static Model.Finder<Long,TipoRecuperoFacturaHistoria> find = new Finder<Long,TipoRecuperoFacturaHistoria>(Long.class, TipoRecuperoFacturaHistoria.class);

	public List<TipoRecuperoFacturaHistoria> getDataSuggest(String input,Integer limit){
		List<TipoRecuperoFacturaHistoria> l = find.where()
				.ilike("nombre", "%"+input+"%")
				.setMaxRows(limit).orderBy("nombre")
			    .findList();

		return l;
	}

	public static Pagination<TipoRecuperoFacturaHistoria> page(String nombre) {
    	Pagination<TipoRecuperoFacturaHistoria> p = new Pagination<TipoRecuperoFacturaHistoria>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");

    	p.setExpressionList(
    			find.where()
                .ilike("nombre", "%" + nombre + "%")
	            );
    	return p;
    }

}
