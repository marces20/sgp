
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
object verTicket extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Ticket,Form[Ticket],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(ticket: Ticket,ticketForm: Form[Ticket]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.43*/("""
"""),format.raw/*5.70*/("""


"""),_display_(Seq[Any](/*8.2*/views/*8.7*/.html.administracion.mainTicket(title = "Lista de tickets")/*8.66*/ {_display_(Seq[Any](format.raw/*8.68*/("""

<div class="page-header">
	<div class="row">
		<div class="col-sm-8">
			<h1>Detalles de ticket</h1>
		</div>
		<div class="col-sm-4">
		<a href=""""),_display_(Seq[Any](/*16.13*/controllers/*16.24*/.administracion.routes.TicketsController.index())),format.raw/*16.72*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-list"></i> Lista de tickets</a>
		<a href=""""),_display_(Seq[Any](/*17.13*/controllers/*17.24*/.administracion.routes.TicketsController.crear())),format.raw/*17.72*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Abrir ticket</a>
		<a href=""""),_display_(Seq[Any](/*18.13*/controllers/*18.24*/.administracion.routes.TicketsController.eliminar(ticket.id))),format.raw/*18.84*/(""""  class="btn btn-default delete-confirm-link"><i class="glyphicon glyphicon-trash icono-eliminar"></i> Eliminar</a>
		</div>
	</div>
</div>


"""),_display_(Seq[Any](/*24.2*/if(flash.containsKey("success"))/*24.34*/ {_display_(Seq[Any](format.raw/*24.36*/("""
    <div class="alert alert-success"><i class="glyphicon glyphicon-ok-sign"></i> """),_display_(Seq[Any](/*25.83*/flash/*25.88*/.get("success"))),format.raw/*25.103*/("""</div>
""")))})),format.raw/*26.2*/(""" 



<div class="row">
		<div class="col-sm-2">
			<label class="control-label">Número</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*33.49*/ticket/*33.55*/.id)),format.raw/*33.58*/("""</p>
		</div>
		
		<div class="col-sm-2">
			<label class="control-label">Fecha</label> 
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*38.49*/(DateUtils.formatDate(ticket.fecha)))),format.raw/*38.85*/("""</p>
		</div>
		
		<div class="col-sm-2">
			<label class="control-label">Prioridad</label> 
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*43.49*/ticket/*43.55*/.getPrioridad())),format.raw/*43.70*/("""</p>
		</div>
		
		<div class="col-sm-2">
			<label class="control-label">Usuario</label> 
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*48.49*/ticket/*48.55*/.usuario.nombre)),format.raw/*48.70*/("""</p>
		</div>
	</div>
<br />
	<div class="row">
		<div class="col-sm-12">
			<label class="control-label">Asunto</label> 
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*55.49*/ticket/*55.55*/.asunto)),format.raw/*55.62*/("""</p>
		</div>
	</div>
<br />
	<div class="row">
		<div class="col-sm-12">
			<label class="control-label">Detalle</label> 
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*62.49*/ticket/*62.55*/.detalles)),format.raw/*62.64*/("""</p>
		</div>
	</div>
	 
		<div class="row">
			<div class="col-sm-12">
				<label class="control-label">Respuesta</label> 
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*69.50*/ticket/*69.56*/.respuesta)),format.raw/*69.66*/("""</p>
			</div>
		</div>
 

<div style="margin-top: 50px">

	<h4>Estado actual: 	<b>"""),_display_(Seq[Any](/*76.26*/ticket/*76.32*/.estado.nombre)),format.raw/*76.46*/("""</b></h4>

	<div class="row margin-bottom-25">	
	
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*81.14*/controllers/*81.25*/.administracion.routes.TicketsController.cambiarEstado(ticket.id, models.Estado.TICKET_ABIERTO))),format.raw/*81.120*/("""" class="btn btn-default">
				<i class="glyphicon glyphicon glyphicon-unchecked"></i> Abierto
			</a>
		</div>	
		
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*87.14*/controllers/*87.25*/.administracion.routes.TicketsController.cambiarEstado(ticket.id, models.Estado.TICKET_EN_PROCESO))),format.raw/*87.123*/("""" class="btn btn-default">
				<i class="glyphicon glyphicon-refresh"></i> En proceso
			</a>
		</div>	
	
	
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*94.14*/controllers/*94.25*/.administracion.routes.TicketsController.cambiarEstado(ticket.id, models.Estado.TICKET_CERRADO))),format.raw/*94.120*/("""" class="btn btn-default">
				<i class="glyphicon glyphicon-stop"></i> Cerrado
			</a>
		</div>	
	
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*100.14*/controllers/*100.25*/.administracion.routes.TicketsController.cambiarEstado(ticket.id, models.Estado.TICKET_CANCELADO))),format.raw/*100.122*/("""" class="btn btn-default">
				<i class="glyphicon glyphicon-remove-sign"></i> Cancelado
			</a>
		</div>	

	</div>


</div>




""")))})))}
    }
    
    def render(ticket:Ticket,ticketForm:Form[Ticket]): play.api.templates.HtmlFormat.Appendable = apply(ticket,ticketForm)
    
    def f:((Ticket,Form[Ticket]) => play.api.templates.HtmlFormat.Appendable) = (ticket,ticketForm) => apply(ticket,ticketForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/administracion/tickets/verTicket.scala.html
                    HASH: ead48f9a660b02e27baff851c57236298c174c8b
                    MATRIX: 814->1|998->103|1030->127|1104->42|1133->171|1174->178|1186->183|1253->242|1292->244|1485->401|1505->412|1575->460|1713->562|1733->573|1803->621|1942->724|1962->735|2044->795|2229->945|2270->977|2310->979|2430->1063|2444->1068|2482->1083|2522->1092|2708->1242|2723->1248|2748->1251|2926->1393|2984->1429|3166->1575|3181->1581|3218->1596|3398->1740|3413->1746|3450->1761|3663->1938|3678->1944|3707->1951|3921->2129|3936->2135|3967->2144|4183->2324|4198->2330|4230->2340|4357->2431|4372->2437|4408->2451|4537->2544|4557->2555|4675->2650|4871->2810|4891->2821|5012->2919|5201->3072|5221->3083|5339->3178|5520->3322|5541->3333|5662->3430
                    LINES: 26->1|33->5|33->5|34->1|35->5|38->8|38->8|38->8|38->8|46->16|46->16|46->16|47->17|47->17|47->17|48->18|48->18|48->18|54->24|54->24|54->24|55->25|55->25|55->25|56->26|63->33|63->33|63->33|68->38|68->38|73->43|73->43|73->43|78->48|78->48|78->48|85->55|85->55|85->55|92->62|92->62|92->62|99->69|99->69|99->69|106->76|106->76|106->76|111->81|111->81|111->81|117->87|117->87|117->87|124->94|124->94|124->94|130->100|130->100|130->100
                    -- GENERATED --
                */
            