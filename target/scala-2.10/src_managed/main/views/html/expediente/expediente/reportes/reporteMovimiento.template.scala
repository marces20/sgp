
package views.html.expediente.expediente.reportes

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
object reporteMovimiento extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(cerrados: List[com.avaje.ebean.SqlRow], abiertos: List[com.avaje.ebean.SqlRow]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.82*/("""



"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.expediente.mainExpediente("Reportes de movimiento")/*5.64*/ {_display_(Seq[Any](format.raw/*5.66*/("""

<div class="page-header">

	<h1>Reportes de movimientos cerrados</h1>
	
	<table class="table table-striped table-bordered">
		<thead>
			<tr>
				<th>Servicio</th>
				<th>Menos de 7 días</th>
				<th>Entre 7 y 14</th>
				<th>Entre 14 y 21</th>
				<th>Entre 21 y 28</th>
				<th>Más de 28</th>
			</tr>
		</thead>
		<tbody>
		"""),_display_(Seq[Any](/*23.4*/for(m <- cerrados) yield /*23.22*/ {_display_(Seq[Any](format.raw/*23.24*/("""
			<tr>
				<td>"""),_display_(Seq[Any](/*25.10*/m/*25.11*/.getString("nombre"))),format.raw/*25.31*/("""</td>
				<td>"""),_display_(Seq[Any](/*26.10*/m/*26.11*/.getInteger("r07"))),format.raw/*26.29*/("""</td>
				<td>"""),_display_(Seq[Any](/*27.10*/m/*27.11*/.getInteger("r0714"))),format.raw/*27.31*/("""</td>
				<td>"""),_display_(Seq[Any](/*28.10*/m/*28.11*/.getInteger("r1421"))),format.raw/*28.31*/("""</td>
				<td>"""),_display_(Seq[Any](/*29.10*/m/*29.11*/.getInteger("r2128"))),format.raw/*29.31*/("""</td>
				<td>"""),_display_(Seq[Any](/*30.10*/m/*30.11*/.getInteger("r28"))),format.raw/*30.29*/("""</td>
			</tr>	
		""")))})),format.raw/*32.4*/("""
        </tbody>
       </table>
        
        
	<h1>Reportes de movimientos abiertos</h1>
	
	<table class="table table-striped table-bordered">
		<thead>
			<tr>
				<th>Servicio</th>
				<th>Menos de 7 días</th>
				<th>Entre 7 y 14</th>
				<th>Entre 14 y 21</th>
				<th>Entre 21 y 28</th>
				<th>Más de 28</th>
			</tr>
		</thead>
		<tbody>
		"""),_display_(Seq[Any](/*51.4*/for(m <- abiertos) yield /*51.22*/ {_display_(Seq[Any](format.raw/*51.24*/("""
			<tr>
				<td>"""),_display_(Seq[Any](/*53.10*/m/*53.11*/.getString("nombre"))),format.raw/*53.31*/("""</td>
				<td>"""),_display_(Seq[Any](/*54.10*/m/*54.11*/.getInteger("r07"))),format.raw/*54.29*/("""</td>
				<td>"""),_display_(Seq[Any](/*55.10*/m/*55.11*/.getInteger("r0714"))),format.raw/*55.31*/("""</td>
				<td>"""),_display_(Seq[Any](/*56.10*/m/*56.11*/.getInteger("r1421"))),format.raw/*56.31*/("""</td>
				<td>"""),_display_(Seq[Any](/*57.10*/m/*57.11*/.getInteger("r2128"))),format.raw/*57.31*/("""</td>
				<td>"""),_display_(Seq[Any](/*58.10*/m/*58.11*/.getInteger("r28"))),format.raw/*58.29*/("""</td>
			</tr>	
		""")))})),format.raw/*60.4*/("""
        </tbody>
       </table>
        
        
	</div>	
        
        
        
	</div>	


""")))})),format.raw/*72.2*/("""
"""))}
    }
    
    def render(cerrados:List[com.avaje.ebean.SqlRow],abiertos:List[com.avaje.ebean.SqlRow]): play.api.templates.HtmlFormat.Appendable = apply(cerrados,abiertos)
    
    def f:((List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow]) => play.api.templates.HtmlFormat.Appendable) = (cerrados,abiertos) => apply(cerrados,abiertos)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:36 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/expediente/expediente/reportes/reporteMovimiento.scala.html
                    HASH: f59e7b5ca908e9f8f904fa9d6c84cf0ed3a80a65
                    MATRIX: 868->1|1042->81|1085->90|1097->95|1162->152|1201->154|1585->503|1619->521|1659->523|1715->543|1725->544|1767->564|1819->580|1829->581|1869->599|1921->615|1931->616|1973->636|2025->652|2035->653|2077->673|2129->689|2139->690|2181->710|2233->726|2243->727|2283->745|2335->766|2743->1139|2777->1157|2817->1159|2873->1179|2883->1180|2925->1200|2977->1216|2987->1217|3027->1235|3079->1251|3089->1252|3131->1272|3183->1288|3193->1289|3235->1309|3287->1325|3297->1326|3339->1346|3391->1362|3401->1363|3441->1381|3493->1402|3636->1514
                    LINES: 26->1|29->1|33->5|33->5|33->5|33->5|51->23|51->23|51->23|53->25|53->25|53->25|54->26|54->26|54->26|55->27|55->27|55->27|56->28|56->28|56->28|57->29|57->29|57->29|58->30|58->30|58->30|60->32|79->51|79->51|79->51|81->53|81->53|81->53|82->54|82->54|82->54|83->55|83->55|83->55|84->56|84->56|84->56|85->57|85->57|85->57|86->58|86->58|86->58|88->60|100->72
                    -- GENERATED --
                */
            