
package views.html.contabilidad.ordenesPagosCircuitos.acciones

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
object modalCargarExpedienteFisico extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.29*/("""
"""),format.raw/*3.70*/(""" 
	
"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.contabilidad.routes.OrdenesPagosCircuitosAccionesController.cargarExpedienteFisico(), 'id -> "formCargarExpedienteFisico")/*5.157*/ {_display_(Seq[Any](format.raw/*5.159*/("""	
	
	"""),_display_(Seq[Any](/*7.3*/views/*7.8*/.html.tags.successError())),format.raw/*7.33*/("""
	
	<div class="row">
		<div class="col-sm-4">
			<div class="form-group """),_display_(Seq[Any](/*11.28*/if(formBuscador.error("expediente_fisico_id") != null)/*11.82*/ {_display_(Seq[Any](format.raw/*11.84*/("""has-error""")))}/*11.94*/else/*11.98*/{_display_(Seq[Any](format.raw/*11.99*/("""has-required""")))})),format.raw/*11.112*/("""">
				<label for="inputExpediente" class="control-label">Expediente Fisico</label>
				<div class="input-group">
					"""),_display_(Seq[Any](/*14.7*/inputText(formBuscador("expedienteFisico.expedienteEjercicio"),'class -> "form-control",'id -> "expedienteFisico"))),format.raw/*14.121*/("""
					"""),_display_(Seq[Any](/*15.7*/inputText(formBuscador("expediente_fisico_id"),'hidden -> "hidden", 'id -> "expediente_fisico_id"))),format.raw/*15.105*/("""
					<span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchExpediente2" 
									data-title="Selección de expediente" 
									data-url=""""),_display_(Seq[Any](/*20.21*/controllers/*20.32*/.expediente.routes.ExpedientesController.modalBuscarCopia())),format.raw/*20.91*/("""" 
									data-height="650" 
									data-width="700" 
									data-listen="modal.seleccion.expediente.simple" 
									data-label="#expedienteFisico" 
									data-field="#expediente_fisico_id">
							<i class="glyphicon glyphicon-search"></i>
						</a>
					</span>
				</div>
				"""),_display_(Seq[Any](/*30.6*/formBuscador("expediente_id")/*30.35*/.error.map/*30.45*/{ error =>_display_(Seq[Any](format.raw/*30.55*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*31.31*/error/*31.36*/.message)),format.raw/*31.44*/("""</div>
				""")))})),format.raw/*32.6*/("""
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-5"><br />
			<button type="submit" class="btn btn-default" title="Agregar Expediente Fisico"><i class="glyphicon glyphicon-arrow-right"></i> Cargar Expediente</button>
		</div>
	</div>

""")))})),format.raw/*42.2*/("""
<script>
$( function()"""),format.raw/*44.14*/("""{"""),format.raw/*44.15*/("""
	if($("#expedienteFisico").length)"""),format.raw/*45.35*/("""{"""),format.raw/*45.36*/("""
		var options = """),format.raw/*46.17*/("""{"""),format.raw/*46.18*/("""
				script:"/suggestExpedienteCopia/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*52.30*/("""{"""),format.raw/*52.31*/(""" 
											$("#expediente_fisico_id").val(obj.id); 
										 """),format.raw/*54.12*/("""}"""),format.raw/*54.13*/("""
			"""),format.raw/*55.4*/("""}"""),format.raw/*55.5*/(""";
		var as_json = new bsn.AutoSuggest('expedienteFisico', options);
	"""),format.raw/*57.2*/("""}"""),format.raw/*57.3*/("""
	$('#searchExpediente2').modalSearch();
"""),format.raw/*59.1*/("""}"""),format.raw/*59.2*/(""");
</script>
"""),_display_(Seq[Any](/*61.2*/flash()/*61.9*/.clear())))}
    }
    
    def render(formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(formBuscador)
    
    def f:((DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (formBuscador) => apply(formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/ordenesPagosCircuitos/acciones/modalCargarExpedienteFisico.scala.html
                    HASH: 43e51cc1a61b1f31ecc9843455b5ac9e557decda
                    MATRIX: 845->1|974->47|1006->71|1080->28|1108->115|1147->120|1160->126|1318->275|1358->277|1398->283|1410->288|1456->313|1566->387|1629->441|1669->443|1698->453|1711->457|1750->458|1796->471|1951->591|2088->705|2130->712|2251->810|2464->987|2484->998|2565->1057|2892->1349|2930->1378|2949->1388|2997->1398|3064->1429|3078->1434|3108->1442|3151->1454|3437->1709|3488->1732|3517->1733|3580->1768|3609->1769|3654->1786|3683->1787|3853->1929|3882->1930|3975->1995|4004->1996|4035->2000|4063->2001|4159->2070|4187->2071|4255->2112|4283->2113|4332->2127|4347->2134
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|35->7|35->7|35->7|39->11|39->11|39->11|39->11|39->11|39->11|39->11|42->14|42->14|43->15|43->15|48->20|48->20|48->20|58->30|58->30|58->30|58->30|59->31|59->31|59->31|60->32|70->42|72->44|72->44|73->45|73->45|74->46|74->46|80->52|80->52|82->54|82->54|83->55|83->55|85->57|85->57|87->59|87->59|89->61|89->61
                    -- GENERATED --
                */
            