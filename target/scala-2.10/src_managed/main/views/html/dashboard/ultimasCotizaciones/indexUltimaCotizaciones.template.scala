
package views.html.dashboard.ultimasCotizaciones

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
object indexUltimaCotizaciones extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[utils.pagination.Pagination[UltimaCotizacion],DynamicForm,utils.pagination.PaginadorFicha,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[UltimaCotizacion], formBuscador: DynamicForm, paginadorFicha: utils.pagination.PaginadorFicha):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

def /*6.2*/scripts/*6.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*6.13*/("""
	 
""")))};implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.135*/("""
"""),format.raw/*5.70*/("""
"""),format.raw/*8.2*/("""
 

"""),_display_(Seq[Any](/*11.2*/views/*11.7*/.html.dashboard.mainDashboard("Lista de Cotizaciones", scripts)/*11.70*/ {_display_(Seq[Any](format.raw/*11.72*/("""
	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Lista de Cotizaciones</h1>
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
				  	<li role="presentation" class="dropdown-header">Acciones Masivas</li>
				  </ul>
				</div>
					
				<div class="pull-right btn-header">
					<a href=""""),_display_(Seq[Any](/*43.16*/controllers/*43.27*/.dashboard.routes.UltimasCotizacionesController.crearUltimaCotizaciones())),format.raw/*43.100*/("""?"""),_display_(Seq[Any](/*43.102*/UriTrack/*43.110*/.encode())),format.raw/*43.119*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nueva Cotizacion</a>
				</div>
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*49.3*/views/*49.8*/.html.tags.successError())),format.raw/*49.33*/("""
	
	<div id="actions">
		<form action="" id="formSearchUltimasCotizaciones" method="GET">
		<div class="row">
			
		</div>

		<div class="row">	
    		
			<div class="col-sm-2">
				<div class="col-sm-2 input-group">
					<label class="control-label">Fecha</label>
					<div>
						"""),_display_(Seq[Any](/*63.8*/inputText(formBuscador("fecha_desde"), 'class -> "form-control inputDateMascara", 'id -> "fecha_desde", 'placeholder -> "Desde"))),format.raw/*63.136*/("""
						"""),_display_(Seq[Any](/*64.8*/inputText(formBuscador("fecha_hasta"), 'class -> "form-control inputDateMascara", 'id -> "fecha_hasta", 'placeholder -> "Hasta"))),format.raw/*64.136*/("""
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			 
			<div class="col-sm-2">
				<div class="form-group">
				<label for="nombre" class="control-label">&nbsp;</label>
				<button  class="form-control btn btn-primary">Buscar</button>
				</div>
			</div>
			<div class="col-sm-2">
				<div class="form-group">
				<label for="nombre" class="control-label">&nbsp;</label>
				<a href=""""),_display_(Seq[Any](/*80.15*/controllers/*80.26*/.dashboard.routes.UltimasCotizacionesController.indexUltimaCotizaciones())),format.raw/*80.99*/(""""  class="form-control btn btn-default">Limpiar</a>
				</div>
			</div>
		</div>
		 
		</form>
	</div>
	
	"""),_display_(Seq[Any](/*88.3*/if(buscador.getTotalRowCount == 0)/*88.37*/ {_display_(Seq[Any](format.raw/*88.39*/("""
        
        <div class="well">
            <em>No se encuentran Cotizaciones</em>
        </div>
        
    """)))}/*94.7*/else/*94.12*/{_display_(Seq[Any](format.raw/*94.13*/("""
    	
		<table id="listaAutorizados" class="table table-striped table-bordered">
			<thead>
				 <tr style="background: #FFFFFF;">
			        <td colspan="3">Mostrando """),_display_(Seq[Any](/*99.39*/buscador/*99.47*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*99.79*/(""" resultado(s). </td>
			    </tr>
				<tr>
					<th width="40">Fecha</th>
					<th width="40">Moneda</th>
					<th width="40">Cotizacion</th>
					<th width="30">#</th>
				</tr>
			</thead>
			<tbody>
			"""),_display_(Seq[Any](/*109.5*/for(co <- buscador.getList) yield /*109.32*/ {_display_(Seq[Any](format.raw/*109.34*/("""
				"""),_display_(Seq[Any](/*110.6*/paginadorFicha/*110.20*/.add(co.id.toString))),format.raw/*110.40*/("""
				<tr class="pointer">
					<td class="fecha">"""),_display_(Seq[Any](/*112.25*/if(co.fecha != null)/*112.45*/{_display_(Seq[Any](_display_(Seq[Any](/*112.47*/(utils.DateUtils.formatDate(co.fecha))))))})),format.raw/*112.86*/("""</td>
					<td rel=""""),_display_(Seq[Any](/*113.16*/co/*113.18*/.cotizacion)),format.raw/*113.29*/("""">"""),_display_(Seq[Any](/*113.32*/UltimaCotizacion/*113.48*/.getMoneda(co.tipo_moneda))),format.raw/*113.74*/("""</td>
					<td class="total" rel=""""),_display_(Seq[Any](/*114.30*/co/*114.32*/.cotizacion)),format.raw/*114.43*/("""">"""),_display_(Seq[Any](/*114.46*/(utils.NumberUtils.moneda(co.cotizacion)))),format.raw/*114.87*/("""</td>
					
					<td>
						<a class="btn btn-default btn-xs delete-confirm-link notSeleccion" href=""""),_display_(Seq[Any](/*117.81*/controllers/*117.92*/.dashboard.routes.UltimasCotizacionesController.eliminar(co.id))),format.raw/*117.155*/("""&"""),_display_(Seq[Any](/*117.157*/UriTrack/*117.165*/.encode())),format.raw/*117.174*/("""">
							<i class="glyphicon glyphicon-trash icono-eliminar"></i>
						</a>
					</td>
				</tr>
             """)))})),format.raw/*122.15*/("""
             """),_display_(Seq[Any](/*123.15*/paginadorFicha/*123.29*/.guardar())),format.raw/*123.39*/("""
	        </tbody>
	        <tfoot>
		        <tr>
			        <td colspan="3">&nbsp</td>
			        
		        </tr>
	        </tfoot>
        </table>
    	
    	<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*134.8*/views/*134.13*/.html.helpers.paginador(buscador, controllers.dashboard.routes.UltimasCotizacionesController.indexUltimaCotizaciones()))),format.raw/*134.132*/("""
		</div>
<script>
$( function ()"""),format.raw/*137.15*/("""{"""),format.raw/*137.16*/("""
	 
"""),format.raw/*139.1*/("""}"""),format.raw/*139.2*/(""");

function selectTrList()"""),format.raw/*141.24*/("""{"""),format.raw/*141.25*/("""
	 
	
"""),format.raw/*144.1*/("""}"""),format.raw/*144.2*/("""

function selectAll()"""),format.raw/*146.21*/("""{"""),format.raw/*146.22*/("""
	 
"""),format.raw/*148.1*/("""}"""),format.raw/*148.2*/("""

</script>		
 	 """)))})),format.raw/*151.5*/("""
""")))})))}
    }
    
    def render(buscador:utils.pagination.Pagination[UltimaCotizacion],formBuscador:DynamicForm,paginadorFicha:utils.pagination.PaginadorFicha): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador,paginadorFicha)
    
    def f:((utils.pagination.Pagination[UltimaCotizacion],DynamicForm,utils.pagination.PaginadorFicha) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador,paginadorFicha) => apply(buscador,formBuscador,paginadorFicha)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:58 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/ultimasCotizaciones/indexUltimaCotizaciones.scala.html
                    HASH: 3dd175b2e8451c3fd3c66e506665cf83a9ec24ba
                    MATRIX: 905->1|1169->261|1183->268|1267->272|1303->191|1335->215|1410->134|1438->259|1465->277|1505->282|1518->287|1590->350|1630->352|2718->1404|2738->1415|2834->1488|2873->1490|2891->1498|2923->1507|3095->1644|3108->1649|3155->1674|3473->1957|3624->2085|3667->2093|3818->2221|4255->2622|4275->2633|4370->2706|4513->2814|4556->2848|4596->2850|4731->2968|4744->2973|4783->2974|4989->3144|5006->3152|5060->3184|5302->3390|5346->3417|5387->3419|5429->3425|5453->3439|5496->3459|5583->3509|5613->3529|5662->3531|5728->3570|5786->3591|5798->3593|5832->3604|5872->3607|5898->3623|5947->3649|6019->3684|6031->3686|6065->3697|6105->3700|6169->3741|6308->3843|6329->3854|6416->3917|6456->3919|6475->3927|6508->3936|6654->4049|6706->4064|6730->4078|6763->4088|7005->4294|7020->4299|7163->4418|7225->4451|7255->4452|7287->4456|7316->4457|7372->4484|7402->4485|7436->4491|7465->4492|7516->4514|7546->4515|7578->4519|7607->4520|7657->4538
                    LINES: 26->1|33->6|33->6|35->6|37->5|37->5|38->1|39->5|40->8|43->11|43->11|43->11|43->11|75->43|75->43|75->43|75->43|75->43|75->43|81->49|81->49|81->49|95->63|95->63|96->64|96->64|112->80|112->80|112->80|120->88|120->88|120->88|126->94|126->94|126->94|131->99|131->99|131->99|141->109|141->109|141->109|142->110|142->110|142->110|144->112|144->112|144->112|144->112|145->113|145->113|145->113|145->113|145->113|145->113|146->114|146->114|146->114|146->114|146->114|149->117|149->117|149->117|149->117|149->117|149->117|154->122|155->123|155->123|155->123|166->134|166->134|166->134|169->137|169->137|171->139|171->139|173->141|173->141|176->144|176->144|178->146|178->146|180->148|180->148|183->151
                    -- GENERATED --
                */
            