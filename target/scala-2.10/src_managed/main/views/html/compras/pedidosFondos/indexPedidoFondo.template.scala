
package views.html.compras.pedidosFondos

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
object indexPedidoFondo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[PedidoFondo],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[PedidoFondo], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

def /*6.2*/scripts/*6.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*6.13*/("""
	
""")))};implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.81*/("""
"""),format.raw/*5.70*/("""
"""),format.raw/*8.2*/("""

"""),_display_(Seq[Any](/*10.2*/views/*10.7*/.html.compras.mainCompras("Lista de Pedidos Fondos", scripts)/*10.68*/ {_display_(Seq[Any](format.raw/*10.70*/("""
	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Lista de pedidos</h1>
			</div>
			
			<div class="col-sm-5">
				
					
				<div class="pull-right btn-header">
					<a href=""""),_display_(Seq[Any](/*21.16*/controllers/*21.27*/.compras.routes.PedidosFondosController.crear())),format.raw/*21.74*/("""?"""),_display_(Seq[Any](/*21.76*/UriTrack/*21.84*/.encode())),format.raw/*21.93*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo Pedido</a>
				</div>
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*27.3*/views/*27.8*/.html.tags.successError())),format.raw/*27.33*/("""
	
	<div id="actions">
		<form action="" id="formSearchCertificaciones" method="GET">
		<div class="row">
			
		</div>

		<div class="row">	
    		
			<div class="col-sm-2">
				<div class="form-group">
					<label for="nombre" class="control-label">ID
					"""),_display_(Seq[Any](/*40.7*/inputText(formBuscador("id"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*40.89*/("""
					</label>
				</div>
			</div>
			<div class="col-sm-2 input-group">
				<label class="control-label">Fecha de pedido</label>
				<div>
				"""),_display_(Seq[Any](/*47.6*/inputText(formBuscador("fecha_pedido_desde"), 'class -> "form-control dateMask inputDateMascara", 'id -> "desde", 'placeholder -> "Desde"))),format.raw/*47.144*/("""
				"""),_display_(Seq[Any](/*48.6*/inputText(formBuscador("fecha_pedido_hasta"), 'class -> "form-control dateMask inputDateMascara", 'id -> "hasta", 'placeholder -> "Hasta"))),format.raw/*48.144*/("""
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
				<a href=""""),_display_(Seq[Any](/*64.15*/controllers/*64.26*/.compras.routes.PedidosFondosController.index())),format.raw/*64.73*/(""""  class="form-control btn btn-default">Limpiar</a>
				</div>
			</div>
		</div>
		</form>
	</div>
	
	"""),_display_(Seq[Any](/*71.3*/if(buscador.getTotalRowCount == 0)/*71.37*/ {_display_(Seq[Any](format.raw/*71.39*/("""
        
        <div class="well">
            <em>No se encuentran Pedidos</em>
        </div>
        
    """)))}/*77.7*/else/*77.12*/{_display_(Seq[Any](format.raw/*77.13*/("""
    	Mostrando """),_display_(Seq[Any](/*78.17*/buscador/*78.25*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*78.57*/(""" resultado(s). 
			
		<table id="listaPedidosFondos" class="table table-striped table-bordered">
			<thead>
				<tr>
					<th width="30"><input type="checkbox" name="checkAll" id="checkAll"/></th>
					<th width="30">#</th>
					<th width="80">ID</th>
					<th width="70">Fecha</th>
					<th width="70">PROFE</th>
					<th width="95">Monto Total</th>
					<th width="30">#</th>
				</tr>
			</thead>
			<tbody>
			"""),_display_(Seq[Any](/*93.5*/for(pedido <- buscador.getList) yield /*93.36*/ {_display_(Seq[Any](format.raw/*93.38*/("""
				<tr class="pointer" data-estado="" data-href=""""),_display_(Seq[Any](/*94.52*/controllers/*94.63*/.compras.routes.PedidosFondosController.ver(pedido.id))),format.raw/*94.117*/("""&"""),_display_(Seq[Any](/*94.119*/UriTrack/*94.127*/.encode())),format.raw/*94.136*/("""">
					<td><input type="checkbox" name="check_listado[]" value=""""),_display_(Seq[Any](/*95.64*/pedido/*95.70*/.id)),format.raw/*95.73*/("""" class="notSeleccion" id="check-"""),_display_(Seq[Any](/*95.107*/pedido/*95.113*/.id)),format.raw/*95.116*/(""""/></td>
					<td><a class="btn btn-default btn-xs notSeleccion" href=""""),_display_(Seq[Any](/*96.64*/controllers/*96.75*/.compras.routes.PedidosFondosController.editar(pedido.id))),format.raw/*96.132*/("""&"""),_display_(Seq[Any](/*96.134*/UriTrack/*96.142*/.encode())),format.raw/*96.151*/(""""><i class="glyphicon glyphicon-edit"></i></a></td>
					<td>"""),_display_(Seq[Any](/*97.11*/(pedido.id))),format.raw/*97.22*/("""</td>
					<td class="fechaPedido">"""),_display_(Seq[Any](/*98.31*/if(pedido.fecha_pedido != null)/*98.62*/{_display_(Seq[Any](_display_(Seq[Any](/*98.64*/(utils.DateUtils.formatDate(pedido.fecha_pedido))))))})),format.raw/*98.114*/("""</td>
					<td>"""),_display_(Seq[Any](/*99.11*/if(pedido.profe != null && pedido.profe)/*99.51*/{_display_(Seq[Any](format.raw/*99.52*/("""SI""")))}/*99.55*/else/*99.59*/{_display_(Seq[Any](format.raw/*99.60*/("""NO""")))})),format.raw/*99.63*/("""</td>
					<td></td>
					<td>
						<a class="btn btn-default btn-xs delete-confirm-link notSeleccion" href=""""),_display_(Seq[Any](/*102.81*/controllers/*102.92*/.compras.routes.PedidosFondosController.eliminar(pedido.id))),format.raw/*102.151*/("""&"""),_display_(Seq[Any](/*102.153*/UriTrack/*102.161*/.encode())),format.raw/*102.170*/("""">
							<i class="glyphicon glyphicon-trash icono-eliminar"></i>
						</a>
					</td>
				</tr>
             """)))})),format.raw/*107.15*/("""
	        </tbody>
	       
        </table>
    	
    	<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*113.8*/views/*113.13*/.html.helpers.paginador(buscador, controllers.compras.routes.PedidosFondosController.index()))),format.raw/*113.106*/("""
		</div>
		<script>
		$( function ()"""),format.raw/*116.17*/("""{"""),format.raw/*116.18*/("""
			
		"""),format.raw/*118.3*/("""}"""),format.raw/*118.4*/(""");
		</script>		
 	 """)))})),format.raw/*120.5*/("""
""")))})))}
    }
    
    def render(buscador:utils.pagination.Pagination[PedidoFondo],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[PedidoFondo],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:42 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/pedidosFondos/indexPedidoFondo.scala.html
                    HASH: 33b55e306c7aa5b0642e4bab2729ebae0c9c96df
                    MATRIX: 853->1|1063->207|1077->214|1161->218|1196->137|1228->161|1302->80|1330->205|1357->222|1395->225|1408->230|1478->291|1518->293|1766->505|1786->516|1855->563|1893->565|1910->573|1941->582|2109->715|2122->720|2169->745|2463->1004|2567->1086|2748->1232|2909->1370|2950->1376|3111->1514|3539->1906|3559->1917|3628->1964|3767->2068|3810->2102|3850->2104|3980->2217|3993->2222|4032->2223|4085->2240|4102->2248|4156->2280|4606->2695|4653->2726|4693->2728|4781->2780|4801->2791|4878->2845|4917->2847|4935->2855|4967->2864|5069->2930|5084->2936|5109->2939|5180->2973|5196->2979|5222->2982|5330->3054|5350->3065|5430->3122|5469->3124|5487->3132|5519->3141|5617->3203|5650->3214|5722->3250|5762->3281|5810->3283|5887->3333|5939->3349|5988->3389|6027->3390|6049->3393|6062->3397|6101->3398|6136->3401|6284->3512|6305->3523|6388->3582|6428->3584|6447->3592|6480->3601|6626->3714|6761->3813|6776->3818|6893->3911|6959->3948|6989->3949|7024->3956|7053->3957|7106->3978
                    LINES: 26->1|33->6|33->6|35->6|37->5|37->5|38->1|39->5|40->8|42->10|42->10|42->10|42->10|53->21|53->21|53->21|53->21|53->21|53->21|59->27|59->27|59->27|72->40|72->40|79->47|79->47|80->48|80->48|96->64|96->64|96->64|103->71|103->71|103->71|109->77|109->77|109->77|110->78|110->78|110->78|125->93|125->93|125->93|126->94|126->94|126->94|126->94|126->94|126->94|127->95|127->95|127->95|127->95|127->95|127->95|128->96|128->96|128->96|128->96|128->96|128->96|129->97|129->97|130->98|130->98|130->98|130->98|131->99|131->99|131->99|131->99|131->99|131->99|131->99|134->102|134->102|134->102|134->102|134->102|134->102|139->107|145->113|145->113|145->113|148->116|148->116|150->118|150->118|152->120
                    -- GENERATED --
                */
            