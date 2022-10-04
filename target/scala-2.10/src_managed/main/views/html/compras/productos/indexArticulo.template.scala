
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
object indexArticulo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[Articulo],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[Articulo], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.78*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.compras.mainCompras("Lista Articulos")/*5.51*/ {_display_(Seq[Any](format.raw/*5.53*/("""
	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Lista de Articulos</h1>
			</div>
	
			<div class="col-sm-2">
				<a href=""""),_display_(Seq[Any](/*13.15*/controllers/*13.26*/.compras.routes.ArticulosController.indexArticulo())),format.raw/*13.77*/("""" class="btn btn-default">
					<i class="glyphicon glyphicon-list"></i>
				</a>
				<a href="#" class="btn btn-default">
					<i class="glyphicon glyphicon-align-justify"></i>
				</a>
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*23.3*/if(flash.containsKey("success"))/*23.35*/ {_display_(Seq[Any](format.raw/*23.37*/("""
		<div class="alert alert-success"><i class="glyphicon glyphicon-ok-sign"></i> """),_display_(Seq[Any](/*24.81*/flash/*24.86*/.get("success"))),format.raw/*24.101*/("""</div>
	""")))})),format.raw/*25.3*/("""
	"""),_display_(Seq[Any](/*26.3*/if(flash.containsKey("error"))/*26.33*/ {_display_(Seq[Any](format.raw/*26.35*/("""
		<div class="alert alert-danger"><i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*27.84*/flash/*27.89*/.get("error"))),format.raw/*27.102*/("""</div>
	""")))})),format.raw/*28.3*/("""
	
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
					<a href=""""),_display_(Seq[Any](/*49.16*/controllers/*49.27*/.compras.routes.ArticulosController.indexArticulo())),format.raw/*49.78*/(""""  class="form-control btn btn-default">Limpiar</a>
					</div>
				</div>
			</form>
		</div>
	</div>
	
	<div class="row">
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*58.14*/controllers/*58.25*/.compras.routes.ArticulosController.crearArticulo)),format.raw/*58.74*/(""""  class="form-control btn btn-default">Nuevo Articulo</a>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*62.3*/if(buscador.getTotalRowCount == 0)/*62.37*/ {_display_(Seq[Any](format.raw/*62.39*/("""
        
        <div class="well">
            <em>No se encuentran Articulos</em>
        </div>
        
    """)))}/*68.7*/else/*68.12*/{_display_(Seq[Any](format.raw/*68.13*/("""
    	Mostrando """),_display_(Seq[Any](/*69.17*/buscador/*69.25*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*69.57*/(""" resultado(s). 
		
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th width="50">#</th>
					<th width="100">Código</th>
					<th width="300">Nombre</th>
					<th class="50">#</th>
				</tr>
			</thead>
			<tbody>
			"""),_display_(Seq[Any](/*81.5*/for(articulo <- buscador.getList) yield /*81.38*/ {_display_(Seq[Any](format.raw/*81.40*/("""
				<tr>
					<td>
						<a href=""""),_display_(Seq[Any](/*84.17*/controllers/*84.28*/.compras.routes.ArticulosController.editarArticulo(articulo.id))),format.raw/*84.91*/("""">
							<i class="glyphicon glyphicon-edit"></i>
						</a>
					</td>
					<td>"""),_display_(Seq[Any](/*88.11*/(articulo.id))),format.raw/*88.24*/("""</td>
					<td>"""),_display_(Seq[Any](/*89.11*/(articulo.nombre))),format.raw/*89.28*/("""</td>
					<td>
						<a href=""""),_display_(Seq[Any](/*91.17*/controllers/*91.28*/.compras.routes.ArticulosController.eliminarArticulo(articulo.id))),format.raw/*91.93*/("""">
							<i class="glyphicon glyphicon-remove-circle"></i>
						</a>
					</td>
				</tr>
             """)))})),format.raw/*96.15*/("""
	        </tbody>
        </table>
    	
    	<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*101.8*/views/*101.13*/.html.helpers.paginador(buscador, controllers.compras.routes.ArticulosController.indexArticulo()))),format.raw/*101.110*/("""
		</div>
 	 """)))})),format.raw/*103.5*/("""
""")))})))}
    }
    
    def render(buscador:utils.pagination.Pagination[Articulo],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[Articulo],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:45 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/productos/indexArticulo.scala.html
                    HASH: 13245e49369418f8b92e12c20d9c71e6ed3d98a2
                    MATRIX: 843->1|1021->96|1053->120|1127->77|1155->164|1193->168|1205->173|1257->217|1296->219|1491->378|1511->389|1584->440|1837->658|1878->690|1918->692|2035->773|2049->778|2087->793|2127->802|2165->805|2204->835|2244->837|2364->921|2378->926|2414->939|2454->948|2684->1143|2792->1229|3210->1611|3230->1622|3303->1673|3501->1835|3521->1846|3592->1895|3707->1975|3750->2009|3790->2011|3922->2126|3935->2131|3974->2132|4027->2149|4044->2157|4098->2189|4382->2438|4431->2471|4471->2473|4543->2509|4563->2520|4648->2583|4767->2666|4802->2679|4854->2695|4893->2712|4961->2744|4981->2755|5068->2820|5206->2926|5332->3016|5347->3021|5468->3118|5514->3132
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|41->13|41->13|41->13|51->23|51->23|51->23|52->24|52->24|52->24|53->25|54->26|54->26|54->26|55->27|55->27|55->27|56->28|64->36|64->36|77->49|77->49|77->49|86->58|86->58|86->58|90->62|90->62|90->62|96->68|96->68|96->68|97->69|97->69|97->69|109->81|109->81|109->81|112->84|112->84|112->84|116->88|116->88|117->89|117->89|119->91|119->91|119->91|124->96|129->101|129->101|129->101|131->103
                    -- GENERATED --
                */
            