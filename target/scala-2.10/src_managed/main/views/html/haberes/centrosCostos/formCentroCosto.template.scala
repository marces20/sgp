
package views.html.haberes.centrosCostos

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
object formCentroCosto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.haberes.CentroCosto],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(centroForm: Form[models.haberes.CentroCosto]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

import models.haberes._

implicit def /*6.2*/implicitFieldConstructor/*6.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.48*/("""
"""),format.raw/*6.70*/(""" 
	
	<div class="row menu-acciones">
		<div class="col-sm-10">
			<button type="submit" class="btn btn-default" title="Guardar centro"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>
			<a href=""""),_display_(Seq[Any](/*11.14*/if(request().getHeader("referer"))/*11.48*/{_display_(Seq[Any](format.raw/*11.49*/(""" """),_display_(Seq[Any](/*11.51*/request()/*11.60*/.getHeader("referer"))),format.raw/*11.81*/(""" """)))}/*11.84*/else/*11.89*/{_display_(Seq[Any](_display_(Seq[Any](/*11.91*/controllers/*11.102*/.haberes.routes.CentrosCostosController.index())),_display_(Seq[Any](/*11.150*/UriTrack/*11.158*/.decode()))))})),format.raw/*11.168*/("""" title="Cancelar editar" class="btn btn-default"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
		</div>
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*14.14*/UriTrack/*14.22*/.decode())),format.raw/*14.31*/("""" title="Volver al listado" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
		</div>	
	</div>
	<div class="row">
		 
		<div class="col-sm-5">
			<div class="form-group """),_display_(Seq[Any](/*20.28*/if(centroForm.error("nombre") != null)/*20.66*/ {_display_(Seq[Any](format.raw/*20.68*/("""has-error""")))}/*20.78*/else/*20.82*/{_display_(Seq[Any](format.raw/*20.83*/("""has-required""")))})),format.raw/*20.96*/("""">
				<label for="inputDenominacion" class="control-label">Denominacion</label> 
				"""),_display_(Seq[Any](/*22.6*/inputText(centroForm("nombre"), 'class -> "form-control"))),format.raw/*22.63*/("""
				"""),_display_(Seq[Any](/*23.6*/centroForm("nombre")/*23.26*/.error.map/*23.36*/{ error =>_display_(Seq[Any](format.raw/*23.46*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*24.31*/error/*24.36*/.message)),format.raw/*24.44*/("""</div>
				""")))})),format.raw/*25.6*/("""
			</div>
		</div>
		 
	</div>
	"""))}
    }
    
    def render(centroForm:Form[models.haberes.CentroCosto]): play.api.templates.HtmlFormat.Appendable = apply(centroForm)
    
    def f:((Form[models.haberes.CentroCosto]) => play.api.templates.HtmlFormat.Appendable) = (centroForm) => apply(centroForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/centrosCostos/formCentroCosto.scala.html
                    HASH: aca1407dec9f8fb9aa58f27b9fd9c7e673f51077
                    MATRIX: 832->1|1043->129|1075->153|1149->47|1177->197|1426->410|1469->444|1508->445|1546->447|1564->456|1607->477|1628->480|1641->485|1689->487|1710->498|1789->546|1807->554|1844->564|2040->724|2057->732|2088->741|2315->932|2362->970|2402->972|2431->982|2444->986|2483->987|2528->1000|2650->1087|2729->1144|2770->1150|2799->1170|2818->1180|2866->1190|2933->1221|2947->1226|2977->1234|3020->1246
                    LINES: 26->1|35->6|35->6|36->1|37->6|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|45->14|45->14|45->14|51->20|51->20|51->20|51->20|51->20|51->20|51->20|53->22|53->22|54->23|54->23|54->23|54->23|55->24|55->24|55->24|56->25
                    -- GENERATED --
                */
            