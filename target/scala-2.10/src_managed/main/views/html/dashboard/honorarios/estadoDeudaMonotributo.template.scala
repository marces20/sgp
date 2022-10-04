
package views.html.dashboard.honorarios

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
object estadoDeudaMonotributo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template8[java.util.Map[Long, java.util.List[Factura]],java.util.Map[Long, String],java.util.Map[Long, java.math.BigDecimal],java.util.Map[Long, java.math.BigDecimal],java.util.Map[Long, java.math.BigDecimal],java.math.BigDecimal,java.math.BigDecimal,java.math.BigDecimal,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(listFactura: java.util.Map[Long,java.util.List[Factura]],
mapPeriodo: java.util.Map[Long,String],
totalPeriodo: java.util.Map[Long,java.math.BigDecimal],
totalImpuestoPeriodo: java.util.Map[Long,java.math.BigDecimal],
totalNetoPeriodo: java.util.Map[Long,java.math.BigDecimal],
total:java.math.BigDecimal,
totalImpuesto:java.math.BigDecimal,
totalNeto:java.math.BigDecimal):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*10.2*/implicitFieldConstructor/*10.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*8.32*/("""
"""),format.raw/*10.70*/(""" 
"""),_display_(Seq[Any](/*11.2*/views/*11.7*/.html.dashboard.mainDashboard("Estado de deudas - Honorarios Monotributo")/*11.81*/ {_display_(Seq[Any](format.raw/*11.83*/("""
<div class="page-header">
	<div class="row">
		<div class="col-sm-7"><h1>Estado de deudas - Honorarios Monotributo</h1></div>
		<div class="col-sm-5">
			<div class="dropdown pull-right">
			 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
			 	<i class="glyphicon glyphicon-list-alt"></i>
			    Reportes
			    <span class="caret"></span>
			  </button>
			  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
			  	<li><a href=""""),_display_(Seq[Any](/*23.21*/controllers/*23.32*/.dashboard.routes.HonorariosController.estadoDeudaMonotributoExcel())),format.raw/*23.100*/(""""> Exportar listado Excel</a></li>
			  	<li><a href=""""),_display_(Seq[Any](/*24.21*/controllers/*24.32*/.dashboard.routes.HonorariosController.estadoDeudaMonotributoExcelProfe())),format.raw/*24.105*/(""""> Exportar listado PROFE Excel</a></li>
			  </ul>
			</div>
		</div>
	</div>
</div>
<div class="row">		
	<table class="table table-striped table-bordered">
	<tbody>	
		
			"""),_display_(Seq[Any](/*34.5*/for((key,value) <- listFactura) yield /*34.36*/ {_display_(Seq[Any](format.raw/*34.38*/("""
				<tr>
					<td colspan="5" align="center"><b>"""),_display_(Seq[Any](/*36.41*/mapPeriodo/*36.51*/.get(key))),format.raw/*36.60*/("""</b></td>
				</tr>
				<tr>
					<td><b>Nombre</b></td>
					<td align="center"><b>Expediente</b></td>
					<td align="center"><b>Base</b></td>
					<td align="center"><b>Total impuestos</b></td>
					<td align="center"><b>Total</b></td>
				</tr>
				"""),_display_(Seq[Any](/*45.6*/for(factura <- value) yield /*45.27*/ {_display_(Seq[Any](format.raw/*45.29*/("""
					<tr>
						<td>"""),_display_(Seq[Any](/*47.12*/factura/*47.19*/.proveedor.nombre)),format.raw/*47.36*/("""</td>
						<td align="center">"""),_display_(Seq[Any](/*48.27*/factura/*48.34*/.expediente.getExpedienteEjercicio())),format.raw/*48.70*/("""</td>
						<td align="center">"""),_display_(Seq[Any](/*49.27*/utils/*49.32*/.NumberUtils.moneda(factura.getBase()))),format.raw/*49.70*/("""</td>
						<td align="center">"""),_display_(Seq[Any](/*50.27*/utils/*50.32*/.NumberUtils.moneda(factura.getTotalImpuesto()))),format.raw/*50.79*/("""</td>
						<td align="center">"""),_display_(Seq[Any](/*51.27*/utils/*51.32*/.NumberUtils.moneda(factura.getTotal()))),format.raw/*51.71*/("""</td>
					</tr>
				""")))})),format.raw/*53.6*/("""
				<tr>
					
					<td colspan="2" align="right"><b>TOTALES:</b></td>
					<td align="center"><b>"""),_display_(Seq[Any](/*57.29*/utils/*57.34*/.NumberUtils.moneda(totalPeriodo.get(key)))),format.raw/*57.76*/("""</b></td>
					<td align="center"><b>"""),_display_(Seq[Any](/*58.29*/utils/*58.34*/.NumberUtils.moneda(totalImpuestoPeriodo.get(key)))),format.raw/*58.84*/("""</b></td>
					<td align="center"><b>"""),_display_(Seq[Any](/*59.29*/utils/*59.34*/.NumberUtils.moneda(totalNetoPeriodo.get(key)))),format.raw/*59.80*/("""</b></td>
				</tr>
				<tr>
					<td colspan="5" align="center">&nbsp;</td>
				</tr>
			""")))})),format.raw/*64.5*/("""
			<tr>
				<td colspan="2" align="right"><b style="font-size:20px;">TOTALES:</b></td>
				<td align="center"><b style="font-size:20px;">"""),_display_(Seq[Any](/*67.52*/utils/*67.57*/.NumberUtils.moneda(total))),format.raw/*67.83*/("""</b></td>
				<td align="center"><b style="font-size:20px;">"""),_display_(Seq[Any](/*68.52*/utils/*68.57*/.NumberUtils.moneda(totalImpuesto))),format.raw/*68.91*/("""</b></td>
				<td align="center"><b style="font-size:20px;">"""),_display_(Seq[Any](/*69.52*/utils/*69.57*/.NumberUtils.moneda(totalNeto))),format.raw/*69.87*/("""</b></td>
				
			</tr>
	</tbody>
	</table>
</div>	
""")))})))}
    }
    
    def render(listFactura:java.util.Map[Long, java.util.List[Factura]],mapPeriodo:java.util.Map[Long, String],totalPeriodo:java.util.Map[Long, java.math.BigDecimal],totalImpuestoPeriodo:java.util.Map[Long, java.math.BigDecimal],totalNetoPeriodo:java.util.Map[Long, java.math.BigDecimal],total:java.math.BigDecimal,totalImpuesto:java.math.BigDecimal,totalNeto:java.math.BigDecimal): play.api.templates.HtmlFormat.Appendable = apply(listFactura,mapPeriodo,totalPeriodo,totalImpuestoPeriodo,totalNetoPeriodo,total,totalImpuesto,totalNeto)
    
    def f:((java.util.Map[Long, java.util.List[Factura]],java.util.Map[Long, String],java.util.Map[Long, java.math.BigDecimal],java.util.Map[Long, java.math.BigDecimal],java.util.Map[Long, java.math.BigDecimal],java.math.BigDecimal,java.math.BigDecimal,java.math.BigDecimal) => play.api.templates.HtmlFormat.Appendable) = (listFactura,mapPeriodo,totalPeriodo,totalImpuestoPeriodo,totalNetoPeriodo,total,totalImpuesto,totalNeto) => apply(listFactura,mapPeriodo,totalPeriodo,totalImpuestoPeriodo,totalNetoPeriodo,total,totalImpuesto,totalNeto)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:56 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/honorarios/estadoDeudaMonotributo.scala.html
                    HASH: 359e72e65c2c9e150035f3dbe2e3006301a8c9f3
                    MATRIX: 1067->1|1544->394|1577->418|1651->375|1680->462|1718->465|1731->470|1814->544|1854->546|2400->1056|2420->1067|2511->1135|2602->1190|2622->1201|2718->1274|2928->1449|2975->1480|3015->1482|3101->1532|3120->1542|3151->1551|3440->1805|3477->1826|3517->1828|3575->1850|3591->1857|3630->1874|3698->1906|3714->1913|3772->1949|3840->1981|3854->1986|3914->2024|3982->2056|3996->2061|4065->2108|4133->2140|4147->2145|4208->2184|4261->2206|4397->2306|4411->2311|4475->2353|4549->2391|4563->2396|4635->2446|4709->2484|4723->2489|4791->2535|4913->2626|5088->2765|5102->2770|5150->2796|5247->2857|5261->2862|5317->2896|5414->2957|5428->2962|5480->2992
                    LINES: 26->1|36->10|36->10|37->8|38->10|39->11|39->11|39->11|39->11|51->23|51->23|51->23|52->24|52->24|52->24|62->34|62->34|62->34|64->36|64->36|64->36|73->45|73->45|73->45|75->47|75->47|75->47|76->48|76->48|76->48|77->49|77->49|77->49|78->50|78->50|78->50|79->51|79->51|79->51|81->53|85->57|85->57|85->57|86->58|86->58|86->58|87->59|87->59|87->59|92->64|95->67|95->67|95->67|96->68|96->68|96->68|97->69|97->69|97->69
                    -- GENERATED --
                */
            