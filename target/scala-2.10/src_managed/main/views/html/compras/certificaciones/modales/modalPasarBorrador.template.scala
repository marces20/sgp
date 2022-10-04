
package views.html.compras.certificaciones.modales

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
	
"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.compras.routes.CertificacionesAccionesController.pasarBorradorMasivo(), 'id -> "formPasarBorradorCertificacion")/*5.147*/ {_display_(Seq[Any](format.raw/*5.149*/("""	
	
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
                    DATE: Tue Oct 04 11:43:43 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/certificaciones/modales/modalPasarBorrador.scala.html
                    HASH: 3823ac5ee23b951acf5a597405e96b2c9b8defe0
                    MATRIX: 824->1|953->47|985->71|1059->28|1087->115|1126->120|1139->126|1287->265|1327->267|1367->273|1405->303|1444->305|1563->389|1576->394|1611->407|1650->416|1690->421|1731->453|1771->455|1890->538|1904->543|1942->558|1982->567|2203->757|2240->759|2255->766
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|35->7|35->7|35->7|36->8|36->8|36->8|37->9|39->11|39->11|39->11|40->12|40->12|40->12|41->13|47->19|48->20|48->20
                    -- GENERATED --
                */
            