
package views.html.haberes.liquidacionConceptos

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
object verLiquidacionConcepto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[models.haberes.LiquidacionConcepto],models.haberes.LiquidacionConcepto,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lcForm:Form[models.haberes.LiquidacionConcepto],lc:models.haberes.LiquidacionConcepto):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._ 

import utils._ 

def /*4.2*/scripts/*4.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*4.13*/("""
<script src=""""),_display_(Seq[Any](/*5.15*/routes/*5.21*/.Assets.at("javascripts/haberes/liquidacionConcepto.js"))),format.raw/*5.77*/("""" type="text/javascript"></script>
""")))};implicit def /*7.2*/implicitFieldConstructor/*7.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.89*/("""
"""),format.raw/*6.2*/(""" 
"""),format.raw/*7.70*/("""

"""),_display_(Seq[Any](/*9.2*/views/*9.7*/.html.haberes.mainHaberes("Vista Concepto",scripts)/*9.58*/ {_display_(Seq[Any](format.raw/*9.60*/("""
<div class="page-header">
	<div class="row">
		<div class="col-sm-7">
			<h1>Vista de Concepto</h1>
		</div>
		<div class="col-sm-5"></div>
	</div>
</div>
<div class="row menu-acciones">
	<div class="col-sm-10">
		<a href=""""),_display_(Seq[Any](/*20.13*/controllers/*20.24*/.haberes.routes.LiquidacionConceptosController.crear())),format.raw/*20.78*/("""" class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i>
			Nuevo Concepto</a> 
			<a href=""""),_display_(Seq[Any](/*22.14*/controllers/*22.25*/.haberes.routes.LiquidacionConceptosController.editar(lc.id))),_display_(Seq[Any](/*22.86*/UriTrack/*22.94*/.get("&"))),format.raw/*22.103*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-edit"></i>
			Editar</a> 
			<a href=""""),_display_(Seq[Any](/*24.14*/controllers/*24.25*/.haberes.routes.LiquidacionConceptosController.eliminar(lc.id))),_display_(Seq[Any](/*24.88*/UriTrack/*24.96*/.get("&"))),format.raw/*24.105*/(""""  class="btn btn-default delete-confirm-link"><i
			class="glyphicon glyphicon-trash icono-eliminar"></i> Eliminar</a>
	</div>
	<div class="col-sm-2">
		<a
			href=""""),_display_(Seq[Any](/*29.11*/UriTrack/*29.19*/.getOnNull(controllers.haberes.routes.LiquidacionConceptosController.index().absoluteURL()))),format.raw/*29.110*/(""""
			class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a>
	</div>
</div>

<input type="hidden" id="conceptoId" name="agenteId" value=""""),_display_(Seq[Any](/*34.62*/lc/*34.64*/.id)),format.raw/*34.67*/("""" />
<div class="row">
	<div class="col-sm-2">
		<div class="form-group">
			<label class="control-label">Código</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*39.49*/lcForm/*39.55*/.field("codigo").value)),format.raw/*39.77*/("""</p>
		</div>
	</div>
	<div class="col-sm-5">
		<div class="form-group">
			<label class="control-label">Denominación</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*45.49*/lcForm/*45.55*/.field("denominacion").value)),format.raw/*45.83*/("""</p>
		</div>
	</div>
	<div class="col-sm-5">
		<div class="form-group">
			<label class="control-label">Abreviatura</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*51.49*/lcForm/*51.55*/.field("abreviatura").value)),format.raw/*51.82*/("""</p>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-sm-2">
		<div class="form-group">
			<label class="control-label">Fecha Baja</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*59.49*/lcForm/*59.55*/.field("fecha_baja").value)),format.raw/*59.81*/("""</p>
		</div>
	</div>
	<div class="col-sm-5">

		<div class="form-group">
			<label class="control-label">Tipo</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*66.49*/lcForm/*66.55*/.field("liquidacionConceptoTipo.nombre").value)),format.raw/*66.101*/("""</p>
		</div>
	</div>
	<div class="col-sm-5">
		<div class="form-group">
			<label class="control-label">Base Cálculo</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*72.49*/lcForm/*72.55*/.field("liquidacionBaseCalculo.nombre").value)),format.raw/*72.100*/("""</p>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-sm-5">
		<div class="form-group">
			<label class="control-label">Clasificacion</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*80.49*/lcForm/*80.55*/.field("liquidacionConceptoClasificacion.nombre").value)),format.raw/*80.110*/("""</p>
		</div>
	</div>
	<div class="col-sm-2">
			<div class="form-group">
				<label class="control-label">Deduce ganancias</label>
				<p class="form-control-static form-control">
					"""),_display_(Seq[Any](/*87.7*/if(lcForm("deduce_ganancias").value == "true")/*87.53*/{_display_(Seq[Any](format.raw/*87.54*/("""SI""")))}/*87.57*/else/*87.61*/{_display_(Seq[Any](format.raw/*87.62*/("""NO""")))})),format.raw/*87.65*/("""
				</p>
			</div>
		</div>
	<div class="col-sm-2">
			<div class="form-group">
				<label class="control-label">Reporte ganancias</label>
				<p class="form-control-static form-control">
					"""),_display_(Seq[Any](/*95.7*/if(lcForm("reporte_ganancias").value == "true")/*95.54*/{_display_(Seq[Any](format.raw/*95.55*/("""SI""")))}/*95.58*/else/*95.62*/{_display_(Seq[Any](format.raw/*95.63*/("""NO""")))})),format.raw/*95.66*/("""
				</p>
			</div>
		</div>	
</div>
""")))})),format.raw/*100.2*/("""
"""))}
    }
    
    def render(lcForm:Form[models.haberes.LiquidacionConcepto],lc:models.haberes.LiquidacionConcepto): play.api.templates.HtmlFormat.Appendable = apply(lcForm,lc)
    
    def f:((Form[models.haberes.LiquidacionConcepto],models.haberes.LiquidacionConcepto) => play.api.templates.HtmlFormat.Appendable) = (lcForm,lc) => apply(lcForm,lc)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:35 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/liquidacionConceptos/verLiquidacionConcepto.scala.html
                    HASH: 0521b74f0ec73b7077d6428945a04eec18cbc3bf
                    MATRIX: 889->1|1087->125|1101->132|1185->136|1235->151|1249->157|1326->213|1393->252|1425->276|1499->88|1526->249|1555->320|1592->323|1604->328|1663->379|1702->381|1963->606|1983->617|2059->671|2203->779|2223->790|2314->851|2331->859|2363->868|2495->964|2515->975|2608->1038|2625->1046|2657->1055|2860->1222|2877->1230|2991->1321|3178->1472|3189->1474|3214->1477|3419->1646|3434->1652|3478->1674|3688->1848|3703->1854|3753->1882|3962->2055|3977->2061|4026->2088|4259->2285|4274->2291|4322->2317|4525->2484|4540->2490|4609->2536|4819->2710|4834->2716|4902->2761|5138->2961|5153->2967|5231->3022|5453->3209|5508->3255|5547->3256|5569->3259|5582->3263|5621->3264|5656->3267|5886->3462|5942->3509|5981->3510|6003->3513|6016->3517|6055->3518|6090->3521|6160->3559
                    LINES: 26->1|31->4|31->4|33->4|34->5|34->5|34->5|35->7|35->7|36->1|37->6|38->7|40->9|40->9|40->9|40->9|51->20|51->20|51->20|53->22|53->22|53->22|53->22|53->22|55->24|55->24|55->24|55->24|55->24|60->29|60->29|60->29|65->34|65->34|65->34|70->39|70->39|70->39|76->45|76->45|76->45|82->51|82->51|82->51|90->59|90->59|90->59|97->66|97->66|97->66|103->72|103->72|103->72|111->80|111->80|111->80|118->87|118->87|118->87|118->87|118->87|118->87|118->87|126->95|126->95|126->95|126->95|126->95|126->95|126->95|131->100
                    -- GENERATED --
                */
            