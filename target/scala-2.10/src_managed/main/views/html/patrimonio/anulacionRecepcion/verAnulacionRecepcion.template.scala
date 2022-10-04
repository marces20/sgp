
package views.html.patrimonio.anulacionRecepcion

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
object verAnulacionRecepcion extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Long,List[OrdenLineaAnulacion],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(idOrdenCompra: Long, lineas: List[OrdenLineaAnulacion]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import java.math.BigDecimal;var total=new java.math.BigDecimal(0);


Seq[Any](format.raw/*1.58*/("""
"""),format.raw/*3.1*/("""<div id="listaLineaProductos" class="contenedorPaginador ajaxPaginador">

		 """),_display_(Seq[Any](/*5.5*/if(lineas.size() > 0)/*5.26*/{_display_(Seq[Any](format.raw/*5.27*/("""   
		<table id="listaProductosAnulados" class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th>Producto</th>
					<th width="50">Cantidad</th>	
					<th width="50">UDM</th>	
					<th width="100">Unitario</th>	
					<th width="100">Total</th>	
				</tr>
			</thead>
			<tbody>
		        """),_display_(Seq[Any](/*17.12*/for(linea <- lineas) yield /*17.32*/ {_display_(Seq[Any](format.raw/*17.34*/("""
					<tr class="pointer">
						<td>"""),_display_(Seq[Any](/*19.12*/linea/*19.17*/.ordenLinea.producto.nombre)),format.raw/*19.44*/("""</td>
						<td>"""),_display_(Seq[Any](/*20.12*/linea/*20.17*/.cantidad)),format.raw/*20.26*/("""</td>
						<td>"""),_display_(Seq[Any](/*21.12*/linea/*21.17*/.ordenLinea.udm.nombre)),format.raw/*21.39*/("""</td>
						<td>"""),_display_(Seq[Any](/*22.12*/utils/*22.17*/.NumberUtils.moneda(linea.ordenLinea.precio))),format.raw/*22.61*/("""</td>
						<td>"""),_display_(Seq[Any](/*23.12*/utils/*23.17*/.NumberUtils.moneda(linea.ordenLinea.precio.multiply(linea.cantidad)))),format.raw/*23.86*/("""</td>
					</tr>
					"""),_display_(Seq[Any](/*25.7*/{total = total.add(linea.ordenLinea.precio.multiply(linea.cantidad))})),format.raw/*25.76*/("""
              	""")))})),format.raw/*26.17*/("""
			</tbody>
			<tfoot>
				<tr class="pointer">
					<td colspan="4" align="right">TOTAL</td>
					<td>"""),_display_(Seq[Any](/*31.11*/utils/*31.16*/.NumberUtils.moneda(total))),format.raw/*31.42*/("""</td>
				</tr>
			</tfoot>
		</table>
		""")))})),format.raw/*35.4*/("""

</div>    """))}
    }
    
    def render(idOrdenCompra:Long,lineas:List[OrdenLineaAnulacion]): play.api.templates.HtmlFormat.Appendable = apply(idOrdenCompra,lineas)
    
    def f:((Long,List[OrdenLineaAnulacion]) => play.api.templates.HtmlFormat.Appendable) = (idOrdenCompra,lineas) => apply(idOrdenCompra,lineas)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/anulacionRecepcion/verAnulacionRecepcion.scala.html
                    HASH: e07dfd84bddb858fb66a1410f1af024bde0b3267
                    MATRIX: 844->1|1062->57|1090->128|1204->208|1233->229|1271->230|1637->560|1673->580|1713->582|1789->622|1803->627|1852->654|1906->672|1920->677|1951->686|2005->704|2019->709|2063->731|2117->749|2131->754|2197->798|2251->816|2265->821|2356->890|2416->915|2507->984|2557->1002|2703->1112|2717->1117|2765->1143|2842->1189
                    LINES: 26->1|30->1|31->3|33->5|33->5|33->5|45->17|45->17|45->17|47->19|47->19|47->19|48->20|48->20|48->20|49->21|49->21|49->21|50->22|50->22|50->22|51->23|51->23|51->23|53->25|53->25|54->26|59->31|59->31|59->31|63->35
                    -- GENERATED --
                */
            