
package views.html.patrimonio.actasMovimientos

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
object lineaActaMovimiento extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[ActaMovimiento,Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea: ActaMovimiento, editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.44*/("""

 
			

<tr data-id=""""),_display_(Seq[Any](/*6.15*/linea/*6.20*/.id)),format.raw/*6.23*/("""" """),_display_(Seq[Any](/*6.26*/if(linea.cancelado)/*6.45*/{_display_(Seq[Any](format.raw/*6.46*/("""class="cancelada"""")))})),format.raw/*6.64*/(""">
	"""),_display_(Seq[Any](/*7.3*/if(editable)/*7.15*/{_display_(Seq[Any](format.raw/*7.16*/("""
		
	""")))})),format.raw/*9.3*/("""
	<td>"""),_display_(Seq[Any](/*10.7*/linea/*10.12*/.organigrama.nombre)),format.raw/*10.31*/("""</td>
	<td>"""),_display_(Seq[Any](/*11.7*/linea/*11.12*/.usuario.nombre)),format.raw/*11.27*/("""</td>
	<td>"""),_display_(Seq[Any](/*12.7*/if(linea.usuario_receptor != null)/*12.41*/{_display_(Seq[Any](_display_(Seq[Any](/*12.43*/linea/*12.48*/.usuario_receptor.nombre))))})),format.raw/*12.73*/("""</td>
	<td>"""),_display_(Seq[Any](/*13.7*/utils/*13.12*/.DateUtils.formatDate(linea.fecha_llegada,"dd/MM/yyyy HH:mm:ss"))),format.raw/*13.76*/("""</td>
	<td>"""),_display_(Seq[Any](/*14.7*/utils/*14.12*/.DateUtils.formatDate(linea.fecha_salida,"dd/MM/yyyy HH:mm:ss"))),format.raw/*14.75*/("""</td>
	<td>"""),_display_(Seq[Any](/*15.7*/ActaMovimiento/*15.21*/.tiempoEnMovimiento(linea))),format.raw/*15.47*/("""</td>
	<td>"""),_display_(Seq[Any](/*16.7*/if(linea.estado !=  null)/*16.32*/{_display_(Seq[Any](_display_(Seq[Any](/*16.34*/linea/*16.39*/.estado.nombre))))})),format.raw/*16.54*/("""</td>
	<td>"""),_display_(Seq[Any](/*17.7*/if(linea.cancelado)/*17.26*/{_display_(Seq[Any](format.raw/*17.27*/("""CANCELADO""")))})),format.raw/*17.37*/("""</td>
	
	
	<td>
		"""),_display_(Seq[Any](/*21.4*/if(linea != null && linea.descripcion != null && !linea.descripcion.isEmpty())/*21.82*/{_display_(Seq[Any](format.raw/*21.83*/("""
			<div class='tip-top pointer' style="display: inline;" title='"""),_display_(Seq[Any](/*22.66*/linea/*22.71*/.descripcion)),format.raw/*22.83*/("""'>
				<i class="glyphicon glyphicon-list-alt"></i></div>
		""")))})),format.raw/*24.4*/("""
	</td>
</tr>
"""))}
    }
    
    def render(linea:ActaMovimiento,editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(linea,editable)
    
    def f:((ActaMovimiento,Boolean) => play.api.templates.HtmlFormat.Appendable) = (linea,editable) => apply(linea,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/actasMovimientos/lineaActaMovimiento.scala.html
                    HASH: 3586d2f624960145ceca7f8b4ff3afafc82dbb7e
                    MATRIX: 832->1|968->43|1031->71|1044->76|1068->79|1106->82|1133->101|1171->102|1220->120|1259->125|1279->137|1317->138|1355->146|1398->154|1412->159|1453->178|1501->191|1515->196|1552->211|1600->224|1643->258|1691->260|1705->265|1756->290|1804->303|1818->308|1904->372|1952->385|1966->390|2051->453|2099->466|2122->480|2170->506|2218->519|2252->544|2300->546|2314->551|2355->566|2403->579|2431->598|2470->599|2512->609|2570->632|2657->710|2696->711|2799->778|2813->783|2847->795|2941->858
                    LINES: 26->1|29->1|34->6|34->6|34->6|34->6|34->6|34->6|34->6|35->7|35->7|35->7|37->9|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|44->16|44->16|44->16|44->16|44->16|45->17|45->17|45->17|45->17|49->21|49->21|49->21|50->22|50->22|50->22|52->24
                    -- GENERATED --
                */
            