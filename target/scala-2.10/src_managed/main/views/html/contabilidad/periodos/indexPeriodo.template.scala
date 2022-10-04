
package views.html.contabilidad.periodos

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
object indexPeriodo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[Periodo],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[Periodo], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.77*/("""
"""),format.raw/*3.70*/("""

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.contabilidad.mainContabilidad("Lista Periodos")/*5.60*/ {_display_(Seq[Any](format.raw/*5.62*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Lista de Periodos</h1>
			</div>
			<div class="col-sm-2">
				<a href=""""),_display_(Seq[Any](/*13.15*/controllers/*13.26*/.contabilidad.routes.PeriodosController.indexPeriodo())),format.raw/*13.80*/("""" class="btn btn-default">
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
					<a href=""""),_display_(Seq[Any](/*41.16*/controllers/*41.27*/.contabilidad.routes.PeriodosController.indexPeriodo())),format.raw/*41.81*/(""""  class="form-control btn btn-default">Limpiar</a>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*49.14*/controllers/*49.25*/.contabilidad.routes.PeriodosController.crearPeriodo)),format.raw/*49.77*/(""""  class="form-control btn btn-default">Nuevo Periodo</a>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*53.3*/if(buscador.getTotalRowCount == 0)/*53.37*/ {_display_(Seq[Any](format.raw/*53.39*/("""
        
        <div class="well">
            <em>No se encuentran Periodos</em>
        </div>
        
    """)))}/*59.7*/else/*59.12*/{_display_(Seq[Any](format.raw/*59.13*/("""
		
		Mostrando """),_display_(Seq[Any](/*61.14*/buscador/*61.22*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*61.54*/(""" resultado(s). 
		
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
			"""),_display_(Seq[Any](/*73.5*/for(periodo <- buscador.getList) yield /*73.37*/ {_display_(Seq[Any](format.raw/*73.39*/("""
				<tr>
					<td>
						<a href=""""),_display_(Seq[Any](/*76.17*/controllers/*76.28*/.contabilidad.routes.PeriodosController.editarPeriodo(periodo.id))),format.raw/*76.93*/("""">
							<i class="glyphicon glyphicon-edit"></i>
						</a>
					</td>
					<td>"""),_display_(Seq[Any](/*80.11*/(periodo.id))),format.raw/*80.23*/("""</td>
					<td>"""),_display_(Seq[Any](/*81.11*/(periodo.nombre))),format.raw/*81.27*/("""</td>
					<td>
						<a href=""""),_display_(Seq[Any](/*83.17*/controllers/*83.28*/.contabilidad.routes.PeriodosController.eliminarPeriodo(periodo.id))),format.raw/*83.95*/("""">
							<i class="glyphicon glyphicon-remove-circle"></i>
						</a>
					</td>
				</tr>
             """)))})),format.raw/*88.15*/("""
	        </tbody>
        </table>
		
		<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*93.8*/views/*93.13*/.html.helpers.paginador(buscador, controllers.contabilidad.routes.PeriodosController.indexPeriodo()))),format.raw/*93.113*/("""
		</div>
 	 """)))})),format.raw/*95.5*/("""
""")))})),format.raw/*96.2*/("""
		
		
	
	"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[Periodo],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[Periodo],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:38 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/periodos/indexPeriodo.scala.html
                    HASH: 7fbefcfb60b46887f0ed827e7ac8ca2626a16a59
                    MATRIX: 845->1|1022->95|1054->119|1128->76|1156->163|1193->166|1205->171|1266->224|1305->226|1498->383|1518->394|1594->448|2035->854|2143->940|2561->1322|2581->1333|2657->1387|2853->1547|2873->1558|2947->1610|3061->1689|3104->1723|3144->1725|3275->1839|3288->1844|3327->1845|3380->1862|3397->1870|3451->1902|3735->2151|3783->2183|3823->2185|3895->2221|3915->2232|4002->2297|4121->2380|4155->2392|4207->2408|4245->2424|4313->2456|4333->2467|4422->2534|4560->2640|4679->2724|4693->2729|4816->2829|4861->2843|4894->2845
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|41->13|41->13|41->13|56->28|56->28|69->41|69->41|69->41|77->49|77->49|77->49|81->53|81->53|81->53|87->59|87->59|87->59|89->61|89->61|89->61|101->73|101->73|101->73|104->76|104->76|104->76|108->80|108->80|109->81|109->81|111->83|111->83|111->83|116->88|121->93|121->93|121->93|123->95|124->96
                    -- GENERATED --
                */
            