
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
object informacionPorPacientes extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[OrdenLineaCliente],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[OrdenLineaCliente],formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import models.auth._

import utils._

def /*6.2*/scripts/*6.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*6.13*/("""
	<script src=""""),_display_(Seq[Any](/*7.16*/routes/*7.22*/.Assets.at("javascripts/patrimonio/ordenesProvision.js"))),format.raw/*7.78*/("""" type="text/javascript"></script>
""")))};implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.86*/("""
"""),format.raw/*5.70*/(""" 
"""),format.raw/*8.2*/("""
"""),_display_(Seq[Any](/*9.2*/views/*9.7*/.html.patrimonio.mainPatrimonio("Información de pacientes", scripts)/*9.75*/ {_display_(Seq[Any](format.raw/*9.77*/("""
<div class="page-header">
	<div class="row">
		<div class="col-sm-7">
			<h1>Información por Paciente</h1>
		</div>
		
		<div class="col-sm-5">
			<div class="dropdown pull-right">
				<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
			 		<i class="glyphicon glyphicon-list-alt"></i> Reportes<span class="caret"></span>
				</button>
				<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
					 <li role="presentation"><a role="menuitem" id="generarArchivo" 
				    data-url="" tabindex="-1" href=""""),_display_(Seq[Any](/*23.42*/controllers/*23.53*/.patrimonio.routes.OrdenesProvisionController.informacionPorPacientesExcel())),format.raw/*23.129*/("""">
				    Informe Excel</a></li>
				</ul>
			</div>
			
			 
		</div>
	</div>
</div>	
"""),_display_(Seq[Any](/*32.2*/views/*32.7*/.html.tags.successError())),format.raw/*32.32*/("""
<form action="" method="GET">
	<div class="row seccion">
		<div class="col-sm-2">
			<label class="control-label">Paciente
				<div class="input-group">
					"""),_display_(Seq[Any](/*38.7*/inputText(formBuscador("paciente_id"), 'hidden -> "hidden", 'id -> "paciente_id"))),format.raw/*38.88*/("""
					"""),_display_(Seq[Any](/*39.7*/inputText(formBuscador("paciente"), 'class -> "form-control", 'id -> "paciente"))),format.raw/*39.87*/("""
					<span class="input-group-addon"><a href="#" id="searchPaciente" data-title="Selección de pacientes" data-url=""""),_display_(Seq[Any](/*40.117*/controllers/*40.128*/.compras.routes.ClientesController.modalBuscar())),format.raw/*40.176*/("""" data-height="650" data-width="700" data-listen="modal.seleccion.cliente.simple" data-label="#paciente" data-field="#paciente_id"><i class="glyphicon glyphicon-search"></i></a></span>
				</div> 
			</label>
		</div>	
		<div class="col-sm-2">
			<label class="control-label">Proveedor
				<div class="input-group">
					"""),_display_(Seq[Any](/*47.7*/inputText(formBuscador("proveedor_id"), 'hidden -> "hidden", 'id -> "proveedor_id"))),format.raw/*47.90*/("""
					"""),_display_(Seq[Any](/*48.7*/inputText(formBuscador("proveedor_nombre"), 'name -> "", 'class -> "form-control", 'id -> "proveedor"))),format.raw/*48.109*/("""
					<span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchProveedor" 
									data-title="Selección de Proveedores" 
									data-url=""""),_display_(Seq[Any](/*53.21*/controllers/*53.32*/.compras.routes.ProveedoresController.modalBuscar())),format.raw/*53.83*/("""" 
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
			<label class="control-label">Expediente
				<div class="input-group">
					"""),_display_(Seq[Any](/*68.7*/inputText(formBuscador("expediente_id"), 'hidden -> "hidden", 'id -> "expediente_id"))),format.raw/*68.92*/("""
					"""),_display_(Seq[Any](/*69.7*/inputText(formBuscador("expediente.nombre"), 'name -> "", 'class -> "form-control", 'id -> "expediente"))),format.raw/*69.111*/("""
					<span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchExpediente" 
									data-title="Selección de expediente" 
									data-url=""""),_display_(Seq[Any](/*74.21*/controllers/*74.32*/.expediente.routes.ExpedientesController.modalBuscar())),format.raw/*74.86*/("""" 
									data-height="650" 
									data-width="700" 
									data-listen="modal.seleccion.expediente.simple" 
									data-label="#expediente" 
									data-field="#expediente_id">
							<i class="glyphicon glyphicon-search"></i>
						</a>
					</span>
				</div>
			</label>
		</div>
		<div class="col-sm-2">
				<label class="control-label">Ejercicio
					"""),_display_(Seq[Any](/*88.7*/select(formBuscador("ejercicio"), Ejercicio.getEjercicios().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*88.166*/("""
				</label>
			</div>
		<div class="col-sm-2">
			<div class="form-group">
			<label for="nombre" class="control-label">&nbsp;</label>
			<button type="submit" class="form-control btn btn-primary"><i class="glyphicon glyphicon-search"></i> Buscar</button>
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group">
			<label for="nombre" class="control-label">&nbsp;</label>
			<a href=""""),_display_(Seq[Any](/*100.14*/controllers/*100.25*/.patrimonio.routes.OrdenesProvisionController.informacionPorPacientes())),format.raw/*100.96*/(""""  class="form-control btn btn-default">Limpiar</a>
			</div>
		</div>
	</div>
</form>	

	"""),_display_(Seq[Any](/*106.3*/if(buscador.getTotalRowCount == 0)/*106.37*/ {_display_(Seq[Any](format.raw/*106.39*/("""
        
        <div class="well">
            <em>No se encuentran Informacion</em>
        </div>
        
    """)))}/*112.7*/else/*112.12*/{_display_(Seq[Any](format.raw/*112.13*/("""
    	Mostrando """),_display_(Seq[Any](/*113.17*/buscador/*113.25*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*113.57*/(""" resultado(s).   
    	<table id="listaOrdenProvision" class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th width="30">
						<input type="checkbox" name="checkAll" id="checkAll"/>
					</th>
					<th>Nombre</th>
					<th>Proveedor</th>
					<th>Exp.</th>
					<th>OP</th>
					<th>Producto</th>
					<th>Q</th>
					<th>RX</th>
					<th>A</th>
					<th>P</th>
					<th>Precio</th>
					<th>Total</th>
					 
				</tr>
			</thead>
			<tbody>
			"""),_display_(Seq[Any](/*135.5*/for(olc <- buscador.getList) yield /*135.33*/ {_display_(Seq[Any](format.raw/*135.35*/("""
				<tr>
					<td><input type="checkbox" name="check_listado[]" value=""""),_display_(Seq[Any](/*137.64*/olc/*137.67*/.id)),format.raw/*137.70*/("""" class="notSeleccion" id="check-"""),_display_(Seq[Any](/*137.104*/olc/*137.107*/.id)),format.raw/*137.110*/(""""/></td>
					<td>"""),_display_(Seq[Any](/*138.11*/(olc.cliente.nombre))),format.raw/*138.31*/("""</td>	
					<td>"""),_display_(Seq[Any](/*139.11*/(olc.ordenLinea.orden.proveedor.nombre))),format.raw/*139.50*/("""</td>
					<td>"""),_display_(Seq[Any](/*140.11*/(olc.ordenLinea.orden.expediente.getExpedienteEjercicio()))),format.raw/*140.69*/("""</td>
					<td>"""),_display_(Seq[Any](/*141.11*/if(olc.ordenLinea.orden.numero_orden_provision != null)/*141.66*/{_display_(Seq[Any](_display_(Seq[Any](/*141.68*/olc/*141.71*/.ordenLinea.orden.numero_orden_provision))))})),format.raw/*141.112*/("""</td>
					<td>"""),_display_(Seq[Any](/*142.11*/(olc.ordenLinea.producto.nombre))),format.raw/*142.43*/("""</td>
					<td>"""),_display_(Seq[Any](/*143.11*/(olc.cantidad))),format.raw/*143.25*/("""</td>	
					<td>"""),_display_(Seq[Any](/*144.11*/(olc.getTotalRecibido()))),format.raw/*144.35*/("""</td>
					<td>"""),_display_(Seq[Any](/*145.11*/(olc.getTotalAnulado()))),format.raw/*145.34*/("""</td>	
					<td>"""),_display_(Seq[Any](/*146.11*/(olc.cantidad.subtract(olc.getTotalRecibido()).subtract( olc.getTotalAnulado())))),format.raw/*146.91*/("""</td>	
					<td>"""),_display_(Seq[Any](/*147.11*/utils/*147.16*/.NumberUtils.moneda(olc.ordenLinea.precio))),format.raw/*147.58*/("""</td>
					<td>"""),_display_(Seq[Any](/*148.11*/(utils.NumberUtils.moneda(olc.ordenLinea.precio.multiply(olc.cantidad), 2)))),format.raw/*148.86*/("""</td>
					 
				</tr>
			""")))})),format.raw/*151.5*/("""		
			</tbody>
			</table>
			<div class="pagination pull-right">
		    	"""),_display_(Seq[Any](/*155.9*/views/*155.14*/.html.helpers.paginador(buscador, controllers.patrimonio.routes.OrdenesProvisionController.informacionPorPacientes()))),format.raw/*155.131*/("""
			</div>
    """)))})),format.raw/*157.6*/("""
""")))})),format.raw/*158.2*/("""

<script>
$( function() """),format.raw/*161.15*/("""{"""),format.raw/*161.16*/("""
	$('#searchPaciente').modalSearch();
	var baseUrl = $('#generarArchivo').attr('href')
	$('#generarArchivo').attr('href', baseUrl + '?descarga=&' + window.location.href.slice(window.location.href.indexOf('?') + 1))
"""),format.raw/*165.1*/("""}"""),format.raw/*165.2*/(""")
</script>
"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[OrdenLineaCliente],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[OrdenLineaCliente],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:31 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/ordenesProvision/informacionPorPacientes.scala.html
                    HASH: 675bfca5e353050ba4f57e524aeb92903850ae45
                    MATRIX: 872->1|1087->213|1101->220|1185->224|1236->240|1250->246|1327->302|1394->142|1426->166|1500->85|1528->210|1556->338|1592->340|1604->345|1680->413|1719->415|2333->993|2353->1004|2452->1080|2576->1169|2589->1174|2636->1199|2831->1359|2934->1440|2976->1447|3078->1527|3232->1644|3253->1655|3324->1703|3681->2025|3786->2108|3828->2115|3953->2217|4165->2393|4185->2404|4258->2455|4689->2851|4796->2936|4838->2943|4965->3047|5177->3223|5197->3234|5273->3288|5677->3657|5859->3816|6299->4219|6320->4230|6414->4301|6541->4392|6585->4426|6626->4428|6761->4545|6775->4550|6815->4551|6869->4568|6887->4576|6942->4608|7456->5086|7501->5114|7542->5116|7652->5189|7665->5192|7691->5195|7763->5229|7777->5232|7804->5235|7860->5254|7903->5274|7957->5291|8019->5330|8072->5346|8153->5404|8206->5420|8271->5475|8320->5477|8333->5480|8402->5521|8455->5537|8510->5569|8563->5585|8600->5599|8654->5616|8701->5640|8754->5656|8800->5679|8854->5696|8957->5776|9011->5793|9026->5798|9091->5840|9144->5856|9242->5931|9301->5958|9411->6032|9426->6037|9567->6154|9615->6170|9649->6172|9703->6197|9733->6198|9976->6413|10005->6414
                    LINES: 26->1|33->6|33->6|35->6|36->7|36->7|36->7|37->5|37->5|38->1|39->5|40->8|41->9|41->9|41->9|41->9|55->23|55->23|55->23|64->32|64->32|64->32|70->38|70->38|71->39|71->39|72->40|72->40|72->40|79->47|79->47|80->48|80->48|85->53|85->53|85->53|100->68|100->68|101->69|101->69|106->74|106->74|106->74|120->88|120->88|132->100|132->100|132->100|138->106|138->106|138->106|144->112|144->112|144->112|145->113|145->113|145->113|167->135|167->135|167->135|169->137|169->137|169->137|169->137|169->137|169->137|170->138|170->138|171->139|171->139|172->140|172->140|173->141|173->141|173->141|173->141|173->141|174->142|174->142|175->143|175->143|176->144|176->144|177->145|177->145|178->146|178->146|179->147|179->147|179->147|180->148|180->148|183->151|187->155|187->155|187->155|189->157|190->158|193->161|193->161|197->165|197->165
                    -- GENERATED --
                */
            