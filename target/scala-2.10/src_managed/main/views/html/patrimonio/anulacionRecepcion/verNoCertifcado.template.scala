
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
object verNoCertifcado extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Long,List[CertificacionServicioLinea],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(idOrdenCompra: Long, lineas: List[CertificacionServicioLinea]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import java.math.BigDecimal;var total=new java.math.BigDecimal(0);


Seq[Any](format.raw/*1.65*/("""
"""),format.raw/*3.1*/("""<div id="listaLineaProductos" class="contenedorPaginador ajaxPaginador">
 
		"""),_display_(Seq[Any](/*5.4*/if(lineas.size() > 0)/*5.25*/{_display_(Seq[Any](format.raw/*5.26*/("""  
		<table id="listaProductosAnulados" class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th>Producto</th>
					<th width="50">Cantidad</th>	
					<th width="100">Unitario</th>	
					<th width="100">Total</th>	
				</tr>
			</thead>
			<tbody>
		        """),_display_(Seq[Any](/*16.12*/for(linea <- lineas) yield /*16.32*/ {_display_(Seq[Any](format.raw/*16.34*/("""
					<tr class="pointer">
						<td>"""),_display_(Seq[Any](/*18.12*/linea/*18.17*/.producto.nombre)),format.raw/*18.33*/("""</td>
						<td>"""),_display_(Seq[Any](/*19.12*/linea/*19.17*/.cantidad)),format.raw/*19.26*/("""</td>
						<td>"""),_display_(Seq[Any](/*20.12*/utils/*20.17*/.NumberUtils.moneda(linea.precio))),format.raw/*20.50*/("""</td>
						<td>"""),_display_(Seq[Any](/*21.12*/utils/*21.17*/.NumberUtils.moneda(linea.precio.multiply(linea.cantidad)))),format.raw/*21.75*/("""</td>
					</tr>
					"""),_display_(Seq[Any](/*23.7*/{total = total.add(linea.precio.multiply(linea.cantidad))})),format.raw/*23.65*/("""
              	""")))})),format.raw/*24.17*/("""
			</tbody>
			<tfoot>
				<tr class="pointer">
					<td colspan="3" align="right">TOTAL</td>
					<td>"""),_display_(Seq[Any](/*29.11*/utils/*29.16*/.NumberUtils.moneda(total))),format.raw/*29.42*/("""</td>
				</tr>
			</tfoot>
		</table>
		""")))})),format.raw/*33.4*/("""		

</div> """))}
    }
    
    def render(idOrdenCompra:Long,lineas:List[CertificacionServicioLinea]): play.api.templates.HtmlFormat.Appendable = apply(idOrdenCompra,lineas)
    
    def f:((Long,List[CertificacionServicioLinea]) => play.api.templates.HtmlFormat.Appendable) = (idOrdenCompra,lineas) => apply(idOrdenCompra,lineas)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/anulacionRecepcion/verNoCertifcado.scala.html
                    HASH: 169870f4c91a2c028cf7ab4b8a912c8952ec3c7c
                    MATRIX: 845->1|1069->64|1096->133|1208->211|1237->232|1275->233|1598->520|1634->540|1674->542|1748->580|1762->585|1800->601|1853->618|1867->623|1898->632|1951->649|1965->654|2020->687|2073->704|2087->709|2167->767|2225->790|2305->848|2354->865|2495->970|2509->975|2557->1001|2630->1043
                    LINES: 26->1|30->1|31->3|33->5|33->5|33->5|44->16|44->16|44->16|46->18|46->18|46->18|47->19|47->19|47->19|48->20|48->20|48->20|49->21|49->21|49->21|51->23|51->23|52->24|57->29|57->29|57->29|61->33
                    -- GENERATED --
                */
            