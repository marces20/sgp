
package views.html

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
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template4[List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(ll:List[com.avaje.ebean.SqlRow],lr:List[com.avaje.ebean.SqlRow],ls:List[com.avaje.ebean.SqlRow],usuariosActivos:Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.123*/("""
"""),format.raw/*5.70*/("""
"""),_display_(Seq[Any](/*6.2*/main("SGP - v1.0")/*6.20*/ {_display_(Seq[Any](format.raw/*6.22*/("""
 

"""),_display_(Seq[Any](/*9.2*/if(usuariosActivos)/*9.21*/{_display_(Seq[Any](format.raw/*9.22*/("""	    
<div class="page-header">
	<div class="row">
	
		<div class="col-sm-4">
			<div class="panel panel-default">
				<div class="panel-heading"><b>Top 20 de Deuda por Proveedor</b>
				</div>
				<div class="panel-body" id="div-datos-puestos">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<td><b>Proveedor</b></td>
								<td><b>Deuda Total</b></td>
							</tr>	
						</thead>
						<tbody>
							"""),_display_(Seq[Any](/*26.9*/for(el <- ll) yield /*26.22*/{_display_(Seq[Any](format.raw/*26.23*/("""
							<tr>
								<td>"""),_display_(Seq[Any](/*28.14*/el/*28.16*/.getString("nombre"))),format.raw/*28.36*/("""</td>
								<td>"""),_display_(Seq[Any](/*29.14*/(utils.NumberUtils.moneda(el.getBigDecimal("td"))))),format.raw/*29.64*/("""</td>
							</tr>
							""")))})),format.raw/*31.9*/("""
						</tbody>
					</table>			
				</div>
			</div>	
		</div>
		
		<div class="col-sm-4">
			<div class="panel panel-default">
				<div class="panel-heading"><b>Top 20 de Deuda por Rubro</b>
				</div>
				<div class="panel-body" id="div-datos-puestos">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<td><b>Rubro</b></td>
								<td><b>Deuda Total</b></td>
							</tr>	
						</thead>
						<tbody>
							"""),_display_(Seq[Any](/*51.9*/for(el <- lr) yield /*51.22*/{_display_(Seq[Any](format.raw/*51.23*/("""
							<tr>
								<td>"""),_display_(Seq[Any](/*53.14*/el/*53.16*/.getString("nombre"))),format.raw/*53.36*/("""</td>
								<td>"""),_display_(Seq[Any](/*54.14*/(utils.NumberUtils.moneda(el.getBigDecimal("td"))))),format.raw/*54.64*/("""</td>
							</tr>
							""")))})),format.raw/*56.9*/("""
						</tbody>
					</table>			
				</div>
			</div>	
		</div>
		
		<div class="col-sm-4">
			<div class="panel panel-default">
				<div class="panel-heading"><b>Top 20 de Deuda por Servicio</b>
				</div>
				<div class="panel-body" id="div-datos-puestos">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<td><b>Servicio</b></td>
								<td><b>Deuda Total</b></td>
							</tr>	
						</thead>
						<tbody>
							"""),_display_(Seq[Any](/*76.9*/for(el <- ls) yield /*76.22*/{_display_(Seq[Any](format.raw/*76.23*/("""
							<tr>
								<td>"""),_display_(Seq[Any](/*78.14*/el/*78.16*/.getString("nombre"))),format.raw/*78.36*/("""</td>
								<td>"""),_display_(Seq[Any](/*79.14*/(utils.NumberUtils.moneda(el.getBigDecimal("td"))))),format.raw/*79.64*/("""</td>
							</tr>
							""")))})),format.raw/*81.9*/("""
						</tbody>
					</table>			
				</div>
			</div>	
		</div>
		
	</div>
</div>	
""")))})),format.raw/*90.2*/("""			 
		
""")))})),format.raw/*92.2*/("""
"""))}
    }
    
    def render(ll:List[com.avaje.ebean.SqlRow],lr:List[com.avaje.ebean.SqlRow],ls:List[com.avaje.ebean.SqlRow],usuariosActivos:Boolean): play.api.templates.HtmlFormat.Appendable = apply(ll,lr,ls,usuariosActivos)
    
    def f:((List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],Boolean) => play.api.templates.HtmlFormat.Appendable) = (ll,lr,ls,usuariosActivos) => apply(ll,lr,ls,usuariosActivos)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:27 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/index.scala.html
                    HASH: a1c756b7ee610c65d540b68cda87aea9a2a3e1d7
                    MATRIX: 862->1|1123->179|1155->203|1230->122|1258->247|1294->249|1320->267|1359->269|1398->274|1425->293|1463->294|1947->743|1976->756|2015->757|2077->783|2088->785|2130->805|2185->824|2257->874|2315->901|2805->1356|2834->1369|2873->1370|2935->1396|2946->1398|2988->1418|3043->1437|3115->1487|3173->1514|3669->1975|3698->1988|3737->1989|3799->2015|3810->2017|3852->2037|3907->2056|3979->2106|4037->2133|4152->2217|4192->2226
                    LINES: 26->1|33->5|33->5|34->1|35->5|36->6|36->6|36->6|39->9|39->9|39->9|56->26|56->26|56->26|58->28|58->28|58->28|59->29|59->29|61->31|81->51|81->51|81->51|83->53|83->53|83->53|84->54|84->54|86->56|106->76|106->76|106->76|108->78|108->78|108->78|109->79|109->79|111->81|120->90|122->92
                    -- GENERATED --
                */
            