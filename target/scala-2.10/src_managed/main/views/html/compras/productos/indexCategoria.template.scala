
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
object indexCategoria extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[Categoria],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[Categoria], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.79*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.compras.mainCompras("Lista Categorias")/*5.52*/ {_display_(Seq[Any](format.raw/*5.54*/("""
	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Lista de Categorias</h1>
			</div>
	
			<div class="col-sm-2">
				<a href=""""),_display_(Seq[Any](/*13.15*/controllers/*13.26*/.compras.routes.CategoriasController.indexCategoria())),format.raw/*13.79*/("""" class="btn btn-default">
					<i class="glyphicon glyphicon-list"></i>
				</a>
				<a href="#" class="btn btn-default">
					<i class="glyphicon glyphicon-align-justify"></i>
				</a>
			</div>
		</div>
		
	"""),_display_(Seq[Any](/*22.3*/if(flash.containsKey("success"))/*22.35*/ {_display_(Seq[Any](format.raw/*22.37*/("""
		<div class="alert alert-success"><i class="glyphicon glyphicon-ok-sign"></i> """),_display_(Seq[Any](/*23.81*/flash/*23.86*/.get("success"))),format.raw/*23.101*/("""</div>
	""")))})),format.raw/*24.3*/("""
	"""),_display_(Seq[Any](/*25.3*/if(flash.containsKey("error"))/*25.33*/ {_display_(Seq[Any](format.raw/*25.35*/("""
		<div class="alert alert-danger"><i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*26.84*/flash/*26.89*/.get("error"))),format.raw/*26.102*/("""</div>
	""")))})),format.raw/*27.3*/("""
		
	</div>
	<div id="actions">
		<div class="row">
			<form action="" method="GET">
				<div class="col-sm-3">
					<div class="form-group">
						<label for="nombre" class="control-label">Nombre
						"""),_display_(Seq[Any](/*36.8*/inputText(formBuscador("nombre"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*36.94*/("""
						</label>
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
					<a href=""""),_display_(Seq[Any](/*49.16*/controllers/*49.27*/.compras.routes.CategoriasController.indexCategoria())),format.raw/*49.80*/(""""  class="form-control btn btn-default">Limpiar</a>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*57.14*/controllers/*57.25*/.compras.routes.CategoriasController.crearCategoria)),format.raw/*57.76*/(""""  class="form-control btn btn-default">Nueva Categoria</a>
		</div>
	</div>

	"""),_display_(Seq[Any](/*61.3*/if(buscador.getTotalRowCount == 0)/*61.37*/ {_display_(Seq[Any](format.raw/*61.39*/("""
        
        <div class="well">
            <em>No se encuentran Categorias</em>
        </div>
        
    """)))}/*67.7*/else/*67.12*/{_display_(Seq[Any](format.raw/*67.13*/("""
		
		Mostrando """),_display_(Seq[Any](/*69.14*/buscador/*69.22*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*69.54*/(""" resultado(s). 
		
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th width="50">#</th>
					<th width="100">Código</th>
					<th width="300">Nombre</th>
					<th width="300">Padre</th>
					<th class="50">#</th>
				</tr>
			</thead>
			<tbody>
			"""),_display_(Seq[Any](/*82.5*/for(categoria <- buscador.getList) yield /*82.39*/ {_display_(Seq[Any](format.raw/*82.41*/("""
				<tr>
					<td>
						<a href=""""),_display_(Seq[Any](/*85.17*/controllers/*85.28*/.compras.routes.CategoriasController.editarCategoria(categoria.id))),format.raw/*85.94*/("""">
							<i class="glyphicon glyphicon-edit"></i>
						</a>
					</td>
					<td>"""),_display_(Seq[Any](/*89.11*/(categoria.id))),format.raw/*89.25*/("""</td>
					<td>"""),_display_(Seq[Any](/*90.11*/(categoria.nombre))),format.raw/*90.29*/("""</td>
					<td>"""),_display_(Seq[Any](/*91.11*/if(categoria.parent_categoria != null)/*91.49*/ {_display_(Seq[Any](_display_(Seq[Any](/*91.52*/categoria/*91.61*/.parent_categoria.nombre))))})),format.raw/*91.86*/("""</td>
					<td>
						<a href=""""),_display_(Seq[Any](/*93.17*/controllers/*93.28*/.compras.routes.CategoriasController.eliminarCategoria(categoria.id))),format.raw/*93.96*/("""">
							<i class="glyphicon glyphicon-remove-circle"></i>
						</a>
					</td>
				</tr>
             """)))})),format.raw/*98.15*/("""
	        </tbody>
        </table>
		
		<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*103.8*/views/*103.13*/.html.helpers.paginador(buscador, controllers.compras.routes.CategoriasController.indexCategoria()))),format.raw/*103.112*/("""
		</div>
 	 """)))})),format.raw/*105.5*/("""
""")))})))}
    }
    
    def render(buscador:utils.pagination.Pagination[Categoria],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[Categoria],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:45 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/productos/indexCategoria.scala.html
                    HASH: 65d66351e00fd0e51afb0cc8bf8e46379a1318f6
                    MATRIX: 845->1|1024->97|1056->121|1130->78|1158->165|1196->169|1208->174|1261->219|1300->221|1496->381|1516->392|1591->445|1837->656|1878->688|1918->690|2035->771|2049->776|2087->791|2127->800|2165->803|2204->833|2244->835|2364->919|2378->924|2414->937|2454->946|2693->1150|2801->1236|3219->1618|3239->1629|3314->1682|3510->1842|3530->1853|3603->1904|3718->1984|3761->2018|3801->2020|3934->2136|3947->2141|3986->2142|4039->2159|4056->2167|4110->2199|4426->2480|4476->2514|4516->2516|4588->2552|4608->2563|4696->2629|4815->2712|4851->2726|4903->2742|4943->2760|4995->2776|5042->2814|5091->2817|5109->2826|5160->2851|5228->2883|5248->2894|5338->2962|5476->3068|5596->3152|5611->3157|5734->3256|5780->3270
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|41->13|41->13|41->13|50->22|50->22|50->22|51->23|51->23|51->23|52->24|53->25|53->25|53->25|54->26|54->26|54->26|55->27|64->36|64->36|77->49|77->49|77->49|85->57|85->57|85->57|89->61|89->61|89->61|95->67|95->67|95->67|97->69|97->69|97->69|110->82|110->82|110->82|113->85|113->85|113->85|117->89|117->89|118->90|118->90|119->91|119->91|119->91|119->91|119->91|121->93|121->93|121->93|126->98|131->103|131->103|131->103|133->105
                    -- GENERATED --
                */
            