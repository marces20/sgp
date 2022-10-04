
package views.html.patrimonio.inventario

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
object registrarModal extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[RemitoLinea,Form[Inventario],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea: RemitoLinea, iForm: Form[Inventario]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.47*/("""
"""),format.raw/*4.70*/(""" 

<div class="row">

	<div class="col-sm-2">
		<label class="control-label">Remito</label>
		<p class="form-control-static form-control">"""),_display_(Seq[Any](/*10.48*/linea/*10.53*/.remito_id)),format.raw/*10.63*/("""</p>
	</div>

	<div class="col-sm-8">
		<label class="control-label">Producto</label>
		<p class="form-control-static form-control">"""),_display_(Seq[Any](/*15.48*/linea/*15.53*/.lineaOrden.producto.nombre)),format.raw/*15.80*/("""</p>
	</div>
	
	<div class="col-sm-2">
		<label class="control-label">Cantidad</label>
		<p class="form-control-static form-control">"""),_display_(Seq[Any](/*20.48*/linea/*20.53*/.cantidad)),format.raw/*20.62*/("""</p>
	</div>
</div>

<h3 style="margin-top:15px">Números de inventario</h3>
<hr />


	<label for="cuenta" class="control-label">Prefijo</label>
	<div class="input-group """),_display_(Seq[Any](/*29.27*/if(iForm.error("cuenta_analitica_id") != null)/*29.73*/ {_display_(Seq[Any](format.raw/*29.75*/("""has-error""")))}/*29.86*/else/*29.91*/{_display_(Seq[Any](format.raw/*29.92*/("""has-required""")))})),format.raw/*29.105*/("""">
		"""),_display_(Seq[Any](/*30.4*/inputText(iForm("profijo.nombre"), 'class -> "form-control", 'id -> "prefijo"))),format.raw/*30.82*/("""
		"""),_display_(Seq[Any](/*31.4*/inputText(iForm("nomenclador_inventario_id"), 'hidden -> "hidden", 'id -> "prefijo_id"))),format.raw/*31.91*/("""
		<span class="input-group-addon">
			<a href="#" 
			   id="searchPrefijo" 
			   class="searchModal"
			   data-title="Selección de prefijo" 
			   data-url=""""),_display_(Seq[Any](/*37.18*/controllers/*37.29*/.patrimonio.routes.PrefijosController.modalBuscar())),format.raw/*37.80*/("""" 
			   data-height="650" 
			   data-width="700" 
			   data-listen="modal.seleccion.prefijo.simple" 
			   data-label="#prefijo" data-field="#prefijo_id">
			   <i class="glyphicon glyphicon-search"></i>
			 </a>
		</span>
	</div>
	"""),_display_(Seq[Any](/*46.3*/iForm("cuenta_analitica_id")/*46.31*/.error.map/*46.41*/{ error =>_display_(Seq[Any](format.raw/*46.51*/("""
		<div class="text-error">"""),_display_(Seq[Any](/*47.28*/error/*47.33*/.message)),format.raw/*47.41*/("""</div>
	""")))})),format.raw/*48.3*/("""
<hr />

<input type="hidden" id="remito_id"  value=""""),_display_(Seq[Any](/*51.46*/linea/*51.51*/.remito_id)),format.raw/*51.61*/("""" />
<input type="hidden" id="producto_id"  value=""""),_display_(Seq[Any](/*52.48*/linea/*52.53*/.lineaOrden.producto_id)),format.raw/*52.76*/("""" />




<div id="listaInventario">

	"""),_display_(Seq[Any](/*59.3*/for( inventario <- linea.getInventario() ) yield /*59.45*/{_display_(Seq[Any](format.raw/*59.46*/("""
	<div class="row lineaNumeroInventario" data-id=""""),_display_(Seq[Any](/*60.51*/inventario/*60.61*/.id)),format.raw/*60.64*/("""">
		
		<div class="col-sm-3">
			<div class="row">
				<div class="col-sm-8">
					<div class="form-group">
						<input type="text" name="numero" value=""""),_display_(Seq[Any](/*66.48*/inventario/*66.58*/.numero)),format.raw/*66.65*/("""" class="form-control numero" >
					</div>
				</div>
				<div class="col-sm-4">
					<div class="form-group">
						<input type="text" name="division" value=""""),_display_(Seq[Any](/*71.50*/inventario/*71.60*/.division)),format.raw/*71.69*/("""" class="form-control division" size="3">
					</div>
				</div>
			</div>
		</div>
		
		<div class="col-sm-5">
			<button type="submit" class="btn btn-default enviar" title="Guardar"><i class="glyphicon glyphicon-pencil" data-href=""></i></button>
			<button type="submit" class="btn btn-default dividir" title="Dividir"><i class="glyphicon glyphicon-align-justify" data-href=""></i></button>
			<button type="submit" class="btn btn-default eliminar icono-eliminar pull-right" title="Dividir"><i class="glyphicon glyphicon-remove" data-href=""></i></button>
		</div>
		
	</div>
	""")))})),format.raw/*84.3*/("""

</div>

	<div class="row lineaNumeroInventario hidden" id="estructura">
		<div class="col-sm-3">
			<div class="row">
				<div class="col-sm-8">
					<div class="form-group">
						"""),_display_(Seq[Any](/*93.8*/inputText(iForm("numero"), 'class -> "form-control numero", 'placeholder -> "Número"))),format.raw/*93.93*/("""
					</div>
				</div>
				<div class="col-sm-4">
					<div class="form-group">
						"""),_display_(Seq[Any](/*98.8*/inputText(iForm("division"), 'class -> "form-control division", 'size -> "3"))),format.raw/*98.85*/("""
					</div>
				</div>
			</div>
		</div>
		
		<div class="col-sm-5">
			<button type="submit" class="btn btn-default enviar" title="Editar"><i class="glyphicon glyphicon-floppy-disk"></i></button>
			<button type="submit" class="btn btn-default dividir hidden" title="Dividir"><i class="glyphicon glyphicon-align-justify" data-href=""></i></button>
			<button type="submit" class="btn btn-default eliminar hidden icono-eliminar pull-right" title="Dividir"><i class="glyphicon glyphicon-remove" data-href=""></i></button>
		</div>
	</div>


<script>
$( function()"""),format.raw/*113.14*/("""{"""),format.raw/*113.15*/("""
	
	var remito_id = $('#remito_id').val();

	$('#searchPrefijo').modalSearch();

	
	var options = """),format.raw/*120.16*/("""{"""),format.raw/*120.17*/("""
			script:"/patrimonio/suggestPrefijo/",
			varname:"",
			json:true,
			shownoresults:true,
			maxresults:6,
			callback: function (obj) """),format.raw/*126.29*/("""{"""),format.raw/*126.30*/(""" 
										$("#prefijo").next().val(obj.id); 
									 """),format.raw/*128.11*/("""}"""),format.raw/*128.12*/("""
		"""),format.raw/*129.3*/("""}"""),format.raw/*129.4*/(""";
	var as_json = new bsn.AutoSuggest('prefijo', options);
	
	function crearLinea() """),format.raw/*132.24*/("""{"""),format.raw/*132.25*/("""
		var estructura = $('#estructura').clone(true).removeAttr('id');
		$('#listaInventario').prepend(estructura);
		estructura.removeClass('hidden');
	"""),format.raw/*136.2*/("""}"""),format.raw/*136.3*/("""
	crearLinea();
	
	
	
	$('#listaInventario').on('click', '.dividir', function() """),format.raw/*141.59*/("""{"""),format.raw/*141.60*/("""
		var contenedor = $(this).closest('.lineaNumeroInventario');
		var copia = contenedor.clone();
		copia.find('.enviar i').addClass("glyphicon-floppy-disk").removeClass("glyphicon-pencil");
		copia.attr("data-id", "");	
		copia.find(".numero").val("");
		$(contenedor).after(copia);
		copia.find('.numero').focus();
	"""),format.raw/*149.2*/("""}"""),format.raw/*149.3*/(""");
	
	$('#listaInventario').on('click', '.enviar', function() """),format.raw/*151.58*/("""{"""),format.raw/*151.59*/("""
		var btn = $(this);
		var linea = $(this).closest('.lineaNumeroInventario');
		var prefijo = $('#prefijo_id').val();
		var numero = linea.find('.numero').val();
		var division =  linea.find('.division').val();
		var producto_id =  $('#producto_id').val();
		var id = linea.attr("data-id");
		
		if(prefijo == "") """),format.raw/*160.21*/("""{"""),format.raw/*160.22*/("""
			alert("Debe elegir un prefijo.");
			return false;
		"""),format.raw/*163.3*/("""}"""),format.raw/*163.4*/(""" else if (numero == "") """),format.raw/*163.28*/("""{"""),format.raw/*163.29*/("""
			alert("Debe indicar un número de inventario.");
			return false;
		"""),format.raw/*166.3*/("""}"""),format.raw/*166.4*/("""

		if(typeof id != "undefined" && id != "") """),format.raw/*168.44*/("""{"""),format.raw/*168.45*/("""
			var url = '"""),_display_(Seq[Any](/*169.16*/controllers/*169.27*/.patrimonio.routes.InventarioController.actualizar())),format.raw/*169.79*/("""';
		"""),format.raw/*170.3*/("""}"""),format.raw/*170.4*/(""" else """),format.raw/*170.10*/("""{"""),format.raw/*170.11*/("""
			var url = '"""),_display_(Seq[Any](/*171.16*/controllers/*171.27*/.patrimonio.routes.InventarioController.guardar())),format.raw/*171.76*/("""';
		"""),format.raw/*172.3*/("""}"""),format.raw/*172.4*/("""
		
		linea.find('button').attr('disabled', true);
		$.post(url, """),format.raw/*175.15*/("""{"""),format.raw/*175.16*/("""id: id, remito_id: remito_id, nomenclador_inventario_id: prefijo, numero: numero, division: division, producto_id:producto_id"""),format.raw/*175.141*/("""}"""),format.raw/*175.142*/(""", function(data)"""),format.raw/*175.158*/("""{"""),format.raw/*175.159*/("""
			if(data.success) """),format.raw/*176.21*/("""{"""),format.raw/*176.22*/("""
				alert("El número de inventario se ha creado correctamente.");
				if(data.id) """),format.raw/*178.17*/("""{"""),format.raw/*178.18*/("""
					btn.find('i').addClass("glyphicon-pencil").removeClass("glyphicon-floppy-disk");
					linea.find('.dividir').removeClass('hidden');
					linea.find('.eliminar').removeClass('hidden');
					linea.attr('data-id', data.id);
				"""),format.raw/*183.5*/("""}"""),format.raw/*183.6*/("""
			"""),format.raw/*184.4*/("""}"""),format.raw/*184.5*/(""" else """),format.raw/*184.11*/("""{"""),format.raw/*184.12*/("""
				alert(data.message);
			"""),format.raw/*186.4*/("""}"""),format.raw/*186.5*/("""
			linea.find('button').removeAttr('disabled');
			
		"""),format.raw/*189.3*/("""}"""),format.raw/*189.4*/(""");
	"""),format.raw/*190.2*/("""}"""),format.raw/*190.3*/(""");
	
	$('#listaInventario').on('click', '.eliminar', function() """),format.raw/*192.60*/("""{"""),format.raw/*192.61*/("""
		var btn = $(this);
		var linea = $(this).closest('.lineaNumeroInventario');
		var id = linea.attr("data-id");

		if(id == "") """),format.raw/*197.16*/("""{"""),format.raw/*197.17*/("""
			linea.remove();
			
			alert($('#listaInventario .lineaNumeroInventario').length);
			if($('#listaInventario .lineaNumeroInventario').length < 1)"""),format.raw/*201.63*/("""{"""),format.raw/*201.64*/("""
				crearLinea();
			"""),format.raw/*203.4*/("""}"""),format.raw/*203.5*/("""
			
		"""),format.raw/*205.3*/("""}"""),format.raw/*205.4*/(""" else """),format.raw/*205.10*/("""{"""),format.raw/*205.11*/("""
			var url = '"""),_display_(Seq[Any](/*206.16*/controllers/*206.27*/.patrimonio.routes.InventarioController.eliminar())),format.raw/*206.77*/("""';
			$.get(url, """),format.raw/*207.15*/("""{"""),format.raw/*207.16*/("""id: id"""),format.raw/*207.22*/("""}"""),format.raw/*207.23*/(""", function(data)"""),format.raw/*207.39*/("""{"""),format.raw/*207.40*/("""
				
				if(data.success) """),format.raw/*209.22*/("""{"""),format.raw/*209.23*/("""
					alert("El número de inventario se ha eliminado correctamente.");
					linea.remove();
				"""),format.raw/*212.5*/("""}"""),format.raw/*212.6*/(""" else """),format.raw/*212.12*/("""{"""),format.raw/*212.13*/("""
					alert(data.message);
				"""),format.raw/*214.5*/("""}"""),format.raw/*214.6*/("""
				
				if($('#listaInventario .lineaNumeroInventario').length < 1)"""),format.raw/*216.64*/("""{"""),format.raw/*216.65*/("""
					crearLinea();
				"""),format.raw/*218.5*/("""}"""),format.raw/*218.6*/("""
				
			"""),format.raw/*220.4*/("""}"""),format.raw/*220.5*/(""");
		"""),format.raw/*221.3*/("""}"""),format.raw/*221.4*/("""

	"""),format.raw/*223.2*/("""}"""),format.raw/*223.3*/(""");
	
"""),format.raw/*225.1*/("""}"""),format.raw/*225.2*/(""")
</script>


"""))}
    }
    
    def render(linea:RemitoLinea,iForm:Form[Inventario]): play.api.templates.HtmlFormat.Appendable = apply(linea,iForm)
    
    def f:((RemitoLinea,Form[Inventario]) => play.api.templates.HtmlFormat.Appendable) = (linea,iForm) => apply(linea,iForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/inventario/registrarModal.scala.html
                    HASH: 81731f40858d49c28d09030c61361fbd82c9d7de
                    MATRIX: 827->1|992->84|1024->108|1098->46|1127->152|1308->297|1322->302|1354->312|1528->450|1542->455|1591->482|1766->621|1780->626|1811->635|2026->814|2081->860|2121->862|2150->873|2163->878|2202->879|2248->892|2290->899|2390->977|2430->982|2539->1069|2743->1237|2763->1248|2836->1299|3116->1544|3153->1572|3172->1582|3220->1592|3285->1621|3299->1626|3329->1634|3370->1644|3463->1701|3477->1706|3509->1716|3598->1769|3612->1774|3657->1797|3738->1843|3796->1885|3835->1886|3923->1938|3942->1948|3967->1951|4165->2113|4184->2123|4213->2130|4415->2296|4434->2306|4465->2315|5090->2909|5318->3102|5425->3187|5553->3280|5652->3357|6260->3936|6290->3937|6424->4042|6454->4043|6628->4188|6658->4189|6746->4248|6776->4249|6808->4253|6837->4254|6952->4340|6982->4341|7163->4494|7192->4495|7306->4580|7336->4581|7689->4906|7718->4907|7811->4971|7841->4972|8194->5296|8224->5297|8312->5357|8341->5358|8394->5382|8424->5383|8526->5457|8555->5458|8631->5505|8661->5506|8715->5523|8736->5534|8811->5586|8845->5592|8874->5593|8909->5599|8939->5600|8993->5617|9014->5628|9086->5677|9120->5683|9149->5684|9246->5752|9276->5753|9431->5878|9462->5879|9508->5895|9539->5896|9590->5918|9620->5919|9734->6004|9764->6005|10028->6241|10057->6242|10090->6247|10119->6248|10154->6254|10184->6255|10243->6286|10272->6287|10358->6345|10387->6346|10420->6351|10449->6352|10544->6418|10574->6419|10737->6553|10767->6554|10949->6707|10979->6708|11031->6732|11060->6733|11097->6742|11126->6743|11161->6749|11191->6750|11245->6767|11266->6778|11339->6828|11386->6846|11416->6847|11451->6853|11481->6854|11526->6870|11556->6871|11614->6900|11644->6901|11771->7000|11800->7001|11835->7007|11865->7008|11926->7041|11955->7042|12055->7113|12085->7114|12139->7140|12168->7141|12207->7152|12236->7153|12270->7159|12299->7160|12332->7165|12361->7166|12396->7173|12425->7174
                    LINES: 26->1|31->4|31->4|32->1|33->4|39->10|39->10|39->10|44->15|44->15|44->15|49->20|49->20|49->20|58->29|58->29|58->29|58->29|58->29|58->29|58->29|59->30|59->30|60->31|60->31|66->37|66->37|66->37|75->46|75->46|75->46|75->46|76->47|76->47|76->47|77->48|80->51|80->51|80->51|81->52|81->52|81->52|88->59|88->59|88->59|89->60|89->60|89->60|95->66|95->66|95->66|100->71|100->71|100->71|113->84|122->93|122->93|127->98|127->98|142->113|142->113|149->120|149->120|155->126|155->126|157->128|157->128|158->129|158->129|161->132|161->132|165->136|165->136|170->141|170->141|178->149|178->149|180->151|180->151|189->160|189->160|192->163|192->163|192->163|192->163|195->166|195->166|197->168|197->168|198->169|198->169|198->169|199->170|199->170|199->170|199->170|200->171|200->171|200->171|201->172|201->172|204->175|204->175|204->175|204->175|204->175|204->175|205->176|205->176|207->178|207->178|212->183|212->183|213->184|213->184|213->184|213->184|215->186|215->186|218->189|218->189|219->190|219->190|221->192|221->192|226->197|226->197|230->201|230->201|232->203|232->203|234->205|234->205|234->205|234->205|235->206|235->206|235->206|236->207|236->207|236->207|236->207|236->207|236->207|238->209|238->209|241->212|241->212|241->212|241->212|243->214|243->214|245->216|245->216|247->218|247->218|249->220|249->220|250->221|250->221|252->223|252->223|254->225|254->225
                    -- GENERATED --
                */
            