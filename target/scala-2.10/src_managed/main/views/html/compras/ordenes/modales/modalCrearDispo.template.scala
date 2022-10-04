
package views.html.compras.ordenes.modales

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
object modalCrearDispo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[DynamicForm,Long,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(dispoForm: DynamicForm,id:Long):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.34*/("""
"""),format.raw/*3.70*/(""" 
								
																			
"""),_display_(Seq[Any](/*6.2*/helper/*6.8*/.form(action = controllers.compras.routes.OrdenesAccionesController.crearDispo(), 'id -> "formCrearDispo")/*6.114*/ {_display_(Seq[Any](format.raw/*6.116*/("""	
"""),_display_(Seq[Any](/*7.2*/views/*7.7*/.html.tags.successError())),format.raw/*7.32*/("""	
	<input name="id_orden" id="id_orden" type="hidden" value=""""),_display_(Seq[Any](/*8.61*/id)),format.raw/*8.63*/(""""/>
	
	
	<div class="row">
		 
		<div class="col-sm-3">
			<label for="inputNombre" class="control-label">Numero</label> 
			<div class="input-group """),_display_(Seq[Any](/*15.29*/if(dispoForm.error("numero") != null)/*15.66*/ {_display_(Seq[Any](format.raw/*15.68*/("""has-error""")))}/*15.78*/else/*15.82*/{_display_(Seq[Any](format.raw/*15.83*/("""has-required""")))})),format.raw/*15.96*/("""">
				"""),_display_(Seq[Any](/*16.6*/inputText(dispoForm("numero"), 'class -> "form-control"))),format.raw/*16.62*/("""
			 	<span class="input-group-addon">
				<a href="#" id="getLastNumeroDispo" 
							data-url=""""),_display_(Seq[Any](/*19.19*/controllers/*19.30*/.expediente.routes.DisposController.getLastNumeroDispoByOrden())),format.raw/*19.93*/("""">
							<i class="glyphicon glyphicon-record"></i></a></span>
			</div>
			<div class="hide errorOp text-error"></div>
		</div>
		
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*26.28*/if(dispoForm.error("fecha") != null)/*26.64*/ {_display_(Seq[Any](format.raw/*26.66*/("""has-error""")))})),format.raw/*26.76*/("""">
				<label for="fecha" class="control-label">Fecha</label> 
				"""),_display_(Seq[Any](/*28.6*/inputText(dispoForm("fecha"),'class -> "form-control date", 'id -> "fecha"))),format.raw/*28.81*/("""
				 
			</div>
		</div>
		 
		<div class="col-sm-6">
			<div class="form-group">
				<label for="inputNombre" class="control-label">Descripción</label> 
				"""),_display_(Seq[Any](/*36.6*/inputText(dispoForm("descripcion"), 'class -> "form-control"))),format.raw/*36.67*/("""
				 
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="col-sm-5"><br />
			<button type="submit" class="btn btn-default" title="Crear dispo"><i class="glyphicon glyphicon-arrow-right"></i> 
			Crear</button>
		</div>
	</div>

""")))})),format.raw/*49.2*/("""
<script>
$( function()"""),format.raw/*51.14*/("""{"""),format.raw/*51.15*/("""
	$(".inputNumericMask").numeric_input();
	 
	$(document).on("click", '#getLastNumeroDispo', function()"""),format.raw/*54.59*/("""{"""),format.raw/*54.60*/("""
		 
		if($("#id_orden").val() == "")"""),format.raw/*56.33*/("""{"""),format.raw/*56.34*/("""
			alert ("Debe tener asignado una orden para poder sugerir el N° disposicion.");
		"""),format.raw/*58.3*/("""}"""),format.raw/*58.4*/("""else"""),format.raw/*58.8*/("""{"""),format.raw/*58.9*/(""" 
			 
			var url = $(this).attr("data-url");
			var data = $("#id_orden").serialize();
			$.post(url, data, function(data)"""),format.raw/*62.36*/("""{"""),format.raw/*62.37*/("""
				if(data.success) """),format.raw/*63.22*/("""{"""),format.raw/*63.23*/("""
					$(".errorOp").html("N° sugerido: "+data.numero);
					$(".errorOp").removeClass("hide");
				"""),format.raw/*66.5*/("""}"""),format.raw/*66.6*/(""" else """),format.raw/*66.12*/("""{"""),format.raw/*66.13*/("""
					$(".errorOp").html(data.message)
					$(".errorOp").removeClass("hide");
				"""),format.raw/*69.5*/("""}"""),format.raw/*69.6*/("""
			"""),format.raw/*70.4*/("""}"""),format.raw/*70.5*/(""");
			 
		"""),format.raw/*72.3*/("""}"""),format.raw/*72.4*/("""
	"""),format.raw/*73.2*/("""}"""),format.raw/*73.3*/(""");
"""),format.raw/*74.1*/("""}"""),format.raw/*74.2*/(""");
</script>
 """))}
    }
    
    def render(dispoForm:DynamicForm,id:Long): play.api.templates.HtmlFormat.Appendable = apply(dispoForm,id)
    
    def f:((DynamicForm,Long) => play.api.templates.HtmlFormat.Appendable) = (dispoForm,id) => apply(dispoForm,id)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:44 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/ordenes/modales/modalCrearDispo.scala.html
                    HASH: ccb2b9586ae438ba78b83d5996c0ed71ab41085c
                    MATRIX: 818->1|952->52|984->76|1058->33|1086->120|1152->152|1165->158|1280->264|1320->266|1357->269|1369->274|1415->299|1512->361|1535->363|1721->513|1767->550|1807->552|1836->562|1849->566|1888->567|1933->580|1976->588|2054->644|2188->742|2208->753|2293->816|2514->1001|2559->1037|2599->1039|2641->1049|2744->1117|2841->1192|3036->1352|3119->1413|3391->1654|3442->1677|3471->1678|3602->1781|3631->1782|3696->1819|3725->1820|3837->1905|3865->1906|3896->1910|3924->1911|4075->2034|4104->2035|4154->2057|4183->2058|4309->2157|4337->2158|4371->2164|4400->2165|4510->2248|4538->2249|4569->2253|4597->2254|4634->2264|4662->2265|4691->2267|4719->2268|4749->2271|4777->2272
                    LINES: 26->1|29->3|29->3|30->1|31->3|34->6|34->6|34->6|34->6|35->7|35->7|35->7|36->8|36->8|43->15|43->15|43->15|43->15|43->15|43->15|43->15|44->16|44->16|47->19|47->19|47->19|54->26|54->26|54->26|54->26|56->28|56->28|64->36|64->36|77->49|79->51|79->51|82->54|82->54|84->56|84->56|86->58|86->58|86->58|86->58|90->62|90->62|91->63|91->63|94->66|94->66|94->66|94->66|97->69|97->69|98->70|98->70|100->72|100->72|101->73|101->73|102->74|102->74
                    -- GENERATED --
                */
            