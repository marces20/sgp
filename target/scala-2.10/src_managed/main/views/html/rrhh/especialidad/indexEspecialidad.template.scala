
package views.html.rrhh.especialidad

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
object indexEspecialidad extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[Especialidad],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[Especialidad], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.82*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.rrhh.mainRrhh("Lista Especialidades")/*5.50*/ {_display_(Seq[Any](format.raw/*5.52*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Lista de Especialidades</h1>
			</div>
			<div class="col-sm-2">
				<a href=""""),_display_(Seq[Any](/*13.15*/controllers/*13.26*/.rrhh.routes.EspecialidadesController.indexEspecialidad())),format.raw/*13.83*/("""" class="btn btn-default">
					<i class="glyphicon glyphicon-list"></i>
				</a>
				<a href="#" class="btn btn-default">
					<i class="glyphicon glyphicon-align-justify"></i>
				</a>
			</div>
		</div>
	</div>
	<div id="actions">
		<div class="row">
			<form action="" method="GET">
				<div class="col-sm-3">
					<div class="form-group">
						<label for="nombre" class="control-label">Nombre
						"""),_display_(Seq[Any](/*28.8*/inputText(formBuscador("nombre"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*28.94*/("""
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
					<a href=""""),_display_(Seq[Any](/*41.16*/controllers/*41.27*/.rrhh.routes.EspecialidadesController.indexEspecialidad())),format.raw/*41.84*/(""""  class="form-control btn btn-default">Limpiar</a>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*49.14*/controllers/*49.25*/.rrhh.routes.EspecialidadesController.crearEspecialidad)),format.raw/*49.80*/(""""  class="form-control btn btn-default">Nueva Especialidad</a>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*53.3*/if(buscador.getTotalRowCount == 0)/*53.37*/ {_display_(Seq[Any](format.raw/*53.39*/("""
        
        <div class="well">
            <em>No se encuentran Especialidades</em>
        </div>
        
    """)))}/*59.7*/else/*59.12*/{_display_(Seq[Any](format.raw/*59.13*/("""
		
		Mostrando """),_display_(Seq[Any](/*61.14*/buscador/*61.22*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*61.54*/(""" resultado(s). 
		
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th width="50">#</th>
					<th width="100">"Código"</th>
					<th width="300">Nombre</th>
					<th class="50">#</th>
				</tr>
			</thead>
			<tbody>
			"""),_display_(Seq[Any](/*73.5*/for(especialidad <- buscador.getList) yield /*73.42*/ {_display_(Seq[Any](format.raw/*73.44*/("""
				<tr>
					<td>
						<a href=""""),_display_(Seq[Any](/*76.17*/controllers/*76.28*/.rrhh.routes.EspecialidadesController.editarEspecialidad(especialidad.id))),format.raw/*76.101*/("""">
							<i class="glyphicon glyphicon-edit"></i>
						</a>
					</td>
					<td>"""),_display_(Seq[Any](/*80.11*/(especialidad.id))),format.raw/*80.28*/("""</td>
					<td>"""),_display_(Seq[Any](/*81.11*/(especialidad.nombre))),format.raw/*81.32*/("""</td>
					<td>
						<a href=""""),_display_(Seq[Any](/*83.17*/controllers/*83.28*/.rrhh.routes.EspecialidadesController.eliminarEspecialidad(especialidad.id))),format.raw/*83.103*/("""">
							<i class="glyphicon glyphicon-remove-circle"></i>
						</a>
					</td>
				</tr>
             """)))})),format.raw/*88.15*/("""
	        </tbody>
        </table>
		
		<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*93.8*/views/*93.13*/.html.helpers.paginador(buscador, controllers.rrhh.routes.EspecialidadesController.indexEspecialidad()))),format.raw/*93.116*/("""
		</div>
 	 """)))})),format.raw/*95.5*/("""
""")))})),format.raw/*96.2*/("""
		
		
	
	"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[Especialidad],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[Especialidad],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:31 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/especialidad/indexEspecialidad.scala.html
                    HASH: 0eff9f8731f46b13def8efa7c98980ad87dd46ae
                    MATRIX: 851->1|1033->100|1065->124|1139->81|1167->168|1205->172|1217->177|1268->220|1307->222|1506->385|1526->396|1605->453|2046->859|2154->945|2572->1327|2592->1338|2671->1395|2867->1555|2887->1566|2964->1621|3083->1705|3126->1739|3166->1741|3303->1861|3316->1866|3355->1867|3408->1884|3425->1892|3479->1924|3765->2175|3818->2212|3858->2214|3930->2250|3950->2261|4046->2334|4165->2417|4204->2434|4256->2450|4299->2471|4367->2503|4387->2514|4485->2589|4623->2695|4742->2779|4756->2784|4882->2887|4927->2901|4960->2903
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|41->13|41->13|41->13|56->28|56->28|69->41|69->41|69->41|77->49|77->49|77->49|81->53|81->53|81->53|87->59|87->59|87->59|89->61|89->61|89->61|101->73|101->73|101->73|104->76|104->76|104->76|108->80|108->80|109->81|109->81|111->83|111->83|111->83|116->88|121->93|121->93|121->93|123->95|124->96
                    -- GENERATED --
                */
            