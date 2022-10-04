
package views.html.haberes.instrumentosLegales

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
object modalBusquedaInstrumentoLegal extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[models.haberes.InstrumentoLegal],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[models.haberes.InstrumentoLegal], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.101*/("""
"""),format.raw/*3.70*/(""" 

<div id="modalBusquedaInstrumentosLegales" class="contenedorPaginador ajaxPaginador">
<form action=""""),_display_(Seq[Any](/*6.16*/controllers/*6.27*/.haberes.routes.InstrumentosLegalesController.modalBuscar())),format.raw/*6.86*/("""" method="GET">
	<div class="row">
		<div class="col-sm-6">
			<label class="control-label">Denominacion</label>
			"""),_display_(Seq[Any](/*10.5*/inputText(formBuscador("nombre"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*10.91*/("""
			
		</div>
		<div class="col-sm-3">
			<label class="control-label">&nbsp 
			<button class="btn btn-primary form-control">Buscar</button>
			</label>
		</div>
	</div>
</form>

"""),_display_(Seq[Any](/*21.2*/if(buscador.getTotalRowCount == 0)/*21.36*/ {_display_(Seq[Any](format.raw/*21.38*/("""
	<div class="well">
	    <em>No se encuentran Instrumentos Legales</em>
	</div>
""")))}/*25.3*/else/*25.8*/{_display_(Seq[Any](format.raw/*25.9*/("""
    Mostrando """),_display_(Seq[Any](/*26.16*/buscador/*26.24*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*26.56*/(""" resultado(s). 
    	
	<table class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th>Denominacion</th>
			</tr>
		</thead>
		<tbody>
    	
    """),_display_(Seq[Any](/*36.6*/for(lc <- buscador.getList) yield /*36.33*/ {_display_(Seq[Any](format.raw/*36.35*/("""
	<tr data-id=""""),_display_(Seq[Any](/*37.16*/lc/*37.18*/.id)),format.raw/*37.21*/("""" class="modalSeleccionInstrumentoLegal">
		<td> """),_display_(Seq[Any](/*38.9*/lc/*38.11*/.nombre)),format.raw/*38.18*/("""</td>
	</tr>    
    """)))})),format.raw/*40.6*/("""
    </tbody>
    </table>
    
	<div class="pagination pull-right">
	    """),_display_(Seq[Any](/*45.7*/views/*45.12*/.html.helpers.paginador(buscador, controllers.haberes.routes.InstrumentosLegalesController.modalBuscar()))),format.raw/*45.117*/("""
	</div>	
""")))})),format.raw/*47.2*/("""
</div>

<script>
$( function()"""),format.raw/*51.14*/("""{"""),format.raw/*51.15*/("""
	var contenedor = $("#modalBusquedaInstrumentosLegales");
										   
	var url = """"),_display_(Seq[Any](/*54.14*/controllers/*54.25*/.haberes.routes.InstrumentosLegalesController.get())),format.raw/*54.76*/(""""
	contenedor.find('.modalSeleccionInstrumentoLegal').on('click', function()"""),format.raw/*55.75*/("""{"""),format.raw/*55.76*/("""
		var id = $(this).attr('data-id');
		$.get(url+"?id="+id, function(data)"""),format.raw/*57.38*/("""{"""),format.raw/*57.39*/("""
			$(document).trigger("modal.seleccion.instrumentoLegal.simple", data);
		"""),format.raw/*59.3*/("""}"""),format.raw/*59.4*/(""");
	"""),format.raw/*60.2*/("""}"""),format.raw/*60.3*/(""");
	
	contenedor.find('form').on('submit', function()"""),format.raw/*62.49*/("""{"""),format.raw/*62.50*/("""
		var url = $(this).attr("action");
		var query = $(this).serialize();
		$.get(url+"?"+query, function(data)"""),format.raw/*65.38*/("""{"""),format.raw/*65.39*/("""
			contenedor.parent().html(data);
		"""),format.raw/*67.3*/("""}"""),format.raw/*67.4*/(""");
		return false;
	"""),format.raw/*69.2*/("""}"""),format.raw/*69.3*/(""");
"""),format.raw/*70.1*/("""}"""),format.raw/*70.2*/(""");
</script>"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[models.haberes.InstrumentoLegal],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[models.haberes.InstrumentoLegal],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/instrumentosLegales/modalBusquedaInstrumentoLegal.scala.html
                    HASH: fa6a576d9926a34605bfadbd36e6c1ee6a68211d
                    MATRIX: 892->1|1094->121|1126->145|1201->100|1230->189|1372->296|1391->307|1471->366|1627->487|1735->573|1962->765|2005->799|2045->801|2149->888|2161->893|2199->894|2252->911|2269->919|2323->951|2539->1132|2582->1159|2622->1161|2675->1178|2686->1180|2711->1183|2797->1234|2808->1236|2837->1243|2892->1267|3007->1347|3021->1352|3149->1457|3193->1470|3256->1505|3285->1506|3410->1595|3430->1606|3503->1657|3608->1734|3637->1735|3741->1811|3770->1812|3875->1890|3903->1891|3935->1896|3963->1897|4046->1952|4075->1953|4215->2065|4244->2066|4311->2106|4339->2107|4388->2129|4416->2130|4447->2134|4475->2135
                    LINES: 26->1|29->3|29->3|30->1|31->3|34->6|34->6|34->6|38->10|38->10|49->21|49->21|49->21|53->25|53->25|53->25|54->26|54->26|54->26|64->36|64->36|64->36|65->37|65->37|65->37|66->38|66->38|66->38|68->40|73->45|73->45|73->45|75->47|79->51|79->51|82->54|82->54|82->54|83->55|83->55|85->57|85->57|87->59|87->59|88->60|88->60|90->62|90->62|93->65|93->65|95->67|95->67|97->69|97->69|98->70|98->70
                    -- GENERATED --
                */
            