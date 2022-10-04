
package views.html.haberes.liquidacionPuestos

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
object tabsLiquidacionPuesto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Boolean,Form[models.haberes.LiquidacionPuesto],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formularioCarga: Boolean, lpForm: Form[models.haberes.LiquidacionPuesto] = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.83*/("""

	<hr />

	<ul id="facturaTab" class="nav nav-tabs">
		<li class="active"><a class="tabDetalle" href="#contenedorDetalles" data-toggle="tab">Detalles</a></li>
		 
	</ul>
	<div class="tab-content margin-bottom-25">
		<div class="tab-pane active" id="contenedorDetalles">
			"""),_display_(Seq[Any](/*11.5*/views/*11.10*/.html.haberes.liquidacionPuestos.contenidoTabDetalle(formularioCarga, lpForm))),format.raw/*11.87*/("""	
		</div>
		
	</div>
	
	<hr />

	 

	 
"""))}
    }
    
    def render(formularioCarga:Boolean,lpForm:Form[models.haberes.LiquidacionPuesto]): play.api.templates.HtmlFormat.Appendable = apply(formularioCarga,lpForm)
    
    def f:((Boolean,Form[models.haberes.LiquidacionPuesto]) => play.api.templates.HtmlFormat.Appendable) = (formularioCarga,lpForm) => apply(formularioCarga,lpForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/liquidacionPuestos/tabsLiquidacionPuesto.scala.html
                    HASH: 153d8abca24de97fed0a9556426e8aec58e4b6e5
                    MATRIX: 857->1|1032->82|1352->367|1366->372|1465->449
                    LINES: 26->1|29->1|39->11|39->11|39->11
                    -- GENERATED --
                */
            