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

@Entity
@Table(name = "auth_modulos")
public class Modulo extends Model {
	private static final long serialVersionUID = 1L;

	public static final Integer COMPRAS = 1;
	public static final Integer CONTABILIDAD = 2;
	public static final Integer RRHH = 3;
	public static final Integer PRESUPUESTO = 4;
	public static final Integer DELEGACION = 5;
	public static final Integer EXPEDIENTES = 6;
	public static final Integer ADMINISTRACION = 7;
	public static final Integer RENDICIONES = 8;
	public static final Integer DASHBOARD = 9;
	public static final Integer PATRIMONIO = 10;
	public static final Integer HABERES = 11;
	public static final Integer RECUPERO = 12;
	public static final Integer INFORMES = 13;
	public static final Integer EQUIPOS = 14;
	public static final Integer NOVEDADES = 15;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="auth_modulos_id_seq")
	public Integer id;
	public String nombre;

	public static Model.Finder<Long,Modulo> find = new Finder<Long,Modulo>(Long.class, Modulo.class);

	public static HashSet<Integer> getModulosConPermisoAsignado(){
		HashSet<Integer> permisos = new HashSet<>();
	    String sql = "select m.id modulo " +
	    			 "from auth_asignaciones a " +
	    			 "inner join auth_permisos p on p.id = a.permiso_id " +
	    			 "inner join auth_componentes c on c.id = p.componente_id " +
	    			 "inner join auth_modulos m on m.id = c.modulo_id " +
	    			 "where usuario_id = :usuario_id";

	    List<SqlRow> rows = Ebean.createSqlQuery(sql).setParameter("usuario_id", Usuario.getUsuarioSesion()).findList();

	    for (SqlRow row : rows) {
			permisos.add(row.getInteger("modulo"));
		}
	    return permisos;
	}

	public static Boolean check(Integer modulo) {
		Integer usuario = Usuario.getUsuarioSesion();
		HashSet<Integer> permisos = null;
		if(Cache.get("permisos.modulos."+usuario) == null)
			Cache.set("permisos.modulos."+usuario, getModulosConPermisoAsignado());

		permisos = new HashSet((Collection) Cache.get("permisos.modulos."+usuario));
		return  permisos.contains(modulo);
	}

}
