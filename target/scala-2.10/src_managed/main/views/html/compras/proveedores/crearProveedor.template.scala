
package views.html.compras.proveedores

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
object crearProveedor extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Proveedor],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(provForm: Form[Proveedor]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.29*/("""
"""),format.raw/*3.70*/(""" 
"""),_display_(Seq[Any](/*4.2*/views/*4.7*/.html.compras.mainCompras("Crear proveedor")/*4.51*/ {_display_(Seq[Any](format.raw/*4.53*/("""

<div class="page-header">
	<div class="row">
		<div class="col-sm-10">
			<h1>Crear nuevo proveedor</h1>
		</div>
	</div>
</div>

"""),_display_(Seq[Any](/*14.2*/if(flash.containsKey("success"))/*14.34*/ {_display_(Seq[Any](format.raw/*14.36*/("""
	<div class="alert alert-success">
		<i class="glyphicon glyphicon-ok-circle"></i> """),_display_(Seq[Any](/*16.50*/flash/*16.55*/.get("success"))),format.raw/*16.70*/("""
	</div>
""")))})),format.raw/*18.2*/("""
"""),_display_(Seq[Any](/*19.2*/if(flash.containsKey("error"))/*19.32*/ {_display_(Seq[Any](format.raw/*19.34*/("""
	<div class="alert alert-danger">
		<i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*21.52*/flash/*21.57*/.get("error"))),format.raw/*21.70*/("""
	</div>
""")))})),format.raw/*23.2*/("""

"""),_display_(Seq[Any](/*25.2*/helper/*25.8*/.form(action = controllers.compras.routes.ProveedoresController.guardar())/*25.82*/ {_display_(Seq[Any](format.raw/*25.84*/("""
	"""),_display_(Seq[Any](/*26.3*/views/*26.8*/.html.compras.proveedores.form(provForm))),format.raw/*26.48*/("""
""")))})),format.raw/*27.2*/("""

""")))})),format.raw/*29.2*/("""
"""))}
    }
    
    def render(provForm:Form[Proveedor]): play.api.templates.HtmlFormat.Appendable = apply(provForm)
    
    def f:((Form[Proveedor]) => play.api.templates.HtmlFormat.Appendable) = (provForm) => apply(provForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:46 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/proveedores/crearProveedor.scala.html
                    HASH: 57810641638d478f2d30227ae3e4c953a089fb7f
                    MATRIX: 812->1|942->49|974->73|1048->28|1077->117|1115->121|1127->126|1179->170|1218->172|1396->315|1437->347|1477->349|1600->436|1614->441|1651->456|1694->468|1732->471|1771->501|1811->503|1935->591|1949->596|1984->609|2027->621|2067->626|2081->632|2164->706|2204->708|2243->712|2256->717|2318->757|2352->760|2388->765
                    LINES: 26->1|29->3|29->3|30->1|31->3|32->4|32->4|32->4|32->4|42->14|42->14|42->14|44->16|44->16|44->16|46->18|47->19|47->19|47->19|49->21|49->21|49->21|51->23|53->25|53->25|53->25|53->25|54->26|54->26|54->26|55->27|57->29
                    -- GENERATED --
                */
            