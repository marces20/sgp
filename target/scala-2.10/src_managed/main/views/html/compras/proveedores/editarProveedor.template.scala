
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
object editarProveedor extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Proveedor],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(provForm: Form[Proveedor]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.29*/("""
"""),format.raw/*3.70*/(""" 
"""),_display_(Seq[Any](/*4.2*/views/*4.7*/.html.compras.mainCompras("Editar proveedor")/*4.52*/ {_display_(Seq[Any](format.raw/*4.54*/("""

<div class="page-header">
	<div class="row">
		<div class="col-sm-9">
			<h1>Editar proveedor</h1>
		</div>
		
		<div class="col-sm-3">
			<a href=""""),_display_(Seq[Any](/*13.14*/controllers/*13.25*/.compras.routes.ProveedoresController.crear)),format.raw/*13.68*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo proveedor</a>
		</div>
	</div>
</div>
"""),_display_(Seq[Any](/*17.2*/if(flash.containsKey("success"))/*17.34*/ {_display_(Seq[Any](format.raw/*17.36*/("""
	<div class="alert alert-success">
		<i class="glyphicon glyphicon-ok-circle"></i> """),_display_(Seq[Any](/*19.50*/flash/*19.55*/.get("success"))),format.raw/*19.70*/("""
	</div>
""")))})),format.raw/*21.2*/("""
"""),_display_(Seq[Any](/*22.2*/if(flash.containsKey("error"))/*22.32*/ {_display_(Seq[Any](format.raw/*22.34*/("""
	<div class="alert alert-danger">
		<i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*24.52*/flash/*24.57*/.get("error"))),format.raw/*24.70*/("""
	</div>
""")))})),format.raw/*26.2*/("""

"""),_display_(Seq[Any](/*28.2*/helper/*28.8*/.form(action = controllers.compras.routes.ProveedoresController.actualizar())/*28.85*/ {_display_(Seq[Any](format.raw/*28.87*/("""
	"""),_display_(Seq[Any](/*29.3*/inputText(provForm("id"), 'hidden -> "hidden",'id->"idProveeedor"))),format.raw/*29.69*/("""
	"""),_display_(Seq[Any](/*30.3*/views/*30.8*/.html.compras.proveedores.form(provForm))),format.raw/*30.48*/("""
	"""),_display_(Seq[Any](/*31.3*/views/*31.8*/.html.compras.proveedores.tabsProveedores(provForm, true))),format.raw/*31.65*/("""
	"""),_display_(Seq[Any](/*32.3*/views/*32.8*/.html.compras.proveedores.tabsAtributos(provForm, true))),format.raw/*32.63*/("""
	
	
""")))})),format.raw/*35.2*/("""




""")))})),format.raw/*40.2*/("""
"""))}
    }
    
    def render(provForm:Form[Proveedor]): play.api.templates.HtmlFormat.Appendable = apply(provForm)
    
    def f:((Form[Proveedor]) => play.api.templates.HtmlFormat.Appendable) = (provForm) => apply(provForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:46 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/proveedores/editarProveedor.scala.html
                    HASH: 41fbab4bf23b42415c9da99ddbd4d18a9d1d80b9
                    MATRIX: 813->1|943->49|975->73|1049->28|1078->117|1116->121|1128->126|1181->171|1220->173|1416->333|1436->344|1501->387|1658->509|1699->541|1739->543|1862->630|1876->635|1913->650|1956->662|1994->665|2033->695|2073->697|2197->785|2211->790|2246->803|2289->815|2329->820|2343->826|2429->903|2469->905|2508->909|2596->975|2635->979|2648->984|2710->1024|2749->1028|2762->1033|2841->1090|2880->1094|2893->1099|2970->1154|3010->1163|3052->1174
                    LINES: 26->1|29->3|29->3|30->1|31->3|32->4|32->4|32->4|32->4|41->13|41->13|41->13|45->17|45->17|45->17|47->19|47->19|47->19|49->21|50->22|50->22|50->22|52->24|52->24|52->24|54->26|56->28|56->28|56->28|56->28|57->29|57->29|58->30|58->30|58->30|59->31|59->31|59->31|60->32|60->32|60->32|63->35|68->40
                    -- GENERATED --
                */
            