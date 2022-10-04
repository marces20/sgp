package models.auth;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import com.avaje.ebean.SqlRow;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import models.Usuario;

import com.avaje.ebean.Ebean;


import play.cache.Cache;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity 
@Table(name = "auth_permisos")
public class Permiso extends Model {
	private static final long serialVersionUID = 1L;
	
	@Id
	public String id;
	public String descripcion;
	public String componente_id;
	
	public static Finder<Long,Permiso> find = new Finder<Long,Permiso>(Long.class, Permiso.class);
	
	public static HashSet<String> getAsignados(Integer idUsuario) {
		HashSet<String> permisos = new HashSet<>();
		
	    String sql = "select c.permiso_id permiso from auth_asignaciones c where usuario_id = :usuario_id";
	    List<SqlRow> rows = Ebean.createSqlQuery(sql).setParameter("usuario_id", idUsuario).findList();
	    
	    for (SqlRow row : rows) {
			permisos.add(row.getString("permiso"));
		}

	    return permisos;
	}
	
	public static Boolean check(String permiso) {
		HashSet<String> permisos = null;
		if(Cache.get("permisos.asignados."+Usuario.getUsuarioSesion()) == null)
			Cache.set("permisos.asignados."+Usuario.getUsuarioSesion(), Permiso.getAsignados(Usuario.getUsuarioSesion()));
		
		permisos = new HashSet((Collection) Cache.get("permisos.asignados."+Usuario.getUsuarioSesion()));
		return permisos.contains(permiso);
	}
		
	
}