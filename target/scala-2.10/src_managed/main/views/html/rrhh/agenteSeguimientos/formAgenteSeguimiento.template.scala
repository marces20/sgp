
package views.html.rrhh.agenteSeguimientos

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
object formAgenteSeguimiento extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[AgenteSeguimiento],AgenteSeguimiento,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(agenteSeguimientoForm: Form[AgenteSeguimiento],agenteSeguimiento:AgenteSeguimiento):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.86*/("""
"""),format.raw/*4.70*/(""" 

<div class="row menu-acciones">
	<div class="col-sm-10">
		<button type="submit" class="btn btn-default" title="Guardar agente"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>
		<a href=""""),_display_(Seq[Any](/*9.13*/if(request().getHeader("referer"))/*9.47*/{_display_(Seq[Any](format.raw/*9.48*/(""" """),_display_(Seq[Any](/*9.50*/request()/*9.59*/.getHeader("referer"))),format.raw/*9.80*/(""" """)))}/*9.83*/else/*9.88*/{_display_(Seq[Any](_display_(Seq[Any](/*9.90*/controllers/*9.101*/.rrhh.routes.AgentesSeguimientoController.index())),_display_(Seq[Any](/*9.151*/UriTrack/*9.159*/.decode()))))})),format.raw/*9.169*/("""" title="Cancelar editar" class="btn btn-default"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
	</div>
	<div class="col-sm-2">
		<a href=""""),_display_(Seq[Any](/*12.13*/UriTrack/*12.21*/.decode())),format.raw/*12.30*/("""" title="Volver al listado" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
		"""),_display_(Seq[Any](/*13.4*/if(agenteSeguimientoForm.field("id").value)/*13.47*/{_display_(Seq[Any](format.raw/*13.48*/("""<a href=""""),_display_(Seq[Any](/*13.58*/controllers/*13.69*/.rrhh.routes.AgentesSeguimientoController.ver(agenteSeguimientoForm.field("id").value.toLong))),_display_(Seq[Any](/*13.163*/UriTrack/*13.171*/.get("&"))),format.raw/*13.180*/("""" title="Ver agente" class="btn btn-default"><i class="glyphicon glyphicon-align-justify"></i></a>""")))})),format.raw/*13.279*/("""
	</div>
</div>

<input type="hidden" name="""),_display_(Seq[Any](/*17.28*/UriTrack/*17.36*/.getKey())),format.raw/*17.45*/(""" value=""""),_display_(Seq[Any](/*17.54*/UriTrack/*17.62*/.code())),format.raw/*17.69*/("""" />
"""),_display_(Seq[Any](/*18.2*/inputText(agenteSeguimientoForm("id"), 'type -> "hidden", 'id -> "agenteSeguimientoId"))),format.raw/*18.89*/("""
<div class="row">
	
	<div class="col-sm-3">
		<label class="control-label">Agente</label>
			<div class="input-group """),_display_(Seq[Any](/*23.29*/if(agenteSeguimientoForm.error("agente_id") != null)/*23.81*/ {_display_(Seq[Any](format.raw/*23.83*/("""has-error""")))}/*23.93*/else/*23.97*/{_display_(Seq[Any](format.raw/*23.98*/("""has-required""")))})),format.raw/*23.111*/("""">
				"""),_display_(Seq[Any](/*24.6*/inputText(agenteSeguimientoForm("agente.apellido"), 'name -> "", 'class -> "form-control", 'id -> "agente"))),format.raw/*24.113*/("""
				"""),_display_(Seq[Any](/*25.6*/inputText(agenteSeguimientoForm("agente_id"), 'hidden -> "hidden", 'id -> "agente_id"))),format.raw/*25.92*/("""
				<span class="input-group-addon">
				<a href="#" class="searchModal"
							id="searchAgente" 
						 	data-title="Selección de Agente" 
						 	data-url=""""),_display_(Seq[Any](/*30.20*/controllers/*30.31*/.rrhh.routes.AgentesController.modalBuscar())),format.raw/*30.75*/("""" 
						 	data-height="650" data-width="700" 
						 	data-listen="modal.seleccion.agente.simple" 
						 	data-label="#agente" data-field="#agente_id">
				<i class="glyphicon glyphicon-search"></i></a></span>
			</div>
			"""),_display_(Seq[Any](/*36.5*/agenteSeguimientoForm("agente_id")/*36.39*/.error.map/*36.49*/{ error =>_display_(Seq[Any](format.raw/*36.59*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*37.30*/error/*37.35*/.message)),format.raw/*37.43*/("""</div>
			""")))})),format.raw/*38.5*/("""
	</div>
	
	<div class="col-sm-2">
		<div class="form-group">
			<label for="inputFIninicio" class="control-label">Fecha Inicio</label> 
			"""),_display_(Seq[Any](/*44.5*/inputText(agenteSeguimientoForm("fincio"), 'class -> "form-control", 'id -> "fincio"))),format.raw/*44.90*/("""
		</div>
	</div>
	<div class="col-sm-2">
		<div class="form-group">
			<label for="inputFFin" class="control-label">Fecha Fin</label> 
			"""),_display_(Seq[Any](/*50.5*/inputText(agenteSeguimientoForm("ffin"), 'class -> "form-control", 'id -> "ffin"))),format.raw/*50.86*/("""
		</div>
	</div>	
	
	<div class="col-sm-2">
		<div class="form-group """),_display_(Seq[Any](/*55.27*/if(agenteSeguimientoForm.error("tipo_agente_seguimiento_id") != null)/*55.96*/ {_display_(Seq[Any](format.raw/*55.98*/("""has-error""")))}/*55.108*/else/*55.112*/{_display_(Seq[Any](format.raw/*55.113*/("""has-required""")))})),format.raw/*55.126*/("""">
			<label for=""""),_display_(Seq[Any](/*56.17*/agenteSeguimientoForm("tipo_agente_seguimiento_id"))),format.raw/*56.68*/("""" class="control-label">Tipo</label>
			"""),_display_(Seq[Any](/*57.5*/select(agenteSeguimientoForm("tipo_agente_seguimiento_id"), 
			TipoAgenteSeguimiento.find.all().map { p => p.id.toString -> p.nombre}, 
			'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*59.64*/("""
			
			"""),_display_(Seq[Any](/*61.5*/agenteSeguimientoForm("tipo_agente_seguimiento_id")/*61.56*/.error.map/*61.66*/{ error =>_display_(Seq[Any](format.raw/*61.76*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*62.30*/error/*62.35*/.message)),format.raw/*62.43*/("""</div>
			""")))})),format.raw/*63.5*/("""
		</div>
	</div>
	
</div>	
<script>
	$( function() """),format.raw/*69.16*/("""{"""),format.raw/*69.17*/("""
		 
		$("#fincio,#ffin").mask("99/99/9999");
		 
	
	"""),format.raw/*74.2*/("""}"""),format.raw/*74.3*/(""");
</script>

"""))}
    }
    
    def render(agenteSeguimientoForm:Form[AgenteSeguimiento],agenteSeguimiento:AgenteSeguimiento): play.api.templates.HtmlFormat.Appendable = apply(agenteSeguimientoForm,agenteSeguimiento)
    
    def f:((Form[AgenteSeguimiento],AgenteSeguimiento) => play.api.templates.HtmlFormat.Appendable) = (agenteSeguimientoForm,agenteSeguimiento) => apply(agenteSeguimientoForm,agenteSeguimiento)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:31 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agenteSeguimientos/formAgenteSeguimiento.scala.html
                    HASH: 83beb64bc5ac7b8e0e58ab7df18ebf2d7b24a5fb
                    MATRIX: 849->1|1051->120|1083->144|1157->85|1185->188|1428->396|1470->430|1508->431|1545->433|1562->442|1604->463|1624->466|1636->471|1683->473|1703->484|1783->534|1800->542|1836->552|2029->709|2046->717|2077->726|2213->827|2265->870|2304->871|2350->881|2370->892|2495->986|2513->994|2545->1003|2677->1102|2757->1146|2774->1154|2805->1163|2850->1172|2867->1180|2896->1187|2937->1193|3046->1280|3201->1399|3262->1451|3302->1453|3331->1463|3344->1467|3383->1468|3429->1481|3472->1489|3602->1596|3643->1602|3751->1688|3948->1849|3968->1860|4034->1904|4295->2130|4338->2164|4357->2174|4405->2184|4471->2214|4485->2219|4515->2227|4557->2238|4733->2379|4840->2464|5015->2604|5118->2685|5225->2756|5303->2825|5343->2827|5373->2837|5387->2841|5427->2842|5473->2855|5528->2874|5601->2925|5677->2966|5899->3166|5943->3175|6003->3226|6022->3236|6070->3246|6136->3276|6150->3281|6180->3289|6222->3300|6302->3352|6331->3353|6411->3406|6439->3407
                    LINES: 26->1|31->4|31->4|32->1|33->4|38->9|38->9|38->9|38->9|38->9|38->9|38->9|38->9|38->9|38->9|38->9|38->9|38->9|41->12|41->12|41->12|42->13|42->13|42->13|42->13|42->13|42->13|42->13|42->13|42->13|46->17|46->17|46->17|46->17|46->17|46->17|47->18|47->18|52->23|52->23|52->23|52->23|52->23|52->23|52->23|53->24|53->24|54->25|54->25|59->30|59->30|59->30|65->36|65->36|65->36|65->36|66->37|66->37|66->37|67->38|73->44|73->44|79->50|79->50|84->55|84->55|84->55|84->55|84->55|84->55|84->55|85->56|85->56|86->57|88->59|90->61|90->61|90->61|90->61|91->62|91->62|91->62|92->63|98->69|98->69|103->74|103->74
                    -- GENERATED --
                */
            