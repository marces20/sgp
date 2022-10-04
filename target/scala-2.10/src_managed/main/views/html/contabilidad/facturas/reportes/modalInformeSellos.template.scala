
package views.html.contabilidad.facturas.reportes

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
object modalInformeSellos extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(url: String = null,formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.48*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/if(url)/*5.9*/ {_display_(Seq[Any](format.raw/*5.11*/("""
	<div class="panel panel-default">
		<div class="panel-body">
	    	<i class="glyphicon glyphicon-save"></i> <a href=""""),_display_(Seq[Any](/*8.58*/controllers/*8.69*/.contabilidad.routes.FacturasAccionesController.descargar322(url))),format.raw/*8.134*/("""">Descargar archivo de informe mensual de RENTAS</a>
		</div>
	</div>
""")))}/*11.2*/else/*11.6*/{_display_(Seq[Any](format.raw/*11.7*/("""

	"""),_display_(Seq[Any](/*13.3*/helper/*13.9*/.form(action = controllers.contabilidad.routes.FacturasReportesController.informeSellos(), 'id -> "formInformeSellos")/*13.127*/ {_display_(Seq[Any](format.raw/*13.129*/("""
		"""),_display_(Seq[Any](/*14.4*/if(flash.containsKey("error"))/*14.34*/ {_display_(Seq[Any](format.raw/*14.36*/("""
			<div class="alert alert-danger"><i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*15.85*/flash/*15.90*/.get("error"))),format.raw/*15.103*/("""</div>
		""")))})),format.raw/*16.4*/("""
		
		"""),_display_(Seq[Any](/*18.4*/if(flash.containsKey("success"))/*18.36*/ {_display_(Seq[Any](format.raw/*18.38*/("""
			<div class="alert alert-success"><i class="glyphicon glyphicon-ok-circle"></i> """),_display_(Seq[Any](/*19.84*/flash/*19.89*/.get("success"))),format.raw/*19.104*/("""</div>
		""")))})),format.raw/*20.4*/("""
	
		<div class="row">
			<div class="col-sm-3">
				<div class="form-group">
					<label for="inputFechaPago" class="control-label">Fecha OPG Desde</label> 
					"""),_display_(Seq[Any](/*26.7*/inputText(formBuscador("fecha_desde"), 'class -> "form-control", 'id -> "fecha_desde", 'autofocus -> "autofocus"))),format.raw/*26.120*/("""
				</div>
					"""),_display_(Seq[Any](/*28.7*/formBuscador("fecha_desde")/*28.34*/.error.map/*28.44*/{ error =>_display_(Seq[Any](format.raw/*28.54*/("""
						<div class="text-error">"""),_display_(Seq[Any](/*29.32*/error/*29.37*/.message)),format.raw/*29.45*/("""</div>
					""")))})),format.raw/*30.7*/("""
			</div>
			<div class="col-sm-3">
				<div class="form-group">
					<label for="inputFechaPago" class="control-label">Fecha OPG Hasta</label> 
					"""),_display_(Seq[Any](/*35.7*/inputText(formBuscador("fecha_hasta"), 'class -> "form-control", 'id -> "fecha_hasta", 'autofocus -> "autofocus"))),format.raw/*35.120*/("""
				</div>
					"""),_display_(Seq[Any](/*37.7*/formBuscador("fecha_hasta")/*37.34*/.error.map/*37.44*/{ error =>_display_(Seq[Any](format.raw/*37.54*/("""
						<div class="text-error">"""),_display_(Seq[Any](/*38.32*/error/*38.37*/.message)),format.raw/*38.45*/("""</div>
					""")))})),format.raw/*39.7*/("""
			</div>
			<div class="col-sm-3">
				<label for="inputPeriodo" class="control-label">Periodo</label> 
				<div class="input-group">
					"""),_display_(Seq[Any](/*44.7*/inputText(formBuscador("periodo"),'class -> "form-control",'id -> "periodo_modal"))),format.raw/*44.89*/("""
					"""),_display_(Seq[Any](/*45.7*/inputText(formBuscador("periodo_id"),'hidden -> "hidden",'id -> "periodo_id_modal"))),format.raw/*45.90*/("""
					<span class="input-group-addon">
					<a href="#" class="searchModal"
								id="searchPeriodo" 
								data-title="Selección de Periodo" 
								data-url=""""),_display_(Seq[Any](/*50.20*/controllers/*50.31*/.contabilidad.routes.PeriodosController.modalBuscar())),format.raw/*50.84*/("""" 
								data-height="650" 
								data-width="700" 
								data-listen="modal.seleccion.periodo.simple" 
								data-label="#periodo_modal" 
								data-field="#periodo_id_modal">
						<i class="glyphicon glyphicon-search"></i>
					</a>
					</span>
				</div>
			</div>
		</div>	
		<div class="row">	
			<div class="col-sm-6">
				<label for="cuenta" class="control-label">Cuenta</label>
				<div class="input-group """),_display_(Seq[Any](/*65.30*/if(formBuscador.error("cuenta_id") != null)/*65.73*/ {_display_(Seq[Any](format.raw/*65.75*/("""has-error""")))}/*65.86*/else/*65.91*/{_display_(Seq[Any](format.raw/*65.92*/("""has-required""")))})),format.raw/*65.105*/("""">
					"""),_display_(Seq[Any](/*66.7*/inputText(formBuscador("cuenta.nombre"), 'class -> "form-control", 'id -> "cuenta_modal"))),format.raw/*66.96*/("""
					"""),_display_(Seq[Any](/*67.7*/inputText(formBuscador("cuenta_id"),'hidden -> "hidden", 'id -> "cuenta_id_modal"))),format.raw/*67.89*/("""
					<span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchCuentaModal" 
									data-title="Selección de Cuenta" 
									data-url=""""),_display_(Seq[Any](/*72.21*/controllers/*72.32*/.contabilidad.routes.CuentasController.modalBuscar())),format.raw/*72.84*/("""" 
									data-height="650" 
									data-width="700" 
									data-listen="modal.seleccion.cuenta.simple" 
									data-label="#cuenta_modal" 
									data-field="#cuenta_id_modal">
							<i class="glyphicon glyphicon-search"></i>
						</a>
					</span>
				</div>
				"""),_display_(Seq[Any](/*82.6*/formBuscador("cuenta_id")/*82.31*/.error.map/*82.41*/{ error =>_display_(Seq[Any](format.raw/*82.51*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*83.31*/error/*83.36*/.message)),format.raw/*83.44*/("""</div>
				""")))})),format.raw/*84.6*/("""
			</div>
		</div>
		<div class="row">	
			<div class="col-sm-5"><br />
				<button type="submit" class="btn btn-default" title="Buscar"><i class="glyphicon glyphicon-floppy-disk"></i> Crear Archvio</button>
			</div>
		</div>	
	""")))})),format.raw/*92.3*/("""	
""")))})),format.raw/*93.2*/("""

"""),_display_(Seq[Any](/*95.2*/flash()/*95.9*/.clear())),format.raw/*95.17*/("""
<script>
 $( function () """),format.raw/*97.17*/("""{"""),format.raw/*97.18*/("""
	 $('#fecha_hasta,#fecha_desde').mask("99/99/9999");
	 
	 if($("#periodo_modal").length)"""),format.raw/*100.33*/("""{"""),format.raw/*100.34*/("""
			var options = """),format.raw/*101.18*/("""{"""),format.raw/*101.19*/("""
					script:"/contabilidad/suggestPeriodo/",
					varname:"",
					json:true,
					shownoresults:true,
					maxresults:6,
					callback: function (obj) """),format.raw/*107.31*/("""{"""),format.raw/*107.32*/(""" 
												$("#periodo_id_modal").val(obj.id); 
											 """),format.raw/*109.13*/("""}"""),format.raw/*109.14*/("""
				"""),format.raw/*110.5*/("""}"""),format.raw/*110.6*/(""";
			var as_json = new bsn.AutoSuggest('periodo_modal', options);
		"""),format.raw/*112.3*/("""}"""),format.raw/*112.4*/("""
	 
	 if($("#cuenta_modal").length)"""),format.raw/*114.32*/("""{"""),format.raw/*114.33*/("""
			var options = """),format.raw/*115.18*/("""{"""),format.raw/*115.19*/("""
					script:"/suggestCuenta/",
					varname:"",
					json:true,
					shownoresults:true,
					maxresults:6,
					callback: function (obj) """),format.raw/*121.31*/("""{"""),format.raw/*121.32*/(""" 
												$("#cuenta_id_modal").val(obj.id); 
											 """),format.raw/*123.13*/("""}"""),format.raw/*123.14*/("""
				"""),format.raw/*124.5*/("""}"""),format.raw/*124.6*/(""";
			var as_json = new bsn.AutoSuggest('cuenta_modal', options);
		"""),format.raw/*126.3*/("""}"""),format.raw/*126.4*/("""	
 """),format.raw/*127.2*/("""}"""),format.raw/*127.3*/(""");
</script>"""))}
    }
    
    def render(url:String,formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(url,formBuscador)
    
    def f:((String,DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (url,formBuscador) => apply(url,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:40 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/facturas/reportes/modalInformeSellos.scala.html
                    HASH: 77a82da8568bd9ae197e17a0ada30aa7438ec589
                    MATRIX: 830->1|978->66|1010->90|1084->47|1112->134|1150->138|1164->145|1203->147|1358->267|1377->278|1464->343|1553->414|1565->418|1603->419|1642->423|1656->429|1784->547|1825->549|1864->553|1903->583|1943->585|2064->670|2078->675|2114->688|2155->698|2197->705|2238->737|2278->739|2398->823|2412->828|2450->843|2491->853|2690->1017|2826->1130|2879->1148|2915->1175|2934->1185|2982->1195|3050->1227|3064->1232|3094->1240|3138->1253|3325->1405|3461->1518|3514->1536|3550->1563|3569->1573|3617->1583|3685->1615|3699->1620|3729->1628|3773->1641|3950->1783|4054->1865|4096->1872|4201->1955|4403->2121|4423->2132|4498->2185|4961->2612|5013->2655|5053->2657|5082->2668|5095->2673|5134->2674|5180->2687|5224->2696|5335->2785|5377->2792|5481->2874|5690->3047|5710->3058|5784->3110|6098->3389|6132->3414|6151->3424|6199->3434|6266->3465|6280->3470|6310->3478|6353->3490|6615->3721|6649->3724|6687->3727|6702->3734|6732->3742|6786->3768|6815->3769|6933->3858|6963->3859|7010->3877|7040->3878|7222->4031|7252->4032|7344->4095|7374->4096|7407->4101|7436->4102|7532->4170|7561->4171|7625->4206|7655->4207|7702->4225|7732->4226|7900->4365|7930->4366|8021->4428|8051->4429|8084->4434|8113->4435|8208->4502|8237->4503|8268->4506|8297->4507
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|36->8|36->8|36->8|39->11|39->11|39->11|41->13|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|44->16|46->18|46->18|46->18|47->19|47->19|47->19|48->20|54->26|54->26|56->28|56->28|56->28|56->28|57->29|57->29|57->29|58->30|63->35|63->35|65->37|65->37|65->37|65->37|66->38|66->38|66->38|67->39|72->44|72->44|73->45|73->45|78->50|78->50|78->50|93->65|93->65|93->65|93->65|93->65|93->65|93->65|94->66|94->66|95->67|95->67|100->72|100->72|100->72|110->82|110->82|110->82|110->82|111->83|111->83|111->83|112->84|120->92|121->93|123->95|123->95|123->95|125->97|125->97|128->100|128->100|129->101|129->101|135->107|135->107|137->109|137->109|138->110|138->110|140->112|140->112|142->114|142->114|143->115|143->115|149->121|149->121|151->123|151->123|152->124|152->124|154->126|154->126|155->127|155->127
                    -- GENERATED --
                */
            