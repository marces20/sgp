
package views.html.patrimonio.lineasCertificaciones

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
object listaLineasPacientes extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[List[CertificacionServicioLinea],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea: List[CertificacionServicioLinea]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.43*/("""

"""),_display_(Seq[Any](/*3.2*/if(linea.size() > 0)/*3.22*/{_display_(Seq[Any](format.raw/*3.23*/("""


<table id="listaDePacientes" class="table table-striped table-bordered">
	<thead>
		<tr>
			<th>Producto</th>
			<th>Paciente</th>
			<th>Cantidad</th>
			<th>Precio</th>
			<th>Total</th>
		<tr>	
	</thead>
	<tbody>
	"""),_display_(Seq[Any](/*17.3*/for(ll <- linea) yield /*17.19*/ {_display_(Seq[Any](format.raw/*17.21*/("""
		"""),_display_(Seq[Any](/*18.4*/if(ll.certificacionServicioLineaCliente.size() > 0)/*18.55*/{_display_(Seq[Any](format.raw/*18.56*/("""
			"""),_display_(Seq[Any](/*19.5*/for(lcc <- ll.certificacionServicioLineaCliente) yield /*19.53*/ {_display_(Seq[Any](format.raw/*19.55*/("""
				<tr>
				 <td>"""),_display_(Seq[Any](/*21.11*/ll/*21.13*/.producto.nombre)),format.raw/*21.29*/("""</td>
				 <td>"""),_display_(Seq[Any](/*22.11*/lcc/*22.14*/.cliente.nombre.toUpperCase())),format.raw/*22.43*/(""" - ID:"""),_display_(Seq[Any](/*22.50*/lcc/*22.53*/.cliente.id_paciente_rismi)),format.raw/*22.79*/("""</td>
				 <td>"""),_display_(Seq[Any](/*23.11*/lcc/*23.14*/.cantidad)),format.raw/*23.23*/("""</td>
				 <td>"""),_display_(Seq[Any](/*24.11*/utils/*24.16*/.NumberUtils.moneda(ll.precio))),format.raw/*24.46*/("""</td>
				 <td>"""),_display_(Seq[Any](/*25.11*/utils/*25.16*/.NumberUtils.moneda(lcc.cantidad.multiply(ll.precio)))),format.raw/*25.69*/("""</td>
				</tr> 
			""")))})),format.raw/*27.5*/("""
		""")))}/*28.4*/else/*28.8*/{_display_(Seq[Any](format.raw/*28.9*/("""
			<tr><td>"""),_display_(Seq[Any](/*29.13*/ll/*29.15*/.producto.nombre)),format.raw/*29.31*/("""</td><td colspan="4">NO TIENE PACIENTES</td></tr>
		""")))})),format.raw/*30.4*/("""
	""")))})),format.raw/*31.3*/("""	
	</tbody>
</table>
""")))})))}
    }
    
    def render(linea:List[CertificacionServicioLinea]): play.api.templates.HtmlFormat.Appendable = apply(linea)
    
    def f:((List[CertificacionServicioLinea]) => play.api.templates.HtmlFormat.Appendable) = (linea) => apply(linea)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/lineasCertificaciones/listaLineasPacientes.scala.html
                    HASH: a97eb7d25df03427fa316966755e7d30fbc9bfc3
                    MATRIX: 848->1|983->42|1020->45|1048->65|1086->66|1342->287|1374->303|1414->305|1453->309|1513->360|1552->361|1592->366|1656->414|1696->416|1752->436|1763->438|1801->454|1853->470|1865->473|1916->502|1959->509|1971->512|2019->538|2071->554|2083->557|2114->566|2166->582|2180->587|2232->617|2284->633|2298->638|2373->691|2425->712|2447->716|2459->720|2497->721|2546->734|2557->736|2595->752|2679->805|2713->808
                    LINES: 26->1|29->1|31->3|31->3|31->3|45->17|45->17|45->17|46->18|46->18|46->18|47->19|47->19|47->19|49->21|49->21|49->21|50->22|50->22|50->22|50->22|50->22|50->22|51->23|51->23|51->23|52->24|52->24|52->24|53->25|53->25|53->25|55->27|56->28|56->28|56->28|57->29|57->29|57->29|58->30|59->31
                    -- GENERATED --
                */
            