
package views.html.rrhh.tipoResidencia

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
object crearTipoResidencia extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[TipoResidencia],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(tpForm: Form[TipoResidencia]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.32*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/views/*4.7*/.html.rrhh.mainRrhh("Crear Tipo Residencia")/*4.51*/ {_display_(Seq[Any](format.raw/*4.53*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Crear nuevo Tipo Residencia</h1>
			</div>
			
			<div class="col-sm-2">
				<a href=""""),_display_(Seq[Any](/*13.15*/controllers/*13.26*/.rrhh.routes.TipoResidenciasController.indexTipoResidencia())),format.raw/*13.86*/("""" class="btn btn-default">
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
    
    """),_display_(Seq[Any](/*26.6*/helper/*26.12*/.form(action = controllers.rrhh.routes.TipoResidenciasController.guardarTipoResidencia())/*26.101*/ {_display_(Seq[Any](format.raw/*26.103*/("""
		"""),_display_(Seq[Any](/*27.4*/views/*27.9*/.html.rrhh.tipoResidencia.formTipoResidencia(tpForm))),format.raw/*27.61*/("""
		<div class="row form-actions">
		    <div class="col-lg-offset-4 col-lg-8">
		      <a href=""""),_display_(Seq[Any](/*30.19*/controllers/*30.30*/.rrhh.routes.TipoResidenciasController.indexTipoResidencia())),format.raw/*30.90*/("""" class="btn btn-default">Cancelar</a>
		      <button type="submit" class="btn btn-sistema">Guardar</button>
		    </div>
		</div>
	""")))})),format.raw/*34.3*/("""
""")))})),format.raw/*35.2*/("""	"""))}
    }
    
    def render(tpForm:Form[TipoResidencia]): play.api.templates.HtmlFormat.Appendable = apply(tpForm)
    
    def f:((Form[TipoResidencia]) => play.api.templates.HtmlFormat.Appendable) = (tpForm) => apply(tpForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:29 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/tipoResidencia/crearTipoResidencia.scala.html
                    HASH: 2c8def709040e07fce7f94ca01560e90da935118
                    MATRIX: 822->1|962->31|989->49|1025->51|1037->56|1089->100|1128->102|1335->273|1355->284|1437->344|1679->551|1718->581|1758->583|1833->623|1847->628|1882->641|1928->656|1974->667|1989->673|2088->762|2129->764|2168->768|2181->773|2255->825|2388->922|2408->933|2490->993|2655->1127|2688->1129
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|32->4|41->13|41->13|41->13|48->20|48->20|48->20|50->22|50->22|50->22|52->24|54->26|54->26|54->26|54->26|55->27|55->27|55->27|58->30|58->30|58->30|62->34|63->35
                    -- GENERATED --
                */
            