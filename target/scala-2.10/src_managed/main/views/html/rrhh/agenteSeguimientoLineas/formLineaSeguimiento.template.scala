
package views.html.rrhh.agenteSeguimientoLineas

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
object formLineaSeguimiento extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[AgenteSeguimientoLinea],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[AgenteSeguimientoLinea]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.43*/("""
"""),format.raw/*3.70*/(""" 


"""),_display_(Seq[Any](/*6.2*/if(flash.containsKey("error"))/*6.32*/ {_display_(Seq[Any](format.raw/*6.34*/("""
	<div class="alert alert-danger">
		<i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*8.52*/flash/*8.57*/.get("error"))),format.raw/*8.70*/("""
	</div>
""")))})),format.raw/*10.2*/("""
 

 <div class="row">
	"""),_display_(Seq[Any](/*14.3*/inputText(lineaForm("agente_seguimiento_id"), 'type -> "hidden"))),format.raw/*14.67*/("""
	
	<div class="col-sm-8">
			<label class="control-label">Observacion</label> 
			<div class="form-group """),_display_(Seq[Any](/*18.28*/if(lineaForm.error("observacion") != null)/*18.70*/ {_display_(Seq[Any](format.raw/*18.72*/("""has-error""")))})),format.raw/*18.82*/("""">
				"""),_display_(Seq[Any](/*19.6*/inputText(lineaForm("observacion"), 'class -> "form-control"))),format.raw/*19.67*/("""
				
				"""),_display_(Seq[Any](/*21.6*/lineaForm("observacion")/*21.30*/.error.map/*21.40*/{ error =>_display_(Seq[Any](format.raw/*21.50*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*22.31*/error/*22.36*/.message)),format.raw/*22.44*/("""</div>
				""")))})),format.raw/*23.6*/("""
			</div>
		</div>
	<div class="col-sm-2">
		<label class="control-label">Fecha</label> 
		<div class="form-group">
			"""),_display_(Seq[Any](/*29.5*/inputText(lineaForm("fecha"),'class -> "form-control date", 'autocomplete -> "off", 'id -> "fecha"))),format.raw/*29.104*/("""
		</div>
	</div>
	 
	 
</div>

 
 
<div class="row form-actions">
    <div class="col-lg-offset-4 col-lg-8">
      <a href="" class="btn btn-default cancelar" title="Cancelar"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
      <button type="submit" class="btn btn-default" title="Guardar Linea"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>
    </div>
</div>

<script>
	$( function() """),format.raw/*46.16*/("""{"""),format.raw/*46.17*/("""
		 
		$("#fecha").mask("99/99/9999");
		 
	
	"""),format.raw/*51.2*/("""}"""),format.raw/*51.3*/(""");
</script>
"""))}
    }
    
    def render(lineaForm:Form[AgenteSeguimientoLinea]): play.api.templates.HtmlFormat.Appendable = apply(lineaForm)
    
    def f:((Form[AgenteSeguimientoLinea]) => play.api.templates.HtmlFormat.Appendable) = (lineaForm) => apply(lineaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:31 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agenteSeguimientoLineas/formLineaSeguimiento.scala.html
                    HASH: ea7a6b577d9dc30028364c7f76d764f0e82a7627
                    MATRIX: 840->1|983->61|1015->85|1089->42|1117->129|1156->134|1194->164|1233->166|1354->252|1367->257|1401->270|1442->280|1502->305|1588->369|1731->476|1782->518|1822->520|1864->530|1907->538|1990->599|2036->610|2069->634|2088->644|2136->654|2203->685|2217->690|2247->698|2290->710|2446->831|2568->930|3018->1352|3047->1353|3120->1399|3148->1400
                    LINES: 26->1|29->3|29->3|30->1|31->3|34->6|34->6|34->6|36->8|36->8|36->8|38->10|42->14|42->14|46->18|46->18|46->18|46->18|47->19|47->19|49->21|49->21|49->21|49->21|50->22|50->22|50->22|51->23|57->29|57->29|74->46|74->46|79->51|79->51
                    -- GENERATED --
                */
            