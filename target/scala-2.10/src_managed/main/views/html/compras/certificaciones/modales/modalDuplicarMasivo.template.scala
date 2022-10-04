
package views.html.compras.certificaciones.modales

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
object modalDuplicarMasivo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.29*/("""
"""),format.raw/*3.70*/(""" 
																							
"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.compras.routes.CertificacionesAccionesController.duplicarMasivo(), 'id -> "formDuplicarMasivoCertificacion")/*5.143*/ {_display_(Seq[Any](format.raw/*5.145*/("""	
	
	"""),_display_(Seq[Any](/*7.3*/if(flash.containsKey("error"))/*7.33*/ {_display_(Seq[Any](format.raw/*7.35*/("""
		<div class="alert alert-danger"><i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*8.84*/flash/*8.89*/.get("error"))),format.raw/*8.102*/("""</div>
	""")))})),format.raw/*9.3*/("""
	
	"""),_display_(Seq[Any](/*11.3*/if(flash.containsKey("success"))/*11.35*/ {_display_(Seq[Any](format.raw/*11.37*/("""
		<div class="alert alert-success"><i class="glyphicon glyphicon-ok-circle"></i> """),_display_(Seq[Any](/*12.83*/flash/*12.88*/.get("success"))),format.raw/*12.103*/("""</div>
	""")))})),format.raw/*13.3*/("""
	<div class="row">
		<div class="col-sm-3">
			<label for="inputPeriodo" class="control-label">Periodo</label> 
			<div class="input-group">
				"""),_display_(Seq[Any](/*18.6*/inputText(formBuscador("periodo_id_modal"),'hidden -> "hidden",'id -> "periodo_id_modal"))),format.raw/*18.95*/("""
				"""),_display_(Seq[Any](/*19.6*/inputText(formBuscador("periodo_modal"),'class -> "form-control",'id -> "periodo_modal"))),format.raw/*19.94*/("""
				<span class="input-group-addon">
				<a href="#" class="searchModal"
							id="searchPeriodoModal" 
							data-title="Selección de Periodo" 
							data-url=""""),_display_(Seq[Any](/*24.19*/controllers/*24.30*/.contabilidad.routes.PeriodosController.modalBuscar())),format.raw/*24.83*/("""" 
							data-height="650" 
							data-width="700" 
							data-listen="modal.seleccion.periodo.simple" 
							data-label="#periodo_modal" 
							data-field="#periodo_id_modal">
					<i class="glyphicon glyphicon-search"></i>
				</a>
				</span>
			</div>
			
			"""),_display_(Seq[Any](/*35.5*/formBuscador("periodo_id_modal")/*35.37*/.error.map/*35.47*/{ error =>_display_(Seq[Any](format.raw/*35.57*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*36.30*/error/*36.35*/.message)),format.raw/*36.43*/("""</div>
			""")))})),format.raw/*37.5*/("""
		</div>
		
	</div>
	<div class="row">
		<div class="col-sm-12">&nbsp</div>
	</div>
	<div class="row">
		<div class="col-sm-4" style="border-right:1px solid black;">
			<div class="form-group">
				<label for="porcentaje_modal" class="control-label">Porcentaje Parcial(%)</label> 
				<input name="porcentaje_modal" id="porcentaje_modal" class="form-control date"/>
			</div>
		</div>
		<div class="col-sm-4">
			<div class="form-group">
				<label for="total_porcentaje_modal" class="control-label">Porcentaje Total (%)</label> 
				<input name="total_porcentaje_modal" id="total_porcentaje_modal" class="form-control date"/>
			</div>
		</div>
	</div>
	<div class="row">
		
	</div>
	<div class="row">
		<div class="col-sm-5"><br />
			<button type="submit" class="btn btn-default" title="Duplicar certificaciones"><i class="glyphicon glyphicon-arrow-right"></i> Duplicar</button>
		</div>
	</div>
""")))})),format.raw/*66.2*/("""
<script>
$( function()"""),format.raw/*68.14*/("""{"""),format.raw/*68.15*/("""
	if($("#periodo_modal").length)"""),format.raw/*69.32*/("""{"""),format.raw/*69.33*/("""
		var options = """),format.raw/*70.17*/("""{"""),format.raw/*70.18*/("""
				script:"/contabilidad/suggestPeriodo/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*76.30*/("""{"""),format.raw/*76.31*/(""" 
											$("#periodo_id_modal").val(obj.id); 
										 """),format.raw/*78.12*/("""}"""),format.raw/*78.13*/("""
			"""),format.raw/*79.4*/("""}"""),format.raw/*79.5*/(""";
		var as_json = new bsn.AutoSuggest('periodo_modal', options);
	"""),format.raw/*81.2*/("""}"""),format.raw/*81.3*/("""
	
	$('#searchPeriodoModal').modalSearch();		 
"""),format.raw/*84.1*/("""}"""),format.raw/*84.2*/(""");
</script>
"""),_display_(Seq[Any](/*86.2*/flash()/*86.9*/.clear())))}
    }
    
    def render(formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(formBuscador)
    
    def f:((DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (formBuscador) => apply(formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:43 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/certificaciones/modales/modalDuplicarMasivo.scala.html
                    HASH: 378294aa23c2cc33326a6106f76b8d6d29575944
                    MATRIX: 825->1|954->47|986->71|1060->28|1088->115|1149->142|1162->148|1306->283|1346->285|1386->291|1424->321|1463->323|1582->407|1595->412|1630->425|1669->434|1709->439|1750->471|1790->473|1909->556|1923->561|1961->576|2001->585|2183->732|2294->821|2335->827|2445->915|2647->1081|2667->1092|2742->1145|3046->1414|3087->1446|3106->1456|3154->1466|3220->1496|3234->1501|3264->1509|3306->1520|4238->2421|4289->2444|4318->2445|4378->2477|4407->2478|4452->2495|4481->2496|4656->2643|4685->2644|4774->2705|4803->2706|4834->2710|4862->2711|4955->2777|4983->2778|5057->2825|5085->2826|5134->2840|5149->2847
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|35->7|35->7|35->7|36->8|36->8|36->8|37->9|39->11|39->11|39->11|40->12|40->12|40->12|41->13|46->18|46->18|47->19|47->19|52->24|52->24|52->24|63->35|63->35|63->35|63->35|64->36|64->36|64->36|65->37|94->66|96->68|96->68|97->69|97->69|98->70|98->70|104->76|104->76|106->78|106->78|107->79|107->79|109->81|109->81|112->84|112->84|114->86|114->86
                    -- GENERATED --
                */
            