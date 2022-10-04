
package views.html.expediente.iniciador

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
object modalBusquedaIniciadorExpediente extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[IniciadorExpediente],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[IniciadorExpediente], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.89*/("""
"""),format.raw/*3.70*/(""" 

<div id="modalBusquedaExpedientes" class="contenedorPaginador ajaxPaginador">
<form action=""""),_display_(Seq[Any](/*6.16*/controllers/*6.27*/.expediente.routes.IniciadorExpedientesController.modalBuscar())),format.raw/*6.90*/("""" method="GET">
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
	    <em>No se encuentran iniciador de expedientes</em>
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
    	
    """),_display_(Seq[Any](/*36.6*/for(iniciadorExpediente <- buscador.getList) yield /*36.50*/ {_display_(Seq[Any](format.raw/*36.52*/("""
	<tr data-id=""""),_display_(Seq[Any](/*37.16*/iniciadorExpediente/*37.35*/.id)),format.raw/*37.38*/("""" class="modalSeleccionIniciadorExpediente">
		<td> """),_display_(Seq[Any](/*38.9*/iniciadorExpediente/*38.28*/.nombre)),format.raw/*38.35*/("""</td>
	</tr>    
    """)))})),format.raw/*40.6*/("""
    </tbody>
    </table>
    
	<div class="pagination pull-right">
	    """),_display_(Seq[Any](/*45.7*/views/*45.12*/.html.helpers.paginador(buscador, controllers.expediente.routes.IniciadorExpedientesController.modalBuscar()))),format.raw/*45.121*/("""
	</div>	
""")))})),format.raw/*47.2*/("""
</div>

<script>
$( function()"""),format.raw/*51.14*/("""{"""),format.raw/*51.15*/("""
	var contenedor = $("#modalBusquedaIniciadorExpedientes");
	var url = """"),_display_(Seq[Any](/*53.14*/controllers/*53.25*/.expediente.routes.IniciadorExpedientesController.get())),format.raw/*53.80*/(""""
	contenedor.find('.modalSeleccionIniciadorExpediente').on('click', function()"""),format.raw/*54.78*/("""{"""),format.raw/*54.79*/("""
		var id = $(this).attr('data-id');
		$.get(url+"?id="+id, function(data)"""),format.raw/*56.38*/("""{"""),format.raw/*56.39*/("""
			$(document).trigger("modal.seleccion.iniciadorExpediente.simple", data);
		"""),format.raw/*58.3*/("""}"""),format.raw/*58.4*/(""");
	"""),format.raw/*59.2*/("""}"""),format.raw/*59.3*/(""");
	
	contenedor.find('form').on('submit', function()"""),format.raw/*61.49*/("""{"""),format.raw/*61.50*/("""
		var url = $(this).attr("action");
		var query = $(this).serialize();
		$.get(url+"?"+query, function(data)"""),format.raw/*64.38*/("""{"""),format.raw/*64.39*/("""
			contenedor.parent().html(data);
		"""),format.raw/*66.3*/("""}"""),format.raw/*66.4*/(""");
		return false;
	"""),format.raw/*68.2*/("""}"""),format.raw/*68.3*/(""");
"""),format.raw/*69.1*/("""}"""),format.raw/*69.2*/(""");
</script>"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[IniciadorExpediente],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[IniciadorExpediente],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:36 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/expediente/iniciador/modalBusquedaIniciadorExpediente.scala.html
                    HASH: 193034debe150c1a00b136a55bafbd94a278e2ad
                    MATRIX: 876->1|1066->109|1098->133|1172->88|1201->177|1335->276|1354->287|1438->350|1588->465|1696->551|1923->743|1966->777|2006->779|2114->870|2126->875|2164->876|2217->893|2234->901|2288->933|2498->1108|2558->1152|2598->1154|2651->1171|2679->1190|2704->1193|2793->1247|2821->1266|2850->1273|2905->1297|3020->1377|3034->1382|3166->1491|3210->1504|3273->1539|3302->1540|3413->1615|3433->1626|3510->1681|3618->1761|3647->1762|3751->1838|3780->1839|3888->1920|3916->1921|3948->1926|3976->1927|4059->1982|4088->1983|4228->2095|4257->2096|4324->2136|4352->2137|4401->2159|4429->2160|4460->2164|4488->2165
                    LINES: 26->1|29->3|29->3|30->1|31->3|34->6|34->6|34->6|38->10|38->10|49->21|49->21|49->21|53->25|53->25|53->25|54->26|54->26|54->26|64->36|64->36|64->36|65->37|65->37|65->37|66->38|66->38|66->38|68->40|73->45|73->45|73->45|75->47|79->51|79->51|81->53|81->53|81->53|82->54|82->54|84->56|84->56|86->58|86->58|87->59|87->59|89->61|89->61|92->64|92->64|94->66|94->66|96->68|96->68|97->69|97->69
                    -- GENERATED --
                */
            