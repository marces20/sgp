package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity 
@Table(name = "ordenes_solicitudes")
public class OrdenesSolicitudes extends Model{
	
	private static final long serialVersionUID = 1L;
	@Id  														 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ordenes_solicitudes_id_seq")
	public Long id;
	
	@ManyToOne
	@JoinColumn(name="orden_id", referencedColumnName="id", insertable=false, updatable=false)
	public Orden orden;
	@Required(message="Requiere una orden")
	public Long orden_id;
	
	@ManyToOne
	@JoinColumn(name="solicitud_id", referencedColumnName="id", insertable=false, updatable=false)
	public Solicitud solicitud;
	@Required(message="Requiere una solicitud")
	public Long solicitud_id;
	
	public static Model.Finder<Long,OrdenesSolicitudes> find = new Finder<Long,OrdenesSolicitudes>(Long.class, OrdenesSolicitudes.class);
}
