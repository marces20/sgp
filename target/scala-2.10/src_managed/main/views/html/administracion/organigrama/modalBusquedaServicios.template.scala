
package views.html.administracion.organigrama

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
object modalBusquedaServicios extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[Organigrama],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[Organigrama], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.81*/("""
"""),format.raw/*3.70*/(""" 

<div id="modalBusquedaServicios" class="contenedorPaginador ajaxPaginador">
<form action=""""),_display_(Seq[Any](/*6.16*/controllers/*6.27*/.administracion.routes.OrganigramasController.modalBuscarServicios())),format.raw/*6.95*/("""" method="GET">
	<div class="row">
		<div class="col-sm-6">
			<label class="control-label">Nombre</label>
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
	    <em>No se encuentran Servicios</em>
	</div>
""")))}/*25.3*/else/*25.8*/{_display_(Seq[Any](format.raw/*25.9*/("""
    Mostrando """),_display_(Seq[Any](/*26.16*/buscador/*26.24*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*26.56*/(""" resultado(s). 
    	
	<table class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th>Nombre</th>
			</tr>
		</thead>
		<tbody>
    	
    """),_display_(Seq[Any](/*36.6*/for(o <- buscador.getList) yield /*36.32*/ {_display_(Seq[Any](format.raw/*36.34*/("""
	<tr data-href=""""),_display_(Seq[Any](/*37.18*/controllers/*37.29*/.administracion.routes.OrganigramasController.get(o.id.toLong))),format.raw/*37.91*/("""" class="modalSeleccionServicio">
		<td>"""),_display_(Seq[Any](/*38.8*/o/*38.9*/.nombre)),format.raw/*38.16*/("""</td>
	</tr>    
    """)))})),format.raw/*40.6*/("""
    </tbody>
    </table>
    
	<div class="pagination pull-right">
	    """),_display_(Seq[Any](/*45.7*/views/*45.12*/.html.helpers.paginador(buscador, controllers.administracion.routes.OrganigramasController.modalBuscarServicios()))),format.raw/*45.126*/("""
	</div>	
""")))})),format.raw/*47.2*/("""
</div>

<script>
$( function()"""),format.raw/*51.14*/("""{"""),format.raw/*51.15*/("""
	var contenedor = $("#modalBusquedaServicios");
	contenedor.find('.modalSeleccionServicio').on('click', function()"""),format.raw/*53.67*/("""{"""),format.raw/*53.68*/("""
		var url = $(this).attr('data-href');
		$.get(url, function(data)"""),format.raw/*55.28*/("""{"""),format.raw/*55.29*/("""
			$(document).trigger("modal.seleccion.servicio.simple", data);
		"""),format.raw/*57.3*/("""}"""),format.raw/*57.4*/(""");
	"""),format.raw/*58.2*/("""}"""),format.raw/*58.3*/(""");
	
	contenedor.find('form').on('submit', function()"""),format.raw/*60.49*/("""{"""),format.raw/*60.50*/("""
		var url = $(this).attr("action");
		var query = $(this).serialize();
		$.get(url+"?"+query, function(data)"""),format.raw/*63.38*/("""{"""),format.raw/*63.39*/("""
			contenedor.parent().html(data);
		"""),format.raw/*65.3*/("""}"""),format.raw/*65.4*/(""");
		return false;
	"""),format.raw/*67.2*/("""}"""),format.raw/*67.3*/(""");
"""),format.raw/*68.1*/("""}"""),format.raw/*68.2*/(""");
</script>"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[Organigrama],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[Organigrama],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/administracion/organigrama/modalBusquedaServicios.scala.html
                    HASH: b9862aa19d2574e87a3643a4523bfbf3578ae71d
                    MATRIX: 864->1|1046->101|1078->125|1152->80|1181->169|1313->266|1332->277|1421->345|1571->460|1679->546|1906->738|1949->772|1989->774|2082->850|2094->855|2132->856|2185->873|2202->881|2256->913|2466->1088|2508->1114|2548->1116|2603->1135|2623->1146|2707->1208|2784->1250|2793->1251|2822->1258|2877->1282|2992->1362|3006->1367|3143->1481|3187->1494|3250->1529|3279->1530|3424->1647|3453->1648|3550->1717|3579->1718|3676->1788|3704->1789|3736->1794|3764->1795|3847->1850|3876->1851|4016->1963|4045->1964|4112->2004|4140->2005|4189->2027|4217->2028|4248->2032|4276->2033
                    LINES: 26->1|29->3|29->3|30->1|31->3|34->6|34->6|34->6|38->10|38->10|49->21|49->21|49->21|53->25|53->25|53->25|54->26|54->26|54->26|64->36|64->36|64->36|65->37|65->37|65->37|66->38|66->38|66->38|68->40|73->45|73->45|73->45|75->47|79->51|79->51|81->53|81->53|83->55|83->55|85->57|85->57|86->58|86->58|88->60|88->60|91->63|91->63|93->65|93->65|95->67|95->67|96->68|96->68
                    -- GENERATED --
                */
            