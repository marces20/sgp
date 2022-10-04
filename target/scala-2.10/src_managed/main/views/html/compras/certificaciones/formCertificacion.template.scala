
package views.html.compras.certificaciones

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
object formCertificacion extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Certificacion],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(certificacionForm: Form[Certificacion]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.42*/("""
"""),format.raw/*4.70*/(""" 
	
	
	<div class="row menu-acciones">
		<div class="col-sm-5">
			<button type="submit" class="btn btn-default" title="Guardar orden"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>	
																																   
	    	<a href=""""),_display_(Seq[Any](/*11.17*/if(request().getHeader("referer"))/*11.51*/{_display_(Seq[Any](format.raw/*11.52*/(""" """),_display_(Seq[Any](/*11.54*/request()/*11.63*/.getHeader("referer"))),format.raw/*11.84*/(""" """)))}/*11.87*/else/*11.92*/{_display_(Seq[Any](_display_(Seq[Any](/*11.94*/controllers/*11.105*/.compras.routes.CertificacionesController.index())),_display_(Seq[Any](/*11.155*/UriTrack/*11.163*/.decode()))))})),format.raw/*11.173*/("""" title="Cancelar editar" class="btn btn-default"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
	    </div>
	    <div class="col-sm-5">
			"""),_display_(Seq[Any](/*14.5*/if(certificacionForm("tipoCuenta").value != null)/*14.54*/{_display_(Seq[Any](format.raw/*14.55*/("""
				<span style="color:red;font-size: 25px;font-weight: bold;">"""),_display_(Seq[Any](/*15.65*/certificacionForm("tipoCuenta.nombre")/*15.103*/.value)),format.raw/*15.109*/("""</span>
			""")))})),format.raw/*16.5*/("""
		</div>
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*19.14*/UriTrack/*19.22*/.decode())),format.raw/*19.31*/("""" title="Volver al listado" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
			"""),_display_(Seq[Any](/*20.5*/if(certificacionForm.field("id").value)/*20.44*/{_display_(Seq[Any](format.raw/*20.45*/("""<a href=""""),_display_(Seq[Any](/*20.55*/controllers/*20.66*/.compras.routes.CertificacionesController.ver(certificacionForm.field("id").value.toLong))),_display_(Seq[Any](/*20.156*/UriTrack/*20.164*/.get("&"))),format.raw/*20.173*/("""" title="Ver orden" class="btn btn-default"><i class="glyphicon glyphicon-align-justify"></i></a>""")))})),format.raw/*20.271*/("""
		</div>
	</div>
	
	
	"""),_display_(Seq[Any](/*25.3*/inputText(certificacionForm("id"), 'type -> "hidden", 'id -> "certificacionId"))),format.raw/*25.82*/("""
	<input type="hidden" name="""),_display_(Seq[Any](/*26.29*/UriTrack/*26.37*/.getKey())),format.raw/*26.46*/(""" value=""""),_display_(Seq[Any](/*26.55*/UriTrack/*26.63*/.code())),format.raw/*26.70*/("""" />
	<div class="row">
		<div class="col-sm-2">
			<label class="control-label">Referencia</label> 
			<div class="form-group """),_display_(Seq[Any](/*30.28*/if(certificacionForm.error("nombre") != null)/*30.73*/ {_display_(Seq[Any](format.raw/*30.75*/("""has-error""")))})),format.raw/*30.85*/("""">
				"""),_display_(Seq[Any](/*31.6*/inputText(certificacionForm("nombre"), 'class -> "form-control",'readOnly -> "readOnly"))),format.raw/*31.94*/("""
				
				"""),_display_(Seq[Any](/*33.6*/certificacionForm("nombre")/*33.33*/.error.map/*33.43*/{ error =>_display_(Seq[Any](format.raw/*33.53*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*34.31*/error/*34.36*/.message)),format.raw/*34.44*/("""</div>
				""")))})),format.raw/*35.6*/("""
			</div>
		</div>
		<div class="col-sm-4">
			<label class="control-label">Proveedor</label> 
			<div class="input-group """),_display_(Seq[Any](/*40.29*/if(certificacionForm.error("proveedor_id") != null)/*40.80*/ {_display_(Seq[Any](format.raw/*40.82*/("""has-error""")))}/*40.92*/else/*40.96*/{_display_(Seq[Any](format.raw/*40.97*/("""has-required""")))})),format.raw/*40.110*/("""">	
				"""),_display_(Seq[Any](/*41.6*/inputText(certificacionForm("proveedor.nombre"), 'class -> "form-control", 'id -> "proveedor"))),format.raw/*41.100*/("""
				"""),_display_(Seq[Any](/*42.6*/inputText(certificacionForm("proveedor_id"), 'hidden -> "hidden", 'id -> "proveedor_id"))),format.raw/*42.94*/("""
				<span class="input-group-addon">
                	<a href="#" id="searchProveedor" data-title="Selección de proveedor" data-url=""""),_display_(Seq[Any](/*44.98*/controllers/*44.109*/.compras.routes.ProveedoresController.modalBuscar())),format.raw/*44.160*/("""" data-height="650" data-width="700" data-listen="modal.seleccion.proveedor.simple" data-label="#proveedor" data-field="#proveedor_id" /> <i class="glyphicon glyphicon-search"></i></a>
                </span>
			</div>
			"""),_display_(Seq[Any](/*47.5*/certificacionForm("proveedor_id")/*47.38*/.error.map/*47.48*/{ error =>_display_(Seq[Any](format.raw/*47.58*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*48.30*/error/*48.35*/.message)),format.raw/*48.43*/("""</div>
			""")))})),format.raw/*49.5*/("""
		</div>
		<div class="col-sm-2">
			<label for="expediente" class="control-label">Expediente</label> 
			<div class="input-group """),_display_(Seq[Any](/*53.29*/if(certificacionForm.error("expediente_id") != null)/*53.81*/ {_display_(Seq[Any](format.raw/*53.83*/("""has-error""")))}/*53.93*/else/*53.97*/{_display_(Seq[Any](format.raw/*53.98*/("""has-required""")))})),format.raw/*53.111*/("""">
				"""),_display_(Seq[Any](/*54.6*/inputText(certificacionForm("expediente.expedienteEjercicio"),'class -> "form-control", 'id -> "expediente"))),format.raw/*54.114*/("""
				"""),_display_(Seq[Any](/*55.6*/inputText(certificacionForm("expediente_id"),'hidden -> "hidden", 'id -> "expediente_id"))),format.raw/*55.95*/("""
				<span class="input-group-addon"><a href="#" id="searchExpediente" data-title="Selección de expediente" data-url=""""),_display_(Seq[Any](/*56.119*/controllers/*56.130*/.expediente.routes.ExpedientesController.modalBuscar())),format.raw/*56.184*/("""" data-height="650" data-width="700" data-listen="modal.seleccion.expediente.simple" data-label="#expediente" data-field="#expediente_id"><i class="glyphicon glyphicon-search"></i></a></span>
			</div>
			"""),_display_(Seq[Any](/*58.5*/certificacionForm("expediente_id")/*58.39*/.error.map/*58.49*/{ error =>_display_(Seq[Any](format.raw/*58.59*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*59.30*/error/*59.35*/.message)),format.raw/*59.43*/("""</div>
			""")))})),format.raw/*60.5*/("""
		</div>
		
		<div class="col-sm-2">
			<label for="inputPeriodo" class="control-label">Periodo</label> 
			<div class="input-group """),_display_(Seq[Any](/*65.29*/if(certificacionForm.error("periodo_id") != null)/*65.78*/ {_display_(Seq[Any](format.raw/*65.80*/("""has-error""")))}/*65.90*/else/*65.94*/{_display_(Seq[Any](format.raw/*65.95*/("""has-required""")))})),format.raw/*65.108*/("""">
				
				"""),_display_(Seq[Any](/*67.6*/inputText(certificacionForm("periodo.nombre"),'class -> "form-control",'id -> "periodo"))),format.raw/*67.94*/("""
				"""),_display_(Seq[Any](/*68.6*/inputText(certificacionForm("periodo_id"),'hidden -> "hidden",'id -> "periodo_id"))),format.raw/*68.88*/("""
				<span class="input-group-addon">
				<a href="#" class="searchModal"
							id="searchPeriodo" 
							data-title="Selección de Periodo" 
							data-url=""""),_display_(Seq[Any](/*73.19*/controllers/*73.30*/.contabilidad.routes.PeriodosController.modalBuscar())),format.raw/*73.83*/("""" 
							data-height="650" 
							data-width="700" 
							data-listen="modal.seleccion.periodo.simple" 
							data-label="#periodo" 
							data-field="#periodo_id">
					<i class="glyphicon glyphicon-search"></i>
				</a>
				</span>
			</div>
			"""),_display_(Seq[Any](/*83.5*/certificacionForm("periodo_id")/*83.36*/.error.map/*83.46*/{ error =>_display_(Seq[Any](format.raw/*83.56*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*84.30*/error/*84.35*/.message)),format.raw/*84.43*/("""</div>
			""")))})),format.raw/*85.5*/("""
		</div>
	</div>
	
	<div class="row">
		<div class="col-sm-2">
			<label class="control-label">Orden de Compras</label> 
			<div class="input-group """),_display_(Seq[Any](/*92.29*/if(certificacionForm.error("orden_id") != null)/*92.76*/ {_display_(Seq[Any](format.raw/*92.78*/("""has-error""")))})),format.raw/*92.88*/("""">
				"""),_display_(Seq[Any](/*93.6*/inputText(certificacionForm("orden.nombre"),'class -> "form-control", 'id -> "orden"))),format.raw/*93.91*/("""
				"""),_display_(Seq[Any](/*94.6*/inputText(certificacionForm("orden_id"),'hidden -> "hidden", 'id -> "orden_id"))),format.raw/*94.85*/("""
				
				<span class="input-group-addon"><a href="#" 
				id="searchOrden" 
				data-title="Selección de orden" 
				data-url=""""),_display_(Seq[Any](/*99.16*/controllers/*99.27*/.compras.routes.OrdenesController.modalBuscar())),format.raw/*99.74*/("""" 
				data-height="650" data-width="700" 
				data-listen="modal.seleccion.orden.simple" 
				data-label="#orden" 
				data-field="#orden_id"><i class="glyphicon glyphicon-search"></i></a></span>
				
			</div>
		</div>
		
		<div class="col-sm-2">
			<label class="control-label">Fecha certificacion</label> 
			<div class="form-group """),_display_(Seq[Any](/*110.28*/if(certificacionForm.error("fecha_certificacion")  != null)/*110.87*/ {_display_(Seq[Any](format.raw/*110.89*/("""has-error""")))})),format.raw/*110.99*/("""">
				"""),_display_(Seq[Any](/*111.6*/inputText(certificacionForm("fecha_certificacion"),'class -> "form-control date", 'autocomplete -> "off"))),format.raw/*111.111*/("""
			</div>
			"""),_display_(Seq[Any](/*113.5*/certificacionForm("fecha_certificacion")/*113.45*/.error.map/*113.55*/{ error =>_display_(Seq[Any](format.raw/*113.65*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*114.30*/error/*114.35*/.message)),format.raw/*114.43*/("""</div>
			""")))})),format.raw/*115.5*/("""
		</div>
		
		<div class="col-sm-2">
			<!-- <div class="checkbox">
				<label class="control-label"> 
					Profe
					"""),_display_(Seq[Any](/*122.7*/checkbox(certificacionForm("profe")))),format.raw/*122.43*/("""
				</label>
			</div>-->
			<div class="form-group """),_display_(Seq[Any](/*125.28*/if(certificacionForm.error("tipo_cuenta_id") != null)/*125.81*/ {_display_(Seq[Any](format.raw/*125.83*/("""has-error""")))})),format.raw/*125.93*/("""">
				<label class="control-label">Tipo Cuenta</label>
				"""),_display_(Seq[Any](/*127.6*/select(certificacionForm("tipo_cuenta_id"),TipoCuenta.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*127.170*/("""
				"""),_display_(Seq[Any](/*128.6*/certificacionForm("tipo_cuenta_id")/*128.41*/.error.map/*128.51*/{ error =>_display_(Seq[Any](format.raw/*128.61*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*129.31*/error/*129.36*/.message)),format.raw/*129.44*/("""</div>
				""")))})),format.raw/*130.6*/("""
			</div>
		</div>
		<div class="col-sm-2">
			<div class="checkbox">
				<label class="control-label">Creacion Automatica
				"""),_display_(Seq[Any](/*136.6*/checkbox(certificacionForm("creacion_automatica")))),format.raw/*136.56*/("""</label> 
			</div>
		</div>
				
	</div>
	
	
	<div class="row">
		 
		
		
	 
		 
	</div>
	
"""))}
    }
    
    def render(certificacionForm:Form[Certificacion]): play.api.templates.HtmlFormat.Appendable = apply(certificacionForm)
    
    def f:((Form[Certificacion]) => play.api.templates.HtmlFormat.Appendable) = (certificacionForm) => apply(certificacionForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:42 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/certificaciones/formCertificacion.scala.html
                    HASH: 35b821f4a4d2ae425c95e5d2b17595625ebc0308
                    MATRIX: 823->1|981->76|1013->100|1087->41|1115->144|1404->397|1447->431|1486->432|1524->434|1542->443|1585->464|1606->467|1619->472|1667->474|1688->485|1769->535|1787->543|1824->553|2016->710|2074->759|2113->760|2214->825|2262->863|2291->869|2334->881|2418->929|2435->937|2466->946|2603->1048|2651->1087|2690->1088|2736->1098|2756->1109|2877->1199|2895->1207|2927->1216|3058->1314|3117->1338|3218->1417|3283->1446|3300->1454|3331->1463|3376->1472|3393->1480|3422->1487|3586->1615|3640->1660|3680->1662|3722->1672|3765->1680|3875->1768|3921->1779|3957->1806|3976->1816|4024->1826|4091->1857|4105->1862|4135->1870|4178->1882|4338->2006|4398->2057|4438->2059|4467->2069|4480->2073|4519->2074|4565->2087|4609->2096|4726->2190|4767->2196|4877->2284|5048->2419|5069->2430|5143->2481|5401->2704|5443->2737|5462->2747|5510->2757|5576->2787|5590->2792|5620->2800|5662->2811|5830->2943|5891->2995|5931->2997|5960->3007|5973->3011|6012->3012|6058->3025|6101->3033|6232->3141|6273->3147|6384->3236|6540->3355|6561->3366|6638->3420|6879->3626|6922->3660|6941->3670|6989->3680|7055->3710|7069->3715|7099->3723|7141->3734|7311->3868|7369->3917|7409->3919|7438->3929|7451->3933|7490->3934|7536->3947|7584->3960|7694->4048|7735->4054|7839->4136|8036->4297|8056->4308|8131->4361|8419->4614|8459->4645|8478->4655|8526->4665|8592->4695|8606->4700|8636->4708|8678->4719|8864->4869|8920->4916|8960->4918|9002->4928|9045->4936|9152->5021|9193->5027|9294->5106|9459->5235|9479->5246|9548->5293|9922->5630|9991->5689|10032->5691|10075->5701|10119->5709|10248->5814|10299->5829|10349->5869|10369->5879|10418->5889|10485->5919|10500->5924|10531->5932|10574->5943|10731->6064|10790->6100|10881->6154|10944->6207|10985->6209|11028->6219|11125->6280|11313->6444|11355->6450|11400->6485|11420->6495|11469->6505|11537->6536|11552->6541|11583->6549|11627->6561|11792->6690|11865->6740
                    LINES: 26->1|31->4|31->4|32->1|33->4|40->11|40->11|40->11|40->11|40->11|40->11|40->11|40->11|40->11|40->11|40->11|40->11|40->11|43->14|43->14|43->14|44->15|44->15|44->15|45->16|48->19|48->19|48->19|49->20|49->20|49->20|49->20|49->20|49->20|49->20|49->20|49->20|54->25|54->25|55->26|55->26|55->26|55->26|55->26|55->26|59->30|59->30|59->30|59->30|60->31|60->31|62->33|62->33|62->33|62->33|63->34|63->34|63->34|64->35|69->40|69->40|69->40|69->40|69->40|69->40|69->40|70->41|70->41|71->42|71->42|73->44|73->44|73->44|76->47|76->47|76->47|76->47|77->48|77->48|77->48|78->49|82->53|82->53|82->53|82->53|82->53|82->53|82->53|83->54|83->54|84->55|84->55|85->56|85->56|85->56|87->58|87->58|87->58|87->58|88->59|88->59|88->59|89->60|94->65|94->65|94->65|94->65|94->65|94->65|94->65|96->67|96->67|97->68|97->68|102->73|102->73|102->73|112->83|112->83|112->83|112->83|113->84|113->84|113->84|114->85|121->92|121->92|121->92|121->92|122->93|122->93|123->94|123->94|128->99|128->99|128->99|139->110|139->110|139->110|139->110|140->111|140->111|142->113|142->113|142->113|142->113|143->114|143->114|143->114|144->115|151->122|151->122|154->125|154->125|154->125|154->125|156->127|156->127|157->128|157->128|157->128|157->128|158->129|158->129|158->129|159->130|165->136|165->136
                    -- GENERATED --
                */
            