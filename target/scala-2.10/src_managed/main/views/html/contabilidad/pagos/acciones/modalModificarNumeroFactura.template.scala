
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
object modalModificarNumeroFactura extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[DynamicForm,Long,Pago,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm,id:Long,p:Pago):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.44*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.contabilidad.routes.PagosAccionesController.modificarNumeroFactura(), 'id -> "formModificarNumeroFactura")/*5.141*/ {_display_(Seq[Any](format.raw/*5.143*/("""
	<input type="hidden" name="id" value=""""),_display_(Seq[Any](/*6.41*/id)),format.raw/*6.43*/("""" />
	
	"""),_display_(Seq[Any](/*8.3*/views/*8.8*/.html.tags.successError())),format.raw/*8.33*/("""
	
	"""),_display_(Seq[Any](/*10.3*/formBuscador("id_pago")/*10.26*/.error.map/*10.36*/{ error =>_display_(Seq[Any](format.raw/*10.46*/("""
		<div class="alert alert-danger"><i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*11.84*/error/*11.89*/.message)),format.raw/*11.97*/("""</div>
	""")))})),format.raw/*12.3*/("""
	
	<div id="alert-success" class="alert alert-success hide"></div>
	<div id="alert-danger" class="alert alert-danger hide"></div>
	<div class="row">
		<div class="col-sm-6">
			<div class="panel panel-default">
				<div class="panel-heading"><b>Facturacion</b></div>
				<div class="panel-body">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<td>Monto Orden</td>
								<td>Monto Cargado</td>
								<td>Restante</td>
							</tr>
						<thead>
						<tbody>
						<tr>
							<td><b>"""),_display_(Seq[Any](/*31.16*/if(p.factura != null && p.factura.orden != null)/*31.64*/{_display_(Seq[Any](_display_(Seq[Any](/*31.66*/utils/*31.71*/.NumberUtils.moneda(p.factura.orden.getTotalTotal())))))})),format.raw/*31.124*/("""</b></td>
							<td><b>"""),_display_(Seq[Any](/*32.16*/if(p.factura != null && p.factura.orden != null)/*32.64*/{_display_(Seq[Any](_display_(Seq[Any](/*32.66*/utils/*32.71*/.NumberUtils.moneda(Factura.getTotalMontoFacturasCargadas(p.factura.id))))))})),format.raw/*32.144*/("""</b></td>
							<td><b>"""),_display_(Seq[Any](/*33.16*/if(p.factura != null && p.factura.orden != null)/*33.64*/{_display_(Seq[Any](_display_(Seq[Any](/*33.66*/utils/*33.71*/.NumberUtils.moneda(p.factura.orden.getTotalTotal().subtract(Factura.getTotalMontoFacturasCargadas(p.factura.id)))))))})),format.raw/*33.186*/("""</b></td>
						</tr>
						</tbody>
					</table>
				</div>
			</div>	
		</div>
		<div class="col-sm-6">
			<div class="panel panel-default">
				<div class="panel-heading"><b>Facturas cargadas</b></div>
				<div class="panel-body">
					<table class="table table-striped table-bordered">
						<thead>
						<tr>
							<td>Factura</td>
							<td>Numero</td>
							<td>Monto</td>
						</tr>
						</thead>
						<tbody>
						
						"""),_display_(Seq[Any](/*54.8*/for(s <- Factura.getFacturasDatosCargadas(p.factura.id) ) yield /*54.65*/{_display_(Seq[Any](format.raw/*54.66*/("""
						
							<tr>
								<td><b>"""),_display_(Seq[Any](/*57.17*/s/*57.18*/.getString("nombre"))),format.raw/*57.38*/("""</b></td>
								<td><b>"""),_display_(Seq[Any](/*58.17*/s/*58.18*/.getString("numero_factura"))),format.raw/*58.46*/("""</b></td>
								<td><b>"""),_display_(Seq[Any](/*59.17*/utils/*59.22*/.NumberUtils.moneda(s.getBigDecimal("monto")))),format.raw/*59.67*/("""</b></td>
							</tr>
						""")))})),format.raw/*61.8*/("""
						</tbody>
					</table>
				</div>
			</div>	
		</div>
	</div>
	
	<div class="row">
		<div class="col-sm-3">
			<div class="form-group """),_display_(Seq[Any](/*71.28*/if(formBuscador.error("numero_factura") != null)/*71.76*/ {_display_(Seq[Any](format.raw/*71.78*/("""has-error""")))})),format.raw/*71.88*/("""">
				<label for="inputNumeroFactura" class="control-label">N° Factura</label> 
				"""),_display_(Seq[Any](/*73.6*/inputText(formBuscador("numero_factura"), 'class -> "form-control", 'id -> "numero_factura", 'autofocus -> "autofocus"))),format.raw/*73.125*/("""
			</div>
			
			"""),_display_(Seq[Any](/*76.5*/formBuscador("numero_factura")/*76.35*/.error.map/*76.45*/{ error =>_display_(Seq[Any](format.raw/*76.55*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*77.30*/error/*77.35*/.message)),format.raw/*77.43*/("""</div>
			""")))})),format.raw/*78.5*/("""
		</div>
		
		<div class="col-sm-3">
			<div class="form-group """),_display_(Seq[Any](/*82.28*/if(formBuscador.error("monto") != null)/*82.67*/ {_display_(Seq[Any](format.raw/*82.69*/("""has-error""")))})),format.raw/*82.79*/("""">
				<label for="inputNumeroFactura" class="control-label">Monto</label> 
				"""),_display_(Seq[Any](/*84.6*/inputText(formBuscador("monto"), 'class -> "form-control", 'id -> "monto"))),format.raw/*84.80*/("""
			</div>
			
			"""),_display_(Seq[Any](/*87.5*/formBuscador("monto")/*87.26*/.error.map/*87.36*/{ error =>_display_(Seq[Any](format.raw/*87.46*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*88.30*/error/*88.35*/.message)),format.raw/*88.43*/("""</div>
			""")))})),format.raw/*89.5*/("""
		</div>
		
		<div class="col-sm-5"><br />
			<button type="submit" class="btn btn-default" title="Guardar"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>
		</div>
		
	</div>
""")))})),format.raw/*97.2*/("""
<script>
$( function()"""),format.raw/*99.14*/("""{"""),format.raw/*99.15*/(""" 
	$('#numero_factura').mask("a-9999-99999999");
	$("#monto").numeric_input("""),format.raw/*101.28*/("""{"""),format.raw/*101.29*/("""allowNegative: true"""),format.raw/*101.48*/("""}"""),format.raw/*101.49*/(""");

"""),format.raw/*103.1*/("""}"""),format.raw/*103.2*/(""")
</script>
"""),_display_(Seq[Any](/*105.2*/flash()/*105.9*/.clear())))}
    }
    
    def render(formBuscador:DynamicForm,id:Long,p:Pago): play.api.templates.HtmlFormat.Appendable = apply(formBuscador,id,p)
    
    def f:((DynamicForm,Long,Pago) => play.api.templates.HtmlFormat.Appendable) = (formBuscador,id,p) => apply(formBuscador,id,p)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:38 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/pagos/acciones/modalModificarNumeroFactura.scala.html
                    HASH: 60b6788db9c87d71c633acd9a6d80ab2655950c7
                    MATRIX: 839->1|983->62|1015->86|1089->43|1117->130|1155->134|1168->140|1310->273|1350->275|1426->316|1449->318|1492->327|1504->332|1550->357|1590->362|1622->385|1641->395|1689->405|1809->489|1823->494|1853->502|1893->511|2461->1043|2518->1091|2566->1093|2580->1098|2660->1151|2721->1176|2778->1224|2826->1226|2840->1231|2940->1304|3001->1329|3058->1377|3106->1379|3120->1384|3262->1499|3737->1939|3810->1996|3849->1997|3921->2033|3931->2034|3973->2054|4035->2080|4045->2081|4095->2109|4157->2135|4171->2140|4238->2185|4299->2215|4477->2357|4534->2405|4574->2407|4616->2417|4737->2503|4879->2622|4933->2641|4972->2671|4991->2681|5039->2691|5105->2721|5119->2726|5149->2734|5191->2745|5292->2810|5340->2849|5380->2851|5422->2861|5538->2942|5634->3016|5688->3035|5718->3056|5737->3066|5785->3076|5851->3106|5865->3111|5895->3119|5937->3130|6163->3325|6214->3348|6243->3349|6348->3425|6378->3426|6426->3445|6456->3446|6488->3450|6517->3451|6566->3464|6582->3471
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|34->6|34->6|36->8|36->8|36->8|38->10|38->10|38->10|38->10|39->11|39->11|39->11|40->12|59->31|59->31|59->31|59->31|59->31|60->32|60->32|60->32|60->32|60->32|61->33|61->33|61->33|61->33|61->33|82->54|82->54|82->54|85->57|85->57|85->57|86->58|86->58|86->58|87->59|87->59|87->59|89->61|99->71|99->71|99->71|99->71|101->73|101->73|104->76|104->76|104->76|104->76|105->77|105->77|105->77|106->78|110->82|110->82|110->82|110->82|112->84|112->84|115->87|115->87|115->87|115->87|116->88|116->88|116->88|117->89|125->97|127->99|127->99|129->101|129->101|129->101|129->101|131->103|131->103|133->105|133->105
                    -- GENERATED --
                */
            