
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
object crearOrdenPago extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[OrdenPago],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formPago: Form[OrdenPago]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.29*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/views/*4.7*/.html.contabilidad.mainContabilidad("Crear orden de pago")/*4.65*/ {_display_(Seq[Any](format.raw/*4.67*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Crear nueva orden de pago</h1>
			</div>
			
			<div class="col-sm-2">
				<a href=""""),_display_(Seq[Any](/*13.15*/controllers/*13.26*/.contabilidad.routes.OrdenesPagosController.index())),format.raw/*13.77*/("""" class="btn btn-default">
					<i class="glyphicon glyphicon-list"></i>
				</a> 
				<a href="#" class="btn btn-default"><i class="glyphicon glyphicon-align-justify"></i></a> 
			</div>
		</div>
	</div>
	"""),_display_(Seq[Any](/*20.3*/if(flash.containsKey("error"))/*20.33*/ {_display_(Seq[Any](format.raw/*20.35*/("""
		<div class="alert alert-danger">
			"""),_display_(Seq[Any](/*22.5*/flash/*22.10*/.get("error"))),format.raw/*22.23*/("""
		</div>
    """)))})),format.raw/*24.6*/("""
    """),_display_(Seq[Any](/*25.6*/helper/*25.12*/.form(action = controllers.contabilidad.routes.OrdenesPagosController.guardar())/*25.92*/ {_display_(Seq[Any](format.raw/*25.94*/("""
		"""),_display_(Seq[Any](/*26.4*/views/*26.9*/.html.contabilidad.ordenesPagos.formOrdenPago(formPago))),format.raw/*26.64*/("""
	""")))})),format.raw/*27.3*/("""
	<script>
$(function()"""),format.raw/*29.13*/("""{"""),format.raw/*29.14*/("""
	$('.searchModal').modalSearch(); 
"""),format.raw/*31.1*/("""}"""),format.raw/*31.2*/(""");
</script>
""")))})),format.raw/*33.2*/("""	"""))}
    }
    
    def render(formPago:Form[OrdenPago]): play.api.templates.HtmlFormat.Appendable = apply(formPago)
    
    def f:((Form[OrdenPago]) => play.api.templates.HtmlFormat.Appendable) = (formPago) => apply(formPago)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/ordenesPagos/crearOrdenPago.scala.html
                    HASH: e1486a8e0613d44bff87d4bc30d3c8de4a500ecf
                    MATRIX: 818->1|956->28|984->48|1021->51|1033->56|1099->114|1138->116|1352->294|1372->305|1445->356|1694->570|1733->600|1773->602|1850->644|1864->649|1899->662|1947->679|1989->686|2004->692|2093->772|2133->774|2173->779|2186->784|2263->839|2298->843|2351->868|2380->869|2445->907|2473->908|2520->924
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|32->4|41->13|41->13|41->13|48->20|48->20|48->20|50->22|50->22|50->22|52->24|53->25|53->25|53->25|53->25|54->26|54->26|54->26|55->27|57->29|57->29|59->31|59->31|61->33
                    -- GENERATED --
                */
            