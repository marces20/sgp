
package views.html.dashboard.autorizados

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
object indexAutorizado extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[utils.pagination.Pagination[Autorizado],DynamicForm,utils.pagination.PaginadorFicha,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[Autorizado], formBuscador: DynamicForm, paginadorFicha: utils.pagination.PaginadorFicha):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

def /*6.2*/scripts/*6.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*6.13*/("""
	<script src=""""),_display_(Seq[Any](/*7.16*/routes/*7.22*/.Assets.at("javascripts/dashboard/autorizado.js"))),format.raw/*7.71*/("""" type="text/javascript"></script>
""")))};implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};def /*10.2*/getClassEstado/*10.16*/(i:Estado) = {{
	var classEstado:String = new String()
	if(i != null && i.id == 84){
		classEstado = "borrador"
	}else if(i != null && i.id == 86){
		classEstado = "cancelada"
	}else if(i != null && i.id == 85){
		classEstado = "autorizado"
	}
	classEstado
	
}};
Seq[Any](format.raw/*1.129*/("""
"""),format.raw/*5.70*/("""
"""),format.raw/*8.2*/("""

"""),format.raw/*21.2*/("""

"""),_display_(Seq[Any](/*23.2*/views/*23.7*/.html.dashboard.mainDashboard("Lista de Autorizados", scripts)/*23.69*/ {_display_(Seq[Any](format.raw/*23.71*/("""
	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Lista de Autorizados</h1>
			</div>
			
			<div class="col-sm-5">
				<div class="dropdown pull-right">
				 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 	<i class="glyphicon glyphicon-list-alt"></i>
				    Reportes
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				  	
				  	
				  </ul>
				</div>
				
				<div class="dropdown pull-right btn-header">
				 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 	<i class="glyphicon glyphicon-cog"></i>
				    Acciones
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				  	<li role="presentation" class="dropdown-header">Acciones Masivas</li>
				  </ul>
				</div>
					
				<div class="pull-right btn-header">
					<a href=""""),_display_(Seq[Any](/*55.16*/controllers/*55.27*/.dashboard.routes.AutorizadosController.crear())),format.raw/*55.74*/("""?"""),_display_(Seq[Any](/*55.76*/UriTrack/*55.84*/.encode())),format.raw/*55.93*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo Autorizado</a>
				</div>
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*61.3*/views/*61.8*/.html.tags.successError())),format.raw/*61.33*/("""
	
	<div id="actions">
		<form action="" id="formSearchAutorizafos" method="GET">
		<div class="row">
			<div class="col-sm-8 filtrosEstados" id="filtrosEstados">
			 	<div class="btn-group">
				  <button type="button" id="btn-filtro-borrador" rel="borrador" class="btn btn-default btn-filtros"><i class="glyphicon glyphicon-pencil"></i><br>Borrador
				 	"""),_display_(Seq[Any](/*69.8*/checkbox(formBuscador("btnFiltro[0]"), 'hidden -> "hidden"))),format.raw/*69.67*/("""
				  </button>
				 <button type="button" id="btn-filtro-aprobado" rel="aprobado" class="btn btn-default btn-filtros"><i class="glyphicon glyphicon-ok"></i><br>Aprobado 
				  	"""),_display_(Seq[Any](/*72.9*/checkbox(formBuscador("btnFiltro[1]"), 'hidden -> "hidden"))),format.raw/*72.68*/("""
				  </button>
				  <button type="button" id="btn-filtro-cancelado" rel="cancelado" class="btn btn-default btn-filtros"><i class="glyphicon glyphicon-minus-sign"></i><br>Cancelado 
				  	"""),_display_(Seq[Any](/*75.9*/checkbox(formBuscador("btnFiltro[2]"), 'hidden -> "hidden"))),format.raw/*75.68*/("""
				  </button>
				</div>
			</div>
		</div>

		<div class="row">	
    		
			<div class="col-sm-2">
				<div class="form-group">
					<label for="nombre" class="control-label">Referencia
					"""),_display_(Seq[Any](/*86.7*/inputText(formBuscador("nombre"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*86.93*/("""
					</label>
				</div>
			</div>
			<div class="col-sm-2">
				<label class="control-label">Expediente</label>
					<div class="input-group">
						"""),_display_(Seq[Any](/*93.8*/inputText(formBuscador("expediente.nombre"), 'name -> "", 'class -> "form-control", 'id -> "expediente"))),format.raw/*93.112*/("""
						"""),_display_(Seq[Any](/*94.8*/inputText(formBuscador("expediente.id"), 'hidden -> "hidden", 'id -> "expediente_id"))),format.raw/*94.93*/("""
						<span class="input-group-addon">
							<a href="#" class="searchModal"
										id="searchExpediente" 
										data-title="Selección de expediente" 
										data-url=""""),_display_(Seq[Any](/*99.22*/controllers/*99.33*/.expediente.routes.ExpedientesController.modalBuscar())),format.raw/*99.87*/("""" 
										data-height="650" 
										data-width="700" 
										data-listen="modal.seleccion.expediente.simple" 
										data-label="#expediente" 
										data-field="#expediente_id">
								<i class="glyphicon glyphicon-search"></i>
							</a>
						</span>
					</div>
			</div>
			<div class="col-sm-2">
				<label class="control-label">Proveedor
					<div class="input-group">
						"""),_display_(Seq[Any](/*113.8*/inputText(formBuscador("proveedor.nombre"), 'name -> "", 'class -> "form-control", 'id -> "proveedor"))),format.raw/*113.110*/("""
						"""),_display_(Seq[Any](/*114.8*/inputText(formBuscador("proveedor.id"), 'hidden -> "hidden", 'id -> "proveedor_id"))),format.raw/*114.91*/("""
						<span class="input-group-addon">
							<a href="#" class="searchModal"
										id="searchProveedor" 
										data-title="Selección de Proveedores" 
										data-url=""""),_display_(Seq[Any](/*119.22*/controllers/*119.33*/.compras.routes.ProveedoresController.modalBuscar())),format.raw/*119.84*/("""" 
										data-height="650" 
										data-width="700" 
										data-listen="modal.seleccion.proveedor.simple" 
										data-label="#proveedor" 
										data-field="#proveedor_id">
								<i class="glyphicon glyphicon-search"></i>
							</a>
						</span>
					</div>
				</label>
			</div>
		</div>
		<div class="row">
			 
			<div class="col-sm-2">
				<div class="form-group">
				<label for="nombre" class="control-label">&nbsp;</label>
				<button  class="form-control btn btn-primary">Buscar</button>
				</div>
			</div>
			<div class="col-sm-2">
				<div class="form-group">
				<label for="nombre" class="control-label">&nbsp;</label>
				<a href=""""),_display_(Seq[Any](/*143.15*/controllers/*143.26*/.dashboard.routes.AutorizadosController.index())),format.raw/*143.73*/(""""  class="form-control btn btn-default">Limpiar</a>
				</div>
			</div>
		</div>
		 
		</form>
	</div>
	
	"""),_display_(Seq[Any](/*151.3*/if(buscador.getTotalRowCount == 0)/*151.37*/ {_display_(Seq[Any](format.raw/*151.39*/("""
        
        <div class="well">
            <em>No se encuentran Autorizados</em>
        </div>
        
    """)))}/*157.7*/else/*157.12*/{_display_(Seq[Any](format.raw/*157.13*/("""
    	
		<table id="listaAutorizados" class="table table-striped table-bordered">
			<thead>
				 <tr style="background: #FFFFFF;">
			        <td colspan="5">Mostrando """),_display_(Seq[Any](/*162.39*/buscador/*162.47*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*162.79*/(""" resultado(s). </td>
			        <td><b>Total:</b> <span class="totalFooter"></span></td>
			        <td colspan="2">&nbsp</td>
		        </tr>
				<tr>
					<th width="30"><input type="checkbox" name="checkAll" id="checkAll"/></th>
					<th width="30">#</th>
					<th width="40">Referencia</th>
					<th width="80">Descripcion</th>
					<th width="70">Fecha</th>
					<th width="95">Total</th>
					<th width="100">Estado</th>
					<th width="30">#</th>
				</tr>
			</thead>
			<tbody>
			"""),_display_(Seq[Any](/*178.5*/for(autorizado <- buscador.getList) yield /*178.40*/ {_display_(Seq[Any](format.raw/*178.42*/("""
				"""),_display_(Seq[Any](/*179.6*/paginadorFicha/*179.20*/.add(autorizado.id.toString))),format.raw/*179.48*/("""
				<tr class="pointer """),_display_(Seq[Any](/*180.25*/getClassEstado(autorizado.estado))),format.raw/*180.58*/("""" data-estado=""""),_display_(Seq[Any](/*180.74*/autorizado/*180.84*/.estado_id)),format.raw/*180.94*/("""" data-href=""""),_display_(Seq[Any](/*180.108*/controllers/*180.119*/.dashboard.routes.AutorizadosController.ver(autorizado.id))),format.raw/*180.177*/("""&"""),_display_(Seq[Any](/*180.179*/UriTrack/*180.187*/.encode())),format.raw/*180.196*/("""">
					<td><input type="checkbox" name="check_listado[]" value=""""),_display_(Seq[Any](/*181.64*/autorizado/*181.74*/.id)),format.raw/*181.77*/("""" class="notSeleccion" id="check-"""),_display_(Seq[Any](/*181.111*/autorizado/*181.121*/.id)),format.raw/*181.124*/(""""/></td>
					<td><a class="btn btn-default btn-xs notSeleccion" href=""""),_display_(Seq[Any](/*182.64*/controllers/*182.75*/.dashboard.routes.AutorizadosController.editar(autorizado.id))),format.raw/*182.136*/("""&"""),_display_(Seq[Any](/*182.138*/UriTrack/*182.146*/.encode())),format.raw/*182.155*/(""""><i class="glyphicon glyphicon-edit"></i></a></td>
					<td>"""),_display_(Seq[Any](/*183.11*/(autorizado.nombre))),format.raw/*183.30*/("""</td>
					<td>"""),_display_(Seq[Any](/*184.11*/(autorizado.descripcion))),format.raw/*184.35*/("""</td>
					<td class="fecha">"""),_display_(Seq[Any](/*185.25*/if(autorizado.fecha != null)/*185.53*/{_display_(Seq[Any](_display_(Seq[Any](/*185.55*/(utils.DateUtils.formatDate(autorizado.fecha))))))})),format.raw/*185.102*/("""</td>
					<td class="total" rel=""""),_display_(Seq[Any](/*186.30*/autorizado/*186.40*/.getTotal())),format.raw/*186.51*/("""">"""),_display_(Seq[Any](/*186.54*/(utils.NumberUtils.moneda(autorizado.getTotal())))),format.raw/*186.103*/("""</td>
					<td class="estado">"""),_display_(Seq[Any](/*187.26*/if(autorizado.estado != null)/*187.55*/{_display_(Seq[Any](_display_(Seq[Any](/*187.57*/(autorizado.estado.nombre)))))})),format.raw/*187.84*/("""</td>
					<td>
						<a class="btn btn-default btn-xs delete-confirm-link notSeleccion" href=""""),_display_(Seq[Any](/*189.81*/controllers/*189.92*/.dashboard.routes.AutorizadosController.eliminar(autorizado.id))),format.raw/*189.155*/("""&"""),_display_(Seq[Any](/*189.157*/UriTrack/*189.165*/.encode())),format.raw/*189.174*/("""">
							<i class="glyphicon glyphicon-trash icono-eliminar"></i>
						</a>
					</td>
				</tr>
             """)))})),format.raw/*194.15*/("""
             """),_display_(Seq[Any](/*195.15*/paginadorFicha/*195.29*/.guardar())),format.raw/*195.39*/("""
	        </tbody>
	        <tfoot>
		        <tr>
			        <td colspan="5">&nbsp</td>
			        <td><b>Total:</b> <span class="totalFooter"></span></td>
			        <td colspan="2">&nbsp</td>
		        </tr>
	        </tfoot>
        </table>
    	
    	<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*207.8*/views/*207.13*/.html.helpers.paginador(buscador, controllers.dashboard.routes.AutorizadosController.index()))),format.raw/*207.106*/("""
		</div>
<script>
$( function ()"""),format.raw/*210.15*/("""{"""),format.raw/*210.16*/("""
	var n = 0;
	var b = 0;
	var c = 0;
	$(".total").each(function (index) """),format.raw/*214.36*/("""{"""),format.raw/*214.37*/("""
		
		n = Number($(this).attr("rel"))+n 
	"""),format.raw/*217.2*/("""}"""),format.raw/*217.3*/(""")
	$(".totalFooter").append(formatNumberPesos(parseFloat(n).toFixed(2)));
	
	
	$( "#checkAll" ).click(function() """),format.raw/*221.36*/("""{"""),format.raw/*221.37*/("""
		
		  	selectAll();
	"""),format.raw/*224.2*/("""}"""),format.raw/*224.3*/(""");
	$( "input[name='check_listado[]']" ).click(function() """),format.raw/*225.56*/("""{"""),format.raw/*225.57*/("""
		selectTrList();
	"""),format.raw/*227.2*/("""}"""),format.raw/*227.3*/(""");
"""),format.raw/*228.1*/("""}"""),format.raw/*228.2*/(""");

function selectTrList()"""),format.raw/*230.24*/("""{"""),format.raw/*230.25*/("""
	var n = 0;
	var b = 0;
	var c = 0;
	$(".total").each(function (index) """),format.raw/*234.36*/("""{"""),format.raw/*234.37*/("""
		if($(this).parent().find("input[name='check_listado[]']").prop("checked"))"""),format.raw/*235.77*/("""{"""),format.raw/*235.78*/("""
			n = Number($(this).attr("rel"))+n 
		"""),format.raw/*237.3*/("""}"""),format.raw/*237.4*/("""
	"""),format.raw/*238.2*/("""}"""),format.raw/*238.3*/(""")
	$(".totalFooter").empty();
	$(".totalFooter").append(formatNumberPesos(parseFloat(n).toFixed(2)));
	
"""),format.raw/*242.1*/("""}"""),format.raw/*242.2*/("""

function selectAll()"""),format.raw/*244.21*/("""{"""),format.raw/*244.22*/("""
	var n = 0; 
	var b = 0; 
	var c = 0; 
	if($("#checkAll").prop("checked"))"""),format.raw/*248.36*/("""{"""),format.raw/*248.37*/("""
		$("input[name='check_listado[]']").prop( "checked", true );
		
	"""),format.raw/*251.2*/("""}"""),format.raw/*251.3*/("""else"""),format.raw/*251.7*/("""{"""),format.raw/*251.8*/("""
		$( "input[name='check_listado[]']").prop( "checked", false );
	"""),format.raw/*253.2*/("""}"""),format.raw/*253.3*/("""
	
	$(".total").each(function (index) """),format.raw/*255.36*/("""{"""),format.raw/*255.37*/("""
		n = Number($(this).attr("rel"))+n 
	"""),format.raw/*257.2*/("""}"""),format.raw/*257.3*/(""")
	$(".totalFooter").empty();
	$(".totalFooter").append(formatNumberPesos(parseFloat(n).toFixed(2)));
"""),format.raw/*260.1*/("""}"""),format.raw/*260.2*/("""

</script>		
 	 """)))})),format.raw/*263.5*/("""
""")))})))}
    }
    
    def render(buscador:utils.pagination.Pagination[Autorizado],formBuscador:DynamicForm,paginadorFicha:utils.pagination.PaginadorFicha): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador,paginadorFicha)
    
    def f:((utils.pagination.Pagination[Autorizado],DynamicForm,utils.pagination.PaginadorFicha) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador,paginadorFicha) => apply(buscador,formBuscador,paginadorFicha)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:58 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/autorizados/indexAutorizado.scala.html
                    HASH: 806bb6290339fe46a1e5eb7270c1ceddb68baa30
                    MATRIX: 883->1|1141->255|1155->262|1239->266|1290->282|1304->288|1374->337|1441->185|1473->209|1531->376|1554->390|1845->128|1873->253|1900->373|1929->650|1967->653|1980->658|2051->720|2091->722|3178->1773|3198->1784|3267->1831|3305->1833|3322->1841|3353->1850|3525->1987|3538->1992|3585->2017|3978->2375|4059->2434|4274->2614|4355->2673|4582->2865|4663->2924|4893->3119|5001->3205|5188->3357|5315->3461|5358->3469|5465->3554|5682->3735|5702->3746|5778->3800|6214->4200|6340->4302|6384->4310|6490->4393|6708->4574|6729->4585|6803->4636|7510->5306|7531->5317|7601->5364|7745->5472|7789->5506|7830->5508|7965->5625|7979->5630|8019->5631|8226->5801|8244->5809|8299->5841|8826->6332|8878->6367|8919->6369|8961->6375|8985->6389|9036->6417|9098->6442|9154->6475|9207->6491|9227->6501|9260->6511|9312->6525|9334->6536|9416->6594|9456->6596|9475->6604|9508->6613|9611->6679|9631->6689|9657->6692|9729->6726|9750->6736|9777->6739|9886->6811|9907->6822|9992->6883|10032->6885|10051->6893|10084->6902|10183->6964|10225->6983|10278->6999|10325->7023|10392->7053|10430->7081|10479->7083|10554->7130|10626->7165|10646->7175|10680->7186|10720->7189|10793->7238|10861->7269|10900->7298|10949->7300|11003->7327|11136->7423|11157->7434|11244->7497|11284->7499|11303->7507|11336->7516|11482->7629|11534->7644|11558->7658|11591->7668|11927->7968|11942->7973|12059->8066|12121->8099|12151->8100|12252->8172|12282->8173|12352->8215|12381->8216|12523->8329|12553->8330|12604->8353|12633->8354|12720->8412|12750->8413|12798->8433|12827->8434|12858->8437|12887->8438|12943->8465|12973->8466|13074->8538|13104->8539|13210->8616|13240->8617|13309->8658|13338->8659|13368->8661|13397->8662|13529->8766|13558->8767|13609->8789|13639->8790|13743->8865|13773->8866|13868->8933|13897->8934|13929->8938|13958->8939|14052->9005|14081->9006|14148->9044|14178->9045|14245->9084|14274->9085|14404->9187|14433->9188|14483->9206
                    LINES: 26->1|33->6|33->6|35->6|36->7|36->7|36->7|37->5|37->5|37->10|37->10|49->1|50->5|51->8|53->21|55->23|55->23|55->23|55->23|87->55|87->55|87->55|87->55|87->55|87->55|93->61|93->61|93->61|101->69|101->69|104->72|104->72|107->75|107->75|118->86|118->86|125->93|125->93|126->94|126->94|131->99|131->99|131->99|145->113|145->113|146->114|146->114|151->119|151->119|151->119|175->143|175->143|175->143|183->151|183->151|183->151|189->157|189->157|189->157|194->162|194->162|194->162|210->178|210->178|210->178|211->179|211->179|211->179|212->180|212->180|212->180|212->180|212->180|212->180|212->180|212->180|212->180|212->180|212->180|213->181|213->181|213->181|213->181|213->181|213->181|214->182|214->182|214->182|214->182|214->182|214->182|215->183|215->183|216->184|216->184|217->185|217->185|217->185|217->185|218->186|218->186|218->186|218->186|218->186|219->187|219->187|219->187|219->187|221->189|221->189|221->189|221->189|221->189|221->189|226->194|227->195|227->195|227->195|239->207|239->207|239->207|242->210|242->210|246->214|246->214|249->217|249->217|253->221|253->221|256->224|256->224|257->225|257->225|259->227|259->227|260->228|260->228|262->230|262->230|266->234|266->234|267->235|267->235|269->237|269->237|270->238|270->238|274->242|274->242|276->244|276->244|280->248|280->248|283->251|283->251|283->251|283->251|285->253|285->253|287->255|287->255|289->257|289->257|292->260|292->260|295->263
                    -- GENERATED --
                */
            