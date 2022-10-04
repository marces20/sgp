
package views.html.recupero.recuperoPago

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
object formRecuperoPago extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[models.recupero.RecuperoPago],models.recupero.RecuperoPago,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(recuperoPagoForm: Form[models.recupero.RecuperoPago],rp:models.recupero.RecuperoPago):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.recupero.RecuperoPago

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.88*/("""
"""),format.raw/*5.70*/(""" 
	
	
	<div class="row menu-acciones">
		<div class="col-sm-10">
			<button type="submit" class="btn btn-default" title="Guardar pago"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>	
																																   
	    	<a href=""""),_display_(Seq[Any](/*12.17*/if(request().getHeader("referer"))/*12.51*/{_display_(Seq[Any](format.raw/*12.52*/(""" """),_display_(Seq[Any](/*12.54*/request()/*12.63*/.getHeader("referer"))),format.raw/*12.84*/(""" """)))}/*12.87*/else/*12.92*/{_display_(Seq[Any](_display_(Seq[Any](/*12.94*/controllers/*12.105*/.recupero.routes.RecuperoPagosController.index())),_display_(Seq[Any](/*12.154*/UriTrack/*12.162*/.decode()))))})),format.raw/*12.172*/("""" title="Cancelar editar" class="btn btn-default"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
	    </div>
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*15.14*/UriTrack/*15.22*/.decode())),format.raw/*15.31*/("""" title="Volver al listado" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
			"""),_display_(Seq[Any](/*16.5*/if(recuperoPagoForm.field("id").value)/*16.43*/{_display_(Seq[Any](format.raw/*16.44*/("""<a href=""""),_display_(Seq[Any](/*16.54*/controllers/*16.65*/.recupero.routes.RecuperoPagosController.ver(recuperoPagoForm.field("id").value.toLong))),_display_(Seq[Any](/*16.153*/UriTrack/*16.161*/.get("&"))),format.raw/*16.170*/("""" title="Ver factura" class="btn btn-default"><i class="glyphicon glyphicon-align-justify"></i></a>""")))})),format.raw/*16.270*/("""
		</div>
	</div>
	
	
	"""),_display_(Seq[Any](/*21.3*/inputText(recuperoPagoForm("id"), 'type -> "hidden", 'id -> "recuperoPagoId"))),format.raw/*21.80*/("""
	"""),_display_(Seq[Any](/*22.3*/inputText(recuperoPagoForm("pago_principal_id"), 'type -> "hidden" ))),format.raw/*22.71*/("""
	"""),_display_(Seq[Any](/*23.3*/inputText(recuperoPagoForm("recupero_factura_id"), 'type -> "hidden" ))),format.raw/*23.73*/("""
	<input type="hidden" name="""),_display_(Seq[Any](/*24.29*/UriTrack/*24.37*/.getKey())),format.raw/*24.46*/(""" value=""""),_display_(Seq[Any](/*24.55*/UriTrack/*24.63*/.code())),format.raw/*24.70*/("""" />
	<div class="row">
		<div class="col-sm-2">
			<label class="control-label">Nombre</label> 
			<div class="form-group """),_display_(Seq[Any](/*28.28*/if(recuperoPagoForm.error("nombre") != null)/*28.72*/ {_display_(Seq[Any](format.raw/*28.74*/("""has-error""")))})),format.raw/*28.84*/("""">
				"""),_display_(Seq[Any](/*29.6*/inputText(recuperoPagoForm("nombre"), 'class -> "form-control",'readOnly -> "readOnly"))),format.raw/*29.93*/("""
				
				"""),_display_(Seq[Any](/*31.6*/recuperoPagoForm("nombre")/*31.32*/.error.map/*31.42*/{ error =>_display_(Seq[Any](format.raw/*31.52*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*32.31*/error/*32.36*/.message)),format.raw/*32.44*/("""</div>
				""")))})),format.raw/*33.6*/("""
			</div>
		</div>
		<div class="col-sm-3">
		 	<label class="control-label">Numero Recibo</label> 
			<div class="input-group """),_display_(Seq[Any](/*38.29*/if(recuperoPagoForm.error("numero") != null)/*38.73*/ {_display_(Seq[Any](format.raw/*38.75*/("""has-error""")))}/*38.85*/else/*38.89*/{_display_(Seq[Any](format.raw/*38.90*/("""has-required""")))})),format.raw/*38.103*/("""">
			    <span class="input-group-btn">
			    <i class="input-group-addon" style="display:none"></i>
			      """),_display_(Seq[Any](/*41.11*/inputText(recuperoPagoForm("numero"), 'class -> "form-control",'id->"numero"))),format.raw/*41.88*/("""
			    </span>
		  	</div>	
		  	"""),_display_(Seq[Any](/*44.7*/recuperoPagoForm("numero")/*44.33*/.error.map/*44.43*/{ error =>_display_(Seq[Any](format.raw/*44.53*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*45.30*/error/*45.35*/.message)),format.raw/*45.43*/("""</div>
			""")))})),format.raw/*46.5*/("""
		</div>
		<div class="col-sm-4">
			<label class="control-label">Cliente</label> 
			<div class="input-group """),_display_(Seq[Any](/*50.29*/if(recuperoPagoForm.error("cliente_id") != null)/*50.77*/ {_display_(Seq[Any](format.raw/*50.79*/("""has-error""")))}/*50.89*/else/*50.93*/{_display_(Seq[Any](format.raw/*50.94*/("""has-required""")))})),format.raw/*50.107*/("""">	
				"""),_display_(Seq[Any](/*51.6*/inputText(recuperoPagoForm("cliente.nombre"), 'class -> "form-control", 'id -> "cliente_nombre"))),format.raw/*51.102*/("""
				"""),_display_(Seq[Any](/*52.6*/inputText(recuperoPagoForm("cliente_id"), 'hidden -> "hidden", 'id -> "cliente_id"))),format.raw/*52.89*/("""
				<span class="input-group-addon">
                	<a href="#" id="searchCliente" 
                	data-title="Selección de cliente" 
                	data-url=""""),_display_(Seq[Any](/*56.29*/controllers/*56.40*/.compras.routes.ClientesController.modalBuscar())),format.raw/*56.88*/("""" 
                	data-height="650" data-width="700" 
                	data-listen="modal.seleccion.cliente.simple" 
                	data-label="#cliente_nombre" data-field="#cliente_id" /> 
                	<i class="glyphicon glyphicon-search"></i></a>
                </span>
			</div>
			"""),_display_(Seq[Any](/*63.5*/recuperoPagoForm("cliente_id")/*63.35*/.error.map/*63.45*/{ error =>_display_(Seq[Any](format.raw/*63.55*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*64.30*/error/*64.35*/.message)),format.raw/*64.43*/("""</div>
			""")))})),format.raw/*65.5*/("""
		</div>
		<div class="col-sm-2">
			<label class="control-label">Fecha</label> 
			<div class="form-group """),_display_(Seq[Any](/*69.28*/if(recuperoPagoForm.error("fecha")  != null)/*69.72*/ {_display_(Seq[Any](format.raw/*69.74*/("""has-error""")))}/*69.84*/else/*69.88*/{_display_(Seq[Any](format.raw/*69.89*/("""has-required""")))})),format.raw/*69.102*/("""">
				"""),_display_(Seq[Any](/*70.6*/inputText(recuperoPagoForm("fecha"),'class -> "form-control date", 'autocomplete -> "off"))),format.raw/*70.96*/("""
			</div>
			"""),_display_(Seq[Any](/*72.5*/recuperoPagoForm("fecha")/*72.30*/.error.map/*72.40*/{ error =>_display_(Seq[Any](format.raw/*72.50*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*73.30*/error/*73.35*/.message)),format.raw/*73.43*/("""</div>
			""")))})),format.raw/*74.5*/("""
		</div>
		
		

		
	</div>
	
	<div class="row">
		<div class="col-sm-2">
			<label for="planulla" class="control-label">Planilla</label> 
			<div class="input-group """),_display_(Seq[Any](/*85.29*/if(recuperoPagoForm.error("planilla_id") != null)/*85.78*/ {_display_(Seq[Any](format.raw/*85.80*/("""has-error""")))}/*85.90*/else/*85.94*/{_display_(Seq[Any](format.raw/*85.95*/("""has-required""")))})),format.raw/*85.108*/("""">
				"""),_display_(Seq[Any](/*86.6*/inputText(recuperoPagoForm("planilla.recuperoPlanillaEjercicio"),'class -> "form-control", 'id -> "planilla"))),format.raw/*86.115*/("""
				"""),_display_(Seq[Any](/*87.6*/inputText(recuperoPagoForm("planilla_id"),'hidden -> "hidden", 'id -> "planilla_id"))),format.raw/*87.90*/("""

				<span class="input-group-addon">
				<a href="#" 
				id="searchPlanilla" data-title="Selección de Planilla" 
				data-url=""""),_display_(Seq[Any](/*92.16*/controllers/*92.27*/.recupero.routes.RecuperoPlanillasController.modalBuscar())),format.raw/*92.85*/("""" 
				data-height="650" data-width="700" 
				data-listen="modal.seleccion.planilla.simple" 
				data-label="#planilla" 
				data-field="#planilla_id">
				<i class="glyphicon glyphicon-search"></i></a></span>
				
			</div>
			"""),_display_(Seq[Any](/*100.5*/recuperoPagoForm("planilla_id")/*100.36*/.error.map/*100.46*/{ error =>_display_(Seq[Any](format.raw/*100.56*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*101.31*/error/*101.36*/.message)),format.raw/*101.44*/("""</div>
				""")))})),format.raw/*102.6*/("""
		</div>
		<div class="col-sm-4">
			<label class="control-label">Concepto</label> 
			<div class="form-group """),_display_(Seq[Any](/*106.28*/if(recuperoPagoForm.error("concepto") != null)/*106.74*/ {_display_(Seq[Any](format.raw/*106.76*/("""has-error""")))})),format.raw/*106.86*/("""">
				"""),_display_(Seq[Any](/*107.6*/inputText(recuperoPagoForm("concepto"), 'class -> "form-control",'id -> "concepto_recupero"))),format.raw/*107.98*/("""
				
				"""),_display_(Seq[Any](/*109.6*/recuperoPagoForm("concepto")/*109.34*/.error.map/*109.44*/{ error =>_display_(Seq[Any](format.raw/*109.54*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*110.31*/error/*110.36*/.message)),format.raw/*110.44*/("""</div>
				""")))})),format.raw/*111.6*/("""
			</div>
		</div>
	
	
		<div class="col-sm-2">
			<label class="control-label">Total</label> 
			<div class="form-group """),_display_(Seq[Any](/*118.28*/if(recuperoPagoForm.error("total") != null)/*118.71*/ {_display_(Seq[Any](format.raw/*118.73*/("""has-error""")))}/*118.84*/else/*118.89*/{_display_(Seq[Any](format.raw/*118.90*/("""has-required""")))})),format.raw/*118.103*/("""">
				"""),_display_(Seq[Any](/*119.6*/inputText(recuperoPagoForm("total"), 'class -> "form-control", 'id -> "total"))),format.raw/*119.84*/("""
				"""),_display_(Seq[Any](/*120.6*/recuperoPagoForm("total")/*120.31*/.error.map/*120.41*/{ error =>_display_(Seq[Any](format.raw/*120.51*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*121.31*/error/*121.36*/.message)),format.raw/*121.44*/("""</div>
				""")))})),format.raw/*122.6*/("""
			</div>
		</div>
		
		<div class="col-sm-2">
			<label class="control-label">Tipo de pago</label> 
			<div class="form-group """),_display_(Seq[Any](/*128.28*/if(recuperoPagoForm.error("tipoPago") != null)/*128.74*/  {_display_(Seq[Any](format.raw/*128.77*/("""has-error""")))}/*128.88*/else/*128.93*/{_display_(Seq[Any](format.raw/*128.94*/("""has-required""")))})),format.raw/*128.107*/("""">
				"""),_display_(Seq[Any](/*129.6*/select(recuperoPagoForm("tipoPago"),options(""->"Seleccionar", "efectivo"->"Efectivo","cheque"->"Cheque","tarjeta"->"Tarjeta","transferencia"->"Transferencia"), 'class -> "form-control select", 'id -> "tipoPago"))),format.raw/*129.218*/("""
				"""),_display_(Seq[Any](/*130.6*/recuperoPagoForm("tipoPago")/*130.34*/.error.map/*130.44*/{ error =>_display_(Seq[Any](format.raw/*130.54*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*131.31*/error/*131.36*/.message)),format.raw/*131.44*/("""</div>
				""")))})),format.raw/*132.6*/("""
			</div>
		</div>
		"""),_display_(Seq[Any](/*135.4*/if(rp != null)/*135.18*/{_display_(Seq[Any](format.raw/*135.19*/("""
			<div class="col-sm-2">
				<label class="control-label">N° Factura</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*138.50*/rp/*138.52*/.recuperoFactura.getNumeroFactura())),format.raw/*138.87*/("""</p>
			</div>
		""")))})),format.raw/*140.4*/(""" 
	</div>
	
<hr />

"""))}
    }
    
    def render(recuperoPagoForm:Form[models.recupero.RecuperoPago],rp:models.recupero.RecuperoPago): play.api.templates.HtmlFormat.Appendable = apply(recuperoPagoForm,rp)
    
    def f:((Form[models.recupero.RecuperoPago],models.recupero.RecuperoPago) => play.api.templates.HtmlFormat.Appendable) = (recuperoPagoForm,rp) => apply(recuperoPagoForm,rp)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:35 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/recupero/recuperoPago/formRecuperoPago.scala.html
                    HASH: 0c60fd497e249dca029b5c388b63f6d7084bc94a
                    MATRIX: 864->1|1105->159|1137->183|1211->87|1239->227|1528->480|1571->514|1610->515|1648->517|1666->526|1709->547|1730->550|1743->555|1791->557|1812->568|1892->617|1910->625|1947->635|2146->798|2163->806|2194->815|2331->917|2378->955|2417->956|2463->966|2483->977|2602->1065|2620->1073|2652->1082|2785->1182|2844->1206|2943->1283|2981->1286|3071->1354|3109->1357|3201->1427|3266->1456|3283->1464|3314->1473|3359->1482|3376->1490|3405->1497|3565->1621|3618->1665|3658->1667|3700->1677|3743->1685|3852->1772|3898->1783|3933->1809|3952->1819|4000->1829|4067->1860|4081->1865|4111->1873|4154->1885|4319->2014|4372->2058|4412->2060|4441->2070|4454->2074|4493->2075|4539->2088|4688->2201|4787->2278|4857->2313|4892->2339|4911->2349|4959->2359|5025->2389|5039->2394|5069->2402|5111->2413|5259->2525|5316->2573|5356->2575|5385->2585|5398->2589|5437->2590|5483->2603|5527->2612|5646->2708|5687->2714|5792->2797|5995->2964|6015->2975|6085->3023|6416->3319|6455->3349|6474->3359|6522->3369|6588->3399|6602->3404|6632->3412|6674->3423|6819->3532|6872->3576|6912->3578|6941->3588|6954->3592|6993->3593|7039->3606|7082->3614|7194->3704|7244->3719|7278->3744|7297->3754|7345->3764|7411->3794|7425->3799|7455->3807|7497->3818|7700->3985|7758->4034|7798->4036|7827->4046|7840->4050|7879->4051|7925->4064|7968->4072|8100->4181|8141->4187|8247->4271|8414->4402|8434->4413|8514->4471|8780->4701|8821->4732|8841->4742|8890->4752|8958->4783|8973->4788|9004->4796|9048->4808|9197->4920|9253->4966|9294->4968|9337->4978|9381->4986|9496->5078|9543->5089|9581->5117|9601->5127|9650->5137|9718->5168|9733->5173|9764->5181|9808->5193|9968->5316|10021->5359|10062->5361|10092->5372|10106->5377|10146->5378|10193->5391|10237->5399|10338->5477|10380->5483|10415->5508|10435->5518|10484->5528|10552->5559|10567->5564|10598->5572|10642->5584|10808->5713|10864->5759|10906->5762|10936->5773|10950->5778|10990->5779|11037->5792|11081->5800|11317->6012|11359->6018|11397->6046|11417->6056|11466->6066|11534->6097|11549->6102|11580->6110|11624->6122|11683->6145|11707->6159|11747->6160|11912->6288|11924->6290|11982->6325|12032->6343
                    LINES: 26->1|33->5|33->5|34->1|35->5|42->12|42->12|42->12|42->12|42->12|42->12|42->12|42->12|42->12|42->12|42->12|42->12|42->12|45->15|45->15|45->15|46->16|46->16|46->16|46->16|46->16|46->16|46->16|46->16|46->16|51->21|51->21|52->22|52->22|53->23|53->23|54->24|54->24|54->24|54->24|54->24|54->24|58->28|58->28|58->28|58->28|59->29|59->29|61->31|61->31|61->31|61->31|62->32|62->32|62->32|63->33|68->38|68->38|68->38|68->38|68->38|68->38|68->38|71->41|71->41|74->44|74->44|74->44|74->44|75->45|75->45|75->45|76->46|80->50|80->50|80->50|80->50|80->50|80->50|80->50|81->51|81->51|82->52|82->52|86->56|86->56|86->56|93->63|93->63|93->63|93->63|94->64|94->64|94->64|95->65|99->69|99->69|99->69|99->69|99->69|99->69|99->69|100->70|100->70|102->72|102->72|102->72|102->72|103->73|103->73|103->73|104->74|115->85|115->85|115->85|115->85|115->85|115->85|115->85|116->86|116->86|117->87|117->87|122->92|122->92|122->92|130->100|130->100|130->100|130->100|131->101|131->101|131->101|132->102|136->106|136->106|136->106|136->106|137->107|137->107|139->109|139->109|139->109|139->109|140->110|140->110|140->110|141->111|148->118|148->118|148->118|148->118|148->118|148->118|148->118|149->119|149->119|150->120|150->120|150->120|150->120|151->121|151->121|151->121|152->122|158->128|158->128|158->128|158->128|158->128|158->128|158->128|159->129|159->129|160->130|160->130|160->130|160->130|161->131|161->131|161->131|162->132|165->135|165->135|165->135|168->138|168->138|168->138|170->140
                    -- GENERATED --
                */
            