
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
object editarTipoProducto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[TipoProducto],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(tipoProductoForm: Form[TipoProducto]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.40*/("""
"""),format.raw/*3.70*/("""

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.compras.mainCompras("Modificar Tipo Producto")/*5.59*/ {_display_(Seq[Any](format.raw/*5.61*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Editar Tipo Producto</h1>
			</div>
			
			<div class="col-sm-2">
				<a href=""""),_display_(Seq[Any](/*14.15*/controllers/*14.26*/.compras.routes.TipoProductosController.indexTipoProducto())),format.raw/*14.85*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
				<a href="#" class="btn btn-default"><i class="glyphicon glyphicon-align-justify"></i></a> 
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*20.3*/if(flash.containsKey("error"))/*20.33*/ {_display_(Seq[Any](format.raw/*20.35*/("""
		<div class="alert alert-danger">
			"""),_display_(Seq[Any](/*22.5*/flash/*22.10*/.get("error"))),format.raw/*22.23*/("""
		</div>
	""")))})),format.raw/*24.3*/("""
	
	"""),_display_(Seq[Any](/*26.3*/helper/*26.9*/.form(action = controllers.compras.routes.TipoProductosController.actualizarTipoProducto())/*26.100*/ {_display_(Seq[Any](format.raw/*26.102*/("""
		"""),_display_(Seq[Any](/*27.4*/inputText(tipoProductoForm("id"), 'hidden -> "hidden"))),format.raw/*27.58*/("""
		"""),_display_(Seq[Any](/*28.4*/views/*28.9*/.html.compras.productos.formTipoProducto(tipoProductoForm))),format.raw/*28.67*/("""
		<div class="row form-actions">
		    <div class="col-lg-offset-4 col-lg-8">
		      <a href=""""),_display_(Seq[Any](/*31.19*/controllers/*31.30*/.compras.routes.TipoProductosController.indexTipoProducto())),format.raw/*31.89*/("""" class="btn btn-default">Cancelar</a>
		      <button type="submit" class="btn btn-sistema">Editar</button>
		    </div>
		</div>
	""")))})),format.raw/*35.3*/("""

""")))})))}
    }
    
    def render(tipoProductoForm:Form[TipoProducto]): play.api.templates.HtmlFormat.Appendable = apply(tipoProductoForm)
    
    def f:((Form[TipoProducto]) => play.api.templates.HtmlFormat.Appendable) = (tipoProductoForm) => apply(tipoProductoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:45 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/productos/editarTipoProducto.scala.html
                    HASH: 89ff28862dd88620d0999eba3f9f9b19195340e3
                    MATRIX: 817->1|957->58|989->82|1063->39|1091->126|1128->129|1140->134|1200->186|1239->188|1439->352|1459->363|1540->422|1773->620|1812->650|1852->652|1927->692|1941->697|1976->710|2019->722|2059->727|2073->733|2174->824|2215->826|2254->830|2330->884|2369->888|2382->893|2462->951|2595->1048|2615->1059|2696->1118|2860->1251
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|42->14|42->14|42->14|48->20|48->20|48->20|50->22|50->22|50->22|52->24|54->26|54->26|54->26|54->26|55->27|55->27|56->28|56->28|56->28|59->31|59->31|59->31|63->35
                    -- GENERATED --
                */
            