
package views.html.contabilidad.ordenesPagosCircuitos

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
object formOrdenPagoCircuito extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[OrdenPagoCircuito],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(ordenPagoCircuitoForm: Form[OrdenPagoCircuito]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.50*/("""
"""),format.raw/*4.70*/(""" 

<script>
$( function()"""),format.raw/*7.14*/("""{"""),format.raw/*7.15*/(""" $('.searchModal').modalSearch();"""),format.raw/*7.48*/("""}"""),format.raw/*7.49*/(""")
</script>

<div class="row menu-acciones">
	<div class="col-sm-10">
		<button type="submit" class="btn btn-default" title="Guardar orden de pago"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>	
    	<a href=""""),_display_(Seq[Any](/*13.16*/if( UriTrack.decode() )/*13.39*/{_display_(Seq[Any](format.raw/*13.40*/(""" """),_display_(Seq[Any](/*13.42*/UriTrack/*13.50*/.decode())),format.raw/*13.59*/(""" """)))}/*13.62*/else/*13.67*/{_display_(Seq[Any](_display_(Seq[Any](/*13.69*/controllers/*13.80*/.contabilidad.routes.OrdenesPagosCircuitosController.index())),_display_(Seq[Any](/*13.141*/UriTrack/*13.149*/.decode()))))})),format.raw/*13.159*/("""" title="Cancelar editar" class="btn btn-default"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
    </div>
	<div class="col-sm-2">
		<a href=""""),_display_(Seq[Any](/*16.13*/UriTrack/*16.21*/.decode())),format.raw/*16.30*/("""" title="Volver al listado" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
	</div>
</div>

<input type="hidden" name="""),_display_(Seq[Any](/*20.28*/UriTrack/*20.36*/.getKey())),format.raw/*20.45*/(""" value=""""),_display_(Seq[Any](/*20.54*/UriTrack/*20.62*/.code())),format.raw/*20.69*/("""" />
<div class="row">

	<div class="col-sm-4">
		<div class="form-group">
			<label class="control-label">Contraparte</label>
			"""),_display_(Seq[Any](/*26.5*/inputText(ordenPagoCircuitoForm("proveedor.nombre"), 'class -> "form-control",'readOnly -> "readOnly"))),format.raw/*26.107*/("""	
		    """),_display_(Seq[Any](/*27.8*/inputText(ordenPagoCircuitoForm("proveedor_id"),'hidden -> "hidden", 'id -> "proveedor_id",'readOnly -> "readOnly"))),format.raw/*27.123*/("""
		</div>
	</div>
	
	
	<div class="col-sm-2">
		<div class="form-group">
			<label class="control-label">Expediente</label>
			"""),_display_(Seq[Any](/*35.5*/inputText(ordenPagoCircuitoForm("expediente.expedienteEjercicio"), 'class -> "form-control",'readOnly -> "readOnly"))),format.raw/*35.121*/("""	
		    """),_display_(Seq[Any](/*36.8*/inputText(ordenPagoCircuitoForm("expediente_id"),'hidden -> "hidden", 'id -> "expediente_id",'readOnly -> "readOnly"))),format.raw/*36.125*/("""
		</div>
	</div>
	<div class="col-sm-2">
		<div class="form-group">
			<label class="control-label">Orden de pago N°</label>
			"""),_display_(Seq[Any](/*42.5*/inputText(ordenPagoCircuitoForm("ordenPago.ordenEjercicio"), 'class -> "form-control",'readOnly -> "readOnly"))),format.raw/*42.115*/("""	
		    """),_display_(Seq[Any](/*43.8*/inputText(ordenPagoCircuitoForm("orden_pago_id"),'hidden -> "hidden", 'id -> "expediente_id",'readOnly -> "readOnly"))),format.raw/*43.125*/("""
		</div>
	</div>	
	
	<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*48.28*/if(ordenPagoCircuitoForm.error("expediente_fisico_id") != null)/*48.91*/ {_display_(Seq[Any](format.raw/*48.93*/("""has-error""")))}/*48.103*/else/*48.107*/{_display_(Seq[Any](format.raw/*48.108*/("""has-required""")))})),format.raw/*48.121*/("""">
				<label for="inputExpediente" class="control-label">Expediente Fisico</label>
				<div class="input-group">
					"""),_display_(Seq[Any](/*51.7*/inputText(ordenPagoCircuitoForm("expedienteFisico.expedienteEjercicio"),'class -> "form-control",'id -> "expedienteFisico"))),format.raw/*51.130*/("""
					"""),_display_(Seq[Any](/*52.7*/inputText(ordenPagoCircuitoForm("expediente_fisico_id"),'hidden -> "hidden", 'id -> "expediente_fisico_id"))),format.raw/*52.114*/("""
					<span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchExpediente" 
									data-title="Selección de expediente" 
									data-url=""""),_display_(Seq[Any](/*57.21*/controllers/*57.32*/.expediente.routes.ExpedientesController.modalBuscarCopia())),format.raw/*57.91*/("""" 
									data-height="650" 
									data-width="700" 
									data-listen="modal.seleccion.expediente.simple" 
									data-label="#expedienteFisico" 
									data-field="#expediente_fisico_id">
							<i class="glyphicon glyphicon-search"></i>
						</a>
					</span>
				</div>
				"""),_display_(Seq[Any](/*67.6*/ordenPagoCircuitoForm("expediente_id")/*67.44*/.error.map/*67.54*/{ error =>_display_(Seq[Any](format.raw/*67.64*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*68.31*/error/*68.36*/.message)),format.raw/*68.44*/("""</div>
				""")))})),format.raw/*69.6*/("""
			</div>
		</div>
	"""),_display_(Seq[Any](/*72.3*/inputText(ordenPagoCircuitoForm("estado_id"), 'hidden -> "hidden"))),format.raw/*72.69*/("""
	"""),_display_(Seq[Any](/*73.3*/inputText(ordenPagoCircuitoForm("fecha_creacion"), 'hidden -> "hidden"))),format.raw/*73.74*/(""" 
	"""),_display_(Seq[Any](/*74.3*/inputText(ordenPagoCircuitoForm("fecha_contabilidad"), 'hidden -> "hidden"))),format.raw/*74.78*/(""" 
	"""),_display_(Seq[Any](/*75.3*/inputText(ordenPagoCircuitoForm("fecha_rendiciones"), 'hidden -> "hidden"))),format.raw/*75.77*/(""" 
	"""),_display_(Seq[Any](/*76.3*/inputText(ordenPagoCircuitoForm("fecha_rendicion"), 'hidden -> "hidden"))),format.raw/*76.75*/("""  
	"""),_display_(Seq[Any](/*77.3*/inputText(ordenPagoCircuitoForm("fecha_pago"), 'hidden -> "hidden"))),format.raw/*77.70*/(""" 
	"""),_display_(Seq[Any](/*78.3*/inputText(ordenPagoCircuitoForm("fecha_mayor"), 'hidden -> "hidden"))),format.raw/*78.71*/("""  

</div>
 
"""))}
    }
    
    def render(ordenPagoCircuitoForm:Form[OrdenPagoCircuito]): play.api.templates.HtmlFormat.Appendable = apply(ordenPagoCircuitoForm)
    
    def f:((Form[OrdenPagoCircuito]) => play.api.templates.HtmlFormat.Appendable) = (ordenPagoCircuitoForm) => apply(ordenPagoCircuitoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/ordenesPagosCircuitos/formOrdenPagoCircuito.scala.html
                    HASH: a2e0515d2d5883286095c90eab1a83338be987e2
                    MATRIX: 842->1|1010->87|1042->111|1116->49|1145->155|1200->183|1228->184|1288->217|1316->218|1587->453|1619->476|1658->477|1696->479|1713->487|1744->496|1765->499|1778->504|1826->506|1846->517|1938->578|1956->586|1993->596|2192->759|2209->767|2240->776|2421->921|2438->929|2469->938|2514->947|2531->955|2560->962|2732->1099|2857->1201|2902->1211|3040->1326|3211->1462|3350->1578|3395->1588|3535->1705|3706->1841|3839->1951|3884->1961|4024->2078|4137->2155|4209->2218|4249->2220|4279->2230|4293->2234|4333->2235|4379->2248|4537->2371|4683->2494|4726->2502|4856->2609|5073->2790|5093->2801|5174->2860|5511->3162|5558->3200|5577->3210|5625->3220|5693->3252|5707->3257|5737->3265|5781->3278|5841->3303|5929->3369|5968->3373|6061->3444|6101->3449|6198->3524|6238->3529|6334->3603|6374->3608|6468->3680|6509->3686|6598->3753|6638->3758|6728->3826
                    LINES: 26->1|31->4|31->4|32->1|33->4|36->7|36->7|36->7|36->7|42->13|42->13|42->13|42->13|42->13|42->13|42->13|42->13|42->13|42->13|42->13|42->13|42->13|45->16|45->16|45->16|49->20|49->20|49->20|49->20|49->20|49->20|55->26|55->26|56->27|56->27|64->35|64->35|65->36|65->36|71->42|71->42|72->43|72->43|77->48|77->48|77->48|77->48|77->48|77->48|77->48|80->51|80->51|81->52|81->52|86->57|86->57|86->57|96->67|96->67|96->67|96->67|97->68|97->68|97->68|98->69|101->72|101->72|102->73|102->73|103->74|103->74|104->75|104->75|105->76|105->76|106->77|106->77|107->78|107->78
                    -- GENERATED --
                */
            