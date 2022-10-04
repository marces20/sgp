
package views.html.haberes.liquidacionConceptoTipos

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
object formLiquidacionConceptoTipo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.haberes.LiquidacionConceptoTipo],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(tipoForm: Form[models.haberes.LiquidacionConceptoTipo]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

import models.haberes._

implicit def /*6.2*/implicitFieldConstructor/*6.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.58*/("""
"""),format.raw/*6.70*/(""" 
	
	<div class="row menu-acciones">
		<div class="col-sm-10">
			<button type="submit" class="btn btn-default" title="Guardar tipo de concepto"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>
			<a href=""""),_display_(Seq[Any](/*11.14*/if(request().getHeader("referer"))/*11.48*/{_display_(Seq[Any](format.raw/*11.49*/(""" """),_display_(Seq[Any](/*11.51*/request()/*11.60*/.getHeader("referer"))),format.raw/*11.81*/(""" """)))}/*11.84*/else/*11.89*/{_display_(Seq[Any](_display_(Seq[Any](/*11.91*/controllers/*11.102*/.haberes.routes.LiquidacionConceptoTiposController.index())),_display_(Seq[Any](/*11.161*/UriTrack/*11.169*/.decode()))))})),format.raw/*11.179*/("""" title="Cancelar editar" class="btn btn-default"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
		</div>
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*14.14*/UriTrack/*14.22*/.decode())),format.raw/*14.31*/("""" title="Volver al listado" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
		</div>	
	</div>
	<div class="row">
		 
		<div class="col-sm-5">
			<div class="form-group """),_display_(Seq[Any](/*20.28*/if(tipoForm.error("nombre") != null)/*20.64*/ {_display_(Seq[Any](format.raw/*20.66*/("""has-error""")))}/*20.76*/else/*20.80*/{_display_(Seq[Any](format.raw/*20.81*/("""has-required""")))})),format.raw/*20.94*/("""">
				<label for="inputDenominacion" class="control-label">Denominacion</label> 
				"""),_display_(Seq[Any](/*22.6*/inputText(tipoForm("nombre"), 'class -> "form-control"))),format.raw/*22.61*/("""
				"""),_display_(Seq[Any](/*23.6*/tipoForm("nombre")/*23.24*/.error.map/*23.34*/{ error =>_display_(Seq[Any](format.raw/*23.44*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*24.31*/error/*24.36*/.message)),format.raw/*24.44*/("""</div>
				""")))})),format.raw/*25.6*/("""
			</div>
		</div>
		 
	</div>
	"""))}
    }
    
    def render(tipoForm:Form[models.haberes.LiquidacionConceptoTipo]): play.api.templates.HtmlFormat.Appendable = apply(tipoForm)
    
    def f:((Form[models.haberes.LiquidacionConceptoTipo]) => play.api.templates.HtmlFormat.Appendable) = (tipoForm) => apply(tipoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/liquidacionConceptoTipos/formLiquidacionConceptoTipo.scala.html
                    HASH: 34e7fb7c9375732720ba7e2f9bf5e879e7f5af9a
                    MATRIX: 867->1|1088->139|1120->163|1194->57|1222->207|1481->430|1524->464|1563->465|1601->467|1619->476|1662->497|1683->500|1696->505|1744->507|1765->518|1855->577|1873->585|1910->595|2106->755|2123->763|2154->772|2381->963|2426->999|2466->1001|2495->1011|2508->1015|2547->1016|2592->1029|2714->1116|2791->1171|2832->1177|2859->1195|2878->1205|2926->1215|2993->1246|3007->1251|3037->1259|3080->1271
                    LINES: 26->1|35->6|35->6|36->1|37->6|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|45->14|45->14|45->14|51->20|51->20|51->20|51->20|51->20|51->20|51->20|53->22|53->22|54->23|54->23|54->23|54->23|55->24|55->24|55->24|56->25
                    -- GENERATED --
                */
            