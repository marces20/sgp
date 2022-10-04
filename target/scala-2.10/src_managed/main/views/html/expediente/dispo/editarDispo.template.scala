
package views.html.expediente.dispo

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
object editarDispo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Dispo],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formDispo: Form[Dispo]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.26*/("""
"""),format.raw/*3.70*/("""

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.expediente.mainExpediente("Modificar Disposicion")/*5.63*/ {_display_(Seq[Any](format.raw/*5.65*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Editar Disposicion</h1>
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*15.3*/if(flash.containsKey("error"))/*15.33*/ {_display_(Seq[Any](format.raw/*15.35*/("""
		<div class="alert alert-danger">
			"""),_display_(Seq[Any](/*17.5*/flash/*17.10*/.get("error"))),format.raw/*17.23*/("""
		</div>
	""")))})),format.raw/*19.3*/("""
	
	"""),_display_(Seq[Any](/*21.3*/helper/*21.9*/.form(action = controllers.expediente.routes.DisposController.actualizar())/*21.84*/ {_display_(Seq[Any](format.raw/*21.86*/("""
		"""),_display_(Seq[Any](/*22.4*/inputText(formDispo("id"), 'hidden -> "hidden"))),format.raw/*22.51*/("""

		"""),_display_(Seq[Any](/*24.4*/views/*24.9*/.html.expediente.dispo.formDispo(formDispo))),format.raw/*24.52*/("""
	""")))})),format.raw/*25.3*/("""

""")))})))}
    }
    
    def render(formDispo:Form[Dispo]): play.api.templates.HtmlFormat.Appendable = apply(formDispo)
    
    def f:((Form[Dispo]) => play.api.templates.HtmlFormat.Appendable) = (formDispo) => apply(formDispo)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:36 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/expediente/dispo/editarDispo.scala.html
                    HASH: d9faa7930e5b3a9deca795b37c88a3d94b89b1c9
                    MATRIX: 802->1|928->44|960->68|1034->25|1062->112|1099->115|1111->120|1175->176|1214->178|1388->317|1427->347|1467->349|1542->389|1556->394|1591->407|1634->419|1674->424|1688->430|1772->505|1812->507|1851->511|1920->558|1960->563|1973->568|2038->611|2072->614
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|43->15|43->15|43->15|45->17|45->17|45->17|47->19|49->21|49->21|49->21|49->21|50->22|50->22|52->24|52->24|52->24|53->25
                    -- GENERATED --
                */
            