
package views.html.administracion.usuarios

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
object form extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Usuario],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(usuarioForm: Form[Usuario]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.30*/("""
"""),format.raw/*3.70*/(""" 


 	<div class="row">
		<div class="col-sm-3">
			<div class="form-group """),_display_(Seq[Any](/*8.28*/if(usuarioForm.error("nombre") != null)/*8.67*/ {_display_(Seq[Any](format.raw/*8.69*/("""has-error""")))}/*8.80*/else/*8.85*/{_display_(Seq[Any](format.raw/*8.86*/("""has-required""")))})),format.raw/*8.99*/("""">
				<label for="nombre" class="control-label">Nombre</label>
				"""),_display_(Seq[Any](/*10.6*/inputText(usuarioForm("nombre"), 'class -> "form-control"))),format.raw/*10.64*/("""
				"""),_display_(Seq[Any](/*11.6*/usuarioForm("nombre")/*11.27*/.error.map/*11.37*/{ error =>_display_(Seq[Any](format.raw/*11.47*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*12.31*/error/*12.36*/.message)),format.raw/*12.44*/("""</div>
				""")))})),format.raw/*13.6*/("""
			</div>
		</div>
		
		<div class="col-sm-3">
			<div class="form-group """),_display_(Seq[Any](/*18.28*/if(usuarioForm.error("nick") != null)/*18.65*/ {_display_(Seq[Any](format.raw/*18.67*/("""has-error""")))}/*18.78*/else/*18.83*/{_display_(Seq[Any](format.raw/*18.84*/("""has-required""")))})),format.raw/*18.97*/("""">
				<label for="nombre" class="control-label">Nick</label>
				"""),_display_(Seq[Any](/*20.6*/inputText(usuarioForm("nick"), 'class -> "form-control"))),format.raw/*20.62*/("""
				"""),_display_(Seq[Any](/*21.6*/usuarioForm("nick")/*21.25*/.error.map/*21.35*/{ error =>_display_(Seq[Any](format.raw/*21.45*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*22.31*/error/*22.36*/.message)),format.raw/*22.44*/("""</div>
				""")))})),format.raw/*23.6*/("""
			</div>
		</div>		
		
		<div class="col-sm-3">
			<div class="form-group """),_display_(Seq[Any](/*28.28*/if(usuarioForm.error("password") != null)/*28.69*/ {_display_(Seq[Any](format.raw/*28.71*/("""has-error""")))}/*28.82*/else/*28.87*/{_display_(Seq[Any](format.raw/*28.88*/("""has-required""")))})),format.raw/*28.101*/("""">
				<label for="nombre" class="control-label">Contraseña</label>
				"""),_display_(Seq[Any](/*30.6*/inputText(usuarioForm("password"), 'class -> "form-control"))),format.raw/*30.66*/("""
				"""),_display_(Seq[Any](/*31.6*/usuarioForm("password")/*31.29*/.error.map/*31.39*/{ error =>_display_(Seq[Any](format.raw/*31.49*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*32.31*/error/*32.36*/.message)),format.raw/*32.44*/("""</div>
				""")))})),format.raw/*33.6*/("""
			</div>
		</div>
		
		<div class="col-sm-3">
			<div class="checkbox" """),_display_(Seq[Any](/*38.27*/if(usuarioForm.error("activo") != null)/*38.66*/ {_display_(Seq[Any](format.raw/*38.68*/("""has-error""")))})),format.raw/*38.78*/("""">
				<label for="activo" class="control-label"> """),_display_(Seq[Any](/*39.49*/checkbox(usuarioForm("activo")))),format.raw/*39.80*/(""" ¿usuario activo?</label>
			</div>
		</div>
	
	</div>	
	<div class="row">
		<div class="col-sm-2">
			<label for="inputPeriodo" class="control-label">Departamento</label> 
			<div class="input-group">
				"""),_display_(Seq[Any](/*48.6*/inputText(usuarioForm("departamento.nombre"),'class -> "form-control",'id -> "departamento"))),format.raw/*48.98*/("""
				"""),_display_(Seq[Any](/*49.6*/inputText(usuarioForm("departamento_id"),'hidden -> "hidden",'id -> "departamento_id"))),format.raw/*49.92*/("""
				<span class="input-group-addon">
				<a href="#" class="searchModal"
							id="searchDepartamento" 
							data-title="Selección de Departamento" 
							data-url=""""),_display_(Seq[Any](/*54.19*/controllers/*54.30*/.rrhh.routes.DepartamentosController.modalBuscar())),format.raw/*54.80*/("""" 
							data-height="650" 
							data-width="700" 
							data-listen="modal.seleccion.departamento.simple" 
							data-label="#departamento" 
							data-field="#departamento_id">
					<i class="glyphicon glyphicon-search"></i>
				</a>
				</span>
			</div>
			"""),_display_(Seq[Any](/*64.5*/usuarioForm("departamento_id")/*64.35*/.error.map/*64.45*/{ error =>_display_(Seq[Any](format.raw/*64.55*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*65.31*/error/*65.36*/.message)),format.raw/*65.44*/("""</div>
				""")))})),format.raw/*66.6*/("""
		</div>
		<div class="col-sm-2">
			
			<div class="form-group """),_display_(Seq[Any](/*70.28*/if(usuarioForm.error("organigrama_id") != null)/*70.75*/ {_display_(Seq[Any](format.raw/*70.77*/("""has-error""")))}/*70.87*/else/*70.91*/{_display_(Seq[Any](format.raw/*70.92*/("""has-required""")))})),format.raw/*70.105*/("""">
				<label for="inputPeriodo" class="control-label">Servicio</label> 
				"""),_display_(Seq[Any](/*72.6*/inputText(usuarioForm("organigrama.nombre"),'class -> "form-control",'id -> "organigrama"))),format.raw/*72.96*/("""
				"""),_display_(Seq[Any](/*73.6*/inputText(usuarioForm("organigrama_id"),'hidden -> "hidden",'id -> "organigrama_id"))),format.raw/*73.90*/("""
				
			</div>
			"""),_display_(Seq[Any](/*76.5*/usuarioForm("organigrama_id")/*76.34*/.error.map/*76.44*/{ error =>_display_(Seq[Any](format.raw/*76.54*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*77.31*/error/*77.36*/.message)),format.raw/*77.44*/("""</div>
				""")))})),format.raw/*78.6*/("""
		</div>
				<div class="col-sm-2  """),_display_(Seq[Any](/*80.28*/if(usuarioForm.error("plansumarmaterno") != null)/*80.77*/ {_display_(Seq[Any](format.raw/*80.79*/("""has-error""")))}/*80.89*/else/*80.93*/{_display_(Seq[Any](format.raw/*80.94*/("""has-required""")))})),format.raw/*80.107*/("""">
					<label class="control-label"> 
						PLAN SUMAR MATERNO 
						"""),_display_(Seq[Any](/*83.8*/select(usuarioForm("plansumarmaterno"),options(""->"","true"->"SI","false"->"NO"), 'class -> "form-control select"))),format.raw/*83.123*/("""
					</label>
					"""),_display_(Seq[Any](/*85.7*/usuarioForm("plansumarmaterno")/*85.38*/.error.map/*85.48*/{ error =>_display_(Seq[Any](format.raw/*85.58*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*86.31*/error/*86.36*/.message)),format.raw/*86.44*/("""</div>
					""")))})),format.raw/*87.7*/("""
				</div>
				
	</div>		
<script>
$( function()"""),format.raw/*92.14*/("""{"""),format.raw/*92.15*/("""
	$('#searchDepartamento').modalSearch();	
	
"""),format.raw/*95.1*/("""}"""),format.raw/*95.2*/(""");
</script>	
	"""))}
    }
    
    def render(usuarioForm:Form[Usuario]): play.api.templates.HtmlFormat.Appendable = apply(usuarioForm)
    
    def f:((Form[Usuario]) => play.api.templates.HtmlFormat.Appendable) = (usuarioForm) => apply(usuarioForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/administracion/usuarios/form.scala.html
                    HASH: 2aa3b4eb61dd7d33227f68c98e69c1465004c990
                    MATRIX: 804->1|935->50|967->74|1041->29|1070->118|1186->199|1233->238|1272->240|1300->251|1312->256|1350->257|1394->270|1500->341|1580->399|1622->406|1652->427|1671->437|1719->447|1787->479|1801->484|1831->492|1875->505|1991->585|2037->622|2077->624|2106->635|2119->640|2158->641|2203->654|2307->723|2385->779|2427->786|2455->805|2474->815|2522->825|2590->857|2604->862|2634->870|2678->883|2796->965|2846->1006|2886->1008|2915->1019|2928->1024|2967->1025|3013->1038|3123->1113|3205->1173|3247->1180|3279->1203|3298->1213|3346->1223|3414->1255|3428->1260|3458->1268|3502->1281|3617->1360|3665->1399|3705->1401|3747->1411|3835->1463|3888->1494|4139->1710|4253->1802|4295->1809|4403->1895|4615->2071|4635->2082|4707->2132|5020->2410|5059->2440|5078->2450|5126->2460|5194->2492|5208->2497|5238->2505|5282->2518|5388->2588|5444->2635|5484->2637|5513->2647|5526->2651|5565->2652|5611->2665|5726->2745|5838->2835|5880->2842|5986->2926|6044->2949|6082->2978|6101->2988|6149->2998|6217->3030|6231->3035|6261->3043|6305->3056|6380->3095|6438->3144|6478->3146|6507->3156|6520->3160|6559->3161|6605->3174|6715->3249|6853->3364|6911->3387|6951->3418|6970->3428|7018->3438|7086->3470|7100->3475|7130->3483|7175->3497|7257->3551|7286->3552|7361->3600|7389->3601
                    LINES: 26->1|29->3|29->3|30->1|31->3|36->8|36->8|36->8|36->8|36->8|36->8|36->8|38->10|38->10|39->11|39->11|39->11|39->11|40->12|40->12|40->12|41->13|46->18|46->18|46->18|46->18|46->18|46->18|46->18|48->20|48->20|49->21|49->21|49->21|49->21|50->22|50->22|50->22|51->23|56->28|56->28|56->28|56->28|56->28|56->28|56->28|58->30|58->30|59->31|59->31|59->31|59->31|60->32|60->32|60->32|61->33|66->38|66->38|66->38|66->38|67->39|67->39|76->48|76->48|77->49|77->49|82->54|82->54|82->54|92->64|92->64|92->64|92->64|93->65|93->65|93->65|94->66|98->70|98->70|98->70|98->70|98->70|98->70|98->70|100->72|100->72|101->73|101->73|104->76|104->76|104->76|104->76|105->77|105->77|105->77|106->78|108->80|108->80|108->80|108->80|108->80|108->80|108->80|111->83|111->83|113->85|113->85|113->85|113->85|114->86|114->86|114->86|115->87|120->92|120->92|123->95|123->95
                    -- GENERATED --
                */
            