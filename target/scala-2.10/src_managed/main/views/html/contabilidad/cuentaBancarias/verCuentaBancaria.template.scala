
package views.html.contabilidad.cuentaBancarias

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
object verCuentaBancaria extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[CuentaBancaria],CuentaBancaria,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(cuentaBancariaForm: Form[CuentaBancaria],c: CuentaBancaria):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.62*/("""
"""),format.raw/*3.70*/("""

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.contabilidad.mainContabilidad("Ver cuenta bancaria")/*5.65*/ {_display_(Seq[Any](format.raw/*5.67*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Vista de cuenta bancaria</h1>
			</div>
			<div class="col-sm-5">
				<div class="dropdown pull-right">
				 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 	<i class="glyphicon glyphicon-list-alt"></i>
				    Reportes
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				    
				  </ul>
				</div>
				
				<div class="dropdown pull-right btn-header">
				 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 	<i class="glyphicon glyphicon-cog"></i>
				    Acciones
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				  	
				  </ul>
				</div>
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*38.3*/views/*38.8*/.html.tags.successError())),format.raw/*38.33*/("""
	
	<div class="row menu-acciones">
		<div class="col-sm-10">
			<a href=""""),_display_(Seq[Any](/*42.14*/controllers/*42.25*/.contabilidad.routes.CuentaBancariasController.crearCuentaBancaria())),format.raw/*42.93*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo</a>
			<a href=""""),_display_(Seq[Any](/*43.14*/controllers/*43.25*/.contabilidad.routes.CuentaBancariasController.editarCuentaBancaria(c.id))),format.raw/*43.98*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-edit"></i> Editar</a>
			<a href=""""),_display_(Seq[Any](/*44.14*/controllers/*44.25*/.contabilidad.routes.CuentaBancariasController.eliminarCuentaBancaria(c.id))),format.raw/*44.100*/(""""  class="btn btn-default delete-confirm-link"><i class="glyphicon glyphicon-trash icono-eliminar"></i> Eliminar</a>
		</div>
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*47.14*/controllers/*47.25*/.contabilidad.routes.CuentaBancariasController.indexCuentaBancaria())),format.raw/*47.93*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a>
		</div>
	</div>
	
	<div class="row">
		<div class="col-sm-4">
			<label class="control-label">Proveedor</label> 
			<p class="form-control-static form-control" style="height: 25px; overflow: hidden;">
				<a href="#" class="infoProveedor" data-url=""""),_display_(Seq[Any](/*55.50*/controllers/*55.61*/.compras.routes.ProveedoresAccionesController.modalInformacionProveedor(c.proveedor.id))),format.raw/*55.148*/("""">
						"""),_display_(Seq[Any](/*56.8*/cuentaBancariaForm("proveedor.nombre")/*56.46*/.value)),format.raw/*56.52*/("""
				</a>
			</p>
		</div>
		<div class="col-sm-4">
			<label class="control-label">Numero Cuenta</label> 
			<p class="form-control-static form-control" style="height: 25px; overflow: hidden;">
				"""),_display_(Seq[Any](/*63.6*/cuentaBancariaForm("numero_cuenta")/*63.41*/.value)),format.raw/*63.47*/("""
			</p>
		</div>
		<div class="col-sm-4">
			<label class="control-label">CBU</label> 
			<p class="form-control-static form-control" style="height: 25px; overflow: hidden;">
				"""),_display_(Seq[Any](/*69.6*/cuentaBancariaForm("cbu")/*69.31*/.value)),format.raw/*69.37*/("""
			</p>
		</div>
	</div>	
	<div class="row contenedorUbicacion">
		<div class="col-sm-4">
			<div class="seleccionBanco form-group """),_display_(Seq[Any](/*75.43*/if(cuentaBancariaForm.error("banco_id") != null)/*75.91*/ {_display_(Seq[Any](format.raw/*75.93*/("""has-error""")))}/*75.103*/else/*75.107*/{_display_(Seq[Any](format.raw/*75.108*/("""has-required""")))})),format.raw/*75.121*/("""">
				<label for=""""),_display_(Seq[Any](/*76.18*/cuentaBancariaForm("banco_id")/*76.48*/.id)),format.raw/*76.51*/("""" class="control-label">Banco</label>
				"""),_display_(Seq[Any](/*77.6*/select(cuentaBancariaForm("banco_id"), Banco.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar",'disabled -> "disabled"))),format.raw/*77.185*/("""
			</div>
		</div>
		<div class="col-sm-4">
			<div class="seleccionSucursal form-group """),_display_(Seq[Any](/*81.46*/if(cuentaBancariaForm.error("sucursal_banco_id") != null)/*81.103*/ {_display_(Seq[Any](format.raw/*81.105*/("""has-error""")))}/*81.115*/else/*81.119*/{_display_(Seq[Any](format.raw/*81.120*/("""has-required""")))})),format.raw/*81.133*/("""">
				<label for=""""),_display_(Seq[Any](/*82.18*/cuentaBancariaForm("sucursal_banco_id")/*82.57*/.id)),format.raw/*82.60*/("""" class="control-label">Sucursal</label>
				"""),_display_(Seq[Any](/*83.6*/select(cuentaBancariaForm("sucursal_banco_id"), 
					cuentaBancariaForm("banco_id").value match {
						case null => {options()}
						case v if v.matches("\\d+") => {SucursalBanco.getSucursales(v.toInt).map { p => p.id.toString -> p.nombre}}
						case _ => {options()}
					}, 
				'class -> "form-control select", '_default -> "Seleccionar",'disabled -> "disabled"))),format.raw/*89.89*/("""
			</div>
		</div>
		<div class="col-sm-2">
			<div class="checkbox">
				<label class="control-label"> 
					Predeterminada
					"""),_display_(Seq[Any](/*96.7*/checkbox(cuentaBancariaForm("predeterminada"),'disabled -> "disabled"))),format.raw/*96.77*/("""
				</label>
			</div>
		</div>
	</div>
	<h4>Estado actual: 	<b>"""),_display_(Seq[Any](/*101.26*/c/*101.27*/.estado.nombre)),format.raw/*101.41*/("""</b></h4>
	
	<div class="row margin-bottom-25">	
		"""),_display_(Seq[Any](/*104.4*/for(estado <- models.Estado.getSiguienteEstadoPorAprobar(c.estado.orden,models.Estado.TIPO_CUENTA_BANCARIA)) yield /*104.112*/ {_display_(Seq[Any](format.raw/*104.114*/("""	
			"""),_display_(Seq[Any](/*105.5*/if(estado.orden <= 3)/*105.26*/ {_display_(Seq[Any](format.raw/*105.28*/("""
				<div class="col-sm-3">
					<a href=""""),_display_(Seq[Any](/*107.16*/controllers/*107.27*/.contabilidad.routes.CuentaBancariasController.cambiarEstado(c.id, estado.id.toLong))),format.raw/*107.111*/("""" class="btn btn-default">
						<i class="glyphicon glyphicon-arrow-right"></i> """),_display_(Seq[Any](/*108.56*/estado/*108.62*/.nombre)),format.raw/*108.69*/("""
					</a>
				</div>
				
			""")))})),format.raw/*112.5*/("""
		""")))})),format.raw/*113.4*/("""
		"""),_display_(Seq[Any](/*114.4*/if(c.estado.id == models.Estado.CUENTA_BANCARIA_ESTADO_CANCELADO)/*114.69*/ {_display_(Seq[Any](format.raw/*114.71*/("""
			<div class="col-sm-3">
				<a href=""""),_display_(Seq[Any](/*116.15*/controllers/*116.26*/.contabilidad.routes.CuentaBancariasController.cambiarEstado(c.id, models.Estado.CUENTA_BANCARIA_ESTADO_BORRADOR))),format.raw/*116.139*/("""" class="btn btn-default">
					<i class="glyphicon glyphicon-arrow-right"></i> Volver a Borrador
				</a>
			</div>
		""")))}/*120.4*/else/*120.8*/{_display_(Seq[Any](format.raw/*120.9*/("""
			<div class="col-sm-3">
				<a href=""""),_display_(Seq[Any](/*122.15*/controllers/*122.26*/.contabilidad.routes.CuentaBancariasController.cambiarEstado(c.id, models.Estado.CUENTA_BANCARIA_ESTADO_CANCELADO))),format.raw/*122.140*/("""" class="btn btn-default">
					<i class="glyphicon glyphicon-minus-sign"></i> Cancelar Cuenta Bancaria
				</a>
			</div>
		""")))})),format.raw/*126.4*/("""	
	</div>	
""")))})))}
    }
    
    def render(cuentaBancariaForm:Form[CuentaBancaria],c:CuentaBancaria): play.api.templates.HtmlFormat.Appendable = apply(cuentaBancariaForm,c)
    
    def f:((Form[CuentaBancaria],CuentaBancaria) => play.api.templates.HtmlFormat.Appendable) = (cuentaBancariaForm,c) => apply(cuentaBancariaForm,c)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/cuentaBancarias/verCuentaBancaria.scala.html
                    HASH: 9444d28df34278e8516593de5f3c18c2231238e9
                    MATRIX: 844->1|1006->80|1038->104|1112->61|1140->148|1177->151|1189->156|1255->214|1294->216|2273->1160|2286->1165|2333->1190|2444->1265|2464->1276|2554->1344|2686->1440|2706->1451|2801->1524|2929->1616|2949->1627|3047->1702|3247->1866|3267->1877|3357->1945|3715->2267|3735->2278|3845->2365|3890->2375|3937->2413|3965->2419|4200->2619|4244->2654|4272->2660|4488->2841|4522->2866|4550->2872|4719->3005|4776->3053|4816->3055|4846->3065|4860->3069|4900->3070|4946->3083|5002->3103|5041->3133|5066->3136|5144->3179|5346->3358|5472->3448|5539->3505|5580->3507|5610->3517|5624->3521|5664->3522|5710->3535|5766->3555|5814->3594|5839->3597|5920->3643|6311->4012|6478->4144|6570->4214|6673->4280|6684->4281|6721->4295|6809->4347|6935->4455|6977->4457|7019->4463|7050->4484|7091->4486|7171->4529|7192->4540|7300->4624|7419->4706|7435->4712|7465->4719|7528->4750|7564->4754|7604->4758|7679->4823|7720->4825|7798->4866|7819->4877|7956->4990|8095->5110|8108->5114|8147->5115|8225->5156|8246->5167|8384->5281|8542->5407
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|66->38|66->38|66->38|70->42|70->42|70->42|71->43|71->43|71->43|72->44|72->44|72->44|75->47|75->47|75->47|83->55|83->55|83->55|84->56|84->56|84->56|91->63|91->63|91->63|97->69|97->69|97->69|103->75|103->75|103->75|103->75|103->75|103->75|103->75|104->76|104->76|104->76|105->77|105->77|109->81|109->81|109->81|109->81|109->81|109->81|109->81|110->82|110->82|110->82|111->83|117->89|124->96|124->96|129->101|129->101|129->101|132->104|132->104|132->104|133->105|133->105|133->105|135->107|135->107|135->107|136->108|136->108|136->108|140->112|141->113|142->114|142->114|142->114|144->116|144->116|144->116|148->120|148->120|148->120|150->122|150->122|150->122|154->126
                    -- GENERATED --
                */
            