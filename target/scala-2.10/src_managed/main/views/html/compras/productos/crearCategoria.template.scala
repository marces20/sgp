
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
object crearCategoria extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Categoria],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(categoriaForm: Form[Categoria]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.34*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/views/*4.7*/.html.compras.mainCompras("Crear Categoria")/*4.51*/ {_display_(Seq[Any](format.raw/*4.53*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Crear nueva categoria</h1>
			</div>
			
			<div class="col-sm-2">
				<a href=""""),_display_(Seq[Any](/*13.15*/controllers/*13.26*/.compras.routes.CategoriasController.indexCategoria())),format.raw/*13.79*/("""" class="btn btn-default">
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
	
	"""),_display_(Seq[Any](/*26.3*/helper/*26.9*/.form(action = controllers.compras.routes.CategoriasController.guardarCategoria())/*26.91*/ {_display_(Seq[Any](format.raw/*26.93*/("""
		"""),_display_(Seq[Any](/*27.4*/views/*27.9*/.html.compras.productos.formCategoria(categoriaForm))),format.raw/*27.61*/(""" 	
		<div class="row form-actions">
		    <div class="col-lg-offset-4 col-lg-8">
		      <a href="" class="btn btn-default">Cancelar</a>
		      <button type="submit" class="btn btn-sistema">Guardar</button>
		    </div>
		</div>
	""")))})),format.raw/*34.3*/("""
	


""")))})))}
    }
    
    def render(categoriaForm:Form[Categoria]): play.api.templates.HtmlFormat.Appendable = apply(categoriaForm)
    
    def f:((Form[Categoria]) => play.api.templates.HtmlFormat.Appendable) = (categoriaForm) => apply(categoriaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:45 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/productos/crearCategoria.scala.html
                    HASH: afb4acfd6fc5510974d9daec83237dd2af4297da
                    MATRIX: 810->1|952->33|979->51|1015->53|1027->58|1079->102|1118->104|1319->269|1339->280|1414->333|1656->540|1695->570|1735->572|1810->612|1824->617|1859->630|1905->645|1946->651|1960->657|2051->739|2091->741|2130->745|2143->750|2217->802|2480->1034
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|32->4|41->13|41->13|41->13|48->20|48->20|48->20|50->22|50->22|50->22|52->24|54->26|54->26|54->26|54->26|55->27|55->27|55->27|62->34
                    -- GENERATED --
                */
            