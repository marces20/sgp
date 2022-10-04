
package views.html.haberes.escalasLaborales

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
object indexEscalaLaboral extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[models.haberes.EscalaLaboral],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[models.haberes.EscalaLaboral], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

implicit def /*6.2*/implicitFieldConstructor/*6.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.98*/("""
"""),format.raw/*5.1*/("""
"""),format.raw/*6.70*/(""" 
"""),_display_(Seq[Any](/*7.2*/views/*7.7*/.html.haberes.mainHaberes("Lista Escalas Laborales ")/*7.60*/ {_display_(Seq[Any](format.raw/*7.62*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Lista Escalas Laborales</h1>
			</div>
	
			<div class="col-sm-5">
				<div class="pull-right btn-header">
					<a href=""""),_display_(Seq[Any](/*17.16*/controllers/*17.27*/.haberes.routes.EscalasLaboralesController.crear())),format.raw/*17.77*/("""?"""),_display_(Seq[Any](/*17.79*/UriTrack/*17.87*/.encode())),format.raw/*17.96*/(""""  class="form-control btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nueva Escala</a>
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
					<a href=""""),_display_(Seq[Any](/*44.16*/controllers/*44.27*/.haberes.routes.EscalasLaboralesController.index())),format.raw/*44.77*/(""""  class="form-control btn btn-default">Limpiar</a>
					</div>
				</div>
			</div>
		</form>
	</div>
	
	"""),_display_(Seq[Any](/*51.3*/if(buscador.getTotalRowCount == 0)/*51.37*/ {_display_(Seq[Any](format.raw/*51.39*/("""
        
        <div class="well">
            <em>No se encuentran Escalas Laborales</em>
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
				<tr class="pointer" data-href=""""),_display_(Seq[Any](/*74.37*/controllers/*74.48*/.haberes.routes.EscalasLaboralesController.ver(lc.id))),format.raw/*74.101*/("""&"""),_display_(Seq[Any](/*74.103*/UriTrack/*74.111*/.encode())),format.raw/*74.120*/("""">
					<td><input type="checkbox" name="check_listado[]" value=""""),_display_(Seq[Any](/*75.64*/lc/*75.66*/.id)),format.raw/*75.69*/("""" class="notSeleccion" id="check-"""),_display_(Seq[Any](/*75.103*/lc/*75.105*/.id)),format.raw/*75.108*/(""""/></td>
					<td>
						"""),_display_(Seq[Any](/*77.8*/if(Permiso.check("escalaLaboralEditar"))/*77.48*/ {_display_(Seq[Any](format.raw/*77.50*/("""
						<a class="btn btn-default btn-xs notSeleccion" href=""""),_display_(Seq[Any](/*78.61*/controllers/*78.72*/.haberes.routes.EscalasLaboralesController.editar(lc.id))),format.raw/*78.128*/("""&"""),_display_(Seq[Any](/*78.130*/UriTrack/*78.138*/.encode())),format.raw/*78.147*/("""">
							<i class="glyphicon glyphicon-edit"></i>
						</a>
						""")))})),format.raw/*81.8*/("""
					</td>
					<td>"""),_display_(Seq[Any](/*83.11*/(lc.nombre))),format.raw/*83.22*/("""</td>
					<td>
						"""),_display_(Seq[Any](/*85.8*/if(Permiso.check("escalaLaboralEditar"))/*85.48*/ {_display_(Seq[Any](format.raw/*85.50*/("""
						<a class="btn btn-default btn-xs delete-confirm-link notSeleccion" href=""""),_display_(Seq[Any](/*86.81*/controllers/*86.92*/.haberes.routes.EscalasLaboralesController.eliminar(lc.id))),format.raw/*86.150*/("""&"""),_display_(Seq[Any](/*86.152*/UriTrack/*86.160*/.encode())),format.raw/*86.169*/("""">
							<i class="glyphicon glyphicon-trash icono-eliminar"></i>
						</a>
						""")))})),format.raw/*89.8*/("""
					</td>
				</tr>
             """)))})),format.raw/*92.15*/("""
	        </tbody>
        </table>
        
        <div class="pagination pull-right">
		    """),_display_(Seq[Any](/*97.8*/views/*97.13*/.html.helpers.paginador(buscador, controllers.haberes.routes.EscalasLaboralesController.index()))),format.raw/*97.109*/("""
		</div>
 	 """)))})),format.raw/*99.5*/("""
""")))})))}
    }
    
    def render(buscador:utils.pagination.Pagination[models.haberes.EscalaLaboral],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[models.haberes.EscalaLaboral],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/escalasLaborales/indexEscalaLaboral.scala.html
                    HASH: 4d0c2d35667f7ed6822e404332e9e8cb3bd9a3a9
                    MATRIX: 875->1|1111->155|1143->179|1217->97|1244->153|1272->223|1309->226|1321->231|1382->284|1421->286|1662->491|1682->502|1754->552|1792->554|1809->562|1840->571|2020->716|2033->721|2080->746|2316->947|2424->1033|2843->1416|2863->1427|2935->1477|3077->1584|3120->1618|3160->1620|3300->1743|3313->1748|3352->1749|3410->1771|3427->1779|3481->1811|3819->2114|3862->2141|3902->2143|3975->2180|3995->2191|4071->2244|4110->2246|4128->2254|4160->2263|4262->2329|4273->2331|4298->2334|4369->2368|4381->2370|4407->2373|4468->2399|4517->2439|4557->2441|4654->2502|4674->2513|4753->2569|4792->2571|4810->2579|4842->2588|4942->2657|5000->2679|5033->2690|5091->2713|5140->2753|5180->2755|5297->2836|5317->2847|5398->2905|5437->2907|5455->2915|5487->2924|5603->3009|5671->3045|5802->3141|5816->3146|5935->3242|5980->3256
                    LINES: 26->1|33->6|33->6|34->1|35->5|36->6|37->7|37->7|37->7|37->7|47->17|47->17|47->17|47->17|47->17|47->17|53->23|53->23|53->23|61->31|61->31|74->44|74->44|74->44|81->51|81->51|81->51|87->57|87->57|87->57|89->59|89->59|89->59|103->73|103->73|103->73|104->74|104->74|104->74|104->74|104->74|104->74|105->75|105->75|105->75|105->75|105->75|105->75|107->77|107->77|107->77|108->78|108->78|108->78|108->78|108->78|108->78|111->81|113->83|113->83|115->85|115->85|115->85|116->86|116->86|116->86|116->86|116->86|116->86|119->89|122->92|127->97|127->97|127->97|129->99
                    -- GENERATED --
                */
            