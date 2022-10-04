
package views.html.patrimonio.baul.lineas

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
object lineasProductoBaul extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[RemitoLineaBaul,Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea:  RemitoLineaBaul, editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import models.auth._


Seq[Any](format.raw/*1.46*/("""
"""),format.raw/*3.1*/("""<tr>
"""),_display_(Seq[Any](/*4.2*/if(editable)/*4.14*/{_display_(Seq[Any](format.raw/*4.15*/("""
	<td class="accion-editar"><a class="btn btn-default btn-xs modificarProducto" href=""""),_display_(Seq[Any](/*5.87*/controllers/*5.98*/.patrimonio.routes.RemitosLineasBaulController.editar(linea.id))),format.raw/*5.161*/(""""><i class="glyphicon glyphicon-edit"></i></a></td>
""")))})),format.raw/*6.2*/("""
<td>"""),_display_(Seq[Any](/*7.6*/linea/*7.11*/.producto.nombre)),format.raw/*7.27*/("""</td>
<td>"""),_display_(Seq[Any](/*8.6*/linea/*8.11*/.cantidad)),format.raw/*8.20*/("""</td>
"""),_display_(Seq[Any](/*9.2*/if(editable)/*9.14*/{_display_(Seq[Any](format.raw/*9.15*/("""
	<td>
		<a class="btn btn-default btn-xs eliminarProducto" href=""""),_display_(Seq[Any](/*11.61*/controllers/*11.72*/.patrimonio.routes.RemitosLineasBaulController.eliminar(linea.id))),format.raw/*11.137*/(""""><i class="glyphicon glyphicon-trash icono-eliminar"></i></a>
	</td>
""")))})),format.raw/*13.2*/("""
</tr>"""))}
    }
    
    def render(linea:RemitoLineaBaul,editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(linea,editable)
    
    def f:((RemitoLineaBaul,Boolean) => play.api.templates.HtmlFormat.Appendable) = (linea,editable) => apply(linea,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/baul/lineas/lineasProductoBaul.scala.html
                    HASH: 9b1c3048fc8fa5b7917cbe58cf5f540640355e12
                    MATRIX: 827->1|987->45|1015->70|1056->77|1076->89|1114->90|1237->178|1256->189|1341->252|1425->306|1466->313|1479->318|1516->334|1562->346|1575->351|1605->360|1647->368|1667->380|1705->381|1810->450|1830->461|1918->526|2022->599
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|33->5|33->5|33->5|34->6|35->7|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|39->11|39->11|39->11|41->13
                    -- GENERATED --
                */
            