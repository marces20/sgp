
package views.html.contabilidad.facturas

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
object listaFactura extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[List[Factura],Factura,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lista: List[Factura],factura: Factura):play.api.templates.HtmlFormat.Appendable = {
        _display_ {
def /*2.2*/getClassEstado/*2.16*/(i:Factura) = {{
	var classEstado:String = new String()
	var saldoPendiente:BigDecimal = i.getSaldoPendiente()
	var base:BigDecimal = i.getBase()
	
	
	if(!saldoPendiente.equals(base) && i.estado != null && i.estado_id == 19){
		classEstado = "pagado"
	}else{
		if(i.estado != null && i.estado.id == 18){
			classEstado = "borrador"
		}else if(i.estado != null && i.estado.id == 21){
			classEstado = "cancelada"
		}else if(i.estado != null && i.estado.id == 19){
			classEstado = "autorizado"
		}
	}
	classEstado
}};
Seq[Any](format.raw/*1.41*/("""
"""),format.raw/*20.2*/("""
"""),_display_(Seq[Any](/*21.2*/if(factura != null && lista != null && lista.size() > 0)/*21.58*/{_display_(Seq[Any](format.raw/*21.59*/("""
		<table id="" class="table table-bordered">
			<thead>
				<tr>
					<th width="100">Referencia</th>
					<th width="100">Proveedor</th>
					<!-- <th width="100">Referencia</th> -->
					<th width="100">OPG</th>
					<th width="100">N° Factura</th>
					<!-- <th width="100">Representante</th> -->
					<th width="100">Base</th>
					<th width="100">Total impuestos</th>
					<th width="100">Total</th>
					<th width="100">Saldo pendiente</th>
					<th width="100">Expediente</th>
					<th width="100">Periodo</th>
					<th>Tipo Cuenta</th>
					<th width="100">Estado</th>
				</tr>	
			</thead>	
			
			"""),_display_(Seq[Any](/*42.5*/for(f <- lista) yield /*42.20*/ {_display_(Seq[Any](format.raw/*42.22*/("""
				<tr class=""""),_display_(Seq[Any](/*43.17*/getClassEstado(f))),format.raw/*43.34*/("""">
					<td align="center">"""),_display_(Seq[Any](/*44.26*/(f.nombre))),format.raw/*44.36*/("""</td>
					<td>"""),_display_(Seq[Any](/*45.11*/if(f.proveedor != null)/*45.34*/{_display_(Seq[Any](_display_(Seq[Any](/*45.36*/(f.proveedor.nombre)))))})),format.raw/*45.57*/("""</td>
					<td class="opg">"""),_display_(Seq[Any](/*46.23*/if(f.ordenPago != null)/*46.46*/{_display_(Seq[Any](_display_(Seq[Any](/*46.48*/(f.ordenPago.numero)))))})),format.raw/*46.69*/("""</td>
					<td>"""),_display_(Seq[Any](/*47.11*/(f.numero_factura))),format.raw/*47.29*/("""</td>
					<td class="totalBase" rel=""""),_display_(Seq[Any](/*48.34*/f/*48.35*/.base)),format.raw/*48.40*/("""">"""),_display_(Seq[Any](/*48.43*/if(f.base != null)/*48.61*/{_display_(Seq[Any](_display_(Seq[Any](/*48.63*/(utils.NumberUtils.moneda(f.base))))))})),format.raw/*48.98*/("""</td>
					<td class="totalImpuestos" rel=""""),_display_(Seq[Any](/*49.39*/f/*49.40*/.getTotalImpuesto())),format.raw/*49.59*/("""">"""),_display_(Seq[Any](/*49.62*/(utils.NumberUtils.moneda(f.getTotalImpuesto())))),format.raw/*49.110*/("""</td>
					<td class="total" rel=""""),_display_(Seq[Any](/*50.30*/f/*50.31*/.getTotal())),format.raw/*50.42*/("""">"""),_display_(Seq[Any](/*50.45*/(utils.NumberUtils.moneda(f.getTotal())))),format.raw/*50.85*/("""</td>
					<td class="totalSaldo" rel=""""),_display_(Seq[Any](/*51.35*/f/*51.36*/.getSaldoPendiente())),format.raw/*51.56*/("""">"""),_display_(Seq[Any](/*51.59*/(utils.NumberUtils.moneda(f.getSaldoPendiente())))),format.raw/*51.108*/("""</td>
					<td>"""),_display_(Seq[Any](/*52.11*/if(f.expediente != null)/*52.35*/{_display_(Seq[Any](_display_(Seq[Any](/*52.37*/(f.expediente.getExpedienteEjercicio())))))})),format.raw/*52.77*/("""</td>
					<td>"""),_display_(Seq[Any](/*53.11*/if(f.periodo != null)/*53.32*/{_display_(Seq[Any](_display_(Seq[Any](/*53.34*/(f.periodo.nombre)))))})),format.raw/*53.53*/("""</td>
					<td>"""),_display_(Seq[Any](/*54.11*/if(f.tipoCuenta != null)/*54.35*/{_display_(Seq[Any](_display_(Seq[Any](/*54.37*/f/*54.38*/.tipoCuenta.nombre))))})),format.raw/*54.57*/("""</td>
					<td class="estado" align="center">
							"""),_display_(Seq[Any](/*56.9*/if(f.getSaldoPendiente() != null && !f.getSaldoPendiente().equals(f.base) && (f.estado != null && f.estado.id == 19))/*56.126*/{_display_(Seq[Any](format.raw/*56.127*/("""
								Pagado 
							""")))}/*58.9*/else/*58.13*/{_display_(Seq[Any](format.raw/*58.14*/("""
								"""),_display_(Seq[Any](/*59.10*/if(f.estado != null)/*59.30*/{_display_(Seq[Any](_display_(Seq[Any](/*59.32*/(f.estado.nombre)))))})),format.raw/*59.50*/("""
							""")))})),format.raw/*60.9*/("""
							<a class="btn btn-default btn-xs"  href=""""),_display_(Seq[Any](/*61.50*/controllers/*61.61*/.contabilidad.routes.FacturasController.ver(f.id))),format.raw/*61.110*/("""" target="_blank">
							<i class="glyphicon glyphicon-list-alt"></i> Ver</a>
					</td>	
				<tr>
			
			""")))})),format.raw/*66.5*/("""
	</table>
""")))})),format.raw/*68.2*/("""	"""))}
    }
    
    def render(lista:List[Factura],factura:Factura): play.api.templates.HtmlFormat.Appendable = apply(lista,factura)
    
    def f:((List[Factura],Factura) => play.api.templates.HtmlFormat.Appendable) = (lista,factura) => apply(lista,factura)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:39 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/facturas/listaFactura.scala.html
                    HASH: 7ef94ed4dc923968c451caf24819c455293050a8
                    MATRIX: 818->1|934->42|956->56|1500->40|1528->570|1565->572|1630->628|1669->629|2314->1239|2345->1254|2385->1256|2438->1273|2477->1290|2541->1318|2573->1328|2625->1344|2657->1367|2705->1369|2752->1390|2816->1418|2848->1441|2896->1443|2943->1464|2995->1480|3035->1498|3110->1537|3120->1538|3147->1543|3186->1546|3213->1564|3261->1566|3322->1601|3402->1645|3412->1646|3453->1665|3492->1668|3563->1716|3634->1751|3644->1752|3677->1763|3716->1766|3778->1806|3854->1846|3864->1847|3906->1867|3945->1870|4017->1919|4069->1935|4102->1959|4150->1961|4216->2001|4268->2017|4298->2038|4346->2040|4391->2059|4443->2075|4476->2099|4524->2101|4534->2102|4579->2121|4668->2175|4795->2292|4835->2293|4878->2318|4891->2322|4930->2323|4976->2333|5005->2353|5053->2355|5097->2373|5137->2382|5223->2432|5243->2443|5315->2492|5454->2600|5497->2612
                    LINES: 26->1|28->2|28->2|47->1|48->20|49->21|49->21|49->21|70->42|70->42|70->42|71->43|71->43|72->44|72->44|73->45|73->45|73->45|73->45|74->46|74->46|74->46|74->46|75->47|75->47|76->48|76->48|76->48|76->48|76->48|76->48|76->48|77->49|77->49|77->49|77->49|77->49|78->50|78->50|78->50|78->50|78->50|79->51|79->51|79->51|79->51|79->51|80->52|80->52|80->52|80->52|81->53|81->53|81->53|81->53|82->54|82->54|82->54|82->54|82->54|84->56|84->56|84->56|86->58|86->58|86->58|87->59|87->59|87->59|87->59|88->60|89->61|89->61|89->61|94->66|96->68
                    -- GENERATED --
                */
            