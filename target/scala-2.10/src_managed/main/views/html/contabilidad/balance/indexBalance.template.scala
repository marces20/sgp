
package views.html.contabilidad.balance

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
object indexBalance extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[Balance],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[Balance], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import models.auth._

import java.math.BigDecimal;var debe=new java.math.BigDecimal(0);var haber=new java.math.BigDecimal(0);

def /*6.2*/scripts/*6.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*6.13*/("""
	<script src=""""),_display_(Seq[Any](/*7.16*/routes/*7.22*/.Assets.at("javascripts/contabilidad/balance.js"))),format.raw/*7.71*/("""" type="text/javascript"></script>
""")))};implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};def /*10.2*/getClassEstado/*10.16*/(i:Estado) = {{
	var classEstado:String = new String()
	if(i != null && i.id == 104){
		classEstado = "borrador"
	}else if(i != null && i.id == 105){
		classEstado = "autorizado"
	} 
	
	classEstado
}};
Seq[Any](format.raw/*1.77*/("""
"""),format.raw/*5.70*/(""" 
"""),format.raw/*8.2*/("""

"""),format.raw/*19.2*/("""

"""),_display_(Seq[Any](/*21.2*/views/*21.7*/.html.contabilidad.mainContabilidad("Balance",scripts)/*21.61*/ {_display_(Seq[Any](format.raw/*21.63*/("""
<div class="page-header">
	<div class="row">
		<div class="col-sm-7">
			<h1>Balance</h1>
		</div>

		<div class="col-sm-5">
			<div class="dropdown pull-right btn-header">
			 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
			 	<i class="glyphicon glyphicon-list-alt"></i>
			    Reportes
			    <span class="caret"></span>
			  </button>
			  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
			  	<li role="presentation">
			  		 <a id="reporteArchivoBejerman" href="#" data-url=""""),_display_(Seq[Any](/*37.60*/controllers/*37.71*/.contabilidad.routes.BalanceController.archivoBejerman())),format.raw/*37.127*/("""">Descargar Archivo Factura</a>
			  	</li>
			  	<li role="presentation">
			  		 <a id="reporteArchivoBejermanPagos" href="#" data-url=""""),_display_(Seq[Any](/*40.65*/controllers/*40.76*/.contabilidad.routes.BalanceController.archivoBejermanPagos())),format.raw/*40.137*/("""">Descargar Archivo Pagos</a>
			  	</li>
			  	<li role="presentation">
			  		 <a id="reporteArchivoExcel" href="#" data-url=""""),_display_(Seq[Any](/*43.57*/controllers/*43.68*/.contabilidad.routes.BalanceController.archivoExcel())),format.raw/*43.121*/("""">Descargar Excel</a></li>	 
			
			  </ul>
			</div>
			
			<div class="dropdown pull-right btn-header">
			 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
			 	<i class="glyphicon glyphicon-list-alt"></i>
			    Acciones
			    <span class="caret"></span>
			 </button>
			  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
			  	    
				<li role="presentation"><a role="menuitem" id="accionPasarBorrador" tabindex="-1" href="#" data-url=""""),_display_(Seq[Any](/*56.107*/controllers/*56.118*/.contabilidad.routes.BalanceController.modalPasarBorrador())),format.raw/*56.177*/("""">Pasar a Borrador</a></li>	
				<li role="presentation"><a role="menuitem" id="accionPasarControlado" tabindex="-1" href="#" data-url=""""),_display_(Seq[Any](/*57.109*/controllers/*57.120*/.contabilidad.routes.BalanceController.modalPasarControlado())),format.raw/*57.181*/("""">Pasar a Controlado</a></li>	
				<li role="presentation"><a role="menuitem" id="accionCambiarCuenta" tabindex="-1" href="#" data-url=""""),_display_(Seq[Any](/*58.107*/controllers/*58.118*/.contabilidad.routes.BalanceController.modalCambiarCuenta())),format.raw/*58.177*/("""">Cambiar Cuenta</a></li>
			 	
			 </ul>
			</div>
		</div>
	</div>
	<div id="actions">
		<form action="" id="formSearchBalance" method="GET">
			 <div class="row">
				<div class="col-sm-10 filtrosEstados" id="filtrosEstados">
					<div class="btn-group">
					  <button type="button" rel="abierta" class="btn btn-default btn-filtros">
					  	<i class="glyphicon glyphicon-arrow-right"></i><br>Borrador
					  	"""),_display_(Seq[Any](/*71.10*/checkbox(formBuscador("btnFiltro[0]"), 'hidden -> "hidden"))),format.raw/*71.69*/("""
					  </button>
					  <button type="button" rel="entregado" class="btn btn-default btn-filtros">
					  	<i class="glyphicon glyphicon-arrow-right"></i><br>Controlado
					  	"""),_display_(Seq[Any](/*75.10*/checkbox(formBuscador("btnFiltro[1]"), 'hidden -> "hidden"))),format.raw/*75.69*/("""
					  </button> 
					</div>
				</div>
			</div>  
			<div class="row" >
				<div class="col-sm-2">
					<label class="control-label">Cuenta Propia
					"""),_display_(Seq[Any](/*83.7*/select(formBuscador("cuenta_propia_id"),
					CuentaPropia.find.all().map { p => p.id.toString -> p.nombre},'class -> "form-control select"))),format.raw/*84.100*/(""" 	
					</label>
				</div>
				
				 <div class="col-sm-2 input-group">
					<label class="control-label">Fecha</label>
					<div>
						"""),_display_(Seq[Any](/*91.8*/inputText(formBuscador("fecha_desde"), 'class -> "form-control inputDateMascara", 'id -> "fecha_desde", 'placeholder -> "Desde"))),format.raw/*91.136*/("""
						"""),_display_(Seq[Any](/*92.8*/inputText(formBuscador("fecha_hasta"), 'class -> "form-control inputDateMascara", 'id -> "fecha_hasta", 'placeholder -> "Hasta"))),format.raw/*92.136*/("""
					</div>
				</div>
				 
				<div class="col-sm-1">
					<label class="control-label">Ejercicio
					"""),_display_(Seq[Any](/*98.7*/select(formBuscador("ejercicio"), Ejercicio.getEjercicios().map { p => p.id.toString -> p.nombre}, 
					'class -> "form-control select" ))),format.raw/*99.39*/("""
					</label>
				</div>
				
				<div class="col-sm-4">
					<label class="control-label">Cuenta Balance
						<div class="input-group">
							"""),_display_(Seq[Any](/*106.9*/inputText(formBuscador("cuenta.nombre"), 'name -> "", 'class -> "form-control", 'id -> "cuenta"))),format.raw/*106.105*/("""
							"""),_display_(Seq[Any](/*107.9*/inputText(formBuscador("cuenta.id"), 'hidden -> "hidden", 'id -> "cuenta_id"))),format.raw/*107.86*/("""
							<span class="input-group-addon">
								<a href="#" class="searchModal"
											id="searchCuenta" 
											data-title="Selección de Cuenta" 
											data-url=""""),_display_(Seq[Any](/*112.23*/controllers/*112.34*/.contabilidad.routes.CuentasController.modalBuscar())),format.raw/*112.86*/("""" 
											data-height="650" 
											data-width="700" 
											data-listen="modal.seleccion.cuenta.simple" 
											data-label="#cuenta" 
											data-field="#cuenta_id">
									<i class="glyphicon glyphicon-search"></i>
								</a>
							</span>
						</div>
					</label>
				</div>
				<div class="col-sm-2">
					<label class="control-label"> 
						TIPO
						"""),_display_(Seq[Any](/*127.8*/select(formBuscador("tipo"),options(""->"","pagos"->"Pagos",
															"facturas"->"Facturas",
															"factura_recupero"->"Recupero facturas",
															"pago_recupero"->"Recupero pagos",
															"nt_recupero"->"Recupero Notas"), 'class -> "form-control select"))),format.raw/*131.82*/("""
					</label>
				</div>
			</div>
			<div class="row" >
				<div class="col-sm-2">
					<label class="control-label">Expediente</label>
						<div class="input-group">
							"""),_display_(Seq[Any](/*139.9*/inputText(formBuscador("expediente.nombre"), 'name -> "", 'class -> "form-control", 'id -> "expediente"))),format.raw/*139.113*/("""
							"""),_display_(Seq[Any](/*140.9*/inputText(formBuscador("expediente.id"), 'hidden -> "hidden", 'id -> "expediente_id"))),format.raw/*140.94*/("""
							<span class="input-group-addon">
								<a href="#" class="searchModal"
											id="searchExpediente" 
											data-title="Selección de expediente" 
											data-url=""""),_display_(Seq[Any](/*145.23*/controllers/*145.34*/.expediente.routes.ExpedientesController.modalBuscar())),format.raw/*145.88*/("""" 
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
				<label for="orden_pago_id" class="control-label">Orden de pago N° 
					<div class="input-group">
						"""),_display_(Seq[Any](/*159.8*/inputText(formBuscador("ordenPago.numero"), 'class -> "form-control", 'id -> "orden_pago"))),format.raw/*159.98*/("""
						"""),_display_(Seq[Any](/*160.8*/inputText(formBuscador("ordenPago.id"),'hidden -> "hidden", 'id -> "orden_pago_id"))),format.raw/*160.91*/("""
						<span class="input-group-addon">
							<a href="#" class="searchModal"
										id="searchOp" 
										data-title="Selección de órdenes de pago" 
										data-url=""""),_display_(Seq[Any](/*165.22*/controllers/*165.33*/.contabilidad.routes.OrdenesPagosController.modalBuscar())),format.raw/*165.90*/("""" 
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
					<a href=""""),_display_(Seq[Any](/*186.16*/controllers/*186.27*/.contabilidad.routes.BalanceController.index())),format.raw/*186.73*/("""?cuenta_propia_id=2"  class="form-control btn btn-default">Limpiar</a>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>
<div class="row">
	<div class="col-sm-12">
	"""),_display_(Seq[Any](/*195.3*/if(buscador.getTotalRowCount == 0)/*195.37*/ {_display_(Seq[Any](format.raw/*195.39*/("""
        
        <div class="well">
            <em>No se encuentran Lineas</em>
        </div>
        
    """)))}/*201.7*/else/*201.12*/{_display_(Seq[Any](format.raw/*201.13*/("""
		Mostrando """),_display_(Seq[Any](/*202.14*/buscador/*202.22*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*202.54*/(""" resultado(s). 
		
		<table id="listaBalanceCuentaPropia" class="table table-striped table-bordered">
			<thead>
				<tr>
					<th width="30"><input type="checkbox" name="checkAll" id="checkAll"/></th>
					<th>Asiento</th>
					<th>Cuenta</th>
					<th>Cuenta Balance</th>
					<th>OP</th> 
					<th>Exp</th>
					<th>Fecha</th>
					<th>DEBE</th>
					<th>HABER</th>
					<th>Estado</th>
					<th>Tipo</th>
					
				</tr>
			</thead>
			<tbody>
			"""),_display_(Seq[Any](/*222.5*/for(bcp <- buscador.getList) yield /*222.33*/ {_display_(Seq[Any](format.raw/*222.35*/("""
				<tr class=" """),_display_(Seq[Any](/*223.18*/getClassEstado(bcp.estado))),format.raw/*223.44*/("""" data-estado="" data-href="">
					<td><input type="checkbox" name="check_listado[]" value=""""),_display_(Seq[Any](/*224.64*/bcp/*224.67*/.id)),format.raw/*224.70*/("""" class="notSeleccion" id="check-"""),_display_(Seq[Any](/*224.104*/bcp/*224.107*/.id)),format.raw/*224.110*/(""""/></td>
					<td>"""),_display_(Seq[Any](/*225.11*/if(bcp.asiento != null)/*225.34*/ {_display_(Seq[Any](_display_(Seq[Any](/*225.37*/bcp/*225.40*/.asiento))))})),format.raw/*225.49*/(""" </td>
					<td>"""),_display_(Seq[Any](/*226.11*/if(bcp.cuentaPropia != null)/*226.39*/ {_display_(Seq[Any](_display_(Seq[Any](/*226.42*/bcp/*226.45*/.cuentaPropia.nombre))))})),format.raw/*226.66*/(""" -"""),_display_(Seq[Any](/*226.69*/bcp/*226.72*/.id)),format.raw/*226.75*/("""<br> """),_display_(Seq[Any](/*226.81*/if(bcp.referencia != null)/*226.107*/ {_display_(Seq[Any](_display_(Seq[Any](/*226.110*/bcp/*226.113*/.referencia))))})),format.raw/*226.125*/("""</td>
					<td>"""),_display_(Seq[Any](/*227.11*/if(bcp.cuenta != null)/*227.33*/ {_display_(Seq[Any](_display_(Seq[Any](/*227.36*/bcp/*227.39*/.cuenta.nombre)),format.raw/*227.53*/(""" - """),_display_(Seq[Any](/*227.57*/bcp/*227.60*/.cuenta.code))))})),format.raw/*227.73*/(""" </td>
					
					<td>
						"""),_display_(Seq[Any](/*230.8*/if(bcp.orden_pago_id != null)/*230.37*/{_display_(Seq[Any](format.raw/*230.38*/("""
							"""),_display_(Seq[Any](/*231.9*/bcp/*231.12*/.ordenPago.getNombreCompleto())),format.raw/*231.42*/("""
						""")))})),format.raw/*232.8*/("""	
					</td>
					<td>
						"""),_display_(Seq[Any](/*235.8*/if(bcp.expediente_id != null)/*235.37*/{_display_(Seq[Any](format.raw/*235.38*/("""
							"""),_display_(Seq[Any](/*236.9*/bcp/*236.12*/.expediente.getExpedienteEjercicio())),format.raw/*236.48*/("""
						""")))})),format.raw/*237.8*/("""
					</td>		
					<td class="fecha">"""),_display_(Seq[Any](/*239.25*/if(bcp.fecha != null)/*239.46*/{_display_(Seq[Any](_display_(Seq[Any](/*239.48*/(utils.DateUtils.formatDate(bcp.fecha))))))})),format.raw/*239.88*/("""</td>
					<td class="">"""),_display_(Seq[Any](/*240.20*/(utils.NumberUtils.moneda(bcp.debe)))),format.raw/*240.56*/("""</td>
					<td class="">"""),_display_(Seq[Any](/*241.20*/(utils.NumberUtils.moneda(bcp.haber)))),format.raw/*241.57*/("""</td>
					<td class="estado">"""),_display_(Seq[Any](/*242.26*/if(bcp.estado != null)/*242.48*/{_display_(Seq[Any](_display_(Seq[Any](/*242.50*/(bcp.estado.nombre)))))})),format.raw/*242.70*/("""</td>
					<td class="">"""),_display_(Seq[Any](/*243.20*/bcp/*243.23*/.tipo)),format.raw/*243.28*/("""</td>
					 
				</tr>	
				"""),_display_(Seq[Any](/*246.6*/{debe = debe.add(bcp.debe)})),format.raw/*246.33*/("""   
				"""),_display_(Seq[Any](/*247.6*/{haber = haber.add(bcp.haber)})),format.raw/*247.36*/("""   
			""")))})),format.raw/*248.5*/("""
			</tbody>
	        <tfoot>
	        	<tr>	
	        		<td colspan="7">Mostrando """),_display_(Seq[Any](/*252.39*/buscador/*252.47*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*252.79*/(""" resultado(s).</td>
	        		<td><b>Total DEBE:</b> <span class="totalFooter">"""),_display_(Seq[Any](/*253.62*/(utils.NumberUtils.moneda(debe)))),format.raw/*253.94*/("""</span></td>
	        		<td><b>Total HABER:</b> <span class="totalCreditoFooter">"""),_display_(Seq[Any](/*254.70*/(utils.NumberUtils.moneda(haber)))),format.raw/*254.103*/("""</span></td>
	        		<td colspan="2"></td>
	        	</tr>
	        </tfoot>
        </table>
		
		<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*261.8*/views/*261.13*/.html.helpers.paginadorTodos(buscador, controllers.contabilidad.routes.BalanceController.index()))),format.raw/*261.110*/("""
		</div>
	""")))})),format.raw/*263.3*/("""
	</div>	
</div>

""")))})))}
    }
    
    def render(buscador:utils.pagination.Pagination[Balance],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[Balance],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:41 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/balance/indexBalance.scala.html
                    HASH: 58a44c5a96ae27b04e0b8026ccf4f02fad722fa3
                    MATRIX: 844->1|1139->293|1153->300|1237->304|1288->320|1302->326|1372->375|1439->222|1471->246|1529->414|1552->428|1781->76|1809->290|1837->411|1866->627|1904->630|1917->635|1980->689|2020->691|2621->1256|2641->1267|2720->1323|2895->1462|2915->1473|2999->1534|3164->1663|3184->1674|3260->1727|3820->2250|3841->2261|3923->2320|4097->2457|4118->2468|4202->2529|4376->2666|4397->2677|4479->2736|4930->3151|5011->3210|5226->3389|5307->3448|5499->3605|5662->3745|5836->3884|5987->4012|6030->4020|6181->4148|6323->4255|6483->4393|6666->4540|6786->4636|6831->4645|6931->4722|7146->4900|7167->4911|7242->4963|7664->5349|7974->5636|8188->5814|8316->5918|8361->5927|8469->6012|8692->6198|8713->6209|8790->6263|9265->6702|9378->6792|9422->6800|9528->6883|9743->7061|9764->7072|9844->7129|10574->7822|10595->7833|10664->7879|10874->8053|10918->8087|10959->8089|11089->8201|11103->8206|11143->8207|11194->8221|11212->8229|11267->8261|11755->8713|11800->8741|11841->8743|11896->8761|11945->8787|12076->8881|12089->8884|12115->8887|12187->8921|12201->8924|12228->8927|12284->8946|12317->8969|12367->8972|12380->8975|12416->8984|12470->9001|12508->9029|12558->9032|12571->9035|12619->9056|12659->9059|12672->9062|12698->9065|12741->9071|12778->9097|12829->9100|12843->9103|12883->9115|12936->9131|12968->9153|13018->9156|13031->9159|13068->9173|13109->9177|13122->9180|13162->9193|13228->9223|13267->9252|13307->9253|13352->9262|13365->9265|13418->9295|13458->9303|13524->9333|13563->9362|13603->9363|13648->9372|13661->9375|13720->9411|13760->9419|13835->9457|13866->9478|13915->9480|13982->9520|14044->9545|14103->9581|14165->9606|14225->9643|14293->9674|14325->9696|14374->9698|14421->9718|14483->9743|14496->9746|14524->9751|14589->9780|14639->9807|14684->9816|14737->9846|14777->9854|14898->9938|14916->9946|14971->9978|15089->10059|15144->10091|15263->10173|15320->10206|15501->10351|15516->10356|15637->10453|15681->10465
                    LINES: 26->1|33->6|33->6|35->6|36->7|36->7|36->7|37->5|37->5|37->10|37->10|47->1|48->5|49->8|51->19|53->21|53->21|53->21|53->21|69->37|69->37|69->37|72->40|72->40|72->40|75->43|75->43|75->43|88->56|88->56|88->56|89->57|89->57|89->57|90->58|90->58|90->58|103->71|103->71|107->75|107->75|115->83|116->84|123->91|123->91|124->92|124->92|130->98|131->99|138->106|138->106|139->107|139->107|144->112|144->112|144->112|159->127|163->131|171->139|171->139|172->140|172->140|177->145|177->145|177->145|191->159|191->159|192->160|192->160|197->165|197->165|197->165|218->186|218->186|218->186|227->195|227->195|227->195|233->201|233->201|233->201|234->202|234->202|234->202|254->222|254->222|254->222|255->223|255->223|256->224|256->224|256->224|256->224|256->224|256->224|257->225|257->225|257->225|257->225|257->225|258->226|258->226|258->226|258->226|258->226|258->226|258->226|258->226|258->226|258->226|258->226|258->226|258->226|259->227|259->227|259->227|259->227|259->227|259->227|259->227|259->227|262->230|262->230|262->230|263->231|263->231|263->231|264->232|267->235|267->235|267->235|268->236|268->236|268->236|269->237|271->239|271->239|271->239|271->239|272->240|272->240|273->241|273->241|274->242|274->242|274->242|274->242|275->243|275->243|275->243|278->246|278->246|279->247|279->247|280->248|284->252|284->252|284->252|285->253|285->253|286->254|286->254|293->261|293->261|293->261|295->263
                    -- GENERATED --
                */
            