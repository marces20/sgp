
package views.html.rrhh.departamento

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
object indexDepartamento extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[Departamento],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[Departamento], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.82*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.rrhh.mainRrhh("Lista Departamentos")/*5.49*/ {_display_(Seq[Any](format.raw/*5.51*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Lista de Departamentos</h1>
			</div>
			<div class="col-sm-2">
				<a href=""""),_display_(Seq[Any](/*13.15*/controllers/*13.26*/.rrhh.routes.DepartamentosController.indexDepartamento())),format.raw/*13.82*/("""" class="btn btn-default">
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
					<a href=""""),_display_(Seq[Any](/*41.16*/controllers/*41.27*/.rrhh.routes.DepartamentosController.indexDepartamento())),format.raw/*41.83*/(""""  class="form-control btn btn-default">Limpiar</a>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*49.14*/controllers/*49.25*/.rrhh.routes.DepartamentosController.crearDepartamento)),format.raw/*49.79*/(""""  class="form-control btn btn-default">Nuevo Departamento</a>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*53.3*/if(buscador.getTotalRowCount == 0)/*53.37*/ {_display_(Seq[Any](format.raw/*53.39*/("""
        
        <div class="well">
            <em>No se encuentran Departamento</em>
        </div>
        
    """)))}/*59.7*/else/*59.12*/{_display_(Seq[Any](format.raw/*59.13*/("""
		
		Mostrando """),_display_(Seq[Any](/*61.14*/buscador/*61.22*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*61.54*/(""" resultado(s). 
		
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
			"""),_display_(Seq[Any](/*74.5*/for(departamento <- buscador.getList) yield /*74.42*/ {_display_(Seq[Any](format.raw/*74.44*/("""
				<tr>
					<td>
						<a href=""""),_display_(Seq[Any](/*77.17*/controllers/*77.28*/.rrhh.routes.DepartamentosController.editarDepartamento(departamento.id))),format.raw/*77.100*/("""">
							<i class="glyphicon glyphicon-edit"></i>
						</a>
					</td>
					<td>"""),_display_(Seq[Any](/*81.11*/(departamento.id))),format.raw/*81.28*/("""</td>
					<td>"""),_display_(Seq[Any](/*82.11*/(departamento.nombre))),format.raw/*82.32*/("""</td>
					<td>"""),_display_(Seq[Any](/*83.11*/if(departamento.parent_departamento != null)/*83.55*/{_display_(Seq[Any](_display_(Seq[Any](/*83.57*/(departamento.parent_departamento.nombre)))))})),format.raw/*83.99*/("""</td>
					<td>
						<a href=""""),_display_(Seq[Any](/*85.17*/controllers/*85.28*/.rrhh.routes.DepartamentosController.eliminarDepartamento(departamento.id))),format.raw/*85.102*/("""">
							<i class="glyphicon glyphicon-remove-circle"></i>
						</a>
					</td>
				</tr>
             """)))})),format.raw/*90.15*/("""
	        </tbody>
        </table>
		<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*94.8*/views/*94.13*/.html.helpers.paginador(buscador, controllers.rrhh.routes.DepartamentosController.indexDepartamento()))),format.raw/*94.115*/("""
		</div>
 	 """)))})),format.raw/*96.5*/("""
""")))})),format.raw/*97.2*/("""
		
		
	
	"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[Departamento],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[Departamento],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:30 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/departamento/indexDepartamento.scala.html
                    HASH: 1b8c1a95b32eab37e76b1593cf0b9780182f050e
                    MATRIX: 851->1|1033->100|1065->124|1139->81|1167->168|1205->172|1217->177|1267->219|1306->221|1504->383|1524->394|1602->450|2043->856|2151->942|2569->1324|2589->1335|2667->1391|2863->1551|2883->1562|2959->1616|3078->1700|3121->1734|3161->1736|3296->1854|3309->1859|3348->1860|3401->1877|3418->1885|3472->1917|3788->2198|3841->2235|3881->2237|3953->2273|3973->2284|4068->2356|4187->2439|4226->2456|4278->2472|4321->2493|4373->2509|4426->2553|4474->2555|4542->2597|4610->2629|4630->2640|4727->2714|4865->2820|4981->2901|4995->2906|5120->3008|5165->3022|5198->3024
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|41->13|41->13|41->13|56->28|56->28|69->41|69->41|69->41|77->49|77->49|77->49|81->53|81->53|81->53|87->59|87->59|87->59|89->61|89->61|89->61|102->74|102->74|102->74|105->77|105->77|105->77|109->81|109->81|110->82|110->82|111->83|111->83|111->83|111->83|113->85|113->85|113->85|118->90|122->94|122->94|122->94|124->96|125->97
                    -- GENERATED --
                */
            