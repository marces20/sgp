
package views.html.contabilidad.ordenesPagos

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
object formOrdenPago extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[OrdenPago],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formOrden: Form[OrdenPago]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.30*/("""
"""),format.raw/*4.70*/(""" 

<script>
$(function()"""),format.raw/*7.13*/("""{"""),format.raw/*7.14*/("""
	$("#fecha").mask("99/99/9999");
	$("#numero").numeric_input("""),format.raw/*9.29*/("""{"""),format.raw/*9.30*/("""decimal: null, initialParse: false"""),format.raw/*9.64*/("""}"""),format.raw/*9.65*/(""");
	$("#monto").numeric_input();
"""),format.raw/*11.1*/("""}"""),format.raw/*11.2*/(""");
</script>


<div class="row menu-acciones">
	<div class="col-sm-10">
		<button type="submit" class="btn btn-default" title="Guardar orden de pago"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>	
    	<a href=""""),_display_(Seq[Any](/*18.16*/if( UriTrack.decode() )/*18.39*/{_display_(Seq[Any](format.raw/*18.40*/(""" """),_display_(Seq[Any](/*18.42*/UriTrack/*18.50*/.decode())),format.raw/*18.59*/(""" """)))}/*18.62*/else/*18.67*/{_display_(Seq[Any](_display_(Seq[Any](/*18.69*/controllers/*18.80*/.contabilidad.routes.OrdenesPagosController.index())),_display_(Seq[Any](/*18.132*/UriTrack/*18.140*/.decode()))))})),format.raw/*18.150*/("""" title="Cancelar editar" class="btn btn-default"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
    </div>
	<div class="col-sm-2">
		<a href=""""),_display_(Seq[Any](/*21.13*/UriTrack/*21.21*/.decode())),format.raw/*21.30*/("""" title="Volver al listado" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
	</div>
</div>

<input type="hidden" name="""),_display_(Seq[Any](/*25.28*/UriTrack/*25.36*/.getKey())),format.raw/*25.45*/(""" value=""""),_display_(Seq[Any](/*25.54*/UriTrack/*25.62*/.code())),format.raw/*25.69*/("""" />
<div class="row">
	<div class="col-sm-2 """),_display_(Seq[Any](/*27.24*/if(formOrden.error("numero") != null)/*27.61*/ {_display_(Seq[Any](format.raw/*27.63*/("""has-error""")))}/*27.73*/else/*27.77*/{_display_(Seq[Any](format.raw/*27.78*/("""has-required""")))})),format.raw/*27.91*/("""">
		<label class="control-label">Número
			"""),_display_(Seq[Any](/*29.5*/inputText(formOrden("numero"), 'class -> "form-control", 'id -> "numero", 'autofocus -> "autofocus"))),format.raw/*29.105*/("""
		</label> 
		"""),_display_(Seq[Any](/*31.4*/formOrden("numero")/*31.23*/.error.map/*31.33*/{ error =>_display_(Seq[Any](format.raw/*31.43*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*32.29*/error/*32.34*/.message)),format.raw/*32.42*/("""</div>
		""")))})),format.raw/*33.4*/("""
	</div>

	
	<div class="col-sm-2 """),_display_(Seq[Any](/*37.24*/if(formOrden.error("ejercicio_id") != null)/*37.67*/ {_display_(Seq[Any](format.raw/*37.69*/("""has-error""")))}/*37.79*/else/*37.83*/{_display_(Seq[Any](format.raw/*37.84*/("""has-required""")))})),format.raw/*37.97*/("""">
		<label class="control-label">Ejercicio
			"""),_display_(Seq[Any](/*39.5*/select(formOrden("ejercicio_id"), Ejercicio.getEjercicios().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*39.164*/("""
		</label>
		"""),_display_(Seq[Any](/*41.4*/formOrden("ejercicio_id")/*41.29*/.error.map/*41.39*/{ error =>_display_(Seq[Any](format.raw/*41.49*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*42.29*/error/*42.34*/.message)),format.raw/*42.42*/("""</div>
		""")))})),format.raw/*43.4*/("""
	</div>
	
	<div class="col-sm-2 """),_display_(Seq[Any](/*46.24*/if(formOrden.error("monto") != null)/*46.60*/ {_display_(Seq[Any](format.raw/*46.62*/("""has-error""")))}/*46.72*/else/*46.76*/{_display_(Seq[Any](format.raw/*46.77*/("""has-required""")))})),format.raw/*46.90*/("""">
		<label class="control-label">Monto
			"""),_display_(Seq[Any](/*48.5*/inputText(formOrden("monto"), 'class -> "form-control", 'id -> "monto"))),format.raw/*48.76*/("""
		</label>
		"""),_display_(Seq[Any](/*50.4*/formOrden("monto")/*50.22*/.error.map/*50.32*/{ error =>_display_(Seq[Any](format.raw/*50.42*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*51.29*/error/*51.34*/.message)),format.raw/*51.42*/("""</div>
		""")))})),format.raw/*52.4*/("""
	</div>
	
	<div class="col-sm-2">
		<div class="form-group">
			<label for="orden_pago_id" class="control-label">Orden de pago Padre N° </label>
			<div class="input-group">
				"""),_display_(Seq[Any](/*59.6*/inputText(formOrden("ordenPago.nombreCompleto"), 'class -> "form-control", 'id -> "orden_pago"))),format.raw/*59.101*/("""
				"""),_display_(Seq[Any](/*60.6*/inputText(formOrden("orden_pago_id"),'hidden -> "hidden", 'id -> "orden_pago_id"))),format.raw/*60.87*/("""
				<span class="input-group-addon">
					<a href="#" class="searchModal"
								id="searchOrdenPago" 
								data-title="Selección de órdenes de pago" 
								data-url=""""),_display_(Seq[Any](/*65.20*/controllers/*65.31*/.contabilidad.routes.OrdenesPagosController.modalBuscar())),format.raw/*65.88*/("""" 
								data-height="650" 
								data-width="700" 
								data-listen="modal.seleccion.orden-pago.simple" 
								data-label="#orden_pago" 
								data-field="#orden_pago_id">
						<i class="glyphicon glyphicon-search"></i>
					</a>
				</span>
			</div>
		</div>
	</div>
</div>

<div class="row">
	<div class="col-sm-8">
		<label class="control-label">Observación</label>
		"""),_display_(Seq[Any](/*82.4*/textarea(formOrden("observacion"), 'class -> "form-control", 'id -> "monto", 'rows -> 4))),format.raw/*82.92*/("""
	</div>
</div>

"""))}
    }
    
    def render(formOrden:Form[OrdenPago]): play.api.templates.HtmlFormat.Appendable = apply(formOrden)
    
    def f:((Form[OrdenPago]) => play.api.templates.HtmlFormat.Appendable) = (formOrden) => apply(formOrden)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/ordenesPagos/formOrdenPago.scala.html
                    HASH: b37ed1d1123964db6fc3cf653685931850661c61
                    MATRIX: 817->1|965->67|997->91|1071->29|1100->135|1154->162|1182->163|1273->227|1301->228|1362->262|1390->263|1452->298|1480->299|1754->537|1786->560|1825->561|1863->563|1880->571|1911->580|1932->583|1945->588|1993->590|2013->601|2096->653|2114->661|2151->671|2350->834|2367->842|2398->851|2579->996|2596->1004|2627->1013|2672->1022|2689->1030|2718->1037|2802->1085|2848->1122|2888->1124|2917->1134|2930->1138|2969->1139|3014->1152|3096->1199|3219->1299|3272->1317|3300->1336|3319->1346|3367->1356|3433->1386|3447->1391|3477->1399|3519->1410|3594->1449|3646->1492|3686->1494|3715->1504|3728->1508|3767->1509|3812->1522|3897->1572|4079->1731|4131->1748|4165->1773|4184->1783|4232->1793|4298->1823|4312->1828|4342->1836|4384->1847|4457->1884|4502->1920|4542->1922|4571->1932|4584->1936|4623->1937|4668->1950|4749->1996|4842->2067|4894->2084|4921->2102|4940->2112|4988->2122|5054->2152|5068->2157|5098->2165|5140->2176|5362->2363|5480->2458|5522->2465|5625->2546|5841->2726|5861->2737|5940->2794|6378->3197|6488->3285
                    LINES: 26->1|31->4|31->4|32->1|33->4|36->7|36->7|38->9|38->9|38->9|38->9|40->11|40->11|47->18|47->18|47->18|47->18|47->18|47->18|47->18|47->18|47->18|47->18|47->18|47->18|47->18|50->21|50->21|50->21|54->25|54->25|54->25|54->25|54->25|54->25|56->27|56->27|56->27|56->27|56->27|56->27|56->27|58->29|58->29|60->31|60->31|60->31|60->31|61->32|61->32|61->32|62->33|66->37|66->37|66->37|66->37|66->37|66->37|66->37|68->39|68->39|70->41|70->41|70->41|70->41|71->42|71->42|71->42|72->43|75->46|75->46|75->46|75->46|75->46|75->46|75->46|77->48|77->48|79->50|79->50|79->50|79->50|80->51|80->51|80->51|81->52|88->59|88->59|89->60|89->60|94->65|94->65|94->65|111->82|111->82
                    -- GENERATED --
                */
            