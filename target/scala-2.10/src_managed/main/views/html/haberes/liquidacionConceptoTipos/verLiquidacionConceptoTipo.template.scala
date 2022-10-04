
package views.html.haberes.liquidacionConceptoTipos

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
object verLiquidacionConceptoTipo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[models.haberes.LiquidacionConceptoTipo],models.haberes.LiquidacionConceptoTipo,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lcForm: Form[models.haberes.LiquidacionConceptoTipo],lc:models.haberes.LiquidacionConceptoTipo):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

def /*4.2*/scripts/*4.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*4.13*/("""
	<script src=""""),_display_(Seq[Any](/*5.16*/routes/*5.22*/.Assets.at("javascripts/haberes/liquidacionConceptoTipo.js"))),format.raw/*5.82*/("""" type="text/javascript"></script>
""")))};implicit def /*7.2*/implicitFieldConstructor/*7.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.98*/("""
"""),format.raw/*6.2*/("""
"""),format.raw/*7.70*/(""" 

"""),_display_(Seq[Any](/*9.2*/views/*9.7*/.html.haberes.mainHaberes("Vista Tipo de Concepto",scripts)/*9.66*/ {_display_(Seq[Any](format.raw/*9.68*/("""
	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Vista Tipo de Concepto</h1>
			</div>
			<div class="col-sm-5">
				
			</div>
		</div>
	</div>		
	<div class="row menu-acciones">
		<div class="col-sm-10">
			<a href=""""),_display_(Seq[Any](/*22.14*/controllers/*22.25*/.haberes.routes.LiquidacionConceptoTiposController.crear())),format.raw/*22.83*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo Tipo Concepto</a>
			<a href=""""),_display_(Seq[Any](/*23.14*/controllers/*23.25*/.haberes.routes.LiquidacionConceptoTiposController.editar(lc.id))),_display_(Seq[Any](/*23.90*/UriTrack/*23.98*/.get("&"))),format.raw/*23.107*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-edit"></i> Editar</a>
			<a href=""""),_display_(Seq[Any](/*24.14*/controllers/*24.25*/.haberes.routes.LiquidacionConceptoTiposController.eliminar(lc.id))),_display_(Seq[Any](/*24.92*/UriTrack/*24.100*/.get("&"))),format.raw/*24.109*/(""""  class="btn btn-default delete-confirm-link"><i class="glyphicon glyphicon-trash icono-eliminar"></i> Eliminar</a>
		</div>
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*27.14*/UriTrack/*27.22*/.getOnNull(controllers.haberes.routes.LiquidacionConceptoTiposController.index().absoluteURL()))),format.raw/*27.117*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
		</div> 
	</div>	
	
	<input type="hidden" id="tipoConceptoId" name="tipoConceptoId" value=""""),_display_(Seq[Any](/*31.73*/lc/*31.75*/.id)),format.raw/*31.78*/(""""/>
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
    
    def render(lcForm:Form[models.haberes.LiquidacionConceptoTipo],lc:models.haberes.LiquidacionConceptoTipo): play.api.templates.HtmlFormat.Appendable = apply(lcForm,lc)
    
    def f:((Form[models.haberes.LiquidacionConceptoTipo],models.haberes.LiquidacionConceptoTipo) => play.api.templates.HtmlFormat.Appendable) = (lcForm,lc) => apply(lcForm,lc)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/liquidacionConceptoTipos/verLiquidacionConceptoTipo.scala.html
                    HASH: 1d89567e34f8d88e83e0ca07625de6c6f1585514
                    MATRIX: 905->1|1110->132|1124->139|1208->143|1259->159|1273->165|1354->225|1421->263|1453->287|1527->97|1554->261|1582->331|1620->335|1632->340|1699->399|1738->401|2026->653|2046->664|2126->722|2272->832|2292->843|2387->908|2404->916|2436->925|2564->1017|2584->1028|2681->1095|2699->1103|2731->1112|2931->1276|2948->1284|3066->1379|3267->1544|3278->1546|3303->1549|3521->1731|3536->1737|3580->1759
                    LINES: 26->1|31->4|31->4|33->4|34->5|34->5|34->5|35->7|35->7|36->1|37->6|38->7|40->9|40->9|40->9|40->9|53->22|53->22|53->22|54->23|54->23|54->23|54->23|54->23|55->24|55->24|55->24|55->24|55->24|58->27|58->27|58->27|62->31|62->31|62->31|68->37|68->37|68->37
                    -- GENERATED --
                */
            