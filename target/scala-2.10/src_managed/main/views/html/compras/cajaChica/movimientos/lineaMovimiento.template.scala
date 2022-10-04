
package views.html.compras.cajaChica.movimientos

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
object lineaMovimiento extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[CajaChicaMovimiento,Boolean,java.math.BigDecimal,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea: CajaChicaMovimiento,  editable: Boolean = false,saldoTotal:java.math.BigDecimal):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import java.math.BigDecimal;var xxx=new java.math.BigDecimal(0);


Seq[Any](format.raw/*1.90*/("""
"""),format.raw/*3.1*/("""
 

<tr data-id=""""),_display_(Seq[Any](/*6.15*/linea/*6.20*/.id)),format.raw/*6.23*/("""">
	"""),_display_(Seq[Any](/*7.3*/if(editable)/*7.15*/{_display_(Seq[Any](format.raw/*7.16*/("""
		<td class="accion-editar"><a class="btn btn-default btn-xs modificarMovimiento" href=""""),_display_(Seq[Any](/*8.90*/controllers/*8.101*/.compras.routes.CajaChicaMovimientosController.editar(linea.id))),format.raw/*8.164*/(""""><i class="glyphicon glyphicon-edit"></i></a></td>
	""")))})),format.raw/*9.3*/("""
	
	<td>"""),_display_(Seq[Any](/*11.7*/linea/*11.12*/.proveedor.nombre)),format.raw/*11.29*/("""</td>
	<td>"""),_display_(Seq[Any](/*12.7*/linea/*12.12*/.producto.nombre)),format.raw/*12.28*/("""</td>
	<td>"""),_display_(Seq[Any](/*13.7*/linea/*13.12*/.numero_factura)),format.raw/*13.27*/("""</td>
	<td>"""),_display_(Seq[Any](/*14.7*/utils/*14.12*/.DateUtils.formatDate(linea.fecha))),format.raw/*14.46*/("""</td>
	<td class="cuentaAnaliticaEnLinea">"""),_display_(Seq[Any](/*15.38*/if(linea.cuentaAnalitica == null)/*15.71*/{_display_(Seq[Any](format.raw/*15.72*/("""No asociada""")))}/*15.85*/else/*15.90*/{_display_(Seq[Any](_display_(Seq[Any](/*15.92*/linea/*15.97*/.cuentaAnalitica.codigo)),format.raw/*15.120*/(""" """),_display_(Seq[Any](/*15.122*/linea/*15.127*/.cuentaAnalitica.nombre))))})),format.raw/*15.151*/("""</td>
	<td>"""),_display_(Seq[Any](/*16.7*/linea/*16.12*/.udm.nombre)),format.raw/*16.23*/("""</td>
	<td>"""),_display_(Seq[Any](/*17.7*/linea/*17.12*/.cantidad)),format.raw/*17.21*/("""</td>
	<td>"""),_display_(Seq[Any](/*18.7*/utils/*18.12*/.NumberUtils.moneda(linea.precio, 10))),format.raw/*18.49*/("""</td>
	<td>"""),_display_(Seq[Any](/*19.7*/utils/*19.12*/.NumberUtils.moneda(linea.getTotal(), 10))),format.raw/*19.53*/("""</td>
	"""),_display_(Seq[Any](/*20.3*/if(!editable)/*20.16*/{_display_(Seq[Any](format.raw/*20.17*/("""<td>"""),_display_(Seq[Any](/*20.22*/utils/*20.27*/.NumberUtils.moneda(saldoTotal, 10))),format.raw/*20.62*/("""</td>""")))})),format.raw/*20.68*/("""
	"""),_display_(Seq[Any](/*21.3*/if(editable)/*21.15*/{_display_(Seq[Any](format.raw/*21.16*/("""
		<td><a class="btn btn-default btn-xs eliminarMovimmiento" href=""""),_display_(Seq[Any](/*22.68*/controllers/*22.79*/.compras.routes.CajaChicaMovimientosController.eliminar(linea.id))),format.raw/*22.144*/(""""><i class="glyphicon glyphicon-trash icono-eliminar"></i></a></td>
	""")))})),format.raw/*23.3*/("""
	 
</tr>
 """))}
    }
    
    def render(linea:CajaChicaMovimiento,editable:Boolean,saldoTotal:java.math.BigDecimal): play.api.templates.HtmlFormat.Appendable = apply(linea,editable,saldoTotal)
    
    def f:((CajaChicaMovimiento,Boolean,java.math.BigDecimal) => play.api.templates.HtmlFormat.Appendable) = (linea,editable,saldoTotal) => apply(linea,editable,saldoTotal)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:46 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/cajaChica/movimientos/lineaMovimiento.scala.html
                    HASH: d7c0977d3895facc9c54efdca6185356131f08cc
                    MATRIX: 856->1|1104->89|1132->158|1188->179|1201->184|1225->187|1265->193|1285->205|1323->206|1449->297|1469->308|1554->371|1639->426|1685->437|1699->442|1738->459|1786->472|1800->477|1838->493|1886->506|1900->511|1937->526|1985->539|1999->544|2055->578|2135->622|2177->655|2216->656|2247->669|2260->674|2308->676|2322->681|2368->704|2407->706|2422->711|2473->735|2521->748|2535->753|2568->764|2616->777|2630->782|2661->791|2709->804|2723->809|2782->846|2830->859|2844->864|2907->905|2951->914|2973->927|3012->928|3053->933|3067->938|3124->973|3162->979|3201->983|3222->995|3261->996|3366->1065|3386->1076|3474->1141|3576->1212
                    LINES: 26->1|30->1|31->3|34->6|34->6|34->6|35->7|35->7|35->7|36->8|36->8|36->8|37->9|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|43->15|43->15|43->15|43->15|43->15|43->15|43->15|43->15|44->16|44->16|44->16|45->17|45->17|45->17|46->18|46->18|46->18|47->19|47->19|47->19|48->20|48->20|48->20|48->20|48->20|48->20|48->20|49->21|49->21|49->21|50->22|50->22|50->22|51->23
                    -- GENERATED --
                */
            