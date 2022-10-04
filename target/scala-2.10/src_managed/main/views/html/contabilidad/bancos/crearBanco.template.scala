
package views.html.contabilidad.bancos

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
object crearBanco extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Banco],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(bancoForm: Form[Banco]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.26*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/views/*4.7*/.html.contabilidad.mainContabilidad("Crear Banco")/*4.57*/ {_display_(Seq[Any](format.raw/*4.59*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Crear nuevo Banco</h1>
			</div>
			
			<div class="col-sm-2">
				<a href=""""),_display_(Seq[Any](/*13.15*/controllers/*13.26*/.contabilidad.routes.BancosController.indexBanco())),format.raw/*13.76*/("""" class="btn btn-default">
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
    
    """),_display_(Seq[Any](/*26.6*/helper/*26.12*/.form(action = controllers.contabilidad.routes.BancosController.guardarBanco())/*26.91*/ {_display_(Seq[Any](format.raw/*26.93*/("""
		"""),_display_(Seq[Any](/*27.4*/views/*27.9*/.html.contabilidad.bancos.formBanco(bancoForm))),format.raw/*27.55*/(""" 	
		<div class="row form-actions">
		    <div class="col-lg-offset-4 col-lg-8">
		      <a href=""""),_display_(Seq[Any](/*30.19*/controllers/*30.30*/.contabilidad.routes.BancosController.indexBanco())),format.raw/*30.80*/("""" class="btn btn-default">Cancelar</a>
		      <button type="submit" class="btn btn-sistema">Guardar</button>
		    </div>
		</div>
	""")))})),format.raw/*34.3*/("""
""")))})))}
    }
    
    def render(bancoForm:Form[Banco]): play.api.templates.HtmlFormat.Appendable = apply(bancoForm)
    
    def f:((Form[Banco]) => play.api.templates.HtmlFormat.Appendable) = (bancoForm) => apply(bancoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/bancos/crearBanco.scala.html
                    HASH: 0f83388e7184596006028bfff366c743b97aa420
                    MATRIX: 804->1|938->25|965->43|1001->45|1013->50|1071->100|1110->102|1307->263|1327->274|1399->324|1641->531|1680->561|1720->563|1795->603|1809->608|1844->621|1890->636|1936->647|1951->653|2039->732|2079->734|2118->738|2131->743|2199->789|2334->888|2354->899|2426->949|2591->1083
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|32->4|41->13|41->13|41->13|48->20|48->20|48->20|50->22|50->22|50->22|52->24|54->26|54->26|54->26|54->26|55->27|55->27|55->27|58->30|58->30|58->30|62->34
                    -- GENERATED --
                */
            