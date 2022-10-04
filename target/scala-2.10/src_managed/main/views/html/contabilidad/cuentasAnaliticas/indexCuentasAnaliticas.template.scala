
package views.html.contabilidad.cuentasAnaliticas

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
object indexCuentasAnaliticas extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[List[CuentaAnalitica],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(cuentas: List[CuentaAnalitica]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {
def /*3.2*/scripts/*3.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*3.13*/("""
	<script src=""""),_display_(Seq[Any](/*4.16*/routes/*4.22*/.Assets.at("plugins/treeview/jquery.treeview.js"))),format.raw/*4.71*/("""" type="text/javascript"></script>
	<link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*5.47*/routes/*5.53*/.Assets.at("plugins/treeview/jquery.treeview.css"))),format.raw/*5.103*/("""">
""")))};
Seq[Any](format.raw/*1.34*/("""

"""),format.raw/*6.2*/("""

"""),_display_(Seq[Any](/*8.2*/views/*8.7*/.html.contabilidad.mainContabilidad(title = "Cuentas analíticas", scripts)/*8.81*/ {_display_(Seq[Any](format.raw/*8.83*/("""


<div class="page-header">
	<div class="row">
		<div class="col-sm-9">
			<h1>Cuentas presupuestarias</h1>
		</div>
	</div>
</div>


"""),_display_(Seq[Any](/*20.2*/if(flash.containsKey("success"))/*20.34*/ {_display_(Seq[Any](format.raw/*20.36*/("""
	<div class="alert alert-success"><i class="glyphicon glyphicon-ok-sign"></i> """),_display_(Seq[Any](/*21.80*/flash/*21.85*/.get("success"))),format.raw/*21.100*/("""</div>
""")))})),format.raw/*22.2*/("""
"""),_display_(Seq[Any](/*23.2*/if(flash.containsKey("error"))/*23.32*/ {_display_(Seq[Any](format.raw/*23.34*/("""
	<div class="alert alert-danger"><i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*24.83*/flash/*24.88*/.get("error"))),format.raw/*24.101*/("""</div>
""")))})),format.raw/*25.2*/(""" 
        
<div class="sub-content">

"""),_display_(Seq[Any](/*29.2*/if(cuentas.isEmpty())/*29.23*/ {_display_(Seq[Any](format.raw/*29.25*/("""
    <div class="well">
        <em>No se encuentran cuentas</em>
    </div>
""")))}/*33.3*/else/*33.8*/{_display_(Seq[Any](format.raw/*33.9*/("""
	<div id="tree" class="treeview">
		"""),_display_(Seq[Any](/*35.4*/views/*35.9*/.html.contabilidad.cuentasAnaliticas.listaCuenta(CuentaAnalitica.find.where().eq("parent_id", null).findList()))),format.raw/*35.120*/(""" 
	</div>
""")))})),format.raw/*37.2*/("""
        
""")))})),format.raw/*39.2*/("""
</div>

<script>
$( function()"""),format.raw/*43.14*/("""{"""),format.raw/*43.15*/("""
	$("#tree").treeview("""),format.raw/*44.22*/("""{"""),format.raw/*44.23*/("""
		collapsed: true,
		animated: "medium",
		persist: "location"
	"""),format.raw/*48.2*/("""}"""),format.raw/*48.3*/(""");
	
	
	$('#tree li span').click( function()"""),format.raw/*51.38*/("""{"""),format.raw/*51.39*/("""
		$(this).parent().find('.hitarea:first').click();
	"""),format.raw/*53.2*/("""}"""),format.raw/*53.3*/(""");
	
"""),format.raw/*55.1*/("""}"""),format.raw/*55.2*/(""")
</script>"""))}
    }
    
    def render(cuentas:List[CuentaAnalitica]): play.api.templates.HtmlFormat.Appendable = apply(cuentas)
    
    def f:((List[CuentaAnalitica]) => play.api.templates.HtmlFormat.Appendable) = (cuentas) => apply(cuentas)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:41 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/cuentasAnaliticas/indexCuentasAnaliticas.scala.html
                    HASH: 603b2c489de8853d0fdb7c07c41071bda864e146
                    MATRIX: 837->1|946->38|960->45|1044->49|1096->66|1110->72|1180->121|1297->203|1311->209|1383->259|1427->33|1457->264|1496->269|1508->274|1590->348|1629->350|1812->498|1853->530|1893->532|2010->613|2024->618|2062->633|2102->642|2140->645|2179->675|2219->677|2339->761|2353->766|2389->779|2429->788|2507->831|2537->852|2577->854|2677->937|2689->942|2727->943|2802->983|2815->988|2949->1099|2993->1112|3037->1125|3100->1160|3129->1161|3180->1184|3209->1185|3305->1254|3333->1255|3408->1302|3437->1303|3519->1358|3547->1359|3581->1366|3609->1367
                    LINES: 26->1|28->3|28->3|30->3|31->4|31->4|31->4|32->5|32->5|32->5|34->1|36->6|38->8|38->8|38->8|38->8|50->20|50->20|50->20|51->21|51->21|51->21|52->22|53->23|53->23|53->23|54->24|54->24|54->24|55->25|59->29|59->29|59->29|63->33|63->33|63->33|65->35|65->35|65->35|67->37|69->39|73->43|73->43|74->44|74->44|78->48|78->48|81->51|81->51|83->53|83->53|85->55|85->55
                    -- GENERATED --
                */
            