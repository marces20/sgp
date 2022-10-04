
package views.html.rrhh.departamento

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
object crearDepartamento extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Departamento],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(departamentoForm: Form[Departamento]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.40*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/views/*4.7*/.html.rrhh.mainRrhh("Crear Departamento")/*4.48*/ {_display_(Seq[Any](format.raw/*4.50*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Crear nuevo Departamento</h1>
			</div>
			
			<div class="col-sm-2">
				<a href=""""),_display_(Seq[Any](/*13.15*/controllers/*13.26*/.rrhh.routes.DepartamentosController.indexDepartamento())),format.raw/*13.82*/("""" class="btn btn-default">
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
    
    """),_display_(Seq[Any](/*26.6*/helper/*26.12*/.form(action = controllers.rrhh.routes.DepartamentosController.guardarDepartamento())/*26.97*/ {_display_(Seq[Any](format.raw/*26.99*/("""
		"""),_display_(Seq[Any](/*27.4*/views/*27.9*/.html.rrhh.departamento.formDepartamento(departamentoForm))),format.raw/*27.67*/("""
		<div class="row form-actions">
		    <div class="col-lg-offset-4 col-lg-8">
		      <a href=""""),_display_(Seq[Any](/*30.19*/controllers/*30.30*/.rrhh.routes.DepartamentosController.indexDepartamento())),format.raw/*30.86*/("""" class="btn btn-default">Cancelar</a>
		      <button type="submit" class="btn btn-sistema">Guardar</button>
		    </div>
		</div>
	""")))})),format.raw/*34.3*/("""
""")))})),format.raw/*35.2*/("""	"""))}
    }
    
    def render(departamentoForm:Form[Departamento]): play.api.templates.HtmlFormat.Appendable = apply(departamentoForm)
    
    def f:((Form[Departamento]) => play.api.templates.HtmlFormat.Appendable) = (departamentoForm) => apply(departamentoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:30 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/departamento/crearDepartamento.scala.html
                    HASH: 276bf18d3870d07b928ded9d87335f736988d4ee
                    MATRIX: 816->1|964->39|991->57|1027->59|1039->64|1088->105|1127->107|1331->275|1351->286|1429->342|1671->549|1710->579|1750->581|1825->621|1839->626|1874->639|1920->654|1966->665|1981->671|2075->756|2115->758|2154->762|2167->767|2247->825|2380->922|2400->933|2478->989|2643->1123|2676->1125
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|32->4|41->13|41->13|41->13|48->20|48->20|48->20|50->22|50->22|50->22|52->24|54->26|54->26|54->26|54->26|55->27|55->27|55->27|58->30|58->30|58->30|62->34|63->35
                    -- GENERATED --
                */
            