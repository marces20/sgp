
package views.html.patrimonio.actaRecepcion

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
object crearActaRecepcion extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[ActaRecepcion],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(actaForm: Form[ActaRecepcion]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

def /*5.2*/scripts/*5.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*5.13*/("""
	<script src=""""),_display_(Seq[Any](/*6.16*/routes/*6.22*/.Assets.at("javascripts/patrimonio/actasRecepcion.js"))),format.raw/*6.76*/("""" type="text/javascript"></script>
""")))};implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.33*/("""
"""),format.raw/*4.70*/(""" 
"""),format.raw/*7.2*/("""

"""),_display_(Seq[Any](/*9.2*/views/*9.7*/.html.patrimonio.mainPatrimonio("Crear actar",scripts)/*9.61*/ {_display_(Seq[Any](format.raw/*9.63*/("""
	
	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Crear acta</h1>
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*19.3*/helper/*19.9*/.form(action = controllers.patrimonio.routes.ActasRecepcionController.guardar())/*19.89*/ {_display_(Seq[Any](format.raw/*19.91*/("""
		"""),_display_(Seq[Any](/*20.4*/views/*20.9*/.html.patrimonio.actaRecepcion.formActaRecepcion(actaForm))),format.raw/*20.67*/(""" 
	""")))})),format.raw/*21.3*/("""
	
""")))})),format.raw/*23.2*/("""
"""))}
    }
    
    def render(actaForm:Form[ActaRecepcion]): play.api.templates.HtmlFormat.Appendable = apply(actaForm)
    
    def f:((Form[ActaRecepcion]) => play.api.templates.HtmlFormat.Appendable) = (actaForm) => apply(actaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/actaRecepcion/crearActaRecepcion.scala.html
                    HASH: d594570cdffb2d57aa6d6d922729c94e5ea691d9
                    MATRIX: 825->1|967->142|981->149|1065->153|1117->170|1131->176|1206->230|1274->70|1306->94|1380->32|1409->138|1438->267|1477->272|1489->277|1551->331|1590->333|1767->475|1781->481|1870->561|1910->563|1950->568|1963->573|2043->631|2079->636|2116->642
                    LINES: 26->1|31->5|31->5|33->5|34->6|34->6|34->6|35->4|35->4|36->1|37->4|38->7|40->9|40->9|40->9|40->9|50->19|50->19|50->19|50->19|51->20|51->20|51->20|52->21|54->23
                    -- GENERATED --
                */
            