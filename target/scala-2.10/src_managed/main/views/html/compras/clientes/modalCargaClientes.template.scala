
package views.html.compras.clientes

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
object modalCargaClientes extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Cliente],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(clienteForm: Form[Cliente]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.30*/("""
"""),format.raw/*3.70*/("""



"""),_display_(Seq[Any](/*7.2*/helper/*7.8*/.form(action = controllers.compras.routes.ClientesController.guardarDesdeModal(),'id -> "formCargaClienteDesdeModal")/*7.125*/ {_display_(Seq[Any](format.raw/*7.127*/("""
"""),_display_(Seq[Any](/*8.2*/views/*8.7*/.html.tags.successError())),format.raw/*8.32*/("""
 <div class="row">
	<div class="col-sm-6">
		<div class="form-group """),_display_(Seq[Any](/*11.27*/if(clienteForm.error("nombre") != null)/*11.66*/ {_display_(Seq[Any](format.raw/*11.68*/("""has-error""")))}/*11.79*/else/*11.84*/{_display_(Seq[Any](format.raw/*11.85*/("""has-required""")))})),format.raw/*11.98*/("""">
			<label for="nombre" class="control-label">Nombre</label>
			"""),_display_(Seq[Any](/*13.5*/inputText(clienteForm("nombre"), 'class -> "form-control", 'id -> "nombre" ))),format.raw/*13.81*/("""
			"""),_display_(Seq[Any](/*14.5*/clienteForm("nombre")/*14.26*/.error.map/*14.36*/{ error =>_display_(Seq[Any](format.raw/*14.46*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*15.30*/error/*15.35*/.message)),format.raw/*15.43*/("""</div>
			""")))})),format.raw/*16.5*/("""
		</div>
	</div>
	<div class="col-sm-6">
		<div class=" form-group """),_display_(Seq[Any](/*20.28*/if(clienteForm.error("cliente_tipo_id") != null)/*20.76*/ {_display_(Seq[Any](format.raw/*20.78*/("""has-error""")))}/*20.89*/else/*20.94*/{_display_(Seq[Any](format.raw/*20.95*/("""has-required""")))})),format.raw/*20.108*/("""">
			<label for=""""),_display_(Seq[Any](/*21.17*/clienteForm("cliente_tipo_id")/*21.47*/.id)),format.raw/*21.50*/("""" class="control-label">Tipo de cliente</label>
			"""),_display_(Seq[Any](/*22.5*/select(clienteForm("cliente_tipo_id"), ClienteTipo.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*22.166*/("""
			"""),_display_(Seq[Any](/*23.5*/clienteForm("cliente_tipo_id")/*23.35*/.error.map/*23.45*/{ error =>_display_(Seq[Any](format.raw/*23.55*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*24.30*/error/*24.35*/.message)),format.raw/*24.43*/("""</div>
			""")))})),format.raw/*25.5*/("""
		</div>
	</div>
</div>	
<div class="row">
	<div class="col-sm-3">
		<div class="form-group">
			<label for="cuit" class="control-label">CUIT</label>
			"""),_display_(Seq[Any](/*33.5*/inputText(clienteForm("cuit2"), 'class -> "form-control" , 'id -> "cuit2"))),format.raw/*33.79*/("""
			"""),_display_(Seq[Any](/*34.5*/clienteForm("cuit2")/*34.25*/.error.map/*34.35*/{ error =>_display_(Seq[Any](format.raw/*34.45*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*35.30*/error/*35.35*/.message)),format.raw/*35.43*/("""</div>
			""")))})),format.raw/*36.5*/("""
		</div>
	</div>		
	<div class="col-sm-3">
		<div class="form-group">
			<label for="dni" class="control-label">DNI</label>
			"""),_display_(Seq[Any](/*42.5*/inputText(clienteForm("dni"), 'class -> "form-control", 'id -> "dni"))),format.raw/*42.74*/("""
			"""),_display_(Seq[Any](/*43.5*/clienteForm("dni")/*43.23*/.error.map/*43.33*/{ error =>_display_(Seq[Any](format.raw/*43.43*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*44.30*/error/*44.35*/.message)),format.raw/*44.43*/("""</div>
			""")))})),format.raw/*45.5*/("""
		</div>
	</div>
	<div class="col-sm-6">
		<label for="servicio" class="control-label">Obra Social</label>
		<div class="input-group"> 
			"""),_display_(Seq[Any](/*51.5*/inputText(clienteForm("obrasocial.nombre"),'class -> "form-control", 'id -> "obrasocial", 'autocomplete -> "off"))),format.raw/*51.118*/("""
			"""),_display_(Seq[Any](/*52.5*/inputText(clienteForm("obrasocial_id"),'hidden -> "hidden", 'id -> "obrasocial_id"))),format.raw/*52.88*/("""
			<span class="input-group-addon">
				<a href="#" id="searchObraSocial" 
				data-title="Selección de obra social" 
				data-url=""""),_display_(Seq[Any](/*56.16*/controllers/*56.27*/.compras.routes.ObrasSocialesController.modalBuscar())),format.raw/*56.80*/("""" 
				data-height="650" data-width="700" 
				data-listen="modal.seleccion.ob.simple" 
				data-label="#obrasocial" data-field="#obrasocial_id"><i class="glyphicon glyphicon-search"></i></a>
			</span>
		</div>
	</div>
</div>	
<div class="row">
	<div class="col-sm-3">
		<div class="form-group">
			<label for="idPaciente" class="control-label">ID Paciente</label>
			"""),_display_(Seq[Any](/*68.5*/inputText(clienteForm("id_paciente_rismi"), 'class -> "form-control", 'id -> "id_paciente_rismi"))),format.raw/*68.102*/("""
			"""),_display_(Seq[Any](/*69.5*/clienteForm("id_paciente_rismi")/*69.37*/.error.map/*69.47*/{ error =>_display_(Seq[Any](format.raw/*69.57*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*70.30*/error/*70.35*/.message)),format.raw/*70.43*/("""</div>
			""")))})),format.raw/*71.5*/("""
		</div>
	</div>
	<div class="col-sm-3">
		<div class="form-group">
			<label for="referencia" class="control-label">Referencia</label>
			"""),_display_(Seq[Any](/*77.5*/inputText(clienteForm("referencia"), 'class -> "form-control", 'id -> "referencia"))),format.raw/*77.88*/("""
			"""),_display_(Seq[Any](/*78.5*/clienteForm("referencia")/*78.30*/.error.map/*78.40*/{ error =>_display_(Seq[Any](format.raw/*78.50*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*79.30*/error/*79.35*/.message)),format.raw/*79.43*/("""</div>
			""")))})),format.raw/*80.5*/("""
		</div>
	</div>
	<div class="col-sm-3">
		<div class="form-group """),_display_(Seq[Any](/*84.27*/if(clienteForm.error("sexo") != null)/*84.64*/ {_display_(Seq[Any](format.raw/*84.66*/("""has-error""")))})),format.raw/*84.76*/("""">
			<label for=""""),_display_(Seq[Any](/*85.17*/clienteForm("sexo"))),format.raw/*85.36*/("""" class="control-label">Sexo</label>
			"""),_display_(Seq[Any](/*86.5*/select(clienteForm("sexo"), options("M"->"Masculino","F"->"Femenino"),'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*86.135*/("""
		</div>
	</div>
	<div class="col-sm-3">
		<div class="form-group """),_display_(Seq[Any](/*90.27*/if(clienteForm.error("fnacimiento") != null)/*90.71*/ {_display_(Seq[Any](format.raw/*90.73*/("""has-error""")))})),format.raw/*90.83*/("""">
			<label for="inputNombre" class="control-label">Fecha nacimiento</label> 
			"""),_display_(Seq[Any](/*92.5*/inputText(clienteForm("fnacimiento"), 'class -> "form-control date", 'id -> "nacimiento"))),format.raw/*92.94*/("""
		</div>
	</div>
</div>	
<div class="row">
	<div class="col-sm-10">
		<button type="submit" class="btn btn-default" title="Guardar orden">
			<i class="glyphicon glyphicon-floppy-disk"></i> Guardar
		</button>	
	</div>
</div>
<script>
 $( function () """),format.raw/*104.17*/("""{"""),format.raw/*104.18*/("""
	 $('#searchObraSocial').modalSearch();
	 $("#cuit2").mask("99999999999");
	 $("#dni").mask("99999999");
	 $("#id_paciente_rismi").numeric_input(); 
	 if($("#obrasocial").length)"""),format.raw/*109.30*/("""{"""),format.raw/*109.31*/("""
			var options = """),format.raw/*110.18*/("""{"""),format.raw/*110.19*/("""
					script:"/suggestOb/",
					varname:"",
					json:true,
					shownoresults:true,
					maxresults:6,
					callback: function (obj) """),format.raw/*116.31*/("""{"""),format.raw/*116.32*/(""" 
												$("#obrasocial_id").val(obj.id); 
											 """),format.raw/*118.13*/("""}"""),format.raw/*118.14*/("""
				"""),format.raw/*119.5*/("""}"""),format.raw/*119.6*/(""";
			var as_json = new bsn.AutoSuggest('obrasocial', options);
		"""),format.raw/*121.3*/("""}"""),format.raw/*121.4*/("""	
 """),format.raw/*122.2*/("""}"""),format.raw/*122.3*/(""");
</script>
""")))})),format.raw/*124.2*/("""
"""),_display_(Seq[Any](/*125.2*/flash()/*125.9*/.clear())))}
    }
    
    def render(clienteForm:Form[Cliente]): play.api.templates.HtmlFormat.Appendable = apply(clienteForm)
    
    def f:((Form[Cliente]) => play.api.templates.HtmlFormat.Appendable) = (clienteForm) => apply(clienteForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:41 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/clientes/modalCargaClientes.scala.html
                    HASH: 9d31b0e50f0bf0a71aea12a4f31d13c0993f3cd6
                    MATRIX: 811->1|941->48|973->72|1047->29|1075->116|1114->121|1127->127|1253->244|1293->246|1329->248|1341->253|1387->278|1493->348|1541->387|1581->389|1610->400|1623->405|1662->406|1707->419|1809->486|1907->562|1947->567|1977->588|1996->598|2044->608|2110->638|2124->643|2154->651|2196->662|2301->731|2358->779|2398->781|2427->792|2440->797|2479->798|2525->811|2580->830|2619->860|2644->863|2731->915|2915->1076|2955->1081|2994->1111|3013->1121|3061->1131|3127->1161|3141->1166|3171->1174|3213->1185|3403->1340|3499->1414|3539->1419|3568->1439|3587->1449|3635->1459|3701->1489|3715->1494|3745->1502|3787->1513|3951->1642|4042->1711|4082->1716|4109->1734|4128->1744|4176->1754|4242->1784|4256->1789|4286->1797|4328->1808|4504->1949|4640->2062|4680->2067|4785->2150|4955->2284|4975->2295|5050->2348|5455->2718|5575->2815|5615->2820|5656->2852|5675->2862|5723->2872|5789->2902|5803->2907|5833->2915|5875->2926|6051->3067|6156->3150|6196->3155|6230->3180|6249->3190|6297->3200|6363->3230|6377->3235|6407->3243|6449->3254|6553->3322|6599->3359|6639->3361|6681->3371|6736->3390|6777->3409|6853->3450|7006->3580|7110->3648|7163->3692|7203->3694|7245->3704|7363->3787|7474->3876|7755->4128|7785->4129|7993->4308|8023->4309|8070->4327|8100->4328|8264->4463|8294->4464|8383->4524|8413->4525|8446->4530|8475->4531|8568->4596|8597->4597|8628->4600|8657->4601|8703->4615|8741->4617|8757->4624
                    LINES: 26->1|29->3|29->3|30->1|31->3|35->7|35->7|35->7|35->7|36->8|36->8|36->8|39->11|39->11|39->11|39->11|39->11|39->11|39->11|41->13|41->13|42->14|42->14|42->14|42->14|43->15|43->15|43->15|44->16|48->20|48->20|48->20|48->20|48->20|48->20|48->20|49->21|49->21|49->21|50->22|50->22|51->23|51->23|51->23|51->23|52->24|52->24|52->24|53->25|61->33|61->33|62->34|62->34|62->34|62->34|63->35|63->35|63->35|64->36|70->42|70->42|71->43|71->43|71->43|71->43|72->44|72->44|72->44|73->45|79->51|79->51|80->52|80->52|84->56|84->56|84->56|96->68|96->68|97->69|97->69|97->69|97->69|98->70|98->70|98->70|99->71|105->77|105->77|106->78|106->78|106->78|106->78|107->79|107->79|107->79|108->80|112->84|112->84|112->84|112->84|113->85|113->85|114->86|114->86|118->90|118->90|118->90|118->90|120->92|120->92|132->104|132->104|137->109|137->109|138->110|138->110|144->116|144->116|146->118|146->118|147->119|147->119|149->121|149->121|150->122|150->122|152->124|153->125|153->125
                    -- GENERATED --
                */
            