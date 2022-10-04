
package views.html.patrimonio.actaRecepcion

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
object tabsActaRecepcion extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Boolean,ActaRecepcion,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(editar:Boolean,acta:ActaRecepcion):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.37*/("""

<ul id="actaTab" class="nav nav-tabs">
	<li class="active">
		<a id="listaProductosActa" 
		   data-href=""""),_display_(Seq[Any](/*6.18*/controllers/*6.29*/.patrimonio.routes.ActasRecepcionLineasController.index())),format.raw/*6.86*/("""?acta_id="""),_display_(Seq[Any](/*6.96*/acta/*6.100*/.id)),format.raw/*6.103*/("""" 
		   href="#contenedorProductosActa" data-toggle="tab">Lista de productos</a></li>
	<li><a id="listaAjuste" data-href="" href="#contenedorAjuste" data-toggle="tab">Lista de ajustes</a></li>
	
	<li><a id="listaAjusteAutomatico" data-href=""""),_display_(Seq[Any](/*10.48*/controllers/*10.59*/.patrimonio.routes.ActaRecepcionLineaAjusteController.index())),format.raw/*10.120*/("""?acta_id="""),_display_(Seq[Any](/*10.130*/acta/*10.134*/.id)),format.raw/*10.137*/("""&editable="""),_display_(Seq[Any](/*10.148*/editar)),format.raw/*10.154*/(""""  href="#contenedorAjusteAutomatico" data-toggle="tab">
		Lista de ajustes Automaticos</a></li>
	<li><a id="listaPacientes" data-href=""""),_display_(Seq[Any](/*12.41*/controllers/*12.52*/.patrimonio.routes.ActasRecepcionController.getPacientes(acta.id))),format.raw/*12.117*/("""" href="#contenedorPacientes" data-toggle="tab">Lista de Pacientes</a></li>	
	<li><a id="listaMovimientos" data-href="" href="#contenedorMovimientos" data-toggle="tab">Movimientos</a></li>	
</ul>	
	
<div class="tab-content">
	<div id="contenedorProductosActa" class="tab-pane active">
	
	</div>
	<div id="contenedorAjuste" class="tab-pane">
		"""),_display_(Seq[Any](/*21.4*/for(ajuste <- acta.getAjustes()) yield /*21.36*/ {_display_(Seq[Any](format.raw/*21.38*/("""
		
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>Concepto</th>
					<th>Importe</th>
				</tr>
			</thead>
			<tbody>
			
				<tr>
					<td>"""),_display_(Seq[Any](/*33.11*/ajuste/*33.17*/.producto.nombre)),format.raw/*33.33*/("""</td>
					<td>"""),_display_(Seq[Any](/*34.11*/utils/*34.16*/.NumberUtils.moneda(ajuste.cantidad.multiply(ajuste.precio)))),format.raw/*34.76*/("""</td>
				</tr>
			
			</tbody>
			</table>
			
			
		""")))})),format.raw/*41.4*/("""
	</div>
	<div id="contenedorAjusteAutomatico" class="tab-pane">
	
	</div>
	<div id="contenedorPacientes" class="tab-pane">
	
	</div>
	<div id="contenedorMovimientos" class="tab-pane">
		"""),_display_(Seq[Any](/*50.4*/views/*50.9*/.html.patrimonio.actaRecepcion.contenidoTabActaMovimiento(acta.id))),format.raw/*50.75*/("""	
	</div>
</div>

<script>
	$( function()"""),format.raw/*55.15*/("""{"""),format.raw/*55.16*/("""
		var urlProductos= $('#listaProductosActa').attr("data-href");

		$.get(urlProductos, function(data)"""),format.raw/*58.37*/("""{"""),format.raw/*58.38*/("""
			$('#contenedorProductosActa').html(data);
		"""),format.raw/*60.3*/("""}"""),format.raw/*60.4*/(""");
		
		var urlAjusteAutomatico = $('#listaAjusteAutomatico').attr("data-href");
		$.get(urlAjusteAutomatico, function(data)"""),format.raw/*63.44*/("""{"""),format.raw/*63.45*/("""
			$('#contenedorAjusteAutomatico').html(data);
		"""),format.raw/*65.3*/("""}"""),format.raw/*65.4*/(""");
		
		$('#listaPacientes').on("click", function() """),format.raw/*67.47*/("""{"""),format.raw/*67.48*/(""" 
			var urlPacientes = $('#listaPacientes').attr("data-href");
			$.get(urlPacientes, function(data)"""),format.raw/*69.38*/("""{"""),format.raw/*69.39*/("""
				$('#contenedorPacientes').html(data);
			"""),format.raw/*71.4*/("""}"""),format.raw/*71.5*/(""");
		"""),format.raw/*72.3*/("""}"""),format.raw/*72.4*/(""");
		
		 
	"""),format.raw/*75.2*/("""}"""),format.raw/*75.3*/(""");
	</script>
"""))}
    }
    
    def render(editar:Boolean,acta:ActaRecepcion): play.api.templates.HtmlFormat.Appendable = apply(editar,acta)
    
    def f:((Boolean,ActaRecepcion) => play.api.templates.HtmlFormat.Appendable) = (editar,acta) => apply(editar,acta)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/actaRecepcion/tabsActaRecepcion.scala.html
                    HASH: ff81546fbbac442b39925c675319b0261f28fb73
                    MATRIX: 826->1|955->36|1099->145|1118->156|1196->213|1241->223|1254->227|1279->230|1557->472|1577->483|1661->544|1708->554|1722->558|1748->561|1796->572|1825->578|1998->715|2018->726|2106->791|2485->1135|2533->1167|2573->1169|2787->1347|2802->1353|2840->1369|2892->1385|2906->1390|2988->1450|3074->1505|3297->1693|3310->1698|3398->1764|3467->1805|3496->1806|3626->1908|3655->1909|3730->1957|3758->1958|3910->2082|3939->2083|4017->2134|4045->2135|4125->2187|4154->2188|4283->2289|4312->2290|4385->2336|4413->2337|4445->2342|4473->2343|4511->2354|4539->2355
                    LINES: 26->1|29->1|34->6|34->6|34->6|34->6|34->6|34->6|38->10|38->10|38->10|38->10|38->10|38->10|38->10|38->10|40->12|40->12|40->12|49->21|49->21|49->21|61->33|61->33|61->33|62->34|62->34|62->34|69->41|78->50|78->50|78->50|83->55|83->55|86->58|86->58|88->60|88->60|91->63|91->63|93->65|93->65|95->67|95->67|97->69|97->69|99->71|99->71|100->72|100->72|103->75|103->75
                    -- GENERATED --
                */
            