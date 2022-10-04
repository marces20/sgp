
package views.html.compras.clientes

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
object editarCliente extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Cliente],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(clienteForm: Form[Cliente]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

def /*4.2*/scripts/*4.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*4.13*/("""
	<script src=""""),_display_(Seq[Any](/*5.16*/routes/*5.22*/.Assets.at("javascripts/compras/clientes.js"))),format.raw/*5.67*/("""" type="text/javascript"></script>
""")))};implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.30*/("""
"""),format.raw/*3.70*/("""
"""),format.raw/*6.2*/("""
 
"""),_display_(Seq[Any](/*8.2*/views/*8.7*/.html.compras.mainCompras("Editar cliente", scripts)/*8.59*/ {_display_(Seq[Any](format.raw/*8.61*/("""

<div class="page-header">
	<div class="row">
		<div class="col-sm-9">
			<h1>Editar cliente</h1>
		</div>
		
		<div class="col-sm-3">
			<a href=""""),_display_(Seq[Any](/*17.14*/controllers/*17.25*/.compras.routes.ClientesController.crear)),format.raw/*17.65*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo cliente</a>
			<a href=""""),_display_(Seq[Any](/*18.14*/controllers/*18.25*/.compras.routes.ClientesController.index())),format.raw/*18.67*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
			<a href="#" class="btn btn-default"><i class="glyphicon glyphicon-align-justify"></i></a> 
		</div>
	</div>
</div>
"""),_display_(Seq[Any](/*23.2*/if(flash.containsKey("success"))/*23.34*/ {_display_(Seq[Any](format.raw/*23.36*/("""
	<div class="alert alert-success">
		<i class="glyphicon glyphicon-ok-circle"></i> """),_display_(Seq[Any](/*25.50*/flash/*25.55*/.get("success"))),format.raw/*25.70*/("""
	</div>
""")))})),format.raw/*27.2*/("""
"""),_display_(Seq[Any](/*28.2*/if(flash.containsKey("error"))/*28.32*/ {_display_(Seq[Any](format.raw/*28.34*/("""
	<div class="alert alert-danger">
		<i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*30.52*/flash/*30.57*/.get("error"))),format.raw/*30.70*/("""
	</div>
""")))})),format.raw/*32.2*/("""

"""),_display_(Seq[Any](/*34.2*/helper/*34.8*/.form(action = controllers.compras.routes.ClientesController.actualizar())/*34.82*/ {_display_(Seq[Any](format.raw/*34.84*/("""
	"""),_display_(Seq[Any](/*35.3*/inputText(clienteForm("id"), 'hidden -> "hidden"))),format.raw/*35.52*/("""
	"""),_display_(Seq[Any](/*36.3*/views/*36.8*/.html.compras.clientes.form(clienteForm))),format.raw/*36.48*/("""
	"""),_display_(Seq[Any](/*37.3*/views/*37.8*/.html.compras.clientes.tabsClientes(clienteForm, true))),format.raw/*37.62*/("""

""")))})),format.raw/*39.2*/("""

""")))})),format.raw/*41.2*/("""
"""))}
    }
    
    def render(clienteForm:Form[Cliente]): play.api.templates.HtmlFormat.Appendable = apply(clienteForm)
    
    def f:((Form[Cliente]) => play.api.templates.HtmlFormat.Appendable) = (clienteForm) => apply(clienteForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:41 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/clientes/editarCliente.scala.html
                    HASH: acae4475c3845555018c8d1ffa1a04d8ea5c2ea9
                    MATRIX: 806->1|928->121|942->128|1026->132|1078->149|1092->155|1158->200|1226->50|1258->74|1332->29|1361->118|1389->237|1429->243|1441->248|1501->300|1540->302|1734->460|1754->471|1816->511|1957->616|1977->627|2041->669|2272->865|2313->897|2353->899|2476->986|2490->991|2527->1006|2570->1018|2608->1021|2647->1051|2687->1053|2811->1141|2825->1146|2860->1159|2903->1171|2943->1176|2957->1182|3040->1256|3080->1258|3119->1262|3190->1311|3229->1315|3242->1320|3304->1360|3343->1364|3356->1369|3432->1423|3468->1428|3504->1433
                    LINES: 26->1|29->4|29->4|31->4|32->5|32->5|32->5|33->3|33->3|34->1|35->3|36->6|38->8|38->8|38->8|38->8|47->17|47->17|47->17|48->18|48->18|48->18|53->23|53->23|53->23|55->25|55->25|55->25|57->27|58->28|58->28|58->28|60->30|60->30|60->30|62->32|64->34|64->34|64->34|64->34|65->35|65->35|66->36|66->36|66->36|67->37|67->37|67->37|69->39|71->41
                    -- GENERATED --
                */
            