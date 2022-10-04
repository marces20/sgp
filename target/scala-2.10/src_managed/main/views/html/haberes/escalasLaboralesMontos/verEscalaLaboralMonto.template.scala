
package views.html.haberes.escalasLaboralesMontos

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
object verEscalaLaboralMonto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[models.haberes.EscalaLaboralMonto],models.haberes.EscalaLaboralMonto,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lcForm: Form[models.haberes.EscalaLaboralMonto],lc:models.haberes.EscalaLaboralMonto):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

def /*4.2*/scripts/*4.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*4.13*/("""
	<script src=""""),_display_(Seq[Any](/*5.16*/routes/*5.22*/.Assets.at("javascripts/haberes/escalaLaboralMonto.js"))),format.raw/*5.77*/("""" type="text/javascript"></script>
""")))};implicit def /*7.2*/implicitFieldConstructor/*7.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.88*/("""
"""),format.raw/*6.2*/("""
"""),format.raw/*7.70*/(""" 

"""),_display_(Seq[Any](/*9.2*/views/*9.7*/.html.haberes.mainHaberes("Vista Monto Escala Laboral",scripts)/*9.70*/ {_display_(Seq[Any](format.raw/*9.72*/("""
	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Vista Monto Escala Laboral</h1>
			</div>
			<div class="col-sm-5">
				
			</div>
		</div>
	</div>		
	<div class="row menu-acciones">
		<div class="col-sm-10">
			<a href=""""),_display_(Seq[Any](/*22.14*/controllers/*22.25*/.haberes.routes.EscalasLaboralesMontosController.crear())),format.raw/*22.81*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nueva Monto</a>
			<a href=""""),_display_(Seq[Any](/*23.14*/controllers/*23.25*/.haberes.routes.EscalasLaboralesMontosController.editar(lc.id))),_display_(Seq[Any](/*23.88*/UriTrack/*23.96*/.get("&"))),format.raw/*23.105*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-edit"></i> Editar</a>
			<a href=""""),_display_(Seq[Any](/*24.14*/controllers/*24.25*/.haberes.routes.EscalasLaboralesMontosController.eliminar(lc.id))),_display_(Seq[Any](/*24.90*/UriTrack/*24.98*/.get("&"))),format.raw/*24.107*/(""""  class="btn btn-default delete-confirm-link"><i class="glyphicon glyphicon-trash icono-eliminar"></i> Eliminar</a>
		</div>
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*27.14*/UriTrack/*27.22*/.getOnNull(controllers.haberes.routes.EscalasLaboralesMontosController.index().absoluteURL()))),format.raw/*27.115*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
		</div> 
	</div>	
	
	<input type="hidden" id="escalaId" name="escalaId" value=""""),_display_(Seq[Any](/*31.61*/lc/*31.63*/.id)),format.raw/*31.66*/(""""/>
	<div class="row">
		<div class="col-sm-6">
			<div class="form-group">
				<label class="control-label">Concepto</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*36.50*/lcForm/*36.56*/.field("liquidacionConcepto.denominacion").value)),format.raw/*36.104*/("""</p>
			</div>
		</div>
		<div class="col-sm-6">
			<div class="form-group">
				<label class="control-label">Escala</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*42.50*/lcForm/*42.56*/.field("escalaLaboral.nombre").value)),format.raw/*42.92*/("""</p>
			</div>
		</div>
	</div>
	<div class="row">	 
		 <div class="col-sm-2">
			<div class="form-group">
				<label class="control-label">Importe</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*50.50*/lcForm/*50.56*/.field("importe_referencia").value)),format.raw/*50.90*/("""</p>
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group">
				<label class="control-label">Importe Tope</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*56.50*/lcForm/*56.56*/.field("importe_compensador").value)),format.raw/*56.91*/("""</p>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-2">
			<div class="form-group">
				<label class="control-label">Estado</label>
				<p class="form-control-static form-control">
					"""),_display_(Seq[Any](/*65.7*/if(lc.activo)/*65.20*/{_display_(Seq[Any](format.raw/*65.21*/("""
				    	Activo				    	
				    """)))}/*67.10*/else/*67.14*/{_display_(Seq[Any](format.raw/*67.15*/("""
						Inactivo
					""")))})),format.raw/*69.7*/("""
				</p>
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group">
				<label class="control-label">Fecha Baja</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*76.50*/lcForm/*76.56*/.field("fecha_baja").value)),format.raw/*76.82*/("""</p>
			</div>
		</div>
	</div>
	 
	 
	 
	 
	 
	
	 
""")))})))}
    }
    
    def render(lcForm:Form[models.haberes.EscalaLaboralMonto],lc:models.haberes.EscalaLaboralMonto): play.api.templates.HtmlFormat.Appendable = apply(lcForm,lc)
    
    def f:((Form[models.haberes.EscalaLaboralMonto],models.haberes.EscalaLaboralMonto) => play.api.templates.HtmlFormat.Appendable) = (lcForm,lc) => apply(lcForm,lc)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/escalasLaboralesMontos/verEscalaLaboralMonto.scala.html
                    HASH: 5b21ad5736be225e6aab31b73e3f0772cae69107
                    MATRIX: 888->1|1083->122|1097->129|1181->133|1232->149|1246->155|1322->210|1389->248|1421->272|1495->87|1522->246|1550->316|1588->320|1600->325|1671->388|1710->390|2002->646|2022->657|2100->713|2238->815|2258->826|2351->889|2368->897|2400->906|2528->998|2548->1009|2643->1074|2660->1082|2692->1091|2892->1255|2909->1263|3025->1356|3214->1509|3225->1511|3250->1514|3461->1689|3476->1695|3547->1743|3757->1917|3772->1923|3830->1959|4071->2164|4086->2170|4142->2204|4358->2384|4373->2390|4430->2425|4672->2632|4694->2645|4733->2646|4787->2681|4800->2685|4839->2686|4892->2708|5111->2891|5126->2897|5174->2923
                    LINES: 26->1|31->4|31->4|33->4|34->5|34->5|34->5|35->7|35->7|36->1|37->6|38->7|40->9|40->9|40->9|40->9|53->22|53->22|53->22|54->23|54->23|54->23|54->23|54->23|55->24|55->24|55->24|55->24|55->24|58->27|58->27|58->27|62->31|62->31|62->31|67->36|67->36|67->36|73->42|73->42|73->42|81->50|81->50|81->50|87->56|87->56|87->56|96->65|96->65|96->65|98->67|98->67|98->67|100->69|107->76|107->76|107->76
                    -- GENERATED --
                */
            