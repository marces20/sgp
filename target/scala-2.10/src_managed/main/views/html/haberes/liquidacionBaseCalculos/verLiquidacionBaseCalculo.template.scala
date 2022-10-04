
package views.html.haberes.liquidacionBaseCalculos

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
object verLiquidacionBaseCalculo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[models.haberes.LiquidacionBaseCalculo],models.haberes.LiquidacionBaseCalculo,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lcForm: Form[models.haberes.LiquidacionBaseCalculo],lc:models.haberes.LiquidacionBaseCalculo):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

def /*4.2*/scripts/*4.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*4.13*/("""
	<script src=""""),_display_(Seq[Any](/*5.16*/routes/*5.22*/.Assets.at("javascripts/haberes/liquidacionBaseCalculo.js"))),format.raw/*5.81*/("""" type="text/javascript"></script>
""")))};implicit def /*7.2*/implicitFieldConstructor/*7.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.96*/("""
"""),format.raw/*6.2*/("""
"""),format.raw/*7.70*/(""" 

"""),_display_(Seq[Any](/*9.2*/views/*9.7*/.html.haberes.mainHaberes("Vista Base Calculo",scripts)/*9.62*/ {_display_(Seq[Any](format.raw/*9.64*/("""
	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Vista Base Calculo</h1>
			</div>
			<div class="col-sm-5">
				
			</div>
		</div>
	</div>		
	<div class="row menu-acciones">
		<div class="col-sm-10">
			<a href=""""),_display_(Seq[Any](/*22.14*/controllers/*22.25*/.haberes.routes.LiquidacionBaseCalculosController.crear())),format.raw/*22.82*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo Base Calculo</a>
			<a href=""""),_display_(Seq[Any](/*23.14*/controllers/*23.25*/.haberes.routes.LiquidacionBaseCalculosController.editar(lc.id))),_display_(Seq[Any](/*23.89*/UriTrack/*23.97*/.get("&"))),format.raw/*23.106*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-edit"></i> Editar</a>
			<a href=""""),_display_(Seq[Any](/*24.14*/controllers/*24.25*/.haberes.routes.LiquidacionBaseCalculosController.eliminar(lc.id))),_display_(Seq[Any](/*24.91*/UriTrack/*24.99*/.get("&"))),format.raw/*24.108*/(""""  class="btn btn-default delete-confirm-link"><i class="glyphicon glyphicon-trash icono-eliminar"></i> Eliminar</a>
		</div>
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*27.14*/UriTrack/*27.22*/.getOnNull(controllers.haberes.routes.LiquidacionBaseCalculosController.index().absoluteURL()))),format.raw/*27.116*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
		</div> 
	</div>	
	
	<input type="hidden" id="baseCalculoId" name="agenteId" value=""""),_display_(Seq[Any](/*31.66*/lc/*31.68*/.id)),format.raw/*31.71*/(""""/>
	<div class="row">
		 
		<div class="col-sm-2">
			<div class="form-group">
				<label class="control-label">Nombre</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*37.50*/lcForm/*37.56*/.field("nombre").value)),format.raw/*37.78*/("""</p>
			</div>
		</div>
		
		 <div class="col-sm-8	">
			<div class="form-group">
				<label class="control-label">Parámetros</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*44.50*/lcForm/*44.56*/.field("parametros").value)),format.raw/*44.82*/("""</p>
			</div>
		</div> 
		 
	</div>
	<div class="row">
		<div class="col-sm-10	">
			<div class="form-group">
				<label class="control-label">Cálculo</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*53.50*/lcForm/*53.56*/.field("calculo").value)),format.raw/*53.79*/("""</p>
			</div>
		</div> 
	</div> 
""")))})))}
    }
    
    def render(lcForm:Form[models.haberes.LiquidacionBaseCalculo],lc:models.haberes.LiquidacionBaseCalculo): play.api.templates.HtmlFormat.Appendable = apply(lcForm,lc)
    
    def f:((Form[models.haberes.LiquidacionBaseCalculo],models.haberes.LiquidacionBaseCalculo) => play.api.templates.HtmlFormat.Appendable) = (lcForm,lc) => apply(lcForm,lc)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/liquidacionBaseCalculos/verLiquidacionBaseCalculo.scala.html
                    HASH: 4766bd754d43fadfe4e7106eedbe17cca1a9ae03
                    MATRIX: 901->1|1104->130|1118->137|1202->141|1253->157|1267->163|1347->222|1414->260|1446->284|1520->95|1547->258|1575->328|1613->332|1625->337|1688->392|1727->394|2011->642|2031->653|2110->710|2255->819|2275->830|2369->894|2386->902|2418->911|2546->1003|2566->1014|2662->1080|2679->1088|2711->1097|2911->1261|2928->1269|3045->1363|3239->1521|3250->1523|3275->1526|3488->1703|3503->1709|3547->1731|3766->1914|3781->1920|3829->1946|4074->2155|4089->2161|4134->2184
                    LINES: 26->1|31->4|31->4|33->4|34->5|34->5|34->5|35->7|35->7|36->1|37->6|38->7|40->9|40->9|40->9|40->9|53->22|53->22|53->22|54->23|54->23|54->23|54->23|54->23|55->24|55->24|55->24|55->24|55->24|58->27|58->27|58->27|62->31|62->31|62->31|68->37|68->37|68->37|75->44|75->44|75->44|84->53|84->53|84->53
                    -- GENERATED --
                */
            