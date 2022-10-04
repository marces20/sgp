
package views.html.patrimonio.recepciones

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
object editarRecepcion extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Recepcion],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(recepcionForm: Form[Recepcion]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.34*/("""
"""),format.raw/*4.70*/(""" 
    
"""),_display_(Seq[Any](/*6.2*/views/*6.7*/.html.patrimonio.mainPatrimonio("Editar recepción")/*6.58*/ {_display_(Seq[Any](format.raw/*6.60*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Editar recepción</h1>
			</div>
			
			 
		</div>
	</div>
	 
    
	"""),_display_(Seq[Any](/*19.3*/helper/*19.9*/.form(action = controllers.patrimonio.routes.RecepcionesController.actualizar(), 'id -> "formEditarRecepcion")/*19.119*/ {_display_(Seq[Any](format.raw/*19.121*/("""
		"""),_display_(Seq[Any](/*20.4*/views/*20.9*/.html.patrimonio.recepciones.formRecepciones(recepcionForm))),format.raw/*20.68*/(""" 
	""")))})),format.raw/*21.3*/("""
	
""")))})))}
    }
    
    def render(recepcionForm:Form[Recepcion]): play.api.templates.HtmlFormat.Appendable = apply(recepcionForm)
    
    def f:((Form[Recepcion]) => play.api.templates.HtmlFormat.Appendable) = (recepcionForm) => apply(recepcionForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:31 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/recepciones/editarRecepcion.scala.html
                    HASH: 8f15e4e1d569642883b0119bec4fac6bd674c6bd
                    MATRIX: 816->1|968->71|1000->95|1074->33|1103->139|1147->149|1159->154|1218->205|1257->207|1457->372|1471->378|1591->488|1632->490|1672->495|1685->500|1766->559|1802->564
                    LINES: 26->1|31->4|31->4|32->1|33->4|35->6|35->6|35->6|35->6|48->19|48->19|48->19|48->19|49->20|49->20|49->20|50->21
                    -- GENERATED --
                */
            