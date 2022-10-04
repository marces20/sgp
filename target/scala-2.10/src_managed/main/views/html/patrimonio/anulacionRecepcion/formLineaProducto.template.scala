
package views.html.patrimonio.anulacionRecepcion

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
object formLineaProducto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Long,Form[OrdenLineaAnulacion],Long,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(idOrdenCompra:Long, lineaForm: Form[OrdenLineaAnulacion], orden_linea_id:Long = 0):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.85*/("""
"""),format.raw/*3.70*/(""" 



"""),_display_(Seq[Any](/*7.2*/views/*7.7*/.html.tags.successError())),format.raw/*7.32*/("""


	"""),_display_(Seq[Any](/*10.3*/inputText(lineaForm("id"), 'type -> "hidden"))),format.raw/*10.48*/("""
	
	<input type="hidden" name="idOrdenCompra" value=""""),_display_(Seq[Any](/*12.52*/idOrdenCompra)),format.raw/*12.65*/("""" />


<div class="row">
	<div class="col-sm-8">
		<label for="producto_nombre" class="control-label">Producto</label>
		<div class="input-group """),_display_(Seq[Any](/*18.28*/if(lineaForm.error("producto_id") != null)/*18.70*/ {_display_(Seq[Any](format.raw/*18.72*/("""has-error""")))}/*18.83*/else/*18.88*/{_display_(Seq[Any](format.raw/*18.89*/("""has-required""")))})),format.raw/*18.102*/("""">
			"""),_display_(Seq[Any](/*19.5*/inputText(lineaForm("ordenLinea.producto.nombre"), 'class -> "form-control", 'autofocus -> "autofocus", 'id -> "producto_modal"))),format.raw/*19.133*/("""
			"""),_display_(Seq[Any](/*20.5*/inputText(lineaForm("orden_linea_id"), 'hidden -> "hidden", 'id -> "orden_linea_id"))),format.raw/*20.89*/("""
			<span class="input-group-addon">
				<a href="#" id="searchProductoModal" 
							data-title="Selección de producto" 
							data-url=""""),_display_(Seq[Any](/*24.19*/controllers/*24.30*/.patrimonio.routes.AnulacionRecepcionProductosController.modalProductosEnOrden(orden_linea_id))),format.raw/*24.124*/("""" 
							data-height="650" 
							data-width="700" 
							data-listen="modal.seleccion.producto.simple" 
							data-label="#producto_modal" 
							data-field="#orden_linea_id">
							<i class="glyphicon glyphicon-search"></i>
				</a>
			</span>
		</div>
		"""),_display_(Seq[Any](/*34.4*/lineaForm("producto_id")/*34.28*/.error.map/*34.38*/{ error =>_display_(Seq[Any](format.raw/*34.48*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*35.29*/error/*35.34*/.message)),format.raw/*35.42*/("""</div>
		""")))})),format.raw/*36.4*/("""
	</div>


	<div class="col-sm-4">
		<div class="form-group has-required """),_display_(Seq[Any](/*41.40*/if(lineaForm.error("cantidad") != null)/*41.79*/ {_display_(Seq[Any](format.raw/*41.81*/("""has-error""")))})),format.raw/*41.91*/("""">
			<label for="nombre" class="control-label">Cantidad para anular</label>
			"""),_display_(Seq[Any](/*43.5*/inputText(lineaForm("cantidad"), 'class -> "form-control"))),format.raw/*43.63*/("""
			"""),_display_(Seq[Any](/*44.5*/lineaForm("cantidad")/*44.26*/.error.map/*44.36*/{ error =>_display_(Seq[Any](format.raw/*44.46*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*45.30*/error/*45.35*/.message)),format.raw/*45.43*/("""</div>
			""")))})),format.raw/*46.5*/("""
		</div>
	</div>
	
</div>
<div class="row">

	<div class="col-sm-12">
		<label for="obs" class="control-label">Observaciones</label> 
		"""),_display_(Seq[Any](/*55.4*/textarea(lineaForm("observaciones"), 'class -> "form-control", 'rows -> "4", 'id -> "obs"))),format.raw/*55.94*/("""
	</div>

</div>

	<div class="col-sm-2 col-md-offset-10">
		<div class="form-group">
		<label for="nombre" class="control-label">&nbsp;</label>
		<button id="btn-guardar-anulacion-productos"  class="form-control btn btn-primary"> Guardar</button>
		</div>
	</div>	



<script>
$(function()"""),format.raw/*70.13*/("""{"""),format.raw/*70.14*/("""

	$('#searchProductoModal').modalSearch();

"""),format.raw/*74.1*/("""}"""),format.raw/*74.2*/(""");
</script>




"""),_display_(Seq[Any](/*80.2*/flash()/*80.9*/.clear())))}
    }
    
    def render(idOrdenCompra:Long,lineaForm:Form[OrdenLineaAnulacion],orden_linea_id:Long): play.api.templates.HtmlFormat.Appendable = apply(idOrdenCompra,lineaForm,orden_linea_id)
    
    def f:((Long,Form[OrdenLineaAnulacion],Long) => play.api.templates.HtmlFormat.Appendable) = (idOrdenCompra,lineaForm,orden_linea_id) => apply(idOrdenCompra,lineaForm,orden_linea_id)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/anulacionRecepcion/formLineaProducto.scala.html
                    HASH: 54e853cb62ab45285cd771256a5a87998d512e9f
                    MATRIX: 845->1|1031->105|1063->129|1137->84|1166->173|1210->183|1222->188|1268->213|1311->221|1378->266|1470->322|1505->335|1693->487|1744->529|1784->531|1813->542|1826->547|1865->548|1911->561|1954->569|2105->697|2146->703|2252->787|2432->931|2452->942|2569->1036|2878->1310|2911->1334|2930->1344|2978->1354|3044->1384|3058->1389|3088->1397|3130->1408|3245->1487|3293->1526|3333->1528|3375->1538|3493->1621|3573->1679|3614->1685|3644->1706|3663->1716|3711->1726|3778->1757|3792->1762|3822->1770|3865->1782|4047->1929|4159->2019|4492->2324|4521->2325|4597->2374|4625->2375|4684->2399|4699->2406
                    LINES: 26->1|29->3|29->3|30->1|31->3|35->7|35->7|35->7|38->10|38->10|40->12|40->12|46->18|46->18|46->18|46->18|46->18|46->18|46->18|47->19|47->19|48->20|48->20|52->24|52->24|52->24|62->34|62->34|62->34|62->34|63->35|63->35|63->35|64->36|69->41|69->41|69->41|69->41|71->43|71->43|72->44|72->44|72->44|72->44|73->45|73->45|73->45|74->46|83->55|83->55|98->70|98->70|102->74|102->74|108->80|108->80
                    -- GENERATED --
                */
            