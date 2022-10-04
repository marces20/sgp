
package views.html.rendiciones.pagosRealizados

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
object indexPagosRealizados extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[MiPago],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[MiPago], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.76*/("""
"""),format.raw/*4.70*/(""" 
"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.rendiciones.mainRendiciones("Lista de Pagos Realizados")/*5.69*/ {_display_(Seq[Any](format.raw/*5.71*/("""
<script>
$(function()"""),format.raw/*7.13*/("""{"""),format.raw/*7.14*/("""
	$(".inputDateMascara").mask("99/99/9999");
	 
"""),format.raw/*10.1*/("""}"""),format.raw/*10.2*/(""");
</script>
	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Lista de pagos realizados</h1>
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
						"""),_display_(Seq[Any](/*29.8*/inputText(formBuscador("fecha_desde"), 'class -> "form-control inputDateMascara", 'id -> "desde", 'placeholder -> "Desde"))),format.raw/*29.130*/("""
						"""),_display_(Seq[Any](/*30.8*/inputText(formBuscador("fecha_hasta"), 'class -> "form-control inputDateMascara", 'id -> "hasta", 'placeholder -> "Hasta"))),format.raw/*30.130*/("""
					</div>
				</div>
				
				<div class="col-sm-2">
					<label class="control-label">Tipo de pago</label>
							"""),_display_(Seq[Any](/*36.9*/select(formBuscador("tipo"), MiPago.Tipo.values().map { p => p.key().toString() -> p.value()}, 
							'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*37.68*/("""
				</div>
				
				<div class="col-sm-2">
					<div class="form-group">
					<label for="nombre" class="control-label">&nbsp;</label>
					<button  class="form-control btn btn-primary"><i class="glyphicon glyphicon-search"></i> Buscar</button>
					</div>
				</div>
				<div class="col-sm-2">
					<div class="form-group">
					<label for="nombre" class="control-label">&nbsp;</label>
					<a href=""""),_display_(Seq[Any](/*49.16*/controllers/*49.27*/.rendiciones.routes.RendicionesController.indexPagosRealizados())),format.raw/*49.91*/(""""  class="form-control btn btn-default">Limpiar</a>
					</div>
				</div>
			</form>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*56.3*/if(buscador.getTotalRowCount == 0)/*56.37*/ {_display_(Seq[Any](format.raw/*56.39*/("""
        
        <div class="well">
            <em>No se encuentran pagos</em>
        </div>
        
    """)))}/*62.7*/else/*62.12*/{_display_(Seq[Any](format.raw/*62.13*/("""
		
		Mostrando """),_display_(Seq[Any](/*64.14*/buscador/*64.22*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*64.54*/(""" resultado(s). 
		
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
			"""),_display_(Seq[Any](/*81.5*/for(miPago <- buscador.getList) yield /*81.36*/ {_display_(Seq[Any](format.raw/*81.38*/("""
				<tr>
					<td class="notSeleccion">
						
					</td>
					<td>"""),_display_(Seq[Any](/*86.11*/MiPago/*86.17*/.Tipo.getValue(miPago.tipo))),format.raw/*86.44*/("""</td>
					<td>"""),_display_(Seq[Any](/*87.11*/miPago/*87.17*/.numero_envio)),format.raw/*87.30*/("""</td>
					<td>"""),_display_(Seq[Any](/*88.11*/miPago/*88.17*/.numero_lote)),format.raw/*88.29*/("""</td>
					<td>"""),_display_(Seq[Any](/*89.11*/DateUtils/*89.20*/.formatDate(miPago.fecha))),format.raw/*89.45*/("""</td>
					<td>"""),_display_(Seq[Any](/*90.11*/miPago/*90.17*/.cantidad)),format.raw/*90.26*/("""</td>
					<td>"""),_display_(Seq[Any](/*91.11*/miPago/*91.17*/.monto)),format.raw/*91.23*/("""</td>
					<td>"""),_display_(Seq[Any](/*92.11*/if(MiPago.Tipo.AGENTE_CONTRATADO.key() == miPago.tipo)/*92.65*/{_display_(Seq[Any](format.raw/*92.66*/("""
								<i class="glyphicon glyphicon-save"></i> 
								<a href=""""),_display_(Seq[Any](/*94.19*/controllers/*94.30*/.contabilidad.routes.PagosAccionesController.descargarRendiciones(miPago.id))),format.raw/*94.106*/("""" id="descarga">Descargar archivo Rendiciones</a>
							""")))})),format.raw/*95.9*/("""
					</td>
				</tr>
             """)))})),format.raw/*98.15*/("""
	        </tbody>
        </table>
		
		<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*103.8*/views/*103.13*/.html.helpers.paginador(buscador, controllers.rendiciones.routes.RendicionesController.indexPagosRealizados()))),format.raw/*103.123*/("""
		</div>
 	 """)))})),format.raw/*105.5*/("""
""")))})),format.raw/*106.2*/("""	"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[MiPago],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[MiPago],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:31 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rendiciones/pagosRealizados/indexPagosRealizados.scala.html
                    HASH: 48e9a66dadf1f8c9fb990e54c427af29ac2e9f53
                    MATRIX: 858->1|1052->113|1084->137|1158->75|1187->181|1225->185|1237->190|1307->252|1346->254|1397->278|1425->279|1503->330|1531->331|2007->772|2152->894|2196->903|2341->1025|2501->1150|2687->1314|3138->1729|3158->1740|3244->1804|3393->1918|3436->1952|3476->1954|3610->2071|3623->2076|3662->2077|3717->2096|3734->2104|3788->2136|4252->2565|4299->2596|4339->2598|4449->2672|4464->2678|4513->2705|4566->2722|4581->2728|4616->2741|4669->2758|4684->2764|4718->2776|4771->2793|4789->2802|4836->2827|4889->2844|4904->2850|4935->2859|4988->2876|5003->2882|5031->2888|5084->2905|5147->2959|5186->2960|5293->3031|5313->3042|5412->3118|5502->3177|5573->3216|5698->3305|5713->3310|5847->3420|5895->3436|5930->3439
                    LINES: 26->1|31->4|31->4|32->1|33->4|34->5|34->5|34->5|34->5|36->7|36->7|39->10|39->10|58->29|58->29|59->30|59->30|65->36|66->37|78->49|78->49|78->49|85->56|85->56|85->56|91->62|91->62|91->62|93->64|93->64|93->64|110->81|110->81|110->81|115->86|115->86|115->86|116->87|116->87|116->87|117->88|117->88|117->88|118->89|118->89|118->89|119->90|119->90|119->90|120->91|120->91|120->91|121->92|121->92|121->92|123->94|123->94|123->94|124->95|127->98|132->103|132->103|132->103|134->105|135->106
                    -- GENERATED --
                */
            