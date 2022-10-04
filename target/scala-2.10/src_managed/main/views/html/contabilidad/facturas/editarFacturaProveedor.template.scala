
package views.html.contabilidad.facturas

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
object editarFacturaProveedor extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[Factura],Factura,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(facturaForm: Form[Factura], factura: Factura):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};def /*5.2*/getClassEstadoEditable/*5.24*/(i:String) = {{
	var isEditable:Boolean = new Boolean(false)
	
	
	if(i == null || (i.compareTo("18") == 0) ){
		isEditable = new Boolean(true)
	}
	
	isEditable
}};def /*15.2*/getClassEstadoEditableParaImpuestos/*15.37*/(i:String) = {{
	var isEditable:Boolean = new Boolean(false)
	
	
	if(i == null || (i.compareTo("60") == 0) ){
		isEditable = new Boolean(true)
	}
	
	isEditable
}};
Seq[Any](format.raw/*1.48*/("""
"""),format.raw/*4.70*/("""
"""),format.raw/*14.2*/("""
"""),format.raw/*24.2*/("""

"""),_display_(Seq[Any](/*26.2*/views/*26.7*/.html.contabilidad.mainContabilidad("Modificar Factura")/*26.63*/ {_display_(Seq[Any](format.raw/*26.65*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Editar factura</h1>
			</div>
			<div class="col-sm-5">
				<div class="dropdown pull-right">
				 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 	<i class="glyphicon glyphicon-list-alt"></i>
				    Reportes
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				  </ul>
				</div>
				<div class="dropdown pull-right btn-header">
				 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 	<i class="glyphicon glyphicon-cog"></i>
				    Acciones
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				  	
				  </ul>
				</div>
				<div class="pull-right btn-header">
					<a href=""""),_display_(Seq[Any](/*54.16*/controllers/*54.27*/.contabilidad.routes.FacturasController.crear())),_display_(Seq[Any](/*54.75*/UriTrack/*54.83*/.get("?"))),format.raw/*54.92*/(""""  class="btn btn-default pull-right"><i class="glyphicon glyphicon-plus-sign"></i> Nueva Factura</a>
				</div>
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*60.3*/views/*60.8*/.html.tags.successError())),format.raw/*60.33*/("""
	
	"""),_display_(Seq[Any](/*62.3*/helper/*62.9*/.form(action = controllers.contabilidad.routes.FacturasController.actualizar(factura.id) )/*62.99*/ {_display_(Seq[Any](format.raw/*62.101*/("""
	
		"""),_display_(Seq[Any](/*64.4*/inputText(facturaForm("id"), 'hidden -> "hidden"))),format.raw/*64.53*/("""
		"""),_display_(Seq[Any](/*65.4*/views/*65.9*/.html.contabilidad.facturas.formFacturaProveedor(facturaForm))),format.raw/*65.70*/("""
		"""),_display_(Seq[Any](/*66.4*/views/*66.9*/.html.contabilidad.facturas.tabsFactura(getClassEstadoEditable(factura.estado.id.toString),getClassEstadoEditableParaImpuestos(factura.estado.id.toString),facturaForm,factura))),format.raw/*66.184*/("""

	""")))})),format.raw/*68.3*/("""

""")))})))}
    }
    
    def render(facturaForm:Form[Factura],factura:Factura): play.api.templates.HtmlFormat.Appendable = apply(facturaForm,factura)
    
    def f:((Form[Factura],Factura) => play.api.templates.HtmlFormat.Appendable) = (facturaForm,factura) => apply(facturaForm,factura)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:40 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/facturas/editarFacturaProveedor.scala.html
                    HASH: 38b9f195957087718c48ef1c9eb9c9f9eefca790
                    MATRIX: 828->1|992->82|1024->106|1081->152|1111->174|1286->337|1330->372|1521->47|1549->150|1577->335|1605->533|1643->536|1656->541|1721->597|1761->599|2741->1543|2761->1554|2839->1602|2856->1610|2887->1619|3066->1763|3079->1768|3126->1793|3166->1798|3180->1804|3279->1894|3320->1896|3361->1902|3432->1951|3471->1955|3484->1960|3567->2021|3606->2025|3619->2030|3817->2205|3852->2209
                    LINES: 26->1|31->4|31->4|31->5|31->5|40->15|40->15|50->1|51->4|52->14|53->24|55->26|55->26|55->26|55->26|83->54|83->54|83->54|83->54|83->54|89->60|89->60|89->60|91->62|91->62|91->62|91->62|93->64|93->64|94->65|94->65|94->65|95->66|95->66|95->66|97->68
                    -- GENERATED --
                */
            