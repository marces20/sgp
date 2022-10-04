
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
object editarCategoria extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Categoria],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(categoriaForm: Form[Categoria]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.34*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.compras.mainCompras("Modificar Categoria")/*5.55*/ {_display_(Seq[Any](format.raw/*5.57*/("""
<div class="page-header">
	<div class="row">
		<div class="col-sm-10">
			<h1>Editar Categoria</h1>
		</div>
		
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*13.14*/controllers/*13.25*/.compras.routes.CategoriasController.indexCategoria())),format.raw/*13.78*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
			<a href="#" class="btn btn-default"><i class="glyphicon glyphicon-align-justify"></i></a> 
		</div>
	</div>
</div>

"""),_display_(Seq[Any](/*19.2*/if(flash.containsKey("error"))/*19.32*/ {_display_(Seq[Any](format.raw/*19.34*/("""
	<div class="alert alert-danger">
		"""),_display_(Seq[Any](/*21.4*/flash/*21.9*/.get("error"))),format.raw/*21.22*/("""
	</div>
""")))})),format.raw/*23.2*/("""

"""),_display_(Seq[Any](/*25.2*/helper/*25.8*/.form(action = controllers.compras.routes.CategoriasController.actualizarCategoria())/*25.93*/ {_display_(Seq[Any](format.raw/*25.95*/("""
	"""),_display_(Seq[Any](/*26.3*/inputText(categoriaForm("id"), 'hidden -> "hidden"))),format.raw/*26.54*/("""
	"""),_display_(Seq[Any](/*27.3*/views/*27.8*/.html.compras.productos.formCategoria(categoriaForm))),format.raw/*27.60*/("""
	<div class="row form-actions">
	    <div class="col-lg-offset-4 col-lg-8">
	      <a href=""""),_display_(Seq[Any](/*30.18*/controllers/*30.29*/.compras.routes.CategoriasController.indexCategoria())),format.raw/*30.82*/("""" class="btn btn-default">Cancelar</a>
	      <button type="submit" class="btn btn-sistema">Editar</button>
	    </div>
	</div>
""")))})),format.raw/*34.2*/("""

""")))})))}
    }
    
    def render(categoriaForm:Form[Categoria]): play.api.templates.HtmlFormat.Appendable = apply(categoriaForm)
    
    def f:((Form[Categoria]) => play.api.templates.HtmlFormat.Appendable) = (categoriaForm) => apply(categoriaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:45 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/productos/editarCategoria.scala.html
                    HASH: fcb45ace820a0bc8e13189a42a0118a52242c604
                    MATRIX: 811->1|945->52|977->76|1051->33|1079->120|1117->124|1129->129|1185->177|1224->179|1411->330|1431->341|1506->394|1733->586|1772->616|1812->618|1885->656|1898->661|1933->674|1974->684|2012->687|2026->693|2120->778|2160->780|2198->783|2271->834|2309->837|2322->842|2396->894|2526->988|2546->999|2621->1052|2781->1181
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|41->13|41->13|41->13|47->19|47->19|47->19|49->21|49->21|49->21|51->23|53->25|53->25|53->25|53->25|54->26|54->26|55->27|55->27|55->27|58->30|58->30|58->30|62->34
                    -- GENERATED --
                */
            