
package views.html.haberes.novedades

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
object editarNovedades extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.haberes.Novedad],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(nForm: Form[models.haberes.Novedad]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

def /*5.2*/scripts/*5.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*5.13*/("""
	<script src=""""),_display_(Seq[Any](/*6.16*/routes/*6.22*/.Assets.at("javascripts/haberes/novedades.js"))),format.raw/*6.68*/("""" type="text/javascript"></script>
""")))};implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.39*/("""
"""),format.raw/*4.70*/(""" 
"""),format.raw/*7.2*/("""

"""),_display_(Seq[Any](/*9.2*/views/*9.7*/.html.haberes.mainHaberes("Editar novedades", scripts)/*9.61*/ {_display_(Seq[Any](format.raw/*9.63*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Editar novedades</h1>
			</div>
		</div>
	</div>
	"""),_display_(Seq[Any](/*18.3*/views/*18.8*/.html.tags.successError())),format.raw/*18.33*/("""
	
    """),_display_(Seq[Any](/*20.6*/helper/*20.12*/.form(action = controllers.haberes.routes.NovedadesController.actualizar(), 'id -> "formNovedades")/*20.111*/ {_display_(Seq[Any](format.raw/*20.113*/("""
	<div class="row menu-acciones">
		<div class="col-sm-10">
			<button type="submit" class="btn btn-default" title="Guardar novedad"><i class="glyphicon glyphicon-edit"></i> Editar</button>
			<a href=""""),_display_(Seq[Any](/*24.14*/UriTrack/*24.22*/.getOnNull(controllers.haberes.routes.NovedadesController.crear().absoluteURL()))),format.raw/*24.102*/("""" title="Cancelar" class="btn btn-default"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
		</div>
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*27.14*/UriTrack/*27.22*/.getOnNull(controllers.haberes.routes.NovedadesController.index().absoluteURL()))),format.raw/*27.102*/("""" title="Volver al listado" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
		</div>	
	</div>
    """),_display_(Seq[Any](/*30.6*/inputText(nForm("id"), 'hidden -> "hidden"))),format.raw/*30.49*/("""
		"""),_display_(Seq[Any](/*31.4*/views/*31.9*/.html.haberes.novedades.formNovedades(nForm))),format.raw/*31.53*/(""" 	
	""")))})),format.raw/*32.3*/("""
""")))})))}
    }
    
    def render(nForm:Form[models.haberes.Novedad]): play.api.templates.HtmlFormat.Appendable = apply(nForm)
    
    def f:((Form[models.haberes.Novedad]) => play.api.templates.HtmlFormat.Appendable) = (nForm) => apply(nForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:35 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/novedades/editarNovedades.scala.html
                    HASH: 5755cf65de17b6a516aa0fac87a92b7bf0b3fc0e
                    MATRIX: 824->1|972->148|986->155|1070->159|1122->176|1136->182|1203->228|1271->76|1303->100|1377->38|1406->144|1435->265|1474->270|1486->275|1548->329|1587->331|1766->475|1779->480|1826->505|1871->515|1886->521|1995->620|2036->622|2279->829|2296->837|2399->917|2591->1073|2608->1081|2711->1161|2870->1285|2935->1328|2975->1333|2988->1338|3054->1382|3091->1388
                    LINES: 26->1|31->5|31->5|33->5|34->6|34->6|34->6|35->4|35->4|36->1|37->4|38->7|40->9|40->9|40->9|40->9|49->18|49->18|49->18|51->20|51->20|51->20|51->20|55->24|55->24|55->24|58->27|58->27|58->27|61->30|61->30|62->31|62->31|62->31|63->32
                    -- GENERATED --
                */
            