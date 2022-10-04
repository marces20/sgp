
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
object verCargoLaboral extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[models.haberes.CargoLaboral],models.haberes.CargoLaboral,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lcForm: Form[models.haberes.CargoLaboral],lc:models.haberes.CargoLaboral):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

def /*4.2*/scripts/*4.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*4.13*/("""
	<script src=""""),_display_(Seq[Any](/*5.16*/routes/*5.22*/.Assets.at("javascripts/haberes/cargoLaboral.js"))),format.raw/*5.71*/("""" type="text/javascript"></script>
""")))};implicit def /*7.2*/implicitFieldConstructor/*7.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.76*/("""
"""),format.raw/*6.2*/("""
"""),format.raw/*7.70*/(""" 

"""),_display_(Seq[Any](/*9.2*/views/*9.7*/.html.haberes.mainHaberes("Vista Cargo Laboral",scripts)/*9.63*/ {_display_(Seq[Any](format.raw/*9.65*/("""
	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Vista Cargo Laboral</h1>
			</div>
			<div class="col-sm-5">
				
			</div>
		</div>
	</div>		
	<div class="row menu-acciones">
		<div class="col-sm-10">
			<a href=""""),_display_(Seq[Any](/*22.14*/controllers/*22.25*/.haberes.routes.CargosLaboralesController.crear())),format.raw/*22.74*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo Cargo</a>
			<a href=""""),_display_(Seq[Any](/*23.14*/controllers/*23.25*/.haberes.routes.CargosLaboralesController.editar(lc.id))),_display_(Seq[Any](/*23.81*/UriTrack/*23.89*/.get("&"))),format.raw/*23.98*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-edit"></i> Editar</a>
			<a href=""""),_display_(Seq[Any](/*24.14*/controllers/*24.25*/.haberes.routes.CargosLaboralesController.eliminar(lc.id))),_display_(Seq[Any](/*24.83*/UriTrack/*24.91*/.get("&"))),format.raw/*24.100*/(""""  class="btn btn-default delete-confirm-link"><i class="glyphicon glyphicon-trash icono-eliminar"></i> Eliminar</a>
		</div>
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*27.14*/UriTrack/*27.22*/.getOnNull(controllers.haberes.routes.CargosLaboralesController.index().absoluteURL()))),format.raw/*27.108*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
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
    
    def render(lcForm:Form[models.haberes.CargoLaboral],lc:models.haberes.CargoLaboral): play.api.templates.HtmlFormat.Appendable = apply(lcForm,lc)
    
    def f:((Form[models.haberes.CargoLaboral],models.haberes.CargoLaboral) => play.api.templates.HtmlFormat.Appendable) = (lcForm,lc) => apply(lcForm,lc)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/cargosLaborales/verCargoLaboral.scala.html
                    HASH: 5e9e1388c332fb4dbc93f6c2c7c83776707c5d7a
                    MATRIX: 863->1|1046->110|1060->117|1144->121|1195->137|1209->143|1279->192|1346->230|1378->254|1452->75|1479->228|1507->298|1545->302|1557->307|1621->363|1660->365|1945->614|1965->625|2036->674|2174->776|2194->787|2280->843|2297->851|2328->860|2456->952|2476->963|2564->1021|2581->1029|2613->1038|2813->1202|2830->1210|2939->1296|3126->1447|3137->1449|3162->1452|3381->1635|3396->1641|3440->1663
                    LINES: 26->1|31->4|31->4|33->4|34->5|34->5|34->5|35->7|35->7|36->1|37->6|38->7|40->9|40->9|40->9|40->9|53->22|53->22|53->22|54->23|54->23|54->23|54->23|54->23|55->24|55->24|55->24|55->24|55->24|58->27|58->27|58->27|62->31|62->31|62->31|68->37|68->37|68->37
                    -- GENERATED --
                */
            