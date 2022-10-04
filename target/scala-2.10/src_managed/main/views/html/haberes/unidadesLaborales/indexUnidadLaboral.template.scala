
package views.html.haberes.unidadesLaborales

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
object indexUnidadLaboral extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[models.haberes.UnidadLaboral],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[models.haberes.UnidadLaboral], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

implicit def /*6.2*/implicitFieldConstructor/*6.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.98*/("""
"""),format.raw/*5.1*/("""
"""),format.raw/*6.70*/(""" 
"""),_display_(Seq[Any](/*7.2*/views/*7.7*/.html.haberes.mainHaberes("Lista Unidades Laborales ")/*7.61*/ {_display_(Seq[Any](format.raw/*7.63*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Lista Unidades Laborales</h1>
			</div>
	
			<div class="col-sm-5">
				<div class="pull-right btn-header">
					<a href=""""),_display_(Seq[Any](/*17.16*/controllers/*17.27*/.haberes.routes.UnidadesLaboralesController.crear())),format.raw/*17.78*/("""?"""),_display_(Seq[Any](/*17.80*/UriTrack/*17.88*/.encode())),format.raw/*17.97*/(""""  class="form-control btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo Unidad</a>
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
					<a href=""""),_display_(Seq[Any](/*44.16*/controllers/*44.27*/.haberes.routes.UnidadesLaboralesController.index())),format.raw/*44.78*/(""""  class="form-control btn btn-default">Limpiar</a>
					</div>
				</div>
			</div>
		</form>
	</div>
	
	"""),_display_(Seq[Any](/*51.3*/if(buscador.getTotalRowCount == 0)/*51.37*/ {_display_(Seq[Any](format.raw/*51.39*/("""
        
        <div class="well">
            <em>No se encuentran Unidades Laborales</em>
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
				<tr class="pointer" data-href=""""),_display_(Seq[Any](/*74.37*/controllers/*74.48*/.haberes.routes.UnidadesLaboralesController.ver(lc.id))),format.raw/*74.102*/("""&"""),_display_(Seq[Any](/*74.104*/UriTrack/*74.112*/.encode())),format.raw/*74.121*/("""">
					<td><input type="checkbox" name="check_listado[]" value=""""),_display_(Seq[Any](/*75.64*/lc/*75.66*/.id)),format.raw/*75.69*/("""" class="notSeleccion" id="check-"""),_display_(Seq[Any](/*75.103*/lc/*75.105*/.id)),format.raw/*75.108*/(""""/></td>
					<td>
						<a class="btn btn-default btn-xs notSeleccion" href=""""),_display_(Seq[Any](/*77.61*/controllers/*77.72*/.haberes.routes.UnidadesLaboralesController.editar(lc.id))),format.raw/*77.129*/("""&"""),_display_(Seq[Any](/*77.131*/UriTrack/*77.139*/.encode())),format.raw/*77.148*/("""">
							<i class="glyphicon glyphicon-edit"></i>
						</a>
					</td>
					<td>"""),_display_(Seq[Any](/*81.11*/(lc.nombre))),format.raw/*81.22*/("""</td>
					<td>
						<a class="btn btn-default btn-xs delete-confirm-link notSeleccion" href=""""),_display_(Seq[Any](/*83.81*/controllers/*83.92*/.haberes.routes.UnidadesLaboralesController.eliminar(lc.id))),format.raw/*83.151*/("""&"""),_display_(Seq[Any](/*83.153*/UriTrack/*83.161*/.encode())),format.raw/*83.170*/("""">
							<i class="glyphicon glyphicon-trash icono-eliminar"></i>
						</a>
					</td>
				</tr>
             """)))})),format.raw/*88.15*/("""
	        </tbody>
        </table>
        
        <div class="pagination pull-right">
		    """),_display_(Seq[Any](/*93.8*/views/*93.13*/.html.helpers.paginador(buscador, controllers.haberes.routes.UnidadesLaboralesController.index()))),format.raw/*93.110*/("""
		</div>
 	 """)))})),format.raw/*95.5*/("""
""")))})))}
    }
    
    def render(buscador:utils.pagination.Pagination[models.haberes.UnidadLaboral],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[models.haberes.UnidadLaboral],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/unidadesLaborales/indexUnidadLaboral.scala.html
                    HASH: 6bbe345d2be6f77c5b89699ee6275f1d9a5886be
                    MATRIX: 876->1|1112->155|1144->179|1218->97|1245->153|1273->223|1310->226|1322->231|1384->285|1423->287|1665->493|1685->504|1758->555|1796->557|1813->565|1844->574|2024->719|2037->724|2084->749|2320->950|2428->1036|2847->1419|2867->1430|2940->1481|3082->1588|3125->1622|3165->1624|3306->1748|3319->1753|3358->1754|3416->1776|3433->1784|3487->1816|3825->2119|3868->2146|3908->2148|3981->2185|4001->2196|4078->2250|4117->2252|4135->2260|4167->2269|4269->2335|4280->2337|4305->2340|4376->2374|4388->2376|4414->2379|4529->2458|4549->2469|4629->2526|4668->2528|4686->2536|4718->2545|4837->2628|4870->2639|5002->2735|5022->2746|5104->2805|5143->2807|5161->2815|5193->2824|5338->2937|5469->3033|5483->3038|5603->3135|5648->3149
                    LINES: 26->1|33->6|33->6|34->1|35->5|36->6|37->7|37->7|37->7|37->7|47->17|47->17|47->17|47->17|47->17|47->17|53->23|53->23|53->23|61->31|61->31|74->44|74->44|74->44|81->51|81->51|81->51|87->57|87->57|87->57|89->59|89->59|89->59|103->73|103->73|103->73|104->74|104->74|104->74|104->74|104->74|104->74|105->75|105->75|105->75|105->75|105->75|105->75|107->77|107->77|107->77|107->77|107->77|107->77|111->81|111->81|113->83|113->83|113->83|113->83|113->83|113->83|118->88|123->93|123->93|123->93|125->95
                    -- GENERATED --
                */
            