
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
object indexExpediente extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[Expediente],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[Expediente], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

def /*6.2*/scripts/*6.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*6.13*/("""
	<script src=""""),_display_(Seq[Any](/*7.16*/routes/*7.22*/.Assets.at("javascripts/expediente/expediente.js"))),format.raw/*7.72*/("""" type="text/javascript"></script>
""")))};implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.80*/("""
"""),format.raw/*5.70*/(""" 
"""),format.raw/*8.2*/("""
"""),_display_(Seq[Any](/*9.2*/views/*9.7*/.html.expediente.mainExpediente("Lista de expedientes",scripts)/*9.70*/ {_display_(Seq[Any](format.raw/*9.72*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Lista de expedientes</h1>
			</div>
			<div class="col-sm-5">
				<div class="pull-right btn-header">
					<a href=""""),_display_(Seq[Any](/*18.16*/controllers/*18.27*/.expediente.routes.ExpedientesController.crearExpediente)),format.raw/*18.83*/(""""  class="form-control btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo expediente</a>
				</div> 
				<div class="dropdown pull-right btn-header">
				 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 	<i class="glyphicon glyphicon-list-alt"></i>
				    Reportes
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				    <li role="presentation"><a role="menuitem" id="reporteTapaExpedienteMasivo" data-url=""""),_display_(Seq[Any](/*27.96*/controllers/*27.107*/.expediente.routes.ExpedientesController.reporteTapaExpedienteMasivo())),format.raw/*27.177*/("""" tabindex="-1" href="#">Tapa Expediente</a></li>
				    <li role="presentation"><a role="menuitem" id="reporteListadoExpediente" data-url=""""),_display_(Seq[Any](/*28.93*/controllers/*28.104*/.expediente.routes.ExpedientesController.listadoExpedientes())),format.raw/*28.165*/("""" tabindex="-1" href="#">Listado Expedientes</a></li>
				    <li role="presentation"><a role="menuitem" id="reportePaseExpedienteListado" data-url=""""),_display_(Seq[Any](/*29.97*/controllers/*29.108*/.expediente.routes.ExpedientesReportesController.reportePaseExpedienteLista())),format.raw/*29.185*/("""" tabindex="-1" href="#">Reporte Pase Expediente</a></li>
				  </ul>
				</div>
				<div class="dropdown pull-right btn-header">
				 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 	<i class="glyphicon glyphicon-cog"></i>
				    Acciones
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				  	"""),_display_(Seq[Any](/*39.9*/if(Permiso.check("expedientesPasarAOtroServicio"))/*39.59*/ {_display_(Seq[Any](format.raw/*39.61*/("""
				    <li role="presentation"><a role="menuitem" id="accionPasarOtroServicio" tabindex="-1" href="#" 
				    						   data-url=""""),_display_(Seq[Any](/*41.29*/controllers/*41.40*/.expediente.routes.ExpedientesAccionesController.modalPasarOtroServicio())),format.raw/*41.113*/("""">
				    						   Pasar a otro servicio</a>
				 	</li>
				 	""")))})),format.raw/*44.8*/("""
				 	"""),_display_(Seq[Any](/*45.8*/if(Permiso.check("expedientesCancelarPase"))/*45.52*/ {_display_(Seq[Any](format.raw/*45.54*/("""
				 	<li role="presentation"><a role="menuitem" id="cancelarPaseLista" tabindex="-1" href="#" 
				    						   data-url=""""),_display_(Seq[Any](/*47.29*/controllers/*47.40*/.expediente.routes.ExpedientesAccionesController.cancelarPaseLista())),format.raw/*47.108*/("""">
				    						   Cancelar Pases</a>
				 	</li>
				 	""")))})),format.raw/*50.8*/("""
				 	"""),_display_(Seq[Any](/*51.8*/if(Permiso.check("expedientesAsignarMiServicio"))/*51.57*/ {_display_(Seq[Any](format.raw/*51.59*/("""
				  	<li role="presentation">
				  		<a role="menuitem" id="accionAsignarMiServicio" tabindex="-1" href="#" 
				    						   data-url=""""),_display_(Seq[Any](/*54.29*/controllers/*54.40*/.expediente.routes.ExpedientesAccionesController.modalAsignarMiServicio())),format.raw/*54.113*/("""">
				    						   Asignar a Mi Servicio</a>
				 	</li>
				 	""")))})),format.raw/*57.8*/("""
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
				<label for="nombre" class="control-label">Nombre</label>
				"""),_display_(Seq[Any](/*73.6*/inputText(formBuscador("nombre"), 'class -> "form-control"))),format.raw/*73.65*/("""
			</div>
			<div class="col-sm-3">
				<label for="nombre" class="control-label">Descripción</label>
				"""),_display_(Seq[Any](/*77.6*/inputText(formBuscador("descripcion"), 'class -> "form-control"))),format.raw/*77.70*/("""
			</div>
			<div class="col-sm-2">
				<label class="control-label">Ejercicio
				"""),_display_(Seq[Any](/*81.6*/select(formBuscador("ejercicio"), Ejercicio.getEjercicios().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*81.165*/("""
				</label>
			</div>
			<div class="col-sm-1 input-group">
				<label class="control-label"> 
					RP
					"""),_display_(Seq[Any](/*87.7*/select(formBuscador("rp"),options(""->"","SI"->"SI","NO"->"NO"), 'class -> "form-control select"))),format.raw/*87.104*/("""
				</label>
			</div>
			<div class="col-sm-1 input-group">
				<label class="control-label"> 
					COPIA
					"""),_display_(Seq[Any](/*93.7*/select(formBuscador("copia"),options(""->"","SI"->"SI","NO"->"NO"), 'class -> "form-control select"))),format.raw/*93.107*/("""
				</label>
			</div>
			<div class="col-sm-2 input-group">
				<label class="control-label"> 
					Servicio/depto
					"""),_display_(Seq[Any](/*99.7*/select(formBuscador("organigrama_id"), 
					Organigrama.find.where().eq("circuito_expediente", true).orderBy("nombre asc").findList().map{ p => p.id.toString -> p.nombre}, 'class -> 
					"form-control select", '_default -> "Seleccionar"))),format.raw/*101.56*/("""
				</label>
			</div>
			
			
		</div>		
		<div class="row">	
			<div class="col-sm-2">
				<div class="form-group">
				<label for="nombre" class="control-label">&nbsp;</label>
				<button  class="form-control btn btn-primary"><i class="glyphicon glyphicon-search"></i>  Buscar</button>
				</div>
			</div>
			<div class="col-sm-2">
				<div class="form-group">
				<label for="nombre" class="control-label">&nbsp;</label>
				<a href=""""),_display_(Seq[Any](/*117.15*/controllers/*117.26*/.expediente.routes.ExpedientesController.indexExpediente())),format.raw/*117.84*/(""""  class="form-control btn btn-default">Limpiar</a>
				</div>
			</div>
		</div>
		</form>
	</div>
	
	"""),_display_(Seq[Any](/*124.3*/if(buscador.getTotalRowCount == 0)/*124.37*/ {_display_(Seq[Any](format.raw/*124.39*/("""
        
        <div class="well">
            <em>No se encuentran expedientes</em>
        </div>
        
    """)))}/*130.7*/else/*130.12*/{_display_(Seq[Any](format.raw/*130.13*/("""
		
		Mostrando """),_display_(Seq[Any](/*132.14*/buscador/*132.22*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*132.54*/(""" resultado(s). 
		
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th width="30"><input type="checkbox" name="checkAll" id="checkAll"/></th>
					<th width="30">#</th>
					<th>Código</th>
					<th>Nombre</th>
					<th>Ejecicio</th>
					<th>Descripción</th>
					<th>Fecha</th>
					<th>Serv/Depto</th>
					<th width="30">#</th>
				</tr>
			</thead>
			<tbody>
			"""),_display_(Seq[Any](/*149.5*/for(expediente <- buscador.getList) yield /*149.40*/ {_display_(Seq[Any](format.raw/*149.42*/("""
				<tr class="pointer" data-href=""""),_display_(Seq[Any](/*150.37*/controllers/*150.48*/.expediente.routes.ExpedientesController.ver(expediente.id))),format.raw/*150.107*/("""">
					<td><input type="checkbox" name="check_listado[]" class="notSeleccion" value=""""),_display_(Seq[Any](/*151.85*/expediente/*151.95*/.id)),format.raw/*151.98*/("""" id="check-"""),_display_(Seq[Any](/*151.111*/expediente/*151.121*/.id)),format.raw/*151.124*/(""""/></td>
					<td>							 
						<a class="btn btn-default btn-xs notSeleccion"  href=""""),_display_(Seq[Any](/*153.62*/controllers/*153.73*/.expediente.routes.ExpedientesController.editarExpediente(expediente.id))),format.raw/*153.145*/("""">
							<i class="glyphicon glyphicon-edit"></i>
						</a>
					</td>
					<td>"""),_display_(Seq[Any](/*157.11*/(expediente.id))),format.raw/*157.26*/("""</td>
					<td>"""),_display_(Seq[Any](/*158.11*/(expediente.nombre))),format.raw/*158.30*/("""</td>
					<td>"""),_display_(Seq[Any](/*159.11*/(expediente.ejercicio.nombre))),format.raw/*159.40*/("""</td>
					<td>"""),_display_(Seq[Any](/*160.11*/(expediente.descripcion))),format.raw/*160.35*/("""</td>
					<td>"""),_display_(Seq[Any](/*161.11*/(utils.DateUtils.formatDate(expediente.fecha)))),format.raw/*161.57*/("""</td>
					<td>"""),_display_(Seq[Any](/*162.11*/if(expediente.movimiento != null)/*162.44*/ {_display_(Seq[Any](format.raw/*162.46*/(""" """),_display_(Seq[Any](/*162.48*/expediente/*162.58*/.movimiento.organigrama.nombre)),format.raw/*162.88*/(""" """)))})),format.raw/*162.90*/("""</td>
					<td>
						<a class="btn btn-default btn-xs delete-confirm-link notSeleccion" href=""""),_display_(Seq[Any](/*164.81*/controllers/*164.92*/.expediente.routes.ExpedientesController.eliminarExpediente(expediente.id))),format.raw/*164.166*/("""">
							<i class="glyphicon glyphicon-trash icono-eliminar"></i>
						</a>
					</td>
				</tr>
             """)))})),format.raw/*169.15*/("""
             
	        </tbody>
        </table>

		<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*175.8*/views/*175.13*/.html.helpers.paginador(buscador, controllers.expediente.routes.ExpedientesController.indexExpediente()))),format.raw/*175.117*/("""
		</div>
 	 """)))})),format.raw/*177.5*/("""
""")))})),format.raw/*178.2*/("""
		
		
	
	"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[Expediente],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[Expediente],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:36 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/expediente/expediente/indexExpediente.scala.html
                    HASH: 12774e7b5da844f38e0e9b1f2083be5afc0cf50c
                    MATRIX: 851->1|1060->207|1074->214|1158->218|1209->234|1223->240|1294->290|1361->136|1393->160|1467->79|1495->204|1523->326|1559->328|1571->333|1642->396|1681->398|1917->598|1937->609|2015->665|2621->1235|2642->1246|2735->1316|2913->1458|2934->1469|3018->1530|3204->1680|3225->1691|3325->1768|3800->2208|3859->2258|3899->2260|4068->2393|4088->2404|4184->2477|4280->2542|4323->2550|4376->2594|4416->2596|4577->2721|4597->2732|4688->2800|4777->2858|4820->2866|4878->2915|4918->2917|5095->3058|5115->3069|5211->3142|5307->3207|5407->3272|5420->3277|5467->3302|5669->3469|5750->3528|5893->3636|5979->3700|6099->3785|6281->3944|6427->4055|6547->4152|6696->4266|6819->4366|6977->4489|7239->4728|7717->5169|7738->5180|7819->5238|7959->5342|8003->5376|8044->5378|8179->5495|8193->5500|8233->5501|8287->5518|8305->5526|8360->5558|8795->5957|8847->5992|8888->5994|8962->6031|8983->6042|9066->6101|9190->6188|9210->6198|9236->6201|9287->6214|9308->6224|9335->6227|9460->6315|9481->6326|9577->6398|9697->6481|9735->6496|9788->6512|9830->6531|9883->6547|9935->6576|9988->6592|10035->6616|10088->6632|10157->6678|10210->6694|10253->6727|10294->6729|10333->6731|10353->6741|10406->6771|10441->6773|10574->6869|10595->6880|10693->6954|10839->7067|10971->7163|10986->7168|11114->7272|11160->7286|11194->7288
                    LINES: 26->1|33->6|33->6|35->6|36->7|36->7|36->7|37->5|37->5|38->1|39->5|40->8|41->9|41->9|41->9|41->9|50->18|50->18|50->18|59->27|59->27|59->27|60->28|60->28|60->28|61->29|61->29|61->29|71->39|71->39|71->39|73->41|73->41|73->41|76->44|77->45|77->45|77->45|79->47|79->47|79->47|82->50|83->51|83->51|83->51|86->54|86->54|86->54|89->57|98->66|98->66|98->66|105->73|105->73|109->77|109->77|113->81|113->81|119->87|119->87|125->93|125->93|131->99|133->101|149->117|149->117|149->117|156->124|156->124|156->124|162->130|162->130|162->130|164->132|164->132|164->132|181->149|181->149|181->149|182->150|182->150|182->150|183->151|183->151|183->151|183->151|183->151|183->151|185->153|185->153|185->153|189->157|189->157|190->158|190->158|191->159|191->159|192->160|192->160|193->161|193->161|194->162|194->162|194->162|194->162|194->162|194->162|194->162|196->164|196->164|196->164|201->169|207->175|207->175|207->175|209->177|210->178
                    -- GENERATED --
                */
            