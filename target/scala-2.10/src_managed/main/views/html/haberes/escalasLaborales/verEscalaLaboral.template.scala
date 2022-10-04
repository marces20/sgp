
package views.html.haberes.escalasLaborales

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
object verEscalaLaboral extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[models.haberes.EscalaLaboral],models.haberes.EscalaLaboral,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lcForm: Form[models.haberes.EscalaLaboral],lc:models.haberes.EscalaLaboral):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

def /*4.2*/scripts/*4.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*4.13*/("""
	<script src=""""),_display_(Seq[Any](/*5.16*/routes/*5.22*/.Assets.at("javascripts/haberes/escalaLaboral.js"))),format.raw/*5.72*/("""" type="text/javascript"></script>
""")))};implicit def /*7.2*/implicitFieldConstructor/*7.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.78*/("""
"""),format.raw/*6.2*/("""
"""),format.raw/*7.70*/(""" 

"""),_display_(Seq[Any](/*9.2*/views/*9.7*/.html.haberes.mainHaberes("Vista Escala Laboral",scripts)/*9.64*/ {_display_(Seq[Any](format.raw/*9.66*/("""
	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Vista Escala Laboral</h1>
			</div>
			<div class="col-sm-5">
				
			</div>
		</div>
	</div>		
	<div class="row menu-acciones">
		<div class="col-sm-10">
			<a href=""""),_display_(Seq[Any](/*22.14*/controllers/*22.25*/.haberes.routes.EscalasLaboralesController.crear())),format.raw/*22.75*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nueva Escala</a>
			<a href=""""),_display_(Seq[Any](/*23.14*/controllers/*23.25*/.haberes.routes.EscalasLaboralesController.editar(lc.id))),_display_(Seq[Any](/*23.82*/UriTrack/*23.90*/.get("&"))),format.raw/*23.99*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-edit"></i> Editar</a>
			<a href=""""),_display_(Seq[Any](/*24.14*/controllers/*24.25*/.haberes.routes.EscalasLaboralesController.eliminar(lc.id))),_display_(Seq[Any](/*24.84*/UriTrack/*24.92*/.get("&"))),format.raw/*24.101*/(""""  class="btn btn-default delete-confirm-link"><i class="glyphicon glyphicon-trash icono-eliminar"></i> Eliminar</a>
		</div>
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*27.14*/UriTrack/*27.22*/.getOnNull(controllers.haberes.routes.EscalasLaboralesController.index().absoluteURL()))),format.raw/*27.109*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
		</div> 
	</div>	
	
	<input type="hidden" id="escalaId" name="escalaId" value=""""),_display_(Seq[Any](/*31.61*/lc/*31.63*/.id)),format.raw/*31.66*/(""""/>
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
    
    def render(lcForm:Form[models.haberes.EscalaLaboral],lc:models.haberes.EscalaLaboral): play.api.templates.HtmlFormat.Appendable = apply(lcForm,lc)
    
    def f:((Form[models.haberes.EscalaLaboral],models.haberes.EscalaLaboral) => play.api.templates.HtmlFormat.Appendable) = (lcForm,lc) => apply(lcForm,lc)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/escalasLaborales/verEscalaLaboral.scala.html
                    HASH: c3bc1c3c311d13628d43ff12f59b9f216112cfe0
                    MATRIX: 867->1|1052->112|1066->119|1150->123|1201->139|1215->145|1286->195|1353->233|1385->257|1459->77|1486->231|1514->301|1552->305|1564->310|1629->367|1668->369|1954->619|1974->630|2046->680|2185->783|2205->794|2292->851|2309->859|2340->868|2468->960|2488->971|2577->1030|2594->1038|2626->1047|2826->1211|2843->1219|2953->1306|3142->1459|3153->1461|3178->1464|3397->1647|3412->1653|3456->1675
                    LINES: 26->1|31->4|31->4|33->4|34->5|34->5|34->5|35->7|35->7|36->1|37->6|38->7|40->9|40->9|40->9|40->9|53->22|53->22|53->22|54->23|54->23|54->23|54->23|54->23|55->24|55->24|55->24|55->24|55->24|58->27|58->27|58->27|62->31|62->31|62->31|68->37|68->37|68->37
                    -- GENERATED --
                */
            