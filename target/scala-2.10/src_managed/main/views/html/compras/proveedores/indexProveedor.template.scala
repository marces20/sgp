
package views.html.compras.proveedores

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
object indexProveedor extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[Proveedor],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[Proveedor], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.79*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.compras.mainCompras(title = "Lista de proveedores")/*5.64*/ {_display_(Seq[Any](format.raw/*5.66*/("""
    
<div class="page-header">
	<div class="row">
		<div class="col-sm-9">
			<h1>Lista de proveedores</h1>
		</div>

		<div class="col-sm-3">
			<a href=""""),_display_(Seq[Any](/*14.14*/controllers/*14.25*/.compras.routes.ProveedoresController.crear)),format.raw/*14.68*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo proveedor</a>
		</div>
	</div>
</div>

"""),_display_(Seq[Any](/*19.2*/if(flash.containsKey("success"))/*19.34*/ {_display_(Seq[Any](format.raw/*19.36*/("""
	<div class="alert alert-success"><i class="glyphicon glyphicon-ok-sign"></i> """),_display_(Seq[Any](/*20.80*/flash/*20.85*/.get("success"))),format.raw/*20.100*/("""</div>
""")))})),format.raw/*21.2*/("""
"""),_display_(Seq[Any](/*22.2*/if(flash.containsKey("error"))/*22.32*/ {_display_(Seq[Any](format.raw/*22.34*/("""
	<div class="alert alert-danger"><i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*23.83*/flash/*23.88*/.get("error"))),format.raw/*23.101*/("""</div>
""")))})),format.raw/*24.2*/(""" 


    <form action="" method="GET">
		<div class="row seccion">
			
				<div class="col-sm-2">
					<div class="form-group">
						<label for="nombre" class="control-label">Nombre
						"""),_display_(Seq[Any](/*33.8*/inputText(formBuscador("nombre"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*33.94*/("""
						</label>
					</div>
				</div>
				
				<div class="col-sm-2">
					<div class="form-group">
						<label for="nombre" class="control-label">Cuit
							"""),_display_(Seq[Any](/*41.9*/inputText(formBuscador("cuit"), 'class -> "form-control"))),format.raw/*41.66*/("""
						</label>
					</div>
				</div>

				
				<div class="col-sm-2">
					<label class="control-label">Tipo de proveedor
						"""),_display_(Seq[Any](/*49.8*/select(formBuscador("tipo"), options(Proveedor.TIPO_INTERNO ->"Agentes", Proveedor.TIPO_EXTERNO->"Proveedores", Proveedor.TIPO_AGENTE_INTERNO ->"Agentes contratados", Proveedor.TIPO_AGENTE_PLANTA->"Agentes en planta"), 'class -> "form-control select", '_default -> "Todos"))),format.raw/*49.281*/("""
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
					<a href=""""),_display_(Seq[Any](/*62.16*/controllers/*62.27*/.compras.routes.ProveedoresController.index())),format.raw/*62.72*/(""""  class="form-control btn btn-default">Limpiar</a>
					</div>
				</div>
			
		</div>
    </form>
    """),_display_(Seq[Any](/*68.6*/if(buscador.getTotalRowCount == 0)/*68.40*/ {_display_(Seq[Any](format.raw/*68.42*/("""
        
        <div class="well">
            <em>No se encuentran resultados</em>
        </div>
        
    """)))}/*74.7*/else/*74.12*/{_display_(Seq[Any](format.raw/*74.13*/("""
		Mostrando """),_display_(Seq[Any](/*75.14*/buscador/*75.22*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*75.54*/(""" resultado(s).   
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th width="50">#</th>
					<th>Nombre</th>
					<th width="110">Cuit</th>
					<th width="110">Agente</th>
					<th class="50">#</th>
				</tr>
			</thead>
			<tbody>
		        """),_display_(Seq[Any](/*87.12*/for(proveedor <- buscador.getList) yield /*87.46*/ {_display_(Seq[Any](format.raw/*87.48*/("""
				<tr class="pointer" data-href=""""),_display_(Seq[Any](/*88.37*/controllers/*88.48*/.compras.routes.ProveedoresController.ver(proveedor.id))),format.raw/*88.103*/("""">
					<td class="notSeleccion"><a class="btn btn-default btn-xs notSeleccion" href=""""),_display_(Seq[Any](/*89.85*/controllers/*89.96*/.compras.routes.ProveedoresController.editar(proveedor.id))),format.raw/*89.154*/(""""><i class="glyphicon glyphicon-edit"></i></a></td>
					<td>"""),_display_(Seq[Any](/*90.11*/(proveedor.nombre))),format.raw/*90.29*/("""</td>
					<td>"""),_display_(Seq[Any](/*91.11*/(proveedor.cuit))),format.raw/*91.27*/("""</td>
					<td>"""),_display_(Seq[Any](/*92.11*/if(proveedor.agente_id != null)/*92.42*/{_display_(Seq[Any](format.raw/*92.43*/("""Si""")))}/*92.47*/else/*92.52*/{_display_(Seq[Any](format.raw/*92.53*/("""No""")))})),format.raw/*92.56*/("""</td>
					<td class="notSeleccion"><a class="btn btn-default btn-xs delete-confirm-link notSeleccion"  href=""""),_display_(Seq[Any](/*93.106*/controllers/*93.117*/.compras.routes.ProveedoresController.eliminar(proveedor.id))),format.raw/*93.177*/(""""><i class="glyphicon glyphicon-remove-circle"></i></a></td>
				</tr>
		        """)))})),format.raw/*95.12*/("""
			</tbody>
		</table>
		<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*99.8*/views/*99.13*/.html.helpers.paginador(buscador, controllers.compras.routes.ProveedoresController.index()))),format.raw/*99.104*/("""
		</div>
	""")))})),format.raw/*101.3*/("""
""")))})))}
    }
    
    def render(buscador:utils.pagination.Pagination[Proveedor],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[Proveedor],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:46 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/proveedores/indexProveedor.scala.html
                    HASH: 9b27aafb5f1f9c5812151ab19d0fcdfb2401664e
                    MATRIX: 847->1|1027->99|1059->123|1133->78|1162->167|1202->173|1214->178|1279->235|1318->237|1520->403|1540->414|1605->457|1764->581|1805->613|1845->615|1962->696|1976->701|2014->716|2054->725|2092->728|2131->758|2171->760|2291->844|2305->849|2341->862|2381->871|2614->1069|2722->1155|2927->1325|3006->1382|3180->1521|3476->1794|3899->2181|3919->2192|3986->2237|4132->2348|4175->2382|4215->2384|4354->2506|4367->2511|4406->2512|4457->2527|4474->2535|4528->2567|4850->2853|4900->2887|4940->2889|5014->2927|5034->2938|5112->2993|5236->3081|5256->3092|5337->3150|5436->3213|5476->3231|5529->3248|5567->3264|5620->3281|5660->3312|5699->3313|5721->3317|5734->3322|5773->3323|5808->3326|5957->3438|5978->3449|6061->3509|6177->3593|6285->3666|6299->3671|6413->3762|6459->3776
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|42->14|42->14|42->14|47->19|47->19|47->19|48->20|48->20|48->20|49->21|50->22|50->22|50->22|51->23|51->23|51->23|52->24|61->33|61->33|69->41|69->41|77->49|77->49|90->62|90->62|90->62|96->68|96->68|96->68|102->74|102->74|102->74|103->75|103->75|103->75|115->87|115->87|115->87|116->88|116->88|116->88|117->89|117->89|117->89|118->90|118->90|119->91|119->91|120->92|120->92|120->92|120->92|120->92|120->92|120->92|121->93|121->93|121->93|123->95|127->99|127->99|127->99|129->101
                    -- GENERATED --
                */
            