
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
object modalRechazarFactura extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.29*/("""
"""),format.raw/*3.70*/(""" 
	
"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.contabilidad.routes.FacturasAccionesController.rechazar(), 'id -> "formRechazarFactura")/*5.123*/ {_display_(Seq[Any](format.raw/*5.125*/("""	
	
	"""),_display_(Seq[Any](/*7.3*/views/*7.8*/.html.tags.successError())),format.raw/*7.33*/("""
	
	"""),_display_(Seq[Any](/*9.3*/for(facturaMotivoRechazo <- models.FacturaMotivoRechazo.getFacturaMotivoRechazo()) yield /*9.85*/ {_display_(Seq[Any](format.raw/*9.87*/("""
		<div class="row">
			<div class="col-sm-12"><br />
				<label><input type="checkbox" name="motivo_rechazo[]" value=""""),_display_(Seq[Any](/*12.67*/facturaMotivoRechazo/*12.87*/.id)),format.raw/*12.90*/(""""> """),_display_(Seq[Any](/*12.94*/facturaMotivoRechazo/*12.114*/.descripcion)),format.raw/*12.126*/("""</label>
			</div>
		</div>
	""")))})),format.raw/*15.3*/("""
	<div class="row">
		<div class="col-sm-12"><br />
			<label>Otro Motivo: <input type="text" name="otro" value=""></label>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-5"><br />
			<button type="submit" class="btn btn-default" title="Rechazar"><i class="glyphicon glyphicon-arrow-right"></i> Rechazar</button>
		</div>
	</div>
""")))})),format.raw/*26.2*/("""
"""),_display_(Seq[Any](/*27.2*/flash()/*27.9*/.clear())))}
    }
    
    def render(formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(formBuscador)
    
    def f:((DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (formBuscador) => apply(formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:40 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/facturas/acciones/modalRechazarFactura.scala.html
                    HASH: 6e6730a8bf857b571a45911aa07495297b9276e3
                    MATRIX: 825->1|954->47|986->71|1060->28|1088->115|1127->120|1140->126|1264->241|1304->243|1344->249|1356->254|1402->279|1441->284|1538->366|1577->368|1733->488|1762->508|1787->511|1827->515|1857->535|1892->547|1953->577|2325->918|2362->920|2377->927
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|35->7|35->7|35->7|37->9|37->9|37->9|40->12|40->12|40->12|40->12|40->12|40->12|43->15|54->26|55->27|55->27
                    -- GENERATED --
                */
            