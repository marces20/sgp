
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
object formCategoria extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Categoria],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(categoriaForm: Form[Categoria]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.34*/("""
"""),format.raw/*3.70*/(""" 

	<div class="row">
		<div class="col-sm-4">
			<div class="form-group """),_display_(Seq[Any](/*7.28*/if(categoriaForm.error("nombre") != null)/*7.69*/ {_display_(Seq[Any](format.raw/*7.71*/("""has-error""")))}/*7.81*/else/*7.85*/{_display_(Seq[Any](format.raw/*7.86*/("""has-required""")))})),format.raw/*7.99*/("""">
				<label for="inputNombre" class="control-label">Nombre</label> 
				"""),_display_(Seq[Any](/*9.6*/inputText(categoriaForm("nombre"), 'class -> "form-control"))),format.raw/*9.66*/("""
				"""),_display_(Seq[Any](/*10.6*/categoriaForm("nombre")/*10.29*/.error.map/*10.39*/{ error =>_display_(Seq[Any](format.raw/*10.49*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*11.31*/error/*11.36*/.message)),format.raw/*11.44*/("""</div>
				""")))})),format.raw/*12.6*/("""
			</div>
		</div>
		<div class="col-sm-4">
			<div class="form-group """),_display_(Seq[Any](/*16.28*/if(categoriaForm.error("parent_categoria.id") != null)/*16.82*/ {_display_(Seq[Any](format.raw/*16.84*/("""has-error""")))}/*16.94*/else/*16.98*/{_display_(Seq[Any](format.raw/*16.99*/("""has-required""")))})),format.raw/*16.112*/("""">
				<label for="inputCategoria" class="control-label">Categor&iacute;a Padre</label> 
				"""),_display_(Seq[Any](/*18.6*/inputText(categoriaForm("parent_categoria.nombre"),'class -> "form-control"))),format.raw/*18.82*/("""
				"""),_display_(Seq[Any](/*19.6*/inputText(categoriaForm("parent_categoria.id"),'hidden -> "hidden"))),format.raw/*19.73*/("""
				"""),_display_(Seq[Any](/*20.6*/categoriaForm("parent_categoria.id")/*20.42*/.error.map/*20.52*/{ error =>_display_(Seq[Any](format.raw/*20.62*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*21.31*/error/*21.36*/.message)),format.raw/*21.44*/("""</div>
				""")))})),format.raw/*22.6*/("""
			</div>
		</div>
	</div>
	
	"""))}
    }
    
    def render(categoriaForm:Form[Categoria]): play.api.templates.HtmlFormat.Appendable = apply(categoriaForm)
    
    def f:((Form[Categoria]) => play.api.templates.HtmlFormat.Appendable) = (categoriaForm) => apply(categoriaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:45 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/productos/formCategoria.scala.html
                    HASH: cd558d4fb8442a386025131fd37a107cf05cadb2
                    MATRIX: 809->1|943->52|975->76|1049->33|1077->120|1186->194|1235->235|1274->237|1302->247|1314->251|1352->252|1396->265|1505->340|1586->400|1627->406|1659->429|1678->439|1726->449|1793->480|1807->485|1837->493|1880->505|1988->577|2051->631|2091->633|2120->643|2133->647|2172->648|2218->661|2347->755|2445->831|2486->837|2575->904|2616->910|2661->946|2680->956|2728->966|2795->997|2809->1002|2839->1010|2882->1022
                    LINES: 26->1|29->3|29->3|30->1|31->3|35->7|35->7|35->7|35->7|35->7|35->7|35->7|37->9|37->9|38->10|38->10|38->10|38->10|39->11|39->11|39->11|40->12|44->16|44->16|44->16|44->16|44->16|44->16|44->16|46->18|46->18|47->19|47->19|48->20|48->20|48->20|48->20|49->21|49->21|49->21|50->22
                    -- GENERATED --
                */
            