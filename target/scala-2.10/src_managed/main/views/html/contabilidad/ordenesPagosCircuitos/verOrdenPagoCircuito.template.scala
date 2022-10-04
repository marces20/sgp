
package views.html.contabilidad.ordenesPagosCircuitos

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
object verOrdenPagoCircuito extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[OrdenPagoCircuito],OrdenPagoCircuito,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(ordenPagoCircuitoForm: Form[OrdenPagoCircuito], ordenPagoCircuito:OrdenPagoCircuito):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.87*/("""
"""),format.raw/*5.70*/(""" 
"""),_display_(Seq[Any](/*6.2*/views/*6.7*/.html.contabilidad.mainContabilidad("Lista de Circuito Ordenes de Pago")/*6.79*/ {_display_(Seq[Any](format.raw/*6.81*/("""
<div class="page-header">
	<div class="row">
		<div class="col-sm-3">
			<h1>Vista Orden de Pago</h1>
		</div>
	</div>		
</div>		
"""),_display_(Seq[Any](/*14.2*/views/*14.7*/.html.tags.successError())),format.raw/*14.32*/("""
<div class="row menu-acciones">
	<div class="col-sm-9">
		<a href=""""),_display_(Seq[Any](/*17.13*/controllers/*17.24*/.contabilidad.routes.OrdenesPagosCircuitosController.editar(ordenPagoCircuitoForm.field("id").value.toLong))),_display_(Seq[Any](/*17.132*/UriTrack/*17.140*/.get("&"))),format.raw/*17.149*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-edit"></i> Editar</a>
	</div>
	<div class="col-sm-3">
		<a href=""""),_display_(Seq[Any](/*20.13*/UriTrack/*20.21*/.getOnNull(controllers.contabilidad.routes.OrdenesPagosCircuitosController.index().absoluteURL()))),format.raw/*20.118*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a>
	</div>	
</div>
<div class="row">
	<div class="col-sm-4">
		<div class="form-group">
			<label class="control-label">Contraparte</label>
			<p class="form-control-static form-control">
				<a href="#" class="infoProveedor" data-url=""""),_display_(Seq[Any](/*28.50*/controllers/*28.61*/.compras.routes.ProveedoresAccionesController.modalInformacionProveedor(ordenPagoCircuito.proveedor.id))),format.raw/*28.164*/("""">
					"""),_display_(Seq[Any](/*29.7*/ordenPagoCircuitoForm/*29.28*/.field("proveedor.nombre").value)),format.raw/*29.60*/("""
				</a>
			</p>
		</div>
	</div>
	<div class="col-sm-2">
		<div class="form-group">
			<label class="control-label">Expediente</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*37.49*/ordenPagoCircuitoForm/*37.70*/.field("expediente.expedienteEjercicio").value)),format.raw/*37.116*/("""</p>
		</div>
	</div>
	<div class="col-sm-2">
		<div class="form-group">
			<label class="control-label">Orden de pago N°</label>
			<p class="form-control-static form-control">
				"""),_display_(Seq[Any](/*44.6*/if(ordenPagoCircuito.ordenPago != null)/*44.45*/{_display_(Seq[Any](format.raw/*44.46*/(""" 
					"""),_display_(Seq[Any](/*45.7*/ordenPagoCircuitoForm/*45.28*/.field("ordenPago.ordenEjercicio").value)),format.raw/*45.68*/("""
				""")))})),format.raw/*46.6*/("""
			</p>
		</div>
	</div>
	<div class="col-sm-2">
		<div class="form-group">
			<label class="control-label">Expediente Fisico</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*53.49*/ordenPagoCircuitoForm/*53.70*/.field("expedienteFisico.expedienteEjercicio").value)),format.raw/*53.122*/("""</p>
		</div>
	</div>
</div>		

"""),_display_(Seq[Any](/*58.2*/views/*58.7*/.html.contabilidad.ordenesPagosCircuitos.tabsOrdenPagoCircuito(ordenPagoCircuitoForm,ordenPagoCircuito))),format.raw/*58.110*/("""

<h4>Total: 	<b>"""),_display_(Seq[Any](/*60.17*/(utils.NumberUtils.moneda(ordenPagoCircuito.total)))),format.raw/*60.68*/("""</b></h4>	
<h4>Estado actual: 	<b>"""),_display_(Seq[Any](/*61.25*/ordenPagoCircuito/*61.42*/.estado.nombre)),format.raw/*61.56*/("""</b></h4>

<div class="row margin-bottom-25">
	"""),_display_(Seq[Any](/*64.3*/for(estado <- models.Estado.getSiguienteEstadoPorAprobar(ordenPagoCircuito.estado.orden,models.Estado.ORDEN_PAGO_CIRCUITO)) yield /*64.126*/ {_display_(Seq[Any](format.raw/*64.128*/("""	
		"""),_display_(Seq[Any](/*65.4*/if(estado.orden <= 4)/*65.25*/ {_display_(Seq[Any](format.raw/*65.27*/("""
			<div class="col-sm-3">
				<a href=""""),_display_(Seq[Any](/*67.15*/controllers/*67.26*/.contabilidad.routes.OrdenesPagosCircuitosController.cambiarEstado(ordenPagoCircuitoForm.field("id").value.toInt, estado.id.toLong))),_display_(Seq[Any](/*67.158*/UriTrack/*67.166*/.get("&"))),format.raw/*67.175*/("""" class="btn btn-default">
					<i class="glyphicon glyphicon-arrow-right"></i> """),_display_(Seq[Any](/*68.55*/estado/*68.61*/.nombre)),format.raw/*68.68*/("""
				</a>
			</div>
		""")))})),format.raw/*71.4*/("""
	""")))})),format.raw/*72.3*/("""	
		 
	"""),_display_(Seq[Any](/*74.3*/if(ordenPagoCircuito.estado.id == models.Estado.ORDEN_PAGO_CIRCUITO_ESTADO_CANCELADO)/*74.88*/ {_display_(Seq[Any](format.raw/*74.90*/("""
		<div class="col-sm-3">
			<a href=""""),_display_(Seq[Any](/*76.14*/controllers/*76.25*/.contabilidad.routes.OrdenesPagosCircuitosController.cambiarEstado(ordenPagoCircuitoForm.field("id").value.toInt, models.Estado.ORDEN_PAGO_CIRCUITO_ESTADO_BORRADOR))),_display_(Seq[Any](/*76.190*/UriTrack/*76.198*/.get("&"))),format.raw/*76.207*/("""" class="btn btn-default">
				<i class="glyphicon glyphicon-arrow-right"></i> Volver a Borrador
			</a>
		</div>
	""")))}/*80.3*/else/*80.7*/{_display_(Seq[Any](format.raw/*80.8*/("""
		<div class="col-sm-3">
			<a href=""""),_display_(Seq[Any](/*82.14*/controllers/*82.25*/.contabilidad.routes.OrdenesPagosCircuitosController.cambiarEstado(ordenPagoCircuitoForm.field("id").value.toInt, models.Estado.ORDEN_PAGO_CIRCUITO_ESTADO_CANCELADO))),_display_(Seq[Any](/*82.191*/UriTrack/*82.199*/.get("&"))),format.raw/*82.208*/("""" class="btn btn-default">
				<i class="glyphicon glyphicon-minus-sign"></i> Cancelar Circuito
			</a>
		</div>
	""")))})),format.raw/*86.3*/("""
		
</div>


""")))})))}
    }
    
    def render(ordenPagoCircuitoForm:Form[OrdenPagoCircuito],ordenPagoCircuito:OrdenPagoCircuito): play.api.templates.HtmlFormat.Appendable = apply(ordenPagoCircuitoForm,ordenPagoCircuito)
    
    def f:((Form[OrdenPagoCircuito],OrdenPagoCircuito) => play.api.templates.HtmlFormat.Appendable) = (ordenPagoCircuitoForm,ordenPagoCircuito) => apply(ordenPagoCircuitoForm,ordenPagoCircuito)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/ordenesPagosCircuitos/verOrdenPagoCircuito.scala.html
                    HASH: d81500fcd97f78c76666b8aed7518a2e3d137386
                    MATRIX: 859->1|1084->143|1116->167|1190->86|1218->211|1255->214|1267->219|1347->291|1386->293|1553->425|1566->430|1613->455|1718->524|1738->535|1877->643|1895->651|1927->660|2086->783|2103->791|2223->888|2564->1193|2584->1204|2710->1307|2754->1316|2784->1337|2838->1369|3059->1554|3089->1575|3158->1621|3376->1804|3424->1843|3463->1844|3506->1852|3536->1873|3598->1913|3635->1919|3854->2102|3884->2123|3959->2175|4027->2208|4040->2213|4166->2316|4220->2334|4293->2385|4364->2420|4390->2437|4426->2451|4509->2499|4649->2622|4690->2624|4730->2629|4760->2650|4800->2652|4877->2693|4897->2704|5060->2836|5078->2844|5110->2853|5227->2934|5242->2940|5271->2947|5325->2970|5359->2973|5402->2981|5496->3066|5536->3068|5611->3107|5631->3118|5827->3283|5845->3291|5877->3300|6011->3416|6023->3420|6061->3421|6136->3460|6156->3471|6353->3637|6371->3645|6403->3654|6549->3769
                    LINES: 26->1|33->5|33->5|34->1|35->5|36->6|36->6|36->6|36->6|44->14|44->14|44->14|47->17|47->17|47->17|47->17|47->17|50->20|50->20|50->20|58->28|58->28|58->28|59->29|59->29|59->29|67->37|67->37|67->37|74->44|74->44|74->44|75->45|75->45|75->45|76->46|83->53|83->53|83->53|88->58|88->58|88->58|90->60|90->60|91->61|91->61|91->61|94->64|94->64|94->64|95->65|95->65|95->65|97->67|97->67|97->67|97->67|97->67|98->68|98->68|98->68|101->71|102->72|104->74|104->74|104->74|106->76|106->76|106->76|106->76|106->76|110->80|110->80|110->80|112->82|112->82|112->82|112->82|112->82|116->86
                    -- GENERATED --
                */
            