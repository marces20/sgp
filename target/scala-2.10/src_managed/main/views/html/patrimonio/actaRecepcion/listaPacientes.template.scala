
package views.html.patrimonio.actaRecepcion

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
object listaPacientes extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Map[Integer, Map[String, String]],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(p:Map[Integer,Map[String,String]]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.37*/("""
"""),format.raw/*3.1*/("""<table id="listaProdutosActas" class="table table-striped table-bordered table-hover">
	<thead>
		<tr>
			<th>Producto</th>
			<th>Cantidad</th>
			<th>Paciente</th>
			<th>Referencia</th>	
		</tr>
	</thead>
	<tbody>
        """),_display_(Seq[Any](/*13.10*/for((key,value) <- p) yield /*13.31*/ {_display_(Seq[Any](format.raw/*13.33*/("""
        	<tr class="pointer">
				<td>"""),_display_(Seq[Any](/*15.10*/value/*15.15*/.get("producto"))),format.raw/*15.31*/("""</td>
				<td>"""),_display_(Seq[Any](/*16.10*/value/*16.15*/.get("cantidad"))),format.raw/*16.31*/("""</td>
				<td>"""),_display_(Seq[Any](/*17.10*/value/*17.15*/.get("nombre"))),format.raw/*17.29*/("""</td>
				<td>"""),_display_(Seq[Any](/*18.10*/if(value.get("referencia") != null)/*18.45*/{_display_(Seq[Any](_display_(Seq[Any](/*18.47*/value/*18.52*/.get("referencia")))))})),format.raw/*18.71*/("""</td>
			</tr>
			 
        """)))})),format.raw/*21.10*/("""
	</tbody>
</table>"""))}
    }
    
    def render(p:Map[Integer, Map[String, String]]): play.api.templates.HtmlFormat.Appendable = apply(p)
    
    def f:((Map[Integer, Map[String, String]]) => play.api.templates.HtmlFormat.Appendable) = (p) => apply(p)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/actaRecepcion/listaPacientes.scala.html
                    HASH: 2002e8017b8f3de19d2f4a4fc29d3261cb037a06
                    MATRIX: 835->1|980->36|1007->54|1269->280|1306->301|1346->303|1422->343|1436->348|1474->364|1525->379|1539->384|1577->400|1628->415|1642->420|1678->434|1729->449|1773->484|1821->486|1835->491|1880->510|1941->539
                    LINES: 26->1|30->1|31->3|41->13|41->13|41->13|43->15|43->15|43->15|44->16|44->16|44->16|45->17|45->17|45->17|46->18|46->18|46->18|46->18|46->18|49->21
                    -- GENERATED --
                */
            