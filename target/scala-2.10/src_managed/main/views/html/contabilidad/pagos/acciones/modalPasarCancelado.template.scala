
package views.html.contabilidad.pagos.acciones

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
object modalPasarCancelado extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.29*/("""
"""),format.raw/*3.70*/(""" 
	
"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.contabilidad.routes.PagosAccionesController.pasarCanceladoMasivo(), 'id -> "formPasarCanceladoPago")/*5.135*/ {_display_(Seq[Any](format.raw/*5.137*/("""	
	
	"""),_display_(Seq[Any](/*7.3*/views/*7.8*/.html.tags.successError())),format.raw/*7.33*/("""
	<div class="col-sm-3">
		<div class="form-group """),_display_(Seq[Any](/*9.27*/if(formBuscador.error("fecha_cancelacion") != null)/*9.78*/ {_display_(Seq[Any](format.raw/*9.80*/("""has-error""")))})),format.raw/*9.90*/("""">
			<label for="inputFechaCancelacion" class="control-label">Fecha Cancelacion</label> 
			"""),_display_(Seq[Any](/*11.5*/inputText(formBuscador("fecha_cancelacion"), 'class -> "form-control", 'id -> "fechaParaModificarCancelacion", 'autofocus -> "autofocus"))),format.raw/*11.142*/("""
		</div>
			"""),_display_(Seq[Any](/*13.5*/formBuscador("fecha_cancelacion")/*13.38*/.error.map/*13.48*/{ error =>_display_(Seq[Any](format.raw/*13.58*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*14.30*/error/*14.35*/.message)),format.raw/*14.43*/("""</div>
			""")))})),format.raw/*15.5*/("""
	</div>
	<div class="col-sm-5"><br />
		<button type="submit" class="btn btn-default" title="Pasar a Cancelado"><i class="glyphicon glyphicon-arrow-right"></i> Pasar a Cancelado</button>
	</div>

""")))})),format.raw/*21.2*/("""
"""),_display_(Seq[Any](/*22.2*/flash()/*22.9*/.clear())),format.raw/*22.17*/("""
<script>
 $( function () """),format.raw/*24.17*/("""{"""),format.raw/*24.18*/("""
	 $('#fechaParaModificarCancelacion').mask("99/99/9999");
 """),format.raw/*26.2*/("""}"""),format.raw/*26.3*/(""");
</script>"""))}
    }
    
    def render(formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(formBuscador)
    
    def f:((DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (formBuscador) => apply(formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:38 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/pagos/acciones/modalPasarCancelado.scala.html
                    HASH: d83a1fd4cb62d3f8422cec5913f2a19ade55d80c
                    MATRIX: 821->1|950->47|982->71|1056->28|1084->115|1123->120|1136->126|1272->253|1312->255|1352->261|1364->266|1410->291|1496->342|1555->393|1594->395|1635->405|1764->499|1924->636|1973->650|2015->683|2034->693|2082->703|2148->733|2162->738|2192->746|2234->757|2463->955|2500->957|2515->964|2545->972|2599->998|2628->999|2715->1059|2743->1060
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|35->7|35->7|35->7|37->9|37->9|37->9|37->9|39->11|39->11|41->13|41->13|41->13|41->13|42->14|42->14|42->14|43->15|49->21|50->22|50->22|50->22|52->24|52->24|54->26|54->26
                    -- GENERATED --
                */
            