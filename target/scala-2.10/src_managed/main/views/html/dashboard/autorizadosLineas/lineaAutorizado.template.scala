
package views.html.dashboard.autorizadosLineas

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
object lineaAutorizado extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[AutorizadoLinea,Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea: AutorizadoLinea, editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.45*/("""

<tr>
	<td>
		"""),_display_(Seq[Any](/*5.4*/if(linea.ordenProvision != null)/*5.36*/{_display_(Seq[Any](format.raw/*5.37*/("""
			"""),_display_(Seq[Any](/*6.5*/linea/*6.10*/.ordenProvision.numero)),format.raw/*6.32*/("""
		""")))})),format.raw/*7.4*/("""
		<br>"""),_display_(Seq[Any](/*8.8*/if(linea.orden.tipo_moneda != null)/*8.43*/{_display_(Seq[Any](format.raw/*8.44*/("""<span style="color:green;font-weight:bold;font-size: 12px;">M.E.</span>""")))})),format.raw/*8.116*/("""
	</td>
	 
	<td>"""),_display_(Seq[Any](/*11.7*/if(linea.orden.tipo_cuenta_id != null)/*11.45*/{_display_(Seq[Any](_display_(Seq[Any](/*11.47*/linea/*11.52*/.orden.tipoCuenta.nombre))))})),format.raw/*11.77*/("""</td>
	<td>"""),_display_(Seq[Any](/*12.7*/linea/*12.12*/.expediente.getExpedienteEjercicio())),format.raw/*12.48*/("""</td>
	<td>"""),_display_(Seq[Any](/*13.7*/linea/*13.12*/.proveedor.nombre)),format.raw/*13.29*/("""</td>
	<td>"""),_display_(Seq[Any](/*14.7*/utils/*14.12*/.NumberUtils.moneda(linea.getTotal(), 10))),format.raw/*14.53*/("""</td>
	<td>
		<a href=""""),_display_(Seq[Any](/*16.13*/controllers/*16.24*/.dashboard.routes.AutorizadoLineasController.getActas(linea.id))),format.raw/*16.87*/("""" class="lineasActas">
		<i class="glyphicon glyphicon-align-justify"></i></a>
	</td>
	"""),_display_(Seq[Any](/*19.3*/if(editable)/*19.15*/{_display_(Seq[Any](format.raw/*19.16*/("""
		<td>
			 
			"""),_display_(Seq[Any](/*22.5*/if(linea.autorizado.id != null && linea.orden.id != null)/*22.62*/{_display_(Seq[Any](format.raw/*22.63*/("""
				<a class="btn btn-default btn-xs eliminarAutorizado" 
				   href=""""),_display_(Seq[Any](/*24.15*/controllers/*24.26*/.dashboard.routes.AutorizadoLineasController.eliminar(linea.autorizado.id,linea.orden.id))),format.raw/*24.115*/("""">
				<i class="glyphicon glyphicon-trash icono-eliminar"></i></a>
			""")))})),format.raw/*26.5*/("""
		</td>
	""")))})),format.raw/*28.3*/("""
</tr>"""))}
    }
    
    def render(linea:AutorizadoLinea,editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(linea,editable)
    
    def f:((AutorizadoLinea,Boolean) => play.api.templates.HtmlFormat.Appendable) = (linea,editable) => apply(linea,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:56 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/autorizadosLineas/lineaAutorizado.scala.html
                    HASH: 80dd2be1296b70f119c7ec04bd29f3fb5e898069
                    MATRIX: 829->1|966->44|1020->64|1060->96|1098->97|1138->103|1151->108|1194->130|1229->135|1272->144|1315->179|1353->180|1457->252|1512->272|1559->310|1607->312|1621->317|1672->342|1720->355|1734->360|1792->396|1840->409|1854->414|1893->431|1941->444|1955->449|2018->490|2080->516|2100->527|2185->590|2311->681|2332->693|2371->694|2426->714|2492->771|2531->772|2642->847|2662->858|2774->947|2879->1021|2923->1034
                    LINES: 26->1|29->1|33->5|33->5|33->5|34->6|34->6|34->6|35->7|36->8|36->8|36->8|36->8|39->11|39->11|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|44->16|44->16|44->16|47->19|47->19|47->19|50->22|50->22|50->22|52->24|52->24|52->24|54->26|56->28
                    -- GENERATED --
                */
            