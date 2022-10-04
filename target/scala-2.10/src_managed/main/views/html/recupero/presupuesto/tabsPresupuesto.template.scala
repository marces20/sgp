
package views.html.recupero.presupuesto

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
object tabsPresupuesto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Boolean,Form[models.recupero.Presupuesto],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formularioCarga: Boolean, presupuestoForm: Form[models.recupero.Presupuesto] = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.87*/("""

<ul id="certificacionTab" class="nav nav-tabs">
	<li class="active"><a class="tabProducto" href="#contenedorProductos" data-toggle="tab">Productos</a></li>
	<li><a class="tabNotas" href="#contenedorNotas" data-toggle="tab">Notas</a></li>
</ul>

<div class="tab-content">

	<div class="tab-pane active" id="contenedorProductos">
		"""),_display_(Seq[Any](/*11.4*/views/*11.9*/.html.recupero.presupuesto.contenidoTabProducto(formularioCarga, presupuestoForm))),format.raw/*11.90*/("""	
	</div>
	<div class="tab-pane" id="contenedorNotas">
		"""),_display_(Seq[Any](/*14.4*/if(formularioCarga)/*14.23*/{_display_(Seq[Any](format.raw/*14.24*/("""
			<textarea name="nota" class="form-control" rows="5">"""),_display_(Seq[Any](/*15.57*/presupuestoForm/*15.72*/.field("nota").value)),format.raw/*15.92*/("""</textarea>
		""")))}/*16.5*/else/*16.10*/{_display_(Seq[Any](format.raw/*16.11*/("""
			<textarea name="nota" disabled="disabled" class="form-control" rows="5">"""),_display_(Seq[Any](/*17.77*/presupuestoForm/*17.92*/.field("nota").value)),format.raw/*17.112*/("""</textarea>
		""")))})),format.raw/*18.4*/("""
	</div>

</div>
"""))}
    }
    
    def render(formularioCarga:Boolean,presupuestoForm:Form[models.recupero.Presupuesto]): play.api.templates.HtmlFormat.Appendable = apply(formularioCarga,presupuestoForm)
    
    def f:((Boolean,Form[models.recupero.Presupuesto]) => play.api.templates.HtmlFormat.Appendable) = (formularioCarga,presupuestoForm) => apply(formularioCarga,presupuestoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:35 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/recupero/presupuesto/tabsPresupuesto.scala.html
                    HASH: 5ed3fa7e619c1cb894b3b5f5e114e254a5639f13
                    MATRIX: 840->1|1019->86|1397->429|1410->434|1513->515|1609->576|1637->595|1676->596|1770->654|1794->669|1836->689|1870->706|1883->711|1922->712|2036->790|2060->805|2103->825|2150->841
                    LINES: 26->1|29->1|39->11|39->11|39->11|42->14|42->14|42->14|43->15|43->15|43->15|44->16|44->16|44->16|45->17|45->17|45->17|46->18
                    -- GENERATED --
                */
            