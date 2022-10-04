
package views.html.dashboard.deudasPorAntiguedad

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
object deudasDetallesCuenta extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[List[com.avaje.ebean.SqlRow],DynamicForm,Integer,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(listaFinal:List[com.avaje.ebean.SqlRow],formBuscador: DynamicForm,idCuenta:Integer):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import java.math.BigDecimal;var ptmpcompromiso=new java.math.BigDecimal(0);var ptmpdeuda=new java.math.BigDecimal(0);var mtdoh=new java.math.BigDecimal(0);var mtcoh=new java.math.BigDecimal(0);var mtdoo=new java.math.BigDecimal(0);var mtcoo=new java.math.BigDecimal(0);var mtdos=new java.math.BigDecimal(0);var mtcos=new java.math.BigDecimal(0);var mtdph=new java.math.BigDecimal(0);var mtcph=new java.math.BigDecimal(0);var mtdpo=new java.math.BigDecimal(0);var mtcpo=new java.math.BigDecimal(0);var mtdps=new java.math.BigDecimal(0);var mtcps=new java.math.BigDecimal(0)

import java.lang.Integer;var proveedorId =0;var bandera =0;var xx =0

import java.lang.String;var institucionNombre ="";var fecha ="";var proveedor =""


Seq[Any](format.raw/*1.86*/("""
"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.dashboard.mainDashboard("Deudas Detalles Por Cuenta")/*5.66*/ {_display_(Seq[Any](format.raw/*5.68*/("""

"""),_display_(Seq[Any](/*7.2*/views/*7.7*/.html.dashboard.deudasPorAntiguedad.navdeudas(formBuscador))),format.raw/*7.66*/("""

<div class="page-header">
	<div class="row">
		<div class="col-sm-7">
			<h1>Deudas Detalles por Cuenta</h1>
		</div>
		
		<div class="col-sm-5">
			<div class="dropdown pull-right">
			 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
			 	<i class="glyphicon glyphicon-list-alt"></i>
			    Reportes
			    <span class="caret"></span>
			  </button>
			  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
			  	<li role="presentation">
				  <a id="" role="menuitem" tabindex="-1" 
				  href=""""),_display_(Seq[Any](/*25.14*/controllers/*25.25*/.dashboard.routes.DeudasPorAntiguedadReportesController.deudasDetallesReporte(0,false,idCuenta,true))),format.raw/*25.125*/("""">Reporte Excel</a></li>
			  	
			  </ul>
			</div>
		</div>
	</div>
</div>

<div class="row"  style="">
	<div class="col-sm-12" style="">
		 
			"""),_display_(Seq[Any](/*36.5*/if(listaFinal != null)/*36.27*/{_display_(Seq[Any](format.raw/*36.28*/("""
				"""),_display_(Seq[Any](/*37.6*/if(listaFinal.size() > 0)/*37.31*/{_display_(Seq[Any](format.raw/*37.32*/("""
					<table class="table table-striped table-bordered table-hover" id="listaInforme">
						"""),_display_(Seq[Any](/*39.8*/views/*39.13*/.html.dashboard.deudasPorAntiguedad.tablaDetalles("OPERATIVA","",proveedor))),format.raw/*39.88*/("""
						<tbody>
							
							"""),_display_(Seq[Any](/*42.9*/for(s <- listaFinal) yield /*42.29*/{_display_(Seq[Any](format.raw/*42.30*/("""
								"""),_display_(Seq[Any](/*43.10*/{xx = 1})),format.raw/*43.18*/("""
								 
								
								"""),_display_(Seq[Any](/*46.10*/{ptmpdeuda = ptmpdeuda.add(s.getBigDecimal("total_deuda"))})),format.raw/*46.69*/("""
								 
								<tr>
									<td>"""),_display_(Seq[Any](/*49.15*/s/*49.16*/.getInteger("numeroProvision"))),format.raw/*49.46*/("""</td>
									<td>"""),_display_(Seq[Any](/*50.15*/(utils.DateUtils.formatDate(s.getDate("fecha"))))),format.raw/*50.63*/("""</td>
									<td>"""),_display_(Seq[Any](/*51.15*/s/*51.16*/.getString("expediente"))),format.raw/*51.40*/("""</td>
									<td>"""),_display_(Seq[Any](/*52.15*/s/*52.16*/.getString("nombre_proveedor"))),format.raw/*52.46*/("""</td>
									<td>"""),_display_(Seq[Any](/*53.15*/utils/*53.20*/.NumberUtils.moneda(s.getBigDecimal("total_deuda")))),format.raw/*53.71*/("""</td>
									<td>"""),_display_(Seq[Any](/*54.15*/s/*54.16*/.getString("deposito"))),format.raw/*54.38*/("""</td>
									<td>"""),_display_(Seq[Any](/*55.15*/s/*55.16*/.getString("rubro"))),format.raw/*55.35*/("""</td>
									<td>"""),_display_(Seq[Any](/*56.15*/s/*56.16*/.getString("descripcion"))),format.raw/*56.41*/("""</td>
								</tr>
								"""),_display_(Seq[Any](/*58.10*/{mtdoh= mtdoh.add(s.getBigDecimal("total_deuda"))})),format.raw/*58.60*/("""
								"""),_display_(Seq[Any](/*59.10*/{proveedorId = s.getInteger("proveedorId")})),format.raw/*59.53*/("""
								"""),_display_(Seq[Any](/*60.10*/{fecha = s.getString("fecha_mes_ano")})),format.raw/*60.48*/("""
								"""),_display_(Seq[Any](/*61.10*/{institucionNombre = s.getString("deposito")})),format.raw/*61.55*/("""
							""")))})),format.raw/*62.9*/("""
							
							
							"""),_display_(Seq[Any](/*65.9*/{ptmpdeuda = new java.math.BigDecimal(0)})),format.raw/*65.50*/("""
							"""),_display_(Seq[Any](/*66.9*/{proveedorId =0})),format.raw/*66.25*/("""
							"""),_display_(Seq[Any](/*67.9*/{fecha =""})),format.raw/*67.20*/("""		
							"""),_display_(Seq[Any](/*68.9*/{institucionNombre =""})),format.raw/*68.32*/("""					
							"""),_display_(Seq[Any](/*69.9*/{bandera = 0})),format.raw/*69.22*/("""
							"""),_display_(Seq[Any](/*70.9*/{xx = 0})),format.raw/*70.17*/("""
						</tbody>
						<tfoot>
							<tr>
								<td colspan="4" align="right"><b>TOTALES</b></td>
								<td><b>"""),_display_(Seq[Any](/*75.17*/utils/*75.22*/.NumberUtils.moneda(mtdoh))),format.raw/*75.48*/("""</b></td>
								<td></td>
								<td colspan="2" align="right"></td>
							</tr>
						</tfoot>
					</table>
				""")))})),format.raw/*81.6*/("""
			""")))})),format.raw/*82.5*/("""
		 	
	</div>
</div>






""")))})))}
    }
    
    def render(listaFinal:List[com.avaje.ebean.SqlRow],formBuscador:DynamicForm,idCuenta:Integer): play.api.templates.HtmlFormat.Appendable = apply(listaFinal,formBuscador,idCuenta)
    
    def f:((List[com.avaje.ebean.SqlRow],DynamicForm,Integer) => play.api.templates.HtmlFormat.Appendable) = (listaFinal,formBuscador,idCuenta) => apply(listaFinal,formBuscador,idCuenta)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:59 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/deudasPorAntiguedad/deudasDetallesCuenta.scala.html
                    HASH: ea7077144260167c9cb42db4cd40595573133357
                    MATRIX: 861->1|1765->85|1801->814|1813->819|1880->878|1919->880|1956->883|1968->888|2048->947|2660->1523|2680->1534|2803->1634|2986->1782|3017->1804|3056->1805|3097->1811|3131->1836|3170->1837|3299->1931|3313->1936|3410->2011|3476->2042|3512->2062|3551->2063|3597->2073|3627->2081|3692->2110|3773->2169|3847->2207|3857->2208|3909->2238|3965->2258|4035->2306|4091->2326|4101->2327|4147->2351|4203->2371|4213->2372|4265->2402|4321->2422|4335->2427|4408->2478|4464->2498|4474->2499|4518->2521|4574->2541|4584->2542|4625->2561|4681->2581|4691->2582|4738->2607|4803->2636|4875->2686|4921->2696|4986->2739|5032->2749|5092->2787|5138->2797|5205->2842|5245->2851|5305->2876|5368->2917|5412->2926|5450->2942|5494->2951|5527->2962|5573->2973|5618->2996|5667->3010|5702->3023|5746->3032|5776->3040|5928->3156|5942->3161|5990->3187|6140->3306|6176->3311
                    LINES: 26->1|34->1|35->5|35->5|35->5|35->5|37->7|37->7|37->7|55->25|55->25|55->25|66->36|66->36|66->36|67->37|67->37|67->37|69->39|69->39|69->39|72->42|72->42|72->42|73->43|73->43|76->46|76->46|79->49|79->49|79->49|80->50|80->50|81->51|81->51|81->51|82->52|82->52|82->52|83->53|83->53|83->53|84->54|84->54|84->54|85->55|85->55|85->55|86->56|86->56|86->56|88->58|88->58|89->59|89->59|90->60|90->60|91->61|91->61|92->62|95->65|95->65|96->66|96->66|97->67|97->67|98->68|98->68|99->69|99->69|100->70|100->70|105->75|105->75|105->75|111->81|112->82
                    -- GENERATED --
                */
            