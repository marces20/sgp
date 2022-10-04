
package views.html.compras

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
object mainCompras extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,Html,Html,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(title: String, scripts: Html = Html(""))(content: Html):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import models.auth._


Seq[Any](format.raw/*1.58*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/main(title: String, scripts)/*4.30*/{_display_(Seq[Any](format.raw/*4.31*/("""
	<div class="row">
		<div class="col-sm-2">
			<div class="menu-contenido">
			
			<ul class="nav nav-pills nav-stacked">
				<li class="titulo">Gestion Compras</li>
				"""),_display_(Seq[Any](/*11.6*/if(Componente.check("solicitudesCompra"))/*11.47*/ {_display_(Seq[Any](format.raw/*11.49*/("""
					<li><a href=""""),_display_(Seq[Any](/*12.20*/controllers/*12.31*/.compras.routes.SolicitudesController.index())),format.raw/*12.76*/("""">Solicitudes de compras</a></li>
				""")))})),format.raw/*13.6*/("""
				"""),_display_(Seq[Any](/*14.6*/if(Componente.check("ordenesCompra"))/*14.43*/ {_display_(Seq[Any](format.raw/*14.45*/("""
					<li><a href=""""),_display_(Seq[Any](/*15.20*/controllers/*15.31*/.compras.routes.OrdenesController.index())),format.raw/*15.72*/("""">Ordenes de compras</a></li>
				""")))})),format.raw/*16.6*/("""
				"""),_display_(Seq[Any](/*17.6*/if(Componente.check("certificacionesCompras"))/*17.52*/ {_display_(Seq[Any](format.raw/*17.54*/("""
					<li><a href=""""),_display_(Seq[Any](/*18.20*/controllers/*18.31*/.compras.routes.CertificacionesComprasController.index())),format.raw/*18.87*/("""">Certificaciones Compras</a></li>
				""")))})),format.raw/*19.6*/("""
				"""),_display_(Seq[Any](/*20.6*/if(Componente.check("certificacionesObras"))/*20.50*/ {_display_(Seq[Any](format.raw/*20.52*/("""
					<li><a href=""""),_display_(Seq[Any](/*21.20*/controllers/*21.31*/.compras.routes.CertificacionesObrasController.index())),format.raw/*21.85*/("""">Certificaciones Obras</a></li>
				""")))})),format.raw/*22.6*/("""
				"""),_display_(Seq[Any](/*23.6*/if(Componente.check("certificaciones"))/*23.45*/ {_display_(Seq[Any](format.raw/*23.47*/("""
					<li><a href=""""),_display_(Seq[Any](/*24.20*/controllers/*24.31*/.compras.routes.CertificacionesController.index())),format.raw/*24.80*/("""">Certificaciones Personal</a></li>
				""")))})),format.raw/*25.6*/("""
				"""),_display_(Seq[Any](/*26.6*/if(Componente.check("pedidosFondos"))/*26.43*/ {_display_(Seq[Any](format.raw/*26.45*/("""
					<li><a href=""""),_display_(Seq[Any](/*27.20*/controllers/*27.31*/.compras.routes.PedidosFondosController.index())),format.raw/*27.78*/("""">Pedidos de Fondos</a></li>
				""")))})),format.raw/*28.6*/("""
				"""),_display_(Seq[Any](/*29.6*/if(Componente.check("cajaChica"))/*29.39*/ {_display_(Seq[Any](format.raw/*29.41*/("""
					<li><a href=""""),_display_(Seq[Any](/*30.20*/controllers/*30.31*/.compras.routes.CajaChicaController.index())),format.raw/*30.74*/("""">Caja Chica</a></li>
				""")))})),format.raw/*31.6*/("""
				<li class="titulo">Productos</li>
				"""),_display_(Seq[Any](/*33.6*/if(Componente.check("productos"))/*33.39*/ {_display_(Seq[Any](format.raw/*33.41*/("""
					<li><a href=""""),_display_(Seq[Any](/*34.20*/controllers/*34.31*/.compras.routes.ProductosController.indexProducto())),format.raw/*34.82*/("""">Productos</a></li>
				""")))})),format.raw/*35.6*/("""
				"""),_display_(Seq[Any](/*36.6*/if(Componente.check("productosCategoria"))/*36.48*/ {_display_(Seq[Any](format.raw/*36.50*/("""
					<li><a href=""""),_display_(Seq[Any](/*37.20*/controllers/*37.31*/.compras.routes.CategoriasController.indexCategoria())),format.raw/*37.84*/("""">Categorías</a></li>
				""")))})),format.raw/*38.6*/("""				
				"""),_display_(Seq[Any](/*39.6*/if(Componente.check("productosTipo"))/*39.43*/ {_display_(Seq[Any](format.raw/*39.45*/("""
					<li><a href=""""),_display_(Seq[Any](/*40.20*/controllers/*40.31*/.compras.routes.TipoProductosController.indexTipoProducto())),format.raw/*40.90*/("""">Tipos de productos</a></li>
				""")))})),format.raw/*41.6*/("""
				"""),_display_(Seq[Any](/*42.6*/if(Componente.check("articulos"))/*42.39*/ {_display_(Seq[Any](format.raw/*42.41*/("""
					<li><a href=""""),_display_(Seq[Any](/*43.20*/controllers/*43.31*/.compras.routes.ArticulosController.indexArticulo())),format.raw/*43.82*/("""">Artículos</a></li>
				""")))})),format.raw/*44.6*/("""
				
				<li class="titulo">Proveedores</li>
				"""),_display_(Seq[Any](/*47.6*/if(Componente.check("proveedores"))/*47.41*/ {_display_(Seq[Any](format.raw/*47.43*/("""
					<li><a href=""""),_display_(Seq[Any](/*48.20*/controllers/*48.31*/.compras.routes.ProveedoresController.index())),format.raw/*48.76*/("""">Gestión</a></li>
				""")))})),format.raw/*49.6*/("""
				<li class="titulo">Clientes</li>
				"""),_display_(Seq[Any](/*51.6*/if(Componente.check("clientes"))/*51.38*/ {_display_(Seq[Any](format.raw/*51.40*/("""
					<li><a href=""""),_display_(Seq[Any](/*52.20*/controllers/*52.31*/.compras.routes.ClientesController.index())),format.raw/*52.73*/("""">Gestión</a></li>
				""")))})),format.raw/*53.6*/("""
			</ul>
			</div>
		</div>
		<div class="col-sm-10">"""),_display_(Seq[Any](/*57.27*/content)),format.raw/*57.34*/("""</div>
	</div>

""")))})))}
    }
    
    def render(title:String,scripts:Html,content:Html): play.api.templates.HtmlFormat.Appendable = apply(title,scripts)(content)
    
    def f:((String,Html) => (Html) => play.api.templates.HtmlFormat.Appendable) = (title,scripts) => (content) => apply(title,scripts)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:41 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/mainCompras.scala.html
                    HASH: 0d045df1b4344d63edd1ba56159e2b86a5c16360
                    MATRIX: 798->1|969->57|996->80|1032->82|1068->110|1106->111|1313->283|1363->324|1403->326|1459->346|1479->357|1546->402|1616->441|1657->447|1703->484|1743->486|1799->506|1819->517|1882->558|1948->593|1989->599|2044->645|2084->647|2140->667|2160->678|2238->734|2309->774|2350->780|2403->824|2443->826|2499->846|2519->857|2595->911|2664->949|2705->955|2753->994|2793->996|2849->1016|2869->1027|2940->1076|3012->1117|3053->1123|3099->1160|3139->1162|3195->1182|3215->1193|3284->1240|3349->1274|3390->1280|3432->1313|3472->1315|3528->1335|3548->1346|3613->1389|3671->1416|3750->1460|3792->1493|3832->1495|3888->1515|3908->1526|3981->1577|4038->1603|4079->1609|4130->1651|4170->1653|4226->1673|4246->1684|4321->1737|4379->1764|4424->1774|4470->1811|4510->1813|4566->1833|4586->1844|4667->1903|4733->1938|4774->1944|4816->1977|4856->1979|4912->1999|4932->2010|5005->2061|5062->2087|5148->2138|5192->2173|5232->2175|5288->2195|5308->2206|5375->2251|5430->2275|5508->2318|5549->2350|5589->2352|5645->2372|5665->2383|5729->2425|5784->2449|5875->2504|5904->2511
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|39->11|39->11|39->11|40->12|40->12|40->12|41->13|42->14|42->14|42->14|43->15|43->15|43->15|44->16|45->17|45->17|45->17|46->18|46->18|46->18|47->19|48->20|48->20|48->20|49->21|49->21|49->21|50->22|51->23|51->23|51->23|52->24|52->24|52->24|53->25|54->26|54->26|54->26|55->27|55->27|55->27|56->28|57->29|57->29|57->29|58->30|58->30|58->30|59->31|61->33|61->33|61->33|62->34|62->34|62->34|63->35|64->36|64->36|64->36|65->37|65->37|65->37|66->38|67->39|67->39|67->39|68->40|68->40|68->40|69->41|70->42|70->42|70->42|71->43|71->43|71->43|72->44|75->47|75->47|75->47|76->48|76->48|76->48|77->49|79->51|79->51|79->51|80->52|80->52|80->52|81->53|85->57|85->57
                    -- GENERATED --
                */
            