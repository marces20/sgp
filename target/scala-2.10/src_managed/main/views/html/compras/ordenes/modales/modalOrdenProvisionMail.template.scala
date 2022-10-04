
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
object modalOrdenProvisionMail extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[DynamicForm,Long,List[DireccionProveedor],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm,ordenId:Long,lista: List[DireccionProveedor]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.74*/("""
"""),format.raw/*3.70*/(""" 
"""),format.raw/*6.1*/("""<div class="row" id="div-actualizar-mail-proveedor">
"""),_display_(Seq[Any](/*7.2*/views/*7.7*/.html.tags.successError())),format.raw/*7.32*/("""
"""),_display_(Seq[Any](/*8.2*/if(lista != null)/*8.19*/{_display_(Seq[Any](format.raw/*8.20*/("""
<table class="table table-striped table-bordered">
	<thead>
		<tr>
		    <th>Email</th>
		    <th>Fecha Actual.</th>
		    <th colspan="2" ></th>
		  </tr>
	</thead>
	<tbody>
		"""),_display_(Seq[Any](/*18.4*/for(linea <- lista) yield /*18.23*/ {_display_(Seq[Any](format.raw/*18.25*/("""
			<tr> 
  				<td>
  					<input size="40" type="text" name="email" value=""""),_display_(Seq[Any](/*21.58*/linea/*21.63*/.email)),format.raw/*21.69*/("""" />
  					<input type="hidden" name="id_direccion" value=""""),_display_(Seq[Any](/*22.57*/linea/*22.62*/.id)),format.raw/*22.65*/("""" />
  					<input type="hidden" name="ordenId" value=""""),_display_(Seq[Any](/*23.52*/ordenId)),format.raw/*23.59*/("""" />
  				</td>
		    	<td>
		    		<input size="10" readonly="readonly" type="text" name="fecha_actualizacion" value=""""),_display_(Seq[Any](/*26.93*/DateUtils/*26.102*/.formatDate(linea.getFechaActualizacion()))),format.raw/*26.144*/("""" />
		    	</td>
		    	<td>
		    		<a  id="" data-url=""""),_display_(Seq[Any](/*29.30*/controllers/*29.41*/.compras.routes.ProveedoresAccionesController.actualizarMail())),format.raw/*29.103*/("""" class="btn btn-default actualizarMailProveedorOrden">
					<i class="glyphicon glyphicon-arrow-right"></i> Actualizar Mail</a>
				</td>
		    	<td>
		    		<a  id="" data-url=""""),_display_(Seq[Any](/*33.30*/controllers/*33.41*/.compras.routes.OrdenesAccionesController.enviarOrdenMail())),format.raw/*33.100*/("""" class="btn btn-default enviarMailOrden">
		    		<i class="glyphicon glyphicon-envelope"></i> Enviar Mail</a>
				</td>
		  	</tr>
		""")))})),format.raw/*37.4*/("""
	</tbody>
</table>
""")))})),format.raw/*40.2*/("""
</div>
"""),_display_(Seq[Any](/*42.2*/flash()/*42.9*/.clear())),format.raw/*42.17*/("""

"""))}
    }
    
    def render(formBuscador:DynamicForm,ordenId:Long,lista:List[DireccionProveedor]): play.api.templates.HtmlFormat.Appendable = apply(formBuscador,ordenId,lista)
    
    def f:((DynamicForm,Long,List[DireccionProveedor]) => play.api.templates.HtmlFormat.Appendable) = (formBuscador,ordenId,lista) => apply(formBuscador,ordenId,lista)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:44 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/ordenes/modales/modalOrdenProvisionMail.scala.html
                    HASH: 912880fb9f3112415086cdc968c5342baf30de6a
                    MATRIX: 851->1|1063->92|1095->116|1169->73|1197->160|1225->200|1313->254|1325->259|1371->284|1407->286|1432->303|1470->304|1684->483|1719->502|1759->504|1873->582|1887->587|1915->593|2012->654|2026->659|2051->662|2143->718|2172->725|2329->846|2348->855|2413->897|2508->956|2528->967|2613->1029|2829->1209|2849->1220|2931->1279|3098->1415|3150->1436|3194->1445|3209->1452|3239->1460
                    LINES: 26->1|33->3|33->3|34->1|35->3|36->6|37->7|37->7|37->7|38->8|38->8|38->8|48->18|48->18|48->18|51->21|51->21|51->21|52->22|52->22|52->22|53->23|53->23|56->26|56->26|56->26|59->29|59->29|59->29|63->33|63->33|63->33|67->37|70->40|72->42|72->42|72->42
                    -- GENERATED --
                */
            