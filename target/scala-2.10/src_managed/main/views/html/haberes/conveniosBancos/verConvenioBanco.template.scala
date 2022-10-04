
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
object verConvenioBanco extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[models.haberes.ConvenioBanco],models.haberes.ConvenioBanco,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lcForm: Form[models.haberes.ConvenioBanco],lc:models.haberes.ConvenioBanco):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

def /*4.2*/scripts/*4.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*4.13*/("""
	<script src=""""),_display_(Seq[Any](/*5.16*/routes/*5.22*/.Assets.at("javascripts/haberes/convenioBanco.js"))),format.raw/*5.72*/("""" type="text/javascript"></script>
""")))};implicit def /*7.2*/implicitFieldConstructor/*7.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.78*/("""
"""),format.raw/*6.2*/("""
"""),format.raw/*7.70*/(""" 

"""),_display_(Seq[Any](/*9.2*/views/*9.7*/.html.haberes.mainHaberes("Vista Convenio Banco",scripts)/*9.64*/ {_display_(Seq[Any](format.raw/*9.66*/("""
	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Vista Convenio Banco</h1>
			</div>
			<div class="col-sm-5">
				
			</div>
		</div>
	</div>		
	<div class="row menu-acciones">
		<div class="col-sm-10">
			<a href=""""),_display_(Seq[Any](/*22.14*/controllers/*22.25*/.haberes.routes.ConveniosBancosController.crear())),format.raw/*22.74*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo Convenio</a>
			<a href=""""),_display_(Seq[Any](/*23.14*/controllers/*23.25*/.haberes.routes.ConveniosBancosController.editar(lc.id))),_display_(Seq[Any](/*23.81*/UriTrack/*23.89*/.get("&"))),format.raw/*23.98*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-edit"></i> Editar</a>
			<a href=""""),_display_(Seq[Any](/*24.14*/controllers/*24.25*/.haberes.routes.ConveniosBancosController.eliminar(lc.id))),_display_(Seq[Any](/*24.83*/UriTrack/*24.91*/.get("&"))),format.raw/*24.100*/(""""  class="btn btn-default delete-confirm-link"><i class="glyphicon glyphicon-trash icono-eliminar"></i> Eliminar</a>
		</div>
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*27.14*/UriTrack/*27.22*/.getOnNull(controllers.haberes.routes.ConveniosBancosController.index().absoluteURL()))),format.raw/*27.108*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
		</div> 
	</div>	
	
	<input type="hidden" id="convenioId" name="cargoId" value=""""),_display_(Seq[Any](/*31.62*/lc/*31.64*/.id)),format.raw/*31.67*/(""""/>
	<div class="row">
		
		 <div class="col-sm-5">
			<div class="form-group">
				<label class="control-label">Denominacion</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*37.50*/lcForm/*37.56*/.field("nombre").value)),format.raw/*37.78*/("""</p>
			</div>
		</div>
		 
	</div>
	 
	 
	 
	 
	 
	
	 
""")))})))}
    }
    
    def render(lcForm:Form[models.haberes.ConvenioBanco],lc:models.haberes.ConvenioBanco): play.api.templates.HtmlFormat.Appendable = apply(lcForm,lc)
    
    def f:((Form[models.haberes.ConvenioBanco],models.haberes.ConvenioBanco) => play.api.templates.HtmlFormat.Appendable) = (lcForm,lc) => apply(lcForm,lc)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/conveniosBancos/verConvenioBanco.scala.html
                    HASH: e9dbe3b4e0be22368c5188e5c1fa11fb668c8586
                    MATRIX: 866->1|1051->112|1065->119|1149->123|1200->139|1214->145|1285->195|1352->233|1384->257|1458->77|1485->231|1513->301|1551->305|1563->310|1628->367|1667->369|1953->619|1973->630|2044->679|2185->784|2205->795|2291->851|2308->859|2339->868|2467->960|2487->971|2575->1029|2592->1037|2624->1046|2824->1210|2841->1218|2950->1304|3140->1458|3151->1460|3176->1463|3395->1646|3410->1652|3454->1674
                    LINES: 26->1|31->4|31->4|33->4|34->5|34->5|34->5|35->7|35->7|36->1|37->6|38->7|40->9|40->9|40->9|40->9|53->22|53->22|53->22|54->23|54->23|54->23|54->23|54->23|55->24|55->24|55->24|55->24|55->24|58->27|58->27|58->27|62->31|62->31|62->31|68->37|68->37|68->37
                    -- GENERATED --
                */
            