
package views.html.compras.solicitudes.modales

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
					   id="searchCuentaAnalitica2" 
					   class="searchModal"
					   data-title="Selección de Cuenta Analitica" 
					   data-url=""""),_display_(Seq[Any](/*17.20*/controllers/*17.31*/.contabilidad.routes.CuentasAnaliticasController.modalBuscar())),format.raw/*17.93*/("""" 
					   data-height="650" 
					   data-width="700" 
					   data-listen="modal.seleccion.cuentaAnalitica.simple" 
					   data-label="#cuentaAnalitica" 
					   data-field="#cuentaAnalitica_id">
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
					<button class="btn btn-default form-control" id="editarCuentaAnaliticaSolicitud">
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
$( function()"""),format.raw/*57.14*/("""{"""),format.raw/*57.15*/("""
	 
	$('#editarCuentaAnaliticaSolicitud').click( function()"""),format.raw/*59.56*/("""{"""),format.raw/*59.57*/("""editarCuentaAnaliticaSolicitud()"""),format.raw/*59.89*/("""}"""),format.raw/*59.90*/(""");
	$('#cerrarEditarCuentaAnaliticaOrden').click( function()"""),format.raw/*60.58*/("""{"""),format.raw/*60.59*/("""cerrarEditarCuentaAnaliticaOrden()"""),format.raw/*60.93*/("""}"""),format.raw/*60.94*/(""");
	if($("#cuentaAnalitica").length)"""),format.raw/*61.34*/("""{"""),format.raw/*61.35*/("""
		 
		var options = """),format.raw/*63.17*/("""{"""),format.raw/*63.18*/("""
				script:"/contabilidad/suggestCuentaAnalitica/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*69.30*/("""{"""),format.raw/*69.31*/(""" 
											$("#cuentaAnalitica_id").val(obj.id); 
										 """),format.raw/*71.12*/("""}"""),format.raw/*71.13*/("""
			"""),format.raw/*72.4*/("""}"""),format.raw/*72.5*/(""";
		var as_json = new bsn.AutoSuggest('cuentaAnalitica', options);
	"""),format.raw/*74.2*/("""}"""),format.raw/*74.3*/(""" 
	
	$('#searchCuentaAnalitica2').modalSearch();
"""),format.raw/*77.1*/("""}"""),format.raw/*77.2*/(""");
function cerrarEditarCuentaAnaliticaOrden()"""),format.raw/*78.44*/("""{"""),format.raw/*78.45*/("""
	$("#modalEditarCuentaAnalitica").dialog("destroy");
"""),format.raw/*80.1*/("""}"""),format.raw/*80.2*/("""
function editarCuentaAnaliticaSolicitud()"""),format.raw/*81.42*/("""{"""),format.raw/*81.43*/("""
	
	if($("#cuentaAnalitica_id").val() != "" && $("#cuentaAnalitica").val() != "")"""),format.raw/*83.79*/("""{"""),format.raw/*83.80*/("""
		/*if($("input[name='check_listado[]']").length > 0)"""),format.raw/*84.54*/("""{"""),format.raw/*84.55*/("""
			
				data = $("input[name='check_listado[]']").serialize();
				alert($("#solicitudId").val());
				alert($("#solicitudId").length);
		"""),format.raw/*89.3*/("""}"""),format.raw/*89.4*/("""else"""),format.raw/*89.8*/("""{"""),format.raw/*89.9*/("""
			alert($("#solicitudId").val());
			alert($("#solicitudId").length);
			if($("#solicitudId").length > 0)"""),format.raw/*92.36*/("""{"""),format.raw/*92.37*/("""
				data = $("#solicitudId").serialize();
			"""),format.raw/*94.4*/("""}"""),format.raw/*94.5*/("""else"""),format.raw/*94.9*/("""{"""),format.raw/*94.10*/("""
				r = '<p class="responseError">- Debe seleccionar una solicitud.</p>'
					$("#responseEditarCuenta").html(r);
			"""),format.raw/*97.4*/("""}"""),format.raw/*97.5*/("""
		"""),format.raw/*98.3*/("""}"""),format.raw/*98.4*/("""*/
		
		if($("#solicitudId").length > 0)"""),format.raw/*100.35*/("""{"""),format.raw/*100.36*/("""
			data = $("#solicitudId").serialize();
		"""),format.raw/*102.3*/("""}"""),format.raw/*102.4*/("""else"""),format.raw/*102.8*/("""{"""),format.raw/*102.9*/("""
			if($("input[name='check_listado[]']").length > 0)"""),format.raw/*103.53*/("""{"""),format.raw/*103.54*/("""
				data = $("input[name='check_listado[]']").serialize();
			"""),format.raw/*105.4*/("""}"""),format.raw/*105.5*/("""
		"""),format.raw/*106.3*/("""}"""),format.raw/*106.4*/("""	
		
		data += "&"+$("#cuentaAnalitica_id").serialize();
		
		$.ajax("""),format.raw/*110.10*/("""{"""),format.raw/*110.11*/("""
	        url: "/compras/solicitud/editarCuentaAnalitica",
	        type: "post",
	        data: data,
	        success: function(r)"""),format.raw/*114.30*/("""{"""),format.raw/*114.31*/("""
	        	$("#responseEditarCuenta").html(r);
	        	if($(".cuentaAnaliticaEnLinea").length > 0)"""),format.raw/*116.54*/("""{"""),format.raw/*116.55*/("""
	        		$(".cuentaAnaliticaEnLinea").html($("#cuentaAnalitica").val());
	        	"""),format.raw/*118.11*/("""}"""),format.raw/*118.12*/("""
	        	
	        """),format.raw/*120.10*/("""}"""),format.raw/*120.11*/(""",
	        error:function()"""),format.raw/*121.26*/("""{"""),format.raw/*121.27*/("""
	        
	        """),format.raw/*123.10*/("""}"""),format.raw/*123.11*/("""
	    """),format.raw/*124.6*/("""}"""),format.raw/*124.7*/(""");
		
	"""),format.raw/*126.2*/("""}"""),format.raw/*126.3*/("""else"""),format.raw/*126.7*/("""{"""),format.raw/*126.8*/("""
		r = '<p class="responseError">- Debe seleccionar una cuenta.</p>'
		$("#responseEditarCuenta").html(r);
	"""),format.raw/*129.2*/("""}"""),format.raw/*129.3*/("""
"""),format.raw/*130.1*/("""}"""),format.raw/*130.2*/("""
</script>"""))}
    }
    
    def render(formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(formBuscador)
    
    def f:((DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (formBuscador) => apply(formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:46 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/solicitudes/modales/modalEditarCuentaAnalitica.scala.html
                    HASH: 315d55ed63ac38245114d37cf737453cf0df7c7f
                    MATRIX: 828->1|957->47|989->71|1063->28|1091->115|1322->311|1440->406|1481->412|1598->506|1826->698|1846->709|1930->771|2919->1732|2948->1733|3035->1792|3064->1793|3124->1825|3153->1826|3241->1886|3270->1887|3332->1921|3361->1922|3425->1958|3454->1959|3503->1980|3532->1981|3715->2136|3744->2137|3835->2200|3864->2201|3895->2205|3923->2206|4018->2274|4046->2275|4122->2324|4150->2325|4224->2371|4253->2372|4334->2426|4362->2427|4432->2469|4461->2470|4570->2551|4599->2552|4681->2606|4710->2607|4876->2746|4904->2747|4935->2751|4963->2752|5098->2859|5127->2860|5200->2906|5228->2907|5259->2911|5288->2912|5433->3030|5461->3031|5491->3034|5519->3035|5588->3075|5618->3076|5690->3120|5719->3121|5751->3125|5780->3126|5862->3179|5892->3180|5983->3243|6012->3244|6043->3247|6072->3248|6170->3317|6200->3318|6361->3450|6391->3451|6520->3551|6550->3552|6665->3638|6695->3639|6745->3660|6775->3661|6831->3688|6861->3689|6910->3709|6940->3710|6974->3716|7003->3717|7038->3724|7067->3725|7099->3729|7128->3730|7264->3838|7293->3839|7322->3840|7351->3841
                    LINES: 26->1|29->3|29->3|30->1|31->3|38->10|38->10|39->11|39->11|45->17|45->17|45->17|85->57|85->57|87->59|87->59|87->59|87->59|88->60|88->60|88->60|88->60|89->61|89->61|91->63|91->63|97->69|97->69|99->71|99->71|100->72|100->72|102->74|102->74|105->77|105->77|106->78|106->78|108->80|108->80|109->81|109->81|111->83|111->83|112->84|112->84|117->89|117->89|117->89|117->89|120->92|120->92|122->94|122->94|122->94|122->94|125->97|125->97|126->98|126->98|128->100|128->100|130->102|130->102|130->102|130->102|131->103|131->103|133->105|133->105|134->106|134->106|138->110|138->110|142->114|142->114|144->116|144->116|146->118|146->118|148->120|148->120|149->121|149->121|151->123|151->123|152->124|152->124|154->126|154->126|154->126|154->126|157->129|157->129|158->130|158->130
                    -- GENERATED --
                */
            