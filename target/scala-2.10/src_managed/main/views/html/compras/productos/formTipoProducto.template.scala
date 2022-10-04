
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
object formTipoProducto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[TipoProducto],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(tipoProductoForm: Form[TipoProducto]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.40*/("""
"""),format.raw/*3.70*/(""" 

	<div class="row">
		<div class="col-sm-4">
			<div class="form-group """),_display_(Seq[Any](/*7.28*/if(tipoProductoForm.error("nombre") != null)/*7.72*/ {_display_(Seq[Any](format.raw/*7.74*/("""has-error""")))}/*7.84*/else/*7.88*/{_display_(Seq[Any](format.raw/*7.89*/("""has-required""")))})),format.raw/*7.102*/("""">
				<label for="inputNombre" class="control-label">Nombre</label> 
				"""),_display_(Seq[Any](/*9.6*/inputText(tipoProductoForm("nombre"), 'class -> "form-control"))),format.raw/*9.69*/("""
				"""),_display_(Seq[Any](/*10.6*/tipoProductoForm("nombre")/*10.32*/.error.map/*10.42*/{ error =>_display_(Seq[Any](format.raw/*10.52*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*11.31*/error/*11.36*/.message)),format.raw/*11.44*/("""</div>
				""")))})),format.raw/*12.6*/("""
			</div>
		</div>
	</div>"""))}
    }
    
    def render(tipoProductoForm:Form[TipoProducto]): play.api.templates.HtmlFormat.Appendable = apply(tipoProductoForm)
    
    def f:((Form[TipoProducto]) => play.api.templates.HtmlFormat.Appendable) = (tipoProductoForm) => apply(tipoProductoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:45 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/productos/formTipoProducto.scala.html
                    HASH: 1e3592496e873ee09f63d1b1fa88ab8fec95c471
                    MATRIX: 815->1|955->58|987->82|1061->39|1089->126|1198->200|1250->244|1289->246|1317->256|1329->260|1367->261|1412->274|1521->349|1605->412|1646->418|1681->444|1700->454|1748->464|1815->495|1829->500|1859->508|1902->520
                    LINES: 26->1|29->3|29->3|30->1|31->3|35->7|35->7|35->7|35->7|35->7|35->7|35->7|37->9|37->9|38->10|38->10|38->10|38->10|39->11|39->11|39->11|40->12
                    -- GENERATED --
                */
            