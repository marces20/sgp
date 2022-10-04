
package views.html.contabilidad.sucursalbancos

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
object indexSucursalBanco extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[SucursalBanco],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[SucursalBanco], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.83*/("""
"""),format.raw/*3.70*/("""

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.contabilidad.mainContabilidad("Lista Sucursal Bancos")/*5.67*/ {_display_(Seq[Any](format.raw/*5.69*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Lista de sucursal bancos</h1>
			</div>
	
			<div class="col-sm-2">
				<a href=""""),_display_(Seq[Any](/*14.15*/controllers/*14.26*/.contabilidad.routes.SucursalBancosController.indexSucursalBanco())),format.raw/*14.92*/("""" class="btn btn-default">
					<i class="glyphicon glyphicon-list"></i>
				</a>
				<a href="#" class="btn btn-default">
					<i class="glyphicon glyphicon-align-justify"></i>
				</a>
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*24.3*/views/*24.8*/.html.tags.successError())),format.raw/*24.33*/("""
	
	<div id="actions">
		<div class="row">
			<form action="" method="GET">
				<div class="col-sm-3">
					<div class="form-group">
						<label for="nombre" class="control-label">Nombre
						"""),_display_(Seq[Any](/*32.8*/inputText(formBuscador("nombre"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*32.94*/("""
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
					<a href=""""),_display_(Seq[Any](/*45.16*/controllers/*45.27*/.contabilidad.routes.SucursalBancosController.indexSucursalBanco())),format.raw/*45.93*/(""""  class="form-control btn btn-default">Limpiar</a>
					</div>
				</div>
			</form>
		</div>
	</div>
	
	<div class="row">
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*54.14*/controllers/*54.25*/.contabilidad.routes.SucursalBancosController.crearSucursalBanco)),format.raw/*54.89*/(""""  class="form-control btn btn-default">Nueva sucursal</a>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*58.3*/if(buscador.getTotalRowCount == 0)/*58.37*/ {_display_(Seq[Any](format.raw/*58.39*/("""
        
        <div class="well">
            <em>No se encuentran sucursales</em>
        </div>
        
    """)))}/*64.7*/else/*64.12*/{_display_(Seq[Any](format.raw/*64.13*/("""
    
    	Mostrando """),_display_(Seq[Any](/*66.17*/buscador/*66.25*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*66.57*/(""" resultado(s). 
		
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th width="50">#</th>
					<th width="200">Nombre</th>
					<th width="200">Banco</th>
					<th width="200">Codigo</th>
					<th width="200">Localidad</th>
					<th class="50">#</th>
				</tr>
			</thead>
			<tbody>
			"""),_display_(Seq[Any](/*80.5*/for(sucursalBanco <- buscador.getList) yield /*80.43*/ {_display_(Seq[Any](format.raw/*80.45*/("""
				<tr>
					<td>
						<a href=""""),_display_(Seq[Any](/*83.17*/controllers/*83.28*/.contabilidad.routes.SucursalBancosController.editarSucursalBanco(sucursalBanco.id))),format.raw/*83.111*/("""">
							<i class="glyphicon glyphicon-edit"></i>
						</a>
					</td>
					<td>"""),_display_(Seq[Any](/*87.11*/(sucursalBanco.nombre))),format.raw/*87.33*/("""</td>
					<td>"""),_display_(Seq[Any](/*88.11*/(sucursalBanco.banco.nombre))),format.raw/*88.39*/("""</td>
					<td>"""),_display_(Seq[Any](/*89.11*/(sucursalBanco.codigo))),format.raw/*89.33*/("""</td>
					<td>"""),_display_(Seq[Any](/*90.11*/(sucursalBanco.localidad.nombre))),format.raw/*90.43*/("""</td>
					<td>
						<a href=""""),_display_(Seq[Any](/*92.17*/controllers/*92.28*/.contabilidad.routes.SucursalBancosController.eliminarSucursalBanco(sucursalBanco.id))),format.raw/*92.113*/("""">
							<i class="glyphicon glyphicon-remove-circle"></i>
						</a>
					</td>
				</tr>
             """)))})),format.raw/*97.15*/("""
	        </tbody>
        </table>
        
        <div class="pagination pull-right">
		    """),_display_(Seq[Any](/*102.8*/views/*102.13*/.html.helpers.paginador(buscador, controllers.contabilidad.routes.SucursalBancosController.indexSucursalBanco()))),format.raw/*102.125*/("""
		</div>
        </div>
 	 """)))})),format.raw/*105.5*/("""
""")))})))}
    }
    
    def render(buscador:utils.pagination.Pagination[SucursalBanco],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[SucursalBanco],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:38 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/sucursalbancos/indexSucursalBanco.scala.html
                    HASH: 44dac8c38123c0a5c364a1fa10f03ab155d30682
                    MATRIX: 863->1|1046->101|1078->125|1152->82|1180->169|1217->172|1229->177|1297->237|1336->239|1538->405|1558->416|1646->482|1899->700|1912->705|1959->730|2189->925|2297->1011|2715->1393|2735->1404|2823->1470|3021->1632|3041->1643|3127->1707|3242->1787|3285->1821|3325->1823|3458->1939|3471->1944|3510->1945|3568->1967|3585->1975|3639->2007|3991->2324|4045->2362|4085->2364|4157->2400|4177->2411|4283->2494|4402->2577|4446->2599|4498->2615|4548->2643|4600->2659|4644->2681|4696->2697|4750->2729|4818->2761|4838->2772|4946->2857|5084->2963|5216->3059|5231->3064|5367->3176|5428->3205
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|42->14|42->14|42->14|52->24|52->24|52->24|60->32|60->32|73->45|73->45|73->45|82->54|82->54|82->54|86->58|86->58|86->58|92->64|92->64|92->64|94->66|94->66|94->66|108->80|108->80|108->80|111->83|111->83|111->83|115->87|115->87|116->88|116->88|117->89|117->89|118->90|118->90|120->92|120->92|120->92|125->97|130->102|130->102|130->102|133->105
                    -- GENERATED --
                */
            