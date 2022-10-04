
package views.html.expediente.expediente

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
object verExpediente extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[Expediente],Expediente,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lcForm: Form[Expediente],lc:Expediente):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

def /*5.2*/scripts/*5.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*5.13*/("""
	<script src=""""),_display_(Seq[Any](/*6.16*/routes/*6.22*/.Assets.at("javascripts/expediente/expediente.js"))),format.raw/*6.72*/("""" type="text/javascript"></script>
""")))};implicit def /*8.2*/implicitFieldConstructor/*8.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.42*/("""
"""),format.raw/*7.2*/("""
"""),format.raw/*8.70*/(""" 

"""),_display_(Seq[Any](/*10.2*/views/*10.7*/.html.expediente.mainExpediente("Vista Expediente",scripts)/*10.66*/ {_display_(Seq[Any](format.raw/*10.68*/("""
	<div class="page-header">
		<div class="row">
			<div class="col-sm-3">
				<h1>Vista Expediente</h1>
			</div>
			<div class="col-sm-4">
				 
			</div>
			<div class="col-sm-5">
				<div class="dropdown pull-right btn-header">
				 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 	<i class="glyphicon glyphicon-list-alt"></i>
				    Reportes
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				    <li role="presentation"><a role="menuitem" id="reporteTapaExpediente" href=""""),_display_(Seq[Any](/*27.86*/controllers/*27.97*/.expediente.routes.ExpedientesController.reporteTapaExpediente(lc.id))),format.raw/*27.166*/("""" tabindex="-1">Tapa Expediente</a></li>
				  	<li><a id="reportePaseExpediente" href="#" data-url=""""),_display_(Seq[Any](/*28.62*/controllers/*28.73*/.expediente.routes.ExpedientesReportesController.reportePaseExpediente(lc.id))),format.raw/*28.150*/("""">Reporte Pase Expediente</a></li>
				  </ul>
				</div>
				
				<div class="dropdown pull-right btn-header">
				 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 	<i class="glyphicon glyphicon-list-alt"></i>
				    Acciones
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				  	"""),_display_(Seq[Any](/*39.9*/if(Permiso.check("expedientesCrearCopia") && lc.nro_copia == null)/*39.75*/ {_display_(Seq[Any](format.raw/*39.77*/("""
				  	<li role="presentation">
				  		<a  role="menuitem" href=""""),_display_(Seq[Any](/*41.36*/controllers/*41.47*/.expediente.routes.ExpedientesController.crearCopia(lc.id))),format.raw/*41.105*/("""">
				  		<i class="glyphicon glyphicon-subtitles"></i> Crear Copia</a>
				  	</li>
				  	""")))})),format.raw/*44.9*/("""
				  	"""),_display_(Seq[Any](/*45.9*/if(Permiso.check("expedientesCrearRP") && (lc.residuo_pasivo == null || !lc.residuo_pasivo ))/*45.102*/ {_display_(Seq[Any](format.raw/*45.104*/("""
				  	<li role="presentation">
				  		<a  role="menuitem" href=""""),_display_(Seq[Any](/*47.36*/controllers/*47.47*/.expediente.routes.ExpedientesController.crearRP(lc.id))),format.raw/*47.102*/("""">
				  		<i class="glyphicon glyphicon-registration-mark"></i> Crear RP</a>
				  	</li>
				  	""")))})),format.raw/*50.9*/("""
				  	"""),_display_(Seq[Any](/*51.9*/if(Permiso.check("expedientesPasarAOtroServicio"))/*51.59*/ {_display_(Seq[Any](format.raw/*51.61*/("""
				  	<li role="presentation">
				  		<a role="menuitem" id="accionPasarOtroServicio" tabindex="-1" href="#" 
				    						   data-url=""""),_display_(Seq[Any](/*54.29*/controllers/*54.40*/.expediente.routes.ExpedientesAccionesController.modalPasarOtroServicioIndividual(lc.id))),format.raw/*54.128*/("""">
				    						   Pasar a otro servicio</a>
				 	</li>
				 	""")))})),format.raw/*57.8*/("""
				 	
				 	"""),_display_(Seq[Any](/*59.8*/if(Permiso.check("expedientesCancelarPase"))/*59.52*/ {_display_(Seq[Any](format.raw/*59.54*/("""
				    <li><a id="cancelarPase" href="#" data-url=""""),_display_(Seq[Any](/*60.54*/controllers/*60.65*/.expediente.routes.ExpedientesAccionesController.cancelarPase(lc.id))),format.raw/*60.133*/("""">Cancelar Pase</a></li>
				  	""")))})),format.raw/*61.9*/("""
				  	"""),_display_(Seq[Any](/*62.9*/if(Permiso.check("expedientesAsignarMiServicio"))/*62.58*/ {_display_(Seq[Any](format.raw/*62.60*/("""
				  	<li role="presentation">
				  		<a role="menuitem" id="asignarMiServicio" tabindex="-1" href="#" 
				    						   data-url=""""),_display_(Seq[Any](/*65.29*/controllers/*65.40*/.expediente.routes.ExpedientesAccionesController.asignarMiServicio(lc.id))),format.raw/*65.113*/("""">
				    						   Asignar a Mi Servicio</a>
				 	</li>
				 	""")))})),format.raw/*68.8*/("""
				  </ul>
				</div>
				
				<div class="pull-right btn-header">
					<a href=""""),_display_(Seq[Any](/*73.16*/controllers/*73.27*/.expediente.routes.ExpedientesController.crearExpediente())),format.raw/*73.85*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo expediente</a>
				</div>
			</div>
		</div>
	</div>		
"""),_display_(Seq[Any](/*78.2*/views/*78.7*/.html.tags.successError())),format.raw/*78.32*/("""	
	<div class="row menu-acciones">
		<div class="col-sm-4">
			<a href=""""),_display_(Seq[Any](/*81.14*/controllers/*81.25*/.expediente.routes.ExpedientesController.editarExpediente(lc.id))),format.raw/*81.89*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-edit"></i> Editar</a>
			<a href=""""),_display_(Seq[Any](/*82.14*/controllers/*82.25*/.expediente.routes.ExpedientesController.eliminarExpediente(lc.id))),format.raw/*82.91*/(""""  class="btn btn-default delete-confirm-link"><i class="glyphicon glyphicon-trash icono-eliminar"></i> Eliminar</a>
			"""),_display_(Seq[Any](/*83.5*/if(Permiso.check("expedientesEliminarCopias") && lc.nro_copia != null)/*83.75*/ {_display_(Seq[Any](format.raw/*83.77*/("""
			<a href=""""),_display_(Seq[Any](/*84.14*/controllers/*84.25*/.expediente.routes.ExpedientesController.eliminarExpedienteCopia(lc.id))),format.raw/*84.96*/(""""  class="btn btn-default delete-confirm-link"><i class="glyphicon glyphicon-trash icono-eliminar"></i> Eliminar Copia</a>
			""")))})),format.raw/*85.5*/("""
		</div>
		<div class="col-sm-6">
				"""),_display_(Seq[Any](/*88.6*/if(lc.servicio != null)/*88.29*/ {_display_(Seq[Any](format.raw/*88.31*/(""" 
				<h2>Depto/Servicio - """),_display_(Seq[Any](/*89.27*/lc/*89.29*/.servicio)),format.raw/*89.38*/("""</h2>
				""")))})),format.raw/*90.6*/("""
		</div>
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*93.14*/UriTrack/*93.22*/.getOnNull(controllers.expediente.routes.ExpedientesController.indexExpediente().absoluteURL()))),format.raw/*93.117*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
		</div> 
	</div>	
	
	<input type="hidden" id="expedienteId" name="expedienteId" value=""""),_display_(Seq[Any](/*97.69*/lc/*97.71*/.id)),format.raw/*97.74*/(""""/>
	<div class="row">
		<div class="col-sm-2">
			<div class="form-group">
				<label class="control-label">Nombre</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*102.50*/lcForm/*102.56*/.field("nombre").value)),format.raw/*102.78*/("""</p>
			</div>
		</div>
		<div class="col-sm-7">
			<div class="form-group">
				<label class="control-label">Descripcion</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*108.50*/lcForm/*108.56*/.field("descripcion").value)),format.raw/*108.83*/("""</p>
			</div>
		</div> 
	</div>
	<div class="row">
	 	<div class="col-sm-2">
			<div class="form-group">
				<label class="control-label">Ejercicio</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*116.50*/lc/*116.52*/.ejercicio.nombre)),format.raw/*116.69*/("""</p>
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group ">
				<label class="control-label">Fecha</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*122.50*/(utils.DateUtils.formatDate(lc.fecha)))),format.raw/*122.88*/("""</p>
			</div>
		</div>
		<div class="col-sm-5">
			<div class="form-group">
				<label class="control-label">Iniciador</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*128.50*/if(lc.iniciador != null)/*128.74*/{_display_(Seq[Any](_display_(Seq[Any](/*128.76*/(lc.iniciador.nombre)))))})),format.raw/*128.98*/("""</p>
			</div>
		</div>
	</div> 
	<div class="row">
		<div class="col-sm-2">
			<div class="form-group">
				<label class="control-label">Expediente Padre</label>
					<p class="form-control-static form-control">
					"""),_display_(Seq[Any](/*137.7*/if(lc.parent_id != null)/*137.31*/{_display_(Seq[Any](format.raw/*137.32*/(""" """),_display_(Seq[Any](/*137.34*/lc/*137.36*/.parent.getExpedienteEjercicio()))))})),format.raw/*137.69*/("""
					</p>
			</div>
		</div>
		<div class="col-sm-2">
			<div class="checkbox">
				<label class="control-label">
					Residuo pasivo
					"""),_display_(Seq[Any](/*145.7*/checkbox(lcForm("residuo_pasivo"), 'disabled -> "disabled"))),format.raw/*145.66*/("""
				</label>
			</div>
		</div>	
		
		<div class="col-sm-2">
			<div class="checkbox">
				<label class="control-label">
					RESERVADO
					"""),_display_(Seq[Any](/*154.7*/checkbox(lcForm("reservado"), 'disabled -> "disabled"))),format.raw/*154.61*/("""
				</label>
			</div>
		</div>	
		<div class="col-sm-3">
			<div class="checkbox">
				<label class="control-label">
					LICITACION
					"""),_display_(Seq[Any](/*162.7*/checkbox(lcForm("licitacion"), 'disabled -> "disabled"))),format.raw/*162.62*/("""
				</label>
			</div>
		</div>	
		<div class="col-sm-3">
			<div class="checkbox">
				<label class="control-label">
					EMERGENCIA SANITARIA
					"""),_display_(Seq[Any](/*170.7*/checkbox(lcForm("emergencia"), 'disabled -> "disabled"))),format.raw/*170.62*/("""
				</label>
			</div>
		</div>	
	</div> 
	<div class="row">	
		<div class="col-sm-2">
			<div class="checkbox">
				<label class="control-label">
					Cerrar
					"""),_display_(Seq[Any](/*180.7*/checkbox(lcForm("cerrar"), 'disabled -> "disabled"))),format.raw/*180.58*/("""
				</label>
			</div>
		</div>		
		<div class="col-sm-2">
			<div class="checkbox">
				<label class="control-label">
					Activo
					"""),_display_(Seq[Any](/*188.7*/checkbox(lcForm("activo"), 'disabled -> "disabled"))),format.raw/*188.58*/("""
				</label>
			</div>
		</div>		
		<div class="col-sm-3">
			<div class="checkbox">
				<label class="control-label">
					Expediente Guardia Personal
					"""),_display_(Seq[Any](/*196.7*/checkbox(lcForm("guardia"), 'disabled -> "disabled"))),format.raw/*196.59*/("""
				</label>
			</div>
		</div>	
		
		<div class="col-sm-3">
			<div class="checkbox">
				<label class="control-label">
					PROFE
					"""),_display_(Seq[Any](/*205.7*/checkbox(lcForm("profe"), 'disabled -> "disabled"))),format.raw/*205.57*/("""
				</label>
			</div>
		</div>	
		
	</div> 
	"""),_display_(Seq[Any](/*211.3*/views/*211.8*/.html.expediente.expediente.tabsExpediente(false, lcForm))),format.raw/*211.65*/(""" 
	
	 
""")))})))}
    }
    
    def render(lcForm:Form[Expediente],lc:Expediente): play.api.templates.HtmlFormat.Appendable = apply(lcForm,lc)
    
    def f:((Form[Expediente],Expediente) => play.api.templates.HtmlFormat.Appendable) = (lcForm,lc) => apply(lcForm,lc)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:36 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/expediente/expediente/verExpediente.scala.html
                    HASH: b01b4e8a487f85c4a064ef2eb517ffd7bdf87f9c
                    MATRIX: 825->1|996->98|1010->105|1094->109|1145->125|1159->131|1230->181|1297->219|1329->243|1403->41|1430->217|1458->287|1497->291|1510->296|1578->355|1618->357|2277->980|2297->991|2389->1060|2527->1162|2547->1173|2647->1250|3109->1677|3184->1743|3224->1745|3328->1813|3348->1824|3429->1882|3554->1976|3598->1985|3701->2078|3742->2080|3846->2148|3866->2159|3944->2214|4074->2313|4118->2322|4177->2372|4217->2374|4394->2515|4414->2526|4525->2614|4621->2679|4671->2694|4724->2738|4764->2740|4854->2794|4874->2805|4965->2873|5029->2906|5073->2915|5131->2964|5171->2966|5342->3101|5362->3112|5458->3185|5554->3250|5674->3334|5694->3345|5774->3403|5944->3538|5957->3543|6004->3568|6113->3641|6133->3652|6219->3716|6347->3808|6367->3819|6455->3885|6611->4006|6690->4076|6730->4078|6780->4092|6800->4103|6893->4174|7051->4301|7126->4341|7158->4364|7198->4366|7262->4394|7273->4396|7304->4405|7346->4416|7430->4464|7447->4472|7565->4567|7762->4728|7773->4730|7798->4733|8008->4906|8024->4912|8069->4934|8285->5113|8301->5119|8351->5146|8594->5352|8606->5354|8646->5371|8857->5545|8918->5583|9132->5760|9166->5784|9215->5786|9264->5808|9519->6027|9553->6051|9593->6052|9632->6054|9644->6056|9704->6089|9881->6230|9963->6289|10142->6432|10219->6486|10396->6627|10474->6682|10661->6833|10739->6888|10941->7054|11015->7105|11189->7243|11263->7294|11458->7453|11533->7505|11708->7644|11781->7694|11865->7742|11879->7747|11959->7804
                    LINES: 26->1|33->5|33->5|35->5|36->6|36->6|36->6|37->8|37->8|38->1|39->7|40->8|42->10|42->10|42->10|42->10|59->27|59->27|59->27|60->28|60->28|60->28|71->39|71->39|71->39|73->41|73->41|73->41|76->44|77->45|77->45|77->45|79->47|79->47|79->47|82->50|83->51|83->51|83->51|86->54|86->54|86->54|89->57|91->59|91->59|91->59|92->60|92->60|92->60|93->61|94->62|94->62|94->62|97->65|97->65|97->65|100->68|105->73|105->73|105->73|110->78|110->78|110->78|113->81|113->81|113->81|114->82|114->82|114->82|115->83|115->83|115->83|116->84|116->84|116->84|117->85|120->88|120->88|120->88|121->89|121->89|121->89|122->90|125->93|125->93|125->93|129->97|129->97|129->97|134->102|134->102|134->102|140->108|140->108|140->108|148->116|148->116|148->116|154->122|154->122|160->128|160->128|160->128|160->128|169->137|169->137|169->137|169->137|169->137|169->137|177->145|177->145|186->154|186->154|194->162|194->162|202->170|202->170|212->180|212->180|220->188|220->188|228->196|228->196|237->205|237->205|243->211|243->211|243->211
                    -- GENERATED --
                */
            