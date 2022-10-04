
package views.html.contabilidad.facturas

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
object vistaFacturasCargadas extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[utils.pagination.Pagination[FacturaDato],DynamicForm,utils.pagination.PaginadorFicha,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[FacturaDato], formBuscador: DynamicForm, paginadorFicha: utils.pagination.PaginadorFicha):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

def /*6.2*/scripts/*6.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*6.13*/("""
	<script src=""""),_display_(Seq[Any](/*7.16*/routes/*7.22*/.Assets.at("javascripts/contabilidad/facturas.js"))),format.raw/*7.72*/("""" type="text/javascript"></script>
""")))};implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.130*/("""
"""),format.raw/*5.70*/(""" 
"""),format.raw/*8.2*/("""

"""),_display_(Seq[Any](/*10.2*/views/*10.7*/.html.contabilidad.mainContabilidad("Vista de facturas cargadas", scripts)/*10.81*/ {_display_(Seq[Any](format.raw/*10.83*/("""

<div class="page-header">
	<div class="row">
		<div class="col-sm-7"><h1>Vista de facturas cargadas</h1></div>
		<div class="col-sm-5">
			<div class="dropdown pull-right">
				<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown"> <i class="glyphicon glyphicon-list-alt"></i> Reportes <span class="caret"></span></button>

				<ul class="dropdown-menu">
					<li><a id="reporteFacturasCargadas" href="#" data-url=""""),_display_(Seq[Any](/*20.62*/controllers/*20.73*/.contabilidad.routes.FacturasReportesController.reporteFacturasCargadas())),format.raw/*20.146*/("""">Reporte</a></li>
				</ul>
			</div>
			<div class="dropdown pull-right btn-header">
			</div>
		</div>
	</div>
</div>

	"""),_display_(Seq[Any](/*29.3*/views/*29.8*/.html.tags.successError())),format.raw/*29.33*/("""
	<div id="actions">
		<form action="" id="formSearchFacturas" method="GET">
			<div class="row" >
			
				<div class="col-sm-2">
					<label class="control-label">Expediente</label>
					<div class="input-group">
						"""),_display_(Seq[Any](/*37.8*/inputText(formBuscador("expediente.nombre"), 'name -> "", 'class -> "form-control", 'id -> "expediente"))),format.raw/*37.112*/("""
						"""),_display_(Seq[Any](/*38.8*/inputText(formBuscador("expediente.id"), 'hidden -> "hidden", 'id -> "expediente_id"))),format.raw/*38.93*/("""
						<span class="input-group-addon">
							<a href="#" class="searchModal"
										id="searchExpediente" 
										data-title="Selección de expediente" 
										data-url=""""),_display_(Seq[Any](/*43.22*/controllers/*43.33*/.expediente.routes.ExpedientesController.modalBuscar())),format.raw/*43.87*/("""" 
										data-height="650" 
										data-width="700" 
										data-listen="modal.seleccion.expediente.simple" 
										data-label="#expediente" 
										data-field="#expediente_id">
								<i class="glyphicon glyphicon-search"></i>
							</a>
						</span>
					</div>
				</div>	
				<div class="col-sm-2">
					<label class="control-label">Proveedores
						<div class="input-group">
							"""),_display_(Seq[Any](/*57.9*/inputText(formBuscador("proveedor.nombre"), 'name -> "", 'class -> "form-control", 'id -> "proveedor"))),format.raw/*57.111*/("""
							"""),_display_(Seq[Any](/*58.9*/inputText(formBuscador("proveedor.id"), 'hidden -> "hidden", 'id -> "proveedor_id"))),format.raw/*58.92*/("""
							<span class="input-group-addon">
								<a href="#" class="searchModal"
											id="searchProveedor" 
											data-title="Selección de Proveedores" 
											data-url=""""),_display_(Seq[Any](/*63.23*/controllers/*63.34*/.compras.routes.ProveedoresController.modalBuscar())),format.raw/*63.85*/("""" 
											data-height="650" 
											data-width="700" 
											data-listen="modal.seleccion.proveedor.simple" 
											data-label="#proveedor" 
											data-field="#proveedor_id">
									<i class="glyphicon glyphicon-search"></i>
								</a>
							</span>
						</div>
					</label>
				</div>
				<div class="col-sm-2">
				<label for="orden_pago_id" class="control-label">Orden de pago N° 
					<div class="input-group">
						"""),_display_(Seq[Any](/*78.8*/inputText(formBuscador("ordenPago.numero"), 'class -> "form-control", 'id -> "orden_pago"))),format.raw/*78.98*/("""
						"""),_display_(Seq[Any](/*79.8*/inputText(formBuscador("ordenPago.id"),'hidden -> "hidden", 'id -> "orden_pago_id"))),format.raw/*79.91*/("""
						<span class="input-group-addon">
							<a href="#" class="searchModal"
										id="searchOp" 
										data-title="Selección de órdenes de pago" 
										data-url=""""),_display_(Seq[Any](/*84.22*/controllers/*84.33*/.contabilidad.routes.OrdenesPagosController.modalBuscar())),format.raw/*84.90*/("""" 
										data-height="650" 
										data-width="700" 
										data-listen="modal.seleccion.orden-pago.simple" 
										data-label="#orden_pago" 
										data-field="#orden_pago_id">
								<i class="glyphicon glyphicon-search"></i>
							</a>
						</span>
					</div>
				</label>
				</div>
				<div class="col-sm-2">
					<div class="form-group">
					<label for="nombre" class="control-label">&nbsp;</label>
					<button  class="form-control btn btn-primary"><i class="glyphicon glyphicon-search"></i> Buscar</button>
					</div>
				</div>
				<div class="col-sm-2">
					<div class="form-group">
					<label for="nombre" class="control-label">&nbsp;</label>
					<a href=""""),_display_(Seq[Any](/*105.16*/controllers/*105.27*/.contabilidad.routes.FacturasController.index())),format.raw/*105.74*/(""""  class="form-control btn btn-default">Limpiar</a>
					</div>
				</div>
			</div>
		</form>
	</div>	
	<form  id="tabla">
		<table id="listaFacturas" class="table table-bordered">
			<thead>
				 <tr style="background: #FFFFFF;"><td colspan="6">Mostrando """),_display_(Seq[Any](/*114.66*/buscador/*114.74*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*114.106*/(""" resultado(s). </td></tr>
				 <tr>
				 	<th width="50"><input type="checkbox" name="checkAll" id="checkAll"/></th>
				 	<th>Proveedor</th>
				 	<th>Expediente</th>
				 	<th>OP</th>
				 	<th>N° Factura</th>
				 	<th>Fecha Pago</th>
				 	<th>Monto Orden Pago</th>
				 	<th>Monto OP</th>
				 	<th>Monto F/C</th>
				 	<th>Monto</th>
				 </tr>
			</thead>
			<tbody>
				
			"""),_display_(Seq[Any](/*130.5*/for(f <- buscador.getList) yield /*130.31*/ {_display_(Seq[Any](format.raw/*130.33*/("""
				"""),_display_(Seq[Any](/*131.6*/paginadorFicha/*131.20*/.add(f.id.toString))),format.raw/*131.39*/("""
				
				<tr data-estado="" data-href="">
					<td><input type="checkbox" name="check_listado[]" value=""""),_display_(Seq[Any](/*134.64*/f/*134.65*/.id)),format.raw/*134.68*/("""" class="notSeleccion" id="check-"""),_display_(Seq[Any](/*134.102*/f/*134.103*/.id)),format.raw/*134.106*/(""""/></td>		
					<td>"""),_display_(Seq[Any](/*135.11*/if(f.factura.proveedor != null)/*135.42*/{_display_(Seq[Any](_display_(Seq[Any](/*135.44*/(f.factura.proveedor.nombre)))))})),format.raw/*135.73*/("""</td>
					<td>"""),_display_(Seq[Any](/*136.11*/if(f.factura.expediente != null)/*136.43*/{_display_(Seq[Any](_display_(Seq[Any](/*136.45*/(f.factura.expediente.getExpedienteEjercicio())))))})),format.raw/*136.93*/("""</td>	
					<td>"""),_display_(Seq[Any](/*137.11*/if(f.factura.ordenPago != null)/*137.42*/{_display_(Seq[Any](_display_(Seq[Any](/*137.44*/(f.factura.ordenPago.getNombreCompleto())))))})),format.raw/*137.86*/("""</td>	
					<td>"""),_display_(Seq[Any](/*138.11*/if(f.numero_factura != null)/*138.39*/{_display_(Seq[Any](_display_(Seq[Any](/*138.41*/(f.numero_factura)))))})),format.raw/*138.60*/("""</td>	
					<td>"""),_display_(Seq[Any](/*139.11*/if(f.factura.fecha_pago != null)/*139.43*/{_display_(Seq[Any](_display_(Seq[Any](/*139.45*/(utils.DateUtils.formatDate(f.factura.fecha_pago))))))})),format.raw/*139.96*/("""</td>		
					<td>"""),_display_(Seq[Any](/*140.11*/(utils.NumberUtils.moneda(Factura.getTotalPorOp(f.factura.orden_pago_id))))),format.raw/*140.85*/("""</td>
					<td>"""),_display_(Seq[Any](/*141.11*/(utils.NumberUtils.moneda(f.factura.orden.getTotalTotal())))),format.raw/*141.70*/("""</td>
					<td>"""),_display_(Seq[Any](/*142.11*/(utils.NumberUtils.moneda(Factura.getTotalMontoFacturasCargadas(f.factura.id))))),format.raw/*142.90*/("""</td>
					<td>"""),_display_(Seq[Any](/*143.11*/(utils.NumberUtils.moneda(f.getMonto())))),format.raw/*143.51*/("""</td>
				</tr>
             """)))})),format.raw/*145.15*/("""
             """),_display_(Seq[Any](/*146.15*/paginadorFicha/*146.29*/.guardar())),format.raw/*146.39*/("""
	        </tbody>
	        <tfoot>
	        	<tr>
	        		<td colspan="6">Mostrando """),_display_(Seq[Any](/*150.39*/buscador/*150.47*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*150.79*/(""" resultado(s).</td>
	        	</tr>
	        </tfoot>
        </table>
	</form>
		<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*156.8*/views/*156.13*/.html.helpers.paginador(buscador, controllers.contabilidad.routes.FacturasController.vistaFacturasCargadas()))),format.raw/*156.122*/("""
		</div>
""")))})),format.raw/*158.2*/("""		
"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[FacturaDato],formBuscador:DynamicForm,paginadorFicha:utils.pagination.PaginadorFicha): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador,paginadorFicha)
    
    def f:((utils.pagination.Pagination[FacturaDato],DynamicForm,utils.pagination.PaginadorFicha) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador,paginadorFicha) => apply(buscador,formBuscador,paginadorFicha)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:40 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/facturas/vistaFacturasCargadas.scala.html
                    HASH: d03e0488d9eb730428ebf7dac92efb9deb782377
                    MATRIX: 890->1|1149->257|1163->264|1247->268|1298->284|1312->290|1383->340|1450->186|1482->210|1557->129|1585->254|1613->376|1651->379|1664->384|1747->458|1787->460|2272->909|2292->920|2388->993|2547->1117|2560->1122|2607->1147|2863->1368|2990->1472|3033->1480|3140->1565|3357->1746|3377->1757|3453->1811|3896->2219|4021->2321|4065->2330|4170->2413|4392->2599|4412->2610|4485->2661|4970->3111|5082->3201|5125->3209|5230->3292|5444->3470|5464->3481|5543->3538|6273->4231|6294->4242|6364->4289|6659->4547|6677->4555|6733->4587|7152->4970|7195->4996|7236->4998|7278->5004|7302->5018|7344->5037|7487->5143|7498->5144|7524->5147|7596->5181|7608->5182|7635->5185|7693->5206|7734->5237|7783->5239|7839->5268|7892->5284|7934->5316|7983->5318|8058->5366|8112->5383|8153->5414|8202->5416|8271->5458|8325->5475|8363->5503|8412->5505|8458->5524|8512->5541|8554->5573|8603->5575|8681->5626|8736->5644|8833->5718|8886->5734|8968->5793|9021->5809|9123->5888|9176->5904|9239->5944|9302->5974|9354->5989|9378->6003|9411->6013|9537->6102|9555->6110|9610->6142|9771->6267|9786->6272|9919->6381|9962->6392
                    LINES: 26->1|33->6|33->6|35->6|36->7|36->7|36->7|37->5|37->5|38->1|39->5|40->8|42->10|42->10|42->10|42->10|52->20|52->20|52->20|61->29|61->29|61->29|69->37|69->37|70->38|70->38|75->43|75->43|75->43|89->57|89->57|90->58|90->58|95->63|95->63|95->63|110->78|110->78|111->79|111->79|116->84|116->84|116->84|137->105|137->105|137->105|146->114|146->114|146->114|162->130|162->130|162->130|163->131|163->131|163->131|166->134|166->134|166->134|166->134|166->134|166->134|167->135|167->135|167->135|167->135|168->136|168->136|168->136|168->136|169->137|169->137|169->137|169->137|170->138|170->138|170->138|170->138|171->139|171->139|171->139|171->139|172->140|172->140|173->141|173->141|174->142|174->142|175->143|175->143|177->145|178->146|178->146|178->146|182->150|182->150|182->150|188->156|188->156|188->156|190->158
                    -- GENERATED --
                */
            