package models.recupero;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.annotation.Formula;

import models.Cliente;
import models.Estado;
import models.Expediente;
import models.Orden;
import models.Usuario;
import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.NumberUtils;
import utils.formatters.DecimalComa;
import utils.pagination.Pagination;

@Entity
@Table(name = "recupero_certificado_deudas")
public class RecuperoCertificadoDeuda extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="recupero_certificado_deudas_id_seq")
	public Long id;

	@ManyToOne
	@JoinColumn(name="cliente_id", referencedColumnName="id", insertable=false, updatable=false)
	public Cliente cliente;
	@Required(message="Debe tener un cliente asociado")
	public Long cliente_id;

	@ManyToOne
	@JoinColumn(name="expediente_id", referencedColumnName="id", insertable=false, updatable=false)
	public Expediente expediente;
	@Required(message="Seleccion Expediente")
	public Integer expediente_id;

	@DecimalComa(value="")
	@Required(message="Requiere monto")
	public BigDecimal monto;

	@Required(message="Debe escribir un numero")
	public String numero;

	@Required(message="Debe escribir una fecha")
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha;

	@ManyToOne
	@JoinColumn(name="create_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario create_usuario;
	@Column(name="create_usuario_id")
	public Long create_usuario_id;

	public Date create_date;

	@ManyToOne
	@JoinColumn(name="estado_id", referencedColumnName="id", insertable=false, updatable=false)
	public Estado estado;
	public Long estado_id;

	public Date write_date;

	@ManyToOne
	@JoinColumn(name="write_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario write_usuario;
	@Column(name="write_usuario_id")
	public Long write_usuario_id;

	@Transient
	public String nombreCompleto;

	public String getNombreCompleto(){

		if(numero != null && expediente != null) {
			return expediente.ejercicio != null ? numero+ "/" + expediente.ejercicio.nombre :numero;
		}else {
			return "";
		}


	}

	@Formula(select = "_c${ta}.total", join = "left outer join (select recupero_certificado_deuda_id, round(sum(deuda)::numeric,2) as total from recupero_certificado_deuda_lineas group by recupero_certificado_deuda_id) as _c${ta} on _c${ta}.recupero_certificado_deuda_id = ${ta}.id")
	public BigDecimal total;//Base
	public BigDecimal getTotal(){
		if (total == null)
			return new BigDecimal(0);
		return total;
	}

	@OneToMany()
	public List<RecuperoCerficadoDeudaLinea> recuperoCerficadoDeudaLinea;

	public static Model.Finder<Long,RecuperoCertificadoDeuda> find = new Finder<Long,RecuperoCertificadoDeuda>(Long.class, RecuperoCertificadoDeuda.class);

	public List<RecuperoCertificadoDeuda> getDataSuggest(String input,Integer limit){
		List<RecuperoCertificadoDeuda> l = find.where()
				.ilike("numero", "%"+input+"%")
				.setMaxRows(limit).orderBy("id desc")
			    .findList();
		return l;
	}

	public static Pagination<RecuperoCertificadoDeuda> page(String numero,
															String expediente_id,
															String fecha,
															String filtroBorrador,
															String filtroAprobada){

		Pagination<RecuperoCertificadoDeuda> p = new Pagination<RecuperoCertificadoDeuda>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");

    	ExpressionList<RecuperoCertificadoDeuda> e = find
				.fetch("expediente")
				.where();

    	if(!numero.isEmpty()) {
    		e.ilike("numero", "%"+numero+"%");
    	}

    	if(  !filtroBorrador.isEmpty() || !filtroAprobada.isEmpty() ) {
    		e = e.disjunction();


	   		if(!filtroBorrador.isEmpty()){
	   			 e = e.eq("estado_id", Estado.RECUPERO_CERTIFICADO_DEUDA_BORRADOR);
	   		}

	   		if(!filtroAprobada.isEmpty()){
	   			 e = e.eq("estado_id", Estado.RECUPERO_CERTIFICADO_DEUDA_BORRADOR);
	   		}



	   		e = e.endJunction();
    		p.parcheCountAllFormula = true;
    	}

    	p.setExpressionList(e);
    	return p;
	}


}
