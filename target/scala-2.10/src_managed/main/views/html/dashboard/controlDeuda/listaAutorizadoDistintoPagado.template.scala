
package views.html.dashboard.controlDeuda

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
object listaAutorizadoDistintoPagado extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[List[models.informes.InformeDeudaProveedoresMaterializada],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(r:List[models.informes.InformeDeudaProveedoresMaterializada]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.64*/("""
"""),format.raw/*3.70*/(""" 

<table class="table table-striped table-bordered" id="listaInforme">
	<thead>
		<tr>
			<th width="40">Orden</th>
			<th width="60">Expediente</th>
			<th width="30">Cuenta</th>
			<th width="130">Rubro</th>
			<th width="80">Inst.</th>
			<th>Proveedor</th>
			<th width="90">Orden</th>
			<th width="90">Autorizado</th>
			<th width="90">Pagado</th>
			<th width="90">Deuda</th>
			<th width="30">Compromiso</th>
		</tr>
	</thead>
	<tbody>
	
		"""),_display_(Seq[Any](/*23.4*/for(informe <- r) yield /*23.21*/ {_display_(Seq[Any](format.raw/*23.23*/("""
         
		<tr>
			<td>"""),_display_(Seq[Any](/*26.9*/informe/*26.16*/.numero_orden_provision)),format.raw/*26.39*/("""
			<br>"""),_display_(Seq[Any](/*27.9*/if(informe.tipo_moneda != null)/*27.40*/{_display_(Seq[Any](format.raw/*27.41*/("""<span style="color:green;font-weight:bold;font-size: 12px;">M.E.</span>""")))})),format.raw/*27.113*/("""
			</td>
			<td>"""),_display_(Seq[Any](/*29.9*/informe/*29.16*/.expediente)),format.raw/*29.27*/("""</td>
			<td>"""),_display_(Seq[Any](/*30.9*/if(informe.tipoCuenta != null)/*30.39*/ {_display_(Seq[Any](_display_(Seq[Any](/*30.42*/informe/*30.49*/.tipoCuenta.nombre))))})),format.raw/*30.68*/("""</td>
			<td>"""),_display_(Seq[Any](/*31.9*/informe/*31.16*/.rubro)),format.raw/*31.22*/("""</td>
			<td>"""),_display_(Seq[Any](/*32.9*/informe/*32.16*/.deposito.nombre)),format.raw/*32.32*/("""</td>
			<td>"""),_display_(Seq[Any](/*33.9*/informe/*33.16*/.nombreProveedor)),format.raw/*33.32*/("""</td>
			<td class="totalOrden" data-valor=""""),_display_(Seq[Any](/*34.40*/informe/*34.47*/.totalOrden)),format.raw/*34.58*/("""">"""),_display_(Seq[Any](/*34.61*/utils/*34.66*/.NumberUtils.moneda(informe.totalOrden))),format.raw/*34.105*/("""</td>
			<td class="totalAutorizado" data-valor=""""),_display_(Seq[Any](/*35.45*/informe/*35.52*/.totalAutorizado)),format.raw/*35.68*/("""">"""),_display_(Seq[Any](/*35.71*/utils/*35.76*/.NumberUtils.moneda(informe.totalAutorizado))),format.raw/*35.120*/("""</td>
			<td class="totalPagado" data-valor=""""),_display_(Seq[Any](/*36.41*/informe/*36.48*/.totalPagado)),format.raw/*36.60*/("""">"""),_display_(Seq[Any](/*36.63*/utils/*36.68*/.NumberUtils.moneda(informe.totalPagado))),format.raw/*36.108*/("""</td>
			<td class="totalDeuda" data-valor=""""),_display_(Seq[Any](/*37.40*/informe/*37.47*/.totalDeuda)),format.raw/*37.58*/("""">

					"""),_display_(Seq[Any](/*39.7*/utils/*39.12*/.NumberUtils.moneda(informe.totalDeuda))),format.raw/*39.51*/("""

			</td>
			<td class="totalCompromiso" data-valor=""""),_display_(Seq[Any](/*42.45*/informe/*42.52*/.totalCompromiso)),format.raw/*42.68*/("""">
			

					"""),_display_(Seq[Any](/*45.7*/utils/*45.12*/.NumberUtils.moneda(informe.totalCompromiso))),format.raw/*45.56*/("""

				
			</td>		
		</tr>
        """)))})),format.raw/*50.10*/("""
	</tbody>
	</table>"""))}
    }
    
    def render(r:List[models.informes.InformeDeudaProveedoresMaterializada]): play.api.templates.HtmlFormat.Appendable = apply(r)
    
    def f:((List[models.informes.InformeDeudaProveedoresMaterializada]) => play.api.templates.HtmlFormat.Appendable) = (r) => apply(r)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:47 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/controlDeuda/listaAutorizadoDistintoPagado.scala.html
                    HASH: 2ff28cc1164628ebd80734e40c11e33af7ebbbd0
                    MATRIX: 873->1|1037->82|1069->106|1143->63|1171->150|1656->600|1689->617|1729->619|1790->645|1806->652|1851->675|1895->684|1935->715|1974->716|2079->788|2132->806|2148->813|2181->824|2230->838|2269->868|2318->871|2334->878|2379->897|2428->911|2444->918|2472->924|2521->938|2537->945|2575->961|2624->975|2640->982|2678->998|2759->1043|2775->1050|2808->1061|2847->1064|2861->1069|2923->1108|3009->1158|3025->1165|3063->1181|3102->1184|3116->1189|3183->1233|3265->1279|3281->1286|3315->1298|3354->1301|3368->1306|3431->1346|3512->1391|3528->1398|3561->1409|3606->1419|3620->1424|3681->1463|3772->1518|3788->1525|3826->1541|3875->1555|3889->1560|3955->1604|4022->1639
                    LINES: 26->1|29->3|29->3|30->1|31->3|51->23|51->23|51->23|54->26|54->26|54->26|55->27|55->27|55->27|55->27|57->29|57->29|57->29|58->30|58->30|58->30|58->30|58->30|59->31|59->31|59->31|60->32|60->32|60->32|61->33|61->33|61->33|62->34|62->34|62->34|62->34|62->34|62->34|63->35|63->35|63->35|63->35|63->35|63->35|64->36|64->36|64->36|64->36|64->36|64->36|65->37|65->37|65->37|67->39|67->39|67->39|70->42|70->42|70->42|73->45|73->45|73->45|78->50
                    -- GENERATED --
                */
            