
package views.html.patrimonio.ordenesProvision

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
object listadoProductosSolicitados extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[OrdenProvision,utils.pagination.Pagination[OrdenProvisionLineas],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(orden: OrdenProvision, buscador: utils.pagination.Pagination[OrdenProvisionLineas]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import models.auth._

import utils._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};def /*7.2*/getPacientes/*7.14*/(linea: OrdenLinea) = {{
	var pacientes:String = new String()
	if(linea != null && linea.ordenLineaCliente != null && linea.ordenLineaCliente.size() > 0){
		for(olp <- linea.ordenLineaCliente) {
			pacientes += olp.cliente.nombre.toUpperCase()+" - ID:"+olp.cliente.id_paciente_rismi+"\n" 
		}
	}
	pacientes
}};
Seq[Any](format.raw/*1.86*/("""
"""),format.raw/*5.70*/("""

"""),format.raw/*15.2*/("""

<div class="contenedorPaginador ajaxPaginador">
"""),_display_(Seq[Any](/*18.2*/if(buscador.getTotalRowCount == 0)/*18.36*/ {_display_(Seq[Any](format.raw/*18.38*/("""
    <div class="well">
    	<em>No se encuentran resultados</em>
    </div>  
""")))}/*22.3*/else/*22.8*/{_display_(Seq[Any](format.raw/*22.9*/("""
   	Mostrando """),_display_(Seq[Any](/*23.16*/buscador/*23.24*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*23.56*/(""" resultado(s). 
   
	<table class="table table-striped table-bordered table-hover" style="margin-top: 20px">
		<thead>
			<tr>
				<th width="30">
					<input type="checkbox" name="checkAllLineaSolicitados"  data-check=".data-check-linea-solicitados"  id="checkAllLineaSolicitados"/>
				</th>
				<th>Producto</th>
				<th>Udm</th>
				<th>Servicio</th>
				<th>Solicitado</th>
				<th>Recepcionado</th>
				<th>Pendiente</th>
				<th>Precio</th>
				<th width="80">Total</th>
				<th>Pacientes</th>
			</tr>
		</thead>
		<tbody>
		"""),_display_(Seq[Any](/*43.4*/for(o <- buscador.getList) yield /*43.30*/ {_display_(Seq[Any](format.raw/*43.32*/("""
			<tr>
				<td><input type="checkbox" name="check_linea_solicitados[]" value=""""),_display_(Seq[Any](/*45.73*/o/*45.74*/.orden_linea_id)),format.raw/*45.89*/("""" class="data-check-linea-solicitados notSeleccion" id="check-"""),_display_(Seq[Any](/*45.152*/o/*45.153*/.orden_linea_id)),format.raw/*45.168*/(""""/></td>
				<td>"""),_display_(Seq[Any](/*46.10*/o/*46.11*/.producto.nombre)),format.raw/*46.27*/("""</td>
				<td>"""),_display_(Seq[Any](/*47.10*/o/*47.11*/.udm)),format.raw/*47.15*/("""</td>
				<td>"""),_display_(Seq[Any](/*48.10*/if(o.departamento != null)/*48.36*/{_display_(Seq[Any](_display_(Seq[Any](/*48.38*/o/*48.39*/.departamento))))})),format.raw/*48.53*/("""</td>
				<td align="center">"""),_display_(Seq[Any](/*49.25*/o/*49.26*/.cantidad)),format.raw/*49.35*/("""</td>
				<td align="center">"""),_display_(Seq[Any](/*50.25*/o/*50.26*/.getRecepcionado())),format.raw/*50.44*/("""</td>
				<td align="center">"""),_display_(Seq[Any](/*51.25*/o/*51.26*/.getPendiente())),format.raw/*51.41*/("""</td>
				<td>"""),_display_(Seq[Any](/*52.10*/utils/*52.15*/.NumberUtils.moneda(o.precio))),format.raw/*52.44*/("""</td>
				<td>"""),_display_(Seq[Any](/*53.10*/utils/*53.15*/.NumberUtils.moneda(o.getTotal()))),format.raw/*53.48*/("""</td>
				"""),_display_(Seq[Any](/*54.6*/if(o.orden_linea_id != null && o.getOrdenLinea().ordenLineaCliente != null && o.getOrdenLinea().ordenLineaCliente.size() > 0)/*54.131*/{_display_(Seq[Any](format.raw/*54.132*/("""
					"""),_display_(Seq[Any](/*55.7*/if(o.getOrdenLinea().ordenLineaCliente != null && o.getOrdenLinea().ordenLineaCliente.size() > 0)/*55.104*/{_display_(Seq[Any](format.raw/*55.105*/("""
					
					""")))})),format.raw/*57.7*/("""
					<td><div class='tip-top pointer' title='"""),_display_(Seq[Any](/*58.47*/getPacientes(o.getOrdenLinea()))),format.raw/*58.78*/("""'><i class="glyphicon glyphicon-user"></i></div></td>
				""")))}/*59.6*/else/*59.10*/{_display_(Seq[Any](format.raw/*59.11*/("""
					<td></td>
				""")))})),format.raw/*61.6*/("""
			</tr>
		""")))})),format.raw/*63.4*/("""
		</tbody>
	</table>
	<div class="pagination pull-right">
	    """),_display_(Seq[Any](/*67.7*/views/*67.12*/.html.helpers.paginador(buscador, controllers.patrimonio.routes.OrdenesProvisionController.verProductosSolicitados()))),format.raw/*67.129*/("""
	</div>
		""")))})),format.raw/*69.4*/("""
		
</div>
<script>
	$( function()"""),format.raw/*73.15*/("""{"""),format.raw/*73.16*/("""
		
		 
		
		$('#checkAllLineaSolicitados').on('change', function()"""),format.raw/*77.57*/("""{"""),format.raw/*77.58*/("""
			var c = $(this).prop("checked");
			var target = $(this).attr('data-check');
			if(c) $(target).prop( "checked", true );
			else $(target).prop( "checked", false );
		"""),format.raw/*82.3*/("""}"""),format.raw/*82.4*/(""");
	"""),format.raw/*83.2*/("""}"""),format.raw/*83.3*/(""");
</script>"""))}
    }
    
    def render(orden:OrdenProvision,buscador:utils.pagination.Pagination[OrdenProvisionLineas]): play.api.templates.HtmlFormat.Appendable = apply(orden,buscador)
    
    def f:((OrdenProvision,utils.pagination.Pagination[OrdenProvisionLineas]) => play.api.templates.HtmlFormat.Appendable) = (orden,buscador) => apply(orden,buscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:31 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/ordenesProvision/listadoProductosSolicitados.scala.html
                    HASH: dc63134879efbad96371fcddc193adf1d91ca4a9
                    MATRIX: 882->1|1109->146|1141->170|1198->219|1218->231|1564->85|1593->214|1624->547|1713->601|1756->635|1796->637|1898->722|1910->727|1948->728|2001->745|2018->753|2072->785|2661->1339|2703->1365|2743->1367|2862->1450|2872->1451|2909->1466|3009->1529|3020->1530|3058->1545|3113->1564|3123->1565|3161->1581|3213->1597|3223->1598|3249->1602|3301->1618|3336->1644|3384->1646|3394->1647|3434->1661|3501->1692|3511->1693|3542->1702|3609->1733|3619->1734|3659->1752|3726->1783|3736->1784|3773->1799|3825->1815|3839->1820|3890->1849|3942->1865|3956->1870|4011->1903|4058->1915|4193->2040|4233->2041|4276->2049|4383->2146|4423->2147|4469->2162|4553->2210|4606->2241|4684->2301|4697->2305|4736->2306|4790->2329|4836->2344|4940->2413|4954->2418|5094->2535|5139->2549|5205->2587|5234->2588|5333->2659|5362->2660|5565->2836|5593->2837|5625->2842|5653->2843
                    LINES: 26->1|33->5|33->5|33->7|33->7|42->1|43->5|45->15|48->18|48->18|48->18|52->22|52->22|52->22|53->23|53->23|53->23|73->43|73->43|73->43|75->45|75->45|75->45|75->45|75->45|75->45|76->46|76->46|76->46|77->47|77->47|77->47|78->48|78->48|78->48|78->48|78->48|79->49|79->49|79->49|80->50|80->50|80->50|81->51|81->51|81->51|82->52|82->52|82->52|83->53|83->53|83->53|84->54|84->54|84->54|85->55|85->55|85->55|87->57|88->58|88->58|89->59|89->59|89->59|91->61|93->63|97->67|97->67|97->67|99->69|103->73|103->73|107->77|107->77|112->82|112->82|113->83|113->83
                    -- GENERATED --
                */
            