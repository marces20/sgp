
package views.html.contabilidad.facturas

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
object contenidoTabParciales extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Boolean,Form[Factura],Factura,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formularioCarga: Boolean, facturaForm: Form[Factura] = null,factura:Factura):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.79*/("""
<div class="tab-pane" id="contenedorParciales">

	"""),_display_(Seq[Any](/*4.3*/if(factura != null && factura.facturaParciales != null && factura.facturaParciales.size() > 0)/*4.97*/{_display_(Seq[Any](format.raw/*4.98*/("""
		<table id="" class="table table-bordered">
			<thead>
				<tr>
					<th width="100">Referencia</th>
					<th width="100">Proveedor</th>
					<!-- <th width="100">Referencia</th> -->
					<th width="100">OPG</th>
					<th width="100">N° Factura</th>
					<!-- <th width="100">Representante</th> -->
					<th width="100">Base</th>
					<th width="100">Total impuestos</th>
					<th width="100">Total</th>
					<th width="100">Saldo pendiente</th>
					<th width="100">Expediente</th>
					<th width="100">Periodo</th>
					<th>Tipo Cuenta</th>
					<th width="100">Estado</th>
				</tr>	
			</thead>	
		"""),_display_(Seq[Any](/*24.4*/for(f <- factura.facturaParciales) yield /*24.38*/ {_display_(Seq[Any](format.raw/*24.40*/("""
			<tr>
				<td align="center">"""),_display_(Seq[Any](/*26.25*/(f.nombre))),format.raw/*26.35*/("""</td>
				<td>"""),_display_(Seq[Any](/*27.10*/if(f.proveedor != null)/*27.33*/{_display_(Seq[Any](_display_(Seq[Any](/*27.35*/(f.proveedor.nombre)))))})),format.raw/*27.56*/("""</td>
				<td class="opg">"""),_display_(Seq[Any](/*28.22*/if(f.ordenPago != null)/*28.45*/{_display_(Seq[Any](_display_(Seq[Any](/*28.47*/(f.ordenPago.numero)))))})),format.raw/*28.68*/("""</td>
				<td>"""),_display_(Seq[Any](/*29.10*/(f.numero_factura))),format.raw/*29.28*/("""</td>
				<td class="totalBase" rel=""""),_display_(Seq[Any](/*30.33*/f/*30.34*/.base)),format.raw/*30.39*/("""">"""),_display_(Seq[Any](/*30.42*/if(f.base != null)/*30.60*/{_display_(Seq[Any](_display_(Seq[Any](/*30.62*/(utils.NumberUtils.moneda(f.base))))))})),format.raw/*30.97*/("""</td>
				<td class="totalImpuestos" rel=""""),_display_(Seq[Any](/*31.38*/f/*31.39*/.getTotalImpuesto())),format.raw/*31.58*/("""">"""),_display_(Seq[Any](/*31.61*/(utils.NumberUtils.moneda(f.getTotalImpuesto())))),format.raw/*31.109*/("""</td>
				<td class="total" rel=""""),_display_(Seq[Any](/*32.29*/f/*32.30*/.getTotal())),format.raw/*32.41*/("""">"""),_display_(Seq[Any](/*32.44*/(utils.NumberUtils.moneda(f.getTotal())))),format.raw/*32.84*/("""</td>
				<td class="totalSaldo" rel=""""),_display_(Seq[Any](/*33.34*/f/*33.35*/.getSaldoPendiente())),format.raw/*33.55*/("""">"""),_display_(Seq[Any](/*33.58*/(utils.NumberUtils.moneda(f.getSaldoPendiente())))),format.raw/*33.107*/("""</td>
				<td>"""),_display_(Seq[Any](/*34.10*/if(f.expediente != null)/*34.34*/{_display_(Seq[Any](_display_(Seq[Any](/*34.36*/(f.expediente.getExpedienteEjercicio())))))})),format.raw/*34.76*/("""</td>
				<td>"""),_display_(Seq[Any](/*35.10*/if(f.periodo != null)/*35.31*/{_display_(Seq[Any](_display_(Seq[Any](/*35.33*/(f.periodo.nombre)))))})),format.raw/*35.52*/("""</td>
				<td>"""),_display_(Seq[Any](/*36.10*/if(f.tipoCuenta != null)/*36.34*/{_display_(Seq[Any](_display_(Seq[Any](/*36.36*/f/*36.37*/.tipoCuenta.nombre))))})),format.raw/*36.56*/("""</td>
				<td class="estado" align="center">
						"""),_display_(Seq[Any](/*38.8*/if(f.getSaldoPendiente() != null && !f.getSaldoPendiente().equals(f.base) && (f.estado != null && f.estado.id == 19))/*38.125*/{_display_(Seq[Any](format.raw/*38.126*/("""
							Pagado 
						""")))}/*40.8*/else/*40.12*/{_display_(Seq[Any](format.raw/*40.13*/("""
							"""),_display_(Seq[Any](/*41.9*/if(f.estado != null)/*41.29*/{_display_(Seq[Any](_display_(Seq[Any](/*41.31*/(f.estado.nombre)))))})),format.raw/*41.49*/("""
						""")))})),format.raw/*42.8*/("""
				</td>	
			<tr>
		
		""")))})),format.raw/*46.4*/("""
		</table>
	""")))})),format.raw/*48.3*/("""
</div>"""))}
    }
    
    def render(formularioCarga:Boolean,facturaForm:Form[Factura],factura:Factura): play.api.templates.HtmlFormat.Appendable = apply(formularioCarga,facturaForm,factura)
    
    def f:((Boolean,Form[Factura],Factura) => play.api.templates.HtmlFormat.Appendable) = (formularioCarga,facturaForm,factura) => apply(formularioCarga,facturaForm,factura)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:40 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/facturas/contenidoTabParciales.scala.html
                    HASH: 928f72e95c7be8cdb0027576ef701e002c2b3a41
                    MATRIX: 835->1|1006->78|1092->130|1194->224|1232->225|1872->830|1922->864|1962->866|2031->899|2063->909|2114->924|2146->947|2194->949|2241->970|2304->997|2336->1020|2384->1022|2431->1043|2482->1058|2522->1076|2596->1114|2606->1115|2633->1120|2672->1123|2699->1141|2747->1143|2808->1178|2887->1221|2897->1222|2938->1241|2977->1244|3048->1292|3118->1326|3128->1327|3161->1338|3200->1341|3262->1381|3337->1420|3347->1421|3389->1441|3428->1444|3500->1493|3551->1508|3584->1532|3632->1534|3698->1574|3749->1589|3779->1610|3827->1612|3872->1631|3923->1646|3956->1670|4004->1672|4014->1673|4059->1692|4146->1744|4273->1861|4313->1862|4354->1885|4367->1889|4406->1890|4450->1899|4479->1919|4527->1921|4571->1939|4610->1947|4667->1973|4712->1987
                    LINES: 26->1|29->1|32->4|32->4|32->4|52->24|52->24|52->24|54->26|54->26|55->27|55->27|55->27|55->27|56->28|56->28|56->28|56->28|57->29|57->29|58->30|58->30|58->30|58->30|58->30|58->30|58->30|59->31|59->31|59->31|59->31|59->31|60->32|60->32|60->32|60->32|60->32|61->33|61->33|61->33|61->33|61->33|62->34|62->34|62->34|62->34|63->35|63->35|63->35|63->35|64->36|64->36|64->36|64->36|64->36|66->38|66->38|66->38|68->40|68->40|68->40|69->41|69->41|69->41|69->41|70->42|74->46|76->48
                    -- GENERATED --
                */
            