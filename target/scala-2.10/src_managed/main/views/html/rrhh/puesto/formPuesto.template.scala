
package views.html.rrhh.puesto

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
object formPuesto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Puesto],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(puestoForm: Form[Puesto]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.28*/("""
"""),format.raw/*3.70*/(""" 

	<div class="row">
		<div class="col-sm-4">
			<div class="form-group """),_display_(Seq[Any](/*7.28*/if(puestoForm.error("nombre") != null)/*7.66*/ {_display_(Seq[Any](format.raw/*7.68*/("""has-error""")))}/*7.78*/else/*7.82*/{_display_(Seq[Any](format.raw/*7.83*/("""has-required""")))})),format.raw/*7.96*/("""">
				<label for="inputNombre" class="control-label">Nombre</label> 
				"""),_display_(Seq[Any](/*9.6*/inputText(puestoForm("nombre"), 'class -> "form-control"))),format.raw/*9.63*/("""
				"""),_display_(Seq[Any](/*10.6*/puestoForm("nombre")/*10.26*/.error.map/*10.36*/{ error =>_display_(Seq[Any](format.raw/*10.46*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*11.31*/error/*11.36*/.message)),format.raw/*11.44*/("""</div>
				""")))})),format.raw/*12.6*/("""
			</div>
		</div>
	</div>
	"""))}
    }
    
    def render(puestoForm:Form[Puesto]): play.api.templates.HtmlFormat.Appendable = apply(puestoForm)
    
    def f:((Form[Puesto]) => play.api.templates.HtmlFormat.Appendable) = (puestoForm) => apply(puestoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:29 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/puesto/formPuesto.scala.html
                    HASH: 581fb3fe76000203ecce0cc7c3a6d52179d77e71
                    MATRIX: 797->1|925->46|957->70|1031->27|1059->114|1168->188|1214->226|1253->228|1281->238|1293->242|1331->243|1375->256|1484->331|1562->388|1603->394|1632->414|1651->424|1699->434|1766->465|1780->470|1810->478|1853->490
                    LINES: 26->1|29->3|29->3|30->1|31->3|35->7|35->7|35->7|35->7|35->7|35->7|35->7|37->9|37->9|38->10|38->10|38->10|38->10|39->11|39->11|39->11|40->12
                    -- GENERATED --
                */
            