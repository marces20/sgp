
package views.html.compras.productos

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
object indexTipoProducto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[TipoProducto],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[TipoProducto], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.82*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.compras.mainCompras("Lista Tipo Productos")/*5.56*/ {_display_(Seq[Any](format.raw/*5.58*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Lista de Tipo de Productos</h1>
			</div>
	
			<div class="col-sm-2">
				<a href=""""),_display_(Seq[Any](/*14.15*/controllers/*14.26*/.compras.routes.TipoProductosController.indexTipoProducto())),format.raw/*14.85*/("""" class="btn btn-default">
					<i class="glyphicon glyphicon-list"></i>
				</a>
				<a href="#" class="btn btn-default">
					<i class="glyphicon glyphicon-align-justify"></i>
				</a>
			</div>
		</div>
		
	"""),_display_(Seq[Any](/*23.3*/if(flash.containsKey("success"))/*23.35*/ {_display_(Seq[Any](format.raw/*23.37*/("""
		<div class="alert alert-success"><i class="glyphicon glyphicon-ok-sign"></i> """),_display_(Seq[Any](/*24.81*/flash/*24.86*/.get("success"))),format.raw/*24.101*/("""</div>
	""")))})),format.raw/*25.3*/("""
	"""),_display_(Seq[Any](/*26.3*/if(flash.containsKey("error"))/*26.33*/ {_display_(Seq[Any](format.raw/*26.35*/("""
		<div class="alert alert-danger"><i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*27.84*/flash/*27.89*/.get("error"))),format.raw/*27.102*/("""</div>
	""")))})),format.raw/*28.3*/("""
		
	</div>
	<div id="actions">
		<div class="row">
			<form action="" method="GET">
				<div class="col-sm-3">
					<div class="form-group">
						<label for="nombre" class="control-label">Nombre
						"""),_display_(Seq[Any](/*37.8*/inputText(formBuscador("nombre"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*37.94*/("""
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
					<a href=""""),_display_(Seq[Any](/*50.16*/controllers/*50.27*/.compras.routes.TipoProductosController.indexTipoProducto())),format.raw/*50.86*/(""""  class="form-control btn btn-default">Limpiar</a>
					</div>
				</div>
			</form>
		</div>
	</div>
	
	<div class="row">
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*59.14*/controllers/*59.25*/.compras.routes.TipoProductosController.crearTipoProducto)),format.raw/*59.82*/(""""  class="form-control btn btn-default">Nuevo Tipo Producto</a>
		</div>
	</div>

	"""),_display_(Seq[Any](/*63.3*/if(buscador.getTotalRowCount == 0)/*63.37*/ {_display_(Seq[Any](format.raw/*63.39*/("""
        
        <div class="well">
            <em>No se encuentran Tipo Productos</em>
        </div>
        
    """)))}/*69.7*/else/*69.12*/{_display_(Seq[Any](format.raw/*69.13*/("""
    
		Mostrando """),_display_(Seq[Any](/*71.14*/buscador/*71.22*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*71.54*/(""" resultado(s). 
		
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th width="50">#</th>
					<th width="100">Código</th>
					<th width="300">Nombre</th>
					<th class="50">#</th>
				</tr>
			</thead>
			<tbody>
			"""),_display_(Seq[Any](/*83.5*/for(tipoProducto <- buscador.getList) yield /*83.42*/ {_display_(Seq[Any](format.raw/*83.44*/("""
				<tr>
					<td>
						<a href=""""),_display_(Seq[Any](/*86.17*/controllers/*86.28*/.compras.routes.TipoProductosController.editarTipoProducto(tipoProducto.id))),format.raw/*86.103*/("""">
							<i class="glyphicon glyphicon-edit"></i>
						</a>
					</td>
					<td>"""),_display_(Seq[Any](/*90.11*/(tipoProducto.id))),format.raw/*90.28*/("""</td>
					<td>"""),_display_(Seq[Any](/*91.11*/(tipoProducto.nombre))),format.raw/*91.32*/("""</td>
					<td>
						<a href=""""),_display_(Seq[Any](/*93.17*/controllers/*93.28*/.compras.routes.TipoProductosController.eliminarTipoProducto(tipoProducto.id))),format.raw/*93.105*/("""">
							<i class="glyphicon glyphicon-remove-circle"></i>
						</a>
					</td>
				</tr>
             """)))})),format.raw/*98.15*/("""
	        </tbody>
        </table>
        
        <div class="pagination pull-right">
		    """),_display_(Seq[Any](/*103.8*/views/*103.13*/.html.helpers.paginador(buscador, controllers.compras.routes.TipoProductosController.indexTipoProducto()))),format.raw/*103.118*/("""
		</div>
        </div>
 	 """)))})),format.raw/*106.5*/("""
""")))})),format.raw/*107.2*/("""
		"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[TipoProducto],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[TipoProducto],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:45 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/productos/indexTipoProducto.scala.html
                    HASH: 93e7c31f92ef952c105538680fca4e190f49be6c
                    MATRIX: 851->1|1033->100|1065->124|1139->81|1167->168|1205->172|1217->177|1274->226|1313->228|1517->396|1537->407|1618->466|1864->677|1905->709|1945->711|2062->792|2076->797|2114->812|2154->821|2192->824|2231->854|2271->856|2391->940|2405->945|2441->958|2481->967|2720->1171|2828->1257|3246->1639|3266->1650|3347->1709|3545->1871|3565->1882|3644->1939|3763->2023|3806->2057|3846->2059|3983->2179|3996->2184|4035->2185|4090->2204|4107->2212|4161->2244|4445->2493|4498->2530|4538->2532|4610->2568|4630->2579|4728->2654|4847->2737|4886->2754|4938->2770|4981->2791|5049->2823|5069->2834|5169->2911|5307->3017|5439->3113|5454->3118|5583->3223|5644->3252|5678->3254
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|42->14|42->14|42->14|51->23|51->23|51->23|52->24|52->24|52->24|53->25|54->26|54->26|54->26|55->27|55->27|55->27|56->28|65->37|65->37|78->50|78->50|78->50|87->59|87->59|87->59|91->63|91->63|91->63|97->69|97->69|97->69|99->71|99->71|99->71|111->83|111->83|111->83|114->86|114->86|114->86|118->90|118->90|119->91|119->91|121->93|121->93|121->93|126->98|131->103|131->103|131->103|134->106|135->107
                    -- GENERATED --
                */
            