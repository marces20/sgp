
package views.html.contabilidad.pagos.acciones

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
object modalModificarReferencia extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.29*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.contabilidad.routes.PagosAccionesController.modificarReferencia(), 'id -> "formModificarReferencia")/*5.135*/ {_display_(Seq[Any](format.raw/*5.137*/("""
	
	"""),_display_(Seq[Any](/*7.3*/views/*7.8*/.html.tags.successError())),format.raw/*7.33*/("""
	
	"""),_display_(Seq[Any](/*9.3*/formBuscador("id_pago")/*9.26*/.error.map/*9.36*/{ error =>_display_(Seq[Any](format.raw/*9.46*/("""
		<div class="alert alert-danger"><i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*10.84*/error/*10.89*/.message)),format.raw/*10.97*/("""</div>
	""")))})),format.raw/*11.3*/("""
	
	<div id="alert-success" class="alert alert-success hide"></div>
	<div id="alert-danger" class="alert alert-danger hide"></div>
	
	<div class="row">
		<div class="col-sm-3">
			<div class="form-group """),_display_(Seq[Any](/*18.28*/if(formBuscador.error("referencia") != null)/*18.72*/ {_display_(Seq[Any](format.raw/*18.74*/("""has-error""")))})),format.raw/*18.84*/("""">
				<label for="inputFechaPago" class="control-label">Referencia</label> 
				"""),_display_(Seq[Any](/*20.6*/inputText(formBuscador("referencia"), 'class -> "form-control", 'id -> "referenciaParaMosidicar", 'autofocus -> "autofocus"))),format.raw/*20.130*/("""
			</div>
				"""),_display_(Seq[Any](/*22.6*/formBuscador("referencia")/*22.32*/.error.map/*22.42*/{ error =>_display_(Seq[Any](format.raw/*22.52*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*23.31*/error/*23.36*/.message)),format.raw/*23.44*/("""</div>
				""")))})),format.raw/*24.6*/("""
		</div>
		
		<div class="col-sm-5"><br />
			<button type="submit" class="btn btn-default" title="Guardar"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>
		</div>
		
	</div>
""")))})),format.raw/*32.2*/("""
"""),_display_(Seq[Any](/*33.2*/flash()/*33.9*/.clear())))}
    }
    
    def render(formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(formBuscador)
    
    def f:((DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (formBuscador) => apply(formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:38 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/pagos/acciones/modalModificarReferencia.scala.html
                    HASH: 96ad7343f19f7c147e9b30727b2d31caa33cfdcf
                    MATRIX: 826->1|956->49|988->73|1062->28|1091->117|1131->123|1144->129|1280->256|1320->258|1361->265|1373->270|1419->295|1460->302|1491->325|1509->335|1556->345|1677->430|1691->435|1721->443|1762->453|2009->664|2062->708|2102->710|2144->720|2263->804|2410->928|2463->946|2498->972|2517->982|2565->992|2633->1024|2647->1029|2677->1037|2721->1050|2955->1253|2993->1256|3008->1263
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|35->7|35->7|35->7|37->9|37->9|37->9|37->9|38->10|38->10|38->10|39->11|46->18|46->18|46->18|46->18|48->20|48->20|50->22|50->22|50->22|50->22|51->23|51->23|51->23|52->24|60->32|61->33|61->33
                    -- GENERATED --
                */
            