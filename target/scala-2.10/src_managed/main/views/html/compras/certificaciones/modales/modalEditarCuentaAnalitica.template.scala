
package views.html.compras.certificaciones.modales

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
	        url: "/compras/certificacion/editarCuentaAnalitica",
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
                    DATE: Tue Oct 04 11:43:43 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/certificaciones/modales/modalEditarCuentaAnalitica.scala.html
                    HASH: 1000893be4b64ec04f52bf2206ec72bb9e603e84
                    MATRIX: 832->1|961->47|993->71|1067->28|1095->115|1326->311|1444->406|1485->412|1602->506|1829->697|1849->708|1933->770|2925->1734|2954->1735|3045->1798|3074->1799|3138->1835|3167->1836|3263->1904|3292->1905|3363->1947|3393->1948|3457->1984|3486->1985|3535->2006|3564->2007|3747->2162|3776->2163|3867->2226|3896->2227|3927->2231|3955->2232|4050->2300|4078->2301|4153->2349|4181->2350|4264->2405|4293->2406|4374->2460|4402->2461|4477->2508|4506->2509|4615->2590|4644->2591|4724->2643|4753->2644|4851->2715|4879->2716|4910->2720|4938->2721|5006->2761|5035->2762|5112->2812|5140->2813|5171->2817|5200->2818|5349->2940|5377->2941|5407->2944|5435->2945|5532->3013|5562->3014|5727->3150|5757->3151|5886->3251|5916->3252|6031->3338|6061->3339|6111->3360|6141->3361|6197->3388|6227->3389|6276->3409|6306->3410|6340->3416|6369->3417|6404->3424|6433->3425|6465->3429|6494->3430|6630->3538|6659->3539|6688->3540|6717->3541
                    LINES: 26->1|29->3|29->3|30->1|31->3|38->10|38->10|39->11|39->11|45->17|45->17|45->17|84->56|84->56|86->58|86->58|86->58|86->58|87->59|87->59|87->59|87->59|88->60|88->60|90->62|90->62|96->68|96->68|98->70|98->70|99->71|99->71|101->73|101->73|104->76|104->76|106->78|106->78|108->80|108->80|110->82|110->82|112->84|112->84|113->85|113->85|117->89|117->89|117->89|117->89|118->90|118->90|120->92|120->92|120->92|120->92|123->95|123->95|124->96|124->96|128->100|128->100|132->104|132->104|134->106|134->106|136->108|136->108|138->110|138->110|139->111|139->111|141->113|141->113|142->114|142->114|144->116|144->116|144->116|144->116|147->119|147->119|148->120|148->120
                    -- GENERATED --
                */
            