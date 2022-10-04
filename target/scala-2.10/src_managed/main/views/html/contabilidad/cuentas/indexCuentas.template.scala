
package views.html.contabilidad.cuentas

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
object indexCuentas extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[List[Cuenta],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(cuentas: List[Cuenta]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {
def /*3.2*/scripts/*3.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*3.13*/("""
	<script src=""""),_display_(Seq[Any](/*4.16*/routes/*4.22*/.Assets.at("plugins/treeview/jquery.treeview.js"))),format.raw/*4.71*/("""" type="text/javascript"></script>
	<link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*5.47*/routes/*5.53*/.Assets.at("plugins/treeview/jquery.treeview.css"))),format.raw/*5.103*/("""">
""")))};
Seq[Any](format.raw/*1.25*/("""

"""),format.raw/*6.2*/("""

"""),_display_(Seq[Any](/*8.2*/views/*8.7*/.html.contabilidad.mainContabilidad(title = "Cuentas", scripts)/*8.70*/ {_display_(Seq[Any](format.raw/*8.72*/("""

<div class="page-header">
	<div class="row">
		<div class="col-sm-9">
			<h1>Cuentas</h1>
		</div>
	</div>
</div>

"""),_display_(Seq[Any](/*18.2*/if(flash.containsKey("success"))/*18.34*/ {_display_(Seq[Any](format.raw/*18.36*/("""
	<div class="alert alert-success"><i class="glyphicon glyphicon-ok-sign"></i> """),_display_(Seq[Any](/*19.80*/flash/*19.85*/.get("success"))),format.raw/*19.100*/("""</div>
""")))})),format.raw/*20.2*/("""
"""),_display_(Seq[Any](/*21.2*/if(flash.containsKey("error"))/*21.32*/ {_display_(Seq[Any](format.raw/*21.34*/("""
	<div class="alert alert-danger"><i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*22.83*/flash/*22.88*/.get("error"))),format.raw/*22.101*/("""</div>
""")))})),format.raw/*23.2*/(""" 
        
<div class="sub-content">

"""),_display_(Seq[Any](/*27.2*/if(cuentas.isEmpty())/*27.23*/ {_display_(Seq[Any](format.raw/*27.25*/("""
    <div class="well">
        <em>No se encuentran cuentas</em>
    </div>
""")))}/*31.3*/else/*31.8*/{_display_(Seq[Any](format.raw/*31.9*/("""
	<div id="tree" class="treeview">
		"""),_display_(Seq[Any](/*33.4*/views/*33.9*/.html.contabilidad.cuentas.listaCuenta(cuentas))),format.raw/*33.56*/(""" 
	</div>
""")))})),format.raw/*35.2*/("""
        
""")))})),format.raw/*37.2*/("""
</div>

<style>
.treeview span span """),format.raw/*41.21*/("""{"""),format.raw/*41.22*/("""font-size: 11px;  color: #515151 """),format.raw/*41.55*/("""}"""),format.raw/*41.56*/("""
</style>


<script>
$( function()"""),format.raw/*46.14*/("""{"""),format.raw/*46.15*/("""
	$("#tree").treeview("""),format.raw/*47.22*/("""{"""),format.raw/*47.23*/("""
		collapsed: true,
		animated: "medium",
		control:"#sidetreecontrol",
		persist: "location"
	"""),format.raw/*52.2*/("""}"""),format.raw/*52.3*/(""");
	
	$('#tree li span').click( function()"""),format.raw/*54.38*/("""{"""),format.raw/*54.39*/("""
		$(this).parent().find('.hitarea:first').click();
	"""),format.raw/*56.2*/("""}"""),format.raw/*56.3*/(""");
	
"""),format.raw/*58.1*/("""}"""),format.raw/*58.2*/(""")
</script>"""))}
    }
    
    def render(cuentas:List[Cuenta]): play.api.templates.HtmlFormat.Appendable = apply(cuentas)
    
    def f:((List[Cuenta]) => play.api.templates.HtmlFormat.Appendable) = (cuentas) => apply(cuentas)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/cuentas/indexCuentas.scala.html
                    HASH: ec002370296d4f9573478a3404482aa4996fb2d2
                    MATRIX: 808->1|908->29|922->36|1006->40|1058->57|1072->63|1142->112|1259->194|1273->200|1345->250|1389->24|1419->255|1458->260|1470->265|1541->328|1580->330|1743->458|1784->490|1824->492|1941->573|1955->578|1993->593|2033->602|2071->605|2110->635|2150->637|2270->721|2284->726|2320->739|2360->748|2438->791|2468->812|2508->814|2608->897|2620->902|2658->903|2733->943|2746->948|2815->995|2859->1008|2903->1021|2971->1061|3000->1062|3061->1095|3090->1096|3155->1133|3184->1134|3235->1157|3264->1158|3391->1258|3419->1259|3491->1303|3520->1304|3602->1359|3630->1360|3664->1367|3692->1368
                    LINES: 26->1|28->3|28->3|30->3|31->4|31->4|31->4|32->5|32->5|32->5|34->1|36->6|38->8|38->8|38->8|38->8|48->18|48->18|48->18|49->19|49->19|49->19|50->20|51->21|51->21|51->21|52->22|52->22|52->22|53->23|57->27|57->27|57->27|61->31|61->31|61->31|63->33|63->33|63->33|65->35|67->37|71->41|71->41|71->41|71->41|76->46|76->46|77->47|77->47|82->52|82->52|84->54|84->54|86->56|86->56|88->58|88->58
                    -- GENERATED --
                */
            