
package views.html.haberes.conveniosBancos

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
object formConvenioBanco extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.haberes.ConvenioBanco],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(convenioForm: Form[models.haberes.ConvenioBanco]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

import models.haberes._

implicit def /*6.2*/implicitFieldConstructor/*6.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.52*/("""
"""),format.raw/*6.70*/(""" 
	
	<div class="row menu-acciones">
		<div class="col-sm-10">
			<button type="submit" class="btn btn-default" title="Guardar categoria"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>
			<a href=""""),_display_(Seq[Any](/*11.14*/if(request().getHeader("referer"))/*11.48*/{_display_(Seq[Any](format.raw/*11.49*/(""" """),_display_(Seq[Any](/*11.51*/request()/*11.60*/.getHeader("referer"))),format.raw/*11.81*/(""" """)))}/*11.84*/else/*11.89*/{_display_(Seq[Any](_display_(Seq[Any](/*11.91*/controllers/*11.102*/.haberes.routes.ConveniosBancosController.index())),_display_(Seq[Any](/*11.152*/UriTrack/*11.160*/.decode()))))})),format.raw/*11.170*/("""" title="Cancelar editar" class="btn btn-default"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
		</div>
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*14.14*/UriTrack/*14.22*/.decode())),format.raw/*14.31*/("""" title="Volver al listado" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
		</div>	
	</div>
	<div class="row">
		 
		<div class="col-sm-5">
			<div class="form-group """),_display_(Seq[Any](/*20.28*/if(convenioForm.error("nombre") != null)/*20.68*/ {_display_(Seq[Any](format.raw/*20.70*/("""has-error""")))}/*20.80*/else/*20.84*/{_display_(Seq[Any](format.raw/*20.85*/("""has-required""")))})),format.raw/*20.98*/("""">
				<label for="inputDenominacion" class="control-label">Denominacion</label> 
				"""),_display_(Seq[Any](/*22.6*/inputText(convenioForm("nombre"), 'class -> "form-control"))),format.raw/*22.65*/("""
				"""),_display_(Seq[Any](/*23.6*/convenioForm("nombre")/*23.28*/.error.map/*23.38*/{ error =>_display_(Seq[Any](format.raw/*23.48*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*24.31*/error/*24.36*/.message)),format.raw/*24.44*/("""</div>
				""")))})),format.raw/*25.6*/("""
			</div>
		</div>
		 
	</div>
	"""))}
    }
    
    def render(convenioForm:Form[models.haberes.ConvenioBanco]): play.api.templates.HtmlFormat.Appendable = apply(convenioForm)
    
    def f:((Form[models.haberes.ConvenioBanco]) => play.api.templates.HtmlFormat.Appendable) = (convenioForm) => apply(convenioForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/conveniosBancos/formConvenioBanco.scala.html
                    HASH: d750bd94a21c10820bba404c38e6a31d9797a0c1
                    MATRIX: 838->1|1053->133|1085->157|1159->51|1187->201|1439->417|1482->451|1521->452|1559->454|1577->463|1620->484|1641->487|1654->492|1702->494|1723->505|1804->555|1822->563|1859->573|2055->733|2072->741|2103->750|2330->941|2379->981|2419->983|2448->993|2461->997|2500->998|2545->1011|2667->1098|2748->1157|2789->1163|2820->1185|2839->1195|2887->1205|2954->1236|2968->1241|2998->1249|3041->1261
                    LINES: 26->1|35->6|35->6|36->1|37->6|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|45->14|45->14|45->14|51->20|51->20|51->20|51->20|51->20|51->20|51->20|53->22|53->22|54->23|54->23|54->23|54->23|55->24|55->24|55->24|56->25
                    -- GENERATED --
                */
            