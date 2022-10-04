
package views.html.contabilidad.pagos

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
object tabsPago extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Boolean,Form[Pago],Pago,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formularioCarga: Boolean,pagoForm: Form[Pago], pago: Pago = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.68*/("""


	<ul id="pagoTab" class="nav nav-tabs">
		<li class="active"><a class="tabPago" href="#contenedorPagos" data-toggle="tab">Pagos</a></li>
		<li><a class="tabNotas" href="#contenedorNotas" data-toggle="tab">Notas</a></li>
	</ul>
	<div class="tab-content">
		<div class="tab-pane active" id="contenedorPagos">
			"""),_display_(Seq[Any](/*10.5*/views/*10.10*/.html.contabilidad.pagos.contenidoTabPago(formularioCarga, pago))),format.raw/*10.74*/("""	
		</div>
		<div class="tab-pane" id="contenedorNotas">
		"""),_display_(Seq[Any](/*13.4*/if(formularioCarga)/*13.23*/{_display_(Seq[Any](format.raw/*13.24*/("""
			<textarea name="nota" class="form-control" rows="5">"""),_display_(Seq[Any](/*14.57*/pagoForm/*14.65*/.field("nota").value)),format.raw/*14.85*/("""</textarea>
		""")))}/*15.5*/else/*15.10*/{_display_(Seq[Any](format.raw/*15.11*/("""
			<textarea name="nota" disabled="disabled" class="form-control" rows="5">"""),_display_(Seq[Any](/*16.77*/pagoForm/*16.85*/.field("nota").value)),format.raw/*16.105*/("""</textarea>
		""")))})),format.raw/*17.4*/("""
		</div>
	</div>
"""))}
    }
    
    def render(formularioCarga:Boolean,pagoForm:Form[Pago],pago:Pago): play.api.templates.HtmlFormat.Appendable = apply(formularioCarga,pagoForm,pago)
    
    def f:((Boolean,Form[Pago],Pago) => play.api.templates.HtmlFormat.Appendable) = (formularioCarga,pagoForm,pago) => apply(formularioCarga,pagoForm,pago)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:38 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/pagos/tabsPago.scala.html
                    HASH: 489f22c7aed26ff089ae737943d631b36fdcb40e
                    MATRIX: 813->1|973->67|1331->390|1345->395|1431->459|1529->522|1557->541|1596->542|1690->600|1707->608|1749->628|1783->645|1796->650|1835->651|1949->729|1966->737|2009->757|2056->773
                    LINES: 26->1|29->1|38->10|38->10|38->10|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|44->16|44->16|44->16|45->17
                    -- GENERATED --
                */
            