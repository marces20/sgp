
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
object modalModificarFechaConciliado extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.29*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.contabilidad.routes.PagosAccionesController.modificarFechaConciliado(), 'id -> "formModificarFechaConciliado")/*5.145*/ {_display_(Seq[Any](format.raw/*5.147*/("""
	
	"""),_display_(Seq[Any](/*7.3*/views/*7.8*/.html.tags.successError())),format.raw/*7.33*/("""
	
	"""),_display_(Seq[Any](/*9.3*/formBuscador("id_pago")/*9.26*/.error.map/*9.36*/{ error =>_display_(Seq[Any](format.raw/*9.46*/("""
		<div class="alert alert-danger"><i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*10.84*/error/*10.89*/.message)),format.raw/*10.97*/("""</div>
	""")))})),format.raw/*11.3*/("""		
				
	<div class="row">
		<div class="col-sm-3">
			<div class="form-group """),_display_(Seq[Any](/*15.28*/if(formBuscador.error("fecha_conciliado") != null)/*15.78*/ {_display_(Seq[Any](format.raw/*15.80*/("""has-error""")))})),format.raw/*15.90*/("""">
				<label for="inputFechaConciliado" class="control-label">Fecha Conciliacion</label> 
				"""),_display_(Seq[Any](/*17.6*/inputText(formBuscador("fecha_conciliado"), 'class -> "form-control", 'id -> "fechaParaModificarConciliado", 'autofocus -> "autofocus"))),format.raw/*17.141*/("""
			</div>
				"""),_display_(Seq[Any](/*19.6*/formBuscador("fecha_conciliado")/*19.38*/.error.map/*19.48*/{ error =>_display_(Seq[Any](format.raw/*19.58*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*20.31*/error/*20.36*/.message)),format.raw/*20.44*/("""</div>
				""")))})),format.raw/*21.6*/("""
		</div>
		
		<div class="col-sm-5"><br />
			<button type="submit" class="btn btn-default" title="Guardar"><i class="glyphicon glyphicon-floppy-disk"></i> Modificar</button>
		</div>
		
	</div>
	
""")))})),format.raw/*30.2*/("""
"""),_display_(Seq[Any](/*31.2*/flash()/*31.9*/.clear())),format.raw/*31.17*/("""
<script>
 $( function () """),format.raw/*33.17*/("""{"""),format.raw/*33.18*/("""
	 $('#fechaParaModificarConciliado').mask("99/99/9999");
 """),format.raw/*35.2*/("""}"""),format.raw/*35.3*/(""");
</script>"""))}
    }
    
    def render(formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(formBuscador)
    
    def f:((DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (formBuscador) => apply(formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:38 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/pagos/acciones/modalModificarFechaConciliado.scala.html
                    HASH: 21ee00d29e240130f535db542ee3e557b515cffa
                    MATRIX: 831->1|961->49|993->73|1067->28|1096->117|1136->123|1149->129|1295->266|1335->268|1376->275|1388->280|1434->305|1475->312|1506->335|1524->345|1571->355|1692->440|1706->445|1736->453|1777->463|1896->546|1955->596|1995->598|2037->608|2170->706|2328->841|2381->859|2422->891|2441->901|2489->911|2557->943|2571->948|2601->956|2645->969|2884->1177|2922->1180|2937->1187|2967->1195|3023->1223|3052->1224|3140->1285|3168->1286
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|35->7|35->7|35->7|37->9|37->9|37->9|37->9|38->10|38->10|38->10|39->11|43->15|43->15|43->15|43->15|45->17|45->17|47->19|47->19|47->19|47->19|48->20|48->20|48->20|49->21|58->30|59->31|59->31|59->31|61->33|61->33|63->35|63->35
                    -- GENERATED --
                */
            