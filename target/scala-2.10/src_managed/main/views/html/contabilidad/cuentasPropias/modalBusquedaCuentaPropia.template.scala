
package views.html.contabilidad.cuentasPropias

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
object modalBusquedaCuentaPropia extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[CuentaPropia],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[CuentaPropia], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.82*/("""
"""),format.raw/*3.70*/(""" 

<div id="modalBusquedaCuentasPropias" class="contenedorPaginador ajaxPaginador">
<form action=""""),_display_(Seq[Any](/*6.16*/controllers/*6.27*/.contabilidad.routes.CuentasPropiasController.modalBuscar())),format.raw/*6.86*/("""" method="GET">
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
	    <em>No se encuentran Cuentas</em>
	</div>
""")))}/*25.3*/else/*25.8*/{_display_(Seq[Any](format.raw/*25.9*/("""
    Mostrando """),_display_(Seq[Any](/*26.16*/buscador/*26.24*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*26.56*/(""" resultado(s). 
    	
	<table class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th>Numero</th>
				<th>Nombre</th>
			</tr>
		</thead>
		<tbody>
    	
    """),_display_(Seq[Any](/*37.6*/for(cuenta <- buscador.getList) yield /*37.37*/ {_display_(Seq[Any](format.raw/*37.39*/("""
	<tr data-id=""""),_display_(Seq[Any](/*38.16*/cuenta/*38.22*/.id)),format.raw/*38.25*/("""" class="modalSeleccionCuentaPropia">
		<td> """),_display_(Seq[Any](/*39.9*/cuenta/*39.15*/.numero)),format.raw/*39.22*/("""</td>	
		<td> """),_display_(Seq[Any](/*40.9*/cuenta/*40.15*/.nombre)),format.raw/*40.22*/("""</td>
	</tr>    
    """)))})),format.raw/*42.6*/("""
    </tbody>
    </table>
    
	<div class="pagination pull-right">
	    """),_display_(Seq[Any](/*47.7*/views/*47.12*/.html.helpers.paginador(buscador, controllers.contabilidad.routes.CuentasPropiasController.modalBuscar()))),format.raw/*47.117*/("""
	</div>	
""")))})),format.raw/*49.2*/("""
</div>

<script>
$( function()"""),format.raw/*53.14*/("""{"""),format.raw/*53.15*/("""
	var contenedor = $("#modalBusquedaCuentasPropias");
	var url = """"),_display_(Seq[Any](/*55.14*/controllers/*55.25*/.contabilidad.routes.CuentasPropiasController.get())),format.raw/*55.76*/(""""
	contenedor.find('.modalSeleccionCuentaPropia').on('click', function()"""),format.raw/*56.71*/("""{"""),format.raw/*56.72*/("""
		var id = $(this).attr('data-id');
		$.get(url+"?id="+id, function(data)"""),format.raw/*58.38*/("""{"""),format.raw/*58.39*/("""
			$(document).trigger("modal.seleccion.cuentaPropia.simple", data);
		"""),format.raw/*60.3*/("""}"""),format.raw/*60.4*/(""");
	"""),format.raw/*61.2*/("""}"""),format.raw/*61.3*/(""");
	
	contenedor.find('form').on('submit', function()"""),format.raw/*63.49*/("""{"""),format.raw/*63.50*/("""
		var url = $(this).attr("action");
		var query = $(this).serialize();
		$.get(url+"?"+query, function(data)"""),format.raw/*66.38*/("""{"""),format.raw/*66.39*/("""
			contenedor.parent().html(data);
		"""),format.raw/*68.3*/("""}"""),format.raw/*68.4*/(""");
		return false;
	"""),format.raw/*70.2*/("""}"""),format.raw/*70.3*/(""");
"""),format.raw/*71.1*/("""}"""),format.raw/*71.2*/(""");
</script>"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[CuentaPropia],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[CuentaPropia],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:38 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/cuentasPropias/modalBusquedaCuentaPropia.scala.html
                    HASH: 65bceecfbb2df9a2a3de950a8a54ba753d233c1f
                    MATRIX: 869->1|1052->102|1084->126|1158->81|1187->170|1324->272|1343->283|1423->342|1573->457|1681->543|1908->735|1951->769|1991->771|2082->845|2094->850|2132->851|2185->868|2202->876|2256->908|2487->1104|2534->1135|2574->1137|2627->1154|2642->1160|2667->1163|2749->1210|2764->1216|2793->1223|2844->1239|2859->1245|2888->1252|2943->1276|3058->1356|3072->1361|3200->1466|3244->1479|3307->1514|3336->1515|3441->1584|3461->1595|3534->1646|3635->1719|3664->1720|3768->1796|3797->1797|3898->1871|3926->1872|3958->1877|3986->1878|4069->1933|4098->1934|4238->2046|4267->2047|4334->2087|4362->2088|4411->2110|4439->2111|4470->2115|4498->2116
                    LINES: 26->1|29->3|29->3|30->1|31->3|34->6|34->6|34->6|38->10|38->10|49->21|49->21|49->21|53->25|53->25|53->25|54->26|54->26|54->26|65->37|65->37|65->37|66->38|66->38|66->38|67->39|67->39|67->39|68->40|68->40|68->40|70->42|75->47|75->47|75->47|77->49|81->53|81->53|83->55|83->55|83->55|84->56|84->56|86->58|86->58|88->60|88->60|89->61|89->61|91->63|91->63|94->66|94->66|96->68|96->68|98->70|98->70|99->71|99->71
                    -- GENERATED --
                */
            