
package views.html.dashboard.liquidaciones

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
object liquidacionesPorProfesion extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template4[DynamicForm,List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm,rowParque:List[com.avaje.ebean.SqlRow],rowConvenio:List[com.avaje.ebean.SqlRow],rowPlanta:List[com.avaje.ebean.SqlRow]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.148*/("""
"""),format.raw/*5.70*/("""

"""),_display_(Seq[Any](/*7.2*/views/*7.7*/.html.dashboard.mainDashboard("Liquidaciones por Profesion")/*7.67*/ {_display_(Seq[Any](format.raw/*7.69*/("""
<script>
$( function()"""),format.raw/*9.14*/("""{"""),format.raw/*9.15*/(""" $('.searchModal').modalSearch();"""),format.raw/*9.48*/("""}"""),format.raw/*9.49*/(""")

</script>
<script src=""""),_display_(Seq[Any](/*12.15*/routes/*12.21*/.Assets.at("javascripts/dashboard/liquidacionesPorProfesion.js"))),format.raw/*12.85*/("""" type="text/javascript"></script>
<div class="page-header">
	<div class="row">
		<div class="col-sm-7">
			<h1>Liquidaciones por Profesion</h1>
		</div>
		<div class="col-sm-5">
			<div class="dropdown pull-right">
			 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
			 	<i class="glyphicon glyphicon-list-alt"></i>
			    Reportes
			    <span class="caret"></span>
			  </button>
			  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
			  	<li><a tabindex="-1" href="#" id="liquidacionesPorProfesionReporte" data-url=""""),_display_(Seq[Any](/*26.86*/controllers/*26.97*/.dashboard.routes.LiquidacionesReportesController.liquidacionesPorProfesion())),format.raw/*26.174*/("""">Exportar</a></li>
			  </ul>
			</div>
		</div>
	</div>
</div>	
"""),_display_(Seq[Any](/*32.2*/views/*32.7*/.html.tags.successError())),format.raw/*32.32*/("""
<div id="actions">
	<form action="" method="GET">
		<div class="row">
			<form action="" id="formSearchLiquidacionesPorProfesion" method="GET">
			<div class="col-sm-2">
				<label for="inputPeriodo" class="control-label">Periodo</label> 
				<div class="input-group">
					"""),_display_(Seq[Any](/*40.7*/inputText(formBuscador("periodo"),'class -> "form-control",'id -> "periodo"))),format.raw/*40.83*/("""
					"""),_display_(Seq[Any](/*41.7*/inputText(formBuscador("periodo_id"),'hidden -> "hidden",'id -> "periodo_id"))),format.raw/*41.84*/("""
					<span class="input-group-addon">
					<a href="#" class="searchModal"
								id="searchPeriodo" 
								data-title="Selección de Periodo" 
								data-url=""""),_display_(Seq[Any](/*46.20*/controllers/*46.31*/.contabilidad.routes.PeriodosController.modalBuscar())),format.raw/*46.84*/("""" 
								data-height="650" 
								data-width="700" 
								data-listen="modal.seleccion.periodo.simple" 
								data-label="#periodo" 
								data-field="#periodo_id">
						<i class="glyphicon glyphicon-search"></i>
					</a>
					</span>
				</div>
			</div>
			<div class="col-sm-4">
				<label for="solicitante" class="control-label">Profesion</label> 
				<div class="input-group">
					"""),_display_(Seq[Any](/*60.7*/inputText(formBuscador("profesion.nombre"), 'name -> "", 'class -> "form-control", 'id -> "profesion"))),format.raw/*60.109*/("""
					"""),_display_(Seq[Any](/*61.7*/inputText(formBuscador("profesion_id"), 'hidden -> "hidden", 'id -> "profesion_id"))),format.raw/*61.90*/("""
					<span class="input-group-addon">
					<a href="#" class="searchModal" id="searchProfesion" 
							 	data-title="Selección de profesion" 
							 	data-url=""""),_display_(Seq[Any](/*65.21*/controllers/*65.32*/.rrhh.routes.ProfesionesController.modalBuscar())),format.raw/*65.80*/("""" 
							 	data-height="650" data-width="700" 
							 	data-listen="modal.seleccion.profesion.simple" 
							 	data-label="#profesion" 
							 	data-field="#profesion_id">
					<i class="glyphicon glyphicon-search"></i></a></span>
				</div>
			</div>
			<div class="col-sm-2">
				<div class="form-group">
				<label for="nombre" class="control-label">&nbsp;</label>
				<button  class="form-control btn btn-primary"><i class="glyphicon glyphicon-search"></i> Buscar</button>
				</div>
			</div>
			</form>
		</div>
	</form>
</div>
<hr>

	"""),_display_(Seq[Any](/*85.3*/views/*85.8*/.html.dashboard.liquidaciones.vistas.listaHaberesClasificacion(rowParque,rowConvenio,rowPlanta))),format.raw/*85.103*/(""" 
""")))})))}
    }
    
    def render(formBuscador:DynamicForm,rowParque:List[com.avaje.ebean.SqlRow],rowConvenio:List[com.avaje.ebean.SqlRow],rowPlanta:List[com.avaje.ebean.SqlRow]): play.api.templates.HtmlFormat.Appendable = apply(formBuscador,rowParque,rowConvenio,rowPlanta)
    
    def f:((DynamicForm,List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow]) => play.api.templates.HtmlFormat.Appendable) = (formBuscador,rowParque,rowConvenio,rowPlanta) => apply(formBuscador,rowParque,rowConvenio,rowPlanta)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:44:01 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/liquidaciones/liquidacionesPorProfesion.scala.html
                    HASH: 43e07014725265bff19d441e999517fbb4337b9e
                    MATRIX: 910->1|1196->204|1228->228|1303->147|1331->272|1368->275|1380->280|1448->340|1487->342|1537->365|1565->366|1625->399|1653->400|1716->427|1731->433|1817->497|2455->1099|2475->1110|2575->1187|2677->1254|2690->1259|2737->1284|3048->1560|3146->1636|3188->1643|3287->1720|3489->1886|3509->1897|3584->1950|4019->2350|4144->2452|4186->2459|4291->2542|4491->2706|4511->2717|4581->2765|5162->3311|5175->3316|5293->3411
                    LINES: 26->1|33->5|33->5|34->1|35->5|37->7|37->7|37->7|37->7|39->9|39->9|39->9|39->9|42->12|42->12|42->12|56->26|56->26|56->26|62->32|62->32|62->32|70->40|70->40|71->41|71->41|76->46|76->46|76->46|90->60|90->60|91->61|91->61|95->65|95->65|95->65|115->85|115->85|115->85
                    -- GENERATED --
                */
            