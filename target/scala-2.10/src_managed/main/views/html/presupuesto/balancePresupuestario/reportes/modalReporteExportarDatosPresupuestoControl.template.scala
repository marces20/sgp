
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
object modalReporteExportarDatosPresupuestoControl extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(url: String = null,formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.48*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/if(url)/*5.9*/ {_display_(Seq[Any](format.raw/*5.11*/("""
	<div class="panel panel-default">
		<div class="panel-body">
	    	<i class="glyphicon glyphicon-save"></i> <a href=""""),_display_(Seq[Any](/*8.58*/controllers/*8.69*/.contabilidad.routes.FacturasAccionesController.descargar322(url))),format.raw/*8.134*/("""">
	    	Descargar archivo</a>
		</div>
	</div>
	 
	
""")))}/*14.2*/else/*14.6*/{_display_(Seq[Any](format.raw/*14.7*/("""

 

	"""),_display_(Seq[Any](/*18.3*/helper/*18.9*/.form(action = controllers.presupuesto.routes.BalancePresupuestarioReportesController.reporteExportarDatosPresupuestoControl(), 'id -> "formReporteExportarDatosPresupuestoControl")/*18.189*/ {_display_(Seq[Any](format.raw/*18.191*/("""
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
	 $(document).on("submit", '#formReporteExportarDatosPresupuestoControl', function()"""),format.raw/*40.85*/("""{"""),format.raw/*40.86*/("""
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
    
    def render(url:String,formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(url,formBuscador)
    
    def f:((String,DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (url,formBuscador) => apply(url,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:36 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/presupuesto/balancePresupuestario/reportes/modalReporteExportarDatosPresupuestoControl.scala.html
                    HASH: 132e7b68f0f5609736203babda75aa412043c79c
                    MATRIX: 867->1|1015->66|1047->90|1121->47|1149->134|1187->138|1201->145|1240->147|1395->267|1414->278|1501->343|1573->397|1585->401|1623->402|1665->409|1679->415|1869->595|1910->597|1950->602|1964->607|2011->632|2149->735|2307->871|2545->1078|2579->1081|2617->1084|2632->1091|2662->1099|2716->1125|2745->1126|2858->1211|2887->1212|3129->1426|3158->1427|3208->1449|3237->1450|3310->1496|3338->1497|3372->1503|3401->1504|3462->1538|3490->1539|3521->1543|3549->1544|3602->1570|3630->1571|3661->1575|3689->1576
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|36->8|36->8|36->8|42->14|42->14|42->14|46->18|46->18|46->18|46->18|47->19|47->19|47->19|54->26|55->27|62->34|63->35|65->37|65->37|65->37|67->39|67->39|68->40|68->40|74->46|74->46|75->47|75->47|78->50|78->50|78->50|78->50|80->52|80->52|81->53|81->53|84->56|84->56|85->57|85->57
                    -- GENERATED --
                */
            