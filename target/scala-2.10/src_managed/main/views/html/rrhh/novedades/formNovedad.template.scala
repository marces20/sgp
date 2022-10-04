
package views.html.rrhh.novedades

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
object formNovedad extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Novedad],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(nForm: Form[Novedad]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.24*/("""
"""),format.raw/*3.70*/(""" 

	"""),_display_(Seq[Any](/*5.3*/views/*5.8*/.html.tags.successError())),format.raw/*5.33*/("""
	
<div class="row">
	
	<div class="col-sm-6 """),_display_(Seq[Any](/*9.24*/if(nForm.error("agente_id") != null)/*9.60*/ {_display_(Seq[Any](format.raw/*9.62*/("""has-error""")))}/*9.73*/else/*9.78*/{_display_(Seq[Any](format.raw/*9.79*/("""has-required""")))})),format.raw/*9.92*/("""">
		<label class="control-label">Agente
			<div class="input-group">
				"""),_display_(Seq[Any](/*12.6*/inputText(nForm("agente.apellido"), 'name -> "", 'autocomplete -> "off", 'class -> "form-control", 'id -> "agente"))),format.raw/*12.121*/("""
				"""),_display_(Seq[Any](/*13.6*/inputText(nForm("agente_id"), 'hidden -> "hidden", 'id -> "agente_id"))),format.raw/*13.76*/("""
				<span class="input-group-addon"><a href="#" id="searchAgente" data-title="Selección de agente" data-url=""""),_display_(Seq[Any](/*14.111*/controllers/*14.122*/.rrhh.routes.AgentesController.modalBuscar())),format.raw/*14.166*/("""" data-height="650" data-width="700" data-listen="modal.seleccion.agente.simple" data-label="#agente" data-field="#agente_id"><i class="glyphicon glyphicon-search"></i></a></span>
			</div>
		</label>
			"""),_display_(Seq[Any](/*17.5*/nForm("agente_id")/*17.23*/.error.map/*17.33*/{ error =>_display_(Seq[Any](format.raw/*17.43*/(""" <div class="text-error">"""),_display_(Seq[Any](/*17.69*/error/*17.74*/.message)),format.raw/*17.82*/("""</div>""")))})),format.raw/*17.89*/("""
	</div>
	
	<div class="col-sm-3">
		<label class="control-label">Fecha de inicio</label> 
		<div class="form-group """),_display_(Seq[Any](/*22.27*/if(nForm.error("fecha_inicio")  != null)/*22.67*/ {_display_(Seq[Any](format.raw/*22.69*/("""has-error""")))}/*22.80*/else/*22.85*/{_display_(Seq[Any](format.raw/*22.86*/("""has-required""")))})),format.raw/*22.99*/("""">
			"""),_display_(Seq[Any](/*23.5*/inputText(nForm("fecha_inicio"),'class -> "form-control date", 'autocomplete -> "off", 'id -> "fecha_inicio"))),format.raw/*23.114*/("""
		</div>
		"""),_display_(Seq[Any](/*25.4*/nForm("fecha_inicio")/*25.25*/.error.map/*25.35*/{ error =>_display_(Seq[Any](format.raw/*25.45*/("""<div class="text-error">"""),_display_(Seq[Any](/*25.70*/error/*25.75*/.message)),format.raw/*25.83*/("""</div>""")))})),format.raw/*25.90*/("""
	</div>

	
	<div class="col-sm-2">
		<label class="control-label">Tiempo</label> 
		<div class="form-group """),_display_(Seq[Any](/*31.27*/if(nForm.error("horas")  != null)/*31.60*/ {_display_(Seq[Any](format.raw/*31.62*/("""has-error""")))}/*31.73*/else/*31.78*/{_display_(Seq[Any](format.raw/*31.79*/("""has-required""")))})),format.raw/*31.92*/("""">
			"""),_display_(Seq[Any](/*32.5*/inputText(nForm("horas"),'class -> "form-control", 'autocomplete -> "off", 'id -> "horas"))),format.raw/*32.95*/("""
		</div>
		"""),_display_(Seq[Any](/*34.4*/nForm("horas")/*34.18*/.error.map/*34.28*/{ error =>_display_(Seq[Any](format.raw/*34.38*/("""<div class="text-error">"""),_display_(Seq[Any](/*34.63*/error/*34.68*/.message)),format.raw/*34.76*/("""</div>""")))})),format.raw/*34.83*/("""
	</div>
	
	
		<div class="col-sm-6">
			<label for="servicio" class="control-label">Servicio</label> 
			<div class="input-group """),_display_(Seq[Any](/*40.29*/if(nForm.error("servicio_id")  != null)/*40.68*/ {_display_(Seq[Any](format.raw/*40.70*/("""has-error""")))}/*40.81*/else/*40.86*/{_display_(Seq[Any](format.raw/*40.87*/("""has-required""")))})),format.raw/*40.100*/("""">
				"""),_display_(Seq[Any](/*41.6*/inputText(nForm("servicio.nombre"),'class -> "form-control",'id -> "servicio"))),format.raw/*41.84*/("""
				"""),_display_(Seq[Any](/*42.6*/inputText(nForm("servicio_id"),'hidden -> "hidden",'id -> "servicio_id"))),format.raw/*42.78*/("""
				<span class="input-group-addon">
				<a href="#" class="searchModal"
							id="searchServicio" 
							data-title="Selección de servicios" 
							data-url=""""),_display_(Seq[Any](/*47.19*/controllers/*47.30*/.administracion.routes.OrganigramasController.modalBuscarServicios())),format.raw/*47.98*/("""" 
							data-height="650" 
							data-width="700" 
							data-listen="modal.seleccion.servicio.simple" 
							data-label="#servicio" 
							data-field="#servicio_id">
					<i class="glyphicon glyphicon-search"></i>
				</a>
				</span>
			</div>
			"""),_display_(Seq[Any](/*57.5*/nForm("departamento_id")/*57.29*/.error.map/*57.39*/{ error =>_display_(Seq[Any](format.raw/*57.49*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*58.31*/error/*58.36*/.message)),format.raw/*58.44*/("""</div>
				""")))})),format.raw/*59.6*/("""
		</div>
	
</div>	
	
<div class="row ">

	<div class="col-sm-12">
		<label for="obs" class="control-label">Descripción</label> 
		"""),_display_(Seq[Any](/*68.4*/textarea(nForm("descripcion"), 'class -> "form-control", 'rows -> "4"))),format.raw/*68.74*/("""
	</div>

</div>
	
<div class="row">
	<div class="col-sm-4 col-sm-offset-4">
		<button type="submit" class="btn btn-default"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>
		<a href="" class="btn btn-default cancelar"  id="btnCancelar"><i class="glyphicon glyphicon-floppy-remove"></i>Cancelar</a>
	</div>
</div>
	


<script>
$( function()"""),format.raw/*83.14*/("""{"""),format.raw/*83.15*/("""
	$('#searchAgente').modalSearch();
	$('#searchServicio').modalSearch();
	$("#fecha_inicio").mask("99/99/9999 99:99");
	$("#horas").mask("99:99");
	
"""),format.raw/*89.1*/("""}"""),format.raw/*89.2*/(""");
</script>

"""),_display_(Seq[Any](/*92.2*/flash()/*92.9*/.clear())))}
    }
    
    def render(nForm:Form[Novedad]): play.api.templates.HtmlFormat.Appendable = apply(nForm)
    
    def f:((Form[Novedad]) => play.api.templates.HtmlFormat.Appendable) = (nForm) => apply(nForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:31 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/novedades/formNovedad.scala.html
                    HASH: 9287f9ff8194809660ab7fd7ae1e00158595fed7
                    MATRIX: 802->1|927->44|959->68|1033->23|1062->112|1103->119|1115->124|1161->149|1246->199|1290->235|1329->237|1357->248|1369->253|1407->254|1451->267|1564->345|1702->460|1744->467|1836->537|1985->649|2006->660|2073->704|2316->912|2343->930|2362->940|2410->950|2472->976|2486->981|2516->989|2555->996|2713->1118|2762->1158|2802->1160|2831->1171|2844->1176|2883->1177|2928->1190|2971->1198|3103->1307|3153->1322|3183->1343|3202->1353|3250->1363|3311->1388|3325->1393|3355->1401|3394->1408|3545->1523|3587->1556|3627->1558|3656->1569|3669->1574|3708->1575|3753->1588|3796->1596|3908->1686|3958->1701|3981->1715|4000->1725|4048->1735|4109->1760|4123->1765|4153->1773|4192->1780|4365->1917|4413->1956|4453->1958|4482->1969|4495->1974|4534->1975|4580->1988|4624->1997|4724->2075|4766->2082|4860->2154|5065->2323|5085->2334|5175->2402|5476->2668|5509->2692|5528->2702|5576->2712|5644->2744|5658->2749|5688->2757|5732->2770|5908->2911|6000->2981|6400->3353|6429->3354|6611->3509|6639->3510|6692->3528|6707->3535
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|37->9|37->9|37->9|37->9|37->9|37->9|37->9|40->12|40->12|41->13|41->13|42->14|42->14|42->14|45->17|45->17|45->17|45->17|45->17|45->17|45->17|45->17|50->22|50->22|50->22|50->22|50->22|50->22|50->22|51->23|51->23|53->25|53->25|53->25|53->25|53->25|53->25|53->25|53->25|59->31|59->31|59->31|59->31|59->31|59->31|59->31|60->32|60->32|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|68->40|68->40|68->40|68->40|68->40|68->40|68->40|69->41|69->41|70->42|70->42|75->47|75->47|75->47|85->57|85->57|85->57|85->57|86->58|86->58|86->58|87->59|96->68|96->68|111->83|111->83|117->89|117->89|120->92|120->92
                    -- GENERATED --
                */
            