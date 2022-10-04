
package views.html.expediente.iniciador

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
object crearIniciadorExpediente extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[IniciadorExpediente],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(iniciadorExpedienteForm: Form[IniciadorExpediente]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.54*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/views/*4.7*/.html.expediente.mainExpediente("Crear Iniciador Expediente")/*4.68*/ {_display_(Seq[Any](format.raw/*4.70*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Crear nuevo iniciador de expediente</h1>
			</div>
			
			<div class="col-sm-2">
				<a href=""""),_display_(Seq[Any](/*13.15*/controllers/*13.26*/.expediente.routes.IniciadorExpedientesController.indexIniciadorExpediente())),format.raw/*13.102*/("""" class="btn btn-default">
					<i class="glyphicon glyphicon-list"></i>
				</a> 
				<a href="#" class="btn btn-default"><i class="glyphicon glyphicon-align-justify"></i></a> 
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*21.3*/views/*21.8*/.html.tags.successError())),format.raw/*21.33*/("""
    
    """),_display_(Seq[Any](/*23.6*/helper/*23.12*/.form(action = controllers.expediente.routes.IniciadorExpedientesController.guardarIniciadorExpediente())/*23.117*/ {_display_(Seq[Any](format.raw/*23.119*/("""
		"""),_display_(Seq[Any](/*24.4*/views/*24.9*/.html.expediente.iniciador.formIniciadorExpediente(iniciadorExpedienteForm))),format.raw/*24.84*/("""
		<div class="row form-actions">
		    <div class="col-lg-offset-4 col-lg-8">
		      <a href=""""),_display_(Seq[Any](/*27.19*/controllers/*27.30*/.expediente.routes.IniciadorExpedientesController.indexIniciadorExpediente())),format.raw/*27.106*/("""" class="btn btn-default">Cancelar</a>
		      <button type="submit" class="btn btn-sistema">Guardar</button>
		    </div>
		</div>
	""")))})),format.raw/*31.3*/("""
""")))})),format.raw/*32.2*/("""	"""))}
    }
    
    def render(iniciadorExpedienteForm:Form[IniciadorExpediente]): play.api.templates.HtmlFormat.Appendable = apply(iniciadorExpedienteForm)
    
    def f:((Form[IniciadorExpediente]) => play.api.templates.HtmlFormat.Appendable) = (iniciadorExpedienteForm) => apply(iniciadorExpedienteForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:36 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/expediente/iniciador/crearIniciadorExpediente.scala.html
                    HASH: c94cb030228c75fb16c54ed23583671204b16761
                    MATRIX: 833->1|995->53|1022->71|1058->73|1070->78|1139->139|1178->141|1393->320|1413->331|1512->407|1756->616|1769->621|1816->646|1862->657|1877->663|1992->768|2033->770|2072->774|2085->779|2182->854|2315->951|2335->962|2434->1038|2599->1172|2632->1174
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|32->4|41->13|41->13|41->13|49->21|49->21|49->21|51->23|51->23|51->23|51->23|52->24|52->24|52->24|55->27|55->27|55->27|59->31|60->32
                    -- GENERATED --
                */
            