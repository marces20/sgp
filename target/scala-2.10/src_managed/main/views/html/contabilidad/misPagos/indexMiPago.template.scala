
package views.html.contabilidad.misPagos

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
object indexMiPago extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[MiPago],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[MiPago], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

def /*5.2*/scripts/*5.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*5.13*/("""
	<script src=""""),_display_(Seq[Any](/*6.16*/routes/*6.22*/.Assets.at("javascripts/contabilidad/pagos.js"))),format.raw/*6.69*/("""" type="text/javascript"></script>
""")))};implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.76*/("""
"""),format.raw/*4.70*/(""" 
"""),format.raw/*7.2*/("""
"""),_display_(Seq[Any](/*8.2*/views/*8.7*/.html.contabilidad.mainContabilidad("Lista de Mis Pagos",scripts)/*8.72*/ {_display_(Seq[Any](format.raw/*8.74*/("""
<script>
$(function()"""),format.raw/*10.13*/("""{"""),format.raw/*10.14*/("""
	$(".inputDateMascara").mask("99/99/9999");
	 
"""),format.raw/*13.1*/("""}"""),format.raw/*13.2*/(""");
</script>
	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Lista de mis pagos</h1>
			</div>
			<div class="col-sm-2">
				<div class="pull-right btn-header">
				</div>
			</div>
		</div>
	</div>
	<div id="actions">
		<div class="row">
			<form action="" method="GET">
				<div class="col-sm-2 input-group">
					<label class="control-label">Fecha fin</label>
					<div>
						"""),_display_(Seq[Any](/*32.8*/inputText(formBuscador("fecha_desde"), 'class -> "form-control inputDateMascara", 'id -> "desde", 'placeholder -> "Desde"))),format.raw/*32.130*/("""
						"""),_display_(Seq[Any](/*33.8*/inputText(formBuscador("fecha_hasta"), 'class -> "form-control inputDateMascara", 'id -> "hasta", 'placeholder -> "Hasta"))),format.raw/*33.130*/("""
					</div>
				</div>
				
				<div class="col-sm-2">
					<label class="control-label">Tipo de pago</label>
							"""),_display_(Seq[Any](/*39.9*/select(formBuscador("tipo"), MiPago.Tipo.values().map { p => p.key().toString() -> p.value()}, 
							'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*40.68*/("""
				</div>
				
				<div class="col-sm-2">
					<div class="form-group">
						<label for="nombre" class="control-label">Ref. Pago
						"""),_display_(Seq[Any](/*46.8*/inputText(formBuscador("referencia"), 'class -> "form-control"))),format.raw/*46.71*/("""
						</label>
					</div>
				</div>
				<div class="col-sm-2">
				<label for="orden_pago_id" class="control-label">Orden de pago N° 
					<div class="input-group">
						"""),_display_(Seq[Any](/*53.8*/inputText(formBuscador("ordenPago.numero"), 'class -> "form-control", 'id -> "orden_pago"))),format.raw/*53.98*/("""
						"""),_display_(Seq[Any](/*54.8*/inputText(formBuscador("ordenPago.id"),'hidden -> "hidden", 'id -> "orden_pago_id"))),format.raw/*54.91*/("""
						<span class="input-group-addon">
							<a href="#" class="searchModal"
										id="searchPeriodo" 
										data-title="Selección de órdenes de pago" 
										data-url=""""),_display_(Seq[Any](/*59.22*/controllers/*59.33*/.contabilidad.routes.OrdenesPagosController.modalBuscar())),format.raw/*59.90*/("""" 
										data-height="650" 
										data-width="700" 
										data-listen="modal.seleccion.orden-pago.simple" 
										data-label="#orden_pago" 
										data-field="#orden_pago_id">
								<i class="glyphicon glyphicon-search"></i>
							</a>
						</span>
					</div>
				</label>
				</div>
			</div>	
			<div class="row">
				<div class="col-sm-2">
					<div class="form-group">
					<label for="nombre" class="control-label">&nbsp;</label>
					<button  class="form-control btn btn-primary"><i class="glyphicon glyphicon-search"></i> Buscar</button>
					</div>
				</div>
				<div class="col-sm-2">
					<div class="form-group">
					<label for="nombre" class="control-label">&nbsp;</label>
					<a href=""""),_display_(Seq[Any](/*82.16*/controllers/*82.27*/.contabilidad.routes.MisPagosController.index())),format.raw/*82.74*/(""""  class="form-control btn btn-default">Limpiar</a>
					</div>
				</div>
			</form>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*89.3*/if(buscador.getTotalRowCount == 0)/*89.37*/ {_display_(Seq[Any](format.raw/*89.39*/("""
        
        <div class="well">
            <em>No se encuentran pagos</em>
        </div>
        
    """)))}/*95.7*/else/*95.12*/{_display_(Seq[Any](format.raw/*95.13*/("""
		
		Mostrando """),_display_(Seq[Any](/*97.14*/buscador/*97.22*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*97.54*/(""" resultado(s). 
		
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th width="50">#</th>
					<th width="130">Tipo</th>
					<th width="100">N° Envio</th>
					<th width="100">N° Lote</th>
					<th width="80">Fecha</th>
					<th width="80">Cantidad</th>
					<th width="80">Monto Total</th>
					<th width="380"></th>
					<th class="50">#</th>
				</tr>
			</thead>
			<tbody>
			"""),_display_(Seq[Any](/*114.5*/for(miPago <- buscador.getList) yield /*114.36*/ {_display_(Seq[Any](format.raw/*114.38*/("""
				<tr>
					<td class="notSeleccion">
						<a class="btn btn-default btn-xs notSeleccion" href=""""),_display_(Seq[Any](/*117.61*/controllers/*117.72*/.contabilidad.routes.MisPagosController.editar(miPago.id))),format.raw/*117.129*/("""&"""),_display_(Seq[Any](/*117.131*/UriTrack/*117.139*/.encode())),format.raw/*117.148*/("""">
							<i class="glyphicon glyphicon-edit"></i>
						</a>
					</td>
					<td>"""),_display_(Seq[Any](/*121.11*/MiPago/*121.17*/.Tipo.getValue(miPago.tipo))),format.raw/*121.44*/("""</td>
					<td>"""),_display_(Seq[Any](/*122.11*/miPago/*122.17*/.numero_envio)),format.raw/*122.30*/("""</td>
					<td>"""),_display_(Seq[Any](/*123.11*/miPago/*123.17*/.numero_lote)),format.raw/*123.29*/("""</td>
					<td>"""),_display_(Seq[Any](/*124.11*/DateUtils/*124.20*/.formatDate(miPago.fecha))),format.raw/*124.45*/("""</td>
					<td>"""),_display_(Seq[Any](/*125.11*/miPago/*125.17*/.cantidad)),format.raw/*125.26*/("""</td>
					<td>"""),_display_(Seq[Any](/*126.11*/miPago/*126.17*/.monto)),format.raw/*126.23*/("""</td>
					<td>"""),_display_(Seq[Any](/*127.11*/if(MiPago.Tipo.AGENTE_CONTRATADO.key() == miPago.tipo)/*127.65*/{_display_(Seq[Any](format.raw/*127.66*/("""<i class="glyphicon glyphicon-save"></i> <a href=""""),_display_(Seq[Any](/*127.117*/controllers/*127.128*/.contabilidad.routes.PagosAccionesController.descargarOpg(miPago.id))),format.raw/*127.196*/("""" id="descarga">Descargar archivo OPG</a> <i class="glyphicon glyphicon-save"></i> <a href=""""),_display_(Seq[Any](/*127.289*/controllers/*127.300*/.contabilidad.routes.PagosAccionesController.descargarBnf(miPago.id))),format.raw/*127.368*/("""" id="descarga">Descargar archivo BNF</a>""")))})),format.raw/*127.410*/("""</td>
				</tr>
             """)))})),format.raw/*129.15*/("""
	        </tbody>
        </table>
		
		<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*134.8*/views/*134.13*/.html.helpers.paginador(buscador, controllers.contabilidad.routes.MisPagosController.index()))),format.raw/*134.106*/("""
		</div>
 	 """)))})),format.raw/*136.5*/("""
""")))})),format.raw/*137.2*/("""	"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[MiPago],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[MiPago],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:39 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/misPagos/indexMiPago.scala.html
                    HASH: 493e319d25f564b7ea01cb0b8528ca9485c20faa
                    MATRIX: 843->1|1028->185|1042->192|1126->196|1178->213|1192->219|1260->266|1328->113|1360->137|1434->75|1463->181|1492->303|1529->306|1541->311|1614->376|1653->378|1705->402|1734->403|1812->454|1840->455|2309->889|2454->1011|2498->1020|2643->1142|2803->1267|2989->1431|3169->1576|3254->1639|3471->1821|3583->1911|3627->1920|3732->2003|3956->2191|3976->2202|4055->2259|4839->3007|4859->3018|4928->3065|5077->3179|5120->3213|5160->3215|5294->3332|5307->3337|5346->3338|5401->3357|5418->3365|5472->3397|5937->3826|5985->3857|6026->3859|6167->3963|6188->3974|6269->4031|6309->4033|6328->4041|6361->4050|6485->4137|6501->4143|6551->4170|6605->4187|6621->4193|6657->4206|6711->4223|6727->4229|6762->4241|6816->4258|6835->4267|6883->4292|6937->4309|6953->4315|6985->4324|7039->4341|7055->4347|7084->4353|7138->4370|7202->4424|7242->4425|7331->4476|7353->4487|7445->4555|7576->4648|7598->4659|7690->4727|7766->4769|7831->4801|7956->4890|7971->4895|8088->4988|8136->5004|8171->5007
                    LINES: 26->1|31->5|31->5|33->5|34->6|34->6|34->6|35->4|35->4|36->1|37->4|38->7|39->8|39->8|39->8|39->8|41->10|41->10|44->13|44->13|63->32|63->32|64->33|64->33|70->39|71->40|77->46|77->46|84->53|84->53|85->54|85->54|90->59|90->59|90->59|113->82|113->82|113->82|120->89|120->89|120->89|126->95|126->95|126->95|128->97|128->97|128->97|145->114|145->114|145->114|148->117|148->117|148->117|148->117|148->117|148->117|152->121|152->121|152->121|153->122|153->122|153->122|154->123|154->123|154->123|155->124|155->124|155->124|156->125|156->125|156->125|157->126|157->126|157->126|158->127|158->127|158->127|158->127|158->127|158->127|158->127|158->127|158->127|158->127|160->129|165->134|165->134|165->134|167->136|168->137
                    -- GENERATED --
                */
            