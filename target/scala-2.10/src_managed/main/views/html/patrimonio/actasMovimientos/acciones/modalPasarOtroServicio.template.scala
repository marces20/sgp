
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
object modalPasarOtroServicio extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[DynamicForm,Long,String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm,id:Long,url:String = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.55*/("""
"""),format.raw/*3.70*/(""" 
																			
"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.patrimonio.routes.ActasMovimientosController.pasarOtroServicio(), 'id -> "formPasarOtroServicio")/*5.132*/ {_display_(Seq[Any](format.raw/*5.134*/("""	
	
	"""),_display_(Seq[Any](/*7.3*/views/*7.8*/.html.tags.successError())),format.raw/*7.33*/("""
	"""),_display_(Seq[Any](/*8.3*/if(url)/*8.10*/ {_display_(Seq[Any](format.raw/*8.12*/("""
		<div class="panel panel-default">
		<div class="panel-body">
	    	<i class="glyphicon glyphicon-save"></i> <a href=""""),_display_(Seq[Any](/*11.58*/controllers/*11.69*/.contabilidad.routes.FacturasAccionesController.descargar322(url))),format.raw/*11.134*/("""">Descargar reporte pase</a>
		</div>
		</div>
	""")))}/*14.3*/else/*14.7*/{_display_(Seq[Any](format.raw/*14.8*/("""
	"""),_display_(Seq[Any](/*15.3*/if(id != null)/*15.17*/{_display_(Seq[Any](format.raw/*15.18*/("""
		<input type="hidden" name="idActa" id="idActa"  value=""""),_display_(Seq[Any](/*16.59*/id)),format.raw/*16.61*/(""""/>
	""")))})),format.raw/*17.3*/("""
	<div class="row">
		<div class="col-sm-8">
			<label for="inputOrganigrama" class="control-label">Departamento/Servicio</label> 
			<div class="input-group """),_display_(Seq[Any](/*21.29*/if(formBuscador.error("organigrama_id") != null)/*21.77*/ {_display_(Seq[Any](format.raw/*21.79*/("""has-error""")))})),format.raw/*21.89*/("""">
				
				"""),_display_(Seq[Any](/*23.6*/select(formBuscador("organigrama_id"), 
				Organigrama.find.where().eq("circuito_expediente", true).orderBy("nombre asc").findList().map{ p => p.id.toString -> p.nombre}, 'class -> 
				"form-control select", '_default -> "Seleccionar"))),format.raw/*25.55*/("""
			</div>
			"""),_display_(Seq[Any](/*27.5*/formBuscador("organigrama_id")/*27.35*/.error.map/*27.45*/{ error =>_display_(Seq[Any](format.raw/*27.55*/("""<div class="text-error">"""),_display_(Seq[Any](/*27.80*/error/*27.85*/.message)),format.raw/*27.93*/("""</div>""")))})),format.raw/*27.100*/("""
		</div>
	
	</div>
	<div class="row">
		<div class="col-sm-12">
			<label for="Descripción" class="control-label">Descripción</label>
			<div class="input-group """),_display_(Seq[Any](/*34.29*/if(formBuscador.error("descripcion") != null)/*34.74*/ {_display_(Seq[Any](format.raw/*34.76*/("""has-error""")))})),format.raw/*34.86*/("""">
				"""),_display_(Seq[Any](/*35.6*/textarea(formBuscador("descripcion"), 'class -> "form-control", 'id -> "descripcion", 'rows -> "3", 'cols -> "50"))),format.raw/*35.120*/("""
				"""),_display_(Seq[Any](/*36.6*/formBuscador("descripcion")/*36.33*/.error.map/*36.43*/{ error =>_display_(Seq[Any](format.raw/*36.53*/(""" <div class="text-error">"""),_display_(Seq[Any](/*36.79*/error/*36.84*/.message)),format.raw/*36.92*/("""</div>""")))})),format.raw/*36.99*/("""
			</div>
		</div>	
	</div>	
	
	
	<div class="row">
		<div class="col-sm-5"><br />
			<button type="submit" class="btn btn-default" title="Pasar a otro Servicio">
				<i class="glyphicon glyphicon-arrow-right"></i> Pasar a otro Servicio
			</button>
		</div>
	</div>
	""")))})),format.raw/*49.3*/("""
	
""")))})),format.raw/*51.2*/("""
<script>
$( function()"""),format.raw/*53.14*/("""{"""),format.raw/*53.15*/("""
	
"""),format.raw/*55.1*/("""}"""),format.raw/*55.2*/(""");
</script>
"""),_display_(Seq[Any](/*57.2*/flash()/*57.9*/.clear())))}
    }
    
    def render(formBuscador:DynamicForm,id:Long,url:String): play.api.templates.HtmlFormat.Appendable = apply(formBuscador,id,url)
    
    def f:((DynamicForm,Long,String) => play.api.templates.HtmlFormat.Appendable) = (formBuscador,id,url) => apply(formBuscador,id,url)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/actasMovimientos/acciones/modalPasarOtroServicio.scala.html
                    HASH: 403cdc93c3a57c33a9b61aea2f6a3ff49fa92000
                    MATRIX: 845->1|1000->73|1032->97|1106->54|1134->141|1191->164|1204->170|1337->294|1377->296|1417->302|1429->307|1475->332|1512->335|1527->342|1566->344|1723->465|1743->476|1831->541|1898->590|1910->594|1948->595|1986->598|2009->612|2048->613|2143->672|2167->674|2204->680|2399->839|2456->887|2496->889|2538->899|2586->912|2845->1149|2895->1164|2934->1194|2953->1204|3001->1214|3062->1239|3076->1244|3106->1252|3146->1259|3345->1422|3399->1467|3439->1469|3481->1479|3524->1487|3661->1601|3702->1607|3738->1634|3757->1644|3805->1654|3867->1680|3881->1685|3911->1693|3950->1700|4251->1970|4286->1974|4337->1997|4366->1998|4396->2001|4424->2002|4473->2016|4488->2023
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|35->7|35->7|35->7|36->8|36->8|36->8|39->11|39->11|39->11|42->14|42->14|42->14|43->15|43->15|43->15|44->16|44->16|45->17|49->21|49->21|49->21|49->21|51->23|53->25|55->27|55->27|55->27|55->27|55->27|55->27|55->27|55->27|62->34|62->34|62->34|62->34|63->35|63->35|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36|77->49|79->51|81->53|81->53|83->55|83->55|85->57|85->57
                    -- GENERATED --
                */
            