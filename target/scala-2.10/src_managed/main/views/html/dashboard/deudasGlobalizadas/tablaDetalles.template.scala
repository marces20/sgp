
package views.html.dashboard.deudasGlobalizadas

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
object tablaDetalles extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,String,String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(cuenta:String,institucion:String,proveedor:String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.53*/("""
<thead>
	<th colspan="8" align="center" style="font-size:20px;text-align:center;">"""),_display_(Seq[Any](/*3.76*/cuenta)),format.raw/*3.82*/(""" - """),_display_(Seq[Any](/*3.86*/institucion)),format.raw/*3.97*/(""" - """),_display_(Seq[Any](/*3.101*/proveedor)),format.raw/*3.110*/("""</th>
</thead>
<thead>
	<th>N° OP</th>
	<th>FECHA EXP.</th>
	<th>N° EXP.</th>
	<th>PROVEEDOR</th>
	<th>DEUDA</th>
	<th>COMPROMISO</th>
	<th>RUBRO</th>
	<th>DETALLE</th>
</thead>
"""))}
    }
    
    def render(cuenta:String,institucion:String,proveedor:String): play.api.templates.HtmlFormat.Appendable = apply(cuenta,institucion,proveedor)
    
    def f:((String,String,String) => play.api.templates.HtmlFormat.Appendable) = (cuenta,institucion,proveedor) => apply(cuenta,institucion,proveedor)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:56 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/deudasGlobalizadas/tablaDetalles.scala.html
                    HASH: 4c0c073ba8283ae7c64e6a81443f6d0b6b2f9fd9
                    MATRIX: 825->1|970->52|1089->136|1116->142|1155->146|1187->157|1227->161|1258->170
                    LINES: 26->1|29->1|31->3|31->3|31->3|31->3|31->3|31->3
                    -- GENERATED --
                */
            