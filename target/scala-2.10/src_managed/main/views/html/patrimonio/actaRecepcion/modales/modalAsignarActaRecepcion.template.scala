
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
object modalAsignarActaRecepcion extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[ActaRecepcion],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(actaForm: Form[ActaRecepcion]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.33*/("""
"""),format.raw/*4.70*/(""" 
    
"""),_display_(Seq[Any](/*6.2*/helper/*6.8*/.form(action = controllers.patrimonio.routes.ActasRecepcionAccionesController.asignar(), 'id -> "formAsignarActaRecepcion")/*6.131*/ {_display_(Seq[Any](format.raw/*6.133*/("""
"""),_display_(Seq[Any](/*7.2*/views/*7.7*/.html.tags.successError())),format.raw/*7.32*/("""
 <div class="row">
	<div class="col-sm-3">
		<div class="form-group has-required """),_display_(Seq[Any](/*10.40*/if(actaForm.error("numero") != null)/*10.76*/ {_display_(Seq[Any](format.raw/*10.78*/("""has-error""")))})),format.raw/*10.88*/("""">
			<label for="nombre" class="control-label">Número de acta</label>
			"""),_display_(Seq[Any](/*12.5*/inputText(actaForm("numero"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*12.87*/("""
			"""),_display_(Seq[Any](/*13.5*/actaForm("numero")/*13.23*/.error.map/*13.33*/{ error =>_display_(Seq[Any](format.raw/*13.43*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*14.30*/error/*14.35*/.message)),format.raw/*14.43*/("""</div>
			""")))})),format.raw/*15.5*/("""
		</div>
	</div>

	<div class="col-sm-3">
		<div class="form-group has-required """),_display_(Seq[Any](/*20.40*/if(actaForm.error("ejercicio_id") != null)/*20.82*/ {_display_(Seq[Any](format.raw/*20.84*/("""has-error""")))})),format.raw/*20.94*/("""">
			<label class="control-label">Ejercicio
			"""),_display_(Seq[Any](/*22.5*/select(actaForm("ejercicio_id"), Ejercicio.getEjercicios().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*22.163*/("""
			</label>
			"""),_display_(Seq[Any](/*24.5*/actaForm("ejercicio_id")/*24.29*/.error.map/*24.39*/{ error =>_display_(Seq[Any](format.raw/*24.49*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*25.30*/error/*25.35*/.message)),format.raw/*25.43*/("""</div>
			""")))})),format.raw/*26.5*/("""	
		</div>
	</div>

	<div class="col-sm-2">
		<div class="form-group">
		<label for="nombre" class="control-label">&nbsp;</label>
		<button  class="form-control btn btn-primary"> Guardar</button>
		</div>
	</div>	

</div>	

""")))})),format.raw/*39.2*/("""

"""),_display_(Seq[Any](/*41.2*/flash()/*41.9*/.clear())))}
    }
    
    def render(actaForm:Form[ActaRecepcion]): play.api.templates.HtmlFormat.Appendable = apply(actaForm)
    
    def f:((Form[ActaRecepcion]) => play.api.templates.HtmlFormat.Appendable) = (actaForm) => apply(actaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/actaRecepcion/modales/modalAsignarActaRecepcion.scala.html
                    HASH: 37fef4de7181f27cac9f68af2f89516318aa48e5
                    MATRIX: 840->1|991->70|1023->94|1097->32|1126->138|1170->148|1183->154|1315->277|1355->279|1392->282|1404->287|1450->312|1572->398|1617->434|1657->436|1699->446|1811->523|1915->605|1956->611|1983->629|2002->639|2050->649|2117->680|2131->685|2161->693|2204->705|2327->792|2378->834|2418->836|2460->846|2546->897|2727->1055|2781->1074|2814->1098|2833->1108|2881->1118|2948->1149|2962->1154|2992->1162|3035->1174|3304->1412|3344->1417|3359->1424
                    LINES: 26->1|31->4|31->4|32->1|33->4|35->6|35->6|35->6|35->6|36->7|36->7|36->7|39->10|39->10|39->10|39->10|41->12|41->12|42->13|42->13|42->13|42->13|43->14|43->14|43->14|44->15|49->20|49->20|49->20|49->20|51->22|51->22|53->24|53->24|53->24|53->24|54->25|54->25|54->25|55->26|68->39|70->41|70->41
                    -- GENERATED --
                */
            