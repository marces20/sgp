
package views.html.presupuesto.creditoPresupuestario

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
object verCreditoPresupuestario extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[CreditoPresupuestario,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(creditoPresupuestario: CreditoPresupuestario):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._


Seq[Any](format.raw/*1.48*/("""
"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/views/*6.7*/.html.presupuesto.mainPresupuesto("Credito Presupuestario")/*6.66*/ {_display_(Seq[Any](format.raw/*6.68*/("""
	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Vista de Credito Presupuestario</h1>
			</div>
			<div class="col-sm-5">
				<div class="pull-right">
					
				</div>
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*20.3*/views/*20.8*/.html.tags.successError())),format.raw/*20.33*/("""
	
	<div class="row menu-acciones">
		<div class="col-sm-9">
			"""),_display_(Seq[Any](/*24.5*/if(Permiso.check("crearCredito"))/*24.38*/ {_display_(Seq[Any](format.raw/*24.40*/("""  	
				<a href=""""),_display_(Seq[Any](/*25.15*/controllers/*25.26*/.presupuesto.routes.CreditosPresupuestariosController.crear)),format.raw/*25.85*/(""""  class="btn btn-default">
				<i class="glyphicon glyphicon-plus-sign"></i> Nuevo</a>
				
				<a href=""""),_display_(Seq[Any](/*28.15*/controllers/*28.26*/.presupuesto.routes.CreditosPresupuestariosController.editar(creditoPresupuestario.id))),format.raw/*28.112*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-edit"></i> Editar</a>
			""")))})),format.raw/*29.5*/("""
			"""),_display_(Seq[Any](/*30.5*/if(Permiso.check("eliminarCredito"))/*30.41*/ {_display_(Seq[Any](format.raw/*30.43*/("""  	
			<a href=""""),_display_(Seq[Any](/*31.14*/controllers/*31.25*/.presupuesto.routes.CreditosPresupuestariosController.crear)),format.raw/*31.84*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-trash icono-eliminar"></i> Eliminar</a>
			""")))})),format.raw/*32.5*/("""		
		</div>
		<div class="col-sm-3">
			<a href=""""),_display_(Seq[Any](/*35.14*/controllers/*35.25*/.presupuesto.routes.CreditosPresupuestariosController.index())),format.raw/*35.86*/("""" class="btn btn-default">
				<i class="glyphicon glyphicon-list"></i>
			</a>
			<a href="#" class="btn btn-default">
				<i class="glyphicon glyphicon-align-justify"></i>
			</a>
		</div>
	</div>
	 
	<div class="row">
		<div class="col-sm-6">
			<label for="inputNombre" class="control-label">Ley</label> 
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*47.49*/if(creditoPresupuestario.nombre != null)/*47.89*/{_display_(Seq[Any](_display_(Seq[Any](/*47.91*/creditoPresupuestario/*47.112*/.nombre))))})),format.raw/*47.120*/("""</p>
		</div>
		<div class="col-sm-2">
			<label class="control-label">Ejercicio</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*51.49*/if(creditoPresupuestario.ejercicio != null)/*51.92*/{_display_(Seq[Any](_display_(Seq[Any](/*51.94*/creditoPresupuestario/*51.115*/.ejercicio.nombre))))})),format.raw/*51.133*/("""</p>
		</div>
		
		<div class="col-sm-2">
			<label for="expediente" class="control-label">Expediente</label> 
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*56.49*/if(creditoPresupuestario.expediente != null)/*56.93*/{_display_(Seq[Any](_display_(Seq[Any](/*56.95*/creditoPresupuestario/*56.116*/.expediente.nombre))))})),format.raw/*56.135*/("""</p>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-2">
			<label for="inputFechaStart" class="control-label">Fecha</label> 
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*62.49*/if(creditoPresupuestario.fecha != null)/*62.88*/{_display_(Seq[Any](_display_(Seq[Any](/*62.90*/(utils.DateUtils.formatDate(creditoPresupuestario.fecha))))))})),format.raw/*62.148*/("""</p>
		</div>
	</div>		
	<hr />	
		
	"""),_display_(Seq[Any](/*67.3*/views/*67.8*/.html.presupuesto.creditoPresupuestario.tabsCreditoPresupuestario(false,creditoPresupuestario))),format.raw/*67.102*/("""	
		
	<hr />
	
	<div class="panel panel-default">
	<div class="panel-heading"><b>Detalles</b></div>
	<div class="panel-body">
	
		<div class="row margin-bottom-25">
			<div class="col-sm-12">
				 
				<h4>Total: 	<b>"""),_display_(Seq[Any](/*78.21*/if(creditoPresupuestario.getTotal() != null)/*78.65*/{_display_(Seq[Any](_display_(Seq[Any](/*78.67*/utils/*78.72*/.NumberUtils.moneda(creditoPresupuestario.getTotal())))))}/*78.126*/else/*78.130*/{_display_(Seq[Any](format.raw/*78.131*/("""0,00""")))})),format.raw/*78.136*/("""</b></h4>
				<h4>Total Recursos: 	<b>"""),_display_(Seq[Any](/*79.30*/if(creditoPresupuestario.getTotalRecursos() != null)/*79.82*/{_display_(Seq[Any](_display_(Seq[Any](/*79.84*/utils/*79.89*/.NumberUtils.moneda(creditoPresupuestario.getTotalRecursos())))))}/*79.151*/else/*79.155*/{_display_(Seq[Any](format.raw/*79.156*/("""0,00""")))})),format.raw/*79.161*/("""</b></h4>
				
				<h4>Estado: 
					"""),_display_(Seq[Any](/*82.7*/if(creditoPresupuestario.estado != null)/*82.47*/{_display_(Seq[Any](format.raw/*82.48*/("""
						<b>"""),_display_(Seq[Any](/*83.11*/creditoPresupuestario/*83.32*/.estado)),format.raw/*83.39*/("""</b>
					""")))})),format.raw/*84.7*/(""" 
				</h4>
			</div>
		</div>

	</div>
	</div>
	"""),_display_(Seq[Any](/*91.3*/if(creditoPresupuestario.estado != "Completado" && Permiso.check("aprobarCredito"))/*91.86*/{_display_(Seq[Any](format.raw/*91.87*/("""
		<div class="row margin-bottom-25">
	 	<div class="col-sm-3">
	 		
			<a href=""""),_display_(Seq[Any](/*95.14*/controllers/*95.25*/.presupuesto.routes.CreditosPresupuestariosController.aprobar(creditoPresupuestario.id))),format.raw/*95.112*/("""" class="btn btn-default btn-disable-onclick">
				<i class="glyphicon glyphicon-arrow-right"></i> APROBAR
			</a>
			
		</div>
	 	</div>
 	""")))})),format.raw/*101.4*/("""

""")))})))}
    }
    
    def render(creditoPresupuestario:CreditoPresupuestario): play.api.templates.HtmlFormat.Appendable = apply(creditoPresupuestario)
    
    def f:((CreditoPresupuestario) => play.api.templates.HtmlFormat.Appendable) = (creditoPresupuestario) => apply(creditoPresupuestario)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:36 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/presupuesto/creditoPresupuestario/verCreditoPresupuestario.scala.html
                    HASH: 58f45f374a31d2c25d24b10844910be5e61cf940
                    MATRIX: 842->1|1039->47|1067->107|1104->110|1116->115|1183->174|1222->176|1503->422|1516->427|1563->452|1667->521|1709->554|1749->556|1804->575|1824->586|1905->645|2051->755|2071->766|2180->852|2295->936|2336->942|2381->978|2421->980|2475->998|2495->1009|2576->1068|2709->1170|2798->1223|2818->1234|2901->1295|3306->1664|3355->1704|3403->1706|3434->1727|3469->1735|3646->1876|3698->1919|3746->1921|3777->1942|3822->1960|4022->2124|4075->2168|4123->2170|4154->2191|4200->2210|4425->2399|4473->2438|4521->2440|4606->2498|4684->2541|4697->2546|4814->2640|5079->2869|5132->2913|5180->2915|5194->2920|5262->2974|5276->2978|5316->2979|5354->2984|5430->3024|5491->3076|5539->3078|5553->3083|5629->3145|5643->3149|5683->3150|5721->3155|5797->3196|5846->3236|5885->3237|5933->3249|5963->3270|5992->3277|6035->3289|6127->3346|6219->3429|6258->3430|6380->3516|6400->3527|6510->3614|6689->3761
                    LINES: 26->1|34->1|35->5|36->6|36->6|36->6|36->6|50->20|50->20|50->20|54->24|54->24|54->24|55->25|55->25|55->25|58->28|58->28|58->28|59->29|60->30|60->30|60->30|61->31|61->31|61->31|62->32|65->35|65->35|65->35|77->47|77->47|77->47|77->47|77->47|81->51|81->51|81->51|81->51|81->51|86->56|86->56|86->56|86->56|86->56|92->62|92->62|92->62|92->62|97->67|97->67|97->67|108->78|108->78|108->78|108->78|108->78|108->78|108->78|108->78|109->79|109->79|109->79|109->79|109->79|109->79|109->79|109->79|112->82|112->82|112->82|113->83|113->83|113->83|114->84|121->91|121->91|121->91|125->95|125->95|125->95|131->101
                    -- GENERATED --
                */
            