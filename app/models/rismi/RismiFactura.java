package models.rismi;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.avaje.ebean.ExpressionList;

import models.recupero.RecuperoFactura;
import play.data.format.Formats;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
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

	public static Model.Finder<Long,RismiFactura> find = new Finder<Long,RismiFactura>(Long.class, RismiFactura.class);

	public static Pagination<RismiFactura> page(String nombre){

		Pagination<RismiFactura> p = new Pagination<RismiFactura>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");

    	ExpressionList<RismiFactura> e = find
				.where();

    	if(p.parcheCountAllFormula)
    		p.setTotalRowCount(e.findList().size());



    	p.setExpressionList(e);
    	return p;
	}

}
