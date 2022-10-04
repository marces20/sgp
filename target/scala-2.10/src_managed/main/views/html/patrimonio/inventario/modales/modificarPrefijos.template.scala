
package views.html.patrimonio.inventario.modales

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
object modificarPrefijos extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[InventarioPrefijo],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(actaForm: Form[InventarioPrefijo]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.37*/("""
"""),format.raw/*4.70*/(""" 
    
"""),_display_(Seq[Any](/*6.2*/helper/*6.8*/.form(action = controllers.patrimonio.routes.PrefijosAccionesController.modificar(), 'id -> "formGuardarActaRecepcion")/*6.127*/ {_display_(Seq[Any](format.raw/*6.129*/("""
"""),_display_(Seq[Any](/*7.2*/views/*7.7*/.html.tags.successError())),format.raw/*7.32*/("""
 <div class="row">

	<label for="cuenta" class="control-label">Prefijo</label>
	<div class="input-group has-required">
		"""),_display_(Seq[Any](/*12.4*/inputText(actaForm("profijo.nombre"), 'class -> "form-control", 'id -> "prefijo"))),format.raw/*12.85*/("""
		"""),_display_(Seq[Any](/*13.4*/inputText(actaForm("prefijo_inventario_id"), 'hidden -> "hidden", 'id -> "prefijo_id"))),format.raw/*13.90*/("""
		<span class="input-group-addon">
			<a href="#" 
			   id="searchPrefijo" 
			   class="searchModal"
			   data-title="Selección de prefijo" 
			   data-url=""""),_display_(Seq[Any](/*19.18*/controllers/*19.29*/.patrimonio.routes.PrefijosController.modalBuscar())),format.raw/*19.80*/("""" 
			   data-height="650" 
			   data-width="700" 
			   data-listen="modal.seleccion.prefijo.simple" 
			   data-label="#prefijo" data-field="#prefijo_id">
			   <i class="glyphicon glyphicon-search"></i>
			 </a>
		</span>
	</div>

	
	<div class="col-sm-2">
		<div class="form-group">
		<label for="nombre" class="control-label">&nbsp;</label>
		<button  class="form-control btn btn-primary"> Guardar</button>
		</div>
	</div>	

</div>	

""")))})),format.raw/*39.2*/("""

"""),_display_(Seq[Any](/*41.2*/flash()/*41.9*/.clear())))}
    }
    
    def render(actaForm:Form[InventarioPrefijo]): play.api.templates.HtmlFormat.Appendable = apply(actaForm)
    
    def f:((Form[InventarioPrefijo]) => play.api.templates.HtmlFormat.Appendable) = (actaForm) => apply(actaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/inventario/modales/modificarPrefijos.scala.html
                    HASH: 0757488efd01d468fc3d7654410ebfc0492b2505
                    MATRIX: 833->1|988->74|1020->98|1094->36|1123->142|1167->152|1180->158|1308->277|1348->279|1385->282|1397->287|1443->312|1606->440|1709->521|1749->526|1857->612|2061->780|2081->791|2154->842|2647->1304|2687->1309|2702->1316
                    LINES: 26->1|31->4|31->4|32->1|33->4|35->6|35->6|35->6|35->6|36->7|36->7|36->7|41->12|41->12|42->13|42->13|48->19|48->19|48->19|68->39|70->41|70->41
                    -- GENERATED --
                */
            