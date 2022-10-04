
package views.html.expediente

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
object mainExpediente extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,Html,Html,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(title: String, scripts: Html = Html(""))(content: Html):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import models.auth._


Seq[Any](format.raw/*1.58*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/main(title: String, scripts)/*4.30*/{_display_(Seq[Any](format.raw/*4.31*/("""
	<div class="row">
		<div class="col-sm-2">
			<div class="menu-contenido">
			
			<ul class="nav nav-pills nav-stacked">
				<li class="titulo">Expedientes</li>
				"""),_display_(Seq[Any](/*11.6*/if(Componente.check("expedientes"))/*11.41*/ {_display_(Seq[Any](format.raw/*11.43*/("""
					<li><a href=""""),_display_(Seq[Any](/*12.20*/controllers/*12.31*/.expediente.routes.ExpedientesController.indexExpediente())),format.raw/*12.89*/("""">Expedientes</a></li>
				""")))})),format.raw/*13.6*/("""
				"""),_display_(Seq[Any](/*14.6*/if(Componente.check("expedientes"))/*14.41*/ {_display_(Seq[Any](format.raw/*14.43*/("""
					<li><a href=""""),_display_(Seq[Any](/*15.20*/controllers/*15.31*/.expediente.routes.ExpedientesMisPasesController.index())),format.raw/*15.87*/("""">Mis Pases</a></li>
				""")))})),format.raw/*16.6*/("""
				"""),_display_(Seq[Any](/*17.6*/if(Componente.check("expedientes"))/*17.41*/ {_display_(Seq[Any](format.raw/*17.43*/("""
					"""),_display_(Seq[Any](/*18.7*/if(Permiso.check("reporteMovimientos"))/*18.46*/ {_display_(Seq[Any](format.raw/*18.48*/("""  	
					<li><a href=""""),_display_(Seq[Any](/*19.20*/controllers/*19.31*/.expediente.routes.ExpedientesReportesController.reporteMovimiento())),format.raw/*19.99*/("""">Reporte de movimientos</a></li>
					""")))})),format.raw/*20.7*/("""
				""")))})),format.raw/*21.6*/("""  
				"""),_display_(Seq[Any](/*22.6*/if(Componente.check("expedientes"))/*22.41*/ {_display_(Seq[Any](format.raw/*22.43*/("""
					"""),_display_(Seq[Any](/*23.7*/if(Permiso.check("dispoVer"))/*23.36*/ {_display_(Seq[Any](format.raw/*23.38*/("""  	
					<li><a href=""""),_display_(Seq[Any](/*24.20*/controllers/*24.31*/.expediente.routes.DisposController.index())),format.raw/*24.74*/("""">Disposiciones</a></li>
					""")))})),format.raw/*25.7*/("""
				""")))})),format.raw/*26.6*/("""
				
				<li class="titulo">Configuración</li>
				"""),_display_(Seq[Any](/*29.6*/if(Componente.check("iniciador"))/*29.39*/ {_display_(Seq[Any](format.raw/*29.41*/("""
					<li><a href=""""),_display_(Seq[Any](/*30.20*/controllers/*30.31*/.expediente.routes.IniciadorExpedientesController.indexIniciadorExpediente())),format.raw/*30.107*/("""">Iniciador</a></li>
				""")))})),format.raw/*31.6*/("""
			</ul>
			</div>
		</div>
		<div class="col-sm-10">"""),_display_(Seq[Any](/*35.27*/content)),format.raw/*35.34*/("""</div>
	</div>
""")))})))}
    }
    
    def render(title:String,scripts:Html,content:Html): play.api.templates.HtmlFormat.Appendable = apply(title,scripts)(content)
    
    def f:((String,Html) => (Html) => play.api.templates.HtmlFormat.Appendable) = (title,scripts) => (content) => apply(title,scripts)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:36 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/expediente/mainExpediente.scala.html
                    HASH: 0f5dcd29f1f2e8fbf692c2aedb9ad1152ebb56da
                    MATRIX: 804->1|975->57|1002->80|1038->82|1074->110|1112->111|1315->279|1359->314|1399->316|1455->336|1475->347|1555->405|1614->433|1655->439|1699->474|1739->476|1795->496|1815->507|1893->563|1950->589|1991->595|2035->630|2075->632|2117->639|2165->678|2205->680|2264->703|2284->714|2374->782|2445->822|2482->828|2525->836|2569->871|2609->873|2651->880|2689->909|2729->911|2788->934|2808->945|2873->988|2935->1019|2972->1025|3060->1078|3102->1111|3142->1113|3198->1133|3218->1144|3317->1220|3374->1246|3465->1301|3494->1308
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|39->11|39->11|39->11|40->12|40->12|40->12|41->13|42->14|42->14|42->14|43->15|43->15|43->15|44->16|45->17|45->17|45->17|46->18|46->18|46->18|47->19|47->19|47->19|48->20|49->21|50->22|50->22|50->22|51->23|51->23|51->23|52->24|52->24|52->24|53->25|54->26|57->29|57->29|57->29|58->30|58->30|58->30|59->31|63->35|63->35
                    -- GENERATED --
                */
            