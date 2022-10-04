
package views.html.contabilidad.misPagos

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
object verMiPago extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[MiPago],MiPago,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(miPagoForm: Form[MiPago], miPago:MiPago):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.43*/("""
"""),format.raw/*4.70*/(""" 


"""),_display_(Seq[Any](/*7.2*/views/*7.7*/.html.contabilidad.mainContabilidad("Ver Mi Pago")/*7.57*/ {_display_(Seq[Any](format.raw/*7.59*/("""
	<div class="page-header">
		<div class="row">
			<div class="col-sm-3">
				<h1>Ver pago</h1>
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*16.3*/if(flash.containsKey("success"))/*16.35*/ {_display_(Seq[Any](format.raw/*16.37*/("""
		<div class="alert alert-success"><i class="glyphicon glyphicon-ok-sign"></i> """),_display_(Seq[Any](/*17.81*/flash/*17.86*/.get("success"))),format.raw/*17.101*/("""</div>
	""")))})),format.raw/*18.3*/("""
	"""),_display_(Seq[Any](/*19.3*/if(flash.containsKey("error"))/*19.33*/ {_display_(Seq[Any](format.raw/*19.35*/("""
		<div class="alert alert-danger"><i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*20.84*/flash/*20.89*/.get("error"))),format.raw/*20.102*/("""</div>
	""")))})),format.raw/*21.3*/(""" 
	<div class="row menu-acciones">
		<div class="col-sm-10">
			
		</div>
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*27.14*/UriTrack/*27.22*/.getOnNull(controllers.contabilidad.routes.MisPagosController.index().absoluteURL()))),format.raw/*27.106*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a>
		</div>
	</div>
	
	<div class="row">
		<div class="col-sm-2">
			<label class="control-label">Fecha</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*34.49*/miPagoForm/*34.59*/.field("fecha").value)),format.raw/*34.80*/("""</p>
		</div>
		<div class="col-sm-2">
			<label class="control-label">N° Envio</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*38.49*/miPagoForm/*38.59*/.field("numero_envio").value)),format.raw/*38.87*/("""</p>
		</div>
		<div class="col-sm-2">
			<label class="control-label">N° Lote</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*42.49*/miPagoForm/*42.59*/.field("numero_lote").value)),format.raw/*42.86*/("""</p>
		</div>
		<div class="col-sm-4">
			<label class="control-label">Cantidad</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*46.49*/miPagoForm/*46.59*/.field("cantidad").value)),format.raw/*46.83*/("""</p>
		</div>
		<div class="col-sm-2">
			<label class="control-label">Monto Total</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*50.49*/miPagoForm/*50.59*/.field("monto").value)),format.raw/*50.80*/("""</p>
		</div>
	</div>
	
	

""")))})))}
    }
    
    def render(miPagoForm:Form[MiPago],miPago:MiPago): play.api.templates.HtmlFormat.Appendable = apply(miPagoForm,miPago)
    
    def f:((Form[MiPago],MiPago) => play.api.templates.HtmlFormat.Appendable) = (miPagoForm,miPago) => apply(miPagoForm,miPago)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:39 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/misPagos/verMiPago.scala.html
                    HASH: ceca9e73e94735802d49f58e6cbf036e0f459f7d
                    MATRIX: 813->1|974->80|1006->104|1080->42|1109->148|1151->156|1163->161|1221->211|1260->213|1431->349|1472->381|1512->383|1630->465|1644->470|1682->485|1723->495|1762->499|1801->529|1841->531|1962->616|1976->621|2012->634|2053->644|2207->762|2224->770|2331->854|2602->1089|2621->1099|2664->1120|2840->1260|2859->1270|2909->1298|3084->1437|3103->1447|3152->1474|3328->1614|3347->1624|3393->1648|3572->1791|3591->1801|3634->1822
                    LINES: 26->1|31->4|31->4|32->1|33->4|36->7|36->7|36->7|36->7|45->16|45->16|45->16|46->17|46->17|46->17|47->18|48->19|48->19|48->19|49->20|49->20|49->20|50->21|56->27|56->27|56->27|63->34|63->34|63->34|67->38|67->38|67->38|71->42|71->42|71->42|75->46|75->46|75->46|79->50|79->50|79->50
                    -- GENERATED --
                */
            