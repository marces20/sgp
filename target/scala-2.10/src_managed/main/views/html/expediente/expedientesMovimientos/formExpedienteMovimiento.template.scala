
package views.html.expediente.expedientesMovimientos

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
object formExpedienteMovimiento extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[ExpedienteMovimiento],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[ExpedienteMovimiento]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.41*/("""
"""),format.raw/*3.70*/(""" 



"""),_display_(Seq[Any](/*7.2*/if(flash.containsKey("error"))/*7.32*/ {_display_(Seq[Any](format.raw/*7.34*/("""
	<div class="alert alert-danger">
		<i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*9.52*/flash/*9.57*/.get("error"))),format.raw/*9.70*/("""
	</div>
""")))})),format.raw/*11.2*/("""
<script>
$(function()"""),format.raw/*13.13*/("""{"""),format.raw/*13.14*/("""
"""),format.raw/*14.1*/("""}"""),format.raw/*14.2*/(""");
</script>

 <div class="row">
	"""),_display_(Seq[Any](/*18.3*/inputText(lineaForm("expediente_id"), 'type -> "hidden"))),format.raw/*18.59*/("""
	<div class="col-sm-8">
		<label for="inputOrganigrama" class="control-label">Departamento/Servicio</label> 
		<div class="input-group """),_display_(Seq[Any](/*21.28*/if(lineaForm.error("organigrama_id") != null)/*21.73*/ {_display_(Seq[Any](format.raw/*21.75*/("""has-error""")))})),format.raw/*21.85*/("""">
			"""),_display_(Seq[Any](/*22.5*/select(lineaForm("organigrama_id"), 
			Organigrama.find.where().eq("circuito_expediente", true).orderBy("nombre asc").findList().map{ p => p.id.toString -> p.nombre}, 'class -> 
			"form-control select", '_default -> "Seleccionar"))),format.raw/*24.54*/("""
		</div>
		"""),_display_(Seq[Any](/*26.4*/lineaForm("organigrama_id")/*26.31*/.error.map/*26.41*/{ error =>_display_(Seq[Any](format.raw/*26.51*/("""<div class="text-error">"""),_display_(Seq[Any](/*26.76*/error/*26.81*/.message)),format.raw/*26.89*/("""</div>""")))})),format.raw/*26.96*/("""
	</div>
</div>


<div class="row">
	<div class="col-sm-12">
		<label for="Descripción" class="control-label">Descripción</label>
		<div class="input-group """),_display_(Seq[Any](/*34.28*/if(lineaForm.error("descripcion") != null)/*34.70*/ {_display_(Seq[Any](format.raw/*34.72*/("""has-error""")))})),format.raw/*34.82*/("""">
			"""),_display_(Seq[Any](/*35.5*/textarea(lineaForm("descripcion"), 'class -> "form-control", 'id -> "descripcion", 'rows -> "3", 'cols -> "50"))),format.raw/*35.116*/("""
			"""),_display_(Seq[Any](/*36.5*/lineaForm("descripcion")/*36.29*/.error.map/*36.39*/{ error =>_display_(Seq[Any](format.raw/*36.49*/(""" <div class="text-error">"""),_display_(Seq[Any](/*36.75*/error/*36.80*/.message)),format.raw/*36.88*/("""</div>""")))})),format.raw/*36.95*/("""
		</div>
	</div>	
</div>
 
<div class="row form-actions">
    <div class="col-lg-offset-4 col-lg-8">
      <button type="submit" class="btn btn-default"><i class="glyphicon glyphicon-floppy-disk"></i>Guardar</button>	
      <a href="" class="btn btn-default cancelar"><i class="glyphicon glyphicon-floppy-remove"></i>Cancelar</a>
    </div>
</div>
<script>

</script>"""))}
    }
    
    def render(lineaForm:Form[ExpedienteMovimiento]): play.api.templates.HtmlFormat.Appendable = apply(lineaForm)
    
    def f:((Form[ExpedienteMovimiento]) => play.api.templates.HtmlFormat.Appendable) = (lineaForm) => apply(lineaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:36 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/expediente/expedientesMovimientos/formExpedienteMovimiento.scala.html
                    HASH: d722c12f49fe9cbc2b00cd69c8cc1382e52984df
                    MATRIX: 847->1|989->61|1021->85|1095->40|1124->129|1168->139|1206->169|1245->171|1368->259|1381->264|1415->277|1458->289|1510->313|1539->314|1568->316|1596->317|1670->356|1748->412|1924->552|1978->597|2018->599|2060->609|2103->617|2359->851|2409->866|2445->893|2464->903|2512->913|2573->938|2587->943|2617->951|2656->958|2857->1123|2908->1165|2948->1167|2990->1177|3033->1185|3167->1296|3208->1302|3241->1326|3260->1336|3308->1346|3370->1372|3384->1377|3414->1385|3453->1392
                    LINES: 26->1|29->3|29->3|30->1|31->3|35->7|35->7|35->7|37->9|37->9|37->9|39->11|41->13|41->13|42->14|42->14|46->18|46->18|49->21|49->21|49->21|49->21|50->22|52->24|54->26|54->26|54->26|54->26|54->26|54->26|54->26|54->26|62->34|62->34|62->34|62->34|63->35|63->35|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36
                    -- GENERATED --
                */
            