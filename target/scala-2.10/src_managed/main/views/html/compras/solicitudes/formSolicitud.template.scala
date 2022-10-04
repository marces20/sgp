
package views.html.compras.solicitudes

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
object formSolicitud extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Solicitud],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(solicitudForm: Form[Solicitud]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import java.util.List

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.34*/("""
"""),format.raw/*4.70*/(""" 


	"""),_display_(Seq[Any](/*7.3*/inputText(solicitudForm("id"), 'type -> "hidden", 'id -> "solicitudId"))),format.raw/*7.74*/("""
	"""),_display_(Seq[Any](/*8.3*/inputText(solicitudForm("estado_id"), 'type -> "hidden", 'id -> "estado_id"))),format.raw/*8.79*/("""
    
	<div class="row">
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*12.28*/if(solicitudForm.error("referencia") != null)/*12.73*/ {_display_(Seq[Any](format.raw/*12.75*/("""has-error""")))})),format.raw/*12.85*/("""">
				<label for=""""),_display_(Seq[Any](/*13.18*/solicitudForm("referencia")/*13.45*/.id)),format.raw/*13.48*/("""" class="control-label">Referencia</label> 
				"""),_display_(Seq[Any](/*14.6*/inputText(solicitudForm("referencia"), 'class -> "form-control" , 'readOnly -> "readOnly"))),format.raw/*14.96*/("""
																				   
				"""),_display_(Seq[Any](/*16.6*/solicitudForm("referencia")/*16.33*/.error.map/*16.43*/{ error =>_display_(Seq[Any](format.raw/*16.53*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*17.31*/error/*17.36*/.message)),format.raw/*17.44*/("""</div>
				""")))})),format.raw/*18.6*/("""
			</div>
		</div>
		
		<div class="col-sm-3">
			<label for="solicitante" class="control-label">Solicitante</label> 
			<div class="input-group """),_display_(Seq[Any](/*24.29*/if(solicitudForm.error("solicitante.id") != null)/*24.78*/ {_display_(Seq[Any](format.raw/*24.80*/("""has-error""")))})),format.raw/*24.90*/("""">
				"""),_display_(Seq[Any](/*25.6*/inputText(solicitudForm("solicitante.nombreCompleto"),'class -> "form-control", 'id -> "solicitante"))),format.raw/*25.107*/("""
				"""),_display_(Seq[Any](/*26.6*/inputText(solicitudForm("solicitante.id"),'hidden -> "hidden", 'id ->"solicitante_id"))),format.raw/*26.92*/("""
				<span class="input-group-addon">
                	<a href="#" id="searchSolicitante" data-title="Selección de solicitante" data-url=""""),_display_(Seq[Any](/*28.102*/controllers/*28.113*/.rrhh.routes.AgentesController.modalBuscar())),format.raw/*28.157*/("""" data-height="650" data-width="700" data-listen="modal.seleccion.agente.simple" data-label="#solicitante" data-field="#solicitante_id" /> <i class="glyphicon glyphicon-search"></i></a>
               </span>
			</div>
		</div>
		
		<div class="col-sm-3">
			<label for="servicio" class="control-label">Servicio</label>
			<div class="input-group """),_display_(Seq[Any](/*35.29*/if(solicitudForm.error("departamento_id") != null)/*35.79*/ {_display_(Seq[Any](format.raw/*35.81*/("""has-error""")))}/*35.91*/else/*35.95*/{_display_(Seq[Any](format.raw/*35.96*/("""has-required""")))})),format.raw/*35.109*/(""""> 
				"""),_display_(Seq[Any](/*36.6*/inputText(solicitudForm("departamento.nombre"),'class -> "form-control", 'id -> "servicio", 'autocomplete -> "off"))),format.raw/*36.121*/("""
				"""),_display_(Seq[Any](/*37.6*/inputText(solicitudForm("departamento_id"),'hidden -> "hidden", 'id -> "servicio_id"))),format.raw/*37.91*/("""
				<span class="input-group-addon">
					<a href="#" id="searchServicio" data-title="Selección de servicio" data-url=""""),_display_(Seq[Any](/*39.84*/controllers/*39.95*/.rrhh.routes.DepartamentosController.modalBuscar())),format.raw/*39.145*/("""" data-height="650" data-width="700" data-listen="modal.seleccion.departamento.simple" data-label="#servicio" data-field="#servicio_id"><i class="glyphicon glyphicon-search"></i></a>
				</span>
			</div>
			"""),_display_(Seq[Any](/*42.5*/solicitudForm("departamento_id")/*42.37*/.error.map/*42.47*/{ error =>_display_(Seq[Any](format.raw/*42.57*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*43.30*/error/*43.35*/.message)),format.raw/*43.43*/("""</div>
			""")))})),format.raw/*44.5*/("""
		</div>
		
		<!-- <div class="col-sm-3">
			<div class="form-group """),_display_(Seq[Any](/*48.28*/if(solicitudForm.error("dirigida") != null)/*48.71*/ {_display_(Seq[Any](format.raw/*48.73*/("""has-error""")))})),format.raw/*48.83*/("""">
				<label for=""""),_display_(Seq[Any](/*49.18*/solicitudForm("dirigida")/*49.43*/.id)),format.raw/*49.46*/("""" class="control-label">Dirigido a</label>
				"""),_display_(Seq[Any](/*50.6*/select(solicitudForm("dirigida"), options("compras"->"A Compras","patrimonio"->"A Patrimonio"), 
				'class -> "form-control select"))),format.raw/*51.37*/("""
			</div>
		</div> -->
		<div class="col-sm-3">
			<label for="deposito" class="control-label">Institucion</label> 
			<div class="input-group """),_display_(Seq[Any](/*56.29*/if(solicitudForm.error("deposito_id") != null)/*56.75*/ {_display_(Seq[Any](format.raw/*56.77*/("""has-error""")))}/*56.87*/else/*56.91*/{_display_(Seq[Any](format.raw/*56.92*/("""has-required""")))})),format.raw/*56.105*/("""">
				"""),_display_(Seq[Any](/*57.6*/inputText(solicitudForm("deposito.nombre"),'class -> "form-control", 'id -> "deposito_nombre"))),format.raw/*57.100*/("""
				"""),_display_(Seq[Any](/*58.6*/inputText(solicitudForm("deposito_id"),'hidden -> "hidden", 'id -> "deposito_id"))),format.raw/*58.87*/("""
				<span class="input-group-addon">
                	<a href="#" id="searchDeposito" data-title="Selección de depósito" 
                	data-url=""""),_display_(Seq[Any](/*61.29*/controllers/*61.40*/.delegacion.routes.DepositosController.modalBuscar())),format.raw/*61.92*/("""" 
                	data-height="650" data-width="700" data-listen="modal.seleccion.deposito.simple" 
                	data-label="#deposito_nombre" data-field="#deposito_id" /> <i class="glyphicon glyphicon-search"></i></a>
                </span>
			</div>
			"""),_display_(Seq[Any](/*66.5*/solicitudForm("deposito_id")/*66.33*/.error.map/*66.43*/{ error =>_display_(Seq[Any](format.raw/*66.53*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*67.30*/error/*67.35*/.message)),format.raw/*67.43*/("""</div>
			""")))})),format.raw/*68.5*/("""
		</div>
		
	</div>
	<div class="row">
		<div class="col-sm-2">
			<label for="expediente" class="control-label">Expediente</label> 
			<div class="input-group """),_display_(Seq[Any](/*75.29*/if(solicitudForm.error("expediente_id") != null)/*75.77*/ {_display_(Seq[Any](format.raw/*75.79*/("""has-error""")))})),format.raw/*75.89*/("""">
				"""),_display_(Seq[Any](/*76.6*/inputText(solicitudForm("expediente.expedienteEjercicio"),'class -> "form-control", 'id -> "expediente"))),format.raw/*76.110*/("""
				"""),_display_(Seq[Any](/*77.6*/inputText(solicitudForm("expediente_id"),'hidden -> "hidden", 'id -> "expediente_id"))),format.raw/*77.91*/("""

				<span class="input-group-addon"><a href="#" id="searchExpediente" data-title="Selección de expediente" data-url=""""),_display_(Seq[Any](/*79.119*/controllers/*79.130*/.expediente.routes.ExpedientesController.modalBuscar())),format.raw/*79.184*/("""" data-height="650" data-width="700" data-listen="modal.seleccion.expediente.simple" data-label="#expediente" data-field="#expediente_id"><i class="glyphicon glyphicon-search"></i></a></span>
			</div>
		</div>
		<div class="col-sm-3">
			<label for="paciente" class="control-label">Paciente <span style="color:red" id="profeCliente"></span></label> 
				<div class="input-group """),_display_(Seq[Any](/*84.30*/if(solicitudForm.error("cliente.id") != null)/*84.75*/ {_display_(Seq[Any](format.raw/*84.77*/("""has-error""")))})),format.raw/*84.87*/("""">
				"""),_display_(Seq[Any](/*85.6*/inputText(solicitudForm("cliente.nombre"),'class -> "form-control", 'id -> "paciente", 'autocomplete -> "off"))),format.raw/*85.116*/("""
				"""),_display_(Seq[Any](/*86.6*/inputText(solicitudForm("cliente_id"),'hidden -> "hidden", 'id -> "paciente_id"))),format.raw/*86.86*/("""
				<span class="input-group-addon">
                	<a href="#" id="searchPaciente" data-title="Selección de paciente" data-url=""""),_display_(Seq[Any](/*88.96*/controllers/*88.107*/.compras.routes.ClientesController.modalBuscar())),format.raw/*88.155*/("""" data-height="650" data-width="700" data-listen="modal.seleccion.cliente.simple" data-label="#paciente" data-field="#paciente_id" /> <i class="glyphicon glyphicon-search"></i></a>
                </span>
                <span class="input-group-addon">
                	<a href="#" id="searchPacienteCarga" 
			                	data-title="Carga de paciente" 
			                	data-url=""""),_display_(Seq[Any](/*93.32*/controllers/*93.43*/.compras.routes.ClientesController.modalCarga())),format.raw/*93.90*/("""" 
			                	data-height="650" 
			                	data-width="700" 
			                	data-listen="modal.carga.cliente.simple" 
			                	data-label="#paciente" 
			                	data-field="#paciente_id" /> 
			                	<i class="glyphicon glyphicon-plus"></i></a>
                </span>
			</div>
		</div>

		<!-- <div class="col-sm-3">
			<div class="form-group """),_display_(Seq[Any](/*105.28*/if(solicitudForm.error("origen") != null)/*105.69*/ {_display_(Seq[Any](format.raw/*105.71*/("""has-error""")))})),format.raw/*105.81*/("""">
				<label for=""""),_display_(Seq[Any](/*106.18*/solicitudForm("origen")/*106.41*/.id)),format.raw/*106.44*/("""" class="control-label">Médico</label> 
				"""),_display_(Seq[Any](/*107.6*/inputText(solicitudForm("origen"),'class -> "form-control"))),format.raw/*107.65*/("""
			</div>
		</div> -->
		<div class="col-sm-3">
			<label for="medico" class="control-label">Medico Solicitante</label> 
			<div class="input-group """),_display_(Seq[Any](/*112.29*/if(solicitudForm.error("medico.id") != null)/*112.73*/ {_display_(Seq[Any](format.raw/*112.75*/("""has-error""")))})),format.raw/*112.85*/("""">
				"""),_display_(Seq[Any](/*113.6*/inputText(solicitudForm("medico.nombreCompleto"),'class -> "form-control", 'id -> "medico"))),format.raw/*113.97*/("""
				"""),_display_(Seq[Any](/*114.6*/inputText(solicitudForm("medico_id"),'hidden -> "hidden", 'id ->"medico_id"))),format.raw/*114.82*/("""
				<span class="input-group-addon">
                	<a href="#" id="searchMedico" 
                	data-title="Selección de Medico" 
                	data-url=""""),_display_(Seq[Any](/*118.29*/controllers/*118.40*/.rrhh.routes.AgentesController.modalBuscar())),format.raw/*118.84*/("""" 
                	data-height="650" 
                	data-width="700" 
                	data-listen="modal.seleccion.agente.simple" 
                	data-label="#medico" 
                	data-field="#medico_id" /> 
                	<i class="glyphicon glyphicon-search"></i></a>
               </span>
			
			</div>
		</div>
		<div class="col-sm-3">
			<div class="form-group """),_display_(Seq[Any](/*130.28*/if(solicitudForm.error("prioridad") != null)/*130.72*/ {_display_(Seq[Any](format.raw/*130.74*/("""has-error""")))})),format.raw/*130.84*/("""">
				<label for="prioridad" class="control-label">Prioridad</label>
				"""),_display_(Seq[Any](/*132.6*/select(solicitudForm("prioridad"), options("baja"->"Baja","media"->"Media","alta"->"Alta"), 'id -> "prioridad", 
				'class -> "form-control select"))),format.raw/*133.37*/("""
			</div>
		</div>
	</div>


	<div class="row">
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*141.28*/if(solicitudForm.error("date_start") != null)/*141.73*/ {_display_(Seq[Any](format.raw/*141.75*/("""has-error""")))})),format.raw/*141.85*/("""">
				<label for="fechaSolicitud" class="control-label">Fecha Solicitud</label> 
				"""),_display_(Seq[Any](/*143.6*/inputText(solicitudForm("date_start"),'class -> "form-control date"))),format.raw/*143.74*/("""
			</div>
			"""),_display_(Seq[Any](/*145.5*/solicitudForm("date_start")/*145.32*/.error.map/*145.42*/{ error =>_display_(Seq[Any](format.raw/*145.52*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*146.30*/error/*146.35*/.message)),format.raw/*146.43*/("""</div>
			""")))})),format.raw/*147.5*/("""
		</div>
		
		<!-- <div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*151.28*/if(solicitudForm.error("date_end") != null)/*151.71*/ {_display_(Seq[Any](format.raw/*151.73*/("""has-error""")))})),format.raw/*151.83*/("""">
				<label for="fechaLimite" class="control-label">Fecha Límite</label> 
				"""),_display_(Seq[Any](/*153.6*/inputText(solicitudForm("date_end"),'class -> "form-control date", 'id -> "fechaLimite"))),format.raw/*153.94*/("""
			</div>
			"""),_display_(Seq[Any](/*155.5*/solicitudForm("date_end")/*155.30*/.error.map/*155.40*/{ error =>_display_(Seq[Any](format.raw/*155.50*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*156.30*/error/*156.35*/.message)),format.raw/*156.43*/("""</div>
			""")))})),format.raw/*157.5*/("""
		</div> -->
		<div class="col-sm-4">
			<div class="col-sm-6">
				<div class="form-group """),_display_(Seq[Any](/*161.29*/if(solicitudForm.error("fecha_imputacion") != null)/*161.80*/ {_display_(Seq[Any](format.raw/*161.82*/("""has-error""")))})),format.raw/*161.92*/("""">
					<label for="inputFechaImputacion" class="control-label">Fecha preventiva</label> 
					"""),_display_(Seq[Any](/*163.7*/inputText(solicitudForm("fecha_imputacion"),'class -> "form-control date", 'id -> "inputFechaImputacion"))),format.raw/*163.112*/("""
				</div>
				"""),_display_(Seq[Any](/*165.6*/solicitudForm("fecha_imputacion")/*165.39*/.error.map/*165.49*/{ error =>_display_(Seq[Any](format.raw/*165.59*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*166.31*/error/*166.36*/.message)),format.raw/*166.44*/("""</div>
				""")))})),format.raw/*167.6*/("""
			</div>
			<div class="col-sm-6">
				<div class="form-group">
					<label class="control-label">Pedido Rismi</label>
					"""),_display_(Seq[Any](/*172.7*/inputText(solicitudForm("pedido_rismi_id"),'class -> "form-control"))),format.raw/*172.75*/("""
				</div>
			</div>
		</div> 
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*177.28*/if(solicitudForm.error("tipo_cuenta_id") != null)/*177.77*/ {_display_(Seq[Any](format.raw/*177.79*/("""has-error""")))})),format.raw/*177.89*/("""">
				<label for="tipo_cuenta" class="control-label">Tipo Cuenta</label>
				 
				<input type="hidden" name="creacion_orden_compra" id="creacion_orden_compra" value="auto"/>
				"""),_display_(Seq[Any](/*181.6*/select(solicitudForm("tipo_cuenta_id"), 
				TipoCuenta.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*182.126*/("""
			</div>
			"""),_display_(Seq[Any](/*184.5*/solicitudForm("tipo_cuenta_id")/*184.36*/.error.map/*184.46*/{ error =>_display_(Seq[Any](format.raw/*184.56*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*185.30*/error/*185.35*/.message)),format.raw/*185.43*/("""</div>
			""")))})),format.raw/*186.5*/("""
		</div>
		
		
		<div class="col-sm-3">
			<!--  <div class="col-sm-4">
				<div class="checkbox">
					<label>
						Profe """),_display_(Seq[Any](/*194.14*/checkbox(solicitudForm("profe")))),format.raw/*194.46*/("""
					</label>
				</div> 
			</div>-->
			<div class="col-sm-4">
				<div class="checkbox">
					<label>
						Repo stock """),_display_(Seq[Any](/*201.19*/checkbox(solicitudForm("repo_stock")))),format.raw/*201.56*/("""
					</label>
				</div> 
			</div>
			<div class="col-sm-4">
				<div class="checkbox">
					<label>
						Recuperable Profe """),_display_(Seq[Any](/*208.26*/checkbox(solicitudForm("recuperable")))),format.raw/*208.64*/("""
					</label>
				</div> 
			</div>
			<div class="col-sm-4">
				<div class="checkbox">
					<label>
						Entregado """),_display_(Seq[Any](/*215.18*/checkbox(solicitudForm("entregado")))),format.raw/*215.54*/("""
					</label>
				</div> 
			</div>
		</div>
		
		
	</div>"""))}
    }
    
    def render(solicitudForm:Form[Solicitud]): play.api.templates.HtmlFormat.Appendable = apply(solicitudForm)
    
    def f:((Form[Solicitud]) => play.api.templates.HtmlFormat.Appendable) = (solicitudForm) => apply(solicitudForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:46 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/solicitudes/formSolicitud.scala.html
                    HASH: e7648236caceea0b393c2a5cc456cc05fd4b853b
                    MATRIX: 811->1|968->75|1000->99|1074->33|1102->143|1142->149|1234->220|1271->223|1368->299|1481->376|1535->421|1575->423|1617->433|1673->453|1709->480|1734->483|1818->532|1930->622|1995->652|2031->679|2050->689|2098->699|2165->730|2179->735|2209->743|2252->755|2435->902|2493->951|2533->953|2575->963|2618->971|2742->1072|2783->1078|2891->1164|3067->1303|3088->1314|3155->1358|3539->1706|3598->1756|3638->1758|3667->1768|3680->1772|3719->1773|3765->1786|3809->1795|3947->1910|3988->1916|4095->2001|4252->2122|4272->2133|4345->2183|4589->2392|4630->2424|4649->2434|4697->2444|4763->2474|4777->2479|4807->2487|4849->2498|4955->2568|5007->2611|5047->2613|5089->2623|5145->2643|5179->2668|5204->2671|5287->2719|5442->2852|5623->2997|5678->3043|5718->3045|5747->3055|5760->3059|5799->3060|5845->3073|5888->3081|6005->3175|6046->3181|6149->3262|6336->3413|6356->3424|6430->3476|6728->3739|6765->3767|6784->3777|6832->3787|6898->3817|6912->3822|6942->3830|6984->3841|7182->4003|7239->4051|7279->4053|7321->4063|7364->4071|7491->4175|7532->4181|7639->4266|7796->4386|7817->4397|7894->4451|8310->4831|8364->4876|8404->4878|8446->4888|8489->4896|8622->5006|8663->5012|8765->5092|8934->5225|8955->5236|9026->5284|9454->5676|9474->5687|9543->5734|9982->6136|10033->6177|10074->6179|10117->6189|10174->6209|10207->6232|10233->6235|10314->6280|10396->6339|10583->6489|10637->6533|10678->6535|10721->6545|10765->6553|10879->6644|10921->6650|11020->6726|11222->6891|11243->6902|11310->6946|11729->7328|11783->7372|11824->7374|11867->7384|11978->7459|12150->7608|12288->7709|12343->7754|12384->7756|12427->7766|12550->7853|12641->7921|12692->7936|12729->7963|12749->7973|12798->7983|12865->8013|12880->8018|12911->8026|12954->8037|13061->8107|13114->8150|13155->8152|13198->8162|13315->8243|13426->8331|13477->8346|13512->8371|13532->8381|13581->8391|13648->8421|13663->8426|13694->8434|13737->8445|13867->8538|13928->8589|13969->8591|14012->8601|14144->8697|14273->8802|14326->8819|14369->8852|14389->8862|14438->8872|14506->8903|14521->8908|14552->8916|14596->8928|14759->9055|14850->9123|14971->9207|15030->9256|15071->9258|15114->9268|15331->9449|15521->9615|15572->9630|15613->9661|15633->9671|15682->9681|15749->9711|15764->9716|15795->9724|15838->9735|16001->9861|16056->9893|16217->10017|16277->10054|16442->10182|16503->10220|16660->10340|16719->10376
                    LINES: 26->1|31->4|31->4|32->1|33->4|36->7|36->7|37->8|37->8|41->12|41->12|41->12|41->12|42->13|42->13|42->13|43->14|43->14|45->16|45->16|45->16|45->16|46->17|46->17|46->17|47->18|53->24|53->24|53->24|53->24|54->25|54->25|55->26|55->26|57->28|57->28|57->28|64->35|64->35|64->35|64->35|64->35|64->35|64->35|65->36|65->36|66->37|66->37|68->39|68->39|68->39|71->42|71->42|71->42|71->42|72->43|72->43|72->43|73->44|77->48|77->48|77->48|77->48|78->49|78->49|78->49|79->50|80->51|85->56|85->56|85->56|85->56|85->56|85->56|85->56|86->57|86->57|87->58|87->58|90->61|90->61|90->61|95->66|95->66|95->66|95->66|96->67|96->67|96->67|97->68|104->75|104->75|104->75|104->75|105->76|105->76|106->77|106->77|108->79|108->79|108->79|113->84|113->84|113->84|113->84|114->85|114->85|115->86|115->86|117->88|117->88|117->88|122->93|122->93|122->93|134->105|134->105|134->105|134->105|135->106|135->106|135->106|136->107|136->107|141->112|141->112|141->112|141->112|142->113|142->113|143->114|143->114|147->118|147->118|147->118|159->130|159->130|159->130|159->130|161->132|162->133|170->141|170->141|170->141|170->141|172->143|172->143|174->145|174->145|174->145|174->145|175->146|175->146|175->146|176->147|180->151|180->151|180->151|180->151|182->153|182->153|184->155|184->155|184->155|184->155|185->156|185->156|185->156|186->157|190->161|190->161|190->161|190->161|192->163|192->163|194->165|194->165|194->165|194->165|195->166|195->166|195->166|196->167|201->172|201->172|206->177|206->177|206->177|206->177|210->181|211->182|213->184|213->184|213->184|213->184|214->185|214->185|214->185|215->186|223->194|223->194|230->201|230->201|237->208|237->208|244->215|244->215
                    -- GENERATED --
                */
            