
package views.html.patrimonio.recepciones

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
object verRecepcion extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Recepcion,utils.pagination.PaginadorFicha,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(recepcion: Recepcion, paginadorFicha: utils.pagination.PaginadorFicha):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import models.auth._

import utils._

def /*6.2*/scripts/*6.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*6.13*/("""
	<script src=""""),_display_(Seq[Any](/*7.16*/routes/*7.22*/.Assets.at("javascripts/patrimonio/recepciones.js"))),format.raw/*7.73*/("""" type="text/javascript"></script>
""")))};implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.73*/("""
"""),format.raw/*5.70*/(""" 
"""),format.raw/*8.2*/("""
"""),_display_(Seq[Any](/*9.2*/paginadorFicha/*9.16*/.setActual(recepcion.id.toString))),format.raw/*9.49*/("""

"""),_display_(Seq[Any](/*11.2*/views/*11.7*/.html.patrimonio.mainPatrimonio("Vista de recepción", scripts)/*11.69*/ {_display_(Seq[Any](format.raw/*11.71*/("""
	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Vista de recepción</h1>
			</div>
			"""),_display_(Seq[Any](/*17.5*/if(Permiso.check("recepcionesCrear"))/*17.42*/ {_display_(Seq[Any](format.raw/*17.44*/("""
			<div class="dropdown pull-right btn-header">
			 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
			 	<i class="glyphicon glyphicon-cog"></i>
			    Acciones
			    <span class="caret"></span>
			  </button>
			  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
			  	<li><a id="cargarRemitosMasivos" href="#" data-url=""""),_display_(Seq[Any](/*25.60*/controllers/*25.71*/.patrimonio.routes.RecepcionesController.modalCargarRemitosMasivos(recepcion.id))),format.raw/*25.151*/("""">Cargar Remitos Masivos</a></li>
			  </ul>
			</div>
			<div class="pull-right btn-header">
				<a href=""""),_display_(Seq[Any](/*29.15*/controllers/*29.26*/.patrimonio.routes.RemitosController.crear(recepcion.id))),format.raw/*29.82*/("""" class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Crear remito</a>
			</div>
			""")))})),format.raw/*31.5*/("""
		</div>	
	</div>
	
<ol class="breadcrumb">
  <li><a href=""""),_display_(Seq[Any](/*36.17*/controllers/*36.28*/.patrimonio.routes.OrdenesProvisionController.ver(recepcion.ordenProvision.id))),format.raw/*36.106*/("""">Orden de provisión """),_display_(Seq[Any](/*36.128*/recepcion/*36.137*/.ordenProvision.numero)),format.raw/*36.159*/("""</a></li>
  <li class="active">Recepción """),_display_(Seq[Any](/*37.33*/recepcion/*37.42*/.numero)),format.raw/*37.49*/("""</li>
</ol>

	
	
	"""),_display_(Seq[Any](/*42.3*/views/*42.8*/.html.tags.successError())),format.raw/*42.33*/("""

<div class="row menu-acciones">
	<div class="col-sm-4">
		"""),_display_(Seq[Any](/*46.4*/if(Permiso.check("recepcionesCrear"))/*46.41*/ {_display_(Seq[Any](format.raw/*46.43*/("""
		<a href=""""),_display_(Seq[Any](/*47.13*/controllers/*47.24*/.patrimonio.routes.RecepcionesController.editar(recepcion.id))),_display_(Seq[Any](/*47.86*/UriTrack/*47.94*/.get("&"))),format.raw/*47.103*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-edit"></i> Editar</a>
		""")))})),format.raw/*48.4*/("""
		"""),_display_(Seq[Any](/*49.4*/if(Permiso.check("recepcionesEliminar"))/*49.44*/ {_display_(Seq[Any](format.raw/*49.46*/("""
		<a href=""""),_display_(Seq[Any](/*50.13*/controllers/*50.24*/.patrimonio.routes.RecepcionesController.eliminar(recepcion.id))),_display_(Seq[Any](/*50.88*/UriTrack/*50.96*/.get("&"))),format.raw/*50.105*/(""""  class="btn btn-default delete-confirm-link"><i class="glyphicon glyphicon-trash icono-eliminar"></i> Eliminar</a>
		""")))})),format.raw/*51.4*/("""
	</div>
	<div class="col-sm-5">
		"""),_display_(Seq[Any](/*54.4*/if(recepcion.ordenProvision.ordenCompra.tipo_moneda != null)/*54.64*/{_display_(Seq[Any](format.raw/*54.65*/("""
			<span style="color:green;font-weight:bold;font-size: 24px;">MONEDA EXTRANJERA</span>
		""")))})),format.raw/*56.4*/("""
	</div>
	<div class="col-sm-3">
		<a href=""""),_display_(Seq[Any](/*59.13*/UriTrack/*59.21*/.getOnNull(controllers.patrimonio.routes.RecepcionesController.index().absoluteURL()))),format.raw/*59.106*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a>
		
       """),_display_(Seq[Any](/*61.9*/if(paginadorFicha.getLista().size() > 1)/*61.49*/{_display_(Seq[Any](format.raw/*61.50*/("""
		
              	
		<div class="btn-group">
			"""),_display_(Seq[Any](/*65.5*/if(paginadorFicha.hasPrev())/*65.33*/ {_display_(Seq[Any](format.raw/*65.35*/("""
				<a  role="group" href=""""),_display_(Seq[Any](/*66.29*/controllers/*66.40*/.patrimonio.routes.RecepcionesController.ver(paginadorFicha.prev().toLong))),_display_(Seq[Any](/*66.115*/UriTrack/*66.123*/.get("&"))),format.raw/*66.132*/("""" class="btn btn-default"><i class="glyphicon glyphicon-chevron-left"></i></a>
			""")))})),format.raw/*67.5*/("""
			<p style="padding-top: 3px" href=""  role="group" class="btn btn-default">"""),_display_(Seq[Any](/*68.79*/paginadorFicha/*68.93*/.posicionActual())),format.raw/*68.110*/(""" de """),_display_(Seq[Any](/*68.115*/paginadorFicha/*68.129*/.getLista().size())),format.raw/*68.147*/("""</p>
			"""),_display_(Seq[Any](/*69.5*/if(paginadorFicha.hasNext())/*69.33*/ {_display_(Seq[Any](format.raw/*69.35*/("""
				<a  role="group" href=""""),_display_(Seq[Any](/*70.29*/controllers/*70.40*/.patrimonio.routes.RecepcionesController.ver(paginadorFicha.next().toLong))),_display_(Seq[Any](/*70.115*/UriTrack/*70.123*/.get("&"))),format.raw/*70.132*/("""" class="btn btn-default"><i class="glyphicon glyphicon-chevron-right"></i></a>
			""")))})),format.raw/*71.5*/("""  
		</div>
		""")))})),format.raw/*73.4*/("""
	</div>
</div>

	

	<div class="row">
		<div class="col-sm-2">
			<label class="control-label">Número</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*82.49*/recepcion/*82.58*/.numero)),format.raw/*82.65*/("""</p>
		</div>
		
		<div class="col-sm-2">
			<label class="control-label">Orden de provisión</label> 
			<p class="form-control-static form-control" style="height: 25px; overflow: hidden;">"""),_display_(Seq[Any](/*87.89*/recepcion/*87.98*/.ordenProvision.numero)),format.raw/*87.120*/("""</p>
		</div>
		
		<div class="col-sm-2">
			<label class="control-label">Acta</label> 
			<p class="form-control-static form-control" style="height: 25px; overflow: hidden;">"""),_display_(Seq[Any](/*92.89*/if(recepcion.acta != null)/*92.115*/ {_display_(Seq[Any](format.raw/*92.117*/(""" """),_display_(Seq[Any](/*92.119*/recepcion/*92.128*/.acta.numero)),format.raw/*92.140*/(""" """)))})),format.raw/*92.142*/("""</p>
		</div>
		
		<div class="col-sm-2">
			<label class="control-label">Fecha</label> 
			<p class="form-control-static form-control" style="height: 25px; overflow: hidden;">"""),_display_(Seq[Any](/*97.89*/(DateUtils.formatDate(recepcion.create_date)))),format.raw/*97.134*/("""</p>
		</div>
		
		<div class="col-sm-3">
			<label class="control-label">Proveedor</label> 
			<p class="form-control-static form-control" style="height: 25px; overflow: hidden;">"""),_display_(Seq[Any](/*102.89*/recepcion/*102.98*/.ordenProvision.ordenCompra.proveedor.nombre)),format.raw/*102.142*/("""</p>
		</div>
		
	</div>

	<div class="row">
		<div class="col-sm-2">
			<label class="control-label">Total</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*110.49*/utils/*110.54*/.NumberUtils.moneda(recepcion.total))),format.raw/*110.90*/("""</p>
		</div>
	</div>
	
<hr />

	<ul id="ordenTab" class="nav nav-tabs">
		<li class="active"><a id="listaRemitos" data-href=""""),_display_(Seq[Any](/*117.55*/controllers/*117.66*/.patrimonio.routes.RemitosController.indexAjax())),format.raw/*117.114*/("""?recepcion_id="""),_display_(Seq[Any](/*117.129*/recepcion/*117.138*/.id)),format.raw/*117.141*/("""" href="#contenedorRemitos" data-toggle="tab">Lista de remitos</a></li>
	</ul>


	<div class="tab-content">
		<div id="contenedorRemitos" class="tab-pane active">
		
		</div>
	</div>
	
	
	<script>
	$( function()"""),format.raw/*129.15*/("""{"""),format.raw/*129.16*/("""
		var urlRemitos = $('#listaRemitos').attr("data-href");
		$.get(urlRemitos, function(data)"""),format.raw/*131.35*/("""{"""),format.raw/*131.36*/("""
			$('#contenedorRemitos').html(data);
		"""),format.raw/*133.3*/("""}"""),format.raw/*133.4*/(""");
	"""),format.raw/*134.2*/("""}"""),format.raw/*134.3*/(""");
	</script>
	
	
""")))})),format.raw/*138.2*/("""
"""))}
    }
    
    def render(recepcion:Recepcion,paginadorFicha:utils.pagination.PaginadorFicha): play.api.templates.HtmlFormat.Appendable = apply(recepcion,paginadorFicha)
    
    def f:((Recepcion,utils.pagination.PaginadorFicha) => play.api.templates.HtmlFormat.Appendable) = (recepcion,paginadorFicha) => apply(recepcion,paginadorFicha)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:31 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/recepciones/verRecepcion.scala.html
                    HASH: ac0990aa0d4028cbf87e3c3de0555bb28d7aae8a
                    MATRIX: 839->1|1044->205|1058->212|1142->216|1194->233|1208->239|1280->290|1348->133|1380->157|1454->72|1483->201|1512->327|1549->330|1571->344|1625->377|1665->382|1678->387|1749->449|1789->451|1950->577|1996->614|2036->616|2484->1028|2504->1039|2607->1119|2755->1231|2775->1242|2853->1298|2989->1403|3091->1469|3111->1480|3212->1558|3271->1580|3290->1589|3335->1611|3414->1654|3432->1663|3461->1670|3520->1694|3533->1699|3580->1724|3680->1789|3726->1826|3766->1828|3816->1842|3836->1853|3928->1915|3945->1923|3977->1932|4091->2015|4131->2020|4180->2060|4220->2062|4270->2076|4290->2087|4384->2151|4401->2159|4433->2168|4585->2289|4659->2328|4728->2388|4767->2389|4892->2483|4976->2531|4993->2539|5101->2624|5220->2708|5269->2748|5308->2749|5397->2803|5434->2831|5474->2833|5540->2863|5560->2874|5666->2949|5684->2957|5716->2966|5831->3050|5947->3130|5970->3144|6010->3161|6052->3166|6076->3180|6117->3198|6162->3208|6199->3236|6239->3238|6305->3268|6325->3279|6431->3354|6449->3362|6481->3371|6597->3456|6645->3473|6849->3641|6867->3650|6896->3657|7127->3852|7145->3861|7190->3883|7407->4064|7443->4090|7484->4092|7523->4094|7542->4103|7577->4115|7612->4117|7830->4299|7898->4344|8121->4530|8140->4539|8208->4583|8417->4755|8432->4760|8491->4796|8662->4930|8683->4941|8755->4989|8808->5004|8828->5013|8855->5016|9107->5239|9137->5240|9260->5334|9290->5335|9362->5379|9391->5380|9424->5385|9453->5386|9508->5409
                    LINES: 26->1|33->6|33->6|35->6|36->7|36->7|36->7|37->5|37->5|38->1|39->5|40->8|41->9|41->9|41->9|43->11|43->11|43->11|43->11|49->17|49->17|49->17|57->25|57->25|57->25|61->29|61->29|61->29|63->31|68->36|68->36|68->36|68->36|68->36|68->36|69->37|69->37|69->37|74->42|74->42|74->42|78->46|78->46|78->46|79->47|79->47|79->47|79->47|79->47|80->48|81->49|81->49|81->49|82->50|82->50|82->50|82->50|82->50|83->51|86->54|86->54|86->54|88->56|91->59|91->59|91->59|93->61|93->61|93->61|97->65|97->65|97->65|98->66|98->66|98->66|98->66|98->66|99->67|100->68|100->68|100->68|100->68|100->68|100->68|101->69|101->69|101->69|102->70|102->70|102->70|102->70|102->70|103->71|105->73|114->82|114->82|114->82|119->87|119->87|119->87|124->92|124->92|124->92|124->92|124->92|124->92|124->92|129->97|129->97|134->102|134->102|134->102|142->110|142->110|142->110|149->117|149->117|149->117|149->117|149->117|149->117|161->129|161->129|163->131|163->131|165->133|165->133|166->134|166->134|170->138
                    -- GENERATED --
                */
            