
package views.html.patrimonio.baul

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
object formRemitoBaul extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[RemitoBaul],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(rForm: Form[RemitoBaul]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.27*/("""
"""),format.raw/*4.70*/(""" 


<div class="row menu-acciones">
	<div class="col-sm-10">
		<button type="submit" class="btn btn-default" title="Guardar certificación"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>	
    	<a href=""""),_display_(Seq[Any](/*10.16*/controllers/*10.27*/.patrimonio.routes.RemitosBaulController.index())),format.raw/*10.75*/("""" title="Cancelar" class="btn btn-default"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
    </div>
</div>

"""),_display_(Seq[Any](/*14.2*/inputText(rForm("id"), 'type -> "hidden", 'id->"remitoId"))),format.raw/*14.60*/("""

<div class="row">

	<div class="col-sm-2">
		<div class="form-group """),_display_(Seq[Any](/*19.27*/if(rForm.error("numero") != null)/*19.60*/ {_display_(Seq[Any](format.raw/*19.62*/("""has-error""")))}/*19.73*/else/*19.78*/{_display_(Seq[Any](format.raw/*19.79*/("""has-required""")))})),format.raw/*19.92*/("""">
			<label for="numero" class="control-label">Número</label>
			"""),_display_(Seq[Any](/*21.5*/inputText(rForm("numero"), 'class -> "form-control"))),format.raw/*21.57*/("""
			"""),_display_(Seq[Any](/*22.5*/rForm("numero")/*22.20*/.error.map/*22.30*/{ error =>_display_(Seq[Any](format.raw/*22.40*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*23.30*/error/*23.35*/.message)),format.raw/*23.43*/("""</div>
			""")))})),format.raw/*24.5*/("""
		</div>
	</div>
	
	<div class="col-sm-2">
		<div class="form-group """),_display_(Seq[Any](/*29.27*/if(rForm.error("fecha") != null)/*29.59*/ {_display_(Seq[Any](format.raw/*29.61*/("""has-error""")))})),format.raw/*29.71*/("""">
			<label for="fechaRemito" class="control-label">Fecha de remito</label> 
			"""),_display_(Seq[Any](/*31.5*/inputText(rForm("fecha"),'class -> "form-control date"))),format.raw/*31.60*/("""
		</div>
	</div>

	<div class="col-sm-3">
		<label class="control-label">Proveedor
			<div class="input-group">
				"""),_display_(Seq[Any](/*38.6*/inputText(rForm("proveedor_id"), 'hidden -> "hidden", 'id -> "proveedor_id"))),format.raw/*38.82*/("""
				"""),_display_(Seq[Any](/*39.6*/inputText(rForm("proveedor.nombre"), 'name -> "", 'class -> "form-control", 'id -> "proveedor"))),format.raw/*39.101*/("""
				<span class="input-group-addon">
					<a href="#" class="searchModal"
								id="searchProveedor" 
								data-title="Selección de Proveedores" 
								data-url=""""),_display_(Seq[Any](/*44.20*/controllers/*44.31*/.compras.routes.ProveedoresController.modalBuscar())),format.raw/*44.82*/("""" 
								data-height="650" 
								data-width="700" 
								data-listen="modal.seleccion.proveedor.simple" 
								data-label="#proveedor" 
								data-field="#proveedor_id">
						<i class="glyphicon glyphicon-search"></i>
					</a>
				</span>
			</div>
		</label>
	</div>

</div>


<div class="row">

	<div class="col-sm-12">
		<label for="fechaRemito" class="control-label">Observaciones</label> 
		"""),_display_(Seq[Any](/*64.4*/textarea(rForm("observaciones"), 'class -> "form-control", 'rows -> "4"))),format.raw/*64.76*/("""
	</div>
</div>


<script>
$( function()"""),format.raw/*70.14*/("""{"""),format.raw/*70.15*/("""
	$('#searchProveedor').modalSearch();
	$("#precio, #cantidad, #descuento").numeric_input("""),format.raw/*72.52*/("""{"""),format.raw/*72.53*/("""allowNegative: true"""),format.raw/*72.72*/("""}"""),format.raw/*72.73*/(""");
"""),format.raw/*73.1*/("""}"""),format.raw/*73.2*/(""")
</script>	

<hr />"""))}
    }
    
    def render(rForm:Form[RemitoBaul]): play.api.templates.HtmlFormat.Appendable = apply(rForm)
    
    def f:((Form[RemitoBaul]) => play.api.templates.HtmlFormat.Appendable) = (rForm) => apply(rForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/baul/formRemitoBaul.scala.html
                    HASH: 87a4ea90c048db684eef45f8c643366cdd47e761
                    MATRIX: 809->1|954->64|986->88|1060->26|1089->132|1351->358|1371->369|1441->417|1606->547|1686->605|1798->681|1840->714|1880->716|1909->727|1922->732|1961->733|2006->746|2110->815|2184->867|2225->873|2249->888|2268->898|2316->908|2383->939|2397->944|2427->952|2470->964|2581->1039|2622->1071|2662->1073|2704->1083|2823->1167|2900->1222|3060->1347|3158->1423|3200->1430|3318->1525|3530->1701|3550->1712|3623->1763|4088->2193|4182->2265|4256->2311|4285->2312|4405->2404|4434->2405|4481->2424|4510->2425|4541->2429|4569->2430
                    LINES: 26->1|31->4|31->4|32->1|33->4|39->10|39->10|39->10|43->14|43->14|48->19|48->19|48->19|48->19|48->19|48->19|48->19|50->21|50->21|51->22|51->22|51->22|51->22|52->23|52->23|52->23|53->24|58->29|58->29|58->29|58->29|60->31|60->31|67->38|67->38|68->39|68->39|73->44|73->44|73->44|93->64|93->64|99->70|99->70|101->72|101->72|101->72|101->72|102->73|102->73
                    -- GENERATED --
                */
            