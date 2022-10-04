
package views.html.haberes.liquidacionPuestos

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
object verLiquidacionPuesto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Form[models.haberes.LiquidacionPuesto],models.haberes.LiquidacionPuesto,utils.pagination.PaginadorFicha,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lcForm: Form[models.haberes.LiquidacionPuesto],lc:models.haberes.LiquidacionPuesto, paginadorFicha: utils.pagination.PaginadorFicha):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

def /*5.2*/scripts/*5.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*5.13*/("""
	<script src=""""),_display_(Seq[Any](/*6.16*/routes/*6.22*/.Assets.at("javascripts/haberes/liquidacionPuesto.js"))),format.raw/*6.76*/("""" type="text/javascript"></script>
""")))};implicit def /*8.2*/implicitFieldConstructor/*8.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.135*/("""
"""),_display_(Seq[Any](/*4.2*/paginadorFicha/*4.16*/.setActual(lc.id.toString))),format.raw/*4.42*/("""
"""),format.raw/*7.2*/("""
"""),format.raw/*8.70*/(""" 


"""),_display_(Seq[Any](/*11.2*/views/*11.7*/.html.haberes.mainHaberes("Vista Liquidación",scripts)/*11.61*/ {_display_(Seq[Any](format.raw/*11.63*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Vista Liquidación</h1>
			</div>
			<div class="col-sm-2">
				<!-- <a href=""""),_display_(Seq[Any](/*19.20*/controllers/*19.31*/.haberes.routes.LiquidacionPuestosController.crear())),format.raw/*19.83*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nueva Liquidación</a> -->
			</div>
		</div>
	</div>		
	"""),_display_(Seq[Any](/*23.3*/views/*23.8*/.html.tags.successError())),format.raw/*23.33*/("""
	<div class="row menu-acciones">
		<div class="col-sm-9">
			<a href=""""),_display_(Seq[Any](/*26.14*/controllers/*26.25*/.haberes.routes.LiquidacionPuestosController.editar(lc.id))),_display_(Seq[Any](/*26.84*/UriTrack/*26.92*/.get("&"))),format.raw/*26.101*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-edit"></i> Editar</a>
			<a href=""""),_display_(Seq[Any](/*27.14*/controllers/*27.25*/.haberes.routes.LiquidacionPuestosController.eliminar(lc.id))),_display_(Seq[Any](/*27.86*/UriTrack/*27.94*/.get("&"))),format.raw/*27.103*/(""""  class="btn btn-default delete-confirm-link"><i class="glyphicon glyphicon-trash icono-eliminar"></i> Eliminar</a>
		</div>
		<div class="col-sm-3">
			<a href=""""),_display_(Seq[Any](/*30.14*/UriTrack/*30.22*/.getOnNull(controllers.haberes.routes.LiquidacionPuestosController.index().absoluteURL()))),format.raw/*30.111*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a>

		"""),_display_(Seq[Any](/*32.4*/if(paginadorFicha.getLista().size() > 1)/*32.44*/{_display_(Seq[Any](format.raw/*32.45*/("""

		<div class="btn-group">
			"""),_display_(Seq[Any](/*35.5*/if(paginadorFicha.hasPrev())/*35.33*/ {_display_(Seq[Any](format.raw/*35.35*/("""
				<a  role="group" href=""""),_display_(Seq[Any](/*36.29*/controllers/*36.40*/.haberes.routes.LiquidacionPuestosController.ver(paginadorFicha.prev().toLong))),_display_(Seq[Any](/*36.119*/UriTrack/*36.127*/.get("&"))),format.raw/*36.136*/("""" class="btn btn-default"><i class="glyphicon glyphicon-chevron-left"></i></a>
			""")))})),format.raw/*37.5*/("""
			<p style="padding-top: 3px" href=""  role="group" class="btn btn-default">"""),_display_(Seq[Any](/*38.79*/paginadorFicha/*38.93*/.posicionActual())),format.raw/*38.110*/(""" de """),_display_(Seq[Any](/*38.115*/paginadorFicha/*38.129*/.getLista().size())),format.raw/*38.147*/("""</p>
			"""),_display_(Seq[Any](/*39.5*/if(paginadorFicha.hasNext())/*39.33*/ {_display_(Seq[Any](format.raw/*39.35*/("""
				<a  role="group" href=""""),_display_(Seq[Any](/*40.29*/controllers/*40.40*/.haberes.routes.LiquidacionPuestosController.ver(paginadorFicha.next().toLong))),_display_(Seq[Any](/*40.119*/UriTrack/*40.127*/.get("&"))),format.raw/*40.136*/("""" class="btn btn-default"><i class="glyphicon glyphicon-chevron-right"></i></a>
			""")))})),format.raw/*41.5*/("""  
		</div>
		""")))})),format.raw/*43.4*/("""
			
			 
		</div> 
	</div>	
	
	<input type="hidden" id="liquidacionPuestoId" name="liquidacionPuestoId" value=""""),_display_(Seq[Any](/*49.83*/lc/*49.85*/.id)),format.raw/*49.88*/(""""/>
	
	<div class="row">
		<div class="col-sm-4">
			<div class="form-group">
				<label class="control-label">N° Liquidación</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*55.50*/lcForm/*55.56*/.field("liquidacionMes.nro_liquidacion_parque").value)),format.raw/*55.109*/("""</p>
			</div>
		</div>
		<div class="col-sm-4">
			<div class="form-group">
				<label class="control-label">N° Liquidación Puesto</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*61.50*/lcForm/*61.56*/.field("nro_liq_puesto").value)),format.raw/*61.86*/("""</p>
			</div>
		</div>
		<div class="col-sm-4">
			<div class="form-group">
				<label class="control-label">Puesto Laboral</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*67.50*/lcForm/*67.56*/.field("puestoLaboral.legajo.agente.apellido").value)),format.raw/*67.108*/("""</p>
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*72.3*/views/*72.8*/.html.haberes.liquidacionPuestos.tabsLiquidacionPuesto(false,lcForm))),format.raw/*72.76*/(""" 
	
	<h4>Total C/A: <b>"""),_display_(Seq[Any](/*74.21*/utils/*74.26*/.NumberUtils.moneda(lc.getTotalCA()))),format.raw/*74.62*/("""</b></h4>	
	<h4>Total S/A: 	   <b>"""),_display_(Seq[Any](/*75.25*/utils/*75.30*/.NumberUtils.moneda(lc.getTotalSA()))),format.raw/*75.66*/("""</b></h4>	
	<h4>Total Retenciones: <b>"""),_display_(Seq[Any](/*76.29*/utils/*76.34*/.NumberUtils.moneda(lc.getTotalRetenciones()))),format.raw/*76.79*/("""</b></h4>	
	<h4>Total a Cobrar: <b>"""),_display_(Seq[Any](/*77.26*/utils/*77.31*/.NumberUtils.moneda(lc. getTotalACobrar()))),format.raw/*77.73*/("""</b></h4>	
	<h4>Estado actual: 	<b>"""),_display_(Seq[Any](/*78.26*/lc/*78.28*/.estado.nombre)),format.raw/*78.42*/("""</b></h4>
	
	<div class="row margin-bottom-25">	
		"""),_display_(Seq[Any](/*81.4*/for(estado <- models.Estado.getSiguienteEstadoPorAprobar(lc.estado.orden,models.Estado.TIPO_LIQUIDACION_PUESTOS)) yield /*81.117*/ {_display_(Seq[Any](format.raw/*81.119*/("""	
			"""),_display_(Seq[Any](/*82.5*/if(estado.orden <= 4)/*82.26*/ {_display_(Seq[Any](format.raw/*82.28*/("""
				<div class="col-sm-3">
					<a href=""""),_display_(Seq[Any](/*84.16*/controllers/*84.27*/.haberes.routes.LiquidacionPuestosController.cambiarEstado(lcForm.field("id").value.toInt, estado.id.toLong))),_display_(Seq[Any](/*84.136*/UriTrack/*84.144*/.get("&"))),format.raw/*84.153*/("""" class="btn btn-default">
						<i class="glyphicon glyphicon-arrow-right"></i> """),_display_(Seq[Any](/*85.56*/estado/*85.62*/.nombre)),format.raw/*85.69*/("""
					</a>
				</div>
				
			""")))})),format.raw/*89.5*/("""
		""")))})),format.raw/*90.4*/("""
		"""),_display_(Seq[Any](/*91.4*/if(lc.estado.id == models.Estado.LIQUIDACION_PUESTOS_CANCELADO)/*91.67*/ {_display_(Seq[Any](format.raw/*91.69*/("""
			<div class="col-sm-3">
				<a href=""""),_display_(Seq[Any](/*93.15*/controllers/*93.26*/.haberes.routes.LiquidacionPuestosController.cambiarEstado(lcForm.field("id").value.toInt, models.Estado.LIQUIDACION_PUESTOS_BORRADOR))),_display_(Seq[Any](/*93.161*/UriTrack/*93.169*/.get("&"))),format.raw/*93.178*/("""" class="btn btn-default">
					<i class="glyphicon glyphicon-arrow-right"></i> Volver a Borrador
				</a>
			</div>
		""")))}/*97.4*/else/*97.8*/{_display_(Seq[Any](format.raw/*97.9*/("""
			<div class="col-sm-3">
				<a href=""""),_display_(Seq[Any](/*99.15*/controllers/*99.26*/.haberes.routes.LiquidacionPuestosController.cambiarEstado(lcForm.field("id").value.toInt, models.Estado.LIQUIDACION_PUESTOS_CANCELADO))),_display_(Seq[Any](/*99.162*/UriTrack/*99.170*/.get("&"))),format.raw/*99.179*/("""" class="btn btn-default">
					<i class="glyphicon glyphicon-minus-sign"></i> Cancelar Liquidacion
				</a>
			</div>
		""")))})),format.raw/*103.4*/("""
		
		"""),_display_(Seq[Any](/*105.4*/if(lc.estado.id == models.Estado.LIQUIDACION_PUESTOS_BORRADOR)/*105.66*/ {_display_(Seq[Any](format.raw/*105.68*/("""
		<div class="col-sm-3">
			<a href=""""),_display_(Seq[Any](/*107.14*/controllers/*107.25*/.haberes.routes.LiquidacionPuestosController.preLiquidar(lc.puestoLaboral.id,lc.liquidacionMes.id,lc.id))),_display_(Seq[Any](/*107.130*/UriTrack/*107.138*/.get("&"))),format.raw/*107.147*/("""" class="btn btn-default">
				<i class="glyphicon glyphicon-ok"></i> Volver a Preliquidar
			</a>
		</div>
		""")))})),format.raw/*111.4*/("""
	</div>
	
	
""")))})))}
    }
    
    def render(lcForm:Form[models.haberes.LiquidacionPuesto],lc:models.haberes.LiquidacionPuesto,paginadorFicha:utils.pagination.PaginadorFicha): play.api.templates.HtmlFormat.Appendable = apply(lcForm,lc,paginadorFicha)
    
    def f:((Form[models.haberes.LiquidacionPuesto],models.haberes.LiquidacionPuesto,utils.pagination.PaginadorFicha) => play.api.templates.HtmlFormat.Appendable) = (lcForm,lc,paginadorFicha) => apply(lcForm,lc,paginadorFicha)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/liquidacionPuestos/verLiquidacionPuesto.scala.html
                    HASH: b67d6d51c19ac32ea7a45c783cc5b5c7a14cedb0
                    MATRIX: 913->1|1155->211|1169->218|1253->222|1304->238|1318->244|1393->298|1460->336|1492->360|1567->134|1603->169|1625->183|1672->209|1699->334|1727->404|1767->409|1780->414|1843->468|1883->470|2081->632|2101->643|2175->695|2340->825|2353->830|2400->855|2508->927|2528->938|2617->997|2634->1005|2666->1014|2794->1106|2814->1117|2905->1178|2922->1186|2954->1195|3154->1359|3171->1367|3283->1456|3393->1531|3442->1571|3481->1572|3548->1604|3585->1632|3625->1634|3690->1663|3710->1674|3820->1753|3838->1761|3870->1770|3984->1853|4099->1932|4122->1946|4162->1963|4204->1968|4228->1982|4269->2000|4313->2009|4350->2037|4390->2039|4455->2068|4475->2079|4585->2158|4603->2166|4635->2175|4750->2259|4796->2274|4945->2387|4956->2389|4981->2392|5200->2575|5215->2581|5291->2634|5516->2823|5531->2829|5583->2859|5801->3041|5816->3047|5891->3099|5962->3135|5975->3140|6065->3208|6125->3232|6139->3237|6197->3273|6268->3308|6282->3313|6340->3349|6415->3388|6429->3393|6496->3438|6568->3474|6582->3479|6646->3521|6718->3557|6729->3559|6765->3573|6852->3625|6982->3738|7023->3740|7064->3746|7094->3767|7134->3769|7213->3812|7233->3823|7373->3932|7391->3940|7423->3949|7541->4031|7556->4037|7585->4044|7647->4075|7682->4079|7721->4083|7793->4146|7833->4148|7910->4189|7930->4200|8096->4335|8114->4343|8146->4352|8284->4472|8296->4476|8334->4477|8411->4518|8431->4529|8598->4665|8616->4673|8648->4682|8802->4804|8845->4811|8917->4873|8958->4875|9034->4914|9055->4925|9192->5030|9211->5038|9244->5047|9387->5158
                    LINES: 26->1|31->5|31->5|33->5|34->6|34->6|34->6|35->8|35->8|36->1|37->4|37->4|37->4|38->7|39->8|42->11|42->11|42->11|42->11|50->19|50->19|50->19|54->23|54->23|54->23|57->26|57->26|57->26|57->26|57->26|58->27|58->27|58->27|58->27|58->27|61->30|61->30|61->30|63->32|63->32|63->32|66->35|66->35|66->35|67->36|67->36|67->36|67->36|67->36|68->37|69->38|69->38|69->38|69->38|69->38|69->38|70->39|70->39|70->39|71->40|71->40|71->40|71->40|71->40|72->41|74->43|80->49|80->49|80->49|86->55|86->55|86->55|92->61|92->61|92->61|98->67|98->67|98->67|103->72|103->72|103->72|105->74|105->74|105->74|106->75|106->75|106->75|107->76|107->76|107->76|108->77|108->77|108->77|109->78|109->78|109->78|112->81|112->81|112->81|113->82|113->82|113->82|115->84|115->84|115->84|115->84|115->84|116->85|116->85|116->85|120->89|121->90|122->91|122->91|122->91|124->93|124->93|124->93|124->93|124->93|128->97|128->97|128->97|130->99|130->99|130->99|130->99|130->99|134->103|136->105|136->105|136->105|138->107|138->107|138->107|138->107|138->107|142->111
                    -- GENERATED --
                */
            