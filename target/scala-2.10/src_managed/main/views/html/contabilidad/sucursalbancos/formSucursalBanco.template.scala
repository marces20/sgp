
package views.html.contabilidad.sucursalbancos

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
object formSucursalBanco extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[SucursalBanco],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(sucursalBancoForm: Form[SucursalBanco]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.42*/("""
"""),format.raw/*3.70*/(""" 

	<div class="row">
		<div class="col-sm-4">
			<div class="form-group """),_display_(Seq[Any](/*7.28*/if(sucursalBancoForm.error("nombre") != null)/*7.73*/ {_display_(Seq[Any](format.raw/*7.75*/("""has-error""")))}/*7.85*/else/*7.89*/{_display_(Seq[Any](format.raw/*7.90*/("""has-required""")))})),format.raw/*7.103*/("""">
				<label for="inputNombre" class="control-label">Nombre</label> 
				"""),_display_(Seq[Any](/*9.6*/inputText(sucursalBancoForm("nombre"), 'class -> "form-control"))),format.raw/*9.70*/("""
				"""),_display_(Seq[Any](/*10.6*/sucursalBancoForm("nombre")/*10.33*/.error.map/*10.43*/{ error =>_display_(Seq[Any](format.raw/*10.53*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*11.31*/error/*11.36*/.message)),format.raw/*11.44*/("""</div>
				""")))})),format.raw/*12.6*/("""
			</div>
		</div>
		<div class="col-sm-4">
			<div class="form-group """),_display_(Seq[Any](/*16.28*/if(sucursalBancoForm.error("banco.id") != null)/*16.75*/ {_display_(Seq[Any](format.raw/*16.77*/("""has-error""")))}/*16.87*/else/*16.91*/{_display_(Seq[Any](format.raw/*16.92*/("""has-required""")))})),format.raw/*16.105*/("""">
				<label for="inputEjercicio" class="control-label">Banco</label> 
				"""),_display_(Seq[Any](/*18.6*/inputText(sucursalBancoForm("banco.nombre"),'class -> "form-control"))),format.raw/*18.75*/("""
				"""),_display_(Seq[Any](/*19.6*/inputText(sucursalBancoForm("banco.id"),'hidden -> "hidden"))),format.raw/*19.66*/("""
				"""),_display_(Seq[Any](/*20.6*/sucursalBancoForm("banco.id")/*20.35*/.error.map/*20.45*/{ error =>_display_(Seq[Any](format.raw/*20.55*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*21.31*/error/*21.36*/.message)),format.raw/*21.44*/("""</div>
				""")))})),format.raw/*22.6*/("""
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-4">
			<div class="form-group """),_display_(Seq[Any](/*28.28*/if(sucursalBancoForm.error("codigo") != null)/*28.73*/ {_display_(Seq[Any](format.raw/*28.75*/("""has-error""")))}/*28.85*/else/*28.89*/{_display_(Seq[Any](format.raw/*28.90*/("""has-required""")))})),format.raw/*28.103*/("""">
				<label for="inputNombre" class="control-label">Codigo</label> 
				"""),_display_(Seq[Any](/*30.6*/inputText(sucursalBancoForm("codigo"), 'class -> "form-control"))),format.raw/*30.70*/("""
				"""),_display_(Seq[Any](/*31.6*/sucursalBancoForm("codigo")/*31.33*/.error.map/*31.43*/{ error =>_display_(Seq[Any](format.raw/*31.53*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*32.31*/error/*32.36*/.message)),format.raw/*32.44*/("""</div>
				""")))})),format.raw/*33.6*/("""
			</div>
		</div>
		<div class="col-sm-4">
			<div class="form-group """),_display_(Seq[Any](/*37.28*/if(sucursalBancoForm.error("localidad.id") != null)/*37.79*/ {_display_(Seq[Any](format.raw/*37.81*/("""has-error""")))}/*37.91*/else/*37.95*/{_display_(Seq[Any](format.raw/*37.96*/("""has-required""")))})),format.raw/*37.109*/("""">
				<label for="inputEjercicio" class="control-label">Localidad</label> 
				"""),_display_(Seq[Any](/*39.6*/inputText(sucursalBancoForm("localidad.nombre"),'class -> "form-control"))),format.raw/*39.79*/("""
				"""),_display_(Seq[Any](/*40.6*/inputText(sucursalBancoForm("localidad.id"),'hidden -> "hidden"))),format.raw/*40.70*/("""
				"""),_display_(Seq[Any](/*41.6*/sucursalBancoForm("localidad.id")/*41.39*/.error.map/*41.49*/{ error =>_display_(Seq[Any](format.raw/*41.59*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*42.31*/error/*42.36*/.message)),format.raw/*42.44*/("""</div>
				""")))})),format.raw/*43.6*/("""
			</div>
		</div>
	</div>	"""))}
    }
    
    def render(sucursalBancoForm:Form[SucursalBanco]): play.api.templates.HtmlFormat.Appendable = apply(sucursalBancoForm)
    
    def f:((Form[SucursalBanco]) => play.api.templates.HtmlFormat.Appendable) = (sucursalBancoForm) => apply(sucursalBancoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:38 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/sucursalbancos/formSucursalBanco.scala.html
                    HASH: 6e10dabdf89c30a39cc793bd442611e01fc49b8d
                    MATRIX: 827->1|969->60|1001->84|1075->41|1103->128|1212->202|1265->247|1304->249|1332->259|1344->263|1382->264|1427->277|1536->352|1621->416|1662->422|1698->449|1717->459|1765->469|1832->500|1846->505|1876->513|1919->525|2027->597|2083->644|2123->646|2152->656|2165->660|2204->661|2250->674|2362->751|2453->820|2494->826|2576->886|2617->892|2655->921|2674->931|2722->941|2789->972|2803->977|2833->985|2876->997|3011->1096|3065->1141|3105->1143|3134->1153|3147->1157|3186->1158|3232->1171|3342->1246|3428->1310|3469->1316|3505->1343|3524->1353|3572->1363|3639->1394|3653->1399|3683->1407|3726->1419|3834->1491|3894->1542|3934->1544|3963->1554|3976->1558|4015->1559|4061->1572|4177->1653|4272->1726|4313->1732|4399->1796|4440->1802|4482->1835|4501->1845|4549->1855|4616->1886|4630->1891|4660->1899|4703->1911
                    LINES: 26->1|29->3|29->3|30->1|31->3|35->7|35->7|35->7|35->7|35->7|35->7|35->7|37->9|37->9|38->10|38->10|38->10|38->10|39->11|39->11|39->11|40->12|44->16|44->16|44->16|44->16|44->16|44->16|44->16|46->18|46->18|47->19|47->19|48->20|48->20|48->20|48->20|49->21|49->21|49->21|50->22|56->28|56->28|56->28|56->28|56->28|56->28|56->28|58->30|58->30|59->31|59->31|59->31|59->31|60->32|60->32|60->32|61->33|65->37|65->37|65->37|65->37|65->37|65->37|65->37|67->39|67->39|68->40|68->40|69->41|69->41|69->41|69->41|70->42|70->42|70->42|71->43
                    -- GENERATED --
                */
            