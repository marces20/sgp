
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
object crearTipoProducto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[TipoProducto],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(tipoProductoForm: Form[TipoProducto]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.40*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/views/*4.7*/.html.compras.mainCompras("Crear Tipo Producto")/*4.55*/ {_display_(Seq[Any](format.raw/*4.57*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Crear nuevo Tipo Producto</h1>
			</div>
			
			<div class="col-sm-2">
				<a href=""""),_display_(Seq[Any](/*13.15*/controllers/*13.26*/.compras.routes.TipoProductosController.indexTipoProducto())),format.raw/*13.85*/("""" class="btn btn-default">
					<i class="glyphicon glyphicon-list"></i>
				</a> 
				<a href="#" class="btn btn-default"><i class="glyphicon glyphicon-align-justify"></i></a> 
			</div>
		</div>
	</div>
	"""),_display_(Seq[Any](/*20.3*/if(flash.containsKey("error"))/*20.33*/ {_display_(Seq[Any](format.raw/*20.35*/("""
		<div class="alert alert-danger">
			"""),_display_(Seq[Any](/*22.5*/flash/*22.10*/.get("error"))),format.raw/*22.23*/("""
		</div>
    """)))})),format.raw/*24.6*/("""
    
    """),_display_(Seq[Any](/*26.6*/helper/*26.12*/.form(action = controllers.compras.routes.TipoProductosController.guardarTipoProducto())/*26.100*/ {_display_(Seq[Any](format.raw/*26.102*/("""
		"""),_display_(Seq[Any](/*27.4*/views/*27.9*/.html.compras.productos.formTipoProducto(tipoProductoForm))),format.raw/*27.67*/(""" 	
		<div class="row form-actions">
		    <div class="col-lg-offset-4 col-lg-8">
		      <a href=""""),_display_(Seq[Any](/*30.19*/controllers/*30.30*/.compras.routes.TipoProductosController.indexTipoProducto())),format.raw/*30.89*/("""" class="btn btn-default">Cancelar</a>
		      <button type="submit" class="btn btn-sistema">Guardar</button>
		    </div>
		</div>
	""")))})),format.raw/*34.3*/("""
""")))})))}
    }
    
    def render(tipoProductoForm:Form[TipoProducto]): play.api.templates.HtmlFormat.Appendable = apply(tipoProductoForm)
    
    def f:((Form[TipoProducto]) => play.api.templates.HtmlFormat.Appendable) = (tipoProductoForm) => apply(tipoProductoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:45 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/productos/crearTipoProducto.scala.html
                    HASH: 091092ffd05c288e155dfe498a011d5881da8b18
                    MATRIX: 816->1|964->39|991->57|1027->59|1039->64|1095->112|1134->114|1339->283|1359->294|1440->353|1682->560|1721->590|1761->592|1836->632|1850->637|1885->650|1931->665|1977->676|1992->682|2090->770|2131->772|2170->776|2183->781|2263->839|2398->938|2418->949|2499->1008|2664->1142
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|32->4|41->13|41->13|41->13|48->20|48->20|48->20|50->22|50->22|50->22|52->24|54->26|54->26|54->26|54->26|55->27|55->27|55->27|58->30|58->30|58->30|62->34
                    -- GENERATED --
                */
            