
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
object navdeudas extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.29*/("""
"""),format.raw/*3.70*/(""" 

<div class="row"  style="">

	<nav class="navbar navbar-default" role="navigation">
		<div class="container-fluid">
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		      <ul class="nav navbar-nav">
		      	<!-- <li class="active"><a href=""""),_display_(Seq[Any](/*11.44*/controllers/*11.55*/.dashboard.routes.DeudasGlobalizadasController.deudasResumidas())),format.raw/*11.119*/("""">Deudas Resumen <span class="sr-only">(current)</span></a></li> -->
		        <li class="dropdown">
		         	
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Deudas Resumen <b class="caret"></b></a>
		          <ul class="dropdown-menu">
		          	<li><a href=""""),_display_(Seq[Any](/*16.28*/controllers/*16.39*/.dashboard.routes.DeudasGlobalizadasController.deudasResumidas(0,false))),format.raw/*16.110*/("""">Deudas Resumen</a></li>
		            <li><a href=""""),_display_(Seq[Any](/*17.29*/controllers/*17.40*/.dashboard.routes.DeudasGlobalizadasController.deudasResumidas(models.Deposito.HEARM,false))),format.raw/*17.131*/("""">Deudas Resumen HEARM</a></li>
		            <li><a href=""""),_display_(Seq[Any](/*18.29*/controllers/*18.40*/.dashboard.routes.DeudasGlobalizadasController.deudasResumidas(-1,false))),format.raw/*18.112*/("""">Deudas Resumen Otras Instituciones</a></li>
		            <li><a href=""""),_display_(Seq[Any](/*19.29*/controllers/*19.40*/.dashboard.routes.DeudasGlobalizadasController.deudasResumidas(0,true))),format.raw/*19.110*/("""">Deudas Resumen RA</a></li>
		          </ul>
		        </li>
		        <li class="dropdown">
		        	<a href="#" class="dropdown-toggle" data-toggle="dropdown">Deudas Detalles <b class="caret"></b></a>
		          	<ul class="dropdown-menu">
		          		<li><a href=""""),_display_(Seq[Any](/*25.29*/controllers/*25.40*/.dashboard.routes.DeudasGlobalizadasController.deudasDetalles(0,true))),format.raw/*25.109*/("""">Deudas RA</a></li>
		          		<li><a href=""""),_display_(Seq[Any](/*26.29*/controllers/*26.40*/.dashboard.routes.DeudasGlobalizadasController.deudasDetalles(1530,false))),format.raw/*26.113*/("""">Deudas MOFAR</a></li>
		          		<li><a href=""""),_display_(Seq[Any](/*27.29*/controllers/*27.40*/.dashboard.routes.DeudasGlobalizadasController.deudasDetalles(15156,false))),format.raw/*27.114*/("""">Deudas MACROFAR</a></li>
		          		<li><a href=""""),_display_(Seq[Any](/*28.29*/controllers/*28.40*/.dashboard.routes.DeudasGlobalizadasController.deudasDetalles(4359,false))),format.raw/*28.113*/("""">Deudas SAN JORGE</a></li>
		          		<li><a href=""""),_display_(Seq[Any](/*29.29*/controllers/*29.40*/.dashboard.routes.DeudasGlobalizadasController.deudasDetalles(2749,false))),format.raw/*29.113*/("""">Deudas IMPLANTEJ</a></li>
		          		<li><a href=""""),_display_(Seq[Any](/*30.29*/controllers/*30.40*/.dashboard.routes.DeudasGlobalizadasController.deudasDetalles(14733,false))),format.raw/*30.114*/("""">Deudas BIOMISIONES</a></li>
		          		<!--  <li><a href=""""),_display_(Seq[Any](/*31.35*/controllers/*31.46*/.dashboard.routes.DeudasGlobalizadasController.deudasDetalles(1498,false))),format.raw/*31.119*/("""">Deudas MEDICALPRO</a></li>-->
		          		<li><a href=""""),_display_(Seq[Any](/*32.29*/controllers/*32.40*/.dashboard.routes.DeudasGlobalizadasController.deudasDetalles(1589,false))),format.raw/*32.113*/("""">Deudas NR CONSTRUCCIONES-TABAY</a></li>
		          	</ul>
		        </li>
		        <li class="dropdown">
		        	<a href="#" class="dropdown-toggle" data-toggle="dropdown">Deudas Otros  <b class="caret"></b></a>
		          	<ul class="dropdown-menu">
		          		<li><a href=""""),_display_(Seq[Any](/*38.29*/controllers/*38.40*/.dashboard.routes.DeudasGlobalizadasController.deudasDetallesOtrosProveedoresResumen(false,false))),format.raw/*38.137*/("""">Deudas Otros Proveedores Operativa - RESUMEN</a></li>
		          		<li><a href=""""),_display_(Seq[Any](/*39.29*/controllers/*39.40*/.dashboard.routes.DeudasGlobalizadasController.deudasDetallesOtrosProveedoresResumen(false,true))),format.raw/*39.136*/("""">Deudas Otros Proveedores Equipamiento Operativa - RESUMEN</a></li>
		          	
		          		<li><a href=""""),_display_(Seq[Any](/*41.29*/controllers/*41.40*/.dashboard.routes.DeudasGlobalizadasController.deudasDetallesOtros(false,false))),format.raw/*41.119*/("""">Deudas Otros Proveedores Operativa</a></li>
		          		<li><a href=""""),_display_(Seq[Any](/*42.29*/controllers/*42.40*/.dashboard.routes.DeudasGlobalizadasController.deudasDetallesOtros(false,true))),format.raw/*42.118*/("""">Deudas Otros Proveedores Equipamiento Operativa</a></li>
		          		<li><a href=""""),_display_(Seq[Any](/*43.29*/controllers/*43.40*/.dashboard.routes.DeudasGlobalizadasController.deudasDetallesOtros(true,false))),format.raw/*43.118*/("""">Deudas Otros Proveedores PROFE</a></li>
		          		<li><a href=""""),_display_(Seq[Any](/*44.29*/controllers/*44.40*/.dashboard.routes.DeudasGlobalizadasController.deudasDetallesOtros(true,true))),format.raw/*44.117*/("""">Deudas Otros Proveedores Equipamiento PROFE</a></li>
		          	</ul>
		        </li>
		        
		        <li class="dropdown">
		        	<a href="#" class="dropdown-toggle" data-toggle="dropdown">Deudas Totales Cuentas  <b class="caret"></b></a>
		          	<ul class="dropdown-menu">
		          		"""),_display_(Seq[Any](/*51.16*/for(t <- TipoCuenta.find.all()) yield /*51.47*/ {_display_(Seq[Any](format.raw/*51.49*/("""
		          			<li><a href=""""),_display_(Seq[Any](/*52.30*/controllers/*52.41*/.dashboard.routes.DeudasGlobalizadasController.deudasDetallesCuentas(t.id.intValue()))),format.raw/*52.126*/("""">"""),_display_(Seq[Any](/*52.129*/t/*52.130*/.nombre)),format.raw/*52.137*/("""</a></li>
		          		""")))})),format.raw/*53.16*/("""
		          		
		          		
		          	</ul>
		        </li>
		         
		        <li class="dropdown">
		        	<a href="#" class="dropdown-toggle" data-toggle="dropdown">Servicios  <b class="caret"></b></a>
		        	<ul class="dropdown-menu">
		        		<li><a href=""""),_display_(Seq[Any](/*62.27*/controllers/*62.38*/.dashboard.routes.DeudasGlobalizadasController.deudasDetallesServiciosResumen())),format.raw/*62.117*/("""">Servicios RESUMEN</a></li>
		        		<li><a href=""""),_display_(Seq[Any](/*63.27*/controllers/*63.38*/.dashboard.routes.DeudasGlobalizadasController.deudasDetallesServicios())),format.raw/*63.110*/("""">Servicios Detalles</a></li>
		        	</ul>
		        </li>
		        
		        <li class="dropdown">
		        	<a href="#" class="dropdown-toggle" data-toggle="dropdown">Honorarios  <b class="caret"></b></a>
		        	<ul class="dropdown-menu">
		        		<li><a href=""""),_display_(Seq[Any](/*70.27*/controllers/*70.38*/.dashboard.routes.DeudasGlobalizadasController.deudasDetallesHonorariosResumen())),format.raw/*70.118*/("""">Honorarios RESUMEN</a></li>
		        		<li><a href=""""),_display_(Seq[Any](/*71.27*/controllers/*71.38*/.dashboard.routes.DeudasGlobalizadasController.deudasDetallesHonorarios())),format.raw/*71.111*/("""">Honorarios Detalles</a></li>
		        	</ul>
		        </li>
		         
			        
			    
		      
		       """),_display_(Seq[Any](/*78.11*/helper/*78.17*/.form(action = controllers.dashboard.routes.DeudasGlobalizadasController.deudasDetallesPorProveedor())/*78.119*/ {_display_(Seq[Any](format.raw/*78.121*/("""	
		      	<div class="input-group" style="padding: 10px 15px 0px 15px;">	
					"""),_display_(Seq[Any](/*80.7*/inputText(formBuscador("proveedor.id"), 'hidden -> "hidden", 'id -> "proveedor_id"))),format.raw/*80.90*/("""
					"""),_display_(Seq[Any](/*81.7*/inputText(formBuscador("proveedor.nombre"), 'name -> "", 'class -> "form-control",'placeholder->"Proveedor", 'id -> "proveedor"))),format.raw/*81.135*/("""
	    			 <span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchProveedor" 
									data-title="Selección de Proveedores" 
									data-url=""""),_display_(Seq[Any](/*86.21*/controllers/*86.32*/.compras.routes.ProveedoresController.modalBuscar())),format.raw/*86.83*/("""" 
									data-height="650" 
									data-width="700" 
									data-listen="modal.seleccion.proveedor.simple" 
									data-label="#proveedor" 
									data-field="#proveedor_id">
							<i class="glyphicon glyphicon-search"></i>
						</a>
					</span>
					<button class="btn btn-outline-success my-2 my-sm-0" style="margin:0px 0px 0px 10px; text-align: center;" type="submit">Buscar</button>	
				</div>
				
    		   """)))})),format.raw/*98.11*/("""
    		   
		      </ul>
		      	
		    </div>  
	   		
		</div>
		 
	</nav>
</div>
<script type="text/javascript">
	$(function()"""),format.raw/*109.14*/("""{"""),format.raw/*109.15*/("""
		$('#searchProveedor').modalSearch();
	"""),format.raw/*111.2*/("""}"""),format.raw/*111.3*/(""");
</script>


"""))}
    }
    
    def render(formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(formBuscador)
    
    def f:((DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (formBuscador) => apply(formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:56 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/deudasGlobalizadas/navdeudas.scala.html
                    HASH: 8f73d16f4b3f3e626909bd88b77c0e7b01a7740c
                    MATRIX: 812->1|941->47|973->71|1047->28|1075->115|1385->389|1405->400|1492->464|1820->756|1840->767|1934->838|2024->892|2044->903|2158->994|2254->1054|2274->1065|2369->1137|2479->1211|2499->1222|2592->1292|2903->1567|2923->1578|3015->1647|3100->1696|3120->1707|3216->1780|3304->1832|3324->1843|3421->1917|3512->1972|3532->1983|3628->2056|3720->2112|3740->2123|3836->2196|3928->2252|3948->2263|4045->2337|4145->2401|4165->2412|4261->2485|4357->2545|4377->2556|4473->2629|4796->2916|4816->2927|4936->3024|5056->3108|5076->3119|5195->3215|5342->3326|5362->3337|5464->3416|5574->3490|5594->3501|5695->3579|5818->3666|5838->3677|5939->3755|6045->3825|6065->3836|6165->3913|6509->4221|6556->4252|6596->4254|6662->4284|6682->4295|6790->4380|6830->4383|6841->4384|6871->4391|6928->4416|7245->4697|7265->4708|7367->4787|7458->4842|7478->4853|7573->4925|7887->5203|7907->5214|8010->5294|8102->5350|8122->5361|8218->5434|8369->5549|8384->5555|8496->5657|8537->5659|8653->5740|8758->5823|8800->5830|8951->5958|9167->6138|9187->6149|9260->6200|9720->6628|9879->6758|9909->6759|9978->6800|10007->6801
                    LINES: 26->1|29->3|29->3|30->1|31->3|39->11|39->11|39->11|44->16|44->16|44->16|45->17|45->17|45->17|46->18|46->18|46->18|47->19|47->19|47->19|53->25|53->25|53->25|54->26|54->26|54->26|55->27|55->27|55->27|56->28|56->28|56->28|57->29|57->29|57->29|58->30|58->30|58->30|59->31|59->31|59->31|60->32|60->32|60->32|66->38|66->38|66->38|67->39|67->39|67->39|69->41|69->41|69->41|70->42|70->42|70->42|71->43|71->43|71->43|72->44|72->44|72->44|79->51|79->51|79->51|80->52|80->52|80->52|80->52|80->52|80->52|81->53|90->62|90->62|90->62|91->63|91->63|91->63|98->70|98->70|98->70|99->71|99->71|99->71|106->78|106->78|106->78|106->78|108->80|108->80|109->81|109->81|114->86|114->86|114->86|126->98|137->109|137->109|139->111|139->111
                    -- GENERATED --
                */
            