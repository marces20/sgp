
package views.html.recupero.recuperoPago.cheques

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
object lineaCheque extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[models.recupero.Cheque,Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea: models.recupero.Cheque, editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.52*/("""

<tr data-id=""""),_display_(Seq[Any](/*3.15*/linea/*3.20*/.id)),format.raw/*3.23*/("""">
	  """),_display_(Seq[Any](/*4.5*/if(editable)/*4.17*/{_display_(Seq[Any](format.raw/*4.18*/("""
	<td class="accion-editar"><a class="btn btn-default btn-xs modificarCheque" href=""""),_display_(Seq[Any](/*5.85*/controllers/*5.96*/.recupero.routes.RecuperoChequesController.editar(linea.id))),format.raw/*5.155*/(""""><i class="glyphicon glyphicon-edit"></i></a></td>
	""")))})),format.raw/*6.3*/("""
	<td>"""),_display_(Seq[Any](/*7.7*/linea/*7.12*/.numero)),format.raw/*7.19*/("""</td>
	<td>"""),_display_(Seq[Any](/*8.7*/if(linea.fecha != null)/*8.30*/{_display_(Seq[Any](_display_(Seq[Any](/*8.32*/(utils.DateUtils.formatDate(linea.fecha))))))})),format.raw/*8.74*/("""</td>
	<td>"""),_display_(Seq[Any](/*9.7*/linea/*9.12*/.banco.nombre)),format.raw/*9.25*/("""</td>
	<td>"""),_display_(Seq[Any](/*10.7*/linea/*10.12*/.sucursalBanco.nombre)),format.raw/*10.33*/("""</td>
	<td>"""),_display_(Seq[Any](/*11.7*/utils/*11.12*/.NumberUtils.moneda(linea.monto, 10))),format.raw/*11.48*/("""</td>
	<td>"""),_display_(Seq[Any](/*12.7*/linea/*12.12*/.observaciones)),format.raw/*12.26*/("""</td>
  """),_display_(Seq[Any](/*13.4*/if(editable)/*13.16*/{_display_(Seq[Any](format.raw/*13.17*/("""
		<td><a class="btn btn-default btn-xs eliminarCheque delete-confirm-link" href=""""),_display_(Seq[Any](/*14.83*/controllers/*14.94*/.recupero.routes.RecuperoChequesController.eliminar(linea.id))),format.raw/*14.155*/(""""><i class="glyphicon glyphicon-trash icono-eliminar"></i></a></td>
	 """)))})),format.raw/*15.4*/("""
</tr>
"""))}
    }
    
    def render(linea:models.recupero.Cheque,editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(linea,editable)
    
    def f:((models.recupero.Cheque,Boolean) => play.api.templates.HtmlFormat.Appendable) = (linea,editable) => apply(linea,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:35 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/recupero/recuperoPago/cheques/lineaCheque.scala.html
                    HASH: 277ce0fdc9864bd89d58ad409a34b30069894be4
                    MATRIX: 834->1|978->51|1031->69|1044->74|1068->77|1110->85|1130->97|1168->98|1289->184|1308->195|1389->254|1474->309|1516->317|1529->322|1557->329|1604->342|1635->365|1682->367|1749->409|1796->422|1809->427|1843->440|1891->453|1905->458|1948->479|1996->492|2010->497|2068->533|2116->546|2130->551|2166->565|2211->575|2232->587|2271->588|2391->672|2411->683|2495->744|2598->816
                    LINES: 26->1|29->1|31->3|31->3|31->3|32->4|32->4|32->4|33->5|33->5|33->5|34->6|35->7|35->7|35->7|36->8|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|43->15
                    -- GENERATED --
                */
            