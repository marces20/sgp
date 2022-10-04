
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
object form extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[OrdenProvision],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(opForm: Form[OrdenProvision]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import models.auth._

import utils._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.32*/("""
"""),format.raw/*5.70*/(""" 


"""),_display_(Seq[Any](/*8.2*/views/*8.7*/.html.tags.successError())),format.raw/*8.32*/("""
"""),_display_(Seq[Any](/*9.2*/inputText(opForm("id"), 'hidden -> "hidden"))),format.raw/*9.46*/("""
"""),_display_(Seq[Any](/*10.2*/inputText(opForm("orden_compra_id"), 'hidden -> "hidden"))),format.raw/*10.59*/("""
"""),_display_(Seq[Any](/*11.2*/inputText(opForm("ejercicio_id"), 'hidden -> "hidden"))),format.raw/*11.56*/("""
<div class="row menu-acciones">
	<div class="col-sm-10">
		<button type="submit" class="btn btn-default" title="Guardar certificación"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>	
    	<a href=""""),_display_(Seq[Any](/*15.16*/controllers/*15.27*/.patrimonio.routes.OrdenesProvisionController.index())),format.raw/*15.80*/("""" title="Cancelar" class="btn btn-default"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
    </div>
</div>
	  
<div class="row">
	<div class="col-sm-2">
		<div class="form-group has-required """),_display_(Seq[Any](/*21.40*/if(opForm.error("numero") != null)/*21.74*/ {_display_(Seq[Any](format.raw/*21.76*/("""has-error""")))})),format.raw/*21.86*/("""">
			<label for="nombre" class="control-label">Número</label>
			"""),_display_(Seq[Any](/*23.5*/inputText(opForm("numero"), 'class -> "form-control",'id -> "numero",'readOnly->"readOnly"))),format.raw/*23.96*/("""
			"""),_display_(Seq[Any](/*24.5*/opForm("numero")/*24.21*/.error.map/*24.31*/{ error =>_display_(Seq[Any](format.raw/*24.41*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*25.30*/error/*25.35*/.message)),format.raw/*25.43*/("""</div>
			""")))})),format.raw/*26.5*/("""
		</div>
	</div>
	
	<div class="col-sm-2  has-required """),_display_(Seq[Any](/*30.38*/if(opForm.error("fecha") != null)/*30.71*/ {_display_(Seq[Any](format.raw/*30.73*/("""has-error""")))})),format.raw/*30.83*/("""">
		<label class="control-label">Fecha Provision</label> 
		<div class="form-group ">
			"""),_display_(Seq[Any](/*33.5*/inputText(opForm("fecha"),'class -> "form-control date", 'autocomplete -> "off",'readOnly->"readOnly"))),format.raw/*33.107*/("""
		</div>
		"""),_display_(Seq[Any](/*35.4*/opForm("fecha")/*35.19*/.error.map/*35.29*/{ error =>_display_(Seq[Any](format.raw/*35.39*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*36.29*/error/*36.34*/.message)),format.raw/*36.42*/("""</div>
		""")))})),format.raw/*37.4*/("""
	</div>
	
	<div class="col-sm-2  has-required """),_display_(Seq[Any](/*40.38*/if(opForm.error("plazo_entrega") != null)/*40.79*/ {_display_(Seq[Any](format.raw/*40.81*/("""has-error""")))})),format.raw/*40.91*/("""">
		<label class="control-label">Fecha entrega</label> 
		<div class="form-group ">
			"""),_display_(Seq[Any](/*43.5*/inputText(opForm("plazo_entrega"),'class -> "form-control date", 'autocomplete -> "off",'readOnly->"readOnly"))),format.raw/*43.115*/("""
		</div>
		"""),_display_(Seq[Any](/*45.4*/opForm("plazo_entrega")/*45.27*/.error.map/*45.37*/{ error =>_display_(Seq[Any](format.raw/*45.47*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*46.29*/error/*46.34*/.message)),format.raw/*46.42*/("""</div>
		""")))})),format.raw/*47.4*/("""
	</div>
	
	<div class="col-sm-2  has-required """),_display_(Seq[Any](/*50.38*/if(opForm.error("fcierre") != null)/*50.73*/ {_display_(Seq[Any](format.raw/*50.75*/("""has-error""")))})),format.raw/*50.85*/("""">
		<label class="control-label">Fecha cierre</label> 
		<div class="form-group ">
			"""),_display_(Seq[Any](/*53.5*/inputText(opForm("fcierre"),'class -> "form-control date", 'autocomplete -> "off"))),format.raw/*53.87*/("""
		</div>
		"""),_display_(Seq[Any](/*55.4*/opForm("fcierre")/*55.21*/.error.map/*55.31*/{ error =>_display_(Seq[Any](format.raw/*55.41*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*56.29*/error/*56.34*/.message)),format.raw/*56.42*/("""</div>
		""")))})),format.raw/*57.4*/("""
	</div>
	
	 

</div>
"""))}
    }
    
    def render(opForm:Form[OrdenProvision]): play.api.templates.HtmlFormat.Appendable = apply(opForm)
    
    def f:((Form[OrdenProvision]) => play.api.templates.HtmlFormat.Appendable) = (opForm) => apply(opForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/ordenesProvision/form.scala.html
                    HASH: b2f39ef801cf7e453b2a9bcf48f10b2fe5381385
                    MATRIX: 815->1|988->92|1020->116|1094->31|1123->160|1165->168|1177->173|1223->198|1260->201|1325->245|1363->248|1442->305|1480->308|1556->362|1813->583|1833->594|1908->647|2159->862|2202->896|2242->898|2284->908|2388->977|2501->1068|2542->1074|2567->1090|2586->1100|2634->1110|2701->1141|2715->1146|2745->1154|2788->1166|2885->1227|2927->1260|2967->1262|3009->1272|3138->1366|3263->1468|3313->1483|3337->1498|3356->1508|3404->1518|3470->1548|3484->1553|3514->1561|3556->1572|3643->1623|3693->1664|3733->1666|3775->1676|3902->1768|4035->1878|4085->1893|4117->1916|4136->1926|4184->1936|4250->1966|4264->1971|4294->1979|4336->1990|4423->2041|4467->2076|4507->2078|4549->2088|4675->2179|4779->2261|4829->2276|4855->2293|4874->2303|4922->2313|4988->2343|5002->2348|5032->2356|5074->2367
                    LINES: 26->1|33->5|33->5|34->1|35->5|38->8|38->8|38->8|39->9|39->9|40->10|40->10|41->11|41->11|45->15|45->15|45->15|51->21|51->21|51->21|51->21|53->23|53->23|54->24|54->24|54->24|54->24|55->25|55->25|55->25|56->26|60->30|60->30|60->30|60->30|63->33|63->33|65->35|65->35|65->35|65->35|66->36|66->36|66->36|67->37|70->40|70->40|70->40|70->40|73->43|73->43|75->45|75->45|75->45|75->45|76->46|76->46|76->46|77->47|80->50|80->50|80->50|80->50|83->53|83->53|85->55|85->55|85->55|85->55|86->56|86->56|86->56|87->57
                    -- GENERATED --
                */
            