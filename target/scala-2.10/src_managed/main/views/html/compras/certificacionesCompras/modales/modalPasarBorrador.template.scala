
package views.html.compras.certificacionesCompras.modales

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
	
"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.compras.routes.CertificacionesComprasAccionesController.pasarBorradorMasivo(), 'id -> "formPasarBorradorCertificacion")/*5.154*/ {_display_(Seq[Any](format.raw/*5.156*/("""	
	
	"""),_display_(Seq[Any](/*7.3*/if(flash.containsKey("error"))/*7.33*/ {_display_(Seq[Any](format.raw/*7.35*/("""
		<div class="alert alert-danger"><i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*8.84*/flash/*8.89*/.get("error"))),format.raw/*8.102*/("""</div>
	""")))})),format.raw/*9.3*/("""
	
	"""),_display_(Seq[Any](/*11.3*/if(flash.containsKey("success"))/*11.35*/ {_display_(Seq[Any](format.raw/*11.37*/("""
		<div class="alert alert-success"><i class="glyphicon glyphicon-ok-circle"></i> """),_display_(Seq[Any](/*12.83*/flash/*12.88*/.get("success"))),format.raw/*12.103*/("""</div>
	""")))})),format.raw/*13.3*/("""
	
	<div class="col-sm-5"><br />
		<button type="submit" class="btn btn-default" title="Pasar a Borrador"><i class="glyphicon glyphicon-arrow-right"></i> Pasar a Borrador</button>
	</div>

""")))})),format.raw/*19.2*/("""
"""),_display_(Seq[Any](/*20.2*/flash()/*20.9*/.clear())))}
    }
    
    def render(formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(formBuscador)
    
    def f:((DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (formBuscador) => apply(formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:44 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/certificacionesCompras/modales/modalPasarBorrador.scala.html
                    HASH: 4705cde6ccc9fd902007f09b60631c1028c89a3a
                    MATRIX: 831->1|960->47|992->71|1066->28|1094->115|1133->120|1146->126|1301->272|1341->274|1381->280|1419->310|1458->312|1577->396|1590->401|1625->414|1664->423|1704->428|1745->460|1785->462|1904->545|1918->550|1956->565|1996->574|2217->764|2254->766|2269->773
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|35->7|35->7|35->7|36->8|36->8|36->8|37->9|39->11|39->11|39->11|40->12|40->12|40->12|41->13|47->19|48->20|48->20
                    -- GENERATED --
                */
            