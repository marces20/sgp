
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
object verProveedor extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[Proveedor],Proveedor,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(provForm: Form[Proveedor],proveedor:Proveedor):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.49*/("""
"""),format.raw/*3.70*/(""" 
"""),_display_(Seq[Any](/*4.2*/views/*4.7*/.html.compras.mainCompras("Ver proveedor")/*4.49*/ {_display_(Seq[Any](format.raw/*4.51*/("""
<div class="page-header">
	<div class="row">
		<div class="col-sm-9">
			<h1>Ver proveedor</h1>
		</div>
		
		<div class="col-sm-3">
			<a href=""""),_display_(Seq[Any](/*12.14*/controllers/*12.25*/.compras.routes.ProveedoresController.crear)),format.raw/*12.68*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo proveedor</a>
			 
		</div>
	</div>
</div>
<div class="row menu-acciones">
	<div class="col-sm-10">
		<a href=""""),_display_(Seq[Any](/*19.13*/controllers/*19.24*/.compras.routes.ProveedoresController.crear())),format.raw/*19.69*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo</a>
		<a href=""""),_display_(Seq[Any](/*20.13*/controllers/*20.24*/.compras.routes.ProveedoresController.editar(proveedor.id))),format.raw/*20.82*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-edit"></i> Editar</a>
		<a href=""""),_display_(Seq[Any](/*21.13*/controllers/*21.24*/.compras.routes.ProveedoresController.eliminar(proveedor.id))),format.raw/*21.84*/(""""  class="btn btn-default delete-confirm-link"><i class="glyphicon glyphicon-trash icono-eliminar"></i> Eliminar</a>
	</div>
	<div class="col-sm-2">
		<a href=""""),_display_(Seq[Any](/*24.13*/controllers/*24.24*/.compras.routes.ProveedoresController.index())),format.raw/*24.69*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a>
	</div>
</div>
<div class="row">
	<div class="col-sm-4">
		<div class="form-group">
			<label class="control-label">Nombre del proveedor</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*31.49*/provForm/*31.57*/.field("nombre").value)),format.raw/*31.79*/("""</p>
		</div>
	</div>
	<div class="col-sm-3">
		<div class="form-group">
			<label class="control-label">Referencia</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*37.49*/provForm/*37.57*/.field("referencia").value)),format.raw/*37.83*/("""</p>
		</div>
	</div>

	<div class="col-sm-4">
		<div class="form-group">
			<label class="control-label">Agente</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*44.49*/provForm/*44.57*/.field("agente.apellido").value)),format.raw/*44.88*/("""</p>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-sm-2">
		<div class="form-group">
			<label class="control-label">Cuit</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*52.49*/provForm/*52.57*/.field("cuit").value)),format.raw/*52.77*/("""</p>
		</div>
	</div>	
	<div class="col-sm-2">
		<div class="form-group">
			<label class="control-label">DNI</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*58.49*/provForm/*58.57*/.field("dni").value)),format.raw/*58.76*/("""</p>
		</div>
	</div>		
		
	
	
	<div class="col-sm-2">
		<div class="form-group">
			<label class="control-label">Fecha vencimiento 322</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*67.49*/provForm/*67.57*/.field("fecha_vencimiento_322").value)),format.raw/*67.94*/("""</p>
		</div>
	</div>
	<div class="col-sm-3">
		<div class="form-group">
			<label class="control-label">Proveedor Padre</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*73.49*/provForm/*73.57*/.field("proveedor_padre.nombre").value)),format.raw/*73.95*/("""</p>
		</div>
	</div>
	
</div>	
<div class="row">
	<div class="col-sm-2">
		<div class="form-group">
			<label class="control-label">Número de inscripción</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*82.49*/provForm/*82.57*/.field("numero_inscripcion").value)),format.raw/*82.91*/("""</p>
		</div>
	</div>
	<div class="col-sm-offset-1  col-sm-2">
		<div class="checkbox">
			<label for="activo" class="control-label"> """),_display_(Seq[Any](/*87.48*/checkbox(provForm("activo"), 'disabled -> "disabled"))),format.raw/*87.101*/(""" Activo</label>
		</div>
	</div>
	
	<div class="col-sm-offset-1  col-sm-2">
		<div class="checkbox">
			<label for="activo" class="control-label"> """),_display_(Seq[Any](/*93.48*/checkbox(provForm("oficio"), 'disabled -> "disabled"))),format.raw/*93.101*/(""" Oficio</label>
		</div>
	</div>
	
</div>	
	
<ul class="nav nav-tabs">
  <li class="active"><a href="#contenedorDirecciones" data-toggle="tab">Contactos del proveedor</a></li>
  <li><a href="#contenedorObservaciones" data-toggle="tab">Observaciones</a></li>
</ul>

<div class="tab-content">
	<div class="tab-pane active" id="contenedorDirecciones">
		"""),_display_(Seq[Any](/*106.4*/if(provForm("id").value != null)/*106.36*/{_display_(Seq[Any](format.raw/*106.37*/("""
			"""),_display_(Seq[Any](/*107.5*/views/*107.10*/.html.compras.proveedores.contacto_proveedor(provForm,true))),format.raw/*107.69*/(""" 
		""")))})),format.raw/*108.4*/("""
	</div>
	<div class="tab-pane" id="contenedorObservaciones">
		<p class="form-control-static form-control">"""),_display_(Seq[Any](/*111.48*/provForm/*111.56*/.field("observaciones").value)),format.raw/*111.85*/("""</p>
	</div>
	
</div>
<br>
"""),_display_(Seq[Any](/*116.2*/views/*116.7*/.html.compras.proveedores.tabsAtributos(provForm, false))),format.raw/*116.63*/("""
""")))})))}
    }
    
    def render(provForm:Form[Proveedor],proveedor:Proveedor): play.api.templates.HtmlFormat.Appendable = apply(provForm,proveedor)
    
    def f:((Form[Proveedor],Proveedor) => play.api.templates.HtmlFormat.Appendable) = (provForm,proveedor) => apply(provForm,proveedor)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:46 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/proveedores/verProveedor.scala.html
                    HASH: 5fe462b1a50a45491cc69e6d661f30eb5b325643
                    MATRIX: 820->1|969->67|1001->91|1075->48|1103->135|1140->138|1152->143|1202->185|1241->187|1424->334|1444->345|1509->388|1736->579|1756->590|1823->635|1954->730|1974->741|2054->799|2181->890|2201->901|2283->961|2480->1122|2500->1133|2567->1178|2867->1442|2884->1450|2928->1472|3136->1644|3153->1652|3201->1678|3406->1847|3423->1855|3476->1886|3703->2077|3720->2085|3762->2105|3964->2271|3981->2279|4022->2298|4250->2490|4267->2498|4326->2535|4539->2712|4556->2720|4616->2758|4863->2969|4880->2977|4936->3011|5107->3146|5183->3199|5367->3347|5443->3400|5831->3752|5873->3784|5913->3785|5954->3790|5969->3795|6051->3854|6088->3859|6234->3968|6252->3976|6304->4005|6368->4033|6382->4038|6461->4094
                    LINES: 26->1|29->3|29->3|30->1|31->3|32->4|32->4|32->4|32->4|40->12|40->12|40->12|47->19|47->19|47->19|48->20|48->20|48->20|49->21|49->21|49->21|52->24|52->24|52->24|59->31|59->31|59->31|65->37|65->37|65->37|72->44|72->44|72->44|80->52|80->52|80->52|86->58|86->58|86->58|95->67|95->67|95->67|101->73|101->73|101->73|110->82|110->82|110->82|115->87|115->87|121->93|121->93|134->106|134->106|134->106|135->107|135->107|135->107|136->108|139->111|139->111|139->111|144->116|144->116|144->116
                    -- GENERATED --
                */
            