
package views.html.expediente.expedientesMovimientos

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
object lineaExpedienteMovimiento extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[ExpedienteMovimiento,Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea: ExpedienteMovimiento, editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {
def /*3.2*/getExpedienteMovimientosOrdenpago/*3.35*/(linea: ExpedienteMovimiento) = {{
	var ops:String = new String()
	if(linea != null && linea.expedienteMovimientosOrdenpago != null && linea.expedienteMovimientosOrdenpago.size() > 0){
		for(olp <- linea.expedienteMovimientosOrdenpago) {
			ops += olp.ordenPago.getNombreCompleto()+"\n" 
		}
	}
	ops
}};
Seq[Any](format.raw/*1.50*/("""

"""),format.raw/*11.2*/("""
 
			

<tr data-id=""""),_display_(Seq[Any](/*15.15*/linea/*15.20*/.id)),format.raw/*15.23*/("""" """),_display_(Seq[Any](/*15.26*/if(linea.cancelado)/*15.45*/{_display_(Seq[Any](format.raw/*15.46*/("""class="cancelada"""")))})),format.raw/*15.64*/(""">
	"""),_display_(Seq[Any](/*16.3*/if(editable)/*16.15*/{_display_(Seq[Any](format.raw/*16.16*/("""
		<!--  <td><input type="checkbox" name="check_listado[]" value=""""),_display_(Seq[Any](/*17.67*/linea/*17.72*/.id)),format.raw/*17.75*/("""" class="check_listado notSeleccion" id="check-"""),_display_(Seq[Any](/*17.123*/linea/*17.128*/.id)),format.raw/*17.131*/(""""/></td>
		<td class="accion-editar"><a class="btn btn-default btn-xs modificarExpedienteMovimiento" href=""""),_display_(Seq[Any](/*18.100*/controllers/*18.111*/.expediente.routes.ExpedientesMovimientosController.editar(linea.id))),format.raw/*18.179*/(""""><i class="glyphicon glyphicon-edit"></i></a></td>
		 -->
	""")))})),format.raw/*20.3*/("""
	<td>"""),_display_(Seq[Any](/*21.7*/linea/*21.12*/.organigrama.nombre)),format.raw/*21.31*/("""</td>
	<td>"""),_display_(Seq[Any](/*22.7*/linea/*22.12*/.usuario.nombre)),format.raw/*22.27*/("""</td>
	<td>"""),_display_(Seq[Any](/*23.7*/utils/*23.12*/.DateUtils.formatDate(linea.fecha_llegada,"dd/MM/yyyy HH:mm:ss"))),format.raw/*23.76*/("""</td>
	<td>"""),_display_(Seq[Any](/*24.7*/utils/*24.12*/.DateUtils.formatDate(linea.fecha_salida,"dd/MM/yyyy HH:mm:ss"))),format.raw/*24.75*/("""</td>
	<td>"""),_display_(Seq[Any](/*25.7*/ExpedienteMovimiento/*25.27*/.tiempoEnMovimiento(linea))),format.raw/*25.53*/("""</td>
	<td>"""),_display_(Seq[Any](/*26.7*/if(linea.cancelado)/*26.26*/{_display_(Seq[Any](format.raw/*26.27*/("""CANCELADO""")))})),format.raw/*26.37*/("""</td>
	<td>
		"""),_display_(Seq[Any](/*28.4*/if(linea != null && linea.expedienteMovimientosOrdenpago != null && linea.expedienteMovimientosOrdenpago.size() > 0)/*28.120*/{_display_(Seq[Any](format.raw/*28.121*/("""
			<div class='tip-top pointer' style="display: inline;" title='"""),_display_(Seq[Any](/*29.66*/getExpedienteMovimientosOrdenpago(linea))),format.raw/*29.106*/("""'>
				<i class="glyphicon glyphicon-tasks"></i></div>
		""")))})),format.raw/*31.4*/("""
	</td>
	<td>
		"""),_display_(Seq[Any](/*34.4*/if(linea != null && linea.descripcion != null && !linea.descripcion.isEmpty())/*34.82*/{_display_(Seq[Any](format.raw/*34.83*/("""
			<div class='tip-top pointer' style="display: inline;" title='"""),_display_(Seq[Any](/*35.66*/linea/*35.71*/.descripcion)),format.raw/*35.83*/("""'>
				<i class="glyphicon glyphicon-list-alt"></i></div>
		""")))})),format.raw/*37.4*/("""
	</td>
</tr>
"""))}
    }
    
    def render(linea:ExpedienteMovimiento,editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(linea,editable)
    
    def f:((ExpedienteMovimiento,Boolean) => play.api.templates.HtmlFormat.Appendable) = (linea,editable) => apply(linea,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:36 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/expediente/expedientesMovimientos/lineaExpedienteMovimiento.scala.html
                    HASH: 46516957e199f75f744bc9ec6742455e4914f7f7
                    MATRIX: 850->1|975->54|1016->87|1355->49|1386->396|1448->422|1462->427|1487->430|1526->433|1554->452|1593->453|1643->471|1683->476|1704->488|1743->489|1847->557|1861->562|1886->565|1971->613|1986->618|2012->621|2158->730|2179->741|2270->809|2364->872|2407->880|2421->885|2462->904|2510->917|2524->922|2561->937|2609->950|2623->955|2709->1019|2757->1032|2771->1037|2856->1100|2904->1113|2933->1133|2981->1159|3029->1172|3057->1191|3096->1192|3138->1202|3190->1219|3316->1335|3356->1336|3459->1403|3522->1443|3613->1503|3668->1523|3755->1601|3794->1602|3897->1669|3911->1674|3945->1686|4039->1749
                    LINES: 26->1|28->3|28->3|37->1|39->11|43->15|43->15|43->15|43->15|43->15|43->15|43->15|44->16|44->16|44->16|45->17|45->17|45->17|45->17|45->17|45->17|46->18|46->18|46->18|48->20|49->21|49->21|49->21|50->22|50->22|50->22|51->23|51->23|51->23|52->24|52->24|52->24|53->25|53->25|53->25|54->26|54->26|54->26|54->26|56->28|56->28|56->28|57->29|57->29|59->31|62->34|62->34|62->34|63->35|63->35|63->35|65->37
                    -- GENERATED --
                */
            