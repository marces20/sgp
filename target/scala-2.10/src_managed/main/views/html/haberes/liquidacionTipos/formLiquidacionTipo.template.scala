
package views.html.haberes.liquidacionTipos

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
object formLiquidacionTipo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.haberes.LiquidacionTipo],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(tipoForm: Form[models.haberes.LiquidacionTipo]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

import models.haberes._

implicit def /*6.2*/implicitFieldConstructor/*6.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.50*/("""
"""),format.raw/*6.70*/(""" 
	
	<div class="row menu-acciones">
		<div class="col-sm-10">
			<button type="submit" class="btn btn-default" title="Guardar tipo de Liquidacion"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>
			<a href=""""),_display_(Seq[Any](/*11.14*/if(request().getHeader("referer"))/*11.48*/{_display_(Seq[Any](format.raw/*11.49*/(""" """),_display_(Seq[Any](/*11.51*/request()/*11.60*/.getHeader("referer"))),format.raw/*11.81*/(""" """)))}/*11.84*/else/*11.89*/{_display_(Seq[Any](_display_(Seq[Any](/*11.91*/controllers/*11.102*/.haberes.routes.LiquidacionTiposController.index())),_display_(Seq[Any](/*11.153*/UriTrack/*11.161*/.decode()))))})),format.raw/*11.171*/("""" title="Cancelar editar" class="btn btn-default"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
		</div>
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*14.14*/UriTrack/*14.22*/.decode())),format.raw/*14.31*/("""" title="Volver al listado" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
		</div>	
	</div>
	<div class="row">
		 
		<div class="col-sm-5">
			<div class="form-group """),_display_(Seq[Any](/*20.28*/if(tipoForm.error("nombre") != null)/*20.64*/ {_display_(Seq[Any](format.raw/*20.66*/("""has-error""")))}/*20.76*/else/*20.80*/{_display_(Seq[Any](format.raw/*20.81*/("""has-required""")))})),format.raw/*20.94*/("""">
				<label for="inputDenominacion" class="control-label">Denominacion</label> 
				"""),_display_(Seq[Any](/*22.6*/inputText(tipoForm("nombre"), 'class -> "form-control"))),format.raw/*22.61*/("""
				"""),_display_(Seq[Any](/*23.6*/tipoForm("nombre")/*23.24*/.error.map/*23.34*/{ error =>_display_(Seq[Any](format.raw/*23.44*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*24.31*/error/*24.36*/.message)),format.raw/*24.44*/("""</div>
				""")))})),format.raw/*25.6*/("""
			</div>
		</div>
		<div class="col-sm-3">
			<div class="checkbox">
				<label class="control-label">
					Excluido Ganancias
					"""),_display_(Seq[Any](/*32.7*/checkbox(tipoForm("excluido_ganancias")))),format.raw/*32.47*/("""
				</label>
			</div>
		</div>	
		 
	</div>
	"""))}
    }
    
    def render(tipoForm:Form[models.haberes.LiquidacionTipo]): play.api.templates.HtmlFormat.Appendable = apply(tipoForm)
    
    def f:((Form[models.haberes.LiquidacionTipo]) => play.api.templates.HtmlFormat.Appendable) = (tipoForm) => apply(tipoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/liquidacionTipos/formLiquidacionTipo.scala.html
                    HASH: d76870f49efa54d6326cbebeb3d567431ba5c95e
                    MATRIX: 843->1|1056->131|1088->155|1162->49|1190->199|1452->425|1495->459|1534->460|1572->462|1590->471|1633->492|1654->495|1667->500|1715->502|1736->513|1818->564|1836->572|1873->582|2069->742|2086->750|2117->759|2344->950|2389->986|2429->988|2458->998|2471->1002|2510->1003|2555->1016|2677->1103|2754->1158|2795->1164|2822->1182|2841->1192|2889->1202|2956->1233|2970->1238|3000->1246|3043->1258|3213->1393|3275->1433
                    LINES: 26->1|35->6|35->6|36->1|37->6|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|45->14|45->14|45->14|51->20|51->20|51->20|51->20|51->20|51->20|51->20|53->22|53->22|54->23|54->23|54->23|54->23|55->24|55->24|55->24|56->25|63->32|63->32
                    -- GENERATED --
                */
            