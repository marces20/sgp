
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
object editarArticulo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Articulo],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(articuloForm: Form[Articulo]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.32*/("""
"""),format.raw/*3.70*/("""

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.compras.mainCompras("Modificar Articulo")/*5.54*/ {_display_(Seq[Any](format.raw/*5.56*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Editar Articulo</h1>
			</div>
			
			<div class="col-sm-2">
				<a href=""""),_display_(Seq[Any](/*14.15*/controllers/*14.26*/.compras.routes.ArticulosController.indexArticulo())),format.raw/*14.77*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
				<a href="#" class="btn btn-default"><i class="glyphicon glyphicon-align-justify"></i></a> 
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*20.3*/if(flash.containsKey("error"))/*20.33*/ {_display_(Seq[Any](format.raw/*20.35*/("""
		<div class="alert alert-danger">
			"""),_display_(Seq[Any](/*22.5*/flash/*22.10*/.get("error"))),format.raw/*22.23*/("""
		</div>
	""")))})),format.raw/*24.3*/("""
	
	"""),_display_(Seq[Any](/*26.3*/helper/*26.9*/.form(action = controllers.compras.routes.ArticulosController.actualizarArticulo())/*26.92*/ {_display_(Seq[Any](format.raw/*26.94*/("""
		"""),_display_(Seq[Any](/*27.4*/inputText(articuloForm("id"), 'hidden -> "hidden"))),format.raw/*27.54*/("""
		"""),_display_(Seq[Any](/*28.4*/views/*28.9*/.html.compras.productos.formArticulo(articuloForm))),format.raw/*28.59*/("""
		<div class="row form-actions">
		    <div class="col-lg-offset-4 col-lg-8">
		      <a href=""""),_display_(Seq[Any](/*31.19*/controllers/*31.30*/.compras.routes.ArticulosController.indexArticulo())),format.raw/*31.81*/("""" class="btn btn-default">Cancelar</a>
		      <button type="submit" class="btn btn-sistema">Editar</button>
		    </div>
		</div>
	""")))})),format.raw/*35.3*/("""

""")))})))}
    }
    
    def render(articuloForm:Form[Articulo]): play.api.templates.HtmlFormat.Appendable = apply(articuloForm)
    
    def f:((Form[Articulo]) => play.api.templates.HtmlFormat.Appendable) = (articuloForm) => apply(articuloForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:45 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/productos/editarArticulo.scala.html
                    HASH: 0735283e262ffc36543952ec1efc54ea8ee608a7
                    MATRIX: 809->1|941->50|973->74|1047->31|1075->118|1112->121|1124->126|1179->173|1218->175|1413->334|1433->345|1506->396|1739->594|1778->624|1818->626|1893->666|1907->671|1942->684|1985->696|2025->701|2039->707|2131->790|2171->792|2210->796|2282->846|2321->850|2334->855|2406->905|2539->1002|2559->1013|2632->1064|2796->1197
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|42->14|42->14|42->14|48->20|48->20|48->20|50->22|50->22|50->22|52->24|54->26|54->26|54->26|54->26|55->27|55->27|56->28|56->28|56->28|59->31|59->31|59->31|63->35
                    -- GENERATED --
                */
            