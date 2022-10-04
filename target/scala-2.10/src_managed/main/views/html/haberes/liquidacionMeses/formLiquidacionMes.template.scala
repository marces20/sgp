
package views.html.haberes.liquidacionMeses

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
object formLiquidacionMes extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.haberes.LiquidacionMes],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lmForm: Form[models.haberes.LiquidacionMes]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

import models.haberes._

implicit def /*6.2*/implicitFieldConstructor/*6.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.47*/("""
"""),format.raw/*6.70*/(""" 
<script>
$( function()"""),format.raw/*8.14*/("""{"""),format.raw/*8.15*/(""" $('.searchModal').modalSearch();"""),format.raw/*8.48*/("""}"""),format.raw/*8.49*/(""")
</script>		
	<div class="row menu-acciones">
		<div class="col-sm-10">
			<button type="submit" class="btn btn-default" title="Guardar liquidacion"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>
			<a href=""""),_display_(Seq[Any](/*13.14*/if(request().getHeader("referer"))/*13.48*/{_display_(Seq[Any](format.raw/*13.49*/(""" """),_display_(Seq[Any](/*13.51*/request()/*13.60*/.getHeader("referer"))),format.raw/*13.81*/(""" """)))}/*13.84*/else/*13.89*/{_display_(Seq[Any](_display_(Seq[Any](/*13.91*/controllers/*13.102*/.haberes.routes.LiquidacionMesesController.index())),_display_(Seq[Any](/*13.153*/UriTrack/*13.161*/.decode()))))})),format.raw/*13.171*/("""" title="Cancelar editar" class="btn btn-default"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
		</div>
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*16.14*/UriTrack/*16.22*/.decode())),format.raw/*16.31*/("""" title="Volver al listado" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
		</div>	
	</div>
	<div class="row">
		<div class="col-sm-2">
			<b>Convenio Ministerio</b>
			<div class="row">
				<div class="col-sm-5">
					<div class="radio">
						<label class="control-label"> 
							"""),_display_(Seq[Any](/*26.9*/inputRadioGroup(lmForm("convenio_ministerio"), options = Seq("true"->"SI")))),format.raw/*26.84*/("""
						</label>
					</div>
				</div>
				<div class="col-sm-7">
					<div class="radio">
						<label class="control-label"> 
							"""),_display_(Seq[Any](/*33.9*/inputRadioGroup(lmForm("convenio_ministerio"),options = Seq("false"->"NO")))),format.raw/*33.84*/("""
						</label>
					</div>
				</div>
			</div>
			"""),_display_(Seq[Any](/*38.5*/lmForm("convenio_ministerio")/*38.34*/.error.map/*38.44*/{ error =>_display_(Seq[Any](format.raw/*38.54*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*39.31*/error/*39.36*/.message)),format.raw/*39.44*/("""</div>
				""")))})),format.raw/*40.6*/("""
		</div> 
	
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*44.28*/if(lmForm.error("nro_liquidacion_parque") != null)/*44.78*/ {_display_(Seq[Any](format.raw/*44.80*/("""has-error""")))}/*44.90*/else/*44.94*/{_display_(Seq[Any](format.raw/*44.95*/("""has-required""")))})),format.raw/*44.108*/("""">
				<label for="inputNroLiquidacionParque" class="control-label">N° Liquidación</label> 
				"""),_display_(Seq[Any](/*46.6*/inputText(lmForm("nro_liquidacion_parque"), 'class -> "form-control"))),format.raw/*46.75*/("""
				"""),_display_(Seq[Any](/*47.6*/lmForm("nro_liquidacion_parque")/*47.38*/.error.map/*47.48*/{ error =>_display_(Seq[Any](format.raw/*47.58*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*48.31*/error/*48.36*/.message)),format.raw/*48.44*/("""</div>
				""")))})),format.raw/*49.6*/("""
			</div>
		</div>
		
		<div class="col-sm-4">
			<div class="form-group """),_display_(Seq[Any](/*54.28*/if(lmForm.error("titulo") != null)/*54.62*/ {_display_(Seq[Any](format.raw/*54.64*/("""has-error""")))}/*54.74*/else/*54.78*/{_display_(Seq[Any](format.raw/*54.79*/("""has-required""")))})),format.raw/*54.92*/("""">
				<label for="inputTitulo" class="control-label">Titulo</label> 
				"""),_display_(Seq[Any](/*56.6*/inputText(lmForm("titulo"), 'class -> "form-control"))),format.raw/*56.59*/("""
				"""),_display_(Seq[Any](/*57.6*/lmForm("titulo")/*57.22*/.error.map/*57.32*/{ error =>_display_(Seq[Any](format.raw/*57.42*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*58.31*/error/*58.36*/.message)),format.raw/*58.44*/("""</div>
				""")))})),format.raw/*59.6*/("""
			</div>
		</div>
		
		<div class="col-sm-3">
			<div class="form-group """),_display_(Seq[Any](/*64.28*/if(lmForm.error("liquidacionTipo") != null)/*64.71*/ {_display_(Seq[Any](format.raw/*64.73*/("""has-error""")))}/*64.83*/else/*64.87*/{_display_(Seq[Any](format.raw/*64.88*/("""has-required""")))})),format.raw/*64.101*/("""">
				<label for=""""),_display_(Seq[Any](/*65.18*/lmForm("liquidacionTipo"))),format.raw/*65.43*/("""" class="control-label">Liquidacion Tipo</label>
				"""),_display_(Seq[Any](/*66.6*/select(lmForm("liquidacion_tipo_id"), 
				LiquidacionTipo.find.all().map { p => p.id.toString -> p.nombre}, 
				'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*68.65*/(""", 
				
				"""),_display_(Seq[Any](/*70.6*/lmForm("liquidacion_tipo_id")/*70.35*/.error.map/*70.45*/{ error =>_display_(Seq[Any](format.raw/*70.55*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*71.31*/error/*71.36*/.message)),format.raw/*71.44*/("""</div>
				""")))})),format.raw/*72.6*/("""
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*78.28*/if(lmForm.error("fecha_liquidacion") != null)/*78.73*/ {_display_(Seq[Any](format.raw/*78.75*/("""has-error""")))}/*78.85*/else/*78.89*/{_display_(Seq[Any](format.raw/*78.90*/("""has-required""")))})),format.raw/*78.103*/("""">
				<label for="fechaLiquidacion" class="control-label">Fecha Liquidacion</label> 
				"""),_display_(Seq[Any](/*80.6*/inputText(lmForm("fecha_liquidacion"),'class -> "form-control date"))),format.raw/*80.74*/("""
			</div>
			"""),_display_(Seq[Any](/*82.5*/lmForm("fecha_liquidacion")/*82.32*/.error.map/*82.42*/{ error =>_display_(Seq[Any](format.raw/*82.52*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*83.30*/error/*83.35*/.message)),format.raw/*83.43*/("""</div>
			""")))})),format.raw/*84.5*/("""
		</div>
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*87.28*/if(lmForm.error("periodo_id") != null)/*87.66*/ {_display_(Seq[Any](format.raw/*87.68*/("""has-error""")))}/*87.78*/else/*87.82*/{_display_(Seq[Any](format.raw/*87.83*/("""has-required""")))})),format.raw/*87.96*/("""">
				<label for="periodo" class="control-label">Periodo</label> 
				<div class="input-group">
					"""),_display_(Seq[Any](/*90.7*/inputText(lmForm("periodo.nombre"), 'class -> "form-control", 'id -> "periodo"))),format.raw/*90.86*/("""
					"""),_display_(Seq[Any](/*91.7*/inputText(lmForm("periodo_id"),'hidden -> "hidden", 'id -> "periodo_id"))),format.raw/*91.79*/("""
					<span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchPeriodo" 
									data-title="Selección de Periodo" 
									data-url=""""),_display_(Seq[Any](/*96.21*/controllers/*96.32*/.contabilidad.routes.PeriodosController.modalBuscar())),format.raw/*96.85*/("""" 
									data-height="650" 
									data-width="700" 
									data-listen="modal.seleccion.periodo.simple" 
									data-label="#periodo" 
									data-field="#periodo_id">
							<i class="glyphicon glyphicon-search"></i>
						</a>
					</span>
				</div>
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*109.28*/if(lmForm.error("expediente_id") != null)/*109.69*/ {_display_(Seq[Any](format.raw/*109.71*/("""has-error""")))}/*109.81*/else/*109.85*/{_display_(Seq[Any](format.raw/*109.86*/("""has-required""")))})),format.raw/*109.99*/("""">
				<label for="inputExpediente" class="control-label">Expediente</label>
				<div class="input-group">
					"""),_display_(Seq[Any](/*112.7*/inputText(lmForm("expediente.expedienteEjercicio"),'class -> "form-control",'id -> "expediente"))),format.raw/*112.103*/("""
					"""),_display_(Seq[Any](/*113.7*/inputText(lmForm("expediente_id"),'hidden -> "hidden", 'id -> "expediente_id"))),format.raw/*113.85*/("""
					<span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchExpediente" 
									data-title="Selección de expediente" 
									data-url=""""),_display_(Seq[Any](/*118.21*/controllers/*118.32*/.expediente.routes.ExpedientesController.modalBuscar())),format.raw/*118.86*/("""" 
									data-height="650" 
									data-width="700" 
									data-listen="modal.seleccion.expediente.simple" 
									data-label="#expediente" 
									data-field="#expediente_id">
							<i class="glyphicon glyphicon-search"></i>
						</a>
					</span>
				</div>
				"""),_display_(Seq[Any](/*128.6*/lmForm("expediente_id")/*128.29*/.error.map/*128.39*/{ error =>_display_(Seq[Any](format.raw/*128.49*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*129.31*/error/*129.36*/.message)),format.raw/*129.44*/("""</div>
				""")))})),format.raw/*130.6*/("""
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*134.28*/if(lmForm.error("orden_pago_id") != null)/*134.69*/ {_display_(Seq[Any](format.raw/*134.71*/("""has-error""")))})),format.raw/*134.81*/("""">
				<label for="orden_pago_id" class="control-label">Orden de pago N° </label>
					<div class="input-group">
						"""),_display_(Seq[Any](/*137.8*/inputText(lmForm("ordenPago.nombreCompleto"), 'class -> "form-control", 'id -> "orden_pago"))),format.raw/*137.100*/("""
						"""),_display_(Seq[Any](/*138.8*/inputText(lmForm("orden_pago_id"),'hidden -> "hidden", 'id -> "orden_pago_id"))),format.raw/*138.86*/("""
						<span class="input-group-addon">
							<a href="#" class="searchModal"
										id="searchOrdenPago" 
										data-title="Selección de órdenes de pago" 
										data-url=""""),_display_(Seq[Any](/*143.22*/controllers/*143.33*/.contabilidad.routes.OrdenesPagosController.modalBuscar())),format.raw/*143.90*/("""" 
										data-height="650" 
										data-width="700" 
										data-listen="modal.seleccion.orden-pago.simple" 
										data-label="#orden_pago" 
										data-field="#orden_pago_id">
								<i class="glyphicon glyphicon-search"></i>
							</a>
						</span>
					</div>
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*156.28*/if(lmForm.error("fecha_orden_pago") != null)/*156.72*/ {_display_(Seq[Any](format.raw/*156.74*/("""has-error""")))})),format.raw/*156.84*/("""">
				<label for="fecha_orden_pago" class="control-label">Fecha orden de pago</label> 
				"""),_display_(Seq[Any](/*158.6*/inputText(lmForm("fecha_orden_pago"),'class -> "form-control date", 'id -> "fecha_orden_pago"))),format.raw/*158.100*/("""
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*162.28*/if(lmForm.error("fecha_pago") != null)/*162.66*/ {_display_(Seq[Any](format.raw/*162.68*/("""has-error""")))})),format.raw/*162.78*/("""">
				<label for="fecha_pago" class="control-label">Fecha de pago</label> 
				"""),_display_(Seq[Any](/*164.6*/inputText(lmForm("fecha_pago"),'class -> "form-control date", 'id -> "fecha_pago"))),format.raw/*164.88*/("""
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*170.28*/if(lmForm.error("expediente_aporte_id") != null)/*170.76*/ {_display_(Seq[Any](format.raw/*170.78*/("""has-error""")))}/*170.88*/else/*170.92*/{_display_(Seq[Any](format.raw/*170.93*/("""has-required""")))})),format.raw/*170.106*/("""">
				<label for="inputExpediente" class="control-label">Expediente Aporte</label>
				<div class="input-group">
					"""),_display_(Seq[Any](/*173.7*/inputText(lmForm("expedienteAporte.expedienteEjercicio"),'class -> "form-control",'id -> "expediente_aporte"))),format.raw/*173.116*/("""
					"""),_display_(Seq[Any](/*174.7*/inputText(lmForm("expediente_aporte_id"),'hidden -> "hidden", 'id -> "expediente_aporte_id"))),format.raw/*174.99*/("""
					<span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchExpediente0" 
									data-title="Selección de expediente" 
									data-url=""""),_display_(Seq[Any](/*179.21*/controllers/*179.32*/.expediente.routes.ExpedientesController.modalBuscar())),format.raw/*179.86*/("""" 
									data-height="650" 
									data-width="700" 
									data-listen="modal.seleccion.expediente.simple" 
									data-label="#expediente_aporte" 
									data-field="#expediente_aporte_id">
							<i class="glyphicon glyphicon-search"></i>
						</a>
					</span>
				</div>
				"""),_display_(Seq[Any](/*189.6*/lmForm("expediente_aporte_id")/*189.36*/.error.map/*189.46*/{ error =>_display_(Seq[Any](format.raw/*189.56*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*190.31*/error/*190.36*/.message)),format.raw/*190.44*/("""</div>
				""")))})),format.raw/*191.6*/("""
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*195.28*/if(lmForm.error("expediente_segurovida_id") != null)/*195.80*/ {_display_(Seq[Any](format.raw/*195.82*/("""has-error""")))}/*195.92*/else/*195.96*/{_display_(Seq[Any](format.raw/*195.97*/("""has-required""")))})),format.raw/*195.110*/("""">
				<label for="inputExpediente" class="control-label">Exp. Seguro Vida</label>
				<div class="input-group">
					"""),_display_(Seq[Any](/*198.7*/inputText(lmForm("expedienteSeguroVida.expedienteEjercicio"),'class -> "form-control",'id -> "expediente_segurovida"))),format.raw/*198.124*/("""
					"""),_display_(Seq[Any](/*199.7*/inputText(lmForm("expediente_segurovida_id"),'hidden -> "hidden", 'id -> "expediente_segurovida_id"))),format.raw/*199.107*/("""
					<span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchExpediente1" 
									data-title="Selección de expediente" 
									data-url=""""),_display_(Seq[Any](/*204.21*/controllers/*204.32*/.expediente.routes.ExpedientesController.modalBuscar())),format.raw/*204.86*/("""" 
									data-height="650" 
									data-width="700" 
									data-listen="modal.seleccion.expediente.simple" 
									data-label="#expediente_segurovida" 
									data-field="#expediente_segurovida_id">
							<i class="glyphicon glyphicon-search"></i>
						</a>
					</span>
				</div>
				"""),_display_(Seq[Any](/*214.6*/lmForm("expediente_segurovida_id")/*214.40*/.error.map/*214.50*/{ error =>_display_(Seq[Any](format.raw/*214.60*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*215.31*/error/*215.36*/.message)),format.raw/*215.44*/("""</div>
				""")))})),format.raw/*216.6*/("""
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*220.28*/if(lmForm.error("expediente_segurosepelio_id") != null)/*220.83*/ {_display_(Seq[Any](format.raw/*220.85*/("""has-error""")))}/*220.95*/else/*220.99*/{_display_(Seq[Any](format.raw/*220.100*/("""has-required""")))})),format.raw/*220.113*/("""">
				<label for="inputExpediente" class="control-label">Exp. Seguro Sepelio</label>
				<div class="input-group">
					"""),_display_(Seq[Any](/*223.7*/inputText(lmForm("expedienteSeguroSepelio.expedienteEjercicio"),'class -> "form-control",'id -> "expediente_segurosepelio"))),format.raw/*223.130*/("""
					"""),_display_(Seq[Any](/*224.7*/inputText(lmForm("expediente_segurosepelio_id"),'hidden -> "hidden", 'id -> "expediente_segurosepelio_id"))),format.raw/*224.113*/("""
					<span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchExpediente2" 
									data-title="Selección de expediente" 
									data-url=""""),_display_(Seq[Any](/*229.21*/controllers/*229.32*/.expediente.routes.ExpedientesController.modalBuscar())),format.raw/*229.86*/("""" 
									data-height="650" 
									data-width="700" 
									data-listen="modal.seleccion.expediente.simple" 
									data-label="#expediente_segurosepelio" 
									data-field="#expediente_segurosepelio_id">
							<i class="glyphicon glyphicon-search"></i>
						</a>
					</span>
				</div>
				"""),_display_(Seq[Any](/*239.6*/lmForm("expediente_segurosepelio_id")/*239.43*/.error.map/*239.53*/{ error =>_display_(Seq[Any](format.raw/*239.63*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*240.31*/error/*240.36*/.message)),format.raw/*240.44*/("""</div>
				""")))})),format.raw/*241.6*/("""
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*245.28*/if(lmForm.error("expediente_contribuciones_id") != null)/*245.84*/ {_display_(Seq[Any](format.raw/*245.86*/("""has-error""")))}/*245.96*/else/*245.100*/{_display_(Seq[Any](format.raw/*245.101*/("""has-required""")))})),format.raw/*245.114*/("""">
				<label for="inputExpediente" class="control-label">Exp. Contribuciones</label>
				<div class="input-group">
					"""),_display_(Seq[Any](/*248.7*/inputText(lmForm("expedienteContribuciones.expedienteEjercicio"),'class -> "form-control",'id -> "expediente_contribuciones"))),format.raw/*248.132*/("""
					"""),_display_(Seq[Any](/*249.7*/inputText(lmForm("expediente_contribuciones_id"),'hidden -> "hidden", 'id -> "expediente_contribuciones_id"))),format.raw/*249.115*/("""
					<span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchExpediente2" 
									data-title="Selección de expediente" 
									data-url=""""),_display_(Seq[Any](/*254.21*/controllers/*254.32*/.expediente.routes.ExpedientesController.modalBuscar())),format.raw/*254.86*/("""" 
									data-height="650" 
									data-width="700" 
									data-listen="modal.seleccion.expediente.simple" 
									data-label="#expediente_contribuciones" 
									data-field="#expediente_contribuciones_id">
							<i class="glyphicon glyphicon-search"></i>
						</a>
					</span>
				</div>
				"""),_display_(Seq[Any](/*264.6*/lmForm("expediente_contribuciones_id")/*264.44*/.error.map/*264.54*/{ error =>_display_(Seq[Any](format.raw/*264.64*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*265.31*/error/*265.36*/.message)),format.raw/*265.44*/("""</div>
				""")))})),format.raw/*266.6*/("""
			</div>
		</div>
		<div class="col-sm-4">
			<label for=""""),_display_(Seq[Any](/*270.17*/lmForm("comentario"))),format.raw/*270.37*/("""" class="control-label">Comentario</label>
			"""),_display_(Seq[Any](/*271.5*/textarea(lmForm("comentario"), 'class -> "form-control", 'rows -> 5))),format.raw/*271.73*/("""
		</div>
	</div>
	<div class="row">
		
	</div>
	"""))}
    }
    
    def render(lmForm:Form[models.haberes.LiquidacionMes]): play.api.templates.HtmlFormat.Appendable = apply(lmForm)
    
    def f:((Form[models.haberes.LiquidacionMes]) => play.api.templates.HtmlFormat.Appendable) = (lmForm) => apply(lmForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/liquidacionMeses/formLiquidacionMes.scala.html
                    HASH: ac8e24144d7df59e223801031ff9258a8c812e60
                    MATRIX: 841->1|1051->128|1083->152|1157->46|1185->196|1236->220|1264->221|1324->254|1352->255|1616->483|1659->517|1698->518|1736->520|1754->529|1797->550|1818->553|1831->558|1879->560|1900->571|1982->622|2000->630|2037->640|2233->800|2250->808|2281->817|2624->1125|2721->1200|2892->1336|2989->1411|3077->1464|3115->1493|3134->1503|3182->1513|3249->1544|3263->1549|3293->1557|3336->1569|3437->1634|3496->1684|3536->1686|3565->1696|3578->1700|3617->1701|3663->1714|3795->1811|3886->1880|3927->1886|3968->1918|3987->1928|4035->1938|4102->1969|4116->1974|4146->1982|4189->1994|4300->2069|4343->2103|4383->2105|4412->2115|4425->2119|4464->2120|4509->2133|4619->2208|4694->2261|4735->2267|4760->2283|4779->2293|4827->2303|4894->2334|4908->2339|4938->2347|4981->2359|5092->2434|5144->2477|5184->2479|5213->2489|5226->2493|5265->2494|5311->2507|5367->2527|5414->2552|5503->2606|5699->2780|5747->2793|5785->2822|5804->2832|5852->2842|5919->2873|5933->2878|5963->2886|6006->2898|6141->2997|6195->3042|6235->3044|6264->3054|6277->3058|6316->3059|6362->3072|6488->3163|6578->3231|6628->3246|6664->3273|6683->3283|6731->3293|6797->3323|6811->3328|6841->3336|6883->3347|6981->3409|7028->3447|7068->3449|7097->3459|7110->3463|7149->3464|7194->3477|7332->3580|7433->3659|7475->3666|7569->3738|7775->3908|7795->3919|7870->3972|8243->4308|8294->4349|8335->4351|8365->4361|8379->4365|8419->4366|8465->4379|8614->4492|8734->4588|8777->4595|8878->4673|9091->4849|9112->4860|9189->4914|9504->5193|9537->5216|9557->5226|9606->5236|9674->5267|9689->5272|9720->5280|9764->5292|9873->5364|9924->5405|9965->5407|10008->5417|10164->5537|10280->5629|10324->5637|10425->5715|10647->5900|10668->5911|10748->5968|11139->6322|11193->6366|11234->6368|11277->6378|11406->6471|11524->6565|11633->6637|11681->6675|11722->6677|11765->6687|11882->6768|11987->6850|12123->6949|12181->6997|12222->6999|12252->7009|12266->7013|12306->7014|12353->7027|12509->7147|12642->7256|12685->7263|12800->7355|13014->7532|13035->7543|13112->7597|13441->7890|13481->7920|13501->7930|13550->7940|13618->7971|13633->7976|13664->7984|13708->7996|13817->8068|13879->8120|13920->8122|13950->8132|13964->8136|14004->8137|14051->8150|14206->8269|14347->8386|14390->8393|14514->8493|14728->8670|14749->8681|14826->8735|15163->9036|15207->9070|15227->9080|15276->9090|15344->9121|15359->9126|15390->9134|15434->9146|15543->9218|15608->9273|15649->9275|15679->9285|15693->9289|15734->9290|15781->9303|15939->9425|16086->9548|16129->9555|16259->9661|16473->9838|16494->9849|16571->9903|16914->10210|16961->10247|16981->10257|17030->10267|17098->10298|17113->10303|17144->10311|17188->10323|17297->10395|17363->10451|17404->10453|17434->10463|17449->10467|17490->10468|17537->10481|17695->10603|17844->10728|17887->10735|18019->10843|18233->11020|18254->11031|18331->11085|18676->11394|18724->11432|18744->11442|18793->11452|18861->11483|18876->11488|18907->11496|18951->11508|19049->11569|19092->11589|19175->11636|19266->11704
                    LINES: 26->1|35->6|35->6|36->1|37->6|39->8|39->8|39->8|39->8|44->13|44->13|44->13|44->13|44->13|44->13|44->13|44->13|44->13|44->13|44->13|44->13|44->13|47->16|47->16|47->16|57->26|57->26|64->33|64->33|69->38|69->38|69->38|69->38|70->39|70->39|70->39|71->40|75->44|75->44|75->44|75->44|75->44|75->44|75->44|77->46|77->46|78->47|78->47|78->47|78->47|79->48|79->48|79->48|80->49|85->54|85->54|85->54|85->54|85->54|85->54|85->54|87->56|87->56|88->57|88->57|88->57|88->57|89->58|89->58|89->58|90->59|95->64|95->64|95->64|95->64|95->64|95->64|95->64|96->65|96->65|97->66|99->68|101->70|101->70|101->70|101->70|102->71|102->71|102->71|103->72|109->78|109->78|109->78|109->78|109->78|109->78|109->78|111->80|111->80|113->82|113->82|113->82|113->82|114->83|114->83|114->83|115->84|118->87|118->87|118->87|118->87|118->87|118->87|118->87|121->90|121->90|122->91|122->91|127->96|127->96|127->96|140->109|140->109|140->109|140->109|140->109|140->109|140->109|143->112|143->112|144->113|144->113|149->118|149->118|149->118|159->128|159->128|159->128|159->128|160->129|160->129|160->129|161->130|165->134|165->134|165->134|165->134|168->137|168->137|169->138|169->138|174->143|174->143|174->143|187->156|187->156|187->156|187->156|189->158|189->158|193->162|193->162|193->162|193->162|195->164|195->164|201->170|201->170|201->170|201->170|201->170|201->170|201->170|204->173|204->173|205->174|205->174|210->179|210->179|210->179|220->189|220->189|220->189|220->189|221->190|221->190|221->190|222->191|226->195|226->195|226->195|226->195|226->195|226->195|226->195|229->198|229->198|230->199|230->199|235->204|235->204|235->204|245->214|245->214|245->214|245->214|246->215|246->215|246->215|247->216|251->220|251->220|251->220|251->220|251->220|251->220|251->220|254->223|254->223|255->224|255->224|260->229|260->229|260->229|270->239|270->239|270->239|270->239|271->240|271->240|271->240|272->241|276->245|276->245|276->245|276->245|276->245|276->245|276->245|279->248|279->248|280->249|280->249|285->254|285->254|285->254|295->264|295->264|295->264|295->264|296->265|296->265|296->265|297->266|301->270|301->270|302->271|302->271
                    -- GENERATED --
                */
            