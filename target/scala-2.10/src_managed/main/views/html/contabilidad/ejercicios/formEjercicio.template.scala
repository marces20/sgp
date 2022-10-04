
package views.html.contabilidad.ejercicios

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
object formEjercicio extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Ejercicio],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(ejercicioForm: Form[Ejercicio]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.34*/("""
"""),format.raw/*3.70*/(""" 

	<div class="row">
		<div class="col-sm-4">
			<div class="form-group """),_display_(Seq[Any](/*7.28*/if(ejercicioForm.error("nombre") != null)/*7.69*/ {_display_(Seq[Any](format.raw/*7.71*/("""has-error""")))}/*7.81*/else/*7.85*/{_display_(Seq[Any](format.raw/*7.86*/("""has-required""")))})),format.raw/*7.99*/("""">
				<label for="inputNombre" class="control-label">Nombre</label> 
				"""),_display_(Seq[Any](/*9.6*/inputText(ejercicioForm("nombre"), 'class -> "form-control"))),format.raw/*9.66*/("""
				"""),_display_(Seq[Any](/*10.6*/ejercicioForm("nombre")/*10.29*/.error.map/*10.39*/{ error =>_display_(Seq[Any](format.raw/*10.49*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*11.31*/error/*11.36*/.message)),format.raw/*11.44*/("""</div>
				""")))})),format.raw/*12.6*/("""
			</div>
		</div>
		
		<div class="col-sm-4">
			<div class="form-group">
				<label for="inputCodigo" class="control-label">Codigo</label> 
				"""),_display_(Seq[Any](/*19.6*/inputText(ejercicioForm("code"), 'class -> "form-control"))),format.raw/*19.64*/("""
			</div>
		</div>
		<div class="col-sm-4">
			<div class="form-group">
				<label for="inputEstado" class="control-label">Estado</label> 
				"""),_display_(Seq[Any](/*25.6*/inputText(ejercicioForm("estado"), 'class -> "form-control"))),format.raw/*25.66*/("""
			</div>
		</div>
		
	</div>
	<div class="row">
		<div class="col-sm-4">
			<div class="form-group">
				<label for="inputFDesde" class="control-label">Fecha Comienzo</label> 
				"""),_display_(Seq[Any](/*34.6*/inputText(ejercicioForm("date_start"), 'class -> "form-control"))),format.raw/*34.70*/("""
			</div>
		</div>
		<div class="col-sm-4">
			<div class="form-group">
				<label for="inputFHasta" class="control-label">Fecha Fin</label> 
				"""),_display_(Seq[Any](/*40.6*/inputText(ejercicioForm("date_end"), 'class -> "form-control"))),format.raw/*40.68*/("""
			</div>
		</div>
	</div>"""))}
    }
    
    def render(ejercicioForm:Form[Ejercicio]): play.api.templates.HtmlFormat.Appendable = apply(ejercicioForm)
    
    def f:((Form[Ejercicio]) => play.api.templates.HtmlFormat.Appendable) = (ejercicioForm) => apply(ejercicioForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:41 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/ejercicios/formEjercicio.scala.html
                    HASH: 2668b6b60b00230b93ee0ea51c104ceae92ae681
                    MATRIX: 815->1|949->52|981->76|1055->33|1083->120|1192->194|1241->235|1280->237|1308->247|1320->251|1358->252|1402->265|1511->340|1592->400|1633->406|1665->429|1684->439|1732->449|1799->480|1813->485|1843->493|1886->505|2069->653|2149->711|2329->856|2411->916|2629->1099|2715->1163|2898->1311|2982->1373
                    LINES: 26->1|29->3|29->3|30->1|31->3|35->7|35->7|35->7|35->7|35->7|35->7|35->7|37->9|37->9|38->10|38->10|38->10|38->10|39->11|39->11|39->11|40->12|47->19|47->19|53->25|53->25|62->34|62->34|68->40|68->40
                    -- GENERATED --
                */
            