
package views.html.contabilidad.balance

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
object indexBalanceGeneral extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[List[Cuenta],Map[Long, List[Balance]],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(cuentas: List[Cuenta], balances: Map[Long,List[Balance]]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import models.auth._

import java.math.BigDecimal;var debe=new java.math.BigDecimal(0);var haber=new java.math.BigDecimal(0);

def /*6.2*/scripts/*6.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*6.13*/("""
	<script src=""""),_display_(Seq[Any](/*7.16*/routes/*7.22*/.Assets.at("javascripts/contabilidad/balance.js"))),format.raw/*7.71*/("""" type="text/javascript"></script>
""")))};implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.60*/("""
"""),format.raw/*5.70*/(""" 
"""),format.raw/*8.2*/("""

"""),_display_(Seq[Any](/*10.2*/views/*10.7*/.html.contabilidad.mainContabilidad("Balance",scripts)/*10.61*/ {_display_(Seq[Any](format.raw/*10.63*/("""
<div class="page-header">
	<div class="row">
		<div class="col-sm-7">
			<h1>Balance general</h1>
		</div>
		
	</div>
	
</div>
<div class="row">
	<div class="col-sm-12">


			"""),_display_(Seq[Any](/*24.5*/for(b <- cuentas) yield /*24.22*/ {_display_(Seq[Any](format.raw/*24.24*/("""
				"""),_display_(Seq[Any](/*25.6*/views/*25.11*/.html.contabilidad.balance.listaBalanceGeneral(b.id, balances))),format.raw/*25.73*/(""" 
			""")))})),format.raw/*26.5*/("""

		

	</div>	
</div>

""")))})))}
    }
    
    def render(cuentas:List[Cuenta],balances:Map[Long, List[Balance]]): play.api.templates.HtmlFormat.Appendable = apply(cuentas,balances)
    
    def f:((List[Cuenta],Map[Long, List[Balance]]) => play.api.templates.HtmlFormat.Appendable) = (cuentas,balances) => apply(cuentas,balances)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:41 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/balance/indexBalanceGeneral.scala.html
                    HASH: 9713f572ab943769d3f7973b53feea0122c86501
                    MATRIX: 840->1|1121->281|1135->288|1219->292|1271->309|1285->315|1355->364|1423->209|1455->233|1529->59|1558->277|1587->401|1627->406|1640->411|1703->465|1743->467|1969->658|2002->675|2042->677|2084->684|2098->689|2182->751|2220->758
                    LINES: 26->1|33->6|33->6|35->6|36->7|36->7|36->7|37->5|37->5|38->1|39->5|40->8|42->10|42->10|42->10|42->10|56->24|56->24|56->24|57->25|57->25|57->25|58->26
                    -- GENERATED --
                */
            