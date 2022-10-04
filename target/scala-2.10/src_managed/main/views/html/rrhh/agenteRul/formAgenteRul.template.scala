
package views.html.rrhh.agenteRul

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
object formAgenteRul extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[AgenteRul],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[AgenteRul]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.30*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/if(flash.containsKey("error"))/*5.32*/ {_display_(Seq[Any](format.raw/*5.34*/("""
	<div class="alert alert-danger">
		<i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*7.52*/flash/*7.57*/.get("error"))),format.raw/*7.70*/("""
	</div>
""")))})),format.raw/*9.2*/("""

<div class="row">
	"""),_display_(Seq[Any](/*12.3*/inputText(lineaForm("agente_id"), 'type -> "hidden"))),format.raw/*12.55*/("""
	<div class="col-sm-4">
		<div class="form-group """),_display_(Seq[Any](/*14.27*/if(lineaForm.error("tipo_relacion_laboral_id") != null)/*14.82*/ {_display_(Seq[Any](format.raw/*14.84*/("""has-error""")))}/*14.94*/else/*14.98*/{_display_(Seq[Any](format.raw/*14.99*/("""has-required""")))})),format.raw/*14.112*/("""">
			<label for=""""),_display_(Seq[Any](/*15.17*/lineaForm("tipo_relacion_laboral_id"))),format.raw/*15.54*/("""" class="control-label">Tipo Relación Laboral</label>
			"""),_display_(Seq[Any](/*16.5*/select(lineaForm("tipo_relacion_laboral_id"), 
			TipoRelacionLaboral.find.orderBy("orden asc").findList().map { p => p.id.toString -> p.nombre}, 
			'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*18.64*/("""
			
			"""),_display_(Seq[Any](/*20.5*/lineaForm("tipo_relacion_laboral_id")/*20.42*/.error.map/*20.52*/{ error =>_display_(Seq[Any](format.raw/*20.62*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*21.30*/error/*21.35*/.message)),format.raw/*21.43*/("""</div>
			""")))})),format.raw/*22.5*/("""
		</div>
	</div>
	 
	<div class="col-sm-3">
		<div class="form-group """),_display_(Seq[Any](/*27.27*/if(lineaForm.error("institucion_externa_id") != null)/*27.80*/ {_display_(Seq[Any](format.raw/*27.82*/("""has-error""")))}/*27.92*/else/*27.96*/{_display_(Seq[Any](format.raw/*27.97*/("""has-required""")))})),format.raw/*27.110*/("""">
			<label for=""""),_display_(Seq[Any](/*28.17*/lineaForm("institucion_externa_id"))),format.raw/*28.52*/("""" class="control-label">Institucion Externa</label>
			"""),_display_(Seq[Any](/*29.5*/select(lineaForm("institucion_externa_id"), 
			InstitucionExterna.find.all().map { p => p.id.toString -> p.nombre}, 
			'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*31.64*/("""
			
			"""),_display_(Seq[Any](/*33.5*/lineaForm("institucion_externa_id")/*33.40*/.error.map/*33.50*/{ error =>_display_(Seq[Any](format.raw/*33.60*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*34.30*/error/*34.35*/.message)),format.raw/*34.43*/("""</div>
			""")))})),format.raw/*35.5*/("""
		</div>
	</div>
	
	
</div>	

<div class="row">

	<div class="col-sm-8">
		<div class="form-group">
			<label for="inputNota" class="control-label">Nota</label> 
			"""),_display_(Seq[Any](/*47.5*/inputText(lineaForm("nota"), 'class -> "form-control", 'id -> "nota"))),format.raw/*47.74*/("""
		</div>
	</div>
</div>

<div class="row form-actions">
    <div class="col-lg-offset-4 col-lg-8">
    	<a href="" class="btn btn-default cancelar"><i class="glyphicon glyphicon-floppy-remove"></i>Cancelar</a>
     	<button type="submit" class="btn btn-default"><i class="glyphicon glyphicon-floppy-disk"></i>Guardar</button>	
    </div>
</div>
<script>
$( function()"""),format.raw/*59.14*/("""{"""),format.raw/*59.15*/("""
 

"""),format.raw/*62.1*/("""}"""),format.raw/*62.2*/(""");
</script>	


"""),_display_(Seq[Any](/*66.2*/flash()/*66.9*/.clear())))}
    }
    
    def render(lineaForm:Form[AgenteRul]): play.api.templates.HtmlFormat.Appendable = apply(lineaForm)
    
    def f:((Form[AgenteRul]) => play.api.templates.HtmlFormat.Appendable) = (lineaForm) => apply(lineaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:31 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agenteRul/formAgenteRul.scala.html
                    HASH: 20eeb51836226759352246797ea313cbf8100f2d
                    MATRIX: 806->1|937->50|969->74|1043->29|1072->118|1112->124|1150->154|1189->156|1312->244|1325->249|1359->262|1401->274|1461->299|1535->351|1624->404|1688->459|1728->461|1757->471|1770->475|1809->476|1855->489|1911->509|1970->546|2064->605|2298->817|2344->828|2390->865|2409->875|2457->885|2524->916|2538->921|2568->929|2611->941|2723->1017|2785->1070|2825->1072|2854->1082|2867->1086|2906->1087|2952->1100|3008->1120|3065->1155|3157->1212|3362->1395|3408->1406|3452->1441|3471->1451|3519->1461|3586->1492|3600->1497|3630->1505|3673->1517|3887->1696|3978->1765|4386->2145|4415->2146|4449->2153|4477->2154|4533->2175|4548->2182
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|35->7|35->7|35->7|37->9|40->12|40->12|42->14|42->14|42->14|42->14|42->14|42->14|42->14|43->15|43->15|44->16|46->18|48->20|48->20|48->20|48->20|49->21|49->21|49->21|50->22|55->27|55->27|55->27|55->27|55->27|55->27|55->27|56->28|56->28|57->29|59->31|61->33|61->33|61->33|61->33|62->34|62->34|62->34|63->35|75->47|75->47|87->59|87->59|90->62|90->62|94->66|94->66
                    -- GENERATED --
                */
            