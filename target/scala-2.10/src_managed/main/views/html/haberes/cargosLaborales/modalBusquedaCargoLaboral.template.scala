
package views.html.haberes.cargosLaborales

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
object modalBusquedaCargoLaboral extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[models.haberes.CargoLaboral],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[models.haberes.CargoLaboral], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.97*/("""
"""),format.raw/*3.70*/(""" 

<div id="modalBusquedaCargosLaborales" class="contenedorPaginador ajaxPaginador">
<form action=""""),_display_(Seq[Any](/*6.16*/controllers/*6.27*/.haberes.routes.CargosLaboralesController.modalBuscar())),format.raw/*6.82*/("""" method="GET">
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
	    <em>No se encuentran cargos</em>
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
	<tr data-id=""""),_display_(Seq[Any](/*37.16*/lc/*37.18*/.id)),format.raw/*37.21*/("""" class="modalSeleccionCargoLaboral">
		<td> """),_display_(Seq[Any](/*38.9*/lc/*38.11*/.nombre)),format.raw/*38.18*/("""</td>
	</tr>    
    """)))})),format.raw/*40.6*/("""
    </tbody>
    </table>
    
	<div class="pagination pull-right">
	    """),_display_(Seq[Any](/*45.7*/views/*45.12*/.html.helpers.paginador(buscador, controllers.haberes.routes.CargosLaboralesController.modalBuscar()))),format.raw/*45.113*/("""
	</div>	
""")))})),format.raw/*47.2*/("""
</div>

<script>
$( function()"""),format.raw/*51.14*/("""{"""),format.raw/*51.15*/("""
	var contenedor = $("#modalBusquedaCargosLaborales");
										   
	var url = """"),_display_(Seq[Any](/*54.14*/controllers/*54.25*/.haberes.routes.CargosLaboralesController.get())),format.raw/*54.72*/(""""
	contenedor.find('.modalSeleccionCargoLaboral').on('click', function()"""),format.raw/*55.71*/("""{"""),format.raw/*55.72*/("""
		var id = $(this).attr('data-id');
		$.get(url+"?id="+id, function(data)"""),format.raw/*57.38*/("""{"""),format.raw/*57.39*/("""
			$(document).trigger("modal.seleccion.cargoLaboral.simple", data);
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
    
    def render(buscador:utils.pagination.Pagination[models.haberes.CargoLaboral],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[models.haberes.CargoLaboral],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/cargosLaborales/modalBusquedaCargoLaboral.scala.html
                    HASH: cafd63b033654907aeeb78b300829eef691291d8
                    MATRIX: 880->1|1078->117|1110->141|1184->96|1213->185|1351->288|1370->299|1446->354|1602->475|1710->561|1937->753|1980->787|2020->789|2110->862|2122->867|2160->868|2213->885|2230->893|2284->925|2500->1106|2543->1133|2583->1135|2636->1152|2647->1154|2672->1157|2754->1204|2765->1206|2794->1213|2849->1237|2964->1317|2978->1322|3102->1423|3146->1436|3209->1471|3238->1472|3359->1557|3379->1568|3448->1615|3549->1688|3578->1689|3682->1765|3711->1766|3812->1840|3840->1841|3872->1846|3900->1847|3983->1902|4012->1903|4152->2015|4181->2016|4248->2056|4276->2057|4325->2079|4353->2080|4384->2084|4412->2085
                    LINES: 26->1|29->3|29->3|30->1|31->3|34->6|34->6|34->6|38->10|38->10|49->21|49->21|49->21|53->25|53->25|53->25|54->26|54->26|54->26|64->36|64->36|64->36|65->37|65->37|65->37|66->38|66->38|66->38|68->40|73->45|73->45|73->45|75->47|79->51|79->51|82->54|82->54|82->54|83->55|83->55|85->57|85->57|87->59|87->59|88->60|88->60|90->62|90->62|93->65|93->65|95->67|95->67|97->69|97->69|98->70|98->70
                    -- GENERATED --
                */
            