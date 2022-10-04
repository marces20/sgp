
package views.html.recupero.recuperoFactura

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
object editarRecuperoFactura extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[models.recupero.RecuperoFactura],models.recupero.RecuperoFactura,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(recuperoFacturaForm: Form[models.recupero.RecuperoFactura],recuperoFactura:models.recupero.RecuperoFactura):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

def /*5.2*/scripts/*5.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*5.13*/("""
	<script src=""""),_display_(Seq[Any](/*6.16*/routes/*6.22*/.Assets.at("javascripts/recupero/recuperoFactura.js"))),format.raw/*6.75*/("""" type="text/javascript"></script>
""")))};implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.110*/("""
"""),format.raw/*3.70*/("""

"""),format.raw/*7.2*/("""

"""),_display_(Seq[Any](/*9.2*/views/*9.7*/.html.recupero.mainRecupero("Modificar Factura", scripts)/*9.64*/ {_display_(Seq[Any](format.raw/*9.66*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Editar factura</h1>
			</div>

			<div class="col-sm-5">
				<div class="dropdown pull-right">
				 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 	<i class="glyphicon glyphicon-list-alt"></i>
				    Reportes
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				    
				  </ul>
				</div>
				
				<div class="dropdown pull-right btn-header">
				 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 	<i class="glyphicon glyphicon-cog"></i>
				    Acciones
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				  	
				  </ul>
				</div>
					
				<div class="pull-right btn-header">
					<a href=""""),_display_(Seq[Any](/*41.16*/controllers/*41.27*/.recupero.routes.RecuperoFacturasController.crear())),format.raw/*41.78*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nueva Factura</a>
				</div>
			</div>
			
			
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*49.3*/if(flash.containsKey("error"))/*49.33*/ {_display_(Seq[Any](format.raw/*49.35*/("""
		<div class="alert alert-danger">
			"""),_display_(Seq[Any](/*51.5*/flash/*51.10*/.get("error"))),format.raw/*51.23*/("""
		</div>
	""")))})),format.raw/*53.3*/("""
	

	"""),_display_(Seq[Any](/*56.3*/helper/*56.9*/.form(action = controllers.recupero.routes.RecuperoFacturasController.actualizar(recuperoFactura.id))/*56.110*/ {_display_(Seq[Any](format.raw/*56.112*/("""

	
		"""),_display_(Seq[Any](/*59.4*/inputText(recuperoFacturaForm("id"), 'hidden -> "hidden"))),format.raw/*59.61*/("""
		"""),_display_(Seq[Any](/*60.4*/views/*60.9*/.html.recupero.recuperoFactura.formRecuperoFactura(recuperoFacturaForm))),format.raw/*60.80*/("""
		"""),_display_(Seq[Any](/*61.4*/views/*61.9*/.html.recupero.recuperoFactura.tabsRecuperoFactura(true, recuperoFacturaForm))),format.raw/*61.86*/("""	
		
		<h4>Estado actual: 	<b>"""),_display_(Seq[Any](/*63.27*/recuperoFactura/*63.42*/.estado.nombre)),format.raw/*63.56*/("""</b></h4>
		<div class="row margin-bottom-25">	
			
		</div>
		
	""")))})),format.raw/*68.3*/("""

""")))})))}
    }
    
    def render(recuperoFacturaForm:Form[models.recupero.RecuperoFactura],recuperoFactura:models.recupero.RecuperoFactura): play.api.templates.HtmlFormat.Appendable = apply(recuperoFacturaForm,recuperoFactura)
    
    def f:((Form[models.recupero.RecuperoFactura],models.recupero.RecuperoFactura) => play.api.templates.HtmlFormat.Appendable) = (recuperoFacturaForm,recuperoFactura) => apply(recuperoFacturaForm,recuperoFactura)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:35 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/recupero/recuperoFactura/editarRecuperoFactura.scala.html
                    HASH: 949e93b3c2a57ae7538d13ef0518ee6d2076d8eb
                    MATRIX: 878->1|1079->199|1093->206|1177->210|1228->226|1242->232|1316->285|1383->128|1415->152|1490->109|1518->196|1546->321|1583->324|1595->329|1660->386|1699->388|2701->1354|2721->1365|2794->1416|2971->1558|3010->1588|3050->1590|3125->1630|3139->1635|3174->1648|3217->1660|3258->1666|3272->1672|3383->1773|3424->1775|3466->1782|3545->1839|3584->1843|3597->1848|3690->1919|3729->1923|3742->1928|3841->2005|3908->2036|3932->2051|3968->2065|4065->2131
                    LINES: 26->1|29->5|29->5|31->5|32->6|32->6|32->6|33->3|33->3|34->1|35->3|37->7|39->9|39->9|39->9|39->9|71->41|71->41|71->41|79->49|79->49|79->49|81->51|81->51|81->51|83->53|86->56|86->56|86->56|86->56|89->59|89->59|90->60|90->60|90->60|91->61|91->61|91->61|93->63|93->63|93->63|98->68
                    -- GENERATED --
                */
            