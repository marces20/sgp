
package views.html.recupero.recuperoPlanilla

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
object indexPlanilla extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[models.recupero.RecuperoPlanilla],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[models.recupero.RecuperoPlanilla], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

def /*6.2*/scripts/*6.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*6.13*/("""
	<script src=""""),_display_(Seq[Any](/*7.16*/routes/*7.22*/.Assets.at("javascripts/recupero/planilla.js"))),format.raw/*7.68*/("""" type="text/javascript"></script>
""")))};implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.102*/("""
"""),format.raw/*5.70*/("""
"""),format.raw/*8.2*/("""

 

"""),_display_(Seq[Any](/*12.2*/views/*12.7*/.html.recupero.mainRecupero("Lista de Planillas", scripts)/*12.65*/ {_display_(Seq[Any](format.raw/*12.67*/("""
	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Lista de Planillas</h1>
			</div>
			
			<div class="col-sm-5">
				 
				
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
					<a href=""""),_display_(Seq[Any](/*34.16*/controllers/*34.27*/.recupero.routes.RecuperoPlanillasController.crear())),format.raw/*34.79*/("""?"""),_display_(Seq[Any](/*34.81*/UriTrack/*34.89*/.encode())),format.raw/*34.98*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nueva Planilla</a>
				</div>
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*40.3*/views/*40.8*/.html.tags.successError())),format.raw/*40.33*/("""
	
	<div id="actions">
		<form action="" id="formSearchPlanillas" method="GET">
		 
		<div class="row">	
    		
			<div class="col-sm-2">
				<div class="form-group">
					<label for="nombre" class="control-label">Numero
					"""),_display_(Seq[Any](/*50.7*/inputText(formBuscador("numero"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*50.93*/("""
					</label>
				</div>
			</div>
			
			 
			
			<div class="col-sm-2 input-group">
				<label class="control-label">Fecha</label>
				<div>
				"""),_display_(Seq[Any](/*60.6*/inputText(formBuscador("fecha_desde"), 'class -> "form-control dateMask inputDateMascara", 'id -> "desde", 'placeholder -> "Desde"))),format.raw/*60.137*/("""
				"""),_display_(Seq[Any](/*61.6*/inputText(formBuscador("fecha_hasta"), 'class -> "form-control dateMask inputDateMascara", 'id -> "hasta", 'placeholder -> "Hasta"))),format.raw/*61.137*/("""
				</div>
				
			</div>
			
			<div class="col-sm-4">
			<label for="deposito" class="control-label">Institucion</label> 
			<div class="input-group">
				"""),_display_(Seq[Any](/*69.6*/inputText(formBuscador("deposito.nombre"),'class -> "form-control", 'id -> "deposito_nombre", 'autocomplete -> "off"))),format.raw/*69.123*/("""
				"""),_display_(Seq[Any](/*70.6*/inputText(formBuscador("deposito_id"),'hidden -> "hidden", 'id -> "deposito_id"))),format.raw/*70.86*/("""
				<span class="input-group-addon">
                	<a href="#" id="searchDeposito" data-title="Selección de Institucion" 
                	data-url=""""),_display_(Seq[Any](/*73.29*/controllers/*73.40*/.delegacion.routes.DepositosController.modalBuscar())),format.raw/*73.92*/("""" 
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
				<a href=""""),_display_(Seq[Any](/*92.15*/controllers/*92.26*/.recupero.routes.RecuperoPlanillasController.index())),format.raw/*92.78*/(""""  class="form-control btn btn-default">Limpiar</a>
				</div>
			</div>
		</div>
		 
		</form>
	</div>
	
	"""),_display_(Seq[Any](/*100.3*/if(buscador.getTotalRowCount == 0)/*100.37*/ {_display_(Seq[Any](format.raw/*100.39*/("""
        
        <div class="well">
            <em>No se encuentran Planillas</em>
        </div>
        
    """)))}/*106.7*/else/*106.12*/{_display_(Seq[Any](format.raw/*106.13*/("""
    	
		<table id="listaPlanillas" class="table table-striped table-bordered">
			<thead>
				<tr style="background: #FFFFFF;">
			        <td colspan="6">Mostrando """),_display_(Seq[Any](/*111.39*/buscador/*111.47*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*111.79*/(""" resultado(s). </td>
			    </tr>
				<tr>
					<th width="30"><input type="checkbox" name="checkAll" id="checkAll"/></th>
					<th width="30">#</th>
					<th width="80">Institucion</th>
					<th width="80">Numero</th>
					<th width="70">Fecha</th>
					<th width="300">Expediente</th>
					<th width="30">#</th>
				</tr>
			</thead>
			<tbody>
			"""),_display_(Seq[Any](/*124.5*/for(planilla <- buscador.getList) yield /*124.38*/ {_display_(Seq[Any](format.raw/*124.40*/("""
				
				<tr class="pointer" data-estado="" data-href=""""),_display_(Seq[Any](/*126.52*/controllers/*126.63*/.recupero.routes.RecuperoPlanillasController.ver(planilla.id))),format.raw/*126.124*/("""&"""),_display_(Seq[Any](/*126.126*/UriTrack/*126.134*/.encode())),format.raw/*126.143*/("""">
					<td><input type="checkbox" name="check_listado[]" value=""""),_display_(Seq[Any](/*127.64*/planilla/*127.72*/.id)),format.raw/*127.75*/("""" class="notSeleccion" id="check-"""),_display_(Seq[Any](/*127.109*/planilla/*127.117*/.id)),format.raw/*127.120*/(""""/></td>
					<td><a class="btn btn-default btn-xs notSeleccion" href=""""),_display_(Seq[Any](/*128.64*/controllers/*128.75*/.recupero.routes.RecuperoPlanillasController.editar(planilla.id))),format.raw/*128.139*/("""&"""),_display_(Seq[Any](/*128.141*/UriTrack/*128.149*/.encode())),format.raw/*128.158*/(""""><i class="glyphicon glyphicon-edit"></i></a></td>
					<td>"""),_display_(Seq[Any](/*129.11*/(planilla.deposito.nombre))),format.raw/*129.37*/("""</td>
					<td>"""),_display_(Seq[Any](/*130.11*/(planilla.numero))),format.raw/*130.28*/("""</td>
					<td class="fecha">"""),_display_(Seq[Any](/*131.25*/if(planilla.fecha != null)/*131.51*/{_display_(Seq[Any](_display_(Seq[Any](/*131.53*/(utils.DateUtils.formatDate(planilla.fecha))))))})),format.raw/*131.98*/("""</td>
					<td>"""),_display_(Seq[Any](/*132.11*/if(planilla.expediente != null)/*132.42*/{_display_(Seq[Any](_display_(Seq[Any](/*132.44*/(planilla.expediente.getExpedienteEjercicio())))))})),format.raw/*132.91*/("""</td>
				 
					<td>
						<a class="btn btn-default btn-xs delete-confirm-link notSeleccion" href=""""),_display_(Seq[Any](/*135.81*/controllers/*135.92*/.recupero.routes.RecuperoPlanillasController.eliminar(planilla.id))),format.raw/*135.158*/("""&"""),_display_(Seq[Any](/*135.160*/UriTrack/*135.168*/.encode())),format.raw/*135.177*/("""">
							<i class="glyphicon glyphicon-trash icono-eliminar"></i>
						</a>
					</td>
				</tr>
             """)))})),format.raw/*140.15*/("""
             
	        </tbody>
	        <tfoot>
		        <tr>
			        <td colspan="6">&nbsp</td>
			         
		        </tr>
	        </tfoot>
        </table>
    	
    	<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*152.8*/views/*152.13*/.html.helpers.paginador(buscador, controllers.recupero.routes.RecuperoPlanillasController.index()))),format.raw/*152.111*/("""
		</div>
<script>
$( function ()"""),format.raw/*155.15*/("""{"""),format.raw/*155.16*/("""
	var n = 0;
	var b = 0;
	var c = 0;
	 
	
	$( "#checkAll" ).click(function() """),format.raw/*161.36*/("""{"""),format.raw/*161.37*/("""
		
		  	selectAll();
	"""),format.raw/*164.2*/("""}"""),format.raw/*164.3*/(""");
	$( "input[name='check_listado[]']" ).click(function() """),format.raw/*165.56*/("""{"""),format.raw/*165.57*/("""
		selectTrList();
	"""),format.raw/*167.2*/("""}"""),format.raw/*167.3*/(""");
"""),format.raw/*168.1*/("""}"""),format.raw/*168.2*/(""");

function selectTrList()"""),format.raw/*170.24*/("""{"""),format.raw/*170.25*/("""
	var n = 0;
	var b = 0;
	var c = 0;
"""),format.raw/*174.1*/("""}"""),format.raw/*174.2*/("""

function selectAll()"""),format.raw/*176.21*/("""{"""),format.raw/*176.22*/("""
	var n = 0; 
	var b = 0; 
	var c = 0; 
	if($("#checkAll").prop("checked"))"""),format.raw/*180.36*/("""{"""),format.raw/*180.37*/("""
		$("input[name='check_listado[]']").prop( "checked", true );
		
	"""),format.raw/*183.2*/("""}"""),format.raw/*183.3*/("""else"""),format.raw/*183.7*/("""{"""),format.raw/*183.8*/("""
		$( "input[name='check_listado[]']").prop( "checked", false );
	"""),format.raw/*185.2*/("""}"""),format.raw/*185.3*/("""
	
	 
"""),format.raw/*188.1*/("""}"""),format.raw/*188.2*/("""

</script>		
 	 """)))})),format.raw/*191.5*/("""
""")))})))}
    }
    
    def render(buscador:utils.pagination.Pagination[models.recupero.RecuperoPlanilla],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[models.recupero.RecuperoPlanilla],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:35 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/recupero/recuperoPlanilla/indexPlanilla.scala.html
                    HASH: 4f30099e247f62f02290737bfbfd2be1a8b21388
                    MATRIX: 875->1|1106->228|1120->235|1204->239|1255->255|1269->261|1336->307|1403->158|1435->182|1510->101|1538->226|1565->343|1606->349|1619->354|1686->412|1726->414|2364->1016|2384->1027|2458->1079|2496->1081|2513->1089|2544->1098|2714->1233|2727->1238|2774->1263|3036->1490|3144->1576|3328->1725|3482->1856|3523->1862|3677->1993|3871->2152|4011->2269|4052->2275|4154->2355|4344->2509|4364->2520|4438->2572|5126->3224|5146->3235|5220->3287|5364->3395|5408->3429|5449->3431|5582->3546|5596->3551|5636->3552|5840->3719|5858->3727|5913->3759|6300->4110|6350->4143|6391->4145|6485->4202|6506->4213|6591->4274|6631->4276|6650->4284|6683->4293|6786->4359|6804->4367|6830->4370|6902->4404|6921->4412|6948->4415|7057->4487|7078->4498|7166->4562|7206->4564|7225->4572|7258->4581|7357->4643|7406->4669|7459->4685|7499->4702|7566->4732|7602->4758|7651->4760|7723->4805|7776->4821|7817->4852|7866->4854|7940->4901|8079->5003|8100->5014|8190->5080|8230->5082|8249->5090|8282->5099|8428->5212|8685->5433|8700->5438|8822->5536|8884->5569|8914->5570|9020->5647|9050->5648|9101->5671|9130->5672|9217->5730|9247->5731|9295->5751|9324->5752|9355->5755|9384->5756|9440->5783|9470->5784|9535->5821|9564->5822|9615->5844|9645->5845|9749->5920|9779->5921|9874->5988|9903->5989|9935->5993|9964->5994|10058->6060|10087->6061|10121->6067|10150->6068|10200->6086
                    LINES: 26->1|33->6|33->6|35->6|36->7|36->7|36->7|37->5|37->5|38->1|39->5|40->8|44->12|44->12|44->12|44->12|66->34|66->34|66->34|66->34|66->34|66->34|72->40|72->40|72->40|82->50|82->50|92->60|92->60|93->61|93->61|101->69|101->69|102->70|102->70|105->73|105->73|105->73|124->92|124->92|124->92|132->100|132->100|132->100|138->106|138->106|138->106|143->111|143->111|143->111|156->124|156->124|156->124|158->126|158->126|158->126|158->126|158->126|158->126|159->127|159->127|159->127|159->127|159->127|159->127|160->128|160->128|160->128|160->128|160->128|160->128|161->129|161->129|162->130|162->130|163->131|163->131|163->131|163->131|164->132|164->132|164->132|164->132|167->135|167->135|167->135|167->135|167->135|167->135|172->140|184->152|184->152|184->152|187->155|187->155|193->161|193->161|196->164|196->164|197->165|197->165|199->167|199->167|200->168|200->168|202->170|202->170|206->174|206->174|208->176|208->176|212->180|212->180|215->183|215->183|215->183|215->183|217->185|217->185|220->188|220->188|223->191
                    -- GENERATED --
                */
            