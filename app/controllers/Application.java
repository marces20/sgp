package controllers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.mail.EmailException;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Expr;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.SqlQuery;
import com.avaje.ebean.SqlRow;

import fr.opensagres.xdocreport.core.XDocReportException;
import migracion.ActualizarBalance;
import migracion.ActualizarBalancePagos;
import migracion.ActualizarProductosRepetidos;
import models.Estado;
import models.Orden;
import models.OrdenProvision;
import models.RemitoBaul;
import models.Usuario;
import models.haberes.LiquidacionMes;
import models.haberes.LiquidacionPuesto;
import models.informes.HistorialDeudaProveedores;
import models.informes.InformeDeudaProveedoresMaterializada;
import models.informes.InformeTotalesPorOrden;
import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.NumeroALetra;
import views.html.index2;

@Security.Authenticated(Secured.class)
public class Application extends Controller {

	public static Result index() throws EmailException, IOException, XDocReportException  {


		//ActualizarProductosIps a = new ActualizarProductosIps();
		//a.actualizar();





		//AfipController a = new AfipController();
		//RecuperoNotaCredito rc  = RecuperoNotaCredito.find.byId(new Long(5079));
		//a.getUltimoComprobanteNew( new Integer(rc.puntoVenta.numero),TipoComprobante.NOTA_CREDITO);

		//AfipController a = new AfipController();
		//a.getAuth();

		//a.crearComprobantesAutomaticos();
		/*GregorianCalendar exptime = new GregorianCalendar();
		Date ex = new Date(GenTime.getTime()+TicketTime);
		Cache.set("exptime", ex);*/
		 //RecuperoRecibo.actualizarNCND();


		//LiquidacionMes.preliquidarEspera();
		//HistorialDeudaProveedores.insertHistorialDeuda();
		//LiquidacionPuesto.envioMailsReciboAutomatico();

		//AgentesEmailController.envioMailsPorLiquidacion();

		//ActualizarProductosRepetidos.actualizar();
		//ActualizarBalancePagos.xxx();
		//ActualizarBalance.facturas();
		//ActualizarBalance.facturaRecupero();
		//ActualizarBalance.pagoRecupero();
		//ActualizarBalance.notaCreditoRecupero();
		//ActualizarBalance.notaDebitoRecupero();
		//ActualizarBalance.arregloFacturas();
		//LiquidacionPuesto.envioMailsReciboAutomatico();

		/*Long timeDelayFromAppStartToLogFirstLogInMs = null;
		 Calendar now = Calendar.getInstance();
		 now.add(Calendar.DATE, 0);
	    now.set(Calendar.HOUR,10);
	    now.set(Calendar.AM_PM,Calendar.PM);
	    now.set(Calendar.MINUTE,00);
	    now.set(Calendar.SECOND,00);
	    now.set(Calendar.MILLISECOND,00);

	    timeDelayFromAppStartToLogFirstLogInMs = now.getTime().getTime() - Calendar.getInstance().getTime().getTime();
	    Logger.debug("timeDelayFromAppStartToLogFirstLogInMs: "+timeDelayFromAppStartToLogFirstLogInMs);*/

	    // DeudasInformesMails di = new DeudasInformesMails();
	    //di.envioMailsPagadoNoEntregado();
	    //ActualizarFechaPagoFactura ana = new ActualizarFechaPagoFactura();
	    //ana.xxx();

	    //ActualizarBalancePagos a = new ActualizarBalancePagos();
	    //a.xxx();

		//nohup sudo ../play stop
	    //nohup sudo ../play -Dhttp.port=9001 start

	    //new DeudasInformesMails().envioMailsDeudasRA();
	    //new DeudasInformesMails().envioMailsDeudasDestacados();
	    //new DeudasInformesMails().envioMailsDeudasOtros();
		//ActualizarBalance.xxx();

	    //MigrarLiquidaciones.migrar(new Long(707));

	   /* List<BalanceCuentaPropia> bc = BalanceCuentaPropia.find.findList();

	    for(BalanceCuentaPropia bx : bc) {

	    	List<BalanceCuentaPropiaExpediente> bpe = BalanceCuentaPropiaExpediente.find.where().eq("balance_cuenta_propia_id", bx.id).findList();

	    	if(bpe.size() == 1) {
	    		bx.expediente_id = bpe.get(0).expediente_id.intValue();
	    		bx.save();
	    	}

	    	List<BalanceCuentaPropiaOrdenPago> bpo = BalanceCuentaPropiaOrdenPago.find.where().eq("balance_cuenta_propia_id", bx.id).findList();

	    	if(bpo.size() == 1) {
	    		bx.orden_pago_id = bpo.get(0).orden_pago_id;
	    		bx.save();
	    	}


	    }*/


    	//ProductosRismiSgp c = new ProductosRismiSgp();
    	//c.xxx();

    	//ActualizarProductosRepetidos ap = new ActualizarProductosRepetidos();
		//ap.actualizar();


    	//RecuperoFacturasMigracion rfm = new RecuperoFacturasMigracion();
    	//rfm.migrar();

    	//ActualizarProductosIps api = new ActualizarProductosIps();
		//api.actualizar();

    	//ActualizarAutorizados aa = new ActualizarAutorizados();
    	//ActualizarAutorizadosActas aa = new ActualizarAutorizadosActas();
    	//aa.xxx();



    	/*

select e.nombre,e.ejercicio_id
from certificaciones c
inner join expedientes e on c.expediente_id = e.id
where orden_id not in (select id from ordenes ox where c.orden_id = ox.id and ox.expediente_id = c.expediente_id)
group by e.nombre,e.ejercicio_id
order by e.nombre,e.ejercicio_id

    	update controles_presupuestarios set cuenta_analitica_padre_id = 50 ,cuenta_analitica_padre_id = 56 where expediente_id in(12180,12338,12527);
		ro



		update factura_lineas set cuenta_analitica_id = 56 where factura_id in(select id from facturas where expediente_id in(12180,12338,12527));

		update pagos_lineas set cuenta_analitica_id = 56 where pago_id in(select id from pagos where expediente_id in(12180,12338,12527));

    	*/
    	//RecuperoFacturasMigracion rm = new RecuperoFacturasMigracion();
    	//rm.migrar();
    	/*try{
	    	  HtmlEmail email = new HtmlEmail();
	    	  email.setHostName("smtp.gmail.com");
	    	  email.setSmtpPort(25);
	    	  email.setAuthenticator(new DefaultAuthenticator("sistema-administracion-parque-salud@parquesaludmnes.org.ar", "121212sistema"));
	    	  email.setSSLOnConnect(true);
	    	  email.setFrom("sistema-administracion-parque-salud@parquesaludmnes.org.ar");
	    	  email.setSubject("TestMail");
	    	  email.setMsg("This is a test mail ... :-)");
	    	  email.addTo("marces2000@gmail.com");
	    	  email.send();
    	}catch(Exception c){
    		Logger.debug("xxxxxxxxxx "+c);
    	}*/

    	/*
    	 * PARA CONTROLAR PRESUPUESTO SIRVE
    	  SELECT p.id, (round(sum(pl.monto),2)-xx.haber) as d
			from pagos p
			INNER JOIN pagos_lineas pl on p.id = pl.pago_id
			inner join 	(select pago_id,sum(haber) haber from controles_presupuestarios group by pago_id) as xx ON xx.pago_id = p.id
			--where expediente_id = 10679
			group by p.id,xx.haber order by d desc


    	 */

    	/*String sql = " SELECT SUM(ROUND(COALESCE(total_deuda,0),2)) td,proveedor_id,nombre_proveedor nombre "+
    				 " FROM informe_estadistico_deuda_proveedores "+
    				 " GROUP BY proveedor_id,nombre_proveedor " +
    			     " ORDER BY td DESC LIMIT 20 ";

		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
		List<SqlRow>  ll = sqlQuery.findList();

		String sql1 = " SELECT SUM(ROUND(COALESCE(total_deuda,0),2)) td,rubro_id,rubro nombre "+
				 " FROM informe_estadistico_deuda_proveedores "+
				 " GROUP BY rubro_id,rubro " +
			     " ORDER BY td DESC LIMIT 20 ";

		SqlQuery sqlQuery1 = Ebean.createSqlQuery(sql1);
		List<SqlRow>  lr = sqlQuery1.findList();

		String sql2 = " SELECT SUM(ROUND(COALESCE(total_deuda,0),2)) td,ol.departamento_id,d.nombre "+
				 " FROM informe_estadistico_deuda_proveedores i " +
				 " inner join orden_lineas ol on ol.orden_id = i.orden_id " +
				 " inner join departamentos d on d.id = ol.departamento_id "+
				 " GROUP BY ol.departamento_id,d.nombre " +
			     " ORDER BY td DESC LIMIT 20 ";

		SqlQuery sqlQuery2 = Ebean.createSqlQuery(sql2);
		List<SqlRow>  ls = sqlQuery2.findList();


	--profe

update pagos set orden_pago_id =16119 where tipo_cuenta_id = 2 and expediente_id = 16654 and fecha_pago BETWEEN '2018-07-01' AND '2018-07-31';

update facturas set fecha_orden_pago ='2018-07-31', orden_pago_id = 16119
where id in (select factura_id from pagos where tipo_cuenta_id = 2 and expediente_id = 16654 and fecha_pago BETWEEN '2018-07-01' AND '2018-07-31');

INSERT INTO balance_cuentas_propia_ordenespagos (balance_cuenta_propia_id,orden_pago_id )
select id,16119 from balance_cuentas_propias
where id in(select balance_cuenta_propia_id from balance_cuentas_propia_pagos
where pago_id in(select id from pagos where tipo_cuenta_id = 2 and expediente_id = 16654 and fecha_pago BETWEEN '2018-07-01' AND '2018-07-31'));

--oper
update pagos set orden_pago_id =16120 where tipo_cuenta_id = 1 and expediente_id = 16656 and fecha_pago BETWEEN '2018-07-01' AND '2018-07-31';

update facturas set fecha_orden_pago ='2018-07-31', orden_pago_id = 16120
where id in (select factura_id from pagos where tipo_cuenta_id = 1 and expediente_id = 16656 and fecha_pago BETWEEN '2018-07-01' AND '2018-07-31');

INSERT INTO balance_cuentas_propia_ordenespagos (balance_cuenta_propia_id,orden_pago_id )
select id,16120 from balance_cuentas_propias
where id in(select balance_cuenta_propia_id from balance_cuentas_propia_pagos
where pago_id in(select id from pagos where tipo_cuenta_id = 1 and expediente_id = 16656 and fecha_pago BETWEEN '2018-07-01' AND '2018-07-31'));






	SELECT count(*) as c, numero-TRUNC(numero,-2)
from tm where tipo = 'M'
group by  numero-TRUNC(numero,-2)
order by c asc

SELECT count(*) as c,  TRUNC((numero-TRUNC(numero,-2))/10,0) *10
from tm where tipo = 'M'
group by   TRUNC((numero-TRUNC(numero,-2))/10,0) *10
order by c asc


		ArrayList<Integer> z = new ArrayList<Integer>();

		//Random randomGenerator = new Random();
		Random rand = new Random(System.currentTimeMillis());
	    for (int idx = 1; idx <= 50; ++idx){

	      //int randomInt = randomGenerator.ne.nextInt(40,49);
	      int randomNum = rand.nextInt((99 -90) + 1) + 90;
	      if(!z.contains(randomNum)){
	    	 Logger.debug("Generated : " + randomNum);
	    	 z.add(randomNum);
	      }
	    }


	    scp sgp-020820181210.gz administrador@10.1.2.240:/home/administrador/
	 	gunzip -c /home/marce/sgp-240920210810.gz | psql -U postgres -d sgp-1310

	    INSERT INTO lineas_creditos_presupuestarios( credito_presupuestario_id, monto, cuenta_analitica_id)
    	VALUES (550, 7000,  726);

		insert into controles_presupuestarios values(
				  DEFAULT,
				  726,
				  null,
				  null,
				  5,
				  0,
				  7000,
				  null,
				  null,
				  null,
				  null,
				  null,
				  1,
				  'now'::date,
				  null,
				  null,
				  7);

	    select count(*) as x, n from datos group by n order by x desc

	    select count(*), o.tipo_orden, ej.nombre,p.nombre,sum(ol.cantidad),ol.precio,sum(c)
from ordenes o
inner join expedientes e on e.id = o.expediente_id
inner join ejercicios ej on e.ejercicio_id = ej.id
inner join orden_lineas ol on ol.orden_id = o.id
inner join productos p on p.id = ol.producto_id
left join(select count(*) as c,orden_linea_id  as orden_linea_id
		  from orden_linea_clientes
		  --inner join clientes c on c.id = oc2.cliente_id
	      --where c.sexo = 'M'
		  group by orden_linea_id ) olc on olc.orden_linea_id = ol.id
where o.proveedor_id = 2328 and state_id = 11
--and p.nombre= 'RADIOTERAPIA' and ol.precio = 85300
group by ej.nombre ,o.tipo_orden,p.nombre,ol.precio
order by ej.nombre
-----------------------------

select to_char(e.fecha,'dd/MM/YYYY'),e.nombre,ej.nombre,p.nombre,c.nombre,ca.nombre,olc.cantidad,ol.precio
from ordenes o
inner join expedientes e on e.id = o.expediente_id
inner join ejercicios ej on e.ejercicio_id = ej.id
inner join orden_lineas ol on ol.orden_id = o.id
inner join orden_linea_clientes olc on olc.orden_linea_id = ol.id
inner join clientes c on c.id = olc.cliente_id
inner join productos p on p.id = ol.producto_id
inner join cuentas_analiticas ca on ca.id = ol.cuenta_analitica_id

where o.state_id = 11 and c.obrasocial_id = 442 and ej.id = 8
order by e.nombre
	    select (max( cast(REPLACE(nombre, 'IIBB', '0' )as integer)) +1) as n  from factura_linea_impuestos where cuenta_id = 110 or cuenta_id =276
    	*/
		 /*Global pr=new Global();
		pr.onStart(null); */
	 /*
	  select count(*) as c,ca.id,ca.nombre,od.nombre
from facturas f
inner join factura_lineas fl on fl.factura_id = f.id
inner join cuentas_analiticas ca on ca.id = fl.cuenta_analitica_id
inner join ordenes o on o.id = f.orden_id
inner join ordenes_rubros od on od.id = o.orden_rubro_id

where f.state_id= 19 and fecha_orden_pago >= '2019-01-01' and fecha_orden_pago <= '2019-12-31'
group by ca.id,ca.nombre,od.nombre
order by c desc



alter table solicitudes disable trigger all;
update solicitudes set departamento_id =244 where expediente_id = 26240;
alter table solicitudes enable trigger all;


alter table ordenes disable trigger all;
update ordenes set tipo_orden='servicio' where id in(135121);
alter table ordenes enable trigger all;



alter table ordenes disable trigger all;
update ordenes set fecha_presupuesto= '2024-04-09' where id in(129449);
alter table ordenes enable trigger all;


alter table ordenes_provision disable trigger all;
update ordenes_provision set numero = 1996
where orden_compra_id in(select id from ordenes where expediente_id = 45235);
alter table ordenes_provision enable trigger all;



0029
36807


alter table orden_lineas disable trigger all;
update orden_lineas set departamento_id=244 where orden_id in(select id from ordenes where expediente_id=26240);
alter table orden_lineas enable trigger all;

select sum(ol.total+ola.totalAjuste) total --,o.state_id
from ordenes o
inner join expedientes e on e.id = o.expediente_id
inner join ejercicios ej on ej.id = e.ejercicio_id
left outer join (select orden_id, sum(CAST(precio * ol.cantidad as numeric)) as total
		from orden_lineas ol group by orden_id) as ol on ol.orden_id = o.id
left outer join (select orden_id, sum(precio * cantidad) as totalAjuste
		from orden_lineas_ajustes group by orden_id) as ola on ola.orden_id = o.id
where o.id in(81279,81251) and o.state_id = 11 and o.state_id = 11 and ej.id= 9
//////////////////
 MOVIMIENTOS PRESUPUESTO PREVENTIVO
 * select sum(haber-debe),e.nombre,e.ejercicio_id,c.create_date,etapa_presupuestaria_id
from controles_presupuestarios c
left join expedientes e on e.id=c.expediente_id
where
etapa_presupuestaria_id in(5,1)
and cuenta_analitica_padre_id = 78
and c.ejercicio_id =12 --AND e.nombre='1571'
group by  e.id,e.nombre,e.ejercicio_id,c.create_date,etapa_presupuestaria_id
 order by c.create_date asc


 select sum(haber-debe),c.id,c.ejercicio_id,cuenta_analitica_padre_id, c.create_date
from controles_presupuestarios c
left join expedientes e on e.id=c.expediente_id
where
etapa_presupuestaria_id in(5)
group by c.id,c.ejercicio_id,cuenta_analitica_padre_id,c.create_date
order by c.id ascv
	  * */
		Integer u = Usuario.getUsuarioSesion();
    	boolean usuariosActivos = (u.equals(149) || //"MICHELLE NIELSEN"
    							   u.equals(401) || //"ZANIVAN SILVIA"
    							   u.equals(1) ||
    							   u.equals(428) ||//ale storti
    							   u.equals(415) ||// dani diblasi
    							   u.equals(434) ||// mauro bar
    							   u.equals(15) || //"EDUARDO RICARDO DORSANEO"
    							   u.equals(5) ||   //"RYWAKA LIDIA"
    							   u.equals(143) || //"CHAPARRO GLADIS"
    							   u.equals(9));//"BENESZ, DARIO");
    	List<OrdenProvision> op = new ArrayList<OrdenProvision>();
    	List<OrdenProvision> opx = new ArrayList<OrdenProvision>();

    	Integer cantOp  = 0;
    	Integer cantOpx = 0;

    	if(usuariosActivos){
    		/*
    		op = OrdenProvision.find.where()
        			.not(Expr.in("ordenCompra.expediente.ejercicio.id", new Long[]{1L,2L,3L,4L,5L}))
        			.isNull("ordenCompra.fecha_provision")
        			.gt("totalRecepcionado",BigDecimal.ZERO)
        			.findList();

    		opx = OrdenProvision.find.where()
        			.not(Expr.in("ordenCompra.expediente.ejercicio.id", new Long[]{1L,2L,3L,4L,5L}))
        			.isNull("ordenCompra.fecha_provision")
        			.findList();
    		*/

    		cantOp = InformeTotalesPorOrden.find.where()
    		.not(Expr.in("ordenProvision.ordenCompra.expediente.ejercicio.id", new Long[]{1L,2L,3L,4L,5L}))
 			.isNull("ordenProvision.ordenCompra.fecha_provision")
 			.gt("totalRecepcionado",BigDecimal.ZERO)
    		.findRowCount();

    		cantOpx = InformeTotalesPorOrden.find.where()
        	.not(Expr.in("ordenProvision.ordenCompra.expediente.ejercicio.id", new Long[]{1L,2L,3L,4L,5L}))
        	.isNull("ordenProvision.ordenCompra.fecha_provision")
    		.findRowCount();
    	}


    	int eSize =0 ;


    	boolean usuariosActivos2 = (u.equals(25) || //"ana conde
    			   u.equals(439) || //"ana conde
    			   u.equals(8) || //"vanesa
				   u.equals(401) || //"ZANIVAN SILVIA"
				   u.equals(428) ||//ale storti
				   u.equals(415) ||// dani diblasi
				   u.equals(434) ||// mauro bar
				   u.equals(1));
    	if(usuariosActivos2) {
    		ExpressionList<InformeDeudaProveedoresMaterializada> e =InformeDeudaProveedoresMaterializada.find
	    			.fetch("proveedor", "nombre")
	    			.fetch("ordenProvision", "numero, orden_compra_id")
	    			.where();
	    	e = e.ne("rubro_id",8);
	    	e = e.ne("rubro_id",10);
	    	e = e.raw("total_autorizado <> total_pagado");
	    	eSize = e.findList().size();
    	}

    	Logger.debug("------------------- "+usuariosActivos2);
    	List<SqlRow>  row = null;
    	if(u.equals(15) || u.equals(1) || u.equals(433)) {
    		String sql = "select count(*) as c,u.id as id,u.nombre as nombre "+
    		"from solicitudes s "+
    		"inner join estados e on e.id = s.state_id "+
    		"inner join usuarios u on u.id = s.asignacion_usuario_id "+
    		"where asignacion_usuario_id is not null and e.id <> 5 and e.id <> 6 "+
    		"group by u.id,u.nombre order by c desc";
    		SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
    		row = sqlQuery.findList();
    	}

    	List<RemitoBaul> rem = RemitoBaul.find.where()
				   .eq("borrado", false)
				   .findList();


    	return ok(index2.render(usuariosActivos,cantOp,cantOpx,eSize,usuariosActivos2,row,rem.size()));


    	//return ok(index2.render(usuariosActivos,cantOp,cantOpx,eSize,usuariosActivos2,row));
    	//return ok(index2.render(usuariosActivos,op.size(),opx.size()));
    }


}