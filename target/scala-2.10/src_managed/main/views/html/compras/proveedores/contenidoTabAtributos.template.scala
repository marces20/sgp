
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
object contenidoTabAtributos extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Boolean,Form[Proveedor],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formularioCarga: Boolean, provForm: Form[Proveedor] = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import java.util.List


Seq[Any](format.raw/*1.62*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/if(provForm.field("id").value == null || provForm.field("id").value == "")/*4.76*/{_display_(Seq[Any](format.raw/*4.77*/("""
	<p><i class="glyphicon glyphicon-info-sign"></i> Para cargar atributos primero debe guardar el proveedor</p>
""")))}/*6.3*/else/*6.8*/{_display_(Seq[Any](format.raw/*6.9*/("""
	<script>
		$( function ()"""),format.raw/*8.17*/("""{"""),format.raw/*8.18*/("""
			$.get('"""),_display_(Seq[Any](/*9.12*/controllers/*9.23*/.compras.routes.ProveedorAtributosController.index(provForm.field("id").value.toLong, formularioCarga))),format.raw/*9.125*/("""', function(data)"""),format.raw/*9.142*/("""{"""),format.raw/*9.143*/("""
				$('#listaAtributos').parent().html(data);
			"""),format.raw/*11.4*/("""}"""),format.raw/*11.5*/(""")
		"""),format.raw/*12.3*/("""}"""),format.raw/*12.4*/(""");
	</script>
""")))})),format.raw/*14.2*/("""

<div id="listaAtributos">

</div>"""))}
    }
    
    def render(formularioCarga:Boolean,provForm:Form[Proveedor]): play.api.templates.HtmlFormat.Appendable = apply(formularioCarga,provForm)
    
    def f:((Boolean,Form[Proveedor]) => play.api.templates.HtmlFormat.Appendable) = (formularioCarga,provForm) => apply(formularioCarga,provForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:46 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/proveedores/contenidoTabAtributos.scala.html
                    HASH: 1c3ce734340a6beeb0ead4c041433d6a2782b911
                    MATRIX: 827->1|1003->61|1030->85|1066->87|1148->161|1186->162|1315->275|1326->280|1363->281|1417->308|1445->309|1492->321|1511->332|1635->434|1680->451|1709->452|1786->502|1814->503|1845->507|1873->508|1919->523
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|34->6|34->6|34->6|36->8|36->8|37->9|37->9|37->9|37->9|37->9|39->11|39->11|40->12|40->12|42->14
                    -- GENERATED --
                */
            