
package views.html.dashboard

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
object mainDashboard extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,Html,Html,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(title: String, scripts: Html = Html(""))(content: Html):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import models.auth._


Seq[Any](format.raw/*1.58*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/main(title: String, scripts)/*4.30*/{_display_(Seq[Any](format.raw/*4.31*/("""
	<div class="row">
		<div class="col-sm-2">
			<div class="menu-contenido">
			
			<ul class="nav nav-pills nav-stacked">
				"""),_display_(Seq[Any](/*10.6*/if(Componente.check("dashboardAcciones") || Componente.check("cotizacion"))/*10.81*/ {_display_(Seq[Any](format.raw/*10.83*/("""
				<li class="titulo">Acciones</li>
					"""),_display_(Seq[Any](/*12.7*/if(Permiso.check("dashboardAutorizadosListado"))/*12.55*/ {_display_(Seq[Any](format.raw/*12.57*/("""
					<li><a href=""""),_display_(Seq[Any](/*13.20*/controllers/*13.31*/.dashboard.routes.AutorizadosController.index())),format.raw/*13.78*/("""">Autorizados</a></li>
					""")))})),format.raw/*14.7*/("""
					"""),_display_(Seq[Any](/*15.7*/if(Componente.check("cotizacion"))/*15.41*/ {_display_(Seq[Any](format.raw/*15.43*/("""
					<li><a href=""""),_display_(Seq[Any](/*16.20*/controllers/*16.31*/.dashboard.routes.UltimasCotizacionesController.indexUltimaCotizaciones())),format.raw/*16.104*/("""">Cotizaciones</a></li>
					""")))})),format.raw/*17.7*/("""
				""")))})),format.raw/*18.6*/("""
				"""),_display_(Seq[Any](/*19.6*/if(Componente.check("dashboardHonorarios"))/*19.49*/ {_display_(Seq[Any](format.raw/*19.51*/("""
					<li class="titulo">Honorarios</li>
					<!-- <li><a href=""""),_display_(Seq[Any](/*21.25*/controllers/*21.36*/.dashboard.routes.HonorariosController.estadoGeneralPorAgente())),format.raw/*21.99*/("""">Estado general agente</a></li>
			        <li><a href=""""),_display_(Seq[Any](/*22.26*/controllers/*22.37*/.dashboard.routes.HonorariosController.estadoDeuda())),format.raw/*22.89*/("""">Estado de Deudas</a></li> -->
			        """),_display_(Seq[Any](/*23.13*/if(Permiso.check("dashboardHonorarios"))/*23.53*/ {_display_(Seq[Any](format.raw/*23.55*/("""
			        	<li><a href=""""),_display_(Seq[Any](/*24.27*/controllers/*24.38*/.dashboard.routes.HonorariosController.estadoDeudaMonotributo())),format.raw/*24.101*/("""">Reporte Deudas Monotributos</a></li>
			        	<li><a href=""""),_display_(Seq[Any](/*25.27*/controllers/*25.38*/.dashboard.routes.HonorariosController.estadoDeudaMonotributoProfe())),format.raw/*25.106*/("""">Reporte Deudas Monotributos PROFE</a></li>
		        	""")))})),format.raw/*26.13*/("""
		        """)))})),format.raw/*27.12*/("""
		        
		        """),_display_(Seq[Any](/*29.12*/if(Componente.check("dashboardImpuestos"))/*29.54*/ {_display_(Seq[Any](format.raw/*29.56*/("""
		        <li class="titulo">Impuestos</li>
		        	"""),_display_(Seq[Any](/*31.13*/if(Permiso.check("dashboardImpuestosEstadoDeuda"))/*31.63*/ {_display_(Seq[Any](format.raw/*31.65*/("""
		        		<li><a href=""""),_display_(Seq[Any](/*32.27*/controllers/*32.38*/.dashboard.routes.ImpuestosController.estadoDeuda())),format.raw/*32.89*/("""">Reporte Deudas Impuestos</a></li>
		        	""")))})),format.raw/*33.13*/("""
		        """)))})),format.raw/*34.12*/("""	
		        
		        """),_display_(Seq[Any](/*36.12*/if(Componente.check("dashboardLiquidaciones"))/*36.58*/ {_display_(Seq[Any](format.raw/*36.60*/("""
			        <li class="titulo">Liquidaciones Relacion</li>
			        					  
			        """),_display_(Seq[Any](/*39.13*/if(Permiso.check("dashboardLiquidacionesPorPuesto"))/*39.65*/ {_display_(Seq[Any](format.raw/*39.67*/("""
			        	<li><a href=""""),_display_(Seq[Any](/*40.27*/controllers/*40.38*/.dashboard.routes.LiquidacionesController.liquidacionesPorPuesto())),format.raw/*40.104*/("""">Estado por Agente</a></li>
					""")))})),format.raw/*41.7*/("""
					"""),_display_(Seq[Any](/*42.7*/if(Permiso.check("dashboardLiquidacionesPorProfesion"))/*42.62*/ {_display_(Seq[Any](format.raw/*42.64*/("""
			        	<li><a href=""""),_display_(Seq[Any](/*43.27*/controllers/*43.38*/.dashboard.routes.LiquidacionesController.liquidacionesPorProfesion())),format.raw/*43.107*/("""?nuevo=true">Por Profesion</a></li>
					""")))})),format.raw/*44.7*/("""
					"""),_display_(Seq[Any](/*45.7*/if(Permiso.check("dashboardLiquidacionesPorAgrupadoOrganigrama"))/*45.72*/ {_display_(Seq[Any](format.raw/*45.74*/("""
					
						<li><a href=""""),_display_(Seq[Any](/*47.21*/controllers/*47.32*/.dashboard.routes.LiquidacionesController.liquidacionesPorAgrupadoOrganigrama())),format.raw/*47.111*/("""?nuevo=true">Por Grupo Organigrama</a></li>
					""")))})),format.raw/*48.7*/("""
					"""),_display_(Seq[Any](/*49.7*/if(Permiso.check("dashboardLiquidacionesPorProfesion"))/*49.62*/ {_display_(Seq[Any](format.raw/*49.64*/("""
			        	<li><a href=""""),_display_(Seq[Any](/*50.27*/controllers/*50.38*/.dashboard.routes.LiquidacionesController.liquidacionesPorOrganigrama())),format.raw/*50.109*/("""?nuevo=true">Por Organigrama</a></li>
					""")))})),format.raw/*51.7*/("""
					"""),_display_(Seq[Any](/*52.7*/if(Permiso.check("dashboardLiquidacionesPorProfesion"))/*52.62*/ {_display_(Seq[Any](format.raw/*52.64*/("""
			        	<li><a href=""""),_display_(Seq[Any](/*53.27*/controllers/*53.38*/.dashboard.routes.LiquidacionesController.liquidacionesTotalesPorEscala())),format.raw/*53.111*/("""?nuevo=true">Por Escala</a></li>
					""")))})),format.raw/*54.7*/("""
					"""),_display_(Seq[Any](/*55.7*/if(Permiso.check("dashboardLiquidacionesPorProfesion"))/*55.62*/ {_display_(Seq[Any](format.raw/*55.64*/("""
			        	<li><a href=""""),_display_(Seq[Any](/*56.27*/controllers/*56.38*/.dashboard.routes.LiquidacionesController.liquidacionesPorEscala())),format.raw/*56.104*/("""?nuevo=true">Por Escala/Profesion</a></li>
					""")))})),format.raw/*57.7*/("""
			        """),_display_(Seq[Any](/*58.13*/if(Permiso.check("dashboardLiquidacionesPorDepartamento"))/*58.71*/ {_display_(Seq[Any](format.raw/*58.73*/("""
			        	<li><a href=""""),_display_(Seq[Any](/*59.27*/controllers/*59.38*/.dashboard.routes.HonorariosController.porDepartamento())),format.raw/*59.94*/("""">Reporte por departamento</a></li>
					""")))})),format.raw/*60.7*/("""
				""")))})),format.raw/*61.6*/("""
				
				
				"""),_display_(Seq[Any](/*64.6*/if(Componente.check("dashboardProveedores"))/*64.50*/ {_display_(Seq[Any](format.raw/*64.52*/("""
					"""),_display_(Seq[Any](/*65.7*/if(Permiso.check("dashboardProveedoresEstadoPorExpedientePorLinea"))/*65.75*/ {_display_(Seq[Any](format.raw/*65.77*/("""
			        	<li><a href=""""),_display_(Seq[Any](/*66.27*/controllers/*66.38*/.dashboard.routes.ProveedoresController.estadoPorExpedientePorLinea())),format.raw/*66.107*/("""">Estado por linea rubro</a></li>
					""")))})),format.raw/*67.7*/("""
				""")))})),format.raw/*68.6*/(""" 
				
				
		        """),_display_(Seq[Any](/*71.12*/if(Componente.check("dashboardRRHH"))/*71.49*/ {_display_(Seq[Any](format.raw/*71.51*/("""
			        <li class="titulo">RRHH</li>
			        					  
			        """),_display_(Seq[Any](/*74.13*/if(Permiso.check("dashboardProfesionalesMedicosEtario"))/*74.69*/ {_display_(Seq[Any](format.raw/*74.71*/("""
			        	<li><a href=""""),_display_(Seq[Any](/*75.27*/controllers/*75.38*/.dashboard.routes.ProfesionalesMedicosController.index())),format.raw/*75.94*/("""">Profesionales médicos</a></li>
					""")))})),format.raw/*76.7*/("""

				""")))})),format.raw/*78.6*/("""
				
				
				"""),_display_(Seq[Any](/*81.6*/if(Componente.check("dashboardInforme"))/*81.46*/ {_display_(Seq[Any](format.raw/*81.48*/("""
					<li class="titulo">Informes Deudas</li>
					"""),_display_(Seq[Any](/*83.7*/if(Permiso.check("dashboardInformeDeudaProveedores"))/*83.60*/ {_display_(Seq[Any](format.raw/*83.62*/("""
					<li><a href=""""),_display_(Seq[Any](/*84.20*/controllers/*84.31*/.dashboard.routes.InformeEstadisticoDeudaProveedoresController.index())),format.raw/*84.101*/("""">Informe Deuda por proveedor</a></li>
					""")))})),format.raw/*85.7*/("""
					"""),_display_(Seq[Any](/*86.7*/if(Permiso.check("dashboardInformeDeudaPorActas"))/*86.57*/ {_display_(Seq[Any](format.raw/*86.59*/("""
					<li><a href=""""),_display_(Seq[Any](/*87.20*/controllers/*87.31*/.dashboard.routes.InformeDeudaPorActasController.index())),format.raw/*87.87*/("""">Deuda por actas</a></li>
					""")))})),format.raw/*88.7*/("""
					"""),_display_(Seq[Any](/*89.7*/if(Permiso.check("dashboardInformeDeudaProveedores"))/*89.60*/ {_display_(Seq[Any](format.raw/*89.62*/("""
					<li><a href=""""),_display_(Seq[Any](/*90.20*/controllers/*90.31*/.dashboard.routes.DeudasGlobalizadasController.index())),format.raw/*90.85*/("""">Deudas reportes</a></li>
					""")))})),format.raw/*91.7*/("""
					"""),_display_(Seq[Any](/*92.7*/if(Permiso.check("dashboardInformeDeudaProveedores"))/*92.60*/ {_display_(Seq[Any](format.raw/*92.62*/("""
						<li><a href=""""),_display_(Seq[Any](/*93.21*/controllers/*93.32*/.dashboard.routes.DeudasPorAntiguedadController.index())),format.raw/*93.87*/("""">Deudas reportes por Antiguedad</a></li>
					""")))})),format.raw/*94.7*/("""
					"""),_display_(Seq[Any](/*95.7*/if(Permiso.check("dashboardInformeDeudaProveedores"))/*95.60*/ {_display_(Seq[Any](format.raw/*95.62*/("""
						<li><a href=""""),_display_(Seq[Any](/*96.21*/controllers/*96.32*/.dashboard.routes.ControlDeudaController.index())),format.raw/*96.80*/("""">Control Deudas</a></li>
					""")))})),format.raw/*97.7*/("""
				""")))})),format.raw/*98.6*/("""
				
				"""),_display_(Seq[Any](/*100.6*/if(Componente.check("dashboardInforme"))/*100.46*/ {_display_(Seq[Any](format.raw/*100.48*/("""
					<li class="titulo">Informes Pagos</li>
				
					"""),_display_(Seq[Any](/*103.7*/if(Permiso.check("dashboardInformeDeudaProveedores"))/*103.60*/ {_display_(Seq[Any](format.raw/*103.62*/("""
					<li><a href=""""),_display_(Seq[Any](/*104.20*/controllers/*104.31*/.dashboard.routes.InformeEstadisticoPagoProveedoresController.index())),format.raw/*104.100*/("""">Informe Pago por proveedor</a></li>
					""")))})),format.raw/*105.7*/("""
					"""),_display_(Seq[Any](/*106.7*/if(Permiso.check("dashboardInformeDeudaProveedores"))/*106.60*/ {_display_(Seq[Any](format.raw/*106.62*/("""
					<li><a href=""""),_display_(Seq[Any](/*107.20*/controllers/*107.31*/.dashboard.routes.InformeEstadisticoPagoProveedoresController.informePeriodoProveedor())),format.raw/*107.118*/("""">Informe Pago Periodo/Proveedores</a></li>
					""")))})),format.raw/*108.7*/("""
					
					"""),_display_(Seq[Any](/*110.7*/if(Permiso.check("dashboardMovimientoCuenta"))/*110.53*/ {_display_(Seq[Any](format.raw/*110.55*/("""
					<li><a href=""""),_display_(Seq[Any](/*111.20*/controllers/*111.31*/.dashboard.routes.MovimientosCuentasController.index())),format.raw/*111.85*/("""">Movimientos Cuentas</a></li>
					""")))})),format.raw/*112.7*/(""" 
				""")))})),format.raw/*113.6*/("""
				
				"""),_display_(Seq[Any](/*115.6*/if(Componente.check("dashboardInformeRecupero"))/*115.54*/ {_display_(Seq[Any](format.raw/*115.56*/("""
					<li class="titulo">Informes Recupero</li>
					<li><a href=""""),_display_(Seq[Any](/*117.20*/controllers/*117.31*/.dashboard.routes.InformesRecuperoController.index())),format.raw/*117.83*/("""">Informes</a></li>
				""")))})),format.raw/*118.6*/("""
				
				"""),_display_(Seq[Any](/*120.6*/if(Componente.check("dashboardInformeRecupero"))/*120.54*/ {_display_(Seq[Any](format.raw/*120.56*/("""
					<li class="titulo">Inventario</li>
					<li><a href=""""),_display_(Seq[Any](/*122.20*/controllers/*122.31*/.dashboard.routes.InventarioRismiController.index())),format.raw/*122.82*/("""">Inventario Rismi</a></li>
				""")))})),format.raw/*123.6*/("""
			</ul>
			</div>
		</div>
		<div class="col-sm-10">"""),_display_(Seq[Any](/*127.27*/content)),format.raw/*127.34*/("""</div>
	</div>
""")))})))}
    }
    
    def render(title:String,scripts:Html,content:Html): play.api.templates.HtmlFormat.Appendable = apply(title,scripts)(content)
    
    def f:((String,Html) => (Html) => play.api.templates.HtmlFormat.Appendable) = (title,scripts) => (content) => apply(title,scripts)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:46 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/mainDashboard.scala.html
                    HASH: 18b40e6ca27bf7419ff2fa98a51c079e5209309d
                    MATRIX: 802->1|973->57|1000->80|1036->82|1072->110|1110->111|1273->239|1357->314|1397->316|1476->360|1533->408|1573->410|1629->430|1649->441|1718->488|1778->517|1820->524|1863->558|1903->560|1959->580|1979->591|2075->664|2136->694|2173->700|2214->706|2266->749|2306->751|2407->816|2427->827|2512->890|2606->948|2626->959|2700->1011|2780->1055|2829->1095|2869->1097|2932->1124|2952->1135|3038->1198|3139->1263|3159->1274|3250->1342|3339->1399|3383->1411|3442->1434|3493->1476|3533->1478|3626->1535|3685->1585|3725->1587|3788->1614|3808->1625|3881->1676|3961->1724|4005->1736|4065->1760|4120->1806|4160->1808|4286->1898|4347->1950|4387->1952|4450->1979|4470->1990|4559->2056|4625->2091|4667->2098|4731->2153|4771->2155|4834->2182|4854->2193|4946->2262|5019->2304|5061->2311|5135->2376|5175->2378|5238->2405|5258->2416|5360->2495|5441->2545|5483->2552|5547->2607|5587->2609|5650->2636|5670->2647|5764->2718|5839->2762|5881->2769|5945->2824|5985->2826|6048->2853|6068->2864|6164->2937|6234->2976|6276->2983|6340->3038|6380->3040|6443->3067|6463->3078|6552->3144|6632->3193|6681->3206|6748->3264|6788->3266|6851->3293|6871->3304|6949->3360|7022->3402|7059->3408|7110->3424|7163->3468|7203->3470|7245->3477|7322->3545|7362->3547|7425->3574|7445->3585|7537->3654|7608->3694|7645->3700|7704->3723|7750->3760|7790->3762|7898->3834|7963->3890|8003->3892|8066->3919|8086->3930|8164->3986|8234->4025|8272->4032|8323->4048|8372->4088|8412->4090|8499->4142|8561->4195|8601->4197|8657->4217|8677->4228|8770->4298|8846->4343|8888->4350|8947->4400|8987->4402|9043->4422|9063->4433|9141->4489|9205->4522|9247->4529|9309->4582|9349->4584|9405->4604|9425->4615|9501->4669|9565->4702|9607->4709|9669->4762|9709->4764|9766->4785|9786->4796|9863->4851|9942->4899|9984->4906|10046->4959|10086->4961|10143->4982|10163->4993|10233->5041|10296->5073|10333->5079|10380->5090|10430->5130|10471->5132|10563->5188|10626->5241|10667->5243|10724->5263|10745->5274|10838->5343|10914->5387|10957->5394|11020->5447|11061->5449|11118->5469|11139->5480|11250->5567|11332->5617|11381->5630|11437->5676|11478->5678|11535->5698|11556->5709|11633->5763|11702->5800|11741->5807|11788->5818|11846->5866|11887->5868|11991->5935|12012->5946|12087->5998|12144->6023|12191->6034|12249->6082|12290->6084|12387->6144|12408->6155|12482->6206|12547->6239|12639->6294|12669->6301
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|38->10|38->10|38->10|40->12|40->12|40->12|41->13|41->13|41->13|42->14|43->15|43->15|43->15|44->16|44->16|44->16|45->17|46->18|47->19|47->19|47->19|49->21|49->21|49->21|50->22|50->22|50->22|51->23|51->23|51->23|52->24|52->24|52->24|53->25|53->25|53->25|54->26|55->27|57->29|57->29|57->29|59->31|59->31|59->31|60->32|60->32|60->32|61->33|62->34|64->36|64->36|64->36|67->39|67->39|67->39|68->40|68->40|68->40|69->41|70->42|70->42|70->42|71->43|71->43|71->43|72->44|73->45|73->45|73->45|75->47|75->47|75->47|76->48|77->49|77->49|77->49|78->50|78->50|78->50|79->51|80->52|80->52|80->52|81->53|81->53|81->53|82->54|83->55|83->55|83->55|84->56|84->56|84->56|85->57|86->58|86->58|86->58|87->59|87->59|87->59|88->60|89->61|92->64|92->64|92->64|93->65|93->65|93->65|94->66|94->66|94->66|95->67|96->68|99->71|99->71|99->71|102->74|102->74|102->74|103->75|103->75|103->75|104->76|106->78|109->81|109->81|109->81|111->83|111->83|111->83|112->84|112->84|112->84|113->85|114->86|114->86|114->86|115->87|115->87|115->87|116->88|117->89|117->89|117->89|118->90|118->90|118->90|119->91|120->92|120->92|120->92|121->93|121->93|121->93|122->94|123->95|123->95|123->95|124->96|124->96|124->96|125->97|126->98|128->100|128->100|128->100|131->103|131->103|131->103|132->104|132->104|132->104|133->105|134->106|134->106|134->106|135->107|135->107|135->107|136->108|138->110|138->110|138->110|139->111|139->111|139->111|140->112|141->113|143->115|143->115|143->115|145->117|145->117|145->117|146->118|148->120|148->120|148->120|150->122|150->122|150->122|151->123|155->127|155->127
                    -- GENERATED --
                */
            