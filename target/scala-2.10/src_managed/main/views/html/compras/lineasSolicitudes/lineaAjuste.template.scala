
package views.html.compras.lineasSolicitudes

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
object lineaAjuste extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[SolicitudLineaAjuste,Boolean,Solicitud,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea: SolicitudLineaAjuste, editable: Boolean, solicitud: Solicitud):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.72*/("""

<tr data-id=""""),_display_(Seq[Any](/*3.15*/linea/*3.20*/.id)),format.raw/*3.23*/("""">
	<td>"""),_display_(Seq[Any](/*4.7*/linea/*4.12*/.cuentaAnalitica.codigo)),format.raw/*4.35*/("""</td>
	<td>"""),_display_(Seq[Any](/*5.7*/linea/*5.12*/.cuentaAnalitica.nombre)),format.raw/*5.35*/("""</td>
	<td>"""),_display_(Seq[Any](/*6.7*/if(linea.producto != null)/*6.33*/{_display_(Seq[Any](_display_(Seq[Any](/*6.35*/linea/*6.40*/.producto.nombre))))})),format.raw/*6.57*/("""</td>
	<td>"""),_display_(Seq[Any](/*7.7*/linea/*7.12*/.cantidad)),format.raw/*7.21*/("""</td>
	<td>"""),_display_(Seq[Any](/*8.7*/(utils.NumberUtils.moneda(linea.precio,2)))),format.raw/*8.49*/("""</td>
	<!-- <td>"""),_display_(Seq[Any](/*9.12*/utils/*9.17*/.NumberUtils.moneda(linea.valor, 2))),format.raw/*9.52*/("""</td> -->
	<td>"""),_display_(Seq[Any](/*10.7*/if(linea.precio != null)/*10.31*/{_display_(Seq[Any](_display_(Seq[Any](/*10.33*/(utils.NumberUtils.moneda(linea.cantidad.multiply(linea.precio), 2))))))}/*10.102*/else/*10.106*/{_display_(Seq[Any](_display_(Seq[Any](/*10.108*/(utils.NumberUtils.moneda(new java.math.BigDecimal(0),2))))))})),format.raw/*10.166*/("""</td>
	<td>"""),_display_(Seq[Any](/*11.7*/linea/*11.12*/.observacion)),format.raw/*11.24*/("""</td>
	"""),_display_(Seq[Any](/*12.3*/if(editable)/*12.15*/{_display_(Seq[Any](format.raw/*12.16*/("""
		<!-- <td><a class="btn btn-default btn-xs eliminarAjuste delete-confirm-link" href=""""),_display_(Seq[Any](/*13.88*/controllers/*13.99*/.compras.routes.AjustesSolicitudesController.eliminar(linea.id))),format.raw/*13.162*/(""""><i class="glyphicon glyphicon-trash icono-eliminar"></i></a></td> -->
	""")))})),format.raw/*14.3*/("""
</tr>"""))}
    }
    
    def render(linea:SolicitudLineaAjuste,editable:Boolean,solicitud:Solicitud): play.api.templates.HtmlFormat.Appendable = apply(linea,editable,solicitud)
    
    def f:((SolicitudLineaAjuste,Boolean,Solicitud) => play.api.templates.HtmlFormat.Appendable) = (linea,editable,solicitud) => apply(linea,editable,solicitud)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:43 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/lineasSolicitudes/lineaAjuste.scala.html
                    HASH: 45cd5ce03d97b14bafccfc3e5a37b824e0d721c3
                    MATRIX: 838->1|1002->71|1053->87|1066->92|1090->95|1133->104|1146->109|1190->132|1236->144|1249->149|1293->172|1339->184|1373->210|1420->212|1433->217|1475->234|1521->246|1534->251|1564->260|1610->272|1673->314|1725->331|1738->336|1794->371|1845->387|1878->411|1926->413|2009->482|2023->486|2072->488|2157->546|2204->558|2218->563|2252->575|2295->583|2316->595|2355->596|2479->684|2499->695|2585->758|2690->832
                    LINES: 26->1|29->1|31->3|31->3|31->3|32->4|32->4|32->4|33->5|33->5|33->5|34->6|34->6|34->6|34->6|34->6|35->7|35->7|35->7|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|38->10|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|42->14
                    -- GENERATED --
                */
            