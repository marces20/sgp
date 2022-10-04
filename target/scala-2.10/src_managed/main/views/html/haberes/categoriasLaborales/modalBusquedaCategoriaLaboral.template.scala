
package views.html.haberes.categoriasLaborales

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
object modalBusquedaCategoriaLaboral extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[models.haberes.CategoriaLaboral],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[models.haberes.CategoriaLaboral], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.101*/("""
"""),format.raw/*3.70*/(""" 

<div id="modalBusquedaCategoriasLaborales" class="contenedorPaginador ajaxPaginador">
<form action=""""),_display_(Seq[Any](/*6.16*/controllers/*6.27*/.haberes.routes.CategoriasLaboralesController.modalBuscar())),format.raw/*6.86*/("""" method="GET">
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
	    <em>No se encuentran Categorias</em>
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
	<tr data-id=""""),_display_(Seq[Any](/*37.16*/lc/*37.18*/.id)),format.raw/*37.21*/("""" class="modalSeleccionCategoriaLaboral">
		<td> """),_display_(Seq[Any](/*38.9*/lc/*38.11*/.nombre)),format.raw/*38.18*/("""</td>
	</tr>    
    """)))})),format.raw/*40.6*/("""
    </tbody>
    </table>
    
	<div class="pagination pull-right">
	    """),_display_(Seq[Any](/*45.7*/views/*45.12*/.html.helpers.paginador(buscador, controllers.haberes.routes.CategoriasLaboralesController.modalBuscar()))),format.raw/*45.117*/("""
	</div>	
""")))})),format.raw/*47.2*/("""
</div>

<script>
$( function()"""),format.raw/*51.14*/("""{"""),format.raw/*51.15*/("""
	var contenedor = $("#modalBusquedaCategoriasLaborales");
										   
	var url = """"),_display_(Seq[Any](/*54.14*/controllers/*54.25*/.haberes.routes.CategoriasLaboralesController.get())),format.raw/*54.76*/(""""
	contenedor.find('.modalSeleccionCategoriaLaboral').on('click', function()"""),format.raw/*55.75*/("""{"""),format.raw/*55.76*/("""
		var id = $(this).attr('data-id');
		$.get(url+"?id="+id, function(data)"""),format.raw/*57.38*/("""{"""),format.raw/*57.39*/("""
			$(document).trigger("modal.seleccion.categoriaLaboral.simple", data);
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
    
    def render(buscador:utils.pagination.Pagination[models.haberes.CategoriaLaboral],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[models.haberes.CategoriaLaboral],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/categoriasLaborales/modalBusquedaCategoriaLaboral.scala.html
                    HASH: 561ea9db0f8b041743c26af48884bba21a848517
                    MATRIX: 892->1|1094->121|1126->145|1201->100|1230->189|1372->296|1391->307|1471->366|1627->487|1735->573|1962->765|2005->799|2045->801|2139->878|2151->883|2189->884|2242->901|2259->909|2313->941|2529->1122|2572->1149|2612->1151|2665->1168|2676->1170|2701->1173|2787->1224|2798->1226|2827->1233|2882->1257|2997->1337|3011->1342|3139->1447|3183->1460|3246->1495|3275->1496|3400->1585|3420->1596|3493->1647|3598->1724|3627->1725|3731->1801|3760->1802|3865->1880|3893->1881|3925->1886|3953->1887|4036->1942|4065->1943|4205->2055|4234->2056|4301->2096|4329->2097|4378->2119|4406->2120|4437->2124|4465->2125
                    LINES: 26->1|29->3|29->3|30->1|31->3|34->6|34->6|34->6|38->10|38->10|49->21|49->21|49->21|53->25|53->25|53->25|54->26|54->26|54->26|64->36|64->36|64->36|65->37|65->37|65->37|66->38|66->38|66->38|68->40|73->45|73->45|73->45|75->47|79->51|79->51|82->54|82->54|82->54|83->55|83->55|85->57|85->57|87->59|87->59|88->60|88->60|90->62|90->62|93->65|93->65|95->67|95->67|97->69|97->69|98->70|98->70
                    -- GENERATED --
                */
            