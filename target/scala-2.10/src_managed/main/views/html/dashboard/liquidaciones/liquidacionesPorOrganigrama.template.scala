
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
object liquidacionesPorOrganigrama extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template4[DynamicForm,List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm,rowParque:List[com.avaje.ebean.SqlRow],rowConvenio:List[com.avaje.ebean.SqlRow],rowPlanta:List[com.avaje.ebean.SqlRow]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.148*/("""
"""),format.raw/*5.70*/("""

"""),_display_(Seq[Any](/*7.2*/views/*7.7*/.html.dashboard.mainDashboard("Liquidaciones por Organigrama")/*7.69*/ {_display_(Seq[Any](format.raw/*7.71*/("""
<script>
$( function()"""),format.raw/*9.14*/("""{"""),format.raw/*9.15*/(""" $('.searchModal').modalSearch();"""),format.raw/*9.48*/("""}"""),format.raw/*9.49*/(""")

</script>
<script src=""""),_display_(Seq[Any](/*12.15*/routes/*12.21*/.Assets.at("javascripts/dashboard/liquidacionesPorProfesion.js"))),format.raw/*12.85*/("""" type="text/javascript"></script>
<div class="page-header">
	<div class="row">
		<div class="col-sm-7">
			<h1>Liquidaciones por Organigrama</h1>
		</div>
		<div class="col-sm-5">
			<div class="dropdown pull-right">
			 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
			 	<i class="glyphicon glyphicon-list-alt"></i>
			    Reportes
			    <span class="caret"></span>
			  </button>
			  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
			  	<li><a tabindex="-1" href="#" id="liquidacionesPorOrganigramaReporte" data-url=""""),_display_(Seq[Any](/*26.88*/controllers/*26.99*/.dashboard.routes.LiquidacionesReportesController.liquidacionesPorOrganigrama())),format.raw/*26.178*/("""">Exportar</a></li>
			  </ul>
			</div>
		</div>
	</div>
</div>	
"""),_display_(Seq[Any](/*32.2*/views/*32.7*/.html.tags.successError())),format.raw/*32.32*/("""
<div id="actions">
	<form action="" method="GET">
		<div class="row">
			<form action="" id="formSearchLiquidacionesPorOrganigrama" method="GET">
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
				<label for="inputOrgranigrama" class="control-label">Departamento/Servicio</label> 
				<div class="input-group">
					"""),_display_(Seq[Any](/*61.7*/inputText(formBuscador("organigrama.nombre"),'class -> "form-control",'id -> "organigrama"))),format.raw/*61.98*/("""
					"""),_display_(Seq[Any](/*62.7*/inputText(formBuscador("organigrama_id"),'hidden -> "hidden",'id -> "organigrama_id"))),format.raw/*62.92*/("""
					<span class="input-group-addon">
	                	<a href="#" id="searchOrganigrama" data-title="Selección de Departamento/Servicio" 
	                				data-url=""""),_display_(Seq[Any](/*65.33*/controllers/*65.44*/.administracion.routes.OrganigramasController.modalBuscarServicios())),format.raw/*65.112*/("""" 
	                				data-height="650" data-width="700" 
	                				data-listen="modal.seleccion.servicio.simple" 
	                				data-label="#organigrama" data-field="#organigrama_id" /> <i class="glyphicon glyphicon-search"></i></a>
	                </span>
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

	"""),_display_(Seq[Any](/*84.3*/views/*84.8*/.html.dashboard.liquidaciones.vistas.listaHaberesClasificacion(rowParque,rowConvenio,rowPlanta))),format.raw/*84.103*/(""" 
""")))})))}
    }
    
    def render(formBuscador:DynamicForm,rowParque:List[com.avaje.ebean.SqlRow],rowConvenio:List[com.avaje.ebean.SqlRow],rowPlanta:List[com.avaje.ebean.SqlRow]): play.api.templates.HtmlFormat.Appendable = apply(formBuscador,rowParque,rowConvenio,rowPlanta)
    
    def f:((DynamicForm,List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow]) => play.api.templates.HtmlFormat.Appendable) = (formBuscador,rowParque,rowConvenio,rowPlanta) => apply(formBuscador,rowParque,rowConvenio,rowPlanta)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:44:01 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/liquidaciones/liquidacionesPorOrganigrama.scala.html
                    HASH: 430efbfa42b0793e317502bb5284f966660f39d8
                    MATRIX: 912->1|1198->204|1230->228|1305->147|1333->272|1370->275|1382->280|1452->342|1491->344|1541->367|1569->368|1629->401|1657->402|1720->429|1735->435|1821->499|2463->1105|2483->1116|2585->1195|2687->1262|2700->1267|2747->1292|3060->1570|3158->1646|3200->1653|3299->1730|3501->1896|3521->1907|3596->1960|4053->2382|4166->2473|4208->2480|4315->2565|4524->2738|4544->2749|4635->2817|5260->3407|5273->3412|5391->3507
                    LINES: 26->1|33->5|33->5|34->1|35->5|37->7|37->7|37->7|37->7|39->9|39->9|39->9|39->9|42->12|42->12|42->12|56->26|56->26|56->26|62->32|62->32|62->32|70->40|70->40|71->41|71->41|76->46|76->46|76->46|91->61|91->61|92->62|92->62|95->65|95->65|95->65|114->84|114->84|114->84
                    -- GENERATED --
                */
            