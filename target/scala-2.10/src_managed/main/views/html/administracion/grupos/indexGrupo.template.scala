
package views.html.administracion.grupos

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
object indexGrupo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[Grupo],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[Grupo], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.75*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.administracion.mainAdministracion(title = "Lista de grupos")/*5.73*/ {_display_(Seq[Any](format.raw/*5.75*/("""
    
<div class="page-header">
	<div class="row">
		<div class="col-sm-9">
			<h1>Lista de grupos</h1>
		</div>
		<div class="col-sm-3">
		<a href=""""),_display_(Seq[Any](/*13.13*/controllers/*13.24*/.administracion.routes.GruposController.crear)),format.raw/*13.69*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo grupo</a>
			<a href=""""),_display_(Seq[Any](/*14.14*/controllers/*14.25*/.administracion.routes.GruposController.index())),format.raw/*14.72*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a>
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
				<label for="nombre" class="control-label">Nombre
				"""),_display_(Seq[Any](/*30.6*/inputText(formBuscador("nombre"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*30.92*/("""
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
			<a href=""""),_display_(Seq[Any](/*44.14*/controllers/*44.25*/.administracion.routes.GruposController.index())),format.raw/*44.72*/(""""  class="form-control btn btn-default">Limpiar</a>
			</div>
		</div>
</form>
</div>
    
    """),_display_(Seq[Any](/*50.6*/if(buscador.getTotalRowCount == 0)/*50.40*/ {_display_(Seq[Any](format.raw/*50.42*/("""
        
        <div class="well">
            <em>No se encuentran grupos</em>
        </div>
        
    """)))}/*56.7*/else/*56.12*/{_display_(Seq[Any](format.raw/*56.13*/("""
Mostrando """),_display_(Seq[Any](/*57.12*/buscador/*57.20*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*57.52*/(""" resultado(s).   
<table class="table table-striped table-bordered">
	<thead>
		<tr>
			<th width="50">#</th>
			<th width="100">Código</th>
			<th width="700">Nombre</th>
			<th class="50">#</th>
		</tr>
	</thead>
	<tbody>

        """),_display_(Seq[Any](/*69.10*/for(grupos <- buscador.getList) yield /*69.41*/ {_display_(Seq[Any](format.raw/*69.43*/("""
		<tr>
			<td><a
				href=""""),_display_(Seq[Any](/*72.12*/controllers/*72.23*/.administracion.routes.GruposController.editar(grupos.id))),format.raw/*72.80*/(""""><i
					class="glyphicon glyphicon-edit"></i></a></td>
			<td>"""),_display_(Seq[Any](/*74.9*/(grupos.id))),format.raw/*74.20*/("""</td>
			<td>"""),_display_(Seq[Any](/*75.9*/(grupos.nombre))),format.raw/*75.24*/("""</td>
			<td><a href=""""),_display_(Seq[Any](/*76.18*/controllers/*76.29*/.administracion.routes.GruposController.eliminar(grupos.id))),format.raw/*76.88*/(""""><i class="glyphicon glyphicon-remove-circle"></i></a></td>
		</tr>
                """)))})),format.raw/*78.18*/("""

            </tbody>
        </table>


		<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*85.8*/views/*85.13*/.html.helpers.paginador(buscador, controllers.administracion.routes.GruposController.index()))),format.raw/*85.106*/("""
		</div>
        
    """)))})),format.raw/*88.6*/("""
        
""")))})))}
    }
    
    def render(buscador:utils.pagination.Pagination[Grupo],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[Grupo],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/administracion/grupos/indexGrupo.scala.html
                    HASH: c8d4c40862682f8bbb8e732eea8ef8b5b236f2c0
                    MATRIX: 841->1|1017->95|1049->119|1123->74|1152->163|1192->169|1204->174|1278->240|1317->242|1511->400|1531->411|1598->456|1737->559|1757->570|1826->617|2066->822|2107->854|2147->856|2271->944|2285->949|2323->964|2367->977|2588->1163|2696->1249|3105->1622|3125->1633|3194->1680|3331->1782|3374->1816|3414->1818|3549->1936|3562->1941|3601->1942|3650->1955|3667->1963|3721->1995|4003->2241|4050->2272|4090->2274|4158->2306|4178->2317|4257->2374|4359->2441|4392->2452|4442->2467|4479->2482|4539->2506|4559->2517|4640->2576|4760->2664|4889->2758|4903->2763|5019->2856|5077->2883
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|41->13|41->13|41->13|42->14|42->14|42->14|49->21|49->21|49->21|50->22|50->22|50->22|51->23|58->30|58->30|72->44|72->44|72->44|78->50|78->50|78->50|84->56|84->56|84->56|85->57|85->57|85->57|97->69|97->69|97->69|100->72|100->72|100->72|102->74|102->74|103->75|103->75|104->76|104->76|104->76|106->78|113->85|113->85|113->85|116->88
                    -- GENERATED --
                */
            