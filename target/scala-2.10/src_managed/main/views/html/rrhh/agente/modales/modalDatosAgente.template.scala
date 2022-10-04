
package views.html.rrhh.agente.modales

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
object modalDatosAgente extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(url: String = null,formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.48*/("""
"""),format.raw/*3.70*/(""" 
"""),_display_(Seq[Any](/*4.2*/views/*4.7*/.html.tags.successError())),format.raw/*4.32*/("""
"""),_display_(Seq[Any](/*5.2*/if(url)/*5.9*/ {_display_(Seq[Any](format.raw/*5.11*/("""
	<div class="panel panel-default">
		<div class="panel-body">
	    	<i class="glyphicon glyphicon-save"></i> <a href=""""),_display_(Seq[Any](/*8.58*/controllers/*8.69*/.contabilidad.routes.FacturasAccionesController.descargar322(url))),format.raw/*8.134*/("""">Descargar archivo de informe</a>
		</div>
	</div>
""")))})),format.raw/*11.2*/("""
"""),_display_(Seq[Any](/*12.2*/flash()/*12.9*/.clear())),format.raw/*12.17*/("""	"""))}
    }
    
    def render(url:String,formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(url,formBuscador)
    
    def f:((String,DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (url,formBuscador) => apply(url,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:30 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agente/modales/modalDatosAgente.scala.html
                    HASH: b3c82a122bb9c3e0cacfcdaf17e262615ec7fe9c
                    MATRIX: 817->1|965->66|997->90|1071->47|1099->134|1136->137|1148->142|1194->167|1230->169|1244->176|1283->178|1438->298|1457->309|1544->374|1628->427|1665->429|1680->436|1710->444
                    LINES: 26->1|29->3|29->3|30->1|31->3|32->4|32->4|32->4|33->5|33->5|33->5|36->8|36->8|36->8|39->11|40->12|40->12|40->12
                    -- GENERATED --
                */
            