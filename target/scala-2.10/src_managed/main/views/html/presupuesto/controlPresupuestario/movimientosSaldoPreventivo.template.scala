
package views.html.presupuesto.controlPresupuestario

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
object movimientosSaldoPreventivo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[DynamicForm,List[com.avaje.ebean.SqlRow],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm,s:List[com.avaje.ebean.SqlRow]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import models.auth._

import utils._

import java.math.BigDecimal;var totalPreventivo=new java.math.BigDecimal(0);var totalSaldo=new java.math.BigDecimal(0);var ultimoSaldo=new java.math.BigDecimal(0);

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.60*/("""
"""),format.raw/*5.70*/("""
"""),_display_(Seq[Any](/*7.2*/views/*7.7*/.html.presupuesto.mainPresupuesto("Control Presupuesto")/*7.63*/ {_display_(Seq[Any](format.raw/*7.65*/("""

	
<div class="page-header">
	<div class="row">
		<div class="col-sm-7">
			<h1>Movimientos Saldos/Preventivos</h1>
		</div>
		<div class="col-sm-5">
			<div class="dropdown pull-right">
				<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
			 		<i class="glyphicon glyphicon-list-alt"></i> Reportes<span class="caret"></span>
				</button>
				<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
					<li></li>
							
				</ul>
			</div>
		</div>
	</div>
</div>	
	"""),_display_(Seq[Any](/*28.3*/views/*28.8*/.html.tags.successError())),format.raw/*28.33*/("""
<div id="actions">
	<form action="" id="formSearchFacturas" method="GET">
		<div class="row">
			<div class="col-sm-4">
				<label for="cuenta" class="control-label">Cuenta Presupuestaria Padre</label>
				<div class="input-group">
					"""),_display_(Seq[Any](/*35.7*/inputText(formBuscador("cuenta"), 'class -> "form-control", 'id -> "cuentaAnalitica"))),format.raw/*35.92*/("""
					"""),_display_(Seq[Any](/*36.7*/inputText(formBuscador("cuenta_analitica_padre_id"), 'hidden -> "hidden", 'id -> "cuentaAnalitica_id"))),format.raw/*36.109*/("""
					<span class="input-group-addon">
						<a href="#" 
						   id="searchCuentaAnalitica" 
						   class="searchModal"
						   data-title="Selección de cuenta analítica" 
						   data-url=""""),_display_(Seq[Any](/*42.21*/controllers/*42.32*/.contabilidad.routes.CuentasAnaliticasController.modalBuscar())),format.raw/*42.94*/("""" 
						   data-height="650" 
						   data-width="700" 
						   data-listen="modal.seleccion.cuentaAnalitica.simple" 
						   data-label="#cuentaAnalitica" 
						   data-field="#cuentaAnalitica_id">
						   <i class="glyphicon glyphicon-search"></i>
						 </a>
					</span>
				</div>
			</div>
			 			
			 
			<div class="col-sm-2">
				<label class="control-label">Ejercicio
					"""),_display_(Seq[Any](/*57.7*/select(formBuscador("ejercicio"), Ejercicio.getEjercicios().map { p => p.id.toString -> p.nombre}, 
					'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*58.66*/("""
					
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
				<a href=""""),_display_(Seq[Any](/*73.15*/controllers/*73.26*/.presupuesto.routes.ControlPresupuestarioController.controlAnulacionProductosAutomaticos())),format.raw/*73.116*/(""""  class="form-control btn btn-default">Limpiar</a>
				</div>
			</div>
		</div>
	</form>
</div>
<div class="row">
	<div class="col-sm-6">	 
		"""),_display_(Seq[Any](/*81.4*/if(s.size() > 0)/*81.20*/{_display_(Seq[Any](format.raw/*81.21*/("""
			<table id="" class="table table-striped table-bordered">
				<thead>
					<tr>
					 	<th>Saldo</th>
						<th>Preventivo</th> 
						<th>Total</th>
						<th>Expediente</th>
						<th>Fecha</th>
					<tr>	
				</thead>
				<tbody>
				"""),_display_(Seq[Any](/*93.6*/for(sx <- s) yield /*93.18*/ {_display_(Seq[Any](format.raw/*93.20*/("""
					"""),_display_(Seq[Any](/*94.7*/if(sx.getInteger("etapa") == 5)/*94.38*/{_display_(Seq[Any](format.raw/*94.39*/("""
						<tr data-id="">
							 
								
							"""),_display_(Seq[Any](/*98.9*/{totalSaldo = ultimoSaldo.add(totalSaldo).subtract(totalPreventivo)})),format.raw/*98.77*/("""
							
							
							<td><b>SALDO</b></td>
							<td><b>"""),_display_(Seq[Any](/*102.16*/utils/*102.21*/.NumberUtils.moneda(totalSaldo))),format.raw/*102.52*/("""</b></td>
							
							
							
							<!-- =(B267+A269)-SUMA(B270:B342) -->
							<!-- ultimoSaldo+totalSaldo-(totalPreventivo) -->
							
							"""),_display_(Seq[Any](/*109.9*/{ultimoSaldo = sx.getBigDecimal("total")})),format.raw/*109.50*/("""	
							"""),_display_(Seq[Any](/*110.9*/{totalPreventivo = new java.math.BigDecimal(0)})),format.raw/*110.56*/("""
								
							 
							<td></td>
							<td></td>
							<td></td>
						</tr>
					
					""")))})),format.raw/*118.7*/("""
					<tr data-id="">
					
						"""),_display_(Seq[Any](/*121.8*/if(sx.getInteger("etapa") == 5)/*121.39*/{_display_(Seq[Any](format.raw/*121.40*/("""
							<td>"""),_display_(Seq[Any](/*122.13*/utils/*122.18*/.NumberUtils.moneda(sx.getBigDecimal("total")))),format.raw/*122.64*/("""</td>
							<td></td>
						""")))}/*124.8*/else/*124.12*/{_display_(Seq[Any](format.raw/*124.13*/("""
							<td></td>
							<td>"""),_display_(Seq[Any](/*126.13*/utils/*126.18*/.NumberUtils.moneda(sx.getBigDecimal("total")))),format.raw/*126.64*/("""</td>
							"""),_display_(Seq[Any](/*127.9*/{totalPreventivo = totalPreventivo.add(sx.getBigDecimal("total"))})),format.raw/*127.75*/("""
						""")))})),format.raw/*128.8*/("""	
						<td></td>
						<td>"""),_display_(Seq[Any](/*130.12*/sx/*130.14*/.getString("expediente"))),format.raw/*130.38*/("""</td>
						<td>"""),_display_(Seq[Any](/*131.12*/utils/*131.17*/.DateUtils.formatDate(sx.getDate("fecha")))),format.raw/*131.59*/("""</td>
					</tr>
				""")))})),format.raw/*133.6*/("""
						<tr data-id="">
							 
								
							"""),_display_(Seq[Any](/*137.9*/{totalSaldo = ultimoSaldo.add(totalSaldo).subtract(totalPreventivo)})),format.raw/*137.77*/("""
							
							
							<td><b>SALDO</b></td>
							<td><b>"""),_display_(Seq[Any](/*141.16*/utils/*141.21*/.NumberUtils.moneda(totalSaldo))),format.raw/*141.52*/("""</b></td>
							
							
							
							<!-- =(B267+A269)-SUMA(B270:B342) -->
							<!-- ultimoSaldo+totalSaldo-(totalPreventivo) -->
							
							 
								
							 
							<td></td>
							<td></td>
							<td></td>
						</tr>
				</tbody>
			</table>
		
		""")))})),format.raw/*158.4*/("""
	</div>
</div>		
""")))})),format.raw/*161.2*/("""

<script>
$(function()"""),format.raw/*164.13*/("""{"""),format.raw/*164.14*/("""
	$('#searchCuentaAnalitica').modalSearch();
	 
	
	 
	
"""),format.raw/*170.1*/("""}"""),format.raw/*170.2*/(""");
</script>"""))}
    }
    
    def render(formBuscador:DynamicForm,s:List[com.avaje.ebean.SqlRow]): play.api.templates.HtmlFormat.Appendable = apply(formBuscador,s)
    
    def f:((DynamicForm,List[com.avaje.ebean.SqlRow]) => play.api.templates.HtmlFormat.Appendable) = (formBuscador,s) => apply(formBuscador,s)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/presupuesto/controlPresupuestario/movimientosSaldoPreventivo.scala.html
                    HASH: 7ec4ac0365b448a994d4823174af1add8def4f79
                    MATRIX: 863->1|1226->116|1258->140|1332->59|1360->184|1396->351|1408->356|1472->412|1511->414|2089->957|2102->962|2149->987|2423->1226|2530->1311|2572->1318|2697->1420|2930->1617|2950->1628|3034->1690|3459->2080|3646->2245|4119->2682|4139->2693|4252->2783|4432->2928|4457->2944|4496->2945|4772->3186|4800->3198|4840->3200|4882->3207|4922->3238|4961->3239|5045->3288|5135->3356|5233->3417|5248->3422|5302->3453|5490->3605|5554->3646|5600->3656|5670->3703|5796->3797|5867->3832|5908->3863|5948->3864|5998->3877|6013->3882|6082->3928|6131->3958|6145->3962|6185->3963|6252->3993|6267->3998|6336->4044|6386->4058|6475->4124|6515->4132|6581->4161|6593->4163|6640->4187|6694->4204|6709->4209|6774->4251|6828->4273|6913->4322|7004->4390|7102->4451|7117->4456|7171->4487|7468->4752|7519->4771|7571->4794|7601->4795|7684->4850|7713->4851
                    LINES: 26->1|35->5|35->5|36->1|37->5|38->7|38->7|38->7|38->7|59->28|59->28|59->28|66->35|66->35|67->36|67->36|73->42|73->42|73->42|88->57|89->58|104->73|104->73|104->73|112->81|112->81|112->81|124->93|124->93|124->93|125->94|125->94|125->94|129->98|129->98|133->102|133->102|133->102|140->109|140->109|141->110|141->110|149->118|152->121|152->121|152->121|153->122|153->122|153->122|155->124|155->124|155->124|157->126|157->126|157->126|158->127|158->127|159->128|161->130|161->130|161->130|162->131|162->131|162->131|164->133|168->137|168->137|172->141|172->141|172->141|189->158|192->161|195->164|195->164|201->170|201->170
                    -- GENERATED --
                */
            