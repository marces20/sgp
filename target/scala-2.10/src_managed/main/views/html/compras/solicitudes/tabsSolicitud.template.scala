
package views.html.compras.solicitudes

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
object tabsSolicitud extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Boolean,Form[Solicitud],Solicitud,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formularioCarga: Boolean, solicitudForm: Form[Solicitud] = null,solicitud:Solicitud = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._


Seq[Any](format.raw/*1.94*/("""
"""),format.raw/*5.1*/("""<ul id="solicitudTab" class="nav nav-tabs">
	<li class="active"><a class="tabProducto" href="#contenedorProductos" data-toggle="tab">Productos</a></li>
	<li><a class="tabLineAjustePreventivo" href="#contenedorLineasAjuste" data-toggle="tab">Ajustes preventivos</a></li>
	<li><a class="tabReferenciaCompras" href="#contenedorReferenciaCompras" data-toggle="tab">Referencia de compras</a></li>
	<li><a class="tabNotas" href="#contenedorNotas" data-toggle="tab">Notas</a></li>
</ul>

<div class="tab-content">

	<div class="tab-pane active" id="contenedorProductos">
		"""),_display_(Seq[Any](/*15.4*/views/*15.9*/.html.compras.solicitudes.contenidoTabProducto(formularioCarga,solicitudForm,solicitud))),format.raw/*15.96*/("""	
	</div>
	"""),_display_(Seq[Any](/*17.3*/if(!Permiso.check("noVerPrecios"))/*17.37*/ {_display_(Seq[Any](format.raw/*17.39*/("""
	<div class="tab-pane" id="contenedorLineasAjuste">
		"""),_display_(Seq[Any](/*19.4*/views/*19.9*/.html.compras.solicitudes.contenidoTabAjuste(formularioCarga, solicitudForm))),format.raw/*19.85*/("""	
	</div>
	
	<div class="tab-pane" id="contenedorReferenciaCompras">
		<h3>Referencia órdenes de compras</h3>
	</div>
	""")))})),format.raw/*25.3*/("""
	<div class="tab-pane" id="contenedorNotas">
		"""),_display_(Seq[Any](/*27.4*/if(formularioCarga)/*27.23*/{_display_(Seq[Any](format.raw/*27.24*/("""
			<textarea name="descripcion" class="form-control" rows="5">"""),_display_(Seq[Any](/*28.64*/solicitudForm/*28.77*/.field("descripcion").value)),format.raw/*28.104*/("""</textarea>
		""")))}/*29.5*/else/*29.10*/{_display_(Seq[Any](format.raw/*29.11*/("""
			<textarea name="descripcion" disabled="disabled" class="form-control" rows="5">"""),_display_(Seq[Any](/*30.84*/solicitudForm/*30.97*/.field("descripcion").value)),format.raw/*30.124*/("""</textarea>
		""")))})),format.raw/*31.4*/("""
	</div>
	
</div>"""))}
    }
    
    def render(formularioCarga:Boolean,solicitudForm:Form[Solicitud],solicitud:Solicitud): play.api.templates.HtmlFormat.Appendable = apply(formularioCarga,solicitudForm,solicitud)
    
    def f:((Boolean,Form[Solicitud],Solicitud) => play.api.templates.HtmlFormat.Appendable) = (formularioCarga,solicitudForm,solicitud) => apply(formularioCarga,solicitudForm,solicitud)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:45 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/solicitudes/tabsSolicitud.scala.html
                    HASH: 64a3e65ddf0629b9f293ab5920e9528fa9b81f98
                    MATRIX: 829->1|1072->93|1100->153|1712->730|1725->735|1834->822|1883->836|1926->870|1966->872|2059->930|2072->935|2170->1011|2327->1137|2413->1188|2441->1207|2480->1208|2581->1273|2603->1286|2653->1313|2687->1330|2700->1335|2739->1336|2860->1421|2882->1434|2932->1461|2979->1477
                    LINES: 26->1|34->1|35->5|45->15|45->15|45->15|47->17|47->17|47->17|49->19|49->19|49->19|55->25|57->27|57->27|57->27|58->28|58->28|58->28|59->29|59->29|59->29|60->30|60->30|60->30|61->31
                    -- GENERATED --
                */
            