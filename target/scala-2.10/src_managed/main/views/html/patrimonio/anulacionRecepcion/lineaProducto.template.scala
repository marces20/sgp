
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
object lineaProducto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[OrdenLineaAnulacion,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea: OrdenLineaAnulacion):play.api.templates.HtmlFormat.Appendable = {
        _display_ {
def /*3.2*/getPacientes/*3.14*/(linea: OrdenLinea) = {{
	var pacientes:String = new String()
	if(linea != null && linea.ordenLineaCliente != null && linea.ordenLineaCliente.size() > 0){
		for(olp <- linea.ordenLineaCliente) {
			pacientes += olp.cliente.nombre.toUpperCase()+" - ID:"+olp.cliente.id_paciente_rismi+"\n" 
		}
	}
	pacientes
}};def /*13.2*/getPacientesAnulados/*13.22*/(linea: OrdenLineaAnulacion) = {{
	var pacientes:String = new String()
								   
	if(linea.ordenLineaAnulacionCliente != null && linea.ordenLineaAnulacionCliente.size() > 0){
		for(olp <- linea.ordenLineaAnulacionCliente) {
			pacientes += olp.cliente.nombre.toUpperCase()+" - ID:"+olp.cliente.id_paciente_rismi+"\n" 
		}
	}
	
	pacientes
}};
Seq[Any](format.raw/*1.30*/("""

"""),format.raw/*11.2*/("""

"""),format.raw/*23.2*/("""

<tr class="pointer">
	<td class="accion-editar">
		<!-- <a class="btn btn-default btn-xs modificarProducto" href=""""),_display_(Seq[Any](/*27.67*/controllers/*27.78*/.patrimonio.routes.AnulacionRecepcionProductosController.editar(linea.id))),format.raw/*27.151*/(""""><i class="glyphicon glyphicon-edit"></i></a> -->
		<input type="checkbox" name="check_linea_anulacion[]" value=""""),_display_(Seq[Any](/*28.65*/linea/*28.70*/.id)),format.raw/*28.73*/("""" class="data-check-linea-anulacion notSeleccion" id="check-"""),_display_(Seq[Any](/*28.134*/linea/*28.139*/.id)),format.raw/*28.142*/(""""/>
	</td>
	<td>"""),_display_(Seq[Any](/*30.7*/linea/*30.12*/.ordenLinea.producto.nombre)),format.raw/*30.39*/("""</td>
	<td align="center">"""),_display_(Seq[Any](/*31.22*/linea/*31.27*/.cantidad)),format.raw/*31.36*/("""</td>
	<td>"""),_display_(Seq[Any](/*32.7*/linea/*32.12*/.ordenLinea.udm.nombre)),format.raw/*32.34*/("""</td>
	<td align="center">"""),_display_(Seq[Any](/*33.22*/utils/*33.27*/.NumberUtils.moneda(linea.ordenLinea.precio))),format.raw/*33.71*/("""</td>
	<td align="center" class="totalAnulado" data-valor=""""),_display_(Seq[Any](/*34.55*/linea/*34.60*/.getTotal())),format.raw/*34.71*/("""">"""),_display_(Seq[Any](/*34.74*/utils/*34.79*/.NumberUtils.moneda(linea.getTotal()))),format.raw/*34.116*/("""</td>
	<td align="center">"""),_display_(Seq[Any](/*35.22*/linea/*35.27*/.observaciones)),format.raw/*35.41*/("""</td>
	
	"""),_display_(Seq[Any](/*37.3*/if(linea != null && linea.ordenLineaAnulacionCliente != null && linea.ordenLineaAnulacionCliente.size() > 0)/*37.111*/{_display_(Seq[Any](format.raw/*37.112*/("""
			
			
		<td><div class='tip-top pointer' title='"""),_display_(Seq[Any](/*40.44*/getPacientesAnulados(linea))),format.raw/*40.71*/("""'><i class="glyphicon glyphicon-user"></i></div></td>
			
		
	""")))}/*43.3*/else/*43.7*/{_display_(Seq[Any](format.raw/*43.8*/("""
		<td></td>
	""")))})),format.raw/*45.3*/("""
	<!--<td>
	 <a class="btn btn-default btn-xs eliminarProducto" href=""""),_display_(Seq[Any](/*47.61*/controllers/*47.72*/.patrimonio.routes.AnulacionRecepcionProductosController.eliminar(linea.id))),format.raw/*47.147*/("""">
	 <i class="glyphicon glyphicon-trash icono-eliminar"></i></a></td>-->
</tr>

"""))}
    }
    
    def render(linea:OrdenLineaAnulacion): play.api.templates.HtmlFormat.Appendable = apply(linea)
    
    def f:((OrdenLineaAnulacion) => play.api.templates.HtmlFormat.Appendable) = (linea) => apply(linea)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/anulacionRecepcion/lineaProducto.scala.html
                    HASH: 87943965de8c8ec64a418d458e8d4842dd437698
                    MATRIX: 825->1|930->34|950->46|1280->367|1309->387|1690->29|1721->362|1752->738|1909->859|1929->870|2025->943|2177->1059|2191->1064|2216->1067|2314->1128|2329->1133|2355->1136|2409->1155|2423->1160|2472->1187|2536->1215|2550->1220|2581->1229|2629->1242|2643->1247|2687->1269|2751->1297|2765->1302|2831->1346|2928->1407|2942->1412|2975->1423|3014->1426|3028->1431|3088->1468|3152->1496|3166->1501|3202->1515|3249->1527|3367->1635|3407->1636|3498->1691|3547->1718|3631->1784|3643->1788|3681->1789|3729->1806|3838->1879|3858->1890|3956->1965
                    LINES: 26->1|28->3|28->3|36->13|36->13|47->1|49->11|51->23|55->27|55->27|55->27|56->28|56->28|56->28|56->28|56->28|56->28|58->30|58->30|58->30|59->31|59->31|59->31|60->32|60->32|60->32|61->33|61->33|61->33|62->34|62->34|62->34|62->34|62->34|62->34|63->35|63->35|63->35|65->37|65->37|65->37|68->40|68->40|71->43|71->43|71->43|73->45|75->47|75->47|75->47
                    -- GENERATED --
                */
            