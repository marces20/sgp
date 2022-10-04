
package views.html.contabilidad.balance

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
object modalCambiarCuenta extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.29*/("""
"""),format.raw/*3.70*/(""" 
	
"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.contabilidad.routes.BalanceController.cambiarCuentaMasivo(), 'id -> "formCambiarCuentaBalance")/*5.130*/ {_display_(Seq[Any](format.raw/*5.132*/("""	
	
	"""),_display_(Seq[Any](/*7.3*/views/*7.8*/.html.tags.successError())),format.raw/*7.33*/("""
	<div class="col-sm-4">
		<label class="control-label">Cuenta Balance
			<div class="input-group">
				"""),_display_(Seq[Any](/*11.6*/inputText(formBuscador("cuenta.nombre"), 'name -> "", 'class -> "form-control", 'id -> "cuenta_modal"))),format.raw/*11.108*/("""
				"""),_display_(Seq[Any](/*12.6*/inputText(formBuscador("cuenta_id"), 'hidden -> "hidden", 'id -> "cuenta_id_modal"))),format.raw/*12.89*/("""
				<span class="input-group-addon">
					<a href="#" class="searchModal"
								id="searchCuentaModal" 
								data-title="Selección de Cuenta" 
								data-url=""""),_display_(Seq[Any](/*17.20*/controllers/*17.31*/.contabilidad.routes.CuentasController.modalBuscar())),format.raw/*17.83*/("""" 
								data-height="650" 
								data-width="700" 
								data-listen="modal.seleccion.cuenta.simple" 
								data-label="#cuenta_modal" 
								data-field="#cuenta_id_modal">
						<i class="glyphicon glyphicon-search"></i>
					</a>
				</span>
			</div>
		</label>
	</div>
	<div class="col-sm-5"><br />
		<button type="submit" class="btn btn-default" title="cambiar cuenta"><i class="glyphicon glyphicon-arrow-right"></i> Cambiar Cuenta</button>
	</div>

""")))})),format.raw/*33.2*/("""
<script>
$( function()"""),format.raw/*35.14*/("""{"""),format.raw/*35.15*/("""
	$('#searchCuentaModal').modalSearch();
	if($("#cuenta_modal").length)"""),format.raw/*37.31*/("""{"""),format.raw/*37.32*/("""
		var options = """),format.raw/*38.17*/("""{"""),format.raw/*38.18*/("""
				script:"/contabilidad/suggestCuenta/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*44.30*/("""{"""),format.raw/*44.31*/(""" 
											$("#cuenta_id_modal").val(obj.id); 
										 """),format.raw/*46.12*/("""}"""),format.raw/*46.13*/("""
			"""),format.raw/*47.4*/("""}"""),format.raw/*47.5*/(""";
		var as_json = new bsn.AutoSuggest('cuenta_modal', options);
	"""),format.raw/*49.2*/("""}"""),format.raw/*49.3*/("""	
"""),format.raw/*50.1*/("""}"""),format.raw/*50.2*/(""");
</script>
"""),_display_(Seq[Any](/*52.2*/flash()/*52.9*/.clear())))}
    }
    
    def render(formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(formBuscador)
    
    def f:((DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (formBuscador) => apply(formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:41 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/balance/modalCambiarCuenta.scala.html
                    HASH: cc253f74b147cfcd7ff3d1a2aa23a112cb958208
                    MATRIX: 813->1|942->47|974->71|1048->28|1076->115|1115->120|1128->126|1259->248|1299->250|1339->256|1351->261|1397->286|1537->391|1662->493|1703->499|1808->582|2012->750|2032->761|2106->813|2604->1280|2655->1303|2684->1304|2783->1375|2812->1376|2857->1393|2886->1394|3060->1540|3089->1541|3177->1601|3206->1602|3237->1606|3265->1607|3357->1672|3385->1673|3414->1675|3442->1676|3491->1690|3506->1697
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|35->7|35->7|35->7|39->11|39->11|40->12|40->12|45->17|45->17|45->17|61->33|63->35|63->35|65->37|65->37|66->38|66->38|72->44|72->44|74->46|74->46|75->47|75->47|77->49|77->49|78->50|78->50|80->52|80->52
                    -- GENERATED --
                */
            