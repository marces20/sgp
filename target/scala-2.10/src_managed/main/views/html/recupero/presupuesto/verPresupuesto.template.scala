
package views.html.recupero.presupuesto

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
object verPresupuesto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[models.recupero.Presupuesto],models.recupero.Presupuesto,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(presupuestoForm: Form[models.recupero.Presupuesto], presupuesto: models.recupero.Presupuesto):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import utils._

import helper._

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.96*/("""
"""),format.raw/*4.70*/(""" 


"""),_display_(Seq[Any](/*7.2*/views/*7.7*/.html.recupero.mainRecupero("Vista de presupuesto")/*7.58*/ {_display_(Seq[Any](format.raw/*7.60*/("""
	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Vista de presupuesto</h1>
			</div>
			<div class="col-sm-5">
				<div class="dropdown pull-right">
				 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 	<i class="glyphicon glyphicon-list-alt"></i>
				    Reportes
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				  	<li role="presentation"><a role="menuitem" tabindex="-1" href=""""),_display_(Seq[Any](/*21.72*/controllers/*21.83*/.recupero.routes.PresupuestosReportesController.presupuesto(presupuesto.id,false))),format.raw/*21.164*/("""">Presupuesto</a></li>
				  	<li role="presentation"><a role="menuitem" tabindex="-1" href=""""),_display_(Seq[Any](/*22.72*/controllers/*22.83*/.recupero.routes.PresupuestosReportesController.presupuesto(presupuesto.id,true))),format.raw/*22.163*/("""">Presupuesto Extrajero</a></li>
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
	
"""),_display_(Seq[Any](/*41.2*/views/*41.7*/.html.tags.successError())),format.raw/*41.32*/("""

<div class="row menu-acciones">
	<div class="col-sm-9">
		<a href=""""),_display_(Seq[Any](/*45.13*/controllers/*45.24*/.recupero.routes.PresupuestosController.crear())),_display_(Seq[Any](/*45.72*/UriTrack/*45.80*/.get("?"))),format.raw/*45.89*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo</a>
		<a href=""""),_display_(Seq[Any](/*46.13*/controllers/*46.24*/.recupero.routes.PresupuestosController.editar(presupuesto.id))),_display_(Seq[Any](/*46.87*/UriTrack/*46.95*/.get("&"))),format.raw/*46.104*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-edit"></i> Editar</a>
		<a href=""""),_display_(Seq[Any](/*47.13*/controllers/*47.24*/.recupero.routes.PresupuestosController.duplicar(presupuesto.id))),_display_(Seq[Any](/*47.89*/UriTrack/*47.97*/.get("&"))),format.raw/*47.106*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-subtitles"></i> Duplicar</a>
		<a href=""""),_display_(Seq[Any](/*48.13*/controllers/*48.24*/.recupero.routes.PresupuestosController.eliminar(presupuesto.id))),_display_(Seq[Any](/*48.89*/UriTrack/*48.97*/.get("&"))),format.raw/*48.106*/(""""  class="btn btn-default delete-confirm-link"><i class="glyphicon glyphicon-trash icono-eliminar"></i> Eliminar</a>
	</div>
	<div class="col-sm-3">
		<a href=""""),_display_(Seq[Any](/*51.13*/UriTrack/*51.21*/.getOnNull(controllers.recupero.routes.PresupuestosController.index().absoluteURL()))),format.raw/*51.105*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a>
	</div>
</div>
	<div class="row">
		<div class="col-sm-2">
			<label class="control-label">Nombre</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*57.49*/presupuesto/*57.60*/.nombre)),format.raw/*57.67*/("""</p>
		</div>
		<div class="col-sm-4">
			<label class="control-label">Cliente</label> 
			<p class="form-control-static form-control" style="height: 25px; overflow: hidden;">
				"""),_display_(Seq[Any](/*62.6*/presupuestoForm("cliente.nombre")/*62.39*/.value)),format.raw/*62.45*/("""
			</p>
		</div>
		<div class="col-sm-2">
			<label class="control-label">Fecha presupuesto</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*67.49*/presupuestoForm("fecha")/*67.73*/.value)),format.raw/*67.79*/("""</p>
		</div>
		<div class="col-sm-4">
			<label for="deposito" class="control-label">Institucion</label> 
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*71.49*/presupuestoForm("deposito.nombre")/*71.83*/.value)),format.raw/*71.89*/("""</p>
		</div>
	</div>
		
		
	<hr />	
		
		
	"""),_display_(Seq[Any](/*79.3*/views/*79.8*/.html.recupero.presupuesto.tabsPresupuesto(false, presupuestoForm))),format.raw/*79.74*/("""
	<h4>Total: 	   <b>"""),_display_(Seq[Any](/*80.21*/utils/*80.26*/.NumberUtils.moneda(presupuesto.getTotal()))),format.raw/*80.69*/("""</b></h4>	
	<h4>Estado actual: 	<b>"""),_display_(Seq[Any](/*81.26*/presupuesto/*81.37*/.estado.nombre)),format.raw/*81.51*/("""</b></h4>
	<div class="row margin-bottom-25">	
		"""),_display_(Seq[Any](/*83.4*/for(estado <- models.Estado.getSiguienteEstadoPorAprobar(presupuesto.estado.orden,models.Estado.TIPO_PRESUPUESTO)) yield /*83.118*/ {_display_(Seq[Any](format.raw/*83.120*/("""	
			"""),_display_(Seq[Any](/*84.5*/if(estado.orden <= 4)/*84.26*/ {_display_(Seq[Any](format.raw/*84.28*/("""
				<div class="col-sm-3">
					<a href=""""),_display_(Seq[Any](/*86.16*/controllers/*86.27*/.recupero.routes.PresupuestosController.cambiarEstado(presupuestoForm.field("id").value.toInt, estado.id.toLong))),_display_(Seq[Any](/*86.140*/UriTrack/*86.148*/.get("&"))),format.raw/*86.157*/("""" class="btn btn-default">
						<i class="glyphicon glyphicon-arrow-right"></i> """),_display_(Seq[Any](/*87.56*/estado/*87.62*/.nombre)),format.raw/*87.69*/("""
					</a>
				</div>
				
			""")))})),format.raw/*91.5*/("""
		""")))})),format.raw/*92.4*/("""
		"""),_display_(Seq[Any](/*93.4*/if(presupuesto.estado.id == models.Estado.PRESUPUESTO_CANCELADO)/*93.68*/ {_display_(Seq[Any](format.raw/*93.70*/("""
			<div class="col-sm-3">
				<a href=""""),_display_(Seq[Any](/*95.15*/controllers/*95.26*/.recupero.routes.PresupuestosController.cambiarEstado(presupuestoForm.field("id").value.toInt, models.Estado.PRESUPUESTO_BORRADOR))),_display_(Seq[Any](/*95.157*/UriTrack/*95.165*/.get("&"))),format.raw/*95.174*/("""" class="btn btn-default">
					<i class="glyphicon glyphicon-arrow-right"></i> Volver a Borrador
				</a>
			</div>
		""")))}/*99.4*/else/*99.8*/{_display_(Seq[Any](format.raw/*99.9*/("""
			<div class="col-sm-3">
				<a href=""""),_display_(Seq[Any](/*101.15*/controllers/*101.26*/.recupero.routes.PresupuestosController.cambiarEstado(presupuestoForm.field("id").value.toInt, models.Estado.PRESUPUESTO_CANCELADO))),_display_(Seq[Any](/*101.158*/UriTrack/*101.166*/.get("&"))),format.raw/*101.175*/("""" class="btn btn-default">
					<i class="glyphicon glyphicon-minus-sign"></i> Cancelar Presupuesto
				</a>
			</div>
		""")))})),format.raw/*105.4*/("""
	</div>
""")))})),format.raw/*107.2*/("""


"""))}
    }
    
    def render(presupuestoForm:Form[models.recupero.Presupuesto],presupuesto:models.recupero.Presupuesto): play.api.templates.HtmlFormat.Appendable = apply(presupuestoForm,presupuesto)
    
    def f:((Form[models.recupero.Presupuesto],models.recupero.Presupuesto) => play.api.templates.HtmlFormat.Appendable) = (presupuestoForm,presupuesto) => apply(presupuestoForm,presupuesto)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:36 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/recupero/presupuesto/verPresupuesto.scala.html
                    HASH: 88939ae9c3c6cec41ca88e0a50f5d5fbd87af98f
                    MATRIX: 859->1|1073->133|1105->157|1179->95|1208->201|1250->209|1262->214|1321->265|1360->267|1970->841|1990->852|2094->933|2225->1028|2245->1039|2348->1119|2876->1612|2889->1617|2936->1642|3046->1716|3066->1727|3144->1775|3161->1783|3192->1792|3324->1888|3344->1899|3437->1962|3454->1970|3486->1979|3614->2071|3634->2082|3729->2147|3746->2155|3778->2164|3913->2263|3933->2274|4028->2339|4045->2347|4077->2356|4277->2520|4294->2528|4401->2612|4668->2843|4688->2854|4717->2861|4938->3047|4980->3080|5008->3086|5198->3240|5231->3264|5259->3270|5454->3429|5497->3463|5525->3469|5613->3522|5626->3527|5714->3593|5772->3615|5786->3620|5851->3663|5924->3700|5944->3711|5980->3725|6067->3777|6198->3891|6239->3893|6281->3900|6311->3921|6351->3923|6432->3968|6452->3979|6596->4092|6614->4100|6646->4109|6765->4192|6780->4198|6809->4205|6875->4240|6911->4245|6951->4250|7024->4314|7064->4316|7143->4359|7163->4370|7325->4501|7343->4509|7375->4518|7517->4642|7529->4646|7567->4647|7647->4690|7668->4701|7832->4833|7851->4841|7884->4850|8042->4976|8086->4988
                    LINES: 26->1|31->4|31->4|32->1|33->4|36->7|36->7|36->7|36->7|50->21|50->21|50->21|51->22|51->22|51->22|70->41|70->41|70->41|74->45|74->45|74->45|74->45|74->45|75->46|75->46|75->46|75->46|75->46|76->47|76->47|76->47|76->47|76->47|77->48|77->48|77->48|77->48|77->48|80->51|80->51|80->51|86->57|86->57|86->57|91->62|91->62|91->62|96->67|96->67|96->67|100->71|100->71|100->71|108->79|108->79|108->79|109->80|109->80|109->80|110->81|110->81|110->81|112->83|112->83|112->83|113->84|113->84|113->84|115->86|115->86|115->86|115->86|115->86|116->87|116->87|116->87|120->91|121->92|122->93|122->93|122->93|124->95|124->95|124->95|124->95|124->95|128->99|128->99|128->99|130->101|130->101|130->101|130->101|130->101|134->105|136->107
                    -- GENERATED --
                */
            