
package views.html.patrimonio.recepciones

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
object formRecepciones extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Recepcion],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(recepcionForm: Form[Recepcion]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.34*/("""
"""),format.raw/*4.70*/(""" 

"""),_display_(Seq[Any](/*6.2*/views/*6.7*/.html.tags.successError())),format.raw/*6.32*/("""

"""),_display_(Seq[Any](/*8.2*/inputText(recepcionForm("orden_provision_id"), 'type -> "hidden"))),format.raw/*8.67*/("""

	<div class="row menu-acciones">
		<div class="col-sm-10">
			<button type="submit" class="btn btn-default" title="Guardar solicitud"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>	
	    	<a href=""""),_display_(Seq[Any](/*13.17*/controllers/*13.28*/.patrimonio.routes.RecepcionesController.index())),format.raw/*13.76*/("""" title="Cancelar" class="btn btn-default"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
	    </div>

	</div>

"""),_display_(Seq[Any](/*18.2*/inputText(recepcionForm("id"), 'type -> "hidden"))),format.raw/*18.51*/("""
<input type="hidden" name="""),_display_(Seq[Any](/*19.28*/UriTrack/*19.36*/.getKey())),format.raw/*19.45*/(""" value=""""),_display_(Seq[Any](/*19.54*/UriTrack/*19.62*/.code())),format.raw/*19.69*/("""" />
 <div class="row">
	<div class="col-sm-3">
		<div class="form-group has-required """),_display_(Seq[Any](/*22.40*/if(recepcionForm.error("numero") != null)/*22.81*/ {_display_(Seq[Any](format.raw/*22.83*/("""has-error""")))})),format.raw/*22.93*/("""">
			<label for="nombre" class="control-label">Número</label>
			"""),_display_(Seq[Any](/*24.5*/inputText(recepcionForm("numero"), 'class -> "form-control",'id -> "numero"))),format.raw/*24.81*/("""
			"""),_display_(Seq[Any](/*25.5*/recepcionForm("numero")/*25.28*/.error.map/*25.38*/{ error =>_display_(Seq[Any](format.raw/*25.48*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*26.30*/error/*26.35*/.message)),format.raw/*26.43*/("""</div>
			""")))})),format.raw/*27.5*/("""
		</div>
	</div>

</div>
<script>
$( function()"""),format.raw/*33.14*/("""{"""),format.raw/*33.15*/("""
	$("#numero").numeric_input("""),format.raw/*34.29*/("""{"""),format.raw/*34.30*/("""allowNegative: true"""),format.raw/*34.49*/("""}"""),format.raw/*34.50*/(""");
"""),format.raw/*35.1*/("""}"""),format.raw/*35.2*/(""")
</script>		"""))}
    }
    
    def render(recepcionForm:Form[Recepcion]): play.api.templates.HtmlFormat.Appendable = apply(recepcionForm)
    
    def f:((Form[Recepcion]) => play.api.templates.HtmlFormat.Appendable) = (recepcionForm) => apply(recepcionForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:31 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/recepciones/formRecepciones.scala.html
                    HASH: 0e48e710d6e496f48980201c3e659c53acde0e43
                    MATRIX: 816->1|968->71|1000->95|1074->33|1103->139|1143->145|1155->150|1201->175|1240->180|1326->245|1585->468|1605->479|1675->527|1844->661|1915->710|1980->739|1997->747|2028->756|2073->765|2090->773|2119->780|2245->870|2295->911|2335->913|2377->923|2481->992|2579->1068|2620->1074|2652->1097|2671->1107|2719->1117|2786->1148|2800->1153|2830->1161|2873->1173|2955->1227|2984->1228|3042->1258|3071->1259|3118->1278|3147->1279|3178->1283|3206->1284
                    LINES: 26->1|31->4|31->4|32->1|33->4|35->6|35->6|35->6|37->8|37->8|42->13|42->13|42->13|47->18|47->18|48->19|48->19|48->19|48->19|48->19|48->19|51->22|51->22|51->22|51->22|53->24|53->24|54->25|54->25|54->25|54->25|55->26|55->26|55->26|56->27|62->33|62->33|63->34|63->34|63->34|63->34|64->35|64->35
                    -- GENERATED --
                */
            