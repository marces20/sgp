
package views.html.haberes.liquidacionConceptos

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
object indexLiquidacionConcepto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[models.haberes.LiquidacionConcepto],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[models.haberes.LiquidacionConcepto], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

implicit def /*6.2*/implicitFieldConstructor/*6.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.104*/("""
"""),format.raw/*5.1*/("""
"""),format.raw/*6.70*/(""" 
"""),_display_(Seq[Any](/*7.2*/views/*7.7*/.html.haberes.mainHaberes("Lista Conceptos")/*7.51*/ {_display_(Seq[Any](format.raw/*7.53*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Lista de Conceptos</h1>
			</div>
	
			<div class="col-sm-5">
				<div class="pull-right btn-header">
					<a href=""""),_display_(Seq[Any](/*17.16*/controllers/*17.27*/.haberes.routes.LiquidacionConceptosController.crear())),format.raw/*17.81*/("""?"""),_display_(Seq[Any](/*17.83*/UriTrack/*17.91*/.encode())),format.raw/*17.100*/(""""  class="form-control btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo Concepto</a>
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
						"""),_display_(Seq[Any](/*31.8*/inputText(formBuscador("denominacion"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*31.100*/("""
						</label>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="nombre" class="control-label">Codigo
						"""),_display_(Seq[Any](/*38.8*/inputText(formBuscador("codigo"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*38.94*/("""
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
					<a href=""""),_display_(Seq[Any](/*51.16*/controllers/*51.27*/.haberes.routes.LiquidacionConceptosController.index())),format.raw/*51.81*/(""""  class="form-control btn btn-default">Limpiar</a>
					</div>
				</div>
			</div>
		</form>
	</div>
	
	"""),_display_(Seq[Any](/*58.3*/if(buscador.getTotalRowCount == 0)/*58.37*/ {_display_(Seq[Any](format.raw/*58.39*/("""
        
        <div class="well">
            <em>No se encuentran Conceptos</em>
        </div>
        
    """)))}/*64.7*/else/*64.12*/{_display_(Seq[Any](format.raw/*64.13*/("""
    
    	Mostrando """),_display_(Seq[Any](/*66.17*/buscador/*66.25*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*66.57*/(""" resultado(s). 
		
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th width="30">
						<input type="checkbox" name="checkAll" id="checkAll"/>
					</th>
					<th width="30">#</th>
					<th>Código</th>
					<th>Nombre</th>
					<th>Tipo</th>
					<th>Clasificacion</th>
					<th width="30">#</th>
				</tr>
			</thead>
			<tbody>
			"""),_display_(Seq[Any](/*83.5*/for(lc <- buscador.getList) yield /*83.32*/ {_display_(Seq[Any](format.raw/*83.34*/("""
				<tr class="pointer" data-href=""""),_display_(Seq[Any](/*84.37*/controllers/*84.48*/.haberes.routes.LiquidacionConceptosController.ver(lc.id))),format.raw/*84.105*/("""&"""),_display_(Seq[Any](/*84.107*/UriTrack/*84.115*/.encode())),format.raw/*84.124*/("""">
					<td><input type="checkbox" name="check_listado[]" value=""""),_display_(Seq[Any](/*85.64*/lc/*85.66*/.id)),format.raw/*85.69*/("""" class="notSeleccion" id="check-"""),_display_(Seq[Any](/*85.103*/lc/*85.105*/.id)),format.raw/*85.108*/(""""/></td>
					<td>
						<a class="btn btn-default btn-xs notSeleccion" href=""""),_display_(Seq[Any](/*87.61*/controllers/*87.72*/.haberes.routes.LiquidacionConceptosController.editar(lc.id))),format.raw/*87.132*/("""&"""),_display_(Seq[Any](/*87.134*/UriTrack/*87.142*/.encode())),format.raw/*87.151*/("""">
							<i class="glyphicon glyphicon-edit"></i>
						</a>
					</td>
					<td>"""),_display_(Seq[Any](/*91.11*/(lc.codigo))),format.raw/*91.22*/("""</td>
					<td>"""),_display_(Seq[Any](/*92.11*/(lc.denominacion))),format.raw/*92.28*/("""</td>
					<td>"""),_display_(Seq[Any](/*93.11*/(lc.liquidacionConceptoTipo.nombre))),format.raw/*93.46*/("""</td>
					<td>"""),_display_(Seq[Any](/*94.11*/if(lc.liquidacionConceptoClasificacion != null)/*94.58*/{_display_(Seq[Any](_display_(Seq[Any](/*94.60*/(lc.liquidacionConceptoClasificacion.nombre)))))})),format.raw/*94.105*/("""</td>
					<td>
						<a class="btn btn-default btn-xs delete-confirm-link notSeleccion"  href=""""),_display_(Seq[Any](/*96.82*/controllers/*96.93*/.haberes.routes.LiquidacionConceptosController.eliminar(lc.id))),format.raw/*96.155*/("""&"""),_display_(Seq[Any](/*96.157*/UriTrack/*96.165*/.encode())),format.raw/*96.174*/("""">
							<i class="glyphicon glyphicon-trash icono-eliminar"></i>
						</a>
					</td>
				</tr>
             """)))})),format.raw/*101.15*/("""
	        </tbody>
        </table>
        
        <div class="pagination pull-right">
		    """),_display_(Seq[Any](/*106.8*/views/*106.13*/.html.helpers.paginador(buscador, controllers.haberes.routes.LiquidacionConceptosController.index()))),format.raw/*106.113*/("""
		</div>
 	 """)))})),format.raw/*108.5*/("""
""")))})))}
    }
    
    def render(buscador:utils.pagination.Pagination[models.haberes.LiquidacionConcepto],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[models.haberes.LiquidacionConcepto],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/liquidacionConceptos/indexLiquidacionConcepto.scala.html
                    HASH: b8838068c55bcb75883dc8a1503de0ffc6e1db97
                    MATRIX: 891->1|1133->161|1165->185|1240->103|1267->159|1295->229|1332->232|1344->237|1396->281|1435->283|1671->483|1691->494|1767->548|1805->550|1822->558|1854->567|2036->714|2049->719|2096->744|2332->945|2447->1037|2640->1195|2748->1281|3167->1664|3187->1675|3263->1729|3405->1836|3448->1870|3488->1872|3620->1987|3633->1992|3672->1993|3730->2015|3747->2023|3801->2055|4201->2420|4244->2447|4284->2449|4357->2486|4377->2497|4457->2554|4496->2556|4514->2564|4546->2573|4648->2639|4659->2641|4684->2644|4755->2678|4767->2680|4793->2683|4908->2762|4928->2773|5011->2833|5050->2835|5068->2843|5100->2852|5219->2935|5252->2946|5304->2962|5343->2979|5395->2995|5452->3030|5504->3046|5560->3093|5608->3095|5680->3140|5813->3237|5833->3248|5918->3310|5957->3312|5975->3320|6007->3329|6153->3442|6285->3538|6300->3543|6424->3643|6470->3657
                    LINES: 26->1|33->6|33->6|34->1|35->5|36->6|37->7|37->7|37->7|37->7|47->17|47->17|47->17|47->17|47->17|47->17|53->23|53->23|53->23|61->31|61->31|68->38|68->38|81->51|81->51|81->51|88->58|88->58|88->58|94->64|94->64|94->64|96->66|96->66|96->66|113->83|113->83|113->83|114->84|114->84|114->84|114->84|114->84|114->84|115->85|115->85|115->85|115->85|115->85|115->85|117->87|117->87|117->87|117->87|117->87|117->87|121->91|121->91|122->92|122->92|123->93|123->93|124->94|124->94|124->94|124->94|126->96|126->96|126->96|126->96|126->96|126->96|131->101|136->106|136->106|136->106|138->108
                    -- GENERATED --
                */
            