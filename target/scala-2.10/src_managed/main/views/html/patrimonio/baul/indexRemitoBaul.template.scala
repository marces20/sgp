
package views.html.patrimonio.baul

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
object indexRemitoBaul extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[RemitoBaul],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[RemitoBaul], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import models.auth._

import utils._

implicit def /*6.2*/implicitFieldConstructor/*6.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.80*/("""

"""),format.raw/*6.70*/(""" 


"""),_display_(Seq[Any](/*9.2*/views/*9.7*/.html.patrimonio.mainPatrimonio("Remitos en baúl")/*9.57*/ {_display_(Seq[Any](format.raw/*9.59*/("""


<div class="page-header">
	<div class="row">
		<div class="col-sm-7">
			<h1>Lista de remitos en baúl</h1>
		</div>
			<div class="col-sm-5">
					
				<div class="pull-right btn-header">
					<a href=""""),_display_(Seq[Any](/*20.16*/controllers/*20.27*/.patrimonio.routes.RemitosBaulController.crear())),format.raw/*20.75*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo remito</a>
				</div>
			</div>
	</div>
</div>
"""),_display_(Seq[Any](/*25.2*/views/*25.7*/.html.tags.successError())),format.raw/*25.32*/("""


"""),_display_(Seq[Any](/*28.2*/helper/*28.8*/.form(action = controllers.patrimonio.routes.RemitosBaulController.index(), 'id -> "buscadorRemitos")/*28.109*/ {_display_(Seq[Any](format.raw/*28.111*/("""
<div class="row">	

	<div class="form-group col-sm-2">
		<label for="numero" class="control-label">Número
		"""),_display_(Seq[Any](/*33.4*/inputText(formBuscador("numero"), 'class -> "form-control", 'numero -> "form-control", 'autofocus -> "autofocus"))),format.raw/*33.117*/("""
		</label>
	</div>

	<div class="col-sm-2 input-group">
		<label class="control-label">Fecha Fin</label>
		<div>
		"""),_display_(Seq[Any](/*40.4*/inputText(formBuscador("fecha_desde"), 'class -> "form-control inputDateMascara", 'id -> "desde", 'placeholder -> "Desde"))),format.raw/*40.126*/("""
		"""),_display_(Seq[Any](/*41.4*/inputText(formBuscador("fecha_hasta"), 'class -> "form-control inputDateMascara", 'id -> "hasta", 'placeholder -> "Hasta"))),format.raw/*41.126*/("""
		</div>
		
	</div>

	<div class="col-sm-3">
		<label for="producto" class="control-label">Producto</label>
		<div class="input-group">
			"""),_display_(Seq[Any](/*49.5*/inputText(formBuscador("producto.nombre"), 'class -> "form-control", 'id -> "producto"))),format.raw/*49.92*/("""
			"""),_display_(Seq[Any](/*50.5*/inputText(formBuscador("producto_id"), 'hidden -> "hidden", 'id -> "producto_id"))),format.raw/*50.86*/("""
			<span class="input-group-addon"><a href="#" id="searchProducto" data-title="Selección de producto" data-url=""""),_display_(Seq[Any](/*51.114*/controllers/*51.125*/.compras.routes.ProductosController.modalBuscar())),format.raw/*51.174*/("""" data-height="650" data-width="700" data-listen="modal.seleccion.producto.simple" data-label="#producto" data-field="#producto_id"><i class="glyphicon glyphicon-search"></i></a></span>
		</div>
	</div>


	
</div>

<div class="row">	
	<div class="col-sm-3">
		<label class="control-label">Proveedor
			<div class="input-group">
				"""),_display_(Seq[Any](/*63.6*/inputText(formBuscador("proveedor_id"), 'hidden -> "hidden", 'id -> "proveedor_id"))),format.raw/*63.89*/("""
				"""),_display_(Seq[Any](/*64.6*/inputText(formBuscador("proveedor_nombre"), 'name -> "", 'class -> "form-control", 'id -> "proveedor"))),format.raw/*64.108*/("""
				<span class="input-group-addon">
					<a href="#" class="searchModal"
								id="searchProveedor" 
								data-title="Selección de Proveedores" 
								data-url=""""),_display_(Seq[Any](/*69.20*/controllers/*69.31*/.compras.routes.ProveedoresController.modalBuscar())),format.raw/*69.82*/("""" 
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
		<label class="control-label">Responsable
			<div class="input-group">
				"""),_display_(Seq[Any](/*85.6*/inputText(formBuscador("create_usuario_id"), 'hidden -> "hidden", 'id -> "create_usuario_id"))),format.raw/*85.99*/("""
				"""),_display_(Seq[Any](/*86.6*/inputText(formBuscador("create_usuario.nombre"), 'name -> "", 'class -> "form-control", 'id -> "create_usuario"))),format.raw/*86.118*/("""
				<span class="input-group-addon">
					<a href="#" class="searchModal"
								id="searchResponsable" 
								data-title="Selección de responsables" 
								data-url=""""),_display_(Seq[Any](/*91.20*/controllers/*91.31*/.administracion.routes.UsuariosController.modalBuscar())),format.raw/*91.86*/("""" 
								data-height="650" 
								data-width="700" 
								data-listen="modal.seleccion.usuario.simple" 
								data-label="#create_usuario" 
								data-field="#create_usuario_id">
						<i class="glyphicon glyphicon-search"></i>
					</a>
				</span>
			</div>
		</label>
	</div>

	<div class="col-sm-3">
		<div class="row">
			<div class="col-sm-8">
				<div class="form-group">
					<label for="nombre" class="control-label">&nbsp;</label>
					<button  class="form-control btn btn-primary"><i class="glyphicon glyphicon-search"></i> Buscar</button>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
				<label for="nombre" class="control-label">&nbsp;</label>	
				<a href=""""),_display_(Seq[Any](/*115.15*/controllers/*115.26*/.patrimonio.routes.RemitosBaulController.index())),format.raw/*115.74*/(""""  class="form-control btn btn-default">Limpiar</a>
				</div>
			</div>
		</div>

	</div>	
	
	
</div>
""")))})),format.raw/*124.2*/("""


"""),_display_(Seq[Any](/*127.2*/if(buscador.getTotalRowCount == 0)/*127.36*/ {_display_(Seq[Any](format.raw/*127.38*/("""
      
     <div class="well">
         <em>No se encuentran remitos</em>
     </div>
      
""")))}/*133.3*/else/*133.8*/{_display_(Seq[Any](format.raw/*133.9*/("""

	Mostrando """),_display_(Seq[Any](/*135.13*/buscador/*135.21*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*135.53*/(""" resultado(s).   
	<table id="listaRemitos" class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th width="120">Número</th>
				<th>Proveedor</th>
				<th width="100">Fecha</th>
			</tr>
		</thead>
		<tbody>
	        """),_display_(Seq[Any](/*145.11*/for(remito <- buscador.getList) yield /*145.42*/ {_display_(Seq[Any](format.raw/*145.44*/("""
			<tr class="pointer" data-href=""""),_display_(Seq[Any](/*146.36*/controllers/*146.47*/.patrimonio.routes.RemitosBaulController.ver(remito.id))),format.raw/*146.102*/("""">
				<td>"""),_display_(Seq[Any](/*147.10*/remito/*147.16*/.numero)),format.raw/*147.23*/("""</td>
				<td>"""),_display_(Seq[Any](/*148.10*/remito/*148.16*/.proveedor.nombre)),format.raw/*148.33*/("""</td>
				<td>"""),_display_(Seq[Any](/*149.10*/DateUtils/*149.19*/.formatDate(remito.fecha))),format.raw/*149.44*/("""</td>
			</tr>
	        """)))})),format.raw/*151.11*/("""
		</tbody>
	</table>
	
	<div class="pagination pull-right">
	    """),_display_(Seq[Any](/*156.7*/views/*156.12*/.html.helpers.paginador(buscador, controllers.patrimonio.routes.RemitosController.index()))),format.raw/*156.102*/("""
	</div>
  """)))})),format.raw/*158.4*/("""
""")))})),format.raw/*159.2*/("""


<script>
$( function() """),format.raw/*163.15*/("""{"""),format.raw/*163.16*/("""
	$('#searchProducto, #searchResponsable, #searchProveedor').modalSearch();
	$("#desde, #hasta").mask("99/99/9999");

"""),format.raw/*167.1*/("""}"""),format.raw/*167.2*/(""")
</script>"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[RemitoBaul],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[RemitoBaul],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/baul/indexRemitoBaul.scala.html
                    HASH: 9ddf867dbd5d2a9a4eb55285c068b40f26915be0
                    MATRIX: 845->1|1066->142|1098->166|1172->79|1203->210|1245->218|1257->223|1315->273|1354->275|1607->492|1627->503|1697->551|1864->683|1877->688|1924->713|1966->720|1980->726|2091->827|2132->829|2282->944|2418->1057|2577->1181|2722->1303|2762->1308|2907->1430|3091->1579|3200->1666|3241->1672|3344->1753|3496->1868|3517->1879|3589->1928|3969->2273|4074->2356|4116->2363|4241->2465|4453->2641|4473->2652|4546->2703|4981->3103|5096->3196|5138->3203|5273->3315|5488->3494|5508->3505|5585->3560|6359->4297|6380->4308|6451->4356|6596->4469|6639->4476|6683->4510|6724->4512|6844->4614|6857->4619|6896->4620|6949->4636|6967->4644|7022->4676|7313->4930|7361->4961|7402->4963|7476->5000|7497->5011|7576->5066|7626->5079|7642->5085|7672->5092|7725->5108|7741->5114|7781->5131|7834->5147|7853->5156|7901->5181|7961->5208|8069->5280|8084->5285|8198->5375|8244->5389|8279->5392|8338->5422|8368->5423|8518->5545|8547->5546
                    LINES: 26->1|33->6|33->6|34->1|36->6|39->9|39->9|39->9|39->9|50->20|50->20|50->20|55->25|55->25|55->25|58->28|58->28|58->28|58->28|63->33|63->33|70->40|70->40|71->41|71->41|79->49|79->49|80->50|80->50|81->51|81->51|81->51|93->63|93->63|94->64|94->64|99->69|99->69|99->69|115->85|115->85|116->86|116->86|121->91|121->91|121->91|145->115|145->115|145->115|154->124|157->127|157->127|157->127|163->133|163->133|163->133|165->135|165->135|165->135|175->145|175->145|175->145|176->146|176->146|176->146|177->147|177->147|177->147|178->148|178->148|178->148|179->149|179->149|179->149|181->151|186->156|186->156|186->156|188->158|189->159|193->163|193->163|197->167|197->167
                    -- GENERATED --
                */
            