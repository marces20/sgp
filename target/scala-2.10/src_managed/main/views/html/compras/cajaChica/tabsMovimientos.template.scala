
package views.html.compras.cajaChica

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
object tabsMovimientos extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Boolean,CajaChica,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formularioCarga: Boolean, caja: CajaChica = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.52*/("""


<hr />
<ul id="movimientosTab" class="nav nav-tabs">
	<li class="active"><a class="tabProducto" href="#contenedorMovimientos" data-toggle="tab">Movimientos</a></li>
	<li><a class="tabPresupuesto" href="#contenedorPresupuesto" data-toggle="tab">Presupuesto Preventivo</a></li>
	<li><a id="tabResumenPresupuesto" class="tabResumenPresupuesto" href="#contenedorResumenPresupuesto" data-toggle="tab">Resumen Presupuesto</a></li>
</ul>

<div class="tab-content">

	<div class="tab-pane active" id="contenedorMovimientos">
	
	
		"""),_display_(Seq[Any](/*16.4*/if(caja == null)/*16.20*/{_display_(Seq[Any](format.raw/*16.21*/("""
			<p>Para cargar movimientos primero debe crear la caja chica.</p>
		""")))}/*18.5*/else/*18.10*/{_display_(Seq[Any](format.raw/*18.11*/("""
			<script>
			$( function ()"""),format.raw/*20.18*/("""{"""),format.raw/*20.19*/("""
				$.get('"""),_display_(Seq[Any](/*21.13*/controllers/*21.24*/.compras.routes.CajaChicaMovimientosController.lista(caja.id, formularioCarga))),format.raw/*21.102*/("""', function(data)"""),format.raw/*21.119*/("""{"""),format.raw/*21.120*/("""
					$('#lineasMovimientos').html(data);
				"""),format.raw/*23.5*/("""}"""),format.raw/*23.6*/(""")
			"""),format.raw/*24.4*/("""}"""),format.raw/*24.5*/(""");
			</script>
		""")))})),format.raw/*26.4*/("""
	
		<div id="lineasMovimientos">
		
		</div>
	
	
	</div>
	
	<div class="tab-pane" id="contenedorPresupuesto">
		"""),_display_(Seq[Any](/*36.4*/if(caja == null)/*36.20*/{_display_(Seq[Any](format.raw/*36.21*/("""
			<p>Para cargar presupuesto primero debe crear la caja chica.</p>
		""")))}/*38.5*/else/*38.10*/{_display_(Seq[Any](format.raw/*38.11*/("""
			<script>
			$( function ()"""),format.raw/*40.18*/("""{"""),format.raw/*40.19*/("""
				$.get('"""),_display_(Seq[Any](/*41.13*/controllers/*41.24*/.compras.routes.CajaChicaPresupuestoLineasController.lista(caja.id, formularioCarga))),format.raw/*41.108*/("""', function(data)"""),format.raw/*41.125*/("""{"""),format.raw/*41.126*/("""
					$('#lineasPresupuesto').html(data);
				"""),format.raw/*43.5*/("""}"""),format.raw/*43.6*/(""")
			"""),format.raw/*44.4*/("""}"""),format.raw/*44.5*/(""");
			</script>
		""")))})),format.raw/*46.4*/("""
	
		<div id="lineasPresupuesto">
		
		</div>
	</div>
	
	<div class="tab-pane" id="contenedorResumenPresupuesto">
		 
	</div>
	
</div>

<script>
$( function ()"""),format.raw/*60.15*/("""{"""),format.raw/*60.16*/("""
	$('#tabResumenPresupuesto').on("click", function() """),format.raw/*61.53*/("""{"""),format.raw/*61.54*/(""" 
		 
		var url = "/compras/caja-chica/resumenPresupuesto?id="+$('#cajaId').val();
				
		$("#contenedorResumenPresupuesto").html('<div class="loading"></div>');
		$.get(url, function(data)"""),format.raw/*66.28*/("""{"""),format.raw/*66.29*/("""
			$('#contenedorResumenPresupuesto').html(data);
		"""),format.raw/*68.3*/("""}"""),format.raw/*68.4*/(""")
		 
	"""),format.raw/*70.2*/("""}"""),format.raw/*70.3*/(""");
"""),format.raw/*71.1*/("""}"""),format.raw/*71.2*/(""");
</script>"""))}
    }
    
    def render(formularioCarga:Boolean,caja:CajaChica): play.api.templates.HtmlFormat.Appendable = apply(formularioCarga,caja)
    
    def f:((Boolean,CajaChica) => play.api.templates.HtmlFormat.Appendable) = (formularioCarga,caja) => apply(formularioCarga,caja)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:46 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/cajaChica/tabsMovimientos.scala.html
                    HASH: 91bb0963c1c94e76df2db94c5e5402d6f4cc3398
                    MATRIX: 813->1|957->51|1534->593|1559->609|1598->610|1690->685|1703->690|1742->691|1802->723|1831->724|1881->738|1901->749|2002->827|2048->844|2078->845|2153->893|2181->894|2214->900|2242->901|2294->922|2453->1046|2478->1062|2517->1063|2609->1138|2622->1143|2661->1144|2721->1176|2750->1177|2800->1191|2820->1202|2927->1286|2973->1303|3003->1304|3078->1352|3106->1353|3139->1359|3167->1360|3219->1381|3420->1554|3449->1555|3531->1609|3560->1610|3782->1804|3811->1805|3893->1860|3921->1861|3957->1870|3985->1871|4016->1875|4044->1876
                    LINES: 26->1|29->1|44->16|44->16|44->16|46->18|46->18|46->18|48->20|48->20|49->21|49->21|49->21|49->21|49->21|51->23|51->23|52->24|52->24|54->26|64->36|64->36|64->36|66->38|66->38|66->38|68->40|68->40|69->41|69->41|69->41|69->41|69->41|71->43|71->43|72->44|72->44|74->46|88->60|88->60|89->61|89->61|94->66|94->66|96->68|96->68|98->70|98->70|99->71|99->71
                    -- GENERATED --
                */
            