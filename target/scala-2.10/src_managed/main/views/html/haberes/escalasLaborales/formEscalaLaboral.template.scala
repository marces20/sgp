
package views.html.haberes.escalasLaborales

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
object formEscalaLaboral extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.haberes.EscalaLaboral],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(escalaForm: Form[models.haberes.EscalaLaboral]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

import models.haberes._

implicit def /*6.2*/implicitFieldConstructor/*6.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.50*/("""
"""),format.raw/*6.70*/(""" 
	
	<div class="row menu-acciones">
		<div class="col-sm-10">
			<button type="submit" class="btn btn-default" title="Guardar escala"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>
			<a href=""""),_display_(Seq[Any](/*11.14*/if(request().getHeader("referer"))/*11.48*/{_display_(Seq[Any](format.raw/*11.49*/(""" """),_display_(Seq[Any](/*11.51*/request()/*11.60*/.getHeader("referer"))),format.raw/*11.81*/(""" """)))}/*11.84*/else/*11.89*/{_display_(Seq[Any](_display_(Seq[Any](/*11.91*/controllers/*11.102*/.haberes.routes.EscalasLaboralesController.index())),_display_(Seq[Any](/*11.153*/UriTrack/*11.161*/.decode()))))})),format.raw/*11.171*/("""" title="Cancelar editar" class="btn btn-default"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
		</div>
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*14.14*/UriTrack/*14.22*/.decode())),format.raw/*14.31*/("""" title="Volver al listado" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
		</div>	
	</div>
	<div class="row">
		 
		<div class="col-sm-5">
			<div class="form-group """),_display_(Seq[Any](/*20.28*/if(escalaForm.error("nombre") != null)/*20.66*/ {_display_(Seq[Any](format.raw/*20.68*/("""has-error""")))}/*20.78*/else/*20.82*/{_display_(Seq[Any](format.raw/*20.83*/("""has-required""")))})),format.raw/*20.96*/("""">
				<label for="inputDenominacion" class="control-label">Denominacion</label> 
				"""),_display_(Seq[Any](/*22.6*/inputText(escalaForm("nombre"), 'class -> "form-control"))),format.raw/*22.63*/("""
				"""),_display_(Seq[Any](/*23.6*/escalaForm("nombre")/*23.26*/.error.map/*23.36*/{ error =>_display_(Seq[Any](format.raw/*23.46*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*24.31*/error/*24.36*/.message)),format.raw/*24.44*/("""</div>
				""")))})),format.raw/*25.6*/("""
			</div>
		</div>
		 
	</div>
	"""))}
    }
    
    def render(escalaForm:Form[models.haberes.EscalaLaboral]): play.api.templates.HtmlFormat.Appendable = apply(escalaForm)
    
    def f:((Form[models.haberes.EscalaLaboral]) => play.api.templates.HtmlFormat.Appendable) = (escalaForm) => apply(escalaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/escalasLaborales/formEscalaLaboral.scala.html
                    HASH: 5a7490362a56010ac0ba07b5c6dcfb79f2ae1cc9
                    MATRIX: 839->1|1052->131|1084->155|1158->49|1186->199|1435->412|1478->446|1517->447|1555->449|1573->458|1616->479|1637->482|1650->487|1698->489|1719->500|1801->551|1819->559|1856->569|2052->729|2069->737|2100->746|2327->937|2374->975|2414->977|2443->987|2456->991|2495->992|2540->1005|2662->1092|2741->1149|2782->1155|2811->1175|2830->1185|2878->1195|2945->1226|2959->1231|2989->1239|3032->1251
                    LINES: 26->1|35->6|35->6|36->1|37->6|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|45->14|45->14|45->14|51->20|51->20|51->20|51->20|51->20|51->20|51->20|53->22|53->22|54->23|54->23|54->23|54->23|55->24|55->24|55->24|56->25
                    -- GENERATED --
                */
            