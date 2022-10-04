
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
object crearTicket extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Ticket],play.api.templates.HtmlFormat.Appendable] {

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

	"""),_display_(Seq[Any](/*20.3*/helper/*20.9*/.form(action = controllers.administracion.routes.TicketsController.guardar())/*20.86*/ {_display_(Seq[Any](format.raw/*20.88*/("""
	
		
	<div class="row">
		<div class="col-sm-8">
			<label class="control-label">Asunto</label> 
			<div class="form-group">
				"""),_display_(Seq[Any](/*27.6*/inputText(ticketForm("asunto"), 'class -> "form-control"))),format.raw/*27.63*/("""
				"""),_display_(Seq[Any](/*28.6*/ticketForm("asunto")/*28.26*/.error.map/*28.36*/{ error =>_display_(Seq[Any](format.raw/*28.46*/("""
					<div class="text-error"><i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*29.79*/error/*29.84*/.message)),format.raw/*29.92*/("""</div>
				""")))})),format.raw/*30.6*/("""
			</div>
		</div>
		
		<div class="col-sm-4">
			<div class="form-group """),_display_(Seq[Any](/*35.28*/if(ticketForm.error("prioridad") != null)/*35.69*/ {_display_(Seq[Any](format.raw/*35.71*/("""has-error""")))})),format.raw/*35.81*/("""">
				<label class="control-label">Prioridad</label>
				"""),_display_(Seq[Any](/*37.6*/select(ticketForm("prioridad"), options("baja" -> "Baja",
														"media" -> "Media",
														"alta"  -> "Alta"
														), 
				'class -> "form-control select"))),format.raw/*41.37*/("""
			</div>
		</div>
		
	</div>	
	
<div class="row">	
	<div class="col-sm-12">
		<div class="form-group">
			<label for="detalle" class="control-label">Detalles</label>
			"""),_display_(Seq[Any](/*51.5*/textarea(ticketForm("detalles"), 'class -> "form-control", 'id -> "detalle", 'rows -> "5"))),format.raw/*51.95*/("""
			"""),_display_(Seq[Any](/*52.5*/ticketForm("detalles")/*52.27*/.error.map/*52.37*/{ error =>_display_(Seq[Any](format.raw/*52.47*/(""" 
				<div class="text-error">
					<i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*54.55*/error/*54.60*/.message)),format.raw/*54.68*/("""
				</div>
			""")))})),format.raw/*56.5*/("""
		</div>
	</div>

</div>


	<div class="row form-actions">
	    <div class="col-lg-offset-4 col-lg-8">
	      <a href="" class="btn btn-default">Cancelar</a>
	      <button type="submit" class="btn btn-primary">Guardar</button>
	    </div>
	</div>
		
	""")))})),format.raw/*70.3*/("""

""")))})),format.raw/*72.2*/("""
"""))}
    }
    
    def render(ticketForm:Form[Ticket]): play.api.templates.HtmlFormat.Appendable = apply(ticketForm)
    
    def f:((Form[Ticket]) => play.api.templates.HtmlFormat.Appendable) = (ticketForm) => apply(ticketForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/administracion/tickets/crearTicket.scala.html
                    HASH: c928eb52b12b69bf3f2df813c7131071d1be8ade
                    MATRIX: 809->1|938->48|970->72|1044->27|1073->116|1111->120|1123->125|1178->172|1217->174|1410->331|1430->342|1500->390|1655->510|1668->515|1715->540|1756->546|1770->552|1856->629|1896->631|2069->769|2148->826|2190->833|2219->853|2238->863|2286->873|2402->953|2416->958|2446->966|2490->979|2606->1059|2656->1100|2696->1102|2738->1112|2834->1173|3038->1355|3255->1537|3367->1627|3408->1633|3439->1655|3458->1665|3506->1675|3629->1762|3643->1767|3673->1775|3722->1793|4021->2061|4057->2066
                    LINES: 26->1|29->3|29->3|30->1|31->3|32->4|32->4|32->4|32->4|41->13|41->13|41->13|46->18|46->18|46->18|48->20|48->20|48->20|48->20|55->27|55->27|56->28|56->28|56->28|56->28|57->29|57->29|57->29|58->30|63->35|63->35|63->35|63->35|65->37|69->41|79->51|79->51|80->52|80->52|80->52|80->52|82->54|82->54|82->54|84->56|98->70|100->72
                    -- GENERATED --
                */
            