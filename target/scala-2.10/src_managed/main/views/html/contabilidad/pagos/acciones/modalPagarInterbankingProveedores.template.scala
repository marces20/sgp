
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
object modalPagarInterbankingProveedores extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formPago: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.25*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.contabilidad.routes.PagosAccionesController.pagarInterbankingProveedores(), 'id -> "formPagar")/*5.130*/ {_display_(Seq[Any](format.raw/*5.132*/("""
	
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
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/pagos/acciones/modalPagarInterbankingProveedores.scala.html
                    HASH: d0b1a3dab04cd00550a955f89416ce38045a561a
                    MATRIX: 835->1|960->43|992->67|1066->24|1094->111|1132->115|1145->121|1276->243|1316->245|1355->250|1367->255|1413->280|1527->358|1576->398|1616->400|1658->410|1775->492|1905->599|1956->615|1987->637|2006->647|2054->657|2121->688|2135->693|2165->701|2208->713|2434->908|2471->910|2486->917
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|35->7|35->7|35->7|39->11|39->11|39->11|39->11|41->13|41->13|43->15|43->15|43->15|43->15|44->16|44->16|44->16|45->17|54->26|55->27|55->27
                    -- GENERATED --
                */
            