
package views.html.expediente.expediente

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
object tabsExpediente extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Boolean,Form[Expediente],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formularioCarga: Boolean, expedienteForm: Form[Expediente] = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.69*/("""

<ul id="certificacionTab" class="nav nav-tabs">
	<li class="active"><a class="tabExpedienteMovimiento" href="#contenedorExpedientesMovientos" data-toggle="tab">Movimientos</a></li>
	<li><a class="tabDispos" href="#contenedorDispos" data-toggle="tab">Disposiciones</a></li>
</ul>

<div class="tab-content">

	<div class="tab-pane active" id="contenedorExpedientesMovientos">
		"""),_display_(Seq[Any](/*11.4*/views/*11.9*/.html.expediente.expediente.contenidoTabExpedienteMovimiento(formularioCarga, expedienteForm))),format.raw/*11.102*/("""	
	</div>
	
	<div class="tab-pane" id="contenedorDispos">
		"""),_display_(Seq[Any](/*15.4*/views/*15.9*/.html.expediente.expediente.contenidoTabDispos(expedienteForm.field("id").value.toLong))),format.raw/*15.96*/("""	
	</div>
	

</div>
"""))}
    }
    
    def render(formularioCarga:Boolean,expedienteForm:Form[Expediente]): play.api.templates.HtmlFormat.Appendable = apply(formularioCarga,expedienteForm)
    
    def f:((Boolean,Form[Expediente]) => play.api.templates.HtmlFormat.Appendable) = (formularioCarga,expedienteForm) => apply(formularioCarga,expedienteForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:36 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/expediente/expediente/tabsExpediente.scala.html
                    HASH: d26e8a062f942b7c205e83b656d2028e0850914e
                    MATRIX: 823->1|984->68|1408->457|1421->462|1537->555|1637->620|1650->625|1759->712
                    LINES: 26->1|29->1|39->11|39->11|39->11|43->15|43->15|43->15
                    -- GENERATED --
                */
            