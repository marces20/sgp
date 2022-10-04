
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
object editarActaRecepcion extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[ActaRecepcion],ActaRecepcion,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(actaForm: Form[ActaRecepcion],acta:ActaRecepcion):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

def /*6.2*/scripts/*6.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*6.13*/("""
	<script src=""""),_display_(Seq[Any](/*7.16*/routes/*7.22*/.Assets.at("javascripts/patrimonio/actasRecepcion.js"))),format.raw/*7.76*/("""" type="text/javascript"></script>
""")))};implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.52*/("""
"""),format.raw/*4.70*/(""" 

"""),format.raw/*8.2*/("""
"""),_display_(Seq[Any](/*9.2*/views/*9.7*/.html.patrimonio.mainPatrimonio("Editar acta",scripts)/*9.61*/ {_display_(Seq[Any](format.raw/*9.63*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Editar acta</h1>
			</div>
		</div>
	</div>
    
    
	"""),_display_(Seq[Any](/*20.3*/helper/*20.9*/.form(action = controllers.patrimonio.routes.ActasRecepcionController.actualizar(), 'id -> "formEditarActa")/*20.117*/ {_display_(Seq[Any](format.raw/*20.119*/("""
		"""),_display_(Seq[Any](/*21.4*/views/*21.9*/.html.patrimonio.actaRecepcion.formActaRecepcion(actaForm))),format.raw/*21.67*/(""" 
	""")))})),format.raw/*22.3*/("""
	<hr />
	"""),_display_(Seq[Any](/*24.3*/views/*24.8*/.html.patrimonio.actaRecepcion.tabsActaRecepcion(true, acta))),format.raw/*24.68*/("""
	
""")))})))}
    }
    
    def render(actaForm:Form[ActaRecepcion],acta:ActaRecepcion): play.api.templates.HtmlFormat.Appendable = apply(actaForm,acta)
    
    def f:((Form[ActaRecepcion],ActaRecepcion) => play.api.templates.HtmlFormat.Appendable) = (actaForm,acta) => apply(actaForm,acta)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/actaRecepcion/editarActaRecepcion.scala.html
                    HASH: d831e2e2c2a6e7c52d308e7afee34b502a6b1882
                    MATRIX: 840->1|1001->163|1015->170|1099->174|1151->191|1165->197|1240->251|1308->89|1340->113|1414->51|1443->157|1474->288|1511->291|1523->296|1585->350|1624->352|1810->503|1824->509|1942->617|1983->619|2023->624|2036->629|2116->687|2152->692|2200->705|2213->710|2295->770
                    LINES: 26->1|31->6|31->6|33->6|34->7|34->7|34->7|35->4|35->4|36->1|37->4|39->8|40->9|40->9|40->9|40->9|51->20|51->20|51->20|51->20|52->21|52->21|52->21|53->22|55->24|55->24|55->24
                    -- GENERATED --
                */
            