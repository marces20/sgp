
package views.html.presupuesto.creditoPresupuestario

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
object listaCargas extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[List[LineaCreditoPresupuestario],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(listaFinal:List[LineaCreditoPresupuestario], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

import java.math.BigDecimal;var total=new java.math.BigDecimal(0);var totalr=new java.math.BigDecimal(0);

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.74*/("""
"""),format.raw/*5.70*/(""" 
"""),format.raw/*7.1*/("""
"""),_display_(Seq[Any](/*8.2*/views/*8.7*/.html.presupuesto.mainPresupuesto("Lista de Saldos Presupuestarios Cargado")/*8.83*/ {_display_(Seq[Any](format.raw/*8.85*/("""
<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Lista de créditos presupuestarios cargados</h1>
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
			</div>
		</div>
	</div>
	<div id="actions">
		<div class="row">
			<form action="" method="GET">
				<div class="col-sm-4">
					<label for="cuenta" class="control-label">Cuenta Presupuestaria</label>
					<div class="input-group">
						"""),_display_(Seq[Any](/*33.8*/inputText(formBuscador("cuenta"), 'class -> "form-control", 'id -> "cuentaAnalitica"))),format.raw/*33.93*/("""
						"""),_display_(Seq[Any](/*34.8*/inputText(formBuscador("cuenta_analitica_padre_id"), 'hidden -> "hidden", 'id -> "cuentaAnalitica_id"))),format.raw/*34.110*/("""
						<span class="input-group-addon">
							<a href="#" 
							   id="searchCuentaAnalitica" 
							   class="searchModal"
							   data-title="Selección de cuenta analítica" 
							   data-url=""""),_display_(Seq[Any](/*40.22*/controllers/*40.33*/.contabilidad.routes.CuentasAnaliticasController.modalBuscar())),format.raw/*40.95*/("""" 
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
					"""),_display_(Seq[Any](/*53.7*/select(formBuscador("ejercicio"), Ejercicio.getEjercicios().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*53.166*/("""
					</label>
				</div>
				<div class="col-sm-2">
					<div class="form-group">
					<label for="nombre" class="control-label">&nbsp;</label>
					<button  class="form-control btn btn-primary">Buscar</button>
					</div>
				</div>
				<div class="col-sm-2">
					<div class="form-group">
					<label for="nombre" class="control-label">&nbsp;</label>
					<a href=""""),_display_(Seq[Any](/*65.16*/controllers/*65.27*/.presupuesto.routes.CreditosPresupuestariosController.index())),format.raw/*65.88*/(""""  class="form-control btn btn-default">Limpiar</a>
					</div>
				</div>
			</form>
		</div>
	</div>
	"""),_display_(Seq[Any](/*71.3*/if(listaFinal == null || listaFinal.size() == 0)/*71.51*/ {_display_(Seq[Any](format.raw/*71.53*/("""
        
        <div class="well">
            <em>No se encuentran créditos</em>
        </div>
        
    """)))}/*77.7*/else/*77.12*/{_display_(Seq[Any](format.raw/*77.13*/("""
    	<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Fecha</th>
					<th>Cuenta</th>
					<th>Codigo</th>
					<th>Total</th>
				</tr>
			</thead>
			<tbody>
				"""),_display_(Seq[Any](/*89.6*/for(z <- listaFinal) yield /*89.26*/ {_display_(Seq[Any](format.raw/*89.28*/("""
					<tr>
						<td>"""),_display_(Seq[Any](/*91.12*/z/*91.13*/.creditoPresupuestario.nombre)),format.raw/*91.42*/("""</td>
						<td>"""),_display_(Seq[Any](/*92.12*/(utils.DateUtils.formatDate(z.creditoPresupuestario.fecha)))),format.raw/*92.71*/("""</td>
						<td>"""),_display_(Seq[Any](/*93.12*/z/*93.13*/.cuentaAnalitica.nombre)),format.raw/*93.36*/("""</td>
						<td>"""),_display_(Seq[Any](/*94.12*/z/*94.13*/.cuentaAnalitica.codigo)),format.raw/*94.36*/("""</td>
						<td>"""),_display_(Seq[Any](/*95.12*/utils/*95.17*/.NumberUtils.moneda(z.monto))),format.raw/*95.45*/("""</td>
					</tr>
					"""),_display_(Seq[Any](/*97.7*/{total = total.add(z.monto)})),format.raw/*97.35*/("""
				""")))})),format.raw/*98.6*/("""
			</tbody>
			<tfoot>
				<tr>
					<td colspan="3"></td>
					<td align="right">Total</td>
					<td>"""),_display_(Seq[Any](/*104.11*/utils/*104.16*/.NumberUtils.moneda(total))),format.raw/*104.42*/("""</td>
				</tr>
			</tfoot>
        </table>
    """)))})),format.raw/*108.6*/("""
""")))})),format.raw/*109.2*/("""
<script>
$(function()"""),format.raw/*111.13*/("""{"""),format.raw/*111.14*/("""
	$('#searchCuentaAnalitica').modalSearch();

	
"""),format.raw/*115.1*/("""}"""),format.raw/*115.2*/(""");
</script>
	"""))}
    }
    
    def render(listaFinal:List[LineaCreditoPresupuestario],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(listaFinal,formBuscador)
    
    def f:((List[LineaCreditoPresupuestario],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (listaFinal,formBuscador) => apply(listaFinal,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:36 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/presupuesto/creditoPresupuestario/listaCargas.scala.html
                    HASH: 23b25e5039e3d6fcfc1dbfb4fc4b32980ab0d8e5
                    MATRIX: 852->1|1171->130|1203->154|1277->73|1305->198|1333->307|1369->309|1381->314|1465->390|1504->392|2325->1178|2432->1263|2475->1271|2600->1373|2839->1576|2859->1587|2943->1649|3366->2037|3548->2196|3953->2565|3973->2576|4056->2637|4196->2742|4253->2790|4293->2792|4424->2906|4437->2911|4476->2912|4729->3130|4765->3150|4805->3152|4863->3174|4873->3175|4924->3204|4977->3221|5058->3280|5111->3297|5121->3298|5166->3321|5219->3338|5229->3339|5274->3362|5327->3379|5341->3384|5391->3412|5449->3435|5499->3463|5536->3469|5677->3573|5692->3578|5741->3604|5823->3654|5857->3656|5908->3678|5938->3679|6014->3727|6043->3728
                    LINES: 26->1|35->5|35->5|36->1|37->5|38->7|39->8|39->8|39->8|39->8|64->33|64->33|65->34|65->34|71->40|71->40|71->40|84->53|84->53|96->65|96->65|96->65|102->71|102->71|102->71|108->77|108->77|108->77|120->89|120->89|120->89|122->91|122->91|122->91|123->92|123->92|124->93|124->93|124->93|125->94|125->94|125->94|126->95|126->95|126->95|128->97|128->97|129->98|135->104|135->104|135->104|139->108|140->109|142->111|142->111|146->115|146->115
                    -- GENERATED --
                */
            