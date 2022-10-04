
package views.html.contabilidad.ordenesPagos

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
object indexOrdenPago extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[OrdenPago],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[OrdenPago], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.79*/("""
"""),format.raw/*5.70*/(""" 
"""),_display_(Seq[Any](/*6.2*/views/*6.7*/.html.contabilidad.mainContabilidad("Lista de órdenes de pago")/*6.70*/ {_display_(Seq[Any](format.raw/*6.72*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Lista de órdenes de pagos</h1>
			</div>
			<div class="col-sm-2">
				<div class="pull-right btn-header">
					<a href=""""),_display_(Seq[Any](/*15.16*/controllers/*15.27*/.contabilidad.routes.OrdenesPagosController.crear())),format.raw/*15.78*/("""?"""),_display_(Seq[Any](/*15.80*/UriTrack/*15.88*/.encode())),format.raw/*15.97*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nueva Orden</a>
				</div>
			</div>
		</div>
	</div>
	<div id="actions">
		<form action="" method="GET">
			<div class="row">
			</div>
			<div class="row">
				
					<div class="col-sm-2">
						<div class="form-group">
							<label class="control-label">Número
							"""),_display_(Seq[Any](/*29.9*/inputText(formBuscador("numero"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*29.95*/("""
							</label>
						</div>
					</div>
					
					<div class="col-sm-2">
						<label class="control-label">Ejercicio
						"""),_display_(Seq[Any](/*36.8*/select(formBuscador("ejercicio"), Ejercicio.getEjercicios().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*36.167*/("""
						</label>
					</div>
					<div class="col-sm-2 input-group">
						<label class="control-label">Fecha Ultimo Pago</label>
						<div>
						"""),_display_(Seq[Any](/*42.8*/inputText(formBuscador("fecha_ultimo_pago_desde"), 'class -> "form-control inputDateMascara", 'id -> "fecha_ultimo_pago_desde", 'placeholder -> "Desde"))),format.raw/*42.160*/("""
						"""),_display_(Seq[Any](/*43.8*/inputText(formBuscador("fecha_ultimo_pago_hasta"), 'class -> "form-control inputDateMascara", 'id -> "fecha_ultimo_pago_hasta", 'placeholder -> "Hasta"))),format.raw/*43.160*/("""
						</div>
					</div>	
					
					<div class="col-sm-2">
						<div class="form-group">
						<label for="nombre" class="control-label">&nbsp;</label>
						<button  class="form-control btn btn-primary"><i class="glyphicon glyphicon-search"></i> Buscar</button>
						</div>
					</div>
					<div class="col-sm-2">
						<div class="form-group">
						<label for="nombre" class="control-label">&nbsp;</label>
						<a href=""""),_display_(Seq[Any](/*56.17*/controllers/*56.28*/.contabilidad.routes.OrdenesPagosController.index())),format.raw/*56.79*/(""""  class="form-control btn btn-default">Limpiar</a>
						</div>
					</div>
			</div>
		</form>
	</div>
	
	"""),_display_(Seq[Any](/*63.3*/if(buscador.getTotalRowCount == 0)/*63.37*/ {_display_(Seq[Any](format.raw/*63.39*/("""
        
        <div class="well">
            <em>No se encuentran órdenes de pago</em>
        </div>
        
    """)))}/*69.7*/else/*69.12*/{_display_(Seq[Any](format.raw/*69.13*/("""
		
		Mostrando """),_display_(Seq[Any](/*71.14*/buscador/*71.22*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*71.54*/(""" resultado(s). 
		
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th width="30">#</th>
					<th width="40">Número</th>
					<th width="40">Ejercicio</th>
					<th width="80">Creado</th>
					<th width="80">Ultimo pago</th>
					<th width="80">Monto</th>
					<th width="80">Facturado</th>
					<th width="80">Pagado</th>
					<th width="80">Pendiente Pago</th>
					<th width="30">#</th>
				</tr>
			</thead>
			<tbody>
			"""),_display_(Seq[Any](/*89.5*/for(orden <- buscador.getList) yield /*89.35*/ {_display_(Seq[Any](format.raw/*89.37*/("""
				<tr>
				
					<td class="notSeleccion">
						<a class="btn btn-default btn-xs notSeleccion" href=""""),_display_(Seq[Any](/*93.61*/controllers/*93.72*/.contabilidad.routes.OrdenesPagosController.editar(orden.id))),format.raw/*93.132*/("""&"""),_display_(Seq[Any](/*93.134*/UriTrack/*93.142*/.encode())),format.raw/*93.151*/("""">
							<i class="glyphicon glyphicon-edit"></i>
						</a>
					</td>
					<td>"""),_display_(Seq[Any](/*97.11*/orden/*97.16*/.numero)),format.raw/*97.23*/("""</td>
					<td>"""),_display_(Seq[Any](/*98.11*/orden/*98.16*/.ejercicio.nombre)),format.raw/*98.33*/("""</td>
					<td>"""),_display_(Seq[Any](/*99.11*/DateUtils/*99.20*/.formatDate(orden.fecha))),format.raw/*99.44*/("""</td>
					<td>"""),_display_(Seq[Any](/*100.11*/DateUtils/*100.20*/.formatDate(orden.fecha_ultimo_pago))),format.raw/*100.56*/("""</td>
					<td>"""),_display_(Seq[Any](/*101.11*/NumberUtils/*101.22*/.moneda(orden.monto))),format.raw/*101.42*/("""</td>
					<td>"""),_display_(Seq[Any](/*102.11*/NumberUtils/*102.22*/.moneda(orden.getTotalFacturado()))),format.raw/*102.56*/("""</td>
					<td>"""),_display_(Seq[Any](/*103.11*/NumberUtils/*103.22*/.moneda(orden.getTotalPagado()))),format.raw/*103.53*/("""</td>
					<td>"""),_display_(Seq[Any](/*104.11*/NumberUtils/*104.22*/.moneda(orden.getTotalDeuda()))),format.raw/*104.52*/("""</td>
					<td>
						<a class="btn btn-default btn-xs delete-confirm-link notSeleccion" href=""""),_display_(Seq[Any](/*106.81*/controllers/*106.92*/.contabilidad.routes.OrdenesPagosController.eliminar(orden.id))),format.raw/*106.154*/("""&"""),_display_(Seq[Any](/*106.156*/UriTrack/*106.164*/.encode())),format.raw/*106.173*/("""">
							<i class="glyphicon glyphicon-remove-circle icono-eliminar"></i>
						</a>
					</td>
				</tr>
             """)))})),format.raw/*111.15*/("""
	        </tbody>
        </table>
		
		<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*116.8*/views/*116.13*/.html.helpers.paginador(buscador, controllers.contabilidad.routes.OrdenesPagosController.index()))),format.raw/*116.110*/("""
		</div>
 	 """)))})),format.raw/*118.5*/("""
""")))})),format.raw/*119.2*/("""	"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[OrdenPago],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[OrdenPago],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/ordenesPagos/indexOrdenPago.scala.html
                    HASH: 6ec0c0f49235854155eb7195766c471e5a45f194
                    MATRIX: 853->1|1073->139|1105->163|1179->78|1208->207|1246->211|1258->216|1329->279|1368->281|1619->496|1639->507|1712->558|1750->560|1767->568|1798->577|2193->937|2301->1023|2471->1158|2653->1317|2842->1471|3017->1623|3061->1632|3236->1784|3714->2226|3734->2237|3807->2288|3958->2404|4001->2438|4041->2440|4185->2567|4198->2572|4237->2573|4292->2592|4309->2600|4363->2632|4873->3107|4919->3137|4959->3139|5105->3249|5125->3260|5208->3320|5247->3322|5265->3330|5297->3339|5420->3426|5434->3431|5463->3438|5516->3455|5530->3460|5569->3477|5622->3494|5640->3503|5686->3527|5740->3544|5759->3553|5818->3589|5872->3606|5893->3617|5936->3637|5990->3654|6011->3665|6068->3699|6122->3716|6143->3727|6197->3758|6251->3775|6272->3786|6325->3816|6460->3914|6481->3925|6567->3987|6607->3989|6626->3997|6659->4006|6818->4132|6943->4221|6958->4226|7079->4323|7127->4339|7162->4342
                    LINES: 26->1|33->5|33->5|34->1|35->5|36->6|36->6|36->6|36->6|45->15|45->15|45->15|45->15|45->15|45->15|59->29|59->29|66->36|66->36|72->42|72->42|73->43|73->43|86->56|86->56|86->56|93->63|93->63|93->63|99->69|99->69|99->69|101->71|101->71|101->71|119->89|119->89|119->89|123->93|123->93|123->93|123->93|123->93|123->93|127->97|127->97|127->97|128->98|128->98|128->98|129->99|129->99|129->99|130->100|130->100|130->100|131->101|131->101|131->101|132->102|132->102|132->102|133->103|133->103|133->103|134->104|134->104|134->104|136->106|136->106|136->106|136->106|136->106|136->106|141->111|146->116|146->116|146->116|148->118|149->119
                    -- GENERATED --
                */
            