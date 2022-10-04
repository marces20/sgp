
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
object crearArticulo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Articulo],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(articuloForm: Form[Articulo]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.32*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/views/*4.7*/.html.compras.mainCompras("Crear Articulo")/*4.50*/ {_display_(Seq[Any](format.raw/*4.52*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Crear nuevo Articulo</h1>
			</div>
			
			<div class="col-sm-2">
				<a href=""""),_display_(Seq[Any](/*13.15*/controllers/*13.26*/.compras.routes.ArticulosController.indexArticulo())),format.raw/*13.77*/("""" class="btn btn-default">
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
    
    """),_display_(Seq[Any](/*26.6*/helper/*26.12*/.form(action = controllers.compras.routes.ArticulosController.guardarArticulo())/*26.92*/ {_display_(Seq[Any](format.raw/*26.94*/("""
		"""),_display_(Seq[Any](/*27.4*/views/*27.9*/.html.compras.productos.formArticulo(articuloForm))),format.raw/*27.59*/(""" 	
		<div class="row form-actions">
		    <div class="col-lg-offset-4 col-lg-8">
		      <a href=""""),_display_(Seq[Any](/*30.19*/controllers/*30.30*/.compras.routes.ArticulosController.indexArticulo())),format.raw/*30.81*/("""" class="btn btn-default">Cancelar</a>
		      <button type="submit" class="btn btn-sistema">Guardar</button>
		    </div>
		</div>
	""")))})),format.raw/*34.3*/("""
""")))})))}
    }
    
    def render(articuloForm:Form[Articulo]): play.api.templates.HtmlFormat.Appendable = apply(articuloForm)
    
    def f:((Form[Articulo]) => play.api.templates.HtmlFormat.Appendable) = (articuloForm) => apply(articuloForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:45 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/productos/crearArticulo.scala.html
                    HASH: 694fccbc86aa545964fc100567c5f15da6a54f0f
                    MATRIX: 808->1|948->31|975->49|1011->51|1023->56|1074->99|1113->101|1313->265|1333->276|1406->327|1648->534|1687->564|1727->566|1802->606|1816->611|1851->624|1897->639|1943->650|1958->656|2047->736|2087->738|2126->742|2139->747|2211->797|2346->896|2366->907|2439->958|2604->1092
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|32->4|41->13|41->13|41->13|48->20|48->20|48->20|50->22|50->22|50->22|52->24|54->26|54->26|54->26|54->26|55->27|55->27|55->27|58->30|58->30|58->30|62->34
                    -- GENERATED --
                */
            