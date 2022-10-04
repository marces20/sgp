
package views.html.haberes.cargosLaborales

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
object formCargoLaboral extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.haberes.CargoLaboral],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(cargoForm: Form[models.haberes.CargoLaboral]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

import models.haberes._

implicit def /*6.2*/implicitFieldConstructor/*6.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.48*/("""
"""),format.raw/*6.70*/(""" 
	
	<div class="row menu-acciones">
		<div class="col-sm-10">
			<button type="submit" class="btn btn-default" title="Guardar cargo"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>
			<a href=""""),_display_(Seq[Any](/*11.14*/if(request().getHeader("referer"))/*11.48*/{_display_(Seq[Any](format.raw/*11.49*/(""" """),_display_(Seq[Any](/*11.51*/request()/*11.60*/.getHeader("referer"))),format.raw/*11.81*/(""" """)))}/*11.84*/else/*11.89*/{_display_(Seq[Any](_display_(Seq[Any](/*11.91*/controllers/*11.102*/.haberes.routes.CargosLaboralesController.index())),_display_(Seq[Any](/*11.152*/UriTrack/*11.160*/.decode()))))})),format.raw/*11.170*/("""" title="Cancelar editar" class="btn btn-default"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
		</div>
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*14.14*/UriTrack/*14.22*/.decode())),format.raw/*14.31*/("""" title="Volver al listado" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
		</div>	
	</div>
	<div class="row">
		 
		<div class="col-sm-5">
			<div class="form-group """),_display_(Seq[Any](/*20.28*/if(cargoForm.error("nombre") != null)/*20.65*/ {_display_(Seq[Any](format.raw/*20.67*/("""has-error""")))}/*20.77*/else/*20.81*/{_display_(Seq[Any](format.raw/*20.82*/("""has-required""")))})),format.raw/*20.95*/("""">
				<label for="inputDenominacion" class="control-label">Denominacion</label> 
				"""),_display_(Seq[Any](/*22.6*/inputText(cargoForm("nombre"), 'class -> "form-control"))),format.raw/*22.62*/("""
				"""),_display_(Seq[Any](/*23.6*/cargoForm("nombre")/*23.25*/.error.map/*23.35*/{ error =>_display_(Seq[Any](format.raw/*23.45*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*24.31*/error/*24.36*/.message)),format.raw/*24.44*/("""</div>
				""")))})),format.raw/*25.6*/("""
			</div>
		</div>
		 
	</div>
	"""))}
    }
    
    def render(cargoForm:Form[models.haberes.CargoLaboral]): play.api.templates.HtmlFormat.Appendable = apply(cargoForm)
    
    def f:((Form[models.haberes.CargoLaboral]) => play.api.templates.HtmlFormat.Appendable) = (cargoForm) => apply(cargoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/cargosLaborales/formCargoLaboral.scala.html
                    HASH: 9c8dca6dcbc209b8c776b13e175fd85c4517b66f
                    MATRIX: 836->1|1047->129|1079->153|1153->47|1181->197|1429->409|1472->443|1511->444|1549->446|1567->455|1610->476|1631->479|1644->484|1692->486|1713->497|1794->547|1812->555|1849->565|2045->725|2062->733|2093->742|2320->933|2366->970|2406->972|2435->982|2448->986|2487->987|2532->1000|2654->1087|2732->1143|2773->1149|2801->1168|2820->1178|2868->1188|2935->1219|2949->1224|2979->1232|3022->1244
                    LINES: 26->1|35->6|35->6|36->1|37->6|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|45->14|45->14|45->14|51->20|51->20|51->20|51->20|51->20|51->20|51->20|53->22|53->22|54->23|54->23|54->23|54->23|55->24|55->24|55->24|56->25
                    -- GENERATED --
                */
            