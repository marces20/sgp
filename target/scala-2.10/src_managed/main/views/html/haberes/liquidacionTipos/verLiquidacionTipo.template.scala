
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
object verLiquidacionTipo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[models.haberes.LiquidacionTipo],models.haberes.LiquidacionTipo,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lcForm: Form[models.haberes.LiquidacionTipo],lc:models.haberes.LiquidacionTipo):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

def /*4.2*/scripts/*4.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*4.13*/("""
	<script src=""""),_display_(Seq[Any](/*5.16*/routes/*5.22*/.Assets.at("javascripts/haberes/liquidacionTipo.js"))),format.raw/*5.74*/("""" type="text/javascript"></script>
""")))};implicit def /*7.2*/implicitFieldConstructor/*7.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.82*/("""
"""),format.raw/*6.2*/("""
"""),format.raw/*7.70*/(""" 

"""),_display_(Seq[Any](/*9.2*/views/*9.7*/.html.haberes.mainHaberes("Vista Tipo de Liquidación",scripts)/*9.69*/ {_display_(Seq[Any](format.raw/*9.71*/("""
	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Vista Tipo de Liquidación</h1>
			</div>
			<div class="col-sm-5">
				
			</div>
		</div>
	</div>		
	<div class="row menu-acciones">
		<div class="col-sm-10">
			<a href=""""),_display_(Seq[Any](/*22.14*/controllers/*22.25*/.haberes.routes.LiquidacionTiposController.crear())),format.raw/*22.75*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo Tipo Liquidacion</a>
			<a href=""""),_display_(Seq[Any](/*23.14*/controllers/*23.25*/.haberes.routes.LiquidacionTiposController.editar(lc.id))),_display_(Seq[Any](/*23.82*/UriTrack/*23.90*/.get("&"))),format.raw/*23.99*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-edit"></i> Editar</a>
			<a href=""""),_display_(Seq[Any](/*24.14*/controllers/*24.25*/.haberes.routes.LiquidacionTiposController.eliminar(lc.id))),_display_(Seq[Any](/*24.84*/UriTrack/*24.92*/.get("&"))),format.raw/*24.101*/(""""  class="btn btn-default delete-confirm-link"><i class="glyphicon glyphicon-trash icono-eliminar"></i> Eliminar</a>
		</div>
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*27.14*/UriTrack/*27.22*/.getOnNull(controllers.haberes.routes.LiquidacionTiposController.index().absoluteURL()))),format.raw/*27.109*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
		</div> 
	</div>	
	
	<input type="hidden" id="tipoId" name="tipoId" value=""""),_display_(Seq[Any](/*31.57*/lc/*31.59*/.id)),format.raw/*31.62*/(""""/>
	<div class="row">
		<div class="col-sm-5">
		<div class="form-group">
			<label class="control-label">Denominacion</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*36.49*/lcForm/*36.55*/.field("nombre").value)),format.raw/*36.77*/("""</p>
		</div>
		</div>
		 
		 <div class="col-sm-3">
			<div class="checkbox">
				<label class="control-label">
					Excluido Ganancias
					"""),_display_(Seq[Any](/*44.7*/checkbox(lcForm("excluido_ganancias"), 'disabled -> "disabled"))),format.raw/*44.70*/("""
				</label>
			</div>
		</div>	
	</div>
	 
	 
	 
	 
	 
	
	 
""")))})))}
    }
    
    def render(lcForm:Form[models.haberes.LiquidacionTipo],lc:models.haberes.LiquidacionTipo): play.api.templates.HtmlFormat.Appendable = apply(lcForm,lc)
    
    def f:((Form[models.haberes.LiquidacionTipo],models.haberes.LiquidacionTipo) => play.api.templates.HtmlFormat.Appendable) = (lcForm,lc) => apply(lcForm,lc)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/liquidacionTipos/verLiquidacionTipo.scala.html
                    HASH: 5b6f11cc0067969b5f8c5b92b88236b91fdbed30
                    MATRIX: 873->1|1062->116|1076->123|1160->127|1211->143|1225->149|1298->201|1365->239|1397->263|1471->81|1498->237|1526->307|1564->311|1576->316|1646->378|1685->380|1976->635|1996->646|2068->696|2217->809|2237->820|2324->877|2341->885|2372->894|2500->986|2520->997|2609->1056|2626->1064|2658->1073|2858->1237|2875->1245|2985->1332|3170->1481|3181->1483|3206->1486|3418->1662|3433->1668|3477->1690|3655->1833|3740->1896
                    LINES: 26->1|31->4|31->4|33->4|34->5|34->5|34->5|35->7|35->7|36->1|37->6|38->7|40->9|40->9|40->9|40->9|53->22|53->22|53->22|54->23|54->23|54->23|54->23|54->23|55->24|55->24|55->24|55->24|55->24|58->27|58->27|58->27|62->31|62->31|62->31|67->36|67->36|67->36|75->44|75->44
                    -- GENERATED --
                */
            