
package views.html.compras.ordenes.modales

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
object modalEditarCuentaAnalitica extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[DynamicForm,String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm , tipo:String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.43*/("""
"""),format.raw/*3.70*/(""" 

<div id="modalEditarCuentaAnalitica" class="contenedorPaginador ajaxPaginador">
 	<input type="hidden" name="tipo" id="tipo" value=""""),_display_(Seq[Any](/*6.54*/tipo)),format.raw/*6.58*/("""">
	<div class="row margin-bottom-10">
		<div class="col-sm-8 col-sm-offset-2">
			<div class="input-group">
				"""),_display_(Seq[Any](/*10.6*/inputText(formBuscador("cuentaAnalitica_id"), 'hidden -> "hidden", 'id -> "cuentaAnalitica_id"))),format.raw/*10.101*/("""
				"""),_display_(Seq[Any](/*11.6*/inputText(formBuscador("cuentaAnalitica"), 'class -> "form-control", 'id -> "cuentaAnalitica"))),format.raw/*11.100*/("""
				<span class="input-group-addon">
					<a href="#" 
					   id="searchCuentaAnalitica" 
					   class="searchModal"
					   data-title="Selección de Cuenta Analitica" 
					   data-url=""""),_display_(Seq[Any](/*17.20*/controllers/*17.31*/.contabilidad.routes.CuentasAnaliticasController.modalBuscar())),format.raw/*17.93*/("""" 
					   data-height="650" 
					   data-width="700" 
					   data-listen="modal.seleccion.cuentaAnalitica.simple" 
					   data-label="#cuentaAnalitica" data-field="#cuentaAnalitica_id">
					   <i class="glyphicon glyphicon-search"></i>
					 </a>
				</span>
			</div>
		</div>		
		
	</div>
	
	<div class="row margin-bottom-10">	
		<div class="col-sm-5 col-sm-offset-4">
			<div class="input-group pull-center">
				<label>
					<button class="btn btn-default form-control" id="cerrarEditarCuentaAnaliticaOrden">
						<i class="glyphicon glyphicon-minus-sign"></i>
						Cerrar
					</button>
				</label>
				<label>
					<button class="btn btn-default form-control" id="editarCuentaAnaliticaOrden">
						<i class="glyphicon glyphicon-ok"></i>
						Editar
					</button>
				</label>
			</div>	
		</div>
	</div>		
	<div class="row">	
		<div class="col-sm-12" id="responseEditarCuenta">
			
		</div>
	</div>	 
</div>

<script>
$( function()"""),format.raw/*56.14*/("""{"""),format.raw/*56.15*/("""
	 
	$('#editarCuentaAnaliticaOrden').click( function()"""),format.raw/*58.52*/("""{"""),format.raw/*58.53*/("""editarCuentaAnaliticaOrden()"""),format.raw/*58.81*/("""}"""),format.raw/*58.82*/(""");
	$('#cerrarEditarCuentaAnaliticaOrden').click( function()"""),format.raw/*59.58*/("""{"""),format.raw/*59.59*/("""cerrarEditarCuentaAnaliticaOrden()"""),format.raw/*59.93*/("""}"""),format.raw/*59.94*/(""");
	if($("#cuentaAnalitica").length)"""),format.raw/*60.34*/("""{"""),format.raw/*60.35*/("""
		 
		var options = """),format.raw/*62.17*/("""{"""),format.raw/*62.18*/("""
				script:"/contabilidad/suggestCuentaAnalitica/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*68.30*/("""{"""),format.raw/*68.31*/(""" 
											$("#cuentaAnalitica_id").val(obj.id); 
										 """),format.raw/*70.12*/("""}"""),format.raw/*70.13*/("""
			"""),format.raw/*71.4*/("""}"""),format.raw/*71.5*/(""";
		var as_json = new bsn.AutoSuggest('cuentaAnalitica', options);
	"""),format.raw/*73.2*/("""}"""),format.raw/*73.3*/(""" 
	
	$('#searchCuentaAnalitica').modalSearch();
