
package views.html.administracion.grupos

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
object crearGrupo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Grupo],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(grupoForm: Form[Grupo]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.26*/("""
"""),format.raw/*3.70*/(""" 
"""),_display_(Seq[Any](/*4.2*/views/*4.7*/.html.administracion.mainAdministracion("Crear grupo")/*4.61*/ {_display_(Seq[Any](format.raw/*4.63*/("""

<div class="page-header">
	<div class="row">
		<div class="col-sm-10">
			<h1>Crear nuevo grupo</h1>
		</div>
		
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*13.14*/controllers/*13.25*/.administracion.routes.GruposController.index())),format.raw/*13.72*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
			<a href="#" class="btn btn-default"><i class="glyphicon glyphicon-align-justify"></i></a> 
		</div>
	</div>
</div>

    """),_display_(Seq[Any](/*19.6*/if(flash.containsKey("error"))/*19.36*/ {_display_(Seq[Any](format.raw/*19.38*/("""
		<div class="alert alert-danger">
			<i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*21.53*/flash/*21.58*/.get("error"))),format.raw/*21.71*/("""
		</div>
    """)))})),format.raw/*23.6*/("""

"""),_display_(Seq[Any](/*25.2*/helper/*25.8*/.form(action = controllers.administracion.routes.GruposController.guardar())/*25.84*/ {_display_(Seq[Any](format.raw/*25.86*/("""
	"""),_display_(Seq[Any](/*26.3*/views/*26.8*/.html.administracion.grupos.form(grupoForm))),format.raw/*26.51*/("""
	
<div class="row form-actions">
    <div class="col-lg-offset-4 col-lg-8">
      <a href="" class="btn btn-default">Cancelar</a>
      <button type="submit" class="btn btn-sistema">Crear</button>
    </div>
</div>
	
""")))})),format.raw/*35.2*/("""

""")))})),format.raw/*37.2*/("""
"""))}
    }
    
    def render(grupoForm:Form[Grupo]): play.api.templates.HtmlFormat.Appendable = apply(grupoForm)
    
    def f:((Form[Grupo]) => play.api.templates.HtmlFormat.Appendable) = (grupoForm) => apply(grupoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/administracion/grupos/crearGrupo.scala.html
                    HASH: db00de65679ef7040f433aaf75e8ffe8055d5f8a
                    MATRIX: 806->1|933->46|965->70|1039->25|1068->114|1106->118|1118->123|1180->177|1219->179|1417->341|1437->352|1506->399|1743->601|1782->631|1822->633|1948->723|1962->728|1997->741|2045->758|2085->763|2099->769|2184->845|2224->847|2263->851|2276->856|2341->899|2600->1127|2636->1132
                    LINES: 26->1|29->3|29->3|30->1|31->3|32->4|32->4|32->4|32->4|41->13|41->13|41->13|47->19|47->19|47->19|49->21|49->21|49->21|51->23|53->25|53->25|53->25|53->25|54->26|54->26|54->26|63->35|65->37
                    -- GENERATED --
                */
            