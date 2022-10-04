
package views.html.compras.proveedores

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
object form extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Proveedor],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(provForm: Form[Proveedor]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.29*/("""
"""),format.raw/*3.70*/(""" 



	<div class="row menu-acciones">
		<div class="col-sm-10">
			<button type="submit" class="btn btn-default" title="Guardar orden">
				<i class="glyphicon glyphicon-floppy-disk"></i> Guardar
			</button>	
																																   
	    	<a href=""""),_display_(Seq[Any](/*13.17*/if(request().getHeader("referer"))/*13.51*/{_display_(Seq[Any](format.raw/*13.52*/(""" """),_display_(Seq[Any](/*13.54*/request()/*13.63*/.getHeader("referer"))),format.raw/*13.84*/(""" """)))}/*13.87*/else/*13.92*/{_display_(Seq[Any](_display_(Seq[Any](/*13.94*/controllers/*13.105*/.compras.routes.ProveedoresController.index()))))})),format.raw/*13.151*/("""" title="Cancelar editar" class="btn btn-default"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
	    </div>
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*16.14*/controllers/*16.25*/.compras.routes.ProveedoresController.index())),format.raw/*16.70*/("""" title="Volver al listado" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
			"""),_display_(Seq[Any](/*17.5*/if(provForm.field("id").value)/*17.35*/{_display_(Seq[Any](format.raw/*17.36*/("""<a href=""""),_display_(Seq[Any](/*17.46*/controllers/*17.57*/.compras.routes.ProveedoresController.ver(provForm.field("id").value.toLong))),format.raw/*17.133*/("""" title="Ver proveedor" class="btn btn-default"><i class="glyphicon glyphicon-align-justify"></i></a>""")))})),format.raw/*17.235*/("""
		</div>
	</div>
 <div class="row">
 	"""),_display_(Seq[Any](/*21.4*/inputText(provForm("id"), 'type -> "hidden", 'id -> "proveedorId"))),format.raw/*21.70*/("""
	<div class="col-sm-4">
		<div class="form-group """),_display_(Seq[Any](/*23.27*/if(provForm.error("nombre") != null)/*23.63*/ {_display_(Seq[Any](format.raw/*23.65*/("""has-error""")))}/*23.76*/else/*23.81*/{_display_(Seq[Any](format.raw/*23.82*/("""has-required""")))})),format.raw/*23.95*/("""">
			<label for="nombre" class="control-label">Nombre del proveedor</label>
			"""),_display_(Seq[Any](/*25.5*/if(provForm.field("id").value)/*25.35*/{_display_(Seq[Any](format.raw/*25.36*/("""
				
				"""),_display_(Seq[Any](/*27.6*/inputText(provForm("nombre"), 'class -> "form-control",'readOnly -> "readOnly"))),format.raw/*27.85*/("""
				
			""")))}/*29.5*/else/*29.9*/{_display_(Seq[Any](format.raw/*29.10*/("""
				"""),_display_(Seq[Any](/*30.6*/inputText(provForm("nombre"), 'class -> "form-control"))),format.raw/*30.61*/("""
				"""),_display_(Seq[Any](/*31.6*/provForm("nombre")/*31.24*/.error.map/*31.34*/{ error =>_display_(Seq[Any](format.raw/*31.44*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*32.31*/error/*32.36*/.message)),format.raw/*32.44*/("""</div>
				""")))})),format.raw/*33.6*/("""
			""")))})),format.raw/*34.5*/("""
		</div>
	</div>
	
	<div class="col-sm-3">
		<div class="form-group """),_display_(Seq[Any](/*39.27*/if(provForm.error("referencia") != null)/*39.67*/ {_display_(Seq[Any](format.raw/*39.69*/("""has-error""")))})),format.raw/*39.79*/("""">
			<label for="referencia" class="control-label">Referencia</label>
			"""),_display_(Seq[Any](/*41.5*/inputText(provForm("referencia"), 'class -> "form-control"))),format.raw/*41.64*/("""
			"""),_display_(Seq[Any](/*42.5*/provForm("referencia")/*42.27*/.error.map/*42.37*/{ error =>_display_(Seq[Any](format.raw/*42.47*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*43.30*/error/*43.35*/.message)),format.raw/*43.43*/("""</div>
			""")))})),format.raw/*44.5*/("""
		</div>
	</div>

	<div class="col-sm-4">
		<label class="control-label">Agente
			<div class="input-group">
				"""),_display_(Seq[Any](/*51.6*/inputText(provForm("agente.apellido"), 'name -> "", 'class -> "form-control", 'id -> "agente"))),format.raw/*51.100*/("""
				"""),_display_(Seq[Any](/*52.6*/inputText(provForm("agente_id"), 'hidden -> "hidden", 'id -> "agente_id"))),format.raw/*52.79*/("""
				<span class="input-group-addon">
					<a href="#" id="searchAgente" 
								data-title="Selección de agente" 
								data-url=""""),_display_(Seq[Any](/*56.20*/controllers/*56.31*/.rrhh.routes.AgentesController.modalBuscar())),format.raw/*56.75*/("""" 
								data-height="650" data-width="700" data-listen="modal.seleccion.agente.simple" 
								data-label="#agente" data-field="#agente_id">
								<i class="glyphicon glyphicon-search"></i></a></span>
			</div>
		</label>
	</div>
	
	
</div>
<div class="row">
	<div class="col-sm-2">
		<div class="form-group """),_display_(Seq[Any](/*68.27*/if(provForm.error("cuit") != null)/*68.61*/ {_display_(Seq[Any](format.raw/*68.63*/("""has-error""")))}/*68.74*/else/*68.79*/{_display_(Seq[Any](format.raw/*68.80*/("""has-required""")))})),format.raw/*68.93*/("""">
			<label for="cuit" class="control-label">Cuit</label>
			"""),_display_(Seq[Any](/*70.5*/if(provForm.field("id").value)/*70.35*/{_display_(Seq[Any](format.raw/*70.36*/("""
				"""),_display_(Seq[Any](/*71.6*/inputText(provForm("cuit"), 'class -> "form-control",'readOnly -> "readOnly"))),format.raw/*71.83*/("""
			""")))}/*72.5*/else/*72.9*/{_display_(Seq[Any](format.raw/*72.10*/("""
				"""),_display_(Seq[Any](/*73.6*/inputText(provForm("cuit"), 'class -> "form-control", 'id -> "cuit"))),format.raw/*73.74*/("""
				"""),_display_(Seq[Any](/*74.6*/provForm("cuit")/*74.22*/.error.map/*74.32*/{ error =>_display_(Seq[Any](format.raw/*74.42*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*75.31*/error/*75.36*/.message)),format.raw/*75.44*/("""</div>
				""")))})),format.raw/*76.6*/("""
			""")))})),format.raw/*77.5*/("""
		</div>
	</div>		
	<div class="col-sm-2">
		<div class="form-group">
			<label for="cuit" class="control-label">DNI</label>
			 
				"""),_display_(Seq[Any](/*84.6*/inputText(provForm("dni"), 'class -> "form-control", 'id -> "dni"))),format.raw/*84.72*/("""
				 
			 
		</div>
	</div>		
	
	<div class="col-sm-2">
		<div class="form-group """),_display_(Seq[Any](/*91.27*/if(provForm.error("fecha_vencimiento_322") != null)/*91.78*/ {_display_(Seq[Any](format.raw/*91.80*/("""has-error""")))})),format.raw/*91.90*/("""">
			<label for="fecha_factura" class="control-label">Fecha vencimiento 322</label> 
			"""),_display_(Seq[Any](/*93.5*/inputText(provForm("fecha_vencimiento_322"),'class -> "form-control date", 'id -> "fecha_vencimiento_322"))),format.raw/*93.111*/("""
		</div>
	</div>
	<div class="col-sm-3">
			<label class="control-label">Proveedor Padre</label> 
			<div class="input-group">	
				"""),_display_(Seq[Any](/*99.6*/inputText(provForm("proveedor_padre.nombre"), 'class -> "form-control", 'id -> "proveedor_padre"))),format.raw/*99.103*/("""
				"""),_display_(Seq[Any](/*100.6*/inputText(provForm("proveedor_padre_id"), 'hidden -> "hidden", 'id -> "proveedor_padre_id"))),format.raw/*100.97*/("""
				<span class="input-group-addon">
                	<a href="#" id="searchProveedor" 
                	data-title="Selección de proveedor" 
                	data-url=""""),_display_(Seq[Any](/*104.29*/controllers/*104.40*/.compras.routes.ProveedoresController.modalBuscar())),format.raw/*104.91*/("""" 
                	data-height="650" data-width="700" data-listen="modal.seleccion.proveedor.simple" 
                	data-label="#proveedor_padre" data-field="#proveedor_padre_id" /> <i class="glyphicon glyphicon-search"></i></a>
                </span>
			</div>
			 
		</div>
	
</div>
<div class="row">
	<div class="col-sm-2">
		<div class="form-group """),_display_(Seq[Any](/*115.27*/if(provForm.error("numero_inscripcion") != null)/*115.75*/ {_display_(Seq[Any](format.raw/*115.77*/("""has-error""")))})),format.raw/*115.87*/("""">
			<label for="numero_inscripcion" class="control-label">Número de inscripción</label>
			"""),_display_(Seq[Any](/*117.5*/inputText(provForm("numero_inscripcion"), 'class -> "form-control"))),format.raw/*117.72*/("""
			"""),_display_(Seq[Any](/*118.5*/provForm("numero_inscripcion")/*118.35*/.error.map/*118.45*/{ error =>_display_(Seq[Any](format.raw/*118.55*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*119.30*/error/*119.35*/.message)),format.raw/*119.43*/("""</div>
			""")))})),format.raw/*120.5*/("""
		</div>
	</div>
	<div class="col-sm-offset-1  col-sm-2">
		<div class="checkbox" """),_display_(Seq[Any](/*124.26*/if(provForm.error("activo") != null)/*124.62*/ {_display_(Seq[Any](format.raw/*124.64*/("""has-error""")))})),format.raw/*124.74*/("""">
			<label for="activo" class="control-label"> """),_display_(Seq[Any](/*125.48*/checkbox(provForm("activo")))),format.raw/*125.76*/(""" Activo</label>
			
		</div>
	</div>
	
	<div class="col-sm-offset-1  col-sm-2">
		<div class="checkbox" """),_display_(Seq[Any](/*131.26*/if(provForm.error("oficio") != null)/*131.62*/ {_display_(Seq[Any](format.raw/*131.64*/("""has-error""")))})),format.raw/*131.74*/("""">
			<label for="oficio" class="control-label"> """),_display_(Seq[Any](/*132.48*/checkbox(provForm("oficio")))),format.raw/*132.76*/(""" Oficio</label>
			
		</div>
	</div>
</div>
<script>
	$( function() """),format.raw/*138.16*/("""{"""),format.raw/*138.17*/("""
		$("#cuit").mask("99999999999");
		$("#dni").mask("99999999");
		$('#searchAgente,#searchProveedor').modalSearch();
	"""),format.raw/*142.2*/("""}"""),format.raw/*142.3*/(""");
</script>
"""),_display_(Seq[Any](/*144.2*/if(provForm("id").value != null && provForm("id").value != "")/*144.64*/ {_display_(Seq[Any](format.raw/*144.66*/("""

<script>
	$( function() """),format.raw/*147.16*/("""{"""),format.raw/*147.17*/("""
		
		
		 
		
		urlProvincias  = '"""),_display_(Seq[Any](/*152.22*/controllers/*152.33*/.administracion.routes.ProvinciasController.listOptions())),format.raw/*152.90*/("""';
		urlLocalidades = '"""),_display_(Seq[Any](/*153.22*/controllers/*153.33*/.administracion.routes.LocalidadesController.listOptions())),format.raw/*153.91*/("""';
		urlFormularioContacto  = '"""),_display_(Seq[Any](/*154.30*/controllers/*154.41*/.compras.routes.ProveedoresController.formularioContacto(provForm("id").value.toInt))),format.raw/*154.125*/("""';
		
		var contenedorContactos = $('#contenedorContactos');
		var formularioContacto = $('#formularioContacto');
		
		contenedorContactos.on('change', '.seleccionPais .select', function()"""),format.raw/*159.72*/("""{"""),format.raw/*159.73*/("""
			var id = $(this).find('option:selected').val();
			var contenedor = $(this).closest('.contenedorUbicacion');
			contenedor.find('.seleccionProvincia .select, .seleccionLocalidad .select').find('option:gt(0)').remove();
			
			if(id == "") return false;

			$.get(urlProvincias + '?paisId='+id, function(data)"""),format.raw/*166.55*/("""{"""),format.raw/*166.56*/("""
				contenedor.find('.seleccionProvincia .select').html(data);
			"""),format.raw/*168.4*/("""}"""),format.raw/*168.5*/(""");
		"""),format.raw/*169.3*/("""}"""),format.raw/*169.4*/(""");
		
		contenedorContactos.on('change', '.seleccionProvincia .select', function()"""),format.raw/*171.77*/("""{"""),format.raw/*171.78*/("""
			var id = $(this).find('option:selected').val();
			
			var contenedor = $(this).closest('.contenedorUbicacion');
			contenedor.find('.seleccionLocalidad .select').find('option:gt(0)').remove();
			
			if(id == "") return false;

			$.get(urlLocalidades + '?provinciaId='+id, function(data)"""),format.raw/*179.61*/("""{"""),format.raw/*179.62*/("""
				contenedor.find('.seleccionLocalidad .select').html(data);
			"""),format.raw/*181.4*/("""}"""),format.raw/*181.5*/(""");
		"""),format.raw/*182.3*/("""}"""),format.raw/*182.4*/(""");
		
        var contenedor = $('#contenedorDirecciones');
        var primerElemento = $('#contenedorDirecciones .linea-direccion:eq(0)');
        
        contenedor.find('.linea-direccion').hide();
        primerElemento.show();

        if (getCantidadLineas() == 1)
            primerElemento.find('.eliminar').hide();

        $('#nuevoContacto').on('click', function() """),format.raw/*193.52*/("""{"""),format.raw/*193.53*/(""" 
        	$('#listaContactos').toggleClass('hide');
        	$.get(urlFormularioContacto, function(data)"""),format.raw/*195.53*/("""{"""),format.raw/*195.54*/("""
        		$('#contenedorContactos').append(data);
        	"""),format.raw/*197.10*/("""}"""),format.raw/*197.11*/(""");
        	return false;
        """),format.raw/*199.9*/("""}"""),format.raw/*199.10*/(""");
        
        
        $('#contenedorContactos').on('click', '#modificarDireccion', function() """),format.raw/*202.81*/("""{"""),format.raw/*202.82*/(""" 
        	var url = $(this).attr('href');
        	$('#listaContactos').toggleClass('hide');
        	$.get(url, function(data)"""),format.raw/*205.35*/("""{"""),format.raw/*205.36*/("""
        		$('#contenedorContactos').append(data);
        	"""),format.raw/*207.10*/("""}"""),format.raw/*207.11*/(""");
        	return false;
        """),format.raw/*209.9*/("""}"""),format.raw/*209.10*/(""");
        
        $('#contenedorContactos').on('click', '#cancelarEdicion', function() """),format.raw/*211.78*/("""{"""),format.raw/*211.79*/(""" 
        	$('#formularioContacto').remove();
        	$('#listaContactos').toggleClass('hide');;
        """),format.raw/*214.9*/("""}"""),format.raw/*214.10*/(""");
        
        $('#contenedorContactos').on('click', '#guardarContacto', function() """),format.raw/*216.78*/("""{"""),format.raw/*216.79*/(""" 
        	var url = $(this).closest('form').attr('action');
        	$this = $(this);

        	$.post(url, $(this).closest('form').serialize(), function(data)"""),format.raw/*220.73*/("""{"""),format.raw/*220.74*/("""
        		if(data.success)
        			window.location.href = data.redirect;
        		else """),format.raw/*223.16*/("""{"""),format.raw/*223.17*/("""
        			$this.closest("#formularioContacto").remove();
        			$('#contenedorContactos').append(data);
        		"""),format.raw/*226.11*/("""}"""),format.raw/*226.12*/("""
        	"""),format.raw/*227.10*/("""}"""),format.raw/*227.11*/(""");
        	return false;
        """),format.raw/*229.9*/("""}"""),format.raw/*229.10*/(""");
        
        
        function getCantidadLineas() """),format.raw/*232.38*/("""{"""),format.raw/*232.39*/("""
            return contenedor.find('.linea-direccion').length;
        """),format.raw/*234.9*/("""}"""),format.raw/*234.10*/("""
		 
	"""),format.raw/*236.2*/("""}"""),format.raw/*236.3*/(""");
</script>
""")))})),format.raw/*238.2*/("""

	
	
	"""))}
    }
    
    def render(provForm:Form[Proveedor]): play.api.templates.HtmlFormat.Appendable = apply(provForm)
    
    def f:((Form[Proveedor]) => play.api.templates.HtmlFormat.Appendable) = (provForm) => apply(provForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:46 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/proveedores/form.scala.html
                    HASH: 33dc36353126c9f7f7f5230917c991bd09148195
                    MATRIX: 802->1|932->49|964->73|1038->28|1067->117|1375->389|1418->423|1457->424|1495->426|1513->435|1556->456|1577->459|1590->464|1638->466|1659->477|1732->523|1934->689|1954->700|2021->745|2159->848|2198->878|2237->879|2283->889|2303->900|2402->976|2537->1078|2616->1122|2704->1188|2793->1241|2838->1277|2878->1279|2907->1290|2920->1295|2959->1296|3004->1309|3122->1392|3161->1422|3200->1423|3248->1436|3349->1515|3379->1527|3391->1531|3430->1532|3472->1539|3549->1594|3591->1601|3618->1619|3637->1629|3685->1639|3753->1671|3767->1676|3797->1684|3841->1697|3878->1703|3989->1778|4038->1818|4078->1820|4120->1830|4232->1907|4313->1966|4354->1972|4385->1994|4404->2004|4452->2014|4519->2045|4533->2050|4563->2058|4606->2070|4763->2192|4880->2286|4922->2293|5017->2366|5192->2505|5212->2516|5278->2560|5641->2887|5684->2921|5724->2923|5753->2934|5766->2939|5805->2940|5850->2953|5950->3018|5989->3048|6028->3049|6070->3056|6169->3133|6193->3139|6205->3143|6244->3144|6286->3151|6376->3219|6418->3226|6443->3242|6462->3252|6510->3262|6578->3294|6592->3299|6622->3307|6666->3320|6703->3326|6881->3469|6969->3535|7095->3625|7155->3676|7195->3678|7237->3688|7364->3780|7493->3886|7668->4026|7788->4123|7831->4130|7945->4221|8157->4396|8178->4407|8252->4458|8658->4827|8716->4875|8757->4877|8800->4887|8932->4983|9022->5050|9064->5056|9104->5086|9124->5096|9173->5106|9241->5137|9256->5142|9287->5150|9331->5162|9456->5250|9502->5286|9543->5288|9586->5298|9674->5349|9725->5377|9873->5488|9919->5524|9960->5526|10003->5536|10091->5587|10142->5615|10245->5689|10275->5690|10426->5813|10455->5814|10507->5830|10579->5892|10620->5894|10678->5923|10708->5924|10785->5964|10806->5975|10886->6032|10948->6057|10969->6068|11050->6126|11120->6159|11141->6170|11249->6254|11471->6447|11501->6448|11849->6767|11879->6768|11976->6837|12005->6838|12039->6844|12068->6845|12181->6929|12211->6930|12541->7231|12571->7232|12668->7301|12697->7302|12731->7308|12760->7309|13177->7697|13207->7698|13343->7805|13373->7806|13464->7868|13494->7869|13558->7905|13588->7906|13721->8010|13751->8011|13911->8142|13941->8143|14032->8205|14062->8206|14126->8242|14156->8243|14276->8334|14306->8335|14443->8444|14473->8445|14593->8536|14623->8537|14816->8701|14846->8702|14970->8797|15000->8798|15152->8921|15182->8922|15222->8933|15252->8934|15316->8970|15346->8971|15436->9032|15466->9033|15568->9107|15598->9108|15634->9116|15663->9117|15711->9133
                    LINES: 26->1|29->3|29->3|30->1|31->3|41->13|41->13|41->13|41->13|41->13|41->13|41->13|41->13|41->13|41->13|41->13|44->16|44->16|44->16|45->17|45->17|45->17|45->17|45->17|45->17|45->17|49->21|49->21|51->23|51->23|51->23|51->23|51->23|51->23|51->23|53->25|53->25|53->25|55->27|55->27|57->29|57->29|57->29|58->30|58->30|59->31|59->31|59->31|59->31|60->32|60->32|60->32|61->33|62->34|67->39|67->39|67->39|67->39|69->41|69->41|70->42|70->42|70->42|70->42|71->43|71->43|71->43|72->44|79->51|79->51|80->52|80->52|84->56|84->56|84->56|96->68|96->68|96->68|96->68|96->68|96->68|96->68|98->70|98->70|98->70|99->71|99->71|100->72|100->72|100->72|101->73|101->73|102->74|102->74|102->74|102->74|103->75|103->75|103->75|104->76|105->77|112->84|112->84|119->91|119->91|119->91|119->91|121->93|121->93|127->99|127->99|128->100|128->100|132->104|132->104|132->104|143->115|143->115|143->115|143->115|145->117|145->117|146->118|146->118|146->118|146->118|147->119|147->119|147->119|148->120|152->124|152->124|152->124|152->124|153->125|153->125|159->131|159->131|159->131|159->131|160->132|160->132|166->138|166->138|170->142|170->142|172->144|172->144|172->144|175->147|175->147|180->152|180->152|180->152|181->153|181->153|181->153|182->154|182->154|182->154|187->159|187->159|194->166|194->166|196->168|196->168|197->169|197->169|199->171|199->171|207->179|207->179|209->181|209->181|210->182|210->182|221->193|221->193|223->195|223->195|225->197|225->197|227->199|227->199|230->202|230->202|233->205|233->205|235->207|235->207|237->209|237->209|239->211|239->211|242->214|242->214|244->216|244->216|248->220|248->220|251->223|251->223|254->226|254->226|255->227|255->227|257->229|257->229|260->232|260->232|262->234|262->234|264->236|264->236|266->238
                    -- GENERATED --
                */
            