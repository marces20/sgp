
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
object editarProducto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Form[Producto],Boolean,List[Integer],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(productoForm: Form[Producto],editarNombre:Boolean,productoDepositoArray:List[Integer]=null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.94*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.compras.mainCompras("Modificar productos")/*5.55*/ {_display_(Seq[Any](format.raw/*5.57*/("""

<div class="page-header">
	<div class="row">
		<div class="col-sm-10">
			<h1>Editar Producto</h1>
		</div>
		
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*14.14*/controllers/*14.25*/.compras.routes.ProductosController.indexProducto())),format.raw/*14.76*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
			<a href="#" class="btn btn-default"><i class="glyphicon glyphicon-align-justify"></i></a> 
		</div>
	</div>
</div>

"""),_display_(Seq[Any](/*20.2*/views/*20.7*/.html.tags.successError())),format.raw/*20.32*/("""

"""),_display_(Seq[Any](/*22.2*/helper/*22.8*/.form(action = controllers.compras.routes.ProductosController.actualizarProducto())/*22.91*/ {_display_(Seq[Any](format.raw/*22.93*/("""
	"""),_display_(Seq[Any](/*23.3*/inputText(productoForm("id"), 'hidden -> "hidden"))),format.raw/*23.53*/("""
	"""),_display_(Seq[Any](/*24.3*/views/*24.8*/.html.compras.productos.formProducto(productoForm,editarNombre,productoDepositoArray))),format.raw/*24.93*/("""
	<div class="row form-actions">
	    <div class="col-lg-offset-4 col-lg-8">
	      <a href=""""),_display_(Seq[Any](/*27.18*/controllers/*27.29*/.compras.routes.ProductosController.indexProducto())),format.raw/*27.80*/("""" class="btn btn-default">Cancelar</a>
	      <button type="submit" class="btn btn-sistema">Editar</button>
	    </div>
	</div>
""")))})),format.raw/*31.2*/("""

""")))})))}
    }
    
    def render(productoForm:Form[Producto],editarNombre:Boolean,productoDepositoArray:List[Integer]): play.api.templates.HtmlFormat.Appendable = apply(productoForm,editarNombre,productoDepositoArray)
    
    def f:((Form[Producto],Boolean,List[Integer]) => play.api.templates.HtmlFormat.Appendable) = (productoForm,editarNombre,productoDepositoArray) => apply(productoForm,editarNombre,productoDepositoArray)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:45 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/productos/editarProducto.scala.html
                    HASH: 407d5d391bc6f7c2351e73709153ce8144b45674
                    MATRIX: 831->1|1025->112|1057->136|1131->93|1159->180|1197->184|1209->189|1265->237|1304->239|1491->390|1511->401|1584->452|1811->644|1824->649|1871->674|1909->677|1923->683|2015->766|2055->768|2093->771|2165->821|2203->824|2216->829|2323->914|2453->1008|2473->1019|2546->1070|2706->1199
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|42->14|42->14|42->14|48->20|48->20|48->20|50->22|50->22|50->22|50->22|51->23|51->23|52->24|52->24|52->24|55->27|55->27|55->27|59->31
                    -- GENERATED --
                */
            