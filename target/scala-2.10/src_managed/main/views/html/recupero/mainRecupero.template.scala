
package views.html.recupero

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
object mainRecupero extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,Html,Html,play.api.templates.HtmlFormat.Appendable] {

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
				<li class="titulo">Recupero</li>
				"""),_display_(Seq[Any](/*11.6*/if(Componente.check("recuperoPlanilla"))/*11.46*/ {_display_(Seq[Any](format.raw/*11.48*/("""
					<li><a href=""""),_display_(Seq[Any](/*12.20*/controllers/*12.31*/.recupero.routes.RecuperoPlanillasController.index())),format.raw/*12.83*/("""">Planilla</a></li>
				""")))})),format.raw/*13.6*/("""
				"""),_display_(Seq[Any](/*14.6*/if(Componente.check("presupuesto"))/*14.41*/ {_display_(Seq[Any](format.raw/*14.43*/("""
					<li><a href=""""),_display_(Seq[Any](/*15.20*/controllers/*15.31*/.recupero.routes.PresupuestosController.index())),format.raw/*15.78*/("""">Presupuesto</a></li>
				""")))})),format.raw/*16.6*/("""
				"""),_display_(Seq[Any](/*17.6*/if(Componente.check("recuperoFactura"))/*17.45*/ {_display_(Seq[Any](format.raw/*17.47*/("""
					<li><a href=""""),_display_(Seq[Any](/*18.20*/controllers/*18.31*/.recupero.routes.RecuperoFacturasController.index())),format.raw/*18.82*/("""">Facturas</a></li>
				""")))})),format.raw/*19.6*/("""
				"""),_display_(Seq[Any](/*20.6*/if(Componente.check("recuperoPago"))/*20.42*/ {_display_(Seq[Any](format.raw/*20.44*/("""
					<li><a href=""""),_display_(Seq[Any](/*21.20*/controllers/*21.31*/.recupero.routes.RecuperoPagosController.index())),format.raw/*21.79*/("""">Pago</a></li>
				""")))})),format.raw/*22.6*/("""
				<li class="titulo">Informes</li>
				<li><a href=""""),_display_(Seq[Any](/*24.19*/controllers/*24.30*/.recupero.routes.RecuperoReportesController.informeGeneral())),format.raw/*24.90*/("""">Informe General</a></li>
				
				
			</ul>
			</div>
		</div>
		<div class="col-sm-10">"""),_display_(Seq[Any](/*30.27*/content)),format.raw/*30.34*/("""</div>
	</div>

""")))})))}
    }
    
    def render(title:String,scripts:Html,content:Html): play.api.templates.HtmlFormat.Appendable = apply(title,scripts)(content)
    
    def f:((String,Html) => (Html) => play.api.templates.HtmlFormat.Appendable) = (title,scripts) => (content) => apply(title,scripts)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:35 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/recupero/mainRecupero.scala.html
                    HASH: 78ffbc7fb17e72eaeb3e21f87038a6fbe8bd0cfd
                    MATRIX: 800->1|971->57|998->80|1034->82|1070->110|1108->111|1308->276|1357->316|1397->318|1453->338|1473->349|1547->401|1603->426|1644->432|1688->467|1728->469|1784->489|1804->500|1873->547|1932->575|1973->581|2021->620|2061->622|2117->642|2137->653|2210->704|2266->729|2307->735|2352->771|2392->773|2448->793|2468->804|2538->852|2590->873|2682->929|2702->940|2784->1000|2911->1091|2940->1098
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|39->11|39->11|39->11|40->12|40->12|40->12|41->13|42->14|42->14|42->14|43->15|43->15|43->15|44->16|45->17|45->17|45->17|46->18|46->18|46->18|47->19|48->20|48->20|48->20|49->21|49->21|49->21|50->22|52->24|52->24|52->24|58->30|58->30
                    -- GENERATED --
                */
            