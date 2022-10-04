
package views.html.contabilidad.sucursalbancos

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
object crearSucursalBanco extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[SucursalBanco],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(sucursalBancoForm: Form[SucursalBanco]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.42*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/views/*4.7*/.html.contabilidad.mainContabilidad("Crear sucursal de banco")/*4.69*/ {_display_(Seq[Any](format.raw/*4.71*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Crear nueva sucursal</h1>
			</div>
			
			<div class="col-sm-2">
				<a href=""""),_display_(Seq[Any](/*13.15*/controllers/*13.26*/.contabilidad.routes.SucursalBancosController.indexSucursalBanco())),format.raw/*13.92*/("""" class="btn btn-default">
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
    
    """),_display_(Seq[Any](/*26.6*/helper/*26.12*/.form(action = controllers.contabilidad.routes.SucursalBancosController.guardarSucursalBanco())/*26.107*/ {_display_(Seq[Any](format.raw/*26.109*/("""
		"""),_display_(Seq[Any](/*27.4*/views/*27.9*/.html.contabilidad.sucursalbancos.formSucursalBanco(sucursalBancoForm))),format.raw/*27.79*/(""" 	
		<div class="row form-actions">
		    <div class="col-lg-offset-4 col-lg-8">
		      <a href=""""),_display_(Seq[Any](/*30.19*/controllers/*30.30*/.contabilidad.routes.SucursalBancosController.indexSucursalBanco())),format.raw/*30.96*/("""" class="btn btn-default">Cancelar</a>
		      <button type="submit" class="btn btn-sistema">Guardar</button>
		    </div>
		</div>
	""")))})),format.raw/*34.3*/("""
""")))})))}
    }
    
    def render(sucursalBancoForm:Form[SucursalBanco]): play.api.templates.HtmlFormat.Appendable = apply(sucursalBancoForm)
    
    def f:((Form[SucursalBanco]) => play.api.templates.HtmlFormat.Appendable) = (sucursalBancoForm) => apply(sucursalBancoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:38 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/sucursalbancos/crearSucursalBanco.scala.html
                    HASH: 2005207a84b23c49510dab54a3b34a37701685fb
                    MATRIX: 828->1|978->41|1005->59|1041->61|1053->66|1123->128|1162->130|1362->294|1382->305|1470->371|1712->578|1751->608|1791->610|1866->650|1880->655|1915->668|1961->683|2007->694|2022->700|2127->795|2168->797|2207->801|2220->806|2312->876|2447->975|2467->986|2555->1052|2720->1186
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|32->4|41->13|41->13|41->13|48->20|48->20|48->20|50->22|50->22|50->22|52->24|54->26|54->26|54->26|54->26|55->27|55->27|55->27|58->30|58->30|58->30|62->34
                    -- GENERATED --
                */
            