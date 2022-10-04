
package views.html.patrimonio.actasMovimientos

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
object formActaMovimiento extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[ActaMovimiento],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[ActaMovimiento]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.35*/("""
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
	"""),_display_(Seq[Any](/*18.3*/inputText(lineaForm("acta_id"), 'type -> "hidden"))),format.raw/*18.53*/("""
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
    
    def render(lineaForm:Form[ActaMovimiento]): play.api.templates.HtmlFormat.Appendable = apply(lineaForm)
    
    def f:((Form[ActaMovimiento]) => play.api.templates.HtmlFormat.Appendable) = (lineaForm) => apply(lineaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/actasMovimientos/formActaMovimiento.scala.html
                    HASH: 560f202490214e2f9b0623591b7aad2b925afd34
                    MATRIX: 829->1|965->55|997->79|1071->34|1100->123|1144->133|1182->163|1221->165|1344->253|1357->258|1391->271|1434->283|1486->307|1515->308|1544->310|1572->311|1646->350|1718->400|1894->540|1948->585|1988->587|2030->597|2073->605|2329->839|2379->854|2415->881|2434->891|2482->901|2543->926|2557->931|2587->939|2626->946|2827->1111|2878->1153|2918->1155|2960->1165|3003->1173|3137->1284|3178->1290|3211->1314|3230->1324|3278->1334|3340->1360|3354->1365|3384->1373|3423->1380
                    LINES: 26->1|29->3|29->3|30->1|31->3|35->7|35->7|35->7|37->9|37->9|37->9|39->11|41->13|41->13|42->14|42->14|46->18|46->18|49->21|49->21|49->21|49->21|50->22|52->24|54->26|54->26|54->26|54->26|54->26|54->26|54->26|54->26|62->34|62->34|62->34|62->34|63->35|63->35|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36
                    -- GENERATED --
                */
            