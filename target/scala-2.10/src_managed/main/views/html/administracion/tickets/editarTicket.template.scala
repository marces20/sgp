
package views.html.administracion.tickets

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
object editarTicket extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Ticket],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(ticketForm: Form[Ticket]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.28*/("""
"""),format.raw/*3.70*/(""" 
"""),_display_(Seq[Any](/*4.2*/views/*4.7*/.html.administracion.mainTicket("Abrir ticket")/*4.54*/ {_display_(Seq[Any](format.raw/*4.56*/("""

<div class="page-header">
	<div class="row">
		<div class="col-sm-10">
			<h1>Abrir ticket</h1>
		</div>
		
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*13.14*/controllers/*13.25*/.administracion.routes.TicketsController.index())),format.raw/*13.73*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i> Tickets abiertos</a> 
		</div>
	</div>
</div>

"""),_display_(Seq[Any](/*18.2*/views/*18.7*/.html.tags.successError())),format.raw/*18.32*/("""

	"""),_display_(Seq[Any](/*20.3*/helper/*20.9*/.form(action = controllers.administracion.routes.TicketsController.actualizar())/*20.89*/ {_display_(Seq[Any](format.raw/*20.91*/("""
	"""),_display_(Seq[Any](/*21.3*/inputText(ticketForm("estado_id"), 'hidden -> "hidden"))),format.raw/*21.58*/("""
	"""),_display_(Seq[Any](/*22.3*/inputText(ticketForm("usuario_id"), 'hidden -> "hidden"))),format.raw/*22.59*/("""
	"""),_display_(Seq[Any](/*23.3*/inputText(ticketForm("leido"), 'hidden -> "hidden"))),format.raw/*23.54*/("""	
	"""),_display_(Seq[Any](/*24.3*/inputText(ticketForm("fecha"), 'hidden -> "hidden"))),format.raw/*24.54*/("""	
	"""),_display_(Seq[Any](/*25.3*/inputText(ticketForm("id"), 'hidden -> "hidden"))),format.raw/*25.51*/("""	
		
		
		<div class="row">
			<div class="col-sm-8">
				<label class="control-label">Asunto</label> 
				<div class="form-group">
					"""),_display_(Seq[Any](/*32.7*/inputText(ticketForm("asunto"), 'class -> "form-control"))),format.raw/*32.64*/("""
					"""),_display_(Seq[Any](/*33.7*/ticketForm("asunto")/*33.27*/.error.map/*33.37*/{ error =>_display_(Seq[Any](format.raw/*33.47*/("""
						<div class="text-error"><i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*34.80*/error/*34.85*/.message)),format.raw/*34.93*/("""</div>
					""")))})),format.raw/*35.7*/("""
				</div>
			</div>
			
			<div class="col-sm-4">
				<div class="form-group """),_display_(Seq[Any](/*40.29*/if(ticketForm.error("prioridad") != null)/*40.70*/ {_display_(Seq[Any](format.raw/*40.72*/("""has-error""")))})),format.raw/*40.82*/("""">
					<label class="control-label">Prioridad</label>
					"""),_display_(Seq[Any](/*42.7*/select(ticketForm("prioridad"), options("baja" -> "Baja",
															"media" -> "Media",
															"alta"  -> "Alta"
															), 
					'class -> "form-control select"))),format.raw/*46.38*/("""
				</div>
			</div>
		</div>	
	
		<div class="row">	
			<div class="col-sm-12">
				<div class="form-group">
					<label for="detalle" class="control-label">Detalles</label>
					"""),_display_(Seq[Any](/*55.7*/textarea(ticketForm("detalles"), 'class -> "form-control", 'id -> "detalle", 'rows -> "5"))),format.raw/*55.97*/("""
					"""),_display_(Seq[Any](/*56.7*/ticketForm("detalles")/*56.29*/.error.map/*56.39*/{ error =>_display_(Seq[Any](format.raw/*56.49*/(""" 
						<div class="text-error">
							<i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*58.57*/error/*58.62*/.message)),format.raw/*58.70*/("""
						</div>
					""")))})),format.raw/*60.7*/("""
				</div>
			</div>
		</div>
		<div class="row">	
			<div class="col-sm-12">
				<div class="form-group">
					<label for="detalle" class="control-label">Respuesta</label>
					"""),_display_(Seq[Any](/*68.7*/textarea(ticketForm("respuesta"), 'class -> "form-control", 'id -> "respuesta", 'rows -> "5"))),format.raw/*68.100*/("""
					 
				</div>
			</div>
		</div>
	
		<div class="row form-actions">
		    <div class="col-lg-offset-4 col-lg-8">
		      <a href="" class="btn btn-default">Cancelar</a>
		      <button type="submit" class="btn btn-primary">Guardar</button>
		    </div>
		</div>
		
	""")))})),format.raw/*81.3*/("""

""")))})))}
    }
    
    def render(ticketForm:Form[Ticket]): play.api.templates.HtmlFormat.Appendable = apply(ticketForm)
    
    def f:((Form[Ticket]) => play.api.templates.HtmlFormat.Appendable) = (ticketForm) => apply(ticketForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/administracion/tickets/editarTicket.scala.html
                    HASH: 577edd6921389708f653b3ef1e561c4b870ca454
                    MATRIX: 810->1|938->46|970->70|1044->27|1072->114|1109->117|1121->122|1176->169|1215->171|1399->319|1419->330|1489->378|1639->493|1652->498|1699->523|1738->527|1752->533|1841->613|1881->615|1919->618|1996->673|2034->676|2112->732|2150->735|2223->786|2262->790|2335->841|2374->845|2444->893|2617->1031|2696->1088|2738->1095|2767->1115|2786->1125|2834->1135|2950->1215|2964->1220|2994->1228|3038->1241|3154->1321|3204->1362|3244->1364|3286->1374|3382->1435|3586->1617|3803->1799|3915->1889|3957->1896|3988->1918|4007->1928|4055->1938|4180->2027|4194->2032|4224->2040|4275->2060|4490->2240|4606->2333|4909->2605
                    LINES: 26->1|29->3|29->3|30->1|31->3|32->4|32->4|32->4|32->4|41->13|41->13|41->13|46->18|46->18|46->18|48->20|48->20|48->20|48->20|49->21|49->21|50->22|50->22|51->23|51->23|52->24|52->24|53->25|53->25|60->32|60->32|61->33|61->33|61->33|61->33|62->34|62->34|62->34|63->35|68->40|68->40|68->40|68->40|70->42|74->46|83->55|83->55|84->56|84->56|84->56|84->56|86->58|86->58|86->58|88->60|96->68|96->68|109->81
                    -- GENERATED --
                */
            