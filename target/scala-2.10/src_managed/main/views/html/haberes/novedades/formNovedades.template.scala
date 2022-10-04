
package views.html.haberes.novedades

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
object formNovedades extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.haberes.Novedad],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(nForm: Form[models.haberes.Novedad]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import models.auth._

import models.haberes._

implicit def /*6.2*/implicitFieldConstructor/*6.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.39*/("""
"""),format.raw/*3.1*/("""
"""),format.raw/*6.70*/(""" 
	
	<div class="row">

		<div class="col-sm-4">
			<label class="control-label">Puesto laboral</label>
			<div class="input-group """),_display_(Seq[Any](/*12.29*/if(nForm.error("puesto_laboral_id") != null)/*12.73*/ {_display_(Seq[Any](format.raw/*12.75*/("""has-error""")))}/*12.87*/else/*12.92*/{_display_(Seq[Any](format.raw/*12.93*/("""has-required""")))})),format.raw/*12.106*/("""">
				"""),_display_(Seq[Any](/*13.6*/inputText(nForm("puestoLaboral.legajo.agente.apellido"),'class -> "form-control", 'id -> "puesto_laboral"))),format.raw/*13.112*/("""
				"""),_display_(Seq[Any](/*14.6*/inputText(nForm("puesto_laboral_id"), 'hidden -> "hidden", 'id -> "puesto_laboral_id"))),format.raw/*14.92*/("""
				<span class="input-group-addon">
					<a href="#" class="searchModal"
								id="searchPuestoLaboral" 
								data-title="Selección de puesto laboral" 
								data-url=""""),_display_(Seq[Any](/*19.20*/controllers/*19.31*/.haberes.routes.PuestosLaboralesController.modalBuscar())),format.raw/*19.87*/("""" 
								data-height="650" 
								data-width="700" 
								data-listen="modal.seleccion.puestoLaboral.simple" 
								data-label="#puesto_laboral" 
								data-field="#puesto_laboral_id">
						<i class="glyphicon glyphicon-search"></i>
					</a>
				</span>
			</div>
			"""),_display_(Seq[Any](/*29.5*/nForm("puesto_laboral_id")/*29.31*/.error.map/*29.41*/{ error =>_display_(Seq[Any](format.raw/*29.51*/(""" <div class="text-error">"""),_display_(Seq[Any](/*29.77*/error/*29.82*/.message)),format.raw/*29.90*/("""</div>""")))})),format.raw/*29.97*/("""
		</div>
			
		<div class="col-sm-2">
			<label class="control-label">Periodo inicio</label> 
			<div class="form-group """),_display_(Seq[Any](/*34.28*/if(nForm.error("periodo_inicio_id") != null)/*34.72*/ {_display_(Seq[Any](format.raw/*34.74*/("""has-error""")))}/*34.85*/else/*34.90*/{_display_(Seq[Any](format.raw/*34.91*/("""has-required""")))})),format.raw/*34.104*/("""">
				<div class="input-group">
				"""),_display_(Seq[Any](/*36.6*/inputText(nForm("periodoInicio.nombre"),'class -> "form-control", 'id -> "periodo_inicio"))),format.raw/*36.96*/("""
				"""),_display_(Seq[Any](/*37.6*/inputText(nForm("periodo_inicio_id"),'hidden -> "hidden", 'id -> "periodo_inicio_id"))),format.raw/*37.91*/("""
				<span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchPeriodoInicio" 
									data-title="Selección de Periodo" 
									data-url=""""),_display_(Seq[Any](/*42.21*/controllers/*42.32*/.contabilidad.routes.PeriodosController.modalBuscar())),format.raw/*42.85*/("""" 
									data-height="650" 
									data-width="700" 
									data-listen="modal.seleccion.periodo.simple" 
									data-label="#periodo_inicio" 
									data-field="#periodo_inicio_id">
							<i class="glyphicon glyphicon-search"></i>
						</a>
					</span>
				</div>	
			</div>
			"""),_display_(Seq[Any](/*53.5*/nForm("periodo_inicio_id")/*53.31*/.error.map/*53.41*/{ error =>_display_(Seq[Any](format.raw/*53.51*/(""" <div class="text-error">"""),_display_(Seq[Any](/*53.77*/error/*53.82*/.message)),format.raw/*53.90*/("""</div>""")))})),format.raw/*53.97*/("""
		</div>
		
		<div class="col-sm-2">
			<label class="control-label">Periodo fin</label> 
			<div class="form-group """),_display_(Seq[Any](/*58.28*/if(nForm.error("periodo_hasta_id") != null)/*58.71*/ {_display_(Seq[Any](format.raw/*58.73*/("""has-error""")))}/*58.84*/else/*58.89*/{_display_(Seq[Any](format.raw/*58.90*/("""has-required""")))})),format.raw/*58.103*/("""">
				<div class="input-group">
				"""),_display_(Seq[Any](/*60.6*/inputText(nForm("periodoFin.nombre"),'class -> "form-control", 'id -> "periodo_fin"))),format.raw/*60.90*/("""
				"""),_display_(Seq[Any](/*61.6*/inputText(nForm("periodo_hasta_id"),'hidden -> "hidden", 'id -> "periodo_hasta_id"))),format.raw/*61.89*/("""
				<span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchPeriodoFin" 
									data-title="Selección de Periodo" 
									data-url=""""),_display_(Seq[Any](/*66.21*/controllers/*66.32*/.contabilidad.routes.PeriodosController.modalBuscar())),format.raw/*66.85*/("""" 
									data-height="650" 
									data-width="700" 
									data-listen="modal.seleccion.periodo.simple" 
									data-label="#periodo_fin" 
									data-field="#periodo_hasta_id">
							<i class="glyphicon glyphicon-search"></i>
						</a>
					</span>
				</div>	
			</div>
			"""),_display_(Seq[Any](/*77.5*/nForm("periodo_hasta_id")/*77.30*/.error.map/*77.40*/{ error =>_display_(Seq[Any](format.raw/*77.50*/(""" <div class="text-error">"""),_display_(Seq[Any](/*77.76*/error/*77.81*/.message)),format.raw/*77.89*/("""</div>""")))})),format.raw/*77.96*/("""
		</div>
		
		<div class="col-sm-2 """),_display_(Seq[Any](/*80.25*/if(nForm.error("liquidacion_tipo_id") != null)/*80.71*/ {_display_(Seq[Any](format.raw/*80.73*/("""has-error""")))}/*80.85*/else/*80.90*/{_display_(Seq[Any](format.raw/*80.91*/("""has-required""")))})),format.raw/*80.104*/("""">
			<label class="control-label">Tipo
			"""),_display_(Seq[Any](/*82.5*/select(nForm("liquidacion_tipo_id"), models.haberes.LiquidacionTipo.getTipos().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*82.183*/("""
			</label>
			"""),_display_(Seq[Any](/*84.5*/nForm("liquidacion_tipo_id")/*84.33*/.error.map/*84.43*/{ error =>_display_(Seq[Any](format.raw/*84.53*/(""" <div class="text-error">"""),_display_(Seq[Any](/*84.79*/error/*84.84*/.message)),format.raw/*84.92*/("""</div>""")))})),format.raw/*84.99*/("""
		</div>
		
	</div>
	
	<div class="row">
	
		<div class="col-sm-4">
			<label class="control-label">Concepto</label>
			<div class="input-group  """),_display_(Seq[Any](/*93.30*/if(nForm.error("liquidacion_concepto_id") != null)/*93.80*/ {_display_(Seq[Any](format.raw/*93.82*/("""has-error""")))}/*93.94*/else/*93.99*/{_display_(Seq[Any](format.raw/*93.100*/("""has-required""")))})),format.raw/*93.113*/("""">
				"""),_display_(Seq[Any](/*94.6*/inputText(nForm("concepto.denominacion"), 'class -> "form-control", 'id -> "concepto"))),format.raw/*94.92*/("""
				"""),_display_(Seq[Any](/*95.6*/inputText(nForm("liquidacion_concepto_id"), 'hidden -> "hidden", 'id -> "liquidacion_concepto_id"))),format.raw/*95.104*/("""
				<span class="input-group-addon"><a href="#" id="searchConcepto" data-title="Selección de concepto" data-url=""""),_display_(Seq[Any](/*96.115*/controllers/*96.126*/.haberes.routes.LiquidacionConceptosController.modalBuscar())),format.raw/*96.186*/("""" data-height="650" data-width="700" data-listen="modal.seleccion.concepto.simple" data-label="#concepto" data-field="#liquidacion_concepto_id"><i class="glyphicon glyphicon-search"></i></a></span>
			</div>
			"""),_display_(Seq[Any](/*98.5*/nForm("liquidacion_concepto_id")/*98.37*/.error.map/*98.47*/{ error =>_display_(Seq[Any](format.raw/*98.57*/(""" <div class="text-error">"""),_display_(Seq[Any](/*98.83*/error/*98.88*/.message)),format.raw/*98.96*/("""</div>""")))})),format.raw/*98.103*/("""
		</div>
	
		<div class="col-sm-2">
			<label for="cantidad" class="control-label">Cantidad</label>
			<div class="form-group """),_display_(Seq[Any](/*103.28*/if(nForm.error("cantidad") != null)/*103.63*/ {_display_(Seq[Any](format.raw/*103.65*/("""has-error""")))}/*103.76*/else/*103.81*/{_display_(Seq[Any](format.raw/*103.82*/("""has-required""")))})),format.raw/*103.95*/("""">
				"""),_display_(Seq[Any](/*104.6*/inputText(nForm("cantidad"), 'class -> "form-control", 'id -> "cantidad"))),format.raw/*104.79*/("""
				"""),_display_(Seq[Any](/*105.6*/nForm("cantidad")/*105.23*/.error.map/*105.33*/{ error =>_display_(Seq[Any](format.raw/*105.43*/(""" <div class="text-error">"""),_display_(Seq[Any](/*105.69*/error/*105.74*/.message)),format.raw/*105.82*/("""</div>""")))})),format.raw/*105.89*/("""
			</div>
		</div>
	
		<div class="col-sm-2">
			<label class="control-label">Importe</label>
			<div class="form-group """),_display_(Seq[Any](/*111.28*/if(nForm.error("importe") != null)/*111.62*/ {_display_(Seq[Any](format.raw/*111.64*/("""has-error""")))})),format.raw/*111.74*/("""">	
				"""),_display_(Seq[Any](/*112.6*/inputText(nForm("importe"), 'class -> "form-control", 'id -> "importe"))),format.raw/*112.77*/("""
				"""),_display_(Seq[Any](/*113.6*/nForm("importe")/*113.22*/.error.map/*113.32*/{ error =>_display_(Seq[Any](format.raw/*113.42*/(""" <div class="text-error">"""),_display_(Seq[Any](/*113.68*/error/*113.73*/.message)),format.raw/*113.81*/("""</div>""")))})),format.raw/*113.88*/("""
			</div>
		</div>
		
		
		<div class="col-sm-2">
			<label class="control-label">Importe tope</label>
			<div class="form-group """),_display_(Seq[Any](/*120.28*/if(nForm.error("importe_tope") != null)/*120.67*/ {_display_(Seq[Any](format.raw/*120.69*/("""has-error""")))})),format.raw/*120.79*/("""">	
				"""),_display_(Seq[Any](/*121.6*/inputText(nForm("importe_tope"), 'class -> "form-control", 'id -> "importe_tope"))),format.raw/*121.87*/("""
				"""),_display_(Seq[Any](/*122.6*/nForm("importe_tope")/*122.27*/.error.map/*122.37*/{ error =>_display_(Seq[Any](format.raw/*122.47*/(""" <div class="text-error">"""),_display_(Seq[Any](/*122.73*/error/*122.78*/.message)),format.raw/*122.86*/("""</div>""")))})),format.raw/*122.93*/("""
			</div>
		</div>
	
	</div>
	
	<hr />
	
	<div id="listaNovedades" data-href=""""),_display_(Seq[Any](/*130.39*/controllers/*130.50*/.haberes.routes.NovedadesController.lista())),format.raw/*130.93*/("""">
	
	</div>

	"""))}
    }
    
    def render(nForm:Form[models.haberes.Novedad]): play.api.templates.HtmlFormat.Appendable = apply(nForm)
    
    def f:((Form[models.haberes.Novedad]) => play.api.templates.HtmlFormat.Appendable) = (nForm) => apply(nForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:35 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/novedades/formNovedades.scala.html
                    HASH: cb0960eed2236cc0774cb3218f3030efa978fa5f
                    MATRIX: 822->1|1008->105|1040->129|1114->38|1141->56|1169->173|1337->305|1390->349|1430->351|1459->363|1472->368|1511->369|1557->382|1600->390|1729->496|1770->502|1878->588|2092->766|2112->777|2190->833|2505->1113|2540->1139|2559->1149|2607->1159|2669->1185|2683->1190|2713->1198|2752->1205|2910->1327|2963->1371|3003->1373|3032->1384|3045->1389|3084->1390|3130->1403|3203->1441|3315->1531|3356->1537|3463->1622|3674->1797|3694->1808|3769->1861|4098->2155|4133->2181|4152->2191|4200->2201|4262->2227|4276->2232|4306->2240|4345->2247|4499->2365|4551->2408|4591->2410|4620->2421|4633->2426|4672->2427|4718->2440|4791->2478|4897->2562|4938->2568|5043->2651|5251->2823|5271->2834|5346->2887|5671->3177|5705->3202|5724->3212|5772->3222|5834->3248|5848->3253|5878->3261|5917->3268|5990->3305|6045->3351|6085->3353|6114->3365|6127->3370|6166->3371|6212->3384|6291->3428|6492->3606|6544->3623|6581->3651|6600->3661|6648->3671|6710->3697|6724->3702|6754->3710|6793->3717|6976->3864|7035->3914|7075->3916|7104->3928|7117->3933|7157->3934|7203->3947|7246->3955|7354->4041|7395->4047|7516->4145|7668->4260|7689->4271|7772->4331|8019->4543|8060->4575|8079->4585|8127->4595|8189->4621|8203->4626|8233->4634|8273->4641|8438->4769|8483->4804|8524->4806|8554->4817|8568->4822|8608->4823|8654->4836|8698->4844|8794->4917|8836->4923|8863->4940|8883->4950|8932->4960|8995->4986|9010->4991|9041->4999|9081->5006|9240->5128|9284->5162|9325->5164|9368->5174|9413->5183|9507->5254|9549->5260|9575->5276|9595->5286|9644->5296|9707->5322|9722->5327|9753->5335|9793->5342|9961->5473|10010->5512|10051->5514|10094->5524|10139->5533|10243->5614|10285->5620|10316->5641|10336->5651|10385->5661|10448->5687|10463->5692|10494->5700|10534->5707|10651->5787|10672->5798|10738->5841
                    LINES: 26->1|33->6|33->6|34->1|35->3|36->6|42->12|42->12|42->12|42->12|42->12|42->12|42->12|43->13|43->13|44->14|44->14|49->19|49->19|49->19|59->29|59->29|59->29|59->29|59->29|59->29|59->29|59->29|64->34|64->34|64->34|64->34|64->34|64->34|64->34|66->36|66->36|67->37|67->37|72->42|72->42|72->42|83->53|83->53|83->53|83->53|83->53|83->53|83->53|83->53|88->58|88->58|88->58|88->58|88->58|88->58|88->58|90->60|90->60|91->61|91->61|96->66|96->66|96->66|107->77|107->77|107->77|107->77|107->77|107->77|107->77|107->77|110->80|110->80|110->80|110->80|110->80|110->80|110->80|112->82|112->82|114->84|114->84|114->84|114->84|114->84|114->84|114->84|114->84|123->93|123->93|123->93|123->93|123->93|123->93|123->93|124->94|124->94|125->95|125->95|126->96|126->96|126->96|128->98|128->98|128->98|128->98|128->98|128->98|128->98|128->98|133->103|133->103|133->103|133->103|133->103|133->103|133->103|134->104|134->104|135->105|135->105|135->105|135->105|135->105|135->105|135->105|135->105|141->111|141->111|141->111|141->111|142->112|142->112|143->113|143->113|143->113|143->113|143->113|143->113|143->113|143->113|150->120|150->120|150->120|150->120|151->121|151->121|152->122|152->122|152->122|152->122|152->122|152->122|152->122|152->122|160->130|160->130|160->130
                    -- GENERATED --
                */
            