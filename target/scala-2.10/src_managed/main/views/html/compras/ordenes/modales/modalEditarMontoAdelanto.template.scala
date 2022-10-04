
package views.html.compras.ordenes.modales

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
object modalEditarMontoAdelanto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[DynamicForm,Long,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm,id:Long):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.37*/("""
"""),format.raw/*3.70*/(""" 
																			
"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.compras.routes.OrdenesAccionesController.editarMontoAdelanto(), 'id -> "formEditarMontoAdelanto")/*5.132*/ {_display_(Seq[Any](format.raw/*5.134*/("""	
	
	"""),_display_(Seq[Any](/*7.3*/views/*7.8*/.html.tags.successError())),format.raw/*7.33*/("""
	<div class="row">
		<div class="col-sm-3">
			<div class="form-group">
				<label for="monto_adelanto_modal" class="control-label">Monto Adelanto</label> 
				<input name="monto_adelanto_modal" id="monto_adelanto_modal" class="form-control date"/>
				<input name="id_orden" id="id_orden" type="hidden" value=""""),_display_(Seq[Any](/*13.64*/id)),format.raw/*13.66*/(""""/>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-5"><br />
			<button type="submit" class="btn btn-default" title="Editar Monto Adelanto"><i class="glyphicon glyphicon-arrow-right"></i> 
			Editar</button>
		</div>
	</div>

""")))})),format.raw/*24.2*/("""
<script>
$( function()"""),format.raw/*26.14*/("""{"""),format.raw/*26.15*/("""
	/*$("#monto_adelanto_modal").mask("99/99/9999");*/
"""),format.raw/*28.1*/("""}"""),format.raw/*28.2*/(""");
</script>
"""),_display_(Seq[Any](/*30.2*/flash()/*30.9*/.clear())))}
    }
    
    def render(formBuscador:DynamicForm,id:Long): play.api.templates.HtmlFormat.Appendable = apply(formBuscador,id)
    
    def f:((DynamicForm,Long) => play.api.templates.HtmlFormat.Appendable) = (formBuscador,id) => apply(formBuscador,id)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:44 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/ordenes/modales/modalEditarMontoAdelanto.scala.html
                    HASH: f26c59c61f861b373cca44a939a7f1d92addc8fa
                    MATRIX: 827->1|964->55|996->79|1070->36|1098->123|1155->146|1168->152|1301->276|1341->278|1381->284|1393->289|1439->314|1788->627|1812->629|2090->876|2141->899|2170->900|2250->953|2278->954|2327->968|2342->975
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|35->7|35->7|35->7|41->13|41->13|52->24|54->26|54->26|56->28|56->28|58->30|58->30
                    -- GENERATED --
                */
            