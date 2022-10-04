
package views.html.compras.solicitudes

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
object editarSolicitud extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Form[Solicitud],Solicitud,String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(solicitudForm: Form[Solicitud], solicitud: Solicitud,searchIndex:String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

def /*4.2*/scripts/*4.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*4.13*/("""
	<script src=""""),_display_(Seq[Any](/*5.16*/routes/*5.22*/.Assets.at("javascripts/compras/solicitudes.js"))),format.raw/*5.70*/("""" type="text/javascript"></script>
""")))};implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};def /*8.2*/getEditable/*8.13*/(s:Solicitud) = {{
	var r:Boolean = new Boolean(true)
	if(s.estado_id == 4 || s.estado_id ==5){
		r = false
	}
	r
}};
Seq[Any](format.raw/*1.75*/("""
"""),format.raw/*3.70*/("""
"""),format.raw/*6.2*/("""

"""),format.raw/*14.2*/("""

"""),_display_(Seq[Any](/*16.2*/views/*16.7*/.html.compras.mainCompras("Modificar Solicitud", scripts)/*16.64*/ {_display_(Seq[Any](format.raw/*16.66*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Editar Solicitud</h1>
			</div>
			<div class="col-sm-5">
				<div class="dropdown pull-right">
				 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 	<i class="glyphicon glyphicon-list-alt"></i>
				    Reportes
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				    <li role="presentation" class="disabled"><a role="menuitem" tabindex="-1" href="#">Solicitud de compra</a></li>
				    <li role="presentation"><a role="menuitem" tabindex="-1" href=""""),_display_(Seq[Any](/*32.73*/controllers/*32.84*/.compras.routes.SolicitudesReportesController.reporteImputacionPreventiva(solicitudForm.field("id").value.toLong))),format.raw/*32.197*/("""">Imputaci&oacute;n preventiva</a></li>
				    <li role="presentation" class="disabled"><a role="menuitem" tabindex="-1" href="#">Exportaci&oacute;n de lineas</a></li>
				    <li role="presentation" class="disabled"><a role="menuitem" tabindex="-1" href="#">Informe de ajuste preventiva</a></li>
				  </ul>
				</div>
				
				<div class="dropdown pull-right btn-header">
				 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 	<i class="glyphicon glyphicon-cog"></i>
				    Acciones
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				  	<li role="presentation">
				    	<a role="menuitem" tabindex="-1" href="#" id="editarCuentaAnalitica" data-url=""""),_display_(Seq[Any](/*46.90*/controllers/*46.101*/.compras.routes.SolicitudesController.modalEditarCuentaAnalica())),format.raw/*46.165*/("""">
				    		Editar cuenta analitica
				    	</a>
				    </li>
				    <li><a id="importarListaProductos" href="#" data-url=""""),_display_(Seq[Any](/*50.64*/controllers/*50.75*/.compras.routes.SolicitudAccionesController.modalImportarListaProductos())),format.raw/*50.148*/("""">Importar productos y cantidades</a></li>
				  </ul>
				</div>
				<div class="pull-right btn-header">
					<a href=""""),_display_(Seq[Any](/*54.16*/controllers/*54.27*/.compras.routes.SolicitudesController.crearSolicitud(searchIndex))),format.raw/*54.92*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nueva Solicitud</a>
				</div>
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*60.3*/if(flash.containsKey("success"))/*60.35*/ {_display_(Seq[Any](format.raw/*60.37*/("""
		<div class="alert alert-success"><i class="glyphicon glyphicon-ok-sign"></i> """),_display_(Seq[Any](/*61.81*/flash/*61.86*/.get("success"))),format.raw/*61.101*/("""</div>
	""")))})),format.raw/*62.3*/("""
	"""),_display_(Seq[Any](/*63.3*/if(flash.containsKey("error"))/*63.33*/ {_display_(Seq[Any](format.raw/*63.35*/("""
		<div class="alert alert-danger"><i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*64.84*/flash/*64.89*/.get("error"))),format.raw/*64.102*/("""</div>
	""")))})),format.raw/*65.3*/(""" 
	
	"""),_display_(Seq[Any](/*67.3*/helper/*67.9*/.form(action = controllers.compras.routes.SolicitudesController.actualizar(solicitud.id,searchIndex))/*67.110*/ {_display_(Seq[Any](format.raw/*67.112*/("""
		<div class="row menu-acciones">
			<div class="col-sm-4">
			  <button type="submit" class="btn btn-default" title="Guardar solicitud"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>	
		      <a href=""""),_display_(Seq[Any](/*71.19*/controllers/*71.30*/.compras.routes.SolicitudesController.ver(solicitud.id,searchIndex))),format.raw/*71.97*/("""" title="Cancelar editar" class="btn btn-default">
		      <i class="glyphicon glyphicon-floppy-remove"></i> Cancelar
		      </a>
		      
		    </div>
		    <div class="col-sm-4">
				"""),_display_(Seq[Any](/*77.6*/if(solicitudForm("asignacion_usuario_id").value != null)/*77.62*/{_display_(Seq[Any](format.raw/*77.63*/("""
					<span style="color:red;font-size: 15px;font-weight: bold;">"""),_display_(Seq[Any](/*78.66*/solicitudForm("asignacion_usuario.nombre")/*78.108*/.value)),format.raw/*78.114*/("""</span>
				""")))})),format.raw/*79.6*/("""
			</div>
			<div class="col-sm-2">
				<a href=""""),_display_(Seq[Any](/*82.15*/controllers/*82.26*/.compras.routes.SolicitudesController.redirectSearchIndex(searchIndex))),format.raw/*82.96*/("""" title="Volver al listado" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
				<a href=""""),_display_(Seq[Any](/*83.15*/controllers/*83.26*/.compras.routes.SolicitudesController.ver(solicitud.id,searchIndex))),format.raw/*83.93*/("""" title="Ver solicitud" class="btn btn-default"><i class="glyphicon glyphicon-align-justify"></i></a> 
			</div>
		</div>
		"""),_display_(Seq[Any](/*86.4*/inputText(solicitudForm("id"), 'hidden -> "hidden"))),format.raw/*86.55*/("""
		"""),_display_(Seq[Any](/*87.4*/views/*87.9*/.html.compras.solicitudes.formSolicitud(solicitudForm))),format.raw/*87.63*/("""

		"""),_display_(Seq[Any](/*89.4*/views/*89.9*/.html.compras.solicitudes.tabsSolicitud(getEditable(solicitud), solicitudForm,solicitud))),format.raw/*89.97*/("""
		
	<h4>Base: 	<b>"""),_display_(Seq[Any](/*91.17*/utils/*91.22*/.NumberUtils.moneda(solicitud.total))),format.raw/*91.58*/("""</b></h4>	
	<h4>Total Ajuste: 	<b>"""),_display_(Seq[Any](/*92.25*/utils/*92.30*/.NumberUtils.moneda(solicitud.totalAjuste))),format.raw/*92.72*/("""</b></h4>
	<h4>Total: 	<b>"""),_display_(Seq[Any](/*93.18*/utils/*93.23*/.NumberUtils.moneda(solicitud.getTotalTotal()))),format.raw/*93.69*/("""</b></h4>	
	<h4>Estado actual: 	<b>"""),_display_(Seq[Any](/*94.26*/solicitud/*94.35*/.estado.nombre)),format.raw/*94.49*/("""</b></h4>
	
	<div class="row margin-bottom-25">	
		
		
	</div>
		
	""")))})),format.raw/*101.3*/("""

""")))})))}
    }
    
    def render(solicitudForm:Form[Solicitud],solicitud:Solicitud,searchIndex:String): play.api.templates.HtmlFormat.Appendable = apply(solicitudForm,solicitud,searchIndex)
    
    def f:((Form[Solicitud],Solicitud,String) => play.api.templates.HtmlFormat.Appendable) = (solicitudForm,solicitud,searchIndex) => apply(solicitudForm,solicitud,searchIndex)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:45 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/solicitudes/editarSolicitud.scala.html
                    HASH: 9b5b611a6bcb4f991d20cac85933c4edfd59b816
                    MATRIX: 830->1|996->163|1010->170|1094->174|1145->190|1159->196|1228->244|1295->93|1327->117|1384->283|1403->294|1548->74|1576->161|1603->280|1632->409|1670->412|1683->417|1749->474|1789->476|2503->1154|2523->1165|2659->1278|3493->2076|3514->2087|3601->2151|3765->2279|3785->2290|3881->2363|4038->2484|4058->2495|4145->2560|4315->2695|4356->2727|4396->2729|4513->2810|4527->2815|4565->2830|4605->2839|4643->2842|4682->2872|4722->2874|4842->2958|4856->2963|4892->2976|4932->2985|4973->2991|4987->2997|5098->3098|5139->3100|5397->3322|5417->3333|5506->3400|5728->3587|5793->3643|5832->3644|5934->3710|5986->3752|6015->3758|6059->3771|6146->3822|6166->3833|6258->3903|6406->4015|6426->4026|6515->4093|6675->4218|6748->4269|6787->4273|6800->4278|6876->4332|6916->4337|6929->4342|7039->4430|7095->4450|7109->4455|7167->4491|7238->4526|7252->4531|7316->4573|7379->4600|7393->4605|7461->4651|7533->4687|7551->4696|7587->4710|7687->4778
                    LINES: 26->1|29->4|29->4|31->4|32->5|32->5|32->5|33->3|33->3|33->8|33->8|40->1|41->3|42->6|44->14|46->16|46->16|46->16|46->16|62->32|62->32|62->32|76->46|76->46|76->46|80->50|80->50|80->50|84->54|84->54|84->54|90->60|90->60|90->60|91->61|91->61|91->61|92->62|93->63|93->63|93->63|94->64|94->64|94->64|95->65|97->67|97->67|97->67|97->67|101->71|101->71|101->71|107->77|107->77|107->77|108->78|108->78|108->78|109->79|112->82|112->82|112->82|113->83|113->83|113->83|116->86|116->86|117->87|117->87|117->87|119->89|119->89|119->89|121->91|121->91|121->91|122->92|122->92|122->92|123->93|123->93|123->93|124->94|124->94|124->94|131->101
                    -- GENERATED --
                */
            