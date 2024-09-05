package models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Expr;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.SqlRow;
import com.avaje.ebean.SqlUpdate;
import com.avaje.ebean.annotation.Formula;

import models.auth.Permiso;
import play.Logger;
import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.DB;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.DateUtils;
import utils.formatters.DecimalComa;
import utils.pagination.Pagination;

@Entity
@Table(name = "balances")
public class Balance extends Model {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="balances_id_seq")
	public Long id;

	public Integer asiento;

	public String tipo;

	public String referencia;

	@ManyToOne
	@JoinColumn(name="cuenta_propia_id", referencedColumnName="id", insertable=false, updatable=false)
	public CuentaPropia cuentaPropia;
	@Required(message="Requiere cuenta propia")
	public Integer cuenta_propia_id;

	@ManyToOne
	@JoinColumn(name="cuenta_id", referencedColumnName="id", insertable=false, updatable=false)
	public Cuenta cuenta;
	@Required(message="Requiere cuenta")
	public Integer cuenta_id;

	@Required(message="Requiere Fecha")
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha;

	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha_debito;

	@DecimalComa(value="")
	@Required(message="Requiere haber")
	public BigDecimal haber;

	@DecimalComa(value="")
	@Required(message="Requiere debe")
	public BigDecimal debe;

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

	@Formula(select = "_b${ta}.cantidadop", join = "left outer join (select count(*) as cantidadop,balance_id from balance_ordenespagos group by balance_id) as _b${ta} on _b${ta}.balance_id = ${ta}.id")
	public BigDecimal cantidadop;

	@Formula(select = "_e${ta}.cantidadex", join = "left outer join (select count(*) as cantidadex,balance_id from balance_expedientes group by balance_id) as _e${ta} on _e${ta}.balance_id = ${ta}.id")
	public BigDecimal cantidadex;

	@ManyToOne
	@JoinColumn(name="expediente_id", referencedColumnName="id", insertable=false, updatable=false)
	public Expediente expediente;
	public Integer expediente_id;

	@ManyToOne
	@JoinColumn(name="orden_pago_id", referencedColumnName="id", insertable=false, updatable=false)
	public OrdenPago ordenPago;
	public Long orden_pago_id;

	public Date write_date;

	@ManyToOne
	@JoinColumn(name="write_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario write_usuario;
	@Column(name="write_usuario_id")
	public Long write_usuario_id;

	@OneToMany
	@JoinColumn(name="balance_id", referencedColumnName="id", insertable=false, updatable=false)
	public List<BalanceOrdenPago> balanceOrdenPago;

	@OneToMany
	@JoinColumn(name="balance_id", referencedColumnName="id", insertable=false, updatable=false)
	public List<BalanceExpediente> balanceExpediente;

	@ManyToOne
	@JoinColumn(name="orden_id", referencedColumnName="id", insertable=false, updatable=false)
	public Orden orden;
	public Integer orden_id;

	public Boolean marca = false;

	@ManyToOne
	@JoinColumn(name="factura_id", referencedColumnName="id", insertable=false, updatable=false)
	public Factura factura;
	public Integer factura_id;

	@ManyToOne
	@JoinColumn(name="pago_id", referencedColumnName="id", insertable=false, updatable=false)
	public Pago pago;
	public Integer pago_id;

	@ManyToOne
	@JoinColumn(name="puntoventa_id", referencedColumnName="id", insertable=false, updatable=false)
	public PuntoVenta puntoVenta;
	public Integer puntoventa_id;

	public static Finder<Long,Balance> find = new Finder<Long,Balance>(Long.class, Balance.class);

	public static Pagination<Balance> page(String cuentaPropiaId,
										   String fecha_desde,
										   String fecha_hasta,
										   String btnFiltro0,//en curso
										   String btnFiltro1,//pagado
										   String btnFiltro2,//conciliado
										   String btnFiltro3,//cancelado
										   String ejercicio,
										   String cuenta_id,
										   String tipo,
										   String expediente_id,
										   String ordenPagoId,
										   String marca,
										   String deposito_id) {

		Pagination<Balance> p = new Pagination<Balance>();
		p.setOrderDefault("ASC");
		p.setSortByDefault("fecha ,orden_pago_id,haber");
		//p.setSortByDefault("id");
		p.setPageSize(500);

		ExpressionList<Balance> f = find
		.fetch("estado", "id,nombre")
		.fetch("cuentaPropia", "nombre")
		.fetch("cuenta", "nombre,code")
		.fetch("ordenPago", "numero")
		.fetch("ordenPago.ejercicio", "nombre")
		.fetch("expediente", "nombre, id")
		.fetch("expediente.ejercicio", "nombre")
		.fetch("expediente.parent.ejercicio", "nombre")
		.fetch("orden.deposito","nombre")
		.where();

		if(!ejercicio.equals("")){
			Ejercicio ej = Ejercicio.find.byId(new Long(ejercicio));
			f = f.disjunction();
			f = f.between("fecha", ej.date_start, ej.date_stop);
			//f = f.between("fecha_debito", ej.date_start, ej.date_stop);
			//f = f.between("fecha_emision", ej.date_start, ej.date_stop);
			//f = f.between("fecha_cancelado", ej.date_start, ej.date_stop);
			f = f.endJunction();
		}else{
			Ejercicio ej = Ejercicio.find.byId(new Long(6));
			f = f.disjunction();
			f = f.between("fecha", ej.date_start, ej.date_stop);
			//f = f.between("fecha_debito", ej.date_start, ej.date_stop);
			//f = f.between("fecha_emision", ej.date_start, ej.date_stop);
			//f = f.between("fecha_cancelado", ej.date_start, ej.date_stop);
			f = f.endJunction();
		}

		if(!cuenta_id.equals("")){
			f.eq("cuenta_id", Integer.parseInt(cuenta_id));
		}

		if(!deposito_id.equals("")){
			f.eq("orden.deposito_id", Integer.parseInt(deposito_id));
		}

		if(!cuentaPropiaId.equals("")){
			f.eq("cuenta_propia_id", Integer.parseInt(cuentaPropiaId));
		}

		if(!fecha_desde.isEmpty()){
    		Date ffd = DateUtils.formatDate(fecha_desde, "dd/MM/yyyy");
    		f.ge("fecha", ffd);
    	}
		if(!fecha_hasta.isEmpty()){
    		Date ffh = DateUtils.formatDate(fecha_hasta, "dd/MM/yyyy");
    		f.le("fecha", ffh);
    	}

		if(!tipo.isEmpty()){
    		if(tipo.compareTo("pagos") == 0) {
    			f.eq("tipo","pagos");
    		}
    		if(tipo.compareTo("facturas") == 0) {
    			f.eq("tipo","facturas");
    		}
    		if(tipo.compareTo("factura_recupero") == 0) {
    			f.eq("tipo","factura_recupero");
    		}
    		if(tipo.compareTo("pago_recupero") == 0) {
    			f.eq("tipo","pago_recupero");
    		}
    		if(tipo.compareTo("nt_recupero") == 0) {
    			f.eq("tipo","nt_recupero");
    		}
    	}

		if(!marca.isEmpty()){
    		if(marca.compareToIgnoreCase("SI") == 0){
    			f.eq("marca", true);
    		}else{

    			f = f.disjunction();
        		f = f.eq("marca", false);
        		f = f.isNull("marca");
        		f = f.endJunction();
    		}
    	}

		if(!expediente_id.equals("")){
    		f = f.disjunction();
    		f = f.eq("expediente_id", Integer.parseInt(expediente_id));
    		f = f.eq("balanceExpediente.expediente_id", Integer.parseInt(expediente_id));
    		f = f.endJunction();
		}

		if(!ordenPagoId.equals("")){
    		f = f.disjunction();
    		f = f.eq("orden_pago_id", Integer.parseInt(ordenPagoId));
    		f = f.eq("balanceOrdenPago.orden_pago_id", Integer.parseInt(ordenPagoId));
    		f = f.endJunction();
		}

		/*if(!fecha_desde.isEmpty() && !fecha_hasta.isEmpty()){
			Date ffd = DateUtils.formatDate(fecha_desde, "dd/MM/yyyy");
			Date ffh = DateUtils.formatDate(fecha_hasta, "dd/MM/yyyy");

			f = f.disjunction();
			f = f.conjunction();
			f = f.add(Expr.between("fecha_emision",ffd, ffh)).add(Expr.isNull("fecha_cancelado"));
			f = f.endJunction();
			f = f.conjunction();
			f = f.add(Expr.between("fecha_cancelado",ffd, ffh)).add(Expr.isNotNull("fecha_cancelado"));
			f = f.endJunction();
			f = f.endJunction();

		}*/

		if(!btnFiltro0.isEmpty() || !btnFiltro1.isEmpty()){
			f = f.disjunction();

			if(!btnFiltro0.isEmpty()){
				f = f.eq("estado_id", Estado.BALANCE_BORRADOR);
			}
			if(!btnFiltro1.isEmpty()){
				f = f.eq("estado_id", Estado.BALANCE_CONTROLADO);
			}


			f = f.endJunction();
		}



		p.setExpressionList(f);
		Logger.debug("222222222222222222 "+f.toString() );
		return p;
	}

	public static Map<Long,List<Balance>> getBalance(){
		String sql = "WITH RECURSIVE lista AS  ( SELECT t.id, parent_id, COALESCE(b.debe,0) debe, COALESCE(b.haber,0) haber FROM cuentas t left join balances b on b.cuenta_id = t.id "
				+ " UNION ALL "
				+ " SELECT cuentas.id, cuentas.parent_id, lista.debe, lista.haber FROM lista JOIN cuentas ON lista.parent_id = cuentas.id)"
				+ " SELECT l.parent_id, c.id, c.nombre, SUM(debe) debe, SUM(haber) haber"
				+ " FROM lista l "
			    + " INNER JOIN cuentas c ON c.id = l.id "
			    + " GROUP BY l.parent_id, c.id, c.nombre "
			    + " ORDER BY parent_id, id ";


		List<SqlRow> rows = Ebean.createSqlQuery(sql).findList();
		Map<Long,List<Balance>> lista = new HashMap<>();


		for (SqlRow r : rows) {
			Balance b = new Balance();
			b.id = r.getLong("parent_id");
			b.debe = r.getBigDecimal("debe");
			System.out.println("+++++++++ " + b.debe);
			b.haber = r.getBigDecimal("haber");
			Cuenta c = new Cuenta();
			c.id = r.getLong("id");
			c.nombre = r.getString("nombre");
			b.cuenta = c;



			if(lista.containsKey(b.id)) {
				lista.get(b.id).add(b);
			} else {
				List<Balance> listaBalance = new ArrayList<Balance>();
				listaBalance.add(b);
				lista.put(r.getLong("parent_id"), listaBalance);
			}

		}

		return lista;
	}

	public static Integer modificarEstadoMasivo(Integer idEstado, List<Integer> idsSeleccionados){

		SqlUpdate update = Ebean.createSqlUpdate("UPDATE balances " +
				"SET estado_id = :idEstado, write_date = :write_date,write_usuario_id = :write_usuario_id " +
				"WHERE id IN (:ids)");
		update.setParameter("idEstado", idEstado);
		update.setParameter("write_date",new Date());
		update.setParameter("write_usuario_id",new Long(Usuario.getUsuarioSesion()));
		update.setParameter("ids", idsSeleccionados);

		return update.execute();
	}

	public static Integer modificarCuentaMasivo(Integer idCuenta, List<Integer> idsSeleccionados){

		SqlUpdate update = Ebean.createSqlUpdate("UPDATE balances " +
				"SET cuenta_id = :idCuenta, write_date = :write_date,write_usuario_id = :write_usuario_id " +
				"WHERE id IN (:ids)");
		update.setParameter("idCuenta", idCuenta);
		update.setParameter("write_date",new Date());
		update.setParameter("write_usuario_id",new Long(Usuario.getUsuarioSesion()));
		update.setParameter("ids", idsSeleccionados);

		return update.execute();
	}


}
