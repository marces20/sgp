package models;

import java.math.BigDecimal;
import java.util.Date;

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
import utils.formatters.DecimalComa;

@Entity 
@Table(name = "caja_chica_presupuesto_lineas")
public class CajaChicaPresupuestoLinea extends Model{
	
	private static final long serialVersionUID = 1L;
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="caja_chica_presupuesto_lineas_id_seq")
	public Long id; 
	
	@ManyToOne
	@JoinColumn(name="caja_chica_id", referencedColumnName="id", insertable=false, updatable=false)
	public CajaChica caja; 
	@Required(message="Requiere caja_chica_id")
	public Integer caja_chica_id;
	
	@ManyToOne
	@JoinColumn(name="cuenta_analitica_id", referencedColumnName="id", insertable=false, updatable=false)
	public CuentaAnalitica cuentaAnalitica; 
	@Required(message="Requiere cuenta")
	public Integer cuenta_analitica_id;
	
	@DecimalComa(value="")
	@Required(message="El monto límite es obligatorio")
	public BigDecimal monto;
	
	public Date create_date; 
	
	@ManyToOne
	@JoinColumn(name="create_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario create_usuario; 
	public Long create_usuario_id;
	
	public boolean ajuste;
	
	public static Finder<Long,CajaChicaPresupuestoLinea> find = new Finder<Long,CajaChicaPresupuestoLinea>(Long.class, CajaChicaPresupuestoLinea.class);

	
}
