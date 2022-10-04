
package views.html.presupuesto.creditoPresupuestario

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
object indexCreditoPresupuestario extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[CreditoPresupuestario],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[CreditoPresupuestario], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.91*/("""
"""),format.raw/*5.70*/(""" 

"""),_display_(Seq[Any](/*7.2*/views/*7.7*/.html.presupuesto.mainPresupuesto("Lista de Saldos Presupuestarios")/*7.75*/ {_display_(Seq[Any](format.raw/*7.77*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Lista de créditos presupuestarios</h1>
			</div>
			<div class="col-sm-5">
				<div class="dropdown pull-right btn-header">
				 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 	<i class="glyphicon glyphicon-list-alt"></i>
				    Reportes
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				    <li role="presentation"><a role="menuitem" id="reporteListadoCreditos" data-url=""""),_display_(Seq[Any](/*22.91*/controllers/*22.102*/.presupuesto.routes.CreditosPresupuestariosController.reporteListadoCreditos())),format.raw/*22.180*/("""" tabindex="-1" href="#">Listado Creditos</a></li>
				  </ul>
				</div>
			</div>
		</div>
	</div>
	<div id="actions">
		<div class="row">
			<form action="" method="GET">
				<div class="col-sm-3">
					<div class="form-group">
						<label for="nombre" class="control-label">Nombre
						"""),_display_(Seq[Any](/*34.8*/inputText(formBuscador("nombre"), 'class -> "form-control"))),format.raw/*34.67*/("""
						</label>
					</div>
				</div>
				<div class="col-sm-2">
				<label class="control-label">Ejercicio
					"""),_display_(Seq[Any](/*40.7*/select(formBuscador("ejercicio"), Ejercicio.getEjercicios().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*40.166*/("""
					</label>
				</div>
				<div class="col-sm-2">
					<div class="form-group">
					<label for="nombre" class="control-label">&nbsp;</label>
					<button  class="form-control btn btn-primary">Buscar</button>
					</div>
				</div>
				<div class="col-sm-2">
					<div class="form-group">
					<label for="nombre" class="control-label">&nbsp;</label>
					<a href=""""),_display_(Seq[Any](/*52.16*/controllers/*52.27*/.presupuesto.routes.CreditosPresupuestariosController.index())),format.raw/*52.88*/(""""  class="form-control btn btn-default">Limpiar</a>
					</div>
				</div>
			</form>
		</div>
	</div>
	"""),_display_(Seq[Any](/*58.3*/if(Permiso.check("crearCredito"))/*58.36*/ {_display_(Seq[Any](format.raw/*58.38*/("""  	  
	<div class="row">
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*61.14*/controllers/*61.25*/.presupuesto.routes.CreditosPresupuestariosController.crear)),format.raw/*61.84*/(""""  class="form-control btn btn-default">Nuevo crédito</a>
		</div>
	</div>
	""")))})),format.raw/*64.3*/("""
	"""),_display_(Seq[Any](/*65.3*/if(buscador.getTotalRowCount == 0)/*65.37*/ {_display_(Seq[Any](format.raw/*65.39*/("""
        
        <div class="well">
            <em>No se encuentran créditos</em>
        </div>
        
    """)))}/*71.7*/else/*71.12*/{_display_(Seq[Any](format.raw/*71.13*/("""
		
		Mostrando """),_display_(Seq[Any](/*73.14*/buscador/*73.22*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*73.54*/(""" resultado(s). 
		
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th width="30"><input type="checkbox" name="checkAll" id="checkAll"/></th>
					<th width="50">#</th>
					<th width="100">Código</th>
					<th width="500">Ley</th>
					<th width="30">Fecha</th>
					 
					<th width="">Ejercicio</th>
					<th width="">Total</th>
					<th width="">Total Recurso</th>
					<th width="">Estado</th>
					<th class="50">#</th>
				</tr>
			</thead>
			<tbody>
			"""),_display_(Seq[Any](/*92.5*/for(credito <- buscador.getList) yield /*92.37*/ {_display_(Seq[Any](format.raw/*92.39*/("""
				<tr class="pointer" data-href=""""),_display_(Seq[Any](/*93.37*/controllers/*93.48*/.presupuesto.routes.CreditosPresupuestariosController.ver(credito.id))),format.raw/*93.117*/("""">
					<td><input type="checkbox" name="check_listado[]" class="notSeleccion" value=""""),_display_(Seq[Any](/*94.85*/credito/*94.92*/.id)),format.raw/*94.95*/("""" id="check-"""),_display_(Seq[Any](/*94.108*/credito/*94.115*/.id)),format.raw/*94.118*/(""""/></td>
					<td>
						"""),_display_(Seq[Any](/*96.8*/if(Permiso.check("crearCredito"))/*96.41*/ {_display_(Seq[Any](format.raw/*96.43*/("""  
						<a class="btn btn-default btn-xs notSeleccion" href=""""),_display_(Seq[Any](/*97.61*/controllers/*97.72*/.presupuesto.routes.CreditosPresupuestariosController.editar(credito.id))),format.raw/*97.144*/("""">
							<i class="glyphicon glyphicon-edit"></i>
						</a>
						""")))})),format.raw/*100.8*/("""
					</td>
					<td>"""),_display_(Seq[Any](/*102.11*/(credito.id))),format.raw/*102.23*/("""</td>
					<td>"""),_display_(Seq[Any](/*103.11*/(credito.nombre))),format.raw/*103.27*/("""</td>
					<td>"""),_display_(Seq[Any](/*104.11*/(utils.DateUtils.formatDate(credito.fecha)))),format.raw/*104.54*/("""</td>
					 
					<td>"""),_display_(Seq[Any](/*106.11*/(credito.ejercicio.nombre))),format.raw/*106.37*/("""</td>
					<td align="center">"""),_display_(Seq[Any](/*107.26*/utils/*107.31*/.NumberUtils.moneda(credito.getTotal()))),format.raw/*107.70*/("""</td>
					<td align="center">"""),_display_(Seq[Any](/*108.26*/utils/*108.31*/.NumberUtils.moneda(credito.getTotalRecursos()))),format.raw/*108.78*/("""</td>
					<td>"""),_display_(Seq[Any](/*109.11*/(credito.estado))),format.raw/*109.27*/("""</td>
					
					<td>
						"""),_display_(Seq[Any](/*112.8*/if(Permiso.check("eliminarCredito"))/*112.44*/ {_display_(Seq[Any](format.raw/*112.46*/(""" 
						<a href=""""),_display_(Seq[Any](/*113.17*/controllers/*113.28*/.presupuesto.routes.CreditosPresupuestariosController.eliminar(credito.id))),format.raw/*113.102*/("""">
							<i class="glyphicon glyphicon-remove-circle"></i>
						</a>
						""")))})),format.raw/*116.8*/("""
					</td>
				</tr>
             """)))})),format.raw/*119.15*/("""
	        </tbody>
        </table>
		
		<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*124.8*/views/*124.13*/.html.helpers.paginador(buscador, controllers.presupuesto.routes.CreditosPresupuestariosController.index()))),format.raw/*124.120*/("""
		</div>
 	 """)))})),format.raw/*126.5*/("""
""")))})),format.raw/*127.2*/("""
<script>
$( function()"""),format.raw/*129.14*/("""{"""),format.raw/*129.15*/("""
$('#reporteListadoCreditos').click( function() """),format.raw/*130.48*/("""{"""),format.raw/*130.49*/(""" 
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');
		 
		dialogo.dialog("""),format.raw/*134.18*/("""{"""),format.raw/*134.19*/("""
			title: "Listado Creditos",
	    	resizable: false,
			autoOpen: true,
			modal: true,
			height: 250,
			width:750,
	        buttons: """),format.raw/*141.19*/("""{"""),format.raw/*141.20*/("""
		          Cerrar: function() """),format.raw/*142.32*/("""{"""),format.raw/*142.33*/("""
		            $( this ).dialog( "destroy" );
		          """),format.raw/*144.13*/("""}"""),format.raw/*144.14*/("""
		    """),format.raw/*145.7*/("""}"""),format.raw/*145.8*/(""",
	    	close: function(event, ui )"""),format.raw/*146.34*/("""{"""),format.raw/*146.35*/("""
	    		$(this).dialog( "destroy" );
	    	"""),format.raw/*148.7*/("""}"""),format.raw/*148.8*/(""",
		    open: function( event, ui ) """),format.raw/*149.35*/("""{"""),format.raw/*149.36*/("""
				$.post(url, getCheckSeleccionados(), function(data)"""),format.raw/*150.56*/("""{"""),format.raw/*150.57*/("""
					dialogo.html(data);
				"""),format.raw/*152.5*/("""}"""),format.raw/*152.6*/(""");	
		    """),format.raw/*153.7*/("""}"""),format.raw/*153.8*/("""
	    """),format.raw/*154.6*/("""}"""),format.raw/*154.7*/(""");
	"""),format.raw/*155.2*/("""}"""),format.raw/*155.3*/(""");
"""),format.raw/*156.1*/("""}"""),format.raw/*156.2*/(""");		

function getCheckSeleccionados()"""),format.raw/*158.33*/("""{"""),format.raw/*158.34*/("""
	return $("input[name='check_listado[]']").serialize();
"""),format.raw/*160.1*/("""}"""),format.raw/*160.2*/("""
</script>		
	
	"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[CreditoPresupuestario],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[CreditoPresupuestario],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:36 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/presupuesto/creditoPresupuestario/indexCreditoPresupuestario.scala.html
                    HASH: 316c6068591e153318f6368db6cd26433ff5e877
                    MATRIX: 885->1|1114->147|1146->171|1220->90|1248->215|1286->219|1298->224|1374->292|1413->294|2053->898|2074->909|2175->987|2503->1280|2584->1339|2734->1454|2916->1613|3321->1982|3341->1993|3424->2054|3564->2159|3606->2192|3646->2194|3745->2257|3765->2268|3846->2327|3954->2404|3992->2407|4035->2441|4075->2443|4206->2557|4219->2562|4258->2563|4311->2580|4328->2588|4382->2620|4910->3113|4958->3145|4998->3147|5071->3184|5091->3195|5183->3264|5306->3351|5322->3358|5347->3361|5397->3374|5414->3381|5440->3384|5501->3410|5543->3443|5583->3445|5682->3508|5702->3519|5797->3591|5898->3660|5957->3682|5992->3694|6045->3710|6084->3726|6137->3742|6203->3785|6263->3808|6312->3834|6380->3865|6395->3870|6457->3909|6525->3940|6540->3945|6610->3992|6663->4008|6702->4024|6767->4053|6813->4089|6854->4091|6909->4109|6930->4120|7028->4194|7138->4272|7207->4308|7327->4392|7342->4397|7473->4504|7519->4518|7553->4520|7605->4543|7635->4544|7712->4592|7742->4593|7866->4688|7896->4689|8063->4827|8093->4828|8154->4860|8184->4861|8271->4919|8301->4920|8336->4927|8365->4928|8429->4963|8459->4964|8530->5007|8559->5008|8624->5044|8654->5045|8739->5101|8769->5102|8827->5132|8856->5133|8894->5143|8923->5144|8957->5150|8986->5151|9018->5155|9047->5156|9078->5159|9107->5160|9174->5198|9204->5199|9289->5256|9318->5257
                    LINES: 26->1|33->5|33->5|34->1|35->5|37->7|37->7|37->7|37->7|52->22|52->22|52->22|64->34|64->34|70->40|70->40|82->52|82->52|82->52|88->58|88->58|88->58|91->61|91->61|91->61|94->64|95->65|95->65|95->65|101->71|101->71|101->71|103->73|103->73|103->73|122->92|122->92|122->92|123->93|123->93|123->93|124->94|124->94|124->94|124->94|124->94|124->94|126->96|126->96|126->96|127->97|127->97|127->97|130->100|132->102|132->102|133->103|133->103|134->104|134->104|136->106|136->106|137->107|137->107|137->107|138->108|138->108|138->108|139->109|139->109|142->112|142->112|142->112|143->113|143->113|143->113|146->116|149->119|154->124|154->124|154->124|156->126|157->127|159->129|159->129|160->130|160->130|164->134|164->134|171->141|171->141|172->142|172->142|174->144|174->144|175->145|175->145|176->146|176->146|178->148|178->148|179->149|179->149|180->150|180->150|182->152|182->152|183->153|183->153|184->154|184->154|185->155|185->155|186->156|186->156|188->158|188->158|190->160|190->160
                    -- GENERATED --
                */
            