"""),format.raw/*76.1*/("""}"""),format.raw/*76.2*/(""");

function cerrarEditarCuentaAnaliticaOrden()"""),format.raw/*78.44*/("""{"""),format.raw/*78.45*/("""
	$("#modalEditarCuentaAnalitica").dialog("destroy");
"""),format.raw/*80.1*/("""}"""),format.raw/*80.2*/("""

function editarCuentaAnaliticaOrden()"""),format.raw/*82.38*/("""{"""),format.raw/*82.39*/("""
	
	
	if($("#tipo").val() != "")"""),format.raw/*85.28*/("""{"""),format.raw/*85.29*/("""
	
		if($("#cuentaAnalitica_id").val() != "" && $("#cuentaAnalitica").val() != "")"""),format.raw/*87.80*/("""{"""),format.raw/*87.81*/("""
			if($("input[name='check_listado[]']").length > 0)"""),format.raw/*88.53*/("""{"""),format.raw/*88.54*/("""
				
					data = $("input[name='check_listado[]']").serialize();
					
			"""),format.raw/*92.4*/("""}"""),format.raw/*92.5*/("""else"""),format.raw/*92.9*/("""{"""),format.raw/*92.10*/("""
				if($("#tipo").val() != "editar")"""),format.raw/*93.37*/("""{"""),format.raw/*93.38*/("""
					s = '- Debe seleccionar una orden.';
				"""),format.raw/*95.5*/("""}"""),format.raw/*95.6*/("""else"""),format.raw/*95.10*/("""{"""),format.raw/*95.11*/("""
					s = '- Debe seleccionar una linea.';
				"""),format.raw/*97.5*/("""}"""),format.raw/*97.6*/("""
				
				r = '<p class="responseError">'+s+'</p>'
				$("#responseEditarCuenta").html(r);
			"""),format.raw/*101.4*/("""}"""),format.raw/*101.5*/("""
			
			data += "&"+$("#cuentaAnalitica_id").serialize();
			data += "&"+$("#tipo").serialize();
			
			$.ajax("""),format.raw/*106.11*/("""{"""),format.raw/*106.12*/("""
		        url: "/compras/orden/editarCuentaAnalitica",
		        type: "post",
		        data: data,
		        success: function(r)"""),format.raw/*110.31*/("""{"""),format.raw/*110.32*/("""
		        	$("#responseEditarCuenta").html(r);
		        	if($(".cuentaAnaliticaEnLinea").length > 0)"""),format.raw/*112.55*/("""{"""),format.raw/*112.56*/("""
		        		if($("#tipo").val() != "editar")"""),format.raw/*113.45*/("""{"""),format.raw/*113.46*/("""
		        			$(".cuentaAnaliticaEnLinea").html($("#cuentaAnalitica").val());
		        		"""),format.raw/*115.13*/("""}"""),format.raw/*115.14*/("""else"""),format.raw/*115.18*/("""{"""),format.raw/*115.19*/("""
		        			$('#listaDeProductos tr:has(input:checked) .cuentaAnaliticaEnLinea').html($("#cuentaAnalitica").val())
		        		"""),format.raw/*117.13*/("""}"""),format.raw/*117.14*/("""
		        	"""),format.raw/*118.12*/("""}"""),format.raw/*118.13*/("""
		        	
		        """),format.raw/*120.11*/("""}"""),format.raw/*120.12*/(""",
		        error:function()"""),format.raw/*121.27*/("""{"""),format.raw/*121.28*/("""
		        
		        """),format.raw/*123.11*/("""}"""),format.raw/*123.12*/("""
		    """),format.raw/*124.7*/("""}"""),format.raw/*124.8*/(""");
			
		"""),format.raw/*126.3*/("""}"""),format.raw/*126.4*/("""else"""),format.raw/*126.8*/("""{"""),format.raw/*126.9*/("""
			r = '<p class="responseError">- Debe seleccionar una cuenta.</p>'
			$("#responseEditarCuenta").html(r);
		"""),format.raw/*129.3*/("""}"""),format.raw/*129.4*/("""
	"""),format.raw/*130.2*/("""}"""),format.raw/*130.3*/("""else"""),format.raw/*130.7*/("""{"""),format.raw/*130.8*/("""	
		r = '<p class="responseError">- No se pudo seleccionar un tipo de operacion.</p>'
			$("#responseEditarCuenta").html(r);
	"""),format.raw/*133.2*/("""}"""),format.raw/*133.3*/("""	
	
"""),format.raw/*135.1*/("""}"""),format.raw/*135.2*/("""
</script>"""))}
    }
    
    def render(formBuscador:DynamicForm,tipo:String): play.api.templates.HtmlFormat.Appendable = apply(formBuscador,tipo)
    
    def f:((DynamicForm,String) => play.api.templates.HtmlFormat.Appendable) = (formBuscador,tipo) => apply(formBuscador,tipo)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:44 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/ordenes/modales/modalEditarCuentaAnalitica.scala.html
                    HASH: 364f2f6e1c15b17809660d9701f06feced433176
                    MATRIX: 831->1|974->61|1006->85|1080->42|1108->129|1279->265|1304->269|1453->383|1571->478|1612->484|1729->578|1956->769|1976->780|2060->842|3036->1790|3065->1791|3148->1846|3177->1847|3233->1875|3262->1876|3350->1936|3379->1937|3441->1971|3470->1972|3534->2008|3563->2009|3612->2030|3641->2031|3824->2186|3853->2187|3944->2250|3973->2251|4004->2255|4032->2256|4127->2324|4155->2325|4230->2373|4258->2374|4333->2421|4362->2422|4443->2476|4471->2477|4538->2516|4567->2517|4627->2549|4656->2550|4766->2632|4795->2633|4876->2686|4905->2687|5007->2762|5035->2763|5066->2767|5095->2768|5160->2805|5189->2806|5263->2853|5291->2854|5323->2858|5352->2859|5426->2906|5454->2907|5576->3001|5605->3002|5745->3113|5775->3114|5936->3246|5966->3247|6097->3349|6127->3350|6201->3395|6231->3396|6350->3486|6380->3487|6413->3491|6443->3492|6601->3621|6631->3622|6672->3634|6702->3635|6754->3658|6784->3659|6841->3687|6871->3688|6922->3710|6952->3711|6987->3718|7016->3719|7053->3728|7082->3729|7114->3733|7143->3734|7282->3845|7311->3846|7341->3848|7370->3849|7402->3853|7431->3854|7585->3980|7614->3981|7646->3985|7675->3986
                    LINES: 26->1|29->3|29->3|30->1|31->3|34->6|34->6|38->10|38->10|39->11|39->11|45->17|45->17|45->17|84->56|84->56|86->58|86->58|86->58|86->58|87->59|87->59|87->59|87->59|88->60|88->60|90->62|90->62|96->68|96->68|98->70|98->70|99->71|99->71|101->73|101->73|104->76|104->76|106->78|106->78|108->80|108->80|110->82|110->82|113->85|113->85|115->87|115->87|116->88|116->88|120->92|120->92|120->92|120->92|121->93|121->93|123->95|123->95|123->95|123->95|125->97|125->97|129->101|129->101|134->106|134->106|138->110|138->110|140->112|140->112|141->113|141->113|143->115|143->115|143->115|143->115|145->117|145->117|146->118|146->118|148->120|148->120|149->121|149->121|151->123|151->123|152->124|152->124|154->126|154->126|154->126|154->126|157->129|157->129|158->130|158->130|158->130|158->130|161->133|161->133|163->135|163->135
                    -- GENERATED --
                */
            