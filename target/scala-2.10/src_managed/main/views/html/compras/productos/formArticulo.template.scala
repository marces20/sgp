
package views.html.compras.productos

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
object formArticulo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Articulo],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(articuloForm: Form[Articulo]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.32*/("""
"""),format.raw/*3.70*/(""" 

	<div class="row">
		<div class="col-sm-4">
			<div class="form-group """),_display_(Seq[Any](/*7.28*/if(articuloForm.error("nombre") != null)/*7.68*/ {_display_(Seq[Any](format.raw/*7.70*/("""has-error""")))}/*7.80*/else/*7.84*/{_display_(Seq[Any](format.raw/*7.85*/("""has-required""")))})),format.raw/*7.98*/("""">
				<label for="inputNombre" class="control-label">Nombre</label> 
				"""),_display_(Seq[Any](/*9.6*/inputText(articuloForm("nombre"), 'class -> "form-control"))),format.raw/*9.65*/("""
				"""),_display_(Seq[Any](/*10.6*/articuloForm("nombre")/*10.28*/.error.map/*10.38*/{ error =>_display_(Seq[Any](format.raw/*10.48*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*11.31*/error/*11.36*/.message)),format.raw/*11.44*/("""</div>
				""")))})),format.raw/*12.6*/("""
			</div>
		</div>
	</div>"""))}
    }
    
    def render(articuloForm:Form[Articulo]): play.api.templates.HtmlFormat.Appendable = apply(articuloForm)
    
    def f:((Form[Articulo]) => play.api.templates.HtmlFormat.Appendable) = (articuloForm) => apply(articuloForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:45 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/productos/formArticulo.scala.html
                    HASH: 35a8903b6c3527e37eaf661724fc049ed0d8490d
                    MATRIX: 807->1|939->50|971->74|1045->31|1073->118|1182->192|1230->232|1269->234|1297->244|1309->248|1347->249|1391->262|1500->337|1580->396|1621->402|1652->424|1671->434|1719->444|1786->475|1800->480|1830->488|1873->500
                    LINES: 26->1|29->3|29->3|30->1|31->3|35->7|35->7|35->7|35->7|35->7|35->7|35->7|37->9|37->9|38->10|38->10|38->10|38->10|39->11|39->11|39->11|40->12
                    -- GENERATED --
                */
            