
package views.html.compras.lineasAjustesOrdenes

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
object lineaAjuste extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[OrdenLineaAjuste,Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea: OrdenLineaAjuste, editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.46*/("""
<tr data-id=""""),_display_(Seq[Any](/*2.15*/linea/*2.20*/.id)),format.raw/*2.23*/("""">
	<td>
		<input type="checkbox" name="check_linea_ajuste_orden[]" value=""""),_display_(Seq[Any](/*4.68*/linea/*4.73*/.id)),format.raw/*4.76*/("""" class="check_listado notSeleccion" id="check-"""),_display_(Seq[Any](/*4.124*/linea/*4.129*/.id)),format.raw/*4.132*/(""""/>
	</td>
	<td>"""),_display_(Seq[Any](/*6.7*/if(linea.create_date != null)/*6.36*/{_display_(Seq[Any](_display_(Seq[Any](/*6.38*/(utils.DateUtils.formatDate(linea.create_date))))))})),format.raw/*6.86*/("""</td>
	<td>"""),_display_(Seq[Any](/*7.7*/if(linea.create_usuario != null)/*7.39*/{_display_(Seq[Any](_display_(Seq[Any](/*7.41*/linea/*7.46*/.create_usuario.nombre))))})),format.raw/*7.69*/(""" </td>
	<td>"""),_display_(Seq[Any](/*8.7*/linea/*8.12*/.producto.nombre)),format.raw/*8.28*/("""</td>
	<td class="cuentaAnaliticaEnLinea">"""),_display_(Seq[Any](/*9.38*/if(linea.cuentaAnalitica == null)/*9.71*/{_display_(Seq[Any](format.raw/*9.72*/("""No asociada""")))}/*9.85*/else/*9.90*/{_display_(Seq[Any](_display_(Seq[Any](/*9.92*/linea/*9.97*/.cuentaAnalitica.codigo)),format.raw/*9.120*/(""" """),_display_(Seq[Any](/*9.122*/linea/*9.127*/.cuentaAnalitica.nombre))))})),format.raw/*9.151*/("""</td>
	<td>"""),_display_(Seq[Any](/*10.7*/linea/*10.12*/.udm.nombre)),format.raw/*10.23*/("""</td>
	<td>"""),_display_(Seq[Any](/*11.7*/linea/*11.12*/.cantidad)),format.raw/*11.21*/("""</td>
	<td>"""),_display_(Seq[Any](/*12.7*/utils/*12.12*/.NumberUtils.moneda(linea.precio, 2))),format.raw/*12.48*/("""</td>
	<td>"""),_display_(Seq[Any](/*13.7*/(utils.NumberUtils.moneda(linea.precio.multiply(linea.cantidad), 2)))),format.raw/*13.75*/("""</td>
	<td>
		<!-- <a class="btn btn-default btn-xs eliminarAjuste" href=""""),_display_(Seq[Any](/*15.64*/controllers/*15.75*/.compras.routes.OrdenesLineasAjustesController.eliminar(linea.id))),format.raw/*15.140*/("""">
		<i class="glyphicon glyphicon-trash icono-eliminar"></i></a> -->
		"""),_display_(Seq[Any](/*17.4*/linea/*17.9*/.nota)),format.raw/*17.14*/("""
	</td>
</tr>"""))}
    }
    
    def render(linea:OrdenLineaAjuste,editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(linea,editable)
    
    def f:((OrdenLineaAjuste,Boolean) => play.api.templates.HtmlFormat.Appendable) = (linea,editable) => apply(linea,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:45 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/lineasAjustesOrdenes/lineaAjuste.scala.html
                    HASH: 334da428c66833c01ffd7e83d5495247f5abdb9e
                    MATRIX: 827->1|965->45|1016->61|1029->66|1053->69|1166->147|1179->152|1203->155|1287->203|1301->208|1326->211|1379->230|1416->259|1463->261|1536->309|1583->322|1623->354|1670->356|1683->361|1731->384|1779->398|1792->403|1829->419|1908->463|1949->496|1987->497|2017->510|2029->515|2076->517|2089->522|2134->545|2172->547|2186->552|2236->576|2284->589|2298->594|2331->605|2379->618|2393->623|2424->632|2472->645|2486->650|2544->686|2592->699|2682->767|2795->844|2815->855|2903->920|3013->995|3026->1000|3053->1005
                    LINES: 26->1|29->1|30->2|30->2|30->2|32->4|32->4|32->4|32->4|32->4|32->4|34->6|34->6|34->6|34->6|35->7|35->7|35->7|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|37->9|37->9|37->9|37->9|37->9|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|43->15|43->15|43->15|45->17|45->17|45->17
                    -- GENERATED --
                */
            