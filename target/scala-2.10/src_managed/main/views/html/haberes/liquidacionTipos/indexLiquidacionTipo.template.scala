
package views.html.haberes.liquidacionTipos

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
object indexLiquidacionTipo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[models.haberes.LiquidacionTipo],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[models.haberes.LiquidacionTipo], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

implicit def /*6.2*/implicitFieldConstructor/*6.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.100*/("""
"""),format.raw/*5.1*/("""
"""),format.raw/*6.70*/(""" 
"""),_display_(Seq[Any](/*7.2*/views/*7.7*/.html.haberes.mainHaberes("Lista Tipos de Liquidación")/*7.62*/ {_display_(Seq[Any](format.raw/*7.64*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Lista de Tipo de Liquidación</h1>
			</div>
	
			<div class="col-sm-5">
				<div class="pull-right btn-header">
					<a href=""""),_display_(Seq[Any](/*17.16*/controllers/*17.27*/.haberes.routes.LiquidacionTiposController.crear())),format.raw/*17.77*/("""?"""),_display_(Seq[Any](/*17.79*/UriTrack/*17.87*/.encode())),format.raw/*17.96*/(""""  class="form-control btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo Tipo Liquidacion</a>
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
					<a href=""""),_display_(Seq[Any](/*44.16*/controllers/*44.27*/.haberes.routes.LiquidacionTiposController.index())),format.raw/*44.77*/(""""  class="form-control btn btn-default">Limpiar</a>
					</div>
				</div>
			</div>
		</form>
	</div>
	
	"""),_display_(Seq[Any](/*51.3*/if(buscador.getTotalRowCount == 0)/*51.37*/ {_display_(Seq[Any](format.raw/*51.39*/("""
        
        <div class="well">
            <em>No se encuentran Tipos de Liquidacion</em>
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
					<th class="30">#</th>
				</tr>
			</thead>
			<tbody>
			"""),_display_(Seq[Any](/*73.5*/for(lc <- buscador.getList) yield /*73.32*/ {_display_(Seq[Any](format.raw/*73.34*/("""
				<tr class="pointer" data-href=""""),_display_(Seq[Any](/*74.37*/controllers/*74.48*/.haberes.routes.LiquidacionTiposController.ver(lc.id))),format.raw/*74.101*/("""&"""),_display_(Seq[Any](/*74.103*/UriTrack/*74.111*/.encode())),format.raw/*74.120*/("""">
					<td>
						"""),_display_(Seq[Any](/*76.8*/if(Permiso.check("liquidacionTipoEditar"))/*76.50*/ {_display_(Seq[Any](format.raw/*76.52*/("""
						<input type="checkbox" name="check_listado[]" value=""""),_display_(Seq[Any](/*77.61*/lc/*77.63*/.id)),format.raw/*77.66*/("""" class="notSeleccion" id="check-"""),_display_(Seq[Any](/*77.100*/lc/*77.102*/.id)),format.raw/*77.105*/(""""/>
						""")))})),format.raw/*78.8*/("""
					</td>
					<td>
						<a class="btn btn-default btn-xs notSeleccion" href=""""),_display_(Seq[Any](/*81.61*/controllers/*81.72*/.haberes.routes.LiquidacionTiposController.editar(lc.id))),format.raw/*81.128*/("""&"""),_display_(Seq[Any](/*81.130*/UriTrack/*81.138*/.encode())),format.raw/*81.147*/("""">
							<i class="glyphicon glyphicon-edit"></i>
						</a>
					</td>
					<td>"""),_display_(Seq[Any](/*85.11*/(lc.nombre))),format.raw/*85.22*/("""</td>
					<td>
						"""),_display_(Seq[Any](/*87.8*/if(Permiso.check("liquidacionTipoEliminar"))/*87.52*/ {_display_(Seq[Any](format.raw/*87.54*/("""
						<a class="btn btn-default btn-xs delete-confirm-link notSeleccion" href=""""),_display_(Seq[Any](/*88.81*/controllers/*88.92*/.haberes.routes.LiquidacionTiposController.eliminar(lc.id))),format.raw/*88.150*/("""&"""),_display_(Seq[Any](/*88.152*/UriTrack/*88.160*/.encode())),format.raw/*88.169*/("""">
							<i class="glyphicon glyphicon-trash icono-eliminar"></i>
						</a>
						""")))})),format.raw/*91.8*/("""
					</td>
				</tr>
             """)))})),format.raw/*94.15*/("""
	        </tbody>
        </table>
        
        <div class="pagination pull-right">
		    """),_display_(Seq[Any](/*99.8*/views/*99.13*/.html.helpers.paginador(buscador, controllers.haberes.routes.LiquidacionTiposController.index()))),format.raw/*99.109*/("""
		</div>
 	 """)))})),format.raw/*101.5*/("""
""")))})))}
    }
    
    def render(buscador:utils.pagination.Pagination[models.haberes.LiquidacionTipo],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[models.haberes.LiquidacionTipo],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/liquidacionTipos/indexLiquidacionTipo.scala.html
                    HASH: 6cafe0c40c1cd170f782887ef2be0b185d62fd55
                    MATRIX: 879->1|1117->157|1149->181|1224->99|1251->155|1279->225|1316->228|1328->233|1391->288|1430->290|1676->500|1696->511|1768->561|1806->563|1823->571|1854->580|2044->735|2057->740|2104->765|2340->966|2448->1052|2867->1435|2887->1446|2959->1496|3101->1603|3144->1637|3184->1639|3327->1765|3340->1770|3379->1771|3437->1793|3454->1801|3508->1833|3846->2136|3889->2163|3929->2165|4002->2202|4022->2213|4098->2266|4137->2268|4155->2276|4187->2285|4242->2305|4293->2347|4333->2349|4430->2410|4441->2412|4466->2415|4537->2449|4549->2451|4575->2454|4617->2465|4735->2547|4755->2558|4834->2614|4873->2616|4891->2624|4923->2633|5042->2716|5075->2727|5133->2750|5186->2794|5226->2796|5343->2877|5363->2888|5444->2946|5483->2948|5501->2956|5533->2965|5649->3050|5717->3086|5848->3182|5862->3187|5981->3283|6027->3297
                    LINES: 26->1|33->6|33->6|34->1|35->5|36->6|37->7|37->7|37->7|37->7|47->17|47->17|47->17|47->17|47->17|47->17|53->23|53->23|53->23|61->31|61->31|74->44|74->44|74->44|81->51|81->51|81->51|87->57|87->57|87->57|89->59|89->59|89->59|103->73|103->73|103->73|104->74|104->74|104->74|104->74|104->74|104->74|106->76|106->76|106->76|107->77|107->77|107->77|107->77|107->77|107->77|108->78|111->81|111->81|111->81|111->81|111->81|111->81|115->85|115->85|117->87|117->87|117->87|118->88|118->88|118->88|118->88|118->88|118->88|121->91|124->94|129->99|129->99|129->99|131->101
                    -- GENERATED --
                */
            