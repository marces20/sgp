
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
object verCategoriaLaboral extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[models.haberes.CategoriaLaboral],models.haberes.CategoriaLaboral,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lcForm: Form[models.haberes.CategoriaLaboral],lc:models.haberes.CategoriaLaboral):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

def /*4.2*/scripts/*4.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*4.13*/("""
	<script src=""""),_display_(Seq[Any](/*5.16*/routes/*5.22*/.Assets.at("javascripts/haberes/categoriaLaboral.js"))),format.raw/*5.75*/("""" type="text/javascript"></script>
""")))};implicit def /*7.2*/implicitFieldConstructor/*7.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.84*/("""
"""),format.raw/*6.2*/("""
"""),format.raw/*7.70*/(""" 

"""),_display_(Seq[Any](/*9.2*/views/*9.7*/.html.haberes.mainHaberes("Vista Categoria Laboral",scripts)/*9.67*/ {_display_(Seq[Any](format.raw/*9.69*/("""
	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Vista Categoria Laboral</h1>
			</div>
			<div class="col-sm-5">
				
			</div>
		</div>
	</div>		
	<div class="row menu-acciones">
		<div class="col-sm-10">
			<a href=""""),_display_(Seq[Any](/*22.14*/controllers/*22.25*/.haberes.routes.CategoriasLaboralesController.crear())),format.raw/*22.78*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo Categoria</a>
			<a href=""""),_display_(Seq[Any](/*23.14*/controllers/*23.25*/.haberes.routes.CategoriasLaboralesController.editar(lc.id))),_display_(Seq[Any](/*23.85*/UriTrack/*23.93*/.get("&"))),format.raw/*23.102*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-edit"></i> Editar</a>
			<a href=""""),_display_(Seq[Any](/*24.14*/controllers/*24.25*/.haberes.routes.CategoriasLaboralesController.eliminar(lc.id))),_display_(Seq[Any](/*24.87*/UriTrack/*24.95*/.get("&"))),format.raw/*24.104*/(""""  class="btn btn-default delete-confirm-link"><i class="glyphicon glyphicon-trash icono-eliminar"></i> Eliminar</a>
		</div>
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*27.14*/UriTrack/*27.22*/.getOnNull(controllers.haberes.routes.CategoriasLaboralesController.index().absoluteURL()))),format.raw/*27.112*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
		</div> 
	</div>	
	
	<input type="hidden" id="categoriaId" name="categoriaId" value=""""),_display_(Seq[Any](/*31.67*/lc/*31.69*/.id)),format.raw/*31.72*/(""""/>
	<div class="row">
		
		 <div class="col-sm-5">
			<div class="form-group">
				<label class="control-label">Denominacion</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*37.50*/lcForm/*37.56*/.field("nombre").value)),format.raw/*37.78*/("""</p>
			</div>
		</div>
		 
	</div>
	 
	 
	 
	 
	 
	
	 
""")))})))}
    }
    
    def render(lcForm:Form[models.haberes.CategoriaLaboral],lc:models.haberes.CategoriaLaboral): play.api.templates.HtmlFormat.Appendable = apply(lcForm,lc)
    
    def f:((Form[models.haberes.CategoriaLaboral],models.haberes.CategoriaLaboral) => play.api.templates.HtmlFormat.Appendable) = (lcForm,lc) => apply(lcForm,lc)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/categoriasLaborales/verCategoriaLaboral.scala.html
                    HASH: b8d83989ff06117a8e70c3adfee25a5dfd975f70
                    MATRIX: 879->1|1070->118|1084->125|1168->129|1219->145|1233->151|1307->204|1374->242|1406->266|1480->83|1507->240|1535->310|1573->314|1585->319|1653->379|1692->381|1981->634|2001->645|2076->698|2218->804|2238->815|2328->875|2345->883|2377->892|2505->984|2525->995|2617->1057|2634->1065|2666->1074|2866->1238|2883->1246|2996->1336|3191->1495|3202->1497|3227->1500|3446->1683|3461->1689|3505->1711
                    LINES: 26->1|31->4|31->4|33->4|34->5|34->5|34->5|35->7|35->7|36->1|37->6|38->7|40->9|40->9|40->9|40->9|53->22|53->22|53->22|54->23|54->23|54->23|54->23|54->23|55->24|55->24|55->24|55->24|55->24|58->27|58->27|58->27|62->31|62->31|62->31|68->37|68->37|68->37
                    -- GENERATED --
                */
            