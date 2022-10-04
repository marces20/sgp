
package views.html

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
object index2 extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template6[Boolean,Integer,Integer,Integer,Boolean,List[com.avaje.ebean.SqlRow],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(usuariosActivos:Boolean,ca:Integer,cax:Integer,eSize:Integer,usuariosActivos2:Boolean,s:List[com.avaje.ebean.SqlRow]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.120*/("""
"""),format.raw/*5.70*/("""
"""),_display_(Seq[Any](/*6.2*/main("SGP - v1.0")/*6.20*/ {_display_(Seq[Any](format.raw/*6.22*/("""
 
 
 
 

 <div class="page-header">
 	 
	<div class="row">
		"""),_display_(Seq[Any](/*15.4*/if(usuariosActivos)/*15.23*/{_display_(Seq[Any](format.raw/*15.24*/("""	
		"""),_display_(Seq[Any](/*16.4*/if(ca > 0)/*16.14*/{_display_(Seq[Any](format.raw/*16.15*/("""
 		<div class="col-sm-4">
 			
			<div class="panel panel-default">
				<div class="panel-heading"><b>Estado Expedientes</b></div>
				<div class="panel-body" id="div-datos-puestos">
					<table class="table table-striped table-bordered">
						<tbody>
							 <tr align="center">
								<td width="250"><b>Expedientes con recepciones sin firma</b></td>
								<td width="50"><b>"""),_display_(Seq[Any](/*26.28*/ca)),format.raw/*26.30*/("""</b></td> 
								<td>
									 <span id="getExpedientesRecepcionSinFirma" class="glyphicon glyphicon-list-alt pointer" data-url=""""),_display_(Seq[Any](/*28.110*/controllers/*28.121*/.expediente.routes.ExpedientesController.getExpedientesRecepcionSinFirma())),format.raw/*28.195*/(""""></span>
								</td>
							</tr>
						</tbody>
					</table>
					<table class="table table-striped table-bordered">
						<tbody>
							 <tr align="center">
								<td  width="250"><b>Expedientes sin firma</b></td>
								<td width="50"><b>"""),_display_(Seq[Any](/*37.28*/cax)),format.raw/*37.31*/("""</b></td> 
								<td>
									 <span id="getExpedientesSinFirma" class="glyphicon glyphicon-list-alt pointer" 
									 data-url=""""),_display_(Seq[Any](/*40.22*/controllers/*40.33*/.expediente.routes.ExpedientesController.getExpedientesSinFirma())),format.raw/*40.98*/("""">
									 </span>
								</td>
							</tr>
						</tbody>
					</table>				
				</div>
			</div>	
		</div>
		""")))})),format.raw/*49.4*/("""
		""")))})),format.raw/*50.4*/("""
		 """),_display_(Seq[Any](/*51.5*/if(usuariosActivos2)/*51.25*/{_display_(Seq[Any](format.raw/*51.26*/("""	
		<div class="col-sm-4">
 			
			<div class="panel panel-default">
				<div class="panel-heading"><b>Estado Autorizado Pagos</b></div>
				<div class="panel-body" id="div-datos-puestos">
					<table class="table table-striped table-bordered">
						<tbody>
							 <tr align="center">
								<td width="250"><b>Diferencias Autorizados Pagados</b></td>
								<td width="50"><b>"""),_display_(Seq[Any](/*61.28*/eSize)),format.raw/*61.33*/("""</b></td> 
								<td>
									 <span id="getDiferenciaAutorizadoPagos" class="glyphicon glyphicon-list-alt pointer" 
									 data-url=""""),_display_(Seq[Any](/*64.22*/controllers/*64.33*/.dashboard.routes.ControlDeudaController.getAutorizadoDistintoDePagado())),format.raw/*64.105*/(""""></span>
								</td>
							</tr>
						</tbody>
					</table>			
				</div>
			</div>	
		</div>
		""")))})),format.raw/*72.4*/("""
		
		"""),_display_(Seq[Any](/*74.4*/if(s != null && s.size() > 0)/*74.33*/{_display_(Seq[Any](format.raw/*74.34*/("""	
			<div class="col-sm-4">
	 			
				<div class="panel panel-default">
					<div class="panel-heading"><b>Solicitudes Asignadas en Borrador</b></div>
					<div class="panel-body" id="div-datos-puestos">
						<table class="table table-striped table-bordered">
							<tbody>
								"""),_display_(Seq[Any](/*82.10*/for(sx <- s) yield /*82.22*/ {_display_(Seq[Any](format.raw/*82.24*/("""
								 <tr align="center">
									<td width="250"><b>"""),_display_(Seq[Any](/*84.30*/sx/*84.32*/.getString("nombre"))),format.raw/*84.52*/("""</b></td>
									<td width="50"><b>"""),_display_(Seq[Any](/*85.29*/sx/*85.31*/.getString("c"))),format.raw/*85.46*/("""</b></td> 
									 
								</tr>
								""")))})),format.raw/*88.10*/("""
							</tbody>
						</table>			
					</div>
				</div>	
			</div>
		""")))})),format.raw/*94.4*/("""
		
	</div>	
</div>
 
""")))})),format.raw/*99.2*/("""
 """))}
    }
    
    def render(usuariosActivos:Boolean,ca:Integer,cax:Integer,eSize:Integer,usuariosActivos2:Boolean,s:List[com.avaje.ebean.SqlRow]): play.api.templates.HtmlFormat.Appendable = apply(usuariosActivos,ca,cax,eSize,usuariosActivos2,s)
    
    def f:((Boolean,Integer,Integer,Integer,Boolean,List[com.avaje.ebean.SqlRow]) => play.api.templates.HtmlFormat.Appendable) = (usuariosActivos,ca,cax,eSize,usuariosActivos2,s) => apply(usuariosActivos,ca,cax,eSize,usuariosActivos2,s)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:28 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/index2.scala.html
                    HASH: 6a464adb31f6f489bcab8ad5a1d0cf7d63c8b787
                    MATRIX: 837->1|1095->176|1127->200|1202->119|1230->244|1266->246|1292->264|1331->266|1429->329|1457->348|1496->349|1536->354|1555->364|1594->365|2013->748|2037->750|2207->883|2228->894|2325->968|2611->1218|2636->1221|2807->1356|2827->1367|2914->1432|3060->1547|3095->1551|3135->1556|3164->1576|3203->1577|3621->1959|3648->1964|3825->2105|3845->2116|3940->2188|4074->2291|4116->2298|4154->2327|4193->2328|4514->2613|4542->2625|4582->2627|4677->2686|4688->2688|4730->2708|4804->2746|4815->2748|4852->2763|4929->2808|5032->2880|5086->2903
                    LINES: 26->1|33->5|33->5|34->1|35->5|36->6|36->6|36->6|45->15|45->15|45->15|46->16|46->16|46->16|56->26|56->26|58->28|58->28|58->28|67->37|67->37|70->40|70->40|70->40|79->49|80->50|81->51|81->51|81->51|91->61|91->61|94->64|94->64|94->64|102->72|104->74|104->74|104->74|112->82|112->82|112->82|114->84|114->84|114->84|115->85|115->85|115->85|118->88|124->94|129->99
                    -- GENERATED --
                */
            