
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
object modalModificarFecha extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.29*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.contabilidad.routes.PagosAccionesController.modificarFecha(), 'id -> "formModificarFecha")/*5.125*/ {_display_(Seq[Any](format.raw/*5.127*/("""
	
	"""),_display_(Seq[Any](/*7.3*/views/*7.8*/.html.tags.successError())),format.raw/*7.33*/("""
	
	"""),_display_(Seq[Any](/*9.3*/formBuscador("id_pago")/*9.26*/.error.map/*9.36*/{ error =>_display_(Seq[Any](format.raw/*9.46*/("""
		<div class="alert alert-danger"><i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*10.84*/error/*10.89*/.message)),format.raw/*10.97*/("""</div>
	""")))})),format.raw/*11.3*/("""		
				
	<div class="row">
		<div class="col-sm-3">
			<div class="form-group """),_display_(Seq[Any](/*15.28*/if(formBuscador.error("fecha_pago") != null)/*15.72*/ {_display_(Seq[Any](format.raw/*15.74*/("""has-error""")))})),format.raw/*15.84*/("""">
				<label for="inputFechaPago" class="control-label">Fecha Pago</label> 
				"""),_display_(Seq[Any](/*17.6*/inputText(formBuscador("fecha_pago"), 'class -> "form-control", 'id -> "fechaParaModificar", 'autofocus -> "autofocus"))),format.raw/*17.125*/("""
			</div>
				"""),_display_(Seq[Any](/*19.6*/formBuscador("fecha_pago")/*19.32*/.error.map/*19.42*/{ error =>_display_(Seq[Any](format.raw/*19.52*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*20.31*/error/*20.36*/.message)),format.raw/*20.44*/("""</div>
				""")))})),format.raw/*21.6*/("""
		</div>
		
		<div class="col-sm-5"><br />
			<button type="submit" class="btn btn-default" title="Guardar"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>
		</div>
		
	</div>
	
""")))})),format.raw/*30.2*/("""
"""),_display_(Seq[Any](/*31.2*/flash()/*31.9*/.clear())),format.raw/*31.17*/("""
<script>
 $( function () """),format.raw/*33.17*/("""{"""),format.raw/*33.18*/("""
	 $('#fechaParaModificar').mask("99/99/9999");
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
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/pagos/acciones/modalModificarFecha.scala.html
                    HASH: ed229f102f2e5ee87f2a8463aaaf78a2ee03b1e4
                    MATRIX: 821->1|951->49|983->73|1057->28|1086->117|1126->123|1139->129|1265->246|1305->248|1346->255|1358->260|1404->285|1445->292|1476->315|1494->325|1541->335|1662->420|1676->425|1706->433|1747->443|1866->526|1919->570|1959->572|2001->582|2120->666|2262->785|2315->803|2350->829|2369->839|2417->849|2485->881|2499->886|2529->894|2573->907|2810->1113|2848->1116|2863->1123|2893->1131|2949->1159|2978->1160|3056->1211|3084->1212
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|35->7|35->7|35->7|37->9|37->9|37->9|37->9|38->10|38->10|38->10|39->11|43->15|43->15|43->15|43->15|45->17|45->17|47->19|47->19|47->19|47->19|48->20|48->20|48->20|49->21|58->30|59->31|59->31|59->31|61->33|61->33|63->35|63->35
                    -- GENERATED --
                */
            