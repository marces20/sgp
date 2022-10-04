
package views.html.haberes.liquidacionPuestos

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
object formLiquidacionPuesto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.haberes.LiquidacionPuesto],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(baseForm: Form[models.haberes.LiquidacionPuesto]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

import models.haberes._

implicit def /*6.2*/implicitFieldConstructor/*6.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.52*/("""
"""),format.raw/*6.70*/(""" 
<script>
$( function()"""),format.raw/*8.14*/("""{"""),format.raw/*8.15*/(""" $('.searchModal').modalSearch();"""),format.raw/*8.48*/("""}"""),format.raw/*8.49*/(""")
</script>		
	<div class="row menu-acciones">
		<div class="col-sm-10">
			<button type="submit" class="btn btn-default" title="Guardar liquidacion puesto"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>
			<a href=""""),_display_(Seq[Any](/*13.14*/if(request().getHeader("referer"))/*13.48*/{_display_(Seq[Any](format.raw/*13.49*/(""" """),_display_(Seq[Any](/*13.51*/request()/*13.60*/.getHeader("referer"))),format.raw/*13.81*/(""" """)))}/*13.84*/else/*13.89*/{_display_(Seq[Any](_display_(Seq[Any](/*13.91*/controllers/*13.102*/.haberes.routes.LiquidacionPuestosController.index())),_display_(Seq[Any](/*13.155*/UriTrack/*13.163*/.decode()))))})),format.raw/*13.173*/("""" title="Cancelar editar" class="btn btn-default"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
		</div>
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*16.14*/UriTrack/*16.22*/.decode())),format.raw/*16.31*/("""" title="Volver al listado" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
		</div>	
	</div>
	
	<input type="hidden" name="""),_display_(Seq[Any](/*20.29*/UriTrack/*20.37*/.getKey())),format.raw/*20.46*/(""" value=""""),_display_(Seq[Any](/*20.55*/UriTrack/*20.63*/.code())),format.raw/*20.70*/("""" />
	"""),_display_(Seq[Any](/*21.3*/inputText(baseForm("id"), 'type -> "hidden", 'id -> "liquidacionPuestoId"))),format.raw/*21.77*/("""
	"""),_display_(Seq[Any](/*22.3*/inputText(baseForm("liquidacion_mes_id"), 'type -> "hidden", 'id -> "liquidacionMesId"))),format.raw/*22.90*/("""
	<div class="row">
		<div class="col-sm-4">
			<div class="form-group">
				<label for="inputliquidacionMes" class="control-label">N° Liquidación</label> 
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*27.50*/baseForm/*27.58*/.field("liquidacionMes.nro_liquidacion_parque").value)),format.raw/*27.111*/("""</p>
			</div>
		</div>
		<div class="col-sm-4">
			<div class="form-group """),_display_(Seq[Any](/*31.28*/if(baseForm.error("nro_liq_puesto") != null)/*31.72*/ {_display_(Seq[Any](format.raw/*31.74*/("""has-error""")))})),format.raw/*31.84*/("""">
				<label for="inputLiqPuesto" class="control-label">N° Liquidación Puesto</label> 
				"""),_display_(Seq[Any](/*33.6*/inputText(baseForm("nro_liq_puesto"), 'class -> "form-control"))),format.raw/*33.69*/("""
				"""),_display_(Seq[Any](/*34.6*/baseForm("nro_liq_puesto")/*34.32*/.error.map/*34.42*/{ error =>_display_(Seq[Any](format.raw/*34.52*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*35.31*/error/*35.36*/.message)),format.raw/*35.44*/("""</div>
				""")))})),format.raw/*36.6*/("""
			</div>
		</div>
		
		<div class="col-sm-4">
			<label for="puestoLaboral" class="control-label">Puesto Laboral</label> 
			<div class="input-group """),_display_(Seq[Any](/*42.29*/if(baseForm.error("puesto_laboral_id") != null)/*42.76*/ {_display_(Seq[Any](format.raw/*42.78*/("""has-error""")))}/*42.88*/else/*42.92*/{_display_(Seq[Any](format.raw/*42.93*/("""has-required""")))})),format.raw/*42.106*/("""">
				"""),_display_(Seq[Any](/*43.6*/inputText(baseForm("puestoLaboral.legajo.agente.apellido"),'class -> "form-control", 'id -> "puesto_laboral"))),format.raw/*43.115*/("""
				"""),_display_(Seq[Any](/*44.6*/inputText(baseForm("puesto_laboral_id"),'hidden -> "hidden", 'id -> "puesto_laboral_id"))),format.raw/*44.94*/("""
				<span class="input-group-addon"><a href="#" class="searchModal" id="searchPuestoLaboral" 
															data-title="Selección de Puesto Laboral" 
															data-url=""""),_display_(Seq[Any](/*47.27*/controllers/*47.38*/.haberes.routes.PuestosLaboralesController.modalBuscar())),format.raw/*47.94*/("""" 
															data-height="650" 
															data-width="700" 
															data-listen="modal.seleccion.puestoLaboral.simple" 
															data-label="#puesto_laboral" 
															data-field="#puesto_laboral_id">
															<i class="glyphicon glyphicon-search"></i></a></span>
			</div>
			"""),_display_(Seq[Any](/*55.5*/baseForm("puesto_laboral_id")/*55.34*/.error.map/*55.44*/{ error =>_display_(Seq[Any](format.raw/*55.54*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*56.30*/error/*56.35*/.message)),format.raw/*56.43*/("""</div>
			""")))})),format.raw/*57.5*/("""
		</div>
		 
	</div>
	"""))}
    }
    
    def render(baseForm:Form[models.haberes.LiquidacionPuesto]): play.api.templates.HtmlFormat.Appendable = apply(baseForm)
    
    def f:((Form[models.haberes.LiquidacionPuesto]) => play.api.templates.HtmlFormat.Appendable) = (baseForm) => apply(baseForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/liquidacionPuestos/formLiquidacionPuesto.scala.html
                    HASH: b8b3b497299961b97667de994009d7ac8f38c2a5
                    MATRIX: 849->1|1064->133|1096->157|1170->51|1198->201|1249->225|1277->226|1337->259|1365->260|1636->495|1679->529|1718->530|1756->532|1774->541|1817->562|1838->565|1851->570|1899->572|1920->583|2004->636|2022->644|2059->654|2255->814|2272->822|2303->831|2485->977|2502->985|2533->994|2578->1003|2595->1011|2624->1018|2666->1025|2762->1099|2800->1102|2909->1189|3150->1394|3167->1402|3243->1455|3355->1531|3408->1575|3448->1577|3490->1587|3618->1680|3703->1743|3744->1749|3779->1775|3798->1785|3846->1795|3913->1826|3927->1831|3957->1839|4000->1851|4188->2003|4244->2050|4284->2052|4313->2062|4326->2066|4365->2067|4411->2080|4454->2088|4586->2197|4627->2203|4737->2291|4951->2469|4971->2480|5049->2536|5397->2849|5435->2878|5454->2888|5502->2898|5568->2928|5582->2933|5612->2941|5654->2952
                    LINES: 26->1|35->6|35->6|36->1|37->6|39->8|39->8|39->8|39->8|44->13|44->13|44->13|44->13|44->13|44->13|44->13|44->13|44->13|44->13|44->13|44->13|44->13|47->16|47->16|47->16|51->20|51->20|51->20|51->20|51->20|51->20|52->21|52->21|53->22|53->22|58->27|58->27|58->27|62->31|62->31|62->31|62->31|64->33|64->33|65->34|65->34|65->34|65->34|66->35|66->35|66->35|67->36|73->42|73->42|73->42|73->42|73->42|73->42|73->42|74->43|74->43|75->44|75->44|78->47|78->47|78->47|86->55|86->55|86->55|86->55|87->56|87->56|87->56|88->57
                    -- GENERATED --
                */
            