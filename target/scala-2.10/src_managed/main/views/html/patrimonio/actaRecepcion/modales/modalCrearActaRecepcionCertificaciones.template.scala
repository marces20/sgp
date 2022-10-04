
package views.html.patrimonio.actaRecepcion.modales

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
object modalCrearActaRecepcionCertificaciones extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[ActaRecepcion],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(actaForm: Form[ActaRecepcion]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.33*/("""
"""),format.raw/*4.70*/(""" 
    
"""),_display_(Seq[Any](/*6.2*/helper/*6.8*/.form(action = controllers.patrimonio.routes.ActasRecepcionCertificacionesAccionesController.guardar(), 'id -> "formGuardarActaRecepcion")/*6.146*/ {_display_(Seq[Any](format.raw/*6.148*/("""
"""),_display_(Seq[Any](/*7.2*/views/*7.7*/.html.tags.successError())),format.raw/*7.32*/("""
 <div class="row">
	<div class="col-sm-3">
		<div class="form-group has-required """),_display_(Seq[Any](/*10.40*/if(actaForm.error("numero") != null)/*10.76*/ {_display_(Seq[Any](format.raw/*10.78*/("""has-error""")))})),format.raw/*10.88*/("""">
			<label for="nombre" class="control-label">Número</label>
			"""),_display_(Seq[Any](/*12.5*/inputText(actaForm("numero"), 'class -> "form-control",'id->"numeroActa"))),format.raw/*12.78*/("""
			"""),_display_(Seq[Any](/*13.5*/actaForm("numero")/*13.23*/.error.map/*13.33*/{ error =>_display_(Seq[Any](format.raw/*13.43*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*14.30*/error/*14.35*/.message)),format.raw/*14.43*/("""</div>
			""")))})),format.raw/*15.5*/("""
		</div>
	</div>
	
	<div class="col-sm-3">
		<div class="form-group has-required """),_display_(Seq[Any](/*20.40*/if(actaForm.error("ejercicio_id") != null)/*20.82*/ {_display_(Seq[Any](format.raw/*20.84*/("""has-error""")))})),format.raw/*20.94*/("""">
			<label class="control-label">Ejercicio
			"""),_display_(Seq[Any](/*22.5*/select(actaForm("ejercicio_id"), Ejercicio.getEjercicios().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*22.163*/("""
			</label>
			"""),_display_(Seq[Any](/*24.5*/actaForm("ejercicio_id")/*24.29*/.error.map/*24.39*/{ error =>_display_(Seq[Any](format.raw/*24.49*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*25.30*/error/*25.35*/.message)),format.raw/*25.43*/("""</div>
			""")))})),format.raw/*26.5*/("""	
		</div>
	</div>
	<div class="col-sm-2  has-required """),_display_(Seq[Any](/*29.38*/if(actaForm.error("fecha") != null)/*29.73*/ {_display_(Seq[Any](format.raw/*29.75*/("""has-error""")))})),format.raw/*29.85*/("""">
		<label class="control-label">Fecha acta</label> 
		<div class="form-group ">
			"""),_display_(Seq[Any](/*32.5*/inputText(actaForm("fecha"),'class -> "form-control date", 'autocomplete -> "off",'id -> "fecha_acta_modal"))),format.raw/*32.113*/("""
		</div>
		"""),_display_(Seq[Any](/*34.4*/actaForm("fecha")/*34.21*/.error.map/*34.31*/{ error =>_display_(Seq[Any](format.raw/*34.41*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*35.29*/error/*35.34*/.message)),format.raw/*35.42*/("""</div>
		""")))})),format.raw/*36.4*/("""
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

""")))})),format.raw/*55.2*/("""

<script>
$( function()"""),format.raw/*58.14*/("""{"""),format.raw/*58.15*/(""" $("#fecha_acta_modal").mask("99/99/9999");$("#numeroActa").numeric_input();"""),format.raw/*58.91*/("""}"""),format.raw/*58.92*/(""")
</script>

"""),_display_(Seq[Any](/*61.2*/flash()/*61.9*/.clear())))}
    }
    
    def render(actaForm:Form[ActaRecepcion]): play.api.templates.HtmlFormat.Appendable = apply(actaForm)
    
    def f:((Form[ActaRecepcion]) => play.api.templates.HtmlFormat.Appendable) = (actaForm) => apply(actaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/actaRecepcion/modales/modalCrearActaRecepcionCertificaciones.scala.html
                    HASH: bb581091b1e4d2ddad463913a07697b0bffb2582
                    MATRIX: 853->1|1004->70|1036->94|1110->32|1139->138|1183->148|1196->154|1343->292|1383->294|1420->297|1432->302|1478->327|1600->413|1645->449|1685->451|1727->461|1831->530|1926->603|1967->609|1994->627|2013->637|2061->647|2128->678|2142->683|2172->691|2215->703|2339->791|2390->833|2430->835|2472->845|2558->896|2739->1054|2793->1073|2826->1097|2845->1107|2893->1117|2960->1148|2974->1153|3004->1161|3047->1173|3142->1232|3186->1267|3226->1269|3268->1279|3392->1368|3523->1476|3573->1491|3599->1508|3618->1518|3666->1528|3732->1558|3746->1563|3776->1571|3818->1582|3953->1681|4021->1727|4339->2014|4394->2041|4423->2042|4527->2118|4556->2119|4608->2136|4623->2143
                    LINES: 26->1|31->4|31->4|32->1|33->4|35->6|35->6|35->6|35->6|36->7|36->7|36->7|39->10|39->10|39->10|39->10|41->12|41->12|42->13|42->13|42->13|42->13|43->14|43->14|43->14|44->15|49->20|49->20|49->20|49->20|51->22|51->22|53->24|53->24|53->24|53->24|54->25|54->25|54->25|55->26|58->29|58->29|58->29|58->29|61->32|61->32|63->34|63->34|63->34|63->34|64->35|64->35|64->35|65->36|70->41|70->41|84->55|87->58|87->58|87->58|87->58|90->61|90->61
                    -- GENERATED --
                */
            