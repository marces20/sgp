
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
object editarCuentaBancaria extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[CuentaBancaria],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(cuentaBancariaForm: Form[CuentaBancaria]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.44*/("""
"""),format.raw/*3.70*/("""

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.contabilidad.mainContabilidad("Modificar cuenta bancaria")/*5.71*/ {_display_(Seq[Any](format.raw/*5.73*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Editar cuenta bancaria</h1>
			</div>
			
			<div class="col-sm-2">
				<a href=""""),_display_(Seq[Any](/*14.15*/controllers/*14.26*/.contabilidad.routes.CuentaBancariasController.indexCuentaBancaria())),format.raw/*14.94*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
				<a href="#" class="btn btn-default"><i class="glyphicon glyphicon-align-justify"></i></a> 
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*20.3*/if(flash.containsKey("error"))/*20.33*/ {_display_(Seq[Any](format.raw/*20.35*/("""
		<div class="alert alert-danger">
			"""),_display_(Seq[Any](/*22.5*/flash/*22.10*/.get("error"))),format.raw/*22.23*/("""
		</div>
	""")))})),format.raw/*24.3*/("""
	
	"""),_display_(Seq[Any](/*26.3*/helper/*26.9*/.form(action = controllers.contabilidad.routes.CuentaBancariasController.actualizarCuentaBancaria())/*26.109*/ {_display_(Seq[Any](format.raw/*26.111*/("""
		"""),_display_(Seq[Any](/*27.4*/inputText(cuentaBancariaForm("id"), 'hidden -> "hidden"))),format.raw/*27.60*/("""
		"""),_display_(Seq[Any](/*28.4*/views/*28.9*/.html.contabilidad.cuentaBancarias.formCuentaBancaria(cuentaBancariaForm))),format.raw/*28.82*/("""
		
	""")))})),format.raw/*30.3*/("""

""")))})))}
    }
    
    def render(cuentaBancariaForm:Form[CuentaBancaria]): play.api.templates.HtmlFormat.Appendable = apply(cuentaBancariaForm)
    
    def f:((Form[CuentaBancaria]) => play.api.templates.HtmlFormat.Appendable) = (cuentaBancariaForm) => apply(cuentaBancariaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/cuentaBancarias/editarCuentaBancaria.scala.html
                    HASH: 9e75dc356ed069efd3a1a9c61c5c7e6ce8e0b014
                    MATRIX: 832->1|976->62|1008->86|1082->43|1110->130|1147->133|1159->138|1231->202|1270->204|1472->370|1492->381|1582->449|1815->647|1854->677|1894->679|1969->719|1983->724|2018->737|2061->749|2101->754|2115->760|2225->860|2266->862|2305->866|2383->922|2422->926|2435->931|2530->1004|2567->1010
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|42->14|42->14|42->14|48->20|48->20|48->20|50->22|50->22|50->22|52->24|54->26|54->26|54->26|54->26|55->27|55->27|56->28|56->28|56->28|58->30
                    -- GENERATED --
                */
            