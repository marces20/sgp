
package views.html.compras.productos

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
object verProducto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Producto,utils.pagination.PaginadorFicha,List[Integer],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(producto: Producto, paginadorFicha: utils.pagination.PaginadorFicha,productoDepositoArray:List[Integer] = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import utils._


Seq[Any](format.raw/*1.114*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/paginadorFicha/*4.16*/.setActual(producto.id.toString))),format.raw/*4.48*/("""
"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.compras.mainCompras("Producto")/*5.44*/ {_display_(Seq[Any](format.raw/*5.46*/("""
	<div class="page-header">
		<div class="row">
			<div class="col-sm-3">
				<h1>Vista de Producto</h1>
			</div>

		</div>
	</div>
	
	"""),_display_(Seq[Any](/*15.3*/if(flash.containsKey("error"))/*15.33*/ {_display_(Seq[Any](format.raw/*15.35*/("""
	<div class="alert alert-danger">
		"""),_display_(Seq[Any](/*17.4*/flash/*17.9*/.get("error"))),format.raw/*17.22*/("""
	</div>
	""")))})),format.raw/*19.3*/("""
	
<div class="row menu-acciones">
	<div class="col-sm-9">
		<a href=""""),_display_(Seq[Any](/*23.13*/controllers/*23.24*/.compras.routes.ProductosController.crearProducto())),_display_(Seq[Any](/*23.76*/UriTrack/*23.84*/.get("?"))),format.raw/*23.93*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo</a>
		<a href=""""),_display_(Seq[Any](/*24.13*/controllers/*24.24*/.compras.routes.ProductosController.editarProducto(producto.id))),_display_(Seq[Any](/*24.88*/UriTrack/*24.96*/.get("&"))),format.raw/*24.105*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-edit"></i> Editar</a>
		<a href=""""),_display_(Seq[Any](/*25.13*/controllers/*25.24*/.compras.routes.ProductosController.eliminarProducto(producto.id))),_display_(Seq[Any](/*25.90*/UriTrack/*25.98*/.get("&"))),format.raw/*25.107*/(""""  class="btn btn-default delete-confirm-link"><i class="glyphicon glyphicon-trash icono-eliminar"></i> Eliminar</a>
	</div>
	<div class="col-sm-3">
		<a href=""""),_display_(Seq[Any](/*28.13*/UriTrack/*28.21*/.getOnNull(controllers.compras.routes.ProductosController.indexProducto().absoluteURL()))),format.raw/*28.109*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a>
		
		"""),_display_(Seq[Any](/*30.4*/if(paginadorFicha.getLista().size() > 1)/*30.44*/{_display_(Seq[Any](format.raw/*30.45*/("""

		<div class="btn-group">
			"""),_display_(Seq[Any](/*33.5*/if(paginadorFicha.hasPrev())/*33.33*/ {_display_(Seq[Any](format.raw/*33.35*/("""
				<a  role="group" href=""""),_display_(Seq[Any](/*34.29*/controllers/*34.40*/.compras.routes.ProductosController.ver(paginadorFicha.prev().toLong))),_display_(Seq[Any](/*34.110*/UriTrack/*34.118*/.get("&"))),format.raw/*34.127*/("""" class="btn btn-default"><i class="glyphicon glyphicon-chevron-left"></i></a>
			""")))})),format.raw/*35.5*/("""
			<p style="padding-top: 3px" href=""  role="group" class="btn btn-default">"""),_display_(Seq[Any](/*36.79*/paginadorFicha/*36.93*/.posicionActual())),format.raw/*36.110*/(""" de """),_display_(Seq[Any](/*36.115*/paginadorFicha/*36.129*/.getLista().size())),format.raw/*36.147*/("""</p>
			"""),_display_(Seq[Any](/*37.5*/if(paginadorFicha.hasNext())/*37.33*/ {_display_(Seq[Any](format.raw/*37.35*/("""
				<a  role="group" href=""""),_display_(Seq[Any](/*38.29*/controllers/*38.40*/.compras.routes.ProductosController.ver(paginadorFicha.next().toLong))),_display_(Seq[Any](/*38.110*/UriTrack/*38.118*/.get("&"))),format.raw/*38.127*/("""" class="btn btn-default"><i class="glyphicon glyphicon-chevron-right"></i></a>
			""")))})),format.raw/*39.5*/("""  
		</div>
		""")))})),format.raw/*41.4*/("""
		
	</div>
</div>
	
	
	<div class="row">
		<div class="col-sm-9">
			<div class="form-group">
				<label for="inputNombre" class="control-label">Nombre</label> 
				<input value=""""),_display_(Seq[Any](/*51.20*/producto/*51.28*/.nombre)),format.raw/*51.35*/("""" class="form-control" disabled /> 
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-3">
			<div class="form-group">
				<label for="inputReferencia" class="control-label">Referencia</label> 
				<input value=""""),_display_(Seq[Any](/*59.20*/producto/*59.28*/.referencia)),format.raw/*59.39*/("""" class="form-control" disabled /> 
			</div>
		</div>
		<div class="col-sm-3">
			<div class="form-group">
				<label for="inputCodigoRismi" class="control-label">Codigo Rismi</label>
				<input value=""""),_display_(Seq[Any](/*65.20*/producto/*65.28*/.codigo_rismi)),format.raw/*65.41*/("""" class="form-control" disabled />
			</div>
		</div>
		<div class="col-sm-3">
			<div class="form-group">
				<label for="inputCodigoIps" class="control-label">Codigo IPS</label>
				<input value=""""),_display_(Seq[Any](/*71.20*/producto/*71.28*/.codigo_ips)),format.raw/*71.39*/("""" class="form-control" disabled />
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-3">
			<div class="form-group">
				<label for="inputCategoria" class="control-label">Categor&iacute;a</label> 
				<input value=""""),_display_(Seq[Any](/*79.20*/producto/*79.28*/.categoria.nombre)),format.raw/*79.45*/("""" class="form-control" disabled />
			</div>
		</div>
		<div class="col-sm-3">
			<div class="form-group">
				<label for="inputTipoProducto" class="control-label">Tipo Producto</label> 
				<input value=""""),_display_(Seq[Any](/*85.20*/producto/*85.28*/.tipo_producto.nombre)),format.raw/*85.49*/("""" class="form-control" disabled />
			</div>
		</div>
		<div class="col-sm-3">
			<div class="form-group">
				<label for="inputUdm" class="control-label">Udm</label>
				<input value=""""),_display_(Seq[Any](/*91.20*/if(producto.udm != null)/*91.44*/{_display_(Seq[Any](format.raw/*91.45*/("""producto.udm.nombre""")))})),format.raw/*91.65*/("""" class="form-control" disabled />
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-3">
			<div class="form-group">
				<label for="inputPrecioCoste" class="control-label">Precio Coste</label> 
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*99.50*/utils/*99.55*/.NumberUtils.moneda(producto.precio_coste))),format.raw/*99.97*/("""</p>
			</div>
		</div>
		 <div class="col-sm-3">
			<div class="form-group">
				<label for="inputCuentaIngresos" class="control-label">Cuenta de Ingresos</label>
				<input value=""""),_display_(Seq[Any](/*105.20*/if(producto.cuenta_ingreso != null)/*105.55*/{_display_(Seq[Any](_display_(Seq[Any](/*105.57*/producto/*105.65*/.cuenta_ingreso.nombre))))})),format.raw/*105.88*/("""" class="form-control" disabled />
			</div>
		</div>
		<div class="col-sm-3">
			<div class="form-group">
				<label for="inputCuentaGastos" class="control-label">Cuenta de gastos</label> 
				<input value=""""),_display_(Seq[Any](/*111.20*/if(producto.cuenta_gasto != null)/*111.53*/{_display_(Seq[Any](_display_(Seq[Any](/*111.55*/producto/*111.63*/.cuenta_gasto.nombre))))})),format.raw/*111.84*/("""" class="form-control" disabled />
			</div>
		</div>
	</div> 
	<div class="row">
		
		<div class="col-sm-6">
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th width="50">#</th>
						<th width="100">Deposito</th>
					
					</tr>
				</thead>
				<tbody>
					"""),_display_(Seq[Any](/*127.7*/for( d <- Deposito.find.all()) yield /*127.37*/{_display_(Seq[Any](format.raw/*127.38*/("""
						
						<tr>
							<td>
								<input type="checkbox" class="permiso" name="productoDeposito[]" 
								"""),_display_(Seq[Any](/*132.10*/if(productoDepositoArray != null)/*132.43*/{_display_(Seq[Any](format.raw/*132.44*/(""" 
								"""),_display_(Seq[Any](/*133.10*/if(productoDepositoArray.contains(d.id.intValue()))/*133.61*/ {_display_(Seq[Any](format.raw/*133.63*/("""checked""")))}))))})),format.raw/*133.72*/(""" 
								value=""""),_display_(Seq[Any](/*134.17*/d/*134.18*/.id)),format.raw/*134.21*/("""" disabled />
								
							</td>
							<td>"""),_display_(Seq[Any](/*137.13*/d/*137.14*/.nombre)),format.raw/*137.21*/("""</td>
						</tr>
					""")))})),format.raw/*139.7*/("""
				</tbody>	
			</table>
		</div>
		 
	</div>
	

""")))})))}
    }
    
    def render(producto:Producto,paginadorFicha:utils.pagination.PaginadorFicha,productoDepositoArray:List[Integer]): play.api.templates.HtmlFormat.Appendable = apply(producto,paginadorFicha,productoDepositoArray)
    
    def f:((Producto,utils.pagination.PaginadorFicha,List[Integer]) => play.api.templates.HtmlFormat.Appendable) = (producto,paginadorFicha,productoDepositoArray) => apply(producto,paginadorFicha,productoDepositoArray)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:45 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/productos/verProducto.scala.html
                    HASH: 21e99e38d4fc6267f4bb145df71d3e31f797a0f2
                    MATRIX: 846->1|1069->113|1097->132|1134->135|1156->149|1209->181|1246->184|1258->189|1303->226|1342->228|1524->375|1563->405|1603->407|1678->447|1691->452|1726->465|1770->478|1881->553|1901->564|1983->616|2000->624|2031->633|2163->729|2183->740|2277->804|2294->812|2326->821|2454->913|2474->924|2570->990|2587->998|2619->1007|2819->1171|2836->1179|2947->1267|3061->1346|3110->1386|3149->1387|3219->1422|3256->1450|3296->1452|3362->1482|3382->1493|3483->1563|3501->1571|3533->1580|3648->1664|3764->1744|3787->1758|3827->1775|3869->1780|3893->1794|3934->1812|3979->1822|4016->1850|4056->1852|4122->1882|4142->1893|4243->1963|4261->1971|4293->1980|4409->2065|4457->2082|4684->2273|4701->2281|4730->2288|5003->2525|5020->2533|5053->2544|5299->2754|5316->2762|5351->2775|5592->2980|5609->2988|5642->2999|5919->3240|5936->3248|5975->3265|6223->3477|6240->3485|6283->3506|6511->3698|6544->3722|6583->3723|6635->3743|6940->4012|6954->4017|7018->4059|7244->4248|7289->4283|7338->4285|7356->4293|7406->4316|7658->4531|7701->4564|7750->4566|7768->4574|7816->4595|8166->4909|8213->4939|8253->4940|8409->5059|8452->5092|8492->5093|8541->5105|8602->5156|8643->5158|8689->5167|8745->5186|8756->5187|8782->5190|8870->5241|8881->5242|8911->5249|8969->5275
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|33->5|33->5|33->5|33->5|43->15|43->15|43->15|45->17|45->17|45->17|47->19|51->23|51->23|51->23|51->23|51->23|52->24|52->24|52->24|52->24|52->24|53->25|53->25|53->25|53->25|53->25|56->28|56->28|56->28|58->30|58->30|58->30|61->33|61->33|61->33|62->34|62->34|62->34|62->34|62->34|63->35|64->36|64->36|64->36|64->36|64->36|64->36|65->37|65->37|65->37|66->38|66->38|66->38|66->38|66->38|67->39|69->41|79->51|79->51|79->51|87->59|87->59|87->59|93->65|93->65|93->65|99->71|99->71|99->71|107->79|107->79|107->79|113->85|113->85|113->85|119->91|119->91|119->91|119->91|127->99|127->99|127->99|133->105|133->105|133->105|133->105|133->105|139->111|139->111|139->111|139->111|139->111|155->127|155->127|155->127|160->132|160->132|160->132|161->133|161->133|161->133|161->133|162->134|162->134|162->134|165->137|165->137|165->137|167->139
                    -- GENERATED --
                */
            