
package views.html.contabilidad.ejercicios

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
object indexEjercicio extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[Ejercicio],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[Ejercicio], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.79*/("""
"""),format.raw/*3.70*/(""" 
"""),_display_(Seq[Any](/*4.2*/views/*4.7*/.html.contabilidad.mainContabilidad("Lista Ejercicios")/*4.62*/ {_display_(Seq[Any](format.raw/*4.64*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Lista de Ejercicios</h1>
			</div>
			<div class="col-sm-2">
				<a href=""""),_display_(Seq[Any](/*12.15*/controllers/*12.26*/.contabilidad.routes.EjerciciosController.indexEjercicio())),format.raw/*12.84*/("""" class="btn btn-default">
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
						"""),_display_(Seq[Any](/*27.8*/inputText(formBuscador("nombre"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*27.94*/("""
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
					<a href=""""),_display_(Seq[Any](/*40.16*/controllers/*40.27*/.contabilidad.routes.EjerciciosController.indexEjercicio())),format.raw/*40.85*/(""""  class="form-control btn btn-default">Limpiar</a>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*48.14*/controllers/*48.25*/.contabilidad.routes.EjerciciosController.crearEjercicio)),format.raw/*48.81*/(""""  class="form-control btn btn-default">Nuevo Ejercicio</a>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*52.3*/if(buscador.getTotalRowCount == 0)/*52.37*/ {_display_(Seq[Any](format.raw/*52.39*/("""
        
        <div class="well">
            <em>No se encuentran Ejercicios</em>
        </div>
        
    """)))}/*58.7*/else/*58.12*/{_display_(Seq[Any](format.raw/*58.13*/("""
		
		Mostrando """),_display_(Seq[Any](/*60.14*/buscador/*60.22*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*60.54*/(""" resultado(s). 
		
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
			"""),_display_(Seq[Any](/*72.5*/for(ejercicio <- buscador.getList) yield /*72.39*/ {_display_(Seq[Any](format.raw/*72.41*/("""
				<tr>
					<td>
						<a href=""""),_display_(Seq[Any](/*75.17*/controllers/*75.28*/.contabilidad.routes.EjerciciosController.editarEjercicio(ejercicio.id))),format.raw/*75.99*/("""">
							<i class="glyphicon glyphicon-edit"></i>
						</a>
					</td>
					<td>"""),_display_(Seq[Any](/*79.11*/(ejercicio.id))),format.raw/*79.25*/("""</td>
					<td>"""),_display_(Seq[Any](/*80.11*/(ejercicio.nombre))),format.raw/*80.29*/("""</td>
					<td>
						<a href=""""),_display_(Seq[Any](/*82.17*/controllers/*82.28*/.contabilidad.routes.EjerciciosController.eliminarEjercicio(ejercicio.id))),format.raw/*82.101*/("""">
							<i class="glyphicon glyphicon-remove-circle"></i>
						</a>
					</td>
				</tr>
             """)))})),format.raw/*87.15*/("""
	        </tbody>
        </table>
		
		<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*92.8*/views/*92.13*/.html.helpers.paginador(buscador, controllers.contabilidad.routes.EjerciciosController.indexEjercicio()))),format.raw/*92.117*/("""
		</div>
 	 """)))})),format.raw/*94.5*/("""
""")))})),format.raw/*95.2*/("""
		
		
	
	"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[Ejercicio],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[Ejercicio],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:41 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/ejercicios/indexEjercicio.scala.html
                    HASH: b23a180539bba0934d463e0a8ae292ef2b6cd660
                    MATRIX: 851->1|1030->97|1062->121|1136->78|1164->165|1201->168|1213->173|1276->228|1315->230|1510->389|1530->400|1610->458|2051->864|2159->950|2577->1332|2597->1343|2677->1401|2873->1561|2893->1572|2971->1628|3087->1709|3130->1743|3170->1745|3303->1861|3316->1866|3355->1867|3408->1884|3425->1892|3479->1924|3763->2173|3813->2207|3853->2209|3925->2245|3945->2256|4038->2327|4157->2410|4193->2424|4245->2440|4285->2458|4353->2490|4373->2501|4469->2574|4607->2680|4726->2764|4740->2769|4867->2873|4912->2887|4945->2889
                    LINES: 26->1|29->3|29->3|30->1|31->3|32->4|32->4|32->4|32->4|40->12|40->12|40->12|55->27|55->27|68->40|68->40|68->40|76->48|76->48|76->48|80->52|80->52|80->52|86->58|86->58|86->58|88->60|88->60|88->60|100->72|100->72|100->72|103->75|103->75|103->75|107->79|107->79|108->80|108->80|110->82|110->82|110->82|115->87|120->92|120->92|120->92|122->94|123->95
                    -- GENERATED --
                */
            