
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
object resultadoPagarProveedoresMacroMasivos extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[MiPago,play.api.templates.HtmlFormat.Appendable] {

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
		<a href=""""),_display_(Seq[Any](/*10.13*/controllers/*10.24*/.contabilidad.routes.PagosAccionesController.descargarArchivoBnfMacroMasivos(mipago.id))),format.raw/*10.111*/("""" id="descarga">Descargar archivo BENEFICIARIO MACRO MASIVO</a> 
		
	</div>
</div>	
	
<div class="panel panel-default">	
	<div class="panel-body">
		<i class="glyphicon glyphicon-save"></i> 
		<a href=""""),_display_(Seq[Any](/*18.13*/controllers/*18.24*/.contabilidad.routes.PagosAccionesController.descargarArchivoProveedoresMacroMasivos(mipago.id))),format.raw/*18.119*/("""" id="descarga">Descargar archivo PROVEEDORES MACRO MASIVO</a> 
		
	</div>
</div>

"""),_display_(Seq[Any](/*23.2*/flash()/*23.9*/.clear())))}
    }
    
    def render(mipago:MiPago): play.api.templates.HtmlFormat.Appendable = apply(mipago)
    
    def f:((MiPago) => play.api.templates.HtmlFormat.Appendable) = (mipago) => apply(mipago)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:38 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/pagos/acciones/resultadoPagarProveedoresMacroMasivos.scala.html
                    HASH: a81758e5ca2475a05cba9c63bfdd6886397ee44e
                    MATRIX: 834->1|944->17|981->20|1021->52|1060->54|1177->136|1190->141|1227->156|1265->164|1422->285|1442->296|1552->383|1791->586|1811->597|1929->692|2048->776|2063->783
                    LINES: 26->1|29->1|31->3|31->3|31->3|32->4|32->4|32->4|33->5|38->10|38->10|38->10|46->18|46->18|46->18|51->23|51->23
                    -- GENERATED --
                */
            