
package views.html.contabilidad.misPagos

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
object formMiPago extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[MiPago],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formMiPago: Form[MiPago]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.28*/("""
"""),format.raw/*4.70*/(""" 

<script>
$(function()"""),format.raw/*7.13*/("""{"""),format.raw/*7.14*/("""
	$("#fecha").mask("99/99/9999");
	$("#numero").numeric_input("""),format.raw/*9.29*/("""{"""),format.raw/*9.30*/("""decimal: null, initialParse: false"""),format.raw/*9.64*/("""}"""),format.raw/*9.65*/(""");
	$("#monto").numeric_input();
"""),format.raw/*11.1*/("""}"""),format.raw/*11.2*/(""");
</script>


<div class="row menu-acciones">
	<div class="col-sm-10">
		<button type="submit" class="btn btn-default" title="Guardar Mis Pagos"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>	
    	<a href=""""),_display_(Seq[Any](/*18.16*/if( UriTrack.decode() )/*18.39*/{_display_(Seq[Any](format.raw/*18.40*/(""" """),_display_(Seq[Any](/*18.42*/UriTrack/*18.50*/.decode())),format.raw/*18.59*/(""" """)))}/*18.62*/else/*18.67*/{_display_(Seq[Any](_display_(Seq[Any](/*18.69*/controllers/*18.80*/.contabilidad.routes.MisPagosController.index())),_display_(Seq[Any](/*18.128*/UriTrack/*18.136*/.decode()))))})),format.raw/*18.146*/("""" title="Cancelar editar" class="btn btn-default"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
    </div>
	<div class="col-sm-2">
		<a href=""""),_display_(Seq[Any](/*21.13*/UriTrack/*21.21*/.decode())),format.raw/*21.30*/("""" title="Volver al listado" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
	</div>
</div>

<input type="hidden" name="""),_display_(Seq[Any](/*25.28*/UriTrack/*25.36*/.getKey())),format.raw/*25.45*/(""" value=""""),_display_(Seq[Any](/*25.54*/UriTrack/*25.62*/.code())),format.raw/*25.69*/("""" />
<div class="row">
	<div class="col-sm-2">
		<label class="control-label">Fecha</label> 
		<div class="form-group """),_display_(Seq[Any](/*29.27*/if(formMiPago.error("fecha") != null)/*29.64*/ {_display_(Seq[Any](format.raw/*29.66*/("""has-error""")))})),format.raw/*29.76*/("""">
			"""),_display_(Seq[Any](/*30.5*/inputText(formMiPago("fecha"),'class -> "form-control date",'readOnly -> "readOnly"))),format.raw/*30.89*/("""
		</div>
		"""),_display_(Seq[Any](/*32.4*/formMiPago("fecha")/*32.23*/.error.map/*32.33*/{ error =>_display_(Seq[Any](format.raw/*32.43*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*33.29*/error/*33.34*/.message)),format.raw/*33.42*/("""</div>
		""")))})),format.raw/*34.4*/("""
	</div>
	<div class="col-sm-2">
		<label class="control-label">N° Envio</label> 
		<div class="form-group """),_display_(Seq[Any](/*38.27*/if(formMiPago.error("numero_envio") != null)/*38.71*/ {_display_(Seq[Any](format.raw/*38.73*/("""has-error""")))})),format.raw/*38.83*/("""">
			"""),_display_(Seq[Any](/*39.5*/inputText(formMiPago("numero_envio"),'class -> "form-control"))),format.raw/*39.67*/("""
		</div>
		"""),_display_(Seq[Any](/*41.4*/formMiPago("numero_envio")/*41.30*/.error.map/*41.40*/{ error =>_display_(Seq[Any](format.raw/*41.50*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*42.29*/error/*42.34*/.message)),format.raw/*42.42*/("""</div>
		""")))})),format.raw/*43.4*/("""
	</div>
	<div class="col-sm-2">
		<label class="control-label">N° Lote</label> 
		<div class="form-group """),_display_(Seq[Any](/*47.27*/if(formMiPago.error("numero_lote") != null)/*47.70*/ {_display_(Seq[Any](format.raw/*47.72*/("""has-error""")))})),format.raw/*47.82*/("""">
			"""),_display_(Seq[Any](/*48.5*/inputText(formMiPago("numero_lote"),'class -> "form-control"))),format.raw/*48.66*/("""
		</div>
		"""),_display_(Seq[Any](/*50.4*/formMiPago("numero_lote")/*50.29*/.error.map/*50.39*/{ error =>_display_(Seq[Any](format.raw/*50.49*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*51.29*/error/*51.34*/.message)),format.raw/*51.42*/("""</div>
		""")))})),format.raw/*52.4*/("""
	</div>
	<div class="col-sm-2">
		<label class="control-label">Cantidad</label> 
		<div class="form-group """),_display_(Seq[Any](/*56.27*/if(formMiPago.error("cantidad") != null)/*56.67*/ {_display_(Seq[Any](format.raw/*56.69*/("""has-error""")))})),format.raw/*56.79*/("""">
			"""),_display_(Seq[Any](/*57.5*/inputText(formMiPago("cantidad"),'class -> "form-control",'readOnly -> "readOnly"))),format.raw/*57.87*/("""
		</div>
		"""),_display_(Seq[Any](/*59.4*/formMiPago("cantidad")/*59.26*/.error.map/*59.36*/{ error =>_display_(Seq[Any](format.raw/*59.46*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*60.29*/error/*60.34*/.message)),format.raw/*60.42*/("""</div>
		""")))})),format.raw/*61.4*/("""
	</div>
	<div class="col-sm-2">
		<label class="control-label">Monto Total</label> 
		<div class="form-group """),_display_(Seq[Any](/*65.27*/if(formMiPago.error("cantidad") != null)/*65.67*/ {_display_(Seq[Any](format.raw/*65.69*/("""has-error""")))})),format.raw/*65.79*/("""">
			"""),_display_(Seq[Any](/*66.5*/inputText(formMiPago("monto"),'class -> "form-control",'readOnly -> "readOnly"))),format.raw/*66.84*/("""
		</div>
		"""),_display_(Seq[Any](/*68.4*/formMiPago("monto")/*68.23*/.error.map/*68.33*/{ error =>_display_(Seq[Any](format.raw/*68.43*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*69.29*/error/*69.34*/.message)),format.raw/*69.42*/("""</div>
		""")))})),format.raw/*70.4*/("""
	</div>
	
</div>"""))}
    }
    
    def render(formMiPago:Form[MiPago]): play.api.templates.HtmlFormat.Appendable = apply(formMiPago)
    
    def f:((Form[MiPago]) => play.api.templates.HtmlFormat.Appendable) = (formMiPago) => apply(formMiPago)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:39 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/misPagos/formMiPago.scala.html
                    HASH: ff5022841d93819cc5cb00f5c6b6b0e4ed02c519
                    MATRIX: 807->1|953->65|985->89|1059->27|1088->133|1142->160|1170->161|1261->225|1289->226|1350->260|1378->261|1440->296|1468->297|1738->531|1770->554|1809->555|1847->557|1864->565|1895->574|1916->577|1929->582|1977->584|1997->595|2076->643|2094->651|2131->661|2330->824|2347->832|2378->841|2559->986|2576->994|2607->1003|2652->1012|2669->1020|2698->1027|2857->1150|2903->1187|2943->1189|2985->1199|3028->1207|3134->1291|3184->1306|3212->1325|3231->1335|3279->1345|3345->1375|3359->1380|3389->1388|3431->1399|3579->1511|3632->1555|3672->1557|3714->1567|3757->1575|3841->1637|3891->1652|3926->1678|3945->1688|3993->1698|4059->1728|4073->1733|4103->1741|4145->1752|4292->1863|4344->1906|4384->1908|4426->1918|4469->1926|4552->1987|4602->2002|4636->2027|4655->2037|4703->2047|4769->2077|4783->2082|4813->2090|4855->2101|5003->2213|5052->2253|5092->2255|5134->2265|5177->2273|5281->2355|5331->2370|5362->2392|5381->2402|5429->2412|5495->2442|5509->2447|5539->2455|5581->2466|5732->2581|5781->2621|5821->2623|5863->2633|5906->2641|6007->2720|6057->2735|6085->2754|6104->2764|6152->2774|6218->2804|6232->2809|6262->2817|6304->2828
                    LINES: 26->1|31->4|31->4|32->1|33->4|36->7|36->7|38->9|38->9|38->9|38->9|40->11|40->11|47->18|47->18|47->18|47->18|47->18|47->18|47->18|47->18|47->18|47->18|47->18|47->18|47->18|50->21|50->21|50->21|54->25|54->25|54->25|54->25|54->25|54->25|58->29|58->29|58->29|58->29|59->30|59->30|61->32|61->32|61->32|61->32|62->33|62->33|62->33|63->34|67->38|67->38|67->38|67->38|68->39|68->39|70->41|70->41|70->41|70->41|71->42|71->42|71->42|72->43|76->47|76->47|76->47|76->47|77->48|77->48|79->50|79->50|79->50|79->50|80->51|80->51|80->51|81->52|85->56|85->56|85->56|85->56|86->57|86->57|88->59|88->59|88->59|88->59|89->60|89->60|89->60|90->61|94->65|94->65|94->65|94->65|95->66|95->66|97->68|97->68|97->68|97->68|98->69|98->69|98->69|99->70
                    -- GENERATED --
                */
            