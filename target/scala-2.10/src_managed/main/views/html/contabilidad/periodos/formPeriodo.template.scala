
package views.html.contabilidad.periodos

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
object formPeriodo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Periodo],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(periodoForm: Form[Periodo]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.30*/("""
"""),format.raw/*3.70*/(""" 

	<div class="row">
		<div class="col-sm-4">
			<div class="form-group """),_display_(Seq[Any](/*7.28*/if(periodoForm.error("nombre") != null)/*7.67*/ {_display_(Seq[Any](format.raw/*7.69*/("""has-error""")))}/*7.79*/else/*7.83*/{_display_(Seq[Any](format.raw/*7.84*/("""has-required""")))})),format.raw/*7.97*/("""">
				<label for="inputNombre" class="control-label">Nombre</label> 
				"""),_display_(Seq[Any](/*9.6*/inputText(periodoForm("nombre"), 'class -> "form-control"))),format.raw/*9.64*/("""
				"""),_display_(Seq[Any](/*10.6*/periodoForm("nombre")/*10.27*/.error.map/*10.37*/{ error =>_display_(Seq[Any](format.raw/*10.47*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*11.31*/error/*11.36*/.message)),format.raw/*11.44*/("""</div>
				""")))})),format.raw/*12.6*/("""
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*16.28*/if(periodoForm.error("ejercicio.id") != null)/*16.73*/ {_display_(Seq[Any](format.raw/*16.75*/("""has-error""")))}/*16.85*/else/*16.89*/{_display_(Seq[Any](format.raw/*16.90*/("""has-required""")))})),format.raw/*16.103*/("""">
				<label for="inputEjercicio" class="control-label">Ejercicio</label> 
				"""),_display_(Seq[Any](/*18.6*/inputText(periodoForm("ejercicio.nombre"),'class -> "form-control"))),format.raw/*18.73*/("""
				"""),_display_(Seq[Any](/*19.6*/inputText(periodoForm("ejercicio.id"),'hidden -> "hidden"))),format.raw/*19.64*/("""
				"""),_display_(Seq[Any](/*20.6*/periodoForm("ejercicio.id")/*20.33*/.error.map/*20.43*/{ error =>_display_(Seq[Any](format.raw/*20.53*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*21.31*/error/*21.36*/.message)),format.raw/*21.44*/("""</div>
				""")))})),format.raw/*22.6*/("""
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-4">
			<div class="form-group">
				<label for="inputFDesde" class="control-label">Fecha Comienzo</label> 
				"""),_display_(Seq[Any](/*30.6*/inputText(periodoForm("date_start"), 'class -> "form-control"))),format.raw/*30.68*/("""
			</div>
		</div>
		<div class="col-sm-4">
			<div class="form-group">
				<label for="inputFHasta" class="control-label">Fecha Fin</label> 
				"""),_display_(Seq[Any](/*36.6*/inputText(periodoForm("date_end"), 'class -> "form-control"))),format.raw/*36.66*/("""
			</div>
		</div>
	</div>"""))}
    }
    
    def render(periodoForm:Form[Periodo]): play.api.templates.HtmlFormat.Appendable = apply(periodoForm)
    
    def f:((Form[Periodo]) => play.api.templates.HtmlFormat.Appendable) = (periodoForm) => apply(periodoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:38 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/periodos/formPeriodo.scala.html
                    HASH: c243562571a31122158cdd529f3d060bca9fa2d5
                    MATRIX: 809->1|939->48|971->72|1045->29|1073->116|1182->190|1229->229|1268->231|1296->241|1308->245|1346->246|1390->259|1499->334|1578->392|1619->398|1649->419|1668->429|1716->439|1783->470|1797->475|1827->483|1870->495|1978->567|2032->612|2072->614|2101->624|2114->628|2153->629|2199->642|2315->723|2404->790|2445->796|2525->854|2566->860|2602->887|2621->897|2669->907|2736->938|2750->943|2780->951|2823->963|3038->1143|3122->1205|3305->1353|3387->1413
                    LINES: 26->1|29->3|29->3|30->1|31->3|35->7|35->7|35->7|35->7|35->7|35->7|35->7|37->9|37->9|38->10|38->10|38->10|38->10|39->11|39->11|39->11|40->12|44->16|44->16|44->16|44->16|44->16|44->16|44->16|46->18|46->18|47->19|47->19|48->20|48->20|48->20|48->20|49->21|49->21|49->21|50->22|58->30|58->30|64->36|64->36
                    -- GENERATED --
                */
            