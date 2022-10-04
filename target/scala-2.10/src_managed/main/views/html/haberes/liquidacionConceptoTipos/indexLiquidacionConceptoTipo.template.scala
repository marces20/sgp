
package views.html.haberes.liquidacionConceptoTipos

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
object indexLiquidacionConceptoTipo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[models.haberes.LiquidacionConceptoTipo],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[models.haberes.LiquidacionConceptoTipo], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

implicit def /*6.2*/implicitFieldConstructor/*6.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.108*/("""
"""),format.raw/*5.1*/("""
"""),format.raw/*6.70*/(""" 
"""),_display_(Seq[Any](/*7.2*/views/*7.7*/.html.haberes.mainHaberes("Lista de Tipo de Conceptos")/*7.62*/ {_display_(Seq[Any](format.raw/*7.64*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Lista de Tipo de Conceptos</h1>
			</div>
	
			<div class="col-sm-5">
				<div class="pull-right btn-header">
					<a href=""""),_display_(Seq[Any](/*17.16*/controllers/*17.27*/.haberes.routes.LiquidacionConceptoTiposController.crear())),format.raw/*17.85*/("""?"""),_display_(Seq[Any](/*17.87*/UriTrack/*17.95*/.encode())),format.raw/*17.104*/(""""  class="form-control btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo Tipo Concepto</a>
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
					<a href=""""),_display_(Seq[Any](/*44.16*/controllers/*44.27*/.haberes.routes.LiquidacionConceptoTiposController.index())),format.raw/*44.85*/(""""  class="form-control btn btn-default">Limpiar</a>
					</div>
				</div>
			</div>
		</form>
	</div>
	
	"""),_display_(Seq[Any](/*51.3*/if(buscador.getTotalRowCount == 0)/*51.37*/ {_display_(Seq[Any](format.raw/*51.39*/("""
        
        <div class="well">
            <em>No se encuentran Tipos de Conceptos</em>
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
				<tr class="pointer" data-href=""""),_display_(Seq[Any](/*74.37*/controllers/*74.48*/.haberes.routes.LiquidacionConceptoTiposController.ver(lc.id))),format.raw/*74.109*/("""&"""),_display_(Seq[Any](/*74.111*/UriTrack/*74.119*/.encode())),format.raw/*74.128*/("""">
					<td><input type="checkbox" name="check_listado[]" value=""""),_display_(Seq[Any](/*75.64*/lc/*75.66*/.id)),format.raw/*75.69*/("""" class="notSeleccion" id="check-"""),_display_(Seq[Any](/*75.103*/lc/*75.105*/.id)),format.raw/*75.108*/(""""/></td>
					<td>
						"""),_display_(Seq[Any](/*77.8*/if(Permiso.check("liquidacionConceptoTipoEditar"))/*77.58*/ {_display_(Seq[Any](format.raw/*77.60*/("""
						<a class="btn btn-default btn-xs notSeleccion" href=""""),_display_(Seq[Any](/*78.61*/controllers/*78.72*/.haberes.routes.LiquidacionConceptoTiposController.editar(lc.id))),format.raw/*78.136*/("""&"""),_display_(Seq[Any](/*78.138*/UriTrack/*78.146*/.encode())),format.raw/*78.155*/("""">
							<i class="glyphicon glyphicon-edit"></i>
						</a>
						""")))})),format.raw/*81.8*/("""
					</td>
					<td>"""),_display_(Seq[Any](/*83.11*/(lc.nombre))),format.raw/*83.22*/("""</td>
					<td>
						"""),_display_(Seq[Any](/*85.8*/if(Permiso.check("liquidacionConceptoTipoEliminar"))/*85.60*/ {_display_(Seq[Any](format.raw/*85.62*/("""
						<a class="btn btn-default btn-xs delete-confirm-link notSeleccion" href=""""),_display_(Seq[Any](/*86.81*/controllers/*86.92*/.haberes.routes.LiquidacionConceptoTiposController.eliminar(lc.id))),format.raw/*86.158*/("""&"""),_display_(Seq[Any](/*86.160*/UriTrack/*86.168*/.encode())),format.raw/*86.177*/("""">
							<i class="glyphicon glyphicon-trash icono-eliminar"></i>
						</a>
						""")))})),format.raw/*89.8*/("""
					</td>
				</tr>
             """)))})),format.raw/*92.15*/("""
	        </tbody>
        </table>
        
        <div class="pagination pull-right">
		    """),_display_(Seq[Any](/*97.8*/views/*97.13*/.html.helpers.paginador(buscador, controllers.haberes.routes.LiquidacionConceptoTiposController.index()))),format.raw/*97.117*/("""
		</div>
 	 """)))})),format.raw/*99.5*/("""
""")))})))}
    }
    
    def render(buscador:utils.pagination.Pagination[models.haberes.LiquidacionConceptoTipo],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[models.haberes.LiquidacionConceptoTipo],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/liquidacionConceptoTipos/indexLiquidacionConceptoTipo.scala.html
                    HASH: f6bd9ee56c8bbd6ab78a68c62b363eb3e3954e4e
                    MATRIX: 903->1|1149->165|1181->189|1256->107|1283->163|1311->233|1348->236|1360->241|1423->296|1462->298|1706->506|1726->517|1806->575|1844->577|1861->585|1893->594|2080->746|2093->751|2140->776|2376->977|2484->1063|2903->1446|2923->1457|3003->1515|3145->1622|3188->1656|3228->1658|3369->1782|3382->1787|3421->1788|3479->1810|3496->1818|3550->1850|3888->2153|3931->2180|3971->2182|4044->2219|4064->2230|4148->2291|4187->2293|4205->2301|4237->2310|4339->2376|4350->2378|4375->2381|4446->2415|4458->2417|4484->2420|4545->2446|4604->2496|4644->2498|4741->2559|4761->2570|4848->2634|4887->2636|4905->2644|4937->2653|5037->2722|5095->2744|5128->2755|5186->2778|5247->2830|5287->2832|5404->2913|5424->2924|5513->2990|5552->2992|5570->3000|5602->3009|5718->3094|5786->3130|5917->3226|5931->3231|6058->3335|6103->3349
                    LINES: 26->1|33->6|33->6|34->1|35->5|36->6|37->7|37->7|37->7|37->7|47->17|47->17|47->17|47->17|47->17|47->17|53->23|53->23|53->23|61->31|61->31|74->44|74->44|74->44|81->51|81->51|81->51|87->57|87->57|87->57|89->59|89->59|89->59|103->73|103->73|103->73|104->74|104->74|104->74|104->74|104->74|104->74|105->75|105->75|105->75|105->75|105->75|105->75|107->77|107->77|107->77|108->78|108->78|108->78|108->78|108->78|108->78|111->81|113->83|113->83|115->85|115->85|115->85|116->86|116->86|116->86|116->86|116->86|116->86|119->89|122->92|127->97|127->97|127->97|129->99
                    -- GENERATED --
                */
            