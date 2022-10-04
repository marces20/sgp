
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
object formCategoriaLaboral extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.haberes.CategoriaLaboral],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(categoriaForm: Form[models.haberes.CategoriaLaboral]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

import models.haberes._

implicit def /*6.2*/implicitFieldConstructor/*6.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.56*/("""
"""),format.raw/*6.70*/(""" 
	
	<div class="row menu-acciones">
		<div class="col-sm-10">
			<button type="submit" class="btn btn-default" title="Guardar categoria"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>
			<a href=""""),_display_(Seq[Any](/*11.14*/if(request().getHeader("referer"))/*11.48*/{_display_(Seq[Any](format.raw/*11.49*/(""" """),_display_(Seq[Any](/*11.51*/request()/*11.60*/.getHeader("referer"))),format.raw/*11.81*/(""" """)))}/*11.84*/else/*11.89*/{_display_(Seq[Any](_display_(Seq[Any](/*11.91*/controllers/*11.102*/.haberes.routes.CategoriasLaboralesController.index())),_display_(Seq[Any](/*11.156*/UriTrack/*11.164*/.decode()))))})),format.raw/*11.174*/("""" title="Cancelar editar" class="btn btn-default"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
		</div>
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*14.14*/UriTrack/*14.22*/.decode())),format.raw/*14.31*/("""" title="Volver al listado" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
		</div>	
	</div>
	<div class="row">
		 
		<div class="col-sm-5">
			<div class="form-group """),_display_(Seq[Any](/*20.28*/if(categoriaForm.error("nombre") != null)/*20.69*/ {_display_(Seq[Any](format.raw/*20.71*/("""has-error""")))}/*20.81*/else/*20.85*/{_display_(Seq[Any](format.raw/*20.86*/("""has-required""")))})),format.raw/*20.99*/("""">
				<label for="inputDenominacion" class="control-label">Denominacion</label> 
				"""),_display_(Seq[Any](/*22.6*/inputText(categoriaForm("nombre"), 'class -> "form-control"))),format.raw/*22.66*/("""
				"""),_display_(Seq[Any](/*23.6*/categoriaForm("nombre")/*23.29*/.error.map/*23.39*/{ error =>_display_(Seq[Any](format.raw/*23.49*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*24.31*/error/*24.36*/.message)),format.raw/*24.44*/("""</div>
				""")))})),format.raw/*25.6*/("""
			</div>
		</div>
		 
	</div>
	"""))}
    }
    
    def render(categoriaForm:Form[models.haberes.CategoriaLaboral]): play.api.templates.HtmlFormat.Appendable = apply(categoriaForm)
    
    def f:((Form[models.haberes.CategoriaLaboral]) => play.api.templates.HtmlFormat.Appendable) = (categoriaForm) => apply(categoriaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/categoriasLaborales/formCategoriaLaboral.scala.html
                    HASH: c46553d4a4025984cf5ee9aeec6a0954617a3a81
                    MATRIX: 848->1|1067->137|1099->161|1173->55|1201->205|1453->421|1496->455|1535->456|1573->458|1591->467|1634->488|1655->491|1668->496|1716->498|1737->509|1822->563|1840->571|1877->581|2073->741|2090->749|2121->758|2348->949|2398->990|2438->992|2467->1002|2480->1006|2519->1007|2564->1020|2686->1107|2768->1167|2809->1173|2841->1196|2860->1206|2908->1216|2975->1247|2989->1252|3019->1260|3062->1272
                    LINES: 26->1|35->6|35->6|36->1|37->6|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|45->14|45->14|45->14|51->20|51->20|51->20|51->20|51->20|51->20|51->20|53->22|53->22|54->23|54->23|54->23|54->23|55->24|55->24|55->24|56->25
                    -- GENERATED --
                */
            