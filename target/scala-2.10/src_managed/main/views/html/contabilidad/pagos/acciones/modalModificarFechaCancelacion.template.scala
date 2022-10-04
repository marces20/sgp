
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
object modalModificarFechaCancelacion extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.29*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.contabilidad.routes.PagosAccionesController.modificarFechaCancelacion(), 'id -> "formModificarFechaCancelacion")/*5.147*/ {_display_(Seq[Any](format.raw/*5.149*/("""
	
	"""),_display_(Seq[Any](/*7.3*/views/*7.8*/.html.tags.successError())),format.raw/*7.33*/("""
	
	"""),_display_(Seq[Any](/*9.3*/formBuscador("id_pago")/*9.26*/.error.map/*9.36*/{ error =>_display_(Seq[Any](format.raw/*9.46*/("""
		<div class="alert alert-danger"><i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*10.84*/error/*10.89*/.message)),format.raw/*10.97*/("""</div>
	""")))})),format.raw/*11.3*/("""		
				
	<div class="row">
		<div class="col-sm-3">
			<div class="form-group """),_display_(Seq[Any](/*15.28*/if(formBuscador.error("fecha_cancelacion") != null)/*15.79*/ {_display_(Seq[Any](format.raw/*15.81*/("""has-error""")))})),format.raw/*15.91*/("""">
				<label for="inputFechaCancelacion" class="control-label">Fecha Cancelacion</label> 
				"""),_display_(Seq[Any](/*17.6*/inputText(formBuscador("fecha_cancelacion"), 'class -> "form-control", 'id -> "fechaParaModificarCancelacion", 'autofocus -> "autofocus"))),format.raw/*17.143*/("""
			</div>
				"""),_display_(Seq[Any](/*19.6*/formBuscador("fecha_cancelacion")/*19.39*/.error.map/*19.49*/{ error =>_display_(Seq[Any](format.raw/*19.59*/("""
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
	 $('#fechaParaModificarCancelacion').mask("99/99/9999");
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
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/pagos/acciones/modalModificarFechaCancelacion.scala.html
                    HASH: 062ae4a3c54b59376ab5ade27f6189d475f48386
                    MATRIX: 832->1|961->47|993->71|1067->28|1095->115|1133->119|1146->125|1294->264|1334->266|1373->271|1385->276|1431->301|1470->306|1501->329|1519->339|1566->349|1686->433|1700->438|1730->446|1770->455|1885->534|1945->585|1985->587|2027->597|2158->693|2318->830|2369->846|2411->879|2430->889|2478->899|2545->930|2559->935|2589->943|2632->955|2862->1154|2899->1156|2914->1163|2944->1171|2998->1197|3027->1198|3114->1258|3142->1259
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|35->7|35->7|35->7|37->9|37->9|37->9|37->9|38->10|38->10|38->10|39->11|43->15|43->15|43->15|43->15|45->17|45->17|47->19|47->19|47->19|47->19|48->20|48->20|48->20|49->21|58->30|59->31|59->31|59->31|61->33|61->33|63->35|63->35
                    -- GENERATED --
                */
            