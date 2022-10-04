package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import models.auth.Permiso;

import play.Logger;
import play.api.mvc.Session;
import play.data.validation.Constraints.Required;
import play.data.validation.ValidationError;
import play.db.ebean.Model;
import play.mvc.Http.Context;
import utils.pagination.Pagination;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.SqlRow;


@Entity
@Table(name = "usuarios")
public class Usuario extends Model {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="usuarios_id_seq")
    public Integer id;
	
	@Required(message="Debe escribir el nombre")
	public String nombre;

	@Required(message="Debe escribir un nick")
	public String nick;
	
	@Required(message="Debe escribir una contraseña")
	public String password;
	
	public String email;
	
	public boolean activo = false;
	
	@Required(message="Debe setear plan sumar materno")
	public boolean plansumarmaterno = false;
	
	
	@ManyToOne
	@JoinColumn(name="create_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario create_usuario; 
	@Column(name="create_usuario_id")
	public Long create_usuario_id;
	 
	public Date create_date; 
	public Date write_date; 
	
	@ManyToOne
	@JoinColumn(name="write_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario write_usuario; 
	@Column(name="write_usuario_id")
	public Long write_usuario_id;
	
	@OneToOne        
	@JoinColumn(name="departamento_id", referencedColumnName="id", insertable=false, updatable=false)
	public Departamento departamento;
	public Long departamento_id;
	
	@OneToOne        
	@JoinColumn(name="organigrama_id", referencedColumnName="id", insertable=false, updatable=false)
	public Organigrama organigrama;
	public Long organigrama_id;
				   
	public static Integer getUsuarioSesion(){
		try {
			return Integer.parseInt(Context.current().session().get("id"));
		} catch (Exception e) {
			return null;
		}
	}
	
	public static Usuario getUsurioSesion(){
		try {
			return find.byId(Integer.parseInt(Context.current().session().get("id")));
		} catch (Exception e) {
			return null;
		}
	}
	
	public static Model.Finder<Integer,Usuario> find = new Model.Finder<Integer,Usuario>(Integer.class, Usuario.class);
    
    public static Pagination<Usuario> page(String nombre, String nick) {    	
    	Pagination<Usuario> p = new Pagination<Usuario>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	
    	ExpressionList<Usuario> e = find.where();

    	p.setExpressionList(
	    			find.where()
	                .ilike("nombre", "%" + nombre + "%")
	                .ilike("nick", "%" + nick + "%")
    			);

    	
    	p.setExpressionList(e);
    	
    	return p;
    }
    
	public static List<Usuario> getDataSuggest(String nombre, Integer limit){
		return find.where().ilike("nombre", "%" + nombre + "%").setMaxRows(limit).orderBy("nombre").findList();
	}
	
	public static List<Integer> getUsersDepartamentosHijos(Integer deptoId){
		
		List<Integer>  luAux = new ArrayList<Integer>(); 
		List<Integer>  lu = new ArrayList<Integer>(); 
		
		String sql = "WITH RECURSIVE recursetree AS ( "+
	    " SELECT d.id,d.parent_departamento_id,d.nombre "+
	    " FROM departamentos d "+
	    " WHERE parent_departamento_id = :idDepto "+
		" UNION ALL "+
	    " SELECT c.id,c.parent_departamento_id,c.nombre "+
	    " FROM recursetree t , departamentos AS c "+
	    " WHERE c.parent_departamento_id = t.id )" +
	    " SELECT * FROM recursetree; ";

		List<SqlRow> s = Ebean.createSqlQuery(sql)
				.setParameter("idDepto", deptoId)
				.findList();
		for(SqlRow m : s){
			luAux.add(new Integer(m.getString("id")));
		}
		
		List<Usuario> l =  Usuario.find.where()
				.disjunction()
				.in("departamento_id",luAux)
				.in("departamento_id",deptoId)
				.endJunction()
				.findList();
		
		for(Usuario v : l){
			lu.add(v.id);
		}
		
		return lu;
	}
	
	
	public static List<Integer> getUsersOrganigramaHijos(Integer organigramaId){
		
		List<Integer>  luAux = new ArrayList<Integer>(); 
		List<Integer>  lu = new ArrayList<Integer>(); 
		
		String sql = "WITH RECURSIVE recursetree AS ( "+
	    " SELECT o.id,o.padre_id,o.nombre "+
	    " FROM organigramas o "+
	    " WHERE padre_id = :organigramaId "+
		" UNION ALL "+
	    " SELECT c.id,c.padre_id,c.nombre "+
	    " FROM recursetree t , organigramas AS c "+
	    " WHERE c.padre_id = t.id )" +
	    " SELECT * FROM recursetree; ";

		List<SqlRow> s = Ebean.createSqlQuery(sql)
				.setParameter("organigramaId", organigramaId)
				.findList();
		for(SqlRow m : s){
			luAux.add(new Integer(m.getString("id")));
		}
		
		List<Usuario> l =  Usuario.find.where()
				.disjunction()
				.in("organigrama_id",luAux)
				.in("organigrama_id",organigramaId)
				.endJunction()
				.findList();
		
		for(Usuario v : l){
			lu.add(v.id);
		}
		
		return lu;
	}
    
    public List<ValidationError> validate() {
        List<ValidationError> errors = new ArrayList<ValidationError>();
        if (find.where().eq("nick", nick).ne("id", id).findRowCount() > 0) {
            errors.add(new ValidationError("nick", "El nick ya es usado."));
        }
        return errors.isEmpty() ? null : errors;
    }    
    
    
}
