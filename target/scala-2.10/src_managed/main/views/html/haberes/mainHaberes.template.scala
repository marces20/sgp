
package views.html.haberes

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
object mainHaberes extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,Html,Html,play.api.templates.HtmlFormat.Appendable] {

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
					<li class="titulo">Liquidación</li>
						<li><a href=""""),_display_(Seq[Any](/*10.21*/controllers/*10.32*/.haberes.routes.LiquidacionMesesController.index())),format.raw/*10.82*/("""">Liquidaciones</a></li>
						<li><a href=""""),_display_(Seq[Any](/*11.21*/controllers/*11.32*/.haberes.routes.LiquidacionPuestosController.index())),format.raw/*11.84*/("""">Liquidaciones Puestos</a></li>
						<li><a href=""""),_display_(Seq[Any](/*12.21*/controllers/*12.32*/.haberes.routes.NovedadesController.index())),format.raw/*12.75*/("""?activo=activo">Novedades</a></li>
						<li><a href=""""),_display_(Seq[Any](/*13.21*/controllers/*13.32*/.haberes.routes.LiquidacionConceptosController.index())),format.raw/*13.86*/("""">Conceptos</a></li>
						<li><a href=""""),_display_(Seq[Any](/*14.21*/controllers/*14.32*/.haberes.routes.LiquidacionBaseCalculosController.index())),format.raw/*14.89*/("""">Base cálculo</a></li>
						<li><a href=""""),_display_(Seq[Any](/*15.21*/controllers/*15.32*/.haberes.routes.PuestosLaboralesController.index())),format.raw/*15.82*/("""">Puestos Laborales</a></li>
					
					<li class="titulo">Configuración</li>
						<li><a href=""""),_display_(Seq[Any](/*18.21*/controllers/*18.32*/.haberes.routes.EscalasLaboralesMontosController.index())),format.raw/*18.88*/("""">Montos Conceptos</a></li>
						<li><a href=""""),_display_(Seq[Any](/*19.21*/controllers/*19.32*/.haberes.routes.EscalasLaboralesController.index())),format.raw/*19.82*/("""">Escalas Laborales</a></li>
						<li><a href=""""),_display_(Seq[Any](/*20.21*/controllers/*20.32*/.haberes.routes.LiquidacionTiposController.index())),format.raw/*20.82*/("""">Tipos de liquidación</a></li>
						<li><a href=""""),_display_(Seq[Any](/*21.21*/controllers/*21.32*/.haberes.routes.LiquidacionConceptoTiposController.index())),format.raw/*21.90*/("""">Tipos concepto</a></li>
						<li><a href=""""),_display_(Seq[Any](/*22.21*/controllers/*22.32*/.haberes.routes.CategoriasLaboralesController.index())),format.raw/*22.85*/("""">Categorias laborales</a></li>
						<li><a href=""""),_display_(Seq[Any](/*23.21*/controllers/*23.32*/.haberes.routes.UnidadesLaboralesController.index())),format.raw/*23.83*/("""">Unidades laborales</a></li>
						<li><a href=""""),_display_(Seq[Any](/*24.21*/controllers/*24.32*/.haberes.routes.CargosLaboralesController.index())),format.raw/*24.81*/("""">Cargos laborales</a></li>
						<li><a href=""""),_display_(Seq[Any](/*25.21*/controllers/*25.32*/.haberes.routes.CentrosCostosController.index())),format.raw/*25.79*/("""">Centros Costos</a></li>
						<li><a href=""""),_display_(Seq[Any](/*26.21*/controllers/*26.32*/.haberes.routes.ConveniosBancosController.index())),format.raw/*26.81*/("""">Convenios Bancos</a></li>
						<li><a href=""""),_display_(Seq[Any](/*27.21*/controllers/*27.32*/.haberes.routes.LegajosController.index())),format.raw/*27.73*/("""">Legajos</a></li>
						<li><a href=""""),_display_(Seq[Any](/*28.21*/controllers/*28.32*/.haberes.routes.InstrumentosLegalesController.index())),format.raw/*28.85*/("""">Instrumentos Legales</a></li>
				</ul>
			</div>
		</div>
		<div class="col-sm-10">"""),_display_(Seq[Any](/*32.27*/content)),format.raw/*32.34*/("""</div>
	</div>
""")))})),format.raw/*34.2*/("""
"""))}
    }
    
    def render(title:String,scripts:Html,content:Html): play.api.templates.HtmlFormat.Appendable = apply(title,scripts)(content)
    
    def f:((String,Html) => (Html) => play.api.templates.HtmlFormat.Appendable) = (title,scripts) => (content) => apply(title,scripts)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/mainHaberes.scala.html
                    HASH: 8ea05fdf77fc68765817b804bec4056f467f3404
                    MATRIX: 798->1|969->57|996->80|1032->82|1068->110|1106->111|1323->292|1343->303|1415->353|1496->398|1516->409|1590->461|1679->514|1699->525|1764->568|1855->623|1875->634|1951->688|2028->729|2048->740|2127->797|2207->841|2227->852|2299->902|2433->1000|2453->1011|2531->1067|2615->1115|2635->1126|2707->1176|2792->1225|2812->1236|2884->1286|2972->1338|2992->1349|3072->1407|3154->1453|3174->1464|3249->1517|3337->1569|3357->1580|3430->1631|3516->1681|3536->1692|3607->1741|3691->1789|3711->1800|3780->1847|3862->1893|3882->1904|3953->1953|4037->2001|4057->2012|4120->2053|4195->2092|4215->2103|4290->2156|4413->2243|4442->2250|4489->2266
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|46->18|46->18|46->18|47->19|47->19|47->19|48->20|48->20|48->20|49->21|49->21|49->21|50->22|50->22|50->22|51->23|51->23|51->23|52->24|52->24|52->24|53->25|53->25|53->25|54->26|54->26|54->26|55->27|55->27|55->27|56->28|56->28|56->28|60->32|60->32|62->34
                    -- GENERATED --
                */
            