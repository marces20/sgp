
package views.html.compras.productos

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
object indexProducto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[utils.pagination.Pagination[Producto],DynamicForm,utils.pagination.PaginadorFicha,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[Producto], formBuscador: DynamicForm, paginadorFicha: utils.pagination.PaginadorFicha):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.127*/("""
"""),format.raw/*4.70*/(""" 

"""),_display_(Seq[Any](/*6.2*/views/*6.7*/.html.compras.mainCompras("Lista Productos")/*6.51*/ {_display_(Seq[Any](format.raw/*6.53*/("""
	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Lista de Productos</h1>
			</div>
	
			<div class="col-sm-5">
			 
				 
				<div class="pull-right btn-header">
					<a href=""""),_display_(Seq[Any](/*17.16*/controllers/*17.27*/.compras.routes.ProductosController.crearProducto)),format.raw/*17.76*/(""""  class="btn btn-default pull-right"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo Producto</a>
				</div>
			</div>
		</div>
	</div>
	
"""),_display_(Seq[Any](/*23.2*/views/*23.7*/.html.tags.successError())),format.raw/*23.32*/("""
	
	
	<div id="actions">
		<div class="row">
			<form action="" method="GET">
				<div class="col-sm-3">
					<div class="form-group">
						<label for="nombre" class="control-label">Nombre
							"""),_display_(Seq[Any](/*32.9*/inputText(formBuscador("nombre"), 'class -> "form-control"))),format.raw/*32.68*/("""
						</label>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="inputCategoria" class="control-label">Categor&iacute;a</label> 
						"""),_display_(Seq[Any](/*39.8*/inputText(formBuscador("categoria.nombre"),'class -> "form-control"))),format.raw/*39.76*/("""
						"""),_display_(Seq[Any](/*40.8*/inputText(formBuscador("categoria_id"),'hidden -> "hidden"))),format.raw/*40.67*/("""
					</div>
				</div>
				<div class="col-sm-2">
					<div class="form-group">
					<label for="nombre" class="control-label">&nbsp;</label>
					<button  class="form-control btn btn-primary">Buscar</button>
					</div>
				</div>
				<div class="col-sm-2">
					<div class="form-group">
					<label for="nombre" class="control-label">&nbsp;</label>
					<a href=""""),_display_(Seq[Any](/*52.16*/controllers/*52.27*/.compras.routes.ProductosController.indexProducto())),format.raw/*52.78*/(""""  class="form-control btn btn-default">Limpiar</a>
					</div>
				</div>
			</form>
		</div>
	</div>
	 

	"""),_display_(Seq[Any](/*60.3*/if(buscador.getTotalRowCount == 0)/*60.37*/ {_display_(Seq[Any](format.raw/*60.39*/("""
        
        <div class="well">
            <em>No se encuentran Productos</em>
        </div>
        
    """)))}/*66.7*/else/*66.12*/{_display_(Seq[Any](format.raw/*66.13*/("""
		Mostrando """),_display_(Seq[Any](/*67.14*/buscador/*67.22*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*67.54*/(""" resultado(s). 
		
		<table class="table table-striped table-bordered ">
			<thead>
				<tr>
					<th width="30">#</th>
					<th>Código</th>
					<th>ID-RISMI</th>
					<th width="600">Nombre</th>
					<th>Referencia</th>
					<th>Categoria</th>
					<th>Precio</th>
					<th>Estado</th>
					<th class="30">#</th>
				</tr>
			</thead>
			<tbody>
			"""),_display_(Seq[Any](/*84.5*/for(producto <- buscador.getList) yield /*84.38*/ {_display_(Seq[Any](format.raw/*84.40*/("""
				"""),_display_(Seq[Any](/*85.6*/paginadorFicha/*85.20*/.add(producto.id.toString))),format.raw/*85.46*/("""
				<tr class="pointer """),_display_(Seq[Any](/*86.25*/if(producto.activo != true)/*86.52*/{_display_(Seq[Any](format.raw/*86.53*/("""cancelada""")))})),format.raw/*86.63*/("""" data-href=""""),_display_(Seq[Any](/*86.77*/controllers/*86.88*/.compras.routes.ProductosController.ver(producto.id))),format.raw/*86.140*/("""&"""),_display_(Seq[Any](/*86.142*/UriTrack/*86.150*/.encode())),format.raw/*86.159*/("""">
					<td>
						<a href=""""),_display_(Seq[Any](/*88.17*/controllers/*88.28*/.compras.routes.ProductosController.editarProducto(producto.id))),format.raw/*88.91*/("""">
							<i class="glyphicon glyphicon-edit"></i>
						</a>
					</td>
					<td>"""),_display_(Seq[Any](/*92.11*/(producto.id))),format.raw/*92.24*/("""</td>
					<td>"""),_display_(Seq[Any](/*93.11*/if(producto.codigo_rismi != null)/*93.44*/{_display_(Seq[Any](_display_(Seq[Any](/*93.46*/producto/*93.54*/.codigo_rismi))))})),format.raw/*93.68*/("""</td>
					<td>"""),_display_(Seq[Any](/*94.11*/(producto.nombre))),format.raw/*94.28*/("""</td>
					<td>"""),_display_(Seq[Any](/*95.11*/(producto.referencia))),format.raw/*95.32*/("""</td>
					<td>"""),_display_(Seq[Any](/*96.11*/(producto.categoria.nombre))),format.raw/*96.38*/("""</td>
					<td>"""),_display_(Seq[Any](/*97.11*/if(producto.precio_coste != null)/*97.44*/{_display_(Seq[Any](_display_(Seq[Any](/*97.46*/(utils.NumberUtils.moneda(producto.precio_coste))))))})),format.raw/*97.96*/("""</td>
					<td>"""),_display_(Seq[Any](/*98.11*/if(producto.activo)/*98.30*/{_display_(Seq[Any](format.raw/*98.31*/("""ALTA""")))}/*98.36*/else/*98.40*/{_display_(Seq[Any](format.raw/*98.41*/("""BAJA""")))})),format.raw/*98.46*/("""</td>
					<td>
						<a href=""""),_display_(Seq[Any](/*100.17*/controllers/*100.28*/.compras.routes.ProductosController.eliminarProducto(producto.id))),format.raw/*100.93*/("""">
							<i class="glyphicon glyphicon-remove-circle"></i>
						</a>
					</td>
				</tr>
             """)))})),format.raw/*105.15*/("""
              """),_display_(Seq[Any](/*106.16*/paginadorFicha/*106.30*/.guardar())),format.raw/*106.40*/("""
	        </tbody>
        </table>
        
        <div class="pagination pull-right">
		    """),_display_(Seq[Any](/*111.8*/views/*111.13*/.html.helpers.paginador(buscador, controllers.compras.routes.ProductosController.indexProducto()))),format.raw/*111.110*/("""
		</div>
 	 """)))})),format.raw/*113.5*/("""
""")))})))}
    }
    
    def render(buscador:utils.pagination.Pagination[Producto],formBuscador:DynamicForm,paginadorFicha:utils.pagination.PaginadorFicha): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador,paginadorFicha)
    
    def f:((utils.pagination.Pagination[Producto],DynamicForm,utils.pagination.PaginadorFicha) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador,paginadorFicha) => apply(buscador,formBuscador,paginadorFicha)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:45 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/productos/indexProducto.scala.html
                    HASH: 1a88734779f583a40db9e2bb211226c6d4c96a52
                    MATRIX: 875->1|1118->161|1150->185|1225->126|1253->229|1291->233|1303->238|1355->282|1394->284|1640->494|1660->505|1731->554|1910->698|1923->703|1970->728|2203->926|2284->985|2504->1170|2594->1238|2637->1246|2718->1305|3121->1672|3141->1683|3214->1734|3358->1843|3401->1877|3441->1879|3573->1994|3586->1999|3625->2000|3675->2014|3692->2022|3746->2054|4133->2406|4182->2439|4222->2441|4263->2447|4286->2461|4334->2487|4395->2512|4431->2539|4470->2540|4512->2550|4562->2564|4582->2575|4657->2627|4696->2629|4714->2637|4746->2646|4811->2675|4831->2686|4916->2749|5035->2832|5070->2845|5122->2861|5164->2894|5212->2896|5229->2904|5269->2918|5321->2934|5360->2951|5412->2967|5455->2988|5507->3004|5556->3031|5608->3047|5650->3080|5698->3082|5774->3132|5826->3148|5854->3167|5893->3168|5917->3173|5930->3177|5969->3178|6006->3183|6075->3215|6096->3226|6184->3291|6323->3397|6376->3413|6400->3427|6433->3437|6565->3533|6580->3538|6701->3635|6747->3649
                    LINES: 26->1|31->4|31->4|32->1|33->4|35->6|35->6|35->6|35->6|46->17|46->17|46->17|52->23|52->23|52->23|61->32|61->32|68->39|68->39|69->40|69->40|81->52|81->52|81->52|89->60|89->60|89->60|95->66|95->66|95->66|96->67|96->67|96->67|113->84|113->84|113->84|114->85|114->85|114->85|115->86|115->86|115->86|115->86|115->86|115->86|115->86|115->86|115->86|115->86|117->88|117->88|117->88|121->92|121->92|122->93|122->93|122->93|122->93|122->93|123->94|123->94|124->95|124->95|125->96|125->96|126->97|126->97|126->97|126->97|127->98|127->98|127->98|127->98|127->98|127->98|127->98|129->100|129->100|129->100|134->105|135->106|135->106|135->106|140->111|140->111|140->111|142->113
                    -- GENERATED --
                */
            