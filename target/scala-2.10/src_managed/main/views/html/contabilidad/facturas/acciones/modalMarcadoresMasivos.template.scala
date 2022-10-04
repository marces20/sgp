
package views.html.contabilidad.facturas.acciones

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
object modalMarcadoresMasivos extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.29*/("""
"""),format.raw/*3.70*/(""" 
	
"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.contabilidad.routes.FacturasAccionesController.marcadoresMasivos(), 'id -> "formMarcadoresMasivos")/*5.134*/ {_display_(Seq[Any](format.raw/*5.136*/("""	
	
	"""),_display_(Seq[Any](/*7.3*/views/*7.8*/.html.tags.successError())),format.raw/*7.33*/("""
	 
	<div class="row">
		<div class="col-sm-3">
			<div class="checkbox">
				<label class="control-label"> 
					Debe libre deuda DGR
					"""),_display_(Seq[Any](/*14.7*/select(formBuscador("debe_dgr"),options(""->"","NO"->"NO","SI"->"SI"), 'class -> "form-control select",'id -> "debe_dgr"))),format.raw/*14.128*/("""
					 
				</label>
			</div> 
		</div>
		<div class="col-sm-3">
			<div class="checkbox">
				<label class="control-label"> 
					Debe libre deuda DGR aguinaldo
					"""),_display_(Seq[Any](/*23.7*/select(formBuscador("debe_dgr_aguinaldo"),options(""->"","NO"->"NO","SI"->"SI"), 'class -> "form-control select",'id -> "debe_dgr_aguinaldo"))),format.raw/*23.148*/("""
				</label>
			</div> 
		</div>
		<div class="col-sm-3">
			<div class="checkbox">
				<label class="control-label"> 
					Debe constancia AFIP
					"""),_display_(Seq[Any](/*31.7*/select(formBuscador("debe_afip"),options(""->"","NO"->"NO","SI"->"SI"), 'class -> "form-control select",'id -> "debe_afip"))),format.raw/*31.130*/("""
				</label>
			</div> 
		</div>
		<div class="col-sm-2">
			<div class="checkbox">
				<label class="control-label"> 
					Debe Judicial
					"""),_display_(Seq[Any](/*39.7*/select(formBuscador("debe_judicial"),options(""->"","NO"->"NO","SI"->"SI"), 'class -> "form-control select",'id -> "debe_judicial"))),format.raw/*39.138*/("""
					
				</label>
			</div> 
		</div>
		
	</div>
	 
	<div class="row">
		<div class="col-sm-5"><br />
			<button type="submit" class="btn btn-default" title="Agregar Marcadores Masivos"><i class="glyphicon glyphicon-arrow-right"></i> Cargar</button>
		</div>
	</div>

""")))})),format.raw/*53.2*/("""
<script>
$( function()"""),format.raw/*55.14*/("""{"""),format.raw/*55.15*/("""
	 
"""),format.raw/*57.1*/("""}"""),format.raw/*57.2*/(""");
</script>
"""),_display_(Seq[Any](/*59.2*/flash()/*59.9*/.clear())))}
    }
    
    def render(formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(formBuscador)
    
    def f:((DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (formBuscador) => apply(formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:40 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/facturas/acciones/modalMarcadoresMasivos.scala.html
                    HASH: e835607cc534a3f81d83f8d9119f37df5b5b1f28
                    MATRIX: 827->1|956->47|988->71|1062->28|1090->115|1129->120|1142->126|1277->252|1317->254|1357->260|1369->265|1415->290|1591->431|1735->552|1939->721|2103->862|2290->1014|2436->1137|2616->1282|2770->1413|3072->1684|3123->1707|3152->1708|3183->1712|3211->1713|3260->1727|3275->1734
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|35->7|35->7|35->7|42->14|42->14|51->23|51->23|59->31|59->31|67->39|67->39|81->53|83->55|83->55|85->57|85->57|87->59|87->59
                    -- GENERATED --
                */
            