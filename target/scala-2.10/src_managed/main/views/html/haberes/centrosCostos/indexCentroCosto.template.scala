
package views.html.haberes.centrosCostos

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
object indexCentroCosto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[models.haberes.CentroCosto],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[models.haberes.CentroCosto], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

implicit def /*6.2*/implicitFieldConstructor/*6.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.96*/("""
"""),format.raw/*5.1*/("""
"""),format.raw/*6.70*/(""" 
"""),_display_(Seq[Any](/*7.2*/views/*7.7*/.html.haberes.mainHaberes("Lista Centros Costos ")/*7.57*/ {_display_(Seq[Any](format.raw/*7.59*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Lista Centros Costos</h1>
			</div>
	
			<div class="col-sm-5">
				<div class="pull-right btn-header">
					<a href=""""),_display_(Seq[Any](/*17.16*/controllers/*17.27*/.haberes.routes.CentrosCostosController.crear())),format.raw/*17.74*/("""?"""),_display_(Seq[Any](/*17.76*/UriTrack/*17.84*/.encode())),format.raw/*17.93*/(""""  class="form-control btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nueva Centro</a>
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
					<a href=""""),_display_(Seq[Any](/*44.16*/controllers/*44.27*/.haberes.routes.CentrosCostosController.index())),format.raw/*44.74*/(""""  class="form-control btn btn-default">Limpiar</a>
					</div>
				</div>
			</div>
		</form>
	</div>
	
	"""),_display_(Seq[Any](/*51.3*/if(buscador.getTotalRowCount == 0)/*51.37*/ {_display_(Seq[Any](format.raw/*51.39*/("""
        
        <div class="well">
            <em>No se encuentran Centros Costos</em>
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
				<tr class="pointer" data-href=""""),_display_(Seq[Any](/*74.37*/controllers/*74.48*/.haberes.routes.CentrosCostosController.ver(lc.id))),format.raw/*74.98*/("""&"""),_display_(Seq[Any](/*74.100*/UriTrack/*74.108*/.encode())),format.raw/*74.117*/("""">
					<td><input type="checkbox" name="check_listado[]" value=""""),_display_(Seq[Any](/*75.64*/lc/*75.66*/.id)),format.raw/*75.69*/("""" class="notSeleccion" id="check-"""),_display_(Seq[Any](/*75.103*/lc/*75.105*/.id)),format.raw/*75.108*/(""""/></td>
					<td>
						"""),_display_(Seq[Any](/*77.8*/if(Permiso.check("centroCostoEditar"))/*77.46*/ {_display_(Seq[Any](format.raw/*77.48*/("""
						<a class="btn btn-default btn-xs notSeleccion" href=""""),_display_(Seq[Any](/*78.61*/controllers/*78.72*/.haberes.routes.CentrosCostosController.editar(lc.id))),format.raw/*78.125*/("""&"""),_display_(Seq[Any](/*78.127*/UriTrack/*78.135*/.encode())),format.raw/*78.144*/("""">
							<i class="glyphicon glyphicon-edit"></i>
						</a>
						""")))})),format.raw/*81.8*/("""
					</td>
					<td>"""),_display_(Seq[Any](/*83.11*/(lc.nombre))),format.raw/*83.22*/("""</td>
					<td>
						"""),_display_(Seq[Any](/*85.8*/if(Permiso.check("centroCostoEliminar"))/*85.48*/ {_display_(Seq[Any](format.raw/*85.50*/("""
						<a class="btn btn-default btn-xs delete-confirm-link notSeleccion" href=""""),_display_(Seq[Any](/*86.81*/controllers/*86.92*/.haberes.routes.CentrosCostosController.eliminar(lc.id))),format.raw/*86.147*/("""&"""),_display_(Seq[Any](/*86.149*/UriTrack/*86.157*/.encode())),format.raw/*86.166*/("""">
							<i class="glyphicon glyphicon-trash icono-eliminar"></i>
						</a>
						""")))})),format.raw/*89.8*/("""
					</td>
				</tr>
             """)))})),format.raw/*92.15*/("""
	        </tbody>
        </table>
        
        <div class="pagination pull-right">
		    """),_display_(Seq[Any](/*97.8*/views/*97.13*/.html.helpers.paginador(buscador, controllers.haberes.routes.CentrosCostosController.index()))),format.raw/*97.106*/("""
		</div>
 	 """)))})),format.raw/*99.5*/("""
""")))})))}
    }
    
    def render(buscador:utils.pagination.Pagination[models.haberes.CentroCosto],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[models.haberes.CentroCosto],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/centrosCostos/indexCentroCosto.scala.html
                    HASH: 94f8dfa15960c92221e241b4901bd9bcc3d9a07e
                    MATRIX: 868->1|1102->153|1134->177|1208->95|1235->151|1263->221|1300->224|1312->229|1370->279|1409->281|1647->483|1667->494|1736->541|1774->543|1791->551|1822->560|2002->705|2015->710|2062->735|2298->936|2406->1022|2825->1405|2845->1416|2914->1463|3056->1570|3099->1604|3139->1606|3276->1726|3289->1731|3328->1732|3386->1754|3403->1762|3457->1794|3795->2097|3838->2124|3878->2126|3951->2163|3971->2174|4043->2224|4082->2226|4100->2234|4132->2243|4234->2309|4245->2311|4270->2314|4341->2348|4353->2350|4379->2353|4440->2379|4487->2417|4527->2419|4624->2480|4644->2491|4720->2544|4759->2546|4777->2554|4809->2563|4909->2632|4967->2654|5000->2665|5058->2688|5107->2728|5147->2730|5264->2811|5284->2822|5362->2877|5401->2879|5419->2887|5451->2896|5567->2981|5635->3017|5766->3113|5780->3118|5896->3211|5941->3225
                    LINES: 26->1|33->6|33->6|34->1|35->5|36->6|37->7|37->7|37->7|37->7|47->17|47->17|47->17|47->17|47->17|47->17|53->23|53->23|53->23|61->31|61->31|74->44|74->44|74->44|81->51|81->51|81->51|87->57|87->57|87->57|89->59|89->59|89->59|103->73|103->73|103->73|104->74|104->74|104->74|104->74|104->74|104->74|105->75|105->75|105->75|105->75|105->75|105->75|107->77|107->77|107->77|108->78|108->78|108->78|108->78|108->78|108->78|111->81|113->83|113->83|115->85|115->85|115->85|116->86|116->86|116->86|116->86|116->86|116->86|119->89|122->92|127->97|127->97|127->97|129->99
                    -- GENERATED --
                */
            