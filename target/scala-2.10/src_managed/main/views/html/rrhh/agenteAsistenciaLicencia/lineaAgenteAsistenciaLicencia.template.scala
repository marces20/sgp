
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
object lineaAgenteAsistenciaLicencia extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[AgenteAsistenciaLicencia,Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea: AgenteAsistenciaLicencia, editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

def /*5.2*/getClassEstado/*5.16*/(i:AgenteAsistenciaLicencia) = {{
	var classEstado:String = new String()
	
	if(i.estado != null && (i.estado.id == 93) ){
		classEstado = "borrador"
	}else if(i.estado != null && i.estado.id == 95){
		classEstado = "cancelada"
	}else if(i.estado != null && i.estado.id == 94){
		classEstado = "autorizado"
	}else if(i.estado != null && i.estado.id == 96){
		classEstado = "licenciaPreaprobado"
	}
	
	classEstado
}};
Seq[Any](format.raw/*1.54*/("""
"""),format.raw/*19.2*/("""

<tr data-id=""""),_display_(Seq[Any](/*21.15*/linea/*21.20*/.id)),format.raw/*21.23*/("""" class="pointer """),_display_(Seq[Any](/*21.41*/getClassEstado(linea))),format.raw/*21.62*/("""" data-estado=""""),_display_(Seq[Any](/*21.78*/linea/*21.83*/.estado_id)),format.raw/*21.93*/("""" >
	<td class="">
		<input type="checkbox" name="check_listado_inasistencia[]" value=""""),_display_(Seq[Any](/*23.70*/linea/*23.75*/.id)),format.raw/*23.78*/("""" class="notSeleccion" id="check-"""),_display_(Seq[Any](/*23.112*/linea/*23.117*/.id)),format.raw/*23.120*/(""""/>
	</td>
	"""),_display_(Seq[Any](/*25.3*/if(editable && (linea.estado_id.compareTo(Estado.AGENTE_LICENCIA_BORRADOR) == 0 || linea.estado_id.compareTo(Estado.AGENTE_LICENCIA_PREAPROBADO) == 0 || Permiso.check("agentesLicenciasModificarAprobadas")) && Permiso.check("agentesLicenciasModificar"))/*25.255*/{_display_(Seq[Any](format.raw/*25.256*/("""
		
		<td class="accion-editar">
		<a class="btn btn-default btn-xs modificarAgenteAsistenciaLicencia" href=""""),_display_(Seq[Any](/*28.78*/controllers/*28.89*/.rrhh.routes.AgentesAsistenciasLicenciasController.editar(linea.id))),format.raw/*28.156*/(""""><i class="glyphicon glyphicon-edit"></i></a>
		</td>
	""")))}/*30.3*/else/*30.7*/{_display_(Seq[Any](format.raw/*30.8*/("""
		<td></td>
	""")))})),format.raw/*32.3*/("""
	<td>"""),_display_(Seq[Any](/*33.7*/linea/*33.12*/.tipoLicencia.nombre)),format.raw/*33.32*/("""</td>
	<td>"""),_display_(Seq[Any](/*34.7*/if(linea.fpresentacion != null)/*34.38*/{_display_(Seq[Any](_display_(Seq[Any](/*34.40*/(utils.DateUtils.formatDate(linea.fpresentacion))))))})),format.raw/*34.90*/("""</td>
	<td>"""),_display_(Seq[Any](/*35.7*/if(linea.finicio != null)/*35.32*/{_display_(Seq[Any](_display_(Seq[Any](/*35.34*/(utils.DateUtils.formatDate(linea.finicio))))))})),format.raw/*35.78*/("""</td>
	<td>"""),_display_(Seq[Any](/*36.7*/if(linea.ffin != null)/*36.29*/{_display_(Seq[Any](_display_(Seq[Any](/*36.31*/(utils.DateUtils.formatDate(linea.ffin))))))})),format.raw/*36.72*/("""</td>
	<td>"""),_display_(Seq[Any](/*37.7*/linea/*37.12*/.getDiasEntreFechas())),format.raw/*37.33*/("""</td>
	<td>"""),_display_(Seq[Any](/*38.7*/linea/*38.12*/.ejercicio.nombre)),format.raw/*38.29*/("""</td>
	<td>"""),_display_(Seq[Any](/*39.7*/linea/*39.12*/.nota)),format.raw/*39.17*/("""</td>
	<td>"""),_display_(Seq[Any](/*40.7*/linea/*40.12*/.create_usuario.nombre)),format.raw/*40.34*/("""</td>
	<td class="estado">"""),_display_(Seq[Any](/*41.22*/linea/*41.27*/.estado.nombre)),format.raw/*41.41*/("""</td>
	"""),_display_(Seq[Any](/*42.3*/if(editable && Permiso.check("agentesLicenciasEliminar"))/*42.60*/{_display_(Seq[Any](format.raw/*42.61*/("""
		<td><a class="btn btn-default btn-xs eliminarAgenteAsistenciaLicencia" href=""""),_display_(Seq[Any](/*43.81*/controllers/*43.92*/.rrhh.routes.AgentesAsistenciasLicenciasController.eliminar(linea.id))),format.raw/*43.161*/(""""><i class="glyphicon glyphicon-trash icono-eliminar"></i></a></td>
	""")))}/*44.3*/else/*44.7*/{_display_(Seq[Any](format.raw/*44.8*/("""
		<td></td>
	""")))})),format.raw/*46.3*/("""
</tr>"""))}
    }
    
    def render(linea:AgenteAsistenciaLicencia,editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(linea,editable)
    
    def f:((AgenteAsistenciaLicencia,Boolean) => play.api.templates.HtmlFormat.Appendable) = (linea,editable) => apply(linea,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:30 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agenteAsistenciaLicencia/lineaAgenteAsistenciaLicencia.scala.html
                    HASH: d19a35df54d3f8f1c6e362e8f94a63548970dd0c
                    MATRIX: 854->1|1040->114|1062->128|1519->53|1548->555|1602->573|1616->578|1641->581|1695->599|1738->620|1790->636|1804->641|1836->651|1962->741|1976->746|2001->749|2072->783|2087->788|2113->791|2163->806|2425->1058|2465->1059|2614->1172|2634->1183|2724->1250|2801->1309|2813->1313|2851->1314|2899->1331|2942->1339|2956->1344|2998->1364|3046->1377|3086->1408|3134->1410|3210->1460|3258->1473|3292->1498|3340->1500|3410->1544|3458->1557|3489->1579|3537->1581|3604->1622|3652->1635|3666->1640|3709->1661|3757->1674|3771->1679|3810->1696|3858->1709|3872->1714|3899->1719|3947->1732|3961->1737|4005->1759|4069->1787|4083->1792|4119->1806|4163->1815|4229->1872|4268->1873|4386->1955|4406->1966|4498->2035|4587->2106|4599->2110|4637->2111|4685->2128
                    LINES: 26->1|33->5|33->5|48->1|49->19|51->21|51->21|51->21|51->21|51->21|51->21|51->21|51->21|53->23|53->23|53->23|53->23|53->23|53->23|55->25|55->25|55->25|58->28|58->28|58->28|60->30|60->30|60->30|62->32|63->33|63->33|63->33|64->34|64->34|64->34|64->34|65->35|65->35|65->35|65->35|66->36|66->36|66->36|66->36|67->37|67->37|67->37|68->38|68->38|68->38|69->39|69->39|69->39|70->40|70->40|70->40|71->41|71->41|71->41|72->42|72->42|72->42|73->43|73->43|73->43|74->44|74->44|74->44|76->46
                    -- GENERATED --
                */
            