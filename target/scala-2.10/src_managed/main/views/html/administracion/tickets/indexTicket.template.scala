
package views.html.administracion.tickets

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
object indexTicket extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[Ticket],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[Ticket], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};def /*8.2*/getClassEstado/*8.16*/(i:Estado) = {{
	var classEstado:String = new String()
	if(i != null && i.id == 97){
		classEstado = "borrador"
	}else if(i != null && i.id == 98){
		classEstado = "autorizado"
	}else if(i != null && i.id == 99){
		classEstado = "cancelado"
	}
	classEstado
	
}};
Seq[Any](format.raw/*1.76*/("""
"""),format.raw/*5.70*/("""


"""),format.raw/*19.2*/("""



"""),_display_(Seq[Any](/*23.2*/views/*23.7*/.html.administracion.mainTicket(title = "Lista de tickets")/*23.66*/ {_display_(Seq[Any](format.raw/*23.68*/("""

<div class="page-header">
	<div class="row">
		<div class="col-sm-9">
			<h1>Lista de tickets</h1>
		</div>
		<div class="col-sm-3">
		<a href=""""),_display_(Seq[Any](/*31.13*/controllers/*31.24*/.administracion.routes.TicketsController.crear())),format.raw/*31.72*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Abrir ticket</a>
		</div>
	</div>
</div>


"""),_display_(Seq[Any](/*37.2*/if(flash.containsKey("success"))/*37.34*/ {_display_(Seq[Any](format.raw/*37.36*/("""
    <div class="alert alert-success"><i class="glyphicon glyphicon-ok-sign"></i> """),_display_(Seq[Any](/*38.83*/flash/*38.88*/.get("success"))),format.raw/*38.103*/("""</div>
""")))})),format.raw/*39.2*/(""" 
        
<div class="row seccion">
	<form action="" method="GET">
		<div class="col-sm-3">
			<div class="form-group">
				<label for="nombre" class="control-label">Asunto
				"""),_display_(Seq[Any](/*46.6*/inputText(formBuscador("asunto"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*46.92*/("""
				</label>
			</div>
		</div>
		
		<div class="col-sm-3">
			<div class="form-group">
				<label for="nombre" class="control-label">Estado
				"""),_display_(Seq[Any](/*54.6*/select(formBuscador("estado"),options(
				"97" ->"Abierto",
				"98"->"Proceso",
				"99"->"Cerrado",
				"100"->"Cancelado"), 
				'class -> "form-control select"))),format.raw/*59.37*/("""
				</label>
			</div>
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
			<a href=""""),_display_(Seq[Any](/*73.14*/controllers/*73.25*/.administracion.routes.TicketsController.index())),format.raw/*73.73*/(""""  class="form-control btn btn-default">Limpiar</a>
			</div>
		</div>
</form>
</div>
    
    """),_display_(Seq[Any](/*79.6*/if(buscador.getTotalRowCount == 0)/*79.40*/ {_display_(Seq[Any](format.raw/*79.42*/("""
        
        <div class="well">
            <em>No se registran tickets</em>
        </div>
        
    """)))}/*85.7*/else/*85.12*/{_display_(Seq[Any](format.raw/*85.13*/("""
Mostrando """),_display_(Seq[Any](/*86.12*/buscador/*86.20*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*86.52*/(""" resultado(s).   
<table class="table table-striped table-bordered">
	<thead>
		<tr>
			<th width="50">#</th>
			<th width="50">Número</th>
			<th>Asunto</th>
			<th width="250">Usuario</th>
			<th width="100">Fecha</th>
			<th width="100">Fecha cierra</th>
			<th width="130">Prioridad</th>
			<th width="130">Estado</th>
		</tr>
	</thead>
	<tbody>

        """),_display_(Seq[Any](/*102.10*/for(ticket <- buscador.getList) yield /*102.41*/ {_display_(Seq[Any](format.raw/*102.43*/("""
		<tr class="pointer """),_display_(Seq[Any](/*103.23*/if(!ticket.leido && Usuario.getUsuarioSesion() == 1)/*103.75*/{_display_(Seq[Any](format.raw/*103.76*/(""" rojo """)))}/*103.84*/else/*103.89*/{_display_(Seq[Any](_display_(Seq[Any](/*103.91*/getClassEstado(ticket.estado)))))})),format.raw/*103.121*/("""" data-href=""""),_display_(Seq[Any](/*103.135*/controllers/*103.146*/.administracion.routes.TicketsController.ver(ticket.id))),format.raw/*103.201*/("""">
			<td class="notSeleccion" align="center">
				"""),_display_(Seq[Any](/*105.6*/if(Usuario.getUsuarioSesion() == 1)/*105.41*/ {_display_(Seq[Any](format.raw/*105.43*/("""
				<a class="btn btn-default btn-xs notSeleccion" href=""""),_display_(Seq[Any](/*106.59*/controllers/*106.70*/.administracion.routes.TicketsController.editar(ticket.id))),format.raw/*106.128*/("""&"""),_display_(Seq[Any](/*106.130*/UriTrack/*106.138*/.encode())),format.raw/*106.147*/("""">
					<i class="glyphicon glyphicon-edit"></i>
				</a><br>
				""")))})),format.raw/*109.6*/("""
			</td>
			<td>"""),_display_(Seq[Any](/*111.9*/ticket/*111.15*/.id)),format.raw/*111.18*/("""</td>
			<td>"""),_display_(Seq[Any](/*112.9*/(ticket.asunto))),format.raw/*112.24*/("""</td>
			<td>"""),_display_(Seq[Any](/*113.9*/ticket/*113.15*/.usuario.nombre)),format.raw/*113.30*/("""</td>
			<td>"""),_display_(Seq[Any](/*114.9*/utils/*114.14*/.DateUtils.formatDate(ticket.fecha))),format.raw/*114.49*/("""</td>
			<td>"""),_display_(Seq[Any](/*115.9*/if(ticket.fecha_cierre != null)/*115.40*/{_display_(Seq[Any](_display_(Seq[Any](/*115.42*/utils/*115.47*/.DateUtils.formatDate(ticket.fecha_cierre)))))})),format.raw/*115.90*/("""</td>
			<td>"""),_display_(Seq[Any](/*116.9*/(ticket.getPrioridad()))),format.raw/*116.32*/("""</td>
			<td>"""),_display_(Seq[Any](/*117.9*/(ticket.estado.nombre))),format.raw/*117.31*/("""</td>
		</tr>
        """)))})),format.raw/*119.10*/("""

            </tbody>
        </table>


		<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*126.8*/views/*126.13*/.html.helpers.paginador(buscador, controllers.administracion.routes.TicketsController.index()))),format.raw/*126.107*/("""
		</div>
        
    """)))})),format.raw/*129.6*/("""



""")))})))}
    }
    
    def render(buscador:utils.pagination.Pagination[Ticket],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[Ticket],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/administracion/tickets/indexTicket.scala.html
                    HASH: 8c54ef19168d6af20d176f0185e1ff1f3466f4b3
                    MATRIX: 844->1|1061->136|1093->160|1150->211|1172->225|1473->75|1502->204|1535->496|1579->505|1592->510|1660->569|1700->571|1891->726|1911->737|1981->785|2139->908|2180->940|2220->942|2340->1026|2354->1031|2392->1046|2432->1055|2653->1241|2761->1327|2951->1482|3143->1652|3552->2025|3572->2036|3642->2084|3779->2186|3822->2220|3862->2222|3997->2340|4010->2345|4049->2346|4098->2359|4115->2367|4169->2399|4582->2775|4630->2806|4671->2808|4732->2832|4794->2884|4834->2885|4861->2893|4875->2898|4924->2900|4982->2930|5034->2944|5056->2955|5135->3010|5225->3064|5270->3099|5311->3101|5408->3161|5429->3172|5511->3230|5551->3232|5570->3240|5603->3249|5705->3319|5761->3339|5777->3345|5803->3348|5854->3363|5892->3378|5943->3393|5959->3399|5997->3414|6048->3429|6063->3434|6121->3469|6172->3484|6213->3515|6262->3517|6277->3522|6347->3565|6398->3580|6444->3603|6495->3618|6540->3640|6598->3665|6728->3759|6743->3764|6861->3858|6920->3885
                    LINES: 26->1|33->5|33->5|33->8|33->8|45->1|46->5|49->19|53->23|53->23|53->23|53->23|61->31|61->31|61->31|67->37|67->37|67->37|68->38|68->38|68->38|69->39|76->46|76->46|84->54|89->59|103->73|103->73|103->73|109->79|109->79|109->79|115->85|115->85|115->85|116->86|116->86|116->86|132->102|132->102|132->102|133->103|133->103|133->103|133->103|133->103|133->103|133->103|133->103|133->103|133->103|135->105|135->105|135->105|136->106|136->106|136->106|136->106|136->106|136->106|139->109|141->111|141->111|141->111|142->112|142->112|143->113|143->113|143->113|144->114|144->114|144->114|145->115|145->115|145->115|145->115|145->115|146->116|146->116|147->117|147->117|149->119|156->126|156->126|156->126|159->129
                    -- GENERATED --
                */
            