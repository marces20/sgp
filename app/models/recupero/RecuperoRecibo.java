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

import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.annotation.Formula;

import models.Estado;
import models.PuntoVenta;
import models.Usuario;
import models.auth.Permiso;
import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.DateUtils;
import utils.pagination.Pagination;

@Entity
@Table(name = "recupero_recibos")
public class RecuperoRecibo extends Model {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="recupero_recibos_id_seq")
	public Long id;

	@Required(message="Debe escribir un numero")
	public String numero;

	@Required(message="Debe escribir una fecha")
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha;

	@ManyToOne
	@JoinColumn(name="create_user_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario create_usuario;
	@Column(name="create_user_id")
	public Long create_usuario_id;


	@Formats.DateTime(pattern="yyyy-MM-dd HH:mm:ss")
	public Date create_date;

	@ManyToOne
	@JoinColumn(name="write_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario write_usuario;
	@Column(name="write_usuario_id")
	public Long write_usuario_id;


	@Formats.DateTime(pattern="yyyy-MM-dd HH:mm:ss")
	public Date write_date;

	@ManyToOne
	@JoinColumn(name="estado_id", referencedColumnName="id", insertable=false, updatable=false)
	public Estado estado;
	@Column(name="estado_id")
	public Long estado_id;

	@ManyToOne
	@JoinColumn(name="puntoventa_id", referencedColumnName="id", insertable=false, updatable=false)
	public PuntoVenta puntoVenta;
	@Required(message="Seleccion punto venta")
	public Integer puntoventa_id;

	@OneToMany()
	public List<RecuperoReciboFactura> recuperoReciboFactura;

	public String getNumeroRecibo(){
		String puntoventa = (puntoventa_id != null)?puntoVenta.numero:"";
		return "X"+puntoventa+"-"+numero;
	}

	@Formula(select = "_c${ta}.total", join = "left outer join (select recupero_recibo_id, round(sum(monto)::numeric,2) as total from recupero_recibo_facturas group by recupero_recibo_id) as _c${ta} on _c${ta}.recupero_recibo_id = ${ta}.id")
	public BigDecimal total;//Base
	public BigDecimal getTotal(){
		if (total == null)
			return new BigDecimal(0);
		return total;
	}


	public static Model.Finder<Long,RecuperoRecibo> find = new Finder<Long,RecuperoRecibo>(Long.class, RecuperoRecibo.class);

	public static Pagination<RecuperoRecibo> page(String numero,
													String expediente_id,
													String fecha_desde,
													String fecha_hasta){

			Pagination<RecuperoRecibo> p = new Pagination<RecuperoRecibo>();
			p.setOrderDefault("DESC");
			p.setSortByDefault("id");

			ExpressionList<RecuperoRecibo> e = find.where();

			if(!numero.isEmpty()) {
				e.eq("numero",  Integer.parseInt(numero));
			}

			if(!fecha_desde.isEmpty()){
				Date fd = DateUtils.formatDate(fecha_desde, "dd/MM/yyyy");
				e.ge("fecha", fd);
			}

			if(!fecha_hasta.isEmpty()){
				Date fh = DateUtils.formatDate(fecha_hasta, "dd/MM/yyyy");
				e.le("fecha", fh);
			}

			/*if(!Permiso.check("verTodoRecupero")){
				if(Usuario.getUsurioSesion().organigrama != null && Usuario.getUsurioSesion().organigrama.deposito != null){
					e.eq("deposito_id", Usuario.getUsurioSesion().organigrama.deposito_id.intValue());
				}else{
					e.isNull("deposito_id");
				}
			}*/

			p.setExpressionList(e);
			return p;
	}


}
