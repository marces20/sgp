
package views.html.compras.ordenes

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
object contenidoTabProducto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Boolean,Form[Orden],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formularioCarga: Boolean, ordenForm: Form[Orden] = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import java.util.List


Seq[Any](format.raw/*1.59*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/if(ordenForm.field("id").value == null || ordenForm.field("id").value == "")/*4.78*/{_display_(Seq[Any](format.raw/*4.79*/("""
	<p>Para cargar productos primero debe dar de alta la Orden</p>
""")))}/*6.3*/else/*6.8*/{_display_(Seq[Any](format.raw/*6.9*/("""
	<script>
		$( function ()"""),format.raw/*8.17*/("""{"""),format.raw/*8.18*/("""
			$.get('"""),_display_(Seq[Any](/*9.12*/controllers/*9.23*/.compras.routes.LineasOrdenesController.index(ordenForm.field("id").value.toLong, formularioCarga))),format.raw/*9.121*/("""', function(data)"""),format.raw/*9.138*/("""{"""),format.raw/*9.139*/("""
				$('#listaLineaProductos').parent().html(data);
			"""),format.raw/*11.4*/("""}"""),format.raw/*11.5*/(""")
		"""),format.raw/*12.3*/("""}"""),format.raw/*12.4*/(""");
	</script>
""")))})),format.raw/*14.2*/("""

<div id="listaLineaProductos">

</div>
"""))}
    }
    
    def render(formularioCarga:Boolean,ordenForm:Form[Orden]): play.api.templates.HtmlFormat.Appendable = apply(formularioCarga,ordenForm)
    
    def f:((Boolean,Form[Orden]) => play.api.templates.HtmlFormat.Appendable) = (formularioCarga,ordenForm) => apply(formularioCarga,ordenForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:43 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/ordenes/contenidoTabProducto.scala.html
                    HASH: ca4cb72364e608f152b5f78f310769722fcadf07
                    MATRIX: 818->1|992->58|1020->84|1057->87|1141->163|1179->164|1264->233|1275->238|1312->239|1368->268|1396->269|1444->282|1463->293|1583->391|1628->408|1657->409|1741->466|1769->467|1801->472|1829->473|1877->490
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|34->6|34->6|34->6|36->8|36->8|37->9|37->9|37->9|37->9|37->9|39->11|39->11|40->12|40->12|42->14
                    -- GENERATED --
                */
            