
package views.html.contabilidad.cuentas

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
object form extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[Cuenta],Cuenta,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(cuentaForm: Form[Cuenta], cuentaPadre: Cuenta):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.49*/("""
"""),format.raw/*3.70*/("""


 <div class="row">
	<div class="col-sm-4">
		<div class="form-group">
			<label for="nombre" class="control-label">Cuenta Padre</label>
			<p>"""),_display_(Seq[Any](/*10.8*/cuentaPadre/*10.19*/.nombre)),format.raw/*10.26*/("""</p>
			<p>"""),_display_(Seq[Any](/*11.8*/cuentaPadre/*11.19*/.code)),format.raw/*11.24*/("""</p>
		</div>
	</div>
	
	<div class="col-sm-3">
		<div class="form-group """),_display_(Seq[Any](/*16.27*/if(cuentaForm.error("code") != null)/*16.63*/ {_display_(Seq[Any](format.raw/*16.65*/("""has-error""")))}/*16.76*/else/*16.81*/{_display_(Seq[Any](format.raw/*16.82*/("""has-required""")))})),format.raw/*16.95*/("""">
			<label for="codigo" class="control-label">Código</label>
			"""),_display_(Seq[Any](/*18.5*/inputText(cuentaForm("code"), 'class -> "form-control"))),format.raw/*18.60*/("""
			"""),_display_(Seq[Any](/*19.5*/cuentaForm("code")/*19.23*/.error.map/*19.33*/{ error =>_display_(Seq[Any](format.raw/*19.43*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*20.30*/error/*20.35*/.message)),format.raw/*20.43*/("""</div>
			""")))})),format.raw/*21.5*/("""
		</div>
	</div>
	
	<div class="col-sm-5">
		<div class="form-group """),_display_(Seq[Any](/*26.27*/if(cuentaForm.error("nombre") != null)/*26.65*/ {_display_(Seq[Any](format.raw/*26.67*/("""has-error""")))}/*26.78*/else/*26.83*/{_display_(Seq[Any](format.raw/*26.84*/("""has-required""")))})),format.raw/*26.97*/("""">
			<label for="nombre" class="control-label">Nombre</label>
			"""),_display_(Seq[Any](/*28.5*/inputText(cuentaForm("nombre"), 'class -> "form-control"))),format.raw/*28.62*/("""
			"""),_display_(Seq[Any](/*29.5*/cuentaForm("nombre")/*29.25*/.error.map/*29.35*/{ error =>_display_(Seq[Any](format.raw/*29.45*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*30.30*/error/*30.35*/.message)),format.raw/*30.43*/("""</div>
			""")))})),format.raw/*31.5*/("""
		</div>
	</div>
	

</div>"""))}
    }
    
    def render(cuentaForm:Form[Cuenta],cuentaPadre:Cuenta): play.api.templates.HtmlFormat.Appendable = apply(cuentaForm,cuentaPadre)
    
    def f:((Form[Cuenta],Cuenta) => play.api.templates.HtmlFormat.Appendable) = (cuentaForm,cuentaPadre) => apply(cuentaForm,cuentaPadre)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/cuentas/form.scala.html
                    HASH: cc14c33e333559ad70d84c69a467745994c23ac5
                    MATRIX: 807->1|957->69|989->93|1063->48|1092->137|1280->290|1300->301|1329->308|1377->321|1397->332|1424->337|1539->416|1584->452|1624->454|1653->465|1666->470|1705->471|1750->484|1854->553|1931->608|1972->614|1999->632|2018->642|2066->652|2133->683|2147->688|2177->696|2220->708|2331->783|2378->821|2418->823|2447->834|2460->839|2499->840|2544->853|2648->922|2727->979|2768->985|2797->1005|2816->1015|2864->1025|2931->1056|2945->1061|2975->1069|3018->1081
                    LINES: 26->1|29->3|29->3|30->1|31->3|38->10|38->10|38->10|39->11|39->11|39->11|44->16|44->16|44->16|44->16|44->16|44->16|44->16|46->18|46->18|47->19|47->19|47->19|47->19|48->20|48->20|48->20|49->21|54->26|54->26|54->26|54->26|54->26|54->26|54->26|56->28|56->28|57->29|57->29|57->29|57->29|58->30|58->30|58->30|59->31
                    -- GENERATED --
                */
            