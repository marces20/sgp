
package views.html.patrimonio.remitos

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
object formRemito extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Remito],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(remitoForm: Form[Remito]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.28*/("""
"""),format.raw/*4.70*/(""" 

"""),_display_(Seq[Any](/*6.2*/views/*6.7*/.html.tags.successError())),format.raw/*6.32*/("""
<script>
	$( function() """),format.raw/*8.16*/("""{"""),format.raw/*8.17*/("""
		$("#numero_remito").mask("9999-99999999");
	"""),format.raw/*10.2*/("""}"""),format.raw/*10.3*/(""");
</script>	
	


"""),_display_(Seq[Any](/*15.2*/inputText(remitoForm("id"), 'type -> "hidden"))),format.raw/*15.48*/("""
"""),_display_(Seq[Any](/*16.2*/inputText(remitoForm("recepcion_id"), 'type -> "hidden"))),format.raw/*16.58*/("""
<input type="hidden" name="""),_display_(Seq[Any](/*17.28*/UriTrack/*17.36*/.getKey())),format.raw/*17.45*/(""" value=""""),_display_(Seq[Any](/*17.54*/UriTrack/*17.62*/.code())),format.raw/*17.69*/("""" />
"""),_display_(Seq[Any](/*18.2*/if(remitoForm("recepcion_id").value != null)/*18.46*/{_display_(Seq[Any](format.raw/*18.47*/("""
	<div class="row menu-acciones">
		<div class="col-sm-10">
			<button type="submit" class="btn btn-default" title="Guardar solicitud"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>	
	    	<a href=""""),_display_(Seq[Any](/*22.17*/controllers/*22.28*/.patrimonio.routes.RemitosController.index())),format.raw/*22.72*/("""" title="Cancelar" class="btn btn-default"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
	    </div>
	</div>
 <div class="row">
	<div class="col-sm-2">
		<div class="form-group has-required """),_display_(Seq[Any](/*27.40*/if(remitoForm.error("numero") != null)/*27.78*/ {_display_(Seq[Any](format.raw/*27.80*/("""has-error""")))})),format.raw/*27.90*/("""">
			<label for="nombre" class="control-label">Número</label>
			"""),_display_(Seq[Any](/*29.5*/inputText(remitoForm("numero"), 'class -> "form-control",'id->"numero_remito"))),format.raw/*29.83*/("""
			"""),_display_(Seq[Any](/*30.5*/remitoForm("numero")/*30.25*/.error.map/*30.35*/{ error =>_display_(Seq[Any](format.raw/*30.45*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*31.30*/error/*31.35*/.message)),format.raw/*31.43*/("""</div>
			""")))})),format.raw/*32.5*/("""
		</div>
	</div>	


	<div class="col-sm-2  has-required """),_display_(Seq[Any](/*37.38*/if(remitoForm.error("numero") != null)/*37.76*/ {_display_(Seq[Any](format.raw/*37.78*/("""has-error""")))})),format.raw/*37.88*/("""">
		<label class="control-label">Fecha remito</label> 
		<div class="form-group ">
			"""),_display_(Seq[Any](/*40.5*/inputText(remitoForm("fecha_remito"),'class -> "form-control date", 'autocomplete -> "off"))),format.raw/*40.96*/("""
		</div>
		"""),_display_(Seq[Any](/*42.4*/remitoForm("fecha_remito")/*42.30*/.error.map/*42.40*/{ error =>_display_(Seq[Any](format.raw/*42.50*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*43.29*/error/*43.34*/.message)),format.raw/*43.42*/("""</div>
		""")))})),format.raw/*44.4*/("""
	</div>
""")))}/*46.2*/else/*46.6*/{_display_(Seq[Any](format.raw/*46.7*/("""
	<div class="row menu-acciones">
		<div class="col-sm-10">
			<a href=""""),_display_(Seq[Any](/*49.14*/controllers/*49.25*/.patrimonio.routes.RemitosController.index())),format.raw/*49.69*/("""" title="Cancelar" class="btn btn-default"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
	    </div>
	</div>
""")))})),format.raw/*52.2*/("""
</div>	"""))}
    }
    
    def render(remitoForm:Form[Remito]): play.api.templates.HtmlFormat.Appendable = apply(remitoForm)
    
    def f:((Form[Remito]) => play.api.templates.HtmlFormat.Appendable) = (remitoForm) => apply(remitoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/remitos/formRemito.scala.html
                    HASH: c3eaaee3dc696c40a219b91bc69854b6d2fddc7f
                    MATRIX: 804->1|950->65|982->89|1056->27|1085->133|1125->139|1137->144|1183->169|1237->196|1265->197|1341->246|1369->247|1428->271|1496->317|1534->320|1612->376|1677->405|1694->413|1725->422|1770->431|1787->439|1816->446|1858->453|1911->497|1950->498|2207->719|2227->730|2293->774|2542->987|2589->1025|2629->1027|2671->1037|2775->1106|2875->1184|2916->1190|2945->1210|2964->1220|3012->1230|3079->1261|3093->1266|3123->1274|3166->1286|3265->1349|3312->1387|3352->1389|3394->1399|3520->1490|3633->1581|3683->1596|3718->1622|3737->1632|3785->1642|3851->1672|3865->1677|3895->1685|3937->1696|3967->1708|3979->1712|4017->1713|4129->1789|4149->1800|4215->1844|4376->1974
                    LINES: 26->1|31->4|31->4|32->1|33->4|35->6|35->6|35->6|37->8|37->8|39->10|39->10|44->15|44->15|45->16|45->16|46->17|46->17|46->17|46->17|46->17|46->17|47->18|47->18|47->18|51->22|51->22|51->22|56->27|56->27|56->27|56->27|58->29|58->29|59->30|59->30|59->30|59->30|60->31|60->31|60->31|61->32|66->37|66->37|66->37|66->37|69->40|69->40|71->42|71->42|71->42|71->42|72->43|72->43|72->43|73->44|75->46|75->46|75->46|78->49|78->49|78->49|81->52
                    -- GENERATED --
                */
            