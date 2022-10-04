
package views.html.dashboard.honorarios

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
object estadoGeneralPorAgente extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[DynamicForm,String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm,proveedor_id:String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.49*/("""
"""),format.raw/*3.70*/(""" 
"""),_display_(Seq[Any](/*4.2*/views/*4.7*/.html.dashboard.mainDashboard("Estado general agentes - Honorarios")/*4.75*/ {_display_(Seq[Any](format.raw/*4.77*/("""
<script src=""""),_display_(Seq[Any](/*5.15*/routes/*5.21*/.Assets.at("javascripts/dashboard/estadoGeneralPorAgente.js"))),format.raw/*5.82*/("""" type="text/javascript"></script>
	
	<div class="page-header" style="padding-left: 10px;">
		<div class="row">
			<div class="col-sm-10">
				<h1>Estado general por agente</h1>
			</div>
		</div>
		<div class="row"  style="border-bottom: 1px solid #999999;padding-bottom: 5px;">
			<form action="" id="formSearchEstadoGeneralPorAgente" method="GET">
				<div class="col-sm-4">
					<label class="control-label">Agente</label>
						<div class="input-group">
							"""),_display_(Seq[Any](/*18.9*/inputText(formBuscador("proveedor.nombre"), 'name -> "", 'class -> "form-control", 'id -> "proveedor",'placeholder -> "Seleccione un agente"))),format.raw/*18.150*/("""
							"""),_display_(Seq[Any](/*19.9*/inputText(formBuscador("proveedor.id"), 'hidden -> "hidden", 'id -> "proveedor_id"))),format.raw/*19.92*/("""
							<span class="input-group-addon">
								<a href="#" class="searchModal"
											id="searchProveedor" 
											data-title="Selección de Proveedores" 
											data-url=""""),_display_(Seq[Any](/*24.23*/controllers/*24.34*/.compras.routes.ProveedoresController.modalBuscar())),format.raw/*24.85*/("""" 
											data-height="650" 
											data-width="700" 
											data-listen="modal.seleccion.proveedor.simple" 
											data-label="#proveedor" 
											data-field="#proveedor_id">
									<i class="glyphicon glyphicon-search"></i>
								</a>
							</span>
						</div>
					
				</div>
				<div class="col-sm-2">
					<div class="form-group">
					<label for="nombre" class="control-label">&nbsp;</label>
					<button  class="form-control btn btn-primary"><i class="glyphicon glyphicon-search"></i> Buscar</button>
					</div>
				</div>
			</form>	
			<div class="col-sm-2">
				<div class="form-group">
				<label for="nombre" class="control-label">&nbsp;</label>
				<a href=""""),_display_(Seq[Any](/*46.15*/controllers/*46.26*/.dashboard.routes.HonorariosController.estadoGeneralPorAgente())),format.raw/*46.89*/(""""  class="form-control btn btn-default">Limpiar</a>
				</div>
			</div>	
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*52.3*/if(proveedor_id != null && !proveedor_id.isEmpty())/*52.54*/{_display_(Seq[Any](format.raw/*52.55*/("""
	
	<input type="hidden" name="proveedor_id" id="proveedor_id" value=""""),_display_(Seq[Any](/*54.69*/(proveedor_id))),format.raw/*54.83*/(""""/>
	<div class="page-content" class="" style="padding-left: 10px;">
 		
 		
 		<div class="panel panel-default">
			<div class="panel-heading">
				<b class="nombre"></b>
			</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-sm-6">
						<div class="panel panel-default">
							<div class="panel-heading">
								<b>Datos Personales</b>
							</div>
							<div class="panel-body">
								<p>Cuit: <span class="cuit"></span></p>
								<p>Tipo de Relacion: <span  class="relacion"></span></p>
							</div>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="panel panel-default">
							<div class="panel-heading">
								<b>Datos de Deuda Generales</b>
							</div>
							<div class="panel-body">
								<div class="row">
									<div class="col-sm-4 " style="">
										<div class="panel cuadritoDeuda">
											<h3><b>Deuda Total</b></h3>
											<p><b id="cuadroDeuda">$0,00</b></p>
										</div>
									</div>
									<div class="panel col-sm-4">
										<div class="panel cuadritoDeuda">
											<h3><b>Deuda Exigible</b></h3>
											<p><b id="cuadroDeudaExigible">$0,00</b></p>
										</div>
									</div>
									<div class="panel col-sm-4">
										<div class="panel cuadritoTotalPagado">
											<h3><b>Total Pagado</b></h3>
											<p><b id="cuadroTotalPagado">$0,00</b></p>
										</div>
									</div>	
								</div>	
							</div>
						</div>
					</div>
				</div> 
				<ul id="estadoGeneralPorAgenteTab" class="nav nav-tabs">
					<li class="active"><a class="tabGeneral" href="#contenedorGeneral" data-toggle="tab">Estado de General</a></li>
					<li><a class="tabCertificaciones" href="#contenedorCertificaciones" data-toggle="tab">Certificaciones</a></li>
					<li><a class="tabFacturacion" href="#contenedorFacturacion" data-toggle="tab">Facturacion</a></li>
					<li><a class="tabPagos" href="#contenedorPagos" data-toggle="tab">Pagos</a></li>
					<!-- <li><a class="tabDeuda" href="#contenedorDeuda" data-toggle="tab">Estado de Deuda</a></li> -->
				</ul>
		
				<div class="tab-content">
					<div class="tab-pane active" id="contenedorGeneral">
						
						<div class="row">
							<div class="col-sm-6">
								<div class="panel panel-default">
									<div class="panel-heading">
										<b>Certificaciones</b>
									</div>
									<div class="panel-body">
										<div id="chart_certificaciones">
											 
											<!-- <div id="loading"></div>-->
										</div>
									</div>
								</div>
							</div>
							<div class="col-sm-6">
								<div class="panel panel-default">
									<div class="panel-heading">
										<b>Facturacion</b>
									</div>
									<div class="panel-body">
										<div id="chart_facturacion">
										
										</div>
									</div>
								</div>
							</div>
							
						</div>
						
						<div class="row">
							<div class="col-sm-12">
								<div class="panel panel-default">
									<div class="panel-heading">
										<b>Estado de deuda</b>
									</div>
									<div class="panel-body">
										<div id="chart_pagos">
										
										</div>	
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="tab-pane" id="contenedorCertificaciones">
						<h3>Certificaciones</h3>
						<table class="table table-striped table-bordered tableEstadoGeneral tableEstadoGeneralAgente">
							<thead>
								<tr>
									<th width="80">Referencia</th>
									<th width="70">Fecha</th>
									<th width="95">Expediente</th>
									<th width="95">Periodo</th>
									<th width="30">Profe</th>
									<th width="95">Base</th>
									<th width="95">Descuento</th>
									<th width="95">Total</th>
									<th width="100">Estado</th>
									<th width="30">Detalle</th> 
								</tr>
							</thead>
							<tbody>
							</tbody>
						</table>
						
					</div>
					<div class="tab-pane" id="contenedorFacturacion">
						<h3>Facturacion</h3>
						<table class="table table-bordered tableEstadoGeneral tableEstadoGeneralAgenteFacturacion">
							<thead>
								<tr>
									<th width="100">Referencia</th>
									<th width="70">OPG</th>
									<th width="100">N° Factura</th>
									<th width="95">Expediente</th>
									<th width="95">Periodo</th>
									<th width="30">Profe</th>
									<th width="100">Base</th>
									<th width="100">Total impuestos</th>
									<th width="100">Total</th>
									<th width="100">Saldo pendiente</th>
									<th width="100">Estado</th>
									<th width="30">Detalle</th> 
								</tr>
							</thead>
							<tbody>
							</tbody>
						</table>
					</div>
					<div class="tab-pane" id="contenedorPagos">
						<h3>Pagos</h3>
						<table class="table table-bordered tableEstadoGeneral tableEstadoGeneralAgentePagos">
							<thead>
								<tr>
									<th width="100">Fecha</th>
									<th width="70">REF N°</th>
									<th width="70">Orden pago</th>
									<th width="80">Expediente</th>
									<th width="60">Periodo</th>
									<th width="30">Profe</th>
									<th width="100">Total</th>
									<th width="100">Estado</th>
									<th width="30">Detalle</th> 
								</tr>
							</thead>
							<tbody>
							</tbody>
						</table>
					</div>
				</div>
			</div>	
		</div>
 	</div>
 	""")))}/*229.4*/else/*229.8*/{_display_(Seq[Any](format.raw/*229.9*/("""
 		<div class="page-content" class="" style="padding-left: 10px;">
 			 
 		</div>
 	""")))})),format.raw/*233.4*/("""
    
""")))})))}
    }
    
    def render(formBuscador:DynamicForm,proveedor_id:String): play.api.templates.HtmlFormat.Appendable = apply(formBuscador,proveedor_id)
    
    def f:((DynamicForm,String) => play.api.templates.HtmlFormat.Appendable) = (formBuscador,proveedor_id) => apply(formBuscador,proveedor_id)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:57 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/honorarios/estadoGeneralPorAgente.scala.html
                    HASH: ba8285fbb0161510a3def9eb33ed3550b49f7795
                    MATRIX: 824->1|973->67|1005->91|1079->48|1107->135|1144->138|1156->143|1232->211|1271->213|1321->228|1335->234|1417->295|1919->762|2083->903|2127->912|2232->995|2454->1181|2474->1192|2547->1243|3283->1943|3303->1954|3388->2017|3518->2112|3578->2163|3617->2164|3724->2235|3760->2249|9114->7584|9127->7588|9166->7589|9285->7676
                    LINES: 26->1|29->3|29->3|30->1|31->3|32->4|32->4|32->4|32->4|33->5|33->5|33->5|46->18|46->18|47->19|47->19|52->24|52->24|52->24|74->46|74->46|74->46|80->52|80->52|80->52|82->54|82->54|257->229|257->229|257->229|261->233
                    -- GENERATED --
                */
            