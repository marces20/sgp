
package views.html.compras.solicitudes

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
object crearSolicitud extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[Solicitud],String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(solicitudForm: Form[Solicitud],searchIndex:String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

def /*3.2*/scripts/*3.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*3.13*/("""
	<script src=""""),_display_(Seq[Any](/*4.16*/routes/*4.22*/.Assets.at("javascripts/compras/solicitudes.js"))),format.raw/*4.70*/("""" type="text/javascript"></script>
""")))};
Seq[Any](format.raw/*1.53*/("""
"""),format.raw/*5.2*/("""

"""),_display_(Seq[Any](/*7.2*/views/*7.7*/.html.compras.mainCompras("Crear Solicitud", scripts)/*7.60*/ {_display_(Seq[Any](format.raw/*7.62*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Crear nueva Solicitud</h1>
			</div>
		</div>
	</div>
"""),_display_(Seq[Any](/*16.2*/views/*16.7*/.html.tags.successError())),format.raw/*16.32*/("""
    
    """),_display_(Seq[Any](/*18.6*/helper/*18.12*/.form(action = controllers.compras.routes.SolicitudesController.guardarSolicitud(searchIndex))/*18.106*/ {_display_(Seq[Any](format.raw/*18.108*/("""
    	<div class="row menu-acciones">
			<div class="col-sm-4">
				 <button type="submit" class="btn btn-default" title="Guardar solicitud"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>	
		      	 <a href=""""),_display_(Seq[Any](/*22.21*/controllers/*22.32*/.compras.routes.SolicitudesController.index())),format.raw/*22.77*/("""" title="Cancelar editar" class="btn btn-default">
		      	 <i class="glyphicon glyphicon-floppy-remove"></i> Cancelar
		      	 </a>	
			</div>
			<div class="col-sm-4">
				"""),_display_(Seq[Any](/*27.6*/if(solicitudForm("asignacion_usuario_id").value != null)/*27.62*/{_display_(Seq[Any](format.raw/*27.63*/("""
					<span style="color:red;font-size: 15px;font-weight: bold;">"""),_display_(Seq[Any](/*28.66*/solicitudForm("asignacion_usuario.nombre")/*28.108*/.value)),format.raw/*28.114*/("""</span>
				""")))})),format.raw/*29.6*/("""
			</div>
			<div class="col-sm-2">
				<a href=""""),_display_(Seq[Any](/*32.15*/controllers/*32.26*/.compras.routes.SolicitudesController.redirectSearchIndex(searchIndex))),format.raw/*32.96*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a>
			</div>
		</div>
		"""),_display_(Seq[Any](/*35.4*/views/*35.9*/.html.compras.solicitudes.formSolicitud(solicitudForm))),format.raw/*35.63*/(""" 
		
		"""),_display_(Seq[Any](/*37.4*/views/*37.9*/.html.compras.solicitudes.tabsSolicitud(true, solicitudForm,null))),format.raw/*37.74*/("""
		
			
		 
	""")))})),format.raw/*41.3*/("""
""")))})))}
    }
    
    def render(solicitudForm:Form[Solicitud],searchIndex:String): play.api.templates.HtmlFormat.Appendable = apply(solicitudForm,searchIndex)
    
    def f:((Form[Solicitud],String) => play.api.templates.HtmlFormat.Appendable) = (solicitudForm,searchIndex) => apply(solicitudForm,searchIndex)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:45 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/solicitudes/crearSolicitud.scala.html
                    HASH: 4348fc1bdc93dadb2e25a14a890a6228452c211b
                    MATRIX: 819->1|963->71|977->78|1061->82|1112->98|1126->104|1195->152|1270->52|1297->188|1334->191|1346->196|1407->249|1446->251|1619->389|1632->394|1679->419|1725->430|1740->436|1844->530|1885->532|2148->759|2168->770|2235->815|2447->992|2512->1048|2551->1049|2653->1115|2705->1157|2734->1163|2778->1176|2865->1227|2885->1238|2977->1308|3105->1401|3118->1406|3194->1460|3237->1468|3250->1473|3337->1538|3382->1552
                    LINES: 26->1|29->3|29->3|31->3|32->4|32->4|32->4|34->1|35->5|37->7|37->7|37->7|37->7|46->16|46->16|46->16|48->18|48->18|48->18|48->18|52->22|52->22|52->22|57->27|57->27|57->27|58->28|58->28|58->28|59->29|62->32|62->32|62->32|65->35|65->35|65->35|67->37|67->37|67->37|71->41
                    -- GENERATED --
                */
            