
package views.html.haberes.liquidacionMeses

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
object indexLiquidacionMes extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[models.haberes.LiquidacionMes],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[models.haberes.LiquidacionMes], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

def /*8.2*/scripts/*8.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*8.13*/("""
	<script src=""""),_display_(Seq[Any](/*9.16*/routes/*9.22*/.Assets.at("javascripts/haberes/liquidacionMes.js"))),format.raw/*9.73*/("""" type="text/javascript"></script>
""")))};implicit def /*6.2*/implicitFieldConstructor/*6.26*/ = {{ FieldConstructor(simpleInput.render) }};def /*12.2*/getClassEstado/*12.16*/(i:Estado) = {{
	var classEstado:String = new String()
	if(i != null && (i.id == 57)){
		classEstado = "borrador"
	}else if(i != null && i.id == 78){
		classEstado = "cancelada"
	}else if(i != null && i.id == 58){
		classEstado = "autorizado"
	}else if(i != null && i.id == 102){
		classEstado = "ordenPrecurso"
	}
	classEstado
	
}};
Seq[Any](format.raw/*1.99*/("""
"""),format.raw/*5.1*/("""
"""),format.raw/*6.70*/(""" 

"""),format.raw/*10.2*/("""

"""),format.raw/*25.2*/("""

"""),_display_(Seq[Any](/*27.2*/views/*27.7*/.html.haberes.mainHaberes("Lista de liquidaciones", scripts)/*27.67*/ {_display_(Seq[Any](format.raw/*27.69*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Lista de Liquidacion</h1>
			</div>
	
			<div class="col-sm-5">
				<div class="pull-right btn-header">
					<a href=""""),_display_(Seq[Any](/*37.16*/controllers/*37.27*/.haberes.routes.LiquidacionMesesController.crear())),format.raw/*37.77*/("""?"""),_display_(Seq[Any](/*37.79*/UriTrack/*37.87*/.encode())),format.raw/*37.96*/(""""  class="form-control btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nueva Liquidación</a>
				</div>
				
				<div class="dropdown pull-right btn-header">
				  	<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-expanded="true">
				    	<i class="glyphicon glyphicon-list-alt"></i> 
				    	Reportes
				    	<span class="caret"></span>
				  	</button>
					<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
						<!-- <li role="presentation"><a data-title="Datos export macro sueldos" role="menuitem" tabindex="-1" data-url=""""),_display_(Seq[Any](/*47.120*/controllers/*47.131*/.haberes.routes.LiquidacionAccionesController.exportMacroSueldosLista(false))),format.raw/*47.207*/("""" id="modalExportMacroSueldosLista">Datos exportacion MACRO SUELDOS</a></li> -->
						<li role="presentation"><a data-title="Datos export macro sueldos" role="menuitem" tabindex="-1" data-url=""""),_display_(Seq[Any](/*48.115*/controllers/*48.126*/.haberes.routes.LiquidacionAccionesController.exportMacroSueldosLista(true))),format.raw/*48.201*/("""" id="modalExportMacroSueldosListaNuevo">Datos exportacion MACRO SUELDOS NUEVO</a></li>
						"""),_display_(Seq[Any](/*49.8*/if(Permiso.check("reporteDatosAfip"))/*49.45*/ {_display_(Seq[Any](format.raw/*49.47*/("""
							<!-- <li role="presentation"><a data-title="Datos Afip" role="menuitem" tabindex="-1" data-url=""""),_display_(Seq[Any](/*50.105*/controllers/*50.116*/.haberes.routes.LiquidacionMesesReportesController.modalDatosAfip())),format.raw/*50.183*/("""" id="modalDatosAfip">Datos Afip</a></li> -->
							<li role="presentation"><a data-title="Datos Afip" role="menuitem" tabindex="-1" data-url=""""),_display_(Seq[Any](/*51.100*/controllers/*51.111*/.haberes.routes.LiquidacionMesesReportesController.reportesDatosAfip())),format.raw/*51.181*/("""" id="modalDatosAfip">Datos Afip</a></li>
						""")))})),format.raw/*52.8*/("""
						"""),_display_(Seq[Any](/*53.8*/if(Permiso.check("reporteDatosAfipGanancias"))/*53.54*/ {_display_(Seq[Any](format.raw/*53.56*/("""
							<li role="presentation"><a data-title="Datos Afip Ganancias" role="menuitem" tabindex="-1" data-url=""""),_display_(Seq[Any](/*54.110*/controllers/*54.121*/.haberes.routes.LiquidacionMesesReportesController.modalDatosAfipGanancias())),format.raw/*54.197*/("""" id="modalDatosAfipGanancias">Datos Afip Ganancias</a></li>
							<li role="presentation"><a data-title="Datos Control Afip Ganancias" role="menuitem" tabindex="-1" data-url=""""),_display_(Seq[Any](/*55.118*/controllers/*55.129*/.haberes.routes.LiquidacionMesesReportesController.modalControlDatosAfipGanancias())),format.raw/*55.212*/("""" id="modalControlDatosAfipGanancias">Datos Afip Control Ganancias</a></li>
						""")))})),format.raw/*56.8*/("""

						
					</ul>
				</div>
				
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*66.3*/views/*66.8*/.html.tags.successError())),format.raw/*66.33*/("""
	
	<div id="actions">
		<form action="" method="GET">
			<div class="row">
				<div class="col-sm-2">
					<div class="form-group">
						<label for="nombre" class="control-label">N° Liquidación
						"""),_display_(Seq[Any](/*74.8*/inputText(formBuscador("nro_liquidacion_parque"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*74.110*/("""
						</label>
					</div>
				</div>
				<div class="col-sm-2">
				<label class="control-label">Expediente</label>
					<div class="input-group">
						"""),_display_(Seq[Any](/*81.8*/inputText(formBuscador("expediente.nombre"), 'name -> "", 'class -> "form-control", 'id -> "expediente"))),format.raw/*81.112*/("""
						"""),_display_(Seq[Any](/*82.8*/inputText(formBuscador("expediente.id"), 'hidden -> "hidden", 'id -> "expediente_id"))),format.raw/*82.93*/("""
						<span class="input-group-addon">
							<a href="#" class="searchModal"
										id="searchExpediente" 
										data-title="Selección de expediente" 
										data-url=""""),_display_(Seq[Any](/*87.22*/controllers/*87.33*/.expediente.routes.ExpedientesController.modalBuscar())),format.raw/*87.87*/("""" 
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
					<label for="inputPeriodo" class="control-label">Periodo</label> 
					<div class="input-group">
						"""),_display_(Seq[Any](/*101.8*/inputText(formBuscador("periodo"),'class -> "form-control",'id -> "periodo"))),format.raw/*101.84*/("""
						"""),_display_(Seq[Any](/*102.8*/inputText(formBuscador("periodo_id"),'hidden -> "hidden",'id -> "periodo_id"))),format.raw/*102.85*/("""
						<span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchPeriodo" 
									data-title="Selección de Periodo" 
									data-url=""""),_display_(Seq[Any](/*107.21*/controllers/*107.32*/.contabilidad.routes.PeriodosController.modalBuscar())),format.raw/*107.85*/("""" 
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
				<div class="col-sm-2 input-group">
					<label class="control-label">Orden de Pago N°</label>
					<div>
					"""),_display_(Seq[Any](/*121.7*/inputText(formBuscador("numero_orden_pago_desde"), 
							  'class -> "form-control", 
							  'id -> "numero_orden_pago_desde", 
							  'style -> "width: 71px;font-size:11px;", 
							  'placeholder -> "Desde"))),format.raw/*125.34*/("""
					"""),_display_(Seq[Any](/*126.7*/inputText(formBuscador("numero_orden_pago_hasta"), 
							  'class -> "form-control", 
							  'id -> "numero_orden_pago_hasta", 
							  'style -> "width: 71px;font-size:11px;", 'placeholder -> "Hasta"))),format.raw/*129.75*/("""
					</div>
				</div>
				<div class="col-sm-2 input-group">
					<label class="control-label">Fecha Pago</label>
					<div>
						"""),_display_(Seq[Any](/*135.8*/inputText(formBuscador("fecha_pago_desde"), 'class -> "form-control inputDateMascara", 'id -> "fecha_pago_desde", 'placeholder -> "Desde"))),format.raw/*135.146*/("""
						"""),_display_(Seq[Any](/*136.8*/inputText(formBuscador("fecha_pago_hasta"), 'class -> "form-control inputDateMascara", 'id -> "fecha_pago_hasta", 'placeholder -> "Hasta"))),format.raw/*136.146*/("""
					</div>
				</div>
				<div class="col-sm-2">
					<label class="control-label"> 
						C/M
						"""),_display_(Seq[Any](/*142.8*/select(formBuscador("cm"),options(""->"","SI"->"SI","NO"->"NO"), 'class -> "form-control select"))),format.raw/*142.105*/("""
					</label>
				</div>
			</div>	
			<div class="row">	
				<div class="col-sm-2">
					<div class="form-group">
					<label for="buscar" class="control-label">&nbsp;</label>
					<button  class="form-control btn btn-primary">Buscar</button>
					</div>
				</div>
				<div class="col-sm-2">
					<div class="form-group">
					<label for="limpiar" class="control-label">&nbsp;</label>
					<a href=""""),_display_(Seq[Any](/*156.16*/controllers/*156.27*/.haberes.routes.LiquidacionMesesController.index())),format.raw/*156.77*/(""""  class="form-control btn btn-default">Limpiar</a>
					</div>
				</div>
			</div>
		</form>
	</div>
	
	"""),_display_(Seq[Any](/*163.3*/if(buscador.getTotalRowCount == 0)/*163.37*/ {_display_(Seq[Any](format.raw/*163.39*/("""
        
        <div class="well">
            <em>No se encuentran Liquidaciones</em>
        </div>
        
    """)))}/*169.7*/else/*169.12*/{_display_(Seq[Any](format.raw/*169.13*/("""
    
    	Mostrando """),_display_(Seq[Any](/*171.17*/buscador/*171.25*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*171.57*/(""" resultado(s). 
		
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th width="30">
						<input type="checkbox" name="checkAll" id="checkAll"/>
					</th>
					<th width="30">#</th>
					<th>N° Liquidación</th>
					<th>Titulo</th>
					<th>Convenio</th>
					<th>Expediente</th>
					<th>Periodo</th>
					<th>Total C/A</th>
					<th>Total S/A</th>
					<th>Total Ret.</th>
					<th>Total a Cobrar</th>
					<th width="60">Estado</th>
					<th width="30">#</th>
				</tr>
			</thead>
			<tbody>
			"""),_display_(Seq[Any](/*194.5*/for(lc <- buscador.getList) yield /*194.32*/ {_display_(Seq[Any](format.raw/*194.34*/("""
				<tr class="pointer """),_display_(Seq[Any](/*195.25*/getClassEstado(lc.estado))),format.raw/*195.50*/("""" data-href=""""),_display_(Seq[Any](/*195.64*/controllers/*195.75*/.haberes.routes.LiquidacionMesesController.ver(lc.id))),format.raw/*195.128*/("""&"""),_display_(Seq[Any](/*195.130*/UriTrack/*195.138*/.encode())),format.raw/*195.147*/("""">
					<td><input type="checkbox" name="check_listado[]" value=""""),_display_(Seq[Any](/*196.64*/lc/*196.66*/.id)),format.raw/*196.69*/("""" class="notSeleccion" id="check-"""),_display_(Seq[Any](/*196.103*/lc/*196.105*/.id)),format.raw/*196.108*/(""""/></td>
					<td>
						"""),_display_(Seq[Any](/*198.8*/if(Permiso.check("liquidacionMesEditar"))/*198.49*/ {_display_(Seq[Any](format.raw/*198.51*/("""
						<a class="btn btn-default btn-xs notSeleccion" href=""""),_display_(Seq[Any](/*199.61*/controllers/*199.72*/.haberes.routes.LiquidacionMesesController.editar(lc.id))),format.raw/*199.128*/("""&"""),_display_(Seq[Any](/*199.130*/UriTrack/*199.138*/.encode())),format.raw/*199.147*/("""">
							<i class="glyphicon glyphicon-edit"></i>
						</a>
						""")))})),format.raw/*202.8*/("""
					</td>
					<td>"""),_display_(Seq[Any](/*204.11*/(lc.nro_liquidacion_parque))),format.raw/*204.38*/("""</td>
					<td>"""),_display_(Seq[Any](/*205.11*/(lc.titulo))),format.raw/*205.22*/("""</td>
					<td>"""),_display_(Seq[Any](/*206.11*/if(lc.convenio_ministerio)/*206.37*/{_display_(Seq[Any](format.raw/*206.38*/("""SI""")))}/*206.41*/else/*206.45*/{_display_(Seq[Any](format.raw/*206.46*/("""NO""")))})),format.raw/*206.49*/("""</td>
					<td>"""),_display_(Seq[Any](/*207.11*/if(lc.expediente != null)/*207.36*/{_display_(Seq[Any](_display_(Seq[Any](/*207.38*/(lc.expediente.getExpedienteEjercicio())))))})),format.raw/*207.79*/("""</td>
					<td>"""),_display_(Seq[Any](/*208.11*/(lc.periodo.nombre))),format.raw/*208.30*/("""</td>
					<td>"""),_display_(Seq[Any](/*209.11*/utils/*209.16*/.NumberUtils.moneda(lc.getTotalCA()))),format.raw/*209.52*/("""</td>
					<td>"""),_display_(Seq[Any](/*210.11*/utils/*210.16*/.NumberUtils.moneda(lc.getTotalSA()))),format.raw/*210.52*/("""</td>
					<td>"""),_display_(Seq[Any](/*211.11*/utils/*211.16*/.NumberUtils.moneda(lc.getTotalRetenciones()))),format.raw/*211.61*/("""</td>
					<td>"""),_display_(Seq[Any](/*212.11*/utils/*212.16*/.NumberUtils.moneda(lc.getTotalACobrar()))),format.raw/*212.57*/("""</td>
					<td>"""),_display_(Seq[Any](/*213.11*/if(lc.estado != null)/*213.32*/{_display_(Seq[Any](_display_(Seq[Any](/*213.34*/lc/*213.36*/.estado.nombre))))})),format.raw/*213.51*/("""</td>
					<td>
						"""),_display_(Seq[Any](/*215.8*/if(Permiso.check("liquidacionMesEliminar"))/*215.51*/ {_display_(Seq[Any](format.raw/*215.53*/("""
						<a class="btn btn-default btn-xs delete-confirm-link notSeleccion" href=""""),_display_(Seq[Any](/*216.81*/controllers/*216.92*/.haberes.routes.LiquidacionMesesController.eliminar(lc.id))),format.raw/*216.150*/("""&"""),_display_(Seq[Any](/*216.152*/UriTrack/*216.160*/.encode())),format.raw/*216.169*/("""">
							<i class="glyphicon glyphicon-trash icono-eliminar"></i>
						</a>
						""")))})),format.raw/*219.8*/("""
					</td>
				</tr>
             """)))})),format.raw/*222.15*/("""
	        </tbody>
        </table>
        
        <div class="pagination pull-right">
		    """),_display_(Seq[Any](/*227.8*/views/*227.13*/.html.helpers.paginador(buscador, controllers.haberes.routes.LiquidacionMesesController.index()))),format.raw/*227.109*/("""
		</div>
 	 """)))})),format.raw/*229.5*/("""
""")))})))}
    }
    
    def render(buscador:utils.pagination.Pagination[models.haberes.LiquidacionMes],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[models.haberes.LiquidacionMes],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/liquidacionMeses/indexLiquidacionMes.scala.html
                    HASH: 3b2e6fa411523ebbe00d3b7e78353890d99d28de
                    MATRIX: 877->1|1105->228|1119->235|1203->239|1254->255|1268->261|1340->312|1407->156|1439->180|1497->351|1520->365|1881->98|1908->154|1936->224|1966->348|1995->696|2033->699|2046->704|2115->764|2155->766|2393->968|2413->979|2485->1029|2523->1031|2540->1039|2571->1048|3236->1676|3257->1687|3356->1763|3588->1958|3609->1969|3707->2044|3837->2139|3883->2176|3923->2178|4065->2283|4086->2294|4176->2361|4358->2506|4379->2517|4472->2587|4552->2636|4595->2644|4650->2690|4690->2692|4837->2802|4858->2813|4957->2889|5172->3067|5193->3078|5299->3161|5413->3244|5515->3311|5528->3316|5575->3341|5813->3544|5938->3646|6129->3802|6256->3906|6299->3914|6406->3999|6623->4180|6643->4191|6719->4245|7184->4674|7283->4750|7327->4758|7427->4835|7635->5006|7656->5017|7732->5070|8161->5463|8400->5679|8443->5686|8672->5892|8842->6026|9004->6164|9048->6172|9210->6310|9350->6414|9471->6511|9911->6914|9932->6925|10005->6975|10148->7082|10192->7116|10233->7118|10370->7237|10384->7242|10424->7243|10483->7265|10501->7273|10556->7305|11122->7835|11166->7862|11207->7864|11269->7889|11317->7914|11368->7928|11389->7939|11466->7992|11506->7994|11525->8002|11558->8011|11661->8077|11673->8079|11699->8082|11771->8116|11784->8118|11811->8121|11873->8147|11924->8188|11965->8190|12063->8251|12084->8262|12164->8318|12204->8320|12223->8328|12256->8337|12357->8406|12416->8428|12466->8455|12519->8471|12553->8482|12606->8498|12642->8524|12682->8525|12705->8528|12719->8532|12759->8533|12795->8536|12848->8552|12883->8577|12932->8579|13000->8620|13053->8636|13095->8655|13148->8671|13163->8676|13222->8712|13275->8728|13290->8733|13349->8769|13402->8785|13417->8790|13485->8835|13538->8851|13553->8856|13617->8897|13670->8913|13701->8934|13750->8936|13762->8938|13804->8953|13863->8976|13916->9019|13957->9021|14075->9102|14096->9113|14178->9171|14218->9173|14237->9181|14270->9190|14387->9275|14456->9311|14588->9407|14603->9412|14723->9508|14769->9522
                    LINES: 26->1|33->8|33->8|35->8|36->9|36->9|36->9|37->6|37->6|37->12|37->12|51->1|52->5|53->6|55->10|57->25|59->27|59->27|59->27|59->27|69->37|69->37|69->37|69->37|69->37|69->37|79->47|79->47|79->47|80->48|80->48|80->48|81->49|81->49|81->49|82->50|82->50|82->50|83->51|83->51|83->51|84->52|85->53|85->53|85->53|86->54|86->54|86->54|87->55|87->55|87->55|88->56|98->66|98->66|98->66|106->74|106->74|113->81|113->81|114->82|114->82|119->87|119->87|119->87|133->101|133->101|134->102|134->102|139->107|139->107|139->107|153->121|157->125|158->126|161->129|167->135|167->135|168->136|168->136|174->142|174->142|188->156|188->156|188->156|195->163|195->163|195->163|201->169|201->169|201->169|203->171|203->171|203->171|226->194|226->194|226->194|227->195|227->195|227->195|227->195|227->195|227->195|227->195|227->195|228->196|228->196|228->196|228->196|228->196|228->196|230->198|230->198|230->198|231->199|231->199|231->199|231->199|231->199|231->199|234->202|236->204|236->204|237->205|237->205|238->206|238->206|238->206|238->206|238->206|238->206|238->206|239->207|239->207|239->207|239->207|240->208|240->208|241->209|241->209|241->209|242->210|242->210|242->210|243->211|243->211|243->211|244->212|244->212|244->212|245->213|245->213|245->213|245->213|245->213|247->215|247->215|247->215|248->216|248->216|248->216|248->216|248->216|248->216|251->219|254->222|259->227|259->227|259->227|261->229
                    -- GENERATED --
                */
            