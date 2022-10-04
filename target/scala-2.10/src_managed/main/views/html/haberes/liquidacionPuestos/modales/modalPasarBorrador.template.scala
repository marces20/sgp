
package views.html.haberes.liquidacionPuestos.modales

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
object modalPasarBorrador extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.29*/("""
"""),format.raw/*3.70*/(""" 
	
"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.haberes.routes.LiquidacionPuestosAccionesController.pasarBorradorMasivo(), 'id -> "formPasarBorradorLiquidacionPuestos")/*5.155*/ {_display_(Seq[Any](format.raw/*5.157*/("""	
	
	"""),_display_(Seq[Any](/*7.3*/views/*7.8*/.html.tags.successError())),format.raw/*7.33*/("""
	
	<div class="col-sm-5"><br />
		<button type="submit" class="btn btn-default" title="Pasar a Borrador">
		<i class="glyphicon glyphicon-arrow-right"></i> Pasar a Borrador</button>
	</div>

""")))})),format.raw/*14.2*/("""
"""),_display_(Seq[Any](/*15.2*/flash()/*15.9*/.clear())))}
    }
    
    def render(formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(formBuscador)
    
    def f:((DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (formBuscador) => apply(formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/liquidacionPuestos/modales/modalPasarBorrador.scala.html
                    HASH: 8d6c88664c1fc44e6f65ea90ffe27f28eb820880
                    MATRIX: 827->1|956->47|988->71|1062->28|1090->115|1129->120|1142->126|1298->273|1338->275|1378->281|1390->286|1436->311|1660->504|1697->506|1712->513
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|35->7|35->7|35->7|42->14|43->15|43->15
                    -- GENERATED --
                */
            