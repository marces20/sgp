
package views.html.contabilidad.cuentaBancarias

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
object indexCuentaBancaria extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[CuentaBancaria],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[CuentaBancaria], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

def /*4.2*/scripts/*4.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*4.13*/("""
	<script src=""""),_display_(Seq[Any](/*5.16*/routes/*5.22*/.Assets.at("javascripts/contabilidad/cuentasBancarias.js"))),format.raw/*5.80*/("""" type="text/javascript"></script>
""")))};implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};def /*7.2*/getClassEstado/*7.16*/(i:Estado) = {{
	var classEstado:String = new String()
	if(i != null && i.id == 34){
		classEstado = "borrador"
	}else if(i != null && i.id == 37){
		classEstado = "cancelada"
	}else if(i != null && i.id == 36){
		classEstado = "autorizado"
	}
	classEstado
	
}};
Seq[Any](format.raw/*1.84*/("""
"""),format.raw/*3.70*/(""" 
"""),format.raw/*6.2*/("""
"""),format.raw/*18.2*/("""

"""),_display_(Seq[Any](/*20.2*/views/*20.7*/.html.contabilidad.mainContabilidad("Lista cuenta bancarias", scripts)/*20.77*/ {_display_(Seq[Any](format.raw/*20.79*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Lista de cuenta bancarias</h1>
			</div>
			<div class="col-sm-5">
				<div class="btn-group pull-right  btn-header">
					<button class="btn btn-default dropdown-toggle" type="button" id="dropdownReportes" data-toggle="dropdown">
						<i class="glyphicon glyphicon-list-alt"></i> Reportes <span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<li><a id="reporteDatosGenerales" href="#" 
						data-url=""""),_display_(Seq[Any](/*34.18*/controllers/*34.29*/.contabilidad.routes.CuentaBancariasController.reporteDatosGenerales())),format.raw/*34.99*/("""">
						Datos Generales
						</a>
						</li>
					</ul>
				</div>
				<div class="dropdown pull-right">
					<a href=""""),_display_(Seq[Any](/*41.16*/controllers/*41.27*/.contabilidad.routes.CuentaBancariasController.crearCuentaBancaria)),format.raw/*41.93*/(""""  class="form-control btn btn-default">
						<i class="glyphicon glyphicon-plus-sign"></i> Nueva cuenta bancaria
					</a>
					
				</div>
			</div>
		</div>
	</div>
	<div id="actions">
		<form action="" method="GET">
		<div class="row" >
			<div class="col-sm-10 filtrosEstados" id="filtrosEstados">
				<div class="btn-group">
				  <button type="button" rel="borrador" class="btn btn-default btn-filtros">
				  	<i class="glyphicon glyphicon-pencil size-14"></i><br>Borrador
				  	"""),_display_(Seq[Any](/*56.9*/checkbox(formBuscador("btnFiltro[0]"), 'hidden -> "hidden"))),format.raw/*56.68*/("""
				  </button>
				  <button type="button" rel="imputado" class="btn btn-default btn-filtros">
				  	<i class="glyphicon glyphicon-arrow-right"></i><br>En curso
				  	"""),_display_(Seq[Any](/*60.9*/checkbox(formBuscador("btnFiltro[1]"), 'hidden -> "hidden"))),format.raw/*60.68*/("""
				  </button>
				  <button type="button" rel="abierta" class="btn btn-default btn-filtros">
				  	<i class="glyphicon glyphicon-arrow-right"></i><br>Aprobada
				  	"""),_display_(Seq[Any](/*64.9*/checkbox(formBuscador("btnFiltro[2]"), 'hidden -> "hidden"))),format.raw/*64.68*/("""
				  </button>
				  <button type="button" rel="abierta" class="btn btn-default btn-filtros">
				  	<i class="glyphicon glyphicon-minus-sign"></i><br>Cancelada
				  	"""),_display_(Seq[Any](/*68.9*/checkbox(formBuscador("btnFiltro[3]"), 'hidden -> "hidden"))),format.raw/*68.68*/("""
				  </button>
				</div> 
			</div>
		</div>
		<div class="row">
			<div class="col-sm-3">
				<div class="form-group">
					<label for="nombreProveedor" class="control-label">Nombre proveedor
					"""),_display_(Seq[Any](/*77.7*/inputText(formBuscador("nombreProveedor"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*77.102*/("""
					
					</label>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="form-group">
					<label for="nombreProveedor" class="control-label">Número de cuenta
					"""),_display_(Seq[Any](/*85.7*/inputText(formBuscador("numeroCuenta"), 'class -> "form-control"))),format.raw/*85.72*/("""
					</label>
				</div>
			</div>
			<div class="col-sm-2">
				<div class="form-group">
				<label for="nombre" class="control-label">&nbsp;</label>
				<button  class="form-control btn btn-primary"><i class="glyphicon glyphicon-search"></i> Buscar</button>
				</div>
			</div>
			<div class="col-sm-2">
				<div class="form-group">
				<label for="nombre" class="control-label">&nbsp;</label>
				<a href=""""),_display_(Seq[Any](/*98.15*/controllers/*98.26*/.contabilidad.routes.CuentaBancariasController.indexCuentaBancaria())),format.raw/*98.94*/(""""  class="form-control btn btn-default">Limpiar</a>
				</div>
			</div>
		</div>
		</form>
	</div>
	"""),_display_(Seq[Any](/*104.3*/views/*104.8*/.html.tags.successError())),format.raw/*104.33*/("""
	
	"""),_display_(Seq[Any](/*106.3*/if(buscador.getTotalRowCount == 0)/*106.37*/ {_display_(Seq[Any](format.raw/*106.39*/("""
        
        <div class="well">
            <em>No se encuentra cuentas bancarias</em>
        </div>
        
    """)))}/*112.7*/else/*112.12*/{_display_(Seq[Any](format.raw/*112.13*/("""
		
		Mostrando """),_display_(Seq[Any](/*114.14*/buscador/*114.22*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*114.54*/(""" resultado(s). 
		
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th width="20"><input type="checkbox" name="checkAll" id="checkAll"/></th>
					<th width="50">#</th>
					<th width="300">Proveedor</th>
					<th>Cuit</th>
					<th width="300">Banco</th>
					<th width="300">Sucursal</th>
					<th width="300">Numero de cuenta</th>
					<th width="300">CBU</th>
					<th>Estado</th>
					<th>Predeterminada</th>
					<th class="50">#</th>
				</tr>
			</thead>
			<tbody>
			"""),_display_(Seq[Any](/*133.5*/for(cuentaBancaria <- buscador.getList) yield /*133.44*/ {_display_(Seq[Any](format.raw/*133.46*/("""
				 
				<tr class="pointer  """),_display_(Seq[Any](/*135.26*/getClassEstado(cuentaBancaria.estado))),format.raw/*135.63*/("""" data-href=""""),_display_(Seq[Any](/*135.77*/controllers/*135.88*/.contabilidad.routes.CuentaBancariasController.ver(cuentaBancaria.id))),format.raw/*135.157*/("""">
					<td><input type="checkbox" name="id_cuenta[]" value=""""),_display_(Seq[Any](/*136.60*/cuentaBancaria/*136.74*/.id)),format.raw/*136.77*/("""" class="notSeleccion" id="check-"""),_display_(Seq[Any](/*136.111*/cuentaBancaria/*136.125*/.id)),format.raw/*136.128*/(""""/></td>
					<td class="notSeleccion">
						<a href=""""),_display_(Seq[Any](/*138.17*/controllers/*138.28*/.contabilidad.routes.CuentaBancariasController.editarCuentaBancaria(cuentaBancaria.id))),format.raw/*138.114*/("""">
							<i class="glyphicon glyphicon-edit"></i>
						</a>
					</td>
					<td>"""),_display_(Seq[Any](/*142.11*/if(cuentaBancaria.proveedor != null)/*142.47*/{_display_(Seq[Any](_display_(Seq[Any](/*142.49*/(cuentaBancaria.proveedor.nombre)))))})),format.raw/*142.83*/("""</td>
					<td>"""),_display_(Seq[Any](/*143.11*/if(cuentaBancaria.proveedor.cuit != null)/*143.52*/{_display_(Seq[Any](_display_(Seq[Any](/*143.54*/(cuentaBancaria.proveedor.cuit)))))})),format.raw/*143.86*/("""</td>
					<td>"""),_display_(Seq[Any](/*144.11*/if(cuentaBancaria.banco != null)/*144.43*/{_display_(Seq[Any](_display_(Seq[Any](/*144.45*/(cuentaBancaria.banco.nombre)))))})),format.raw/*144.75*/("""</td>
					<td>"""),_display_(Seq[Any](/*145.11*/if(cuentaBancaria.sucursal_banco != null)/*145.52*/{_display_(Seq[Any](_display_(Seq[Any](/*145.54*/(cuentaBancaria.sucursal_banco.nombre)))))})),format.raw/*145.93*/("""</td>
					<td>"""),_display_(Seq[Any](/*146.11*/(cuentaBancaria.numero_cuenta))),format.raw/*146.41*/("""</td>
					<td>"""),_display_(Seq[Any](/*147.11*/if(cuentaBancaria.cbu != null)/*147.41*/{_display_(Seq[Any](_display_(Seq[Any](/*147.43*/(cuentaBancaria.cbu)))))})),format.raw/*147.64*/("""</td>
					<td>"""),_display_(Seq[Any](/*148.11*/if(cuentaBancaria.estado != null)/*148.44*/{_display_(Seq[Any](_display_(Seq[Any](/*148.46*/(cuentaBancaria.estado.nombre)))))})),format.raw/*148.77*/("""</td>
					<td>"""),_display_(Seq[Any](/*149.11*/if(cuentaBancaria.predeterminada != null && cuentaBancaria.predeterminada)/*149.85*/{_display_(Seq[Any](format.raw/*149.86*/("""Si""")))}/*149.89*/else/*149.93*/{_display_(Seq[Any](format.raw/*149.94*/("""No""")))})),format.raw/*149.97*/("""</td>
					<td>
						<a href=""""),_display_(Seq[Any](/*151.17*/controllers/*151.28*/.contabilidad.routes.CuentaBancariasController.eliminarCuentaBancaria(cuentaBancaria.id))),format.raw/*151.116*/("""">
							<i class="glyphicon glyphicon-remove-circle"></i>
						</a>
					</td>
				</tr>
             """)))})),format.raw/*156.15*/("""
	        </tbody>
        </table>
		<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*160.8*/views/*160.13*/.html.helpers.paginador(buscador, controllers.contabilidad.routes.CuentaBancariasController.indexCuentaBancaria()))),format.raw/*160.127*/("""
		</div>
<script>
$( function ()"""),format.raw/*163.15*/("""{"""),format.raw/*163.16*/("""
	$( "#checkAll" ).click(function() """),format.raw/*164.36*/("""{"""),format.raw/*164.37*/("""
		selectAll();
	"""),format.raw/*166.2*/("""}"""),format.raw/*166.3*/(""");
	
	$('#reporteDatosGenerales').click( function() """),format.raw/*168.48*/("""{"""),format.raw/*168.49*/(""" //abrir modal para mostrar mensaje informe rentas
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog("""),format.raw/*172.18*/("""{"""),format.raw/*172.19*/("""
			title: "Informe Datos Generales",
	    	resizable: false,
			autoOpen: true,
			modal: true,
			height: 250,
			width:750,
	        buttons: """),format.raw/*179.19*/("""{"""),format.raw/*179.20*/("""
		          Cerrar: function() """),format.raw/*180.32*/("""{"""),format.raw/*180.33*/("""
		            $( this ).dialog( "destroy" );
		          """),format.raw/*182.13*/("""}"""),format.raw/*182.14*/("""
		    """),format.raw/*183.7*/("""}"""),format.raw/*183.8*/(""",
	    	close: function(event, ui )"""),format.raw/*184.34*/("""{"""),format.raw/*184.35*/("""
	    		$(this).dialog( "destroy" );
	    	"""),format.raw/*186.7*/("""}"""),format.raw/*186.8*/(""",
		    open: function( event, ui ) """),format.raw/*187.35*/("""{"""),format.raw/*187.36*/("""
				$.post(url, getCheckSeleccionados(), function(data)"""),format.raw/*188.56*/("""{"""),format.raw/*188.57*/("""
					dialogo.html(data);
				"""),format.raw/*190.5*/("""}"""),format.raw/*190.6*/(""");	
		    """),format.raw/*191.7*/("""}"""),format.raw/*191.8*/("""
	    """),format.raw/*192.6*/("""}"""),format.raw/*192.7*/(""");
	"""),format.raw/*193.2*/("""}"""),format.raw/*193.3*/(""");
	
"""),format.raw/*195.1*/("""}"""),format.raw/*195.2*/(""");		

function getCheckSeleccionados()"""),format.raw/*197.33*/("""{"""),format.raw/*197.34*/("""
	return $("input[name='id_cuenta[]']").serialize();
"""),format.raw/*199.1*/("""}"""),format.raw/*199.2*/("""


function selectAll()"""),format.raw/*202.21*/("""{"""),format.raw/*202.22*/("""
	if($("#checkAll").prop("checked"))"""),format.raw/*203.36*/("""{"""),format.raw/*203.37*/("""
		$("input[name='id_cuenta[]']").prop( "checked", true );
	"""),format.raw/*205.2*/("""}"""),format.raw/*205.3*/("""else"""),format.raw/*205.7*/("""{"""),format.raw/*205.8*/("""
		$( "input[name='id_cuenta[]']").prop( "checked", false );
	"""),format.raw/*207.2*/("""}"""),format.raw/*207.3*/("""
"""),format.raw/*208.1*/("""}"""),format.raw/*208.2*/("""
</script>
	""")))})),format.raw/*210.3*/("""
""")))})),format.raw/*211.2*/("""
		
		
	
	"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[CuentaBancaria],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[CuentaBancaria],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/cuentaBancarias/indexCuentaBancaria.scala.html
                    HASH: 97f0c5307e038a683ce2869bd39423bac62012fe
                    MATRIX: 866->1|1041->173|1055->180|1139->184|1190->200|1204->206|1283->264|1350->102|1382->126|1439->302|1461->316|1751->83|1779->170|1807->300|1835->576|1873->579|1886->584|1965->654|2005->656|2557->1172|2577->1183|2669->1253|2828->1376|2848->1387|2936->1453|3461->1943|3542->2002|3749->2174|3830->2233|4036->2404|4117->2463|4323->2634|4404->2693|4641->2895|4759->2990|4970->3166|5057->3231|5505->3643|5525->3654|5615->3722|5753->3824|5767->3829|5815->3854|5856->3859|5900->3893|5941->3895|6081->4017|6095->4022|6135->4023|6189->4040|6207->4048|6262->4080|6806->4588|6862->4627|6903->4629|6972->4661|7032->4698|7083->4712|7104->4723|7197->4792|7296->4854|7320->4868|7346->4871|7418->4905|7443->4919|7470->4922|7563->4978|7584->4989|7694->5075|7814->5158|7860->5194|7909->5196|7970->5230|8023->5246|8074->5287|8123->5289|8182->5321|8235->5337|8277->5369|8326->5371|8383->5401|8436->5417|8487->5458|8536->5460|8602->5499|8655->5515|8708->5545|8761->5561|8801->5591|8850->5593|8898->5614|8951->5630|8994->5663|9043->5665|9101->5696|9154->5712|9238->5786|9278->5787|9301->5790|9315->5794|9355->5795|9391->5798|9460->5830|9481->5841|9593->5929|9732->6035|9849->6116|9864->6121|10002->6235|10064->6268|10094->6269|10159->6305|10189->6306|10234->6323|10263->6324|10344->6376|10374->6377|10544->6518|10574->6519|10748->6664|10778->6665|10839->6697|10869->6698|10956->6756|10986->6757|11021->6764|11050->6765|11114->6800|11144->6801|11215->6844|11244->6845|11309->6881|11339->6882|11424->6938|11454->6939|11512->6969|11541->6970|11579->6980|11608->6981|11642->6987|11671->6988|11703->6992|11732->6993|11765->6998|11794->6999|11861->7037|11891->7038|11972->7091|12001->7092|12053->7115|12083->7116|12148->7152|12178->7153|12266->7213|12295->7214|12327->7218|12356->7219|12446->7281|12475->7282|12504->7283|12533->7284|12578->7297|12612->7299
                    LINES: 26->1|29->4|29->4|31->4|32->5|32->5|32->5|33->3|33->3|33->7|33->7|45->1|46->3|47->6|48->18|50->20|50->20|50->20|50->20|64->34|64->34|64->34|71->41|71->41|71->41|86->56|86->56|90->60|90->60|94->64|94->64|98->68|98->68|107->77|107->77|115->85|115->85|128->98|128->98|128->98|134->104|134->104|134->104|136->106|136->106|136->106|142->112|142->112|142->112|144->114|144->114|144->114|163->133|163->133|163->133|165->135|165->135|165->135|165->135|165->135|166->136|166->136|166->136|166->136|166->136|166->136|168->138|168->138|168->138|172->142|172->142|172->142|172->142|173->143|173->143|173->143|173->143|174->144|174->144|174->144|174->144|175->145|175->145|175->145|175->145|176->146|176->146|177->147|177->147|177->147|177->147|178->148|178->148|178->148|178->148|179->149|179->149|179->149|179->149|179->149|179->149|179->149|181->151|181->151|181->151|186->156|190->160|190->160|190->160|193->163|193->163|194->164|194->164|196->166|196->166|198->168|198->168|202->172|202->172|209->179|209->179|210->180|210->180|212->182|212->182|213->183|213->183|214->184|214->184|216->186|216->186|217->187|217->187|218->188|218->188|220->190|220->190|221->191|221->191|222->192|222->192|223->193|223->193|225->195|225->195|227->197|227->197|229->199|229->199|232->202|232->202|233->203|233->203|235->205|235->205|235->205|235->205|237->207|237->207|238->208|238->208|240->210|241->211
                    -- GENERATED --
                */
            