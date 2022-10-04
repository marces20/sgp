
package views.html.compras.certificaciones.modales

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
object modalDetalleCertificacionesPorEstadoPorPeriodo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[List[Certificacion],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(certificaciones:List[Certificacion]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {
def /*2.2*/getClassEstado/*2.16*/(i:Estado) = {{
	var classEstado:String = new String()
	if(i != null && i.id == 28){
		classEstado = "borrador"
	}else if(i != null && i.id == 32){
		classEstado = "cancelada"
	}else if(i != null && i.id == 31){
		classEstado = "autorizado"
	}
	classEstado
	
}};def /*15.2*/getTotalBase/*15.14*/(cl:List[Certificacion]) = {{
	var total:java.math.BigDecimal = new java.math.BigDecimal(0)
	for(c <- cl){
		total = total.add(c.getBase())
	}
	total
}};def /*23.2*/getTotalDescuento/*23.19*/(cl:List[Certificacion]) = {{
	var total:java.math.BigDecimal = new java.math.BigDecimal(0)
	for(c <- cl){
		total = total.add(c.getDescuento())
	}
	total
}};def /*31.2*/getTotalTotal/*31.15*/(cl:List[Certificacion]) = {{
	var total:java.math.BigDecimal = new java.math.BigDecimal(0)
	for(c <- cl){
		total = total.add(c.getTotal())
	}
	total
}};
Seq[Any](format.raw/*1.39*/("""
"""),format.raw/*13.2*/("""

"""),format.raw/*21.2*/("""

"""),format.raw/*29.2*/("""

"""),format.raw/*37.2*/("""

<h3>Certificaciones</h3>
<table class="table table-striped table-bordered tableEstadoGeneral">
	<thead>
		<tr>
			<th width="80">Referencia</th>
			<th width="70">Fecha</th>
			<th width="95">Expediente</th>
			<th width="95">Periodo</th>
			<th width="30">Tipo Cuenta</th>
			<th width="95">Base</th>
			<th width="95">Descuento</th>
			<th width="95">Total</th>
			<th width="100">Estado</th>
			<th width="30">Detalle</th> 
		</tr>
	</thead>
	<tbody>
		"""),_display_(Seq[Any](/*56.4*/for(certificacion <- certificaciones) yield /*56.41*/ {_display_(Seq[Any](format.raw/*56.43*/("""
			<tr class=""""),_display_(Seq[Any](/*57.16*/getClassEstado(certificacion.estado))),format.raw/*57.52*/("""">
				<td>"""),_display_(Seq[Any](/*58.10*/(certificacion.nombre))),format.raw/*58.32*/("""</td>
				<td class="fechaCertificacion">"""),_display_(Seq[Any](/*59.37*/if(certificacion.fecha_certificacion != null)/*59.82*/{_display_(Seq[Any](_display_(Seq[Any](/*59.84*/(utils.DateUtils.formatDate(certificacion.fecha_certificacion))))))})),format.raw/*59.148*/("""</td>
				<td>"""),_display_(Seq[Any](/*60.10*/if(certificacion.expediente != null)/*60.46*/{_display_(Seq[Any](_display_(Seq[Any](/*60.48*/certificacion/*60.61*/.expediente.getExpedienteEjercicio()))))})),format.raw/*60.98*/("""</td>
				<td>"""),_display_(Seq[Any](/*61.10*/if(certificacion.periodo != null)/*61.43*/{_display_(Seq[Any](_display_(Seq[Any](/*61.45*/(certificacion.periodo.nombre)))))})),format.raw/*61.76*/("""</td>
				<td>"""),_display_(Seq[Any](/*62.10*/if(certificacion.tipoCuenta != null)/*62.46*/{_display_(Seq[Any](_display_(Seq[Any](/*62.48*/certificacion/*62.61*/.tipoCuenta.nombre))))})),format.raw/*62.80*/("""</td>
				<td class="base" >"""),_display_(Seq[Any](/*63.24*/(utils.NumberUtils.moneda(certificacion.getBase())))),format.raw/*63.75*/("""</td>
				<td class="descuento">"""),_display_(Seq[Any](/*64.28*/(utils.NumberUtils.moneda(certificacion.getDescuento())))),format.raw/*64.84*/("""</td>
				<td class="total">"""),_display_(Seq[Any](/*65.24*/(utils.NumberUtils.moneda(certificacion.getTotal())))),format.raw/*65.76*/("""</td>
				<td class="estado">
					<div class="tip-top" title=""""),_display_(Seq[Any](/*67.35*/if(certificacion.estado != null)/*67.67*/{_display_(Seq[Any](_display_(Seq[Any](/*67.69*/(certificacion.estado.significado)))))})),format.raw/*67.104*/("""">"""),_display_(Seq[Any](/*67.107*/if(certificacion.estado != null)/*67.139*/{_display_(Seq[Any](_display_(Seq[Any](/*67.141*/(certificacion.estado.nombre)))))})),format.raw/*67.171*/("""</div>
				</td>
				<td>
					<a href='#' class='detalleCertificacionModal' data-url='"""),_display_(Seq[Any](/*70.63*/controllers/*70.74*/.compras.routes.CertificacionesAccionesController.modalDetalleCertificacion(certificacion.id))),format.raw/*70.167*/("""'>
					<i class='glyphicon glyphicon-tasks'></i></a>
				</td>
			</tr>
		""")))})),format.raw/*74.4*/("""
		<tr>	
			<td colspan='5' style='text-align: right;'><b>Totales:</b></td>
			<td>"""),_display_(Seq[Any](/*77.9*/utils/*77.14*/.NumberUtils.moneda(getTotalBase(certificaciones)))),format.raw/*77.64*/("""</td>
			<td>"""),_display_(Seq[Any](/*78.9*/utils/*78.14*/.NumberUtils.moneda(getTotalDescuento(certificaciones)))),format.raw/*78.69*/("""</td>
			<td>"""),_display_(Seq[Any](/*79.9*/utils/*79.14*/.NumberUtils.moneda(getTotalTotal(certificaciones)))),format.raw/*79.65*/("""</td>
			<td colspan='2'></td>
		</tr>
	</tbody>
</table>"""))}
    }
    
    def render(certificaciones:List[Certificacion]): play.api.templates.HtmlFormat.Appendable = apply(certificaciones)
    
    def f:((List[Certificacion]) => play.api.templates.HtmlFormat.Appendable) = (certificaciones) => apply(certificaciones)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:43 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/certificaciones/modales/modalDetalleCertificacionesPorEstadoPorPeriodo.scala.html
                    HASH: 64ba7d43c13ce94e918c9891d86892c23b13e8e7
                    MATRIX: 860->1|974->40|996->54|1270->317|1291->329|1456->483|1482->500|1652->659|1674->672|1856->38|1884->314|1913->480|1942->656|1971->824|2465->1283|2518->1320|2558->1322|2610->1338|2668->1374|2716->1386|2760->1408|2838->1450|2892->1495|2940->1497|3031->1561|3082->1576|3127->1612|3175->1614|3197->1627|3260->1664|3311->1679|3353->1712|3401->1714|3458->1745|3509->1760|3554->1796|3602->1798|3624->1811|3669->1830|3734->1859|3807->1910|3876->1943|3954->1999|4019->2028|4093->2080|4193->2144|4234->2176|4282->2178|4344->2213|4384->2216|4426->2248|4475->2250|4532->2280|4656->2368|4676->2379|4792->2472|4899->2548|5018->2632|5032->2637|5104->2687|5153->2701|5167->2706|5244->2761|5293->2775|5307->2780|5380->2831
                    LINES: 26->1|28->2|28->2|39->15|39->15|45->23|45->23|51->31|51->31|58->1|59->13|61->21|63->29|65->37|84->56|84->56|84->56|85->57|85->57|86->58|86->58|87->59|87->59|87->59|87->59|88->60|88->60|88->60|88->60|88->60|89->61|89->61|89->61|89->61|90->62|90->62|90->62|90->62|90->62|91->63|91->63|92->64|92->64|93->65|93->65|95->67|95->67|95->67|95->67|95->67|95->67|95->67|95->67|98->70|98->70|98->70|102->74|105->77|105->77|105->77|106->78|106->78|106->78|107->79|107->79|107->79
                    -- GENERATED --
                */
            