
package views.html.dashboard.liquidaciones.vistas

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
object detalleHaberesClasificacion extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[List[com.avaje.ebean.SqlRow],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(row:List[com.avaje.ebean.SqlRow]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.36*/("""


"""),_display_(Seq[Any](/*4.2*/if(row != null)/*4.17*/{_display_(Seq[Any](format.raw/*4.18*/("""
	"""),_display_(Seq[Any](/*5.3*/if(row.size() > 0)/*5.21*/{_display_(Seq[Any](format.raw/*5.22*/("""
		<div class="row">
			<div class="col-sm-12">
				
				<h2></h2>
					
				<table class="table table-bordered">
					<thead>
						<tr>
							<td>CONCEPTO</td>
							<td>CANTIDAD</td>
							<td>PRECIO</td>
							<td>TOTAL</td>	
						</tr>
					</thead>
					<tbody>
						"""),_display_(Seq[Any](/*21.8*/for(rp <- row) yield /*21.22*/{_display_(Seq[Any](format.raw/*21.23*/("""
						<tr>
							<td>"""),_display_(Seq[Any](/*23.13*/(rp.getString("concepto")))),format.raw/*23.39*/("""</td>
							<td>"""),_display_(Seq[Any](/*24.13*/(utils.NumberUtils.moneda(rp.getBigDecimal("cantidad"))))),format.raw/*24.69*/("""</td>
							<td>"""),_display_(Seq[Any](/*25.13*/(utils.NumberUtils.moneda(rp.getBigDecimal("importe"))))),format.raw/*25.68*/("""</td>
							<td>"""),_display_(Seq[Any](/*26.13*/(utils.NumberUtils.moneda(rp.getBigDecimal("importe").multiply(rp.getBigDecimal("cantidad")))))),format.raw/*26.107*/("""</td>	
						</tr>
						""")))})),format.raw/*28.8*/("""
					</tbody>
				</table>	
				
			</div>		
		</div>		
	""")))})),format.raw/*34.3*/("""
""")))})))}
    }
    
    def render(row:List[com.avaje.ebean.SqlRow]): play.api.templates.HtmlFormat.Appendable = apply(row)
    
    def f:((List[com.avaje.ebean.SqlRow]) => play.api.templates.HtmlFormat.Appendable) = (row) => apply(row)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:44:02 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/liquidaciones/vistas/detalleHaberesClasificacion.scala.html
                    HASH: f5f98acebf4cbf4d0781d532a6c23aade9d67f62
                    MATRIX: 849->1|977->35|1015->39|1038->54|1076->55|1113->58|1139->76|1177->77|1492->357|1522->371|1561->372|1621->396|1669->422|1723->440|1801->496|1855->514|1932->569|1986->587|2103->681|2160->707|2250->766
                    LINES: 26->1|29->1|32->4|32->4|32->4|33->5|33->5|33->5|49->21|49->21|49->21|51->23|51->23|52->24|52->24|53->25|53->25|54->26|54->26|56->28|62->34
                    -- GENERATED --
                */
            