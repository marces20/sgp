
package views.html.compras.clientes

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
object indexCliente extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[Cliente],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[Cliente], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.77*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.compras.mainCompras(title = "Gestión de clientes")/*5.63*/ {_display_(Seq[Any](format.raw/*5.65*/("""
 <div class="page-header">
	<div class="row">
		<div class="col-sm-9">
			<h1>Gestión de clientes</h1>
		</div>

		<div class="col-sm-3">
			<a href=""""),_display_(Seq[Any](/*13.14*/controllers/*13.25*/.compras.routes.ClientesController.crear())),format.raw/*13.67*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo cliente</a>
			<a href=""""),_display_(Seq[Any](/*14.14*/controllers/*14.25*/.compras.routes.ClientesController.index())),format.raw/*14.67*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a>
			<a href="#" class="btn btn-default"><i
				class="glyphicon glyphicon-align-justify"></i></a>
		</div>
	</div>
</div>

"""),_display_(Seq[Any](/*21.2*/if(flash.containsKey("success"))/*21.34*/ {_display_(Seq[Any](format.raw/*21.36*/("""
	<div class="alert alert-success"><i class="glyphicon glyphicon-ok-sign"></i> """),_display_(Seq[Any](/*22.80*/flash/*22.85*/.get("success"))),format.raw/*22.100*/("""</div>
""")))})),format.raw/*23.2*/("""
"""),_display_(Seq[Any](/*24.2*/if(flash.containsKey("error"))/*24.32*/ {_display_(Seq[Any](format.raw/*24.34*/("""
	<div class="alert alert-danger"><i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*25.83*/flash/*25.88*/.get("error"))),format.raw/*25.101*/("""</div>
""")))})),format.raw/*26.2*/(""" 
<form action="" method="GET">
	<div class="row">
		<div class="col-sm-3">
			<div class="form-group">
				<label for="nombre" class="control-label">Nombre
				"""),_display_(Seq[Any](/*32.6*/inputText(formBuscador("nombre"), 'class -> "form-control"))),format.raw/*32.65*/("""
				</label>
			</div>
		</div>
		
		<div class="col-sm-3">
			<div class="form-group">
				<label for="idPaciente" class="control-label">Id Paciente
				"""),_display_(Seq[Any](/*40.6*/inputText(formBuscador("idPaciente"), 'class -> "form-control"))),format.raw/*40.69*/("""
				</label>
			</div>
		</div>
		
		<div class="col-sm-3">
			<div class="form-group">
				<label for="idPaciente" class="control-label">DNI
				"""),_display_(Seq[Any](/*48.6*/inputText(formBuscador("dni"), 'class -> "form-control"))),format.raw/*48.62*/("""
				</label>
			</div>
		</div>
		
		<div class="col-sm-3">
			<div class="form-group">
				<label for="idPaciente" class="control-label">CUIT
				"""),_display_(Seq[Any](/*56.6*/inputText(formBuscador("cuit"), 'class -> "form-control"))),format.raw/*56.63*/("""
				</label>
			</div>
		</div>
	</div>		
	<div class="row">
		<div class="col-sm-3">
			<div class=" form-group">
				<label class="control-label">Tipo de cliente</label>
				"""),_display_(Seq[Any](/*65.6*/select(formBuscador("cliente_tipo_id"), ClienteTipo.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*65.168*/("""
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
			<a href=""""),_display_(Seq[Any](/*79.14*/controllers/*79.25*/.compras.routes.ClientesController.index())),format.raw/*79.67*/(""""  class="form-control btn btn-default">Limpiar</a>
			</div>
		</div>
	</div>		
</form>

	
   
"""),_display_(Seq[Any](/*87.2*/if(buscador.getTotalRowCount == 0)/*87.36*/ {_display_(Seq[Any](format.raw/*87.38*/("""
	<div class="well"><em>No se encuentran resultados</em></div>
""")))}/*89.3*/else/*89.8*/{_display_(Seq[Any](format.raw/*89.9*/("""

Mostrando """),_display_(Seq[Any](/*91.12*/buscador/*91.20*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*91.52*/(""" resultado(s).   
<table class="table table-striped table-bordered table-hover">
	<thead>
		<tr>
			<th width="50">#</th>
			<th width="">Nombre</th>
			<th width="">Pais</th>
			<th width="">Provincia</th>
			<th width="">Ciudad</th>
			<th>Obra Social</th>
			<th width="">CUIT</th>
			<th width="">DNI</th>
			<th width="">ID-PACIENTE</th>
			<th width="">Referencia</th>
			<th class="30">#</th>
		</tr>
	</thead>
	<tbody>
        """),_display_(Seq[Any](/*109.10*/for(cliente <- buscador.getList) yield /*109.42*/ {_display_(Seq[Any](format.raw/*109.44*/("""
		<tr class="pointer" data-href=""""),_display_(Seq[Any](/*110.35*/controllers/*110.46*/.compras.routes.ClientesController.ver(cliente.id))),format.raw/*110.96*/("""">
			<td class="notSeleccion"><a class="btn btn-default btn-xs notSeleccion" href=""""),_display_(Seq[Any](/*111.83*/controllers/*111.94*/.compras.routes.ClientesController.editar(cliente.id))),format.raw/*111.147*/(""""><i class="glyphicon glyphicon-edit"></i></a></td>
			<td>"""),_display_(Seq[Any](/*112.9*/(cliente.nombre))),format.raw/*112.25*/("""</td>
			"""),_display_(Seq[Any](/*113.5*/if(cliente.direcciones != null && cliente.direcciones.size() > 0)/*113.70*/ {_display_(Seq[Any](format.raw/*113.72*/("""
			
				"""),_display_(Seq[Any](/*115.6*/if(cliente.direcciones.size() > 0 && cliente.direcciones.get(0) != null)/*115.78*/{_display_(Seq[Any](format.raw/*115.79*/("""
				<td>"""),_display_(Seq[Any](/*116.10*/if(cliente.direcciones.get(0).localidad != null && cliente.direcciones.get(0).localidad.provincia != null && cliente.direcciones.get(0).localidad.provincia.pais != null)/*116.179*/{_display_(Seq[Any](_display_(Seq[Any](/*116.181*/(cliente.direcciones.get(0).localidad.provincia.pais.nombre)))))})),format.raw/*116.242*/("""</td>
				<td>"""),_display_(Seq[Any](/*117.10*/if(cliente.direcciones.get(0).localidad != null && cliente.direcciones.get(0).localidad.provincia != null)/*117.116*/{_display_(Seq[Any](_display_(Seq[Any](/*117.118*/(cliente.direcciones.get(0).localidad.provincia.nombre)))))})),format.raw/*117.174*/("""</td>
				<td>"""),_display_(Seq[Any](/*118.10*/if(cliente.direcciones.get(0).localidad != null)/*118.58*/{_display_(Seq[Any](_display_(Seq[Any](/*118.60*/(cliente.direcciones.get(0).localidad.nombre)))))})),format.raw/*118.106*/("""</td>
				""")))})),format.raw/*119.6*/("""
			
			""")))}/*121.5*/else/*121.9*/{_display_(Seq[Any](format.raw/*121.10*/("""
				<td>&nbsp</td>
				<td>&nbsp</td>
				<td>&nbsp</td>
			""")))})),format.raw/*125.5*/("""
			<td>
				"""),_display_(Seq[Any](/*127.6*/if(cliente.obrasocial != null)/*127.36*/{_display_(Seq[Any](format.raw/*127.37*/("""
					"""),_display_(Seq[Any](/*128.7*/(cliente.obrasocial.nombre))),format.raw/*128.34*/("""
				""")))})),format.raw/*129.6*/("""
			</td>
			<td>"""),_display_(Seq[Any](/*131.9*/(cliente.cuit2))),format.raw/*131.24*/("""</td>
			<td>"""),_display_(Seq[Any](/*132.9*/(cliente.dni))),format.raw/*132.22*/("""</td>
			<td>"""),_display_(Seq[Any](/*133.9*/(cliente.id_paciente_rismi))),format.raw/*133.36*/("""</td>
			<td>"""),_display_(Seq[Any](/*134.9*/(cliente.referencia))),format.raw/*134.29*/("""</td>
			<td class="notSeleccion"><a  class="btn btn-default btn-xs delete-confirm-link notSeleccion" href=""""),_display_(Seq[Any](/*135.104*/controllers/*135.115*/.compras.routes.ClientesController.eliminar(cliente.id))),format.raw/*135.170*/(""""><i class="glyphicon glyphicon-remove-circle"></i></a></td>
		</tr>
        """)))})),format.raw/*137.10*/("""
	</tbody>
</table>
		<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*141.8*/views/*141.13*/.html.helpers.paginador(buscador, controllers.compras.routes.ClientesController.index()))),format.raw/*141.101*/("""
		</div>

        
""")))})),format.raw/*145.2*/("""
	
	
	
	
	
	
	
	
	
	
	
	
	
	
""")))})))}
    }
    
    def render(buscador:utils.pagination.Pagination[Cliente],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[Cliente],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:42 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/clientes/indexCliente.scala.html
                    HASH: 4468d65394916bbaa559470cb508213c19353944
                    MATRIX: 840->1|1018->97|1050->121|1124->76|1153->165|1193->171|1205->176|1269->232|1308->234|1504->394|1524->405|1588->447|1729->552|1749->563|1813->605|2049->806|2090->838|2130->840|2247->921|2261->926|2299->941|2339->950|2377->953|2416->983|2456->985|2576->1069|2590->1074|2626->1087|2666->1096|2869->1264|2950->1323|3149->1487|3234->1550|3425->1706|3503->1762|3695->1919|3774->1976|3996->2163|4181->2325|4580->2688|4600->2699|4664->2741|4804->2846|4847->2880|4887->2882|4971->2949|4983->2954|5021->2955|5072->2970|5089->2978|5143->3010|5634->3464|5683->3496|5724->3498|5797->3534|5818->3545|5891->3595|6014->3681|6035->3692|6112->3745|6209->3806|6248->3822|6295->3833|6370->3898|6411->3900|6459->3912|6541->3984|6581->3985|6629->3996|6809->4165|6859->4167|6948->4228|7001->4244|7118->4350|7168->4352|7252->4408|7305->4424|7363->4472|7412->4474|7486->4520|7530->4532|7560->4543|7573->4547|7613->4548|7711->4614|7763->4630|7803->4660|7843->4661|7887->4669|7937->4696|7976->4703|8032->4723|8070->4738|8121->4753|8157->4766|8208->4781|8258->4808|8309->4823|8352->4843|8500->4953|8522->4964|8601->5019|8714->5099|8819->5168|8834->5173|8946->5261|9003->5286
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|41->13|41->13|41->13|42->14|42->14|42->14|49->21|49->21|49->21|50->22|50->22|50->22|51->23|52->24|52->24|52->24|53->25|53->25|53->25|54->26|60->32|60->32|68->40|68->40|76->48|76->48|84->56|84->56|93->65|93->65|107->79|107->79|107->79|115->87|115->87|115->87|117->89|117->89|117->89|119->91|119->91|119->91|137->109|137->109|137->109|138->110|138->110|138->110|139->111|139->111|139->111|140->112|140->112|141->113|141->113|141->113|143->115|143->115|143->115|144->116|144->116|144->116|144->116|145->117|145->117|145->117|145->117|146->118|146->118|146->118|146->118|147->119|149->121|149->121|149->121|153->125|155->127|155->127|155->127|156->128|156->128|157->129|159->131|159->131|160->132|160->132|161->133|161->133|162->134|162->134|163->135|163->135|163->135|165->137|169->141|169->141|169->141|173->145
                    -- GENERATED --
                */
            