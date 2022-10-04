
package views.html.patrimonio.ordenesProvision

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
object modalCrearActasDeAjustes extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[DynamicForm,Long,Form[ActaRecepcion],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm,ordenId:Long,actaForm: Form[ActaRecepcion]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.72*/("""
"""),format.raw/*3.70*/(""" 
	
"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.patrimonio.routes.OrdenesProvisionController.crearActasDeAjustes(), 'id -> "formCrearActasDeAjustes")/*5.136*/ {_display_(Seq[Any](format.raw/*5.138*/("""	
	
	"""),_display_(Seq[Any](/*7.3*/views/*7.8*/.html.tags.successError())),format.raw/*7.33*/("""
	<input type="hidden" value=""""),_display_(Seq[Any](/*8.31*/ordenId)),format.raw/*8.38*/("""" name="ordenId"/>
<div class="row">
	<div class="col-sm-3">
		<div class="form-group has-required """),_display_(Seq[Any](/*11.40*/if(actaForm.error("numero") != null)/*11.76*/ {_display_(Seq[Any](format.raw/*11.78*/("""has-error""")))})),format.raw/*11.88*/("""">
			<label for="nombre" class="control-label">Número</label>
			"""),_display_(Seq[Any](/*13.5*/inputText(actaForm("numero"), 'class -> "form-control",'id->"numeroActa"))),format.raw/*13.78*/("""
			"""),_display_(Seq[Any](/*14.5*/actaForm("numero")/*14.23*/.error.map/*14.33*/{ error =>_display_(Seq[Any](format.raw/*14.43*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*15.30*/error/*15.35*/.message)),format.raw/*15.43*/("""</div>
			""")))})),format.raw/*16.5*/("""
		</div>
	</div>

	<div class="col-sm-3">
		<div class="form-group has-required """),_display_(Seq[Any](/*21.40*/if(actaForm.error("ejercicio_id") != null)/*21.82*/ {_display_(Seq[Any](format.raw/*21.84*/("""has-error""")))})),format.raw/*21.94*/("""">
			<label class="control-label">Ejercicio
			"""),_display_(Seq[Any](/*23.5*/select(actaForm("ejercicio_id"), Ejercicio.getEjercicios().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*23.163*/("""
			</label>
			"""),_display_(Seq[Any](/*25.5*/actaForm("ejercicio_id")/*25.29*/.error.map/*25.39*/{ error =>_display_(Seq[Any](format.raw/*25.49*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*26.30*/error/*26.35*/.message)),format.raw/*26.43*/("""</div>
			""")))})),format.raw/*27.5*/("""	
		</div>
	</div>
	<div class="col-sm-3  has-required """),_display_(Seq[Any](/*30.38*/if(actaForm.error("fecha") != null)/*30.73*/ {_display_(Seq[Any](format.raw/*30.75*/("""has-error""")))})),format.raw/*30.85*/("""">
		<label class="control-label">Fecha acta</label> 
		<div class="form-group ">
			"""),_display_(Seq[Any](/*33.5*/inputText(actaForm("fecha"),'class -> "form-control date", 'autocomplete -> "off",'id -> "fecha_acta_modal"))),format.raw/*33.113*/("""
		</div>
		"""),_display_(Seq[Any](/*35.4*/actaForm("fecha")/*35.21*/.error.map/*35.31*/{ error =>_display_(Seq[Any](format.raw/*35.41*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*36.29*/error/*36.34*/.message)),format.raw/*36.42*/("""</div>
		""")))})),format.raw/*37.4*/("""
	</div>
	<div class="col-sm-3">
		<div class="checkbox">
			<label class="control-label"> """),_display_(Seq[Any](/*41.35*/checkbox(actaForm("cierre"), 'value -> "true"))),format.raw/*41.81*/(""" Acta de cierre</label>
		</div>
	</div>

</div>
 <div class="row">	
	<div class="col-sm-2">
		<div class="form-group">
		<label for="nombre" class="control-label">&nbsp;</label>
		<button  class="form-control btn btn-primary"> Guardar</button>
		</div>
	</div>	

</div>	

 
<script>
$( function()"""),format.raw/*58.14*/("""{"""),format.raw/*58.15*/(""" 
	$("#fecha_acta_modal").mask("99/99/9999");
	$("#numeroActa").numeric_input();

"""),format.raw/*62.1*/("""}"""),format.raw/*62.2*/(""")
</script>
"""),_display_(Seq[Any](/*64.2*/flash()/*64.9*/.clear())),format.raw/*64.17*/("""
""")))})),format.raw/*65.2*/("""

 """))}
    }
    
    def render(formBuscador:DynamicForm,ordenId:Long,actaForm:Form[ActaRecepcion]): play.api.templates.HtmlFormat.Appendable = apply(formBuscador,ordenId,actaForm)
    
    def f:((DynamicForm,Long,Form[ActaRecepcion]) => play.api.templates.HtmlFormat.Appendable) = (formBuscador,ordenId,actaForm) => apply(formBuscador,ordenId,actaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/ordenesProvision/modalCrearActasDeAjustes.scala.html
                    HASH: 0633d97685b81403b686e94a05a6136765d000a0
                    MATRIX: 851->1|1023->90|1055->114|1129->71|1157->158|1196->163|1209->169|1346->297|1386->299|1426->305|1438->310|1484->335|1550->366|1578->373|1714->473|1759->509|1799->511|1841->521|1943->588|2038->661|2078->666|2105->684|2124->694|2172->704|2238->734|2252->739|2282->747|2324->758|2442->840|2493->882|2533->884|2575->894|2659->943|2840->1101|2892->1118|2925->1142|2944->1152|2992->1162|3058->1192|3072->1197|3102->1205|3144->1216|3236->1272|3280->1307|3320->1309|3362->1319|3483->1405|3614->1513|3662->1526|3688->1543|3707->1553|3755->1563|3820->1592|3834->1597|3864->1605|3905->1615|4033->1707|4101->1753|4426->2050|4455->2051|4564->2133|4592->2134|4640->2147|4655->2154|4685->2162|4718->2164
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|35->7|35->7|35->7|36->8|36->8|39->11|39->11|39->11|39->11|41->13|41->13|42->14|42->14|42->14|42->14|43->15|43->15|43->15|44->16|49->21|49->21|49->21|49->21|51->23|51->23|53->25|53->25|53->25|53->25|54->26|54->26|54->26|55->27|58->30|58->30|58->30|58->30|61->33|61->33|63->35|63->35|63->35|63->35|64->36|64->36|64->36|65->37|69->41|69->41|86->58|86->58|90->62|90->62|92->64|92->64|92->64|93->65
                    -- GENERATED --
                */
            