
package views.html.compras.ordenes

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
object tabsOrden extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Boolean,Form[Orden],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formularioCarga: Boolean, ordenForm: Form[Orden] = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.59*/("""
<hr />
<ul id="ordenTab" class="nav nav-tabs">
	<li class="active"><a class="tabProducto" href="#contenedorProductos" data-toggle="tab">Productos</a></li>
	<li><a class="tabLineaAjuste" href="#contenedorLineasAjuste" data-toggle="tab">Ajustes</a></li>
	"""),_display_(Seq[Any](/*6.3*/if(ordenForm.field("tipo_orden").value != null && ordenForm.field("tipo_orden").value == "comun")/*6.100*/{_display_(Seq[Any](format.raw/*6.101*/("""
	<li><a class="tabProductosAnulados" href="#contenedorProductosAnulados" data-toggle="tab">Producto anulados</a></li>
	""")))})),format.raw/*8.3*/("""
	"""),_display_(Seq[Any](/*9.3*/if(ordenForm.field("tipo_orden").value != null && ordenForm.field("tipo_orden").value == "servicio")/*9.103*/{_display_(Seq[Any](format.raw/*9.104*/("""
	<li><a class="tabNoCertificados" href="#contenedorNoCertificados" data-toggle="tab">No Certificados</a></li>
	""")))})),format.raw/*11.3*/("""
	<li><a class="tabNotas" href="#contenedorNotas" data-toggle="tab">Notas</a></li>
	<li><a class="tabDispos" href="#contenedorDispos" data-toggle="tab">Disposiciones</a></li>
</ul>



<div class="tab-content">

	<div class="tab-pane active" id="contenedorProductos">
		"""),_display_(Seq[Any](/*21.4*/views/*21.9*/.html.compras.ordenes.contenidoTabProducto(formularioCarga, ordenForm))),format.raw/*21.79*/("""	
	</div>
	
	<div class="tab-pane" id="contenedorLineasAjuste">
		"""),_display_(Seq[Any](/*25.4*/views/*25.9*/.html.compras.ordenes.contenidoTabAjuste(true, ordenForm))),format.raw/*25.66*/("""	
	</div>
	"""),_display_(Seq[Any](/*27.3*/if(ordenForm.field("tipo_orden").value != null && ordenForm.field("tipo_orden").value == "comun")/*27.100*/{_display_(Seq[Any](format.raw/*27.101*/("""
	<div class="tab-pane" id="contenedorProductosAnulados">
		"""),_display_(Seq[Any](/*29.4*/views/*29.9*/.html.compras.ordenes.contenidoTabProductosAnulados(formularioCarga, ordenForm))),format.raw/*29.88*/("""
	</div>
	""")))})),format.raw/*31.3*/("""
	"""),_display_(Seq[Any](/*32.3*/if(ordenForm.field("tipo_orden").value != null && ordenForm.field("tipo_orden").value == "servicio")/*32.103*/{_display_(Seq[Any](format.raw/*32.104*/("""
	<div class="tab-pane" id="contenedorNoCertificados">
		"""),_display_(Seq[Any](/*34.4*/views/*34.9*/.html.compras.ordenes.contenidoTabNoCertificados(formularioCarga, ordenForm))),format.raw/*34.85*/("""
	</div>
	""")))})),format.raw/*36.3*/("""
	<div class="tab-pane" id="contenedorNotas">
		"""),_display_(Seq[Any](/*38.4*/if(formularioCarga)/*38.23*/{_display_(Seq[Any](format.raw/*38.24*/("""
			<textarea name="descripcion" class="form-control" rows="5">"""),_display_(Seq[Any](/*39.64*/ordenForm/*39.73*/.field("descripcion").value)),format.raw/*39.100*/("""</textarea>
		""")))}/*40.5*/else/*40.10*/{_display_(Seq[Any](format.raw/*40.11*/("""
			<textarea name="descripcion" disabled="disabled" class="form-control" rows="5">"""),_display_(Seq[Any](/*41.84*/ordenForm/*41.93*/.field("descripcion").value)),format.raw/*41.120*/("""</textarea>
		""")))})),format.raw/*42.4*/("""
	</div>
	"""),_display_(Seq[Any](/*44.3*/if(ordenForm.field("expediente_id").value != null)/*44.53*/{_display_(Seq[Any](format.raw/*44.54*/("""
	<div class="tab-pane" id="contenedorDispos">
		"""),_display_(Seq[Any](/*46.4*/views/*46.9*/.html.expediente.expediente.contenidoTabDispos(ordenForm.field("expediente_id").value.toLong))),format.raw/*46.102*/("""
	</div>
	""")))})),format.raw/*48.3*/("""
	
</div>
"""))}
    }
    
    def render(formularioCarga:Boolean,ordenForm:Form[Orden]): play.api.templates.HtmlFormat.Appendable = apply(formularioCarga,ordenForm)
    
    def f:((Boolean,Form[Orden]) => play.api.templates.HtmlFormat.Appendable) = (formularioCarga,ordenForm) => apply(formularioCarga,ordenForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:44 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/ordenes/tabsOrden.scala.html
                    HASH: 3c8ed2ad8de898e3518a6af93461f7209eff1635
                    MATRIX: 807->1|958->58|1252->318|1358->415|1397->416|1550->539|1588->543|1697->643|1736->644|1882->759|2197->1039|2210->1044|2302->1114|2408->1185|2421->1190|2500->1247|2549->1261|2656->1358|2696->1359|2794->1422|2807->1427|2908->1506|2952->1519|2991->1523|3101->1623|3141->1624|3236->1684|3249->1689|3347->1765|3391->1778|3477->1829|3505->1848|3544->1849|3645->1914|3663->1923|3713->1950|3747->1967|3760->1972|3799->1973|3920->2058|3938->2067|3988->2094|4035->2110|4083->2123|4142->2173|4181->2174|4268->2226|4281->2231|4397->2324|4441->2337
                    LINES: 26->1|29->1|34->6|34->6|34->6|36->8|37->9|37->9|37->9|39->11|49->21|49->21|49->21|53->25|53->25|53->25|55->27|55->27|55->27|57->29|57->29|57->29|59->31|60->32|60->32|60->32|62->34|62->34|62->34|64->36|66->38|66->38|66->38|67->39|67->39|67->39|68->40|68->40|68->40|69->41|69->41|69->41|70->42|72->44|72->44|72->44|74->46|74->46|74->46|76->48
                    -- GENERATED --
                */
            