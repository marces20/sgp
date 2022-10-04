
package views.html.recupero.presupuesto

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
object indexPresupuesto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[models.recupero.Presupuesto],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[models.recupero.Presupuesto], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

def /*6.2*/scripts/*6.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*6.13*/("""
	<script src=""""),_display_(Seq[Any](/*7.16*/routes/*7.22*/.Assets.at("javascripts/recupero/presupuesto.js"))),format.raw/*7.71*/("""" type="text/javascript"></script>
""")))};implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};def /*10.2*/getClassEstado/*10.16*/(i:Estado) = {{
	var classEstado:String = new String()
	if(i != null && i.id == 61){
		classEstado = "borrador"
	}else if(i != null && i.id == 64){
		classEstado = "cancelada"
	}else if(i != null && i.id == 63){
		classEstado = "autorizado"
	}
	classEstado
	
}};
Seq[Any](format.raw/*1.97*/("""
"""),format.raw/*5.70*/("""
"""),format.raw/*8.2*/("""

"""),format.raw/*21.2*/("""

"""),_display_(Seq[Any](/*23.2*/views/*23.7*/.html.recupero.mainRecupero("Lista de Presupuestos", scripts)/*23.68*/ {_display_(Seq[Any](format.raw/*23.70*/("""
	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Lista de presupuestos</h1>
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
				  	
				  </ul>
				</div>
					
				<div class="pull-right btn-header">
					<a href=""""),_display_(Seq[Any](/*54.16*/controllers/*54.27*/.recupero.routes.PresupuestosController.crear())),format.raw/*54.74*/("""?"""),_display_(Seq[Any](/*54.76*/UriTrack/*54.84*/.encode())),format.raw/*54.93*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo Presupuesto</a>
				</div>
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*60.3*/views/*60.8*/.html.tags.successError())),format.raw/*60.33*/("""
	
	<div id="actions">
		<form action="" id="formSearchPresupuestos" method="GET">
		<div class="row">
			<div class="col-sm-8 filtrosEstados" id="filtrosEstados">
			 	<div class="btn-group">
				  <button type="button" id="btn-filtro-borrador" rel="borrador" class="btn btn-default btn-filtros"><i class="glyphicon glyphicon-pencil"></i><br>Borrador
				 	"""),_display_(Seq[Any](/*68.8*/checkbox(formBuscador("btnFiltro[0]"), 'hidden -> "hidden"))),format.raw/*68.67*/("""
				  </button>
				  <button type="button" id="btn-filtro-encurso" rel="encurso" class="btn btn-default btn-filtros"><i class="glyphicon glyphicon-arrow-right"></i><br>En Curso 
				  	"""),_display_(Seq[Any](/*71.9*/checkbox(formBuscador("btnFiltro[1]"), 'hidden -> "hidden"))),format.raw/*71.68*/("""
				  </button>
				  <button type="button" id="btn-filtro-aprobado" rel="aprobado" class="btn btn-default btn-filtros"><i class="glyphicon glyphicon-ok"></i><br>Aprobado 
				  	"""),_display_(Seq[Any](/*74.9*/checkbox(formBuscador("btnFiltro[2]"), 'hidden -> "hidden"))),format.raw/*74.68*/("""
				  </button>
				  <button type="button" id="btn-filtro-cancelado" rel="cancelado" class="btn btn-default btn-filtros"><i class="glyphicon glyphicon-minus-sign"></i><br>Cancelado 
				  	"""),_display_(Seq[Any](/*77.9*/checkbox(formBuscador("btnFiltro[3]"), 'hidden -> "hidden"))),format.raw/*77.68*/("""
				  </button>
				</div>
			</div>
		</div>

		<div class="row">	
    		
			<div class="col-sm-2">
				<div class="form-group">
					<label for="nombre" class="control-label">Nombre
					"""),_display_(Seq[Any](/*88.7*/inputText(formBuscador("nombre"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*88.93*/("""
					</label>
				</div>
			</div>
			
			<div class="col-sm-4">
				<label class="control-label">Cliente</label>
					<div class="input-group">
						"""),_display_(Seq[Any](/*96.8*/inputText(formBuscador("cliente.nombre"), 'name -> "", 'class -> "form-control", 'id -> "cliente"))),format.raw/*96.106*/("""
						"""),_display_(Seq[Any](/*97.8*/inputText(formBuscador("cliente_id"), 'hidden -> "hidden", 'id -> "cliente_id"))),format.raw/*97.87*/("""
						<span class="input-group-addon">
							<a href="#" class="searchModal"
										id="searchCliente" 
										data-title="Selección de Clientes" 
										data-url=""""),_display_(Seq[Any](/*102.22*/controllers/*102.33*/.compras.routes.ClientesController.modalBuscar())),format.raw/*102.81*/("""" 
										data-height="650" 
										data-width="700" 
										data-listen="modal.seleccion.cliente.simple" 
										data-label="#cliente" 
										data-field="#cliente_id">
								<i class="glyphicon glyphicon-search"></i>
							</a>
						</span>
					</div>
			</div>

			<div class="col-sm-2 input-group">
				<label class="control-label">Fecha de Presupuesto</label>
				<div>
				"""),_display_(Seq[Any](/*117.6*/inputText(formBuscador("fecha_desde"), 'class -> "form-control dateMask inputDateMascara", 'id -> "desde", 'placeholder -> "Desde"))),format.raw/*117.137*/("""
				"""),_display_(Seq[Any](/*118.6*/inputText(formBuscador("fecha_hasta"), 'class -> "form-control dateMask inputDateMascara", 'id -> "hasta", 'placeholder -> "Hasta"))),format.raw/*118.137*/("""
				</div>
			</div>
			<div class="col-sm-4">
				<label for="deposito" class="control-label">Institucion</label> 
				<div class="input-group">
					"""),_display_(Seq[Any](/*124.7*/inputText(formBuscador("deposito.nombre"),'class -> "form-control", 'id -> "deposito_nombre", 'autocomplete -> "off"))),format.raw/*124.124*/("""
					"""),_display_(Seq[Any](/*125.7*/inputText(formBuscador("deposito_id"),'hidden -> "hidden", 'id -> "deposito_id"))),format.raw/*125.87*/("""
					<span class="input-group-addon">
	                	<a href="#" id="searchDeposito" data-title="Selección de Institucion" 
	                	data-url=""""),_display_(Seq[Any](/*128.30*/controllers/*128.41*/.delegacion.routes.DepositosController.modalBuscar())),format.raw/*128.93*/("""" 
	                	data-height="650" data-width="700" 
	                	data-listen="modal.seleccion.deposito.simple" 
	                	data-label="#deposito_nombre" data-field="#deposito_id" /> <i class="glyphicon glyphicon-search"></i></a>
	                </span>
				</div>
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
				<a href=""""),_display_(Seq[Any](/*146.15*/controllers/*146.26*/.recupero.routes.PresupuestosController.index())),format.raw/*146.73*/(""""  class="form-control btn btn-default">Limpiar</a>
				</div>
			</div>
		</div>
		 
		</form>
	</div>
	
	"""),_display_(Seq[Any](/*154.3*/if(buscador.getTotalRowCount == 0)/*154.37*/ {_display_(Seq[Any](format.raw/*154.39*/("""
        
        <div class="well">
            <em>No se encuentran Presupuestos</em>
        </div>
        
    """)))}/*160.7*/else/*160.12*/{_display_(Seq[Any](format.raw/*160.13*/("""
    	
		<table id="listaPresupuestos" class="table table-striped table-bordered">
			<thead>
				 <tr style="background: #FFFFFF;">
			        <td colspan="5">Mostrando """),_display_(Seq[Any](/*165.39*/buscador/*165.47*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*165.79*/(""" resultado(s). </td>
			        <td><b>Total:</b> <span class="totalFooter"></span></td>
			        <td colspan="2">&nbsp</td>
		        </tr>
				<tr>
					<th width="30"><input type="checkbox" name="checkAll" id="checkAll"/></th>
					<th width="30">#</th>
					<th width="80">Institucion</th>
					<th width="80">Nombre</th>
					<th width="70">Fecha</th>
					<th width="300">Cliente</th>
					<th width="95">Total</th>
					<th width="100">Estado</th>
					<th width="30">#</th>
				</tr>
			</thead>
			<tbody>
			"""),_display_(Seq[Any](/*182.5*/for(presupuesto <- buscador.getList) yield /*182.41*/ {_display_(Seq[Any](format.raw/*182.43*/("""
				
				<tr class="pointer """),_display_(Seq[Any](/*184.25*/getClassEstado(presupuesto.estado))),format.raw/*184.59*/("""" data-estado=""""),_display_(Seq[Any](/*184.75*/presupuesto/*184.86*/.estado_id)),format.raw/*184.96*/("""" data-href=""""),_display_(Seq[Any](/*184.110*/controllers/*184.121*/.recupero.routes.PresupuestosController.ver(presupuesto.id))),format.raw/*184.180*/("""&"""),_display_(Seq[Any](/*184.182*/UriTrack/*184.190*/.encode())),format.raw/*184.199*/("""">
					<td><input type="checkbox" name="check_listado[]" value=""""),_display_(Seq[Any](/*185.64*/presupuesto/*185.75*/.id)),format.raw/*185.78*/("""" class="notSeleccion" id="check-"""),_display_(Seq[Any](/*185.112*/presupuesto/*185.123*/.id)),format.raw/*185.126*/(""""/></td>
					<td><a class="btn btn-default btn-xs notSeleccion" href=""""),_display_(Seq[Any](/*186.64*/controllers/*186.75*/.recupero.routes.PresupuestosController.editar(presupuesto.id))),format.raw/*186.137*/("""&"""),_display_(Seq[Any](/*186.139*/UriTrack/*186.147*/.encode())),format.raw/*186.156*/(""""><i class="glyphicon glyphicon-edit"></i></a></td>
					<td>"""),_display_(Seq[Any](/*187.11*/(presupuesto.deposito.nombre))),format.raw/*187.40*/("""</td>
					<td>"""),_display_(Seq[Any](/*188.11*/(presupuesto.nombre))),format.raw/*188.31*/("""</td>
					<td class="fechaPresupuesto">"""),_display_(Seq[Any](/*189.36*/if(presupuesto.fecha != null)/*189.65*/{_display_(Seq[Any](_display_(Seq[Any](/*189.67*/(utils.DateUtils.formatDate(presupuesto.fecha))))))})),format.raw/*189.115*/("""</td>
					<td>"""),_display_(Seq[Any](/*190.11*/if(presupuesto.cliente != null)/*190.42*/{_display_(Seq[Any](_display_(Seq[Any](/*190.44*/(presupuesto.cliente.nombre)))))})),format.raw/*190.73*/("""</td>
					<td class="total" rel=""""),_display_(Seq[Any](/*191.30*/presupuesto/*191.41*/.getTotal())),format.raw/*191.52*/("""">"""),_display_(Seq[Any](/*191.55*/(utils.NumberUtils.moneda(presupuesto.getTotal())))),format.raw/*191.105*/("""</td>
					<td class="estado">"""),_display_(Seq[Any](/*192.26*/if(presupuesto.estado != null)/*192.56*/{_display_(Seq[Any](_display_(Seq[Any](/*192.58*/(presupuesto.estado.nombre)))))})),format.raw/*192.86*/("""</td>
					<td>
						<a class="btn btn-default btn-xs delete-confirm-link notSeleccion" href=""""),_display_(Seq[Any](/*194.81*/controllers/*194.92*/.recupero.routes.PresupuestosController.eliminar(presupuesto.id))),format.raw/*194.156*/("""&"""),_display_(Seq[Any](/*194.158*/UriTrack/*194.166*/.encode())),format.raw/*194.175*/("""">
							<i class="glyphicon glyphicon-trash icono-eliminar"></i>
						</a>
					</td>
				</tr>
             """)))})),format.raw/*199.15*/("""
             
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
		    """),_display_(Seq[Any](/*212.8*/views/*212.13*/.html.helpers.paginador(buscador, controllers.recupero.routes.PresupuestosController.index()))),format.raw/*212.106*/("""
		</div>
<script>
$( function ()"""),format.raw/*215.15*/("""{"""),format.raw/*215.16*/("""
	var n = 0;
	var b = 0;
	var c = 0;
	$(".total").each(function (index) """),format.raw/*219.36*/("""{"""),format.raw/*219.37*/("""
		
		n = Number($(this).attr("rel"))+n 
	"""),format.raw/*222.2*/("""}"""),format.raw/*222.3*/(""")
	$(".totalFooter").append(formatNumberPesos(parseFloat(n).toFixed(2)));
	
	$( "#checkAll" ).click(function() """),format.raw/*225.36*/("""{"""),format.raw/*225.37*/("""
		
		  	selectAll();
	"""),format.raw/*228.2*/("""}"""),format.raw/*228.3*/(""");
	$( "input[name='check_listado[]']" ).click(function() """),format.raw/*229.56*/("""{"""),format.raw/*229.57*/("""
		selectTrList();
	"""),format.raw/*231.2*/("""}"""),format.raw/*231.3*/(""");
"""),format.raw/*232.1*/("""}"""),format.raw/*232.2*/(""");

function selectTrList()"""),format.raw/*234.24*/("""{"""),format.raw/*234.25*/("""
	var n = 0;
	var b = 0;
	var c = 0;
	$(".total").each(function (index) """),format.raw/*238.36*/("""{"""),format.raw/*238.37*/("""
		if($(this).parent().find("input[name='check_listado[]']").prop("checked"))"""),format.raw/*239.77*/("""{"""),format.raw/*239.78*/("""
			n = Number($(this).attr("rel"))+n 
		"""),format.raw/*241.3*/("""}"""),format.raw/*241.4*/("""
	"""),format.raw/*242.2*/("""}"""),format.raw/*242.3*/(""")
	$(".totalFooter").empty();
	$(".totalFooter").append(formatNumberPesos(parseFloat(n).toFixed(2)));
"""),format.raw/*245.1*/("""}"""),format.raw/*245.2*/("""

function selectAll()"""),format.raw/*247.21*/("""{"""),format.raw/*247.22*/("""
	var n = 0; 
	var b = 0; 
	var c = 0; 
	if($("#checkAll").prop("checked"))"""),format.raw/*251.36*/("""{"""),format.raw/*251.37*/("""
		$("input[name='check_listado[]']").prop( "checked", true );
		
	"""),format.raw/*254.2*/("""}"""),format.raw/*254.3*/("""else"""),format.raw/*254.7*/("""{"""),format.raw/*254.8*/("""
		$( "input[name='check_listado[]']").prop( "checked", false );
	"""),format.raw/*256.2*/("""}"""),format.raw/*256.3*/("""
	
	$(".total").each(function (index) """),format.raw/*258.36*/("""{"""),format.raw/*258.37*/("""
		n = Number($(this).attr("rel"))+n 
	"""),format.raw/*260.2*/("""}"""),format.raw/*260.3*/(""")
	$(".totalFooter").empty();
	$(".totalFooter").append(formatNumberPesos(parseFloat(n).toFixed(2)));
"""),format.raw/*263.1*/("""}"""),format.raw/*263.2*/("""

</script>		
 	 """)))})),format.raw/*266.5*/("""
""")))})))}
    }
    
    def render(buscador:utils.pagination.Pagination[models.recupero.Presupuesto],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[models.recupero.Presupuesto],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:35 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/recupero/presupuesto/indexPresupuesto.scala.html
                    HASH: afb75dd5e7f10a5b7f028087a288e3760c25ebce
                    MATRIX: 868->1|1094->223|1108->230|1192->234|1243->250|1257->256|1327->305|1394->153|1426->177|1484->344|1507->358|1797->96|1825->221|1852->341|1881->618|1919->621|1932->626|2002->687|2042->689|3052->1663|3072->1674|3141->1721|3179->1723|3196->1731|3227->1740|3400->1878|3413->1883|3460->1908|3854->2267|3935->2326|4158->2514|4239->2573|4455->2754|4536->2813|4763->3005|4844->3064|5070->3255|5178->3341|5366->3494|5487->3592|5530->3600|5631->3679|5844->3855|5865->3866|5936->3914|6372->4314|6527->4445|6569->4451|6724->4582|6913->4735|7054->4852|7097->4859|7200->4939|7394->5096|7415->5107|7490->5159|8181->5813|8202->5824|8272->5871|8416->5979|8460->6013|8501->6015|8637->6133|8651->6138|8691->6139|8899->6310|8917->6318|8972->6350|9529->6871|9582->6907|9623->6909|9690->6939|9747->6973|9800->6989|9821->7000|9854->7010|9906->7024|9928->7035|10011->7094|10051->7096|10070->7104|10103->7113|10206->7179|10227->7190|10253->7193|10325->7227|10347->7238|10374->7241|10483->7313|10504->7324|10590->7386|10630->7388|10649->7396|10682->7405|10781->7467|10833->7496|10886->7512|10929->7532|11007->7573|11046->7602|11095->7604|11171->7652|11224->7668|11265->7699|11314->7701|11370->7730|11442->7765|11463->7776|11497->7787|11537->7790|11611->7840|11679->7871|11719->7901|11768->7903|11823->7931|11956->8027|11977->8038|12065->8102|12105->8104|12124->8112|12157->8121|12303->8234|12653->8548|12668->8553|12785->8646|12847->8679|12877->8680|12978->8752|13008->8753|13078->8795|13107->8796|13247->8907|13277->8908|13328->8931|13357->8932|13444->8990|13474->8991|13522->9011|13551->9012|13582->9015|13611->9016|13667->9043|13697->9044|13798->9116|13828->9117|13934->9194|13964->9195|14033->9236|14062->9237|14092->9239|14121->9240|14251->9342|14280->9343|14331->9365|14361->9366|14465->9441|14495->9442|14590->9509|14619->9510|14651->9514|14680->9515|14774->9581|14803->9582|14870->9620|14900->9621|14967->9660|14996->9661|15126->9763|15155->9764|15205->9782
                    LINES: 26->1|33->6|33->6|35->6|36->7|36->7|36->7|37->5|37->5|37->10|37->10|49->1|50->5|51->8|53->21|55->23|55->23|55->23|55->23|86->54|86->54|86->54|86->54|86->54|86->54|92->60|92->60|92->60|100->68|100->68|103->71|103->71|106->74|106->74|109->77|109->77|120->88|120->88|128->96|128->96|129->97|129->97|134->102|134->102|134->102|149->117|149->117|150->118|150->118|156->124|156->124|157->125|157->125|160->128|160->128|160->128|178->146|178->146|178->146|186->154|186->154|186->154|192->160|192->160|192->160|197->165|197->165|197->165|214->182|214->182|214->182|216->184|216->184|216->184|216->184|216->184|216->184|216->184|216->184|216->184|216->184|216->184|217->185|217->185|217->185|217->185|217->185|217->185|218->186|218->186|218->186|218->186|218->186|218->186|219->187|219->187|220->188|220->188|221->189|221->189|221->189|221->189|222->190|222->190|222->190|222->190|223->191|223->191|223->191|223->191|223->191|224->192|224->192|224->192|224->192|226->194|226->194|226->194|226->194|226->194|226->194|231->199|244->212|244->212|244->212|247->215|247->215|251->219|251->219|254->222|254->222|257->225|257->225|260->228|260->228|261->229|261->229|263->231|263->231|264->232|264->232|266->234|266->234|270->238|270->238|271->239|271->239|273->241|273->241|274->242|274->242|277->245|277->245|279->247|279->247|283->251|283->251|286->254|286->254|286->254|286->254|288->256|288->256|290->258|290->258|292->260|292->260|295->263|295->263|298->266
                    -- GENERATED --
                */
            