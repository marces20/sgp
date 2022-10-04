
package views.html.rendiciones

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
object mainRendiciones extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,Html,Html,play.api.templates.HtmlFormat.Appendable] {

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
					<li class="titulo">Pagos</li>
					"""),_display_(Seq[Any](/*10.7*/if(Componente.check("pagosRealizados"))/*10.46*/ {_display_(Seq[Any](format.raw/*10.48*/("""
						<li><a href=""""),_display_(Seq[Any](/*11.21*/controllers/*11.32*/.rendiciones.routes.RendicionesController.indexPagosRealizados())),format.raw/*11.96*/("""">Pagos Realizados</a></li>
					""")))})),format.raw/*12.7*/("""	
				</ul>
			</div>
		</div>
		<div class="col-sm-10">"""),_display_(Seq[Any](/*16.27*/content)),format.raw/*16.34*/("""</div>
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
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rendiciones/mainRendiciones.scala.html
                    HASH: 04b757dfdf9c63ea8d418663eebd7c7534fb839c
                    MATRIX: 806->1|977->57|1004->80|1040->82|1076->110|1114->111|1310->272|1358->311|1398->313|1455->334|1475->345|1561->409|1626->443|1719->500|1748->507
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|38->10|38->10|38->10|39->11|39->11|39->11|40->12|44->16|44->16
                    -- GENERATED --
                */
            