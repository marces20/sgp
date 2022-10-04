
package views.html.haberes.instrumentosLegales

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
object formInstrumentoLegal extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.haberes.InstrumentoLegal],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(ilForm: Form[models.haberes.InstrumentoLegal]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

import models.haberes._

implicit def /*6.2*/implicitFieldConstructor/*6.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.49*/("""
"""),format.raw/*6.70*/(""" 
	
	<div class="row menu-acciones">
		<div class="col-sm-10">
			<button type="submit" class="btn btn-default" title="Guardar instrumento"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>
			<a href=""""),_display_(Seq[Any](/*11.14*/if(request().getHeader("referer"))/*11.48*/{_display_(Seq[Any](format.raw/*11.49*/(""" """),_display_(Seq[Any](/*11.51*/request()/*11.60*/.getHeader("referer"))),format.raw/*11.81*/(""" """)))}/*11.84*/else/*11.89*/{_display_(Seq[Any](_display_(Seq[Any](/*11.91*/controllers/*11.102*/.haberes.routes.InstrumentosLegalesController.index())),_display_(Seq[Any](/*11.156*/UriTrack/*11.164*/.decode()))))})),format.raw/*11.174*/("""" title="Cancelar editar" class="btn btn-default"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
		</div>
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*14.14*/UriTrack/*14.22*/.decode())),format.raw/*14.31*/("""" title="Volver al listado" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
		</div>	
	</div>
	<div class="row">
		<div class="col-sm-5">
			<div class="form-group """),_display_(Seq[Any](/*19.28*/if(ilForm.error("nombre") != null)/*19.62*/ {_display_(Seq[Any](format.raw/*19.64*/("""has-error""")))}/*19.74*/else/*19.78*/{_display_(Seq[Any](format.raw/*19.79*/("""has-required""")))})),format.raw/*19.92*/("""">
				<label for="inputNumero" class="control-label">Nombre</label> 
				"""),_display_(Seq[Any](/*21.6*/inputText(ilForm("nombre"), 'class -> "form-control"))),format.raw/*21.59*/("""
				"""),_display_(Seq[Any](/*22.6*/ilForm("nombre")/*22.22*/.error.map/*22.32*/{ error =>_display_(Seq[Any](format.raw/*22.42*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*23.31*/error/*23.36*/.message)),format.raw/*23.44*/("""</div>
				""")))})),format.raw/*24.6*/("""
			</div>
		</div>
	</div>
	"""))}
    }
    
    def render(ilForm:Form[models.haberes.InstrumentoLegal]): play.api.templates.HtmlFormat.Appendable = apply(ilForm)
    
    def f:((Form[models.haberes.InstrumentoLegal]) => play.api.templates.HtmlFormat.Appendable) = (ilForm) => apply(ilForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/instrumentosLegales/formInstrumentoLegal.scala.html
                    HASH: 485584e846428098f994d30b5b42b1cdae62fb48
                    MATRIX: 848->1|1060->130|1092->154|1166->48|1194->198|1448->416|1491->450|1530->451|1568->453|1586->462|1629->483|1650->486|1663->491|1711->493|1732->504|1817->558|1835->566|1872->576|2068->736|2085->744|2116->753|2339->940|2382->974|2422->976|2451->986|2464->990|2503->991|2548->1004|2658->1079|2733->1132|2774->1138|2799->1154|2818->1164|2866->1174|2933->1205|2947->1210|2977->1218|3020->1230
                    LINES: 26->1|35->6|35->6|36->1|37->6|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|45->14|45->14|45->14|50->19|50->19|50->19|50->19|50->19|50->19|50->19|52->21|52->21|53->22|53->22|53->22|53->22|54->23|54->23|54->23|55->24
                    -- GENERATED --
                */
            