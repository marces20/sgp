
package views.html.contabilidad.facturas.acciones

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
object modalCargar349 extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[DynamicForm,Long,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm,idFactura:Long):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.44*/("""
"""),format.raw/*3.70*/(""" 
																			
"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.contabilidad.routes.FacturasAccionesController.cargar349(), 'id -> "formCargar349")/*5.118*/ {_display_(Seq[Any](format.raw/*5.120*/("""	
	
	"""),_display_(Seq[Any](/*7.3*/views/*7.8*/.html.tags.successError())),format.raw/*7.33*/("""
	<input type="hidden" name="id" value=""""),_display_(Seq[Any](/*8.41*/idFactura)),format.raw/*8.50*/("""" />
	<div class="row">
		<div class="col-sm-4">
			<div class="form-group">
				<label for="fecha_349" class="control-label">Fecha vencimiento 349</label> 
				<input name="fecha_349" id="fecha_349" class="form-control date"/>
			</div>
		</div>
		<div class="col-sm-3">
			<div class="form-group">
				<label for="nui" class="control-label">NUI</label> 
				<input name="nui" id="nui" class="form-control"/>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-5"><br />
			<button type="submit" class="btn btn-default" title="Cargar 349"><i class="glyphicon glyphicon-arrow-right"></i> Cargar</button>
		</div>
	</div>

""")))})),format.raw/*29.2*/("""
<script>
$( function()"""),format.raw/*31.14*/("""{"""),format.raw/*31.15*/("""
	$("#fecha_349").mask("99/99/9999");
"""),format.raw/*33.1*/("""}"""),format.raw/*33.2*/(""");
</script>
"""),_display_(Seq[Any](/*35.2*/flash()/*35.9*/.clear())))}
    }
    
    def render(formBuscador:DynamicForm,idFactura:Long): play.api.templates.HtmlFormat.Appendable = apply(formBuscador,idFactura)
    
    def f:((DynamicForm,Long) => play.api.templates.HtmlFormat.Appendable) = (formBuscador,idFactura) => apply(formBuscador,idFactura)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:40 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/facturas/acciones/modalCargar349.scala.html
                    HASH: e94942430db801b1d8878b18a2e1edc63c88b83a
                    MATRIX: 824->1|968->62|1000->86|1074->43|1102->130|1159->153|1172->159|1291->269|1331->271|1371->277|1383->282|1429->307|1505->348|1535->357|2204->995|2255->1018|2284->1019|2349->1057|2377->1058|2426->1072|2441->1079
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|35->7|35->7|35->7|36->8|36->8|57->29|59->31|59->31|61->33|61->33|63->35|63->35
                    -- GENERATED --
                */
            