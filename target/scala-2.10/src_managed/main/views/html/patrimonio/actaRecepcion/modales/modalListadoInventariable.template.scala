
package views.html.patrimonio.actaRecepcion.modales

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
object modalListadoInventariable extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(url: String = null,formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.48*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/if(url)/*5.9*/ {_display_(Seq[Any](format.raw/*5.11*/("""
	<div class="panel panel-default">
		<div class="panel-body">
	    	<i class="glyphicon glyphicon-save"></i> <a href=""""),_display_(Seq[Any](/*8.58*/controllers/*8.69*/.contabilidad.routes.FacturasAccionesController.descargar322(url))),format.raw/*8.134*/("""">Descargar archivo</a>
		</div>
	</div>
""")))}/*11.2*/else/*11.6*/{_display_(Seq[Any](format.raw/*11.7*/("""

	"""),_display_(Seq[Any](/*13.3*/helper/*13.9*/.form(action = controllers.patrimonio.routes.ActasRecepcionReportesController.informeListadoInventariable(), 'id -> "formListadoInventariable")/*13.152*/ {_display_(Seq[Any](format.raw/*13.154*/("""
		"""),_display_(Seq[Any](/*14.4*/views/*14.9*/.html.tags.successError())),format.raw/*14.34*/("""
	
		<div class="row">
			<div class="col-sm-3">
				<div class="form-group">
					<label for="inputFechaPago" class="control-label">Fecha Desde</label> 
					"""),_display_(Seq[Any](/*20.7*/inputText(formBuscador("fecha_desde"), 'class -> "form-control", 'id -> "fecha_desde", 'autofocus -> "autofocus"))),format.raw/*20.120*/("""
				</div>
					"""),_display_(Seq[Any](/*22.7*/formBuscador("fecha_desde")/*22.34*/.error.map/*22.44*/{ error =>_display_(Seq[Any](format.raw/*22.54*/("""
						<div class="text-error">"""),_display_(Seq[Any](/*23.32*/error/*23.37*/.message)),format.raw/*23.45*/("""</div>
					""")))})),format.raw/*24.7*/("""
			</div>
			<div class="col-sm-3">
				<div class="form-group">
					<label for="inputFechaPago" class="control-label">Fecha Hasta</label> 
					"""),_display_(Seq[Any](/*29.7*/inputText(formBuscador("fecha_hasta"), 'class -> "form-control", 'id -> "fecha_hasta", 'autofocus -> "autofocus"))),format.raw/*29.120*/("""
				</div>
					"""),_display_(Seq[Any](/*31.7*/formBuscador("fecha_hasta")/*31.34*/.error.map/*31.44*/{ error =>_display_(Seq[Any](format.raw/*31.54*/("""
						<div class="text-error">"""),_display_(Seq[Any](/*32.32*/error/*32.37*/.message)),format.raw/*32.45*/("""</div>
					""")))})),format.raw/*33.7*/("""
			</div>
			
		</div>
		<div class="row">	
			<div class="col-sm-5"><br />
				<button type="submit" class="btn btn-default" title="Buscar"><i class="glyphicon glyphicon-floppy-disk"></i> Buscar</button>
			</div>
		</div>	
	""")))})),format.raw/*42.3*/("""	
""")))})),format.raw/*43.2*/("""

"""),_display_(Seq[Any](/*45.2*/flash()/*45.9*/.clear())),format.raw/*45.17*/("""
<script>
 $( function () """),format.raw/*47.17*/("""{"""),format.raw/*47.18*/("""
	 $('#fecha_hasta,#fecha_desde').mask("99/99/9999");
	
 """),format.raw/*50.2*/("""}"""),format.raw/*50.3*/(""");
</script>"""))}
    }
    
    def render(url:String,formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(url,formBuscador)
    
    def f:((String,DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (url,formBuscador) => apply(url,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/actaRecepcion/modales/modalListadoInventariable.scala.html
                    HASH: 98c25923e4a1faaee0d4861b02032463c35f996f
                    MATRIX: 839->1|987->66|1019->90|1093->47|1121->134|1159->138|1173->145|1212->147|1367->267|1386->278|1473->343|1533->385|1545->389|1583->390|1622->394|1636->400|1789->543|1830->545|1869->549|1882->554|1929->579|2124->739|2260->852|2313->870|2349->897|2368->907|2416->917|2484->949|2498->954|2528->962|2572->975|2755->1123|2891->1236|2944->1254|2980->1281|2999->1291|3047->1301|3115->1333|3129->1338|3159->1346|3203->1359|3462->1587|3496->1590|3534->1593|3549->1600|3579->1608|3633->1634|3662->1635|3746->1692|3774->1693
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|36->8|36->8|36->8|39->11|39->11|39->11|41->13|41->13|41->13|41->13|42->14|42->14|42->14|48->20|48->20|50->22|50->22|50->22|50->22|51->23|51->23|51->23|52->24|57->29|57->29|59->31|59->31|59->31|59->31|60->32|60->32|60->32|61->33|70->42|71->43|73->45|73->45|73->45|75->47|75->47|78->50|78->50
                    -- GENERATED --
                */
            