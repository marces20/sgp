
package views.html.administracion.grupos

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
object form extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Grupo],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(grupoForm: Form[Grupo]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.26*/("""
"""),format.raw/*3.70*/(""" 


 <div class="row">
		<div class="col-sm-2">
			<div class="form-group has-required """),_display_(Seq[Any](/*8.41*/if(grupoForm.error("nombre") != null)/*8.78*/ {_display_(Seq[Any](format.raw/*8.80*/("""has-error""")))})),format.raw/*8.90*/("""">
				<label for="nombre" class="control-label">Nombre</label>
				"""),_display_(Seq[Any](/*10.6*/inputText(grupoForm("nombre"), 'class -> "form-control"))),format.raw/*10.62*/("""
				"""),_display_(Seq[Any](/*11.6*/grupoForm("nombre")/*11.25*/.error.map/*11.35*/{ error =>_display_(Seq[Any](format.raw/*11.45*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*12.31*/error/*12.36*/.message)),format.raw/*12.44*/("""</div>
				""")))})),format.raw/*13.6*/("""
			</div>
		</div>

	</div>	"""))}
    }
    
    def render(grupoForm:Form[Grupo]): play.api.templates.HtmlFormat.Appendable = apply(grupoForm)
    
    def f:((Form[Grupo]) => play.api.templates.HtmlFormat.Appendable) = (grupoForm) => apply(grupoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/administracion/grupos/form.scala.html
                    HASH: bf0b447e561f0b01e80769a3ed2b4dd86d3b40d3
                    MATRIX: 800->1|927->46|959->70|1033->25|1062->114|1190->207|1235->244|1274->246|1315->256|1421->327|1499->383|1541->390|1569->409|1588->419|1636->429|1704->461|1718->466|1748->474|1792->487
                    LINES: 26->1|29->3|29->3|30->1|31->3|36->8|36->8|36->8|36->8|38->10|38->10|39->11|39->11|39->11|39->11|40->12|40->12|40->12|41->13
                    -- GENERATED --
                */
            