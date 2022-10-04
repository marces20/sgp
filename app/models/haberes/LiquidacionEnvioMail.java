package models.haberes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import models.Usuario;
import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity 
@Table(name = "liquidaciones_envios_mails")
public class LiquidacionEnvioMail extends Model{
	
	private static final long serialVersionUID = 1L;
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="liquidaciones_envios_mails_id_seq")
	public Long id;
	
	@ManyToOne
	@JoinColumn(name="liquidacion_puesto_id", referencedColumnName="id", insertable=false, updatable=false)
	public LiquidacionPuesto liquidacionPuesto; 
	@Column(name="liquidacion_puesto_id")
	public Long liquidacion_puesto_id;
	
	@Required(message="requiere email")
	public String email;
	
	@Required(message="requiere fecha")
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha;	
	
	@ManyToOne
	@JoinColumn(name="usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario usuario; 
	@Column(name="usuario_id")
	public Long usuario_id;
	
	public static Model.Finder<Long,LiquidacionEnvioMail> find = new Model.Finder<Long,LiquidacionEnvioMail>(Long.class, LiquidacionEnvioMail.class);
}
