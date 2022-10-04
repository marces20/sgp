
package views.html.presupuesto.balancePresupuestario.reportes

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
object modalReporteBalancePorCuentaPorExpediente extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,DynamicForm,Integer,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(url: String = null,formBuscador: DynamicForm,id:Integer):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.59*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/if(url)/*5.9*/ {_display_(Seq[Any](format.raw/*5.11*/("""
	<div class="panel panel-default">
		<div class="panel-body">
	    	<i class="glyphicon glyphicon-save"></i> <a href=""""),_display_(Seq[Any](/*8.58*/controllers/*8.69*/.contabilidad.routes.FacturasAccionesController.descargar322(url))),format.raw/*8.134*/("""">
	    	Descargar archivo</a>
		</div>
	</div>
	 
	
""")))}/*14.2*/else/*14.6*/{_display_(Seq[Any](format.raw/*14.7*/("""

 

	"""),_display_(Seq[Any](/*18.3*/helper/*18.9*/.form(action = controllers.presupuesto.routes.BalancePresupuestarioReportesController.reporteBalancePorCuentaPorExpediente(id), 'id -> "formReporteBalancePorCuentaPorExpediente")/*18.187*/ {_display_(Seq[Any](format.raw/*18.189*/("""
			"""),_display_(Seq[Any](/*19.5*/views/*19.10*/.html.tags.successError())),format.raw/*19.35*/("""

	
		 
		<div class="row">	
			<div class="col-sm-2">
				<label class="control-label">Ejercicio
				"""),_display_(Seq[Any](/*26.6*/select(formBuscador("ejercicio"), Ejercicio.getEjercicios().map { p => p.id.toString -> p.nombre}, 
				'class -> "form-control select"))),format.raw/*27.37*/("""
				</label>
			</div>
			<div class="col-sm-5"><br />
				<button type="submit" class="btn btn-default" title="Buscar"><i class="glyphicon glyphicon-floppy-disk"></i> Buscar</button>
			</div>
		</div>	
	""")))})),format.raw/*34.3*/("""	
""")))})),format.raw/*35.2*/("""

"""),_display_(Seq[Any](/*37.2*/flash()/*37.9*/.clear())),format.raw/*37.17*/("""
<script>
 $( function () """),format.raw/*39.17*/("""{"""),format.raw/*39.18*/("""
	 $(document).on("submit", '#formReporteBalancePorCuentaPorExpediente', function()"""),format.raw/*40.83*/("""{"""),format.raw/*40.84*/("""
			var form = $(this);
			var url = form.attr('action');
			var data = form.serialize();
			var submit = form.find("button[type='submit']");
			submit.replaceWith(getLoading());
			$.post(url, data, function(data)"""),format.raw/*46.36*/("""{"""),format.raw/*46.37*/("""
				if(data.success) """),format.raw/*47.22*/("""{"""),format.raw/*47.23*/("""
					 
					form.replaceWith(data.html);
				"""),format.raw/*50.5*/("""}"""),format.raw/*50.6*/(""" else """),format.raw/*50.12*/("""{"""),format.raw/*50.13*/("""
					form.replaceWith(data);
				"""),format.raw/*52.5*/("""}"""),format.raw/*52.6*/("""
			"""),format.raw/*53.4*/("""}"""),format.raw/*53.5*/(""");
			
			return false;
		"""),format.raw/*56.3*/("""}"""),format.raw/*56.4*/(""");
 """),format.raw/*57.2*/("""}"""),format.raw/*57.3*/(""");
</script>"""))}
    }
    
    def render(url:String,formBuscador:DynamicForm,id:Integer): play.api.templates.HtmlFormat.Appendable = apply(url,formBuscador,id)
    
    def f:((String,DynamicForm,Integer) => play.api.templates.HtmlFormat.Appendable) = (url,formBuscador,id) => apply(url,formBuscador,id)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:36 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/presupuesto/balancePresupuestario/reportes/modalReporteBalancePorCuentaPorExpediente.scala.html
                    HASH: 49cdcf11b82b6635767f89d94d527bcc61a8668c
                    MATRIX: 873->1|1032->77|1064->101|1138->58|1166->145|1204->149|1218->156|1257->158|1412->278|1431->289|1518->354|1590->408|1602->412|1640->413|1682->420|1696->426|1884->604|1925->606|1965->611|1979->616|2026->641|2164->744|2322->880|2560->1087|2594->1090|2632->1093|2647->1100|2677->1108|2731->1134|2760->1135|2871->1218|2900->1219|3142->1433|3171->1434|3221->1456|3250->1457|3323->1503|3351->1504|3385->1510|3414->1511|3475->1545|3503->1546|3534->1550|3562->1551|3615->1577|3643->1578|3674->1582|3702->1583
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|36->8|36->8|36->8|42->14|42->14|42->14|46->18|46->18|46->18|46->18|47->19|47->19|47->19|54->26|55->27|62->34|63->35|65->37|65->37|65->37|67->39|67->39|68->40|68->40|74->46|74->46|75->47|75->47|78->50|78->50|78->50|78->50|80->52|80->52|81->53|81->53|84->56|84->56|85->57|85->57
                    -- GENERATED --
                */
            