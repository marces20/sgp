
package views.html.patrimonio.ordenesProvision

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
object productosRecepcionados extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Long,utils.pagination.Pagination[OrdenProvisionLineas],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(orden_provision_id: Long, buscador: utils.pagination.Pagination[OrdenProvisionLineas]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import models.auth._

import utils._


Seq[Any](format.raw/*1.89*/("""
"""),format.raw/*5.1*/("""

<div class="contenedorPaginador ajaxPaginador">

	"""),_display_(Seq[Any](/*9.3*/if(buscador.getTotalRowCount == 0)/*9.37*/ {_display_(Seq[Any](format.raw/*9.39*/("""
       <div class="well">
           <em>No se encuentran resultados</em>
       </div>
       
   """)))}/*14.6*/else/*14.11*/{_display_(Seq[Any](format.raw/*14.12*/("""
   	Mostrando """),_display_(Seq[Any](/*15.16*/buscador/*15.24*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*15.56*/(""" resultado(s). 
   
	<table class="table table-striped table-bordered table-hover" style="margin-top: 20px">
		<thead>
			<tr>
				<th>Producto</th>
				<th>Precio</th>
				<th width="100">Solicitado</th>
				<th width="50">Udm</th>
				<th width="100">Recepcionado</th>
				<th width="100">Pendiente</th>
			</tr>
		</thead>
		<tbody>
		"""),_display_(Seq[Any](/*29.4*/for(o <- buscador.getList) yield /*29.30*/ {_display_(Seq[Any](format.raw/*29.32*/("""
			<tr>
				<td>"""),_display_(Seq[Any](/*31.10*/o/*31.11*/.producto.nombre)),format.raw/*31.27*/("""</td>
				<td>"""),_display_(Seq[Any](/*32.10*/utils/*32.15*/.NumberUtils.moneda(o.precio))),format.raw/*32.44*/("""</td>
				<td>"""),_display_(Seq[Any](/*33.10*/o/*33.11*/.cantidad)),format.raw/*33.20*/("""</td>
				<td>"""),_display_(Seq[Any](/*34.10*/o/*34.11*/.udm)),format.raw/*34.15*/("""</td>
				<td>"""),_display_(Seq[Any](/*35.10*/o/*35.11*/.getRecepcionado())),format.raw/*35.29*/("""</td>
				<td>"""),_display_(Seq[Any](/*36.10*/o/*36.11*/.getPendiente())),format.raw/*36.26*/("""</td>
			</tr>
		""")))})),format.raw/*38.4*/("""
		</tbody>
	</table>
	<div class="pagination pull-right">
	    """),_display_(Seq[Any](/*42.7*/views/*42.12*/.html.helpers.paginador(buscador, controllers.patrimonio.routes.OrdenesProvisionController.productosRecepcionados()))),format.raw/*42.128*/("""
	</div>
   """)))})),format.raw/*44.5*/("""
		   
</div>"""))}
    }
    
    def render(orden_provision_id:Long,buscador:utils.pagination.Pagination[OrdenProvisionLineas]): play.api.templates.HtmlFormat.Appendable = apply(orden_provision_id,buscador)
    
    def f:((Long,utils.pagination.Pagination[OrdenProvisionLineas]) => play.api.templates.HtmlFormat.Appendable) = (orden_provision_id,buscador) => apply(orden_provision_id,buscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/ordenesProvision/productosRecepcionados.scala.html
                    HASH: ff607ceea048d46b14adffa9e8e2d5494a62f767
                    MATRIX: 867->1|1105->88|1133->148|1224->205|1266->239|1305->241|1429->348|1442->353|1481->354|1534->371|1551->379|1605->411|1993->764|2035->790|2075->792|2131->812|2141->813|2179->829|2231->845|2245->850|2296->879|2348->895|2358->896|2389->905|2441->921|2451->922|2477->926|2529->942|2539->943|2579->961|2631->977|2641->978|2678->993|2729->1013|2833->1082|2847->1087|2986->1203|3032->1218
                    LINES: 26->1|34->1|35->5|39->9|39->9|39->9|44->14|44->14|44->14|45->15|45->15|45->15|59->29|59->29|59->29|61->31|61->31|61->31|62->32|62->32|62->32|63->33|63->33|63->33|64->34|64->34|64->34|65->35|65->35|65->35|66->36|66->36|66->36|68->38|72->42|72->42|72->42|74->44
                    -- GENERATED --
                */
            