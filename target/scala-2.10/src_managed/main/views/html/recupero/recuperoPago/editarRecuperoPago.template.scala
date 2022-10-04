
package views.html.recupero.recuperoPago

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
object editarRecuperoPago extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[models.recupero.RecuperoPago],models.recupero.RecuperoPago,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(recuperoPagoForm: Form[models.recupero.RecuperoPago],recuperoPago:models.recupero.RecuperoPago):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

def /*5.2*/scripts/*5.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*5.13*/("""
	<script src=""""),_display_(Seq[Any](/*6.16*/routes/*6.22*/.Assets.at("javascripts/recupero/pago.js"))),format.raw/*6.64*/("""" type="text/javascript"></script>
""")))};implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.98*/("""
"""),format.raw/*3.70*/("""

"""),format.raw/*7.2*/("""

"""),_display_(Seq[Any](/*9.2*/views/*9.7*/.html.recupero.mainRecupero("Modificar Pago", scripts)/*9.61*/ {_display_(Seq[Any](format.raw/*9.63*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Editar pago</h1>
			</div>

			<div class="col-sm-5">
				<div class="dropdown pull-right">
				 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 	<i class="glyphicon glyphicon-list-alt"></i>
				    Reportes
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				    
				  </ul>
				</div>
				
				<div class="dropdown pull-right btn-header">
				 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 	<i class="glyphicon glyphicon-cog"></i>
				    Acciones
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				  	
				  </ul>
				</div>
					
				<!-- <div class="pull-right btn-header">
					<a href=""""),_display_(Seq[Any](/*41.16*/controllers/*41.27*/.recupero.routes.RecuperoPagosController.crear())),format.raw/*41.75*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo Pago</a>
				</div> -->
			</div>
			
			
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*49.3*/if(flash.containsKey("error"))/*49.33*/ {_display_(Seq[Any](format.raw/*49.35*/("""
		<div class="alert alert-danger">
			"""),_display_(Seq[Any](/*51.5*/flash/*51.10*/.get("error"))),format.raw/*51.23*/("""
		</div>
	""")))})),format.raw/*53.3*/("""
	

	"""),_display_(Seq[Any](/*56.3*/helper/*56.9*/.form(action = controllers.recupero.routes.RecuperoPagosController.actualizar(recuperoPago.id))/*56.104*/ {_display_(Seq[Any](format.raw/*56.106*/("""
	
	
		"""),_display_(Seq[Any](/*59.4*/inputText(recuperoPagoForm("id"), 'hidden -> "hidden"))),format.raw/*59.58*/("""
		"""),_display_(Seq[Any](/*60.4*/views/*60.9*/.html.recupero.recuperoPago.formRecuperoPago(recuperoPagoForm,recuperoPago))),format.raw/*60.84*/("""
		
		 """),_display_(Seq[Any](/*62.5*/views/*62.10*/.html.recupero.recuperoPago.tabsRecuperoPago(true, recuperoPagoForm))),format.raw/*62.78*/("""	
		
		
		
		
		<h4>Estado actual: 	<b>"""),_display_(Seq[Any](/*67.27*/recuperoPago/*67.39*/.estado.nombre)),format.raw/*67.53*/("""</b></h4>
		<div class="row margin-bottom-25">	
			
		</div>
		
	""")))})),format.raw/*72.3*/("""

""")))})),format.raw/*74.2*/("""




<script>

$( function() """),format.raw/*81.15*/("""{"""),format.raw/*81.16*/("""
	
	$( function() """),format.raw/*83.16*/("""{"""),format.raw/*83.17*/("""
		$('.datosPago').hide();
		if('"""),_display_(Seq[Any](/*85.8*/recuperoPago/*85.20*/.tipoPago)),format.raw/*85.29*/("""' == '"""),_display_(Seq[Any](/*85.36*/models/*85.42*/.recupero.RecuperoPago.PAGO_CHEQUE)),format.raw/*85.76*/("""') """),format.raw/*85.79*/("""{"""),format.raw/*85.80*/("""
			$('#datosCheque').show();
			$.get('"""),_display_(Seq[Any](/*87.12*/controllers/*87.23*/.recupero.routes.RecuperoChequesController.editar(recuperoPago.id))),format.raw/*87.89*/("""', function(data) """),format.raw/*87.107*/("""{"""),format.raw/*87.108*/("""
				$('#datosCheque').html(data);
			"""),format.raw/*89.4*/("""}"""),format.raw/*89.5*/(""")
		"""),format.raw/*90.3*/("""}"""),format.raw/*90.4*/("""
	"""),format.raw/*91.2*/("""}"""),format.raw/*91.3*/(""");
	

	
"""),format.raw/*95.1*/("""}"""),format.raw/*95.2*/(""");

</script>"""))}
    }
    
    def render(recuperoPagoForm:Form[models.recupero.RecuperoPago],recuperoPago:models.recupero.RecuperoPago): play.api.templates.HtmlFormat.Appendable = apply(recuperoPagoForm,recuperoPago)
    
    def f:((Form[models.recupero.RecuperoPago],models.recupero.RecuperoPago) => play.api.templates.HtmlFormat.Appendable) = (recuperoPagoForm,recuperoPago) => apply(recuperoPagoForm,recuperoPago)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:35 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/recupero/recuperoPago/editarRecuperoPago.scala.html
                    HASH: 0e53d69c890c9df7c18ef4c58df01fd4419b45ab
                    MATRIX: 866->1|1055->187|1069->194|1153->198|1204->214|1218->220|1281->262|1348->116|1380->140|1454->97|1482->184|1510->298|1547->301|1559->306|1621->360|1660->362|2664->1330|2684->1341|2754->1389|2932->1532|2971->1562|3011->1564|3086->1604|3100->1609|3135->1622|3178->1634|3219->1640|3233->1646|3338->1741|3379->1743|3422->1751|3498->1805|3537->1809|3550->1814|3647->1889|3690->1897|3704->1902|3794->1970|3870->2010|3891->2022|3927->2036|4024->2102|4058->2105|4115->2134|4144->2135|4190->2153|4219->2154|4288->2188|4309->2200|4340->2209|4383->2216|4398->2222|4454->2256|4485->2259|4514->2260|4591->2301|4611->2312|4699->2378|4746->2396|4776->2397|4841->2435|4869->2436|4900->2440|4928->2441|4957->2443|4985->2444|5020->2452|5048->2453
                    LINES: 26->1|29->5|29->5|31->5|32->6|32->6|32->6|33->3|33->3|34->1|35->3|37->7|39->9|39->9|39->9|39->9|71->41|71->41|71->41|79->49|79->49|79->49|81->51|81->51|81->51|83->53|86->56|86->56|86->56|86->56|89->59|89->59|90->60|90->60|90->60|92->62|92->62|92->62|97->67|97->67|97->67|102->72|104->74|111->81|111->81|113->83|113->83|115->85|115->85|115->85|115->85|115->85|115->85|115->85|115->85|117->87|117->87|117->87|117->87|117->87|119->89|119->89|120->90|120->90|121->91|121->91|125->95|125->95
                    -- GENERATED --
                */
            