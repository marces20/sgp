
package views.html.compras.solicitudes.modales

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
object modalInformeFarmacia extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,String,DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(url: String = null,url2: String = null,formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.68*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.tags.successError())),format.raw/*5.32*/("""

"""),_display_(Seq[Any](/*7.2*/if(url)/*7.9*/ {_display_(Seq[Any](format.raw/*7.11*/("""
	<div class="panel panel-default">
		<div class="panel-body">
	    	<i class="glyphicon glyphicon-save"></i> <a href=""""),_display_(Seq[Any](/*10.58*/controllers/*10.69*/.contabilidad.routes.FacturasAccionesController.descargar322(url))),format.raw/*10.134*/("""">Descargar archivo de informe</a>
		</div>
	</div>
""")))}/*13.2*/else/*13.6*/{_display_(Seq[Any](format.raw/*13.7*/("""
	"""),_display_(Seq[Any](/*14.3*/helper/*14.9*/.form(action = controllers.compras.routes.SolicitudesReportesController.informeFarmacia(), 'id -> "formInformeFarmacia")/*14.129*/ {_display_(Seq[Any](format.raw/*14.131*/("""
		<div class="row">
			<div class="col-sm-3">
				<div class="form-group">
					<label for="inputFechaPago" class="control-label">Fecha Desde</label> 
					"""),_display_(Seq[Any](/*19.7*/inputText(formBuscador("fecha_desde"), 'class -> "form-control", 'id -> "fecha_desde", 'autofocus -> "autofocus"))),format.raw/*19.120*/("""
				</div>
					"""),_display_(Seq[Any](/*21.7*/formBuscador("fecha_desde")/*21.34*/.error.map/*21.44*/{ error =>_display_(Seq[Any](format.raw/*21.54*/("""
						<div class="text-error">"""),_display_(Seq[Any](/*22.32*/error/*22.37*/.message)),format.raw/*22.45*/("""</div>
					""")))})),format.raw/*23.7*/("""
			</div>
			<div class="col-sm-3">
				<div class="form-group">
					<label for="inputFechaPago" class="control-label">Fecha Hasta</label> 
					"""),_display_(Seq[Any](/*28.7*/inputText(formBuscador("fecha_hasta"), 'class -> "form-control", 'id -> "fecha_hasta", 'autofocus -> "autofocus"))),format.raw/*28.120*/("""
				</div>
					"""),_display_(Seq[Any](/*30.7*/formBuscador("fecha_hasta")/*30.34*/.error.map/*30.44*/{ error =>_display_(Seq[Any](format.raw/*30.54*/("""
						<div class="text-error">"""),_display_(Seq[Any](/*31.32*/error/*31.37*/.message)),format.raw/*31.45*/("""</div>
					""")))})),format.raw/*32.7*/("""
			</div>
		</div>
		<div class="row">	
			<div class="col-sm-5"><br />
				<button type="submit" class="btn btn-default" title="Buscar"><i class="glyphicon glyphicon-floppy-disk"></i> Buscar</button>
			</div>
		</div>	
	""")))})),format.raw/*40.3*/("""
""")))})),format.raw/*41.2*/("""	
"""),_display_(Seq[Any](/*42.2*/flash()/*42.9*/.clear())),format.raw/*42.17*/("""
<script>
 $( function () """),format.raw/*44.17*/("""{"""),format.raw/*44.18*/("""
	 $('#fecha_hasta,#fecha_desde').mask("99/99/9999");
	 
	  
 """),format.raw/*48.2*/("""}"""),format.raw/*48.3*/(""");
</script>	"""))}
    }
    
    def render(url:String,url2:String,formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(url,url2,formBuscador)
    
    def f:((String,String,DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (url,url2,formBuscador) => apply(url,url2,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:46 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/solicitudes/modales/modalInformeFarmacia.scala.html
                    HASH: a354698925fc447478487f3b709c2440d27d9ac7
                    MATRIX: 836->1|1004->86|1036->110|1110->67|1138->154|1176->158|1188->163|1234->188|1271->191|1285->198|1324->200|1480->320|1500->331|1588->396|1659->449|1671->453|1709->454|1747->457|1761->463|1891->583|1932->585|2125->743|2261->856|2314->874|2350->901|2369->911|2417->921|2485->953|2499->958|2529->966|2573->979|2756->1127|2892->1240|2945->1258|2981->1285|3000->1295|3048->1305|3116->1337|3130->1342|3160->1350|3204->1363|3459->1587|3492->1589|3530->1592|3545->1599|3575->1607|3629->1633|3658->1634|3747->1696|3775->1697
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|35->7|35->7|35->7|38->10|38->10|38->10|41->13|41->13|41->13|42->14|42->14|42->14|42->14|47->19|47->19|49->21|49->21|49->21|49->21|50->22|50->22|50->22|51->23|56->28|56->28|58->30|58->30|58->30|58->30|59->31|59->31|59->31|60->32|68->40|69->41|70->42|70->42|70->42|72->44|72->44|76->48|76->48
                    -- GENERATED --
                */
            