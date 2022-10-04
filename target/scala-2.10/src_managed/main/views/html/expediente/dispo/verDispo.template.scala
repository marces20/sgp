
package views.html.expediente.dispo

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
object verDispo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[Dispo],Dispo,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lcForm: Form[Dispo],lc:Dispo):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

def /*5.2*/scripts/*5.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*5.13*/("""
	<script src=""""),_display_(Seq[Any](/*6.16*/routes/*6.22*/.Assets.at("javascripts/expediente/expediente.js"))),format.raw/*6.72*/("""" type="text/javascript"></script>
""")))};implicit def /*8.2*/implicitFieldConstructor/*8.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.32*/("""
"""),format.raw/*7.2*/("""
"""),format.raw/*8.70*/(""" 

"""),_display_(Seq[Any](/*10.2*/views/*10.7*/.html.expediente.mainExpediente("Vista Disposicion",scripts)/*10.67*/ {_display_(Seq[Any](format.raw/*10.69*/("""
	<div class="page-header">
		<div class="row">
			<div class="col-sm-3">
				<h1>Vista Disposicion</h1>
			</div>
			<div class="col-sm-4">
				 
			</div>
			<div class="col-sm-5">
				<div class="dropdown pull-right btn-header">
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
				 	<i class="glyphicon glyphicon-list-alt"></i>
				    Acciones
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				  
				  </ul>
				</div>
				
				<div class="pull-right btn-header">
					<a href=""""),_display_(Seq[Any](/*42.16*/controllers/*42.27*/.expediente.routes.DisposController.crear())),format.raw/*42.70*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nueva Disposicion</a>
				</div>
			</div>
		</div>
	</div>		
"""),_display_(Seq[Any](/*47.2*/views/*47.7*/.html.tags.successError())),format.raw/*47.32*/("""	
	<div class="row menu-acciones">
		<div class="col-sm-4">
			<a href=""""),_display_(Seq[Any](/*50.14*/controllers/*50.25*/.expediente.routes.DisposController.editar(lc.id))),format.raw/*50.74*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-edit"></i> Editar</a>
			<a href=""""),_display_(Seq[Any](/*51.14*/controllers/*51.25*/.expediente.routes.DisposController.eliminar(lc.id))),format.raw/*51.76*/(""""  class="btn btn-default delete-confirm-link"><i class="glyphicon glyphicon-trash icono-eliminar"></i> Eliminar</a>
		</div>
		<div class="col-sm-6">
				
		</div>
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*57.14*/UriTrack/*57.22*/.getOnNull(controllers.expediente.routes.DisposController.index().absoluteURL()))),format.raw/*57.102*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
		</div> 
	</div>	
	
	<input type="hidden" id="dispoId" name="dispoId" value=""""),_display_(Seq[Any](/*61.59*/lc/*61.61*/.id)),format.raw/*61.64*/(""""/>
	<div class="row">
		<div class="col-sm-2">
			<div class="form-group">
				<label class="control-label">Numero</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*66.50*/lcForm/*66.56*/.field("numero").value)),format.raw/*66.78*/("""</p>
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group">
				<label class="control-label">Expediente</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*72.50*/if(lc.expediente != null)/*72.75*/{_display_(Seq[Any](_display_(Seq[Any](/*72.77*/lc/*72.79*/.expediente.getExpedienteEjercicio()))))})),format.raw/*72.116*/("""</p>
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group ">
				<label class="control-label">Fecha</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*78.50*/(utils.DateUtils.formatDate(lc.fecha)))),format.raw/*78.88*/("""</p>
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group">
				<label for="creacion_orden_compra" class="control-label"> Institucion</label>
				<p class="form-control-static form-control">
					
					 
					"""),_display_(Seq[Any](/*87.7*/lc/*87.9*/.organigrama_id.toString/*87.33*/ match/*87.39*/ {/*88.10*/case "1" =>/*88.21*/ {_display_(Seq[Any](format.raw/*88.23*/("""PARQUE""")))}/*89.10*/case "3" =>/*89.21*/ {_display_(Seq[Any](format.raw/*89.23*/("""HEARM""")))}/*90.10*/case _ =>/*90.19*/ {}})),format.raw/*91.7*/("""
				</p>
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group ">
				<label class="control-label">Fecha Creacion</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*98.50*/(utils.DateUtils.formatDate(lc.create_date)))),format.raw/*98.94*/("""</p>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-7">
			<div class="form-group">
				<label class="control-label">Descripcion</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*106.50*/lcForm/*106.56*/.field("descripcion").value)),format.raw/*106.83*/("""</p>
			</div>
		</div> 
	</div>  
	<div class="row">
		<div class="col-sm-7">
			<div class="form-group">
				<label class="control-label">Motivo Baja</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*114.50*/lcForm/*114.56*/.field("motivo_baja").value)),format.raw/*114.83*/("""</p>
			</div>
		</div> 
	</div>  
	
	<h4>Estado actual: 	<b>"""),_display_(Seq[Any](/*119.26*/lc/*119.28*/.estado.nombre)),format.raw/*119.42*/("""</b></h4>
	<div class="row margin-bottom-25">	
	
		"""),_display_(Seq[Any](/*122.4*/if(lc.estado.id == models.Estado.DISPO_ACTIVA)/*122.50*/ {_display_(Seq[Any](format.raw/*122.52*/("""
			<div class="col-sm-3">
				<a href=""""),_display_(Seq[Any](/*124.15*/controllers/*124.26*/.expediente.routes.DisposController.cambiarEstado(lcForm.field("id").value.toInt, models.Estado.DISPO_DESACTIVA))),_display_(Seq[Any](/*124.139*/UriTrack/*124.147*/.get("&"))),format.raw/*124.156*/("""" class="btn btn-default btn-disable-onclick">
					<i class="glyphicon glyphicon-arrow-right"></i> Pasar a No Activa
				</a>
			</div>
		""")))}/*128.4*/else/*128.8*/{_display_(Seq[Any](format.raw/*128.9*/("""
			<div class="col-sm-3">
				<a href=""""),_display_(Seq[Any](/*130.15*/controllers/*130.26*/.expediente.routes.DisposController.cambiarEstado(lcForm.field("id").value.toInt, models.Estado.DISPO_ACTIVA))),_display_(Seq[Any](/*130.136*/UriTrack/*130.144*/.get("&"))),format.raw/*130.153*/("""" class="btn btn-default btn-disable-onclick">
					<i class="glyphicon glyphicon-minus-sign"></i>  Pasar a Activa
				</a>
			</div>
		""")))})),format.raw/*134.4*/("""
	</div>
	 
""")))})))}
    }
    
    def render(lcForm:Form[Dispo],lc:Dispo): play.api.templates.HtmlFormat.Appendable = apply(lcForm,lc)
    
    def f:((Form[Dispo],Dispo) => play.api.templates.HtmlFormat.Appendable) = (lcForm,lc) => apply(lcForm,lc)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:36 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/expediente/dispo/verDispo.scala.html
                    HASH: ac787c5b76e7e9f99534e68b4acc54909803af5a
                    MATRIX: 805->1|966->88|980->95|1064->99|1115->115|1129->121|1200->171|1267->209|1299->233|1373->31|1400->207|1428->277|1467->281|1480->286|1549->346|1589->348|2638->1361|2658->1372|2723->1415|2894->1551|2907->1556|2954->1581|3063->1654|3083->1665|3154->1714|3282->1806|3302->1817|3375->1868|3614->2071|3631->2079|3734->2159|3921->2310|3932->2312|3957->2315|4166->2488|4181->2494|4225->2516|4439->2694|4473->2719|4521->2721|4532->2723|4596->2760|4806->2934|4866->2972|5128->3199|5138->3201|5171->3225|5186->3231|5197->3243|5217->3254|5257->3256|5283->3273|5303->3284|5343->3286|5368->3302|5386->3311|5411->3321|5635->3509|5701->3553|5944->3759|5960->3765|6010->3792|6256->4001|6272->4007|6322->4034|6421->4096|6433->4098|6470->4112|6558->4164|6614->4210|6655->4212|6733->4253|6754->4264|6899->4377|6918->4385|6951->4394|7110->4534|7123->4538|7162->4539|7240->4580|7261->4591|7403->4701|7422->4709|7455->4718|7624->4855
                    LINES: 26->1|33->5|33->5|35->5|36->6|36->6|36->6|37->8|37->8|38->1|39->7|40->8|42->10|42->10|42->10|42->10|74->42|74->42|74->42|79->47|79->47|79->47|82->50|82->50|82->50|83->51|83->51|83->51|89->57|89->57|89->57|93->61|93->61|93->61|98->66|98->66|98->66|104->72|104->72|104->72|104->72|104->72|110->78|110->78|119->87|119->87|119->87|119->87|119->88|119->88|119->88|119->89|119->89|119->89|119->90|119->90|119->91|126->98|126->98|134->106|134->106|134->106|142->114|142->114|142->114|147->119|147->119|147->119|150->122|150->122|150->122|152->124|152->124|152->124|152->124|152->124|156->128|156->128|156->128|158->130|158->130|158->130|158->130|158->130|162->134
                    -- GENERATED --
                */
            