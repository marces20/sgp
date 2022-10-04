
package views.html.rrhh.agenteAsistenciaLicencia

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
object formAgenteAsistenciaLicencia extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[AgenteAsistenciaLicencia],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[AgenteAsistenciaLicencia]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.45*/("""
"""),format.raw/*3.70*/(""" 



"""),_display_(Seq[Any](/*7.2*/if(flash.containsKey("error"))/*7.32*/ {_display_(Seq[Any](format.raw/*7.34*/("""
	<div class="alert alert-danger">
		<i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*9.52*/flash/*9.57*/.get("error"))),format.raw/*9.70*/("""
	</div>
""")))})),format.raw/*11.2*/("""


 <div class="row">
	"""),_display_(Seq[Any](/*15.3*/inputText(lineaForm("agente_id"), 'type -> "hidden"))),format.raw/*15.55*/("""
	
	<div class="col-sm-3">
		<div class="form-group """),_display_(Seq[Any](/*18.27*/if(lineaForm.error("finicio") != null)/*18.65*/ {_display_(Seq[Any](format.raw/*18.67*/("""has-error""")))})),format.raw/*18.77*/("""">
			<label for="inputFechaImputacion" class="control-label">Fecha Inicio</label> 
			"""),_display_(Seq[Any](/*20.5*/inputText(lineaForm("finicio"),'class -> "form-control date", 'id -> "finicio"))),format.raw/*20.84*/("""
		</div>
		"""),_display_(Seq[Any](/*22.4*/lineaForm("finicio")/*22.24*/.error.map/*22.34*/{ error =>_display_(Seq[Any](format.raw/*22.44*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*23.29*/error/*23.34*/.message)),format.raw/*23.42*/("""</div>
		""")))})),format.raw/*24.4*/("""
	</div>
	<div class="col-sm-3">
		<div class="form-group """),_display_(Seq[Any](/*27.27*/if(lineaForm.error("ffin") != null)/*27.62*/ {_display_(Seq[Any](format.raw/*27.64*/("""has-error""")))})),format.raw/*27.74*/("""">
			<label for="inputFechaImputacion" class="control-label">Fecha Fin</label> 
			"""),_display_(Seq[Any](/*29.5*/inputText(lineaForm("ffin"),'class -> "form-control date", 'id -> "ffin"))),format.raw/*29.78*/("""
		</div>
		"""),_display_(Seq[Any](/*31.4*/lineaForm("ffin")/*31.21*/.error.map/*31.31*/{ error =>_display_(Seq[Any](format.raw/*31.41*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*32.29*/error/*32.34*/.message)),format.raw/*32.42*/("""</div>
		""")))})),format.raw/*33.4*/("""
	</div>
	
	<div class="col-sm-6">
	
		<div class="col-sm-8">
			<div class="form-group """),_display_(Seq[Any](/*39.28*/if(lineaForm.error("fpresentacion") != null)/*39.72*/ {_display_(Seq[Any](format.raw/*39.74*/("""has-error""")))})),format.raw/*39.84*/("""">
				<label for="inputFechaImputacion" class="control-label">Fecha Presentacion</label> 
				"""),_display_(Seq[Any](/*41.6*/inputText(lineaForm("fpresentacion"),'class -> "form-control date", 'id -> "ffin"))),format.raw/*41.88*/("""
			</div>
			"""),_display_(Seq[Any](/*43.5*/lineaForm("fpresentacion")/*43.31*/.error.map/*43.41*/{ error =>_display_(Seq[Any](format.raw/*43.51*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*44.30*/error/*44.35*/.message)),format.raw/*44.43*/("""</div>
			""")))})),format.raw/*45.5*/("""
		</div>
		<div class="col-sm-4">
			<div class="form-group """),_display_(Seq[Any](/*48.28*/if(lineaForm.error("ejercicio_id") != null)/*48.71*/ {_display_(Seq[Any](format.raw/*48.73*/("""has-error""")))}/*48.83*/else/*48.87*/{_display_(Seq[Any](format.raw/*48.88*/("""has-required""")))})),format.raw/*48.101*/("""">
			<label class="control-label">Año</label>
			"""),_display_(Seq[Any](/*50.5*/select(lineaForm("ejercicio_id"), Ejercicio.getEjercicios().map { p => p.id.toString -> p.nombre}, 
			'class -> "form-control select"))),format.raw/*51.36*/("""
			"""),_display_(Seq[Any](/*52.5*/lineaForm("ejercicio_id")/*52.30*/.error.map/*52.40*/{ error =>_display_(Seq[Any](format.raw/*52.50*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*53.30*/error/*53.35*/.message)),format.raw/*53.43*/("""</div>
			""")))})),format.raw/*54.5*/("""
			</div>
		</div>
	</div>
</div>

<div class="row">
	<div class="col-sm-6">
		<div class="form-group """),_display_(Seq[Any](/*62.27*/if(lineaForm.error("tipo_licencia_id") != null)/*62.74*/ {_display_(Seq[Any](format.raw/*62.76*/("""has-error""")))}/*62.86*/else/*62.90*/{_display_(Seq[Any](format.raw/*62.91*/("""has-required""")))})),format.raw/*62.104*/("""">
			<label for=""""),_display_(Seq[Any](/*63.17*/lineaForm("tipo_licencia_id"))),format.raw/*63.46*/("""" class="control-label">Tipo Licencia</label>
			"""),_display_(Seq[Any](/*64.5*/select(lineaForm("tipo_licencia_id"), 
						TipoLicencia.find.all().map { p => p.id.toString -> p.nombre},
						'class -> "form-control select", 
						'_default -> "Seleccionar"))),format.raw/*67.34*/(""" 
			
			"""),_display_(Seq[Any](/*69.5*/lineaForm("tipo_licencia_id")/*69.34*/.error.map/*69.44*/{ error =>_display_(Seq[Any](format.raw/*69.54*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*70.30*/error/*70.35*/.message)),format.raw/*70.43*/("""</div>
			""")))})),format.raw/*71.5*/("""
		</div>
	</div>
	<div class="col-sm-6">
		<label for="inputCie" class="control-label">CIE 10</label> 
		<div class="input-group">
			"""),_display_(Seq[Any](/*77.5*/inputText(lineaForm("cie.nombre"),'class -> "form-control",'id -> "cie"))),format.raw/*77.77*/("""
			"""),_display_(Seq[Any](/*78.5*/inputText(lineaForm("cie_id"),'hidden -> "hidden",'id -> "cie_id"))),format.raw/*78.71*/("""
			<span class="input-group-addon">
               	<a href="#" id="searchCie" data-title="Seleccion de CIE 10" 
               				data-url=""""),_display_(Seq[Any](/*81.31*/controllers/*81.42*/.rrhh.routes.CiesController.modalBuscar())),format.raw/*81.83*/("""" 
               				data-height="650" data-width="700" 
               				data-listen="modal.seleccion.cie.simple" 
               				data-label="#cie" data-field="#cie_id" > <i class="glyphicon glyphicon-search"></i></a>
            </span>
		</div>
	</div>
	
	
	
	
</div>

<div class="row">
	<div class="col-sm-8">
		<label for="nombre" class="control-label">Observaciones</label>
		<div class="form-group """),_display_(Seq[Any](/*97.27*/if(lineaForm.error("nota") != null)/*97.62*/ {_display_(Seq[Any](format.raw/*97.64*/("""has-error""")))})),format.raw/*97.74*/("""">
			"""),_display_(Seq[Any](/*98.5*/inputText(lineaForm("nota"), 'class -> "form-control", 'id -> "nota"))),format.raw/*98.74*/("""
			"""),_display_(Seq[Any](/*99.5*/lineaForm("nota")/*99.22*/.error.map/*99.32*/{ error =>_display_(Seq[Any](format.raw/*99.42*/(""" <div class="text-error">"""),_display_(Seq[Any](/*99.68*/error/*99.73*/.message)),format.raw/*99.81*/("""</div>""")))})),format.raw/*99.88*/("""
		</div>
	</div>	
</div>

<div class="row form-actions">
    <div class="col-lg-offset-4 col-lg-8">
      <a href="" class="btn btn-default cancelar" title="Cancelar"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
      <button type="submit" class="btn btn-default" id="btn-guardar-asistencia" title="Guardar Linea"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>
    </div>
</div>
	
<script>
$( function()"""),format.raw/*112.14*/("""{"""),format.raw/*112.15*/("""


		$("#ffin,#finicio").mask("99/99/9999");


	 $('#searchCie').modalSearch();
	
	if($("#cie").length)"""),format.raw/*120.22*/("""{"""),format.raw/*120.23*/("""
		var options = """),format.raw/*121.17*/("""{"""),format.raw/*121.18*/("""
				script:"/suggestCie/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*127.30*/("""{"""),format.raw/*127.31*/(""" 		
											$("#cie_id").val(obj.id); 
										 """),format.raw/*129.12*/("""}"""),format.raw/*129.13*/("""
			"""),format.raw/*130.4*/("""}"""),format.raw/*130.5*/(""";
		var as_json = new bsn.AutoSuggest('cie', options);
	"""),format.raw/*132.2*/("""}"""),format.raw/*132.3*/("""
"""),format.raw/*133.1*/("""}"""),format.raw/*133.2*/(""")
</script>	
	"""))}
    }
    
    def render(lineaForm:Form[AgenteAsistenciaLicencia]): play.api.templates.HtmlFormat.Appendable = apply(lineaForm)
    
    def f:((Form[AgenteAsistenciaLicencia]) => play.api.templates.HtmlFormat.Appendable) = (lineaForm) => apply(lineaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:30 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agenteAsistenciaLicencia/formAgenteAsistenciaLicencia.scala.html
                    HASH: 753c5e7f72acdf8d555012502de6609ad7d01ffe
                    MATRIX: 851->1|997->65|1029->89|1103->44|1132->133|1176->143|1214->173|1253->175|1376->263|1389->268|1423->281|1466->293|1529->321|1603->373|1695->429|1742->467|1782->469|1824->479|1949->569|2050->648|2100->663|2129->683|2148->693|2196->703|2262->733|2276->738|2306->746|2348->757|2446->819|2490->854|2530->856|2572->866|2694->953|2789->1026|2839->1041|2865->1058|2884->1068|2932->1078|2998->1108|3012->1113|3042->1121|3084->1132|3215->1227|3268->1271|3308->1273|3350->1283|3483->1381|3587->1463|3639->1480|3674->1506|3693->1516|3741->1526|3808->1557|3822->1562|3852->1570|3895->1582|3996->1647|4048->1690|4088->1692|4117->1702|4130->1706|4169->1707|4215->1720|4303->1773|4461->1909|4502->1915|4536->1940|4555->1950|4603->1960|4670->1991|4684->1996|4714->2004|4757->2016|4905->2128|4961->2175|5001->2177|5030->2187|5043->2191|5082->2192|5128->2205|5184->2225|5235->2254|5321->2305|5527->2489|5574->2501|5612->2530|5631->2540|5679->2550|5746->2581|5760->2586|5790->2594|5833->2606|6010->2748|6104->2820|6145->2826|6233->2892|6416->3039|6436->3050|6499->3091|6964->3520|7008->3555|7048->3557|7090->3567|7133->3575|7224->3644|7265->3650|7291->3667|7310->3677|7358->3687|7420->3713|7434->3718|7464->3726|7503->3733|7985->4186|8015->4187|8155->4298|8185->4299|8232->4317|8262->4318|8427->4454|8457->4455|8541->4510|8571->4511|8604->4516|8633->4517|8719->4575|8748->4576|8778->4578|8807->4579
                    LINES: 26->1|29->3|29->3|30->1|31->3|35->7|35->7|35->7|37->9|37->9|37->9|39->11|43->15|43->15|46->18|46->18|46->18|46->18|48->20|48->20|50->22|50->22|50->22|50->22|51->23|51->23|51->23|52->24|55->27|55->27|55->27|55->27|57->29|57->29|59->31|59->31|59->31|59->31|60->32|60->32|60->32|61->33|67->39|67->39|67->39|67->39|69->41|69->41|71->43|71->43|71->43|71->43|72->44|72->44|72->44|73->45|76->48|76->48|76->48|76->48|76->48|76->48|76->48|78->50|79->51|80->52|80->52|80->52|80->52|81->53|81->53|81->53|82->54|90->62|90->62|90->62|90->62|90->62|90->62|90->62|91->63|91->63|92->64|95->67|97->69|97->69|97->69|97->69|98->70|98->70|98->70|99->71|105->77|105->77|106->78|106->78|109->81|109->81|109->81|125->97|125->97|125->97|125->97|126->98|126->98|127->99|127->99|127->99|127->99|127->99|127->99|127->99|127->99|140->112|140->112|148->120|148->120|149->121|149->121|155->127|155->127|157->129|157->129|158->130|158->130|160->132|160->132|161->133|161->133
                    -- GENERATED --
                */
            