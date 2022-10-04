
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
		      	<li class="dropdown">
		        	<a href="#" class="dropdown-toggle" data-toggle="dropdown">Deudas Resumen Mensual <b class="caret"></b></a>
		          	<ul class="dropdown-menu">
		          		<li><a href=""""),_display_(Seq[Any](/*13.29*/controllers/*13.40*/.dashboard.routes.DeudasPorAntiguedadController.deudasResumenMensual())),format.raw/*13.110*/("""">Resumen Mensual</a></li>
		          	</ul>
		        </li>
		        <li class="dropdown">
		        	<a href="#" class="dropdown-toggle" data-toggle="dropdown">Deudas Detalles <b class="caret"></b></a>
		          	<ul class="dropdown-menu">
		          		<li><a href=""""),_display_(Seq[Any](/*19.29*/controllers/*19.40*/.dashboard.routes.DeudasPorAntiguedadController.deudasDetalles(0,false))),format.raw/*19.111*/("""">Todos</a></li>
		          		<li><a href=""""),_display_(Seq[Any](/*20.29*/controllers/*20.40*/.dashboard.routes.DeudasPorAntiguedadController.deudasDetalles(-1,false))),format.raw/*20.112*/("""">Deudas RA</a></li>
		          		<li><a href=""""),_display_(Seq[Any](/*21.29*/controllers/*21.40*/.dashboard.routes.DeudasPorAntiguedadController.deudasDetalles(1530,false))),format.raw/*21.114*/("""">Deudas MOFAR</a></li>
		          		<li><a href=""""),_display_(Seq[Any](/*22.29*/controllers/*22.40*/.dashboard.routes.DeudasPorAntiguedadController.deudasDetalles(15156,false))),format.raw/*22.115*/("""">Deudas MACROFAR</a></li>
		          		<li><a href=""""),_display_(Seq[Any](/*23.29*/controllers/*23.40*/.dashboard.routes.DeudasPorAntiguedadController.deudasDetalles(4359,false))),format.raw/*23.114*/("""">Deudas SAN JORGE</a></li>
		          		<li><a href=""""),_display_(Seq[Any](/*24.29*/controllers/*24.40*/.dashboard.routes.DeudasPorAntiguedadController.deudasDetalles(2749,false))),format.raw/*24.114*/("""">Deudas IMPLANTEJ</a></li>
		          		<li><a href=""""),_display_(Seq[Any](/*25.29*/controllers/*25.40*/.dashboard.routes.DeudasPorAntiguedadController.deudasDetalles(14733,false))),format.raw/*25.115*/("""">Deudas BIOMISIONES</a></li>
		          		<!-- <li><a href=""""),_display_(Seq[Any](/*26.34*/controllers/*26.45*/.dashboard.routes.DeudasPorAntiguedadController.deudasDetalles(1498,false))),format.raw/*26.119*/("""">Deudas MEDICALPRO</a></li>-->
		          		<li><a href=""""),_display_(Seq[Any](/*27.29*/controllers/*27.40*/.dashboard.routes.DeudasPorAntiguedadController.deudasDetalles(1589,false))),format.raw/*27.114*/("""">Deudas NR CONSTRUCCIONES-TABAY</a></li>
		          		<li><a href=""""),_display_(Seq[Any](/*28.29*/controllers/*28.40*/.dashboard.routes.DeudasPorAntiguedadController.deudasDetalles(-2,false))),format.raw/*28.112*/("""">Otros Proveedores</a></li>
		          	</ul>
		        </li>
		        <li class="dropdown">
		        	<a href="#" class="dropdown-toggle" data-toggle="dropdown">Deudas Equipamiento <b class="caret"></b></a>
		          	<ul class="dropdown-menu">
		          		<li><a href=""""),_display_(Seq[Any](/*34.29*/controllers/*34.40*/.dashboard.routes.DeudasPorAntiguedadController.deudasDetalles(0,true))),format.raw/*34.110*/("""">Equipamientos</a></li>
		          	</ul>
		        </li>
		        <li class="dropdown">
		        	<a href="#" class="dropdown-toggle" data-toggle="dropdown">Deudas por Institucion<b class="caret"></b></a>
		          	<ul class="dropdown-menu">
		          		<li><a href=""""),_display_(Seq[Any](/*40.29*/controllers/*40.40*/.dashboard.routes.DeudasPorAntiguedadController.deudasResumenInstitucion())),format.raw/*40.114*/("""">Deudas Resumen Institucion</a></li>
		          		<li><a href=""""),_display_(Seq[Any](/*41.29*/controllers/*41.40*/.dashboard.routes.DeudasPorAntiguedadController.deudasDetallesInstitucion())),format.raw/*41.115*/("""">Deudas Detalle Institucion</a></li>
		          	</ul>
		        </li>
		        <li class="dropdown">
		        	<a href="#" class="dropdown-toggle" data-toggle="dropdown">Deudas Cuentas<b class="caret"></b></a>
		          	<ul class="dropdown-menu">
		          		"""),_display_(Seq[Any](/*47.16*/for(t <- TipoCuenta.find.all()) yield /*47.47*/ {_display_(Seq[Any](format.raw/*47.49*/("""
		          			<li><a href=""""),_display_(Seq[Any](/*48.30*/controllers/*48.41*/.dashboard.routes.DeudasPorAntiguedadController.deudasDetallesCuenta(t.id.intValue()))),format.raw/*48.126*/("""">"""),_display_(Seq[Any](/*48.129*/t/*48.130*/.nombre)),format.raw/*48.137*/("""</a></li>
		          		""")))})),format.raw/*49.16*/("""
		          		
		          		
		          	</ul>
		        </li>
		        <li><a href=""""),_display_(Seq[Any](/*54.25*/controllers/*54.36*/.dashboard.routes.DeudasPorAntiguedadController.deudasDetallesServicios())),format.raw/*54.109*/("""">Servicios</a></li>
		        """),_display_(Seq[Any](/*55.12*/helper/*55.18*/.form(action = controllers.dashboard.routes.DeudasPorAntiguedadController.deudasDetallesPorProveedor())/*55.121*/ {_display_(Seq[Any](format.raw/*55.123*/("""	
		      	<div class="input-group" style="padding: 10px 15px 0px 15px;">	
					"""),_display_(Seq[Any](/*57.7*/inputText(formBuscador("proveedor.id"), 'hidden -> "hidden", 'id -> "proveedor_id"))),format.raw/*57.90*/("""
					"""),_display_(Seq[Any](/*58.7*/inputText(formBuscador("proveedor.nombre"), 'name -> "", 'class -> "form-control",'placeholder->"Proveedor", 'id -> "proveedor"))),format.raw/*58.135*/("""
	    			 <span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchProveedor" 
									data-title="Selección de Proveedores" 
									data-url=""""),_display_(Seq[Any](/*63.21*/controllers/*63.32*/.compras.routes.ProveedoresController.modalBuscar())),format.raw/*63.83*/("""" 
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
				
				
				
				
    		   """)))})),format.raw/*78.11*/("""
		         
		      </ul>
		    </div>  
		</div>
	</nav>
</div>
<script type="text/javascript">
	$(function()"""),format.raw/*86.14*/("""{"""),format.raw/*86.15*/("""
		$('#searchProveedor').modalSearch();
	"""),format.raw/*88.2*/("""}"""),format.raw/*88.3*/(""");
</script>"""))}
    }
    
    def render(formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(formBuscador)
    
    def f:((DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (formBuscador) => apply(formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:59 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/deudasPorAntiguedad/navdeudas.scala.html
                    HASH: d7e567f1627216fa3c4713739c8e9a056d2a632e
                    MATRIX: 813->1|942->47|974->71|1048->28|1076->115|1560->563|1580->574|1673->644|1983->918|2003->929|2097->1000|2178->1045|2198->1056|2293->1128|2378->1177|2398->1188|2495->1262|2583->1314|2603->1325|2701->1400|2792->1455|2812->1466|2909->1540|3001->1596|3021->1607|3118->1681|3210->1737|3230->1748|3328->1823|3427->1886|3447->1897|3544->1971|3640->2031|3660->2042|3757->2116|3863->2186|3883->2197|3978->2269|4294->2549|4314->2560|4407->2630|4721->2908|4741->2919|4838->2993|4940->3059|4960->3070|5058->3145|5364->3415|5411->3446|5451->3448|5517->3478|5537->3489|5645->3574|5685->3577|5696->3578|5726->3585|5783->3610|5909->3700|5929->3711|6025->3784|6093->3816|6108->3822|6221->3925|6262->3927|6378->4008|6483->4091|6525->4098|6676->4226|6892->4406|6912->4417|6985->4468|7460->4911|7599->5022|7628->5023|7696->5064|7724->5065
                    LINES: 26->1|29->3|29->3|30->1|31->3|41->13|41->13|41->13|47->19|47->19|47->19|48->20|48->20|48->20|49->21|49->21|49->21|50->22|50->22|50->22|51->23|51->23|51->23|52->24|52->24|52->24|53->25|53->25|53->25|54->26|54->26|54->26|55->27|55->27|55->27|56->28|56->28|56->28|62->34|62->34|62->34|68->40|68->40|68->40|69->41|69->41|69->41|75->47|75->47|75->47|76->48|76->48|76->48|76->48|76->48|76->48|77->49|82->54|82->54|82->54|83->55|83->55|83->55|83->55|85->57|85->57|86->58|86->58|91->63|91->63|91->63|106->78|114->86|114->86|116->88|116->88
                    -- GENERATED --
                */
            