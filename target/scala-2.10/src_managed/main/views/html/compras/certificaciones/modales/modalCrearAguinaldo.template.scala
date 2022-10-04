
package views.html.compras.certificaciones.modales

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
object modalCrearAguinaldo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[DynamicForm,String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm,url: String = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.48*/("""
"""),format.raw/*3.70*/(""" 
																			
"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.compras.routes.CertificacionesAccionesController.crearAguinaldo(), 'id -> "formCrearAguinaldo")/*5.130*/ {_display_(Seq[Any](format.raw/*5.132*/("""	
	
	"""),_display_(Seq[Any](/*7.3*/if(flash.containsKey("error"))/*7.33*/ {_display_(Seq[Any](format.raw/*7.35*/("""
		<div class="alert alert-danger"><i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*8.84*/flash/*8.89*/.get("error"))),format.raw/*8.102*/("""</div>
	""")))})),format.raw/*9.3*/("""
	
	"""),_display_(Seq[Any](/*11.3*/if(flash.containsKey("success"))/*11.35*/ {_display_(Seq[Any](format.raw/*11.37*/("""
		<div class="alert alert-success"><i class="glyphicon glyphicon-ok-circle"></i> """),_display_(Seq[Any](/*12.83*/flash/*12.88*/.get("success"))),format.raw/*12.103*/("""</div>
	""")))})),format.raw/*13.3*/("""
	
	<div class="row">
		<div class="col-sm-2">
			<div class="form-group">
				<label for="meses" class="control-label">Meses
				"""),_display_(Seq[Any](/*19.6*/inputText(formBuscador("meses"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*19.91*/("""
				</label>
			</div>
		</div>
		<div class="col-sm-3">
			<label class="control-label">Expediente
				<div class="input-group">
					"""),_display_(Seq[Any](/*26.7*/inputText(formBuscador("expediente_id_modal_agui"), 'hidden -> "hidden", 'id -> "expediente_id_modal_agui"))),format.raw/*26.114*/("""
					"""),_display_(Seq[Any](/*27.7*/inputText(formBuscador("expediente.nombre"), 'name -> "", 'class -> "form-control", 'id -> "expediente_modal_agui"))),format.raw/*27.122*/("""
					<span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchExpediente" 
									data-title="Selección de expediente" 
									data-url=""""),_display_(Seq[Any](/*32.21*/controllers/*32.32*/.expediente.routes.ExpedientesController.modalBuscar())),format.raw/*32.86*/("""" 
									data-height="650" 
									data-width="700" 
									data-listen="modal.seleccion.expediente.simple" 
									data-label="#expediente_modal_agui" 
									data-field="#expediente_id_modal_agui">
							<i class="glyphicon glyphicon-search"></i>
						</a>
					</span>
				</div>
			</label>
		</div>
		<div class="col-sm-3">
			<label for="inputPeriodo" class="control-label">Periodo</label> 
			<div class="input-group">
				"""),_display_(Seq[Any](/*47.6*/inputText(formBuscador("periodo_modal_agui"),'class -> "form-control",'id -> "periodo_modal_agui"))),format.raw/*47.104*/("""
				"""),_display_(Seq[Any](/*48.6*/inputText(formBuscador("periodo_id_modal_agui"),'hidden -> "hidden",'id -> "periodo_id_modal_agui"))),format.raw/*48.105*/("""
				<span class="input-group-addon">
				<a href="#" class="searchModal"
							id="searchPeriodo" 
							data-title="Selección de Periodo" 
							data-url=""""),_display_(Seq[Any](/*53.19*/controllers/*53.30*/.contabilidad.routes.PeriodosController.modalBuscar())),format.raw/*53.83*/("""" 
							data-height="650" 
							data-width="700" 
							data-listen="modal.seleccion.periodo.simple" 
							data-label="#periodo_modal_agui" 
							data-field="#periodo_id_modal_agui">
					<i class="glyphicon glyphicon-search"></i>
				</a>
				</span>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-5"><br />
			<button type="submit" class="btn btn-default" title="Crear Aguinaldo">
			<i class="glyphicon glyphicon-arrow-right"></i> Crear Aguinaldo</button>
		</div>
	</div>
	<br>
	<div class="row">
		"""),_display_(Seq[Any](/*73.4*/if(url)/*73.11*/ {_display_(Seq[Any](format.raw/*73.13*/("""
			<div class="panel panel-default">
				<div class="panel-body">
			    	<i class="glyphicon glyphicon-save"></i> 
			    	<a href=""""),_display_(Seq[Any](/*77.19*/controllers/*77.30*/.contabilidad.routes.FacturasAccionesController.descargar322(url))),format.raw/*77.95*/("""">Descargar archivo de Planilla Sueldos</a>
				</div>
			</div>
		""")))})),format.raw/*80.4*/("""
	</div>

""")))})),format.raw/*83.2*/("""
<script>
$( function()"""),format.raw/*85.14*/("""{"""),format.raw/*85.15*/("""
	if($("#periodo_modal_agui").length)"""),format.raw/*86.37*/("""{"""),format.raw/*86.38*/("""
		var options = """),format.raw/*87.17*/("""{"""),format.raw/*87.18*/("""
				script:"/contabilidad/suggestPeriodo/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*93.30*/("""{"""),format.raw/*93.31*/(""" 
											$("#periodo_id_modal_agui").val(obj.id); 
										 """),format.raw/*95.12*/("""}"""),format.raw/*95.13*/("""
			"""),format.raw/*96.4*/("""}"""),format.raw/*96.5*/(""";
		var as_json = new bsn.AutoSuggest('periodo_modal_agui', options);
	"""),format.raw/*98.2*/("""}"""),format.raw/*98.3*/("""
	if($("#expediente_modal_agui").length)"""),format.raw/*99.40*/("""{"""),format.raw/*99.41*/("""
		var options = """),format.raw/*100.17*/("""{"""),format.raw/*100.18*/("""
				script:"/suggestExpediente/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*106.30*/("""{"""),format.raw/*106.31*/(""" 
											$("#expediente_id_modal_agui").val(obj.id); 
										 """),format.raw/*108.12*/("""}"""),format.raw/*108.13*/("""
			"""),format.raw/*109.4*/("""}"""),format.raw/*109.5*/(""";
		var as_json = new bsn.AutoSuggest('expediente_modal_agui', options);
	"""),format.raw/*111.2*/("""}"""),format.raw/*111.3*/("""
"""),format.raw/*112.1*/("""}"""),format.raw/*112.2*/(""");
</script>
"""),_display_(Seq[Any](/*114.2*/flash()/*114.9*/.clear())))}
    }
    
    def render(formBuscador:DynamicForm,url:String): play.api.templates.HtmlFormat.Appendable = apply(formBuscador,url)
    
    def f:((DynamicForm,String) => play.api.templates.HtmlFormat.Appendable) = (formBuscador,url) => apply(formBuscador,url)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:43 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/certificaciones/modales/modalCrearAguinaldo.scala.html
                    HASH: d5409db958be9b8db26bed96dc8dff29ae82dc85
                    MATRIX: 832->1|980->66|1012->90|1086->47|1114->134|1171->157|1184->163|1315->285|1355->287|1395->293|1433->323|1472->325|1591->409|1604->414|1639->427|1678->436|1718->441|1759->473|1799->475|1918->558|1932->563|1970->578|2010->587|2176->718|2283->803|2455->940|2585->1047|2627->1054|2765->1169|2977->1345|2997->1356|3073->1410|3552->1854|3673->1952|3714->1958|3836->2057|4033->2218|4053->2229|4128->2282|4696->2815|4712->2822|4752->2824|4923->2959|4943->2970|5030->3035|5129->3103|5171->3114|5222->3137|5251->3138|5316->3175|5345->3176|5390->3193|5419->3194|5594->3341|5623->3342|5717->3408|5746->3409|5777->3413|5805->3414|5903->3485|5931->3486|5999->3526|6028->3527|6074->3544|6104->3545|6270->3682|6300->3683|6398->3752|6428->3753|6460->3757|6489->3758|6591->3832|6620->3833|6649->3834|6678->3835|6728->3849|6744->3856
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|35->7|35->7|35->7|36->8|36->8|36->8|37->9|39->11|39->11|39->11|40->12|40->12|40->12|41->13|47->19|47->19|54->26|54->26|55->27|55->27|60->32|60->32|60->32|75->47|75->47|76->48|76->48|81->53|81->53|81->53|101->73|101->73|101->73|105->77|105->77|105->77|108->80|111->83|113->85|113->85|114->86|114->86|115->87|115->87|121->93|121->93|123->95|123->95|124->96|124->96|126->98|126->98|127->99|127->99|128->100|128->100|134->106|134->106|136->108|136->108|137->109|137->109|139->111|139->111|140->112|140->112|142->114|142->114
                    -- GENERATED --
                */
            