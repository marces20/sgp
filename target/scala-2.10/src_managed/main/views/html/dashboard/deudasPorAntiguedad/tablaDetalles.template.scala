
package views.html.dashboard.deudasPorAntiguedad

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
	<th>FECHA</th>
	<th>N° EXP.</th>
	<th>PROVEEDOR</th>
	<th>DEUDA</th>
	<th>INSTITUCION</th>
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
                    DATE: Tue Oct 04 11:43:59 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/deudasPorAntiguedad/tablaDetalles.scala.html
                    HASH: c5f2f566949a4ff31c1ec4a6bcac6cfe9cfccf45
                    MATRIX: 826->1|971->52|1090->136|1117->142|1156->146|1188->157|1228->161|1259->170
                    LINES: 26->1|29->1|31->3|31->3|31->3|31->3|31->3|31->3
                    -- GENERATED --
                */
            