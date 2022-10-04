
package views.html.expediente.expediente

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
object contenidoTabDispos extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Long,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(expedienteId:Long = 0):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import java.util.List


Seq[Any](format.raw/*1.25*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/if(expedienteId == 0)/*4.23*/{_display_(Seq[Any](format.raw/*4.24*/("""
	<p>No hay disposiciones</p>
""")))}/*6.3*/else/*6.8*/{_display_(Seq[Any](format.raw/*6.9*/("""
	<script>
	$( function ()"""),format.raw/*8.16*/("""{"""),format.raw/*8.17*/("""
		$.get('"""),_display_(Seq[Any](/*9.11*/controllers/*9.22*/.expediente.routes.DisposController.getDisposPorExpediente(expedienteId))),format.raw/*9.94*/("""', function(data)"""),format.raw/*9.111*/("""{"""),format.raw/*9.112*/("""
			$('#lineasDispos').parent().html(data);
		"""),format.raw/*11.3*/("""}"""),format.raw/*11.4*/(""")
	"""),format.raw/*12.2*/("""}"""),format.raw/*12.3*/(""");
	</script>

""")))})),format.raw/*15.2*/("""

<div id="lineasDispos">

</div>"""))}
    }
    
    def render(expedienteId:Long): play.api.templates.HtmlFormat.Appendable = apply(expedienteId)
    
    def f:((Long) => play.api.templates.HtmlFormat.Appendable) = (expedienteId) => apply(expedienteId)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:36 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/expediente/expediente/contenidoTabDispos.scala.html
                    HASH: 133bf85af624fdb8c7f4a48677b4af26ddffdcac
                    MATRIX: 807->1|946->24|973->48|1009->50|1038->71|1076->72|1124->104|1135->109|1172->110|1225->136|1253->137|1299->148|1318->159|1411->231|1456->248|1485->249|1558->295|1586->296|1616->299|1644->300|1691->316
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|34->6|34->6|34->6|36->8|36->8|37->9|37->9|37->9|37->9|37->9|39->11|39->11|40->12|40->12|43->15
                    -- GENERATED --
                */
            