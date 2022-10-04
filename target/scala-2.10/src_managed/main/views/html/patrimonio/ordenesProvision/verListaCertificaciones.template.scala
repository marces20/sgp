
package views.html.patrimonio.ordenesProvision

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
object verListaCertificaciones extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[OrdenProvision,utils.pagination.Pagination[OrdenProvisionLineas],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(orden: OrdenProvision, buscador: utils.pagination.Pagination[OrdenProvisionLineas]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import models.auth._

import utils._

def /*3.2*/getPacientes/*3.14*/(linea: OrdenLinea) = {{
	var pacientes:String = new String()
	if(linea != null && linea.ordenLineaCliente != null && linea.ordenLineaCliente.size() > 0){
		for(olp <- linea.ordenLineaCliente) {
			pacientes += olp.cliente.nombre.toUpperCase()+" - ID:"+olp.cliente.id_paciente_rismi+"\n" 
		}
	}
	pacientes
}};implicit def /*16.2*/implicitFieldConstructor/*16.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.86*/("""

"""),format.raw/*11.2*/("""

"""),format.raw/*16.70*/("""

	<ul id="ordenTab" class="nav nav-tabs">
		<li class="active"><a href="#contenedorSolicitados" data-toggle="tab">Servicios</a></li>
		<li><a id="menuCertificaciones" href="#contenedorCertificaciones" data-href=""""),_display_(Seq[Any](/*20.81*/controllers/*20.92*/.patrimonio.routes.CertificacionesServiciosController.indexAjax())),format.raw/*20.157*/("""?orden_provision_id="""),_display_(Seq[Any](/*20.178*/orden/*20.183*/.id)),format.raw/*20.186*/("""" data-toggle="tab">Certificaciones</a></li>
		<li><a id="menuAjusteOrdenCompra" data-href=""""),_display_(Seq[Any](/*21.49*/controllers/*21.60*/.compras.routes.OrdenesLineasAjustesController.index(orden.ordenCompra.id,false))),format.raw/*21.140*/("""" href="#contenedorAjusteOrdenCompra" data-toggle="tab">Ajustes Orden</a></li>
	</ul>

	<div class="tab-content">
		<div id="contenedorSolicitados" class="tab-pane active">
			"""),_display_(Seq[Any](/*26.5*/if(buscador.getTotalRowCount == 0)/*26.39*/ {_display_(Seq[Any](format.raw/*26.41*/("""
		       <div class="well">
		           <em>No se encuentran resultados</em>
		       </div>
		       
		   """)))}/*31.8*/else/*31.13*/{_display_(Seq[Any](format.raw/*31.14*/("""
		   	Mostrando """),_display_(Seq[Any](/*32.18*/buscador/*32.26*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*32.58*/(""" resultado(s). 
		   
			<table class="table table-striped table-bordered table-hover" style="margin-top: 20px">
				<thead>
					<tr>
						<th><input type="checkbox" class="check_all" data-check=".check_productos" /></th>
						<th>Producto</th>
						<th width="100">Solicitado</th>
						<th>Servicio</th>
						<th width="50">Udm</th>
						<th width="80">Total</th>
						<th width="100">Certificado</th>
						<th width="100">Pendiente</th>
						<th width="100">Anulado</th>
						<th>Pacientes</th>
					</tr>
				</thead>
				<tbody>
				"""),_display_(Seq[Any](/*50.6*/for(o <- buscador.getList) yield /*50.32*/ {_display_(Seq[Any](format.raw/*50.34*/("""
					<tr>
						<th width="30"><input name="check_listado[]" value=""""),_display_(Seq[Any](/*52.60*/o/*52.61*/.orden_linea_id)),format.raw/*52.76*/("""" type="checkbox" class="check_productos notSeleccion" /></th>
						<td>"""),_display_(Seq[Any](/*53.12*/o/*53.13*/.producto.nombre)),format.raw/*53.29*/("""</td>
						<td>"""),_display_(Seq[Any](/*54.12*/o/*54.13*/.cantidad)),format.raw/*54.22*/("""</td>
						<td>"""),_display_(Seq[Any](/*55.12*/if(o.departamento != null)/*55.38*/{_display_(Seq[Any](_display_(Seq[Any](/*55.40*/o/*55.41*/.departamento))))})),format.raw/*55.55*/("""</td>
						<td>"""),_display_(Seq[Any](/*56.12*/o/*56.13*/.udm)),format.raw/*56.17*/("""</td>
						<td>"""),_display_(Seq[Any](/*57.12*/utils/*57.17*/.NumberUtils.moneda(o.getTotal()))),format.raw/*57.50*/("""</td>
						<td>"""),_display_(Seq[Any](/*58.12*/utils/*58.17*/.NumberUtils.moneda(o.getTotalRecepcionado()))),format.raw/*58.62*/("""</td>
						<td>"""),_display_(Seq[Any](/*59.12*/utils/*59.17*/.NumberUtils.moneda(o.getTotal().subtract(o.getTotalRecepcionado())))),format.raw/*59.85*/("""</td>
						<td>"""),_display_(Seq[Any](/*60.12*/utils/*60.17*/.NumberUtils.moneda(o.getAnuladosMonto()))),format.raw/*60.58*/("""</td>
						<td>
						"""),_display_(Seq[Any](/*62.8*/if(o.getOrdenLinea().ordenLineaCliente != null && o.getOrdenLinea().ordenLineaCliente.size() > 0)/*62.105*/{_display_(Seq[Any](format.raw/*62.106*/("""
							<div class='tip-top pointer' title='"""),_display_(Seq[Any](/*63.45*/getPacientes(o.getOrdenLinea()))),format.raw/*63.76*/("""'><i class="glyphicon glyphicon-user"></i></div>
						""")))})),format.raw/*64.8*/("""
						</td>
					</tr>
				""")))})),format.raw/*67.6*/("""
				</tbody>
			</table>
			<div class="pagination pull-right">
			    """),_display_(Seq[Any](/*71.9*/views/*71.14*/.html.helpers.paginador(buscador, controllers.patrimonio.routes.OrdenesProvisionController.ver(orden.id)))),format.raw/*71.119*/("""
			</div>
		   """)))})),format.raw/*73.7*/("""
		</div>
		
		<div id="contenedorCertificaciones" class="tab-pane">
			
		</div>
		
		<div id="contenedorAjusteOrdenCompra" class="contenedor tab-pane">
			
		</div>"""))}
    }
    
    def render(orden:OrdenProvision,buscador:utils.pagination.Pagination[OrdenProvisionLineas]): play.api.templates.HtmlFormat.Appendable = apply(orden,buscador)
    
    def f:((OrdenProvision,utils.pagination.Pagination[OrdenProvisionLineas]) => play.api.templates.HtmlFormat.Appendable) = (orden,buscador) => apply(orden,buscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:31 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/ordenesProvision/verListaCertificaciones.scala.html
                    HASH: f3b2b3cf0403f54512acb82442c5fdc803f53546
                    MATRIX: 878->1|1096->90|1116->102|1455->481|1488->505|1562->85|1593->418|1625->549|1879->767|1899->778|1987->843|2045->864|2060->869|2086->872|2216->966|2236->977|2339->1057|2556->1239|2599->1273|2639->1275|2773->1392|2786->1397|2825->1398|2880->1417|2897->1425|2951->1457|3553->2024|3595->2050|3635->2052|3743->2124|3753->2125|3790->2140|3901->2215|3911->2216|3949->2232|4003->2250|4013->2251|4044->2260|4098->2278|4133->2304|4181->2306|4191->2307|4231->2321|4285->2339|4295->2340|4321->2344|4375->2362|4389->2367|4444->2400|4498->2418|4512->2423|4579->2468|4633->2486|4647->2491|4737->2559|4791->2577|4805->2582|4868->2623|4929->2649|5036->2746|5076->2747|5158->2793|5211->2824|5299->2881|5362->2913|5474->2990|5488->2995|5616->3100|5666->3119
                    LINES: 26->1|33->3|33->3|41->16|41->16|42->1|44->11|46->16|50->20|50->20|50->20|50->20|50->20|50->20|51->21|51->21|51->21|56->26|56->26|56->26|61->31|61->31|61->31|62->32|62->32|62->32|80->50|80->50|80->50|82->52|82->52|82->52|83->53|83->53|83->53|84->54|84->54|84->54|85->55|85->55|85->55|85->55|85->55|86->56|86->56|86->56|87->57|87->57|87->57|88->58|88->58|88->58|89->59|89->59|89->59|90->60|90->60|90->60|92->62|92->62|92->62|93->63|93->63|94->64|97->67|101->71|101->71|101->71|103->73
                    -- GENERATED --
                */
            