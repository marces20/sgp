
package views.html.rrhh.cies

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
object modalBusquedaCie extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[Cie],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[Cie], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import models.auth._

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.73*/("""
"""),format.raw/*4.70*/(""" 

<div id="modalBusquedaCies" class="contenedorPaginador ajaxPaginador">
<form action=""""),_display_(Seq[Any](/*7.16*/controllers/*7.27*/.rrhh.routes.CiesController.modalBuscar())),format.raw/*7.68*/("""" method="GET">
	<div class="row">
		<div class="col-sm-6">
			<label class="control-label">Nombre</label>
			"""),_display_(Seq[Any](/*11.5*/inputText(formBuscador("nombre"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*11.91*/("""
			
		</div>
		<div class="col-sm-3">
			<label class="control-label">&nbsp 
			<button class="btn btn-primary form-control">Buscar</button>
			</label>
		</div>
	</div>
</form>

"""),_display_(Seq[Any](/*22.2*/if(buscador.getTotalRowCount == 0)/*22.36*/ {_display_(Seq[Any](format.raw/*22.38*/("""
	<div class="well">
	    <em>No se encuentran Cie</em>
	</div>
""")))}/*26.3*/else/*26.8*/{_display_(Seq[Any](format.raw/*26.9*/("""
    Mostrando """),_display_(Seq[Any](/*27.16*/buscador/*27.24*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*27.56*/(""" resultado(s). 
    	
	<table class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th>Codigo</th>
				<th>Nombre</th>
			</tr>
		</thead>
		<tbody>
    	
    """),_display_(Seq[Any](/*38.6*/for(cie <- buscador.getList) yield /*38.34*/ {_display_(Seq[Any](format.raw/*38.36*/("""
	<tr data-id=""""),_display_(Seq[Any](/*39.16*/cie/*39.19*/.id)),format.raw/*39.22*/("""" class="modalSeleccionCie">
		<td> """),_display_(Seq[Any](/*40.9*/cie/*40.12*/.nombre)),format.raw/*40.19*/("""</td>
		<td> """),_display_(Seq[Any](/*41.9*/if(Permiso.check("descripcionCie"))/*41.44*/{_display_(Seq[Any](_display_(Seq[Any](/*41.46*/cie/*41.49*/.descripcion))))})),format.raw/*41.62*/("""</td>
	</tr>    
    """)))})),format.raw/*43.6*/("""
    </tbody>
    </table>
    
	<div class="pagination pull-right">
	    """),_display_(Seq[Any](/*48.7*/views/*48.12*/.html.helpers.paginador(buscador, controllers.rrhh.routes.CiesController.modalBuscar()))),format.raw/*48.99*/("""
	</div>	
""")))})),format.raw/*50.2*/("""
</div>

<script>
$( function()"""),format.raw/*54.14*/("""{"""),format.raw/*54.15*/("""
	var contenedor = $("#modalBusquedaCies");
	var url = """"),_display_(Seq[Any](/*56.14*/controllers/*56.25*/.rrhh.routes.CiesController.get())),format.raw/*56.58*/(""""
	contenedor.find('.modalSeleccionCie').on('click', function()"""),format.raw/*57.62*/("""{"""),format.raw/*57.63*/("""
		var id = $(this).attr('data-id');
		$.get(url+"?id="+id, function(data)"""),format.raw/*59.38*/("""{"""),format.raw/*59.39*/("""
			$(document).trigger("modal.seleccion.cie.simple", data);
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
"""),format.raw/*72.1*/("""}"""),format.raw/*72.2*/(""");"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[Cie],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[Cie],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:30 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/cies/modalBusquedaCie.scala.html
                    HASH: bd3965252bd97f56db3a6663a461f25a29137788
                    MATRIX: 833->1|1028->113|1060->137|1134->72|1162->181|1286->270|1305->281|1367->322|1513->433|1621->519|1837->700|1880->734|1920->736|2003->802|2015->807|2053->808|2105->824|2122->832|2176->864|2396->1049|2440->1077|2480->1079|2532->1095|2544->1098|2569->1101|2641->1138|2653->1141|2682->1148|2731->1162|2775->1197|2823->1199|2835->1202|2874->1215|2927->1237|3037->1312|3051->1317|3160->1404|3202->1415|3261->1446|3290->1447|3383->1504|3403->1515|3458->1548|3549->1611|3578->1612|3680->1686|3709->1687|3799->1750|3827->1751|3858->1755|3886->1756|3967->1809|3996->1810|4133->1919|4162->1920|4227->1958|4255->1959|4302->1979|4330->1980|4360->1983|4388->1984
                    LINES: 26->1|31->4|31->4|32->1|33->4|36->7|36->7|36->7|40->11|40->11|51->22|51->22|51->22|55->26|55->26|55->26|56->27|56->27|56->27|67->38|67->38|67->38|68->39|68->39|68->39|69->40|69->40|69->40|70->41|70->41|70->41|70->41|70->41|72->43|77->48|77->48|77->48|79->50|83->54|83->54|85->56|85->56|85->56|86->57|86->57|88->59|88->59|90->61|90->61|91->62|91->62|93->64|93->64|96->67|96->67|98->69|98->69|100->71|100->71|101->72|101->72
                    -- GENERATED --
                */
            