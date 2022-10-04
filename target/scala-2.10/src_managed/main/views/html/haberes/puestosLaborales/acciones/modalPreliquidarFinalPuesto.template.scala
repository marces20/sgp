
package views.html.haberes.puestosLaborales.acciones

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
object modalPreliquidarFinalPuesto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.29*/("""
"""),format.raw/*3.70*/(""" 
	
"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.haberes.routes.PuestosLaboralesAccionesController.preliquidarFinalPuesto(), 'id -> "formPreliquidarPuestoFinal")/*5.147*/ {_display_(Seq[Any](format.raw/*5.149*/("""	
	
	"""),_display_(Seq[Any](/*7.3*/views/*7.8*/.html.tags.successError())),format.raw/*7.33*/("""
	
	
	<div class="row">
		<div class="col-sm-5"><br />
			<button type="submit" class="btn btn-default" title="Preliquidar"><i class="glyphicon glyphicon-arrow-right"></i> Preliquidar</button>
		</div>
	</div>

""")))})),format.raw/*16.2*/("""
<script>
$( function()"""),format.raw/*18.14*/("""{"""),format.raw/*18.15*/("""
	$('#searchLiquidacion').modalSearch();
"""),format.raw/*20.1*/("""}"""),format.raw/*20.2*/(""");
</script>
"""),_display_(Seq[Any](/*22.2*/flash()/*22.9*/.clear())))}
    }
    
    def render(formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(formBuscador)
    
    def f:((DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (formBuscador) => apply(formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/puestosLaborales/acciones/modalPreliquidarFinalPuesto.scala.html
                    HASH: 333d59c8f1e0417c6d202f94212b5abf06011c8b
                    MATRIX: 835->1|964->47|996->71|1070->28|1098->115|1137->120|1150->126|1298->265|1338->267|1378->273|1390->278|1436->303|1679->515|1730->538|1759->539|1827->580|1855->581|1904->595|1919->602
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|35->7|35->7|35->7|44->16|46->18|46->18|48->20|48->20|50->22|50->22
                    -- GENERATED --
                */
            