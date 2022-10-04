
package views.html.delegacion.depositos

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
object indexDeposito extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[Deposito],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[Deposito], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.78*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.delegacion.mainDelegaciones("Lista Depositos")/*5.59*/ {_display_(Seq[Any](format.raw/*5.61*/("""
	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Lista de depósitos</h1>
			</div>
	
			<div class="col-sm-2">
				<a href=""""),_display_(Seq[Any](/*13.15*/controllers/*13.26*/.delegacion.routes.DepositosController.crear)),format.raw/*13.70*/(""""  class="form-control btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Agregar depósito</a>
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*18.3*/views/*18.8*/.html.tags.successError())),format.raw/*18.33*/("""
	
	<div id="actions">
		<div class="row">
			<form action="" method="GET">
				<div class="col-sm-3">
					<div class="form-group">
						<label for="nombre" class="control-label">Nombre
						"""),_display_(Seq[Any](/*26.8*/inputText(formBuscador("nombre"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*26.94*/("""
						</label>
					</div>
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
					<a href=""""),_display_(Seq[Any](/*39.16*/controllers/*39.27*/.delegacion.routes.DepositosController.index())),format.raw/*39.73*/(""""  class="form-control btn btn-default">Limpiar</a>
					</div>
				</div>
			</form>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*46.3*/if(buscador.getTotalRowCount == 0)/*46.37*/ {_display_(Seq[Any](format.raw/*46.39*/("""
        <div class="well">
            <em>No se encuentran depósitos</em>
        </div>
    """)))}/*50.7*/else/*50.12*/{_display_(Seq[Any](format.raw/*50.13*/("""
    	Mostrando """),_display_(Seq[Any](/*51.17*/buscador/*51.25*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*51.57*/(""" resultado(s). 
		
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th width="50">#</th>
					<th width="100">Código</th>
					<th>Nombre</th>
					<th class="50">#</th>
				</tr>
			</thead>
			<tbody>
			"""),_display_(Seq[Any](/*63.5*/for(deposito <- buscador.getList) yield /*63.38*/ {_display_(Seq[Any](format.raw/*63.40*/("""
				<tr>
					<td>
						<a class="btn btn-default btn-xs notSeleccion" href=""""),_display_(Seq[Any](/*66.61*/controllers/*66.72*/.delegacion.routes.DepositosController.editar(deposito.id))),format.raw/*66.130*/("""">
							<i class="glyphicon glyphicon-edit"></i>
						</a>
					</td>
					<td>"""),_display_(Seq[Any](/*70.11*/(deposito.id))),format.raw/*70.24*/("""</td>
					<td>"""),_display_(Seq[Any](/*71.11*/(deposito.nombre))),format.raw/*71.28*/("""</td>
					<td>
						<a class="btn btn-default btn-xs delete-confirm-link notSeleccion" href=""""),_display_(Seq[Any](/*73.81*/controllers/*73.92*/.delegacion.routes.DepositosController.eliminar(deposito.id))),format.raw/*73.152*/("""">
							<i class="glyphicon glyphicon-remove-circle"></i>
						</a>
					</td>
				</tr>
             """)))})),format.raw/*78.15*/("""
	        </tbody>
        </table>
    	
    	<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*83.8*/views/*83.13*/.html.helpers.paginador(buscador, controllers.delegacion.routes.DepositosController.index()))),format.raw/*83.105*/("""
		</div>
 	 """)))})),format.raw/*85.5*/("""
""")))})))}
    }
    
    def render(buscador:utils.pagination.Pagination[Deposito],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[Deposito],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:29 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/delegacion/depositos/indexDeposito.scala.html
                    HASH: 824074006642c8f4f21ecd7cf292bfa933eddb57
                    MATRIX: 846->1|1024->96|1056->120|1130->77|1158->164|1196->168|1208->173|1268->225|1307->227|1502->386|1522->397|1588->441|1761->579|1774->584|1821->609|2051->804|2159->890|2620->1315|2640->1326|2708->1372|2850->1479|2893->1513|2933->1515|3047->1612|3060->1617|3099->1618|3152->1635|3169->1643|3223->1675|3495->1912|3544->1945|3584->1947|3700->2027|3720->2038|3801->2096|3920->2179|3955->2192|4007->2208|4046->2225|4178->2321|4198->2332|4281->2392|4419->2498|4544->2588|4558->2593|4673->2685|4718->2699
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|41->13|41->13|41->13|46->18|46->18|46->18|54->26|54->26|67->39|67->39|67->39|74->46|74->46|74->46|78->50|78->50|78->50|79->51|79->51|79->51|91->63|91->63|91->63|94->66|94->66|94->66|98->70|98->70|99->71|99->71|101->73|101->73|101->73|106->78|111->83|111->83|111->83|113->85
                    -- GENERATED --
                */
            