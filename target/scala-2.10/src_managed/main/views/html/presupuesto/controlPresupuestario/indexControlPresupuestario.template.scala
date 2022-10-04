
package views.html.presupuesto.controlPresupuestario

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
object indexControlPresupuestario extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[List[OrdenLineaAjuste],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(ol: List[OrdenLineaAjuste],formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import models.auth._

import utils._

import java.lang.Long;var ordenId=new java.lang.Long(0);var expId=new java.lang.Long(0);var cuentaId=new java.lang.Long(0);

import java.math.BigDecimal;var total=new java.math.BigDecimal(0);

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.56*/("""
"""),format.raw/*5.70*/(""" 
"""),_display_(Seq[Any](/*8.2*/views/*8.7*/.html.presupuesto.mainPresupuesto("Control Presupuesto")/*8.63*/ {_display_(Seq[Any](format.raw/*8.65*/("""
<script>

$( function() """),format.raw/*11.15*/("""{"""),format.raw/*11.16*/("""
	var baseUrl = $('#reporteControlAnulacionProductosAutomaticos').attr('href')
	$('#reporteControlAnulacionProductosAutomaticos').attr('href', baseUrl + '?descarga=&' + window.location.href.slice(window.location.href.indexOf('?') + 1))
"""),format.raw/*14.1*/("""}"""),format.raw/*14.2*/(""");

</script>
	
<div class="page-header">
	<div class="row">
		<div class="col-sm-7">
			<h1>Lista Anulaciones Automaticas Patrimonio</h1>
		</div>
		<div class="col-sm-5">
			<div class="dropdown pull-right">
				<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
			 		<i class="glyphicon glyphicon-list-alt"></i> Reportes<span class="caret"></span>
				</button>
				<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
					<li><a id="reporteControlAnulacionProductosAutomaticos" href=""""),_display_(Seq[Any](/*29.69*/controllers/*29.80*/.presupuesto.routes.ControlPresupuestarioController.controlAnulacionProductosAutomaticosExcel())),format.raw/*29.175*/("""">Descargar Excel</a></li>
							
				</ul>
			</div>
		</div>
	</div>
</div>	
	"""),_display_(Seq[Any](/*36.3*/views/*36.8*/.html.tags.successError())),format.raw/*36.33*/("""

<div id="actions">
	<form action="" id="formSearchFacturas" method="GET">
		<div class="row">
			<div class="col-sm-2 input-group">
				<label class="control-label">Fecha Creacion</label>
				<div>
					"""),_display_(Seq[Any](/*44.7*/inputText(formBuscador("fecha_desde"), 'class -> "form-control inputDateMascara", 'id -> "fecha_desde", 'placeholder -> "Desde"))),format.raw/*44.135*/("""
					"""),_display_(Seq[Any](/*45.7*/inputText(formBuscador("fecha_hasta"), 'class -> "form-control inputDateMascara", 'id -> "fecha_hasta", 'placeholder -> "Hasta"))),format.raw/*45.135*/("""
				</div>
			</div>
			<div class="col-sm-2">
				<label class="control-label">Expediente</label>
					<div class="input-group">
						"""),_display_(Seq[Any](/*51.8*/inputText(formBuscador("expediente.nombre"), 'name -> "", 'class -> "form-control", 'id -> "expediente"))),format.raw/*51.112*/("""
						"""),_display_(Seq[Any](/*52.8*/inputText(formBuscador("expediente.id"), 'hidden -> "hidden", 'id -> "expediente_id"))),format.raw/*52.93*/("""
						<span class="input-group-addon">
							<a href="#" class="searchModal"
										id="searchExpediente" 
										data-title="Selección de expediente" 
										data-url=""""),_display_(Seq[Any](/*57.22*/controllers/*57.33*/.expediente.routes.ExpedientesController.modalBuscar())),format.raw/*57.87*/("""" 
										data-height="650" 
										data-width="700" 
										data-listen="modal.seleccion.expediente.simple" 
										data-label="#expediente" 
										data-field="#expediente_id">
								<i class="glyphicon glyphicon-search"></i>
							</a>
						</span>
					</div>
			</div>			
			<div class="col-sm-2 input-group">
				<label class="control-label"> 
					Creacion Automatica
					"""),_display_(Seq[Any](/*71.7*/select(formBuscador("auto"),options("SI"->"SI","NO"->"NO"), 'class -> "form-control select"))),format.raw/*71.99*/("""
				</label>
			</div>
			<div class="col-sm-2">
				<label class="control-label">Ejercicio
					"""),_display_(Seq[Any](/*76.7*/select(formBuscador("ejercicio"), Ejercicio.getEjercicios().map { p => p.id.toString -> p.nombre}, 
					'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*77.66*/("""
					
				</label>
			</div>
		</div>	
		<div class="row">	
			<div class="col-sm-2">
				<div class="form-group">
				<label for="nombre" class="control-label">&nbsp;</label>
				<button  class="form-control btn btn-primary"><i class="glyphicon glyphicon-search"></i> Buscar</button>
				</div>
			</div>
			<div class="col-sm-2">
				<div class="form-group">
				<label for="nombre" class="control-label">&nbsp;</label>
				<a href=""""),_display_(Seq[Any](/*92.15*/controllers/*92.26*/.presupuesto.routes.ControlPresupuestarioController.movimientosSaldoPreventivo())),format.raw/*92.106*/(""""  class="form-control btn btn-default">Limpiar</a>
				</div>
			</div>
		</div>
	</form>
</div>
	"""),_display_(Seq[Any](/*98.3*/if(ol != null)/*98.17*/{_display_(Seq[Any](format.raw/*98.18*/("""
		"""),_display_(Seq[Any](/*99.4*/if(ol.size() == 0)/*99.22*/ {_display_(Seq[Any](format.raw/*99.24*/("""
	        
	        <div class="well">
	            <em>No se encuentran resultados</em>
	        </div>
	        
	    """)))}/*105.8*/else/*105.13*/{_display_(Seq[Any](format.raw/*105.14*/("""
	    
	    	<table class="table table-bordered tablaPresupuesto">
				<thead>
					<tr>
						<th>Fecha</th>
						<th>Usuario</th>
						<th>Orden</th>
						<th>OP</th>
						<th>Expediente</th>
						<th>Cuenta</th>
						<th>Producto</th>
						<th>Cantidad</th>
						<th>Precio</th>
						<th>Total</th>
						<th>Nota</th>
					</tr>
				</thead>
				<tbody>
					
					"""),_display_(Seq[Any](/*125.7*/for(p <- ol) yield /*125.19*/ {_display_(Seq[Any](format.raw/*125.21*/("""
						"""),_display_(Seq[Any](/*126.8*/if(ordenId.compareTo(new Long(0)) != 0 && ordenId.compareTo(p.orden.id) != 0 && cuentaId.compareTo(p.cuentaAnalitica.cuenta_reporta_id) != 0 && expId.compareTo(p.orden.expediente_id) != 0)/*126.196*/{_display_(Seq[Any](format.raw/*126.197*/("""
							<tr>
								<td colspan="8">Total</td>
								<td>"""),_display_(Seq[Any](/*129.14*/utils/*129.19*/.NumberUtils.moneda(total, 2))),format.raw/*129.48*/("""</td>
							</tr>
							<tr>
								<td colspan="9"></td>
							</tr>
							"""),_display_(Seq[Any](/*134.9*/{total = new java.math.BigDecimal(0)})),format.raw/*134.46*/("""
						""")))})),format.raw/*135.8*/("""
						"""),_display_(Seq[Any](/*136.8*/{ordenId = p.orden.id})),format.raw/*136.30*/("""
						"""),_display_(Seq[Any](/*137.8*/{cuentaId = p.cuentaAnalitica.cuenta_reporta_id})),format.raw/*137.56*/("""
						"""),_display_(Seq[Any](/*138.8*/{expId = p.orden.expediente_id})),format.raw/*138.39*/("""
						
						
						<tr>
							<td>"""),_display_(Seq[Any](/*142.13*/if(p.create_date != null)/*142.38*/{_display_(Seq[Any](_display_(Seq[Any](/*142.40*/(utils.DateUtils.formatDate(p.create_date))))))})),format.raw/*142.84*/("""</td>
							<td>"""),_display_(Seq[Any](/*143.13*/if(p.create_usuario != null)/*143.41*/{_display_(Seq[Any](_display_(Seq[Any](/*143.43*/p/*143.44*/.create_usuario.nombre))))})),format.raw/*143.67*/(""" </td>
							<td>ORD"""),_display_(Seq[Any](/*144.16*/ordenId)),format.raw/*144.23*/("""</td>
							<td>"""),_display_(Seq[Any](/*145.13*/if(p.orden.numero_orden_provision != null)/*145.55*/{_display_(Seq[Any](_display_(Seq[Any](/*145.57*/p/*145.58*/.orden.numero_orden_provision))))})),format.raw/*145.88*/("""</td>
							<td>"""),_display_(Seq[Any](/*146.13*/p/*146.14*/.orden.expediente.getExpedienteEjercicio())),format.raw/*146.56*/("""</td>
							<td>"""),_display_(Seq[Any](/*147.13*/p/*147.14*/.cuentaAnalitica.cuentaReporta.codigo)),format.raw/*147.51*/(""" - """),_display_(Seq[Any](/*147.55*/p/*147.56*/.cuentaAnalitica.cuentaReporta.nombre)),format.raw/*147.93*/("""</td>
							<td>"""),_display_(Seq[Any](/*148.13*/p/*148.14*/.producto.nombre)),format.raw/*148.30*/("""</td>
							<td>"""),_display_(Seq[Any](/*149.13*/p/*149.14*/.cantidad)),format.raw/*149.23*/("""</td>
							<td>"""),_display_(Seq[Any](/*150.13*/utils/*150.18*/.NumberUtils.moneda(p.precio, 2))),format.raw/*150.50*/("""</td>
							<td>"""),_display_(Seq[Any](/*151.13*/(utils.NumberUtils.moneda(p.precio.multiply(p.cantidad), 2)))),format.raw/*151.73*/("""</td>
							<td>"""),_display_(Seq[Any](/*152.13*/p/*152.14*/.nota)),format.raw/*152.19*/("""</td>
						</tr>
						"""),_display_(Seq[Any](/*154.8*/{total = total.add(p.precio.multiply(p.cantidad))})),format.raw/*154.58*/("""
					""")))})),format.raw/*155.7*/("""
					<tr>
						<td colspan="9">Total</td>
						<td>"""),_display_(Seq[Any](/*158.12*/utils/*158.17*/.NumberUtils.moneda(total, 2))),format.raw/*158.46*/("""</td>
					</tr>
				</tbody>
			</table>	
	    
	    """)))})),format.raw/*163.7*/("""
    """)))})),format.raw/*164.6*/("""
""")))})),format.raw/*165.2*/("""
<script>
$(function()"""),format.raw/*167.13*/("""{"""),format.raw/*167.14*/("""
	$('#searchExpediente').modalSearch();
"""),format.raw/*169.1*/("""}"""),format.raw/*169.2*/(""");
</script>"""))}
    }
    
    def render(ol:List[OrdenLineaAjuste],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(ol,formBuscador)
    
    def f:((List[OrdenLineaAjuste],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (ol,formBuscador) => apply(ol,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/presupuesto/controlPresupuestario/indexControlPresupuestario.scala.html
                    HASH: 830a307568e0a16fdc86183c714ef3b8b203d689
                    MATRIX: 857->1|1244->112|1276->136|1350->55|1378->180|1415->376|1427->381|1491->437|1530->439|1583->464|1612->465|1875->701|1903->702|2502->1265|2522->1276|2640->1371|2757->1453|2770->1458|2817->1483|3058->1689|3209->1817|3251->1824|3402->1952|3575->2090|3702->2194|3745->2202|3852->2287|4069->2468|4089->2479|4165->2533|4600->2933|4714->3025|4848->3124|5035->3289|5508->3726|5528->3737|5631->3817|5766->3917|5789->3931|5828->3932|5867->3936|5894->3954|5934->3956|6074->4078|6088->4083|6128->4084|6543->4463|6572->4475|6613->4477|6657->4485|6856->4673|6897->4674|6995->4735|7010->4740|7062->4769|7180->4851|7240->4888|7280->4896|7324->4904|7369->4926|7413->4934|7484->4982|7528->4990|7582->5021|7657->5059|7692->5084|7741->5086|7812->5130|7867->5148|7905->5176|7954->5178|7965->5179|8015->5202|8074->5224|8104->5231|8159->5249|8211->5291|8260->5293|8271->5294|8328->5324|8383->5342|8394->5343|8459->5385|8514->5403|8525->5404|8585->5441|8626->5445|8637->5446|8697->5483|8752->5501|8763->5502|8802->5518|8857->5536|8868->5537|8900->5546|8955->5564|8970->5569|9025->5601|9080->5619|9163->5679|9218->5697|9229->5698|9257->5703|9318->5728|9391->5778|9430->5785|9522->5840|9537->5845|9589->5874|9676->5929|9714->5935|9748->5937|9799->5959|9829->5960|9897->6000|9926->6001
                    LINES: 26->1|37->5|37->5|38->1|39->5|40->8|40->8|40->8|40->8|43->11|43->11|46->14|46->14|61->29|61->29|61->29|68->36|68->36|68->36|76->44|76->44|77->45|77->45|83->51|83->51|84->52|84->52|89->57|89->57|89->57|103->71|103->71|108->76|109->77|124->92|124->92|124->92|130->98|130->98|130->98|131->99|131->99|131->99|137->105|137->105|137->105|157->125|157->125|157->125|158->126|158->126|158->126|161->129|161->129|161->129|166->134|166->134|167->135|168->136|168->136|169->137|169->137|170->138|170->138|174->142|174->142|174->142|174->142|175->143|175->143|175->143|175->143|175->143|176->144|176->144|177->145|177->145|177->145|177->145|177->145|178->146|178->146|178->146|179->147|179->147|179->147|179->147|179->147|179->147|180->148|180->148|180->148|181->149|181->149|181->149|182->150|182->150|182->150|183->151|183->151|184->152|184->152|184->152|186->154|186->154|187->155|190->158|190->158|190->158|195->163|196->164|197->165|199->167|199->167|201->169|201->169
                    -- GENERATED --
                */
            