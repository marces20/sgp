
package views.html.haberes.unidadesLaborales

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
object verUnidadLaboral extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[models.haberes.UnidadLaboral],models.haberes.UnidadLaboral,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lcForm: Form[models.haberes.UnidadLaboral],lc:models.haberes.UnidadLaboral):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

def /*4.2*/scripts/*4.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*4.13*/("""
	<script src=""""),_display_(Seq[Any](/*5.16*/routes/*5.22*/.Assets.at("javascripts/haberes/unidadLaboral.js"))),format.raw/*5.72*/("""" type="text/javascript"></script>
""")))};implicit def /*7.2*/implicitFieldConstructor/*7.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.78*/("""
"""),format.raw/*6.2*/("""
"""),format.raw/*7.70*/(""" 

"""),_display_(Seq[Any](/*9.2*/views/*9.7*/.html.haberes.mainHaberes("Vista Unidad Laboral",scripts)/*9.64*/ {_display_(Seq[Any](format.raw/*9.66*/("""
	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Vista Tipo Unidad Laboral</h1>
			</div>
			<div class="col-sm-5">
				
			</div>
		</div>
	</div>		
	<div class="row menu-acciones">
		<div class="col-sm-10">
			<a href=""""),_display_(Seq[Any](/*22.14*/controllers/*22.25*/.haberes.routes.UnidadesLaboralesController.crear())),format.raw/*22.76*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo Unidad</a>
			<a href=""""),_display_(Seq[Any](/*23.14*/controllers/*23.25*/.haberes.routes.UnidadesLaboralesController.editar(lc.id))),_display_(Seq[Any](/*23.83*/UriTrack/*23.91*/.get("&"))),format.raw/*23.100*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-edit"></i> Editar</a>
			<a href=""""),_display_(Seq[Any](/*24.14*/controllers/*24.25*/.haberes.routes.UnidadesLaboralesController.eliminar(lc.id))),_display_(Seq[Any](/*24.85*/UriTrack/*24.93*/.get("&"))),format.raw/*24.102*/(""""  class="btn btn-default delete-confirm-link"><i class="glyphicon glyphicon-trash icono-eliminar"></i> Eliminar</a>
		</div>
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*27.14*/UriTrack/*27.22*/.getOnNull(controllers.haberes.routes.UnidadesLaboralesController.index().absoluteURL()))),format.raw/*27.110*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
		</div> 
	</div>	
	
	<input type="hidden" id="unidadId" name="unidadId" value=""""),_display_(Seq[Any](/*31.61*/lc/*31.63*/.id)),format.raw/*31.66*/(""""/>
	<div class="row">
		<div class="col-sm-5">
			<div class="form-group">
				<label class="control-label">Denominacion</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*36.50*/lcForm/*36.56*/.field("nombre").value)),format.raw/*36.78*/("""</p>
			</div>
		</div>
		 
		 
	</div>
	 
	 
	 
	 
	 
	
	 
""")))})))}
    }
    
    def render(lcForm:Form[models.haberes.UnidadLaboral],lc:models.haberes.UnidadLaboral): play.api.templates.HtmlFormat.Appendable = apply(lcForm,lc)
    
    def f:((Form[models.haberes.UnidadLaboral],models.haberes.UnidadLaboral) => play.api.templates.HtmlFormat.Appendable) = (lcForm,lc) => apply(lcForm,lc)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/unidadesLaborales/verUnidadLaboral.scala.html
                    HASH: f721997eef79fc3b48f60cc5b729c1d1d0023ee9
                    MATRIX: 868->1|1053->112|1067->119|1151->123|1202->139|1216->145|1287->195|1354->233|1386->257|1460->77|1487->231|1515->301|1553->305|1565->310|1630->367|1669->369|1960->624|1980->635|2053->686|2192->789|2212->800|2300->858|2317->866|2349->875|2477->967|2497->978|2587->1038|2604->1046|2636->1055|2836->1219|2853->1227|2964->1315|3153->1468|3164->1470|3189->1473|3404->1652|3419->1658|3463->1680
                    LINES: 26->1|31->4|31->4|33->4|34->5|34->5|34->5|35->7|35->7|36->1|37->6|38->7|40->9|40->9|40->9|40->9|53->22|53->22|53->22|54->23|54->23|54->23|54->23|54->23|55->24|55->24|55->24|55->24|55->24|58->27|58->27|58->27|62->31|62->31|62->31|67->36|67->36|67->36
                    -- GENERATED --
                */
            