
package views.html.contabilidad.pagos.acciones

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
object resultadoPagarEmbargoExterno extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[MiPago,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(mipago: MiPago):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.18*/("""

"""),_display_(Seq[Any](/*3.2*/if(flash.containsKey("success"))/*3.34*/ {_display_(Seq[Any](format.raw/*3.36*/("""
	<div class="alert alert-success"><i class="glyphicon glyphicon-ok-circle"></i> """),_display_(Seq[Any](/*4.82*/flash/*4.87*/.get("success"))),format.raw/*4.102*/("""</div>
""")))})),format.raw/*5.2*/("""	
	
<div class="panel panel-default">	
	<div class="panel-body">
		<i class="glyphicon glyphicon-save"></i> 
		<a href=""""),_display_(Seq[Any](/*10.13*/controllers/*10.24*/.contabilidad.routes.PagosAccionesController.descargarOpgEmbargoExterno(mipago.id))),format.raw/*10.106*/("""" id="descarga">Descargar archivo MACRO SUELDO EXTERNOS</a> 
		
	</div>
</div>
"""),_display_(Seq[Any](/*14.2*/flash()/*14.9*/.clear())))}
    }
    
    def render(mipago:MiPago): play.api.templates.HtmlFormat.Appendable = apply(mipago)
    
    def f:((MiPago) => play.api.templates.HtmlFormat.Appendable) = (mipago) => apply(mipago)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:38 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/pagos/acciones/resultadoPagarEmbargoExterno.scala.html
                    HASH: c9b4a77468a1463a47fe826607511080f7d2c9c4
                    MATRIX: 825->1|935->17|972->20|1012->52|1051->54|1168->136|1181->141|1218->156|1256->164|1413->285|1433->296|1538->378|1653->458|1668->465
                    LINES: 26->1|29->1|31->3|31->3|31->3|32->4|32->4|32->4|33->5|38->10|38->10|38->10|42->14|42->14
                    -- GENERATED --
                */
            