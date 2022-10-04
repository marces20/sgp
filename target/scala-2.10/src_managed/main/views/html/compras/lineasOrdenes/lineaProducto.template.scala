
package views.html.compras.lineasOrdenes

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
object lineaProducto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[OrdenLinea,Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea: OrdenLinea, editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {
def /*3.2*/getPacientes/*3.14*/(linea: OrdenLinea) = {{
	var pacientes:String = new String()
	if(linea != null && linea.ordenLineaCliente != null && linea.ordenLineaCliente.size() > 0){
		for(olp <- linea.ordenLineaCliente) {
			pacientes += olp.cliente.nombre.toUpperCase()+" - ID:"+olp.cliente.id_paciente_rismi+"\n" 
		}
	}
	pacientes
}};
Seq[Any](format.raw/*1.40*/("""

"""),format.raw/*11.2*/("""

					

<tr data-id=""""),_display_(Seq[Any](/*15.15*/linea/*15.20*/.id)),format.raw/*15.23*/("""">
	"""),_display_(Seq[Any](/*16.3*/if(editable)/*16.15*/{_display_(Seq[Any](format.raw/*16.16*/("""
		<td><input type="checkbox" name="check_listado[]" value=""""),_display_(Seq[Any](/*17.61*/linea/*17.66*/.id)),format.raw/*17.69*/("""" class="check_listado notSeleccion" id="check-"""),_display_(Seq[Any](/*17.117*/linea/*17.122*/.id)),format.raw/*17.125*/(""""/></td>
		<td class="accion-editar"><a class="btn btn-default btn-xs modificarProducto" href=""""),_display_(Seq[Any](/*18.88*/controllers/*18.99*/.compras.routes.LineasOrdenesController.editar(linea.id))),format.raw/*18.155*/(""""><i class="glyphicon glyphicon-edit"></i></a></td>
	""")))})),format.raw/*19.3*/("""
	<td>"""),_display_(Seq[Any](/*20.7*/linea/*20.12*/.producto.nombre)),format.raw/*20.28*/("""</td>
	<td>"""),_display_(Seq[Any](/*21.7*/linea/*21.12*/.cantidad)),format.raw/*21.21*/("""</td>
	<td>"""),_display_(Seq[Any](/*22.7*/linea/*22.12*/.udm.nombre)),format.raw/*22.23*/("""</td>
	<td>"""),_display_(Seq[Any](/*23.7*/utils/*23.12*/.NumberUtils.moneda(linea.precio, 2))),format.raw/*23.48*/("""</td>
	<td class="cuentaAnaliticaEnLinea">"""),_display_(Seq[Any](/*24.38*/if(linea.cuentaAnalitica == null)/*24.71*/{_display_(Seq[Any](format.raw/*24.72*/("""No asociada""")))}/*24.85*/else/*24.90*/{_display_(Seq[Any](_display_(Seq[Any](/*24.92*/linea/*24.97*/.cuentaAnalitica.codigo)),format.raw/*24.120*/(""" """),_display_(Seq[Any](/*24.122*/linea/*24.127*/.cuentaAnalitica.nombre))))})),format.raw/*24.151*/("""</td>
	<td>"""),_display_(Seq[Any](/*25.7*/if(linea.departamento != null)/*25.37*/{_display_(Seq[Any](_display_(Seq[Any](/*25.39*/linea/*25.44*/.departamento.nombre))))})),format.raw/*25.65*/("""</td>
	<td>"""),_display_(Seq[Any](/*26.7*/(utils.NumberUtils.moneda(linea.precio.multiply(linea.cantidad), 2)))),format.raw/*26.75*/("""</td>
	"""),_display_(Seq[Any](/*27.3*/if(editable)/*27.15*/{_display_(Seq[Any](format.raw/*27.16*/("""
		<td>
			<a class="btn btn-default btn-xs eliminarProducto" href=""""),_display_(Seq[Any](/*29.62*/controllers/*29.73*/.compras.routes.LineasOrdenesController.eliminar(linea.id))),format.raw/*29.131*/("""">
			<i class="glyphicon glyphicon-trash icono-eliminar"></i></a>
			"""),_display_(Seq[Any](/*31.5*/if(linea != null && linea.ordenLineaCliente != null && linea.ordenLineaCliente.size() > 0)/*31.95*/{_display_(Seq[Any](format.raw/*31.96*/("""
				<div class='tip-top pointer' style="display: inline;" title='"""),_display_(Seq[Any](/*32.67*/getPacientes(linea))),format.raw/*32.86*/("""'>
				<i class="glyphicon glyphicon-user"></i></div>
			""")))})),format.raw/*34.5*/("""
		</td>
		 
	""")))}/*37.3*/else/*37.7*/{_display_(Seq[Any](format.raw/*37.8*/("""
		"""),_display_(Seq[Any](/*38.4*/if(linea != null && linea.ordenLineaCliente != null && linea.ordenLineaCliente.size() > 0)/*38.94*/{_display_(Seq[Any](format.raw/*38.95*/("""
			<td><div class='tip-top pointer' title='"""),_display_(Seq[Any](/*39.45*/getPacientes(linea))),format.raw/*39.64*/("""'><i class="glyphicon glyphicon-user"></i></div></td>
		""")))}/*40.4*/else/*40.8*/{_display_(Seq[Any](format.raw/*40.9*/("""
			<td></td>
		""")))})),format.raw/*42.4*/("""
	""")))})),format.raw/*43.3*/("""
</tr>"""))}
    }
    
    def render(linea:OrdenLinea,editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(linea,editable)
    
    def f:((OrdenLinea,Boolean) => play.api.templates.HtmlFormat.Appendable) = (linea,editable) => apply(linea,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:42 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/lineasOrdenes/lineaProducto.scala.html
                    HASH: fbc2bc517dc2c11372136de04ce7cb00b85b7985
                    MATRIX: 816->1|931->44|951->56|1297->39|1328->372|1391->399|1405->404|1430->407|1471->413|1492->425|1531->426|1629->488|1643->493|1668->496|1753->544|1768->549|1794->552|1927->649|1947->660|2026->716|2112->771|2155->779|2169->784|2207->800|2255->813|2269->818|2300->827|2348->840|2362->845|2395->856|2443->869|2457->874|2515->910|2595->954|2637->987|2676->988|2707->1001|2720->1006|2768->1008|2782->1013|2828->1036|2867->1038|2882->1043|2933->1067|2981->1080|3020->1110|3068->1112|3082->1117|3129->1138|3177->1151|3267->1219|3311->1228|3332->1240|3371->1241|3478->1312|3498->1323|3579->1381|3687->1454|3786->1544|3825->1545|3929->1613|3970->1632|4061->1692|4097->1710|4109->1714|4147->1715|4187->1720|4286->1810|4325->1811|4407->1857|4448->1876|4524->1934|4536->1938|4574->1939|4624->1958|4659->1962
                    LINES: 26->1|28->3|28->3|37->1|39->11|43->15|43->15|43->15|44->16|44->16|44->16|45->17|45->17|45->17|45->17|45->17|45->17|46->18|46->18|46->18|47->19|48->20|48->20|48->20|49->21|49->21|49->21|50->22|50->22|50->22|51->23|51->23|51->23|52->24|52->24|52->24|52->24|52->24|52->24|52->24|52->24|52->24|52->24|52->24|53->25|53->25|53->25|53->25|53->25|54->26|54->26|55->27|55->27|55->27|57->29|57->29|57->29|59->31|59->31|59->31|60->32|60->32|62->34|65->37|65->37|65->37|66->38|66->38|66->38|67->39|67->39|68->40|68->40|68->40|70->42|71->43
                    -- GENERATED --
                */
            