
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
object indexAnulacionRecepcion extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Long,List[OrdenLineaAnulacion],List[Factura],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(idOrdenCompra: Long, lineas: List[OrdenLineaAnulacion],listaFacturas:List[Factura]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import models.auth._

import utils._

import java.math.BigDecimal;var total=new java.math.BigDecimal(0);

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.86*/("""
"""),format.raw/*5.70*/(""" 
"""),format.raw/*7.1*/("""<div id="listaLineaProductos" class="contenedorPaginador ajaxPaginador">

"""),_display_(Seq[Any](/*9.2*/if(Permiso.check("anulacionRecepcionProductosCrear"))/*9.55*/ {_display_(Seq[Any](format.raw/*9.57*/("""
<p><a class="btn btn-default btn-xs" href=""""),_display_(Seq[Any](/*10.45*/controllers/*10.56*/.patrimonio.routes.AnulacionRecepcionProductosController.crear(idOrdenCompra))),format.raw/*10.133*/("""" id="nuevoProducto"><i class="glyphicon glyphicon-plus"></i> Nuevo</a></p>
""")))})),format.raw/*11.2*/("""
		"""),_display_(Seq[Any](/*12.4*/if(listaFacturas.size() > 0)/*12.32*/{_display_(Seq[Any](format.raw/*12.33*/("""
			<p style="font-weight:bold;font-size:20px; color:red;">ESTA ORDEN POSEE FACTURAS O PAGOS EN PROCESO !!!</p>	
		""")))})),format.raw/*14.4*/("""  
		<table id="listaProductosAnulados" class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th width="30">
						<input type="checkbox" name="checkAllLineaAnulacion"  data-check=".data-check-linea-anulacion"  id="checkAllLineaAnulacion"/>
					</th>
					<th>Producto</th>
					<th>Cantidad</th>	
					<th>UDM</th>	
					<th>Unitario</th>	
					<th>Total</th>
					<th>Observacion</th>
					<th>Pacientes</th>
					 		
				</tr>
			</thead>
			<tbody>
		        """),_display_(Seq[Any](/*32.12*/for(linea <- lineas) yield /*32.32*/ {_display_(Seq[Any](format.raw/*32.34*/("""
					"""),_display_(Seq[Any](/*33.7*/views/*33.12*/.html.patrimonio.anulacionRecepcion.lineaProducto(linea))),format.raw/*33.68*/("""
					"""),_display_(Seq[Any](/*34.7*/{total = total.add(linea.getTotal())})),format.raw/*34.44*/("""
              	""")))})),format.raw/*35.17*/("""
			</tbody>
			<tfoot>
				<tr>
					<td colspan="5" align="right">TOTAL</td>
					<td align="center" class="totalAnuladoFooter">"""),_display_(Seq[Any](/*40.53*/utils/*40.58*/.NumberUtils.moneda(total))),format.raw/*40.84*/("""</td>
					<td colspan="2"></td>
				</tr>
			</tfoot>
		</table>
</div>    
<script>
	$( function()"""),format.raw/*47.15*/("""{"""),format.raw/*47.16*/("""
		
		 
		
		$('#checkAllLineaAnulacion').on('change', function()"""),format.raw/*51.55*/("""{"""),format.raw/*51.56*/("""
			var c = $(this).prop("checked");
			var target = $(this).attr('data-check');
			if(c) $(target).prop( "checked", true );
			else $(target).prop( "checked", false );
		"""),format.raw/*56.3*/("""}"""),format.raw/*56.4*/(""");
		
		var trs = $('#listaProductosAnulados tbody tr');
		
		$('#checkAllLineaAnulacion').click( function() """),format.raw/*60.50*/("""{"""),format.raw/*60.51*/("""
			sumarFilas(trs);
		"""),format.raw/*62.3*/("""}"""),format.raw/*62.4*/(""");
		
		$('input[name="check_linea_anulacion[]"]').click( function() """),format.raw/*64.64*/("""{"""),format.raw/*64.65*/("""
			sumarFilas( $('#listaProductosAnulados tbody tr:has(td:eq(0):has(input:checked))') );
		"""),format.raw/*66.3*/("""}"""),format.raw/*66.4*/(""");
		
		function sumarFilas(trs) """),format.raw/*68.28*/("""{"""),format.raw/*68.29*/("""
			var base = 0; 
			trs.each( function() """),format.raw/*70.25*/("""{"""),format.raw/*70.26*/("""
				base += Number($('.totalAnulado',this).attr("data-valor"));
				 
			"""),format.raw/*73.4*/("""}"""),format.raw/*73.5*/(""");
			
			$(".totalAnuladoFooter").html(formatNumberPesos(parseFloat(base).toFixed(2)));
			
		"""),format.raw/*77.3*/("""}"""),format.raw/*77.4*/("""
	"""),format.raw/*78.2*/("""}"""),format.raw/*78.3*/(""");
</script>
"""))}
    }
    
    def render(idOrdenCompra:Long,lineas:List[OrdenLineaAnulacion],listaFacturas:List[Factura]): play.api.templates.HtmlFormat.Appendable = apply(idOrdenCompra,lineas,listaFacturas)
    
    def f:((Long,List[OrdenLineaAnulacion],List[Factura]) => play.api.templates.HtmlFormat.Appendable) = (idOrdenCompra,lineas,listaFacturas) => apply(idOrdenCompra,lineas,listaFacturas)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/anulacionRecepcion/indexAnulacionRecepcion.scala.html
                    HASH: d9e992eeb9cbcb6b342394611c42f3a395de895b
                    MATRIX: 860->1|1156->146|1188->170|1262->85|1291->214|1320->286|1431->363|1492->416|1531->418|1613->464|1633->475|1733->552|1842->630|1882->635|1919->663|1958->664|2107->782|2654->1293|2690->1313|2730->1315|2773->1323|2787->1328|2865->1384|2908->1392|2967->1429|3017->1447|3189->1583|3203->1588|3251->1614|3386->1721|3415->1722|3512->1791|3541->1792|3744->1968|3772->1969|3913->2082|3942->2083|3994->2108|4022->2109|4121->2180|4150->2181|4271->2275|4299->2276|4362->2311|4391->2312|4464->2357|4493->2358|4597->2435|4625->2436|4751->2535|4779->2536|4809->2539|4837->2540
                    LINES: 26->1|35->5|35->5|36->1|37->5|38->7|40->9|40->9|40->9|41->10|41->10|41->10|42->11|43->12|43->12|43->12|45->14|63->32|63->32|63->32|64->33|64->33|64->33|65->34|65->34|66->35|71->40|71->40|71->40|78->47|78->47|82->51|82->51|87->56|87->56|91->60|91->60|93->62|93->62|95->64|95->64|97->66|97->66|99->68|99->68|101->70|101->70|104->73|104->73|108->77|108->77|109->78|109->78
                    -- GENERATED --
                */
            