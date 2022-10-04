
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
object indexNovedades extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

def /*4.2*/scripts/*4.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*4.13*/("""
	<script src=""""),_display_(Seq[Any](/*5.16*/routes/*5.22*/.Assets.at("plugins/fullcalendar-2.2.7/lib/moment.min.js"))),format.raw/*5.80*/("""" type="text/javascript"></script>
	<script src=""""),_display_(Seq[Any](/*6.16*/routes/*6.22*/.Assets.at("plugins/fullcalendar-2.2.7/fullcalendar.min.js"))),format.raw/*6.82*/("""" type="text/javascript"></script>
	<script src=""""),_display_(Seq[Any](/*7.16*/routes/*7.22*/.Assets.at("plugins/fullcalendar-2.2.7/lang/es.js"))),format.raw/*7.73*/("""" type="text/javascript"></script>
	<link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*8.47*/routes/*8.53*/.Assets.at("plugins/fullcalendar-2.2.7/fullcalendar.min.css"))),format.raw/*8.114*/("""">
	<script src=""""),_display_(Seq[Any](/*9.16*/routes/*9.22*/.Assets.at("javascripts/rrhh/novedades.js"))),format.raw/*9.65*/("""" type="text/javascript"></script>
""")))};
Seq[Any](format.raw/*3.1*/("""
"""),format.raw/*10.2*/("""



"""),_display_(Seq[Any](/*14.2*/views/*14.7*/.html.rrhh.mainRrhh("Lista Novedades", scripts)/*14.54*/ {_display_(Seq[Any](format.raw/*14.56*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Lista de Novedades</h1>
			</div>
			<div class="col-sm-5">
				<div class="pull-right btn-header">
					<a href="#" id="btnNuevo" class="form-control btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo</a>
				</div>
				
			</div>
		</div>
	</div>
	
"""),_display_(Seq[Any](/*30.2*/views/*30.7*/.html.tags.successError())),format.raw/*30.32*/("""	
	
	<div id="actions">
		 
			<form action=""""),_display_(Seq[Any](/*34.19*/controllers/*34.30*/.rrhh.routes.NovedadesController.lista())),format.raw/*34.70*/("""" id="formSearchNovedades" method="GET">
				
				<div class="row">	  
					<div class="col-sm-3">
						<label for="servicio" class="control-label">Servicio</label> 
						<div class="input-group">
							<input type="hidden" name="servicio_id" id="bservicio_id" />
							<input type="text" name="servicio" id="bservicio" class="form-control" autocomplete="off" />
							<span class="input-group-addon">
							<a href="#" class="searchModal"
										id="buscarServicio" 
										data-title="Selección de servicios" 
										data-url=""""),_display_(Seq[Any](/*46.22*/controllers/*46.33*/.administracion.routes.OrganigramasController.modalBuscarServicios())),format.raw/*46.101*/("""" 
										data-height="650" 
										data-width="700" 
										data-listen="modal.seleccion.servicio.simple" 
										data-label="#bservicio" 
										data-field="#bservicio_id">
								<i class="glyphicon glyphicon-search"></i>
							</a>
							</span>
						</div>
					</div>
					<div class="col-sm-3">
						<label class="control-label">Agente
							<div class="input-group">
								<input type="hidden" name="agente_id" id="bagente_id" />
								<input type="text" name="agente" id="bagente" class="form-control" autocomplete="off" />
								<span class="input-group-addon"><a href="#" id="buscarAgente" data-title="Selección de agente" data-url=""""),_display_(Seq[Any](/*62.115*/controllers/*62.126*/.rrhh.routes.AgentesController.modalBuscar())),format.raw/*62.170*/("""" data-height="650" data-width="700" data-listen="modal.seleccion.agente.simple" data-label="#bagente" data-field="#bagente_id"><i class="glyphicon glyphicon-search"></i></a></span>
							</div>
						</label>
					</div>
					
				<div class="col-sm-2">
					<div class="form-group">
					<label for="nombre" class="control-label">&nbsp;</label>
					<button  class="form-control btn btn-primary">Buscar</button>
					</div>
				</div>
					
					<div class="col-sm-2">
						<div class="form-group">
						<label for="nombre" class="control-label">&nbsp;</label>
						<a href=""""),_display_(Seq[Any](/*77.17*/controllers/*77.28*/.rrhh.routes.NovedadesController.index())),format.raw/*77.68*/(""""  class="form-control btn btn-default">Limpiar</a>
						</div>
					</div>
				</div>
			</form>
		 
	</div>

<hr />
	


<div id='calendar'></div>	
	
<script>

urlListaNovedades = '"""),_display_(Seq[Any](/*93.23*/controllers/*93.34*/.rrhh.routes.NovedadesController.lista())),format.raw/*93.74*/("""';
urlVerNovedad = '"""),_display_(Seq[Any](/*94.19*/controllers/*94.30*/.rrhh.routes.NovedadesController.ver())),format.raw/*94.68*/("""';
urlGetFeriados = '"""),_display_(Seq[Any](/*95.20*/controllers/*95.31*/.rrhh.routes.NovedadesController.getFeriados())),format.raw/*95.77*/("""';
urlCrearNovedad = '"""),_display_(Seq[Any](/*96.21*/controllers/*96.32*/.rrhh.routes.NovedadesController.crear())),format.raw/*96.72*/("""';

	
</script>	
	
	
<style>
.fc-day-grid-event """),format.raw/*103.20*/("""{"""),format.raw/*103.21*/("""cursor: pointer"""),format.raw/*103.36*/("""}"""),format.raw/*103.37*/("""
</style>	
	
""")))})),format.raw/*106.2*/("""
		
		
	
	"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:31 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/novedades/indexNovedades.scala.html
                    HASH: 2c861e3f380a89f840e20b1a8433540b9f18d752
                    MATRIX: 895->35|909->42|993->46|1044->62|1058->68|1137->126|1222->176|1236->182|1317->242|1402->292|1416->298|1488->349|1604->430|1618->436|1701->497|1754->515|1768->521|1832->564|1906->33|1934->600|1974->605|1987->610|2043->657|2083->659|2471->1012|2484->1017|2531->1042|2613->1088|2633->1099|2695->1139|3276->1684|3296->1695|3387->1763|4096->2435|4117->2446|4184->2490|4802->3072|4822->3083|4884->3123|5104->3307|5124->3318|5186->3358|5243->3379|5263->3390|5323->3428|5381->3450|5401->3461|5469->3507|5528->3530|5548->3541|5610->3581|5687->3629|5717->3630|5761->3645|5791->3646|5837->3660
                    LINES: 31->4|31->4|33->4|34->5|34->5|34->5|35->6|35->6|35->6|36->7|36->7|36->7|37->8|37->8|37->8|38->9|38->9|38->9|40->3|41->10|45->14|45->14|45->14|45->14|61->30|61->30|61->30|65->34|65->34|65->34|77->46|77->46|77->46|93->62|93->62|93->62|108->77|108->77|108->77|124->93|124->93|124->93|125->94|125->94|125->94|126->95|126->95|126->95|127->96|127->96|127->96|134->103|134->103|134->103|134->103|137->106
                    -- GENERATED --
                */
            