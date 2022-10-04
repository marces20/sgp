
package views.html.rrhh.departamento

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
object formDepartamento extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Departamento],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(departamentoForm: Form[Departamento]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.40*/("""
"""),format.raw/*3.70*/(""" 

	<div class="row">
		<div class="col-sm-4">
			<div class="form-group """),_display_(Seq[Any](/*7.28*/if(departamentoForm.error("nombre") != null)/*7.72*/ {_display_(Seq[Any](format.raw/*7.74*/("""has-error""")))}/*7.84*/else/*7.88*/{_display_(Seq[Any](format.raw/*7.89*/("""has-required""")))})),format.raw/*7.102*/("""">
				<label for="inputNombre" class="control-label">Nombre</label> 
				"""),_display_(Seq[Any](/*9.6*/inputText(departamentoForm("nombre"), 'class -> "form-control"))),format.raw/*9.69*/("""
				"""),_display_(Seq[Any](/*10.6*/departamentoForm("nombre")/*10.32*/.error.map/*10.42*/{ error =>_display_(Seq[Any](format.raw/*10.52*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*11.31*/error/*11.36*/.message)),format.raw/*11.44*/("""</div>
				""")))})),format.raw/*12.6*/("""
			</div>
		</div>
		<div class="col-sm-4">
			<div class="form-group """),_display_(Seq[Any](/*16.28*/if(departamentoForm.error("parent_departamento.id") != null)/*16.88*/{_display_(Seq[Any](format.raw/*16.89*/("""has-error""")))}/*16.99*/else/*16.103*/{_display_(Seq[Any](format.raw/*16.104*/("""has-required""")))})),format.raw/*16.117*/("""">
				<label for="inputDeparamento" class="control-label">Padre</label> 
				"""),_display_(Seq[Any](/*18.6*/inputText(departamentoForm("parent_departamento.nombre"),'class -> "form-control"))),format.raw/*18.88*/("""
				"""),_display_(Seq[Any](/*19.6*/inputText(departamentoForm("parent_departamento.id"),'hidden -> "hidden"))),format.raw/*19.79*/("""
				"""),_display_(Seq[Any](/*20.6*/departamentoForm("parent_departamento.id")/*20.48*/.error.map/*20.58*/{ error =>_display_(Seq[Any](format.raw/*20.68*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*21.31*/error/*21.36*/.message)),format.raw/*21.44*/("""</div>
				""")))})),format.raw/*22.6*/("""
			</div>
		</div>
		
		<div class="col-sm-2">
			<div class="checkbox">
				<label>
					Activo """),_display_(Seq[Any](/*29.14*/checkbox(departamentoForm("activo")))),format.raw/*29.50*/("""
				</label>
			</div> 
		</div>
	</div>
	"""))}
    }
    
    def render(departamentoForm:Form[Departamento]): play.api.templates.HtmlFormat.Appendable = apply(departamentoForm)
    
    def f:((Form[Departamento]) => play.api.templates.HtmlFormat.Appendable) = (departamentoForm) => apply(departamentoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:30 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/departamento/formDepartamento.scala.html
                    HASH: 295c650a380946d65494c502ba3817e530aa28d8
                    MATRIX: 815->1|955->58|987->82|1061->39|1089->126|1198->200|1250->244|1289->246|1317->256|1329->260|1367->261|1412->274|1521->349|1605->412|1646->418|1681->444|1700->454|1748->464|1815->495|1829->500|1859->508|1902->520|2010->592|2079->652|2118->653|2147->663|2161->667|2201->668|2247->681|2361->760|2465->842|2506->848|2601->921|2642->927|2693->969|2712->979|2760->989|2827->1020|2841->1025|2871->1033|2914->1045|3049->1144|3107->1180
                    LINES: 26->1|29->3|29->3|30->1|31->3|35->7|35->7|35->7|35->7|35->7|35->7|35->7|37->9|37->9|38->10|38->10|38->10|38->10|39->11|39->11|39->11|40->12|44->16|44->16|44->16|44->16|44->16|44->16|44->16|46->18|46->18|47->19|47->19|48->20|48->20|48->20|48->20|49->21|49->21|49->21|50->22|57->29|57->29
                    -- GENERATED --
                */
            