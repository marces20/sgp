
package views.html.presupuesto.creditoPresupuestario

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
object formCreditoPresupuestario extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[CreditoPresupuestario],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(creditoForm: Form[CreditoPresupuestario]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.44*/("""
"""),format.raw/*3.70*/(""" 
	"""),_display_(Seq[Any](/*4.3*/inputText(creditoForm("id"), 'type -> "hidden", 'id -> "creditoPresupuestarioId"))),format.raw/*4.84*/("""
	<div class="row">
		<div class="col-sm-6">
			<div class="form-group """),_display_(Seq[Any](/*7.28*/if(creditoForm.error("nombre") != null)/*7.67*/ {_display_(Seq[Any](format.raw/*7.69*/("""has-error""")))}/*7.79*/else/*7.83*/{_display_(Seq[Any](format.raw/*7.84*/("""has-required""")))})),format.raw/*7.97*/("""">
				<label for="inputNombre" class="control-label">Ley</label> 
				"""),_display_(Seq[Any](/*9.6*/inputText(creditoForm("nombre"), 'class -> "form-control"))),format.raw/*9.64*/("""
				"""),_display_(Seq[Any](/*10.6*/creditoForm("nombre")/*10.27*/.error.map/*10.37*/{ error =>_display_(Seq[Any](format.raw/*10.47*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*11.31*/error/*11.36*/.message)),format.raw/*11.44*/("""</div>
				""")))})),format.raw/*12.6*/("""
			</div>
		</div>
		
		
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*18.28*/if(creditoForm.error("ejercicio.id") != null)/*18.73*/ {_display_(Seq[Any](format.raw/*18.75*/("""has-error""")))}/*18.85*/else/*18.89*/{_display_(Seq[Any](format.raw/*18.90*/("""has-required""")))})),format.raw/*18.103*/("""">
			<label class="control-label">Ejercicio
			"""),_display_(Seq[Any](/*20.5*/select(creditoForm("ejercicio.id"), Ejercicio.getEjercicios().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*20.166*/("""
			</label>
				"""),_display_(Seq[Any](/*22.6*/creditoForm("ejercicio.id")/*22.33*/.error.map/*22.43*/{ error =>_display_(Seq[Any](format.raw/*22.53*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*23.31*/error/*23.36*/.message)),format.raw/*23.44*/("""</div>
				""")))})),format.raw/*24.6*/("""
			</div>
		</div>
		
		<div class="col-sm-2">
			<label for="expediente" class="control-label">Expediente</label> 
			<div class="input-group">
				"""),_display_(Seq[Any](/*31.6*/inputText(creditoForm("expediente.nombre"),'class -> "form-control", 'id -> "expediente"))),format.raw/*31.95*/("""
				"""),_display_(Seq[Any](/*32.6*/inputText(creditoForm("expediente.id"),'hidden -> "hidden", 'id -> "expediente_id"))),format.raw/*32.89*/("""
				<span class="input-group-addon">
					<a href="#" 
						id="searchExpediente" 
						data-title="Selección de expediente" 
						data-url=""""),_display_(Seq[Any](/*37.18*/controllers/*37.29*/.expediente.routes.ExpedientesController.modalBuscar())),format.raw/*37.83*/("""" 
						data-height="650" 
						data-width="700" 
						data-listen="modal.seleccion.expediente.simple" 
						data-label="#expediente" 
						data-field="#expediente_id">
						<i class="glyphicon glyphicon-search"></i>
					</a>
				</span>
			</div>
		</div>
		
	</div>
	<div class="row">
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*52.28*/if(creditoForm.error("fecha") != null)/*52.66*/ {_display_(Seq[Any](format.raw/*52.68*/("""has-error""")))}/*52.78*/else/*52.82*/{_display_(Seq[Any](format.raw/*52.83*/("""has-required""")))})),format.raw/*52.96*/("""">
				<label for="inputFechaStart" class="control-label">Fecha</label> 
				"""),_display_(Seq[Any](/*54.6*/inputText(creditoForm("fecha"),'class -> "form-control date", 'id -> "fecha"))),format.raw/*54.83*/("""
			</div>
		</div>
	</div>
	
   
  
	"""))}
    }
    
    def render(creditoForm:Form[CreditoPresupuestario]): play.api.templates.HtmlFormat.Appendable = apply(creditoForm)
    
    def f:((Form[CreditoPresupuestario]) => play.api.templates.HtmlFormat.Appendable) = (creditoForm) => apply(creditoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:36 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/presupuesto/creditoPresupuestario/formCreditoPresupuestario.scala.html
                    HASH: 2f2b9ba56709d6a00cc37cc8dd3cddf562214f49
                    MATRIX: 849->1|993->62|1025->86|1099->43|1127->130|1165->134|1267->215|1374->287|1421->326|1460->328|1488->338|1500->342|1538->343|1582->356|1688->428|1767->486|1808->492|1838->513|1857->523|1905->533|1972->564|1986->569|2016->577|2059->589|2173->667|2227->712|2267->714|2296->724|2309->728|2348->729|2394->742|2478->791|2662->952|2715->970|2751->997|2770->1007|2818->1017|2885->1048|2899->1053|2929->1061|2972->1073|3158->1224|3269->1313|3310->1319|3415->1402|3597->1548|3617->1559|3693->1613|4075->1959|4122->1997|4162->1999|4191->2009|4204->2013|4243->2014|4288->2027|4401->2105|4500->2182
                    LINES: 26->1|29->3|29->3|30->1|31->3|32->4|32->4|35->7|35->7|35->7|35->7|35->7|35->7|35->7|37->9|37->9|38->10|38->10|38->10|38->10|39->11|39->11|39->11|40->12|46->18|46->18|46->18|46->18|46->18|46->18|46->18|48->20|48->20|50->22|50->22|50->22|50->22|51->23|51->23|51->23|52->24|59->31|59->31|60->32|60->32|65->37|65->37|65->37|80->52|80->52|80->52|80->52|80->52|80->52|80->52|82->54|82->54
                    -- GENERATED --
                */
            