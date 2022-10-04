
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
object modalCrearActaRecepcion extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[ActaRecepcion],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(actaForm: Form[ActaRecepcion]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.33*/("""
"""),format.raw/*4.70*/(""" 
    
"""),_display_(Seq[Any](/*6.2*/helper/*6.8*/.form(action = controllers.patrimonio.routes.ActasRecepcionAccionesController.guardar(), 'id -> "formGuardarActaRecepcion")/*6.131*/ {_display_(Seq[Any](format.raw/*6.133*/("""
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
			<label class="control-label"> """),_display_(Seq[Any](/*40.35*/checkbox(actaForm("cierre"), 'value -> "true"))),format.raw/*40.81*/(""" Acta de cierre</label>
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
$( function()"""),format.raw/*57.14*/("""{"""),format.raw/*57.15*/(""" 
	$("#fecha_acta_modal").mask("99/99/9999");
	$("#numeroActa").numeric_input();

"""),format.raw/*61.1*/("""}"""),format.raw/*61.2*/(""")
</script>
"""),_display_(Seq[Any](/*63.2*/flash()/*63.9*/.clear())))}
    }
    
    def render(actaForm:Form[ActaRecepcion]): play.api.templates.HtmlFormat.Appendable = apply(actaForm)
    
    def f:((Form[ActaRecepcion]) => play.api.templates.HtmlFormat.Appendable) = (actaForm) => apply(actaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/actaRecepcion/modales/modalCrearActaRecepcion.scala.html
                    HASH: 7f1cf4fcbb9c51acbf7a3d85588e18f5dd85cd20
                    MATRIX: 838->1|989->70|1021->94|1095->32|1124->138|1168->148|1181->154|1313->277|1353->279|1390->282|1402->287|1448->312|1570->398|1615->434|1655->436|1697->446|1801->515|1896->588|1937->594|1964->612|1983->622|2031->632|2098->663|2112->668|2142->676|2185->688|2308->775|2359->817|2399->819|2441->829|2527->880|2708->1038|2762->1057|2795->1081|2814->1091|2862->1101|2929->1132|2943->1137|2973->1145|3016->1157|3111->1216|3155->1251|3195->1253|3237->1263|3361->1352|3492->1460|3542->1475|3568->1492|3587->1502|3635->1512|3701->1542|3715->1547|3745->1555|3787->1566|3919->1662|3987->1708|4307->1997|4360->2022|4389->2023|4502->2109|4530->2110|4580->2125|4595->2132
                    LINES: 26->1|31->4|31->4|32->1|33->4|35->6|35->6|35->6|35->6|36->7|36->7|36->7|39->10|39->10|39->10|39->10|41->12|41->12|42->13|42->13|42->13|42->13|43->14|43->14|43->14|44->15|49->20|49->20|49->20|49->20|51->22|51->22|53->24|53->24|53->24|53->24|54->25|54->25|54->25|55->26|58->29|58->29|58->29|58->29|61->32|61->32|63->34|63->34|63->34|63->34|64->35|64->35|64->35|65->36|69->40|69->40|84->55|86->57|86->57|90->61|90->61|92->63|92->63
                    -- GENERATED --
                */
            