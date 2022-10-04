
package views.html.haberes.centrosCostos

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
object verCentroCosto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[models.haberes.CentroCosto],models.haberes.CentroCosto,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lcForm: Form[models.haberes.CentroCosto],lc:models.haberes.CentroCosto):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

def /*4.2*/scripts/*4.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*4.13*/("""
	<script src=""""),_display_(Seq[Any](/*5.16*/routes/*5.22*/.Assets.at("javascripts/haberes/centroCosto.js"))),format.raw/*5.70*/("""" type="text/javascript"></script>
""")))};implicit def /*7.2*/implicitFieldConstructor/*7.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.74*/("""
"""),format.raw/*6.2*/("""
"""),format.raw/*7.70*/(""" 

"""),_display_(Seq[Any](/*9.2*/views/*9.7*/.html.haberes.mainHaberes("Vista Centro Costo",scripts)/*9.62*/ {_display_(Seq[Any](format.raw/*9.64*/("""
	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Vista Centro Costo</h1>
			</div>
			<div class="col-sm-5">
				
			</div>
		</div>
	</div>		
	<div class="row menu-acciones">
		<div class="col-sm-10">
			<a href=""""),_display_(Seq[Any](/*22.14*/controllers/*22.25*/.haberes.routes.CentrosCostosController.crear())),format.raw/*22.72*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo Centro</a>
			<a href=""""),_display_(Seq[Any](/*23.14*/controllers/*23.25*/.haberes.routes.CentrosCostosController.editar(lc.id))),_display_(Seq[Any](/*23.79*/UriTrack/*23.87*/.get("&"))),format.raw/*23.96*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-edit"></i> Editar</a>
			<a href=""""),_display_(Seq[Any](/*24.14*/controllers/*24.25*/.haberes.routes.CentrosCostosController.eliminar(lc.id))),_display_(Seq[Any](/*24.81*/UriTrack/*24.89*/.get("&"))),format.raw/*24.98*/(""""  class="btn btn-default delete-confirm-link"><i class="glyphicon glyphicon-trash icono-eliminar"></i> Eliminar</a>
		</div>
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*27.14*/UriTrack/*27.22*/.getOnNull(controllers.haberes.routes.CentrosCostosController.index().absoluteURL()))),format.raw/*27.106*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
		</div> 
	</div>	
	
	<input type="hidden" id="cargoId" name="cargoId" value=""""),_display_(Seq[Any](/*31.59*/lc/*31.61*/.id)),format.raw/*31.64*/(""""/>
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
    
    def render(lcForm:Form[models.haberes.CentroCosto],lc:models.haberes.CentroCosto): play.api.templates.HtmlFormat.Appendable = apply(lcForm,lc)
    
    def f:((Form[models.haberes.CentroCosto],models.haberes.CentroCosto) => play.api.templates.HtmlFormat.Appendable) = (lcForm,lc) => apply(lcForm,lc)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/centrosCostos/verCentroCosto.scala.html
                    HASH: 91d273c3fd737d4c6b419c8bf9e07d93fc1dff9b
                    MATRIX: 858->1|1039->108|1053->115|1137->119|1188->135|1202->141|1271->189|1338->227|1370->251|1444->73|1471->225|1499->295|1537->299|1549->304|1612->359|1651->361|1935->609|1955->620|2024->667|2163->770|2183->781|2267->835|2284->843|2315->852|2443->944|2463->955|2549->1011|2566->1019|2597->1028|2797->1192|2814->1200|2921->1284|3108->1435|3119->1437|3144->1440|3363->1623|3378->1629|3422->1651
                    LINES: 26->1|31->4|31->4|33->4|34->5|34->5|34->5|35->7|35->7|36->1|37->6|38->7|40->9|40->9|40->9|40->9|53->22|53->22|53->22|54->23|54->23|54->23|54->23|54->23|55->24|55->24|55->24|55->24|55->24|58->27|58->27|58->27|62->31|62->31|62->31|68->37|68->37|68->37
                    -- GENERATED --
                */
            