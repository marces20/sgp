
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
object resultadoPagarInterno extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[MiPago,play.api.templates.HtmlFormat.Appendable] {

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
		<a href=""""),_display_(Seq[Any](/*10.13*/controllers/*10.24*/.contabilidad.routes.PagosAccionesController.descargarOpg(mipago.id))),format.raw/*10.92*/("""" id="descarga">Descargar archivo OPG</a> 
		<br /> 
		<i class="glyphicon glyphicon-save"></i> 
		<a href=""""),_display_(Seq[Any](/*13.13*/controllers/*13.24*/.contabilidad.routes.PagosAccionesController.descargarBnf(mipago.id))),format.raw/*13.92*/("""" id="descarga">Descargar archivo BNF</a>
		<br /> 
		<i class="glyphicon glyphicon-save"></i> 
		<a href=""""),_display_(Seq[Any](/*16.13*/controllers/*16.24*/.contabilidad.routes.PagosReportesController.descargarLotesPago(mipago.id))),format.raw/*16.98*/("""" id="descarga">Descargar archivo LOTE</a>
	</div>
</div>
"""),_display_(Seq[Any](/*19.2*/flash()/*19.9*/.clear())))}
    }
    
    def render(mipago:MiPago): play.api.templates.HtmlFormat.Appendable = apply(mipago)
    
    def f:((MiPago) => play.api.templates.HtmlFormat.Appendable) = (mipago) => apply(mipago)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:38 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/pagos/acciones/resultadoPagarInterno.scala.html
                    HASH: 03030c39f38c857b5fe2346b4d3129699cef9862
                    MATRIX: 818->1|928->17|967->22|1007->54|1046->56|1164->139|1177->144|1214->159|1253->168|1415->294|1435->305|1525->373|1673->485|1693->496|1783->564|1930->675|1950->686|2046->760|2143->822|2158->829
                    LINES: 26->1|29->1|31->3|31->3|31->3|32->4|32->4|32->4|33->5|38->10|38->10|38->10|41->13|41->13|41->13|44->16|44->16|44->16|47->19|47->19
                    -- GENERATED --
                */
            