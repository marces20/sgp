
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
object modalEditarCotDolar extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[DynamicForm,Long,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm,id:Long):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.37*/("""
"""),format.raw/*3.70*/(""" 
																			
"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.compras.routes.OrdenesAccionesController.editarCotDolar(), 'id -> "formEditarCotDolar")/*5.122*/ {_display_(Seq[Any](format.raw/*5.124*/("""	
	
	"""),_display_(Seq[Any](/*7.3*/views/*7.8*/.html.tags.successError())),format.raw/*7.33*/("""
	<div class="row">
		<div class="col-sm-3">
			<div class="form-group">
				<label for="monto_adelanto_modal" class="control-label">Cotizacion Dolar</label> 
				<input name="monto_adelanto_modal" id="monto_adelanto_modal" class="form-control date"/>
				<input name="id_orden" id="id_orden" type="hidden" value=""""),_display_(Seq[Any](/*13.64*/id)),format.raw/*13.66*/(""""/>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-5"><br />
			<button type="submit" class="btn btn-default" title="Editar cotizacion Dolar"><i class="glyphicon glyphicon-arrow-right"></i> 
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
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/ordenes/modales/modalEditarCotDolar.scala.html
                    HASH: 4b1b822ee356f882fe8308640a2dbdc42871e15f
                    MATRIX: 822->1|959->55|991->79|1065->36|1093->123|1150->146|1163->152|1286->266|1326->268|1366->274|1378->279|1424->304|1775->619|1799->621|2079->870|2130->893|2159->894|2239->947|2267->948|2316->962|2331->969
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|35->7|35->7|35->7|41->13|41->13|52->24|54->26|54->26|56->28|56->28|58->30|58->30
                    -- GENERATED --
                */
            