
package views.html.rrhh.agenteAsistenciaLicencia

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
object resumenAgenteAsistenciaLicencia extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[java.util.Map[String, java.util.Map[String, Array[Integer]]],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(aal:java.util.Map[String,java.util.Map[String,Array[Integer]]]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._


Seq[Any](format.raw/*1.66*/("""
"""),_display_(Seq[Any](/*5.2*/for((key,value) <- aal) yield /*5.25*/{_display_(Seq[Any](format.raw/*5.26*/("""
<table id="listaDeAgenteAsistenciaLicenciasResumen" class="table table-striped table-bordered">
	<thead>
		<tr>
			<th align="center" colspan="3">EJERCICIO - """),_display_(Seq[Any](/*9.48*/key)),format.raw/*9.51*/("""</th>
		</tr>
		<tr>
			<th width="400">Tipo de Licencia</th>
			<th>Dias Pedidos/Totales</th>
			<th>Dias Disponibles</th>
		<tr>
	</thead>
	<tbody>
		"""),_display_(Seq[Any](/*18.4*/for((key2,value2) <- value) yield /*18.31*/{_display_(Seq[Any](format.raw/*18.32*/("""
		<tr>
			<td>"""),_display_(Seq[Any](/*20.9*/key2)),format.raw/*20.13*/("""</td>
			<td>"""),_display_(Seq[Any](/*21.9*/value2(0))),format.raw/*21.18*/("""/"""),_display_(Seq[Any](/*21.20*/value2(2))),format.raw/*21.29*/("""</td>
			<td>"""),_display_(Seq[Any](/*22.9*/value2(1))),format.raw/*22.18*/("""</td>
		</tr>
		""")))})),format.raw/*24.4*/("""
	</tbody>
</table>
""")))})))}
    }
    
    def render(aal:java.util.Map[String, java.util.Map[String, Array[Integer]]]): play.api.templates.HtmlFormat.Appendable = apply(aal)
    
    def f:((java.util.Map[String, java.util.Map[String, Array[Integer]]]) => play.api.templates.HtmlFormat.Appendable) = (aal) => apply(aal)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:30 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agenteAsistenciaLicencia/resumenAgenteAsistenciaLicencia.scala.html
                    HASH: 6771beb0ca0261a4558921ffefb43444a63f4bcd
                    MATRIX: 884->1|1096->65|1132->122|1170->145|1208->146|1403->306|1427->309|1615->462|1658->489|1697->490|1748->506|1774->510|1823->524|1854->533|1892->535|1923->544|1972->558|2003->567|2051->584
                    LINES: 26->1|34->1|35->5|35->5|35->5|39->9|39->9|48->18|48->18|48->18|50->20|50->20|51->21|51->21|51->21|51->21|52->22|52->22|54->24
                    -- GENERATED --
                */
            