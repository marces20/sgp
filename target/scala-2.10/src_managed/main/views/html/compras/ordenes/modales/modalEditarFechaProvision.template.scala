
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
object modalEditarFechaProvision extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[DynamicForm,Long,Orden,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm,id:Long,orden: Orden):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.50*/("""
"""),format.raw/*3.70*/(""" 
																			
"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.compras.routes.OrdenesAccionesController.editarFechaProvision(), 'id -> "formEditarFechaProvision")/*5.134*/ {_display_(Seq[Any](format.raw/*5.136*/("""	
	
	"""),_display_(Seq[Any](/*7.3*/views/*7.8*/.html.tags.successError())),format.raw/*7.33*/("""
	<div class="row">
		<div class="col-sm-3">
			<div class="form-group">
				<label for="fecha_modal" class="control-label">Fecha</label> 
				<input name="fecha_modal" id="fecha_modal" class="form-control date"/>
				<input name="id_orden" id="id_orden" type="hidden" value=""""),_display_(Seq[Any](/*13.64*/id)),format.raw/*13.66*/(""""/>
			</div>
		</div>
		<div class="col-sm-5">
			 
			<span style="color:red;font-weight: bold;">Fecha Expediente - """),_display_(Seq[Any](/*18.67*/(utils.DateUtils.formatDate(orden.expediente.fecha)))),format.raw/*18.119*/("""</span>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-5"><br />
			<button type="submit" class="btn btn-default" title="Editar Fecha Provision"><i class="glyphicon glyphicon-arrow-right"></i> 
			Editar</button>
		</div>
	</div>

""")))})),format.raw/*28.2*/("""
<script>
$( function()"""),format.raw/*30.14*/("""{"""),format.raw/*30.15*/("""
	$("#fecha_modal").mask("99/99/9999");
"""),format.raw/*32.1*/("""}"""),format.raw/*32.2*/(""");
</script>
"""),_display_(Seq[Any](/*34.2*/flash()/*34.9*/.clear())))}
    }
    
    def render(formBuscador:DynamicForm,id:Long,orden:Orden): play.api.templates.HtmlFormat.Appendable = apply(formBuscador,id,orden)
    
    def f:((DynamicForm,Long,Orden) => play.api.templates.HtmlFormat.Appendable) = (formBuscador,id,orden) => apply(formBuscador,id,orden)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:44 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/ordenes/modales/modalEditarFechaProvision.scala.html
                    HASH: 861c847fd523b4a495c70b5a7e02c830272e3e1a
                    MATRIX: 834->1|984->68|1016->92|1090->49|1118->136|1175->159|1188->165|1323->291|1363->293|1403->299|1415->304|1461->329|1774->606|1798->608|1953->727|2028->779|2301->1021|2352->1044|2381->1045|2448->1085|2476->1086|2525->1100|2540->1107
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|35->7|35->7|35->7|41->13|41->13|46->18|46->18|56->28|58->30|58->30|60->32|60->32|62->34|62->34
                    -- GENERATED --
                */
            