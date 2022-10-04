
package views.html.dashboard.autorizados

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
object contenidoTabResumen extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template4[Form[Autorizado],Autorizado,List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(autorizadoForm: Form[Autorizado] = null,a:Autorizado,rp:List[com.avaje.ebean.SqlRow],rr:List[com.avaje.ebean.SqlRow]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.120*/("""
"""),format.raw/*3.70*/(""" 

<div class="row">
	<div class="col-sm-6">
		<div class="panel panel-default">
			<div class="panel-heading"><b>Total por Proveedor</b></div>
			<div class="panel-body">
				<table class="table table-bordered table-hover" id="">
					<tbody>
						"""),_display_(Seq[Any](/*12.8*/for(p <- rp) yield /*12.20*/{_display_(Seq[Any](format.raw/*12.21*/("""
							<tr>
								<td><b>"""),_display_(Seq[Any](/*14.17*/p/*14.18*/.getString("proveedor"))),format.raw/*14.41*/("""</b></td>
								<td><b>"""),_display_(Seq[Any](/*15.17*/utils/*15.22*/.NumberUtils.moneda(p.getBigDecimal("monto")))),format.raw/*15.67*/("""</b></td>
							</tr>
						""")))})),format.raw/*17.8*/("""
					</tbody>
				</table>
			</div>
		</div>	
	</div>
	<div class="col-sm-6">
		<div class="panel panel-default">
			<div class="panel-heading"><b>Total por Rubro</b></div>
			<div class="panel-body">
				<table class="table table-bordered table-hover" id="">
					<tbody>
						"""),_display_(Seq[Any](/*29.8*/for(r <- rr) yield /*29.20*/{_display_(Seq[Any](format.raw/*29.21*/("""
							<tr>
								<td><b>"""),_display_(Seq[Any](/*31.17*/r/*31.18*/.getString("rubro"))),format.raw/*31.37*/("""</b></td>
								<td><b>"""),_display_(Seq[Any](/*32.17*/utils/*32.22*/.NumberUtils.moneda(r.getBigDecimal("monto")))),format.raw/*32.67*/("""</b></td>
							</tr>
						""")))})),format.raw/*34.8*/("""
					</tbody>
				</table>
			</div>
		</div>	
	</div>
</div>"""))}
    }
    
    def render(autorizadoForm:Form[Autorizado],a:Autorizado,rp:List[com.avaje.ebean.SqlRow],rr:List[com.avaje.ebean.SqlRow]): play.api.templates.HtmlFormat.Appendable = apply(autorizadoForm,a,rp,rr)
    
    def f:((Form[Autorizado],Autorizado,List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow]) => play.api.templates.HtmlFormat.Appendable) = (autorizadoForm,a,rp,rr) => apply(autorizadoForm,a,rp,rr)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:57 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/autorizados/contenidoTabResumen.scala.html
                    HASH: 4349a61655bb3b899e1c2932ecdc0de02951bf2f
                    MATRIX: 889->1|1109->138|1141->162|1216->119|1244->206|1530->457|1558->469|1597->470|1662->499|1672->500|1717->523|1779->549|1793->554|1860->599|1921->629|2238->911|2266->923|2305->924|2370->953|2380->954|2421->973|2483->999|2497->1004|2564->1049|2625->1079
                    LINES: 26->1|29->3|29->3|30->1|31->3|40->12|40->12|40->12|42->14|42->14|42->14|43->15|43->15|43->15|45->17|57->29|57->29|57->29|59->31|59->31|59->31|60->32|60->32|60->32|62->34
                    -- GENERATED --
                */
            