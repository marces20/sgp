
package views.html.contabilidad.facturas

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
object contenidoTabActas extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Long,List[FacturaActaAsosiada],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(idFactura: Long, lista: List[FacturaActaAsosiada] = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import utils._


Seq[Any](format.raw/*1.60*/("""
"""),format.raw/*3.1*/("""


<p><a class="btn btn-default btn-xs" href=""""),_display_(Seq[Any](/*6.45*/controllers/*6.56*/.contabilidad.routes.FacturasController.modalSeleccionActaRelacionada(idFactura))),format.raw/*6.136*/("""" id="cargarActa"><i class="glyphicon glyphicon-plus"></i> Cargar acta</a></p>


"""),_display_(Seq[Any](/*9.2*/if(lista.size() > 0)/*9.22*/ {_display_(Seq[Any](format.raw/*9.24*/("""
		<table id="listaActas" class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th width="100">Acta número</th>
					<th width="80">Ejercicio</th>
					<th width="80">Expediente</th>
					<th width="100">Total</th>
					<th width="100">Ord. Provisión</th>
					<th>Proveedor</th>
					<th width="100">Fecha</th>
					<th width="80">Tipo</th>
					<th width="30"></th>
				</tr>
			</thead>
			<tbody>
		        """),_display_(Seq[Any](/*25.12*/for(l <- lista) yield /*25.27*/ {_display_(Seq[Any](format.raw/*25.29*/("""
				<tr>
					<td>"""),_display_(Seq[Any](/*27.11*/l/*27.12*/.acta.numero)),format.raw/*27.24*/("""</td>
					<td>"""),_display_(Seq[Any](/*28.11*/if(l.acta.ejercicio != null)/*28.39*/ {_display_(Seq[Any](_display_(Seq[Any](/*28.42*/l/*28.43*/.acta.ejercicio.nombre))))})),format.raw/*28.66*/("""</td>
					<td>"""),_display_(Seq[Any](/*29.11*/l/*29.12*/.acta.ordenProvision.ordenCompra.expediente.getExpedienteEjercicio())),format.raw/*29.80*/("""</td>
					<td>"""),_display_(Seq[Any](/*30.11*/utils/*30.16*/.NumberUtils.moneda(l.acta.total))),format.raw/*30.49*/("""</td>
					<td>"""),_display_(Seq[Any](/*31.11*/l/*31.12*/.acta.ordenProvision.numero)),format.raw/*31.39*/("""</td>
					<td>"""),_display_(Seq[Any](/*32.11*/l/*32.12*/.acta.ordenProvision.ordenCompra.proveedor.nombre)),format.raw/*32.61*/("""</td>
					<td>"""),_display_(Seq[Any](/*33.11*/DateUtils/*33.20*/.formatDate(l.acta.fecha))),format.raw/*33.45*/("""</td>
					<td>"""),_display_(Seq[Any](/*34.11*/if(l.acta.cierre)/*34.28*/ {_display_(Seq[Any](format.raw/*34.30*/("""Cierre""")))}/*34.38*/else/*34.43*/{_display_(Seq[Any](format.raw/*34.44*/("""Parcial""")))})),format.raw/*34.52*/("""</td>
					<td><a class="btn btn-default btn-xs eliminarActaAsociada" href=""""),_display_(Seq[Any](/*35.72*/controllers/*35.83*/.contabilidad.routes.FacturasController.eliminarActaAsociada(l.id))),format.raw/*35.149*/(""""><i class="glyphicon glyphicon-trash icono-eliminar"></i></a></td>
				</tr>
              	""")))})),format.raw/*37.17*/("""
			</tbody>
		</table>
""")))}/*40.3*/else/*40.8*/{_display_(Seq[Any](format.raw/*40.9*/("""
	<h4>No existen actas asociadas a esta factura.</h4>
""")))})),format.raw/*42.2*/("""

"""))}
    }
    
    def render(idFactura:Long,lista:List[FacturaActaAsosiada]): play.api.templates.HtmlFormat.Appendable = apply(idFactura,lista)
    
    def f:((Long,List[FacturaActaAsosiada]) => play.api.templates.HtmlFormat.Appendable) = (idFactura,lista) => apply(idFactura,lista)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:40 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/facturas/contenidoTabActas.scala.html
                    HASH: 0643b94a97915b42d4bc328b05c12270a6e14ade
                    MATRIX: 832->1|999->59|1026->76|1108->123|1127->134|1229->214|1345->296|1373->316|1412->318|1888->758|1919->773|1959->775|2015->795|2025->796|2059->808|2111->824|2148->852|2197->855|2207->856|2256->879|2308->895|2318->896|2408->964|2460->980|2474->985|2529->1018|2581->1034|2591->1035|2640->1062|2692->1078|2702->1079|2773->1128|2825->1144|2843->1153|2890->1178|2942->1194|2968->1211|3008->1213|3034->1221|3047->1226|3086->1227|3126->1235|3239->1312|3259->1323|3348->1389|3474->1483|3517->1509|3529->1514|3567->1515|3653->1570
                    LINES: 26->1|30->1|31->3|34->6|34->6|34->6|37->9|37->9|37->9|53->25|53->25|53->25|55->27|55->27|55->27|56->28|56->28|56->28|56->28|56->28|57->29|57->29|57->29|58->30|58->30|58->30|59->31|59->31|59->31|60->32|60->32|60->32|61->33|61->33|61->33|62->34|62->34|62->34|62->34|62->34|62->34|62->34|63->35|63->35|63->35|65->37|68->40|68->40|68->40|70->42
                    -- GENERATED --
                */
            