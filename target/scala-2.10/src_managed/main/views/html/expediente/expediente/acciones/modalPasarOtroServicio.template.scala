
package views.html.expediente.expediente.acciones

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
																			
"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.expediente.routes.ExpedientesAccionesController.pasarOtroServicio(), 'id -> "formPasarOtroServicio")/*5.135*/ {_display_(Seq[Any](format.raw/*5.137*/("""	
	
	"""),_display_(Seq[Any](/*7.3*/views/*7.8*/.html.tags.successError())),format.raw/*7.33*/("""
	"""),_display_(Seq[Any](/*8.3*/if(url)/*8.10*/ {_display_(Seq[Any](format.raw/*8.12*/("""
		<div class="panel panel-default">
		<div class="panel-body">
	    	<i class="glyphicon glyphicon-save"></i> <a href=""""),_display_(Seq[Any](/*11.58*/controllers/*11.69*/.contabilidad.routes.FacturasAccionesController.descargar322(url))),format.raw/*11.134*/("""">Descargar reporte pase</a>
		</div>
		</div>
	""")))}/*14.3*/else/*14.7*/{_display_(Seq[Any](format.raw/*14.8*/("""
	"""),_display_(Seq[Any](/*15.3*/if(id != null)/*15.17*/{_display_(Seq[Any](format.raw/*15.18*/("""
		<input type="hidden" name="idExpediente" id="idExpediente"  value=""""),_display_(Seq[Any](/*16.71*/id)),format.raw/*16.73*/(""""/>
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
                    DATE: Tue Oct 04 11:43:36 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/expediente/expediente/acciones/modalPasarOtroServicio.scala.html
                    HASH: 510e36bdd056f94d47a5cee5fca65533547d799f
                    MATRIX: 839->1|994->73|1026->97|1100->54|1128->141|1185->164|1198->170|1334->297|1374->299|1414->305|1426->310|1472->335|1509->338|1524->345|1563->347|1720->468|1740->479|1828->544|1895->593|1907->597|1945->598|1983->601|2006->615|2045->616|2152->687|2176->689|2213->695|2408->854|2465->902|2505->904|2547->914|2595->927|2854->1164|2904->1179|2943->1209|2962->1219|3010->1229|3071->1254|3085->1259|3115->1267|3155->1274|3354->1437|3408->1482|3448->1484|3490->1494|3533->1502|3670->1616|3711->1622|3747->1649|3766->1659|3814->1669|3876->1695|3890->1700|3920->1708|3959->1715|4260->1985|4295->1989|4346->2012|4375->2013|4405->2016|4433->2017|4482->2031|4497->2038
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|35->7|35->7|35->7|36->8|36->8|36->8|39->11|39->11|39->11|42->14|42->14|42->14|43->15|43->15|43->15|44->16|44->16|45->17|49->21|49->21|49->21|49->21|51->23|53->25|55->27|55->27|55->27|55->27|55->27|55->27|55->27|55->27|62->34|62->34|62->34|62->34|63->35|63->35|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36|77->49|79->51|81->53|81->53|83->55|83->55|85->57|85->57
                    -- GENERATED --
                */
            