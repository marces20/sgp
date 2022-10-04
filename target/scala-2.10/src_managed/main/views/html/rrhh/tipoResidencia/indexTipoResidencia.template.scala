
package views.html.rrhh.tipoResidencia

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
object indexTipoResidencia extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[TipoResidencia],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[TipoResidencia], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.84*/("""
"""),format.raw/*4.70*/(""" 

"""),_display_(Seq[Any](/*6.2*/views/*6.7*/.html.rrhh.mainRrhh("Lista Tipo Residencia")/*6.51*/ {_display_(Seq[Any](format.raw/*6.53*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Lista de Tipo Residencia</h1>
			</div>
			<div class="col-sm-2">
				<a href=""""),_display_(Seq[Any](/*14.15*/controllers/*14.26*/.rrhh.routes.TipoResidenciasController.crearTipoResidencia)),format.raw/*14.84*/(""""  class="form-control btn btn-default">
				<i class="glyphicon glyphicon-plus-sign"></i>
				Nueva Residencia
				</a>
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*22.3*/views/*22.8*/.html.tags.successError())),format.raw/*22.33*/("""
	
	<div id="actions">
		<div class="row">
			<form action="" method="GET">
				<div class="col-sm-3">
					<div class="form-group">
						<label for="nombre" class="control-label">Nombre
						"""),_display_(Seq[Any](/*30.8*/inputText(formBuscador("nombre"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*30.94*/("""
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
					<a href=""""),_display_(Seq[Any](/*43.16*/controllers/*43.27*/.rrhh.routes.TipoResidenciasController.indexTipoResidencia())),format.raw/*43.87*/(""""  class="form-control btn btn-default">Limpiar</a>
					</div>
				</div>
			</form>
		</div>
	</div>
	 
	"""),_display_(Seq[Any](/*50.3*/if(buscador.getTotalRowCount == 0)/*50.37*/ {_display_(Seq[Any](format.raw/*50.39*/("""
        
        <div class="well">
            <em>No se encuentran Residencia</em>
        </div>
        
    """)))}/*56.7*/else/*56.12*/{_display_(Seq[Any](format.raw/*56.13*/("""
		
		Mostrando """),_display_(Seq[Any](/*58.14*/buscador/*58.22*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*58.54*/(""" resultado(s). 
		
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th width="50">#</th>
					<th>Id</th>
					<th>Nombre</th>
					<th>Tipo</th>
					<th class="50">#</th>
				</tr>
			</thead>
			<tbody>
			"""),_display_(Seq[Any](/*71.5*/for(resi <- buscador.getList) yield /*71.34*/ {_display_(Seq[Any](format.raw/*71.36*/("""
				<tr data-estado="" 
				class="pointer" 
				data-href=""""),_display_(Seq[Any](/*74.17*/controllers/*74.28*/.rrhh.routes.TipoResidenciasController.ver(resi.id))),format.raw/*74.79*/("""&"""),_display_(Seq[Any](/*74.81*/UriTrack/*74.89*/.encode())),format.raw/*74.98*/(""""
				>
					<td>
						<a class="btn btn-default btn-xs notSeleccion" href=""""),_display_(Seq[Any](/*77.61*/controllers/*77.72*/.rrhh.routes.TipoResidenciasController.editarTipoResidencia(resi.id))),format.raw/*77.140*/("""">
							<i class="glyphicon glyphicon-edit"></i>
						</a>
					</td>
					<td>"""),_display_(Seq[Any](/*81.11*/(resi.id))),format.raw/*81.20*/("""</td>
					<td>"""),_display_(Seq[Any](/*82.11*/(resi.nombre))),format.raw/*82.24*/("""</td>
					<td>"""),_display_(Seq[Any](/*83.11*/(resi.tipo))),format.raw/*83.22*/("""</td>
					<td>
						<a class="btn btn-default btn-xs delete-confirm-link notSeleccion" href=""""),_display_(Seq[Any](/*85.81*/controllers/*85.92*/.rrhh.routes.TipoResidenciasController.eliminarTipoResidencia(resi.id))),format.raw/*85.162*/("""">
							<i class="glyphicon glyphicon-remove-circle"></i>
						</a>
					</td>
				</tr>
             """)))})),format.raw/*90.15*/("""
	        </tbody>
        </table>
		
		<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*95.8*/views/*95.13*/.html.helpers.paginador(buscador, controllers.rrhh.routes.TipoResidenciasController.indexTipoResidencia()))),format.raw/*95.119*/("""
		</div>
 	 """)))})),format.raw/*97.5*/("""
""")))})),format.raw/*98.2*/("""
		
		
	
	"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[TipoResidencia],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[TipoResidencia],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:29 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/tipoResidencia/indexTipoResidencia.scala.html
                    HASH: 535a73eb853ace218c764ad982fea9e10b7712bc
                    MATRIX: 857->1|1057->118|1089->142|1163->83|1191->186|1229->190|1241->195|1293->239|1332->241|1532->405|1552->416|1632->474|1819->626|1832->631|1879->656|2109->851|2217->937|2635->1319|2655->1330|2737->1390|2880->1498|2923->1532|2963->1534|3096->1650|3109->1655|3148->1656|3201->1673|3218->1681|3272->1713|3547->1953|3592->1982|3632->1984|3730->2046|3750->2057|3823->2108|3861->2110|3878->2118|3909->2127|4023->2205|4043->2216|4134->2284|4253->2367|4284->2376|4336->2392|4371->2405|4423->2421|4456->2432|4588->2528|4608->2539|4701->2609|4839->2715|4958->2799|4972->2804|5101->2910|5146->2924|5179->2926
                    LINES: 26->1|31->4|31->4|32->1|33->4|35->6|35->6|35->6|35->6|43->14|43->14|43->14|51->22|51->22|51->22|59->30|59->30|72->43|72->43|72->43|79->50|79->50|79->50|85->56|85->56|85->56|87->58|87->58|87->58|100->71|100->71|100->71|103->74|103->74|103->74|103->74|103->74|103->74|106->77|106->77|106->77|110->81|110->81|111->82|111->82|112->83|112->83|114->85|114->85|114->85|119->90|124->95|124->95|124->95|126->97|127->98
                    -- GENERATED --
                */
            