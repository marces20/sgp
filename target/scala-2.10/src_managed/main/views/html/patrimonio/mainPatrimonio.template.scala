
package views.html.patrimonio

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
object mainPatrimonio extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,Html,Html,play.api.templates.HtmlFormat.Appendable] {

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
					<li class="titulo">Gestión</li>
					"""),_display_(Seq[Any](/*10.7*/if(Componente.check("ordenesProvision"))/*10.47*/ {_display_(Seq[Any](format.raw/*10.49*/("""
						<li><a href=""""),_display_(Seq[Any](/*11.21*/controllers/*11.32*/.patrimonio.routes.OrdenesProvisionController.index())),format.raw/*11.85*/("""">Ordenes de provisión</a></li>
					""")))})),format.raw/*12.7*/("""
					"""),_display_(Seq[Any](/*13.7*/if(Componente.check("recepciones"))/*13.42*/ {_display_(Seq[Any](format.raw/*13.44*/("""
						<li><a href=""""),_display_(Seq[Any](/*14.21*/controllers/*14.32*/.patrimonio.routes.RecepcionesController.index())),format.raw/*14.80*/("""">Recepciones</a></li>
					""")))})),format.raw/*15.7*/("""
					"""),_display_(Seq[Any](/*16.7*/if(Componente.check("remitos"))/*16.38*/ {_display_(Seq[Any](format.raw/*16.40*/("""
						<li><a href=""""),_display_(Seq[Any](/*17.21*/controllers/*17.32*/.patrimonio.routes.RemitosController.index())),format.raw/*17.76*/("""">Remitos</a></li>
					""")))})),format.raw/*18.7*/("""
					"""),_display_(Seq[Any](/*19.7*/if(Componente.check("actasRecepcion"))/*19.45*/ {_display_(Seq[Any](format.raw/*19.47*/("""
						<li><a href=""""),_display_(Seq[Any](/*20.21*/controllers/*20.32*/.patrimonio.routes.ActasRecepcionController.index())),format.raw/*20.83*/("""">Actas</a></li>
						<li><a href=""""),_display_(Seq[Any](/*21.21*/controllers/*21.32*/.patrimonio.routes.ActasMovimientosController.indexGeneral())),format.raw/*21.92*/("""">Actas Recepcion Pases</a></li>
						<li><a href=""""),_display_(Seq[Any](/*22.21*/controllers/*22.32*/.patrimonio.routes.ActasMovimientosController.indexPasesPorUsuario())),format.raw/*22.100*/("""">Actas Pases por Usuario</a></li>
					""")))})),format.raw/*23.7*/("""

					"""),_display_(Seq[Any](/*25.7*/if(Componente.check("certificacionesServicios"))/*25.55*/ {_display_(Seq[Any](format.raw/*25.57*/("""
						<li><a href=""""),_display_(Seq[Any](/*26.21*/controllers/*26.32*/.patrimonio.routes.CertificacionesServiciosController.index())),format.raw/*26.93*/("""">Certificaciones</a></li>
					""")))})),format.raw/*27.7*/("""
					
					"""),_display_(Seq[Any](/*29.7*/if(Componente.check("inventario"))/*29.41*/ {_display_(Seq[Any](format.raw/*29.43*/("""
					<li><a href=""""),_display_(Seq[Any](/*30.20*/controllers/*30.31*/.patrimonio.routes.InventarioController.index())),format.raw/*30.78*/("""">Inventario</a></li>
					""")))})),format.raw/*31.7*/("""
					"""),_display_(Seq[Any](/*32.7*/if(Componente.check("infoPaciente"))/*32.43*/ {_display_(Seq[Any](format.raw/*32.45*/("""
					<li><a href=""""),_display_(Seq[Any](/*33.20*/controllers/*33.31*/.patrimonio.routes.OrdenesProvisionController.informacionPorPacientes())),format.raw/*33.102*/("""">Info por Paciente</a></li>
					""")))})),format.raw/*34.7*/("""
				</ul>
				
				<ul class="nav nav-pills nav-stacked">
					<li class="titulo">Baúl</li>
					"""),_display_(Seq[Any](/*39.7*/if(Componente.check("remitos"))/*39.38*/ {_display_(Seq[Any](format.raw/*39.40*/("""
						<li><a href=""""),_display_(Seq[Any](/*40.21*/controllers/*40.32*/.patrimonio.routes.RemitosBaulController.index())),format.raw/*40.80*/("""">Remitos</a></li>
					""")))})),format.raw/*41.7*/("""
				</ul>
				
			</div>
		</div>
		<div class="col-sm-10">"""),_display_(Seq[Any](/*46.27*/content)),format.raw/*46.34*/("""</div>
	</div>
""")))})))}
    }
    
    def render(title:String,scripts:Html,content:Html): play.api.templates.HtmlFormat.Appendable = apply(title,scripts)(content)
    
    def f:((String,Html) => (Html) => play.api.templates.HtmlFormat.Appendable) = (title,scripts) => (content) => apply(title,scripts)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:31 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/mainPatrimonio.scala.html
                    HASH: 886bad5069d70fdc95e07e8b44dec775132bacc1
                    MATRIX: 804->1|975->57|1002->80|1038->82|1074->110|1112->111|1310->274|1359->314|1399->316|1456->337|1476->348|1551->401|1620->439|1662->446|1706->481|1746->483|1803->504|1823->515|1893->563|1953->592|1995->599|2035->630|2075->632|2132->653|2152->664|2218->708|2274->733|2316->740|2363->778|2403->780|2460->801|2480->812|2553->863|2626->900|2646->911|2728->971|2817->1024|2837->1035|2928->1103|3000->1144|3043->1152|3100->1200|3140->1202|3197->1223|3217->1234|3300->1295|3364->1328|3412->1341|3455->1375|3495->1377|3551->1397|3571->1408|3640->1455|3699->1483|3741->1490|3786->1526|3826->1528|3882->1548|3902->1559|3996->1630|4062->1665|4196->1764|4236->1795|4276->1797|4333->1818|4353->1829|4423->1877|4479->1902|4576->1963|4605->1970
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|38->10|38->10|38->10|39->11|39->11|39->11|40->12|41->13|41->13|41->13|42->14|42->14|42->14|43->15|44->16|44->16|44->16|45->17|45->17|45->17|46->18|47->19|47->19|47->19|48->20|48->20|48->20|49->21|49->21|49->21|50->22|50->22|50->22|51->23|53->25|53->25|53->25|54->26|54->26|54->26|55->27|57->29|57->29|57->29|58->30|58->30|58->30|59->31|60->32|60->32|60->32|61->33|61->33|61->33|62->34|67->39|67->39|67->39|68->40|68->40|68->40|69->41|74->46|74->46
                    -- GENERATED --
                */
            