
package views.html.compras.proveedoresDatosDgr

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
object lineaDatosDgr extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[ProveedorDatoDgr,Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea: ProveedorDatoDgr, editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.46*/("""

<tr data-id=""""),_display_(Seq[Any](/*3.15*/linea/*3.20*/.id)),format.raw/*3.23*/("""">
	
	<td>"""),_display_(Seq[Any](/*5.7*/if(linea.periodo_fiscal != null)/*5.39*/{_display_(Seq[Any](_display_(Seq[Any](/*5.41*/linea/*5.46*/.periodo_fiscal))))})),format.raw/*5.62*/("""</td>
	<td>"""),_display_(Seq[Any](/*6.7*/if(linea.proveedor_dgr_dato_regimen_id != null)/*6.54*/{_display_(Seq[Any](_display_(Seq[Any](/*6.56*/linea/*6.61*/.proveedor_dgr_dato_regimen.regimen)),format.raw/*6.96*/(""" - """),_display_(Seq[Any](/*6.100*/linea/*6.105*/.proveedor_dgr_dato_regimen.descripcion))))})),format.raw/*6.145*/("""</td>
	<td>"""),_display_(Seq[Any](/*7.7*/if(linea.cuit != null)/*7.29*/{_display_(Seq[Any](_display_(Seq[Any](/*7.31*/linea/*7.36*/.cuit))))})),format.raw/*7.42*/("""</td>
	<td>"""),_display_(Seq[Any](/*8.7*/if(linea.razon_social != null)/*8.37*/{_display_(Seq[Any](_display_(Seq[Any](/*8.39*/linea/*8.44*/.razon_social))))})),format.raw/*8.58*/("""</td>
	<td>"""),_display_(Seq[Any](/*9.7*/if(linea.alicuota != null)/*9.33*/{_display_(Seq[Any](_display_(Seq[Any](/*9.35*/linea/*9.40*/.alicuota))))})),format.raw/*9.50*/("""</td>
	<td>"""),_display_(Seq[Any](/*10.7*/if(linea.proveedor_dgr_dato_motivo_id != null)/*10.53*/{_display_(Seq[Any](_display_(Seq[Any](/*10.55*/linea/*10.60*/.proveedor_dgr_dato_motivo.motivo)),format.raw/*10.93*/(""" - """),_display_(Seq[Any](/*10.97*/linea/*10.102*/.proveedor_dgr_dato_motivo.descripcion))))})),format.raw/*10.141*/("""</td>
	<td>"""),_display_(Seq[Any](/*11.7*/if(linea.tipo_contribuyente != null)/*11.43*/{_display_(Seq[Any](_display_(Seq[Any](/*11.45*/linea/*11.50*/.tipo_contribuyente))))})),format.raw/*11.70*/("""</td>
	<td>"""),_display_(Seq[Any](/*12.7*/if(linea.tipo_documento != null)/*12.39*/{_display_(Seq[Any](_display_(Seq[Any](/*12.41*/linea/*12.46*/.tipo_documento))))})),format.raw/*12.62*/("""</td>
	<td>"""),_display_(Seq[Any](/*13.7*/if(linea.numero_documento != null)/*13.41*/{_display_(Seq[Any](_display_(Seq[Any](/*13.43*/linea/*13.48*/.numero_documento))))})),format.raw/*13.66*/("""</td>
	<td>"""),_display_(Seq[Any](/*14.7*/(utils.DateUtils.formatDate(linea.create_date)))),format.raw/*14.54*/("""</td>
		
	"""),_display_(Seq[Any](/*16.3*/if(editable)/*16.15*/{_display_(Seq[Any](format.raw/*16.16*/("""
		 
		 
	""")))}/*19.3*/else/*19.7*/{_display_(Seq[Any](format.raw/*19.8*/("""
		 
	""")))})),format.raw/*21.3*/("""
</tr>"""))}
    }
    
    def render(linea:ProveedorDatoDgr,editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(linea,editable)
    
    def f:((ProveedorDatoDgr,Boolean) => play.api.templates.HtmlFormat.Appendable) = (linea,editable) => apply(linea,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:42 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/proveedoresDatosDgr/lineaDatosDgr.scala.html
                    HASH: 3dfe9e7d3d94ac95e5d49e90953bfc0d2639fcea
                    MATRIX: 828->1|966->45|1019->63|1032->68|1056->71|1103->84|1143->116|1190->118|1203->123|1244->139|1291->152|1346->199|1393->201|1406->206|1462->241|1502->245|1516->250|1582->290|1629->303|1659->325|1706->327|1719->332|1750->338|1797->351|1835->381|1882->383|1895->388|1934->402|1981->415|2015->441|2062->443|2075->448|2110->458|2158->471|2213->517|2261->519|2275->524|2330->557|2370->561|2385->566|2451->605|2499->618|2544->654|2592->656|2606->661|2652->681|2700->694|2741->726|2789->728|2803->733|2845->749|2893->762|2936->796|2984->798|2998->803|3042->821|3090->834|3159->881|3207->894|3228->906|3267->907|3299->921|3311->925|3349->926|3389->935
                    LINES: 26->1|29->1|31->3|31->3|31->3|33->5|33->5|33->5|33->5|33->5|34->6|34->6|34->6|34->6|34->6|34->6|34->6|34->6|35->7|35->7|35->7|35->7|35->7|36->8|36->8|36->8|36->8|36->8|37->9|37->9|37->9|37->9|37->9|38->10|38->10|38->10|38->10|38->10|38->10|38->10|38->10|39->11|39->11|39->11|39->11|39->11|40->12|40->12|40->12|40->12|40->12|41->13|41->13|41->13|41->13|41->13|42->14|42->14|44->16|44->16|44->16|47->19|47->19|47->19|49->21
                    -- GENERATED --
                */
            