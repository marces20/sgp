package models;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.avaje.ebean.ExpressionList;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import utils.DateUtils;
import utils.pagination.Pagination;
@Entity 
@Table(name = "auditoria_registros")
public class AuditoriaRegistro extends Model{
	private static final long serialVersionUID = 1L;
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="auditoria_registros_id_seq")
	
	public Long id;
	@Required(message="Debe escribir un tabla")
	public String tabla;	
	
	public Date fecha = new Date();
	public String operacion = "D";
	
	public Long usuario_id;
	
	public Long id_objeto;
	
	
	public static void registrar (String tabla, Long objetoId) {
		AuditoriaRegistro a = new AuditoriaRegistro();
		a.tabla = tabla;
		a.id_objeto = objetoId;
		a.usuario_id = new Long(Usuario.getUsuarioSesion());
		a.save();
	}
	
	
}
