
package views.html.haberes.conveniosBancos

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
object indexConvenioBanco extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[models.haberes.ConvenioBanco],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[models.haberes.ConvenioBanco], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

implicit def /*6.2*/implicitFieldConstructor/*6.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.98*/("""
"""),format.raw/*5.1*/("""
"""),format.raw/*6.70*/(""" 
"""),_display_(Seq[Any](/*7.2*/views/*7.7*/.html.haberes.mainHaberes("Lista Convenios Bancos ")/*7.59*/ {_display_(Seq[Any](format.raw/*7.61*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Lista Convenios Bancos</h1>
			</div>
	
			<div class="col-sm-5">
				<div class="pull-right btn-header">
					<a href=""""),_display_(Seq[Any](/*17.16*/controllers/*17.27*/.haberes.routes.ConveniosBancosController.crear())),format.raw/*17.76*/("""?"""),_display_(Seq[Any](/*17.78*/UriTrack/*17.86*/.encode())),format.raw/*17.95*/(""""  class="form-control btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nueva Convenio</a>
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
					<a href=""""),_display_(Seq[Any](/*44.16*/controllers/*44.27*/.haberes.routes.ConveniosBancosController.index())),format.raw/*44.76*/(""""  class="form-control btn btn-default">Limpiar</a>
					</div>
				</div>
			</div>
		</form>
	</div>
	
	"""),_display_(Seq[Any](/*51.3*/if(buscador.getTotalRowCount == 0)/*51.37*/ {_display_(Seq[Any](format.raw/*51.39*/("""
        
        <div class="well">
            <em>No se encuentran Convenios Bancos</em>
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
				<tr class="pointer" data-href=""""),_display_(Seq[Any](/*74.37*/controllers/*74.48*/.haberes.routes.ConveniosBancosController.ver(lc.id))),format.raw/*74.100*/("""&"""),_display_(Seq[Any](/*74.102*/UriTrack/*74.110*/.encode())),format.raw/*74.119*/("""">
					<td><input type="checkbox" name="check_listado[]" value=""""),_display_(Seq[Any](/*75.64*/lc/*75.66*/.id)),format.raw/*75.69*/("""" class="notSeleccion" id="check-"""),_display_(Seq[Any](/*75.103*/lc/*75.105*/.id)),format.raw/*75.108*/(""""/></td>
					<td>
						"""),_display_(Seq[Any](/*77.8*/if(Permiso.check("convenioBancoEditar"))/*77.48*/ {_display_(Seq[Any](format.raw/*77.50*/("""
						<a class="btn btn-default btn-xs notSeleccion" href=""""),_display_(Seq[Any](/*78.61*/controllers/*78.72*/.haberes.routes.ConveniosBancosController.editar(lc.id))),format.raw/*78.127*/("""&"""),_display_(Seq[Any](/*78.129*/UriTrack/*78.137*/.encode())),format.raw/*78.146*/("""">
							<i class="glyphicon glyphicon-edit"></i>
						</a>
						""")))})),format.raw/*81.8*/("""
					</td>
					<td>"""),_display_(Seq[Any](/*83.11*/(lc.nombre))),format.raw/*83.22*/("""</td>
					<td>
						"""),_display_(Seq[Any](/*85.8*/if(Permiso.check("convenioBancoEliminar"))/*85.50*/ {_display_(Seq[Any](format.raw/*85.52*/("""
						<a class="btn btn-default btn-xs delete-confirm-link notSeleccion" href=""""),_display_(Seq[Any](/*86.81*/controllers/*86.92*/.haberes.routes.ConveniosBancosController.eliminar(lc.id))),format.raw/*86.149*/("""&"""),_display_(Seq[Any](/*86.151*/UriTrack/*86.159*/.encode())),format.raw/*86.168*/("""">
							<i class="glyphicon glyphicon-trash icono-eliminar"></i>
						</a>
						""")))})),format.raw/*89.8*/("""
					</td>
				</tr>
             """)))})),format.raw/*92.15*/("""
	        </tbody>
        </table>
        
        <div class="pagination pull-right">
		    """),_display_(Seq[Any](/*97.8*/views/*97.13*/.html.helpers.paginador(buscador, controllers.haberes.routes.ConveniosBancosController.index()))),format.raw/*97.108*/("""
		</div>
 	 """)))})),format.raw/*99.5*/("""
""")))})))}
    }
    
    def render(buscador:utils.pagination.Pagination[models.haberes.ConvenioBanco],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[models.haberes.ConvenioBanco],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/conveniosBancos/indexConvenioBanco.scala.html
                    HASH: aba521676e88892109da1f27753bf1c4619c7533
                    MATRIX: 874->1|1110->155|1142->179|1216->97|1243->153|1271->223|1308->226|1320->231|1380->283|1419->285|1659->489|1679->500|1750->549|1788->551|1805->559|1836->568|2018->715|2031->720|2078->745|2314->946|2422->1032|2841->1415|2861->1426|2932->1475|3074->1582|3117->1616|3157->1618|3296->1740|3309->1745|3348->1746|3406->1768|3423->1776|3477->1808|3815->2111|3858->2138|3898->2140|3971->2177|3991->2188|4066->2240|4105->2242|4123->2250|4155->2259|4257->2325|4268->2327|4293->2330|4364->2364|4376->2366|4402->2369|4463->2395|4512->2435|4552->2437|4649->2498|4669->2509|4747->2564|4786->2566|4804->2574|4836->2583|4936->2652|4994->2674|5027->2685|5085->2708|5136->2750|5176->2752|5293->2833|5313->2844|5393->2901|5432->2903|5450->2911|5482->2920|5598->3005|5666->3041|5797->3137|5811->3142|5929->3237|5974->3251
                    LINES: 26->1|33->6|33->6|34->1|35->5|36->6|37->7|37->7|37->7|37->7|47->17|47->17|47->17|47->17|47->17|47->17|53->23|53->23|53->23|61->31|61->31|74->44|74->44|74->44|81->51|81->51|81->51|87->57|87->57|87->57|89->59|89->59|89->59|103->73|103->73|103->73|104->74|104->74|104->74|104->74|104->74|104->74|105->75|105->75|105->75|105->75|105->75|105->75|107->77|107->77|107->77|108->78|108->78|108->78|108->78|108->78|108->78|111->81|113->83|113->83|115->85|115->85|115->85|116->86|116->86|116->86|116->86|116->86|116->86|119->89|122->92|127->97|127->97|127->97|129->99
                    -- GENERATED --
                */
            