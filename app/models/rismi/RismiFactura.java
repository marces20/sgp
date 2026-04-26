package models.rismi;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.annotation.Formula;

import models.Organigrama;
import models.recupero.RecuperoFactura;
import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.DateUtils;
import utils.pagination.Pagination;

@Entity
@Table(name = "rismi_facturas")
public class RismiFactura extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="rismi_facturas_id_seq")
	public Long id;

	public String nombre_paciente;
	public String dominio;
	public String episodio_id;
	public String paciente_id;

	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha_ingreso;

	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha_egreso;

	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date create_date;

	public BigDecimal total_total;

	@ManyToOne
	@JoinColumn(name="organigrama_id", referencedColumnName="id", insertable=false, updatable=false)
	public Organigrama organigrama;
	@Column(name="organigrama_id")
	@Required(message="Debe seleccionar un departamento/servicio")
	public Long organigrama_id;

	@Formula(select = "_c${ta}.total", join = "left outer join (select rismi_factura_id, round(sum(monto)::numeric,2) as total from rismi_factura_detalle group by rismi_factura_id) as _c${ta} on _c${ta}.rismi_factura_id = ${ta}.id")
	public BigDecimal total;//total
	public BigDecimal getTotal(){
		if (total == null)
			return new BigDecimal(0);
		return total;
	}

	public static Model.Finder<Long,RismiFactura> find = new Finder<Long,RismiFactura>(Long.class, RismiFactura.class);

	public static Pagination<RismiFactura> page(String fecha_desde,String fecha_hasta,String organigrama_id){

		Pagination<RismiFactura> p = new Pagination<RismiFactura>();
    	p.setOrderDefault("ASC");
    	p.setSortByDefault("fecha_egreso,id");

    	ExpressionList<RismiFactura> e = find
				.where();

    	if(!organigrama_id.isEmpty()){
    		e.eq("organigrama_id", Integer.parseInt(organigrama_id));
    	}

    	if(!fecha_desde.isEmpty()){
    		Date fod = DateUtils.formatDate(fecha_desde, "dd/MM/yyyy");
    		e.ge("fecha_egreso", fod);
    	}

		if(!fecha_hasta.isEmpty()){
    		Date foh = DateUtils.formatDate(fecha_hasta, "dd/MM/yyyy");
    		e.le("fecha_egreso", foh);
    	}

    	if(p.parcheCountAllFormula)
    		p.setTotalRowCount(e.findList().size());



    	p.setExpressionList(e);
    	return p;
	}

}
