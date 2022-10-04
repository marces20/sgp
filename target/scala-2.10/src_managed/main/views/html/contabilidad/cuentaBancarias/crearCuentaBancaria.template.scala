
package views.html.contabilidad.cuentaBancarias

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
object crearCuentaBancaria extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[CuentaBancaria],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(cuentaBancariaForm: Form[CuentaBancaria]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.44*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/views/*4.7*/.html.contabilidad.mainContabilidad("Crear cuenta bancaria")/*4.67*/ {_display_(Seq[Any](format.raw/*4.69*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Crear nueva cuenta bancaria</h1>
			</div>
			
			<div class="col-sm-2">
				<a href=""""),_display_(Seq[Any](/*13.15*/controllers/*13.26*/.contabilidad.routes.CuentaBancariasController.indexCuentaBancaria())),format.raw/*13.94*/("""" class="btn btn-default">
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
    
    """),_display_(Seq[Any](/*26.6*/helper/*26.12*/.form(action = controllers.contabilidad.routes.CuentaBancariasController.guardarCuentaBancaria())/*26.109*/ {_display_(Seq[Any](format.raw/*26.111*/("""
		"""),_display_(Seq[Any](/*27.4*/views/*27.9*/.html.contabilidad.cuentaBancarias.formCuentaBancaria(cuentaBancariaForm))),format.raw/*27.82*/("""
		
	""")))})),format.raw/*29.3*/("""
""")))})),format.raw/*30.2*/("""	"""))}
    }
    
    def render(cuentaBancariaForm:Form[CuentaBancaria]): play.api.templates.HtmlFormat.Appendable = apply(cuentaBancariaForm)
    
    def f:((Form[CuentaBancaria]) => play.api.templates.HtmlFormat.Appendable) = (cuentaBancariaForm) => apply(cuentaBancariaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/cuentaBancarias/crearCuentaBancaria.scala.html
                    HASH: 11a888ab3caffb3bc7b28618d858c352bd1eeef3
                    MATRIX: 831->1|983->43|1010->61|1046->63|1058->68|1126->128|1165->130|1372->301|1392->312|1482->380|1724->587|1763->617|1803->619|1878->659|1892->664|1927->677|1973->692|2019->703|2034->709|2141->806|2182->808|2221->812|2234->817|2329->890|2366->896|2399->898
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|32->4|41->13|41->13|41->13|48->20|48->20|48->20|50->22|50->22|50->22|52->24|54->26|54->26|54->26|54->26|55->27|55->27|55->27|57->29|58->30
                    -- GENERATED --
                */
            