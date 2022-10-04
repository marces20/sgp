
package views.html.haberes.categoriasLaborales

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
object crearCategoriaLaboral extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.haberes.CategoriaLaboral],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(categoriaForm: Form[models.haberes.CategoriaLaboral]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.56*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/views/*4.7*/.html.haberes.mainHaberes("Crear Categoria Laboral")/*4.59*/ {_display_(Seq[Any](format.raw/*4.61*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Crear nueva Categoria</h1>
			</div>
		</div>
	</div>
	"""),_display_(Seq[Any](/*13.3*/views/*13.8*/.html.tags.successError())),format.raw/*13.33*/("""
    
    """),_display_(Seq[Any](/*15.6*/helper/*15.12*/.form(action = controllers.haberes.routes.CategoriasLaboralesController.guardar())/*15.94*/ {_display_(Seq[Any](format.raw/*15.96*/("""
		"""),_display_(Seq[Any](/*16.4*/views/*16.9*/.html.haberes.categoriasLaborales.formCategoriaLaboral(categoriaForm))),format.raw/*16.78*/(""" 	
	""")))})),format.raw/*17.3*/("""
""")))})))}
    }
    
    def render(categoriaForm:Form[models.haberes.CategoriaLaboral]): play.api.templates.HtmlFormat.Appendable = apply(categoriaForm)
    
    def f:((Form[models.haberes.CategoriaLaboral]) => play.api.templates.HtmlFormat.Appendable) = (categoriaForm) => apply(categoriaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/categoriasLaborales/crearCategoriaLaboral.scala.html
                    HASH: 590f4bf93d1f0f5b2b3dd04d069dd211d402474f
                    MATRIX: 849->1|1013->55|1040->73|1076->75|1088->80|1148->132|1187->134|1362->274|1375->279|1422->304|1468->315|1483->321|1574->403|1614->405|1653->409|1666->414|1757->483|1793->488
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|32->4|41->13|41->13|41->13|43->15|43->15|43->15|43->15|44->16|44->16|44->16|45->17
                    -- GENERATED --
                */
            