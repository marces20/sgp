
package views.html.patrimonio.actasMovimientos.acciones

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
object modalCierreCircuito extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[DynamicForm,Long,String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm,id:Long,url:String = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.55*/("""
"""),format.raw/*3.70*/(""" 
																			
"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.patrimonio.routes.ActasMovimientosController.cierreCircuito(), 'id -> "formCierreCircuito")/*5.126*/ {_display_(Seq[Any](format.raw/*5.128*/("""
	"""),_display_(Seq[Any](/*6.3*/views/*6.8*/.html.tags.successError())),format.raw/*6.33*/("""
	"""),_display_(Seq[Any](/*7.3*/if(url)/*7.10*/ {_display_(Seq[Any](format.raw/*7.12*/("""
		<div class="panel panel-default">
		<div class="panel-body">
	    	<i class="glyphicon glyphicon-save"></i> <a href=""""),_display_(Seq[Any](/*10.58*/controllers/*10.69*/.contabilidad.routes.FacturasAccionesController.descargar322(url))),format.raw/*10.134*/("""">Descargar reporte pase</a>
		</div>
		</div>
	""")))}/*13.3*/else/*13.7*/{_display_(Seq[Any](format.raw/*13.8*/("""
		"""),_display_(Seq[Any](/*14.4*/if(id != null)/*14.18*/{_display_(Seq[Any](format.raw/*14.19*/("""
			<input type="hidden" name="idActa" id="idActa"  value=""""),_display_(Seq[Any](/*15.60*/id)),format.raw/*15.62*/(""""/>
		""")))})),format.raw/*16.4*/("""
		 
		<div class="row">
			<div class="col-sm-12">
				<label for="Descripción" class="control-label">Descripción</label>
				<div class="input-group """),_display_(Seq[Any](/*21.30*/if(formBuscador.error("descripcion") != null)/*21.75*/ {_display_(Seq[Any](format.raw/*21.77*/("""has-error""")))})),format.raw/*21.87*/("""">
					"""),_display_(Seq[Any](/*22.7*/textarea(formBuscador("descripcion"), 'class -> "form-control", 'id -> "descripcion", 'rows -> "3", 'cols -> "50"))),format.raw/*22.121*/("""
					"""),_display_(Seq[Any](/*23.7*/formBuscador("descripcion")/*23.34*/.error.map/*23.44*/{ error =>_display_(Seq[Any](format.raw/*23.54*/(""" <div class="text-error">"""),_display_(Seq[Any](/*23.80*/error/*23.85*/.message)),format.raw/*23.93*/("""</div>""")))})),format.raw/*23.100*/("""
				</div>
			</div>	
		</div>	
		
		
		<div class="row">
			<div class="col-sm-5"><br />
				<button type="submit" class="btn btn-default" title="Cerrar Circuito">
					<i class="glyphicon glyphicon-arrow-right"></i> Cerrar Circuito
				</button>
			</div>
	</div>
	""")))})),format.raw/*36.3*/("""
""")))})),format.raw/*37.2*/("""
<script>
$( function()"""),format.raw/*39.14*/("""{"""),format.raw/*39.15*/("""
	
"""),format.raw/*41.1*/("""}"""),format.raw/*41.2*/(""");
</script>
"""),_display_(Seq[Any](/*43.2*/flash()/*43.9*/.clear())))}
    }
    
    def render(formBuscador:DynamicForm,id:Long,url:String): play.api.templates.HtmlFormat.Appendable = apply(formBuscador,id,url)
    
    def f:((DynamicForm,Long,String) => play.api.templates.HtmlFormat.Appendable) = (formBuscador,id,url) => apply(formBuscador,id,url)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/actasMovimientos/acciones/modalCierreCircuito.scala.html
                    HASH: cd10bee78a2e80fbddb132989f21b73a38488496
                    MATRIX: 842->1|997->73|1029->97|1103->54|1131->141|1188->164|1201->170|1328->288|1368->290|1405->293|1417->298|1463->323|1500->326|1515->333|1554->335|1711->456|1731->467|1819->532|1886->581|1898->585|1936->586|1975->590|1998->604|2037->605|2133->665|2157->667|2195->674|2383->826|2437->871|2477->873|2519->883|2563->892|2700->1006|2742->1013|2778->1040|2797->1050|2845->1060|2907->1086|2921->1091|2951->1099|2991->1106|3291->1375|3324->1377|3375->1400|3404->1401|3434->1404|3462->1405|3511->1419|3526->1426
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|34->6|34->6|34->6|35->7|35->7|35->7|38->10|38->10|38->10|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|44->16|49->21|49->21|49->21|49->21|50->22|50->22|51->23|51->23|51->23|51->23|51->23|51->23|51->23|51->23|64->36|65->37|67->39|67->39|69->41|69->41|71->43|71->43
                    -- GENERATED --
                */
            