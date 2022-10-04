
package views.html.contabilidad.cuentas

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
object modalBusquedaCuenta extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[Cuenta],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[Cuenta], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.76*/("""
"""),format.raw/*3.70*/(""" 

<div id="modalBusquedaCuentas" class="contenedorPaginador ajaxPaginador">
<form action=""""),_display_(Seq[Any](/*6.16*/controllers/*6.27*/.contabilidad.routes.CuentasController.modalBuscar())),format.raw/*6.79*/("""" method="GET">
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
				<th>Codigo</th>
				<th>Nombre</th>
			</tr>
		</thead>
		<tbody>
    	
    """),_display_(Seq[Any](/*37.6*/for(cuenta <- buscador.getList) yield /*37.37*/ {_display_(Seq[Any](format.raw/*37.39*/("""
	<tr data-id=""""),_display_(Seq[Any](/*38.16*/cuenta/*38.22*/.id)),format.raw/*38.25*/("""" class="modalSeleccionCuenta">
		<td> """),_display_(Seq[Any](/*39.9*/cuenta/*39.15*/.code)),format.raw/*39.20*/("""</td>	
		<td> """),_display_(Seq[Any](/*40.9*/cuenta/*40.15*/.nombre)),format.raw/*40.22*/("""</td>
	</tr>    
    """)))})),format.raw/*42.6*/("""
    </tbody>
    </table>
    
	<div class="pagination pull-right">
	    """),_display_(Seq[Any](/*47.7*/views/*47.12*/.html.helpers.paginador(buscador, controllers.contabilidad.routes.CuentasController.modalBuscar()))),format.raw/*47.110*/("""
	</div>	
""")))})),format.raw/*49.2*/("""
</div>

<script>
$( function()"""),format.raw/*53.14*/("""{"""),format.raw/*53.15*/("""
	var contenedor = $("#modalBusquedaCuentas");
	var url = """"),_display_(Seq[Any](/*55.14*/controllers/*55.25*/.contabilidad.routes.CuentasController.get())),format.raw/*55.69*/(""""
	contenedor.find('.modalSeleccionCuenta').on('click', function()"""),format.raw/*56.65*/("""{"""),format.raw/*56.66*/("""
		var id = $(this).attr('data-id');
		$.get(url+"?id="+id, function(data)"""),format.raw/*58.38*/("""{"""),format.raw/*58.39*/("""
			$(document).trigger("modal.seleccion.cuenta.simple", data);
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
    
    def render(buscador:utils.pagination.Pagination[Cuenta],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[Cuenta],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/cuentas/modalBusquedaCuenta.scala.html
                    HASH: 52e2efcb17022baf1115bfbcb793d7fa29222ac5
                    MATRIX: 850->1|1027->96|1059->120|1133->75|1162->164|1292->259|1311->270|1384->322|1534->437|1642->523|1869->715|1912->749|1952->751|2043->825|2055->830|2093->831|2146->848|2163->856|2217->888|2448->1084|2495->1115|2535->1117|2588->1134|2603->1140|2628->1143|2704->1184|2719->1190|2746->1195|2797->1211|2812->1217|2841->1224|2896->1248|3011->1328|3025->1333|3146->1431|3190->1444|3253->1479|3282->1480|3380->1542|3400->1553|3466->1597|3561->1664|3590->1665|3694->1741|3723->1742|3818->1810|3846->1811|3878->1816|3906->1817|3989->1872|4018->1873|4158->1985|4187->1986|4254->2026|4282->2027|4331->2049|4359->2050|4390->2054|4418->2055
                    LINES: 26->1|29->3|29->3|30->1|31->3|34->6|34->6|34->6|38->10|38->10|49->21|49->21|49->21|53->25|53->25|53->25|54->26|54->26|54->26|65->37|65->37|65->37|66->38|66->38|66->38|67->39|67->39|67->39|68->40|68->40|68->40|70->42|75->47|75->47|75->47|77->49|81->53|81->53|83->55|83->55|83->55|84->56|84->56|86->58|86->58|88->60|88->60|89->61|89->61|91->63|91->63|94->66|94->66|96->68|96->68|98->70|98->70|99->71|99->71
                    -- GENERATED --
                */
            