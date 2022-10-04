
package views.html.dashboard.auditoria

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
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[Auditoria],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[Auditoria], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.79*/("""
"""),format.raw/*5.70*/("""



"""),_display_(Seq[Any](/*9.2*/views/*9.7*/.html.dashboard.mainDashboard("Auditoria")/*9.49*/ {_display_(Seq[Any](format.raw/*9.51*/("""
	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Auditoria</h1>
			</div>

		</div>
	</div>
	
	<div id="actions">
		<form action="" method="GET">

			<div class="row">

				<div class="col-sm-2">
					<label class="control-label"> 
						Tipo
						"""),_display_(Seq[Any](/*27.8*/select(formBuscador("tabla"), options(Auditoria.getTablas()), 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*27.130*/("""
					</label>
				</div>
				
				<div class="col-sm-3">
					<div class="form-group">
						<label for="inputPeriodo" class="control-label">Usuario</label> 
						<div class="input-group">
							
							"""),_display_(Seq[Any](/*36.9*/inputText(formBuscador("usuario.nombre"), 'name -> "usuario", 'class -> "form-control", 'id -> "usuario"))),format.raw/*36.114*/("""
							"""),_display_(Seq[Any](/*37.9*/inputText(formBuscador("usuario_id"), 'hidden -> "hidden", 'id -> "usuario_id"))),format.raw/*37.88*/("""
							<span class="input-group-addon">
							<a href="#" class="searchModal"
										id="searchPeriodo" 
										data-title="Selección de usuarios" 
										data-url=""""),_display_(Seq[Any](/*42.22*/controllers/*42.33*/.administracion.routes.UsuariosController.modalBuscar())),format.raw/*42.88*/("""" 
										data-height="650" 
										data-width="700" 
										data-listen="modal.seleccion.usuario.simple" 
										data-label="#usuario" 
										data-field="#usuario_id">
								<i class="glyphicon glyphicon-search"></i>
							</a>
							</span>
						</div>
					</div>
				</div>
				
				<div class="col-sm-3">
					<label class="control-label"> 
						Operación
						"""),_display_(Seq[Any](/*58.8*/select(formBuscador("operacion"),options("" -> "Todas", "U"->"Modificación","I"->"Creación","D"->"Eliminación"), 'class -> "form-control select"))),format.raw/*58.153*/("""
					</label>
				</div>
				
				<div class="col-sm-2 input-group">
					<label class="control-label">Fecha OP</label>
					<div>
						"""),_display_(Seq[Any](/*65.8*/inputText(formBuscador("fecha_desde"), 'class -> "form-control inputDateMascara", 'id -> "fecha_desde", 'placeholder -> "Desde"))),format.raw/*65.136*/("""
						"""),_display_(Seq[Any](/*66.8*/inputText(formBuscador("fecha_hasta"), 'class -> "form-control inputDateMascara", 'id -> "fecha_hasta", 'placeholder -> "Hasta"))),format.raw/*66.136*/("""
					</div>
				</div>
				
			</div>
			
			
			<div class="row">
					<div class="col-sm-2">
						<div class="form-group">
						<label for="nombre" class="control-label">&nbsp;</label>
						<button  class="form-control btn btn-primary"><i class="glyphicon glyphicon-search"></i> Buscar</button>
						</div>
					</div>
					<div class="col-sm-2">
						<div class="form-group">
						<label for="nombre" class="control-label">&nbsp;</label>
						<a href=""""),_display_(Seq[Any](/*83.17*/controllers/*83.28*/.dashboard.routes.AuditoriaController.index())),format.raw/*83.73*/(""""  class="form-control btn btn-default">Limpiar</a>
						</div>
					</div>
			</div>
			
			
		</form>
	</div>
	
	

	"""),_display_(Seq[Any](/*94.3*/if(buscador.getTotalRowCount == 0)/*94.37*/ {_display_(Seq[Any](format.raw/*94.39*/("""
        
        <div class="well">
            <em>No se encuentran registros</em>
        </div>
        
    """)))}/*100.7*/else/*100.12*/{_display_(Seq[Any](format.raw/*100.13*/("""
		
		Mostrando """),_display_(Seq[Any](/*102.14*/buscador/*102.22*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*102.54*/(""" resultado(s). 
		
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th width="40">id</th>
					<th width="40">Operación</th>
					<th width="40">Fecha</th>
					<th width="80">Tipo</th>
					<th width="40">ID</th>
					<th width="120">Usuario</th>
					<th width="30">Campo</th>
					<th>Valor antiguo</th>
					<th>Valor actual</th>
				</tr>
			</thead>
			<tbody>
			"""),_display_(Seq[Any](/*119.5*/for(a <- buscador.getList) yield /*119.31*/ {_display_(Seq[Any](format.raw/*119.33*/("""
				 
				<tr>
					<td>"""),_display_(Seq[Any](/*122.11*/a/*122.12*/.id)),format.raw/*122.15*/("""</td>
					<td>"""),_display_(Seq[Any](/*123.11*/a/*123.12*/.getOperacion())),format.raw/*123.27*/("""</td>
					<td>"""),_display_(Seq[Any](/*124.11*/DateUtils/*124.20*/.formatDate(a.fecha))),format.raw/*124.40*/("""</td>
					<td>"""),_display_(Seq[Any](/*125.11*/Auditoria/*125.20*/.getTablas().get(a.tabla))),format.raw/*125.45*/("""</td>
					<td>-"""),_display_(Seq[Any](/*126.12*/a/*126.13*/.id_objeto)),format.raw/*126.23*/("""-</td>
					<td>"""),_display_(Seq[Any](/*127.11*/if(a.usuario != null)/*127.32*/ {_display_(Seq[Any](format.raw/*127.34*/(""" """),_display_(Seq[Any](/*127.36*/a/*127.37*/.usuario.nombre))))})),format.raw/*127.53*/("""</td>
					<td>"""),_display_(Seq[Any](/*128.11*/a/*128.12*/.campo_actual)),format.raw/*128.25*/("""</td>
					<td>"""),_display_(Seq[Any](/*129.11*/a/*129.12*/.valor_antiguo)),format.raw/*129.26*/("""</td>
					<td>"""),_display_(Seq[Any](/*130.11*/a/*130.12*/.valor_actual)),format.raw/*130.25*/("""</td>
				</tr>
             """)))})),format.raw/*132.15*/("""
	        </tbody>
        </table>
		
		<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*137.8*/views/*137.13*/.html.helpers.paginador(buscador, controllers.dashboard.routes.AuditoriaController.index()))),format.raw/*137.104*/("""
		</div>
 	 """)))})),format.raw/*139.5*/("""


<script>
$( function() """),format.raw/*143.15*/("""{"""),format.raw/*143.16*/("""
	$('.searchModal').modalSearch();
	
"""),format.raw/*146.1*/("""}"""),format.raw/*146.2*/(""")
</script>
	
""")))})))}
    }
    
    def render(buscador:utils.pagination.Pagination[Auditoria],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[Auditoria],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:47 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/auditoria/index.scala.html
                    HASH: bed5f820a8a898b9821b87bc7637f33b8d3087ee
                    MATRIX: 838->1|1058->139|1090->163|1164->78|1193->207|1236->216|1248->221|1298->263|1337->265|1673->566|1818->688|2069->904|2197->1009|2242->1019|2343->1098|2561->1280|2581->1291|2658->1346|3099->1752|3267->1897|3448->2043|3599->2171|3643->2180|3794->2308|4311->2789|4331->2800|4398->2845|4564->2976|4607->3010|4647->3012|4786->3133|4800->3138|4840->3139|4896->3158|4914->3166|4969->3198|5423->3616|5466->3642|5507->3644|5573->3673|5584->3674|5610->3677|5664->3694|5675->3695|5713->3710|5767->3727|5786->3736|5829->3756|5883->3773|5902->3782|5950->3807|6005->3825|6016->3826|6049->3836|6104->3854|6135->3875|6176->3877|6215->3879|6226->3880|6269->3896|6323->3913|6334->3914|6370->3927|6424->3944|6435->3945|6472->3959|6526->3976|6537->3977|6573->3990|6638->4022|6763->4111|6778->4116|6893->4207|6941->4223|7000->4253|7030->4254|7098->4294|7127->4295
                    LINES: 26->1|33->5|33->5|34->1|35->5|39->9|39->9|39->9|39->9|57->27|57->27|66->36|66->36|67->37|67->37|72->42|72->42|72->42|88->58|88->58|95->65|95->65|96->66|96->66|113->83|113->83|113->83|124->94|124->94|124->94|130->100|130->100|130->100|132->102|132->102|132->102|149->119|149->119|149->119|152->122|152->122|152->122|153->123|153->123|153->123|154->124|154->124|154->124|155->125|155->125|155->125|156->126|156->126|156->126|157->127|157->127|157->127|157->127|157->127|157->127|158->128|158->128|158->128|159->129|159->129|159->129|160->130|160->130|160->130|162->132|167->137|167->137|167->137|169->139|173->143|173->143|176->146|176->146
                    -- GENERATED --
                */
            