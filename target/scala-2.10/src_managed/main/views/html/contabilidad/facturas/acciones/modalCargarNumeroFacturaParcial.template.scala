
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
object modalCargarNumeroFacturaParcial extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.29*/("""
"""),format.raw/*3.70*/(""" 
																			
"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.contabilidad.routes.FacturasAccionesController.cargarNumeroFacturaParcial(), 'id -> "formCargarNumeroFacturaParcial")/*5.152*/ {_display_(Seq[Any](format.raw/*5.154*/("""	
	
	"""),_display_(Seq[Any](/*7.3*/views/*7.8*/.html.tags.successError())),format.raw/*7.33*/("""
	<div class="row">
		<div class="col-sm-3">
			<div class="form-group">
				<label for="nfactura_modal" class="control-label">N° Factura</label> 
				<input name="nfactura_modal" id="nfactura_modal" class="form-control date"/>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-5"><br />
			<button type="submit" class="btn btn-default" title="Agregar N° Factura"><i class="glyphicon glyphicon-arrow-right"></i> Cargar N° Factura</button>
		</div>
	</div>

""")))})),format.raw/*22.2*/("""
<script>
$( function()"""),format.raw/*24.14*/("""{"""),format.raw/*24.15*/(""" $('#nfactura_modal').mask("a-9999-99999999");"""),format.raw/*24.61*/("""}"""),format.raw/*24.62*/(""")
</script>
"""),_display_(Seq[Any](/*26.2*/flash()/*26.9*/.clear())))}
    }
    
    def render(formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(formBuscador)
    
    def f:((DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (formBuscador) => apply(formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:40 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/facturas/acciones/modalCargarNumeroFacturaParcial.scala.html
                    HASH: 48a8bbf3fd1818e01520110def4226efa512a8fd
                    MATRIX: 836->1|965->47|997->71|1071->28|1099->115|1156->138|1169->144|1322->288|1362->290|1402->296|1414->301|1460->326|1966->801|2017->824|2046->825|2120->871|2149->872|2197->885|2212->892
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|35->7|35->7|35->7|50->22|52->24|52->24|52->24|52->24|54->26|54->26
                    -- GENERATED --
                */
            