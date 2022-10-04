
package views.html.compras.solicitudes

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
object modalBusquedaSolicitudes extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[Solicitud],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[Solicitud], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.79*/("""
"""),format.raw/*3.70*/(""" 

<div id="modalBusquedaSolicitudes" class="contenedorPaginador ajaxPaginador">
<form action=""""),_display_(Seq[Any](/*6.16*/controllers/*6.27*/.compras.routes.SolicitudesController.modalBuscar())),format.raw/*6.78*/("""" method="GET">
	<div class="row">
		<div class="col-sm-6">
			<label class="control-label">Referencia</label>
			"""),_display_(Seq[Any](/*10.5*/inputText(formBuscador("referencia"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*10.95*/("""
			
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
	    <em>No se encuentran solicitudes</em>
	</div>
""")))}/*25.3*/else/*25.8*/{_display_(Seq[Any](format.raw/*25.9*/("""
    Mostrando """),_display_(Seq[Any](/*26.16*/buscador/*26.24*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*26.56*/(""" resultado(s). 
    	
	<table class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th>Referencia</th>
			</tr>
		</thead>
		<tbody>
    	
    """),_display_(Seq[Any](/*36.6*/for(solicitud <- buscador.getList) yield /*36.40*/ {_display_(Seq[Any](format.raw/*36.42*/("""
	<tr data-id=""""),_display_(Seq[Any](/*37.16*/solicitud/*37.25*/.id)),format.raw/*37.28*/("""" class="modalSeleccionSolicitudes">
		<td>"""),_display_(Seq[Any](/*38.8*/solicitud/*38.17*/.referencia)),format.raw/*38.28*/("""</td>
	</tr>    
    """)))})),format.raw/*40.6*/("""
    </tbody>
    </table>
    
	<div class="pagination pull-right">
	    """),_display_(Seq[Any](/*45.7*/views/*45.12*/.html.helpers.paginador(buscador, controllers.compras.routes.SolicitudesController.modalBuscar()))),format.raw/*45.109*/("""
	</div>	
""")))})),format.raw/*47.2*/("""
</div>

<script>
$( function()"""),format.raw/*51.14*/("""{"""),format.raw/*51.15*/("""
	var contenedor = $("#modalBusquedaSolicitudes");
	var url = """"),_display_(Seq[Any](/*53.14*/controllers/*53.25*/.compras.routes.SolicitudesController.get())),format.raw/*53.68*/(""""
	contenedor.find('.modalSeleccionSolicitudes').on('click', function()"""),format.raw/*54.70*/("""{"""),format.raw/*54.71*/("""
		var id = $(this).attr('data-id');
		$.get(url+"?id="+id, function(data)"""),format.raw/*56.38*/("""{"""),format.raw/*56.39*/("""
			if(data.success)		  
				$(document).trigger("modal.seleccion.solicitud.simple", data);
			else
				alert(data.message);
		"""),format.raw/*61.3*/("""}"""),format.raw/*61.4*/(""");
	"""),format.raw/*62.2*/("""}"""),format.raw/*62.3*/(""");
	
	contenedor.find('form').on('submit', function()"""),format.raw/*64.49*/("""{"""),format.raw/*64.50*/("""
		var url = $(this).attr("action");
		var query = $(this).serialize();
		$.get(url+"?"+query, function(data)"""),format.raw/*67.38*/("""{"""),format.raw/*67.39*/("""
			contenedor.parent().html(data);
		"""),format.raw/*69.3*/("""}"""),format.raw/*69.4*/(""");
		return false;
	"""),format.raw/*71.2*/("""}"""),format.raw/*71.3*/(""");
"""),format.raw/*72.1*/("""}"""),format.raw/*72.2*/(""");
</script>"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[Solicitud],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[Solicitud],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:45 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/solicitudes/modalBusquedaSolicitudes.scala.html
                    HASH: 2ec43d60225a05be7d9722dbd4522977eb4b24ec
                    MATRIX: 857->1|1037->99|1069->123|1143->78|1172->167|1306->266|1325->277|1397->328|1551->447|1663->537|1890->729|1933->763|1973->765|2068->843|2080->848|2118->849|2171->866|2188->874|2242->906|2456->1085|2506->1119|2546->1121|2599->1138|2617->1147|2642->1150|2722->1195|2740->1204|2773->1215|2828->1239|2943->1319|2957->1324|3077->1421|3121->1434|3184->1469|3213->1470|3315->1536|3335->1547|3400->1590|3500->1662|3529->1663|3633->1739|3662->1740|3821->1872|3849->1873|3881->1878|3909->1879|3992->1934|4021->1935|4161->2047|4190->2048|4257->2088|4285->2089|4334->2111|4362->2112|4393->2116|4421->2117
                    LINES: 26->1|29->3|29->3|30->1|31->3|34->6|34->6|34->6|38->10|38->10|49->21|49->21|49->21|53->25|53->25|53->25|54->26|54->26|54->26|64->36|64->36|64->36|65->37|65->37|65->37|66->38|66->38|66->38|68->40|73->45|73->45|73->45|75->47|79->51|79->51|81->53|81->53|81->53|82->54|82->54|84->56|84->56|89->61|89->61|90->62|90->62|92->64|92->64|95->67|95->67|97->69|97->69|99->71|99->71|100->72|100->72
                    -- GENERATED --
                */
            