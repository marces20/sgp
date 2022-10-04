
package views.html.recupero.recuperoNotaCredito

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
object lineaNotaCredito extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[models.recupero.RecuperoNotaCredito,Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea: models.recupero.RecuperoNotaCredito, editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.65*/("""

<tr data-id=""""),_display_(Seq[Any](/*3.15*/linea/*3.20*/.id)),format.raw/*3.23*/("""">
	 
	<!-- <td class="accion-editar"><a class="btn btn-default btn-xs modificarNotaCredito" href=""""),_display_(Seq[Any](/*5.95*/controllers/*5.106*/.recupero.routes.RecuperoNotasCreditosController.editar(linea.id))),format.raw/*5.171*/(""""><i class="glyphicon glyphicon-edit"></i></a></td>
	  -->
	<td>"""),_display_(Seq[Any](/*7.7*/if(linea.planilla != null)/*7.33*/{_display_(Seq[Any](_display_(Seq[Any](/*7.35*/(linea.planilla.getRecuperoPlanillaEjercicio())))))})),format.raw/*7.83*/("""</td>
	<td>"""),_display_(Seq[Any](/*8.7*/if(linea.fecha != null)/*8.30*/{_display_(Seq[Any](_display_(Seq[Any](/*8.32*/(utils.DateUtils.formatDate(linea.fecha))))))})),format.raw/*8.74*/("""</td>
	<td>"""),_display_(Seq[Any](/*9.7*/linea/*9.12*/.producto.nombre)),format.raw/*9.28*/("""</td>
	<td>"""),_display_(Seq[Any](/*10.7*/linea/*10.12*/.udm.nombre)),format.raw/*10.23*/("""</td>
	<td>"""),_display_(Seq[Any](/*11.7*/linea/*11.12*/.cantidad)),format.raw/*11.21*/("""</td>
	<td>"""),_display_(Seq[Any](/*12.7*/utils/*12.12*/.NumberUtils.moneda(linea.precio, 2))),format.raw/*12.48*/("""</td>
	<td>"""),_display_(Seq[Any](/*13.7*/utils/*13.12*/.NumberUtils.moneda(linea.getTotal(),2))),format.raw/*13.51*/("""</td>
 
		<td><a class="btn btn-default btn-xs eliminarNotaCredito delete-confirm-link" href=""""),_display_(Seq[Any](/*15.88*/controllers/*15.99*/.recupero.routes.RecuperoNotasCreditosController.eliminar(linea.id))),format.raw/*15.166*/(""""><i class="glyphicon glyphicon-trash icono-eliminar"></i></a></td>
	 
</tr>"""))}
    }
    
    def render(linea:models.recupero.RecuperoNotaCredito,editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(linea,editable)
    
    def f:((models.recupero.RecuperoNotaCredito,Boolean) => play.api.templates.HtmlFormat.Appendable) = (linea,editable) => apply(linea,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:35 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/recupero/recuperoNotaCredito/lineaNotaCredito.scala.html
                    HASH: d7e579500c9a5c6eb176514accfdd0b952d5881c
                    MATRIX: 851->1|1008->64|1061->82|1074->87|1098->90|1235->192|1255->203|1342->268|1443->335|1477->361|1524->363|1597->411|1644->424|1675->447|1722->449|1789->491|1836->504|1849->509|1886->525|1934->538|1948->543|1981->554|2029->567|2043->572|2074->581|2122->594|2136->599|2194->635|2242->648|2256->653|2317->692|2450->789|2470->800|2560->867
                    LINES: 26->1|29->1|31->3|31->3|31->3|33->5|33->5|33->5|35->7|35->7|35->7|35->7|36->8|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|43->15|43->15|43->15
                    -- GENERATED --
                */
            