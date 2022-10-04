
package views.html.rrhh.agenteAsistencia

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
object tabsAgenteAsistencia extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Agente,Boolean,Long,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(agente:Agente,formularioCarga: Boolean,tipoLicencia:Long):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.60*/("""

<ul id="" class="nav nav-tabs">
	<li><a id="tabInasistenciaResumen" class="tabInasistenciaResumen" href="#contenedorInasistenciaResumen" data-toggle="tab">Resumen Inasistencia</a></li>
	<li class="active"><a class="tabInasistencia" href="#contenedorInasistencia" data-toggle="tab">Inasistencia</a></li>
	 
</ul>

<div class="tab-content">
	<div class="tab-pane" id="contenedorInasistenciaResumen">
		"""),_display_(Seq[Any](/*11.4*/views/*11.9*/.html.rrhh.agenteAsistencia.contenidoTabInasistenciaResumen(agente,formularioCarga))),format.raw/*11.92*/("""	
	</div>
	<div class="tab-pane active" id="contenedorInasistencia">
		"""),_display_(Seq[Any](/*14.4*/views/*14.9*/.html.rrhh.agenteAsistencia.contenidoTabInasistencia(agente,formularioCarga,tipoLicencia))),format.raw/*14.98*/("""	
	</div>
	 
	 
</div>	
<script>

$( function () """),format.raw/*21.16*/("""{"""),format.raw/*21.17*/("""
	$('#tabInasistenciaResumen').on("click", function() """),format.raw/*22.54*/("""{"""),format.raw/*22.55*/(""" 
		$('#listaLicenciasResumen').html('<div class="loading"></div>');														
		$.get('"""),_display_(Seq[Any](/*24.11*/controllers/*24.22*/.rrhh.routes.AgentesAsistenciasLicenciasController.resumen(agente.id, formularioCarga))),format.raw/*24.108*/("""', function(data)"""),format.raw/*24.125*/("""{"""),format.raw/*24.126*/("""
			$('#listaLicenciasResumen').parent().html(data);
		"""),format.raw/*26.3*/("""}"""),format.raw/*26.4*/(""")
			
			/*var url = "/contabilidad/facturaProveedor/getInfoRetenciones?id="+$('#facturaId').val()+"&fci="+$('#formularioCargaImpuestos').val();
				
			$("#contenedorInfoProveedor").html('<div class="loading"></div>');
			$.get(url, function(data)"""),format.raw/*31.29*/("""{"""),format.raw/*31.30*/("""
				$('#contenedorInfoProveedor').parent().html(data);
			"""),format.raw/*33.4*/("""}"""),format.raw/*33.5*/(""")*/
	
	"""),format.raw/*35.2*/("""}"""),format.raw/*35.3*/(""");
"""),format.raw/*36.1*/("""}"""),format.raw/*36.2*/(""");

</script>	"""))}
    }
    
    def render(agente:Agente,formularioCarga:Boolean,tipoLicencia:Long): play.api.templates.HtmlFormat.Appendable = apply(agente,formularioCarga,tipoLicencia)
    
    def f:((Agente,Boolean,Long) => play.api.templates.HtmlFormat.Appendable) = (agente,formularioCarga,tipoLicencia) => apply(agente,formularioCarga,tipoLicencia)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:30 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agenteAsistencia/tabsAgenteAsistencia.scala.html
                    HASH: 82dee81629253c94de8d5780c2538297e9c1a2fe
                    MATRIX: 824->1|976->59|1414->462|1427->467|1532->550|1639->622|1652->627|1763->716|1840->765|1869->766|1951->820|1980->821|2109->914|2129->925|2238->1011|2284->1028|2314->1029|2396->1084|2424->1085|2700->1333|2729->1334|2815->1393|2843->1394|2877->1401|2905->1402|2935->1405|2963->1406
                    LINES: 26->1|29->1|39->11|39->11|39->11|42->14|42->14|42->14|49->21|49->21|50->22|50->22|52->24|52->24|52->24|52->24|52->24|54->26|54->26|59->31|59->31|61->33|61->33|63->35|63->35|64->36|64->36
                    -- GENERATED --
                */
            