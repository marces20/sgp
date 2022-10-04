
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
object lineaProducto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[CertificacionServicioLinea,Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea: CertificacionServicioLinea, editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {
def /*3.2*/getPacientes/*3.14*/(linea: CertificacionServicioLinea) = {{
	var pacientes:String = new String()
	if(linea != null && linea.certificacionServicioLineaCliente != null && linea.certificacionServicioLineaCliente.size() > 0){
		for(olp <- linea.certificacionServicioLineaCliente) {
			pacientes += olp.cliente.nombre.toUpperCase()+" - ID:"+olp.cliente.id_paciente_rismi+" - Q:"+olp.cantidad+"\n" 
		}
	}
	pacientes
}};
Seq[Any](format.raw/*1.56*/("""

"""),format.raw/*11.2*/("""

<tr data-id=""""),_display_(Seq[Any](/*13.15*/linea/*13.20*/.id)),format.raw/*13.23*/("""">
	"""),_display_(Seq[Any](/*14.3*/if(editable)/*14.15*/{_display_(Seq[Any](format.raw/*14.16*/("""
		<td class="accion-editar"><a class="btn btn-default btn-xs modificarProducto" href=""""),_display_(Seq[Any](/*15.88*/controllers/*15.99*/.patrimonio.routes.LineasCertificacionesController.editar(linea.id))),format.raw/*15.166*/(""""><i class="glyphicon glyphicon-edit"></i></a></td>
	""")))})),format.raw/*16.3*/("""
	<td>"""),_display_(Seq[Any](/*17.7*/linea/*17.12*/.producto.nombre)),format.raw/*17.28*/("""</td>
	<td class="cuentaAnaliticaEnLinea">"""),_display_(Seq[Any](/*18.38*/if(linea.cuentaAnalitica == null)/*18.71*/{_display_(Seq[Any](format.raw/*18.72*/("""No asociada""")))}/*18.85*/else/*18.90*/{_display_(Seq[Any](_display_(Seq[Any](/*18.92*/linea/*18.97*/.cuentaAnalitica.codigo)),format.raw/*18.120*/(""" """),_display_(Seq[Any](/*18.122*/linea/*18.127*/.cuentaAnalitica.nombre))))})),format.raw/*18.151*/("""</td>
	<td>"""),_display_(Seq[Any](/*19.7*/linea/*19.12*/.cantidad)),format.raw/*19.21*/("""</td>
	<td>"""),_display_(Seq[Any](/*20.7*/linea/*20.12*/.udm.nombre)),format.raw/*20.23*/("""</td>
	<td>"""),_display_(Seq[Any](/*21.7*/utils/*21.12*/.NumberUtils.moneda(linea.precio))),format.raw/*21.45*/("""</td>
	<td>"""),_display_(Seq[Any](/*22.7*/linea/*22.12*/.descuento)),format.raw/*22.22*/("""</td>
	<td>"""),_display_(Seq[Any](/*23.7*/utils/*23.12*/.NumberUtils.moneda(  linea.getTotalDescuento()))),format.raw/*23.60*/("""</td>
	<td>"""),_display_(Seq[Any](/*24.7*/utils/*24.12*/.NumberUtils.moneda(linea.getTotal()))),format.raw/*24.49*/("""</td>
	<td>
		"""),_display_(Seq[Any](/*26.4*/if(linea != null && linea.certificacionServicioLineaCliente != null && linea.certificacionServicioLineaCliente.size() > 0)/*26.126*/{_display_(Seq[Any](format.raw/*26.127*/("""
			<div class='tip-top pointer' title='"""),_display_(Seq[Any](/*27.41*/getPacientes(linea))),format.raw/*27.60*/("""'><i class="glyphicon glyphicon-user"></i></div>
		""")))})),format.raw/*28.4*/("""
	</td>
	"""),_display_(Seq[Any](/*30.3*/if(editable)/*30.15*/{_display_(Seq[Any](format.raw/*30.16*/("""
		<td><a class="btn btn-default btn-xs eliminarProducto delete-confirm-link" href=""""),_display_(Seq[Any](/*31.85*/controllers/*31.96*/.patrimonio.routes.LineasCertificacionesController.eliminar(linea.id))),format.raw/*31.165*/(""""><i class="glyphicon glyphicon-trash icono-eliminar"></i></a></td>
	""")))})),format.raw/*32.3*/("""
</tr>"""))}
    }
    
    def render(linea:CertificacionServicioLinea,editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(linea,editable)
    
    def f:((CertificacionServicioLinea,Boolean) => play.api.templates.HtmlFormat.Appendable) = (linea,editable) => apply(linea,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/lineasCertificaciones/lineaProducto.scala.html
                    HASH: 809ff1aaeba11ecb764a5ecb0a2ba248738373cb
                    MATRIX: 843->1|974->60|994->72|1425->55|1456->473|1510->491|1524->496|1549->499|1590->505|1611->517|1650->518|1775->607|1795->618|1885->685|1971->740|2014->748|2028->753|2066->769|2146->813|2188->846|2227->847|2258->860|2271->865|2319->867|2333->872|2379->895|2418->897|2433->902|2484->926|2532->939|2546->944|2577->953|2625->966|2639->971|2672->982|2720->995|2734->1000|2789->1033|2837->1046|2851->1051|2883->1061|2931->1074|2945->1079|3015->1127|3063->1140|3077->1145|3136->1182|3188->1199|3320->1321|3360->1322|3438->1364|3479->1383|3563->1436|3610->1448|3631->1460|3670->1461|3792->1547|3812->1558|3904->1627|4006->1698
                    LINES: 26->1|28->3|28->3|37->1|39->11|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|44->16|45->17|45->17|45->17|46->18|46->18|46->18|46->18|46->18|46->18|46->18|46->18|46->18|46->18|46->18|47->19|47->19|47->19|48->20|48->20|48->20|49->21|49->21|49->21|50->22|50->22|50->22|51->23|51->23|51->23|52->24|52->24|52->24|54->26|54->26|54->26|55->27|55->27|56->28|58->30|58->30|58->30|59->31|59->31|59->31|60->32
                    -- GENERATED --
                */
            