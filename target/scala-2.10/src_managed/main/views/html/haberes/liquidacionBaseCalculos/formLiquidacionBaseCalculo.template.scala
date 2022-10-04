
package views.html.haberes.liquidacionBaseCalculos

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
object formLiquidacionBaseCalculo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.haberes.LiquidacionBaseCalculo],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(baseForm: Form[models.haberes.LiquidacionBaseCalculo]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

import models.haberes._

implicit def /*6.2*/implicitFieldConstructor/*6.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.57*/("""
"""),format.raw/*6.70*/(""" 
	
	<div class="row menu-acciones">
		<div class="col-sm-10">
			<button type="submit" class="btn btn-default" title="Guardar base calculo"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>
			<a href=""""),_display_(Seq[Any](/*11.14*/if(request().getHeader("referer"))/*11.48*/{_display_(Seq[Any](format.raw/*11.49*/(""" """),_display_(Seq[Any](/*11.51*/request()/*11.60*/.getHeader("referer"))),format.raw/*11.81*/(""" """)))}/*11.84*/else/*11.89*/{_display_(Seq[Any](_display_(Seq[Any](/*11.91*/controllers/*11.102*/.haberes.routes.LiquidacionBaseCalculosController.index())),_display_(Seq[Any](/*11.160*/UriTrack/*11.168*/.decode()))))})),format.raw/*11.178*/("""" title="Cancelar editar" class="btn btn-default"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
		</div>
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*14.14*/UriTrack/*14.22*/.decode())),format.raw/*14.31*/("""" title="Volver al listado" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
			"""),_display_(Seq[Any](/*15.5*/if(baseForm.field("id").value)/*15.35*/{_display_(Seq[Any](format.raw/*15.36*/("""<a href=""""),_display_(Seq[Any](/*15.46*/controllers/*15.57*/.haberes.routes.LiquidacionBaseCalculosController.ver(baseForm.field("id").value.toLong))),_display_(Seq[Any](/*15.146*/UriTrack/*15.154*/.get("&"))),format.raw/*15.163*/("""" title="Ver tipo de concepto" class="btn btn-default"><i class="glyphicon glyphicon-align-justify"></i></a>""")))})),format.raw/*15.272*/("""
		</div>	
	</div>
	<div class="row">
		 
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*21.28*/if(baseForm.error("nombre") != null)/*21.64*/ {_display_(Seq[Any](format.raw/*21.66*/("""has-error""")))}/*21.76*/else/*21.80*/{_display_(Seq[Any](format.raw/*21.81*/("""has-required""")))})),format.raw/*21.94*/("""">
				<label for="inputDenominacion" class="control-label">Nombre</label> 
				"""),_display_(Seq[Any](/*23.6*/inputText(baseForm("nombre"), 'class -> "form-control"))),format.raw/*23.61*/("""
				"""),_display_(Seq[Any](/*24.6*/baseForm("nombre")/*24.24*/.error.map/*24.34*/{ error =>_display_(Seq[Any](format.raw/*24.44*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*25.31*/error/*25.36*/.message)),format.raw/*25.44*/("""</div>
				""")))})),format.raw/*26.6*/("""
			</div>
		</div>
		
		 <div class="col-sm-8	">
			<div class="form-group """),_display_(Seq[Any](/*31.28*/if(baseForm.error("parametros") != null)/*31.68*/ {_display_(Seq[Any](format.raw/*31.70*/("""has-error""")))})),format.raw/*31.80*/("""">
				<label for="inputParametros" class="control-label">Parámetros</label> 
				"""),_display_(Seq[Any](/*33.6*/inputText(baseForm("parametros"), 'class -> "form-control"))),format.raw/*33.65*/("""
				"""),_display_(Seq[Any](/*34.6*/baseForm("parametros")/*34.28*/.error.map/*34.38*/{ error =>_display_(Seq[Any](format.raw/*34.48*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*35.31*/error/*35.36*/.message)),format.raw/*35.44*/("""</div>
				""")))})),format.raw/*36.6*/("""
			</div>
		</div> 
		 
	</div>
	<div class="row">
		<div class="col-sm-10	">
			<div class="form-group """),_display_(Seq[Any](/*43.28*/if(baseForm.error("calculo") != null)/*43.65*/ {_display_(Seq[Any](format.raw/*43.67*/("""has-error""")))}/*43.77*/else/*43.81*/{_display_(Seq[Any](format.raw/*43.82*/("""has-required""")))})),format.raw/*43.95*/("""">
				<label for="inputParametros" class="control-label">Cálculo</label> 
				"""),_display_(Seq[Any](/*45.6*/textarea(baseForm("calculo"), 'class -> "form-control", 'rows -> 12))),format.raw/*45.74*/("""
				"""),_display_(Seq[Any](/*46.6*/baseForm("calculo")/*46.25*/.error.map/*46.35*/{ error =>_display_(Seq[Any](format.raw/*46.45*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*47.31*/error/*47.36*/.message)),format.raw/*47.44*/("""</div>
				""")))})),format.raw/*48.6*/("""
			</div>
		</div> 
	</div>
	"""))}
    }
    
    def render(baseForm:Form[models.haberes.LiquidacionBaseCalculo]): play.api.templates.HtmlFormat.Appendable = apply(baseForm)
    
    def f:((Form[models.haberes.LiquidacionBaseCalculo]) => play.api.templates.HtmlFormat.Appendable) = (baseForm) => apply(baseForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/liquidacionBaseCalculos/formLiquidacionBaseCalculo.scala.html
                    HASH: cf3b4723115f662e377cddfc91e4332a92c54df9
                    MATRIX: 864->1|1084->138|1116->162|1190->56|1218->206|1473->425|1516->459|1555->460|1593->462|1611->471|1654->492|1675->495|1688->500|1736->502|1757->513|1846->571|1864->579|1901->589|2097->749|2114->757|2145->766|2282->868|2321->898|2360->899|2406->909|2426->920|2546->1009|2564->1017|2596->1026|2738->1135|2868->1229|2913->1265|2953->1267|2982->1277|2995->1281|3034->1282|3079->1295|3195->1376|3272->1431|3313->1437|3340->1455|3359->1465|3407->1475|3474->1506|3488->1511|3518->1519|3561->1531|3674->1608|3723->1648|3763->1650|3805->1660|3923->1743|4004->1802|4045->1808|4076->1830|4095->1840|4143->1850|4210->1881|4224->1886|4254->1894|4297->1906|4439->2012|4485->2049|4525->2051|4554->2061|4567->2065|4606->2066|4651->2079|4766->2159|4856->2227|4897->2233|4925->2252|4944->2262|4992->2272|5059->2303|5073->2308|5103->2316|5146->2328
                    LINES: 26->1|35->6|35->6|36->1|37->6|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|45->14|45->14|45->14|46->15|46->15|46->15|46->15|46->15|46->15|46->15|46->15|46->15|52->21|52->21|52->21|52->21|52->21|52->21|52->21|54->23|54->23|55->24|55->24|55->24|55->24|56->25|56->25|56->25|57->26|62->31|62->31|62->31|62->31|64->33|64->33|65->34|65->34|65->34|65->34|66->35|66->35|66->35|67->36|74->43|74->43|74->43|74->43|74->43|74->43|74->43|76->45|76->45|77->46|77->46|77->46|77->46|78->47|78->47|78->47|79->48
                    -- GENERATED --
                */
            