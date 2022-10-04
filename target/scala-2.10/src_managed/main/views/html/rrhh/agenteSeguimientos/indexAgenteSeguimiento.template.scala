
package views.html.rrhh.agenteSeguimientos

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
object indexAgenteSeguimiento extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[AgenteSeguimiento],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[AgenteSeguimiento], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

def /*4.2*/scripts/*4.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*4.13*/("""
	<script src=""""),_display_(Seq[Any](/*5.16*/routes/*5.22*/.Assets.at("javascripts/rrhh/agentes.js"))),format.raw/*5.63*/("""" type="text/javascript"></script>
""")))};implicit def /*7.2*/implicitFieldConstructor/*7.26*/ = {{ FieldConstructor(simpleInput.render) }};def /*9.2*/getClassEstado/*9.16*/(i:AgenteSeguimiento) = {{
	var classEstado:String = new String()
	
	if(i.estado != null && i.estado.id == 110){
		classEstado = "borrador"
	}else if(i.estado != null && i.estado.id == 112){
		classEstado = "autorizado"
	}
	
	classEstado
}};
Seq[Any](format.raw/*1.87*/("""
"""),format.raw/*6.2*/("""
"""),format.raw/*7.70*/(""" 

"""),format.raw/*19.2*/("""


"""),_display_(Seq[Any](/*22.2*/views/*22.7*/.html.rrhh.mainRrhh("Lista Agentes Seguimientos",scripts)/*22.64*/ {_display_(Seq[Any](format.raw/*22.66*/("""
	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Lista de Agentes Seguimientos</h1>
			</div>
			<div class="col-sm-5">
				<div class="dropdown pull-right">
				 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 	<i class="glyphicon glyphicon-list-alt"></i>
				    Reportes
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				  	
				  </ul>
				</div>
				
				<div class="dropdown pull-right btn-header">
				 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 	<i class="glyphicon glyphicon-cog"></i>
				    Acciones
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				  	
				  </ul>
				</div>
					
				<div class="pull-right btn-header">
					<a href=""""),_display_(Seq[Any](/*52.16*/controllers/*52.27*/.rrhh.routes.AgentesSeguimientoController.crearAgenteSeguimiento())),format.raw/*52.93*/("""?"""),_display_(Seq[Any](/*52.95*/UriTrack/*52.103*/.encode())),format.raw/*52.112*/(""""  class="form-control btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo Seguimiento</a>
				</div>
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*58.3*/views/*58.8*/.html.tags.successError())),format.raw/*58.33*/("""
	
	<div id="actions">
		<form action="" id="formSearchAgenteSeguimiento method="GET">
			<div class="row" >
					<div class="col-sm-10 filtrosEstados" id="filtrosEstados">
						<div class="btn-group">
						  <button type="button" rel="borrador" class="btn btn-default btn-filtros">
						  	<i class="glyphicon glyphicon-pencil size-14"></i><br>Borrador
						  	"""),_display_(Seq[Any](/*67.11*/checkbox(formBuscador("btnFiltro[0]"), 'hidden -> "hidden"))),format.raw/*67.70*/("""
						  </button>
						  <button type="button" rel="imputado" class="btn btn-default btn-filtros">
						  	<i class="glyphicon glyphicon-arrow-right"></i><br>Proceso
						  	"""),_display_(Seq[Any](/*71.11*/checkbox(formBuscador("btnFiltro[1]"), 'hidden -> "hidden"))),format.raw/*71.70*/("""
						 </button>
						 <button type="button" rel="aprobado" class="btn btn-default btn-filtros">
						  	<i class="glyphicon glyphicon-ok"></i><br>Cerrado
						  	"""),_display_(Seq[Any](/*75.11*/checkbox(formBuscador("btnFiltro[2]"), 'hidden -> "hidden"))),format.raw/*75.70*/("""
						 </button> 
						</div>
					</div>
				</div>
			 
			<div class="row">	  
				
				<div class="col-sm-2">
					<div class="form-group">
						<label for="nombre" class="control-label">Nombre
						"""),_display_(Seq[Any](/*86.8*/inputText(formBuscador("nombre"), 'class -> "form-control"))),format.raw/*86.67*/("""
						</label>
					</div>
				</div>
				<div class="col-sm-2">
					<div class="form-group">
						<label for="cuit" class="control-label">DNI
						"""),_display_(Seq[Any](/*93.8*/inputText(formBuscador("dni"), 'class -> "form-control"))),format.raw/*93.64*/("""
						</label>
					</div>
				</div>
				<div class="col-sm-2">
					<div class="form-group">
						<label for="cuit" class="control-label">Tipo
						"""),_display_(Seq[Any](/*100.8*/select(formBuscador("tipo_agente_seguimiento"), 
						TipoAgenteSeguimiento.find.all().map { p => p.id.toString -> p.nombre}, 
						'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*102.67*/("""
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
					<a href=""""),_display_(Seq[Any](/*118.16*/controllers/*118.27*/.rrhh.routes.AgentesAsistenciasController.index())),format.raw/*118.76*/(""""  class="form-control btn btn-default">Limpiar</a>
					</div>
				</div>
				
			</div>
		</form>
	</div>
	"""),_display_(Seq[Any](/*125.3*/if(buscador.getTotalRowCount == 0)/*125.37*/ {_display_(Seq[Any](format.raw/*125.39*/("""
        
        <div class="well">
            <em>No se encuentran Agentes</em>
        </div>
        
    """)))}/*131.7*/else/*131.12*/{_display_(Seq[Any](format.raw/*131.13*/("""
    	Mostrando """),_display_(Seq[Any](/*132.17*/buscador/*132.25*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*132.57*/(""" resultado(s). 
		
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th width="30"><input type="checkbox" name="checkAll" id="checkAll"/></th>
					<th width="50">#</th>
					<th>Apellido y Nombre</th>
					<th>DNI</th>
					<th>Tipo</th>
					<th>Inicio</th>
					<th>Fin</th>
					<th width="30">Estado</th>
					<th class="30">#</th> 
				</tr>
			</thead>
			<tbody>
			"""),_display_(Seq[Any](/*149.5*/for(a <- buscador.getList) yield /*149.31*/ {_display_(Seq[Any](format.raw/*149.33*/("""
				<tr class="pointer """),_display_(Seq[Any](/*150.25*/getClassEstado(a))),format.raw/*150.42*/("""" data-href=""""),_display_(Seq[Any](/*150.56*/controllers/*150.67*/.rrhh.routes.AgentesSeguimientoController.ver(a.id))),format.raw/*150.118*/("""&"""),_display_(Seq[Any](/*150.120*/UriTrack/*150.128*/.encode())),format.raw/*150.137*/("""">
					<td><input type="checkbox" name="check_listado[]" value=""""),_display_(Seq[Any](/*151.64*/a/*151.65*/.id)),format.raw/*151.68*/("""" class="notSeleccion" id="check-"""),_display_(Seq[Any](/*151.102*/a/*151.103*/.id)),format.raw/*151.106*/(""""/></td>
					<td class="notSeleccion" align="center">
						<a class="btn btn-default btn-xs notSeleccion" href=""""),_display_(Seq[Any](/*153.61*/controllers/*153.72*/.rrhh.routes.AgentesSeguimientoController.editarAgenteSeguimiento(a.id))),format.raw/*153.143*/("""&"""),_display_(Seq[Any](/*153.145*/UriTrack/*153.153*/.encode())),format.raw/*153.162*/("""">
							<i class="glyphicon glyphicon-edit"></i>
						</a>
					</td>
					<td>"""),_display_(Seq[Any](/*157.11*/(a.agente.apellido))),format.raw/*157.30*/("""</td>
					<td>"""),_display_(Seq[Any](/*158.11*/(a.agente.dni))),format.raw/*158.25*/("""</td>
					<td>"""),_display_(Seq[Any](/*159.11*/(a.tipoAgenteSeguimiento.nombre))),format.raw/*159.43*/("""</td>
					<td>"""),_display_(Seq[Any](/*160.11*/if(a.fincio != null)/*160.31*/{_display_(Seq[Any](_display_(Seq[Any](/*160.33*/(utils.DateUtils.formatDate(a.fincio))))))})),format.raw/*160.72*/("""</td>
					<td>"""),_display_(Seq[Any](/*161.11*/if(a.ffin != null)/*161.29*/{_display_(Seq[Any](_display_(Seq[Any](/*161.31*/(utils.DateUtils.formatDate(a.ffin))))))})),format.raw/*161.68*/("""</td>
					<td class="estado">"""),_display_(Seq[Any](/*162.26*/(a.estado.nombre))),format.raw/*162.43*/("""</td>
					<td>
						<a class="btn btn-default btn-xs delete-confirm-link notSeleccion" 
							href=""""),_display_(Seq[Any](/*165.15*/controllers/*165.26*/.rrhh.routes.AgentesSeguimientoController.eliminarAgenteSeguimiento(a.id))),format.raw/*165.99*/("""&"""),_display_(Seq[Any](/*165.101*/UriTrack/*165.109*/.encode())),format.raw/*165.118*/("""">
							<i class="glyphicon glyphicon-trash icono-eliminar"></i>
						</a>
					</td> 
				</tr>	
			""")))})),format.raw/*170.5*/("""		
			</tbody>
        </table>
		
		<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*175.8*/views/*175.13*/.html.helpers.paginador(buscador, controllers.rrhh.routes.AgentesSeguimientoController.index()))),format.raw/*175.108*/("""
		</div>
    """)))})),format.raw/*177.6*/("""



""")))})))}
    }
    
    def render(buscador:utils.pagination.Pagination[AgenteSeguimiento],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[AgenteSeguimiento],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:31 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agenteSeguimientos/indexAgenteSeguimiento.scala.html
                    HASH: d00f11b8a7c09759a14a2596beb68be273d875b4
                    MATRIX: 867->1|1061->121|1075->128|1159->132|1210->148|1224->154|1286->195|1353->233|1385->257|1442->305|1464->319|1733->86|1760->231|1788->301|1818->558|1857->562|1870->567|1936->624|1976->626|2989->1603|3009->1614|3097->1680|3135->1682|3153->1690|3185->1699|3370->1849|3383->1854|3430->1879|3833->2246|3914->2305|4129->2484|4210->2543|4414->2711|4495->2770|4738->2978|4819->3037|5007->3190|5085->3246|5275->3400|5492->3594|5927->3992|5948->4003|6020->4052|6166->4162|6210->4196|6251->4198|6382->4311|6396->4316|6436->4317|6490->4334|6508->4342|6563->4374|7003->4778|7046->4804|7087->4806|7149->4831|7189->4848|7240->4862|7261->4873|7336->4924|7376->4926|7395->4934|7428->4943|7531->5009|7542->5010|7568->5013|7640->5047|7652->5048|7679->5051|7831->5166|7852->5177|7947->5248|7987->5250|8006->5258|8039->5267|8159->5350|8201->5369|8254->5385|8291->5399|8344->5415|8399->5447|8452->5463|8482->5483|8531->5485|8597->5524|8650->5540|8678->5558|8727->5560|8791->5597|8859->5628|8899->5645|9040->5749|9061->5760|9157->5833|9197->5835|9216->5843|9249->5852|9386->5957|9502->6037|9517->6042|9636->6137|9683->6152
                    LINES: 26->1|31->4|31->4|33->4|34->5|34->5|34->5|35->7|35->7|35->9|35->9|46->1|47->6|48->7|50->19|53->22|53->22|53->22|53->22|83->52|83->52|83->52|83->52|83->52|83->52|89->58|89->58|89->58|98->67|98->67|102->71|102->71|106->75|106->75|117->86|117->86|124->93|124->93|131->100|133->102|149->118|149->118|149->118|156->125|156->125|156->125|162->131|162->131|162->131|163->132|163->132|163->132|180->149|180->149|180->149|181->150|181->150|181->150|181->150|181->150|181->150|181->150|181->150|182->151|182->151|182->151|182->151|182->151|182->151|184->153|184->153|184->153|184->153|184->153|184->153|188->157|188->157|189->158|189->158|190->159|190->159|191->160|191->160|191->160|191->160|192->161|192->161|192->161|192->161|193->162|193->162|196->165|196->165|196->165|196->165|196->165|196->165|201->170|206->175|206->175|206->175|208->177
                    -- GENERATED --
                */
            