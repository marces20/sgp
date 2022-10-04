
package views.html.administracion.usuarios

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
object indexUsuario extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[Usuario],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(paginator: utils.pagination.Pagination[Usuario], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.78*/("""
"""),format.raw/*3.70*/(""" 
"""),_display_(Seq[Any](/*4.2*/views/*4.7*/.html.administracion.mainAdministracion(title = "Lista de usuarios")/*4.75*/ {_display_(Seq[Any](format.raw/*4.77*/("""
    
<div class="page-header">
	<div class="row">
		<div class="col-sm-9">
			<h1>Lista de usuarios</h1>
		</div>

		<div class="pull-right">
			<a href=""""),_display_(Seq[Any](/*13.14*/controllers/*13.25*/.administracion.routes.UsuariosController.crear)),format.raw/*13.72*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo usuario</a>
			<a href=""""),_display_(Seq[Any](/*14.14*/controllers/*14.25*/.administracion.routes.UsuariosController.index())),format.raw/*14.74*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a>
			<a href="#" class="btn btn-default"><i
				class="glyphicon glyphicon-align-justify"></i></a>
		</div>
	</div>
</div>

    """),_display_(Seq[Any](/*21.6*/if(flash.containsKey("success"))/*21.38*/ {_display_(Seq[Any](format.raw/*21.40*/("""
        <div class="alert alert-success"><i class="glyphicon glyphicon-ok-sign"></i> """),_display_(Seq[Any](/*22.87*/flash/*22.92*/.get("success"))),format.raw/*22.107*/("""</div>
    """)))})),format.raw/*23.6*/(""" 
		<div class="row seccion">
			<form action="" method="GET">
				<div class="col-sm-3">
					<div class="form-group">
						<label class="control-label">Nombre
						"""),_display_(Seq[Any](/*29.8*/inputText(formBuscador("nombre"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*29.94*/("""
						</label>
					</div>
				</div>
				
				<div class="col-sm-2">
					<div class="form-group">
						<label class="control-label">Nick
						"""),_display_(Seq[Any](/*37.8*/inputText(formBuscador("nick"), 'class -> "form-control"))),format.raw/*37.65*/("""
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
					<a href=""""),_display_(Seq[Any](/*51.16*/controllers/*51.27*/.administracion.routes.UsuariosController.index())),format.raw/*51.76*/(""""  class="form-control btn btn-default">Limpiar</a>
					</div>
				</div>
			</form>
		</div>
    
    """),_display_(Seq[Any](/*57.6*/if(paginator.getTotalRowCount == 0)/*57.41*/ {_display_(Seq[Any](format.raw/*57.43*/("""
        
        <div class="well">
            <em>No se encuentran usuarios</em>
        </div>
        
    """)))}/*63.7*/else/*63.12*/{_display_(Seq[Any](format.raw/*63.13*/("""
		
		Mostrando """),_display_(Seq[Any](/*65.14*/paginator/*65.23*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*65.55*/(""" resultado(s).   
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th width="50">#</th>
					<th width="100">Código</th>
					<th width="700">Nombre</th>
					<th width="160">Nick</th>
					<th width="160">Departamento</th>
					<th class="50">#</th>
				</tr>
			</thead>
			<tbody>
		        """),_display_(Seq[Any](/*78.12*/for(usuario <- paginator.getList) yield /*78.45*/ {_display_(Seq[Any](format.raw/*78.47*/("""
				<tr>
					<td>
						<a href=""""),_display_(Seq[Any](/*81.17*/controllers/*81.28*/.administracion.routes.UsuariosController.editar(usuario.id))),format.raw/*81.88*/("""">
							<i class="glyphicon glyphicon-edit"></i>
						</a>
					</td>
					<td>"""),_display_(Seq[Any](/*85.11*/(usuario.id))),format.raw/*85.23*/("""</td>
					<td>"""),_display_(Seq[Any](/*86.11*/(usuario.nombre))),format.raw/*86.27*/("""</td>
					<td>"""),_display_(Seq[Any](/*87.11*/(usuario.nick))),format.raw/*87.25*/("""</td>
					<td>"""),_display_(Seq[Any](/*88.11*/if(usuario.departamento != null)/*88.43*/{_display_(Seq[Any](_display_(Seq[Any](/*88.45*/usuario/*88.52*/.departamento.nombre))))})),format.raw/*88.73*/("""</td>
					<td><a href=""""),_display_(Seq[Any](/*89.20*/controllers/*89.31*/.administracion.routes.UsuariosController.eliminar(usuario.id))),format.raw/*89.93*/(""""><i class="glyphicon glyphicon-remove-circle"></i></a></td>
				</tr>
              	""")))})),format.raw/*91.17*/("""
			</tbody>
		</table>
		
		<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*96.8*/views/*96.13*/.html.helpers.paginador(paginator, controllers.administracion.routes.UsuariosController.index()))),format.raw/*96.109*/("""
		</div>
        
    """)))})),format.raw/*99.6*/("""
        
""")))})))}
    }
    
    def render(paginator:utils.pagination.Pagination[Usuario],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(paginator,formBuscador)
    
    def f:((utils.pagination.Pagination[Usuario],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (paginator,formBuscador) => apply(paginator,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/administracion/usuarios/indexUsuario.scala.html
                    HASH: 2d13878ab846b6e23bc9eb876cc1c581e8944d6f
                    MATRIX: 847->1|1026->98|1058->122|1132->77|1161->166|1199->170|1211->175|1287->243|1326->245|1527->410|1547->421|1616->468|1757->573|1777->584|1848->633|2088->838|2129->870|2169->872|2293->960|2307->965|2345->980|2389->993|2599->1168|2707->1254|2898->1410|2977->1467|3414->1868|3434->1879|3505->1928|3651->2039|3695->2074|3735->2076|3872->2196|3885->2201|3924->2202|3979->2221|3997->2230|4051->2262|4425->2600|4474->2633|4514->2635|4589->2674|4609->2685|4691->2745|4814->2832|4848->2844|4901->2861|4939->2877|4992->2894|5028->2908|5081->2925|5122->2957|5170->2959|5186->2966|5233->2987|5295->3013|5315->3024|5399->3086|5520->3175|5632->3252|5646->3257|5765->3353|5823->3380
                    LINES: 26->1|29->3|29->3|30->1|31->3|32->4|32->4|32->4|32->4|41->13|41->13|41->13|42->14|42->14|42->14|49->21|49->21|49->21|50->22|50->22|50->22|51->23|57->29|57->29|65->37|65->37|79->51|79->51|79->51|85->57|85->57|85->57|91->63|91->63|91->63|93->65|93->65|93->65|106->78|106->78|106->78|109->81|109->81|109->81|113->85|113->85|114->86|114->86|115->87|115->87|116->88|116->88|116->88|116->88|116->88|117->89|117->89|117->89|119->91|124->96|124->96|124->96|127->99
                    -- GENERATED --
                */
            