
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
object editarCategoriaLaboral extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.haberes.CategoriaLaboral],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(categoriaForm: Form[models.haberes.CategoriaLaboral]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.56*/("""
"""),format.raw/*3.70*/("""

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.haberes.mainHaberes("Modificar Categoria Laboral")/*5.63*/ {_display_(Seq[Any](format.raw/*5.65*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Editar Categoria laboral</h1>
			</div>
			
			<div class="col-sm-2">
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*18.3*/views/*18.8*/.html.tags.successError())),format.raw/*18.33*/("""
	
	"""),_display_(Seq[Any](/*20.3*/helper/*20.9*/.form(action = controllers.haberes.routes.CategoriasLaboralesController.actualizar())/*20.94*/ {_display_(Seq[Any](format.raw/*20.96*/("""
		"""),_display_(Seq[Any](/*21.4*/inputText(categoriaForm("id"), 'hidden -> "hidden"))),format.raw/*21.55*/("""
		"""),_display_(Seq[Any](/*22.4*/views/*22.9*/.html.haberes.categoriasLaborales.formCategoriaLaboral(categoriaForm))),format.raw/*22.78*/("""
	""")))})),format.raw/*23.3*/("""

""")))})))}
    }
    
    def render(categoriaForm:Form[models.haberes.CategoriaLaboral]): play.api.templates.HtmlFormat.Appendable = apply(categoriaForm)
    
    def f:((Form[models.haberes.CategoriaLaboral]) => play.api.templates.HtmlFormat.Appendable) = (categoriaForm) => apply(categoriaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/categoriasLaborales/editarCategoriaLaboral.scala.html
                    HASH: b4ab8ed96cea9e2526042aea65eb6642212ea774
                    MATRIX: 850->1|1006->74|1038->98|1112->55|1140->142|1177->145|1189->150|1253->206|1292->208|1512->393|1525->398|1572->423|1612->428|1626->434|1720->519|1760->521|1799->525|1872->576|1911->580|1924->585|2015->654|2049->657
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|46->18|46->18|46->18|48->20|48->20|48->20|48->20|49->21|49->21|50->22|50->22|50->22|51->23
                    -- GENERATED --
                */
            