
package views.html.haberes.novedades

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
object indexNovedades extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[models.haberes.Novedad],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[models.haberes.Novedad], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

def /*8.2*/scripts/*8.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*8.13*/("""
	<script src=""""),_display_(Seq[Any](/*9.16*/routes/*9.22*/.Assets.at("javascripts/haberes/novedades.js"))),format.raw/*9.68*/("""" type="text/javascript"></script>
""")))};implicit def /*6.2*/implicitFieldConstructor/*6.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.92*/("""
"""),format.raw/*5.1*/("""
"""),format.raw/*6.70*/(""" 

"""),format.raw/*10.2*/("""

"""),_display_(Seq[Any](/*12.2*/views/*12.7*/.html.haberes.mainHaberes("Lista de novedades", scripts)/*12.63*/ {_display_(Seq[Any](format.raw/*12.65*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Lista de novedades</h1>
			</div>
	
			<div class="col-sm-5">
				<div class="pull-right btn-header">
					<a href=""""),_display_(Seq[Any](/*22.16*/controllers/*22.27*/.haberes.routes.NovedadesController.crear())),format.raw/*22.70*/("""?"""),_display_(Seq[Any](/*22.72*/UriTrack/*22.80*/.encode())),format.raw/*22.89*/(""""  class="form-control btn btn-default"><i class="glyphicon glyphicon-plus"></i> Crear novedades</a>
				</div>

				<div class="pull-right btn-header">
					<a href=""""),_display_(Seq[Any](/*26.16*/controllers/*26.27*/.haberes.routes.NovedadesAccionesController.crearMasivo())),format.raw/*26.84*/("""?"""),_display_(Seq[Any](/*26.86*/UriTrack/*26.94*/.encode())),format.raw/*26.103*/(""""  class="form-control btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Crear novedades masivamente</a>
				</div>

			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*33.3*/views/*33.8*/.html.tags.successError())),format.raw/*33.33*/("""
	<div id="actions">
		<form action="" method="GET">
			<div class="row">
		
				<div class="col-sm-3">
					<label class="control-label">Puesto laboral</label>
					<div class="input-group">
					"""),_display_(Seq[Any](/*41.7*/inputText(formBuscador("puestoLaboral.legajo.agente.apellido"),'class -> "form-control", 'id -> "puesto_laboral"))),format.raw/*41.120*/("""
						"""),_display_(Seq[Any](/*42.8*/inputText(formBuscador("puesto_laboral_id"), 'hidden -> "hidden", 'id -> "puesto_laboral_id"))),format.raw/*42.101*/("""
						<span class="input-group-addon">
							<a href="#" class="searchModal"
										id="searchPuestoLaboral" 
										data-title="Selección de puesto laboral" 
										data-url=""""),_display_(Seq[Any](/*47.22*/controllers/*47.33*/.haberes.routes.PuestosLaboralesController.modalBuscar())),format.raw/*47.89*/("""" 
										data-height="650" 
										data-width="700" 
										data-listen="modal.seleccion.puestoLaboral.simple" 
										data-label="#puesto_laboral" 
										data-field="#puesto_laboral_id">
								<i class="glyphicon glyphicon-search"></i>
							</a>
						</span>
					</div>
				</div>	
						
				<div class="col-sm-2 input-group">
					<label class="control-label">Fecha Fin</label>
					<div>
					"""),_display_(Seq[Any](/*62.7*/inputText(formBuscador("fecha_desde"), 'class -> "form-control inputDateMascara", 'id -> "desde", 'placeholder -> "Desde"))),format.raw/*62.129*/("""
					"""),_display_(Seq[Any](/*63.7*/inputText(formBuscador("fecha_hasta"), 'class -> "form-control inputDateMascara", 'id -> "hasta", 'placeholder -> "Hasta"))),format.raw/*63.129*/("""
					</div>
				</div>
				
				<div class="col-sm-2">
					<label class="control-label">Tipo
					"""),_display_(Seq[Any](/*69.7*/select(formBuscador("liquidacion_tipo_id"), models.haberes.LiquidacionTipo.getTipos().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*69.192*/("""
					</label>
				</div>
						
				<div class="col-sm-2">
					<label class="control-label"> 
						Tipo de carga
						"""),_display_(Seq[Any](/*76.8*/select(formBuscador("carga"),options(""->"Ambos","manual"->"Manual","masiva"->"Masiva"), 'class -> "form-control select"))),format.raw/*76.129*/("""
					</label>
				</div>
				<div class="col-sm-3">
					<div class="col-sm-6">
						<label class="control-label"> 
							Estado
							"""),_display_(Seq[Any](/*83.9*/select(formBuscador("activo"),options("activo"->"Activo",""->"Todos","desactivo"->"Desactivo"), 'class -> "form-control select"))),format.raw/*83.137*/("""
						</label>
					</div>
					<div class="col-sm-6">
						<label class="control-label"> 
							C/M
							"""),_display_(Seq[Any](/*89.9*/select(formBuscador("cm"),options(""->"","SI"->"SI","NO"->"NO"), 'class -> "form-control select"))),format.raw/*89.106*/("""
						</label>
					</div>
				</div>
			</div>
			<div class="row">
		
				<div class="col-sm-3">
					<label class="control-label">Concepto</label>
					<div class="input-group">
						"""),_display_(Seq[Any](/*99.8*/inputText(formBuscador("concepto.denominacion"), 'class -> "form-control", 'id -> "concepto"))),format.raw/*99.101*/("""
						"""),_display_(Seq[Any](/*100.8*/inputText(formBuscador("liquidacion_concepto_id"), 'hidden -> "hidden", 'id -> "liquidacion_concepto_id"))),format.raw/*100.113*/("""
						<span class="input-group-addon"><a href="#" id="searchConcepto" data-title="Selección de concepto" data-url=""""),_display_(Seq[Any](/*101.117*/controllers/*101.128*/.haberes.routes.LiquidacionConceptosController.modalBuscar())),format.raw/*101.188*/("""" data-height="650" data-width="700" data-listen="modal.seleccion.concepto.simple" data-label="#concepto" data-field="#liquidacion_concepto_id"><i class="glyphicon glyphicon-search"></i></a></span>
					</div>
					"""),_display_(Seq[Any](/*103.7*/formBuscador("liquidacion_concepto_id")/*103.46*/.error.map/*103.56*/{ error =>_display_(Seq[Any](format.raw/*103.66*/(""" <div class="text-error">"""),_display_(Seq[Any](/*103.92*/error/*103.97*/.message)),format.raw/*103.105*/("""</div>""")))})),format.raw/*103.112*/("""
				</div>	

				<div class="col-sm-2">
					<label for="inputPeriodo" class="control-label">Periodo de inicio</label> 
					<div class="input-group">
						"""),_display_(Seq[Any](/*109.8*/inputText(formBuscador("periodo_inicio"),'class -> "form-control",'id -> "periodo_inicio"))),format.raw/*109.98*/("""
						"""),_display_(Seq[Any](/*110.8*/inputText(formBuscador("periodo_inicio_id"),'hidden -> "hidden",'id -> "periodo_inicio_id"))),format.raw/*110.99*/("""
						<span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchPeriodoInicio" 
									data-title="Selección de Periodo" 
									data-url=""""),_display_(Seq[Any](/*115.21*/controllers/*115.32*/.contabilidad.routes.PeriodosController.modalBuscar())),format.raw/*115.85*/("""" 
									data-height="650" 
									data-width="700" 
									data-listen="modal.seleccion.periodo.simple" 
									data-label="#periodo_inicio" 
									data-field="#periodo_inicio_id">
							<i class="glyphicon glyphicon-search"></i>
						</a>
						</span>
					</div>
				</div>
			
				<div class="col-sm-2">
					<label for="inputPeriodo" class="control-label">Periodo de fin</label> 
					<div class="input-group">
						"""),_display_(Seq[Any](/*130.8*/inputText(formBuscador("periodo_fin"),'class -> "form-control",'id -> "periodo_fin"))),format.raw/*130.92*/("""
						"""),_display_(Seq[Any](/*131.8*/inputText(formBuscador("periodo_fin_id"),'hidden -> "hidden",'id -> "periodo_fin_id"))),format.raw/*131.93*/("""
						<span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchPeriodoFin" 
									data-title="Selección de Periodo" 
									data-url=""""),_display_(Seq[Any](/*136.21*/controllers/*136.32*/.contabilidad.routes.PeriodosController.modalBuscar())),format.raw/*136.85*/("""" 
									data-height="650" 
									data-width="700" 
									data-listen="modal.seleccion.periodo.simple" 
									data-label="#periodo_fin" 
									data-field="#periodo_fin_id">
							<i class="glyphicon glyphicon-search"></i>
						</a>
						</span>
					</div>
				</div>
			
				<div class="col-sm-2">
					<div class="form-group">
					<label for="buscar" class="control-label">&nbsp;</label>
					<button  class="form-control btn btn-primary">Buscar</button>
					</div>
				</div>
				<div class="col-sm-2">
					<div class="form-group">
					<label for="limpiar" class="control-label">&nbsp;</label>
					<a href=""""),_display_(Seq[Any](/*157.16*/controllers/*157.27*/.haberes.routes.NovedadesController.index())),format.raw/*157.70*/("""?activo=activo"  class="form-control btn btn-default">Limpiar</a>
					</div>
				</div>
			</div>
		</form>
	</div>


 """),_display_(Seq[Any](/*165.3*/if(buscador.getTotalRowCount == 0)/*165.37*/ {_display_(Seq[Any](format.raw/*165.39*/("""
      
      <div class="well">
          <em>No se encuentran novedades</em>
      </div>
      
  """)))}/*171.5*/else/*171.10*/{_display_(Seq[Any](format.raw/*171.11*/("""

Mostrando """),_display_(Seq[Any](/*173.12*/buscador/*173.20*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*173.52*/(""" resultado(s).   
<table class="table table-striped table-bordered table-hover">
	<thead>
		<tr>
			<th width="30"></th>
			<th>Puesto laboral</th>
			<th width="180">Concepto</th>
			<th width="90">Cantidad</th>
			<th width="90">Importe</th>
			<th width="90">P. inicio</th>
			<th width="90">P. fin</th>
			<th width="90">Fecha</th>
			<th>Tipo Liq.</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
	

	
        """),_display_(Seq[Any](/*193.10*/for(novedad <- buscador.getList) yield /*193.42*/ {_display_(Seq[Any](format.raw/*193.44*/("""
		<tr class="" data-href=""""),_display_(Seq[Any](/*194.28*/controllers/*194.39*/.haberes.routes.NovedadesController.ver(novedad.id))),format.raw/*194.90*/("""&"""),_display_(Seq[Any](/*194.92*/UriTrack/*194.100*/.encode())),format.raw/*194.109*/("""">
			<td><a class="btn btn-default btn-xs" href=""""),_display_(Seq[Any](/*195.49*/controllers/*195.60*/.haberes.routes.NovedadesController.editar(novedad.id))),format.raw/*195.114*/("""&"""),_display_(Seq[Any](/*195.116*/UriTrack/*195.124*/.encode())),format.raw/*195.133*/(""""><i class="glyphicon glyphicon-edit"></i></a></td>
			<td>"""),_display_(Seq[Any](/*196.9*/novedad/*196.16*/.puestoLaboral.legajo.agente.getNombreCompleto())),format.raw/*196.64*/("""</td>
			<td>"""),_display_(Seq[Any](/*197.9*/novedad/*197.16*/.concepto.denominacion)),format.raw/*197.38*/("""</td>
			<td>"""),_display_(Seq[Any](/*198.9*/novedad/*198.16*/.cantidad)),format.raw/*198.25*/("""</td>
			<td>"""),_display_(Seq[Any](/*199.9*/utils/*199.14*/.NumberUtils.moneda(novedad.importe))),format.raw/*199.50*/("""</td>
			<td>"""),_display_(Seq[Any](/*200.9*/novedad/*200.16*/.periodoInicio.nombre)),format.raw/*200.37*/("""</td>
			<td>"""),_display_(Seq[Any](/*201.9*/if(novedad.periodoFin != null)/*201.39*/{_display_(Seq[Any](_display_(Seq[Any](/*201.41*/novedad/*201.48*/.periodoFin.nombre))))})),format.raw/*201.67*/("""</td>
			<td>"""),_display_(Seq[Any](/*202.9*/utils/*202.14*/.DateUtils.formatDate(novedad.fecha_novedad))),format.raw/*202.58*/("""</td>
			<td>"""),_display_(Seq[Any](/*203.9*/if(novedad.liquidacionTipo != null)/*203.44*/{_display_(Seq[Any](_display_(Seq[Any](/*203.46*/novedad/*203.53*/.liquidacionTipo.nombre))))})),format.raw/*203.77*/("""</td>
			<td>
				"""),_display_(Seq[Any](/*205.6*/if(Permiso.check("liquidacionNovedadesEliminar"))/*205.55*/ {_display_(Seq[Any](format.raw/*205.57*/("""
				<a class="btn btn-default btn-xs notSeleccion" id="eliminarNovedadIndex"  href=""""),_display_(Seq[Any](/*206.86*/controllers/*206.97*/.haberes.routes.NovedadesController.eliminar(novedad.id))),format.raw/*206.153*/("""&"""),_display_(Seq[Any](/*206.155*/UriTrack/*206.163*/.encode())),format.raw/*206.172*/("""">
					<i class="glyphicon glyphicon-trash icono-eliminar"></i>
				</a>
				""")))})),format.raw/*209.6*/("""
			</td>
		</tr>
        """)))})),format.raw/*212.10*/("""
	</tbody>
</table>

<div class="pagination pull-right">
    """),_display_(Seq[Any](/*217.6*/views/*217.11*/.html.helpers.paginador(buscador, controllers.haberes.routes.NovedadesController.index()))),format.raw/*217.100*/("""
</div>

  """)))})),format.raw/*220.4*/("""
	
	
""")))})))}
    }
    
    def render(buscador:utils.pagination.Pagination[models.haberes.Novedad],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[models.haberes.Novedad],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:35 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/novedades/indexNovedades.scala.html
                    HASH: 3a0185b61e6772730cd00d2df8543327508b4554
                    MATRIX: 858->1|1082->228|1096->235|1180->239|1232->256|1246->262|1313->308|1381->154|1413->178|1487->91|1515->151|1544->222|1576->345|1616->350|1629->355|1694->411|1734->413|1980->623|2000->634|2065->677|2103->679|2120->687|2151->696|2359->868|2379->879|2458->936|2496->938|2513->946|2545->955|2748->1123|2761->1128|2808->1153|3049->1359|3185->1472|3229->1481|3345->1574|3574->1767|3594->1778|3672->1834|4143->2270|4288->2392|4331->2400|4476->2522|4618->2629|4826->2814|4991->2944|5135->3065|5317->3212|5468->3340|5621->3458|5741->3555|5975->3754|6091->3847|6136->3856|6265->3961|6421->4079|6443->4090|6527->4150|6781->4368|6830->4407|6850->4417|6899->4427|6962->4453|6977->4458|7009->4466|7050->4473|7251->4638|7364->4728|7409->4737|7523->4828|7742->5010|7763->5021|7839->5074|8328->5527|8435->5611|8480->5620|8588->5705|8804->5884|8825->5895|8901->5948|9593->6603|9614->6614|9680->6657|9845->6786|9889->6820|9930->6822|10057->6931|10071->6936|10111->6937|10163->6952|10181->6960|10236->6992|10705->7424|10754->7456|10795->7458|10861->7487|10882->7498|10956->7549|10995->7551|11014->7559|11047->7568|11136->7620|11157->7631|11235->7685|11275->7687|11294->7695|11327->7704|11424->7765|11441->7772|11512->7820|11563->7835|11580->7842|11625->7864|11676->7879|11693->7886|11725->7895|11776->7910|11791->7915|11850->7951|11901->7966|11918->7973|11962->7994|12013->8009|12053->8039|12102->8041|12119->8048|12165->8067|12216->8082|12231->8087|12298->8131|12349->8146|12394->8181|12443->8183|12460->8190|12511->8214|12568->8235|12627->8284|12668->8286|12792->8373|12813->8384|12893->8440|12933->8442|12952->8450|12985->8459|13099->8541|13162->8571|13265->8638|13280->8643|13393->8732|13440->8747
                    LINES: 26->1|33->8|33->8|35->8|36->9|36->9|36->9|37->6|37->6|38->1|39->5|40->6|42->10|44->12|44->12|44->12|44->12|54->22|54->22|54->22|54->22|54->22|54->22|58->26|58->26|58->26|58->26|58->26|58->26|65->33|65->33|65->33|73->41|73->41|74->42|74->42|79->47|79->47|79->47|94->62|94->62|95->63|95->63|101->69|101->69|108->76|108->76|115->83|115->83|121->89|121->89|131->99|131->99|132->100|132->100|133->101|133->101|133->101|135->103|135->103|135->103|135->103|135->103|135->103|135->103|135->103|141->109|141->109|142->110|142->110|147->115|147->115|147->115|162->130|162->130|163->131|163->131|168->136|168->136|168->136|189->157|189->157|189->157|197->165|197->165|197->165|203->171|203->171|203->171|205->173|205->173|205->173|225->193|225->193|225->193|226->194|226->194|226->194|226->194|226->194|226->194|227->195|227->195|227->195|227->195|227->195|227->195|228->196|228->196|228->196|229->197|229->197|229->197|230->198|230->198|230->198|231->199|231->199|231->199|232->200|232->200|232->200|233->201|233->201|233->201|233->201|233->201|234->202|234->202|234->202|235->203|235->203|235->203|235->203|235->203|237->205|237->205|237->205|238->206|238->206|238->206|238->206|238->206|238->206|241->209|244->212|249->217|249->217|249->217|252->220
                    -- GENERATED --
                */
            