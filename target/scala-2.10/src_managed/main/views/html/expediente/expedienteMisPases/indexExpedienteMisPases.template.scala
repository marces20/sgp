
package views.html.expediente.expedienteMisPases

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
object indexExpedienteMisPases extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[ExpedienteMiPase],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[ExpedienteMiPase], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

def /*6.2*/scripts/*6.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*6.13*/("""
	<script src=""""),_display_(Seq[Any](/*7.16*/routes/*7.22*/.Assets.at("javascripts/expediente/expediente.js"))),format.raw/*7.72*/("""" type="text/javascript"></script>
""")))};implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.86*/("""
"""),format.raw/*5.70*/(""" 
"""),format.raw/*8.2*/("""
"""),_display_(Seq[Any](/*9.2*/views/*9.7*/.html.expediente.mainExpediente("Lista de mis pases",scripts)/*9.68*/ {_display_(Seq[Any](format.raw/*9.70*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Lista de Mis Pases</h1>
			</div>
			<div class="col-sm-5">
				<div class="dropdown pull-right btn-header">
				 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 	<i class="glyphicon glyphicon-list-alt"></i>
				    Reportes
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				    <li role="presentation"><a role="menuitem" id="reporteMisPases" 
				    data-url=""""),_display_(Seq[Any](/*25.20*/controllers/*25.31*/.expediente.routes.ExpedientesReportesController.reportePaseExpedienteListaCodigoCombinado())),format.raw/*25.123*/("""" 
				    tabindex="-1" href="#">Reporte Combinar Pases</a></li>
				  </ul>
				</div>
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*33.3*/views/*33.8*/.html.tags.successError())),format.raw/*33.33*/("""
	<div id="actions">
		<form action="" method="GET">
			<div class="row">
				<div class="col-sm-2 input-group">
					<label class="control-label">Fecha Pase</label>
					<div>
						"""),_display_(Seq[Any](/*40.8*/inputText(formBuscador("fecha_desde"), 'class -> "form-control inputDateMascara", 'id -> "fecha_desde", 'placeholder -> "Desde"))),format.raw/*40.136*/("""
						"""),_display_(Seq[Any](/*41.8*/inputText(formBuscador("fecha_hasta"), 'class -> "form-control inputDateMascara", 'id -> "fecha_hasta", 'placeholder -> "Hasta"))),format.raw/*41.136*/("""
					</div>
				</div>
				<div class="col-sm-2 input-group">
					<label class="control-label"> 
						Servicio/depto
						"""),_display_(Seq[Any](/*47.8*/select(formBuscador("organigrama_id"), 
						Organigrama.find.where().eq("circuito_expediente", true).orderBy("nombre asc").findList().map{ p => p.id.toString -> p.nombre}, 'class -> 
						"form-control select", '_default -> "Seleccionar"))),format.raw/*49.57*/("""
					</label>
				</div>
			 	<div class="col-sm-2">
					<div class="form-group">
					<label for="nombre" class="control-label">&nbsp;</label>
					<button  class="form-control btn btn-primary"><i class="glyphicon glyphicon-search"></i>  Buscar</button>
					</div>
				</div>
				<div class="col-sm-2">
					<div class="form-group">
					<label for="nombre" class="control-label">&nbsp;</label>
					<a href=""""),_display_(Seq[Any](/*61.16*/controllers/*61.27*/.expediente.routes.ExpedientesMisPasesController.index())),format.raw/*61.83*/(""""  class="form-control btn btn-default">Limpiar</a>
					</div>
				</div>
			</div>
		</form>
	</div>
	
	"""),_display_(Seq[Any](/*68.3*/if(buscador.getTotalRowCount == 0)/*68.37*/ {_display_(Seq[Any](format.raw/*68.39*/("""
        
        <div class="well">
            <em>No se encuentran pases</em>
        </div>
        
    """)))}/*74.7*/else/*74.12*/{_display_(Seq[Any](format.raw/*74.13*/("""
    	Mostrando """),_display_(Seq[Any](/*75.17*/buscador/*75.25*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*75.57*/(""" resultado(s). 
		
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th width="30">
						<input type="checkbox" name="checkAll" id="checkAll"/>
					</th>
					<th>codigo</th>
					<th>Expediente</th>
					<th>Servicio/Depto.</th>
					<th>Fecha de pase</th>
					<th>Reporte Pase</th>
				</tr>
			</thead>
			<tbody>
			"""),_display_(Seq[Any](/*91.5*/for(emp <- buscador.getList) yield /*91.33*/ {_display_(Seq[Any](format.raw/*91.35*/("""
				<tr class="pointer" data-href="">
					<td><input type="checkbox" name="check_listado[]" class="notSeleccion" value=""""),_display_(Seq[Any](/*93.85*/emp/*93.88*/.codigo)),format.raw/*93.95*/("""" id="check-"""),_display_(Seq[Any](/*93.108*/emp/*93.111*/.codigo)),format.raw/*93.118*/(""""/></td>
					<td>"""),_display_(Seq[Any](/*94.11*/emp/*94.14*/.codigo)),format.raw/*94.21*/("""</td>
					<td>
						"""),_display_(Seq[Any](/*96.8*/for(sr <- emp.getExpedienteMiPases()) yield /*96.45*/{_display_(Seq[Any](format.raw/*96.46*/("""
							"""),_display_(Seq[Any](/*97.9*/sr/*97.11*/.getString("nombreExpediente"))),format.raw/*97.41*/(""" <br>
						""")))})),format.raw/*98.8*/("""
					</td>
					<td>"""),_display_(Seq[Any](/*100.11*/emp/*100.14*/.organigrama.nombre)),format.raw/*100.33*/("""</td>
					<td>"""),_display_(Seq[Any](/*101.11*/utils/*101.16*/.DateUtils.formatDate(emp.fecha_llegada,"dd/MM/yyyy HH:mm:ss"))),format.raw/*101.78*/("""</td>
					<td>
						"""),_display_(Seq[Any](/*103.8*/if(emp.codigo != null)/*103.30*/{_display_(Seq[Any](format.raw/*103.31*/("""
						<i class="glyphicon glyphicon-save"></i>  
							<a role="menuitem" 
							   class="reportePaseExpedienteListadoCodigo" 
							   data-url=""""),_display_(Seq[Any](/*107.22*/controllers/*107.33*/.expediente.routes.ExpedientesReportesController.reportePaseExpedienteListaCodigo(emp.codigo))),format.raw/*107.126*/("""" 
							   tabindex="-1" href="#">Reporte Pase Expediente</a>
						""")))})),format.raw/*109.8*/("""	   
					</td>
				</tr>		
			
			 """)))})),format.raw/*113.6*/("""
             
	        </tbody>
        </table>

		<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*119.8*/views/*119.13*/.html.helpers.paginador(buscador, controllers.expediente.routes.ExpedientesMisPasesController.index()))),format.raw/*119.115*/("""
		</div>
 	 """)))})),format.raw/*121.5*/("""
 <script>
$( function ()"""),format.raw/*123.15*/("""{"""),format.raw/*123.16*/("""
	
	$('#reporteMisPases').click( function() """),format.raw/*125.42*/("""{"""),format.raw/*125.43*/(""" //abrir modal para mostrar mensaje informe rentas
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog("""),format.raw/*129.18*/("""{"""),format.raw/*129.19*/("""
			title: "Pase Expedientes",
	    	resizable: false,
			autoOpen: true,
			modal: true,
			height: 250,
			width:750,
	        buttons: """),format.raw/*136.19*/("""{"""),format.raw/*136.20*/("""
		          Cerrar: function() """),format.raw/*137.32*/("""{"""),format.raw/*137.33*/("""
		            $( this ).dialog( "destroy" );
		          """),format.raw/*139.13*/("""}"""),format.raw/*139.14*/("""
		    """),format.raw/*140.7*/("""}"""),format.raw/*140.8*/(""",
	    	close: function(event, ui )"""),format.raw/*141.34*/("""{"""),format.raw/*141.35*/("""
	    		$(this).dialog( "destroy" );
	    	"""),format.raw/*143.7*/("""}"""),format.raw/*143.8*/(""",
		    open: function( event, ui ) """),format.raw/*144.35*/("""{"""),format.raw/*144.36*/("""
				$.post(url, getCheckSeleccionados(), function(data)"""),format.raw/*145.56*/("""{"""),format.raw/*145.57*/("""
					dialogo.html(data);
				"""),format.raw/*147.5*/("""}"""),format.raw/*147.6*/(""");	
		    """),format.raw/*148.7*/("""}"""),format.raw/*148.8*/("""
	    """),format.raw/*149.6*/("""}"""),format.raw/*149.7*/(""");
	"""),format.raw/*150.2*/("""}"""),format.raw/*150.3*/(""");
"""),format.raw/*151.1*/("""}"""),format.raw/*151.2*/(""")
function getCheckSeleccionados()"""),format.raw/*152.33*/("""{"""),format.raw/*152.34*/("""
	return $("input[name='check_listado[]']").serialize();
"""),format.raw/*154.1*/("""}"""),format.raw/*154.2*/("""
</script>
""")))})))}
    }
    
    def render(buscador:utils.pagination.Pagination[ExpedienteMiPase],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[ExpedienteMiPase],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:36 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/expediente/expedienteMisPases/indexExpedienteMisPases.scala.html
                    HASH: d2a290eb1fa963809a070a13e33eee141c533503
                    MATRIX: 873->1|1088->213|1102->220|1186->224|1237->240|1251->246|1322->296|1389->142|1421->166|1495->85|1523->210|1551->332|1587->334|1599->339|1668->400|1707->402|2334->993|2354->1004|2469->1096|2624->1216|2637->1221|2684->1246|2903->1430|3054->1558|3097->1566|3248->1694|3410->1821|3673->2062|4123->2476|4143->2487|4221->2543|4363->2650|4406->2684|4446->2686|4574->2797|4587->2802|4626->2803|4679->2820|4696->2828|4750->2860|5138->3213|5182->3241|5222->3243|5381->3366|5393->3369|5422->3376|5472->3389|5485->3392|5515->3399|5570->3418|5582->3421|5611->3428|5669->3451|5722->3488|5761->3489|5805->3498|5816->3500|5868->3530|5912->3543|5971->3565|5984->3568|6026->3587|6079->3603|6094->3608|6179->3670|6238->3693|6270->3715|6310->3716|6499->3868|6520->3879|6637->3972|6740->4043|6809->4080|6941->4176|6956->4181|7082->4283|7128->4297|7182->4322|7212->4323|7285->4367|7315->4368|7485->4509|7515->4510|7682->4648|7712->4649|7773->4681|7803->4682|7890->4740|7920->4741|7955->4748|7984->4749|8048->4784|8078->4785|8149->4828|8178->4829|8243->4865|8273->4866|8358->4922|8388->4923|8446->4953|8475->4954|8513->4964|8542->4965|8576->4971|8605->4972|8637->4976|8666->4977|8697->4980|8726->4981|8789->5015|8819->5016|8904->5073|8933->5074
                    LINES: 26->1|33->6|33->6|35->6|36->7|36->7|36->7|37->5|37->5|38->1|39->5|40->8|41->9|41->9|41->9|41->9|57->25|57->25|57->25|65->33|65->33|65->33|72->40|72->40|73->41|73->41|79->47|81->49|93->61|93->61|93->61|100->68|100->68|100->68|106->74|106->74|106->74|107->75|107->75|107->75|123->91|123->91|123->91|125->93|125->93|125->93|125->93|125->93|125->93|126->94|126->94|126->94|128->96|128->96|128->96|129->97|129->97|129->97|130->98|132->100|132->100|132->100|133->101|133->101|133->101|135->103|135->103|135->103|139->107|139->107|139->107|141->109|145->113|151->119|151->119|151->119|153->121|155->123|155->123|157->125|157->125|161->129|161->129|168->136|168->136|169->137|169->137|171->139|171->139|172->140|172->140|173->141|173->141|175->143|175->143|176->144|176->144|177->145|177->145|179->147|179->147|180->148|180->148|181->149|181->149|182->150|182->150|183->151|183->151|184->152|184->152|186->154|186->154
                    -- GENERATED --
                */
            