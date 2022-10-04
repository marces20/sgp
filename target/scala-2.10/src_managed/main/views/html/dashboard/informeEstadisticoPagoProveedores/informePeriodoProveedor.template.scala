
package views.html.dashboard.informeEstadisticoPagoProveedores

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
object informePeriodoProveedor extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template9[java.util.Map[String, List[models.informes.InformeEstadisticoPagoProveedores]],DynamicForm,java.math.BigDecimal,java.math.BigDecimal,java.math.BigDecimal,java.math.BigDecimal,java.math.BigDecimal,java.math.BigDecimal,java.math.BigDecimal,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(listaFinal:java.util.Map[String,List[models.informes.InformeEstadisticoPagoProveedores]],
formBuscador: DynamicForm,
totalFacturado:java.math.BigDecimal,
totalImpuestos:java.math.BigDecimal,
totalPagado:java.math.BigDecimal,
totalPagadoAfip:java.math.BigDecimal,
totalPagadoDgr:java.math.BigDecimal,
totalPagadoOtros:java.math.BigDecimal,
totalSuperPagado:java.math.BigDecimal
):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import java.math.BigDecimal;var total=new java.math.BigDecimal(0);var totalf=new java.math.BigDecimal(0);var totali=new java.math.BigDecimal(0);

import java.util.Map;var li = new java.util.ArrayList[Long];

implicit def /*12.2*/implicitFieldConstructor/*12.26*/ = {{ FieldConstructor(simpleInput.render) }};def /*16.2*/getClassEstado/*16.16*/(i:Estado) = {{
	var classEstado:String = new String()
	if(i != null && i.id == 24){
		classEstado = "borrador"
	}else if(i != null && i.id == 26){
		classEstado = "cancelada"
	}else if(i != null && (i.id == 23)){
		classEstado = "autorizado"
	}else if(i != null && i.id == 25){
		classEstado = "pagado"
	}
	
	classEstado
}};
Seq[Any](format.raw/*10.2*/("""
"""),format.raw/*12.70*/(""" 
"""),format.raw/*15.1*/("""
"""),format.raw/*29.2*/("""
 
"""),_display_(Seq[Any](/*31.2*/views/*31.7*/.html.dashboard.mainDashboard(title = "Informe de pagos por Periodo/Proveedores")/*31.88*/ {_display_(Seq[Any](format.raw/*31.90*/("""
    
<div class="page-header">
	<div class="row">
		<div class="col-sm-7">
			<h1>Informe de pagos por Periodo/Proveedores</h1>
		</div>

		<div class="col-sm-5">
			
			<!-- <div class="dropdown pull-right">
				 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 	<i class="glyphicon glyphicon-list-alt"></i>
				    Reportes
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				    <li role="presentation"><a role="menuitem" id="generarArchivo" 
				    href=""""),_display_(Seq[Any](/*49.16*/controllers/*49.27*/.dashboard.routes.InformeEstadisticoPagoProveedoresController.informePeriodoProveedorReporte())),format.raw/*49.121*/("""" 
				    tabindex="-1" href="#">Resumen por Proveedor</a></li>
				  </ul>
			</div> -->
		
		</div>
	</div>
</div>


<script>

$( function() """),format.raw/*61.15*/("""{"""),format.raw/*61.16*/("""
	/*if($('#periodo_id').val() == '')"""),format.raw/*62.36*/("""{"""),format.raw/*62.37*/("""
		alert("Debe ingresar un Periodo");	
		false;
	"""),format.raw/*65.2*/("""}"""),format.raw/*65.3*/("""else"""),format.raw/*65.7*/("""{"""),format.raw/*65.8*/("""
		var baseUrl = $('#generarArchivo').attr('href')
		$('#generarArchivo').attr('href', baseUrl + '?descarga=&' + window.location.href.slice(window.location.href.indexOf('?') + 1))
		
		
	"""),format.raw/*70.2*/("""}"""),format.raw/*70.3*/("""
	$('#generarArchivo').click( function() """),format.raw/*71.41*/("""{"""),format.raw/*71.42*/("""
		if($('#periodo_id').val() == '')"""),format.raw/*72.35*/("""{"""),format.raw/*72.36*/("""
			alert("Debe ingresar un Periodo");	
			return false;
		"""),format.raw/*75.3*/("""}"""),format.raw/*75.4*/("""else"""),format.raw/*75.8*/("""{"""),format.raw/*75.9*/("""	
			var href = $(this).attr('href') + '?descarga=&' + escape(window.location.href.slice(window.location.href.indexOf('?') + 1).split('&'));
			alert(href);
			window.location = href;
			return false;
		"""),format.raw/*80.3*/("""}"""),format.raw/*80.4*/("""
	"""),format.raw/*81.2*/("""}"""),format.raw/*81.3*/(""");*/
	 
	$('#btn-buscar').click( function() """),format.raw/*83.37*/("""{"""),format.raw/*83.38*/("""
		if($('#fecha_hasta').val() != '' && $('#fecha_desde').val() != '' && $('#periodo').val() != '')"""),format.raw/*84.98*/("""{"""),format.raw/*84.99*/("""
			$('#fecha_hasta').val("");
			$('#fecha_desde').val("");
		"""),format.raw/*87.3*/("""}"""),format.raw/*87.4*/("""else"""),format.raw/*87.8*/("""{"""),format.raw/*87.9*/("""
			if($('#fecha_hasta').val() != '' || $('#fecha_desde').val() != '')"""),format.raw/*88.70*/("""{"""),format.raw/*88.71*/("""
				$('#periodo').val("")
				$('#periodo_id').val("")
			"""),format.raw/*91.4*/("""}"""),format.raw/*91.5*/("""else"""),format.raw/*91.9*/("""{"""),format.raw/*91.10*/("""
				if($('#periodo').val() != '')"""),format.raw/*92.34*/("""{"""),format.raw/*92.35*/("""
					$('#fecha_hasta').val("");
					$('#fecha_desde').val("");
				"""),format.raw/*95.5*/("""}"""),format.raw/*95.6*/("""
			"""),format.raw/*96.4*/("""}"""),format.raw/*96.5*/("""
		"""),format.raw/*97.3*/("""}"""),format.raw/*97.4*/("""
	"""),format.raw/*98.2*/("""}"""),format.raw/*98.3*/(""");
	
"""),format.raw/*100.1*/("""}"""),format.raw/*100.2*/(""");

</script>


"""),_display_(Seq[Any](/*105.2*/views/*105.7*/.html.tags.successError())),format.raw/*105.32*/("""
    <form action="" method="GET" id="filtroInforme">
    	 
		<div class="row seccion">
			<div class="col-sm-4">
				<label class="control-label">Proveedor
					<div class="input-group">	
						"""),_display_(Seq[Any](/*112.8*/inputText(formBuscador("proveedor_nombre"), 'name -> "", 'autofocus -> "autofocus", 'class -> "form-control", 'id -> "proveedor"))),format.raw/*112.137*/("""
						"""),_display_(Seq[Any](/*113.8*/inputText(formBuscador("proveedor_id"), 'hidden -> "hidden", 'id -> "proveedor_id"))),format.raw/*113.91*/("""
						<span class="input-group-addon">
							<a href="#" class="searchModal"
										id="searchProveedor" 
										data-title="Selección de Proveedores" 
										data-url=""""),_display_(Seq[Any](/*118.22*/controllers/*118.33*/.compras.routes.ProveedoresController.modalBuscar())),format.raw/*118.84*/("""" 
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
				
					<div class="form-group """),_display_(Seq[Any](/*132.30*/if(formBuscador.error("periodo_id") != null)/*132.74*/ {_display_(Seq[Any](format.raw/*132.76*/("""has-error""")))})),format.raw/*132.86*/("""">
						<label for="periodo" class="control-label">Periodo</label> 
						<div class="input-group">
							"""),_display_(Seq[Any](/*135.9*/inputText(formBuscador("periodo.nombre"), 'class -> "form-control", 'id -> "periodo"))),format.raw/*135.94*/("""
							"""),_display_(Seq[Any](/*136.9*/inputText(formBuscador("periodo.id"),'hidden -> "hidden", 'id -> "periodo_id"))),format.raw/*136.87*/("""
							<span class="input-group-addon">
								<a href="#" class="searchModal"
											id="searchPeriodo" 
											data-title="Selección de Periodo" 
											data-url=""""),_display_(Seq[Any](/*141.23*/controllers/*141.34*/.contabilidad.routes.PeriodosController.modalBuscar())),format.raw/*141.87*/("""" 
											data-height="650" 
											data-width="700" 
											data-listen="modal.seleccion.periodo.simple" 
											data-label="#periodo" 
											data-field="#periodo_id">
									<i class="glyphicon glyphicon-search"></i>
								</a>
							</span>
						</div>
					</div>
			</div>
			
			<div class="col-sm-2 input-group">
				<label class="control-label">Fecha Pago</label>
				<div>
					"""),_display_(Seq[Any](/*157.7*/inputText(formBuscador("fecha_desde"), 'class -> "form-control inputDateMascara", 'id -> "fecha_desde", 'placeholder -> "Desde"))),format.raw/*157.135*/("""
					"""),_display_(Seq[Any](/*158.7*/inputText(formBuscador("fecha_hasta"), 'class -> "form-control inputDateMascara", 'id -> "fecha_hasta", 'placeholder -> "Hasta"))),format.raw/*158.135*/("""
				</div>
			</div>
			
			<div class="col-sm-2">
				<div class="form-group">
					<label for="nombre" class="control-label">&nbsp;</label>
					<button  class="form-control btn btn-primary" id="btn-buscar">Buscar</button>
				</div>
			</div>
			<div class="col-sm-2">
				<div class="form-group">
					<label for="nombre" class="control-label">&nbsp;</label>
					<a href=""""),_display_(Seq[Any](/*171.16*/controllers/*171.27*/.dashboard.routes.InformeEstadisticoPagoProveedoresController.informePeriodoProveedor())),format.raw/*171.114*/(""""  class="form-control btn btn-default">Limpiar</a>
				</div>
			</div>
			
		 
			
	</div>
	
	 
    </form>
    <hr>
    <div class="row seccion">
    	 <div class="col-sm-12">
	  	  <div class="small-box bg-green">
	  	  	<div class="inner">
	          <h3>Total Pagado</h3>
	          <p>"""),_display_(Seq[Any](/*187.16*/utils/*187.21*/.NumberUtils.moneda(totalSuperPagado))),format.raw/*187.58*/("""</p>
	  	  </div>
		 </div>
		 </div>   
	</div>
    <hr>
   <!-- <div class="row seccion">
    	 <div class="col-sm-12">
	  	  <div class="small-box bg-green">
	  	  	<div class="inner">
	          <h3>Facturado</h3>
	  	  </div>
		 </div>
		 </div>   
		  <div class="col-sm-6">
	  	  <div class="small-box bg-aqua">
	  	  	<div class="inner">
	          <h3>Impuestos Pagados</h3>
	  	  </div>
		 </div>  
		 </div>	   
    </div>-->
    <div class="row seccion">
	    <div class="col-sm-4">
	  	  <div class="small-box bg-green">
	        <div class="inner">
	          <h3>Facturado</h3>
	
	          <p>"""),_display_(Seq[Any](/*215.16*/utils/*215.21*/.NumberUtils.moneda(totalFacturado))),format.raw/*215.56*/("""</p>
	        </div>
	        <div class="icon">
	          <i class="ion ion-bag"></i>
	        </div>
	         
	      </div>
	    </div>
	    
	     <div class="col-sm-4">
	  	  <div class="small-box bg-green">
	        <div class="inner">
	          <h3>Impuestos </h3>
			   
	          <p>"""),_display_(Seq[Any](/*229.16*/utils/*229.21*/.NumberUtils.moneda(totalImpuestos))),format.raw/*229.56*/("""</p>
	        </div>
	        <div class="icon">
	          <i class="ion ion-bag"></i>
	        </div>
	         
	      </div>
	    </div> 
	    
	    <div class="col-sm-4">
	  	  <div class="small-box bg-green">
	        <div class="inner">
	          <h3>Pagado</h3>
	
	          <p>"""),_display_(Seq[Any](/*243.16*/utils/*243.21*/.NumberUtils.moneda(totalPagado))),format.raw/*243.53*/("""</p>
	        </div>
	        <div class="icon">
	          <i class="ion ion-bag"></i>
	        </div>
	         
	      </div>
	    </div>
	    
	    
	    <!--<div class="col-sm-3">
	  	  <div class="small-box bg-aqua">
	        <div class="inner">
	          <h3>Afip</h3>
	
	          <p>"""),_display_(Seq[Any](/*258.16*/utils/*258.21*/.NumberUtils.moneda(totalPagadoAfip))),format.raw/*258.57*/("""</p>
	        </div>
	        <div class="icon">
	          <i class="ion ion-bag"></i>
	        </div>
	         
	      </div>
	    </div>
	    <div class="col-sm-3">
	  	  <div class="small-box bg-aqua">
	        <div class="inner">
	          <h3>DGR</h3>
	
	          <p>"""),_display_(Seq[Any](/*271.16*/utils/*271.21*/.NumberUtils.moneda(totalPagadoDgr))),format.raw/*271.56*/("""</p>
	        </div>
	        <div class="icon">
	          <i class="ion ion-bag"></i>
	        </div>
	         
	      </div>
	    </div>
	    
	     <div class="col-sm-2">
	  	  <div class="small-box bg-aqua">
	        <div class="inner">
	          <h3>Otros</h3>
	
	          <p>"""),_display_(Seq[Any](/*285.16*/utils/*285.21*/.NumberUtils.moneda(totalPagadoOtros))),format.raw/*285.58*/("""</p>
	        </div>
	        <div class="icon">
	          <i class="ion ion-bag"></i>
	        </div>
	         
	      </div>
	    </div> -->
	    
	    
    </div>
    
    
    <hr>
    
    """),_display_(Seq[Any](/*300.6*/if(listaFinal == null || listaFinal.size() == 0)/*300.54*/ {_display_(Seq[Any](format.raw/*300.56*/("""
        
        <div class="well">
            <em>No se encuentran resultados</em>
        </div>
        
    """)))}/*306.7*/else/*306.12*/{_display_(Seq[Any](format.raw/*306.13*/("""
    	
    	"""),_display_(Seq[Any](/*308.7*/if(totalPagadoOtros.compareTo(BigDecimal.ZERO) > 0)/*308.58*/{_display_(Seq[Any](format.raw/*308.59*/("""
    		<table class="table table-striped table-bordered">
				<thead>
					<tr  style="background: #FFFFFF; font-weight: bold;">
						<td align="center" colspan=""><span style="font-size: 16px;">Embargos</span></td>
					</tr>
					<tr style="background: #FFFFFF;  font-weight: bold;">
						
						 
						 
						<td align="center">Total Pagado</td>
					</tr>
				</thead>
				<tbody>
				<tr style="background: #FFFFFF;">
					
					<td align="center">"""),_display_(Seq[Any](/*324.26*/utils/*324.31*/.NumberUtils.moneda(totalPagadoOtros))),format.raw/*324.68*/("""</td>
				</tr>
				</tbody>
				<tfoot>
					<tr style="background: #FFFFFF;  font-weight: bold;">
						 
						
						 
						<td align="center" ><b>Total:</b>"""),_display_(Seq[Any](/*332.41*/utils/*332.46*/.NumberUtils.moneda(totalPagadoOtros))),format.raw/*332.83*/("""</td>
						 
					</tr>
				</tfoot>
				
			</table>
		""")))})),format.raw/*338.4*/("""
    	
		"""),_display_(Seq[Any](/*340.4*/for((key,value) <- listaFinal) yield /*340.34*/ {_display_(Seq[Any](format.raw/*340.36*/(""" 
			"""),_display_(Seq[Any](/*341.5*/{total = new java.math.BigDecimal(0)})),format.raw/*341.42*/("""
			<table class="table table-striped table-bordered">
				<thead>
					<tr  style="background: #FFFFFF; font-weight: bold;">
						<td align="center" colspan="6"><span style="font-size: 16px;">"""),_display_(Seq[Any](/*345.70*/key)),format.raw/*345.73*/("""</span></td>
					</tr>
					<tr style="background: #FFFFFF;  font-weight: bold;">
						<td width="30">Fecha</td>
						<td>Exp.</td>
						<td>Institucion</td>
						 
						<td align="center">Total Facturado</td>
						
						<td align="center">Total Impuestos</td>
						<td align="center">Total Pagado</td>
					</tr>
				</thead>
				<tbody>
				
				
				"""),_display_(Seq[Any](/*361.6*/if(key == "AFIP" || key == "DGR")/*361.39*/{_display_(Seq[Any](format.raw/*361.40*/("""
					
					"""),_display_(Seq[Any](/*363.7*/for(z <- value) yield /*363.22*/ {_display_(Seq[Any](format.raw/*363.24*/(""" 
						
						"""),_display_(Seq[Any](/*365.8*/{total = total.add(z.total)})),format.raw/*365.36*/("""
						"""),_display_(Seq[Any](/*366.8*/{totalf = total.add(z.total_factura)})),format.raw/*366.45*/("""
						
					""")))})),format.raw/*368.7*/("""
					
						<tr style="background: #FFFFFF;">
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							 
							<td align="center">"""),_display_(Seq[Any](/*377.28*/utils/*377.33*/.NumberUtils.moneda(total))),format.raw/*377.59*/("""</td>
						</tr>
						 </tbody>
						<tfoot>
							<tr style="background: #FFFFFF;  font-weight: bold;">
								<td></td> 
								<td></td>
								<td></td>
								<td align="center" ></td>
								<td align="center" ></td>
								<td align="center" ><b>Total:</b>"""),_display_(Seq[Any](/*387.43*/utils/*387.48*/.NumberUtils.moneda(total))),format.raw/*387.74*/("""</td>
								 
							</tr>
						</tfoot>
					
				""")))}/*392.6*/else/*392.10*/{_display_(Seq[Any](format.raw/*392.11*/("""
					 
						
					"""),_display_(Seq[Any](/*395.7*/{total = new java.math.BigDecimal(0)})),format.raw/*395.44*/("""
					"""),_display_(Seq[Any](/*396.7*/{totalf = new java.math.BigDecimal(0)})),format.raw/*396.45*/("""
					"""),_display_(Seq[Any](/*397.7*/{totali = new java.math.BigDecimal(0)})),format.raw/*397.45*/("""
					
					
					
					"""),_display_(Seq[Any](/*401.7*/for(z <- value) yield /*401.22*/ {_display_(Seq[Any](format.raw/*401.24*/(""" 
						"""),_display_(Seq[Any](/*402.8*/if(!li.contains(z.factura_id))/*402.38*/ {_display_(Seq[Any](format.raw/*402.40*/("""
						
							<tr style="background: #FFFFFF;">
								<td>"""),_display_(Seq[Any](/*405.14*/(utils.DateUtils.formatDate(z.fecha_pago)))),format.raw/*405.56*/("""</td>
								<td>"""),_display_(Seq[Any](/*406.14*/(z.expediente.getExpedienteEjercicio()))),format.raw/*406.53*/("""</td>
								<td>"""),_display_(Seq[Any](/*407.14*/if(z.deposito !=null )/*407.36*/{_display_(Seq[Any](_display_(Seq[Any](/*407.38*/z/*407.39*/.deposito.nombre))))})),format.raw/*407.56*/("""</td>
								<td align="center">"""),_display_(Seq[Any](/*408.29*/utils/*408.34*/.NumberUtils.moneda(z.factura.getBase()))),format.raw/*408.74*/("""</td> 
								
								<td align="center">"""),_display_(Seq[Any](/*410.29*/utils/*410.34*/.NumberUtils.moneda(z.factura.getTotalImpuesto()))),format.raw/*410.83*/("""</td> 
								<td align="center">"""),_display_(Seq[Any](/*411.29*/utils/*411.34*/.NumberUtils.moneda(z.total))),format.raw/*411.62*/("""</td>
							</tr>
							"""),_display_(Seq[Any](/*413.9*/{total = total.add(z.total)})),format.raw/*413.37*/("""
							"""),_display_(Seq[Any](/*414.9*/{totalf = totalf.add(z.factura.getBase())})),format.raw/*414.51*/("""
							"""),_display_(Seq[Any](/*415.9*/{totali = totali.add(z.factura.getTotalImpuesto())})),format.raw/*415.60*/("""
							
							"""),_display_(Seq[Any](/*417.9*/{var lci = li.add(z.factura_id)})),format.raw/*417.41*/("""
						""")))}/*418.8*/else/*418.12*/{_display_(Seq[Any](format.raw/*418.13*/("""
							<tr style="background: #FFFFFF;">
								<td>"""),_display_(Seq[Any](/*420.14*/(utils.DateUtils.formatDate(z.fecha_pago)))),format.raw/*420.56*/("""</td>
								<td>"""),_display_(Seq[Any](/*421.14*/(z.expediente.getExpedienteEjercicio()))),format.raw/*421.53*/("""</td>
								<td>"""),_display_(Seq[Any](/*422.14*/if(z.deposito !=null )/*422.36*/{_display_(Seq[Any](_display_(Seq[Any](/*422.38*/z/*422.39*/.deposito.nombre))))})),format.raw/*422.56*/("""</td>
								<td align="center">"""),_display_(Seq[Any](/*423.29*/utils/*423.34*/.NumberUtils.moneda(BigDecimal.ZERO))),format.raw/*423.70*/("""</td> 
								
								<td align="center">"""),_display_(Seq[Any](/*425.29*/utils/*425.34*/.NumberUtils.moneda(BigDecimal.ZERO))),format.raw/*425.70*/("""</td> 
								<td align="center">"""),_display_(Seq[Any](/*426.29*/utils/*426.34*/.NumberUtils.moneda(z.total))),format.raw/*426.62*/("""</td>
							</tr>
							"""),_display_(Seq[Any](/*428.9*/{total = total.add(z.total)})),format.raw/*428.37*/("""
						""")))})),format.raw/*429.8*/("""
						
					""")))})),format.raw/*431.7*/("""
				     
			    
			    </tbody>
				<tfoot>
					<tr style="background: #FFFFFF;  font-weight: bold;">
						<td></td> 
						<td></td> 
						<td></td> 
						<td align="center" ><b>Total:</b>"""),_display_(Seq[Any](/*440.41*/utils/*440.46*/.NumberUtils.moneda(totalf))),format.raw/*440.73*/("""</td>
						<td align="center" ><b>Total:</b>"""),_display_(Seq[Any](/*441.41*/utils/*441.46*/.NumberUtils.moneda(totali))),format.raw/*441.73*/("""</td>
						<td align="center" ><b>Total:</b>"""),_display_(Seq[Any](/*442.41*/utils/*442.46*/.NumberUtils.moneda(total))),format.raw/*442.72*/("""</td>
						 
					</tr>
				</tfoot>
			""")))})),format.raw/*446.5*/("""
			</table>
		""")))})),format.raw/*448.4*/(""" 
	""")))})),format.raw/*449.3*/("""
	
	
	<script type="text/javascript">
	$( function() """),format.raw/*453.16*/("""{"""),format.raw/*453.17*/("""
		$('#searchProveedor,#searchPeriodo').modalSearch();
		 
		
	"""),format.raw/*457.2*/("""}"""),format.raw/*457.3*/(""");
	</script>
	
	
""")))})))}
    }
    
    def render(listaFinal:java.util.Map[String, List[models.informes.InformeEstadisticoPagoProveedores]],formBuscador:DynamicForm,totalFacturado:java.math.BigDecimal,totalImpuestos:java.math.BigDecimal,totalPagado:java.math.BigDecimal,totalPagadoAfip:java.math.BigDecimal,totalPagadoDgr:java.math.BigDecimal,totalPagadoOtros:java.math.BigDecimal,totalSuperPagado:java.math.BigDecimal): play.api.templates.HtmlFormat.Appendable = apply(listaFinal,formBuscador,totalFacturado,totalImpuestos,totalPagado,totalPagadoAfip,totalPagadoDgr,totalPagadoOtros,totalSuperPagado)
    
    def f:((java.util.Map[String, List[models.informes.InformeEstadisticoPagoProveedores]],DynamicForm,java.math.BigDecimal,java.math.BigDecimal,java.math.BigDecimal,java.math.BigDecimal,java.math.BigDecimal,java.math.BigDecimal,java.math.BigDecimal) => play.api.templates.HtmlFormat.Appendable) = (listaFinal,formBuscador,totalFacturado,totalImpuestos,totalPagado,totalPagadoAfip,totalPagadoDgr,totalPagadoOtros,totalSuperPagado) => apply(listaFinal,formBuscador,totalFacturado,totalImpuestos,totalPagado,totalPagadoAfip,totalPagadoDgr,totalPagadoOtros,totalSuperPagado)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:44:00 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/informeEstadisticoPagoProveedores/informePeriodoProveedor.scala.html
                    HASH: a1ebc3a3cc395d4afb2e2c8b1aa532a1407e1cf4
                    MATRIX: 1067->1|1757->399|1790->423|1848->679|1871->693|2224->380|2253->467|2282->677|2310->1016|2349->1020|2362->1025|2452->1106|2492->1108|3132->1712|3152->1723|3269->1817|3441->1961|3470->1962|3534->1998|3563->1999|3639->2048|3667->2049|3698->2053|3726->2054|3940->2241|3968->2242|4037->2283|4066->2284|4129->2319|4158->2320|4244->2379|4272->2380|4303->2384|4331->2385|4561->2588|4589->2589|4618->2591|4646->2592|4718->2636|4747->2637|4873->2735|4902->2736|4992->2799|5020->2800|5051->2804|5079->2805|5177->2875|5206->2876|5292->2935|5320->2936|5351->2940|5380->2941|5442->2975|5471->2976|5567->3045|5595->3046|5626->3050|5654->3051|5684->3054|5712->3055|5741->3057|5769->3058|5802->3063|5831->3064|5884->3081|5898->3086|5946->3111|6179->3308|6332->3437|6376->3445|6482->3528|6700->3709|6721->3720|6795->3771|7195->4134|7249->4178|7290->4180|7333->4190|7478->4299|7586->4384|7631->4393|7732->4471|7949->4651|7970->4662|8046->4715|8497->5130|8649->5258|8692->5265|8844->5393|9260->5772|9281->5783|9392->5870|9722->6163|9737->6168|9797->6205|10444->6815|10459->6820|10517->6855|10851->7152|10866->7157|10924->7192|11249->7480|11264->7485|11319->7517|11650->7811|11665->7816|11724->7852|12038->8129|12053->8134|12111->8169|12434->8455|12449->8460|12509->8497|12742->8694|12800->8742|12841->8744|12975->8860|12989->8865|13029->8866|13078->8879|13139->8930|13179->8931|13674->9389|13689->9394|13749->9431|13949->9594|13964->9599|14024->9636|14114->9694|14160->9704|14207->9734|14248->9736|14290->9742|14350->9779|14582->9974|14608->9977|15007->10340|15050->10373|15090->10374|15139->10387|15171->10402|15212->10404|15264->10420|15315->10448|15359->10456|15419->10493|15465->10507|15670->10675|15685->10680|15734->10706|16045->10980|16060->10985|16109->11011|16183->11066|16197->11070|16237->11071|16294->11092|16354->11129|16397->11136|16458->11174|16501->11181|16562->11219|16623->11244|16655->11259|16696->11261|16741->11270|16781->11300|16822->11302|16921->11364|16986->11406|17042->11425|17104->11464|17160->11483|17192->11505|17241->11507|17252->11508|17296->11525|17367->11559|17382->11564|17445->11604|17526->11648|17541->11653|17613->11702|17685->11737|17700->11742|17751->11770|17814->11797|17865->11825|17910->11834|17975->11876|18020->11885|18094->11936|18147->11953|18202->11985|18229->11993|18243->11997|18283->11998|18375->12053|18440->12095|18496->12114|18558->12153|18614->12172|18646->12194|18695->12196|18706->12197|18750->12214|18821->12248|18836->12253|18895->12289|18976->12333|18991->12338|19050->12374|19122->12409|19137->12414|19188->12442|19251->12469|19302->12497|19342->12505|19388->12519|19622->12716|19637->12721|19687->12748|19770->12794|19785->12799|19835->12826|19918->12872|19933->12877|19982->12903|20056->12945|20104->12961|20140->12965|20222->13018|20252->13019|20343->13082|20372->13083
                    LINES: 26->1|42->12|42->12|42->16|42->16|56->10|57->12|58->15|59->29|61->31|61->31|61->31|61->31|79->49|79->49|79->49|91->61|91->61|92->62|92->62|95->65|95->65|95->65|95->65|100->70|100->70|101->71|101->71|102->72|102->72|105->75|105->75|105->75|105->75|110->80|110->80|111->81|111->81|113->83|113->83|114->84|114->84|117->87|117->87|117->87|117->87|118->88|118->88|121->91|121->91|121->91|121->91|122->92|122->92|125->95|125->95|126->96|126->96|127->97|127->97|128->98|128->98|130->100|130->100|135->105|135->105|135->105|142->112|142->112|143->113|143->113|148->118|148->118|148->118|162->132|162->132|162->132|162->132|165->135|165->135|166->136|166->136|171->141|171->141|171->141|187->157|187->157|188->158|188->158|201->171|201->171|201->171|217->187|217->187|217->187|245->215|245->215|245->215|259->229|259->229|259->229|273->243|273->243|273->243|288->258|288->258|288->258|301->271|301->271|301->271|315->285|315->285|315->285|330->300|330->300|330->300|336->306|336->306|336->306|338->308|338->308|338->308|354->324|354->324|354->324|362->332|362->332|362->332|368->338|370->340|370->340|370->340|371->341|371->341|375->345|375->345|391->361|391->361|391->361|393->363|393->363|393->363|395->365|395->365|396->366|396->366|398->368|407->377|407->377|407->377|417->387|417->387|417->387|422->392|422->392|422->392|425->395|425->395|426->396|426->396|427->397|427->397|431->401|431->401|431->401|432->402|432->402|432->402|435->405|435->405|436->406|436->406|437->407|437->407|437->407|437->407|437->407|438->408|438->408|438->408|440->410|440->410|440->410|441->411|441->411|441->411|443->413|443->413|444->414|444->414|445->415|445->415|447->417|447->417|448->418|448->418|448->418|450->420|450->420|451->421|451->421|452->422|452->422|452->422|452->422|452->422|453->423|453->423|453->423|455->425|455->425|455->425|456->426|456->426|456->426|458->428|458->428|459->429|461->431|470->440|470->440|470->440|471->441|471->441|471->441|472->442|472->442|472->442|476->446|478->448|479->449|483->453|483->453|487->457|487->457
                    -- GENERATED --
                */
            