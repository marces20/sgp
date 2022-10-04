
package views.html.haberes.legajos

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
object indexLegajo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[models.haberes.Legajo],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[models.haberes.Legajo], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

implicit def /*6.2*/implicitFieldConstructor/*6.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.91*/("""
"""),format.raw/*5.1*/("""
"""),format.raw/*6.70*/(""" 
"""),_display_(Seq[Any](/*7.2*/views/*7.7*/.html.haberes.mainHaberes("Lista Legajos ")/*7.50*/ {_display_(Seq[Any](format.raw/*7.52*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Lista Legajos</h1>
			</div>
	
			<div class="col-sm-5">
				<div class="pull-right btn-header">
					<a href=""""),_display_(Seq[Any](/*17.16*/controllers/*17.27*/.haberes.routes.LegajosController.crear())),format.raw/*17.68*/("""?"""),_display_(Seq[Any](/*17.70*/UriTrack/*17.78*/.encode())),format.raw/*17.87*/(""""  class="form-control btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nueva Legajo</a>
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
						<label for="numero" class="control-label">Numero
						"""),_display_(Seq[Any](/*31.8*/inputText(formBuscador("numero"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*31.94*/("""
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
					<a href=""""),_display_(Seq[Any](/*44.16*/controllers/*44.27*/.haberes.routes.LegajosController.index())),format.raw/*44.68*/(""""  class="form-control btn btn-default">Limpiar</a>
					</div>
				</div>
			</div>
		</form>
	</div>
	
	"""),_display_(Seq[Any](/*51.3*/if(buscador.getTotalRowCount == 0)/*51.37*/ {_display_(Seq[Any](format.raw/*51.39*/("""
        
        <div class="well">
            <em>No se encuentran Legajos</em>
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
					<th>Numero</th>
					<th>Agente</th>
					<th width="30">#</th>
				</tr>
			</thead>
			<tbody>
			"""),_display_(Seq[Any](/*74.5*/for(lc <- buscador.getList) yield /*74.32*/ {_display_(Seq[Any](format.raw/*74.34*/("""
				<tr class="pointer" data-href=""""),_display_(Seq[Any](/*75.37*/controllers/*75.48*/.haberes.routes.LegajosController.ver(lc.id))),format.raw/*75.92*/("""&"""),_display_(Seq[Any](/*75.94*/UriTrack/*75.102*/.encode())),format.raw/*75.111*/("""">
					<td><input type="checkbox" name="check_listado[]" value=""""),_display_(Seq[Any](/*76.64*/lc/*76.66*/.id)),format.raw/*76.69*/("""" class="notSeleccion" id="check-"""),_display_(Seq[Any](/*76.103*/lc/*76.105*/.id)),format.raw/*76.108*/(""""/></td>
					<td>
						"""),_display_(Seq[Any](/*78.8*/if(Permiso.check("legajoEditar"))/*78.41*/ {_display_(Seq[Any](format.raw/*78.43*/("""
						<a class="btn btn-default btn-xs notSeleccion" href=""""),_display_(Seq[Any](/*79.61*/controllers/*79.72*/.haberes.routes.LegajosController.editar(lc.id))),format.raw/*79.119*/("""&"""),_display_(Seq[Any](/*79.121*/UriTrack/*79.129*/.encode())),format.raw/*79.138*/("""">
							<i class="glyphicon glyphicon-edit"></i>
						</a>
						""")))})),format.raw/*82.8*/("""
					</td>
					<td>"""),_display_(Seq[Any](/*84.11*/(lc.numero))),format.raw/*84.22*/("""</td>
					<td>"""),_display_(Seq[Any](/*85.11*/(lc.agente.apellido))),format.raw/*85.31*/("""</td>
					<td>
						"""),_display_(Seq[Any](/*87.8*/if(Permiso.check("legajoEliminar"))/*87.43*/ {_display_(Seq[Any](format.raw/*87.45*/("""
						<a class="btn btn-default btn-xs delete-confirm-link notSeleccion" href=""""),_display_(Seq[Any](/*88.81*/controllers/*88.92*/.haberes.routes.LegajosController.eliminar(lc.id))),format.raw/*88.141*/("""&"""),_display_(Seq[Any](/*88.143*/UriTrack/*88.151*/.encode())),format.raw/*88.160*/("""">
							<i class="glyphicon glyphicon-trash icono-eliminar"></i>
						</a>
						""")))})),format.raw/*91.8*/("""
					</td>
				</tr>
             """)))})),format.raw/*94.15*/("""
	        </tbody>
        </table>
        
        <div class="pagination pull-right">
		    """),_display_(Seq[Any](/*99.8*/views/*99.13*/.html.helpers.paginador(buscador, controllers.haberes.routes.LegajosController.index()))),format.raw/*99.100*/("""
		</div>
 	 """)))})),format.raw/*101.5*/("""
""")))})))}
    }
    
    def render(buscador:utils.pagination.Pagination[models.haberes.Legajo],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[models.haberes.Legajo],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/legajos/indexLegajo.scala.html
                    HASH: 30e32d1b334bba8efde053bbd42f0aff72351fe6
                    MATRIX: 852->1|1081->148|1113->172|1187->90|1214->146|1242->216|1279->219|1291->224|1342->267|1381->269|1612->464|1632->475|1695->516|1733->518|1750->526|1781->535|1961->680|1974->685|2021->710|2251->905|2359->991|2778->1374|2798->1385|2861->1426|3003->1533|3046->1567|3086->1569|3216->1682|3229->1687|3268->1688|3326->1710|3343->1718|3397->1750|3750->2068|3793->2095|3833->2097|3906->2134|3926->2145|3992->2189|4030->2191|4048->2199|4080->2208|4182->2274|4193->2276|4218->2279|4289->2313|4301->2315|4327->2318|4388->2344|4430->2377|4470->2379|4567->2440|4587->2451|4657->2498|4696->2500|4714->2508|4746->2517|4846->2586|4904->2608|4937->2619|4989->2635|5031->2655|5089->2678|5133->2713|5173->2715|5290->2796|5310->2807|5382->2856|5421->2858|5439->2866|5471->2875|5587->2960|5655->2996|5786->3092|5800->3097|5910->3184|5956->3198
                    LINES: 26->1|33->6|33->6|34->1|35->5|36->6|37->7|37->7|37->7|37->7|47->17|47->17|47->17|47->17|47->17|47->17|53->23|53->23|53->23|61->31|61->31|74->44|74->44|74->44|81->51|81->51|81->51|87->57|87->57|87->57|89->59|89->59|89->59|104->74|104->74|104->74|105->75|105->75|105->75|105->75|105->75|105->75|106->76|106->76|106->76|106->76|106->76|106->76|108->78|108->78|108->78|109->79|109->79|109->79|109->79|109->79|109->79|112->82|114->84|114->84|115->85|115->85|117->87|117->87|117->87|118->88|118->88|118->88|118->88|118->88|118->88|121->91|124->94|129->99|129->99|129->99|131->101
                    -- GENERATED --
                */
            