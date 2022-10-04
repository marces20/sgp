
package views.html.haberes.novedades

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
object listaNovedades extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[utils.pagination.Pagination[models.haberes.Novedad],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[models.haberes.Novedad]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import models.auth._

import utils._


Seq[Any](format.raw/*1.65*/("""
"""),format.raw/*5.1*/("""
<h4>Novedades cargadas</h4>


 """),_display_(Seq[Any](/*9.3*/if(buscador.getTotalRowCount == 0)/*9.37*/ {_display_(Seq[Any](format.raw/*9.39*/("""
      
      <div class="well">
          <em>No se encuentran novedades</em>
      </div>
      
  """)))}/*15.5*/else/*15.10*/{_display_(Seq[Any](format.raw/*15.11*/("""

Mostrando """),_display_(Seq[Any](/*17.12*/buscador/*17.20*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*17.52*/(""" resultado(s).   
<table class="table table-striped table-bordered table-hover">
	<thead>
		<tr>
			<th width="30"></th>
			<th>Puesto laboral</th>
			<th width="150">Concepto</th>
			<th width="90">Cantidad</th>
			<th width="90">Importe</th>
			<th width="90">Periodo inicio</th>
			<th width="90">Periodo fin</th>
			<th width="90">Tipo Liq.</th>
			<th width="30"></th>
		</tr>
	</thead>
	<tbody>
	

	
        """),_display_(Seq[Any](/*36.10*/for(novedad <- buscador.getList) yield /*36.42*/ {_display_(Seq[Any](format.raw/*36.44*/("""
		<tr class="pointer" data-href=""""),_display_(Seq[Any](/*37.35*/controllers/*37.46*/.haberes.routes.NovedadesController.ver(novedad.id))),format.raw/*37.97*/("""&"""),_display_(Seq[Any](/*37.99*/UriTrack/*37.107*/.encode())),format.raw/*37.116*/("""">
			<td><a class="btn btn-default btn-xs notSeleccion" href=""""),_display_(Seq[Any](/*38.62*/controllers/*38.73*/.haberes.routes.NovedadesController.editar(novedad.id))),format.raw/*38.127*/("""&"""),_display_(Seq[Any](/*38.129*/UriTrack/*38.137*/.encode())),format.raw/*38.146*/(""""><i class="glyphicon glyphicon-edit"></i></a></td>
			<td>"""),_display_(Seq[Any](/*39.9*/novedad/*39.16*/.puestoLaboral.legajo.agente.getNombreCompleto())),format.raw/*39.64*/("""</td>
			<td>"""),_display_(Seq[Any](/*40.9*/novedad/*40.16*/.concepto.denominacion)),format.raw/*40.38*/("""</td>
			<td>"""),_display_(Seq[Any](/*41.9*/novedad/*41.16*/.cantidad)),format.raw/*41.25*/("""</td>
			<td>"""),_display_(Seq[Any](/*42.9*/utils/*42.14*/.NumberUtils.moneda(novedad.importe))),format.raw/*42.50*/("""</td>
			<td>"""),_display_(Seq[Any](/*43.9*/novedad/*43.16*/.periodoInicio.nombre)),format.raw/*43.37*/("""</td>
			<td>"""),_display_(Seq[Any](/*44.9*/if(novedad.periodoFin != null)/*44.39*/{_display_(Seq[Any](_display_(Seq[Any](/*44.41*/novedad/*44.48*/.periodoFin.nombre))))})),format.raw/*44.67*/("""</td>
			<td>"""),_display_(Seq[Any](/*45.9*/if(novedad.liquidacionTipo != null)/*45.44*/{_display_(Seq[Any](_display_(Seq[Any](/*45.46*/novedad/*45.53*/.liquidacionTipo.nombre))))})),format.raw/*45.77*/("""</td>
			<td>
				"""),_display_(Seq[Any](/*47.6*/if(Permiso.check("liquidacionNovedadesEliminar"))/*47.55*/ {_display_(Seq[Any](format.raw/*47.57*/("""	
				<a class="btn btn-default btn-xs  eliminarNovedad notSeleccion" href=""""),_display_(Seq[Any](/*48.76*/controllers/*48.87*/.haberes.routes.NovedadesController.eliminar(novedad.id))),format.raw/*48.143*/("""&"""),_display_(Seq[Any](/*48.145*/UriTrack/*48.153*/.encode())),format.raw/*48.162*/(""""><i class="glyphicon glyphicon-trash icono-eliminar"></i></a>
				""")))})),format.raw/*49.6*/("""
			</td>
		</tr>
        """)))})),format.raw/*52.10*/("""
	</tbody>
</table>

<div class="pagination pull-right">
    """),_display_(Seq[Any](/*57.6*/views/*57.11*/.html.helpers.paginador(buscador, controllers.haberes.routes.NovedadesController.index()))),format.raw/*57.100*/("""
</div>

  """)))})))}
    }
    
    def render(buscador:utils.pagination.Pagination[models.haberes.Novedad]): play.api.templates.HtmlFormat.Appendable = apply(buscador)
    
    def f:((utils.pagination.Pagination[models.haberes.Novedad]) => play.api.templates.HtmlFormat.Appendable) = (buscador) => apply(buscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:35 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/novedades/listaNovedades.scala.html
                    HASH: 0fcc75f5320639c2d33f33fce3372704ccb2fef6
                    MATRIX: 846->1|1060->64|1088->124|1159->161|1201->195|1240->197|1366->306|1379->311|1418->312|1469->327|1486->335|1540->367|2010->801|2058->833|2098->835|2170->871|2190->882|2263->933|2301->935|2319->943|2351->952|2452->1017|2472->1028|2549->1082|2588->1084|2606->1092|2638->1101|2734->1162|2750->1169|2820->1217|2870->1232|2886->1239|2930->1261|2980->1276|2996->1283|3027->1292|3077->1307|3091->1312|3149->1348|3199->1363|3215->1370|3258->1391|3308->1406|3347->1436|3395->1438|3411->1445|3456->1464|3506->1479|3550->1514|3598->1516|3614->1523|3664->1547|3720->1568|3778->1617|3818->1619|3932->1697|3952->1708|4031->1764|4070->1766|4088->1774|4120->1783|4220->1852|4282->1882|4384->1949|4398->1954|4510->2043
                    LINES: 26->1|34->1|35->5|39->9|39->9|39->9|45->15|45->15|45->15|47->17|47->17|47->17|66->36|66->36|66->36|67->37|67->37|67->37|67->37|67->37|67->37|68->38|68->38|68->38|68->38|68->38|68->38|69->39|69->39|69->39|70->40|70->40|70->40|71->41|71->41|71->41|72->42|72->42|72->42|73->43|73->43|73->43|74->44|74->44|74->44|74->44|74->44|75->45|75->45|75->45|75->45|75->45|77->47|77->47|77->47|78->48|78->48|78->48|78->48|78->48|78->48|79->49|82->52|87->57|87->57|87->57
                    -- GENERATED --
                */
            