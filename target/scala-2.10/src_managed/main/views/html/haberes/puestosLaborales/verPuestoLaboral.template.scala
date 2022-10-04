
package views.html.haberes.puestosLaborales

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
object verPuestoLaboral extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Form[models.haberes.PuestoLaboral],models.haberes.PuestoLaboral,List[models.haberes.LiquidacionEnvioMail],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lcForm: Form[models.haberes.PuestoLaboral],lc:models.haberes.PuestoLaboral,le:List[models.haberes.LiquidacionEnvioMail]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

def /*5.2*/scripts/*5.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*5.13*/("""
	<script src=""""),_display_(Seq[Any](/*6.16*/routes/*6.22*/.Assets.at("javascripts/haberes/puestosLaborales.js"))),format.raw/*6.75*/("""" type="text/javascript"></script>
""")))};implicit def /*8.2*/implicitFieldConstructor/*8.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.123*/("""
"""),format.raw/*7.2*/("""
"""),format.raw/*8.70*/(""" 

"""),_display_(Seq[Any](/*10.2*/views/*10.7*/.html.haberes.mainHaberes("Vista Puesto Laboral",scripts)/*10.64*/ {_display_(Seq[Any](format.raw/*10.66*/("""
	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Vista Puesto Laboral</h1>
			</div>


			<div class="col-sm-5">

				<div class="btn-header pull-right">
					<a href=""""),_display_(Seq[Any](/*21.16*/controllers/*21.27*/.haberes.routes.PuestosLaboralesController.crear())),format.raw/*21.77*/("""?"""),_display_(Seq[Any](/*21.79*/UriTrack/*21.87*/.encode())),format.raw/*21.96*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo Puesto Laboral</a>
				</div>
				
				
			<div class="dropdown pull-right btn-header">
			  	<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-expanded="true">
			    	<i class="glyphicon glyphicon-list-alt"></i> 
			    	Reportes
			    	<span class="caret"></span>
			  	</button>
				<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
					"""),_display_(Seq[Any](/*32.7*/if(Permiso.check("puestoLaboralForm649"))/*32.48*/ {_display_(Seq[Any](format.raw/*32.50*/("""
				  		<li role="presentation"><a role="menuitem" data-toggle="modal" tabindex="-1" id="reportef649" href="#modal649"> Formulario 649</a></li>  
				  	""")))})),format.raw/*34.9*/("""
				</ul>
			</div>
			<div class="dropdown pull-right btn-header ">
			  	<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-expanded="true">
			  		 <i class="glyphicon glyphicon-cog"></i>
			    	Acciones
			    	<span class="caret"></span>
			  	</button>
				<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">

					"""),_display_(Seq[Any](/*45.7*/if(Permiso.check("liquidacionMesPreliquidar"))/*45.53*/ {_display_(Seq[Any](format.raw/*45.55*/("""
						<li><a id="preliquidarPuesto" href="#" data-title="Preliquidar Puesto" data-url=""""),_display_(Seq[Any](/*46.89*/controllers/*46.100*/.haberes.routes.PuestosLaboralesAccionesController.modalPreliquidarPuesto())),format.raw/*46.175*/("""">Preliquidar</a></li>
						<li><a id="preliquidarPuestoFinal" href="#" data-title="Preliquidar Puesto" data-url=""""),_display_(Seq[Any](/*47.94*/controllers/*47.105*/.haberes.routes.PuestosLaboralesAccionesController.modalPreliquidarFinalPuesto())),format.raw/*47.185*/("""">Preliquidar Final</a></li>
					""")))})),format.raw/*48.7*/("""
				</ul>
			</div>


			</div>





		</div>
	</div>		
		"""),_display_(Seq[Any](/*61.4*/views/*61.9*/.html.tags.successError())),format.raw/*61.34*/("""
	<div class="row menu-acciones">
		<div class="col-sm-5">
			<a href=""""),_display_(Seq[Any](/*64.14*/controllers/*64.25*/.haberes.routes.PuestosLaboralesController.crear())),format.raw/*64.75*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo Puesto Laboral</a>
			<a href=""""),_display_(Seq[Any](/*65.14*/controllers/*65.25*/.haberes.routes.PuestosLaboralesController.editar(lc.id))),_display_(Seq[Any](/*65.82*/UriTrack/*65.90*/.get("&"))),format.raw/*65.99*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-edit"></i> Editar</a>
			<a href=""""),_display_(Seq[Any](/*66.14*/controllers/*66.25*/.haberes.routes.PuestosLaboralesController.eliminar(lc.id))),_display_(Seq[Any](/*66.84*/UriTrack/*66.92*/.get("&"))),format.raw/*66.101*/(""""  class="btn btn-default delete-confirm-link"><i class="glyphicon glyphicon-trash icono-eliminar"></i> Eliminar</a>
			
		</div>
		<div class="col-sm-5">
			<span style="color:red;font-size: 18px;font-weight: bold;">"""),_display_(Seq[Any](/*70.64*/if(lc.legajo.agente.email != null)/*70.98*/{_display_(Seq[Any](_display_(Seq[Any](/*70.100*/lc/*70.102*/.legajo.agente.email))))})),format.raw/*70.123*/("""</span>
		</div>
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*73.14*/UriTrack/*73.22*/.getOnNull(controllers.haberes.routes.PuestosLaboralesController.index().absoluteURL()))),format.raw/*73.109*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
		</div> 
	</div>	
	
	

	
	
	
	
	<input type="hidden" id="puestoLaboralId" name="puestoLaboralId" value=""""),_display_(Seq[Any](/*83.75*/lc/*83.77*/.id)),format.raw/*83.80*/(""""/>
	<div class="row">
		<div class="col-sm-3">
			<label class="control-label">Legajo</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*87.49*/lcForm/*87.55*/.field("legajo.agente.apellido").value)),format.raw/*87.93*/("""</p>
		</div>
		<div class="col-sm-2">
			<label class="control-label">Estado</label>
			<p class="form-control-static form-control">
			"""),_display_(Seq[Any](/*92.5*/if(lc.activo)/*92.18*/{_display_(Seq[Any](format.raw/*92.19*/("""
				Activo
			""")))}/*94.5*/else/*94.9*/{_display_(Seq[Any](format.raw/*94.10*/("""
				Inactivo
			""")))})),format.raw/*96.5*/("""
			</p>	
		</div>
		<div class="col-sm-2">
			<label class="control-label">Envio mail</label>
				<p class="form-control-static form-control">
					"""),_display_(Seq[Any](/*102.7*/if(lcForm("mail_automatico").value == "true")/*102.52*/{_display_(Seq[Any](format.raw/*102.53*/("""SI""")))}/*102.56*/else/*102.60*/{_display_(Seq[Any](format.raw/*102.61*/("""NO""")))})),format.raw/*102.64*/("""
				</p>
		</div>
		<div class="col-sm-2">
			<b>Convenio Ministerio</b>
			<div class="row">
				<div class="col-sm-5">
					<div class="radio">
						<label class="control-label"> 
							"""),_display_(Seq[Any](/*111.9*/inputRadioGroup(lcForm("convenio_ministerio"), options = Seq("true"->"SI"), 'disabled -> "disabled"))),format.raw/*111.109*/("""
						</label>
					</div>
				</div>
				<div class="col-sm-7">
					<div class="radio">
						<label class="control-label"> 
							"""),_display_(Seq[Any](/*118.9*/inputRadioGroup(lcForm("convenio_ministerio"),options = Seq("false"->"NO"), 'disabled -> "disabled"))),format.raw/*118.109*/("""
						</label>
					</div>
				</div>
			</div>
		</div> 
		<div class="col-sm-2">
			<label class="control-label">Cargo Laboral</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*126.49*/lcForm/*126.55*/.field("cargoLaboral.nombre").value)),format.raw/*126.90*/("""</p>			
		</div> 
	</div>	
	<div class="row">	
		<div class="col-sm-3">
			<label class="control-label">Escala</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*132.49*/lcForm/*132.55*/.field("escalaLaboral.nombre").value)),format.raw/*132.91*/("""</p>	
		</div>
		<div class="col-sm-3">
			<label class="control-label">Departamento</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*136.49*/if(lc.departamento_id != null)/*136.79*/{_display_(Seq[Any](format.raw/*136.80*/("""  """),_display_(Seq[Any](/*136.83*/lcForm/*136.89*/.field("departamento.nombre").value))))})),format.raw/*136.125*/("""</p>		
		</div>
		<div class="col-sm-3">
			<label class="control-label">Especialidad</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*140.49*/lcForm/*140.55*/.field("especialidad.nombre").value)),format.raw/*140.90*/("""</p>	
		</div> 
		<div class="col-sm-3">
			<label class="control-label">Categoria Interna</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*144.49*/lcForm/*144.55*/.field("categoriaLaboral.nombre").value)),format.raw/*144.94*/("""</p>	
		</div>
	</div>
	<div class="row">
		<div class="col-sm-3">
			<label for="fechaPosesion" class="control-label">Fecha Posesion</label> 
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*150.49*/lcForm/*150.55*/.field("fecha_posesion").value)),format.raw/*150.85*/("""</p>	
		</div>
		<div class="col-sm-2">
			<label for="fechaBaja" class="control-label">Fecha Baja</label> 
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*154.49*/lcForm/*154.55*/.field("fecha_baja").value)),format.raw/*154.81*/("""</p>
		</div>
		<div class="col-sm-2">
			<label for="fechaTelegrama" class="control-label">Fecha Telegrama</label> 
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*158.49*/lcForm/*158.55*/.field("fecha_telegrama").value)),format.raw/*158.86*/("""</p>
		</div>
		<div class="col-sm-2">
			<div class="form-group">
				<label for="nombre" class="control-label">N° Liquidación</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*163.50*/lcForm/*163.56*/.field("liquidacionMes.nombreLiquidacion").value)),format.raw/*163.104*/("""</p>
			</div>
		</div>
		  
		<div class="col-sm-2">
			<label class="control-label">Sueldo Referencia</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*169.49*/lcForm/*169.55*/.field("sueldo_referencia").value)),format.raw/*169.88*/("""</p>	
		</div>  
	</div>
	<div class="row"> 
	 	<div class="col-sm-3">
			<label class="control-label">Centro Costo</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*175.49*/lcForm/*175.55*/.field("centrolCosto.nombre").value)),format.raw/*175.90*/("""</p>	
		</div>
		<div class="col-sm-3">
			<label class="control-label">Unidad Laboral</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*179.49*/lcForm/*179.55*/.field("unidadLaboral.nombre").value)),format.raw/*179.91*/("""</p>	
		</div>
		<div class="col-sm-3">
			<label class="control-label">Instrumento Legal</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*183.49*/lcForm/*183.55*/.field("instrumentoLegal.nombre").value)),format.raw/*183.94*/("""</p>	
		</div>
		<div class="col-sm-3">
			<label class="control-label">Convenio Banco</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*187.49*/lcForm/*187.55*/.field("convenioBanco.nombre").value)),format.raw/*187.91*/("""</p>	
		</div>
	</div>
<hr />
<ul id="facturaTab" class="nav nav-tabs">
		<li class="active"><a class="tabMail" href="#contenedorMail" data-toggle="tab">Mails Enviados</a></li>
</ul>
<div class="tab-content">
	<div class="tab-pane active" id="contenedorMail">
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<td>Email</td>
					<td>Fecha</td>
					<td>Liquidacion</td>
				</tr>
			</thead>	
			<tbody>
				"""),_display_(Seq[Any](/*205.6*/for(lex <- le) yield /*205.20*/{_display_(Seq[Any](format.raw/*205.21*/("""
					<tr>
						<td>"""),_display_(Seq[Any](/*207.12*/lex/*207.15*/.email)),format.raw/*207.21*/("""</td>
						<td>"""),_display_(Seq[Any](/*208.12*/(utils.DateUtils.formatDate(lex.fecha,"dd/MM/yyyy HH:mm")))),format.raw/*208.70*/("""</td>
						<td> 
							"""),_display_(Seq[Any](/*210.9*/lex/*210.12*/.liquidacionPuesto.liquidacionMes.nro_liquidacion_parque)),format.raw/*210.68*/(""" - 
							<a class="btn btn-default btn-xs notSeleccion" 
							href=""""),_display_(Seq[Any](/*212.15*/controllers/*212.26*/.haberes.routes.LiquidacionPuestosController.ver(lex.liquidacion_puesto_id))),format.raw/*212.101*/("""">
							<i class="glyphicon glyphicon-tasks"></i>
							</a>
						</td>
					</tr>
				""")))})),format.raw/*217.6*/("""
			</tbody>
		</table>		
	</div>
</div>	

<h4>Estado actual: 	<b>"""),_display_(Seq[Any](/*223.25*/lc/*223.27*/.estado.nombre)),format.raw/*223.41*/("""</b></h4>
<div class="row margin-bottom-25">
	
			"""),_display_(Seq[Any](/*226.5*/if(lc.estado.id == models.Estado.PUESTO_LABORAL_CONTROLADO)/*226.64*/ {_display_(Seq[Any](format.raw/*226.66*/("""
				<div class="col-sm-3">
					<a href=""""),_display_(Seq[Any](/*228.16*/controllers/*228.27*/.haberes.routes.PuestosLaboralesController.cambiarEstado(lc.id, models.Estado.PUESTO_LABORAL_BORRADOR))),_display_(Seq[Any](/*228.130*/UriTrack/*228.138*/.get("&"))),format.raw/*228.147*/("""" class="btn btn-default btn-disable-onclick">
						<i class="glyphicon glyphicon-arrow-right"></i> Volver a Borrador
					</a>
				</div>
			""")))}/*232.5*/else/*232.9*/{_display_(Seq[Any](format.raw/*232.10*/("""
				<div class="col-sm-3">
					<a href=""""),_display_(Seq[Any](/*234.16*/controllers/*234.27*/.haberes.routes.PuestosLaboralesController.cambiarEstado(lc.id, models.Estado.PUESTO_LABORAL_CONTROLADO))),_display_(Seq[Any](/*234.132*/UriTrack/*234.140*/.get("&"))),format.raw/*234.149*/("""" class="btn btn-default btn-disable-onclick">
						<i class="glyphicon glyphicon-arrow-right"></i> Pasar a Controlado
					</a>
				</div>
			""")))})),format.raw/*238.5*/("""
			
			"""),_display_(Seq[Any](/*240.5*/if(lc.fecha_baja != null && lc.liquidacion_mes_id != null)/*240.63*/ {_display_(Seq[Any](format.raw/*240.65*/("""
				<div class="col-sm-3">
					<a href=""""),_display_(Seq[Any](/*242.16*/controllers/*242.27*/.haberes.routes.PuestosLaboralesController.liquidarCierre(lc.id, lc.liquidacion_mes_id))),_display_(Seq[Any](/*242.115*/UriTrack/*242.123*/.get("&"))),format.raw/*242.132*/("""" class="btn btn-default btn-disable-onclick">
						<i class="glyphicon glyphicon-arrow-right"></i> Liquidacion Cierre
					</a>
				</div>
			""")))})),format.raw/*246.5*/("""
	 
</div>	
	

  <!-- Modal 649 -->
  <div class="modal fade" id="modal649" tabindex="-1" role="dialog">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          <h4 class="modal-title">Informe 649</h4>
        </div>
        <div class="modal-body">
          	
			<ul class="list-group">
			  <li class="list-group-item"><a href=""""),_display_(Seq[Any](/*262.44*/controllers/*262.55*/.haberes.routes.PuestosLaboralesReportesController.formulario649(lc.id, 5))),format.raw/*262.129*/("""">Año 2016</a></li>
			  <li class="list-group-item"><a href=""""),_display_(Seq[Any](/*263.44*/controllers/*263.55*/.haberes.routes.PuestosLaboralesReportesController.formulario649(lc.id, 6))),format.raw/*263.129*/("""">Año 2017</a></li>
			  <li class="list-group-item"><a href=""""),_display_(Seq[Any](/*264.44*/controllers/*264.55*/.haberes.routes.PuestosLaboralesReportesController.formulario6492019(lc.id, 7))),format.raw/*264.133*/("""">Año 2018</a></li>
			  <li class="list-group-item"><a href=""""),_display_(Seq[Any](/*265.44*/controllers/*265.55*/.haberes.routes.PuestosLaboralesReportesController.formulario6492019(lc.id, 8))),format.raw/*265.133*/("""">Año 2019</a></li>
			  <li class="list-group-item"><a href=""""),_display_(Seq[Any](/*266.44*/controllers/*266.55*/.haberes.routes.PuestosLaboralesReportesController.formulario6492021(lc.id, 9))),format.raw/*266.133*/("""">Año 2020</a></li>
			  <li class="list-group-item"><a href=""""),_display_(Seq[Any](/*267.44*/controllers/*267.55*/.haberes.routes.PuestosLaboralesReportesController.formulario6492022(lc.id, 10))),format.raw/*267.134*/("""">Año 2021</a></li>
			</ul>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
        </div>
      </div>
    </div>
  </div>
	 
""")))})))}
    }
    
    def render(lcForm:Form[models.haberes.PuestoLaboral],lc:models.haberes.PuestoLaboral,le:List[models.haberes.LiquidacionEnvioMail]): play.api.templates.HtmlFormat.Appendable = apply(lcForm,lc,le)
    
    def f:((Form[models.haberes.PuestoLaboral],models.haberes.PuestoLaboral,List[models.haberes.LiquidacionEnvioMail]) => play.api.templates.HtmlFormat.Appendable) = (lcForm,lc,le) => apply(lcForm,lc,le)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/puestosLaborales/verPuestoLaboral.scala.html
                    HASH: dedfd1133f2b89a049c18be8865be45628e07930
                    MATRIX: 909->1|1161->179|1175->186|1259->190|1310->206|1324->212|1398->265|1465->303|1497->327|1572->122|1599->301|1627->371|1666->375|1679->380|1745->437|1785->439|2023->641|2043->652|2115->702|2153->704|2170->712|2201->721|2739->1224|2789->1265|2829->1267|3015->1422|3451->1823|3506->1869|3546->1871|3671->1960|3692->1971|3790->2046|3942->2162|3963->2173|4066->2253|4132->2288|4227->2348|4240->2353|4287->2378|4395->2450|4415->2461|4487->2511|4634->2622|4654->2633|4741->2690|4758->2698|4789->2707|4917->2799|4937->2810|5026->2869|5043->2877|5075->2886|5329->3104|5372->3138|5421->3140|5433->3142|5481->3163|5572->3218|5589->3226|5699->3313|5913->3491|5924->3493|5949->3496|6128->3639|6143->3645|6203->3683|6376->3821|6398->3834|6437->3835|6471->3851|6483->3855|6522->3856|6571->3874|6757->4024|6812->4069|6852->4070|6875->4073|6889->4077|6929->4078|6965->4081|7193->4273|7317->4373|7489->4509|7613->4609|7836->4795|7852->4801|7910->4836|8114->5003|8130->5009|8189->5045|8367->5186|8407->5216|8447->5217|8487->5220|8503->5226|8567->5262|8746->5404|8762->5410|8820->5445|9004->5592|9020->5598|9082->5637|9310->5828|9326->5834|9379->5864|9572->6020|9588->6026|9637->6052|9839->6217|9855->6223|9909->6254|10131->6439|10147->6445|10219->6493|10416->6653|10432->6659|10488->6692|10697->6864|10713->6870|10771->6905|10951->7048|10967->7054|11026->7090|11209->7236|11225->7242|11287->7281|11467->7424|11483->7430|11542->7466|12016->7904|12047->7918|12087->7919|12146->7941|12159->7944|12188->7950|12242->7967|12323->8025|12385->8051|12398->8054|12477->8110|12587->8183|12608->8194|12707->8269|12831->8361|12935->8428|12947->8430|12984->8444|13071->8495|13140->8554|13181->8556|13261->8599|13282->8610|13417->8713|13436->8721|13469->8730|13632->8874|13645->8878|13685->8879|13765->8922|13786->8933|13923->9038|13942->9046|13975->9055|14152->9200|14197->9209|14265->9267|14306->9269|14386->9312|14407->9323|14527->9411|14546->9419|14579->9428|14756->9573|15282->10062|15303->10073|15401->10147|15501->10210|15522->10221|15620->10295|15720->10358|15741->10369|15843->10447|15943->10510|15964->10521|16066->10599|16166->10662|16187->10673|16289->10751|16389->10814|16410->10825|16513->10904
                    LINES: 26->1|33->5|33->5|35->5|36->6|36->6|36->6|37->8|37->8|38->1|39->7|40->8|42->10|42->10|42->10|42->10|53->21|53->21|53->21|53->21|53->21|53->21|64->32|64->32|64->32|66->34|77->45|77->45|77->45|78->46|78->46|78->46|79->47|79->47|79->47|80->48|93->61|93->61|93->61|96->64|96->64|96->64|97->65|97->65|97->65|97->65|97->65|98->66|98->66|98->66|98->66|98->66|102->70|102->70|102->70|102->70|102->70|105->73|105->73|105->73|115->83|115->83|115->83|119->87|119->87|119->87|124->92|124->92|124->92|126->94|126->94|126->94|128->96|134->102|134->102|134->102|134->102|134->102|134->102|134->102|143->111|143->111|150->118|150->118|158->126|158->126|158->126|164->132|164->132|164->132|168->136|168->136|168->136|168->136|168->136|168->136|172->140|172->140|172->140|176->144|176->144|176->144|182->150|182->150|182->150|186->154|186->154|186->154|190->158|190->158|190->158|195->163|195->163|195->163|201->169|201->169|201->169|207->175|207->175|207->175|211->179|211->179|211->179|215->183|215->183|215->183|219->187|219->187|219->187|237->205|237->205|237->205|239->207|239->207|239->207|240->208|240->208|242->210|242->210|242->210|244->212|244->212|244->212|249->217|255->223|255->223|255->223|258->226|258->226|258->226|260->228|260->228|260->228|260->228|260->228|264->232|264->232|264->232|266->234|266->234|266->234|266->234|266->234|270->238|272->240|272->240|272->240|274->242|274->242|274->242|274->242|274->242|278->246|294->262|294->262|294->262|295->263|295->263|295->263|296->264|296->264|296->264|297->265|297->265|297->265|298->266|298->266|298->266|299->267|299->267|299->267
                    -- GENERATED --
                */
            