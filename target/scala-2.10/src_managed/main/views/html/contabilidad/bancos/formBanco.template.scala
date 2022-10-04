
package views.html.contabilidad.bancos

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
object formBanco extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Banco],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(bancoForm: Form[Banco]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.26*/("""
"""),format.raw/*3.70*/(""" 

	<div class="row">
		<div class="col-sm-4">
			<div class="form-group """),_display_(Seq[Any](/*7.28*/if(bancoForm.error("nombre") != null)/*7.65*/ {_display_(Seq[Any](format.raw/*7.67*/("""has-error""")))}/*7.77*/else/*7.81*/{_display_(Seq[Any](format.raw/*7.82*/("""has-required""")))})),format.raw/*7.95*/("""">
				<label for="inputNombre" class="control-label">Nombre</label> 
				"""),_display_(Seq[Any](/*9.6*/inputText(bancoForm("nombre"), 'class -> "form-control"))),format.raw/*9.62*/("""
				"""),_display_(Seq[Any](/*10.6*/bancoForm("nombre")/*10.25*/.error.map/*10.35*/{ error =>_display_(Seq[Any](format.raw/*10.45*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*11.31*/error/*11.36*/.message)),format.raw/*11.44*/("""</div>
				""")))})),format.raw/*12.6*/("""
			</div>
		</div>
		<div class="col-sm-4">
			<div class="form-group">
				<label for="inputCuit" class="control-label">Cuit</label> 
				"""),_display_(Seq[Any](/*18.6*/inputText(bancoForm("cuit"), 'class -> "form-control"))),format.raw/*18.60*/("""
			</div>
		</div>
	</div>"""))}
    }
    
    def render(bancoForm:Form[Banco]): play.api.templates.HtmlFormat.Appendable = apply(bancoForm)
    
    def f:((Form[Banco]) => play.api.templates.HtmlFormat.Appendable) = (bancoForm) => apply(bancoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/bancos/formBanco.scala.html
                    HASH: e54e8c44723e34f74f1acbf4e124643d2f43fcf4
                    MATRIX: 803->1|929->44|961->68|1035->25|1063->112|1172->186|1217->223|1256->225|1284->235|1296->239|1334->240|1378->253|1487->328|1564->384|1605->390|1633->409|1652->419|1700->429|1767->460|1781->465|1811->473|1854->485|2030->626|2106->680
                    LINES: 26->1|29->3|29->3|30->1|31->3|35->7|35->7|35->7|35->7|35->7|35->7|35->7|37->9|37->9|38->10|38->10|38->10|38->10|39->11|39->11|39->11|40->12|46->18|46->18
                    -- GENERATED --
                */
            