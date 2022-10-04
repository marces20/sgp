
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
object modalModificarTipoPago extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.29*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.contabilidad.routes.PagosAccionesController.modificarTipoPago(), 'id -> "formModificarTipoPago")/*5.131*/ {_display_(Seq[Any](format.raw/*5.133*/("""
	
	"""),_display_(Seq[Any](/*7.3*/views/*7.8*/.html.tags.successError())),format.raw/*7.33*/("""
	
	"""),_display_(Seq[Any](/*9.3*/formBuscador("id_pago")/*9.26*/.error.map/*9.36*/{ error =>_display_(Seq[Any](format.raw/*9.46*/("""
		<div class="alert alert-danger"><i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*10.84*/error/*10.89*/.message)),format.raw/*10.97*/("""</div>
	""")))})),format.raw/*11.3*/("""
	
	<div id="alert-success" class="alert alert-success hide"></div>
	<div id="alert-danger" class="alert alert-danger hide"></div>
	
	<div class="row">
		<div class="col-sm-3">
			<div class="form-group """),_display_(Seq[Any](/*18.28*/if(formBuscador.error("tipo_pago") != null)/*18.71*/ {_display_(Seq[Any](format.raw/*18.73*/("""has-error""")))})),format.raw/*18.83*/("""">
				<label for="tipo_pago" class="control-label">Tipo de Pago</label>
				"""),_display_(Seq[Any](/*20.6*/select(formBuscador("tipo_pago"), options("transferencia"->"Macro Online","transferenciaMacroProveedores"->"Macro Proveedores","transferenciaInterbanking"->"Interbanking","cheque"->"Cheque","debito"->"Debito"),'id -> "tipoPago", 'class -> "form-control select"))),format.raw/*20.267*/("""
			</div>
		</div>
		
		<div class="col-sm-5"><br />
			<button type="submit" class="btn btn-default" title="Guardar"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>
		</div>
		
	</div>
""")))})),format.raw/*29.2*/("""
"""),_display_(Seq[Any](/*30.2*/flash()/*30.9*/.clear())))}
    }
    
    def render(formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(formBuscador)
    
    def f:((DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (formBuscador) => apply(formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:38 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/pagos/acciones/modalModificarTipoPago.scala.html
                    HASH: 990331200b8f40bbcc451ca8b8f41c2d8b2320c5
                    MATRIX: 824->1|953->47|985->71|1059->28|1087->115|1125->119|1138->125|1270->248|1310->250|1349->255|1361->260|1407->285|1446->290|1477->313|1495->323|1542->333|1662->417|1676->422|1706->430|1746->439|1986->643|2038->686|2078->688|2120->698|2233->776|2517->1037|2753->1242|2790->1244|2805->1251
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|35->7|35->7|35->7|37->9|37->9|37->9|37->9|38->10|38->10|38->10|39->11|46->18|46->18|46->18|46->18|48->20|48->20|57->29|58->30|58->30
                    -- GENERATED --
                */
            