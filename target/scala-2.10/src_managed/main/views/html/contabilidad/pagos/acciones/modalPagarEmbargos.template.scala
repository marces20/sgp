
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
object modalPagarEmbargos extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formPago: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.25*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.contabilidad.routes.PagosAccionesController.pagarEmbargos(), 'id -> "formPagar")/*5.115*/ {_display_(Seq[Any](format.raw/*5.117*/("""
	
	"""),_display_(Seq[Any](/*7.3*/views/*7.8*/.html.tags.successError())),format.raw/*7.33*/("""	
				
	<div class="row">
		<div class="col-sm-3">
			<div class="form-group """),_display_(Seq[Any](/*11.28*/if(formPago.error("fecha_pago") != null)/*11.68*/ {_display_(Seq[Any](format.raw/*11.70*/("""has-error""")))})),format.raw/*11.80*/("""">
				<label for="inputFechaPago" class="control-label">Referencia</label> 
				"""),_display_(Seq[Any](/*13.6*/inputText(formPago("referencia"), 'class -> "form-control", 'id -> "referencia", 'autofocus -> "autofocus"))),format.raw/*13.113*/("""
			</div>
				"""),_display_(Seq[Any](/*15.6*/formPago("referencia")/*15.28*/.error.map/*15.38*/{ error =>_display_(Seq[Any](format.raw/*15.48*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*16.31*/error/*16.36*/.message)),format.raw/*16.44*/("""</div>
				""")))})),format.raw/*17.6*/("""
		</div>
		
		<div class="col-sm-5"><br />
			<button type="submit" class="btn btn-default" title="Guardar"><i class="glyphicon glyphicon-floppy-disk"></i> Pagar</button>
		</div>
		
	</div>
	
""")))})),format.raw/*26.2*/("""
"""),_display_(Seq[Any](/*27.2*/flash()/*27.9*/.clear())))}
    }
    
    def render(formPago:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(formPago)
    
    def f:((DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (formPago) => apply(formPago)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:38 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/pagos/acciones/modalPagarEmbargos.scala.html
                    HASH: f468d8435fadab23ceb0ef961a2e1ed1c1e184ac
                    MATRIX: 820->1|945->43|977->67|1051->24|1079->111|1117->115|1130->121|1246->228|1286->230|1325->235|1337->240|1383->265|1497->343|1546->383|1586->385|1628->395|1745->477|1875->584|1926->600|1957->622|1976->632|2024->642|2091->673|2105->678|2135->686|2178->698|2404->893|2441->895|2456->902
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|35->7|35->7|35->7|39->11|39->11|39->11|39->11|41->13|41->13|43->15|43->15|43->15|43->15|44->16|44->16|44->16|45->17|54->26|55->27|55->27
                    -- GENERATED --
                */
            