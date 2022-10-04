
package views.html.patrimonio.inventario

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
object indexInventario extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[Inventario],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[Inventario], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import models.auth._

import utils._

def /*7.2*/scripts/*7.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*7.13*/("""
	<script src=""""),_display_(Seq[Any](/*8.16*/routes/*8.22*/.Assets.at("javascripts/patrimonio/inventario.js"))),format.raw/*8.72*/("""" type="text/javascript"></script>
""")))};implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.80*/("""
"""),format.raw/*5.70*/(""" 

"""),format.raw/*9.2*/("""

"""),_display_(Seq[Any](/*11.2*/views/*11.7*/.html.patrimonio.mainPatrimonio("Inventario", scripts)/*11.61*/ {_display_(Seq[Any](format.raw/*11.63*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Inventario de productos</h1>
			</div>

			
		</div>
		
	</div>

"""),_display_(Seq[Any](/*24.2*/views/*24.7*/.html.tags.successError())),format.raw/*24.32*/("""
"""),_display_(Seq[Any](/*25.2*/helper/*25.8*/.form(action = controllers.patrimonio.routes.InventarioController.index(), 'id -> "buscadorInventario")/*25.111*/ {_display_(Seq[Any](format.raw/*25.113*/("""
<div class="row">	
		
		<div class="form-group col-sm-2">
			<label for="nombre" class="control-label">Prefijo
			"""),_display_(Seq[Any](/*30.5*/select(formBuscador("prefijo_inventario_id"), 
				 InventarioPrefijo.find.findList().map { p => p.id.toString -> (p.prefijo + " | " + p.nombre)}, 
			'class -> "form-control select inline", 'id -> "prefijo_inventario_id", '_default -> "Seleccionar" ))),format.raw/*32.104*/("""
			</label>
		</div>
		
		
	<div class="col-sm-3">
		<div class="row">

			<div class="form-group col-sm-6">
				<label for="nombre" class="control-label">Número
				"""),_display_(Seq[Any](/*42.6*/inputText(formBuscador("numero"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*42.92*/("""
				</label>
			</div>
		
			<div class="form-group col-sm-6">
				<label for="nombre" class="control-label">Remito
				"""),_display_(Seq[Any](/*48.6*/inputText(formBuscador("remito_numero"), 'class -> "form-control"))),format.raw/*48.72*/("""
				</label>
			</div>
		</div>
	
	</div>

	<div class="col-sm-3">
		<label class="control-label">Proveedor
			<div class="input-group">
				"""),_display_(Seq[Any](/*58.6*/inputText(formBuscador("proveedor_id"), 'hidden -> "hidden", 'id -> "proveedor_id"))),format.raw/*58.89*/("""
				"""),_display_(Seq[Any](/*59.6*/inputText(formBuscador("proveedor_nombre"), 'name -> "", 'class -> "form-control", 'id -> "proveedor"))),format.raw/*59.108*/("""
				<span class="input-group-addon">
					<a href="#" class="searchModal"
								id="searchProveedor" 
								data-title="Selección de Proveedores" 
								data-url=""""),_display_(Seq[Any](/*64.20*/controllers/*64.31*/.compras.routes.ProveedoresController.modalBuscar())),format.raw/*64.82*/("""" 
								data-height="650" 
								data-width="700" 
								data-listen="modal.seleccion.proveedor.simple" 
								data-label="#proveedor" 
								data-field="#proveedor_id">
						<i class="glyphicon glyphicon-search"></i>
					</a>
				</span>
			</div>
		</label>
	</div>

	<div class="col-sm-3">
		<label for="producto" class="control-label">Producto</label>
		<div class="input-group">
			"""),_display_(Seq[Any](/*80.5*/inputText(formBuscador("producto.nombre"), 'class -> "form-control", 'autofocus -> "autofocus", 'id -> "producto"))),format.raw/*80.119*/("""
			"""),_display_(Seq[Any](/*81.5*/inputText(formBuscador("producto_id"), 'hidden -> "hidden", 'id -> "producto_id"))),format.raw/*81.86*/("""
			<span class="input-group-addon"><a href="#" id="searchProducto" data-title="Selección de producto" data-url=""""),_display_(Seq[Any](/*82.114*/controllers/*82.125*/.compras.routes.ProductosController.modalBuscar())),format.raw/*82.174*/("""" data-height="650" data-width="700" data-listen="modal.seleccion.producto.simple" data-label="#producto" data-field="#producto_id"><i class="glyphicon glyphicon-search"></i></a></span>
		</div>
	</div>

	<div class="col-sm-2">
		<div class="form-group">
		<label for="nombre" class="control-label">&nbsp;</label>
		<button  class="form-control btn btn-primary"><i class="glyphicon glyphicon-search"></i> Buscar</button>
		</div>
	</div>	
	
	<div class="col-sm-2">
		<div class="form-group">
		<label for="nombre" class="control-label">&nbsp;</label>
		<a href=""""),_display_(Seq[Any](/*96.13*/controllers/*96.24*/.patrimonio.routes.InventarioController.index())),format.raw/*96.71*/(""""  class="form-control btn btn-default">Limpiar</a>
		</div>
	</div>
	
</div>
""")))})),format.raw/*101.2*/("""


  """),_display_(Seq[Any](/*104.4*/if(buscador.getTotalRowCount == 0)/*104.38*/ {_display_(Seq[Any](format.raw/*104.40*/("""
        
       <div class="well">
           <em>No se encuentran actas de recepción</em>
       </div>
        
    """)))}/*110.7*/else/*110.12*/{_display_(Seq[Any](format.raw/*110.13*/("""
		
		Mostrando """),_display_(Seq[Any](/*112.14*/buscador/*112.22*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*112.54*/(""" resultado(s).   
		<table id="listaActasRecepcion" class="table table-striped table-bordered table-hover">
			<thead>	
				<tr>
					
					<th width="100">Producto</th>
					<th width="100">Prefijo</th>
					<th width="100">Número</th>
					<th width="100">Remito</th>
				</tr>
			</thead>
			<tbody>
		        """),_display_(Seq[Any](/*124.12*/for(i <- buscador.getList) yield /*124.38*/ {_display_(Seq[Any](format.raw/*124.40*/("""
				<tr>
					
					<td>"""),_display_(Seq[Any](/*127.11*/i/*127.12*/.producto.nombre)),format.raw/*127.28*/("""</td>
					<td>"""),_display_(Seq[Any](/*128.11*/if(i.prefijo != null)/*128.32*/ {_display_(Seq[Any](_display_(Seq[Any](/*128.35*/i/*128.36*/.prefijo.prefijo))))})),format.raw/*128.53*/("""</td>
					<td>"""),_display_(Seq[Any](/*129.11*/i/*129.12*/.numero)),format.raw/*129.19*/("""</td>
					<td>"""),_display_(Seq[Any](/*130.11*/i/*130.12*/.remito.numero)),format.raw/*130.26*/("""</td>
				</tr>
              	""")))})),format.raw/*132.17*/("""
			</tbody>
		</table>
		
		<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*137.8*/views/*137.13*/.html.helpers.paginador(buscador, controllers.patrimonio.routes.InventarioController.index()))),format.raw/*137.106*/("""
		</div>
    """)))})),format.raw/*139.6*/("""

""")))})),format.raw/*141.2*/("""


<script>
$( function()"""),format.raw/*145.14*/("""{"""),format.raw/*145.15*/("""
	$("#desde, #hasta").mask("99/99/9999");
	$('#searchProveedor, #searchProducto').modalSearch();
	
	
	
	
	
"""),format.raw/*153.1*/("""}"""),format.raw/*153.2*/(""")
</script>"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[Inventario],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[Inventario],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/inventario/indexInventario.scala.html
                    HASH: 98e4b0ecfb7b5f07f2196135595c30a5e64e67c2
                    MATRIX: 851->1|1063->214|1077->221|1161->225|1213->242|1227->248|1298->298|1366->140|1398->164|1472->79|1501->208|1532->335|1572->340|1585->345|1648->399|1688->401|1885->563|1898->568|1945->593|1983->596|1997->602|2110->705|2151->707|2307->828|2583->1081|2796->1259|2904->1345|3067->1473|3155->1539|3343->1692|3448->1775|3490->1782|3615->1884|3827->2060|3847->2071|3920->2122|4372->2539|4509->2653|4550->2659|4653->2740|4805->2855|4826->2866|4898->2915|5511->3492|5531->3503|5600->3550|5716->3634|5761->3643|5805->3677|5846->3679|5991->3806|6005->3811|6045->3812|6101->3831|6119->3839|6174->3871|6537->4197|6580->4223|6621->4225|6687->4254|6698->4255|6737->4271|6791->4288|6822->4309|6872->4312|6883->4313|6927->4330|6981->4347|6992->4348|7022->4355|7076->4372|7087->4373|7124->4387|7191->4421|7304->4498|7319->4503|7436->4596|7485->4613|7522->4618|7580->4647|7610->4648|7753->4763|7782->4764
                    LINES: 26->1|33->7|33->7|35->7|36->8|36->8|36->8|37->5|37->5|38->1|39->5|41->9|43->11|43->11|43->11|43->11|56->24|56->24|56->24|57->25|57->25|57->25|57->25|62->30|64->32|74->42|74->42|80->48|80->48|90->58|90->58|91->59|91->59|96->64|96->64|96->64|112->80|112->80|113->81|113->81|114->82|114->82|114->82|128->96|128->96|128->96|133->101|136->104|136->104|136->104|142->110|142->110|142->110|144->112|144->112|144->112|156->124|156->124|156->124|159->127|159->127|159->127|160->128|160->128|160->128|160->128|160->128|161->129|161->129|161->129|162->130|162->130|162->130|164->132|169->137|169->137|169->137|171->139|173->141|177->145|177->145|185->153|185->153
                    -- GENERATED --
                */
            