
package views.html.expediente.iniciador

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
object formIniciadorExpediente extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[IniciadorExpediente],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(iniciadorExpedienteForm: Form[IniciadorExpediente]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.54*/("""
"""),format.raw/*3.70*/(""" 

	<div class="row">
		<div class="col-sm-4">
			<div class="form-group """),_display_(Seq[Any](/*7.28*/if(iniciadorExpedienteForm.error("nombre") != null)/*7.79*/ {_display_(Seq[Any](format.raw/*7.81*/("""has-error""")))}/*7.91*/else/*7.95*/{_display_(Seq[Any](format.raw/*7.96*/("""has-required""")))})),format.raw/*7.109*/("""">
				<label for="inputNombre" class="control-label">Nombre</label> 
				"""),_display_(Seq[Any](/*9.6*/inputText(iniciadorExpedienteForm("nombre"), 'class -> "form-control"))),format.raw/*9.76*/("""
				"""),_display_(Seq[Any](/*10.6*/iniciadorExpedienteForm("nombre")/*10.39*/.error.map/*10.49*/{ error =>_display_(Seq[Any](format.raw/*10.59*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*11.31*/error/*11.36*/.message)),format.raw/*11.44*/("""</div>
				""")))})),format.raw/*12.6*/("""
			</div>
		</div>
	</div>"""))}
    }
    
    def render(iniciadorExpedienteForm:Form[IniciadorExpediente]): play.api.templates.HtmlFormat.Appendable = apply(iniciadorExpedienteForm)
    
    def f:((Form[IniciadorExpediente]) => play.api.templates.HtmlFormat.Appendable) = (iniciadorExpedienteForm) => apply(iniciadorExpedienteForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:36 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/expediente/iniciador/formIniciadorExpediente.scala.html
                    HASH: 15a226dda89ae7d6b94f4fff5fe84a6190c77ec2
                    MATRIX: 832->1|986->72|1018->96|1092->53|1120->140|1229->214|1288->265|1327->267|1355->277|1367->281|1405->282|1450->295|1559->370|1650->440|1691->446|1733->479|1752->489|1800->499|1867->530|1881->535|1911->543|1954->555
                    LINES: 26->1|29->3|29->3|30->1|31->3|35->7|35->7|35->7|35->7|35->7|35->7|35->7|37->9|37->9|38->10|38->10|38->10|38->10|39->11|39->11|39->11|40->12
                    -- GENERATED --
                */
            