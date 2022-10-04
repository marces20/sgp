
package views.html.recupero.recuperoFactura

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
object tabsRecuperoFactura extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Boolean,Form[models.recupero.RecuperoFactura],models.recupero.RecuperoFactura,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formularioCarga: Boolean, recuperoFacturaForm: Form[models.recupero.RecuperoFactura] = null,factura:models.recupero.RecuperoFactura = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.142*/("""
<hr />
<div class="row">
	<ul id="recuperoFacturaTab" class="nav nav-tabs">
		<li class="active"><a class="tabProducto" href="#contenedorProductos" data-toggle="tab">Productos</a></li>
		<li><a class="tabNotas" href="#contenedorNotas" data-toggle="tab">Notas</a></li>
	</ul>
	
	<div class="tab-content">
	
		<div class="tab-pane active" id="contenedorProductos">
			"""),_display_(Seq[Any](/*12.5*/views/*12.10*/.html.recupero.recuperoFactura.contenidoTabProducto(formularioCarga, recuperoFacturaForm))),format.raw/*12.99*/("""	
		</div>
		<div class="tab-pane" id="contenedorNotas">
			"""),_display_(Seq[Any](/*15.5*/if(formularioCarga)/*15.24*/{_display_(Seq[Any](format.raw/*15.25*/("""
				<textarea name="nota" class="form-control" rows="5">"""),_display_(Seq[Any](/*16.58*/recuperoFacturaForm/*16.77*/.field("nota").value)),format.raw/*16.97*/("""</textarea>
			""")))}/*17.6*/else/*17.11*/{_display_(Seq[Any](format.raw/*17.12*/("""
				<textarea name="nota" disabled="disabled" class="form-control" rows="5">"""),_display_(Seq[Any](/*18.78*/recuperoFacturaForm/*18.97*/.field("nota").value)),format.raw/*18.117*/("""</textarea>
			""")))})),format.raw/*19.5*/("""
		</div>
	
	</div>
</div>

<hr />

<div class="row">
	<div class="col-sm-7">
		"""),_display_(Seq[Any](/*29.4*/views/*29.9*/.html.recupero.recuperoFactura.contenidoTabNotaCredito(formularioCarga,recuperoFacturaForm))),format.raw/*29.100*/("""
	</div>
	<div class="col-sm-5">
		"""),_display_(Seq[Any](/*32.4*/if(!formularioCarga)/*32.24*/{_display_(Seq[Any](format.raw/*32.25*/("""
			"""),_display_(Seq[Any](/*33.5*/views/*33.10*/.html.recupero.recuperoFactura.contenidoTabDetalle(formularioCarga,recuperoFacturaForm,factura))),format.raw/*33.105*/("""
		""")))})),format.raw/*34.4*/("""
		
	</div>
</div>
"""))}
    }
    
    def render(formularioCarga:Boolean,recuperoFacturaForm:Form[models.recupero.RecuperoFactura],factura:models.recupero.RecuperoFactura): play.api.templates.HtmlFormat.Appendable = apply(formularioCarga,recuperoFacturaForm,factura)
    
    def f:((Boolean,Form[models.recupero.RecuperoFactura],models.recupero.RecuperoFactura) => play.api.templates.HtmlFormat.Appendable) = (formularioCarga,recuperoFacturaForm,factura) => apply(formularioCarga,recuperoFacturaForm,factura)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:35 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/recupero/recuperoFactura/tabsRecuperoFactura.scala.html
                    HASH: cd6f5a4d19ba3a5bbb26d2607bdae536034276d1
                    MATRIX: 884->1|1119->141|1533->520|1547->525|1658->614|1757->678|1785->697|1824->698|1919->757|1947->776|1989->796|2024->814|2037->819|2076->820|2191->899|2219->918|2262->938|2310->955|2436->1046|2449->1051|2563->1142|2637->1181|2666->1201|2705->1202|2746->1208|2760->1213|2878->1308|2914->1313
                    LINES: 26->1|29->1|40->12|40->12|40->12|43->15|43->15|43->15|44->16|44->16|44->16|45->17|45->17|45->17|46->18|46->18|46->18|47->19|57->29|57->29|57->29|60->32|60->32|60->32|61->33|61->33|61->33|62->34
                    -- GENERATED --
                */
            