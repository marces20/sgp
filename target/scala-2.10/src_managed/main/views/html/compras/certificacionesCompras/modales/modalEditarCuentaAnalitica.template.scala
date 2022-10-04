
package views.html.compras.certificacionesCompras.modales

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
object modalEditarCuentaAnalitica extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.29*/("""
"""),format.raw/*3.70*/(""" 

<div id="modalEditarCuentaAnalitica" class="contenedorPaginador ajaxPaginador">
 
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
					<button class="btn btn-default form-control" id="cerrarEditarCuentaAnaliticaCertificacion">
						<i class="glyphicon glyphicon-minus-sign"></i>
						Cerrar
					</button>
				</label>
				<label>
					<button class="btn btn-default form-control" id="editarCuentaAnaliticaCertificacion">
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
	 
	$('#editarCuentaAnaliticaCertificacion').click( function()"""),format.raw/*58.60*/("""{"""),format.raw/*58.61*/("""editarCuentaAnaliticaCertificacion()"""),format.raw/*58.97*/("""}"""),format.raw/*58.98*/(""");
	$('#cerrarEditarCuentaAnaliticaCertificacion').click( function()"""),format.raw/*59.66*/("""{"""),format.raw/*59.67*/("""cerrarEditarCuentaAnaliticaCertificacion()"""),format.raw/*59.109*/("""}"""),format.raw/*59.110*/(""");
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

function cerrarEditarCuentaAnaliticaCertificacion()"""),format.raw/*78.52*/("""{"""),format.raw/*78.53*/("""
	$("#modalEditarCuentaAnalitica").dialog("destroy");
"""),format.raw/*80.1*/("""}"""),format.raw/*80.2*/("""

function editarCuentaAnaliticaCertificacion()"""),format.raw/*82.46*/("""{"""),format.raw/*82.47*/("""
	
	if($("#cuentaAnalitica_id").val() != "" && $("#cuentaAnalitica").val() != "")"""),format.raw/*84.79*/("""{"""),format.raw/*84.80*/("""
		if($("input[name='check_listado[]']").length > 0)"""),format.raw/*85.52*/("""{"""),format.raw/*85.53*/("""
			
				data = $("input[name='check_listado[]']").serialize();
				
		"""),format.raw/*89.3*/("""}"""),format.raw/*89.4*/("""else"""),format.raw/*89.8*/("""{"""),format.raw/*89.9*/("""
			if($("#certificacionId").length > 0)"""),format.raw/*90.40*/("""{"""),format.raw/*90.41*/("""
				data = $("#certificacionId").serialize();
			"""),format.raw/*92.4*/("""}"""),format.raw/*92.5*/("""else"""),format.raw/*92.9*/("""{"""),format.raw/*92.10*/("""
				r = '<p class="responseError">- Debe seleccionar una Certificacion.</p>'
					$("#responseEditarCuenta").html(r);
			"""),format.raw/*95.4*/("""}"""),format.raw/*95.5*/("""
		"""),format.raw/*96.3*/("""}"""),format.raw/*96.4*/("""
		
		data += "&"+$("#cuentaAnalitica_id").serialize();
		
		$.ajax("""),format.raw/*100.10*/("""{"""),format.raw/*100.11*/("""
	        url: "/compras/certificacion-compra/editarCuentaAnalitica",
	        type: "post",
	        data: data,
	        success: function(r)"""),format.raw/*104.30*/("""{"""),format.raw/*104.31*/("""
	        	$("#responseEditarCuenta").html(r);
	        	if($(".cuentaAnaliticaEnLinea").length > 0)"""),format.raw/*106.54*/("""{"""),format.raw/*106.55*/("""
	        		$(".cuentaAnaliticaEnLinea").html($("#cuentaAnalitica").val());
	        	"""),format.raw/*108.11*/("""}"""),format.raw/*108.12*/("""
	        	
	        """),format.raw/*110.10*/("""}"""),format.raw/*110.11*/(""",
	        error:function()"""),format.raw/*111.26*/("""{"""),format.raw/*111.27*/("""
	        
	        """),format.raw/*113.10*/("""}"""),format.raw/*113.11*/("""
	    """),format.raw/*114.6*/("""}"""),format.raw/*114.7*/(""");
		
	"""),format.raw/*116.2*/("""}"""),format.raw/*116.3*/("""else"""),format.raw/*116.7*/("""{"""),format.raw/*116.8*/("""
		r = '<p class="responseError">- Debe seleccionar una cuenta.</p>'
		$("#responseEditarCuenta").html(r);
	"""),format.raw/*119.2*/("""}"""),format.raw/*119.3*/("""
"""),format.raw/*120.1*/("""}"""),format.raw/*120.2*/("""
</script>"""))}
    }
    
    def render(formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(formBuscador)
    
    def f:((DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (formBuscador) => apply(formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:44 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/certificacionesCompras/modales/modalEditarCuentaAnalitica.scala.html
                    HASH: 5435400ade50d7e6e39e918270510002aa7efd5e
                    MATRIX: 839->1|968->47|1000->71|1074->28|1102->115|1333->311|1451->406|1492->412|1609->506|1836->697|1856->708|1940->770|2932->1734|2961->1735|3052->1798|3081->1799|3145->1835|3174->1836|3270->1904|3299->1905|3370->1947|3400->1948|3464->1984|3493->1985|3542->2006|3571->2007|3754->2162|3783->2163|3874->2226|3903->2227|3934->2231|3962->2232|4057->2300|4085->2301|4160->2349|4188->2350|4271->2405|4300->2406|4381->2460|4409->2461|4484->2508|4513->2509|4622->2590|4651->2591|4731->2643|4760->2644|4858->2715|4886->2716|4917->2720|4945->2721|5013->2761|5042->2762|5119->2812|5147->2813|5178->2817|5207->2818|5356->2940|5384->2941|5414->2944|5442->2945|5539->3013|5569->3014|5741->3157|5771->3158|5900->3258|5930->3259|6045->3345|6075->3346|6125->3367|6155->3368|6211->3395|6241->3396|6290->3416|6320->3417|6354->3423|6383->3424|6418->3431|6447->3432|6479->3436|6508->3437|6644->3545|6673->3546|6702->3547|6731->3548
                    LINES: 26->1|29->3|29->3|30->1|31->3|38->10|38->10|39->11|39->11|45->17|45->17|45->17|84->56|84->56|86->58|86->58|86->58|86->58|87->59|87->59|87->59|87->59|88->60|88->60|90->62|90->62|96->68|96->68|98->70|98->70|99->71|99->71|101->73|101->73|104->76|104->76|106->78|106->78|108->80|108->80|110->82|110->82|112->84|112->84|113->85|113->85|117->89|117->89|117->89|117->89|118->90|118->90|120->92|120->92|120->92|120->92|123->95|123->95|124->96|124->96|128->100|128->100|132->104|132->104|134->106|134->106|136->108|136->108|138->110|138->110|139->111|139->111|141->113|141->113|142->114|142->114|144->116|144->116|144->116|144->116|147->119|147->119|148->120|148->120
                    -- GENERATED --
                */
            