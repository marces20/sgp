package models.informes;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import models.ActaRecepcion;
import models.Deposito;
import models.Expediente;
import models.Orden;
import models.OrdenProvision;
import models.Periodo;
import models.Proveedor;
import models.TipoCuenta;
import play.Logger;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import utils.pagination.Pagination;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Expr;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.SqlQuery;
import com.avaje.ebean.SqlRow;

@Entity 
@Table(name = "totales_por_orden")
public class InformeTotalesPorOrden extends Model{
	private static final long serialVersionUID = 1L;
	
	@Id
	public Integer orden_id;
	

	@OneToOne
	@JoinColumn(name="orden_id", referencedColumnName="orden_compra_id")
	public OrdenProvision ordenProvision;
	

	
	public BigDecimal totalOrden;
	public BigDecimal totalOrdenDivisa;
	public BigDecimal totalPago;
	public BigDecimal totalPagoDivisa;
	public BigDecimal totalAutorizado;
	public BigDecimal totalAutorizadoDivisa;
	public BigDecimal totalRecepcionado;
	
	public static Model.Finder<Long,InformeTotalesPorOrden> find = new Finder<Long,InformeTotalesPorOrden>(Long.class, InformeTotalesPorOrden.class);
	
	public static Pagination<InformeTotalesPorOrden> page(String orden) {    	
    	Pagination<InformeTotalesPorOrden> p = new Pagination<InformeTotalesPorOrden>();
    	p.setOrderDefault("ASC");
    	p.setSortByDefault("ordenProvision, numero_orden_provision");
    	
    	ExpressionList<InformeTotalesPorOrden> e = find
    			.fetch("ordenProvision", "orden_compra_id,numero")
    			.where();
    	
    	p.setExpressionList(e);
    	return p;
    }	
}
