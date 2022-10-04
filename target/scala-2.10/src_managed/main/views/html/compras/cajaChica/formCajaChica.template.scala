
package views.html.compras.cajaChica

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
object formCajaChica extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[CajaChica],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(cajaForm: Form[CajaChica]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.29*/("""
"""),format.raw/*4.70*/(""" 



<div class="row menu-acciones">
	<div class="col-sm-10">
		<button type="submit" class="btn btn-default" title="Guardar caja"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>	
																															   
    	<a href=""""),_display_(Seq[Any](/*12.16*/if(request().getHeader("referer"))/*12.50*/{_display_(Seq[Any](format.raw/*12.51*/(""" """),_display_(Seq[Any](/*12.53*/request()/*12.62*/.getHeader("referer"))),format.raw/*12.83*/(""" """)))}/*12.86*/else/*12.91*/{_display_(Seq[Any](_display_(Seq[Any](/*12.93*/controllers/*12.104*/.compras.routes.CajaChicaController.index())),_display_(Seq[Any](/*12.148*/UriTrack/*12.156*/.decode()))))})),format.raw/*12.166*/("""" title="Cancelar editar" class="btn btn-default"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
    </div>
	<div class="col-sm-2">
		<a href=""""),_display_(Seq[Any](/*15.13*/UriTrack/*15.21*/.decode())),format.raw/*15.30*/("""" title="Volver al listado" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
		"""),_display_(Seq[Any](/*16.4*/if(cajaForm.field("id").value)/*16.34*/{_display_(Seq[Any](format.raw/*16.35*/("""<a href=""""),_display_(Seq[Any](/*16.45*/controllers/*16.56*/.compras.routes.CajaChicaController.ver(cajaForm.field("id").value.toLong))),_display_(Seq[Any](/*16.131*/UriTrack/*16.139*/.get("&"))),format.raw/*16.148*/("""" title="Ver orden" class="btn btn-default"><i class="glyphicon glyphicon-align-justify"></i></a>""")))})),format.raw/*16.246*/("""
	</div>
</div>
	
	
	"""),_display_(Seq[Any](/*21.3*/inputText(cajaForm("id"), 'type -> "hidden", 'id -> "cajaId"))),format.raw/*21.64*/("""
	"""),_display_(Seq[Any](/*22.3*/inputText(cajaForm("estado_id"), 'type -> "hidden", 'id -> "estadoId"))),format.raw/*22.73*/("""
	<input type="hidden" name="""),_display_(Seq[Any](/*23.29*/UriTrack/*23.37*/.getKey())),format.raw/*23.46*/(""" value=""""),_display_(Seq[Any](/*23.55*/UriTrack/*23.63*/.code())),format.raw/*23.70*/("""" />
	<div class="row">
		<div class="col-sm-2">
			<label class="control-label">Nombre</label> 
			<div class="form-group """),_display_(Seq[Any](/*27.28*/if(cajaForm.error("nombre") != null)/*27.64*/ {_display_(Seq[Any](format.raw/*27.66*/("""has-error""")))})),format.raw/*27.76*/("""">
				"""),_display_(Seq[Any](/*28.6*/inputText(cajaForm("nombre"), 'class -> "form-control",'readOnly -> "readOnly"))),format.raw/*28.85*/("""
				"""),_display_(Seq[Any](/*29.6*/cajaForm("nombre")/*29.24*/.error.map/*29.34*/{ error =>_display_(Seq[Any](format.raw/*29.44*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*30.31*/error/*30.36*/.message)),format.raw/*30.44*/("""</div>
				""")))})),format.raw/*31.6*/("""
			</div>
		</div>
		<div class="col-sm-2">
			<label class="control-label" for="referencia">Referencia</label> 
			<div class="form-group """),_display_(Seq[Any](/*36.28*/if(cajaForm.error("referencia") != null)/*36.68*/ {_display_(Seq[Any](format.raw/*36.70*/("""has-error""")))})),format.raw/*36.80*/("""">
				"""),_display_(Seq[Any](/*37.6*/inputText(cajaForm("referencia"), 'class -> "form-control", 'id -> "referencia"))),format.raw/*37.86*/("""
				"""),_display_(Seq[Any](/*38.6*/cajaForm("referencia")/*38.28*/.error.map/*38.38*/{ error =>_display_(Seq[Any](format.raw/*38.48*/(""" <div class="text-error">"""),_display_(Seq[Any](/*38.74*/error/*38.79*/.message)),format.raw/*38.87*/("""</div>""")))})),format.raw/*38.94*/("""
			</div>
		</div>
		<div class="col-sm-2">
			<label class="control-label" for="fecha">Fecha</label> 
			<div class="form-group """),_display_(Seq[Any](/*43.28*/if(cajaForm.error("fecha") != null)/*43.63*/ {_display_(Seq[Any](format.raw/*43.65*/("""has-error""")))}/*43.76*/else/*43.81*/{_display_(Seq[Any](format.raw/*43.82*/("""has-required""")))})),format.raw/*43.95*/("""">
				"""),_display_(Seq[Any](/*44.6*/inputText(cajaForm("fecha"),'class -> "form-control date", 'autocomplete -> "off", 'id -> "fecha"))),format.raw/*44.104*/("""
			</div>
			"""),_display_(Seq[Any](/*46.5*/cajaForm("fecha")/*46.22*/.error.map/*46.32*/{ error =>_display_(Seq[Any](format.raw/*46.42*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*47.30*/error/*47.35*/.message)),format.raw/*47.43*/("""</div>
			""")))})),format.raw/*48.5*/("""
		</div>
		
		<div class="col-sm-2">
			<label class="control-label" for="monto_limite">Monto límite</label>
			<div class="form-group """),_display_(Seq[Any](/*53.28*/if(cajaForm.error("monto_limite") != null)/*53.70*/ {_display_(Seq[Any](format.raw/*53.72*/("""has-error""")))}/*53.83*/else/*53.88*/{_display_(Seq[Any](format.raw/*53.89*/("""has-required""")))})),format.raw/*53.102*/("""">
				"""),_display_(Seq[Any](/*54.6*/inputText(cajaForm("monto_limite"), 'class -> "form-control", 'id -> "monto_limite"))),format.raw/*54.90*/("""
				"""),_display_(Seq[Any](/*55.6*/cajaForm("monto_limite")/*55.30*/.error.map/*55.40*/{ error =>_display_(Seq[Any](format.raw/*55.50*/(""" <div class="text-error">"""),_display_(Seq[Any](/*55.76*/error/*55.81*/.message)),format.raw/*55.89*/("""</div>""")))})),format.raw/*55.96*/("""
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*59.28*/if(cajaForm.error("numero_cheque") != null)/*59.71*/ {_display_(Seq[Any](format.raw/*59.73*/("""has-error""")))})),format.raw/*59.83*/("""">
				<label for="inputNCheque" class="control-label">N° Cheque</label> 
				"""),_display_(Seq[Any](/*61.6*/inputText(cajaForm("numero_cheque"), 'class -> "form-control"))),format.raw/*61.68*/("""
			</div>
			"""),_display_(Seq[Any](/*63.5*/cajaForm("numero_cheque")/*63.30*/.error.map/*63.40*/{ error =>_display_(Seq[Any](format.raw/*63.50*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*64.30*/error/*64.35*/.message)),format.raw/*64.43*/("""</div>
			""")))})),format.raw/*65.5*/("""
		</div>
		<div class="col-sm-2">
			<label class="control-label" for="monto_cheque">Monto Cheque</label>
			<div class="form-group">
				"""),_display_(Seq[Any](/*70.6*/inputText(cajaForm("monto_cheque"), 'class -> "form-control", 'id -> "monto_cheque"))),format.raw/*70.90*/("""
				
			</div>
		</div>
	</div>	
	<div class="row">	
		<div class="col-sm-4">
			<label for="deposito" class="control-label">Institucion</label> 
			<div class="input-group """),_display_(Seq[Any](/*78.29*/if(cajaForm.error("deposito_id") != null)/*78.70*/ {_display_(Seq[Any](format.raw/*78.72*/("""has-error""")))}/*78.82*/else/*78.86*/{_display_(Seq[Any](format.raw/*78.87*/("""has-required""")))})),format.raw/*78.100*/("""">
				"""),_display_(Seq[Any](/*79.6*/inputText(cajaForm("deposito.nombre"),'class -> "form-control", 'id -> "deposito_nombre", 'autocomplete -> "off"))),format.raw/*79.119*/("""
				"""),_display_(Seq[Any](/*80.6*/inputText(cajaForm("deposito_id"),'hidden -> "hidden", 'id -> "deposito_id"))),format.raw/*80.82*/("""
				<span class="input-group-addon">
                	<a href="#" id="searchDeposito" data-title="Selección de Institucion" 
                	data-url=""""),_display_(Seq[Any](/*83.29*/controllers/*83.40*/.delegacion.routes.DepositosController.modalBuscar())),format.raw/*83.92*/("""" 
                	data-height="650" data-width="700" 
                	data-listen="modal.seleccion.deposito.simple" 
                	data-label="#deposito_nombre" data-field="#deposito_id" /> <i class="glyphicon glyphicon-search"></i></a>
                </span>
			</div>
			"""),_display_(Seq[Any](/*89.5*/cajaForm("deposito_id")/*89.28*/.error.map/*89.38*/{ error =>_display_(Seq[Any](format.raw/*89.48*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*90.30*/error/*90.35*/.message)),format.raw/*90.43*/("""</div>
			""")))})),format.raw/*91.5*/("""
		</div>		

		<div class="col-sm-2">
			<label for="expediente" class="control-label" for="expediente">Expediente</label> 
			<div class="input-group """),_display_(Seq[Any](/*96.29*/if(cajaForm.error("expediente_id") != null)/*96.72*/ {_display_(Seq[Any](format.raw/*96.74*/("""has-error""")))}/*96.84*/else/*96.88*/{_display_(Seq[Any](format.raw/*96.89*/("""has-required""")))})),format.raw/*96.102*/("""">
				"""),_display_(Seq[Any](/*97.6*/inputText(cajaForm("expediente.expedienteEjercicio"),'class -> "form-control", 'id -> "expediente"))),format.raw/*97.105*/("""
				"""),_display_(Seq[Any](/*98.6*/inputText(cajaForm("expediente_id"),'hidden -> "hidden", 'id -> "expediente_id"))),format.raw/*98.86*/("""
				<span class="input-group-addon"><a href="#" id="searchExpediente" data-title="Selección de expediente" data-url=""""),_display_(Seq[Any](/*99.119*/controllers/*99.130*/.expediente.routes.ExpedientesController.modalBuscar())),format.raw/*99.184*/("""" data-height="650" data-width="700" data-listen="modal.seleccion.expediente.simple" data-label="#expediente" data-field="#expediente_id"><i class="glyphicon glyphicon-search"></i></a></span>
			</div>
			"""),_display_(Seq[Any](/*101.5*/cajaForm("expediente_id")/*101.30*/.error.map/*101.40*/{ error =>_display_(Seq[Any](format.raw/*101.50*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*102.30*/error/*102.35*/.message)),format.raw/*102.43*/("""</div>
			""")))})),format.raw/*103.5*/("""
		</div>
		
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*107.28*/if(cajaForm.error("orden_pago_id") != null)/*107.71*/ {_display_(Seq[Any](format.raw/*107.73*/("""has-error""")))})),format.raw/*107.83*/("""">
				<label for="orden_pago_id" class="control-label">Orden de pago N° </label>
				<div class="input-group">
					"""),_display_(Seq[Any](/*110.7*/inputText(cajaForm("ordenPago.nombreCompleto"), 'class -> "form-control", 'id -> "orden_pago"))),format.raw/*110.101*/("""
					"""),_display_(Seq[Any](/*111.7*/inputText(cajaForm("orden_pago_id"),'hidden -> "hidden", 'id -> "orden_pago_id"))),format.raw/*111.87*/("""
					<span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchOrdenPago" 
									data-title="Selección de órdenes de pago" 
									data-url=""""),_display_(Seq[Any](/*116.21*/controllers/*116.32*/.contabilidad.routes.OrdenesPagosController.modalBuscar())),format.raw/*116.89*/("""" 
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
			<div class="form-group """),_display_(Seq[Any](/*129.28*/if(cajaForm.error("cuenta_propia_id") != null)/*129.74*/ {_display_(Seq[Any](format.raw/*129.76*/("""has-error""")))}/*129.86*/else/*129.90*/{_display_(Seq[Any](format.raw/*129.91*/("""has-required""")))})),format.raw/*129.104*/("""">
				<label for="cuenta_propia_id" class="control-label">Cuenta propia</label> 
				<div class="input-group">
					"""),_display_(Seq[Any](/*132.7*/inputText(cajaForm("cuentaPropia.numero"), 'class -> "form-control", 'id -> "cuenta_propia"))),format.raw/*132.99*/("""
					"""),_display_(Seq[Any](/*133.7*/inputText(cajaForm("cuenta_propia_id"),'hidden -> "hidden", 'id -> "cuenta_propia_id"))),format.raw/*133.93*/("""
					<span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchCuentaPropia" 
									data-title="Selección de Cuenta Propia" 
									data-url=""""),_display_(Seq[Any](/*138.21*/controllers/*138.32*/.contabilidad.routes.CuentasPropiasController.modalBuscar())),format.raw/*138.91*/("""" 
									data-height="650" 
									data-width="700" 
									data-listen="modal.seleccion.cuentaPropia.simple" 
									data-label="#cuenta_propia" 
									data-field="#cuenta_propia_id">
							<i class="glyphicon glyphicon-search"></i>
						</a>
					</span>
				</div>
				"""),_display_(Seq[Any](/*148.6*/cajaForm("cuenta_propia_id")/*148.34*/.error.map/*148.44*/{ error =>_display_(Seq[Any](format.raw/*148.54*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*149.31*/error/*149.36*/.message)),format.raw/*149.44*/("""</div>
				""")))})),format.raw/*150.6*/("""
			</div>
		</div>
		<div class="col-sm-2">
			<label class="control-label" for="orden_cargo">Orden Cargo</label>
			<div class="form-group">
				"""),_display_(Seq[Any](/*156.6*/inputText(cajaForm("orden_cargo"), 'class -> "form-control", 'id -> "orden_cargo"))),format.raw/*156.88*/("""
				
			</div>
		</div>
	</div>
	
	
"""))}
    }
    
    def render(cajaForm:Form[CajaChica]): play.api.templates.HtmlFormat.Appendable = apply(cajaForm)
    
    def f:((Form[CajaChica]) => play.api.templates.HtmlFormat.Appendable) = (cajaForm) => apply(cajaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:46 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/cajaChica/formCajaChica.scala.html
                    HASH: a9e45147954a613592e870d5142ac6962d5ae929
                    MATRIX: 809->1|956->66|988->90|1062->28|1091->134|1382->389|1425->423|1464->424|1502->426|1520->435|1563->456|1584->459|1597->464|1645->466|1666->477|1741->521|1759->529|1796->539|1995->702|2012->710|2043->719|2180->821|2219->851|2258->852|2304->862|2324->873|2430->948|2448->956|2480->965|2611->1063|2673->1090|2756->1151|2795->1155|2887->1225|2953->1255|2970->1263|3001->1272|3046->1281|3063->1289|3092->1296|3256->1424|3301->1460|3341->1462|3383->1472|3427->1481|3528->1560|3570->1567|3597->1585|3616->1595|3664->1605|3732->1637|3746->1642|3776->1650|3820->1663|4002->1809|4051->1849|4091->1851|4133->1861|4177->1870|4279->1950|4321->1957|4352->1979|4371->1989|4419->1999|4481->2025|4495->2030|4525->2038|4564->2045|4736->2181|4780->2216|4820->2218|4849->2229|4862->2234|4901->2235|4946->2248|4990->2257|5111->2355|5163->2372|5189->2389|5208->2399|5256->2409|5323->2440|5337->2445|5367->2453|5410->2465|5588->2607|5639->2649|5679->2651|5708->2662|5721->2667|5760->2668|5806->2681|5850->2690|5956->2774|5998->2781|6031->2805|6050->2815|6098->2825|6160->2851|6174->2856|6204->2864|6243->2871|6355->2947|6407->2990|6447->2992|6489->3002|6605->3083|6689->3145|6741->3162|6775->3187|6794->3197|6842->3207|6909->3238|6923->3243|6953->3251|6996->3263|7176->3408|7282->3492|7501->3675|7551->3716|7591->3718|7620->3728|7633->3732|7672->3733|7718->3746|7762->3755|7898->3868|7940->3875|8038->3951|8231->4108|8251->4119|8325->4171|8647->4458|8679->4481|8698->4491|8746->4501|8813->4532|8827->4537|8857->4545|8900->4557|9093->4714|9145->4757|9185->4759|9214->4769|9227->4773|9266->4774|9312->4787|9356->4796|9478->4895|9520->4902|9622->4982|9779->5102|9800->5113|9877->5167|10121->5375|10156->5400|10176->5410|10225->5420|10293->5451|10308->5456|10339->5464|10383->5476|10489->5545|10542->5588|10583->5590|10626->5600|10783->5721|10901->5815|10945->5823|11048->5903|11270->6088|11291->6099|11371->6156|11766->6514|11822->6560|11863->6562|11893->6572|11907->6576|11947->6577|11994->6590|12151->6711|12266->6803|12310->6811|12419->6897|12642->7083|12663->7094|12745->7153|13078->7450|13116->7478|13136->7488|13185->7498|13254->7530|13269->7535|13300->7543|13345->7556|13535->7710|13640->7792
                    LINES: 26->1|31->4|31->4|32->1|33->4|41->12|41->12|41->12|41->12|41->12|41->12|41->12|41->12|41->12|41->12|41->12|41->12|41->12|44->15|44->15|44->15|45->16|45->16|45->16|45->16|45->16|45->16|45->16|45->16|45->16|50->21|50->21|51->22|51->22|52->23|52->23|52->23|52->23|52->23|52->23|56->27|56->27|56->27|56->27|57->28|57->28|58->29|58->29|58->29|58->29|59->30|59->30|59->30|60->31|65->36|65->36|65->36|65->36|66->37|66->37|67->38|67->38|67->38|67->38|67->38|67->38|67->38|67->38|72->43|72->43|72->43|72->43|72->43|72->43|72->43|73->44|73->44|75->46|75->46|75->46|75->46|76->47|76->47|76->47|77->48|82->53|82->53|82->53|82->53|82->53|82->53|82->53|83->54|83->54|84->55|84->55|84->55|84->55|84->55|84->55|84->55|84->55|88->59|88->59|88->59|88->59|90->61|90->61|92->63|92->63|92->63|92->63|93->64|93->64|93->64|94->65|99->70|99->70|107->78|107->78|107->78|107->78|107->78|107->78|107->78|108->79|108->79|109->80|109->80|112->83|112->83|112->83|118->89|118->89|118->89|118->89|119->90|119->90|119->90|120->91|125->96|125->96|125->96|125->96|125->96|125->96|125->96|126->97|126->97|127->98|127->98|128->99|128->99|128->99|130->101|130->101|130->101|130->101|131->102|131->102|131->102|132->103|136->107|136->107|136->107|136->107|139->110|139->110|140->111|140->111|145->116|145->116|145->116|158->129|158->129|158->129|158->129|158->129|158->129|158->129|161->132|161->132|162->133|162->133|167->138|167->138|167->138|177->148|177->148|177->148|177->148|178->149|178->149|178->149|179->150|185->156|185->156
                    -- GENERATED --
                */
            