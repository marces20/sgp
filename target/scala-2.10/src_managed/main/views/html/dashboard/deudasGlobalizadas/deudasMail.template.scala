
package views.html.dashboard.deudasGlobalizadas

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
object deudasMail extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template5[List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(proveedoresDestacados: List[com.avaje.ebean.SqlRow],
proveedoresDestacadosServicios: List[com.avaje.ebean.SqlRow],
proveedoresDestacadosProfe: List[com.avaje.ebean.SqlRow],
proveedoresDestacadosServiciosProfe: List[com.avaje.ebean.SqlRow],
titulo:String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import java.math.BigDecimal;var hayra:Boolean = new Boolean(false);var monto_total_deuda_profe=new java.math.BigDecimal(0);var monto_total_compro_profe=new java.math.BigDecimal(0);var monto_total_deuda_ser_profe=new java.math.BigDecimal(0);var monto_total_compro_ser_profe=new java.math.BigDecimal(0);var monto_total_deuda_ser=new java.math.BigDecimal(0);var monto_total_compro_ser=new java.math.BigDecimal(0);var monto_total_deuda=new java.math.BigDecimal(0);var monto_total_compro=new java.math.BigDecimal(0);


Seq[Any](format.raw/*5.15*/("""
"""),format.raw/*7.1*/("""<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Demystifying Email Design</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body style="margin: 0; padding: 0;">
	"""),_display_(Seq[Any](/*15.3*/if(proveedoresDestacados.size() > 0 || proveedoresDestacadosServicios.size() > 0)/*15.84*/{_display_(Seq[Any](format.raw/*15.85*/("""
	<table border="0" cellpadding="0" cellspacing="0" width="100%">	
		<tr>
			<td style="padding: 10px 0 30px 0;">
				<table align="center" border="0" cellpadding="0" cellspacing="0" width="800" style="border: 1px solid #cccccc; border-collapse: collapse;">
					<tr>
						<td align="center" bgcolor="#70bbd9" style="padding: 10px 0 10px 0; color: #153643; font-size: 14px; font-weight: bold; font-family: Arial, sans-serif;">
							<h1>OPERATIVA """),_display_(Seq[Any](/*22.23*/titulo)),format.raw/*22.29*/("""</h1>
						</td>
					</tr>
					
					"""),_display_(Seq[Any](/*26.7*/if(proveedoresDestacados.size() > 0)/*26.43*/{_display_(Seq[Any](format.raw/*26.44*/("""
					<tr>
						<td bgcolor="#ffffff" style="padding: 10px;">
							<table border="1" cellpadding="0" cellspacing="0" width="100%">
								<tr>
									<td style="padding:10px;font-weight: bold;color: #153643; font-family: Arial, sans-serif; font-size: 12px;">
										<b>PROVEDORES</b>
									</td>
									<td align="center" style="padding:10px;font-weight: bold;color: #153643; font-family: Arial, sans-serif; font-size: 12px;">
										<b>MONTO DEUDA</b>
									</td>
									<td align="center" style="padding:10px;font-weight: bold;color: #153643; font-family: Arial, sans-serif; font-size: 12px;">
										<b>MONTRO COMPROMISO</b>
									</td>
								</tr>
								 """),_display_(Seq[Any](/*41.11*/for(pd <- proveedoresDestacados) yield /*41.43*/ {_display_(Seq[Any](format.raw/*41.45*/("""
									<tr>
										<td style="padding:10px;font-weight: bold; color: #153643; font-family: Arial, sans-serif; font-size: 12px; line-height: 10px;">
											"""),_display_(Seq[Any](/*44.13*/pd/*44.15*/.getString("nombre_proveedor"))),format.raw/*44.45*/("""
										</td>
										<td align="right" style="padding:10px; color: #153643; font-family: Arial, sans-serif; font-size: 12px; line-height: 10px;">"""),_display_(Seq[Any](/*46.136*/utils/*46.141*/.NumberUtils.moneda(pd.getBigDecimal("total_deuda")))),format.raw/*46.193*/("""</td>
										<td align="right" style="padding:10px; color: #153643; font-family: Arial, sans-serif; font-size: 12px; line-height: 10px;">"""),_display_(Seq[Any](/*47.136*/utils/*47.141*/.NumberUtils.moneda(pd.getBigDecimal("total_compromiso")))),format.raw/*47.198*/("""</td>
									</tr>
									"""),_display_(Seq[Any](/*49.11*/{monto_total_deuda= monto_total_deuda.add(pd.getBigDecimal("total_deuda"))})),format.raw/*49.86*/("""
									"""),_display_(Seq[Any](/*50.11*/{monto_total_compro= monto_total_compro.add(pd.getBigDecimal("total_compromiso"))})),format.raw/*50.93*/("""
								""")))})),format.raw/*51.10*/("""	
									<tr>
										<td align="right" style="padding:10px;font-weight: bold;color: #153643; font-family: Arial, sans-serif; font-size: 12px;">
											<b>TOTAL</b>
										</td>
										<td align="right" style="padding:10px;font-weight: bold;color: #153643; font-family: Arial, sans-serif; font-size: 13px;">
											<b>"""),_display_(Seq[Any](/*57.16*/utils/*57.21*/.NumberUtils.moneda(monto_total_deuda))),format.raw/*57.59*/("""</b>
										</td>
										<td align="right" style="padding:10px;font-weight: bold;color: #153643; font-family: Arial, sans-serif; font-size: 13px;">
											<b>"""),_display_(Seq[Any](/*60.16*/utils/*60.21*/.NumberUtils.moneda(monto_total_compro))),format.raw/*60.60*/("""</b>
										</td>
									</tr>
								
							</table>
							
						</td>
					</tr> 
					""")))})),format.raw/*68.7*/("""
					
					"""),_display_(Seq[Any](/*70.7*/if(proveedoresDestacadosServicios.size() > 0)/*70.52*/{_display_(Seq[Any](format.raw/*70.53*/("""
					<tr>
						<td bgcolor="#ffffff" style="padding: 10px;">
							<table border="1" cellpadding="0" cellspacing="0" width="100%">
								<tr align="center">
									<td colspan="3" style="padding:10px;font-weight: bold;color: #153643; font-family: Arial, sans-serif; font-size: 12px;">
										<b>SERVICIOS</b>
									</td>
								</tr>
								<tr>
									<td style="padding:10px;font-weight: bold;color: #153643; font-family: Arial, sans-serif; font-size: 12px;">
										<b>PROVEDORES</b>
									</td>
									<td align="center" style="padding:10px;font-weight: bold;color: #153643; font-family: Arial, sans-serif; font-size: 12px;">
										<b>MONTO DEUDA</b>
									</td>
									<td align="center" style="padding:10px;font-weight: bold;color: #153643; font-family: Arial, sans-serif; font-size: 12px;">
										<b>MONTRO COMPROMISO</b>
									</td>
								</tr>
								 
								"""),_display_(Seq[Any](/*91.10*/for(pd <- proveedoresDestacadosServicios) yield /*91.51*/ {_display_(Seq[Any](format.raw/*91.53*/("""
									<tr>
										<td style="padding:10px;font-weight: bold; color: #153643; font-family: Arial, sans-serif; font-size: 12px; line-height: 10px;">
											"""),_display_(Seq[Any](/*94.13*/pd/*94.15*/.getString("nombre_proveedor"))),format.raw/*94.45*/("""
										</td>
										<td align="right" style="padding:10px; color: #153643; font-family: Arial, sans-serif; font-size: 12px; line-height: 10px;">"""),_display_(Seq[Any](/*96.136*/utils/*96.141*/.NumberUtils.moneda(pd.getBigDecimal("total_deuda")))),format.raw/*96.193*/("""</td>
										<td align="right" style="padding:10px; color: #153643; font-family: Arial, sans-serif; font-size: 12px; line-height: 10px;">"""),_display_(Seq[Any](/*97.136*/utils/*97.141*/.NumberUtils.moneda(pd.getBigDecimal("total_compromiso")))),format.raw/*97.198*/("""</td>
									</tr>
									"""),_display_(Seq[Any](/*99.11*/{monto_total_deuda_ser= monto_total_deuda_ser.add(pd.getBigDecimal("total_deuda"))})),format.raw/*99.94*/("""
									"""),_display_(Seq[Any](/*100.11*/{monto_total_compro_ser= monto_total_compro_ser.add(pd.getBigDecimal("total_compromiso"))})),format.raw/*100.101*/("""
								""")))})),format.raw/*101.10*/("""	
								<tr>
									<td align="right" style="padding:5px;font-weight: bold;color: #153643; font-family: Arial, sans-serif; font-size: 12px;">
										<b>TOTAL</b>
									</td>
									<td align="center" style="padding:5px;font-weight: bold;color: #153643; font-family: Arial, sans-serif; font-size: 13px;">
										<b>"""),_display_(Seq[Any](/*107.15*/utils/*107.20*/.NumberUtils.moneda(monto_total_deuda_ser))),format.raw/*107.62*/("""</b>
									</td>
									<td align="center" style="padding:5px;font-weight: bold;color: #153643; font-family: Arial, sans-serif; font-size: 13px;">
										<b>"""),_display_(Seq[Any](/*110.15*/utils/*110.20*/.NumberUtils.moneda(monto_total_compro_ser))),format.raw/*110.63*/("""</b>
									</td>
								</tr>
							</table>
							
						</td>
					</tr> 
					""")))})),format.raw/*117.7*/("""
					<tr><td bgcolor="#ee4c50" style="padding: 10px;"></td></tr>
				</table>
			</td>
		</tr>
	</table>
	""")))})),format.raw/*123.3*/("""
	
	"""),_display_(Seq[Any](/*125.3*/if(proveedoresDestacadosProfe.size() > 0 || proveedoresDestacadosProfe.size() > 0)/*125.85*/{_display_(Seq[Any](format.raw/*125.86*/("""
	<table border="0" cellpadding="0" cellspacing="0" width="100%">	
		<tr>
			<td style="padding: 10px 0 30px 0;">
				<table align="center" border="0" cellpadding="0" cellspacing="0" width="800" style="border: 1px solid #cccccc; border-collapse: collapse;">
					<tr>
						<td align="center" bgcolor="#70bbd9" style="padding: 10px 0 10px 0; color: #153643; font-size: 14px; font-weight: bold; font-family: Arial, sans-serif;">
							<h1>PROFE """),_display_(Seq[Any](/*132.19*/titulo)),format.raw/*132.25*/("""</h1>
						</td>
					</tr>
					
					
					"""),_display_(Seq[Any](/*137.7*/if(proveedoresDestacadosProfe.size() > 0)/*137.48*/{_display_(Seq[Any](format.raw/*137.49*/("""
					<tr>
						<td bgcolor="#ffffff" style="padding: 10px;">
							<table border="1" cellpadding="0" cellspacing="0" width="100%">
								<tr>
									<td style="padding:10px;font-weight: bold;color: #153643; font-family: Arial, sans-serif; font-size: 12px;">
										<b>PROVEDORES</b>
									</td>
									<td align="center" style="padding:10px;font-weight: bold;color: #153643; font-family: Arial, sans-serif; font-size: 12px;">
										<b>MONTO DEUDA</b>
									</td>
									<td align="center" style="padding:10px;font-weight: bold;color: #153643; font-family: Arial, sans-serif; font-size: 12px;">
										<b>MONTRO COMPROMISO</b>
									</td>
								</tr>
								 """),_display_(Seq[Any](/*152.11*/for(pd <- proveedoresDestacadosProfe) yield /*152.48*/ {_display_(Seq[Any](format.raw/*152.50*/("""
									<tr>
										<td style="padding:10px;font-weight: bold; color: #153643; font-family: Arial, sans-serif; font-size: 12px; line-height: 10px;">
											"""),_display_(Seq[Any](/*155.13*/pd/*155.15*/.getString("nombre_proveedor"))),format.raw/*155.45*/("""
										</td>
										<td align="right" style="padding:10px; color: #153643; font-family: Arial, sans-serif; font-size: 12px; line-height: 10px;">"""),_display_(Seq[Any](/*157.136*/utils/*157.141*/.NumberUtils.moneda(pd.getBigDecimal("total_deuda")))),format.raw/*157.193*/("""</td>
										<td align="right" style="padding:10px; color: #153643; font-family: Arial, sans-serif; font-size: 12px; line-height: 10px;">"""),_display_(Seq[Any](/*158.136*/utils/*158.141*/.NumberUtils.moneda(pd.getBigDecimal("total_compromiso")))),format.raw/*158.198*/("""</td>
									</tr>
									"""),_display_(Seq[Any](/*160.11*/{monto_total_deuda_profe= monto_total_deuda_profe.add(pd.getBigDecimal("total_deuda"))})),format.raw/*160.98*/("""
									"""),_display_(Seq[Any](/*161.11*/{monto_total_compro_profe= monto_total_compro_profe.add(pd.getBigDecimal("total_compromiso"))})),format.raw/*161.105*/("""
								""")))})),format.raw/*162.10*/("""	
									<tr>
										<td align="right" style="padding:10px;font-weight: bold;color: #153643; font-family: Arial, sans-serif; font-size: 12px;">
											<b>TOTAL</b>
										</td>
										<td align="right" style="padding:10px;font-weight: bold;color: #153643; font-family: Arial, sans-serif; font-size: 13px;">
											<b>"""),_display_(Seq[Any](/*168.16*/utils/*168.21*/.NumberUtils.moneda(monto_total_deuda_profe))),format.raw/*168.65*/("""</b>
										</td>
										<td align="right" style="padding:10px;font-weight: bold;color: #153643; font-family: Arial, sans-serif; font-size: 13px;">
											<b>"""),_display_(Seq[Any](/*171.16*/utils/*171.21*/.NumberUtils.moneda(monto_total_compro_profe))),format.raw/*171.66*/("""</b>
										</td>
									</tr>
								
							</table>
							
						</td>
					</tr> 
					""")))})),format.raw/*179.7*/("""
					
					"""),_display_(Seq[Any](/*181.7*/if(proveedoresDestacadosServiciosProfe.size() > 0)/*181.57*/{_display_(Seq[Any](format.raw/*181.58*/("""
					<tr>
						<td bgcolor="#ffffff" style="padding: 10px;">
							<table border="1" cellpadding="0" cellspacing="0" width="100%">
								<tr align="center">
									<td colspan="3" style="padding:10px;font-weight: bold;color: #153643; font-family: Arial, sans-serif; font-size: 12px;">
										<b>SERVICIOS</b>
									</td>
								</tr>
								<tr>
									<td style="padding:10px;font-weight: bold;color: #153643; font-family: Arial, sans-serif; font-size: 12px;">
										<b>PROVEDORES</b>
									</td>
									<td align="center" style="padding:10px;font-weight: bold;color: #153643; font-family: Arial, sans-serif; font-size: 12px;">
										<b>MONTO DEUDA</b>
									</td>
									<td align="center" style="padding:10px;font-weight: bold;color: #153643; font-family: Arial, sans-serif; font-size: 12px;">
										<b>MONTRO COMPROMISO</b>
									</td>
								</tr>
								 
								"""),_display_(Seq[Any](/*202.10*/for(pd <- proveedoresDestacadosServiciosProfe) yield /*202.56*/ {_display_(Seq[Any](format.raw/*202.58*/("""
									<tr>
										<td style="padding:10px;font-weight: bold; color: #153643; font-family: Arial, sans-serif; font-size: 12px; line-height: 10px;">
											"""),_display_(Seq[Any](/*205.13*/pd/*205.15*/.getString("nombre_proveedor"))),format.raw/*205.45*/("""
										</td>
										<td align="right" style="padding:10px; color: #153643; font-family: Arial, sans-serif; font-size: 12px; line-height: 10px;">"""),_display_(Seq[Any](/*207.136*/utils/*207.141*/.NumberUtils.moneda(pd.getBigDecimal("total_deuda")))),format.raw/*207.193*/("""</td>
										<td align="right" style="padding:10px; color: #153643; font-family: Arial, sans-serif; font-size: 12px; line-height: 10px;">"""),_display_(Seq[Any](/*208.136*/utils/*208.141*/.NumberUtils.moneda(pd.getBigDecimal("total_compromiso")))),format.raw/*208.198*/("""</td>
									</tr>
									"""),_display_(Seq[Any](/*210.11*/{monto_total_deuda_ser_profe= monto_total_deuda_ser_profe.add(pd.getBigDecimal("total_deuda"))})),format.raw/*210.106*/("""
									"""),_display_(Seq[Any](/*211.11*/{monto_total_compro_ser_profe= monto_total_compro_ser_profe.add(pd.getBigDecimal("total_compromiso"))})),format.raw/*211.113*/("""
								""")))})),format.raw/*212.10*/("""	
								<tr>
									<td align="right" style="padding:5px;font-weight: bold;color: #153643; font-family: Arial, sans-serif; font-size: 12px;">
										<b>TOTAL</b>
									</td>
									<td align="center" style="padding:5px;font-weight: bold;color: #153643; font-family: Arial, sans-serif; font-size: 13px;">
										<b>"""),_display_(Seq[Any](/*218.15*/utils/*218.20*/.NumberUtils.moneda(monto_total_deuda_ser_profe))),format.raw/*218.68*/("""</b>
									</td>
									<td align="center" style="padding:5px;font-weight: bold;color: #153643; font-family: Arial, sans-serif; font-size: 13px;">
										<b>"""),_display_(Seq[Any](/*221.15*/utils/*221.20*/.NumberUtils.moneda(monto_total_compro_ser_profe))),format.raw/*221.69*/("""</b>
									</td>
								</tr>
							</table>
							
						</td>
					</tr> 
					""")))})),format.raw/*228.7*/(""" 
					
					<tr><td bgcolor="#ee4c50" style="padding: 10px;"></td></tr>
				</table>
			</td>
		</tr>
	</table>
	""")))})),format.raw/*235.3*/("""
</body>
</html>"""))}
    }
    
    def render(proveedoresDestacados:List[com.avaje.ebean.SqlRow],proveedoresDestacadosServicios:List[com.avaje.ebean.SqlRow],proveedoresDestacadosProfe:List[com.avaje.ebean.SqlRow],proveedoresDestacadosServiciosProfe:List[com.avaje.ebean.SqlRow],titulo:String): play.api.templates.HtmlFormat.Appendable = apply(proveedoresDestacados,proveedoresDestacadosServicios,proveedoresDestacadosProfe,proveedoresDestacadosServiciosProfe,titulo)
    
    def f:((List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],String) => play.api.templates.HtmlFormat.Appendable) = (proveedoresDestacados,proveedoresDestacadosServicios,proveedoresDestacadosProfe,proveedoresDestacadosServiciosProfe,titulo) => apply(proveedoresDestacados,proveedoresDestacadosServicios,proveedoresDestacadosProfe,proveedoresDestacadosServiciosProfe,titulo)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:56 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/deudasGlobalizadas/deudasMail.scala.html
                    HASH: 62079bef4e684a5ff74e7406c1f06ac1da330c6a
                    MATRIX: 924->1|1785->256|1812->770|2251->1174|2341->1255|2380->1256|2866->1706|2894->1712|2970->1753|3015->1789|3054->1790|3782->2482|3830->2514|3870->2516|4072->2682|4083->2684|4135->2714|4324->2866|4339->2871|4414->2923|4592->3064|4607->3069|4687->3126|4754->3157|4851->3232|4898->3243|5002->3325|5044->3335|5417->3672|5431->3677|5491->3715|5696->3884|5710->3889|5771->3928|5901->4027|5949->4040|6003->4085|6042->4086|6993->5001|7050->5042|7090->5044|7292->5210|7303->5212|7355->5242|7544->5394|7559->5399|7634->5451|7812->5592|7827->5597|7907->5654|7974->5685|8079->5768|8127->5779|8241->5869|8284->5879|8651->6209|8666->6214|8731->6256|8934->6422|8949->6427|9015->6470|9135->6558|9275->6666|9316->6671|9408->6753|9448->6754|9931->7200|9960->7206|10043->7253|10094->7294|10134->7295|10863->7987|10917->8024|10958->8026|11161->8192|11173->8194|11226->8224|11416->8376|11432->8381|11508->8433|11687->8574|11703->8579|11784->8636|11852->8667|11962->8754|12010->8765|12128->8859|12171->8869|12545->9206|12560->9211|12627->9255|12833->9424|12848->9429|12916->9474|13047->9573|13096->9586|13156->9636|13196->9637|14148->10552|14211->10598|14252->10600|14455->10766|14467->10768|14520->10798|14710->10950|14726->10955|14802->11007|14981->11148|14997->11153|15078->11210|15146->11241|15265->11336|15313->11347|15439->11449|15482->11459|15849->11789|15864->11794|15935->11842|16138->12008|16153->12013|16225->12062|16345->12150|16492->12265
                    LINES: 26->1|34->5|35->7|43->15|43->15|43->15|50->22|50->22|54->26|54->26|54->26|69->41|69->41|69->41|72->44|72->44|72->44|74->46|74->46|74->46|75->47|75->47|75->47|77->49|77->49|78->50|78->50|79->51|85->57|85->57|85->57|88->60|88->60|88->60|96->68|98->70|98->70|98->70|119->91|119->91|119->91|122->94|122->94|122->94|124->96|124->96|124->96|125->97|125->97|125->97|127->99|127->99|128->100|128->100|129->101|135->107|135->107|135->107|138->110|138->110|138->110|145->117|151->123|153->125|153->125|153->125|160->132|160->132|165->137|165->137|165->137|180->152|180->152|180->152|183->155|183->155|183->155|185->157|185->157|185->157|186->158|186->158|186->158|188->160|188->160|189->161|189->161|190->162|196->168|196->168|196->168|199->171|199->171|199->171|207->179|209->181|209->181|209->181|230->202|230->202|230->202|233->205|233->205|233->205|235->207|235->207|235->207|236->208|236->208|236->208|238->210|238->210|239->211|239->211|240->212|246->218|246->218|246->218|249->221|249->221|249->221|256->228|263->235
                    -- GENERATED --
                */
            