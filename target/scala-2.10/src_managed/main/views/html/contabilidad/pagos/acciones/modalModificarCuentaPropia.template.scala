
package views.html.contabilidad.pagos.acciones

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
object modalModificarCuentaPropia extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.29*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.contabilidad.routes.PagosAccionesController.modificarCuentaPropia(), 'id -> "formModificarCuentaPropia")/*5.139*/ {_display_(Seq[Any](format.raw/*5.141*/("""
	
	"""),_display_(Seq[Any](/*7.3*/views/*7.8*/.html.tags.successError())),format.raw/*7.33*/("""
	
	"""),_display_(Seq[Any](/*9.3*/formBuscador("id_pago")/*9.26*/.error.map/*9.36*/{ error =>_display_(Seq[Any](format.raw/*9.46*/("""
		<div class="alert alert-danger"><i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*10.84*/error/*10.89*/.message)),format.raw/*10.97*/("""</div>
	""")))})),format.raw/*11.3*/("""
	
	<div id="alert-success" class="alert alert-success hide"></div>
	<div id="alert-danger" class="alert alert-danger hide"></div>
	
	<div class="row">
		<div class="col-sm-5">
			<div class="form-group """),_display_(Seq[Any](/*18.28*/if(formBuscador.error("cuenta_propia_id") != null)/*18.78*/ {_display_(Seq[Any](format.raw/*18.80*/("""has-error""")))}/*18.90*/else/*18.94*/{_display_(Seq[Any](format.raw/*18.95*/("""has-required""")))})),format.raw/*18.108*/("""">
				<label for="cuenta_propia_id" class="control-label">Cuenta propia</label> 
				<div class="input-group">
					"""),_display_(Seq[Any](/*21.7*/inputText(formBuscador("cuentaPropia.numero"), 'class -> "form-control", 'id -> "cuenta_propia"))),format.raw/*21.103*/("""
					"""),_display_(Seq[Any](/*22.7*/inputText(formBuscador("cuenta_propia_id"),'hidden -> "hidden", 'id -> "cuenta_propia_id"))),format.raw/*22.97*/("""
					<span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchCuentaPropiaModal" 
									data-title="Selección de Cuenta Propia" 
									data-url=""""),_display_(Seq[Any](/*27.21*/controllers/*27.32*/.contabilidad.routes.CuentasPropiasController.modalBuscar())),format.raw/*27.91*/("""" 
									data-height="650" 
									data-width="700" 
									data-listen="modal.seleccion.cuentaPropia.simple" 
									data-label="#cuenta_propia" 
									data-field="#cuenta_propia_id">
							<i class="glyphicon glyphicon-search"></i>
						</a>
					</span>
				</div>
				"""),_display_(Seq[Any](/*37.6*/formBuscador("cuenta_propia_id")/*37.38*/.error.map/*37.48*/{ error =>_display_(Seq[Any](format.raw/*37.58*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*38.31*/error/*38.36*/.message)),format.raw/*38.44*/("""</div>
				""")))})),format.raw/*39.6*/("""
			</div>
		</div>
		
		<div class="col-sm-5"><br />
			<button type="submit" class="btn btn-default" title="Guardar"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>
		</div>
		
	</div>
""")))})),format.raw/*48.2*/("""
<script>
$( function()"""),format.raw/*50.14*/("""{"""),format.raw/*50.15*/("""
	$('#searchCuentaPropiaModal').modalSearch();
"""),format.raw/*52.1*/("""}"""),format.raw/*52.2*/(""");
</script>
"""),_display_(Seq[Any](/*54.2*/flash()/*54.9*/.clear())),format.raw/*54.17*/("""

"""))}
    }
    
    def render(formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(formBuscador)
    
    def f:((DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (formBuscador) => apply(formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:38 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/pagos/acciones/modalModificarCuentaPropia.scala.html
                    HASH: 6057741f0d305c0a6c4170f589965c7521a5754f
                    MATRIX: 828->1|957->47|989->71|1063->28|1091->115|1129->119|1142->125|1282->256|1322->258|1361->263|1373->268|1419->293|1458->298|1489->321|1507->331|1554->341|1674->425|1688->430|1718->438|1758->447|1998->651|2057->701|2097->703|2126->713|2139->717|2178->718|2224->731|2377->849|2496->945|2538->952|2650->1042|2872->1228|2892->1239|2973->1298|3295->1585|3336->1617|3355->1627|3403->1637|3470->1668|3484->1673|3514->1681|3557->1693|3793->1898|3844->1921|3873->1922|3947->1969|3975->1970|4024->1984|4039->1991|4069->1999
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|35->7|35->7|35->7|37->9|37->9|37->9|37->9|38->10|38->10|38->10|39->11|46->18|46->18|46->18|46->18|46->18|46->18|46->18|49->21|49->21|50->22|50->22|55->27|55->27|55->27|65->37|65->37|65->37|65->37|66->38|66->38|66->38|67->39|76->48|78->50|78->50|80->52|80->52|82->54|82->54|82->54
                    -- GENERATED --
                */
            