
package views.html.contabilidad.bancos

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
object indexBanco extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[Banco],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[Banco], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.75*/("""
"""),format.raw/*3.70*/(""" 
"""),_display_(Seq[Any](/*4.2*/views/*4.7*/.html.contabilidad.mainContabilidad("Lista Bancos")/*4.58*/ {_display_(Seq[Any](format.raw/*4.60*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Lista de Bancos</h1>
			</div>
	
			<div class="col-sm-2">
				<a href=""""),_display_(Seq[Any](/*13.15*/controllers/*13.26*/.contabilidad.routes.BancosController.indexBanco())),format.raw/*13.76*/("""" class="btn btn-default">
					<i class="glyphicon glyphicon-list"></i>
				</a>
				<a href="#" class="btn btn-default">
					<i class="glyphicon glyphicon-align-justify"></i>
				</a>
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*23.3*/views/*23.8*/.html.tags.successError())),format.raw/*23.33*/("""
	
	<div id="actions">
		<div class="row">
			<form action="" method="GET">
				<div class="col-sm-3">
					<div class="form-group">
						<label for="nombre" class="control-label">Nombre
						"""),_display_(Seq[Any](/*31.8*/inputText(formBuscador("nombre"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*31.94*/("""
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
					<a href=""""),_display_(Seq[Any](/*44.16*/controllers/*44.27*/.contabilidad.routes.BancosController.indexBanco())),format.raw/*44.77*/(""""  class="form-control btn btn-default">Limpiar</a>
					</div>
				</div>
			</form>
		</div>
	</div>
	
	<div class="row">
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*53.14*/controllers/*53.25*/.contabilidad.routes.BancosController.crearBanco)),format.raw/*53.73*/(""""  class="form-control btn btn-default">Nuevo Banco</a>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*57.3*/if(buscador.getTotalRowCount == 0)/*57.37*/ {_display_(Seq[Any](format.raw/*57.39*/("""
        
        <div class="well">
            <em>No se encuentran Bancos</em>
        </div>
        
    """)))}/*63.7*/else/*63.12*/{_display_(Seq[Any](format.raw/*63.13*/("""
    
    	Mostrando """),_display_(Seq[Any](/*65.17*/buscador/*65.25*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*65.57*/(""" resultado(s). 
		
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th width="50">#</th>
					<th width="100">Código</th>
					<th width="300">Nombre</th>
					<th width="300">CUIT</th>
					<th class="50">#</th>
				</tr>
			</thead>
			<tbody>
			"""),_display_(Seq[Any](/*78.5*/for(banco <- buscador.getList) yield /*78.35*/ {_display_(Seq[Any](format.raw/*78.37*/("""
				<tr>
					<td>
						<a href=""""),_display_(Seq[Any](/*81.17*/controllers/*81.28*/.contabilidad.routes.BancosController.editarBanco(banco.id))),format.raw/*81.87*/("""">
							<i class="glyphicon glyphicon-edit"></i>
						</a>
					</td>
					<td>"""),_display_(Seq[Any](/*85.11*/(banco.id))),format.raw/*85.21*/("""</td>
					<td>"""),_display_(Seq[Any](/*86.11*/(banco.nombre))),format.raw/*86.25*/("""</td>
					<td>"""),_display_(Seq[Any](/*87.11*/(banco.cuit))),format.raw/*87.23*/("""</td>
					<td>
						<a href=""""),_display_(Seq[Any](/*89.17*/controllers/*89.28*/.contabilidad.routes.BancosController.eliminarBanco(banco.id))),format.raw/*89.89*/("""">
							<i class="glyphicon glyphicon-remove-circle"></i>
						</a>
					</td>
				</tr>
             """)))})),format.raw/*94.15*/("""
	        </tbody>
        </table>
        
        <div class="pagination pull-right">
		    """),_display_(Seq[Any](/*99.8*/views/*99.13*/.html.helpers.paginador(buscador, controllers.contabilidad.routes.BancosController.indexBanco()))),format.raw/*99.109*/("""
		</div>
 	 """)))})),format.raw/*101.5*/("""
""")))})))}
    }
    
    def render(buscador:utils.pagination.Pagination[Banco],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[Banco],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/bancos/indexBanco.scala.html
                    HASH: f1c389d9a8d829f5991d00a35f0d4f0457410ad1
                    MATRIX: 839->1|1014->93|1046->117|1120->74|1148->161|1185->164|1197->169|1256->220|1295->222|1488->379|1508->390|1580->440|1833->658|1846->663|1893->688|2123->883|2231->969|2649->1351|2669->1362|2741->1412|2939->1574|2959->1585|3029->1633|3141->1710|3184->1744|3224->1746|3353->1858|3366->1863|3405->1864|3463->1886|3480->1894|3534->1926|3849->2206|3895->2236|3935->2238|4007->2274|4027->2285|4108->2344|4227->2427|4259->2437|4311->2453|4347->2467|4399->2483|4433->2495|4501->2527|4521->2538|4604->2599|4742->2705|4873->2801|4887->2806|5006->2902|5052->2916
                    LINES: 26->1|29->3|29->3|30->1|31->3|32->4|32->4|32->4|32->4|41->13|41->13|41->13|51->23|51->23|51->23|59->31|59->31|72->44|72->44|72->44|81->53|81->53|81->53|85->57|85->57|85->57|91->63|91->63|91->63|93->65|93->65|93->65|106->78|106->78|106->78|109->81|109->81|109->81|113->85|113->85|114->86|114->86|115->87|115->87|117->89|117->89|117->89|122->94|127->99|127->99|127->99|129->101
                    -- GENERATED --
                */
            