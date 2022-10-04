
package views.html.rrhh.agenteAsistencia

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
object editarAgenteAsistencia extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Agente,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(agente:Agente):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

def /*5.2*/scripts/*5.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*5.13*/("""
	<script src=""""),_display_(Seq[Any](/*6.16*/routes/*6.22*/.Assets.at("javascripts/rrhh/agentes.js"))),format.raw/*6.63*/("""" type="text/javascript"></script>
""")))};implicit def /*8.2*/implicitFieldConstructor/*8.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.17*/("""
"""),format.raw/*7.2*/("""
"""),format.raw/*8.70*/(""" 

"""),_display_(Seq[Any](/*10.2*/views/*10.7*/.html.rrhh.mainRrhh("Editar Asistencias Agentes",scripts)/*10.64*/ {_display_(Seq[Any](format.raw/*10.66*/("""

<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Editar Asistencias Agentes</h1>
			</div>

			<div class="col-sm-5">
				<div class="dropdown pull-right">
				 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 	<i class="glyphicon glyphicon-list-alt"></i>
				    Reportes
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				  	<li><a id="reporteLicencia" href="#" data-url=""""),_display_(Seq[Any](/*26.56*/controllers/*26.67*/.rrhh.routes.AgentesAsistenciasReportesController.reporteLicencia())),format.raw/*26.134*/("""">Ficha Licencia</a></li>
				  	<li><a id="reporteLicenciaMedica" href="#" data-url=""""),_display_(Seq[Any](/*27.62*/controllers/*27.73*/.rrhh.routes.AgentesAsistenciasReportesController.reporteLicenciaMedicinaLaboral())),format.raw/*27.155*/("""">Ficha Licencia Medicina Laboral</a></li>
				  </ul>
				</div>
				<div class="dropdown pull-right btn-header">
					<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown"> <i class="glyphicon glyphicon-cog"></i> Acciones <span class="caret"></span> </button>
					<ul class="dropdown-menu">
						"""),_display_(Seq[Any](/*33.8*/if(Permiso.check("agentesLicenciasPasarBorrador"))/*33.58*/ {_display_(Seq[Any](format.raw/*33.60*/("""    
					    	<li role="presentation"><a role="menuitem" id="accionLicenciaPasarBorrador" tabindex="-1" href="#" data-url=""""),_display_(Seq[Any](/*34.121*/controllers/*34.132*/.rrhh.routes.AgentesAsistenciasLicenciasController.modalPasarBorrador())),format.raw/*34.203*/("""">Pasar a Borrador</a></li>
						""")))})),format.raw/*35.8*/("""  
						"""),_display_(Seq[Any](/*36.8*/if(Permiso.check("agentesLicenciasPasarAprobado"))/*36.58*/ {_display_(Seq[Any](format.raw/*36.60*/("""    
							<li role="presentation"><a role="menuitem" id="accionLicenciaPasarPreAprobado" tabindex="-1" href="#" data-url=""""),_display_(Seq[Any](/*37.121*/controllers/*37.132*/.rrhh.routes.AgentesAsistenciasLicenciasController.modalPasarPreAprobado())),format.raw/*37.206*/("""">Pasar a PreAprobado</a></li>
							<li role="presentation"><a role="menuitem" id="accionLicenciaPasarAprobado" tabindex="-1" href="#" data-url=""""),_display_(Seq[Any](/*38.118*/controllers/*38.129*/.rrhh.routes.AgentesAsistenciasLicenciasController.modalPasarAprobado())),format.raw/*38.200*/("""">Pasar a Aprobado</a></li>
						""")))})),format.raw/*39.8*/("""  
						"""),_display_(Seq[Any](/*40.8*/if(Permiso.check("agentesLicenciasPasarCancelado"))/*40.59*/ {_display_(Seq[Any](format.raw/*40.61*/("""    
					    	<li role="presentation"><a role="menuitem" id="accionLicenciaPasarCancelado" tabindex="-1" href="#" data-url=""""),_display_(Seq[Any](/*41.122*/controllers/*41.133*/.rrhh.routes.AgentesAsistenciasLicenciasController.modalPasarCancelado())),format.raw/*41.205*/("""">Pasar a Cancelado</a></li>
						""")))})),format.raw/*42.8*/("""  												  									 																							
					</ul>
				</div>	
			</div>
			
			
		</div>
	</div>
	<div class="row menu-acciones">
		<div class="col-sm-9">
		</div>	
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*54.14*/UriTrack/*54.22*/.getOnNull(controllers.rrhh.routes.AgentesAsistenciasController.index().absoluteURL()))),format.raw/*54.108*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
		</div>
	</div>
</hr>

<h2>"""),_display_(Seq[Any](/*59.6*/agente/*59.12*/.apellido)),format.raw/*59.21*/(""" - Fecha Ingreso """),_display_(Seq[Any](/*59.39*/DateUtils/*59.48*/.formatDate(agente.fingreso,"dd/MM/yyyy"))),format.raw/*59.89*/("""</h2>

<input type="hidden" value=""""),_display_(Seq[Any](/*61.30*/agente/*61.36*/.id)),format.raw/*61.39*/("""" id="agenteId"/>
"""),_display_(Seq[Any](/*62.2*/views/*62.7*/.html.rrhh.agenteAsistencia.tabsAgenteAsistencia(agente,true,0))),format.raw/*62.70*/("""

<script>
$( function()"""),format.raw/*65.14*/("""{"""),format.raw/*65.15*/("""
	/**
	 * Ventana de carga linea de productos en ordenes
	 */
	 
	var contenedor = $("#contenedorInasistencia");

	contenedor.on('click', '#nuevoAgenteAsistenciaLicencia', function()"""),format.raw/*72.69*/("""{"""),format.raw/*72.70*/("""
		urlContenidoModal = '/rrhh/agente-asistencia-licencia/crear?agenteId='+$('#agenteId').val();
		mostrarModal(urlContenidoModal);
		return false;
	"""),format.raw/*76.2*/("""}"""),format.raw/*76.3*/(""");
	
	contenedor.on('click', '.modificarAgenteAsistenciaLicencia', function()"""),format.raw/*78.73*/("""{"""),format.raw/*78.74*/("""
		lineaParaEditar = $(this).closest('tr');
		var modal = mostrarModal($(this).attr('href'));
		modal.dialog('option', 'title', 'Editar Licencia');	
		return false;
	"""),format.raw/*83.2*/("""}"""),format.raw/*83.3*/(""");
	
	contenedor.on('click', '.eliminarAgenteAsistenciaLicencia', function()"""),format.raw/*85.72*/("""{"""),format.raw/*85.73*/("""
		var mensaje = "¿Confirma que desea eliminar el registro?";
		if(confirm(mensaje))"""),format.raw/*87.23*/("""{"""),format.raw/*87.24*/("""
			var url = $(this).attr('href');
			$this = $(this);
			$.get(url, function(data)"""),format.raw/*90.29*/("""{"""),format.raw/*90.30*/("""
				if(data.success)"""),format.raw/*91.21*/("""{"""),format.raw/*91.22*/("""
					$this.closest("tr").remove();
				"""),format.raw/*93.5*/("""}"""),format.raw/*93.6*/(""" else """),format.raw/*93.12*/("""{"""),format.raw/*93.13*/("""
					alert("No se puedo eliminar el registro.");
				"""),format.raw/*95.5*/("""}"""),format.raw/*95.6*/("""
			"""),format.raw/*96.4*/("""}"""),format.raw/*96.5*/(""");
		"""),format.raw/*97.3*/("""}"""),format.raw/*97.4*/("""
		return false;
	"""),format.raw/*99.2*/("""}"""),format.raw/*99.3*/(""");
	
	function mostrarModal(url)"""),format.raw/*101.28*/("""{"""),format.raw/*101.29*/("""
		modalCargaLicencias = $('<div></div>').dialog("""),format.raw/*102.49*/("""{"""),format.raw/*102.50*/("""
			resizable: false,
		    title: "Cargar Licencia",
		    height: 400,
		    width: 750,
		    modal: true,
		    open: function( event, ui ) """),format.raw/*108.35*/("""{"""),format.raw/*108.36*/("""
				$.get(url, function(data)"""),format.raw/*109.30*/("""{"""),format.raw/*109.31*/("""
					modalCargaLicencias.html(data);
				"""),format.raw/*111.5*/("""}"""),format.raw/*111.6*/(""");
		    """),format.raw/*112.7*/("""}"""),format.raw/*112.8*/(""",
		    close: function(event, ui )"""),format.raw/*113.34*/("""{"""),format.raw/*113.35*/("""
		    	modalCargaLicencias.dialog('destroy');
			"""),format.raw/*115.4*/("""}"""),format.raw/*115.5*/("""
		  """),format.raw/*116.5*/("""}"""),format.raw/*116.6*/(""");
		
		
		modalCargaLicencias.on('click', '.cancelar', function()"""),format.raw/*119.58*/("""{"""),format.raw/*119.59*/("""
			modalCargaLicencias.dialog('destroy');
			return false;
		"""),format.raw/*122.3*/("""}"""),format.raw/*122.4*/(""");
		
		modalCargaLicencias.on('submit', function(e)"""),format.raw/*124.47*/("""{"""),format.raw/*124.48*/("""
			var href = $(e.target).attr('action');
			var data = $(e.target).serialize();
			$("#btn-guardar-asistencia").attr("disabled", true);
			$.post(href, data, function(resultado)"""),format.raw/*128.42*/("""{"""),format.raw/*128.43*/("""
				if(resultado.success && resultado.nuevo)"""),format.raw/*129.45*/("""{"""),format.raw/*129.46*/("""
					$('#listaDeAgenteAsistenciaLicencias tbody').prepend(resultado.html);
					modalCargaLicencias.dialog( "destroy" );
				"""),format.raw/*132.5*/("""}"""),format.raw/*132.6*/(""" else if(resultado.success && resultado.modificar)"""),format.raw/*132.56*/("""{"""),format.raw/*132.57*/("""
					$(lineaParaEditar).replaceWith(resultado.html);
					modalCargaLicencias.dialog( "destroy" );
				"""),format.raw/*135.5*/("""}"""),format.raw/*135.6*/(""" else """),format.raw/*135.12*/("""{"""),format.raw/*135.13*/("""
					modalCargaLicencias.html(resultado);
				"""),format.raw/*137.5*/("""}"""),format.raw/*137.6*/("""
				$("#btn-guardar-asistencia").attr("disabled", false);
			"""),format.raw/*139.4*/("""}"""),format.raw/*139.5*/(""");
			return false;
		"""),format.raw/*141.3*/("""}"""),format.raw/*141.4*/(""");
		
		
		return modalCargaLicencias;
	"""),format.raw/*145.2*/("""}"""),format.raw/*145.3*/("""
	
	
	contenedor.find('form').on('submit', function()"""),format.raw/*148.49*/("""{"""),format.raw/*148.50*/("""
		var url = $(this).attr("action");
		var query = $(this).serialize();
		$.get(url+"?"+query, function(data)"""),format.raw/*151.38*/("""{"""),format.raw/*151.39*/("""
			contenedor.parent().html(data);
		"""),format.raw/*153.3*/("""}"""),format.raw/*153.4*/(""");
		return false;
	"""),format.raw/*155.2*/("""}"""),format.raw/*155.3*/(""");
"""),format.raw/*156.1*/("""}"""),format.raw/*156.2*/(""");
</script>

""")))})))}
    }
    
    def render(agente:Agente): play.api.templates.HtmlFormat.Appendable = apply(agente)
    
    def f:((Agente) => play.api.templates.HtmlFormat.Appendable) = (agente) => apply(agente)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:30 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agenteAsistencia/editarAgenteAsistencia.scala.html
                    HASH: 35a9b929fc7d20f6095f556bdf1be08075001a27
                    MATRIX: 813->1|959->73|973->80|1057->84|1108->100|1122->106|1184->147|1251->185|1283->209|1357->16|1384->183|1412->253|1451->257|1464->262|1530->319|1570->321|2157->872|2177->883|2267->950|2390->1037|2410->1048|2515->1130|2901->1481|2960->1531|3000->1533|3162->1658|3183->1669|3277->1740|3343->1775|3388->1785|3447->1835|3487->1837|3649->1962|3670->1973|3767->2047|3952->2195|3973->2206|4067->2277|4133->2312|4178->2322|4238->2373|4278->2375|4441->2501|4462->2512|4557->2584|4624->2620|4874->2834|4891->2842|5000->2928|5136->3029|5151->3035|5182->3044|5236->3062|5254->3071|5317->3112|5389->3148|5404->3154|5429->3157|5483->3176|5496->3181|5581->3244|5633->3268|5662->3269|5872->3451|5901->3452|6076->3600|6104->3601|6209->3678|6238->3679|6431->3845|6459->3846|6563->3922|6592->3923|6704->4007|6733->4008|6845->4092|6874->4093|6923->4114|6952->4115|7019->4155|7047->4156|7081->4162|7110->4163|7191->4217|7219->4218|7250->4222|7278->4223|7310->4228|7338->4229|7383->4247|7411->4248|7472->4280|7502->4281|7580->4330|7610->4331|7783->4475|7813->4476|7872->4506|7902->4507|7972->4549|8001->4550|8038->4559|8067->4560|8131->4595|8161->4596|8239->4646|8268->4647|8301->4652|8330->4653|8425->4719|8455->4720|8545->4782|8574->4783|8655->4835|8685->4836|8893->5015|8923->5016|8997->5061|9027->5062|9181->5188|9210->5189|9289->5239|9319->5240|9451->5344|9480->5345|9515->5351|9545->5352|9620->5399|9649->5400|9739->5462|9768->5463|9818->5485|9847->5486|9915->5526|9944->5527|10026->5580|10056->5581|10194->5690|10224->5691|10290->5729|10319->5730|10367->5750|10396->5751|10427->5754|10456->5755
                    LINES: 26->1|33->5|33->5|35->5|36->6|36->6|36->6|37->8|37->8|38->1|39->7|40->8|42->10|42->10|42->10|42->10|58->26|58->26|58->26|59->27|59->27|59->27|65->33|65->33|65->33|66->34|66->34|66->34|67->35|68->36|68->36|68->36|69->37|69->37|69->37|70->38|70->38|70->38|71->39|72->40|72->40|72->40|73->41|73->41|73->41|74->42|86->54|86->54|86->54|91->59|91->59|91->59|91->59|91->59|91->59|93->61|93->61|93->61|94->62|94->62|94->62|97->65|97->65|104->72|104->72|108->76|108->76|110->78|110->78|115->83|115->83|117->85|117->85|119->87|119->87|122->90|122->90|123->91|123->91|125->93|125->93|125->93|125->93|127->95|127->95|128->96|128->96|129->97|129->97|131->99|131->99|133->101|133->101|134->102|134->102|140->108|140->108|141->109|141->109|143->111|143->111|144->112|144->112|145->113|145->113|147->115|147->115|148->116|148->116|151->119|151->119|154->122|154->122|156->124|156->124|160->128|160->128|161->129|161->129|164->132|164->132|164->132|164->132|167->135|167->135|167->135|167->135|169->137|169->137|171->139|171->139|173->141|173->141|177->145|177->145|180->148|180->148|183->151|183->151|185->153|185->153|187->155|187->155|188->156|188->156
                    -- GENERATED --
                */
            