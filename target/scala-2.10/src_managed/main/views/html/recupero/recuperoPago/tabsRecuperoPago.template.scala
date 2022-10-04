
package views.html.recupero.recuperoPago

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
object tabsRecuperoPago extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Boolean,Form[models.recupero.RecuperoPago],models.recupero.RecuperoPago,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formularioCarga: Boolean, recuperoPagoForm: Form[models.recupero.RecuperoPago] = null,pago:models.recupero.RecuperoPago = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.130*/("""
<hr />
<div class="row">
	<ul id="recuperoChequeTab" class="nav nav-tabs">
		<li class="active"><a class="tabCheque" href="#contenedorCheques" data-toggle="tab">Cheques</a></li>
		<li><a class="tabNotas" href="#contenedorNotas" data-toggle="tab">Notas</a></li>
	</ul>
	
	<div class="tab-content">
	
		<div class="tab-pane active" id="contenedorCheques">
			"""),_display_(Seq[Any](/*12.5*/views/*12.10*/.html.recupero.recuperoPago.contenidoTabCheque(formularioCarga,recuperoPagoForm))),format.raw/*12.90*/("""	
		</div>
		<div class="tab-pane" id="contenedorNotas">
			"""),_display_(Seq[Any](/*15.5*/if(formularioCarga)/*15.24*/{_display_(Seq[Any](format.raw/*15.25*/("""
				<textarea name="nota" class="form-control" rows="5">"""),_display_(Seq[Any](/*16.58*/recuperoPagoForm/*16.74*/.field("nota").value)),format.raw/*16.94*/("""</textarea>
			""")))}/*17.6*/else/*17.11*/{_display_(Seq[Any](format.raw/*17.12*/("""
				<textarea name="nota" disabled="disabled" class="form-control" rows="5">"""),_display_(Seq[Any](/*18.78*/recuperoPagoForm/*18.94*/.field("nota").value)),format.raw/*18.114*/("""</textarea>
			""")))})),format.raw/*19.5*/("""
		</div>
	
	</div>
</div>

"""))}
    }
    
    def render(formularioCarga:Boolean,recuperoPagoForm:Form[models.recupero.RecuperoPago],pago:models.recupero.RecuperoPago): play.api.templates.HtmlFormat.Appendable = apply(formularioCarga,recuperoPagoForm,pago)
    
    def f:((Boolean,Form[models.recupero.RecuperoPago],models.recupero.RecuperoPago) => play.api.templates.HtmlFormat.Appendable) = (formularioCarga,recuperoPagoForm,pago) => apply(formularioCarga,recuperoPagoForm,pago)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:35 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/recupero/recuperoPago/tabsRecuperoPago.scala.html
                    HASH: 154a042d72853510c336266b81bbc20f3a281c73
                    MATRIX: 872->1|1095->129|1500->499|1514->504|1616->584|1715->648|1743->667|1782->668|1877->727|1902->743|1944->763|1979->781|1992->786|2031->787|2146->866|2171->882|2214->902|2262->919
                    LINES: 26->1|29->1|40->12|40->12|40->12|43->15|43->15|43->15|44->16|44->16|44->16|45->17|45->17|45->17|46->18|46->18|46->18|47->19
                    -- GENERATED --
                */
            