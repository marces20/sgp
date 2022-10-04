
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
object listaCuenta extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[List[CuentaAnalitica],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(cuentas: List[CuentaAnalitica]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.34*/("""

"""),_display_(Seq[Any](/*3.2*/if(cuentas.size() > 0)/*3.24*/{_display_(Seq[Any](format.raw/*3.25*/("""
	<ul>
    """),_display_(Seq[Any](/*5.6*/for(cuenta <- cuentas) yield /*5.28*/ {_display_(Seq[Any](format.raw/*5.30*/("""
    	<li>
    		<a href="?id="""),_display_(Seq[Any](/*7.21*/cuenta/*7.27*/.id.toInt)),format.raw/*7.36*/("""" class="hide"></a>
	    	<a href=""""),_display_(Seq[Any](/*8.17*/controllers/*8.28*/.contabilidad.routes.CuentasAnaliticasController.crear(cuenta.id.toInt))),format.raw/*8.99*/(""""><i class="glyphicon glyphicon-plus-sign"></i></a>
	    	<a href=""""),_display_(Seq[Any](/*9.17*/controllers/*9.28*/.contabilidad.routes.CuentasAnaliticasController.editar(cuenta.id.toInt))),format.raw/*9.100*/(""""><i class="glyphicon glyphicon-edit"></i></a>
	    	<a href=""""),_display_(Seq[Any](/*10.17*/controllers/*10.28*/.contabilidad.routes.CuentasAnaliticasController.eliminar(cuenta.id.toInt))),format.raw/*10.102*/(""""><i class="glyphicon glyphicon-remove"></i></a>
    		<span>"""),_display_(Seq[Any](/*11.14*/cuenta/*11.20*/.codigo)),format.raw/*11.27*/(""" - """),_display_(Seq[Any](/*11.31*/cuenta/*11.37*/.nombre)),format.raw/*11.44*/("""</span>
    		"""),_display_(Seq[Any](/*12.8*/views/*12.13*/.html.contabilidad.cuentasAnaliticas.listaCuenta(CuentaAnalitica.find.where().eq("parent_id", cuenta.id).findList()))),format.raw/*12.129*/(""" 
    	</li>
    """)))})),format.raw/*14.6*/("""
	</ul>
""")))})),format.raw/*16.2*/("""
"""))}
    }
    
    def render(cuentas:List[CuentaAnalitica]): play.api.templates.HtmlFormat.Appendable = apply(cuentas)
    
    def f:((List[CuentaAnalitica]) => play.api.templates.HtmlFormat.Appendable) = (cuentas) => apply(cuentas)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:41 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/cuentasAnaliticas/listaCuenta.scala.html
                    HASH: a8283c34d3f2aa9a8f64da374b98c94d764ff909
                    MATRIX: 826->1|952->33|991->38|1021->60|1059->61|1107->75|1144->97|1183->99|1251->132|1265->138|1295->147|1367->184|1386->195|1478->266|1582->335|1601->346|1695->418|1795->482|1815->493|1912->567|2011->630|2026->636|2055->643|2095->647|2110->653|2139->660|2190->676|2204->681|2343->797|2394->817|2436->828
                    LINES: 26->1|29->1|31->3|31->3|31->3|33->5|33->5|33->5|35->7|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|39->11|39->11|39->11|40->12|40->12|40->12|42->14|44->16
                    -- GENERATED --
                */
            