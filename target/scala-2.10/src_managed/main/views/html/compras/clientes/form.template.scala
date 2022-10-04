
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
object form extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Cliente],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(clienteForm: Form[Cliente]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.30*/("""
"""),format.raw/*3.70*/(""" 
	
<div class="row menu-acciones">
	<div class="col-sm-10">
		<button type="submit" class="btn btn-default" title="Guardar orden">
			<i class="glyphicon glyphicon-floppy-disk"></i> Guardar
		</button>	
																															   
    	<a href=""""),_display_(Seq[Any](/*11.16*/if(request().getHeader("referer"))/*11.50*/{_display_(Seq[Any](format.raw/*11.51*/(""" """),_display_(Seq[Any](/*11.53*/request()/*11.62*/.getHeader("referer"))),format.raw/*11.83*/(""" """)))}/*11.86*/else/*11.91*/{_display_(Seq[Any](_display_(Seq[Any](/*11.93*/controllers/*11.104*/.compras.routes.ClientesController.index()))))})),format.raw/*11.147*/("""" title="Cancelar editar" class="btn btn-default"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
    </div>
	<div class="col-sm-2">
		<a href=""""),_display_(Seq[Any](/*14.13*/controllers/*14.24*/.compras.routes.ClientesController.index())),format.raw/*14.66*/("""" title="Volver al listado" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
		"""),_display_(Seq[Any](/*15.4*/if(clienteForm.field("id").value)/*15.37*/{_display_(Seq[Any](format.raw/*15.38*/("""<a href=""""),_display_(Seq[Any](/*15.48*/controllers/*15.59*/.compras.routes.ClientesController.ver(clienteForm.field("id").value.toLong))),format.raw/*15.135*/("""" title="Ver cliente" class="btn btn-default"><i class="glyphicon glyphicon-align-justify"></i></a>""")))})),format.raw/*15.235*/("""
	</div>
</div>

 <div class="row">
	<div class="col-sm-3">
		<div class="form-group """),_display_(Seq[Any](/*21.27*/if(clienteForm.error("nombre") != null)/*21.66*/ {_display_(Seq[Any](format.raw/*21.68*/("""has-error""")))}/*21.79*/else/*21.84*/{_display_(Seq[Any](format.raw/*21.85*/("""has-required""")))})),format.raw/*21.98*/("""">
			<label for="nombre" class="control-label">Nombre</label>
			"""),_display_(Seq[Any](/*23.5*/inputText(clienteForm("nombre"), 'class -> "form-control" ))),format.raw/*23.64*/("""
			"""),_display_(Seq[Any](/*24.5*/clienteForm("nombre")/*24.26*/.error.map/*24.36*/{ error =>_display_(Seq[Any](format.raw/*24.46*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*25.30*/error/*25.35*/.message)),format.raw/*25.43*/("""</div>
			""")))})),format.raw/*26.5*/("""
		</div>
	</div>
	<div class="col-sm-3">
		<div class="checkbox" """),_display_(Seq[Any](/*30.26*/if(clienteForm.error("activo") != null)/*30.65*/ {_display_(Seq[Any](format.raw/*30.67*/("""has-error""")))})),format.raw/*30.77*/("""">
			<label for="activo" class="control-label"> """),_display_(Seq[Any](/*31.48*/checkbox(clienteForm("activo")))),format.raw/*31.79*/(""" ¿cliente activo?</label>
		</div>
	</div>
	
	<div class="col-sm-3">
		<div class=" form-group """),_display_(Seq[Any](/*36.28*/if(clienteForm.error("cliente_tipo_id") != null)/*36.76*/ {_display_(Seq[Any](format.raw/*36.78*/("""has-error""")))}/*36.89*/else/*36.94*/{_display_(Seq[Any](format.raw/*36.95*/("""has-required""")))})),format.raw/*36.108*/("""">
			<label for=""""),_display_(Seq[Any](/*37.17*/clienteForm("cliente_tipo_id")/*37.47*/.id)),format.raw/*37.50*/("""" class="control-label">Tipo de cliente</label>
			"""),_display_(Seq[Any](/*38.5*/select(clienteForm("cliente_tipo_id"), ClienteTipo.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*38.166*/("""
			"""),_display_(Seq[Any](/*39.5*/clienteForm("cliente_tipo_id")/*39.35*/.error.map/*39.45*/{ error =>_display_(Seq[Any](format.raw/*39.55*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*40.30*/error/*40.35*/.message)),format.raw/*40.43*/("""</div>
			""")))})),format.raw/*41.5*/("""
		</div>
	</div>
	
</div>	
<div class="row">
	<div class="col-sm-3">
		<div class="form-group">
			<label for="cuit" class="control-label">CUIT</label>
			"""),_display_(Seq[Any](/*50.5*/inputText(clienteForm("cuit2"), 'class -> "form-control" , 'id -> "cuit2"))),format.raw/*50.79*/("""
			"""),_display_(Seq[Any](/*51.5*/clienteForm("cuit2")/*51.25*/.error.map/*51.35*/{ error =>_display_(Seq[Any](format.raw/*51.45*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*52.30*/error/*52.35*/.message)),format.raw/*52.43*/("""</div>
			""")))})),format.raw/*53.5*/("""
		</div>
	</div>		
	<div class="col-sm-3">
		<div class="form-group">
			<label for="dni" class="control-label">DNI</label>
			"""),_display_(Seq[Any](/*59.5*/inputText(clienteForm("dni"), 'class -> "form-control", 'id -> "dni"))),format.raw/*59.74*/("""
			"""),_display_(Seq[Any](/*60.5*/clienteForm("dni")/*60.23*/.error.map/*60.33*/{ error =>_display_(Seq[Any](format.raw/*60.43*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*61.30*/error/*61.35*/.message)),format.raw/*61.43*/("""</div>
			""")))})),format.raw/*62.5*/("""
		</div>
	</div>
	<div class="col-sm-3">
		<div class="form-group">
			<label for="dni" class="control-label">CIE</label>
			"""),_display_(Seq[Any](/*68.5*/inputText(clienteForm("cie"), 'class -> "form-control", 'id -> "cie"))),format.raw/*68.74*/("""
			"""),_display_(Seq[Any](/*69.5*/clienteForm("cie")/*69.23*/.error.map/*69.33*/{ error =>_display_(Seq[Any](format.raw/*69.43*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*70.30*/error/*70.35*/.message)),format.raw/*70.43*/("""</div>
			""")))})),format.raw/*71.5*/("""
		</div>
	</div>
	<div class="col-sm-3">
		<label for="servicio" class="control-label">Obra Social</label>
		<div class="input-group"> 
			"""),_display_(Seq[Any](/*77.5*/inputText(clienteForm("obrasocial.nombre"),'class -> "form-control", 'id -> "obrasocial", 'autocomplete -> "off"))),format.raw/*77.118*/("""
			"""),_display_(Seq[Any](/*78.5*/inputText(clienteForm("obrasocial_id"),'hidden -> "hidden", 'id -> "obrasocial_id"))),format.raw/*78.88*/("""
			<span class="input-group-addon">
				<a href="#" id="searchObraSocial" 
				data-title="Selección de obra social" 
				data-url=""""),_display_(Seq[Any](/*82.16*/controllers/*82.27*/.compras.routes.ObrasSocialesController.modalBuscar())),format.raw/*82.80*/("""" 
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
			"""),_display_(Seq[Any](/*94.5*/inputText(clienteForm("id_paciente_rismi"), 'class -> "form-control", 'id -> "id_paciente_rismi"))),format.raw/*94.102*/("""
			"""),_display_(Seq[Any](/*95.5*/clienteForm("id_paciente_rismi")/*95.37*/.error.map/*95.47*/{ error =>_display_(Seq[Any](format.raw/*95.57*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*96.30*/error/*96.35*/.message)),format.raw/*96.43*/("""</div>
			""")))})),format.raw/*97.5*/("""
		</div>
	</div>
	<div class="col-sm-3">
		<div class="form-group">
			<label for="referencia" class="control-label">Referencia</label>
			"""),_display_(Seq[Any](/*103.5*/inputText(clienteForm("referencia"), 'class -> "form-control"))),format.raw/*103.67*/("""
			"""),_display_(Seq[Any](/*104.5*/clienteForm("referencia")/*104.30*/.error.map/*104.40*/{ error =>_display_(Seq[Any](format.raw/*104.50*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*105.30*/error/*105.35*/.message)),format.raw/*105.43*/("""</div>
			""")))})),format.raw/*106.5*/("""
		</div>
	</div>
	<div class="col-sm-3">
		<div class="form-group">
			<label for="otraReferencia" class="control-label">Otra referencia</label>
			"""),_display_(Seq[Any](/*112.5*/inputText(clienteForm("referencia_2"), 'class -> "form-control"))),format.raw/*112.69*/("""
			"""),_display_(Seq[Any](/*113.5*/clienteForm("referencia_2")/*113.32*/.error.map/*113.42*/{ error =>_display_(Seq[Any](format.raw/*113.52*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*114.30*/error/*114.35*/.message)),format.raw/*114.43*/("""</div>
			""")))})),format.raw/*115.5*/("""
		</div>
	</div>
	<div class="col-sm-3">
		<div class="form-group">
			<label for="nafliado" class="control-label">N° Afiliado</label>
			"""),_display_(Seq[Any](/*121.5*/inputText(clienteForm("nafiliado"), 'class -> "form-control"))),format.raw/*121.66*/("""
		</div>
	</div>
</div>		
<div class="row">
	<div class="col-sm-2">
		<div class="form-group """),_display_(Seq[Any](/*127.27*/if(clienteForm.error("sexo") != null)/*127.64*/ {_display_(Seq[Any](format.raw/*127.66*/("""has-error""")))})),format.raw/*127.76*/("""">
			<label for=""""),_display_(Seq[Any](/*128.17*/clienteForm("sexo"))),format.raw/*128.36*/("""" class="control-label">Sexo</label>
			"""),_display_(Seq[Any](/*129.5*/select(clienteForm("sexo"), options("M"->"Masculino","F"->"Femenino"),'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*129.135*/("""
		</div>
	</div>
	<div class="col-sm-2">
		<div class="form-group """),_display_(Seq[Any](/*133.27*/if(clienteForm.error("fnacimiento") != null)/*133.71*/ {_display_(Seq[Any](format.raw/*133.73*/("""has-error""")))})),format.raw/*133.83*/("""">
			<label for="inputNombre" class="control-label">Fecha nacimiento</label> 
			"""),_display_(Seq[Any](/*135.5*/inputText(clienteForm("fnacimiento"), 'class -> "form-control date", 'id -> "nacimiento"))),format.raw/*135.94*/("""
		</div>
	</div>
</div>	
"""),_display_(Seq[Any](/*139.2*/if(clienteForm("id").value != null)/*139.37*/ {_display_(Seq[Any](format.raw/*139.39*/("""
<script>
	$( function() """),format.raw/*141.16*/("""{"""),format.raw/*141.17*/("""
		
		$("#id_paciente_rismi").numeric_input(); 
		urlProvincias  = '"""),_display_(Seq[Any](/*144.22*/controllers/*144.33*/.administracion.routes.ProvinciasController.listOptions())),format.raw/*144.90*/("""';
		urlLocalidades = '"""),_display_(Seq[Any](/*145.22*/controllers/*145.33*/.administracion.routes.LocalidadesController.listOptions())),format.raw/*145.91*/("""';
		urlFormularioContacto  = '"""),_display_(Seq[Any](/*146.30*/controllers/*146.41*/.compras.routes.ClientesController.formularioContacto(clienteForm("id").value.toInt))),format.raw/*146.125*/("""';
		
		var contenedorContactos = $('#contenedorContactos');
		var formularioContacto = $('#formularioContacto');
		
		contenedorContactos.on('change', '.seleccionPais .select', function()"""),format.raw/*151.72*/("""{"""),format.raw/*151.73*/("""
			var id = $(this).find('option:selected').val();
			var contenedor = $(this).closest('.contenedorUbicacion');
			contenedor.find('.seleccionProvincia .select, .seleccionLocalidad .select').find('option:gt(0)').remove();
			
			if(id == "") return false;

			$.get(urlProvincias + '?paisId='+id, function(data)"""),format.raw/*158.55*/("""{"""),format.raw/*158.56*/("""
				contenedor.find('.seleccionProvincia .select').html(data);
			"""),format.raw/*160.4*/("""}"""),format.raw/*160.5*/(""");
		"""),format.raw/*161.3*/("""}"""),format.raw/*161.4*/(""");
		
		contenedorContactos.on('change', '.seleccionProvincia .select', function()"""),format.raw/*163.77*/("""{"""),format.raw/*163.78*/("""
			var id = $(this).find('option:selected').val();
			
			var contenedor = $(this).closest('.contenedorUbicacion');
			contenedor.find('.seleccionLocalidad .select').find('option:gt(0)').remove();
			
			if(id == "") return false;

			$.get(urlLocalidades + '?provinciaId='+id, function(data)"""),format.raw/*171.61*/("""{"""),format.raw/*171.62*/("""
				contenedor.find('.seleccionLocalidad .select').html(data);
			"""),format.raw/*173.4*/("""}"""),format.raw/*173.5*/(""");
		"""),format.raw/*174.3*/("""}"""),format.raw/*174.4*/(""");
		
        var contenedor = $('#contenedorDirecciones');
        var primerElemento = $('#contenedorDirecciones .linea-direccion:eq(0)');
        
        contenedor.find('.linea-direccion').hide();
        primerElemento.show();


        if (getCantidadLineas() == 1)
            primerElemento.find('.eliminar').hide();

        
        $('#nuevoContacto').on('click', function() """),format.raw/*187.52*/("""{"""),format.raw/*187.53*/(""" 
        	$('#listaContactos').toggleClass('hide');
        	$.get(urlFormularioContacto, function(data)"""),format.raw/*189.53*/("""{"""),format.raw/*189.54*/("""
        		$('#contenedorContactos').append(data);
        	"""),format.raw/*191.10*/("""}"""),format.raw/*191.11*/(""");
        	return false;
        """),format.raw/*193.9*/("""}"""),format.raw/*193.10*/(""");
        
        $('#contenedorContactos').on('click', '#modificarDireccion', function() """),format.raw/*195.81*/("""{"""),format.raw/*195.82*/(""" 
        	var url = $(this).attr('href');
        	$('#listaContactos').toggleClass('hide');
        	$.get(url, function(data)"""),format.raw/*198.35*/("""{"""),format.raw/*198.36*/("""
        		$('#contenedorContactos').append(data);
        	"""),format.raw/*200.10*/("""}"""),format.raw/*200.11*/(""");
        	return false;
        """),format.raw/*202.9*/("""}"""),format.raw/*202.10*/(""");
        
        $('#contenedorContactos').on('click', '#cancelarEdicion', function() """),format.raw/*204.78*/("""{"""),format.raw/*204.79*/(""" 
        	$('#formularioContacto').remove();
        	$('#listaContactos').toggleClass('hide');
        """),format.raw/*207.9*/("""}"""),format.raw/*207.10*/(""");
        
        $('#contenedorContactos').on('click', '#guardarContacto', function() """),format.raw/*209.78*/("""{"""),format.raw/*209.79*/(""" 
        	var url = $(this).closest('form').attr('action');
        	$this = $(this);

        	$.post(url, $(this).closest('form').serialize(), function(data)"""),format.raw/*213.73*/("""{"""),format.raw/*213.74*/("""
        		if(data.success)
        			window.location.href = data.redirect;
        		else """),format.raw/*216.16*/("""{"""),format.raw/*216.17*/("""
        			$this.closest("#formularioContacto").remove();
        			$('#contenedorContactos').append(data);
        		"""),format.raw/*219.11*/("""}"""),format.raw/*219.12*/("""
        	"""),format.raw/*220.10*/("""}"""),format.raw/*220.11*/(""");
        	return false;
        """),format.raw/*222.9*/("""}"""),format.raw/*222.10*/(""");

        function getCantidadLineas() """),format.raw/*224.38*/("""{"""),format.raw/*224.39*/("""
            return contenedor.find('.linea-direccion').length;
        """),format.raw/*226.9*/("""}"""),format.raw/*226.10*/("""
		
	"""),format.raw/*228.2*/("""}"""),format.raw/*228.3*/(""");
</script>
""")))})))}
    }
    
    def render(clienteForm:Form[Cliente]): play.api.templates.HtmlFormat.Appendable = apply(clienteForm)
    
    def f:((Form[Cliente]) => play.api.templates.HtmlFormat.Appendable) = (clienteForm) => apply(clienteForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:41 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/clientes/form.scala.html
                    HASH: 2b31df54ce683b6e9fec02a622c268cf6bdd4de3
                    MATRIX: 797->1|928->50|960->74|1034->29|1063->118|1361->380|1404->414|1443->415|1481->417|1499->426|1542->447|1563->450|1576->455|1624->457|1645->468|1715->511|1914->674|1934->685|1998->727|2135->829|2177->862|2216->863|2262->873|2282->884|2381->960|2514->1060|2642->1152|2690->1191|2730->1193|2759->1204|2772->1209|2811->1210|2856->1223|2960->1292|3041->1351|3082->1357|3112->1378|3131->1388|3179->1398|3246->1429|3260->1434|3290->1442|3333->1454|3440->1525|3488->1564|3528->1566|3570->1576|3657->1627|3710->1658|3847->1759|3904->1807|3944->1809|3973->1820|3986->1825|4025->1826|4071->1839|4127->1859|4166->1889|4191->1892|4279->1945|4463->2106|4504->2112|4543->2142|4562->2152|4610->2162|4677->2193|4691->2198|4721->2206|4764->2218|4965->2384|5061->2458|5102->2464|5131->2484|5150->2494|5198->2504|5265->2535|5279->2540|5309->2548|5352->2560|5522->2695|5613->2764|5654->2770|5681->2788|5700->2798|5748->2808|5815->2839|5829->2844|5859->2852|5902->2864|6070->2997|6161->3066|6202->3072|6229->3090|6248->3100|6296->3110|6363->3141|6377->3146|6407->3154|6450->3166|6632->3313|6768->3426|6809->3432|6914->3515|7088->3653|7108->3664|7183->3717|7600->4099|7720->4196|7761->4202|7802->4234|7821->4244|7869->4254|7936->4285|7950->4290|7980->4298|8023->4310|8206->4457|8291->4519|8333->4525|8368->4550|8388->4560|8437->4570|8505->4601|8520->4606|8551->4614|8595->4626|8787->4782|8874->4846|8916->4852|8953->4879|8973->4889|9022->4899|9090->4930|9105->4935|9136->4943|9180->4955|9362->5101|9446->5162|9584->5263|9631->5300|9672->5302|9715->5312|9772->5332|9814->5351|9892->5393|10046->5523|10155->5595|10209->5639|10250->5641|10293->5651|10414->5736|10526->5825|10593->5856|10638->5891|10679->5893|10735->5920|10765->5921|10874->5993|10895->6004|10975->6061|11037->6086|11058->6097|11139->6155|11209->6188|11230->6199|11338->6283|11560->6476|11590->6477|11938->6796|11968->6797|12065->6866|12094->6867|12128->6873|12157->6874|12270->6958|12300->6959|12630->7260|12660->7261|12757->7330|12786->7331|12820->7337|12849->7338|13278->7738|13308->7739|13444->7846|13474->7847|13565->7909|13595->7910|13659->7946|13689->7947|13812->8041|13842->8042|14002->8173|14032->8174|14123->8236|14153->8237|14217->8273|14247->8274|14367->8365|14397->8366|14533->8474|14563->8475|14683->8566|14713->8567|14906->8731|14936->8732|15060->8827|15090->8828|15242->8951|15272->8952|15312->8963|15342->8964|15406->9000|15436->9001|15508->9044|15538->9045|15640->9119|15670->9120|15705->9127|15734->9128
                    LINES: 26->1|29->3|29->3|30->1|31->3|39->11|39->11|39->11|39->11|39->11|39->11|39->11|39->11|39->11|39->11|39->11|42->14|42->14|42->14|43->15|43->15|43->15|43->15|43->15|43->15|43->15|49->21|49->21|49->21|49->21|49->21|49->21|49->21|51->23|51->23|52->24|52->24|52->24|52->24|53->25|53->25|53->25|54->26|58->30|58->30|58->30|58->30|59->31|59->31|64->36|64->36|64->36|64->36|64->36|64->36|64->36|65->37|65->37|65->37|66->38|66->38|67->39|67->39|67->39|67->39|68->40|68->40|68->40|69->41|78->50|78->50|79->51|79->51|79->51|79->51|80->52|80->52|80->52|81->53|87->59|87->59|88->60|88->60|88->60|88->60|89->61|89->61|89->61|90->62|96->68|96->68|97->69|97->69|97->69|97->69|98->70|98->70|98->70|99->71|105->77|105->77|106->78|106->78|110->82|110->82|110->82|122->94|122->94|123->95|123->95|123->95|123->95|124->96|124->96|124->96|125->97|131->103|131->103|132->104|132->104|132->104|132->104|133->105|133->105|133->105|134->106|140->112|140->112|141->113|141->113|141->113|141->113|142->114|142->114|142->114|143->115|149->121|149->121|155->127|155->127|155->127|155->127|156->128|156->128|157->129|157->129|161->133|161->133|161->133|161->133|163->135|163->135|167->139|167->139|167->139|169->141|169->141|172->144|172->144|172->144|173->145|173->145|173->145|174->146|174->146|174->146|179->151|179->151|186->158|186->158|188->160|188->160|189->161|189->161|191->163|191->163|199->171|199->171|201->173|201->173|202->174|202->174|215->187|215->187|217->189|217->189|219->191|219->191|221->193|221->193|223->195|223->195|226->198|226->198|228->200|228->200|230->202|230->202|232->204|232->204|235->207|235->207|237->209|237->209|241->213|241->213|244->216|244->216|247->219|247->219|248->220|248->220|250->222|250->222|252->224|252->224|254->226|254->226|256->228|256->228
                    -- GENERATED --
                */
            