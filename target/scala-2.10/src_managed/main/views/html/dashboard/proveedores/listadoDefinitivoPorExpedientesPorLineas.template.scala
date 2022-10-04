
package views.html.dashboard.proveedores

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object listadoDefinitivoPorExpedientesPorLineas extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template5[DynamicForm,java.util.List[Orden],Long,Long,Long,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm,ol:java.util.List[Orden],proveedorId:Long = null,rubroId:Long = null,ejercicioId:Long = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};def /*5.2*/getPacientes/*5.14*/(linea: java.util.List[OrdenLineaCliente]) = {{
	var pacientes:String = new String()
	
	for(olp <- linea) {
		pacientes += olp.cliente.nombre.toUpperCase()+"\n" 
	}
	
	pacientes
}};
Seq[Any](format.raw/*1.122*/("""
"""),format.raw/*3.70*/(""" 

"""),format.raw/*13.2*/("""

"""),_display_(Seq[Any](/*15.2*/views/*15.7*/.html.dashboard.mainDashboard("Proveedores estado definitivo")/*15.69*/ {_display_(Seq[Any](format.raw/*15.71*/("""

<script src=""""),_display_(Seq[Any](/*17.15*/routes/*17.21*/.Assets.at("javascripts/dashboard/proveedores.js"))),format.raw/*17.71*/("""" type="text/javascript"></script>
<div class="page-header">
	<div class="row">
		<div class="col-sm-7"><h1>Proveedores estado definitivo</h1></div>
		<div class="col-sm-5">
			<div class="dropdown pull-right">
			 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
			 	<i class="glyphicon glyphicon-list-alt"></i>
			    Reportes
			    <span class="caret"></span>
			  </button>
			  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
			  	<li role="presentation"><a role="menuitem" id="reporteGeneralPorExpedientePorCuenta" data-url="" tabindex="-1" 
				    href=""""),_display_(Seq[Any](/*30.16*/controllers/*30.27*/.dashboard.routes.ProveedoresController.reporteEstadoDefinitivoExpedienteLineas(proveedorId,rubroId,ejercicioId))),format.raw/*30.139*/("""">
				    Reporte Estado Definitivo Expediente Lineas</a></li>
			  </ul>
			</div>
		</div>
	</div>
</div>
"""),_display_(Seq[Any](/*37.2*/views/*37.7*/.html.tags.successError())),format.raw/*37.32*/("""
<form action="" method="GET">
	<div class="row">
		<div class="col-sm-4">
			<div class="seleccionOrdenRubro">
				<label for="" class="control-label">Rubro</label>
				"""),_display_(Seq[Any](/*43.6*/select(formBuscador("orden_rubro_id"),OrdenRubro.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*43.165*/("""
			</div>
		</div>
			
		<div class="col-sm-6">
			<label class="control-label">Proveedor
				<div class="input-group">
					"""),_display_(Seq[Any](/*50.7*/inputText(formBuscador("proveedor.id"), 'hidden -> "hidden", 'id -> "proveedor_id"))),format.raw/*50.90*/("""
					"""),_display_(Seq[Any](/*51.7*/inputText(formBuscador("proveedor.nombre"), 'name -> "", 'class -> "form-control", 'id -> "proveedor"))),format.raw/*51.109*/("""
					<span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchProveedor" 
									data-title="Selección de Proveedores" 
									data-url=""""),_display_(Seq[Any](/*56.21*/controllers/*56.32*/.compras.routes.ProveedoresController.modalBuscar())),format.raw/*56.83*/("""" 
									data-height="650" 
									data-width="700" 
									data-listen="modal.seleccion.proveedor.simple" 
									data-label="#proveedor" 
									data-field="#proveedor_id">
							<i class="glyphicon glyphicon-search"></i>
						</a>
					</span>
				</div>
			</label>
		</div>
		
		<div class="col-sm-2">
			<label class="control-label">Ejercicio
			"""),_display_(Seq[Any](/*71.5*/select(formBuscador("ejercicio"), Ejercicio.getEjercicios().map { p => p.id.toString -> p.nombre}, 
			'class -> "form-control select"))),format.raw/*72.36*/("""
			</label>
		</div>
	
	</div>
	
	<div class="row">
		<div class="col-sm-2">
			<div class="form-group">
			<label for="nombre" class="control-label">&nbsp;</label>
			<button  class="form-control btn btn-primary">Buscar</button>
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group">
			<label for="nombre" class="control-label">&nbsp;</label>
			<a href=""""),_display_(Seq[Any](/*88.14*/controllers/*88.25*/.dashboard.routes.ProveedoresController.estadoPorExpedientePorLinea())),format.raw/*88.94*/(""""  class="form-control btn btn-default">Limpiar</a>
			</div>
		</div>
	</div>
</form>
<div id="row">
	<table class="table table-bordered">
	<thead>
		<tr>
			<th align="center">Fecha-expediente</th>	
			<th align="center"  width="80">Expediente</th>		
			<th align="center">Proveedor</th>	
			<th align="center">Producto</th>	
			<th align="center">Cantidad</th>	
			<th align="center">Precio</th>
			<th align="center">Total</th>	
			<th align="center">Paciente</th>		
		</tr>
	</thead>					
	"""),_display_(Seq[Any](/*107.3*/for(x <- ol) yield /*107.15*/{_display_(Seq[Any](format.raw/*107.16*/("""
		"""),_display_(Seq[Any](/*108.4*/for(l <- x.lineas) yield /*108.22*/{_display_(Seq[Any](format.raw/*108.23*/("""
			<tr class="" data-url="">
				<td align="center">"""),_display_(Seq[Any](/*110.25*/utils/*110.30*/.DateUtils.formatDate(x.expediente.fecha))),format.raw/*110.71*/("""</td>
				<td align="center">"""),_display_(Seq[Any](/*111.25*/x/*111.26*/.expediente.getExpedienteEjercicio())),format.raw/*111.62*/("""</td>
				<td align="">"""),_display_(Seq[Any](/*112.19*/x/*112.20*/.proveedor.nombre)),format.raw/*112.37*/("""</td>
				<td align="">"""),_display_(Seq[Any](/*113.19*/l/*113.20*/.producto.nombre)),format.raw/*113.36*/("""</td>
				<td align="center">"""),_display_(Seq[Any](/*114.25*/l/*114.26*/.cantidad.toString())),format.raw/*114.46*/("""</td>
				<td align="center">"""),_display_(Seq[Any](/*115.25*/utils/*115.30*/.NumberUtils.moneda(l.precio))),format.raw/*115.59*/("""</td>
				<td align="center"><b>"""),_display_(Seq[Any](/*116.28*/utils/*116.33*/.NumberUtils.moneda(l.precio.multiply(l.cantidad)))),format.raw/*116.83*/("""</b></td>
				<td align="center">
					"""),_display_(Seq[Any](/*118.7*/if(l.ordenLineaCliente.size() > 0)/*118.41*/{_display_(Seq[Any](format.raw/*118.42*/("""
						<div class='tip-top pointer' title='"""),_display_(Seq[Any](/*119.44*/getPacientes(l.ordenLineaCliente))),format.raw/*119.77*/("""'><i class="glyphicon glyphicon-user"></i></div>
					""")))})),format.raw/*120.7*/("""
				</td>
			</tr>
		""")))})),format.raw/*123.4*/("""
	""")))})),format.raw/*124.3*/("""
	</table>
</div>
""")))})),format.raw/*127.2*/("""	"""))}
    }
    
    def render(formBuscador:DynamicForm,ol:java.util.List[Orden],proveedorId:Long,rubroId:Long,ejercicioId:Long): play.api.templates.HtmlFormat.Appendable = apply(formBuscador,ol,proveedorId,rubroId,ejercicioId)
    
    def f:((DynamicForm,java.util.List[Orden],Long,Long,Long) => play.api.templates.HtmlFormat.Appendable) = (formBuscador,ol,proveedorId,rubroId,ejercicioId) => apply(formBuscador,ol,proveedorId,rubroId,ejercicioId)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:44:00 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/proveedores/listadoDefinitivoPorExpedientesPorLineas.scala.html
                    HASH: fed2a638114e5714317af21eb69f07fd21628334
                    MATRIX: 873->1|1095->140|1127->164|1184->212|1204->224|1414->121|1442->208|1472->403|1510->406|1523->411|1594->473|1634->475|1686->491|1701->497|1773->547|2454->1192|2474->1203|2609->1315|2754->1425|2767->1430|2814->1455|3020->1626|3202->1785|3364->1912|3469->1995|3511->2002|3636->2104|3848->2280|3868->2291|3941->2342|4342->2708|4499->2843|4911->3219|4931->3230|5022->3299|5554->3795|5583->3807|5623->3808|5663->3812|5698->3830|5738->3831|5829->3885|5844->3890|5908->3931|5975->3961|5986->3962|6045->3998|6106->4022|6117->4023|6157->4040|6218->4064|6229->4065|6268->4081|6335->4111|6346->4112|6389->4132|6456->4162|6471->4167|6523->4196|6593->4229|6608->4234|6681->4284|6757->4324|6801->4358|6841->4359|6922->4403|6978->4436|7065->4491|7120->4514|7155->4517|7206->4536
                    LINES: 26->1|29->3|29->3|29->5|29->5|38->1|39->3|41->13|43->15|43->15|43->15|43->15|45->17|45->17|45->17|58->30|58->30|58->30|65->37|65->37|65->37|71->43|71->43|78->50|78->50|79->51|79->51|84->56|84->56|84->56|99->71|100->72|116->88|116->88|116->88|135->107|135->107|135->107|136->108|136->108|136->108|138->110|138->110|138->110|139->111|139->111|139->111|140->112|140->112|140->112|141->113|141->113|141->113|142->114|142->114|142->114|143->115|143->115|143->115|144->116|144->116|144->116|146->118|146->118|146->118|147->119|147->119|148->120|151->123|152->124|155->127
                    -- GENERATED --
                */
            