package models.auth;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import models.Usuario;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlRow;

import play.cache.Cache;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity 
@Table(name = "auth_componentes")
public class Componente extends Model {
	private static final long serialVersionUID = 1L;
	
	@Id  
	public String id;
	public String nombre;
	
	public static Finder<Long,Componente> find = new Finder<Long,Componente>(Long.class, Componente.class);
	
	public static HashSet<String> getComponentesConPermisoAsignado(){
		HashSet<String> permisos = new HashSet<>();
	    String sql = "select c.id componente " +
	    			 "from auth_asignaciones a " +
	    			 "inner join auth_permisos p on p.id = a.permiso_id " +
	    			 "inner join auth_componentes c on c.id = p.componente_id " +
	    			 "where usuario_id = :usuario_id";
	    
	    List<SqlRow> rows = Ebean.createSqlQuery(sql).setParameter("usuario_id", Usuario.getUsuarioSesion()).findList();
	    
	    for (SqlRow row : rows) {
			permisos.add(row.getString("componente"));
		}
	    return permisos;
	}
	
	public static Boolean check(String modulo) {
		Integer usuario = Usuario.getUsuarioSesion();
		HashSet<String> permisos = null;
		if(Cache.get("permisos.componentes."+usuario) == null)
			Cache.set("permisos.componentes."+usuario, getComponentesConPermisoAsignado());

		permisos = new HashSet((Collection) Cache.get("permisos.componentes."+usuario));
		return  permisos.contains(modulo);
	}
	
}
