
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
object pagadoNoEntregados extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[List[models.informes.InformeDeudaProveedoresMaterializada],String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lista: List[models.informes.InformeDeudaProveedoresMaterializada],titulo:String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import java.math.BigDecimal;var hayra:Boolean = new Boolean(false);var monto_total_pagado=new java.math.BigDecimal(0);var monto_total_acta=new java.math.BigDecimal(0);


Seq[Any](format.raw/*1.83*/("""

"""),format.raw/*4.1*/("""
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Demystifying Email Design</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body style="margin: 0; padding: 0;">
<table border="0" cellpadding="0" cellspacing="0" width="100%">	
		<tr>
			<td style="padding: 10px 0 30px 0;">
				<table align="center" border="0" cellpadding="0" cellspacing="0" width="800" style="border: 1px solid #cccccc; border-collapse: collapse;">
					<tr>
						<td align="center" bgcolor="#70bbd9" style="padding: 10px 0 10px 0; color: #153643; font-size: 14px; font-weight: bold; font-family: Arial, sans-serif;">
							<h1>"""),_display_(Seq[Any](/*19.13*/titulo)),format.raw/*19.19*/("""</h1>
						</td>
					</tr>
					<tr>
						<td bgcolor="#ffffff" style="padding: 10px;">
							<table border="1" cellpadding="0" cellspacing="0" width="100%">
								<tr>
									<td style="padding:10px;font-weight: bold;color: #153643; font-family: Arial, sans-serif; font-size: 12px;">
										<b>EXP</b>
									</td>
									<td style="padding:10px;font-weight: bold;color: #153643; font-family: Arial, sans-serif; font-size: 12px;">
										<b>PROVEDORES</b>
									</td>
									<td align="center" style="padding:10px;font-weight: bold;color: #153643; font-family: Arial, sans-serif; font-size: 12px;">
										<b>MONTO PAGADO</b>
									</td>
									<td align="center" style="padding:10px;font-weight: bold;color: #153643; font-family: Arial, sans-serif; font-size: 12px;">
										<b>MONTRO ENTREGADO</b>
									</td>
									<td align="center" style="padding:10px;font-weight: bold;color: #153643; font-family: Arial, sans-serif; font-size: 12px;">
										<b>DIFERENCIA</b>
									</td>
								</tr>
								 """),_display_(Seq[Any](/*42.11*/for(pd <- lista) yield /*42.27*/ {_display_(Seq[Any](format.raw/*42.29*/("""
									<tr>
										<td style="padding:10px;font-weight: bold; color: #153643; font-family: Arial, sans-serif; font-size: 12px; line-height: 10px;">
											"""),_display_(Seq[Any](/*45.13*/pd/*45.15*/.expediente)),format.raw/*45.26*/("""
										</td>
										<td style="padding:10px;font-weight: bold; color: #153643; font-family: Arial, sans-serif; font-size: 12px; line-height: 10px;">
											"""),_display_(Seq[Any](/*48.13*/pd/*48.15*/.nombreProveedor)),format.raw/*48.31*/("""
										</td>
										<td align="right" style="padding:10px; color: #153643; font-family: Arial, sans-serif; font-size: 12px; line-height: 10px;">"""),_display_(Seq[Any](/*50.136*/utils/*50.141*/.NumberUtils.moneda(pd.totalPagado))),format.raw/*50.176*/("""</td>
										<td align="right" style="padding:10px; color: #153643; font-family: Arial, sans-serif; font-size: 12px; line-height: 10px;">"""),_display_(Seq[Any](/*51.136*/utils/*51.141*/.NumberUtils.moneda(pd.totalActasSinAdelanto))),format.raw/*51.186*/("""</td>
										<td align="right" style="padding:10px; color: #153643; font-family: Arial, sans-serif; font-size: 12px; line-height: 10px;">"""),_display_(Seq[Any](/*52.136*/utils/*52.141*/.NumberUtils.moneda(pd.totalPagado.subtract(pd.totalActasSinAdelanto)))),format.raw/*52.211*/("""</td>
									</tr>
									"""),_display_(Seq[Any](/*54.11*/{monto_total_pagado= monto_total_pagado.add(pd.totalPagado)})),format.raw/*54.71*/("""
									"""),_display_(Seq[Any](/*55.11*/{monto_total_acta= monto_total_acta.add(pd.totalActasSinAdelanto)})),format.raw/*55.77*/("""
								""")))})),format.raw/*56.10*/("""
								<tr>
									<td></td>
									<td align="right" style="padding:10px;font-weight: bold;color: #153643; font-family: Arial, sans-serif; font-size: 12px;">
										<b>TOTAL</b>
									</td>
									<td align="right" style="padding:10px;font-weight: bold;color: #153643; font-family: Arial, sans-serif; font-size: 13px;">
										<b>"""),_display_(Seq[Any](/*63.15*/utils/*63.20*/.NumberUtils.moneda(monto_total_pagado))),format.raw/*63.59*/("""</b>
									</td>
									<td align="right" style="padding:10px;monto_total_acta: bold;color: #153643; font-family: Arial, sans-serif; font-size: 13px;">
										<b>"""),_display_(Seq[Any](/*66.15*/utils/*66.20*/.NumberUtils.moneda(monto_total_acta))),format.raw/*66.57*/("""</b>
									</td>
									<td align="right" style="padding:10px;monto_total_acta: bold;color: #153643; font-family: Arial, sans-serif; font-size: 13px;">
										<b>"""),_display_(Seq[Any](/*69.15*/utils/*69.20*/.NumberUtils.moneda(monto_total_pagado.subtract(monto_total_acta)))),format.raw/*69.86*/("""</b>
									</td>
								</tr>	
							</table>
						</td>
					</tr> 
					<tr><td bgcolor="#ee4c50" style="padding: 10px;"></td></tr>
				</table>
			</td>
		</tr>
	</table>			
</body>
</html>"""))}
    }
    
    def render(lista:List[models.informes.InformeDeudaProveedoresMaterializada],titulo:String): play.api.templates.HtmlFormat.Appendable = apply(lista,titulo)
    
    def f:((List[models.informes.InformeDeudaProveedoresMaterializada],String) => play.api.templates.HtmlFormat.Appendable) = (lista,titulo) => apply(lista,titulo)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:56 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/deudasGlobalizadas/pagadoNoEntregados.scala.html
                    HASH: 1ec72f54aadc88efc015b574241184859573bd4c
                    MATRIX: 875->1|1218->82|1246->253|2123->1094|2151->1100|3237->2150|3269->2166|3309->2168|3511->2334|3522->2336|3555->2347|3759->2515|3770->2517|3808->2533|3997->2685|4012->2690|4070->2725|4248->2866|4263->2871|4331->2916|4509->3057|4524->3062|4617->3132|4684->3163|4766->3223|4813->3234|4901->3300|4943->3310|5328->3659|5342->3664|5403->3703|5610->3874|5624->3879|5683->3916|5890->4087|5904->4092|5992->4158
                    LINES: 26->1|30->1|32->4|47->19|47->19|70->42|70->42|70->42|73->45|73->45|73->45|76->48|76->48|76->48|78->50|78->50|78->50|79->51|79->51|79->51|80->52|80->52|80->52|82->54|82->54|83->55|83->55|84->56|91->63|91->63|91->63|94->66|94->66|94->66|97->69|97->69|97->69
                    -- GENERATED --
                */
            