
package views.html.compras.proveedores

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
object contenidoTabDatosDgr extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Boolean,Form[Proveedor],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formularioCarga: Boolean, provForm: Form[Proveedor] = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import java.util.List


Seq[Any](format.raw/*1.62*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/if(provForm.field("id").value == null || provForm.field("id").value == "")/*4.76*/{_display_(Seq[Any](format.raw/*4.77*/("""
	<p><i class="glyphicon glyphicon-info-sign"></i> Para cargar datos dgr primero debe guardar el proveedor</p>
""")))}/*6.3*/else/*6.8*/{_display_(Seq[Any](format.raw/*6.9*/("""
	"""),_display_(Seq[Any](/*7.3*/if(provForm.field("cuit").value != null && provForm.field("cuit").value != "")/*7.81*/{_display_(Seq[Any](format.raw/*7.82*/("""
		<script>
			$( function ()"""),format.raw/*9.18*/("""{"""),format.raw/*9.19*/("""
				
				$.get('"""),_display_(Seq[Any](/*11.13*/controllers/*11.24*/.compras.routes.ProveedorDatosDgrController.index(provForm.field("cuit").value.toLong, formularioCarga))),format.raw/*11.127*/("""', function(data)"""),format.raw/*11.144*/("""{"""),format.raw/*11.145*/("""
					$('#listaDatosDgr').parent().html(data);
				"""),format.raw/*13.5*/("""}"""),format.raw/*13.6*/(""")
			"""),format.raw/*14.4*/("""}"""),format.raw/*14.5*/(""");
		</script>
	""")))})),format.raw/*16.3*/("""
""")))})),format.raw/*17.2*/("""

<div id="listaDatosDgr">

</div>"""))}
    }
    
    def render(formularioCarga:Boolean,provForm:Form[Proveedor]): play.api.templates.HtmlFormat.Appendable = apply(formularioCarga,provForm)
    
    def f:((Boolean,Form[Proveedor]) => play.api.templates.HtmlFormat.Appendable) = (formularioCarga,provForm) => apply(formularioCarga,provForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:46 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/proveedores/contenidoTabDatosDgr.scala.html
                    HASH: 3e5e90a0ad718f3f79b5e9be4759ea3979582c9e
                    MATRIX: 826->1|1002->61|1029->85|1065->87|1147->161|1185->162|1314->275|1325->280|1362->281|1399->284|1485->362|1523->363|1579->392|1607->393|1661->411|1681->422|1807->525|1853->542|1883->543|1961->594|1989->595|2021->600|2049->601|2097->618|2130->620
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|34->6|34->6|34->6|35->7|35->7|35->7|37->9|37->9|39->11|39->11|39->11|39->11|39->11|41->13|41->13|42->14|42->14|44->16|45->17
                    -- GENERATED --
                */
            