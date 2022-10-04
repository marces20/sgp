
package views.html.haberes.categoriasLaborales

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
object indexCategoriaLaboral extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[models.haberes.CategoriaLaboral],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[models.haberes.CategoriaLaboral], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

implicit def /*6.2*/implicitFieldConstructor/*6.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.101*/("""
"""),format.raw/*5.1*/("""
"""),format.raw/*6.70*/(""" 
"""),_display_(Seq[Any](/*7.2*/views/*7.7*/.html.haberes.mainHaberes("Lista Categorias Laborales ")/*7.63*/ {_display_(Seq[Any](format.raw/*7.65*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Lista Categorias Laborales</h1>
			</div>
	
			<div class="col-sm-5">
				<div class="pull-right btn-header">
					<a href=""""),_display_(Seq[Any](/*17.16*/controllers/*17.27*/.haberes.routes.CategoriasLaboralesController.crear())),format.raw/*17.80*/("""?"""),_display_(Seq[Any](/*17.82*/UriTrack/*17.90*/.encode())),format.raw/*17.99*/(""""  class="form-control btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nueva Categoria</a>
				</div>
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*23.3*/views/*23.8*/.html.tags.successError())),format.raw/*23.33*/("""
	
	<div id="actions">
		<form action="" method="GET">
			<div class="row">
				<div class="col-sm-3">
					<div class="form-group">
						<label for="nombre" class="control-label">Denominacion
						"""),_display_(Seq[Any](/*31.8*/inputText(formBuscador("nombre"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*31.94*/("""
						</label>
					</div>
				</div>
				<div class="col-sm-2">
					<div class="form-group">
					<label for="buscar" class="control-label">&nbsp;</label>
					<button  class="form-control btn btn-primary">Buscar</button>
					</div>
				</div>
				<div class="col-sm-2">
					<div class="form-group">
					<label for="limpiar" class="control-label">&nbsp;</label>
					<a href=""""),_display_(Seq[Any](/*44.16*/controllers/*44.27*/.haberes.routes.CategoriasLaboralesController.index())),format.raw/*44.80*/(""""  class="form-control btn btn-default">Limpiar</a>
					</div>
				</div>
			</div>
		</form>
	</div>
	
	"""),_display_(Seq[Any](/*51.3*/if(buscador.getTotalRowCount == 0)/*51.37*/ {_display_(Seq[Any](format.raw/*51.39*/("""
        
        <div class="well">
            <em>No se encuentran Categoria Laborales</em>
        </div>
        
    """)))}/*57.7*/else/*57.12*/{_display_(Seq[Any](format.raw/*57.13*/("""
    
    	Mostrando """),_display_(Seq[Any](/*59.17*/buscador/*59.25*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*59.57*/(""" resultado(s). 
		
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th width="30">
						<input type="checkbox" name="checkAll" id="checkAll"/>
					</th>
					<th width="30">#</th>
					<th>Denominacion</th>
					<th width="30">#</th>
				</tr>
			</thead>
			<tbody>
			"""),_display_(Seq[Any](/*73.5*/for(lc <- buscador.getList) yield /*73.32*/ {_display_(Seq[Any](format.raw/*73.34*/("""
				<tr class="pointer" data-href=""""),_display_(Seq[Any](/*74.37*/controllers/*74.48*/.haberes.routes.CategoriasLaboralesController.ver(lc.id))),format.raw/*74.104*/("""&"""),_display_(Seq[Any](/*74.106*/UriTrack/*74.114*/.encode())),format.raw/*74.123*/("""">
					<td><input type="checkbox" name="check_listado[]" value=""""),_display_(Seq[Any](/*75.64*/lc/*75.66*/.id)),format.raw/*75.69*/("""" class="notSeleccion" id="check-"""),_display_(Seq[Any](/*75.103*/lc/*75.105*/.id)),format.raw/*75.108*/(""""/></td>
					<td>
						"""),_display_(Seq[Any](/*77.8*/if(Permiso.check("categoriaLaboralEditar"))/*77.51*/ {_display_(Seq[Any](format.raw/*77.53*/("""
						<a class="btn btn-default btn-xs notSeleccion" href=""""),_display_(Seq[Any](/*78.61*/controllers/*78.72*/.haberes.routes.CategoriasLaboralesController.editar(lc.id))),format.raw/*78.131*/("""&"""),_display_(Seq[Any](/*78.133*/UriTrack/*78.141*/.encode())),format.raw/*78.150*/("""">
							<i class="glyphicon glyphicon-edit"></i>
						</a>
						""")))})),format.raw/*81.8*/("""
					</td>
					<td>"""),_display_(Seq[Any](/*83.11*/(lc.nombre))),format.raw/*83.22*/("""</td>
					<td>
						"""),_display_(Seq[Any](/*85.8*/if(Permiso.check("categoriaLaboralEliminar"))/*85.53*/ {_display_(Seq[Any](format.raw/*85.55*/("""
						<a class="btn btn-default btn-xs delete-confirm-link notSeleccion" href=""""),_display_(Seq[Any](/*86.81*/controllers/*86.92*/.haberes.routes.CategoriasLaboralesController.eliminar(lc.id))),format.raw/*86.153*/("""&"""),_display_(Seq[Any](/*86.155*/UriTrack/*86.163*/.encode())),format.raw/*86.172*/("""">
							<i class="glyphicon glyphicon-trash icono-eliminar"></i>
						</a>
						""")))})),format.raw/*89.8*/("""
					</td>
				</tr>
             """)))})),format.raw/*92.15*/("""
	        </tbody>
        </table>
        
        <div class="pagination pull-right">
		    """),_display_(Seq[Any](/*97.8*/views/*97.13*/.html.helpers.paginador(buscador, controllers.haberes.routes.CategoriasLaboralesController.index()))),format.raw/*97.112*/("""
		</div>
 	 """)))})),format.raw/*99.5*/("""
""")))})))}
    }
    
    def render(buscador:utils.pagination.Pagination[models.haberes.CategoriaLaboral],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[models.haberes.CategoriaLaboral],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/categoriasLaborales/indexCategoriaLaboral.scala.html
                    HASH: 8f4727fe9688f461f85021bac0273e744354529b
                    MATRIX: 884->1|1123->158|1155->182|1230->100|1257->156|1285->226|1322->229|1334->234|1398->290|1437->292|1681->500|1701->511|1776->564|1814->566|1831->574|1862->583|2045->731|2058->736|2105->761|2341->962|2449->1048|2868->1431|2888->1442|2963->1495|3105->1602|3148->1636|3188->1638|3330->1763|3343->1768|3382->1769|3440->1791|3457->1799|3511->1831|3849->2134|3892->2161|3932->2163|4005->2200|4025->2211|4104->2267|4143->2269|4161->2277|4193->2286|4295->2352|4306->2354|4331->2357|4402->2391|4414->2393|4440->2396|4501->2422|4553->2465|4593->2467|4690->2528|4710->2539|4792->2598|4831->2600|4849->2608|4881->2617|4981->2686|5039->2708|5072->2719|5130->2742|5184->2787|5224->2789|5341->2870|5361->2881|5445->2942|5484->2944|5502->2952|5534->2961|5650->3046|5718->3082|5849->3178|5863->3183|5985->3282|6030->3296
                    LINES: 26->1|33->6|33->6|34->1|35->5|36->6|37->7|37->7|37->7|37->7|47->17|47->17|47->17|47->17|47->17|47->17|53->23|53->23|53->23|61->31|61->31|74->44|74->44|74->44|81->51|81->51|81->51|87->57|87->57|87->57|89->59|89->59|89->59|103->73|103->73|103->73|104->74|104->74|104->74|104->74|104->74|104->74|105->75|105->75|105->75|105->75|105->75|105->75|107->77|107->77|107->77|108->78|108->78|108->78|108->78|108->78|108->78|111->81|113->83|113->83|115->85|115->85|115->85|116->86|116->86|116->86|116->86|116->86|116->86|119->89|122->92|127->97|127->97|127->97|129->99
                    -- GENERATED --
                */
            