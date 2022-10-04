
package views.html.dashboard.liquidaciones

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
object liquidacionesPorEscala extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template5[DynamicForm,String,List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm,escala_laboral_id:String,
rowParque:List[com.avaje.ebean.SqlRow],
rowConvenio:List[com.avaje.ebean.SqlRow],
rowPlanta:List[com.avaje.ebean.SqlRow]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

import java.lang.Integer;var c =0;var x =0

implicit def /*8.2*/implicitFieldConstructor/*8.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*4.40*/("""
"""),format.raw/*8.70*/("""
"""),_display_(Seq[Any](/*10.2*/views/*10.7*/.html.dashboard.mainDashboard("Liquidaciones por Escala Laboral")/*10.72*/ {_display_(Seq[Any](format.raw/*10.74*/("""
<script>
$( function()"""),format.raw/*12.14*/("""{"""),format.raw/*12.15*/(""" $('.searchModal').modalSearch();"""),format.raw/*12.48*/("""}"""),format.raw/*12.49*/(""")

</script>
<script src=""""),_display_(Seq[Any](/*15.15*/routes/*15.21*/.Assets.at("javascripts/dashboard/liquidacionesPorProfesion.js"))),format.raw/*15.85*/("""" type="text/javascript"></script>
<div class="page-header">
	<div class="row">
		<div class="col-sm-7">
			<h1>Liquidaciones por Escala Laboral</h1>
		</div>
		<div class="col-sm-5">
			<div class="dropdown pull-right">
			 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
			 	<i class="glyphicon glyphicon-list-alt"></i>
			    Reportes
			    <span class="caret"></span>
			  </button>
			  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
			  	<li><a tabindex="-1" href="#" id="liquidacionesPorEscalaReporte" data-url=""""),_display_(Seq[Any](/*29.83*/controllers/*29.94*/.dashboard.routes.LiquidacionesReportesController.liquidacionesPorEscala())),format.raw/*29.168*/("""">Exportar</a></li>
			  </ul>
			</div>
		</div>
	</div>
</div>	

<div id="actions">
	<form action="" method="GET">
		<div class="row">
			<form action="" id="formSearchLiquidacionesPorEscala" method="GET">
			<div class="col-sm-2">
				<label for="inputPeriodo" class="control-label">Periodo</label> 
				<div class="input-group">
					"""),_display_(Seq[Any](/*43.7*/inputText(formBuscador("periodo"),'class -> "form-control",'id -> "periodo"))),format.raw/*43.83*/("""
					"""),_display_(Seq[Any](/*44.7*/inputText(formBuscador("periodo_id"),'hidden -> "hidden",'id -> "periodo_id"))),format.raw/*44.84*/("""
					<span class="input-group-addon">
					<a href="#" class="searchModal"
								id="searchPeriodo" 
								data-title="Selección de Periodo" 
								data-url=""""),_display_(Seq[Any](/*49.20*/controllers/*49.31*/.contabilidad.routes.PeriodosController.modalBuscar())),format.raw/*49.84*/("""" 
								data-height="650" 
								data-width="700" 
								data-listen="modal.seleccion.periodo.simple" 
								data-label="#periodo" 
								data-field="#periodo_id">
						<i class="glyphicon glyphicon-search"></i>
					</a>
					</span>
				</div>
			</div>
			<div class="col-sm-4">
				<label for="solicitante" class="control-label">Escala Laboral</label> 
				<div class="input-group">
					"""),_display_(Seq[Any](/*63.7*/inputText(formBuscador("escalaLaboral.nombre"), 'name -> "", 'class -> "form-control", 'id -> "escala_laboral"))),format.raw/*63.118*/("""
					"""),_display_(Seq[Any](/*64.7*/inputText(formBuscador("escala_laboral_id"), 'hidden -> "hidden", 'id -> "escala_laboral_id"))),format.raw/*64.100*/("""
					<span class="input-group-addon">
					<a href="#" class="searchModal" id="searchEscalaLaboral" 
							 	data-title="Selección de escala" 
							 	data-url=""""),_display_(Seq[Any](/*68.21*/controllers/*68.32*/.haberes.routes.EscalasLaboralesController.modalBuscar())),format.raw/*68.88*/("""" 
							 	data-height="650" data-width="700" 
							 	data-listen="modal.seleccion.escalaLaboral.simple" 
							 	data-label="#escala_laboral" 
							 	data-field="#escala_laboral_id">
					<i class="glyphicon glyphicon-search"></i></a></span>
				</div>
			</div>
			<div class="col-sm-2">
				<div class="form-group">
				<label for="nombre" class="control-label">&nbsp;</label>
				<button  class="form-control btn btn-primary"><i class="glyphicon glyphicon-search"></i> Buscar</button>
				</div>
			</div>
			</form>
		</div>
	</form>
</div>
<hr>
	"""),_display_(Seq[Any](/*87.3*/if(rowParque != null)/*87.24*/{_display_(Seq[Any](format.raw/*87.25*/("""
		"""),_display_(Seq[Any](/*88.4*/if(rowParque.size() > 0)/*88.28*/{_display_(Seq[Any](format.raw/*88.29*/("""
			<div class="row">
				<div class="col-sm-12">
					<h2>PARQUE SALUD</h2>
					
					<table class="table table-bordered">
						<thead>
							<tr>
								<td>CANTIDAD</td>
								<td>PROFESION</td>
								<td align="center">HABER BRUTO</td>
								<td align="center">GUARDIA</td>
								<td align="center">PRODUCCION</td>	
								<td align="center">ADICIONALES</td>	
								<td align="center">DESCUENTOS</td>	
								<td align="center">NETO</td>
							</tr>
						</thead>
						<tbody>
							"""),_display_(Seq[Any](/*107.9*/for(rp <- rowParque) yield /*107.29*/{_display_(Seq[Any](format.raw/*107.30*/("""
								"""),_display_(Seq[Any](/*108.10*/if(rp.getInteger("idTipoRelacion").compareTo(1) == 0)/*108.63*/{_display_(Seq[Any](format.raw/*108.64*/("""
									"""),_display_(Seq[Any](/*109.11*/{c = c+rp.getInteger("cant")})),format.raw/*109.40*/("""
									<tr>
										<td align="center">"""),_display_(Seq[Any](/*111.31*/rp/*111.33*/.getInteger("cant"))),format.raw/*111.52*/("""</td>
										<td>"""),_display_(Seq[Any](/*112.16*/rp/*112.18*/.getString("profesion"))),format.raw/*112.41*/("""</td>
										<td align="center">	
											"""),_display_(Seq[Any](/*114.13*/(utils.NumberUtils.moneda(rp.getBigDecimal("haber"))))),format.raw/*114.66*/("""
										</td>
										<td align="center">
											"""),_display_(Seq[Any](/*117.13*/(utils.NumberUtils.moneda(rp.getBigDecimal("guardias"))))),format.raw/*117.69*/("""
										</td>
										<td align="center">
											"""),_display_(Seq[Any](/*120.13*/(utils.NumberUtils.moneda(rp.getBigDecimal("produccion"))))),format.raw/*120.71*/("""
										</td>
										<td align="center">
											"""),_display_(Seq[Any](/*123.13*/(utils.NumberUtils.moneda(rp.getBigDecimal("adicional"))))),format.raw/*123.70*/("""
										</td>
										<td align="center">
											"""),_display_(Seq[Any](/*126.13*/(utils.NumberUtils.moneda(rp.getBigDecimal("descuentos"))))),format.raw/*126.71*/("""
										</td>
										<td align="center">"""),_display_(Seq[Any](/*128.31*/(utils.NumberUtils.moneda(rp.getBigDecimal("neto"))))),format.raw/*128.83*/("""</td>
									</tr>
								""")))})),format.raw/*130.10*/("""
							""")))})),format.raw/*131.9*/("""		
							<tr>
										<td>TOTAL """),_display_(Seq[Any](/*133.22*/c)),format.raw/*133.23*/("""</td>
							</tr>						
						</tbody>
					</table>		
				</div>
			</div>	
		""")))})),format.raw/*139.4*/("""
	""")))})),format.raw/*140.3*/("""
	"""),_display_(Seq[Any](/*141.3*/{c = 0})),format.raw/*141.10*/("""
	"""),_display_(Seq[Any](/*142.3*/if(rowConvenio != null)/*142.26*/{_display_(Seq[Any](format.raw/*142.27*/("""
		"""),_display_(Seq[Any](/*143.4*/if(rowConvenio.size() > 0)/*143.30*/{_display_(Seq[Any](format.raw/*143.31*/("""
			<div class="row">
				<div class="col-sm-12">
					<h2>CONVENIO MINISTERIO</h2>
					
					<table class="table table-bordered">
						<thead>
							<tr>
								<td>CANTIDAD</td>
								<td>PROFESION</td>
								<td align="center">HABER BRUTO</td>
								<td align="center">GUARDIA</td>
								<td align="center">PRODUCCION</td>	
								<td align="center">ADICIONALES</td>	
								<td align="center">DESCUENTOS</td>	
								<td align="center">NETO</td>
							</tr>
						</thead>
						<tbody>
							"""),_display_(Seq[Any](/*162.9*/for(rp <- rowConvenio) yield /*162.31*/{_display_(Seq[Any](format.raw/*162.32*/("""
								"""),_display_(Seq[Any](/*163.10*/if(rp.getInteger("idTipoRelacion").compareTo(3) == 0)/*163.63*/{_display_(Seq[Any](format.raw/*163.64*/("""
								"""),_display_(Seq[Any](/*164.10*/{c = c+rp.getInteger("cant")})),format.raw/*164.39*/("""
									<tr>
										<td align="center">"""),_display_(Seq[Any](/*166.31*/rp/*166.33*/.getInteger("cant"))),format.raw/*166.52*/("""</td>
										<td>"""),_display_(Seq[Any](/*167.16*/rp/*167.18*/.getString("profesion"))),format.raw/*167.41*/("""</td>
										<td align="center">	
											"""),_display_(Seq[Any](/*169.13*/(utils.NumberUtils.moneda(rp.getBigDecimal("haber"))))),format.raw/*169.66*/("""
										</td>
										<td align="center">
											"""),_display_(Seq[Any](/*172.13*/(utils.NumberUtils.moneda(rp.getBigDecimal("guardias"))))),format.raw/*172.69*/("""
										</td>
										<td align="center">
											"""),_display_(Seq[Any](/*175.13*/(utils.NumberUtils.moneda(rp.getBigDecimal("produccion"))))),format.raw/*175.71*/("""
										</td>
										<td align="center">
											"""),_display_(Seq[Any](/*178.13*/(utils.NumberUtils.moneda(rp.getBigDecimal("adicional"))))),format.raw/*178.70*/("""
										</td>
										<td align="center">
											"""),_display_(Seq[Any](/*181.13*/(utils.NumberUtils.moneda(rp.getBigDecimal("descuentos"))))),format.raw/*181.71*/("""
										</td>
										<td align="center">"""),_display_(Seq[Any](/*183.31*/(utils.NumberUtils.moneda(rp.getBigDecimal("neto"))))),format.raw/*183.83*/("""</td>
									</tr>
								""")))})),format.raw/*185.10*/("""
							""")))})),format.raw/*186.9*/("""			
							<tr>
										<td>TOTAL """),_display_(Seq[Any](/*188.22*/c)),format.raw/*188.23*/("""</td>
							</tr>		
						</tbody>
					</table>		
				</div>
			</div>	
		""")))})),format.raw/*194.4*/("""
	""")))})),format.raw/*195.3*/("""
	"""),_display_(Seq[Any](/*196.3*/{c = 0})),format.raw/*196.10*/("""
	"""),_display_(Seq[Any](/*197.3*/if(rowPlanta != null)/*197.24*/{_display_(Seq[Any](format.raw/*197.25*/("""
		"""),_display_(Seq[Any](/*198.4*/if(rowPlanta.size() > 0)/*198.28*/{_display_(Seq[Any](format.raw/*198.29*/("""
			<div class="row">
				<div class="col-sm-12">
					<h2>PLANTA</h2>
					
					<table class="table table-bordered">
						<thead>
							<tr>
								<td>CANTIDAD</td>
								<td>PROFESION</td>
								
								<td align="center">HABER BRUTO</td>
								<td align="center">GUARDIA</td>
								<td align="center">PRODUCCION</td>	
								<td align="center">ADICIONALES</td>	
								<td align="center">DESCUENTOS</td>	
								<td align="center">NETO</td>
							</tr>
						</thead>
						<tbody>
							"""),_display_(Seq[Any](/*218.9*/for(rp <- rowPlanta) yield /*218.29*/{_display_(Seq[Any](format.raw/*218.30*/("""
								"""),_display_(Seq[Any](/*219.10*/if(rp.getInteger("idTipoRelacion").compareTo(3) != 0 && rp.getInteger("idTipoRelacion").compareTo(1) != 0)/*219.116*/{_display_(Seq[Any](format.raw/*219.117*/("""
								"""),_display_(Seq[Any](/*220.10*/{c = c+rp.getInteger("cant")})),format.raw/*220.39*/("""
									<tr>
										<td align="center">"""),_display_(Seq[Any](/*222.31*/rp/*222.33*/.getInteger("cant"))),format.raw/*222.52*/("""</td>
										<td>"""),_display_(Seq[Any](/*223.16*/rp/*223.18*/.getString("profesion"))),format.raw/*223.41*/("""</td>
										<td align="center">	
											"""),_display_(Seq[Any](/*225.13*/(utils.NumberUtils.moneda(rp.getBigDecimal("haber"))))),format.raw/*225.66*/("""
										</td>
										<td align="center">
											"""),_display_(Seq[Any](/*228.13*/(utils.NumberUtils.moneda(rp.getBigDecimal("guardias"))))),format.raw/*228.69*/("""
										</td>
										<td align="center">
											"""),_display_(Seq[Any](/*231.13*/(utils.NumberUtils.moneda(rp.getBigDecimal("produccion"))))),format.raw/*231.71*/("""
										</td>
										<td align="center">
											"""),_display_(Seq[Any](/*234.13*/(utils.NumberUtils.moneda(rp.getBigDecimal("adicional"))))),format.raw/*234.70*/("""
										</td>
										<td align="center">
											"""),_display_(Seq[Any](/*237.13*/(utils.NumberUtils.moneda(rp.getBigDecimal("descuentos"))))),format.raw/*237.71*/("""
										</td>
										<td align="center">"""),_display_(Seq[Any](/*239.31*/(utils.NumberUtils.moneda(rp.getBigDecimal("neto"))))),format.raw/*239.83*/("""</td>
									</tr>
								""")))})),format.raw/*241.10*/("""
							""")))})),format.raw/*242.9*/("""		
							<tr>
										<td>TOTAL """),_display_(Seq[Any](/*244.22*/c)),format.raw/*244.23*/("""</td>
							</tr>			
						</tbody>
					</table>		
				</div>
			</div>	
		""")))})),format.raw/*250.4*/("""
	""")))})),format.raw/*251.3*/("""
""")))})))}
    }
    
    def render(formBuscador:DynamicForm,escala_laboral_id:String,rowParque:List[com.avaje.ebean.SqlRow],rowConvenio:List[com.avaje.ebean.SqlRow],rowPlanta:List[com.avaje.ebean.SqlRow]): play.api.templates.HtmlFormat.Appendable = apply(formBuscador,escala_laboral_id,rowParque,rowConvenio,rowPlanta)
    
    def f:((DynamicForm,String,List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow],List[com.avaje.ebean.SqlRow]) => play.api.templates.HtmlFormat.Appendable) = (formBuscador,escala_laboral_id,rowParque,rowConvenio,rowPlanta) => apply(formBuscador,escala_laboral_id,rowParque,rowConvenio,rowPlanta)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:44:01 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/liquidaciones/liquidacionesPorEscala.scala.html
                    HASH: fbfdb49617ba33a30227b94fc2ab43155fcb5b54
                    MATRIX: 914->1|1272->232|1304->256|1378->175|1406->300|1443->346|1456->351|1530->416|1570->418|1621->441|1650->442|1711->475|1740->476|1803->503|1818->509|1904->573|2544->1177|2564->1188|2661->1262|3035->1601|3133->1677|3175->1684|3274->1761|3476->1927|3496->1938|3571->1991|4011->2396|4145->2507|4187->2514|4303->2607|4504->2772|4524->2783|4602->2839|5196->3398|5226->3419|5265->3420|5304->3424|5337->3448|5376->3449|5920->3957|5957->3977|5997->3978|6044->3988|6107->4041|6147->4042|6195->4053|6247->4082|6329->4127|6341->4129|6383->4148|6441->4169|6453->4171|6499->4194|6585->4243|6661->4296|6757->4355|6836->4411|6932->4470|7013->4528|7109->4587|7189->4644|7285->4703|7366->4761|7450->4808|7525->4860|7588->4890|7629->4899|7702->4935|7726->4936|7839->5017|7874->5020|7913->5023|7943->5030|7982->5033|8015->5056|8055->5057|8095->5061|8131->5087|8171->5088|8722->5603|8761->5625|8801->5626|8848->5636|8911->5689|8951->5690|8998->5700|9050->5729|9132->5774|9144->5776|9186->5795|9244->5816|9256->5818|9302->5841|9388->5890|9464->5943|9560->6002|9639->6058|9735->6117|9816->6175|9912->6234|9992->6291|10088->6350|10169->6408|10253->6455|10328->6507|10391->6537|10432->6546|10506->6583|10530->6584|10639->6661|10674->6664|10713->6667|10743->6674|10782->6677|10813->6698|10853->6699|10893->6703|10927->6727|10967->6728|11514->7239|11551->7259|11591->7260|11638->7270|11755->7376|11796->7377|11843->7387|11895->7416|11977->7461|11989->7463|12031->7482|12089->7503|12101->7505|12147->7528|12233->7577|12309->7630|12405->7689|12484->7745|12580->7804|12661->7862|12757->7921|12837->7978|12933->8037|13014->8095|13098->8142|13173->8194|13236->8224|13277->8233|13350->8269|13374->8270|13484->8348|13519->8351
                    LINES: 26->1|38->8|38->8|39->4|40->8|41->10|41->10|41->10|41->10|43->12|43->12|43->12|43->12|46->15|46->15|46->15|60->29|60->29|60->29|74->43|74->43|75->44|75->44|80->49|80->49|80->49|94->63|94->63|95->64|95->64|99->68|99->68|99->68|118->87|118->87|118->87|119->88|119->88|119->88|138->107|138->107|138->107|139->108|139->108|139->108|140->109|140->109|142->111|142->111|142->111|143->112|143->112|143->112|145->114|145->114|148->117|148->117|151->120|151->120|154->123|154->123|157->126|157->126|159->128|159->128|161->130|162->131|164->133|164->133|170->139|171->140|172->141|172->141|173->142|173->142|173->142|174->143|174->143|174->143|193->162|193->162|193->162|194->163|194->163|194->163|195->164|195->164|197->166|197->166|197->166|198->167|198->167|198->167|200->169|200->169|203->172|203->172|206->175|206->175|209->178|209->178|212->181|212->181|214->183|214->183|216->185|217->186|219->188|219->188|225->194|226->195|227->196|227->196|228->197|228->197|228->197|229->198|229->198|229->198|249->218|249->218|249->218|250->219|250->219|250->219|251->220|251->220|253->222|253->222|253->222|254->223|254->223|254->223|256->225|256->225|259->228|259->228|262->231|262->231|265->234|265->234|268->237|268->237|270->239|270->239|272->241|273->242|275->244|275->244|281->250|282->251
                    -- GENERATED --
                */
            