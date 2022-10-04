
package views.html.rrhh.agenteAsistenciaLicencia

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
object indexAgenteAsistenciaLicencia extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[AgenteAsistenciaLicencia],Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(paginador:  utils.pagination.Pagination[AgenteAsistenciaLicencia], editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._


Seq[Any](format.raw/*1.88*/("""
"""),format.raw/*5.1*/("""<div id="listaLineaAgenteAsistenciaLicencias" class="contenedorPaginador ajaxPaginador">

<p>
	<b>Licencias</b>
	"""),_display_(Seq[Any](/*9.3*/if(editable &&  Permiso.check("agentesLicenciasCrear"))/*9.58*/{_display_(Seq[Any](format.raw/*9.59*/("""
	<a class="btn btn-default btn-xs" href="#" id="nuevoAgenteAsistenciaLicencia"><i class="glyphicon glyphicon-plus"></i> Nuevo</a>	 	
	""")))})),format.raw/*11.3*/("""
</p>

<table id="listaDeAgenteAsistenciaLicencias" class="table table-striped table-bordered">
	<thead>
		<tr>
			<th width="30"></th>
			<th class="accion-editar" width="50">#</th>
			<th>Tipo Licencia</th>
			<th>Presentacion</th>
			<th>Inicio</th>
			<th>Fin</th>
			<th>Dias</th>
			<th>Año</th>
			<th>Nota</th>
			<th>Usuario</th>
			<th>Estado</th>
			<th class="50">#</th>
		<tr>	
	</thead>
	<tbody>
	"""),_display_(Seq[Any](/*32.3*/for(linea <- paginador.getList) yield /*32.34*/ {_display_(Seq[Any](format.raw/*32.36*/("""
		"""),_display_(Seq[Any](/*33.4*/views/*33.9*/.html.rrhh.agenteAsistenciaLicencia.lineaAgenteAsistenciaLicencia(linea, editable))),format.raw/*33.91*/("""
	""")))})),format.raw/*34.3*/("""
	</tbody>
</table>

<div class="pagination pull-right">		
    """),_display_(Seq[Any](/*39.6*/views/*39.11*/.html.helpers.paginador(paginador, controllers.rrhh.routes.AgentesAsistenciasLicenciasController.index()))),format.raw/*39.116*/("""
</div>
</div>


"""))}
    }
    
    def render(paginador:utils.pagination.Pagination[AgenteAsistenciaLicencia],editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(paginador,editable)
    
    def f:((utils.pagination.Pagination[AgenteAsistenciaLicencia],Boolean) => play.api.templates.HtmlFormat.Appendable) = (paginador,editable) => apply(paginador,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:30 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agenteAsistenciaLicencia/indexAgenteAsistenciaLicencia.scala.html
                    HASH: 8318307088e0031646f22f00a5566a1b9caf93bf
                    MATRIX: 883->1|1120->87|1148->147|1300->265|1363->320|1401->321|1570->459|2038->892|2085->923|2125->925|2165->930|2178->935|2282->1017|2317->1021|2421->1090|2435->1095|2563->1200
                    LINES: 26->1|34->1|35->5|39->9|39->9|39->9|41->11|62->32|62->32|62->32|63->33|63->33|63->33|64->34|69->39|69->39|69->39
                    -- GENERATED --
                */
            