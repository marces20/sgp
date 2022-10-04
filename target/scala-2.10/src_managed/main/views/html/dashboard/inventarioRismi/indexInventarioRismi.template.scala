
package views.html.dashboard.inventarioRismi

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
object indexInventarioRismi extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[utils.pagination.Pagination[InventarioRismi],DynamicForm,utils.pagination.PaginadorFicha,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[InventarioRismi], formBuscador: DynamicForm, paginadorFicha: utils.pagination.PaginadorFicha):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.134*/("""
"""),format.raw/*5.70*/("""

"""),_display_(Seq[Any](/*7.2*/views/*7.7*/.html.dashboard.mainDashboard("Lista de Inventario Rismi")/*7.65*/ {_display_(Seq[Any](format.raw/*7.67*/("""

<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Lista Inventario Rismi</h1>
			</div>
			
			<div class="col-sm-5">
				 
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*21.3*/views/*21.8*/.html.tags.successError())),format.raw/*21.33*/("""
	<div id="actions">
		<form action="" id="formSearchAutorizafos" method="GET">
			<div class="row">	
				<div class="col-sm-2">
					<div class="form-group">
						<label for="nombre" class="control-label">Producto
						"""),_display_(Seq[Any](/*28.8*/inputText(formBuscador("producto_inv"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*28.100*/("""
						</label>
					</div>
				</div>	
				<div class="col-sm-2">
					<div class="form-group">
						<label for="nombre" class="control-label">Responsable
						"""),_display_(Seq[Any](/*35.8*/inputText(formBuscador("responsable_inv"), 'class -> "form-control"))),format.raw/*35.76*/("""
						</label>
					</div>
				</div>	
				<div class="col-sm-2">
					<div class="form-group">
						<label for="nombre" class="control-label">Lugar
						"""),_display_(Seq[Any](/*42.8*/inputText(formBuscador("lugar_inv"), 'class -> "form-control"))),format.raw/*42.70*/("""
						</label>
					</div>
				</div>	
				<div class="col-sm-2">
					<div class="form-group">
						<label for="nombre" class="control-label">N° Inventario
						"""),_display_(Seq[Any](/*49.8*/inputText(formBuscador("numero_inventario"), 'class -> "form-control"))),format.raw/*49.78*/("""
						</label>
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
					<a href=""""),_display_(Seq[Any](/*65.16*/controllers/*65.27*/.dashboard.routes.InventarioRismiController.index())),format.raw/*65.78*/(""""  class="form-control btn btn-default">Limpiar</a>
					</div>
				</div>
			</div>
		</form>
	</div>
	
	"""),_display_(Seq[Any](/*72.3*/if(buscador.getTotalRowCount == 0)/*72.37*/ {_display_(Seq[Any](format.raw/*72.39*/("""
        
        <div class="well">
            <em>No se encuentran Inventario</em>
        </div>
        
    """)))}/*78.7*/else/*78.12*/{_display_(Seq[Any](format.raw/*78.13*/("""	
    
    	<table id=" " class="table table-striped table-bordered">
			<thead>
				 <tr style="background: #FFFFFF;">
			        <td colspan="9">Mostrando """),_display_(Seq[Any](/*83.39*/buscador/*83.47*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*83.79*/(""" resultado(s). </td>
			       
		        </tr>
				<tr>
					<th width="">CODIGO</th>
					<th width="">Nº INV</th>
					<th width="">PRODUCTO</th>
					<th width="">CONDICION DEL BIEN</th>
					<th width="">LUGAR</th>
					<th width="">RESPONSABLE</th>
					<th width="">DESCRIPCION DEL BIEN</th>
					<th width="">VALOR</th>
					<th width="">FECHA ALTA</th> 
				</tr>
			</thead>
			<tbody>
			"""),_display_(Seq[Any](/*99.5*/for(inv <- buscador.getList) yield /*99.33*/ {_display_(Seq[Any](format.raw/*99.35*/("""
				"""),_display_(Seq[Any](/*100.6*/paginadorFicha/*100.20*/.add(inv.id.toString))),format.raw/*100.41*/("""
				<tr>
					<td>"""),_display_(Seq[Any](/*102.11*/if(inv.codigo != null)/*102.33*/{_display_(Seq[Any](_display_(Seq[Any](/*102.35*/inv/*102.38*/.codigo))))})),format.raw/*102.46*/("""</td>
					<td>"""),_display_(Seq[Any](/*103.11*/if(inv.numero_inventario != null)/*103.44*/{_display_(Seq[Any](_display_(Seq[Any](/*103.46*/inv/*103.49*/.numero_inventario))))})),format.raw/*103.68*/("""</td>
					<td>"""),_display_(Seq[Any](/*104.11*/if(inv.producto_nombre != null)/*104.42*/{_display_(Seq[Any](_display_(Seq[Any](/*104.44*/inv/*104.47*/.producto_nombre))))})),format.raw/*104.64*/("""</td>
					<td>"""),_display_(Seq[Any](/*105.11*/if(inv.param_condicion_producto != null)/*105.51*/{_display_(Seq[Any](_display_(Seq[Any](/*105.53*/inv/*105.56*/.param_condicion_producto))))})),format.raw/*105.82*/("""</td>
					<td>"""),_display_(Seq[Any](/*106.11*/if(inv.lugar != null)/*106.32*/{_display_(Seq[Any](_display_(Seq[Any](/*106.34*/inv/*106.37*/.lugar))))})),format.raw/*106.44*/("""</td>
					<td>"""),_display_(Seq[Any](/*107.11*/if(inv.responsable != null)/*107.38*/{_display_(Seq[Any](_display_(Seq[Any](/*107.40*/inv/*107.43*/.responsable))))})),format.raw/*107.56*/("""</td>
					<td>"""),_display_(Seq[Any](/*108.11*/if(inv.precio != null)/*108.33*/{_display_(Seq[Any](_display_(Seq[Any](/*108.35*/(utils.NumberUtils.moneda(inv.precio))))))})),format.raw/*108.74*/("""</td>
					<td>"""),_display_(Seq[Any](/*109.11*/if(inv.descripcion != null)/*109.38*/{_display_(Seq[Any](_display_(Seq[Any](/*109.40*/inv/*109.43*/.descripcion))))})),format.raw/*109.56*/("""</td>
					<td>"""),_display_(Seq[Any](/*110.11*/if(inv.bi_producto_detalle_creado != null)/*110.53*/{_display_(Seq[Any](_display_(Seq[Any](/*110.55*/(utils.DateUtils.formatDate(inv.bi_producto_detalle_creado))))))})),format.raw/*110.116*/("""</td>
				</tr>
             """)))})),format.raw/*112.15*/("""
             """),_display_(Seq[Any](/*113.15*/paginadorFicha/*113.29*/.guardar())),format.raw/*113.39*/("""
	        </tbody>
	        <tfoot>
		        <tr>
			        <td colspan="9">&nbsp</td>
		        </tr>
	        </tfoot>
        </table>
    	
    	<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*123.8*/views/*123.13*/.html.helpers.paginador(buscador, controllers.dashboard.routes.InventarioRismiController.index()))),format.raw/*123.110*/("""
		</div>
<script>
""")))})),format.raw/*126.2*/("""
""")))})))}
    }
    
    def render(buscador:utils.pagination.Pagination[InventarioRismi],formBuscador:DynamicForm,paginadorFicha:utils.pagination.PaginadorFicha): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador,paginadorFicha)
    
    def f:((utils.pagination.Pagination[InventarioRismi],DynamicForm,utils.pagination.PaginadorFicha) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador,paginadorFicha) => apply(buscador,formBuscador,paginadorFicha)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:56 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/inventarioRismi/indexInventarioRismi.scala.html
                    HASH: 3b51e7f6f0a20e93c0c43beddc20d516b8b7333c
                    MATRIX: 897->1|1169->190|1201->214|1276->133|1304->258|1341->261|1353->266|1419->324|1458->326|1680->513|1693->518|1740->543|1998->766|2113->858|2312->1022|2402->1090|2595->1248|2679->1310|2880->1476|2972->1546|3428->1966|3448->1977|3521->2028|3663->2135|3706->2169|3746->2171|3879->2287|3892->2292|3931->2293|4125->2451|4142->2459|4196->2491|4631->2891|4675->2919|4715->2921|4757->2927|4781->2941|4825->2962|4882->2982|4914->3004|4963->3006|4976->3009|5011->3017|5064->3033|5107->3066|5156->3068|5169->3071|5215->3090|5268->3106|5309->3137|5358->3139|5371->3142|5415->3159|5468->3175|5518->3215|5567->3217|5580->3220|5633->3246|5686->3262|5717->3283|5766->3285|5779->3288|5813->3295|5866->3311|5903->3338|5952->3340|5965->3343|6005->3356|6058->3372|6090->3394|6139->3396|6205->3435|6258->3451|6295->3478|6344->3480|6357->3483|6397->3496|6450->3512|6502->3554|6551->3556|6640->3617|6703->3647|6755->3662|6779->3676|6812->3686|7042->3880|7057->3885|7178->3982|7230->4002
                    LINES: 26->1|33->5|33->5|34->1|35->5|37->7|37->7|37->7|37->7|51->21|51->21|51->21|58->28|58->28|65->35|65->35|72->42|72->42|79->49|79->49|95->65|95->65|95->65|102->72|102->72|102->72|108->78|108->78|108->78|113->83|113->83|113->83|129->99|129->99|129->99|130->100|130->100|130->100|132->102|132->102|132->102|132->102|132->102|133->103|133->103|133->103|133->103|133->103|134->104|134->104|134->104|134->104|134->104|135->105|135->105|135->105|135->105|135->105|136->106|136->106|136->106|136->106|136->106|137->107|137->107|137->107|137->107|137->107|138->108|138->108|138->108|138->108|139->109|139->109|139->109|139->109|139->109|140->110|140->110|140->110|140->110|142->112|143->113|143->113|143->113|153->123|153->123|153->123|156->126
                    -- GENERATED --
                */
            