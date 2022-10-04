
package views.html.contabilidad.ejercicios

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
object crearEjercicio extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Ejercicio],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(ejercicioForm: Form[Ejercicio]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.34*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/views/*4.7*/.html.contabilidad.mainContabilidad("Crear Ejercicio")/*4.61*/ {_display_(Seq[Any](format.raw/*4.63*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Crear nuevo Ejercicio</h1>
			</div>
			
			<div class="col-sm-2">
				<a href=""""),_display_(Seq[Any](/*13.15*/controllers/*13.26*/.contabilidad.routes.EjerciciosController.indexEjercicio())),format.raw/*13.84*/("""" class="btn btn-default">
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
    
    """),_display_(Seq[Any](/*26.6*/helper/*26.12*/.form(action = controllers.contabilidad.routes.EjerciciosController.guardarEjercicio())/*26.99*/ {_display_(Seq[Any](format.raw/*26.101*/("""
		"""),_display_(Seq[Any](/*27.4*/views/*27.9*/.html.contabilidad.ejercicios.formEjercicio(ejercicioForm))),format.raw/*27.67*/("""
		<div class="row form-actions">
		    <div class="col-lg-offset-4 col-lg-8">
		      <a href=""""),_display_(Seq[Any](/*30.19*/controllers/*30.30*/.contabilidad.routes.EjerciciosController.indexEjercicio())),format.raw/*30.88*/("""" class="btn btn-default">Cancelar</a>
		      <button type="submit" class="btn btn-sistema">Guardar</button>
		    </div>
		</div>
	""")))})),format.raw/*34.3*/("""
""")))})),format.raw/*35.2*/("""	"""))}
    }
    
    def render(ejercicioForm:Form[Ejercicio]): play.api.templates.HtmlFormat.Appendable = apply(ejercicioForm)
    
    def f:((Form[Ejercicio]) => play.api.templates.HtmlFormat.Appendable) = (ejercicioForm) => apply(ejercicioForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:41 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/ejercicios/crearEjercicio.scala.html
                    HASH: c8cf823b80e4b4dc19e520a0c8030da5ff1c165b
                    MATRIX: 816->1|958->33|985->51|1021->53|1033->58|1095->112|1134->114|1335->279|1355->290|1435->348|1677->555|1716->585|1756->587|1831->627|1845->632|1880->645|1926->660|1972->671|1987->677|2083->764|2124->766|2163->770|2176->775|2256->833|2389->930|2409->941|2489->999|2654->1133|2687->1135
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|32->4|41->13|41->13|41->13|48->20|48->20|48->20|50->22|50->22|50->22|52->24|54->26|54->26|54->26|54->26|55->27|55->27|55->27|58->30|58->30|58->30|62->34|63->35
                    -- GENERATED --
                */
            