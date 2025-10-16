package models.haberes;

import java.util.Date;
import java.util.List;

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
import play.db.ebean.Model;
import utils.pagination.Pagination;

@Entity
@Table(name = "liquidacion_conceptos")
public class LiquidacionConcepto extends Model{

	private static final long serialVersionUID = 1L;
	public static final long SEGURO_DE_VIDA = 6;
	public static final long SEGURO_DE_VIDA_AJUSTE = 205;
	public static final long SEGURO_DE_SEPELIO = 7;
	public static final long SEGURO_DE_SEPELIO_AJUSTE = 206;
	public static final long JUBILACION = 5;
	public static final long DIFERENCIAL_VACACIONES = 810;
	public static final long AJUSTE_DIFERENCIAL_VACACIONES = 826;
	public static final long OB = 4;

	public static final long GUARDIA_ACTIVA_DÍA_HÁBIL = 672;
	public static final long GUARDIA_ACTIVA_DÍA_INHÁBIL = 673;
	public static final long GUARDIA_CRITICA_DÍA_HÁBIL = 674;
	public static final long GUARDIA_CRITICA_DÍA_INHÁBIL = 675;
	public static final long GUARDIA_ACTIVA_NO_CRITICA_FESTIVA = 807;
	public static final long GUARDIA_ACTIVA_CRITICA_FESTIVA = 808;


	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="liquidacion_conceptos_id_seq")
	public Long id;

	@Required(message="Debe escribir un código")
	public Integer codigo;

	@Required(message="Debe escribir una denominación")
	public String denominacion;

	public String abreviatura;

	public String descripcion;

	public String dispo;

	public Boolean deduce_ganancias = true;

	public Boolean reporte_ganancias = false;

	public Boolean control_guardia = false;

	@ManyToOne
	@JoinColumn(name="liquidacion_base_calculo_id", referencedColumnName="id", insertable=false, updatable=false)
	public LiquidacionBaseCalculo liquidacionBaseCalculo;
	@Required(message="Requiere Base Calculo")
	public Integer liquidacion_base_calculo_id;

	@ManyToOne
	@JoinColumn(name="liquidacion_concepto_tipo_id", referencedColumnName="id", insertable=false, updatable=false)
	public LiquidacionConceptoTipo liquidacionConceptoTipo;
	@Required(message="Requiere Tipo de Concepto")
	public Integer liquidacion_concepto_tipo_id;

	@ManyToOne
	@JoinColumn(name="liquidacion_concepto_clasificacion_id", referencedColumnName="id", insertable=false, updatable=false)
	public LiquidacionConceptoClasificacion liquidacionConceptoClasificacion;
	@Required(message="Requiere Clasificacion de Concepto")
	public Integer liquidacion_concepto_clasificacion_id;

	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha_baja;

	//public boolean fijo;

	public static Model.Finder<Long,LiquidacionConcepto> find = new Model.Finder<Long,LiquidacionConcepto>(Long.class, LiquidacionConcepto.class);

	public static Pagination<LiquidacionConcepto> page(String codigo,
													   String denominacion){

		Pagination<LiquidacionConcepto> p = new Pagination<LiquidacionConcepto>();
    	p.setOrderDefault("ASC");
    	p.setSortByDefault("codigo,denominacion");

    	ExpressionList<LiquidacionConcepto> e = find.where();

    	if(!codigo.isEmpty()){
    		e.eq("codigo",Integer.parseInt(codigo));
    	}

    	if(!denominacion.isEmpty()){
    		e.ilike("denominacion", "%" + denominacion + "%");
    	}

    	p.setExpressionList(e);
    	return p;
	}

	public List<LiquidacionConcepto> getDataSuggest(String input,Integer limit){
		List<LiquidacionConcepto> l = find.where()
				.ilike("denominacion", "%"+input+"%")
				.isNull("fecha_baja")
				.setMaxRows(limit).orderBy("denominacion")
			    .findList();

		return l;
	}
}

