
package views.html.compras.cajaChica.movimientos

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
object contenidoTabResumenPresupuesto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[List[com.avaje.ebean.SqlRow],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(s:List[com.avaje.ebean.SqlRow]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.34*/("""

<div id="" class=" ">
 


<table id="" class="table table-striped table-bordered">
	<thead>
		<tr>
		 	<th>Cuenta analitica</th>
			<th>Monto</th> 
		<tr>	
	</thead>
	<tbody>
	"""),_display_(Seq[Any](/*15.3*/for(sx <- s) yield /*15.15*/ {_display_(Seq[Any](format.raw/*15.17*/("""
		<tr data-id="">
			<td>"""),_display_(Seq[Any](/*17.9*/sx/*17.11*/.getString("cuenta"))),format.raw/*17.31*/("""</td>
			<td>"""),_display_(Seq[Any](/*18.9*/utils/*18.14*/.NumberUtils.moneda(sx.getBigDecimal("total"), 10))),format.raw/*18.64*/("""</td>
		</tr>
	""")))})),format.raw/*20.3*/("""
	</tbody>
</table>

</div>"""))}
    }
    
    def render(s:List[com.avaje.ebean.SqlRow]): play.api.templates.HtmlFormat.Appendable = apply(s)
    
    def f:((List[com.avaje.ebean.SqlRow]) => play.api.templates.HtmlFormat.Appendable) = (s) => apply(s)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:46 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/cajaChica/movimientos/contenidoTabResumenPresupuesto.scala.html
                    HASH: 455b53f48e000073557df618433ac1a017f13025
                    MATRIX: 851->1|977->33|1191->212|1219->224|1259->226|1321->253|1332->255|1374->275|1423->289|1437->294|1509->344|1556->360
                    LINES: 26->1|29->1|43->15|43->15|43->15|45->17|45->17|45->17|46->18|46->18|46->18|48->20
                    -- GENERATED --
                */
            