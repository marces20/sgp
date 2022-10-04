
package views.html.expediente.iniciador

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
object indexIniciadorExpediente extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[IniciadorExpediente],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[IniciadorExpediente], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.89*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.expediente.mainExpediente("Lista iniciador expediente")/*5.68*/ {_display_(Seq[Any](format.raw/*5.70*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-8">
				<h1>Lista de iniciador de expediente</h1>
			</div>
			
		<div class="col-sm-4">
			<div class="pull-right col-sm-4">
				<a href=""""),_display_(Seq[Any](/*15.15*/controllers/*15.26*/.expediente.routes.IniciadorExpedientesController.crearIniciadorExpediente)),format.raw/*15.100*/(""""  class="btn btn-default">Nuevo iniciador expediente</a>
			</div>

		</div>
			
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*23.3*/views/*23.8*/.html.tags.successError())),format.raw/*23.33*/("""
	
	<div id="actions">
		<div class="row">
			<form action="" method="GET">
				<div class="col-sm-3">
					<div class="form-group">
						<label for="nombre" class="control-label">Nombre
						"""),_display_(Seq[Any](/*31.8*/inputText(formBuscador("nombre"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*31.94*/("""
						</label>
					</div>
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
					<a href=""""),_display_(Seq[Any](/*44.16*/controllers/*44.27*/.expediente.routes.IniciadorExpedientesController.indexIniciadorExpediente())),format.raw/*44.103*/(""""  class="form-control btn btn-default">Limpiar</a>
					</div>
				</div>
			</form>
		</div>
	</div>	

	
	"""),_display_(Seq[Any](/*52.3*/if(buscador.getTotalRowCount == 0)/*52.37*/ {_display_(Seq[Any](format.raw/*52.39*/("""
        <div class="well">
            <em>No se encuentran iniciador expediente</em>
        </div>
    """)))}/*56.7*/else/*56.12*/{_display_(Seq[Any](format.raw/*56.13*/("""
		
		Mostrando """),_display_(Seq[Any](/*58.14*/buscador/*58.22*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*58.54*/(""" resultado(s). 
		
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
			"""),_display_(Seq[Any](/*70.5*/for(iniciadorExpediente <- buscador.getList) yield /*70.49*/ {_display_(Seq[Any](format.raw/*70.51*/("""
				<tr>
					<td>
						<a href=""""),_display_(Seq[Any](/*73.17*/controllers/*73.28*/.expediente.routes.IniciadorExpedientesController.editarIniciadorExpediente(iniciadorExpediente.id))),format.raw/*73.127*/("""">
							<i class="glyphicon glyphicon-edit"></i>
						</a>
					</td>
					<td>"""),_display_(Seq[Any](/*77.11*/(iniciadorExpediente.id))),format.raw/*77.35*/("""</td>
					<td>"""),_display_(Seq[Any](/*78.11*/(iniciadorExpediente.nombre))),format.raw/*78.39*/("""</td>
					<td>
						<a href=""""),_display_(Seq[Any](/*80.17*/controllers/*80.28*/.expediente.routes.IniciadorExpedientesController.eliminarIniciadorExpediente(iniciadorExpediente.id))),format.raw/*80.129*/("""">
							<i class="glyphicon glyphicon-remove-circle"></i>
						</a>
					</td>
				</tr>
             """)))})),format.raw/*85.15*/("""
	        </tbody>
        </table>
		
		<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*90.8*/views/*90.13*/.html.helpers.paginador(buscador, controllers.expediente.routes.IniciadorExpedientesController.indexIniciadorExpediente()))),format.raw/*90.135*/("""
		</div>
 	 """)))})),format.raw/*92.5*/("""
""")))})),format.raw/*93.2*/("""
		
		
	
	"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[IniciadorExpediente],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[IniciadorExpediente],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:36 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/expediente/iniciador/indexIniciadorExpediente.scala.html
                    HASH: bf0bf97f767987e3c089bf57871d324a8e63dfe1
                    MATRIX: 868->1|1057->107|1089->131|1163->88|1191->175|1229->179|1241->184|1310->245|1349->247|1596->458|1616->469|1713->543|1851->646|1864->651|1911->676|2141->871|2249->957|2667->1339|2687->1350|2786->1426|2930->1535|2973->1569|3013->1571|3138->1679|3151->1684|3190->1685|3243->1702|3260->1710|3314->1742|3586->1979|3646->2023|3686->2025|3758->2061|3778->2072|3900->2171|4019->2254|4065->2278|4117->2294|4167->2322|4235->2354|4255->2365|4379->2466|4517->2572|4636->2656|4650->2661|4795->2783|4840->2797|4873->2799
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|43->15|43->15|43->15|51->23|51->23|51->23|59->31|59->31|72->44|72->44|72->44|80->52|80->52|80->52|84->56|84->56|84->56|86->58|86->58|86->58|98->70|98->70|98->70|101->73|101->73|101->73|105->77|105->77|106->78|106->78|108->80|108->80|108->80|113->85|118->90|118->90|118->90|120->92|121->93
                    -- GENERATED --
                */
            