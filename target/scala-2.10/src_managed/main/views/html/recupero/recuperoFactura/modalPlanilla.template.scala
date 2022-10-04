
package views.html.recupero.recuperoFactura

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
object modalPlanilla extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,DynamicForm,play.api.templates.HtmlFormat.Appendable] {

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
	    	Descargar archivo PLANILLA DIARIA</a>
		</div>
	</div>
	
	
""")))}/*14.2*/else/*14.6*/{_display_(Seq[Any](format.raw/*14.7*/("""

	"""),_display_(Seq[Any](/*16.3*/helper/*16.9*/.form(action = controllers.recupero.routes.RecuperoReportesController.informePlanilla(), 'id -> "formPlanilla")/*16.120*/ {_display_(Seq[Any](format.raw/*16.122*/("""
		"""),_display_(Seq[Any](/*17.4*/views/*17.9*/.html.tags.successError())),format.raw/*17.34*/("""
		<div class="row">
			<div class="col-sm-3">
				<label class="control-label">Punto Venta</label> 
				<div class="input-group">
			  
					<span class="input-group-btn">
				      """),_display_(Seq[Any](/*24.12*/select(formBuscador("puntoventa_id"),PuntoVenta.find.all().map { p => p.id.toString -> p.numero}, 
						'class -> "form-control select", '_default -> "Seleccionar", 'id -> "puntoventa_id"))),format.raw/*25.91*/("""
				      <i class="input-group-addon" style="display:none"></i>
				    </span>
			    </div> 
			</div>   
			<div class="col-sm-3">
				<div class="form-group">
					<label for="inputFechaPago" class="control-label">Fecha Desde</label> 
					"""),_display_(Seq[Any](/*33.7*/inputText(formBuscador("fecha_desde"), 'class -> "form-control", 'id -> "fecha_desde", 'autofocus -> "autofocus"))),format.raw/*33.120*/("""
				</div>
					"""),_display_(Seq[Any](/*35.7*/formBuscador("fecha_desde")/*35.34*/.error.map/*35.44*/{ error =>_display_(Seq[Any](format.raw/*35.54*/("""
						<div class="text-error">"""),_display_(Seq[Any](/*36.32*/error/*36.37*/.message)),format.raw/*36.45*/("""</div>
					""")))})),format.raw/*37.7*/("""
			</div>
			<div class="col-sm-3">
				<div class="form-group">
					<label for="inputFechaPago" class="control-label">Fecha Hasta</label> 
					"""),_display_(Seq[Any](/*42.7*/inputText(formBuscador("fecha_hasta"), 'class -> "form-control", 'id -> "fecha_hasta", 'autofocus -> "autofocus"))),format.raw/*42.120*/("""
				</div>
					"""),_display_(Seq[Any](/*44.7*/formBuscador("fecha_hasta")/*44.34*/.error.map/*44.44*/{ error =>_display_(Seq[Any](format.raw/*44.54*/("""
						<div class="text-error">"""),_display_(Seq[Any](/*45.32*/error/*45.37*/.message)),format.raw/*45.45*/("""</div>
					""")))})),format.raw/*46.7*/("""
			</div>
			
		</div>
		<div class="row">	
			<div class="col-sm-5"><br />
				<button type="submit" class="btn btn-default" title="Buscar"><i class="glyphicon glyphicon-floppy-disk"></i> Buscar</button>
			</div>
		</div>	
	""")))})),format.raw/*55.3*/("""	
""")))})),format.raw/*56.2*/("""

"""),_display_(Seq[Any](/*58.2*/flash()/*58.9*/.clear())),format.raw/*58.17*/("""
<script>
 $( function () """),format.raw/*60.17*/("""{"""),format.raw/*60.18*/("""
	 $('#fecha_hasta,#fecha_desde').mask("99/99/9999");
	 
	 
 """),format.raw/*64.2*/("""}"""),format.raw/*64.3*/(""");
</script>"""))}
    }
    
    def render(url:String,formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(url,formBuscador)
    
    def f:((String,DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (url,formBuscador) => apply(url,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:35 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/recupero/recuperoFactura/modalPlanilla.scala.html
                    HASH: 110399666c13a6c776a33f6b34f22e30ddcb3596
                    MATRIX: 819->1|967->66|999->90|1073->47|1101->134|1139->138|1153->145|1192->147|1347->267|1366->278|1453->343|1540->412|1552->416|1590->417|1629->421|1643->427|1764->538|1805->540|1844->544|1857->549|1904->574|2124->758|2335->947|2617->1194|2753->1307|2806->1325|2842->1352|2861->1362|2909->1372|2977->1404|2991->1409|3021->1417|3065->1430|3248->1578|3384->1691|3437->1709|3473->1736|3492->1746|3540->1756|3608->1788|3622->1793|3652->1801|3696->1814|3955->2042|3989->2045|4027->2048|4042->2055|4072->2063|4126->2089|4155->2090|4243->2151|4271->2152
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|36->8|36->8|36->8|42->14|42->14|42->14|44->16|44->16|44->16|44->16|45->17|45->17|45->17|52->24|53->25|61->33|61->33|63->35|63->35|63->35|63->35|64->36|64->36|64->36|65->37|70->42|70->42|72->44|72->44|72->44|72->44|73->45|73->45|73->45|74->46|83->55|84->56|86->58|86->58|86->58|88->60|88->60|92->64|92->64
                    -- GENERATED --
                */
            