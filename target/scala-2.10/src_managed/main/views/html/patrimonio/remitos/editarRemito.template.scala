
package views.html.patrimonio.remitos

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
object editarRemito extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[Remito],Remito,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(remitoForm: Form[Remito],r:Remito):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.37*/("""
"""),format.raw/*4.70*/(""" 

"""),_display_(Seq[Any](/*6.2*/views/*6.7*/.html.patrimonio.mainPatrimonio("Editar remito")/*6.55*/ {_display_(Seq[Any](format.raw/*6.57*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Editar remito</h1>
			</div>			 
		</div>
	</div> 
    
  
	"""),_display_(Seq[Any](/*17.3*/helper/*17.9*/.form(action = controllers.patrimonio.routes.RemitosController.actualizar(r.id), 'id -> "formEditarRemito")/*17.116*/ {_display_(Seq[Any](format.raw/*17.118*/("""
		"""),_display_(Seq[Any](/*18.4*/views/*18.9*/.html.patrimonio.remitos.formRemito(remitoForm))),format.raw/*18.56*/(""" 
	""")))})),format.raw/*19.3*/("""
	
	<hr />
	
	<ul id="ordenTab" class="nav nav-tabs">
		<li class="active"><a id="produtosEnRemito" data-href=""""),_display_(Seq[Any](/*24.59*/controllers/*24.70*/.patrimonio.routes.RemitosLineasController.enRemito(r.id))),format.raw/*24.127*/("""" href="#contenedorRemitosProductosAgregado" data-toggle="tab">Productos en remito</a></li>
		<li><a id="productosParaAgregar" data-href=""""),_display_(Seq[Any](/*25.48*/controllers/*25.59*/.patrimonio.routes.RemitosLineasController.paraAgregar(r.id))),format.raw/*25.119*/("""" href="#contenedorRemitosProductosAgregar" data-toggle="tab">Productos para agregar</a></li>
	</ul>


	<div class="tab-content">
		<div id="contenedorRemitosProductosAgregado" class="tab-pane active">
		
		</div>
		
		<div id="contenedorRemitosProductosAgregar" class="tab-pane">
		
		</div>
		
	</div>


	<script>
	$( function() """),format.raw/*42.16*/("""{"""),format.raw/*42.17*/("""

		$('#productosParaAgregar').on('click', function()"""),format.raw/*44.52*/("""{"""),format.raw/*44.53*/("""
			var url = $(this).attr("data-href");
			$.get(url, function(data) """),format.raw/*46.30*/("""{"""),format.raw/*46.31*/("""
				$('#contenedorRemitosProductosAgregar').html(data);
			"""),format.raw/*48.4*/("""}"""),format.raw/*48.5*/(""");
		"""),format.raw/*49.3*/("""}"""),format.raw/*49.4*/(""");
		
		$('#produtosEnRemito').on('click', function()"""),format.raw/*51.48*/("""{"""),format.raw/*51.49*/("""
			var url = $(this).attr("data-href");
			$.get(url, function(data) """),format.raw/*53.30*/("""{"""),format.raw/*53.31*/("""
				$('#contenedorRemitosProductosAgregado').html(data);
			"""),format.raw/*55.4*/("""}"""),format.raw/*55.5*/(""");
		"""),format.raw/*56.3*/("""}"""),format.raw/*56.4*/(""");
		$('#produtosEnRemito').click();
		
		
		/*
		* Filtro de búsqueda en lista de productos en remitos y para agregar
		*/

		$('#contenedorRemitosProductosAgregado, #contenedorRemitosProductosAgregar').on('submit', '#filtroBuscador form', function () """),format.raw/*64.129*/("""{"""),format.raw/*64.130*/("""

			var f = $(this);
			var url = f.attr('action');
			var contenedor = f.closest('.contenedorPaginador');

			$.get(url, f.serialize(), function(data) """),format.raw/*70.45*/("""{"""),format.raw/*70.46*/("""
				contenedor.html(data);
			"""),format.raw/*72.4*/("""}"""),format.raw/*72.5*/(""");
			
			return false;
		"""),format.raw/*75.3*/("""}"""),format.raw/*75.4*/(""");
		
	"""),format.raw/*77.2*/("""}"""),format.raw/*77.3*/(""");
	</script>


""")))})))}
    }
    
    def render(remitoForm:Form[Remito],r:Remito): play.api.templates.HtmlFormat.Appendable = apply(remitoForm,r)
    
    def f:((Form[Remito],Remito) => play.api.templates.HtmlFormat.Appendable) = (remitoForm,r) => apply(remitoForm,r)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/remitos/editarRemito.scala.html
                    HASH: 7c4b4c94b1b5f4202b0aa94aeb868a52b767f2ed
                    MATRIX: 813->1|968->74|1000->98|1074->36|1103->142|1143->148|1155->153|1211->201|1250->203|1441->359|1455->365|1572->472|1613->474|1653->479|1666->484|1735->531|1771->536|1924->653|1944->664|2024->721|2200->861|2220->872|2303->932|2679->1280|2708->1281|2791->1336|2820->1337|2920->1409|2949->1410|3038->1472|3066->1473|3099->1479|3127->1480|3210->1535|3239->1536|3339->1608|3368->1609|3458->1672|3486->1673|3519->1679|3547->1680|3837->1941|3867->1942|4054->2101|4083->2102|4143->2135|4171->2136|4227->2165|4255->2166|4291->2175|4319->2176
                    LINES: 26->1|31->4|31->4|32->1|33->4|35->6|35->6|35->6|35->6|46->17|46->17|46->17|46->17|47->18|47->18|47->18|48->19|53->24|53->24|53->24|54->25|54->25|54->25|71->42|71->42|73->44|73->44|75->46|75->46|77->48|77->48|78->49|78->49|80->51|80->51|82->53|82->53|84->55|84->55|85->56|85->56|93->64|93->64|99->70|99->70|101->72|101->72|104->75|104->75|106->77|106->77
                    -- GENERATED --
                */
            