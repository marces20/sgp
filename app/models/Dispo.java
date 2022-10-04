package models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.avaje.ebean.ExpressionList;

import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import javax.validation.ConstraintViolationException;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.DateUtils;
import utils.pagination.Pagination;

@Entity
@Table(name = "dispos")
public class Dispo extends Model {
	
	@Id  														 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="dispos_id_seq")
	public Long id;
	
	@Required(message="Debe escribir un numero")
	public Integer numero;
	
	public String descripcion;
	
	public String motivo_baja;
	
	@Required(message="Debe escribir un fecha")
	@Formats .DateTime(pattern="dd/MM/yyyy")  
	public Date fecha;
	
	@ManyToOne
	@JoinColumn(name="expediente_id", referencedColumnName="id", insertable=false, updatable=false)
	public Expediente expediente;
	@Required(message="Requiere un expediente")
	public Long expediente_id;
	
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
	
	@ManyToOne
	@JoinColumn(name="estado_id", referencedColumnName="id", insertable=false, updatable=false)
	public Estado estado;
	@Column(name="estado_id")
	public Long estado_id; 
	
	@ManyToOne
	@JoinColumn(name="organigrama_id", referencedColumnName="id", insertable=false, updatable=false)
	public Organigrama organigrama; 
	@Column(name="organigrama_id")
	@Required(message="Debe seleccionar un departamento/servicio")
	public Long organigrama_id;
	
	public static Finder<Long,Dispo> find = new Finder<Long,Dispo>(Long.class, Dispo.class);
	
	public static Pagination<Dispo> page(String numero,
										 String expediente_id,
										 String ejercicio,
										 String fecha_desde,
										 String fecha_hasta,
										 String btnFiltro0,//ACTIVA
										 String btnFiltro1,//NO ACTIVA
										 String organigrama,
										 String desc
										 ) 
										 {
		Pagination<Dispo> p = new Pagination<Dispo>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("numero");
    	
    	ExpressionList<Dispo> e = find.fetch("expediente").where();
    	
    	if(!numero.isEmpty()) {
    		e.eq("numero", Integer.parseInt(numero));
    	}
    	
    	if(!desc.isEmpty()) {
    		e.ilike("descripcion","%" + desc + "%" );
    	}
    	
    	if(!ejercicio.isEmpty()) {
    		e.eq("expediente.ejercicio_id", Integer.valueOf(ejercicio));
    	}
    	
    	if(!expediente_id.isEmpty()) {
    		e.eq("expediente_id", Integer.valueOf(expediente_id));
    	}
    	
    	if(!fecha_desde.isEmpty()){
    		e.ge("fecha", DateUtils.formatDate(fecha_desde, "dd/MM/yyyy"));
    	}
		
		if(!fecha_hasta.isEmpty()){
    		e.le("fecha", DateUtils.formatDate(fecha_hasta, "dd/MM/yyyy"));
    	}
		
		if(!organigrama.isEmpty()) {
    		e.eq("organigrama_id", Integer.valueOf(organigrama));
    	}
		
		if(!btnFiltro0.isEmpty() || !btnFiltro1.isEmpty()){
			e = e.disjunction();
			if(!btnFiltro0.isEmpty()){
				 e = e.eq("estado_id", Estado.DISPO_ACTIVA);
			}	
			if(!btnFiltro1.isEmpty()){
				e = e.eq("estado_id", Estado.DISPO_DESACTIVA);
			}	
			 
			e = e.endJunction();
		}	
    	
    	
    	p.setExpressionList(e);
    	return p;
	}	
	
	public static void buscarDuplicado(Long expediente_id, Integer numero,Long organigrama_id){
		Expediente e = Expediente.find.byId(expediente_id);
		Dispo dispo = Dispo.find.where()
					  .eq("expediente.ejercicio_id", e.ejercicio_id)
					  .eq("organigrama_id", organigrama_id)
					  .eq("numero", numero).findUnique();
		if(dispo != null)
			throw new ConstraintViolationException (null);
	}
	
	public static void buscarDuplicado(Long expediente_id, Integer numero,Long id,Long organigrama_id){
		Expediente e = Expediente.find.byId(expediente_id);
		Dispo dispo = Dispo.find.where()
					  .eq("expediente.ejercicio_id", e.ejercicio_id)
					  .eq("organigrama_id", organigrama_id)
					  .eq("numero", numero)
					  .ne("id",id).findUnique();
		if(dispo != null)
			throw new ConstraintViolationException(null);
	}
	
}
