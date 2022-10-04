
package views.html.delegacion

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
object mainDelegaciones extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,Html,Html,play.api.templates.HtmlFormat.Appendable] {

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
				<li class="titulo">Configuración</li>
				"""),_display_(Seq[Any](/*11.6*/if(Componente.check("depositos"))/*11.39*/ {_display_(Seq[Any](format.raw/*11.41*/("""
					<li><a href=""""),_display_(Seq[Any](/*12.20*/controllers/*12.31*/.delegacion.routes.DepositosController.index())),format.raw/*12.77*/("""">Depósitos</a></li>
				""")))})),format.raw/*13.6*/("""
			</ul>
			</div>
		</div>
		<div class="col-sm-10">"""),_display_(Seq[Any](/*17.27*/content)),format.raw/*17.34*/("""</div>
	</div>
""")))})))}
    }
    
    def render(title:String,scripts:Html,content:Html): play.api.templates.HtmlFormat.Appendable = apply(title,scripts)(content)
    
    def f:((String,Html) => (Html) => play.api.templates.HtmlFormat.Appendable) = (title,scripts) => (content) => apply(title,scripts)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:29 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/delegacion/mainDelegaciones.scala.html
                    HASH: 7d30c5d933e6ad07a45e3ecbf49c2f0d6ce5d799
                    MATRIX: 806->1|977->57|1004->80|1040->82|1076->110|1114->111|1319->281|1361->314|1401->316|1457->336|1477->347|1545->393|1602->419|1693->474|1722->481
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|39->11|39->11|39->11|40->12|40->12|40->12|41->13|45->17|45->17
                    -- GENERATED --
                */
            