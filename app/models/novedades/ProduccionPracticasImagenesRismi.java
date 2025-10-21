package models.novedades;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.avaje.ebean.ExpressionList;

import models.Agente;
import models.Periodo;
import models.haberes.PuestoLaboral;
import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.pagination.Pagination;

@Entity
@Table(name = "produccion_practicas_imagenes_rismi")
public class ProduccionPracticasImagenesRismi extends Model{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="produccion_practicas_imagenes_rismi_id_seq")
	public Long id;

	@Required(message="Debe escribir un documento")
	public String agente_dni;

	@ManyToOne
	@JoinColumn(name="agente_id", referencedColumnName="id", insertable=false, updatable=false)
	public Agente agente;
	public Long agente_id;

	@ManyToOne
	@JoinColumn(name = "puesto_laboral_id", referencedColumnName = "id", insertable = false, updatable = false)
	public PuestoLaboral puestoLaboral;
	public Long puesto_laboral_id;

	@ManyToOne
	@JoinColumn(name = "periodo_id", referencedColumnName = "id", insertable = false, updatable = false)
	public Periodo periodo;
	@Required(message = "Requiere un periodo")
	public Integer periodo_id;

	@Formats.DateTime(pattern = "dd/MM/yyyy")
	public Date fecha_desde;

	@Formats.DateTime(pattern = "dd/MM/yyyy")
	public Date fecha_hasta;

	public Date create_date;

	public Long practica_rismi_id;

	public Long practica_rismi_minutos;

	public BigDecimal practica_rismi_q;

	public static Model.Finder<Long,ProduccionPracticasImagenesRismi> find = new Finder<Long,ProduccionPracticasImagenesRismi>(Long.class, ProduccionPracticasImagenesRismi.class);

	public static Pagination<ProduccionPracticasImagenesRismi> page(){
		Pagination<ProduccionPracticasImagenesRismi> p = new Pagination<ProduccionPracticasImagenesRismi>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	ExpressionList<ProduccionPracticasImagenesRismi> e = find.where();


    	p.setExpressionList(e);
    	return p;
	}
}
