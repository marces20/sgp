
package views.html.rrhh.puesto

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
object indexPuesto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[Puesto],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[Puesto], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.76*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.rrhh.mainRrhh("Lista Puestos")/*5.43*/ {_display_(Seq[Any](format.raw/*5.45*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Lista de Puestos</h1>
			</div>
			<div class="col-sm-2">
				<a href=""""),_display_(Seq[Any](/*13.15*/controllers/*13.26*/.rrhh.routes.PuestosController.indexPuesto())),format.raw/*13.70*/("""" class="btn btn-default">
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
					<a href=""""),_display_(Seq[Any](/*41.16*/controllers/*41.27*/.rrhh.routes.PuestosController.indexPuesto())),format.raw/*41.71*/(""""  class="form-control btn btn-default">Limpiar</a>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*49.14*/controllers/*49.25*/.rrhh.routes.PuestosController.crearPuesto)),format.raw/*49.67*/(""""  class="form-control btn btn-default">Nuevo Puesto</a>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*53.3*/if(buscador.getTotalRowCount == 0)/*53.37*/ {_display_(Seq[Any](format.raw/*53.39*/("""
        
        <div class="well">
            <em>No se encuentran Puestos</em>
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
			"""),_display_(Seq[Any](/*73.5*/for(puesto <- buscador.getList) yield /*73.36*/ {_display_(Seq[Any](format.raw/*73.38*/("""
				<tr>
					<td>
						<a href=""""),_display_(Seq[Any](/*76.17*/controllers/*76.28*/.rrhh.routes.PuestosController.editarPuesto(puesto.id))),format.raw/*76.82*/("""">
							<i class="glyphicon glyphicon-edit"></i>
						</a>
					</td>
					<td>"""),_display_(Seq[Any](/*80.11*/(puesto.id))),format.raw/*80.22*/("""</td>
					<td>"""),_display_(Seq[Any](/*81.11*/(puesto.nombre))),format.raw/*81.26*/("""</td>
					<td>
						<a href=""""),_display_(Seq[Any](/*83.17*/controllers/*83.28*/.rrhh.routes.PuestosController.eliminarPuesto(puesto.id))),format.raw/*83.84*/("""">
							<i class="glyphicon glyphicon-remove-circle"></i>
						</a>
					</td>
				</tr>
             """)))})),format.raw/*88.15*/("""
	        </tbody>
        </table>
		
		<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*93.8*/views/*93.13*/.html.helpers.paginador(buscador, controllers.rrhh.routes.PuestosController.indexPuesto()))),format.raw/*93.103*/("""
		</div>
 	 """)))})),format.raw/*95.5*/("""
""")))})),format.raw/*96.2*/("""
		
		
	
	"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[Puesto],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[Puesto],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:29 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/puesto/indexPuesto.scala.html
                    HASH: da70e4a958e380b33a34d204382928ea5a80e4d9
                    MATRIX: 833->1|1009->94|1041->118|1115->75|1143->162|1181->166|1193->171|1237->207|1276->209|1468->365|1488->376|1554->420|1995->826|2103->912|2521->1294|2541->1305|2607->1349|2803->1509|2823->1520|2887->1562|3000->1640|3043->1674|3083->1676|3213->1789|3226->1794|3265->1795|3318->1812|3335->1820|3389->1852|3673->2101|3720->2132|3760->2134|3832->2170|3852->2181|3928->2235|4047->2318|4080->2329|4132->2345|4169->2360|4237->2392|4257->2403|4335->2459|4473->2565|4592->2649|4606->2654|4719->2744|4764->2758|4797->2760
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|41->13|41->13|41->13|56->28|56->28|69->41|69->41|69->41|77->49|77->49|77->49|81->53|81->53|81->53|87->59|87->59|87->59|89->61|89->61|89->61|101->73|101->73|101->73|104->76|104->76|104->76|108->80|108->80|109->81|109->81|111->83|111->83|111->83|116->88|121->93|121->93|121->93|123->95|124->96
                    -- GENERATED --
                */
            