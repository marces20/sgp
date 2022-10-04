
package views.html.haberes.escalasLaboralesMontos

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
object indexEscalaLaboralMonto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[models.haberes.EscalaLaboralMonto],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[models.haberes.EscalaLaboralMonto], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

implicit def /*6.2*/implicitFieldConstructor/*6.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.103*/("""
"""),format.raw/*5.1*/("""
"""),format.raw/*6.70*/(""" 
"""),_display_(Seq[Any](/*7.2*/views/*7.7*/.html.haberes.mainHaberes("Lista Montos Escalas Laborales ")/*7.67*/ {_display_(Seq[Any](format.raw/*7.69*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Lista Montos Escalas Laborales</h1>
			</div>
	
			<div class="col-sm-5">
				<div class="pull-right btn-header">
					<a href=""""),_display_(Seq[Any](/*17.16*/controllers/*17.27*/.haberes.routes.EscalasLaboralesMontosController.crear())),format.raw/*17.83*/("""?"""),_display_(Seq[Any](/*17.85*/UriTrack/*17.93*/.encode())),format.raw/*17.102*/(""""  class="form-control btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nueva Monto</a>
				</div>
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*23.3*/views/*23.8*/.html.tags.successError())),format.raw/*23.33*/("""
	
	<div id="actions">
		<form action="" method="GET">
			<div class="row">
				<div class="col-sm-3">
					<label class="control-label">Concepto</label>
					<div class="input-group">
						"""),_display_(Seq[Any](/*31.8*/inputText(formBuscador("concepto.denominacion"), 'class -> "form-control", 'id -> "concepto"))),format.raw/*31.101*/("""
						"""),_display_(Seq[Any](/*32.8*/inputText(formBuscador("liquidacion_concepto_id"), 'hidden -> "hidden", 'id -> "liquidacion_concepto_id"))),format.raw/*32.113*/("""
						<span class="input-group-addon"><a href="#" id="searchConcepto" data-title="Selección de concepto" data-url=""""),_display_(Seq[Any](/*33.117*/controllers/*33.128*/.haberes.routes.LiquidacionConceptosController.modalBuscar())),format.raw/*33.188*/("""" data-height="650" data-width="700" data-listen="modal.seleccion.concepto.simple" data-label="#concepto" data-field="#liquidacion_concepto_id"><i class="glyphicon glyphicon-search"></i></a></span>
					</div>
					"""),_display_(Seq[Any](/*35.7*/formBuscador("liquidacion_concepto_id")/*35.46*/.error.map/*35.56*/{ error =>_display_(Seq[Any](format.raw/*35.66*/(""" <div class="text-error">"""),_display_(Seq[Any](/*35.92*/error/*35.97*/.message)),format.raw/*35.105*/("""</div>""")))})),format.raw/*35.112*/("""
				</div>		
				<div class="col-sm-2">
					<div class="form-group">
						<label for="nombre" class="control-label">Estado
						"""),_display_(Seq[Any](/*40.8*/select(formBuscador("activo"), options("true"->"Activo", "false"->"Inactivo"), 'class -> "form-control", '_default -> "Seleccionar"))),format.raw/*40.140*/("""
						</label>
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
					<a href=""""),_display_(Seq[Any](/*53.16*/controllers/*53.27*/.haberes.routes.EscalasLaboralesMontosController.index())),format.raw/*53.83*/(""""  class="form-control btn btn-default">Limpiar</a>
					</div>
				</div>
			</div>
		</form>
	</div>
	
	"""),_display_(Seq[Any](/*60.3*/if(buscador.getTotalRowCount == 0)/*60.37*/ {_display_(Seq[Any](format.raw/*60.39*/("""
        
        <div class="well">
            <em>No se encuentran Montos Escalas Laborales</em>
        </div>
        
    """)))}/*66.7*/else/*66.12*/{_display_(Seq[Any](format.raw/*66.13*/("""
    
    	Mostrando """),_display_(Seq[Any](/*68.17*/buscador/*68.25*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*68.57*/(""" resultado(s). 
		
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th width="30">
						<input type="checkbox" name="checkAll" id="checkAll"/>
					</th>
					<th width="30">#</th>
					<th>Codigo</th>
					<th>Concepto</th>
					<th>Escala</th>
					<th>Importe</th>
					<th>Estado</th>
					<th>Fecha-Baja</th>
					<th width="30">#</th>
				</tr>
			</thead>
			<tbody>
			"""),_display_(Seq[Any](/*87.5*/for(lc <- buscador.getList) yield /*87.32*/ {_display_(Seq[Any](format.raw/*87.34*/("""
				<tr class="pointer" data-href=""""),_display_(Seq[Any](/*88.37*/controllers/*88.48*/.haberes.routes.EscalasLaboralesMontosController.ver(lc.id))),format.raw/*88.107*/("""&"""),_display_(Seq[Any](/*88.109*/UriTrack/*88.117*/.encode())),format.raw/*88.126*/("""">
					<td><input type="checkbox" name="check_listado[]" value=""""),_display_(Seq[Any](/*89.64*/lc/*89.66*/.id)),format.raw/*89.69*/("""" class="notSeleccion" id="check-"""),_display_(Seq[Any](/*89.103*/lc/*89.105*/.id)),format.raw/*89.108*/(""""/></td>
					<td>
						"""),_display_(Seq[Any](/*91.8*/if(Permiso.check("escalaLaboralMontoEditar"))/*91.53*/ {_display_(Seq[Any](format.raw/*91.55*/("""
						<a class="btn btn-default btn-xs notSeleccion" href=""""),_display_(Seq[Any](/*92.61*/controllers/*92.72*/.haberes.routes.EscalasLaboralesMontosController.editar(lc.id))),format.raw/*92.134*/("""&"""),_display_(Seq[Any](/*92.136*/UriTrack/*92.144*/.encode())),format.raw/*92.153*/("""">
							<i class="glyphicon glyphicon-edit"></i>
						</a>
						""")))})),format.raw/*95.8*/("""
					</td>
					<td>"""),_display_(Seq[Any](/*97.11*/(lc.liquidacionConcepto.codigo))),format.raw/*97.42*/("""</td>
					<td>"""),_display_(Seq[Any](/*98.11*/(lc.liquidacionConcepto.denominacion))),format.raw/*98.48*/("""</td>
					<td>
						"""),_display_(Seq[Any](/*100.8*/if(lc.escalaLaboral != null)/*100.36*/{_display_(Seq[Any](format.raw/*100.37*/("""
							"""),_display_(Seq[Any](/*101.9*/(lc.escalaLaboral.nombre))),format.raw/*101.34*/("""
						""")))})),format.raw/*102.8*/("""
					</td>
					<td>"""),_display_(Seq[Any](/*104.11*/(utils.NumberUtils.moneda(lc.importe_referencia)))),format.raw/*104.60*/("""</td>
					<td>
						"""),_display_(Seq[Any](/*106.8*/if(lc.activo)/*106.21*/{_display_(Seq[Any](format.raw/*106.22*/("""
							Activo
						""")))}/*108.8*/else/*108.12*/{_display_(Seq[Any](format.raw/*108.13*/("""
							Inactivo
						""")))})),format.raw/*110.8*/("""
					</td>
					<td>"""),_display_(Seq[Any](/*112.11*/(utils.DateUtils.formatDate(lc.fecha_baja)))),format.raw/*112.54*/("""</td>
					<td>
						"""),_display_(Seq[Any](/*114.8*/if(Permiso.check("escalaLaboralMontoEditar"))/*114.53*/ {_display_(Seq[Any](format.raw/*114.55*/("""
						<a class="btn btn-default btn-xs delete-confirm-link notSeleccion" href=""""),_display_(Seq[Any](/*115.81*/controllers/*115.92*/.haberes.routes.EscalasLaboralesMontosController.eliminar(lc.id))),format.raw/*115.156*/("""&"""),_display_(Seq[Any](/*115.158*/UriTrack/*115.166*/.encode())),format.raw/*115.175*/("""">
							<i class="glyphicon glyphicon-trash icono-eliminar"></i>
						</a>
						""")))})),format.raw/*118.8*/("""
					</td>
				</tr>
             """)))})),format.raw/*121.15*/("""
	        </tbody>
        </table>
        
        <div class="pagination pull-right">
		    """),_display_(Seq[Any](/*126.8*/views/*126.13*/.html.helpers.paginador(buscador, controllers.haberes.routes.EscalasLaboralesMontosController.index()))),format.raw/*126.115*/("""
		</div>
 	 """)))})),format.raw/*128.5*/("""
""")))})))}
    }
    
    def render(buscador:utils.pagination.Pagination[models.haberes.EscalaLaboralMonto],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[models.haberes.EscalaLaboralMonto],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/escalasLaboralesMontos/indexEscalaLaboralMonto.scala.html
                    HASH: ba6f6d6d5656778bf2d3ecb9a6692504f3ea6b05
                    MATRIX: 891->1|1132->160|1164->184|1239->102|1266->158|1294->228|1331->231|1343->236|1411->296|1450->298|1698->510|1718->521|1796->577|1834->579|1851->587|1883->596|2062->740|2075->745|2122->770|2349->962|2465->1055|2508->1063|2636->1168|2790->1285|2811->1296|2894->1356|3145->1572|3193->1611|3212->1621|3260->1631|3322->1657|3336->1662|3367->1670|3407->1677|3575->1810|3730->1942|4149->2325|4169->2336|4247->2392|4389->2499|4432->2533|4472->2535|4619->2665|4632->2670|4671->2671|4729->2693|4746->2701|4800->2733|5244->3142|5287->3169|5327->3171|5400->3208|5420->3219|5502->3278|5541->3280|5559->3288|5591->3297|5693->3363|5704->3365|5729->3368|5800->3402|5812->3404|5838->3407|5899->3433|5953->3478|5993->3480|6090->3541|6110->3552|6195->3614|6234->3616|6252->3624|6284->3633|6384->3702|6442->3724|6495->3755|6547->3771|6606->3808|6665->3831|6703->3859|6743->3860|6788->3869|6836->3894|6876->3902|6935->3924|7007->3973|7066->3996|7089->4009|7129->4010|7170->4032|7184->4036|7224->4037|7280->4061|7339->4083|7405->4126|7464->4149|7519->4194|7560->4196|7678->4277|7699->4288|7787->4352|7827->4354|7846->4362|7879->4371|7996->4456|8065->4492|8197->4588|8212->4593|8338->4695|8384->4709
                    LINES: 26->1|33->6|33->6|34->1|35->5|36->6|37->7|37->7|37->7|37->7|47->17|47->17|47->17|47->17|47->17|47->17|53->23|53->23|53->23|61->31|61->31|62->32|62->32|63->33|63->33|63->33|65->35|65->35|65->35|65->35|65->35|65->35|65->35|65->35|70->40|70->40|83->53|83->53|83->53|90->60|90->60|90->60|96->66|96->66|96->66|98->68|98->68|98->68|117->87|117->87|117->87|118->88|118->88|118->88|118->88|118->88|118->88|119->89|119->89|119->89|119->89|119->89|119->89|121->91|121->91|121->91|122->92|122->92|122->92|122->92|122->92|122->92|125->95|127->97|127->97|128->98|128->98|130->100|130->100|130->100|131->101|131->101|132->102|134->104|134->104|136->106|136->106|136->106|138->108|138->108|138->108|140->110|142->112|142->112|144->114|144->114|144->114|145->115|145->115|145->115|145->115|145->115|145->115|148->118|151->121|156->126|156->126|156->126|158->128
                    -- GENERATED --
                */
            