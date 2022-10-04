
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
object verCliente extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Form[Cliente],Cliente,List[OrdenLineaCliente],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(provForm: Form[Cliente],proveedor:Cliente,olc:List[OrdenLineaCliente]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.73*/("""
"""),format.raw/*5.70*/(""" 
"""),_display_(Seq[Any](/*6.2*/views/*6.7*/.html.compras.mainCompras("Ver proveedor")/*6.49*/ {_display_(Seq[Any](format.raw/*6.51*/("""
<div class="page-header">
	<div class="row">
		<div class="col-sm-9">
			<h1>Ver cliente</h1>
		</div>
		

	</div>
</div>
<div class="row menu-acciones">
	<div class="col-sm-10">
		<a href=""""),_display_(Seq[Any](/*18.13*/controllers/*18.24*/.compras.routes.ClientesController.crear())),format.raw/*18.66*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo</a>
		<a href=""""),_display_(Seq[Any](/*19.13*/controllers/*19.24*/.compras.routes.ClientesController.editar(proveedor.id))),format.raw/*19.79*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-edit"></i> Editar</a>
		<a href=""""),_display_(Seq[Any](/*20.13*/controllers/*20.24*/.compras.routes.ClientesController.eliminar(proveedor.id))),format.raw/*20.81*/(""""  class="btn btn-default delete-confirm-link"><i class="glyphicon glyphicon-trash icono-eliminar"></i> Eliminar</a>
	</div>
	<div class="col-sm-2">
		<a href=""""),_display_(Seq[Any](/*23.13*/controllers/*23.24*/.compras.routes.ClientesController.index())),format.raw/*23.66*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a>
	</div>
</div>

	<div class="row">
		<div class="col-sm-4">
			<div class="form-group">
				<label class="control-label">Nombre del cliente</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*31.50*/provForm/*31.58*/.field("nombre").value)),format.raw/*31.80*/("""</p>
			</div>
		</div>
		
		<div class="col-sm-2">
			<div class="checkbox">
				<label for="activo" class="control-label"> """),_display_(Seq[Any](/*37.49*/checkbox(provForm("activo"), 'disabled -> "disabled"))),format.raw/*37.102*/(""" ¿cliente activo?</label>
			</div>
		</div>
		<div class="col-sm-4">
			<div class="form-group">
				<label class="control-label">Tipo de cliente</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*43.50*/provForm/*43.58*/.field("tipo.nombre").value)),format.raw/*43.85*/("""</p>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-3">
			<div class="form-group">
				<label class="control-label">CUIT</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*51.50*/provForm/*51.58*/.field("cuit2").value)),format.raw/*51.79*/("""</p>
			</div>
		</div>
		<div class="col-sm-3">
			<div class="form-group">
				<label class="control-label">DNI</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*57.50*/provForm/*57.58*/.field("dni").value)),format.raw/*57.77*/("""</p>
			</div>
		</div>
		<div class="col-sm-3">
			<div class="form-group">
				<label class="control-label">CIE</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*63.50*/provForm/*63.58*/.field("cie").value)),format.raw/*63.77*/("""</p>
			</div>
		</div>
		<div class="col-sm-3">
			<div class="form-group">
				<label class="control-label">Obra Social</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*69.50*/provForm/*69.58*/.field("obrasocial.nombre").value)),format.raw/*69.91*/("""</p>
			</div>
		</div>
	</div>
	<div class="row">
		 
		<div class="col-sm-3">
			<div class="form-group">
				<label class="control-label">ID Paciente</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*78.50*/provForm/*78.58*/.field("id_paciente_rismi").value)),format.raw/*78.91*/("""</p>
			</div>
		</div>
		<div class="col-sm-3">
			<div class="form-group">
				<label class="control-label">Referencia</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*84.50*/provForm/*84.58*/.field("referencia").value)),format.raw/*84.84*/("""</p>
			</div>
		</div>
		<div class="col-sm-3">
			<div class="form-group">
				<label class="control-label">Otra referencia</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*90.50*/provForm/*90.58*/.field("referencia_2").value)),format.raw/*90.86*/("""</p>
			</div>
		</div>
		<div class="col-sm-3">
			<div class="form-group">
				<label class="control-label">N° Afiliado</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*96.50*/provForm/*96.58*/.field("nafiliado").value)),format.raw/*96.83*/("""</p>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-2 form-group">
			<label for="sexo" class="control-label"> Sexo</label>
			<p class="form-control-static form-control">
			
				"""),_display_(Seq[Any](/*105.6*/proveedor/*105.15*/.sexo/*105.20*/ match/*105.26*/ {/*106.9*/case "M" =>/*106.20*/ {_display_(Seq[Any](format.raw/*106.22*/("""Masculino""")))}/*107.9*/case "F" =>/*107.20*/ {_display_(Seq[Any](format.raw/*107.22*/("""Femenino""")))}/*108.9*/case _ =>/*108.18*/ {}})),format.raw/*109.6*/("""
			</p>
		</div>
		<div class="col-sm-2">
			<div class="form-group">
				<label class="control-label">Fecha Nacimiento</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*115.50*/provForm("fnacimiento")/*115.73*/.value)),format.raw/*115.79*/("""</p>
			</div>
		</div>
	</div>
	<hr />
	<ul class="nav nav-tabs">
		<li class="active"><a href="#contenedorDirecciones" data-toggle="tab">Contactos del proveedor</a></li>
		<li><a href="#contenedorObservaciones" data-toggle="tab">Observaciones</a></li>
	</ul>
	
	<div class="tab-content">
		<div class="tab-pane active" id="contenedorDirecciones">
			"""),_display_(Seq[Any](/*127.5*/if(provForm("id").value != null)/*127.37*/{_display_(Seq[Any](format.raw/*127.38*/("""
				"""),_display_(Seq[Any](/*128.6*/views/*128.11*/.html.compras.clientes.contacto_cliente(provForm,true))),format.raw/*128.65*/(""" 
			""")))})),format.raw/*129.5*/("""
		</div>
		<div class="tab-pane" id="contenedorObservaciones">
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*132.49*/provForm/*132.57*/.field("observaciones").value)),format.raw/*132.86*/("""</p>
		</div>
		
	</div>
	<hr />
	"""),_display_(Seq[Any](/*137.3*/if(Permiso.check("verEstadosClientes"))/*137.42*/ {_display_(Seq[Any](format.raw/*137.44*/("""
	<ul class="nav nav-tabs">
		<li class="active"><a href="#contenedorEstadoPedido" data-toggle="tab">Estado Pedidos</a></li>
	</ul>
	
	<div class="tab-content">
		<div class="tab-pane active" id="contenedorEstadoPedido">
			"""),_display_(Seq[Any](/*144.5*/if(olc != null)/*144.20*/{_display_(Seq[Any](format.raw/*144.21*/("""
				"""),_display_(Seq[Any](/*145.6*/if(olc.size() > 0)/*145.24*/{_display_(Seq[Any](format.raw/*145.25*/("""
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Expediente</th>
								<th>Fecha Provision</th>
								<th>Proveedor</th>
								<th>Producto</th>
								<th>Cantidad</th>
								<th>Precio</th>
								<th>Total</th>
							</tr>
						</thead>
					"""),_display_(Seq[Any](/*158.7*/for(x <- olc) yield /*158.20*/{_display_(Seq[Any](format.raw/*158.21*/("""
						<tr>
							<td>"""),_display_(Seq[Any](/*160.13*/x/*160.14*/.ordenLinea.orden.expediente.getExpedienteEjercicio())),format.raw/*160.67*/("""</td>
							<td>"""),_display_(Seq[Any](/*161.13*/utils/*161.18*/.DateUtils.formatDate(x.ordenLinea.orden.fecha_provision))),format.raw/*161.75*/("""</td>
							<td>"""),_display_(Seq[Any](/*162.13*/x/*162.14*/.ordenLinea.orden.proveedor.nombre)),format.raw/*162.48*/("""</td>
							<td>"""),_display_(Seq[Any](/*163.13*/x/*163.14*/.ordenLinea.producto.nombre)),format.raw/*163.41*/("""</td>
							<td>"""),_display_(Seq[Any](/*164.13*/x/*164.14*/.cantidad)),format.raw/*164.23*/("""</td>
							<td>"""),_display_(Seq[Any](/*165.13*/utils/*165.18*/.NumberUtils.moneda(x.ordenLinea.precio))),format.raw/*165.58*/("""</td>
							<td>"""),_display_(Seq[Any](/*166.13*/(utils.NumberUtils.moneda(x.ordenLinea.precio.multiply(x.cantidad), 2)))),format.raw/*166.84*/("""</td>
						</tr>
					""")))})),format.raw/*168.7*/("""
					</table>
				""")))}/*170.6*/else/*170.10*/{_display_(Seq[Any](format.raw/*170.11*/("""
					<p class="">No existen pedidos aprobados para este paciente.</p>
				""")))})),format.raw/*172.6*/("""
			""")))}/*173.5*/else/*173.9*/{_display_(Seq[Any](format.raw/*173.10*/("""
				<p class="">No existen pedidos aprobados para este paciente.</p>
			""")))})),format.raw/*175.5*/("""
		</div>
	</div>	
	""")))})),format.raw/*178.3*/("""
""")))})),format.raw/*179.2*/("""	"""))}
    }
    
    def render(provForm:Form[Cliente],proveedor:Cliente,olc:List[OrdenLineaCliente]): play.api.templates.HtmlFormat.Appendable = apply(provForm,proveedor,olc)
    
    def f:((Form[Cliente],Cliente,List[OrdenLineaCliente]) => play.api.templates.HtmlFormat.Appendable) = (provForm,proveedor,olc) => apply(provForm,proveedor,olc)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:41 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/clientes/verCliente.scala.html
                    HASH: 0be023c50079e38047fc49427271f5b54a5644cf
                    MATRIX: 835->1|1049->133|1081->157|1155->72|1184->201|1222->205|1234->210|1284->252|1323->254|1563->458|1583->469|1647->511|1779->607|1799->618|1876->673|2004->765|2024->776|2103->833|2303->997|2323->1008|2387->1050|2699->1326|2716->1334|2760->1356|2928->1488|3004->1541|3250->1751|3267->1759|3316->1786|3559->1993|3576->2001|3619->2022|3832->2199|3849->2207|3890->2226|4103->2403|4120->2411|4161->2430|4382->2615|4399->2623|4454->2656|4709->2875|4726->2883|4781->2916|5001->3100|5018->3108|5066->3134|5291->3323|5308->3331|5358->3359|5579->3544|5596->3552|5643->3577|5889->3787|5908->3796|5923->3801|5939->3807|5950->3819|5971->3830|6012->3832|6041->3852|6062->3863|6103->3865|6131->3884|6150->3893|6176->3903|6397->4087|6430->4110|6459->4116|6860->4481|6902->4513|6942->4514|6985->4521|7000->4526|7077->4580|7116->4587|7268->4702|7286->4710|7338->4739|7414->4779|7463->4818|7504->4820|7772->5052|7797->5067|7837->5068|7880->5075|7908->5093|7948->5094|8301->5411|8331->5424|8371->5425|8434->5451|8445->5452|8521->5505|8577->5524|8592->5529|8672->5586|8728->5605|8739->5606|8796->5640|8852->5659|8863->5660|8913->5687|8969->5706|8980->5707|9012->5716|9068->5735|9083->5740|9146->5780|9202->5799|9296->5870|9354->5896|9395->5918|9409->5922|9449->5923|9559->6001|9584->6007|9597->6011|9637->6012|9745->6088|9801->6112|9836->6115
                    LINES: 26->1|33->5|33->5|34->1|35->5|36->6|36->6|36->6|36->6|48->18|48->18|48->18|49->19|49->19|49->19|50->20|50->20|50->20|53->23|53->23|53->23|61->31|61->31|61->31|67->37|67->37|73->43|73->43|73->43|81->51|81->51|81->51|87->57|87->57|87->57|93->63|93->63|93->63|99->69|99->69|99->69|108->78|108->78|108->78|114->84|114->84|114->84|120->90|120->90|120->90|126->96|126->96|126->96|135->105|135->105|135->105|135->105|135->106|135->106|135->106|135->107|135->107|135->107|135->108|135->108|135->109|141->115|141->115|141->115|153->127|153->127|153->127|154->128|154->128|154->128|155->129|158->132|158->132|158->132|163->137|163->137|163->137|170->144|170->144|170->144|171->145|171->145|171->145|184->158|184->158|184->158|186->160|186->160|186->160|187->161|187->161|187->161|188->162|188->162|188->162|189->163|189->163|189->163|190->164|190->164|190->164|191->165|191->165|191->165|192->166|192->166|194->168|196->170|196->170|196->170|198->172|199->173|199->173|199->173|201->175|204->178|205->179
                    -- GENERATED --
                */
            