
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
object resultadoPagarInterbankingProveedores extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[MiPago,play.api.templates.HtmlFormat.Appendable] {

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
		<a href=""""),_display_(Seq[Any](/*10.13*/controllers/*10.24*/.contabilidad.routes.PagosAccionesController.descargarArchivoInterbankingProveedores(mipago.id))),format.raw/*10.119*/("""" id="descarga">Descargar archivo INTERBANKING PROVEEDORES</a> 
		
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
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/pagos/acciones/resultadoPagarInterbankingProveedores.scala.html
                    HASH: df8620844b8e5a6503025702e73dc810f7ca6d95
                    MATRIX: 834->1|944->17|981->20|1021->52|1060->54|1177->136|1190->141|1227->156|1265->164|1422->285|1442->296|1560->391|1678->474|1693->481
                    LINES: 26->1|29->1|31->3|31->3|31->3|32->4|32->4|32->4|33->5|38->10|38->10|38->10|42->14|42->14
                    -- GENERATED --
                */
            