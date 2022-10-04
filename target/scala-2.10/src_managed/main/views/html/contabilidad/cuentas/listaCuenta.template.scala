
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
object listaCuenta extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[List[Cuenta],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(cuentas: List[Cuenta]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.25*/("""

"""),_display_(Seq[Any](/*3.2*/if(cuentas.size() > 0)/*3.24*/{_display_(Seq[Any](format.raw/*3.25*/("""
	<ul>
    """),_display_(Seq[Any](/*5.6*/for(cuenta <- cuentas) yield /*5.28*/ {_display_(Seq[Any](format.raw/*5.30*/("""
    	<li>
    		<a href="?id="""),_display_(Seq[Any](/*7.21*/cuenta/*7.27*/.id.toInt)),format.raw/*7.36*/("""" class="hide"></a>
	    	<a href=""""),_display_(Seq[Any](/*8.17*/controllers/*8.28*/.contabilidad.routes.CuentasController.crear(cuenta.id.toInt))),format.raw/*8.89*/(""""><i class="glyphicon glyphicon-plus-sign"></i></a>
	    	<a href=""""),_display_(Seq[Any](/*9.17*/controllers/*9.28*/.contabilidad.routes.CuentasController.editar(cuenta.id.toInt))),format.raw/*9.90*/(""""><i class="glyphicon glyphicon-edit"></i></a>
	    	<a href=""""),_display_(Seq[Any](/*10.17*/controllers/*10.28*/.contabilidad.routes.CuentasController.eliminar(cuenta.id.toInt))),format.raw/*10.92*/(""""><i class="glyphicon glyphicon-remove"></i></a>
    		<span><span>"""),_display_(Seq[Any](/*11.20*/cuenta/*11.26*/.code)),format.raw/*11.31*/("""</span>  """),_display_(Seq[Any](/*11.41*/cuenta/*11.47*/.nombre)),format.raw/*11.54*/("""</span>
    		"""),_display_(Seq[Any](/*12.8*/views/*12.13*/.html.contabilidad.cuentas.listaCuenta(Cuenta.getHijos(cuenta.id)))),format.raw/*12.79*/(""" 
    	</li>
    """)))})),format.raw/*14.6*/("""
	</ul>
""")))})),format.raw/*16.2*/("""
"""))}
    }
    
    def render(cuentas:List[Cuenta]): play.api.templates.HtmlFormat.Appendable = apply(cuentas)
    
    def f:((List[Cuenta]) => play.api.templates.HtmlFormat.Appendable) = (cuentas) => apply(cuentas)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/cuentas/listaCuenta.scala.html
                    HASH: c0481db1937badb9ca9af686ba0fe5e05988e545
                    MATRIX: 807->1|924->24|963->29|993->51|1031->52|1079->66|1116->88|1155->90|1223->123|1237->129|1267->138|1339->175|1358->186|1440->247|1544->316|1563->327|1646->389|1746->453|1766->464|1852->528|1957->597|1972->603|1999->608|2045->618|2060->624|2089->631|2140->647|2154->652|2242->718|2293->738|2335->749
                    LINES: 26->1|29->1|31->3|31->3|31->3|33->5|33->5|33->5|35->7|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|39->11|39->11|39->11|40->12|40->12|40->12|42->14|44->16
                    -- GENERATED --
                */
            