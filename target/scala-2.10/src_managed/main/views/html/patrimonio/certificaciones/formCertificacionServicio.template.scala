
package views.html.patrimonio.certificaciones

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
object formCertificacionServicio extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[CertificacionServicio],CertificacionServicio,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(cForm: Form[CertificacionServicio],cs:CertificacionServicio):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.63*/("""
"""),format.raw/*4.70*/(""" 


<div class="row menu-acciones">
	<div class="col-sm-10">
		<button type="submit" class="btn btn-default" title="Guardar certificación"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>	
    	<a href=""""),_display_(Seq[Any](/*10.16*/controllers/*10.27*/.patrimonio.routes.CertificacionesServiciosController.index())),format.raw/*10.88*/("""" title="Cancelar" class="btn btn-default"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
    </div>
</div>

"""),_display_(Seq[Any](/*14.2*/inputText(cForm("id"), 'type -> "hidden", 'id->"certificacionId"))),format.raw/*14.67*/("""
"""),_display_(Seq[Any](/*15.2*/inputText(cForm("orden_provision_id"), 'type -> "hidden", 'id->"orden_provision_id"))),format.raw/*15.86*/("""
<input type="hidden" name="""),_display_(Seq[Any](/*16.28*/UriTrack/*16.36*/.getKey())),format.raw/*16.45*/(""" value=""""),_display_(Seq[Any](/*16.54*/UriTrack/*16.62*/.code())),format.raw/*16.69*/("""" />
<div class="row">
	<div class="col-sm-2">
		<div class="form-group">
			<label for="nombre" class="control-label">Orden provisión</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*21.49*/cs/*21.51*/.ordenProvision.numero)),format.raw/*21.73*/("""</p>
		</div>
	</div>

	<div class="col-sm-2">
		<div class="form-group">
			<label for="nombre" class="control-label">Expediente</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*28.49*/cs/*28.51*/.ordenProvision.ordenCompra.expediente.getExpedienteEjercicio())),format.raw/*28.114*/("""</p>
		</div>
	</div>
	
	
	<div class="col-sm-4">
		<div class="form-group">
			<label for="nombre" class="control-label">Proveedor</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*36.49*/cs/*36.51*/.ordenProvision.ordenCompra.proveedor.nombre)),format.raw/*36.95*/("""</p>
		</div>
	</div>

	<div class="col-sm-2">
		<label for="inputPeriodo" class="control-label">Periodo</label> 
		<div class="input-group """),_display_(Seq[Any](/*42.28*/if(cForm.error("periodo_id") != null)/*42.65*/ {_display_(Seq[Any](format.raw/*42.67*/("""has-error""")))}/*42.77*/else/*42.81*/{_display_(Seq[Any](format.raw/*42.82*/("""has-required""")))})),format.raw/*42.95*/("""">
			
			"""),_display_(Seq[Any](/*44.5*/inputText(cForm("periodo.nombre"),'class -> "form-control",'id -> "periodo"))),format.raw/*44.81*/("""
			"""),_display_(Seq[Any](/*45.5*/inputText(cForm("periodo_id"),'hidden -> "hidden",'id -> "periodo_id"))),format.raw/*45.75*/("""
			<span class="input-group-addon">
			<a href="#" class="searchModal"
						id="searchPeriodo" 
						data-title="Selección de Periodo" 
						data-url=""""),_display_(Seq[Any](/*50.18*/controllers/*50.29*/.contabilidad.routes.PeriodosController.modalBuscar())),format.raw/*50.82*/("""" 
						data-height="650" 
						data-width="700" 
						data-listen="modal.seleccion.periodo.simple" 
						data-label="#periodo" 
						data-field="#periodo_id">
				<i class="glyphicon glyphicon-search"></i>
			</a>
			</span>
		</div>
		"""),_display_(Seq[Any](/*60.4*/cForm("periodo_id")/*60.23*/.error.map/*60.33*/{ error =>_display_(Seq[Any](format.raw/*60.43*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*61.29*/error/*61.34*/.message)),format.raw/*61.42*/("""</div>
		""")))})),format.raw/*62.4*/("""
	</div>
	<div class="col-sm-2">
		<div class="form-group """),_display_(Seq[Any](/*65.27*/if(cForm.error("date_start") != null)/*65.64*/ {_display_(Seq[Any](format.raw/*65.66*/("""has-error""")))})),format.raw/*65.76*/("""">
			<label for="fechaCertificacion" class="control-label">Fecha Certificacion</label> 
			"""),_display_(Seq[Any](/*67.5*/inputText(cForm("fecha_certificacion"),'class -> "form-control date"))),format.raw/*67.74*/("""
		</div>
		 
	</div>

	 
</div>
<div class="row">
	<div class="col-sm-2">
		<div class="form-group">
			<label for="fechaCertificacion" class="control-label">N° Remito</label> 
			"""),_display_(Seq[Any](/*78.5*/inputText(cForm("numero_remito"),'class -> "form-control"))),format.raw/*78.63*/("""
		</div>
		"""),_display_(Seq[Any](/*80.4*/cForm("numero_remito")/*80.26*/.error.map/*80.36*/{ error =>_display_(Seq[Any](format.raw/*80.46*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*81.29*/error/*81.34*/.message)),format.raw/*81.42*/("""</div>
		""")))})),format.raw/*82.4*/("""
	</div>
</div>	


<script>
$( function()"""),format.raw/*88.14*/("""{"""),format.raw/*88.15*/("""
	$('#searchPeriodo').modalSearch();
	$("#numero_remito").mask("9999-99999999");
	$("#precio, #cantidad, #descuento").numeric_input("""),format.raw/*91.52*/("""{"""),format.raw/*91.53*/("""allowNegative: true"""),format.raw/*91.72*/("""}"""),format.raw/*91.73*/(""");
"""),format.raw/*92.1*/("""}"""),format.raw/*92.2*/(""")
</script>	"""))}
    }
    
    def render(cForm:Form[CertificacionServicio],cs:CertificacionServicio): play.api.templates.HtmlFormat.Appendable = apply(cForm,cs)
    
    def f:((Form[CertificacionServicio],CertificacionServicio) => play.api.templates.HtmlFormat.Appendable) = (cForm,cs) => apply(cForm,cs)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/certificaciones/formCertificacionServicio.scala.html
                    HASH: edb1bd648a69c6626cb3de1d07abe06770bb9be2
                    MATRIX: 864->1|1045->100|1077->124|1151->62|1180->168|1442->394|1462->405|1545->466|1710->596|1797->661|1835->664|1941->748|2006->777|2023->785|2054->794|2099->803|2116->811|2145->818|2377->1014|2388->1016|2432->1038|2661->1231|2672->1233|2758->1296|2990->1492|3001->1494|3067->1538|3250->1685|3296->1722|3336->1724|3365->1734|3378->1738|3417->1739|3462->1752|3510->1765|3608->1841|3649->1847|3741->1917|3938->2078|3958->2089|4033->2142|4321->2395|4349->2414|4368->2424|4416->2434|4482->2464|4496->2469|4526->2477|4568->2488|4666->2550|4712->2587|4752->2589|4794->2599|4924->2694|5015->2763|5243->2956|5323->3014|5373->3029|5404->3051|5423->3061|5471->3071|5537->3101|5551->3106|5581->3114|5623->3125|5698->3172|5727->3173|5890->3308|5919->3309|5966->3328|5995->3329|6026->3333|6054->3334
                    LINES: 26->1|31->4|31->4|32->1|33->4|39->10|39->10|39->10|43->14|43->14|44->15|44->15|45->16|45->16|45->16|45->16|45->16|45->16|50->21|50->21|50->21|57->28|57->28|57->28|65->36|65->36|65->36|71->42|71->42|71->42|71->42|71->42|71->42|71->42|73->44|73->44|74->45|74->45|79->50|79->50|79->50|89->60|89->60|89->60|89->60|90->61|90->61|90->61|91->62|94->65|94->65|94->65|94->65|96->67|96->67|107->78|107->78|109->80|109->80|109->80|109->80|110->81|110->81|110->81|111->82|117->88|117->88|120->91|120->91|120->91|120->91|121->92|121->92
                    -- GENERATED --
                */
            