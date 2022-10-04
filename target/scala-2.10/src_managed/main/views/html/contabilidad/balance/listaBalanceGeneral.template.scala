
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
object listaBalanceGeneral extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Long,Map[Long, List[Balance]],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(id : Long, balance: Map[Long,List[Balance]]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.47*/("""

"""),_display_(Seq[Any](/*3.2*/if(balance.containsKey(id))/*3.29*/{_display_(Seq[Any](format.raw/*3.30*/("""
    """),_display_(Seq[Any](/*4.6*/for(b <- balance.get(id)) yield /*4.31*/ {_display_(Seq[Any](format.raw/*4.33*/("""
    	<div class="row"  style="padding-left: 30px; border-left:1px solid #ccc">
    	
    		<div class="col-xs-4">"""),_display_(Seq[Any](/*7.30*/b/*7.31*/.cuenta.nombre)),format.raw/*7.45*/("""</div>
    		<div class="col-xs-2 pull-right" >$"""),_display_(Seq[Any](/*8.43*/b/*8.44*/.debe)),format.raw/*8.49*/("""</div>
    		<div class="col-xs-2 pull-right">$"""),_display_(Seq[Any](/*9.42*/b/*9.43*/.haber)),format.raw/*9.49*/("""</div>
    		
			"""),_display_(Seq[Any](/*11.5*/if(balance.containsKey(b.cuenta.id))/*11.41*/{_display_(Seq[Any](format.raw/*11.42*/("""
				<div class="clearfix"></div>
				"""),_display_(Seq[Any](/*13.6*/views/*13.11*/.html.contabilidad.balance.listaBalanceGeneral(b.cuenta.id, balance))),format.raw/*13.79*/("""
			""")))})),format.raw/*14.5*/("""
    	</div>
    """)))})),format.raw/*16.6*/("""
""")))})))}
    }
    
    def render(id:Long,balance:Map[Long, List[Balance]]): play.api.templates.HtmlFormat.Appendable = apply(id,balance)
    
    def f:((Long,Map[Long, List[Balance]]) => play.api.templates.HtmlFormat.Appendable) = (id,balance) => apply(id,balance)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:41 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/balance/listaBalanceGeneral.scala.html
                    HASH: 5ce1b617eb1727b8501b4f3e81c73d221e6c06db
                    MATRIX: 832->1|971->46|1010->51|1045->78|1083->79|1124->86|1164->111|1203->113|1356->231|1365->232|1400->246|1485->296|1494->297|1520->302|1604->351|1613->352|1640->358|1695->378|1740->414|1779->415|1855->456|1869->461|1959->529|1996->535|2047->555
                    LINES: 26->1|29->1|31->3|31->3|31->3|32->4|32->4|32->4|35->7|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|39->11|39->11|39->11|41->13|41->13|41->13|42->14|44->16
                    -- GENERATED --
                */
            