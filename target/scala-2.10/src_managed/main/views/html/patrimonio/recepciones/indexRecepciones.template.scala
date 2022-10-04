
package views.html.patrimonio.recepciones

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
object indexRecepciones extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[utils.pagination.Pagination[Recepcion],DynamicForm,utils.pagination.PaginadorFicha,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[Recepcion], formBuscador: DynamicForm, paginadorFicha: utils.pagination.PaginadorFicha):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import models.auth._

import utils._

import java.math.BigDecimal;var total=new java.math.BigDecimal(0);

def /*7.2*/scripts/*7.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*7.13*/("""
	<script src=""""),_display_(Seq[Any](/*8.16*/routes/*8.22*/.Assets.at("javascripts/patrimonio/recepciones.js"))),format.raw/*8.73*/("""" type="text/javascript"></script>
	<script src=""""),_display_(Seq[Any](/*9.16*/routes/*9.22*/.Assets.at("javascripts/patrimonio/actasRecepcion.js"))),format.raw/*9.76*/("""" type="text/javascript"></script>
""")))};implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};def /*12.2*/getPediente/*12.13*/(orden:OrdenProvision) = {{
	
	var total:java.math.BigDecimal = new java.math.BigDecimal(0)
	var totalRecepcionado:java.math.BigDecimal = new java.math.BigDecimal(0)
	var ret:java.math.BigDecimal = new java.math.BigDecimal(0)
	
	if(orden != null && orden.ordenCompra != null && orden.ordenCompra.getTotalTotal() != null){
		total = orden.ordenCompra.getTotalTotal()
	}
	
	if(orden != null && orden.getTotalRecepcionado() != null){
		totalRecepcionado = orden.getTotalRecepcionado()
	}
	
	ret = total.subtract(totalRecepcionado)
	
	ret 
}};
Seq[Any](format.raw/*1.128*/("""
"""),format.raw/*5.70*/("""
"""),format.raw/*10.2*/("""

"""),format.raw/*29.2*/("""
 
"""),_display_(Seq[Any](/*31.2*/views/*31.7*/.html.patrimonio.mainPatrimonio("Lista Recepciones", scripts)/*31.68*/ {_display_(Seq[Any](format.raw/*31.70*/("""


	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Lista de recepciones</h1>
			</div>
			
			<div class="col-sm-5">
				<div class="dropdown pull-right">
					<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 		<i class="glyphicon glyphicon-list-alt"></i> Reportes<span class="caret"></span>
					</button>
					<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
						<li><a id="reporteDatosRecepciones" href="#" data-url=""""),_display_(Seq[Any](/*46.63*/controllers/*46.74*/.patrimonio.routes.RecepcionesReportesController.reporteDatosRecepciones())),format.raw/*46.148*/("""">Lista Datos</a></li>	
						<li><a id="reporteLineasRecepciones" href="#" data-url=""""),_display_(Seq[Any](/*47.64*/controllers/*47.75*/.patrimonio.routes.RecepcionesReportesController.reporteLineasRecepciones())),format.raw/*47.150*/("""">Lista Datos Exportacion Rismi</a></li>
					</ul>
				</div>
				
				<div class="dropdown pull-right btn-header">
				
					<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 	<i class="glyphicon glyphicon-cog"></i>	Acciones	<span class="caret"></span>
					</button>
						<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
					 		"""),_display_(Seq[Any](/*57.10*/if(Permiso.check("actaRecepcionCrear"))/*57.49*/ {_display_(Seq[Any](format.raw/*57.51*/("""
					 		<li role="presentation"><a id="accionCrearActaRecepcion" href="#" data-url=""""),_display_(Seq[Any](/*58.86*/controllers/*58.97*/.patrimonio.routes.ActasRecepcionAccionesController.crear())),format.raw/*58.156*/("""" role="menuitem" tabindex="-1">Crear acta de rececpción</a></li>
					 		""")))})),format.raw/*59.10*/("""
					 		"""),_display_(Seq[Any](/*60.10*/if(Permiso.check("actaRecepcionRevocar"))/*60.51*/ {_display_(Seq[Any](format.raw/*60.53*/("""
					 		<li role="presentation"><a id="revocarActaRecepcion" href="#" data-url=""""),_display_(Seq[Any](/*61.82*/controllers/*61.93*/.patrimonio.routes.ActasRecepcionAccionesController.revocar())),format.raw/*61.154*/("""" role="menuitem" tabindex="-1">Revocar acta de rececpción</a></li>
					 		""")))})),format.raw/*62.10*/("""
					 		"""),_display_(Seq[Any](/*63.10*/if(Permiso.check("actaRecepcionAsignar"))/*63.51*/ {_display_(Seq[Any](format.raw/*63.53*/("""
					 		<li role="presentation"><a id="accionAsignarActaRecepcion" href="#" data-url=""""),_display_(Seq[Any](/*64.88*/controllers/*64.99*/.patrimonio.routes.ActasRecepcionAccionesController.modalAsignar())),format.raw/*64.165*/("""" role="menuitem" tabindex="-1">Asignar acta de rececpción</a></li>
					 		""")))})),format.raw/*65.10*/("""
						</ul>
				</div>
			</div>
			
			
		</div>
	</div>


	"""),_display_(Seq[Any](/*75.3*/views/*75.8*/.html.tags.successError())),format.raw/*75.33*/("""

"""),_display_(Seq[Any](/*77.2*/helper/*77.8*/.form(action = controllers.patrimonio.routes.RecepcionesController.index(), 'id -> "buscadorRecepciones", 'autofocus -> "autofocus")/*77.140*/ {_display_(Seq[Any](format.raw/*77.142*/("""

<div class="row">		
	<div class="col-sm-3">
		<div class="row">
			<div class="form-group col-sm-6">
				<label for="nombre" class="control-label">Número</label>
				"""),_display_(Seq[Any](/*84.6*/inputText(formBuscador("numero"), 'class -> "form-control"))),format.raw/*84.65*/("""
				
			</div>
			<div class="form-group col-sm-6">
				<label for="nombre" class="control-label">Orden provisión</label>
				"""),_display_(Seq[Any](/*89.6*/inputText(formBuscador("orden_provision"), 'class -> "form-control"))),format.raw/*89.74*/("""
				
			</div>
		</div>
	</div>

	<div class="col-sm-3">
		<div class="row">
			<div class="form-group col-sm-6">
				<label for="nombre" class="control-label">Remito</label>
				"""),_display_(Seq[Any](/*99.6*/inputText(formBuscador("remito"), 'class -> "form-control"))),format.raw/*99.65*/("""
				
			</div>
			
			<div class="form-group col-sm-6">
				<label for="nombre" class="control-label">Acta</label>
				"""),_display_(Seq[Any](/*105.6*/inputText(formBuscador("acta"), 'class -> "form-control"))),format.raw/*105.63*/("""
				
			</div>
		</div>
	</div>
	<div class="col-sm-2 input-group">
		<label class="control-label">Fecha</label>
		<div>
			"""),_display_(Seq[Any](/*113.5*/inputText(formBuscador("fecha_desde"), 'class -> "form-control inputDateMascara", 'id -> "desde", 'placeholder -> "Desde"))),format.raw/*113.127*/("""
			"""),_display_(Seq[Any](/*114.5*/inputText(formBuscador("fecha_hasta"), 'class -> "form-control inputDateMascara", 'id -> "hasta", 'placeholder -> "Hasta"))),format.raw/*114.127*/("""
		</div>
	</div>
	<div class="col-sm-2 input-group">
		<label class="control-label">Fecha Provision</label>
		<div>
			"""),_display_(Seq[Any](/*120.5*/inputText(formBuscador("fecha_provision_desde"), 'class -> "form-control inputDateMascara", 'id -> "desde", 'placeholder -> "Desde"))),format.raw/*120.137*/("""
			"""),_display_(Seq[Any](/*121.5*/inputText(formBuscador("fecha_provision_hasta"), 'class -> "form-control inputDateMascara", 'id -> "hasta", 'placeholder -> "Hasta"))),format.raw/*121.137*/("""
		</div>
	</div>
	
		<div class="col-sm-2">
			<label class="control-label">Expediente
				<div class="input-group">
					"""),_display_(Seq[Any](/*128.7*/inputText(formBuscador("expediente_id"), 'hidden -> "hidden", 'id -> "expediente_id"))),format.raw/*128.92*/("""
					"""),_display_(Seq[Any](/*129.7*/inputText(formBuscador("expediente.nombre"), 'name -> "", 'class -> "form-control", 'id -> "expediente"))),format.raw/*129.111*/("""
					<span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchExpediente" 
									data-title="Selección de expediente" 
									data-url=""""),_display_(Seq[Any](/*134.21*/controllers/*134.32*/.expediente.routes.ExpedientesController.modalBuscar())),format.raw/*134.86*/("""" 
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
	
	
	
</div>
<div class="row">

<div class="col-sm-2">
		<label class="control-label">Proveedor
			<div class="input-group">
				"""),_display_(Seq[Any](/*155.6*/inputText(formBuscador("proveedor_id"), 'hidden -> "hidden", 'id -> "proveedor_id"))),format.raw/*155.89*/("""
				"""),_display_(Seq[Any](/*156.6*/inputText(formBuscador("proveedor_nombre"), 'name -> "", 'class -> "form-control", 'id -> "proveedor"))),format.raw/*156.108*/("""
				<span class="input-group-addon">
					<a href="#" class="searchModal"
								id="searchProveedorActa" 
								data-title="Selección de Proveedores" 
								data-url=""""),_display_(Seq[Any](/*161.20*/controllers/*161.31*/.compras.routes.ProveedoresController.modalBuscar())),format.raw/*161.82*/("""" 
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
		<label class="control-label">Responsable
			<div class="input-group">
				"""),_display_(Seq[Any](/*177.6*/inputText(formBuscador("create_usuario.nombre"), 'name -> "", 'class -> "form-control", 'id -> "create_usuario"))),format.raw/*177.118*/("""
				"""),_display_(Seq[Any](/*178.6*/inputText(formBuscador("responsable_id"), 'hidden -> "hidden", 'id -> "create_usuario_id"))),format.raw/*178.96*/("""
				<span class="input-group-addon">
					<a href="#" class="searchModal"
								id="searchResponsable" 
								data-title="Selección de responsables" 
								data-url=""""),_display_(Seq[Any](/*183.20*/controllers/*183.31*/.administracion.routes.UsuariosController.modalBuscar())),format.raw/*183.86*/("""" 
								data-height="650" 
								data-width="700" 
								data-listen="modal.seleccion.usuario.simple" 
								data-label="#create_usuario" 
								data-field="#create_usuario_id">
						<i class="glyphicon glyphicon-search"></i>
					</a>
				</span>
				
			</div>
		</label>
	</div>

	<div class="col-sm-2">
		<label class="control-label">Con Acta</label>
			"""),_display_(Seq[Any](/*199.5*/select(formBuscador("conacta"),options(""->"Todos","si"->"SI","no"->"NO"), 'class -> "form-control select"))),format.raw/*199.112*/("""
	</div>
	
	<div class="col-sm-2">
		<label class="control-label">Tipo Cuenta</label>
			"""),_display_(Seq[Any](/*204.5*/select(formBuscador("tipo_cuenta_id"), 
			TipoCuenta.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*205.125*/("""
	</div>
	<div class="col-sm-2">
		<div class="checkbox">
			<label class="control-label">Moneda Extrajera</label> 
				"""),_display_(Seq[Any](/*210.6*/checkbox(formBuscador("tipo_moneda")))),format.raw/*210.43*/("""
		</div> 
	</div>
	<div class="col-sm-2">
		<label for="deposito" class="control-label">Institucion</label> 
		<div class="input-group">
			"""),_display_(Seq[Any](/*216.5*/inputText(formBuscador("deposito.nombre"),'class -> "form-control", 'id -> "deposito_nombre", 'autocomplete -> "off"))),format.raw/*216.122*/("""
			"""),_display_(Seq[Any](/*217.5*/inputText(formBuscador("deposito_id"),'hidden -> "hidden", 'id -> "deposito_id"))),format.raw/*217.85*/("""
			<span class="input-group-addon">
               	<a href="#" id="searchDeposito" data-title="Selección de Institucion" 
               	data-url=""""),_display_(Seq[Any](/*220.28*/controllers/*220.39*/.delegacion.routes.DepositosController.modalBuscar())),format.raw/*220.91*/("""" 
               	data-height="650" data-width="700" 
               	data-listen="modal.seleccion.deposito.simple" 
               	data-label="#deposito_nombre" data-field="#deposito_id" /> <i class="glyphicon glyphicon-search"></i></a>
               </span>
		</div>
	</div>
</div>	
<div class="row">
	<div class="col-sm-2">
		<label class="control-label">Rubro
		"""),_display_(Seq[Any](/*231.4*/select(formBuscador("orden_rubro_id"), 
		OrdenRubro.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*232.124*/("""
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
		<a href=""""),_display_(Seq[Any](/*246.13*/controllers/*246.24*/.patrimonio.routes.RecepcionesController.index())),format.raw/*246.72*/(""""  class="form-control btn btn-default">Limpiar</a>
		</div>
	</div>
</div>	

""")))})),format.raw/*251.2*/("""

   """),_display_(Seq[Any](/*253.5*/if(buscador.getTotalRowCount == 0)/*253.39*/ {_display_(Seq[Any](format.raw/*253.41*/("""
        
       <div class="well">
           <em>No se encuentran órdenes de recepción</em>
       </div>
        
    """)))}/*259.7*/else/*259.12*/{_display_(Seq[Any](format.raw/*259.13*/("""
		
		Mostrando """),_display_(Seq[Any](/*261.14*/buscador/*261.22*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*261.54*/(""" resultado(s).   
		<table id="listaRecepciones" class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th width="30"><input type="checkbox" id="checkAll" class="check_all" data-check=".check_recepcion" /></th>
					<th>N°</th>
					<th>OP</th>
					<th>Institucion</th>
					<th>Fecha Provision</th>
					<th>Acta</th>
					<th width="100">Total</th>
					<th width="100">Pendiente OP</th>
					<th>Proveedor</th>
					<th width="80">Fecha</th>
					<th>Exp.</th>
					<th width="50">Remitos</th>
				</tr>
			</thead>
			<tbody>
		        """),_display_(Seq[Any](/*280.12*/for(recepcion <- buscador.getList) yield /*280.46*/ {_display_(Seq[Any](format.raw/*280.48*/("""
		        	"""),_display_(Seq[Any](/*281.13*/paginadorFicha/*281.27*/.add(recepcion.id.toString))),format.raw/*281.54*/("""
					<tr class="pointer" data-href=""""),_display_(Seq[Any](/*282.38*/controllers/*282.49*/.patrimonio.routes.RecepcionesController.ver(recepcion.id))),format.raw/*282.107*/("""&"""),_display_(Seq[Any](/*282.109*/UriTrack/*282.117*/.encode())),format.raw/*282.126*/("""">
						<td><input name="check_listado[]" value=""""),_display_(Seq[Any](/*283.49*/recepcion/*283.58*/.id)),format.raw/*283.61*/("""" type="checkbox" class="check_recepcion notSeleccion" /></td>
						<td>"""),_display_(Seq[Any](/*284.12*/(recepcion.numero))),format.raw/*284.30*/("""</td>
						<td>"""),_display_(Seq[Any](/*285.12*/(recepcion.ordenProvision.numero))),format.raw/*285.45*/(""" """),_display_(Seq[Any](/*285.47*/if(recepcion.ordenProvision.ordenCompra.tipo_moneda != null)/*285.107*/{_display_(Seq[Any](format.raw/*285.108*/("""- <span style="color:green;font-weight:bold;font-size: 12px;">M.E.</span>""")))})),format.raw/*285.182*/("""</td>
						<td>"""),_display_(Seq[Any](/*286.12*/(recepcion.ordenProvision.ordenCompra.deposito.nombre))),format.raw/*286.66*/("""</td>
						<td>"""),_display_(Seq[Any](/*287.12*/(DateUtils.formatDate(recepcion.ordenProvision.ordenCompra.fecha_provision)))),format.raw/*287.88*/("""</td>
						<td>"""),_display_(Seq[Any](/*288.12*/(if(recepcion.acta != null) {recepcion.acta.numero}))),format.raw/*288.64*/("""</td>
						<td class="total" data-valor=""""),_display_(Seq[Any](/*289.38*/recepcion/*289.47*/.total)),format.raw/*289.53*/("""">"""),_display_(Seq[Any](/*289.56*/(utils.NumberUtils.moneda(recepcion.getTotal())))),format.raw/*289.104*/("""</td>
						<td class="" data-valor="">"""),_display_(Seq[Any](/*290.35*/(utils.NumberUtils.moneda(recepcion.ordenProvision.getPendiente())))),format.raw/*290.102*/("""</td>
						<td>"""),_display_(Seq[Any](/*291.12*/(recepcion.ordenProvision.ordenCompra.proveedor.nombre))),format.raw/*291.67*/("""</td>
						<td>"""),_display_(Seq[Any](/*292.12*/(DateUtils.formatDate(recepcion.create_date)))),format.raw/*292.57*/("""</td>
						<td>"""),_display_(Seq[Any](/*293.12*/recepcion/*293.21*/.ordenProvision.ordenCompra.expediente.getExpedienteEjercicio())),format.raw/*293.84*/("""</td>
						<td>"""),_display_(Seq[Any](/*294.12*/recepcion/*294.21*/.cantidadRemitos)),format.raw/*294.37*/("""</td> 
					</tr>
					"""),_display_(Seq[Any](/*296.7*/{total = total.add(recepcion.getTotal())})),format.raw/*296.48*/(""" 
              	""")))})),format.raw/*297.17*/("""
              	"""),_display_(Seq[Any](/*298.17*/paginadorFicha/*298.31*/.guardar())),format.raw/*298.41*/(""" 
			</tbody>
			<tfoot>
				<td colspan="5"></td>
				<td align="right">TOTALES:</td>
				<td class="totalfooter">"""),_display_(Seq[Any](/*303.30*/utils/*303.35*/.NumberUtils.moneda(total))),format.raw/*303.61*/("""</td>
				<td colspan="3"></td>
			</tfoot>
		</table>
		
		<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*309.8*/views/*309.13*/.html.helpers.paginador(buscador, controllers.patrimonio.routes.RecepcionesController.index()))),format.raw/*309.107*/("""
		</div>
        
    """)))})),format.raw/*312.6*/("""
""")))})),format.raw/*313.2*/("""
<script>
$( function() """),format.raw/*315.15*/("""{"""),format.raw/*315.16*/("""
	 
	
	var trs = $('#listaRecepciones tbody tr');
	 
	
	$('#checkAll').click( function() """),format.raw/*321.35*/("""{"""),format.raw/*321.36*/("""
		sumarFilas(trs);
	"""),format.raw/*323.2*/("""}"""),format.raw/*323.3*/(""");
	
	$('input[name="check_listado[]"]').click( function() """),format.raw/*325.55*/("""{"""),format.raw/*325.56*/("""
		sumarFilas( $('#listaRecepciones tbody tr:has(td:eq(0):has(input:checked))') );
	"""),format.raw/*327.2*/("""}"""),format.raw/*327.3*/(""");
	
	function sumarFilas(trs) """),format.raw/*329.27*/("""{"""),format.raw/*329.28*/("""
		var total = 0;  
		trs.each( function() """),format.raw/*331.24*/("""{"""),format.raw/*331.25*/("""
			total += Number($('.total',this).attr("data-valor"));
		"""),format.raw/*333.3*/("""}"""),format.raw/*333.4*/(""");
		
		$(".totalfooter").html(formatNumberPesos(parseFloat(total).toFixed(2)));
	"""),format.raw/*336.2*/("""}"""),format.raw/*336.3*/("""

"""),format.raw/*338.1*/("""}"""),format.raw/*338.2*/(""")
</script>
"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[Recepcion],formBuscador:DynamicForm,paginadorFicha:utils.pagination.PaginadorFicha): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador,paginadorFicha)
    
    def f:((utils.pagination.Pagination[Recepcion],DynamicForm,utils.pagination.PaginadorFicha) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador,paginadorFicha) => apply(buscador,formBuscador,paginadorFicha)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:31 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/recepciones/indexRecepciones.scala.html
                    HASH: 8649ef8ffc58bf45400a89e3fe610a2f6246724d
                    MATRIX: 884->1|1209->322|1223->329|1307->333|1358->349|1372->355|1444->406|1529->456|1543->462|1618->516|1685->184|1717->208|1775->555|1795->566|2363->127|2391->252|2419->552|2448->1103|2487->1107|2500->1112|2570->1173|2610->1175|3185->1714|3205->1725|3302->1799|3425->1886|3445->1897|3543->1972|3995->2388|4043->2427|4083->2429|4205->2515|4225->2526|4307->2585|4414->2660|4460->2670|4510->2711|4550->2713|4668->2795|4688->2806|4772->2867|4881->2944|4927->2954|4977->2995|5017->2997|5141->3085|5161->3096|5250->3162|5359->3239|5457->3302|5470->3307|5517->3332|5555->3335|5569->3341|5711->3473|5752->3475|5956->3644|6037->3703|6200->3831|6290->3899|6506->4080|6587->4139|6744->4260|6824->4317|6986->4443|7132->4565|7173->4570|7319->4692|7476->4813|7632->4945|7673->4950|7829->5082|7989->5206|8097->5291|8140->5298|8268->5402|8481->5578|8502->5589|8579->5643|9042->6070|9148->6153|9190->6159|9316->6261|9528->6436|9549->6447|9623->6498|10042->6881|10178->6993|10220->6999|10333->7089|10544->7263|10565->7274|10643->7329|11050->7700|11181->7807|11307->7897|11495->8061|11652->8182|11712->8219|11890->8361|12031->8478|12072->8483|12175->8563|12363->8714|12384->8725|12459->8777|12865->9147|13052->9310|13472->9693|13493->9704|13564->9752|13675->9831|13717->9837|13761->9871|13802->9873|13943->9996|13957->10001|13997->10002|14051->10019|14069->10027|14124->10059|14730->10628|14781->10662|14822->10664|14872->10677|14896->10691|14946->10718|15021->10756|15042->10767|15124->10825|15164->10827|15183->10835|15216->10844|15304->10895|15323->10904|15349->10907|15460->10981|15501->10999|15555->11016|15611->11049|15650->11051|15721->11111|15762->11112|15870->11186|15924->11203|16001->11257|16055->11274|16154->11350|16208->11367|16283->11419|16363->11462|16382->11471|16411->11477|16451->11480|16523->11528|16600->11568|16691->11635|16745->11652|16823->11707|16877->11724|16945->11769|16999->11786|17018->11795|17104->11858|17158->11875|17177->11884|17216->11900|17276->11924|17340->11965|17391->11983|17445->12000|17469->12014|17502->12024|17655->12140|17670->12145|17719->12171|17858->12274|17873->12279|17991->12373|18047->12397|18081->12399|18134->12423|18164->12424|18282->12513|18312->12514|18361->12535|18390->12536|18478->12595|18508->12596|18620->12680|18649->12681|18709->12712|18739->12713|18811->12756|18841->12757|18929->12817|18958->12818|19068->12900|19097->12901|19127->12903|19156->12904
                    LINES: 26->1|35->7|35->7|37->7|38->8|38->8|38->8|39->9|39->9|39->9|40->5|40->5|40->12|40->12|58->1|59->5|60->10|62->29|64->31|64->31|64->31|64->31|79->46|79->46|79->46|80->47|80->47|80->47|90->57|90->57|90->57|91->58|91->58|91->58|92->59|93->60|93->60|93->60|94->61|94->61|94->61|95->62|96->63|96->63|96->63|97->64|97->64|97->64|98->65|108->75|108->75|108->75|110->77|110->77|110->77|110->77|117->84|117->84|122->89|122->89|132->99|132->99|138->105|138->105|146->113|146->113|147->114|147->114|153->120|153->120|154->121|154->121|161->128|161->128|162->129|162->129|167->134|167->134|167->134|188->155|188->155|189->156|189->156|194->161|194->161|194->161|210->177|210->177|211->178|211->178|216->183|216->183|216->183|232->199|232->199|237->204|238->205|243->210|243->210|249->216|249->216|250->217|250->217|253->220|253->220|253->220|264->231|265->232|279->246|279->246|279->246|284->251|286->253|286->253|286->253|292->259|292->259|292->259|294->261|294->261|294->261|313->280|313->280|313->280|314->281|314->281|314->281|315->282|315->282|315->282|315->282|315->282|315->282|316->283|316->283|316->283|317->284|317->284|318->285|318->285|318->285|318->285|318->285|318->285|319->286|319->286|320->287|320->287|321->288|321->288|322->289|322->289|322->289|322->289|322->289|323->290|323->290|324->291|324->291|325->292|325->292|326->293|326->293|326->293|327->294|327->294|327->294|329->296|329->296|330->297|331->298|331->298|331->298|336->303|336->303|336->303|342->309|342->309|342->309|345->312|346->313|348->315|348->315|354->321|354->321|356->323|356->323|358->325|358->325|360->327|360->327|362->329|362->329|364->331|364->331|366->333|366->333|369->336|369->336|371->338|371->338
                    -- GENERATED --
                */
            