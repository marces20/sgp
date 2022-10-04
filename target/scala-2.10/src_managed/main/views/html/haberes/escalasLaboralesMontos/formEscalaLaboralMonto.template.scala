
package views.html.haberes.escalasLaboralesMontos

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
object formEscalaLaboralMonto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.haberes.EscalaLaboralMonto],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(escalaMontoForm: Form[models.haberes.EscalaLaboralMonto]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

import models.haberes._

implicit def /*6.2*/implicitFieldConstructor/*6.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.60*/("""
"""),format.raw/*6.70*/(""" 
<script>
$( function()"""),format.raw/*8.14*/("""{"""),format.raw/*8.15*/(""" $('.searchModal').modalSearch();"""),format.raw/*8.48*/("""}"""),format.raw/*8.49*/(""")
</script>		
	<div class="row menu-acciones">
		<div class="col-sm-10">
			<button type="submit" class="btn btn-default" title="Guardar escala"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>
			<a href=""""),_display_(Seq[Any](/*13.14*/if(request().getHeader("referer"))/*13.48*/{_display_(Seq[Any](format.raw/*13.49*/(""" """),_display_(Seq[Any](/*13.51*/request()/*13.60*/.getHeader("referer"))),format.raw/*13.81*/(""" """)))}/*13.84*/else/*13.89*/{_display_(Seq[Any](_display_(Seq[Any](/*13.91*/controllers/*13.102*/.haberes.routes.EscalasLaboralesMontosController.index())),_display_(Seq[Any](/*13.159*/UriTrack/*13.167*/.decode()))))})),format.raw/*13.177*/("""" title="Cancelar editar" class="btn btn-default"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
		</div>
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*16.14*/UriTrack/*16.22*/.decode())),format.raw/*16.31*/("""" title="Volver al listado" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
		</div>	
	</div>
	<div class="row">
		 <div class="col-sm-6">
			<label for="concepto_nombre" class="control-label">Concepto</label>
			<div class="input-group """),_display_(Seq[Any](/*22.29*/if(escalaMontoForm.error("liquidacion_concepto_id") != null)/*22.89*/ {_display_(Seq[Any](format.raw/*22.91*/("""has-error""")))}/*22.102*/else/*22.107*/{_display_(Seq[Any](format.raw/*22.108*/("""has-required""")))})),format.raw/*22.121*/("""">
				"""),_display_(Seq[Any](/*23.6*/inputText(escalaMontoForm("liquidacionConcepto.denominacion"), 'class -> "form-control", 'autofocus -> "autofocus", 'id -> "concepto"))),format.raw/*23.140*/("""
				"""),_display_(Seq[Any](/*24.6*/inputText(escalaMontoForm("liquidacion_concepto_id"), 'hidden -> "hidden", 'id -> "liquidacion_concepto_id"))),format.raw/*24.114*/("""
				<span class="input-group-addon">
					<a href="#" class="searchModal" id="searchProductoModal" 
								data-title="Selección de Concepto" 
								data-url=""""),_display_(Seq[Any](/*28.20*/controllers/*28.31*/.haberes.routes.LiquidacionConceptosController.modalBuscar())),format.raw/*28.91*/(""""
								data-height="650" 
								data-width="700" 
								data-listen="modal.seleccion.concepto.simple" 
								data-label="#concepto" 
								data-field="#liquidacion_concepto_id">
								<i class="glyphicon glyphicon-search"></i>
					</a>
				</span>
			</div>
			"""),_display_(Seq[Any](/*38.5*/escalaMontoForm("liquidacion_concepto_id")/*38.47*/.error.map/*38.57*/{ error =>_display_(Seq[Any](format.raw/*38.67*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*39.30*/error/*39.35*/.message)),format.raw/*39.43*/("""</div>
			""")))})),format.raw/*40.5*/("""
		</div>
		<div class="col-sm-6">
			<label class="control-label">Escala</label>
				<div class="input-group """),_display_(Seq[Any](/*44.30*/if(escalaMontoForm.error("escala_laboral_id") != null)/*44.84*/ {_display_(Seq[Any](format.raw/*44.86*/("""has-error""")))})),format.raw/*44.96*/("""">
					"""),_display_(Seq[Any](/*45.7*/inputText(escalaMontoForm("escalaLaboral.nombre"), 'name -> "", 'class -> "form-control", 'id -> "escala_laboral"))),format.raw/*45.121*/("""
					"""),_display_(Seq[Any](/*46.7*/inputText(escalaMontoForm("escala_laboral_id"), 'hidden -> "hidden", 'id -> "escala_laboral_id"))),format.raw/*46.103*/("""
					<span class="input-group-addon">
					<a href="#" class="searchModal" id="searchEscalaLaboral" 
							 	data-title="Selección de escala" 
							 	data-url=""""),_display_(Seq[Any](/*50.21*/controllers/*50.32*/.haberes.routes.EscalasLaboralesController.modalBuscar())),format.raw/*50.88*/("""" 
							 	data-height="650" data-width="700" 
							 	data-listen="modal.seleccion.escalaLaboral.simple" 
							 	data-label="#escala_laboral" data-field="#escala_laboral_id">
					<i class="glyphicon glyphicon-search"></i></a></span>
				</div>
				"""),_display_(Seq[Any](/*56.6*/escalaMontoForm("escala_laboral_id")/*56.42*/.error.map/*56.52*/{ error =>_display_(Seq[Any](format.raw/*56.62*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*57.31*/error/*57.36*/.message)),format.raw/*57.44*/("""</div>
				""")))})),format.raw/*58.6*/("""
		</div>
		
	</div>
	<div class="row">
		<div class="col-sm-2">
			<label class="control-label">Importe</label>
			<div class="form-group """),_display_(Seq[Any](/*65.28*/if(escalaMontoForm.error("importe_referencia") != null)/*65.83*/ {_display_(Seq[Any](format.raw/*65.85*/("""has-error""")))})),format.raw/*65.95*/("""">	
				"""),_display_(Seq[Any](/*66.6*/inputText(escalaMontoForm("importe_referencia"), 'class -> "form-control", 'id -> "importe_referencia"))),format.raw/*66.109*/("""
				"""),_display_(Seq[Any](/*67.6*/escalaMontoForm("importe_referencia")/*67.43*/.error.map/*67.53*/{ error =>_display_(Seq[Any](format.raw/*67.63*/(""" <div class="text-error">"""),_display_(Seq[Any](/*67.89*/error/*67.94*/.message)),format.raw/*67.102*/("""</div>""")))})),format.raw/*67.109*/("""
			</div>
		</div>
		<div class="col-sm-2">
			<label class="control-label">Importe tope</label>
			<div class="form-group """),_display_(Seq[Any](/*72.28*/if(escalaMontoForm.error("importe_compensador") != null)/*72.84*/ {_display_(Seq[Any](format.raw/*72.86*/("""has-error""")))})),format.raw/*72.96*/("""">	
				"""),_display_(Seq[Any](/*73.6*/inputText(escalaMontoForm("importe_compensador"), 'class -> "form-control", 'id -> "importe_compensador"))),format.raw/*73.111*/("""
				"""),_display_(Seq[Any](/*74.6*/escalaMontoForm("importe_compensador")/*74.44*/.error.map/*74.54*/{ error =>_display_(Seq[Any](format.raw/*74.64*/(""" <div class="text-error">"""),_display_(Seq[Any](/*74.90*/error/*74.95*/.message)),format.raw/*74.103*/("""</div>""")))})),format.raw/*74.110*/("""
			</div>
		</div>	
	</div>
	<div class="row">
		<div class="col-sm-2">
			<div class="form-group">
				<label for="nombre" class="control-label">Estado
				"""),_display_(Seq[Any](/*82.6*/select(escalaMontoForm("activo"), options("true"->"Activo", "false"->"Inactivo"), 'class -> "form-control"))),format.raw/*82.113*/("""
				</label>
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*87.28*/if(escalaMontoForm.error("fecha_baja") != null)/*87.75*/ {_display_(Seq[Any](format.raw/*87.77*/("""has-error""")))})),format.raw/*87.87*/("""">
				<label for="fechaBaja" class="control-label">Fecha Baja</label> 
				"""),_display_(Seq[Any](/*89.6*/inputText(escalaMontoForm("fecha_baja"),'class -> "form-control date"))),format.raw/*89.76*/("""
			</div>
			"""),_display_(Seq[Any](/*91.5*/escalaMontoForm("fecha_baja")/*91.34*/.error.map/*91.44*/{ error =>_display_(Seq[Any](format.raw/*91.54*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*92.30*/error/*92.35*/.message)),format.raw/*92.43*/("""</div>
			""")))})),format.raw/*93.5*/("""
		</div>
	</div>
	"""))}
    }
    
    def render(escalaMontoForm:Form[models.haberes.EscalaLaboralMonto]): play.api.templates.HtmlFormat.Appendable = apply(escalaMontoForm)
    
    def f:((Form[models.haberes.EscalaLaboralMonto]) => play.api.templates.HtmlFormat.Appendable) = (escalaMontoForm) => apply(escalaMontoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/escalasLaboralesMontos/formEscalaLaboralMonto.scala.html
                    HASH: c8552b1f6c0fc8c2ab1d88a0ebd092ab405de797
                    MATRIX: 855->1|1078->141|1110->165|1184->59|1212->209|1263->233|1291->234|1351->267|1379->268|1638->491|1681->525|1720->526|1758->528|1776->537|1819->558|1840->561|1853->566|1901->568|1922->579|2010->636|2028->644|2065->654|2261->814|2278->822|2309->831|2605->1091|2674->1151|2714->1153|2744->1164|2758->1169|2798->1170|2844->1183|2887->1191|3044->1325|3085->1331|3216->1439|3416->1603|3436->1614|3518->1674|3829->1950|3880->1992|3899->2002|3947->2012|4013->2042|4027->2047|4057->2055|4099->2066|4246->2177|4309->2231|4349->2233|4391->2243|4435->2252|4572->2366|4614->2373|4733->2469|4934->2634|4954->2645|5032->2701|5322->2956|5367->2992|5386->3002|5434->3012|5501->3043|5515->3048|5545->3056|5588->3068|5764->3208|5828->3263|5868->3265|5910->3275|5954->3284|6080->3387|6121->3393|6167->3430|6186->3440|6234->3450|6296->3476|6310->3481|6341->3489|6381->3496|6542->3621|6607->3677|6647->3679|6689->3689|6733->3698|6861->3803|6902->3809|6949->3847|6968->3857|7016->3867|7078->3893|7092->3898|7123->3906|7163->3913|7357->4072|7487->4179|7608->4264|7664->4311|7704->4313|7746->4323|7858->4400|7950->4470|8000->4485|8038->4514|8057->4524|8105->4534|8171->4564|8185->4569|8215->4577|8257->4588
                    LINES: 26->1|35->6|35->6|36->1|37->6|39->8|39->8|39->8|39->8|44->13|44->13|44->13|44->13|44->13|44->13|44->13|44->13|44->13|44->13|44->13|44->13|44->13|47->16|47->16|47->16|53->22|53->22|53->22|53->22|53->22|53->22|53->22|54->23|54->23|55->24|55->24|59->28|59->28|59->28|69->38|69->38|69->38|69->38|70->39|70->39|70->39|71->40|75->44|75->44|75->44|75->44|76->45|76->45|77->46|77->46|81->50|81->50|81->50|87->56|87->56|87->56|87->56|88->57|88->57|88->57|89->58|96->65|96->65|96->65|96->65|97->66|97->66|98->67|98->67|98->67|98->67|98->67|98->67|98->67|98->67|103->72|103->72|103->72|103->72|104->73|104->73|105->74|105->74|105->74|105->74|105->74|105->74|105->74|105->74|113->82|113->82|118->87|118->87|118->87|118->87|120->89|120->89|122->91|122->91|122->91|122->91|123->92|123->92|123->92|124->93
                    -- GENERATED --
                */
            