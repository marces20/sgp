
package views.html.haberes.conveniosBancos

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
object modalBusquedaConvenioBanco extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[models.haberes.ConvenioBanco],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[models.haberes.ConvenioBanco], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.98*/("""
"""),format.raw/*3.70*/(""" 

<div id="modalBusquedaConveniosBancos" class="contenedorPaginador ajaxPaginador">
<form action=""""),_display_(Seq[Any](/*6.16*/controllers/*6.27*/.haberes.routes.ConveniosBancosController.modalBuscar())),format.raw/*6.82*/("""" method="GET">
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
	    <em>No se encuentran convenios</em>
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
	<tr data-id=""""),_display_(Seq[Any](/*37.16*/lc/*37.18*/.id)),format.raw/*37.21*/("""" class="modalSeleccionConvenioBanco">
		<td> """),_display_(Seq[Any](/*38.9*/lc/*38.11*/.nombre)),format.raw/*38.18*/("""</td>
	</tr>    
    """)))})),format.raw/*40.6*/("""
    </tbody>
    </table>
    
	<div class="pagination pull-right">
	    """),_display_(Seq[Any](/*45.7*/views/*45.12*/.html.helpers.paginador(buscador, controllers.haberes.routes.ConveniosBancosController.modalBuscar()))),format.raw/*45.113*/("""
	</div>	
""")))})),format.raw/*47.2*/("""
</div>

<script>
$( function()"""),format.raw/*51.14*/("""{"""),format.raw/*51.15*/("""
	var contenedor = $("#modalBusquedaConveniosBancos");
										   
	var url = """"),_display_(Seq[Any](/*54.14*/controllers/*54.25*/.haberes.routes.ConveniosBancosController.get())),format.raw/*54.72*/(""""
	contenedor.find('.modalSeleccionConvenioBanco').on('click', function()"""),format.raw/*55.72*/("""{"""),format.raw/*55.73*/("""
		var id = $(this).attr('data-id');
		$.get(url+"?id="+id, function(data)"""),format.raw/*57.38*/("""{"""),format.raw/*57.39*/("""
			$(document).trigger("modal.seleccion.convenioBanco.simple", data);
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
    
    def render(buscador:utils.pagination.Pagination[models.haberes.ConvenioBanco],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[models.haberes.ConvenioBanco],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/conveniosBancos/modalBusquedaConvenioBanco.scala.html
                    HASH: 31a3a6da7a5dca5a02730dd8cfaef6f683f28b2a
                    MATRIX: 882->1|1081->118|1113->142|1187->97|1216->186|1354->289|1373->300|1449->355|1605->476|1713->562|1940->754|1983->788|2023->790|2116->866|2128->871|2166->872|2219->889|2236->897|2290->929|2506->1110|2549->1137|2589->1139|2642->1156|2653->1158|2678->1161|2761->1209|2772->1211|2801->1218|2856->1242|2971->1322|2985->1327|3109->1428|3153->1441|3216->1476|3245->1477|3366->1562|3386->1573|3455->1620|3557->1694|3586->1695|3690->1771|3719->1772|3821->1847|3849->1848|3881->1853|3909->1854|3992->1909|4021->1910|4161->2022|4190->2023|4257->2063|4285->2064|4334->2086|4362->2087|4393->2091|4421->2092
                    LINES: 26->1|29->3|29->3|30->1|31->3|34->6|34->6|34->6|38->10|38->10|49->21|49->21|49->21|53->25|53->25|53->25|54->26|54->26|54->26|64->36|64->36|64->36|65->37|65->37|65->37|66->38|66->38|66->38|68->40|73->45|73->45|73->45|75->47|79->51|79->51|82->54|82->54|82->54|83->55|83->55|85->57|85->57|87->59|87->59|88->60|88->60|90->62|90->62|93->65|93->65|95->67|95->67|97->69|97->69|98->70|98->70
                    -- GENERATED --
                */
            