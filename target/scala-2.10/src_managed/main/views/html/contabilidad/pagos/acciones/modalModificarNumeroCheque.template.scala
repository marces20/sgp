
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
object modalModificarNumeroCheque extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.29*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.contabilidad.routes.PagosAccionesController.modificarNumeroCheque(), 'id -> "formModificarNumeroCheque")/*5.139*/ {_display_(Seq[Any](format.raw/*5.141*/("""
	
	"""),_display_(Seq[Any](/*7.3*/views/*7.8*/.html.tags.successError())),format.raw/*7.33*/("""
	
	"""),_display_(Seq[Any](/*9.3*/formBuscador("id_pago")/*9.26*/.error.map/*9.36*/{ error =>_display_(Seq[Any](format.raw/*9.46*/("""
		<div class="alert alert-danger"><i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*10.84*/error/*10.89*/.message)),format.raw/*10.97*/("""</div>
	""")))})),format.raw/*11.3*/("""
	
	<div id="alert-success" class="alert alert-success hide"></div>
	<div id="alert-danger" class="alert alert-danger hide"></div>
	
	<div class="row">
		<div class="col-sm-3">
			<div class="form-group """),_display_(Seq[Any](/*18.28*/if(formBuscador.error("numero_cheque") != null)/*18.75*/ {_display_(Seq[Any](format.raw/*18.77*/("""has-error""")))}/*18.87*/else/*18.91*/{_display_(Seq[Any](format.raw/*18.92*/("""has-required""")))})),format.raw/*18.105*/("""">
				<label for="inputFechaPago" class="control-label">N° Cheque</label> 
				"""),_display_(Seq[Any](/*20.6*/inputText(formBuscador("numero_cheque"), 'class -> "form-control", 'id -> "numero_cheque", 'autofocus -> "autofocus"))),format.raw/*20.123*/("""
			</div>
				"""),_display_(Seq[Any](/*22.6*/formBuscador("numero_cheque")/*22.35*/.error.map/*22.45*/{ error =>_display_(Seq[Any](format.raw/*22.55*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*23.31*/error/*23.36*/.message)),format.raw/*23.44*/("""</div>
				""")))})),format.raw/*24.6*/("""
		</div>
		
		<div class="col-sm-5"><br />
			<button type="submit" class="btn btn-default" title="Guardar"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>
		</div>
		
	</div>
""")))})),format.raw/*32.2*/("""
"""),_display_(Seq[Any](/*33.2*/flash()/*33.9*/.clear())))}
    }
    
    def render(formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(formBuscador)
    
    def f:((DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (formBuscador) => apply(formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:38 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/pagos/acciones/modalModificarNumeroCheque.scala.html
                    HASH: 2f4a0a6a75e3c3ae6f43d2ad00a393c9b6ae673f
                    MATRIX: 828->1|957->47|989->71|1063->28|1091->115|1129->119|1142->125|1282->256|1322->258|1361->263|1373->268|1419->293|1458->298|1489->321|1507->331|1554->341|1674->425|1688->430|1718->438|1758->447|1998->651|2054->698|2094->700|2123->710|2136->714|2175->715|2221->728|2337->809|2477->926|2528->942|2566->971|2585->981|2633->991|2700->1022|2714->1027|2744->1035|2787->1047|3013->1242|3050->1244|3065->1251
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|35->7|35->7|35->7|37->9|37->9|37->9|37->9|38->10|38->10|38->10|39->11|46->18|46->18|46->18|46->18|46->18|46->18|46->18|48->20|48->20|50->22|50->22|50->22|50->22|51->23|51->23|51->23|52->24|60->32|61->33|61->33
                    -- GENERATED --
                */
            