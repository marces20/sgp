
package views.html.expediente.expediente

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
object formExpediente extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Expediente],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(expedienteForm: Form[Expediente]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.36*/("""
"""),format.raw/*3.70*/(""" 


	<div class="row menu-acciones">
		<div class="col-sm-10">
			<button type="submit" class="btn btn-default" title="Guardar solicitud"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>	
	    	<a href=""""),_display_(Seq[Any](/*9.17*/controllers/*9.28*/.expediente.routes.ExpedientesController.indexExpediente())),format.raw/*9.86*/("""" title="Cancelar operación" class="btn btn-default"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
	    </div>
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*12.14*/controllers/*12.25*/.expediente.routes.ExpedientesController.indexExpediente())),format.raw/*12.83*/("""" title="Volver al listado" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
		</div>
	</div>

	<div class="row">
	"""),_display_(Seq[Any](/*17.3*/inputText(expedienteForm("id"), 'type -> "hidden", 'id -> "expedienteId"))),format.raw/*17.76*/("""
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*19.28*/if(expedienteForm.error("nombre") != null)/*19.70*/ {_display_(Seq[Any](format.raw/*19.72*/("""has-error""")))}/*19.82*/else/*19.86*/{_display_(Seq[Any](format.raw/*19.87*/("""has-required""")))})),format.raw/*19.100*/("""">
				<label for="inputNombre" class="control-label">Expediente</label> 
				"""),_display_(Seq[Any](/*21.6*/inputText(expedienteForm("nombre"), 'class -> "form-control"))),format.raw/*21.67*/("""
				"""),_display_(Seq[Any](/*22.6*/expedienteForm("nombre")/*22.30*/.error.map/*22.40*/{ error =>_display_(Seq[Any](format.raw/*22.50*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*23.31*/error/*23.36*/.message)),format.raw/*23.44*/("""</div>
				""")))})),format.raw/*24.6*/("""
			</div>
		</div>
		<div class="col-sm-7">
			<div class="form-group """),_display_(Seq[Any](/*28.28*/if(expedienteForm.error("descripcion") != null)/*28.75*/ {_display_(Seq[Any](format.raw/*28.77*/("""has-error""")))}/*28.87*/else/*28.91*/{_display_(Seq[Any](format.raw/*28.92*/("""has-required""")))})),format.raw/*28.105*/("""">
				<label for="inputNombre" class="control-label">Descripción</label> 
				"""),_display_(Seq[Any](/*30.6*/inputText(expedienteForm("descripcion"), 'class -> "form-control"))),format.raw/*30.72*/("""
				"""),_display_(Seq[Any](/*31.6*/expedienteForm("descripcion")/*31.35*/.error.map/*31.45*/{ error =>_display_(Seq[Any](format.raw/*31.55*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*32.31*/error/*32.36*/.message)),format.raw/*32.44*/("""</div>
				""")))})),format.raw/*33.6*/("""
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*39.28*/if(expedienteForm.error("ejercicio_id") != null)/*39.76*/ {_display_(Seq[Any](format.raw/*39.78*/("""has-error""")))}/*39.88*/else/*39.92*/{_display_(Seq[Any](format.raw/*39.93*/("""has-required""")))})),format.raw/*39.106*/("""">
				<label for="inputEjercicio" class="control-label">Ejercicio</label> 
				"""),_display_(Seq[Any](/*41.6*/inputText(expedienteForm("ejercicio.nombre"),'class -> "form-control"))),format.raw/*41.76*/("""
				"""),_display_(Seq[Any](/*42.6*/inputText(expedienteForm("ejercicio_id"),'hidden -> "hidden"))),format.raw/*42.67*/("""
				"""),_display_(Seq[Any](/*43.6*/expedienteForm("ejercicio_id")/*43.36*/.error.map/*43.46*/{ error =>_display_(Seq[Any](format.raw/*43.56*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*44.31*/error/*44.36*/.message)),format.raw/*44.44*/("""</div>
				""")))})),format.raw/*45.6*/("""
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*49.28*/if(expedienteForm.error("fecha") != null)/*49.69*/ {_display_(Seq[Any](format.raw/*49.71*/("""has-error""")))})),format.raw/*49.81*/("""">
				<label for="fecha_factura" class="control-label">Fecha</label> 
				"""),_display_(Seq[Any](/*51.6*/inputText(expedienteForm("fecha"),'class -> "form-control date", 'id -> "fecha"))),format.raw/*51.86*/("""
			</div>
		</div>
		<div class="col-sm-5">
			<div class="form-group">
				<label for="inputIniciador" class="control-label">Iniciador</label> 
				"""),_display_(Seq[Any](/*57.6*/inputText(expedienteForm("iniciador.nombre"),'class -> "form-control"))),format.raw/*57.76*/("""
				"""),_display_(Seq[Any](/*58.6*/inputText(expedienteForm("iniciador.id"),'hidden -> "hidden"))),format.raw/*58.67*/("""
			</div>
		</div>
		
	</div>
	
	<div class="row">
		<div class="col-sm-2">
			<label for="expediente" class="control-label">Expediente Padre</label> 
			<div class="input-group">
				"""),_display_(Seq[Any](/*68.6*/inputText(expedienteForm("parent.expedienteEjercicio"),'class -> "form-control", 'id -> "expediente"))),format.raw/*68.107*/("""
				"""),_display_(Seq[Any](/*69.6*/inputText(expedienteForm("parent_id"),'hidden -> "hidden", 'id -> "expediente_id"))),format.raw/*69.88*/("""

				<span class="input-group-addon">
						<a href="#" id="searchExpediente" 
									data-title="Selección de expediente" 
									data-url=""""),_display_(Seq[Any](/*74.21*/controllers/*74.32*/.expediente.routes.ExpedientesController.modalBuscar())),format.raw/*74.86*/("""" 
									data-height="650" data-width="700" 
									data-listen="modal.seleccion.expediente.simple" 
									data-label="#expediente" 
									data-field="#expediente_id">
						<i class="glyphicon glyphicon-search"></i></a>
				</span>
			</div>
		</div>	
		<div class="col-sm-2">
			<div class="checkbox">
				<label class="control-label">
					Residuo pasivo
					"""),_display_(Seq[Any](/*87.7*/checkbox(expedienteForm("residuo_pasivo")))),format.raw/*87.49*/("""
				</label>
			</div>
		</div>
		
		<div class="col-sm-2">
			<div class="checkbox">
				<label class="control-label">
					RESERVADO
					"""),_display_(Seq[Any](/*96.7*/checkbox(expedienteForm("reservado")))),format.raw/*96.44*/("""
				</label>
			</div>
		</div>		
		<div class="col-sm-3">
			<div class="checkbox">
				<label class="control-label">
					LICITACION
					"""),_display_(Seq[Any](/*104.7*/checkbox(expedienteForm("licitacion")))),format.raw/*104.45*/("""
				</label>
			</div>
		</div>	
		<div class="col-sm-3">
			<div class="checkbox">
				<label class="control-label">
					EMERGENCIA SANITARIA
					"""),_display_(Seq[Any](/*112.7*/checkbox(expedienteForm("emergencia")))),format.raw/*112.45*/("""
				</label>
			</div>
		</div>	
	</div>
	
	<div class="row">
		<div class="col-sm-2">
			<div class="checkbox">
				<label class="control-label">
					Cerrar
					"""),_display_(Seq[Any](/*123.7*/checkbox(expedienteForm("cerrar")))),format.raw/*123.41*/("""
				</label>
			</div>
		</div>		
		<div class="col-sm-2">
			<div class="checkbox">
				<label class="control-label">
					Activo
					"""),_display_(Seq[Any](/*131.7*/checkbox(expedienteForm("activo")))),format.raw/*131.41*/("""
				</label>
			</div>
		</div>		
		<div class="col-sm-3">
			<div class="checkbox">
				<label class="control-label">
					Expediente Guardia Personal
					"""),_display_(Seq[Any](/*139.7*/checkbox(expedienteForm("guardia")))),format.raw/*139.42*/("""
				</label>
			</div>
		</div>	
		
		<div class="col-sm-3">
			<div class="checkbox">
				<label class="control-label">
					ṔROFE
					"""),_display_(Seq[Any](/*148.7*/checkbox(expedienteForm("profe")))),format.raw/*148.40*/("""
				</label>
			</div>
		</div>	
		
	</div>
<script>
$( function()"""),format.raw/*155.14*/("""{"""),format.raw/*155.15*/("""
	$('#searchExpediente').modalSearch();	
"""),format.raw/*157.1*/("""}"""),format.raw/*157.2*/(""");
</script>	"""))}
    }
    
    def render(expedienteForm:Form[Expediente]): play.api.templates.HtmlFormat.Appendable = apply(expedienteForm)
    
    def f:((Form[Expediente]) => play.api.templates.HtmlFormat.Appendable) = (expedienteForm) => apply(expedienteForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:36 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/expediente/expediente/formExpediente.scala.html
                    HASH: 128d9d92532e0cb1ae178db85ff956c6d4fbead7
                    MATRIX: 815->1|951->54|983->78|1057->35|1085->122|1340->342|1359->353|1438->411|1640->577|1660->588|1740->646|1912->783|2007->856|2096->909|2147->951|2187->953|2216->963|2229->967|2268->968|2314->981|2428->1060|2511->1121|2552->1127|2585->1151|2604->1161|2652->1171|2719->1202|2733->1207|2763->1215|2806->1227|2914->1299|2970->1346|3010->1348|3039->1358|3052->1362|3091->1363|3137->1376|3252->1456|3340->1522|3381->1528|3419->1557|3438->1567|3486->1577|3553->1608|3567->1613|3597->1621|3640->1633|3775->1732|3832->1780|3872->1782|3901->1792|3914->1796|3953->1797|3999->1810|4115->1891|4207->1961|4248->1967|4331->2028|4372->2034|4411->2064|4430->2074|4478->2084|4545->2115|4559->2120|4589->2128|4632->2140|4740->2212|4790->2253|4830->2255|4872->2265|4983->2341|5085->2421|5271->2572|5363->2642|5404->2648|5487->2709|5708->2895|5832->2996|5873->3002|5977->3084|6160->3231|6180->3242|6256->3296|6666->3671|6730->3713|6907->3855|6966->3892|7144->4034|7205->4072|7392->4223|7453->4261|7655->4427|7712->4461|7886->4599|7943->4633|8138->4792|8196->4827|8371->4966|8427->4999|8523->5066|8553->5067|8622->5108|8651->5109
                    LINES: 26->1|29->3|29->3|30->1|31->3|37->9|37->9|37->9|40->12|40->12|40->12|45->17|45->17|47->19|47->19|47->19|47->19|47->19|47->19|47->19|49->21|49->21|50->22|50->22|50->22|50->22|51->23|51->23|51->23|52->24|56->28|56->28|56->28|56->28|56->28|56->28|56->28|58->30|58->30|59->31|59->31|59->31|59->31|60->32|60->32|60->32|61->33|67->39|67->39|67->39|67->39|67->39|67->39|67->39|69->41|69->41|70->42|70->42|71->43|71->43|71->43|71->43|72->44|72->44|72->44|73->45|77->49|77->49|77->49|77->49|79->51|79->51|85->57|85->57|86->58|86->58|96->68|96->68|97->69|97->69|102->74|102->74|102->74|115->87|115->87|124->96|124->96|132->104|132->104|140->112|140->112|151->123|151->123|159->131|159->131|167->139|167->139|176->148|176->148|183->155|183->155|185->157|185->157
                    -- GENERATED --
                */
            