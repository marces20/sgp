
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
object modalInformeFarmaciaPorUsuario extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,String,DynamicForm,play.api.templates.HtmlFormat.Appendable] {

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
	"""),_display_(Seq[Any](/*14.3*/helper/*14.9*/.form(action = controllers.compras.routes.SolicitudesReportesController.informeFarmaciaPorUsuario(), 'id -> "formInformeFarmaciaPorUsuario")/*14.149*/ {_display_(Seq[Any](format.raw/*14.151*/("""
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
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/solicitudes/modales/modalInformeFarmaciaPorUsuario.scala.html
                    HASH: be141ed7d7d8faee86cf35f8d1a9920c3f4ede82
                    MATRIX: 846->1|1014->86|1046->110|1120->67|1148->154|1186->158|1198->163|1244->188|1281->191|1295->198|1334->200|1490->320|1510->331|1598->396|1669->449|1681->453|1719->454|1757->457|1771->463|1921->603|1962->605|2155->763|2291->876|2344->894|2380->921|2399->931|2447->941|2515->973|2529->978|2559->986|2603->999|2786->1147|2922->1260|2975->1278|3011->1305|3030->1315|3078->1325|3146->1357|3160->1362|3190->1370|3234->1383|3489->1607|3522->1609|3560->1612|3575->1619|3605->1627|3659->1653|3688->1654|3777->1716|3805->1717
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|35->7|35->7|35->7|38->10|38->10|38->10|41->13|41->13|41->13|42->14|42->14|42->14|42->14|47->19|47->19|49->21|49->21|49->21|49->21|50->22|50->22|50->22|51->23|56->28|56->28|58->30|58->30|58->30|58->30|59->31|59->31|59->31|60->32|68->40|69->41|70->42|70->42|70->42|72->44|72->44|76->48|76->48
                    -- GENERATED --
                */
            