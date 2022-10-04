
package views.html.recupero.recuperoFactura

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
object verRecuperoFactura extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[models.recupero.RecuperoFactura],models.recupero.RecuperoFactura,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(recuperoFacturaForm: Form[models.recupero.RecuperoFactura], recuperoFactura: models.recupero.RecuperoFactura):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import utils._

import helper._

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.112*/("""
"""),format.raw/*4.70*/(""" 


"""),_display_(Seq[Any](/*7.2*/views/*7.7*/.html.recupero.mainRecupero("Vista de factura")/*7.54*/ {_display_(Seq[Any](format.raw/*7.56*/("""
	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Vista de factura</h1>
			</div>
			<div class="col-sm-5">
				<div class="dropdown pull-right">
				 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 	<i class="glyphicon glyphicon-list-alt"></i>
				    Reportes
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
					<li role="presentation"><a role="menuitem" tabindex="-1" href=""""),_display_(Seq[Any](/*21.70*/controllers/*21.81*/.recupero.routes.RecuperoReportesController.imprimirFactura(recuperoFactura.id))),format.raw/*21.160*/("""">Imprimir factura</a></li>
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
	
"""),_display_(Seq[Any](/*40.2*/views/*40.7*/.html.tags.successError())),format.raw/*40.32*/("""

<div class="row menu-acciones">
	<div class="col-sm-9">
		<a href=""""),_display_(Seq[Any](/*44.13*/controllers/*44.24*/.recupero.routes.RecuperoFacturasController.crear())),_display_(Seq[Any](/*44.76*/UriTrack/*44.84*/.get("?"))),format.raw/*44.93*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo</a>
		<a href=""""),_display_(Seq[Any](/*45.13*/controllers/*45.24*/.recupero.routes.RecuperoFacturasController.editar(recuperoFactura.id))),_display_(Seq[Any](/*45.95*/UriTrack/*45.103*/.get("&"))),format.raw/*45.112*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-edit"></i> Editar</a>
		<a href=""""),_display_(Seq[Any](/*46.13*/controllers/*46.24*/.recupero.routes.RecuperoFacturasController.eliminar(recuperoFactura.id))),_display_(Seq[Any](/*46.97*/UriTrack/*46.105*/.get("&"))),format.raw/*46.114*/(""""  class="btn btn-default delete-confirm-link"><i class="glyphicon glyphicon-trash icono-eliminar"></i> Eliminar</a>
	</div>
	<div class="col-sm-3">
		<a href=""""),_display_(Seq[Any](/*49.13*/UriTrack/*49.21*/.getOnNull(controllers.recupero.routes.RecuperoFacturasController.index().absoluteURL()))),format.raw/*49.109*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a>
	</div>
</div>
	"""),_display_(Seq[Any](/*52.3*/inputText(recuperoFacturaForm("id"), 'type -> "hidden", 'id -> "recuperoFacturaId"))),format.raw/*52.86*/("""
	<div class="row">
		<div class="col-sm-2">
			<label class="control-label">Nombre</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*56.49*/recuperoFactura/*56.64*/.nombre)),format.raw/*56.71*/("""</p>
		</div>
		<div class="col-sm-3">
			<label class="control-label">Numero</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*60.49*/recuperoFactura/*60.64*/.getNumeroFactura())),format.raw/*60.83*/("""</p>
		</div>
		 
		<div class="col-sm-4">
			<label class="control-label">Cliente</label> 
			<p class="form-control-static form-control" style="height: 25px; overflow: hidden;">
				"""),_display_(Seq[Any](/*66.6*/recuperoFacturaForm("cliente.nombre")/*66.43*/.value)),format.raw/*66.49*/("""
			</p>
		</div>
	</div>	
	<div class="row">	
		<div class="col-sm-2">
			<label class="control-label">Planilla</label>
			<p class="form-control-static form-control">
			"""),_display_(Seq[Any](/*74.5*/if(recuperoFactura.planilla_id != null)/*74.44*/{_display_(Seq[Any](format.raw/*74.45*/("""
				"""),_display_(Seq[Any](/*75.6*/recuperoFactura/*75.21*/.planilla.getRecuperoPlanillaEjercicio())),format.raw/*75.61*/("""
			""")))})),format.raw/*76.5*/("""
			</p>
		</div>	
		<div class="col-sm-2">
			<label class="control-label">Fecha factura</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*81.49*/recuperoFacturaForm("fecha")/*81.77*/.value)),format.raw/*81.83*/("""</p>
		</div>
	</div>
		
	"""),_display_(Seq[Any](/*85.3*/views/*85.8*/.html.recupero.recuperoFactura.tabsRecuperoFactura(false, recuperoFacturaForm,recuperoFactura))),format.raw/*85.102*/("""
	<!-- <h4>Total: 	   <b>"""),_display_(Seq[Any](/*86.26*/utils/*86.31*/.NumberUtils.moneda(recuperoFactura.getBase()))),format.raw/*86.77*/("""</b></h4>	
	<h4>Estado actual: 	<b>"""),_display_(Seq[Any](/*87.26*/recuperoFactura/*87.41*/.estado.nombre)),format.raw/*87.55*/("""</b></h4>-->
	 
	<div class="row">	
	
		"""),_display_(Seq[Any](/*91.4*/for(estado <- models.Estado.getSiguienteEstadoPorAprobar(recuperoFactura.estado.orden,models.Estado.TIPO_RECUPERO_FACTURA)) yield /*91.127*/ {_display_(Seq[Any](format.raw/*91.129*/("""	
			"""),_display_(Seq[Any](/*92.5*/if(estado.orden <= 4)/*92.26*/ {_display_(Seq[Any](format.raw/*92.28*/("""
				<div class="col-sm-3">
					<a href=""""),_display_(Seq[Any](/*94.16*/controllers/*94.27*/.recupero.routes.RecuperoFacturasController.cambiarEstado(recuperoFacturaForm.field("id").value.toInt, estado.id.toLong))),_display_(Seq[Any](/*94.148*/UriTrack/*94.156*/.get("&"))),format.raw/*94.165*/("""" class="btn btn-default">
						<i class="glyphicon glyphicon-arrow-right"></i> """),_display_(Seq[Any](/*95.56*/estado/*95.62*/.nombre)),format.raw/*95.69*/("""
					</a>
				</div>
				
			""")))})),format.raw/*99.5*/("""
		""")))})),format.raw/*100.4*/(""" 
		
		"""),_display_(Seq[Any](/*102.4*/if(recuperoFactura.estado.id == models.Estado.RECUPERO_FACTURA_CANCELADO)/*102.77*/ {_display_(Seq[Any](format.raw/*102.79*/("""
			<div class="col-sm-3">
				<a href=""""),_display_(Seq[Any](/*104.15*/controllers/*104.26*/.recupero.routes.RecuperoFacturasController.cambiarEstado(recuperoFacturaForm.field("id").value.toInt, models.Estado.RECUPERO_FACTURA_BORRADOR))),_display_(Seq[Any](/*104.170*/UriTrack/*104.178*/.get("&"))),format.raw/*104.187*/("""" class="btn btn-default">
					<i class="glyphicon glyphicon-arrow-right"></i> Volver a Borrador
				</a>
			</div>
		""")))}/*108.4*/else/*108.8*/{_display_(Seq[Any](format.raw/*108.9*/("""
			<div class="col-sm-3">
				<a href=""""),_display_(Seq[Any](/*110.15*/controllers/*110.26*/.recupero.routes.RecuperoFacturasController.cambiarEstado(recuperoFacturaForm.field("id").value.toInt, models.Estado.RECUPERO_FACTURA_CANCELADO))),_display_(Seq[Any](/*110.171*/UriTrack/*110.179*/.get("&"))),format.raw/*110.188*/("""" class="btn btn-default">
					<i class="glyphicon glyphicon-minus-sign"></i> Cancelar Factura
				</a>
			</div>
		""")))})),format.raw/*114.4*/("""
	</div>
""")))})),format.raw/*116.2*/("""


"""))}
    }
    
    def render(recuperoFacturaForm:Form[models.recupero.RecuperoFactura],recuperoFactura:models.recupero.RecuperoFactura): play.api.templates.HtmlFormat.Appendable = apply(recuperoFacturaForm,recuperoFactura)
    
    def f:((Form[models.recupero.RecuperoFactura],models.recupero.RecuperoFactura) => play.api.templates.HtmlFormat.Appendable) = (recuperoFacturaForm,recuperoFactura) => apply(recuperoFacturaForm,recuperoFactura)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:35 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/recupero/recuperoFactura/verRecuperoFactura.scala.html
                    HASH: 2f773879582d8e9cd07d4017b86ef480d4a7ae7f
                    MATRIX: 875->1|1105->149|1137->173|1212->111|1241->217|1283->225|1295->230|1350->277|1389->279|1993->847|2013->858|2115->937|2638->1425|2651->1430|2698->1455|2808->1529|2828->1540|2910->1592|2927->1600|2958->1609|3090->1705|3110->1716|3211->1787|3229->1795|3261->1804|3389->1896|3409->1907|3512->1980|3530->1988|3562->1997|3762->2161|3779->2169|3890->2257|4016->2348|4121->2431|4301->2575|4325->2590|4354->2597|4528->2735|4552->2750|4593->2769|4819->2960|4865->2997|4893->3003|5109->3184|5157->3223|5196->3224|5238->3231|5262->3246|5324->3286|5361->3292|5548->3443|5585->3471|5613->3477|5679->3508|5692->3513|5809->3607|5872->3634|5886->3639|5954->3685|6027->3722|6051->3737|6087->3751|6167->3796|6307->3919|6348->3921|6390->3928|6420->3949|6460->3951|6541->3996|6561->4007|6713->4128|6731->4136|6763->4145|6882->4228|6897->4234|6926->4241|6992->4276|7029->4281|7075->4291|7158->4364|7199->4366|7279->4409|7300->4420|7476->4564|7495->4572|7528->4581|7671->4705|7684->4709|7723->4710|7803->4753|7824->4764|8001->4909|8020->4917|8053->4926|8207->5048|8251->5060
                    LINES: 26->1|31->4|31->4|32->1|33->4|36->7|36->7|36->7|36->7|50->21|50->21|50->21|69->40|69->40|69->40|73->44|73->44|73->44|73->44|73->44|74->45|74->45|74->45|74->45|74->45|75->46|75->46|75->46|75->46|75->46|78->49|78->49|78->49|81->52|81->52|85->56|85->56|85->56|89->60|89->60|89->60|95->66|95->66|95->66|103->74|103->74|103->74|104->75|104->75|104->75|105->76|110->81|110->81|110->81|114->85|114->85|114->85|115->86|115->86|115->86|116->87|116->87|116->87|120->91|120->91|120->91|121->92|121->92|121->92|123->94|123->94|123->94|123->94|123->94|124->95|124->95|124->95|128->99|129->100|131->102|131->102|131->102|133->104|133->104|133->104|133->104|133->104|137->108|137->108|137->108|139->110|139->110|139->110|139->110|139->110|143->114|145->116
                    -- GENERATED --
                */
            