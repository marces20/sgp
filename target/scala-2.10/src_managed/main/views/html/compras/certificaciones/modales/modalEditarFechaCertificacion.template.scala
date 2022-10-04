
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
object modalEditarFechaCertificacion extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.29*/("""
"""),format.raw/*3.70*/(""" 
																			
"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.compras.routes.CertificacionesAccionesController.editarFechaCertificacionMasivo(), 'id -> "formCargarFecharCertificacion")/*5.157*/ {_display_(Seq[Any](format.raw/*5.159*/("""	
	
	"""),_display_(Seq[Any](/*7.3*/if(flash.containsKey("error"))/*7.33*/ {_display_(Seq[Any](format.raw/*7.35*/("""
		<div class="alert alert-danger"><i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*8.84*/flash/*8.89*/.get("error"))),format.raw/*8.102*/("""</div>
	""")))})),format.raw/*9.3*/("""
	
	"""),_display_(Seq[Any](/*11.3*/if(flash.containsKey("success"))/*11.35*/ {_display_(Seq[Any](format.raw/*11.37*/("""
		<div class="alert alert-success"><i class="glyphicon glyphicon-ok-circle"></i> """),_display_(Seq[Any](/*12.83*/flash/*12.88*/.get("success"))),format.raw/*12.103*/("""</div>
	""")))})),format.raw/*13.3*/("""
	<div class="row">
		<div class="col-sm-3">
			<div class="form-group">
				<label for="fecha_certificacion_modal" class="control-label">Fecha Certificacion</label> 
				<input name="fecha_certificacion_modal" id="fecha_certificacion_modal" class="form-control date"/>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-5"><br />
			<button type="submit" class="btn btn-default" title="Agregar Fecha Certificacion">
			<i class="glyphicon glyphicon-arrow-right"></i> Editar Fecha Certificacion</button>
		</div>
	</div>

""")))})),format.raw/*29.2*/("""
<script>
$( function()"""),format.raw/*31.14*/("""{"""),format.raw/*31.15*/("""
	$("#fecha_certificacion_modal").mask("99/99/9999");
"""),format.raw/*33.1*/("""}"""),format.raw/*33.2*/(""");
</script>
"""),_display_(Seq[Any](/*35.2*/flash()/*35.9*/.clear())))}
    }
    
    def render(formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(formBuscador)
    
    def f:((DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (formBuscador) => apply(formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:43 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/certificaciones/modales/modalEditarFechaCertificacion.scala.html
                    HASH: 2aa672790bc8839fd626a2d762e1c90162895218
                    MATRIX: 835->1|964->47|996->71|1070->28|1098->115|1155->138|1168->144|1326->293|1366->295|1406->301|1444->331|1483->333|1602->417|1615->422|1650->435|1689->444|1729->449|1770->481|1810->483|1929->566|1943->571|1981->586|2021->595|2591->1134|2642->1157|2671->1158|2752->1212|2780->1213|2829->1227|2844->1234
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|35->7|35->7|35->7|36->8|36->8|36->8|37->9|39->11|39->11|39->11|40->12|40->12|40->12|41->13|57->29|59->31|59->31|61->33|61->33|63->35|63->35
                    -- GENERATED --
                */
            