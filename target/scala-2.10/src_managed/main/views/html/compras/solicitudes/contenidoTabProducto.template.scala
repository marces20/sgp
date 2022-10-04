
package views.html.compras.solicitudes

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
object contenidoTabProducto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Boolean,Form[Solicitud],Solicitud,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formularioCarga: Boolean, solicitudForm: Form[Solicitud] = null,solicitud:Solicitud):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import java.util.List


Seq[Any](format.raw/*1.87*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/if(solicitudForm.field("id").value == null || solicitudForm.field("id").value == "")/*4.86*/{_display_(Seq[Any](format.raw/*4.87*/("""
	<p>Para cargar productos primero debe dar de alta la solicitud</p>
""")))}/*6.3*/else/*6.8*/{_display_(Seq[Any](format.raw/*6.9*/("""
	
		<script>
			$( function ()"""),format.raw/*9.18*/("""{"""),format.raw/*9.19*/("""
				$.get('"""),_display_(Seq[Any](/*10.13*/controllers/*10.24*/.compras.routes.LineasSolicitudesController.index(solicitudForm.field("id").value.toLong, formularioCarga,solicitudForm.field("estado_id").value.toLong))),format.raw/*10.176*/("""', function(data)"""),format.raw/*10.193*/("""{"""),format.raw/*10.194*/("""
					$('#listaLineaProductos').parent().html(data);
				"""),format.raw/*12.5*/("""}"""),format.raw/*12.6*/(""")
			"""),format.raw/*13.4*/("""}"""),format.raw/*13.5*/(""");
		</script>
	
""")))})),format.raw/*16.2*/("""

<div id="listaLineaProductos">

</div>
"""))}
    }
    
    def render(formularioCarga:Boolean,solicitudForm:Form[Solicitud],solicitud:Solicitud): play.api.templates.HtmlFormat.Appendable = apply(formularioCarga,solicitudForm,solicitud)
    
    def f:((Boolean,Form[Solicitud],Solicitud) => play.api.templates.HtmlFormat.Appendable) = (formularioCarga,solicitudForm,solicitud) => apply(formularioCarga,solicitudForm,solicitud)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:45 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/solicitudes/contenidoTabProducto.scala.html
                    HASH: de068de4c2b0a03f820d499ea40fb510f90aa0d6
                    MATRIX: 836->1|1038->86|1066->112|1103->115|1195->199|1233->200|1322->273|1333->278|1370->279|1431->313|1459->314|1509->328|1529->339|1704->491|1750->508|1780->509|1866->568|1894->569|1927->575|1955->576|2007->597
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|34->6|34->6|34->6|37->9|37->9|38->10|38->10|38->10|38->10|38->10|40->12|40->12|41->13|41->13|44->16
                    -- GENERATED --
                */
            