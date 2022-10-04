
package views.html.contabilidad

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
object mainContabilidad extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,Html,Html,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(title: String, scripts: Html = Html(""))(content: Html):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import models.auth._


Seq[Any](format.raw/*1.58*/("""
"""),_display_(Seq[Any](/*3.2*/main(title: String, scripts)/*3.30*/{_display_(Seq[Any](format.raw/*3.31*/("""
	<div class="row">
		<div class="col-sm-2">
			<div class="menu-contenido">
				<ul class="nav nav-pills nav-stacked">
					<li class="titulo">Provedores</li>
					"""),_display_(Seq[Any](/*9.7*/if(Componente.check("facturas"))/*9.39*/ {_display_(Seq[Any](format.raw/*9.41*/("""
						<li><a href=""""),_display_(Seq[Any](/*10.21*/controllers/*10.32*/.contabilidad.routes.FacturasController.index())),format.raw/*10.79*/("""">Facturas</a></li>
					""")))})),format.raw/*11.7*/("""
					"""),_display_(Seq[Any](/*12.7*/if(Componente.check("pagos"))/*12.36*/ {_display_(Seq[Any](format.raw/*12.38*/("""
						<li><a href=""""),_display_(Seq[Any](/*13.21*/controllers/*13.32*/.contabilidad.routes.PagosController.index())),format.raw/*13.76*/("""">Pagos</a></li>
					""")))})),format.raw/*14.7*/("""	
					
					"""),_display_(Seq[Any](/*16.7*/if(Componente.check("ordenesPagos"))/*16.43*/ {_display_(Seq[Any](format.raw/*16.45*/("""
						<li><a href=""""),_display_(Seq[Any](/*17.21*/controllers/*17.32*/.contabilidad.routes.OrdenesPagosController.index())),format.raw/*17.83*/("""">Ordenes de pago</a></li>
					""")))})),format.raw/*18.7*/("""
					"""),_display_(Seq[Any](/*19.7*/if(Componente.check("misPagos"))/*19.39*/ {_display_(Seq[Any](format.raw/*19.41*/("""
						<li><a href=""""),_display_(Seq[Any](/*20.21*/controllers/*20.32*/.contabilidad.routes.MisPagosController.index())),format.raw/*20.79*/("""">Mis Pagos</a></li>
					""")))})),format.raw/*21.7*/("""	
					"""),_display_(Seq[Any](/*22.7*/if(Componente.check("ordenesPagos"))/*22.43*/ {_display_(Seq[Any](format.raw/*22.45*/("""
					<li><a href=""""),_display_(Seq[Any](/*23.20*/controllers/*23.31*/.contabilidad.routes.OrdenesPagosCircuitosController.index())),format.raw/*23.91*/("""">Ordenes de pago Circuito</a></li>
					""")))})),format.raw/*24.7*/("""
					
					"""),_display_(Seq[Any](/*26.7*/if(Componente.check("pagos"))/*26.36*/ {_display_(Seq[Any](format.raw/*26.38*/("""
						<li><a href=""""),_display_(Seq[Any](/*27.21*/controllers/*27.32*/.contabilidad.routes.ConciliacionPagosController.index())),format.raw/*27.88*/("""">Conciliación de cheques</a></li>
					""")))})),format.raw/*28.7*/("""	
					
					"""),_display_(Seq[Any](/*30.7*/if(Componente.check("facturas"))/*30.39*/ {_display_(Seq[Any](format.raw/*30.41*/("""
						<li><a href=""""),_display_(Seq[Any](/*31.21*/controllers/*31.32*/.contabilidad.routes.FacturasController.vistaFacturasCargadas())),format.raw/*31.95*/("""">Vista Facturas Cargadas</a></li>
					""")))})),format.raw/*32.7*/("""
					
					"""),_display_(Seq[Any](/*34.7*/if(Componente.check("cuentasPropias"))/*34.45*/ {_display_(Seq[Any](format.raw/*34.47*/("""
					<li class="titulo">Cuentas Propias</li>
						
							<li><a href=""""),_display_(Seq[Any](/*37.22*/controllers/*37.33*/.contabilidad.routes.BalanceCuentaPropiaController.index())),format.raw/*37.91*/("""?cuenta_propia_id=2">Balance Cuentas Propias</a></li>
						""")))})),format.raw/*38.8*/("""	
						
					"""),_display_(Seq[Any](/*40.7*/if(Componente.check("balance"))/*40.38*/ {_display_(Seq[Any](format.raw/*40.40*/("""
					<li class="titulo">Balance General</li>
						<li><a href=""""),_display_(Seq[Any](/*42.21*/controllers/*42.32*/.contabilidad.routes.BalanceController.index())),format.raw/*42.78*/("""?cuenta_propia_id=2">Balance</a></li>
						<li><a href=""""),_display_(Seq[Any](/*43.21*/controllers/*43.32*/.contabilidad.routes.BalanceController.general())),format.raw/*43.80*/("""">Balance general</a></li>
					""")))})),format.raw/*44.7*/("""
					
						
					
					<li class="titulo">Cuentas bancarias</li>

					"""),_display_(Seq[Any](/*50.7*/if(Componente.check("cuentasBancarias"))/*50.47*/ {_display_(Seq[Any](format.raw/*50.49*/("""
						<li><a href=""""),_display_(Seq[Any](/*51.21*/controllers/*51.32*/.contabilidad.routes.CuentaBancariasController.indexCuentaBancaria())),format.raw/*51.100*/("""">Cuentas bancarias</a></li>	
					""")))})),format.raw/*52.7*/("""	
					<li class="titulo">Configuración</li>
					"""),_display_(Seq[Any](/*54.7*/if(Componente.check("bancos"))/*54.37*/ {_display_(Seq[Any](format.raw/*54.39*/("""
						<li><a href=""""),_display_(Seq[Any](/*55.21*/controllers/*55.32*/.contabilidad.routes.BancosController.indexBanco())),format.raw/*55.82*/("""">Bancos</a></li>
					""")))})),format.raw/*56.7*/("""	
					"""),_display_(Seq[Any](/*57.7*/if(Componente.check("bancosSucursales"))/*57.47*/ {_display_(Seq[Any](format.raw/*57.49*/("""
						<li><a href=""""),_display_(Seq[Any](/*58.21*/controllers/*58.32*/.contabilidad.routes.SucursalBancosController.indexSucursalBanco())),format.raw/*58.98*/("""">Sucursal bancos</a></li>
					""")))})),format.raw/*59.7*/("""	
					"""),_display_(Seq[Any](/*60.7*/if(Componente.check("ejercicio"))/*60.40*/ {_display_(Seq[Any](format.raw/*60.42*/("""	
						<li><a href=""""),_display_(Seq[Any](/*61.21*/controllers/*61.32*/.contabilidad.routes.EjerciciosController.indexEjercicio())),format.raw/*61.90*/("""">Ejercicios</a></li>
					""")))})),format.raw/*62.7*/("""	
					"""),_display_(Seq[Any](/*63.7*/if(Componente.check("periodos"))/*63.39*/ {_display_(Seq[Any](format.raw/*63.41*/("""
						<li><a href=""""),_display_(Seq[Any](/*64.21*/controllers/*64.32*/.contabilidad.routes.PeriodosController.indexPeriodo())),format.raw/*64.86*/("""">Periodos</a></li>
					""")))})),format.raw/*65.7*/("""	
					"""),_display_(Seq[Any](/*66.7*/if(Componente.check("cuentas"))/*66.38*/ {_display_(Seq[Any](format.raw/*66.40*/("""
						<li><a href=""""),_display_(Seq[Any](/*67.21*/controllers/*67.32*/.contabilidad.routes.CuentasController.index())),format.raw/*67.78*/("""">Cuentas</a></li>
					""")))})),format.raw/*68.7*/("""	
					"""),_display_(Seq[Any](/*69.7*/if(Componente.check("cuentasPresupuestarias"))/*69.53*/ {_display_(Seq[Any](format.raw/*69.55*/("""
						<li><a href=""""),_display_(Seq[Any](/*70.21*/controllers/*70.32*/.contabilidad.routes.CuentasAnaliticasController.index())),format.raw/*70.88*/("""">Cuentas presupuestarias</a></li>
					""")))})),format.raw/*71.7*/("""
				</ul>
			</div>
		</div>
		<div class="col-sm-10">"""),_display_(Seq[Any](/*75.27*/content)),format.raw/*75.34*/("""</div>
	</div>
""")))})),format.raw/*77.2*/("""
"""))}
    }
    
    def render(title:String,scripts:Html,content:Html): play.api.templates.HtmlFormat.Appendable = apply(title,scripts)(content)
    
    def f:((String,Html) => (Html) => play.api.templates.HtmlFormat.Appendable) = (title,scripts) => (content) => apply(title,scripts)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/mainContabilidad.scala.html
                    HASH: a9feda7069f4b00aa487a69b3a4c96060a3772d7
                    MATRIX: 808->1|979->57|1015->81|1051->109|1089->110|1289->276|1329->308|1368->310|1425->331|1445->342|1514->389|1571->415|1613->422|1651->451|1691->453|1748->474|1768->485|1834->529|1888->552|1937->566|1982->602|2022->604|2079->625|2099->636|2172->687|2236->720|2278->727|2319->759|2359->761|2416->782|2436->793|2505->840|2563->867|2606->875|2651->911|2691->913|2747->933|2767->944|2849->1004|2922->1046|2971->1060|3009->1089|3049->1091|3106->1112|3126->1123|3204->1179|3276->1220|3325->1234|3366->1266|3406->1268|3463->1289|3483->1300|3568->1363|3640->1404|3688->1417|3735->1455|3775->1457|3885->1531|3905->1542|3985->1600|4077->1661|4127->1676|4167->1707|4207->1709|4309->1775|4329->1786|4397->1832|4491->1890|4511->1901|4581->1949|4645->1982|4756->2058|4805->2098|4845->2100|4902->2121|4922->2132|5013->2200|5080->2236|5166->2287|5205->2317|5245->2319|5302->2340|5322->2351|5394->2401|5449->2425|5492->2433|5541->2473|5581->2475|5638->2496|5658->2507|5746->2573|5810->2606|5853->2614|5895->2647|5935->2649|5993->2671|6013->2682|6093->2740|6152->2768|6195->2776|6236->2808|6276->2810|6333->2831|6353->2842|6429->2896|6486->2922|6529->2930|6569->2961|6609->2963|6666->2984|6686->2995|6754->3041|6810->3066|6853->3074|6908->3120|6948->3122|7005->3143|7025->3154|7103->3210|7175->3251|7267->3307|7296->3314|7343->3330
                    LINES: 26->1|30->1|31->3|31->3|31->3|37->9|37->9|37->9|38->10|38->10|38->10|39->11|40->12|40->12|40->12|41->13|41->13|41->13|42->14|44->16|44->16|44->16|45->17|45->17|45->17|46->18|47->19|47->19|47->19|48->20|48->20|48->20|49->21|50->22|50->22|50->22|51->23|51->23|51->23|52->24|54->26|54->26|54->26|55->27|55->27|55->27|56->28|58->30|58->30|58->30|59->31|59->31|59->31|60->32|62->34|62->34|62->34|65->37|65->37|65->37|66->38|68->40|68->40|68->40|70->42|70->42|70->42|71->43|71->43|71->43|72->44|78->50|78->50|78->50|79->51|79->51|79->51|80->52|82->54|82->54|82->54|83->55|83->55|83->55|84->56|85->57|85->57|85->57|86->58|86->58|86->58|87->59|88->60|88->60|88->60|89->61|89->61|89->61|90->62|91->63|91->63|91->63|92->64|92->64|92->64|93->65|94->66|94->66|94->66|95->67|95->67|95->67|96->68|97->69|97->69|97->69|98->70|98->70|98->70|99->71|103->75|103->75|105->77
                    -- GENERATED --
                */
            