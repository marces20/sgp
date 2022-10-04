
package views.html.compras.ordenes

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
object editarOrden extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[Orden],Orden,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(ordenForm: Form[Orden],orden:Orden):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

def /*6.2*/scripts/*6.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*6.13*/("""
	<script src=""""),_display_(Seq[Any](/*7.16*/routes/*7.22*/.Assets.at("javascripts/compras/ordenes.js"))),format.raw/*7.66*/("""" type="text/javascript"></script>
""")))};implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.38*/("""
"""),format.raw/*4.70*/("""

"""),format.raw/*8.2*/("""

"""),_display_(Seq[Any](/*10.2*/views/*10.7*/.html.compras.mainCompras("Modificar orden", scripts)/*10.60*/ {_display_(Seq[Any](format.raw/*10.62*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Editar Orden de Compra</h1>
			</div>

			<div class="col-sm-5">
				<div class="dropdown pull-right">
				 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 	<i class="glyphicon glyphicon-list-alt"></i>
				    Reportes
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				  </ul>
				</div>
				
				<div class="dropdown pull-right btn-header">
				 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 	<i class="glyphicon glyphicon-cog"></i>
				    Acciones
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				  	<li><a id="importarListaProductos" href="#" data-url=""""),_display_(Seq[Any](/*36.63*/controllers/*36.74*/.compras.routes.OrdenesAccionesController.modalImportarListaProductos())),format.raw/*36.145*/("""">Importar productos y cantidades</a></li>
				    <li role="presentation">
				    	<a role="menuitem" tabindex="-1" href="#" id="editarCuentaAnalitica" data-url=""""),_display_(Seq[Any](/*38.90*/controllers/*38.101*/.compras.routes.OrdenesController.modalEditarCuentaAnalica("editar"))),format.raw/*38.169*/("""">
				    		Editar cuenta analitica
				    	</a>
				    </li>
				  </ul>
				</div>
					
				<div class="pull-right btn-header">
					<a href=""""),_display_(Seq[Any](/*46.16*/controllers/*46.27*/.compras.routes.OrdenesController.crear())),_display_(Seq[Any](/*46.69*/UriTrack/*46.77*/.get("?"))),format.raw/*46.86*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nueva Orden</a>
				</div>
			</div>
			
			
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*54.3*/views/*54.8*/.html.tags.successError())),format.raw/*54.33*/("""
	

	"""),_display_(Seq[Any](/*57.3*/helper/*57.9*/.form(action = controllers.compras.routes.OrdenesController.actualizar(orden.id))/*57.90*/ {_display_(Seq[Any](format.raw/*57.92*/("""

	
		"""),_display_(Seq[Any](/*60.4*/inputText(ordenForm("id"), 'hidden -> "hidden"))),format.raw/*60.51*/("""
		"""),_display_(Seq[Any](/*61.4*/views/*61.9*/.html.compras.ordenes.formOrden(ordenForm))),format.raw/*61.51*/("""
		"""),_display_(Seq[Any](/*62.4*/views/*62.9*/.html.compras.ordenes.tabsOrden(true, ordenForm))),format.raw/*62.57*/("""	

		<!-- <h4>Base: 	<b>"""),_display_(Seq[Any](/*64.23*/utils/*64.28*/.NumberUtils.moneda(orden.getTotal()))),format.raw/*64.65*/("""</b></h4>	
		<h4>Ajuste: <b>"""),_display_(Seq[Any](/*65.19*/utils/*65.24*/.NumberUtils.moneda(orden.getTotalAjuste()))),format.raw/*65.67*/("""</b></h4>	
		<h4>Total: 	<b>"""),_display_(Seq[Any](/*66.19*/utils/*66.24*/.NumberUtils.moneda(orden.getTotalTotal()))),format.raw/*66.66*/("""</b></h4>	
		"""),_display_(Seq[Any](/*67.4*/if(orden.cot_dolar != null && orden.cot_dolar.compareTo(java.math.BigDecimal.ZERO) > 0)/*67.91*/{_display_(Seq[Any](format.raw/*67.92*/("""
			<h4>Total Moneda Extranjera: <b>"""),_display_(Seq[Any](/*68.37*/utils/*68.42*/.NumberUtils.moneda(orden.getTotalDolar(), orden.tipo_moneda))),format.raw/*68.103*/("""</b></h4>	
		""")))})),format.raw/*69.4*/("""
		<h4>Estado actual: 	<b>"""),_display_(Seq[Any](/*70.27*/orden/*70.32*/.estado.nombre)),format.raw/*70.46*/("""</b></h4> -->
		<div class="row margin-bottom-25">	
		
		</div>
		
	""")))})),format.raw/*75.3*/("""

""")))})))}
    }
    
    def render(ordenForm:Form[Orden],orden:Orden): play.api.templates.HtmlFormat.Appendable = apply(ordenForm,orden)
    
    def f:((Form[Orden],Orden) => play.api.templates.HtmlFormat.Appendable) = (ordenForm,orden) => apply(ordenForm,orden)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:43 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/ordenes/editarOrden.scala.html
                    HASH: 376225a7924e50c992d837172774712a946fa4f9
                    MATRIX: 807->1|952->143|966->150|1050->154|1101->170|1115->176|1180->220|1247->72|1279->96|1353->37|1381->140|1409->256|1447->259|1460->264|1522->317|1562->319|2533->1254|2553->1265|2647->1336|2848->1501|2869->1512|2960->1580|3145->1729|3165->1740|3237->1782|3254->1790|3285->1799|3460->1939|3473->1944|3520->1969|3561->1975|3575->1981|3665->2062|3705->2064|3747->2071|3816->2118|3855->2122|3868->2127|3932->2169|3971->2173|3984->2178|4054->2226|4116->2252|4130->2257|4189->2294|4254->2323|4268->2328|4333->2371|4398->2400|4412->2405|4476->2447|4525->2461|4621->2548|4660->2549|4733->2586|4747->2591|4831->2652|4876->2666|4939->2693|4953->2698|4989->2712|5089->2781
                    LINES: 26->1|31->6|31->6|33->6|34->7|34->7|34->7|35->4|35->4|36->1|37->4|39->8|41->10|41->10|41->10|41->10|67->36|67->36|67->36|69->38|69->38|69->38|77->46|77->46|77->46|77->46|77->46|85->54|85->54|85->54|88->57|88->57|88->57|88->57|91->60|91->60|92->61|92->61|92->61|93->62|93->62|93->62|95->64|95->64|95->64|96->65|96->65|96->65|97->66|97->66|97->66|98->67|98->67|98->67|99->68|99->68|99->68|100->69|101->70|101->70|101->70|106->75
                    -- GENERATED --
                */
            