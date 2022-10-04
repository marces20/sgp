
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
object crearProducto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[Producto],List[Integer],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(productoForm: Form[Producto],productoDepositoArray:List[Integer]=null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.73*/("""
"""),format.raw/*3.1*/("""

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.compras.mainCompras("Crear Productos")/*5.51*/ {_display_(Seq[Any](format.raw/*5.53*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Crear nuevo producto</h1>
			</div>
			
			<div class="col-sm-2">
				<a href=""""),_display_(Seq[Any](/*14.15*/controllers/*14.26*/.compras.routes.ProductosController.indexProducto())),format.raw/*14.77*/("""" class="btn btn-default">
					<i class="glyphicon glyphicon-list"></i>
				</a> 
				<a href="#" class="btn btn-default"><i class="glyphicon glyphicon-align-justify"></i></a> 
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*22.3*/views/*22.8*/.html.tags.successError())),format.raw/*22.33*/("""
    
    """),_display_(Seq[Any](/*24.6*/helper/*24.12*/.form(action = controllers.compras.routes.ProductosController.guardarProducto())/*24.92*/ {_display_(Seq[Any](format.raw/*24.94*/("""
		"""),_display_(Seq[Any](/*25.4*/views/*25.9*/.html.compras.productos.formProducto(productoForm,true,productoDepositoArray))),format.raw/*25.86*/("""
		<div class="row form-actions">
		    <div class="col-lg-offset-4 col-lg-8">
		      <a href="" class="btn btn-default">Cancelar</a>
		      <button type="submit" class="btn btn-sistema">Guardar</button>
		    </div>
		</div>
	""")))})),format.raw/*32.3*/("""

""")))})))}
    }
    
    def render(productoForm:Form[Producto],productoDepositoArray:List[Integer]): play.api.templates.HtmlFormat.Appendable = apply(productoForm,productoDepositoArray)
    
    def f:((Form[Producto],List[Integer]) => play.api.templates.HtmlFormat.Appendable) = (productoForm,productoDepositoArray) => apply(productoForm,productoDepositoArray)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:44 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/productos/crearProducto.scala.html
                    HASH: b899046566d0b0d39b348456d134493db7182173
                    MATRIX: 822->1|1003->72|1030->90|1067->93|1079->98|1131->142|1170->144|1370->308|1390->319|1463->370|1707->579|1720->584|1767->609|1813->620|1828->626|1917->706|1957->708|1996->712|2009->717|2108->794|2369->1024
                    LINES: 26->1|30->1|31->3|33->5|33->5|33->5|33->5|42->14|42->14|42->14|50->22|50->22|50->22|52->24|52->24|52->24|52->24|53->25|53->25|53->25|60->32
                    -- GENERATED --
                */
            