
package views.html.haberes.liquidacionBaseCalculos

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
object indexLiquidacionBaseCalculo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[models.haberes.LiquidacionBaseCalculo],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[models.haberes.LiquidacionBaseCalculo], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

implicit def /*6.2*/implicitFieldConstructor/*6.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.107*/("""
"""),format.raw/*5.1*/("""
"""),format.raw/*6.70*/(""" 
"""),_display_(Seq[Any](/*7.2*/views/*7.7*/.html.haberes.mainHaberes("Lista Base Calculos")/*7.55*/ {_display_(Seq[Any](format.raw/*7.57*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Lista de Base Calculos</h1>
			</div>
	
			<div class="col-sm-5">
				<div class="pull-right btn-header">
					<a href=""""),_display_(Seq[Any](/*17.16*/controllers/*17.27*/.haberes.routes.LiquidacionBaseCalculosController.crear())),format.raw/*17.84*/("""?"""),_display_(Seq[Any](/*17.86*/UriTrack/*17.94*/.encode())),format.raw/*17.103*/(""""  class="form-control btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo Base Calculo</a>
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
					<a href=""""),_display_(Seq[Any](/*44.16*/controllers/*44.27*/.haberes.routes.LiquidacionBaseCalculosController.index())),format.raw/*44.84*/(""""  class="form-control btn btn-default">Limpiar</a>
					</div>
				</div>
			</div>
		</form>
	</div>
	
	"""),_display_(Seq[Any](/*51.3*/if(buscador.getTotalRowCount == 0)/*51.37*/ {_display_(Seq[Any](format.raw/*51.39*/("""
        
        <div class="well">
            <em>No se encuentran Base Calculos</em>
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
				<tr class="pointer" data-href=""""),_display_(Seq[Any](/*74.37*/controllers/*74.48*/.haberes.routes.LiquidacionBaseCalculosController.ver(lc.id))),format.raw/*74.108*/("""&"""),_display_(Seq[Any](/*74.110*/UriTrack/*74.118*/.encode())),format.raw/*74.127*/("""">
					<td><input type="checkbox" name="check_listado[]" value=""""),_display_(Seq[Any](/*75.64*/lc/*75.66*/.id)),format.raw/*75.69*/("""" class="notSeleccion" id="check-"""),_display_(Seq[Any](/*75.103*/lc/*75.105*/.id)),format.raw/*75.108*/(""""/></td>
					<td>
						<a class="btn btn-default btn-xs notSeleccion" href=""""),_display_(Seq[Any](/*77.61*/controllers/*77.72*/.haberes.routes.LiquidacionBaseCalculosController.editar(lc.id))),format.raw/*77.135*/("""&"""),_display_(Seq[Any](/*77.137*/UriTrack/*77.145*/.encode())),format.raw/*77.154*/("""">
							<i class="glyphicon glyphicon-edit"></i>
						</a>
					</td>
					<td>"""),_display_(Seq[Any](/*81.11*/(lc.nombre))),format.raw/*81.22*/("""</td>
					<td>
						<a class="btn btn-default btn-xs delete-confirm-link notSeleccion" href=""""),_display_(Seq[Any](/*83.81*/controllers/*83.92*/.haberes.routes.LiquidacionBaseCalculosController.eliminar(lc.id))),format.raw/*83.157*/("""&"""),_display_(Seq[Any](/*83.159*/UriTrack/*83.167*/.encode())),format.raw/*83.176*/("""">
							<i class="glyphicon glyphicon-trash icono-eliminar"></i>
						</a>
					</td>
				</tr>
             """)))})),format.raw/*88.15*/("""
	        </tbody>
        </table>
        
        <div class="pagination pull-right">
		    """),_display_(Seq[Any](/*93.8*/views/*93.13*/.html.helpers.paginador(buscador, controllers.haberes.routes.LiquidacionBaseCalculosController.index()))),format.raw/*93.116*/("""
		</div>
 	 """)))})),format.raw/*95.5*/("""
""")))})))}
    }
    
    def render(buscador:utils.pagination.Pagination[models.haberes.LiquidacionBaseCalculo],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[models.haberes.LiquidacionBaseCalculo],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/liquidacionBaseCalculos/indexLiquidacionBaseCalculo.scala.html
                    HASH: d0eeca9ea65e4a517ad63c715db3c9a32a16f966
                    MATRIX: 900->1|1145->164|1177->188|1252->106|1279->162|1307->232|1344->235|1356->240|1412->288|1451->290|1691->494|1711->505|1790->562|1828->564|1845->572|1877->581|2063->732|2076->737|2123->762|2359->963|2467->1049|2886->1432|2906->1443|2985->1500|3127->1607|3170->1641|3210->1643|3346->1762|3359->1767|3398->1768|3456->1790|3473->1798|3527->1830|3865->2133|3908->2160|3948->2162|4021->2199|4041->2210|4124->2270|4163->2272|4181->2280|4213->2289|4315->2355|4326->2357|4351->2360|4422->2394|4434->2396|4460->2399|4575->2478|4595->2489|4681->2552|4720->2554|4738->2562|4770->2571|4889->2654|4922->2665|5054->2761|5074->2772|5162->2837|5201->2839|5219->2847|5251->2856|5396->2969|5527->3065|5541->3070|5667->3173|5712->3187
                    LINES: 26->1|33->6|33->6|34->1|35->5|36->6|37->7|37->7|37->7|37->7|47->17|47->17|47->17|47->17|47->17|47->17|53->23|53->23|53->23|61->31|61->31|74->44|74->44|74->44|81->51|81->51|81->51|87->57|87->57|87->57|89->59|89->59|89->59|103->73|103->73|103->73|104->74|104->74|104->74|104->74|104->74|104->74|105->75|105->75|105->75|105->75|105->75|105->75|107->77|107->77|107->77|107->77|107->77|107->77|111->81|111->81|113->83|113->83|113->83|113->83|113->83|113->83|118->88|123->93|123->93|123->93|125->95
                    -- GENERATED --
                */
            