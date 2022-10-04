
package views.html.presupuesto

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
object mainPresupuesto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,Html,Html,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(title: String, scripts: Html = Html(""))(content: Html):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import models.auth._


Seq[Any](format.raw/*1.58*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/main(title: String, scripts)/*4.30*/{_display_(Seq[Any](format.raw/*4.31*/("""
	<div class="row">
		<div class="col-sm-2">
			<div class="menu-contenido">
				<ul class="nav nav-pills nav-stacked">
					<li class="titulo">Presupuesto</li>
					"""),_display_(Seq[Any](/*10.7*/if(Componente.check("creditosPresupuestarios"))/*10.54*/ {_display_(Seq[Any](format.raw/*10.56*/("""
						<li><a href=""""),_display_(Seq[Any](/*11.21*/controllers/*11.32*/.presupuesto.routes.CreditosPresupuestariosController.index())),format.raw/*11.93*/("""">Créditos presupuestarios</a></li>
						<li><a href=""""),_display_(Seq[Any](/*12.21*/controllers/*12.32*/.presupuesto.routes.CreditosPresupuestariosController.listaCargas())),format.raw/*12.99*/("""">Lista Carga Créditos</a></li>
					""")))})),format.raw/*13.7*/("""
					"""),_display_(Seq[Any](/*14.7*/if(Componente.check("balancePresupuestario"))/*14.52*/ {_display_(Seq[Any](format.raw/*14.54*/("""
						<li><a href=""""),_display_(Seq[Any](/*15.21*/controllers/*15.32*/.presupuesto.routes.BalancePresupuestarioController.index())),format.raw/*15.91*/("""">Balance presupuestario</a></li>
					""")))})),format.raw/*16.7*/("""
					"""),_display_(Seq[Any](/*17.7*/if(Componente.check("balancePresupuestario"))/*17.52*/ {_display_(Seq[Any](format.raw/*17.54*/("""
						
						<li><a href=""""),_display_(Seq[Any](/*19.21*/controllers/*19.32*/.presupuesto.routes.BalancePresupuestarioController.balancePresupuestarioPorExpediente())),format.raw/*19.120*/("""">Presupuesto control</a></li>
					""")))})),format.raw/*20.7*/("""
					"""),_display_(Seq[Any](/*21.7*/if(Componente.check("balancePresupuestario"))/*21.52*/ {_display_(Seq[Any](format.raw/*21.54*/("""
						
						<li><a href=""""),_display_(Seq[Any](/*23.21*/controllers/*23.32*/.presupuesto.routes.ControlPresupuestarioController.controlAnulacionProductosAutomaticos())),format.raw/*23.122*/("""">Control Anulacion Automatica</a></li>
						<li><a href=""""),_display_(Seq[Any](/*24.21*/controllers/*24.32*/.presupuesto.routes.ControlPresupuestarioController.movimientosSaldoPreventivo())),format.raw/*24.112*/("""">Movimientos Saldos/Preventivo</a></li>
					""")))})),format.raw/*25.7*/("""
				</ul>
			</div>
		</div>
		<div class="col-sm-10">"""),_display_(Seq[Any](/*29.27*/content)),format.raw/*29.34*/("""</div>
	</div>
""")))})))}
    }
    
    def render(title:String,scripts:Html,content:Html): play.api.templates.HtmlFormat.Appendable = apply(title,scripts)(content)
    
    def f:((String,Html) => (Html) => play.api.templates.HtmlFormat.Appendable) = (title,scripts) => (content) => apply(title,scripts)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:36 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/presupuesto/mainPresupuesto.scala.html
                    HASH: 7ca2806ec0bf7444192abadeed73d0985785442a
                    MATRIX: 806->1|977->57|1004->80|1040->82|1076->110|1114->111|1316->278|1372->325|1412->327|1469->348|1489->359|1572->420|1664->476|1684->487|1773->554|1842->592|1884->599|1938->644|1978->646|2035->667|2055->678|2136->737|2207->777|2249->784|2303->829|2343->831|2407->859|2427->870|2538->958|2606->995|2648->1002|2702->1047|2742->1049|2806->1077|2826->1088|2939->1178|3035->1238|3055->1249|3158->1329|3236->1376|3328->1432|3357->1439
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|41->13|42->14|42->14|42->14|43->15|43->15|43->15|44->16|45->17|45->17|45->17|47->19|47->19|47->19|48->20|49->21|49->21|49->21|51->23|51->23|51->23|52->24|52->24|52->24|53->25|57->29|57->29
                    -- GENERATED --
                */
            