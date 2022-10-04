
package views.html.contabilidad.pagos.reportes

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
object modalInformeMensualImpuestos extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,String,DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(url: String = null,url2: String = null,formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.68*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/if(url)/*5.9*/ {_display_(Seq[Any](format.raw/*5.11*/("""
	<div class="panel panel-default">
		<div class="panel-body">
	    	<i class="glyphicon glyphicon-save"></i> <a href=""""),_display_(Seq[Any](/*8.58*/controllers/*8.69*/.contabilidad.routes.FacturasAccionesController.descargar322(url))),format.raw/*8.134*/("""">Descargar archivo de informe mensual</a>
		</div>
	</div>
	"""),_display_(Seq[Any](/*11.3*/if(url2)/*11.11*/ {_display_(Seq[Any](format.raw/*11.13*/("""
		<div class="panel panel-default">
		<div class="panel-body">
	    	<i class="glyphicon glyphicon-save"></i> 
	    	<a href=""""),_display_(Seq[Any](/*15.17*/controllers/*15.28*/.contabilidad.routes.FacturasAccionesController.descargar322(url2))),format.raw/*15.94*/("""">Descargar archivo de informe TXT</a>
		</div>
		</div>
	""")))})),format.raw/*18.3*/("""
	
	
""")))}/*21.2*/else/*21.6*/{_display_(Seq[Any](format.raw/*21.7*/("""

	"""),_display_(Seq[Any](/*23.3*/helper/*23.9*/.form(action = controllers.contabilidad.routes.PagosReportesController.informeMensualImpuestos(), 'id -> "formInformeMensualImpuestos")/*23.144*/ {_display_(Seq[Any](format.raw/*23.146*/("""
		"""),_display_(Seq[Any](/*24.4*/if(flash.containsKey("error"))/*24.34*/ {_display_(Seq[Any](format.raw/*24.36*/("""
			<div class="alert alert-danger"><i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*25.85*/flash/*25.90*/.get("error"))),format.raw/*25.103*/("""</div>
		""")))})),format.raw/*26.4*/("""
		
		"""),_display_(Seq[Any](/*28.4*/if(flash.containsKey("success"))/*28.36*/ {_display_(Seq[Any](format.raw/*28.38*/("""
			<div class="alert alert-success"><i class="glyphicon glyphicon-ok-circle"></i> """),_display_(Seq[Any](/*29.84*/flash/*29.89*/.get("success"))),format.raw/*29.104*/("""</div>
		""")))})),format.raw/*30.4*/("""
	
		<div class="row">
			<div class="col-sm-3">
				<div class="form-group">
					<label for="inputFechaPago" class="control-label">Fecha Desde</label> 
					"""),_display_(Seq[Any](/*36.7*/inputText(formBuscador("fecha_desde"), 'class -> "form-control", 'id -> "fecha_desde", 'autofocus -> "autofocus"))),format.raw/*36.120*/("""
				</div>
					"""),_display_(Seq[Any](/*38.7*/formBuscador("fecha_desde")/*38.34*/.error.map/*38.44*/{ error =>_display_(Seq[Any](format.raw/*38.54*/("""
						<div class="text-error">"""),_display_(Seq[Any](/*39.32*/error/*39.37*/.message)),format.raw/*39.45*/("""</div>
					""")))})),format.raw/*40.7*/("""
			</div>
			<div class="col-sm-3">
				<div class="form-group">
					<label for="inputFechaPago" class="control-label">Fecha Hasta</label> 
					"""),_display_(Seq[Any](/*45.7*/inputText(formBuscador("fecha_hasta"), 'class -> "form-control", 'id -> "fecha_hasta", 'autofocus -> "autofocus"))),format.raw/*45.120*/("""
				</div>
					"""),_display_(Seq[Any](/*47.7*/formBuscador("fecha_hasta")/*47.34*/.error.map/*47.44*/{ error =>_display_(Seq[Any](format.raw/*47.54*/("""
						<div class="text-error">"""),_display_(Seq[Any](/*48.32*/error/*48.37*/.message)),format.raw/*48.45*/("""</div>
					""")))})),format.raw/*49.7*/("""
			</div>
			<div class="col-sm-6">
				<label for="cuenta" class="control-label">Cuenta</label>
				<div class="input-group """),_display_(Seq[Any](/*53.30*/if(formBuscador.error("cuenta_id") != null)/*53.73*/ {_display_(Seq[Any](format.raw/*53.75*/("""has-error""")))}/*53.86*/else/*53.91*/{_display_(Seq[Any](format.raw/*53.92*/("""has-required""")))})),format.raw/*53.105*/("""">
					"""),_display_(Seq[Any](/*54.7*/inputText(formBuscador("cuenta.nombre"), 'class -> "form-control", 'id -> "cuenta_modal"))),format.raw/*54.96*/("""
					"""),_display_(Seq[Any](/*55.7*/inputText(formBuscador("cuenta_id"),'hidden -> "hidden", 'id -> "cuenta_id_modal"))),format.raw/*55.89*/("""
					<span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchCuentaModal" 
									data-title="Selección de Cuenta" 
									data-url=""""),_display_(Seq[Any](/*60.21*/controllers/*60.32*/.contabilidad.routes.CuentasController.modalBuscar())),format.raw/*60.84*/("""" 
									data-height="650" 
									data-width="700" 
									data-listen="modal.seleccion.cuenta.simple" 
									data-label="#cuenta_modal" 
									data-field="#cuenta_id_modal">
							<i class="glyphicon glyphicon-search"></i>
						</a>
					</span>
				</div>
				"""),_display_(Seq[Any](/*70.6*/formBuscador("cuenta_id")/*70.31*/.error.map/*70.41*/{ error =>_display_(Seq[Any](format.raw/*70.51*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*71.31*/error/*71.36*/.message)),format.raw/*71.44*/("""</div>
				""")))})),format.raw/*72.6*/("""
			</div>
		</div>
		<div class="row">	
			<div class="col-sm-5"><br />
				<button type="submit" class="btn btn-default" title="Buscar"><i class="glyphicon glyphicon-floppy-disk"></i> Buscar</button>
			</div>
		</div>	
	""")))})),format.raw/*80.3*/("""	
""")))})),format.raw/*81.2*/("""

"""),_display_(Seq[Any](/*83.2*/flash()/*83.9*/.clear())),format.raw/*83.17*/("""
<script>
 $( function () """),format.raw/*85.17*/("""{"""),format.raw/*85.18*/("""
	 $('#fecha_hasta,#fecha_desde').mask("99/99/9999");
	 
	 if($("#cuenta_modal").length)"""),format.raw/*88.32*/("""{"""),format.raw/*88.33*/("""
			var options = """),format.raw/*89.18*/("""{"""),format.raw/*89.19*/("""
					script:"/contabilidad/suggestCuenta/",
					varname:"",
					json:true,
					shownoresults:true,
					maxresults:6,
					callback: function (obj) """),format.raw/*95.31*/("""{"""),format.raw/*95.32*/(""" 
												$("#cuenta_id_modal").val(obj.id); 
											 """),format.raw/*97.13*/("""}"""),format.raw/*97.14*/("""
				"""),format.raw/*98.5*/("""}"""),format.raw/*98.6*/(""";
			var as_json = new bsn.AutoSuggest('cuenta_modal', options);
		"""),format.raw/*100.3*/("""}"""),format.raw/*100.4*/("""	
 """),format.raw/*101.2*/("""}"""),format.raw/*101.3*/(""");
</script>"""))}
    }
    
    def render(url:String,url2:String,formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(url,url2,formBuscador)
    
    def f:((String,String,DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (url,url2,formBuscador) => apply(url,url2,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:38 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/pagos/reportes/modalInformeMensualImpuestos.scala.html
                    HASH: 4daa37147ed9ef3ff62b3a871eb5afecc4042971
                    MATRIX: 844->1|1012->86|1044->110|1118->67|1146->154|1184->158|1198->165|1237->167|1392->287|1411->298|1498->363|1595->425|1612->433|1652->435|1816->563|1836->574|1924->640|2014->699|2038->705|2050->709|2088->710|2127->714|2141->720|2286->855|2327->857|2366->861|2405->891|2445->893|2566->978|2580->983|2616->996|2657->1006|2699->1013|2740->1045|2780->1047|2900->1131|2914->1136|2952->1151|2993->1161|3188->1321|3324->1434|3377->1452|3413->1479|3432->1489|3480->1499|3548->1531|3562->1536|3592->1544|3636->1557|3819->1705|3955->1818|4008->1836|4044->1863|4063->1873|4111->1883|4179->1915|4193->1920|4223->1928|4267->1941|4430->2068|4482->2111|4522->2113|4551->2124|4564->2129|4603->2130|4649->2143|4693->2152|4804->2241|4846->2248|4950->2330|5159->2503|5179->2514|5253->2566|5567->2845|5601->2870|5620->2880|5668->2890|5735->2921|5749->2926|5779->2934|5822->2946|6077->3170|6111->3173|6149->3176|6164->3183|6194->3191|6248->3217|6277->3218|6393->3306|6422->3307|6468->3325|6497->3326|6677->3478|6706->3479|6796->3541|6825->3542|6857->3547|6885->3548|6980->3615|7009->3616|7040->3619|7069->3620
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|36->8|36->8|36->8|39->11|39->11|39->11|43->15|43->15|43->15|46->18|49->21|49->21|49->21|51->23|51->23|51->23|51->23|52->24|52->24|52->24|53->25|53->25|53->25|54->26|56->28|56->28|56->28|57->29|57->29|57->29|58->30|64->36|64->36|66->38|66->38|66->38|66->38|67->39|67->39|67->39|68->40|73->45|73->45|75->47|75->47|75->47|75->47|76->48|76->48|76->48|77->49|81->53|81->53|81->53|81->53|81->53|81->53|81->53|82->54|82->54|83->55|83->55|88->60|88->60|88->60|98->70|98->70|98->70|98->70|99->71|99->71|99->71|100->72|108->80|109->81|111->83|111->83|111->83|113->85|113->85|116->88|116->88|117->89|117->89|123->95|123->95|125->97|125->97|126->98|126->98|128->100|128->100|129->101|129->101
                    -- GENERATED --
                */
            