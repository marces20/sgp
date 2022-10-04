
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
object modalModificarPaguese extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.29*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.contabilidad.routes.PagosAccionesController.modificarPaguese(), 'id -> "formModificarPaguese")/*5.129*/ {_display_(Seq[Any](format.raw/*5.131*/("""
	
	"""),_display_(Seq[Any](/*7.3*/views/*7.8*/.html.tags.successError())),format.raw/*7.33*/("""
	
	"""),_display_(Seq[Any](/*9.3*/formBuscador("id_pago")/*9.26*/.error.map/*9.36*/{ error =>_display_(Seq[Any](format.raw/*9.46*/("""
		<div class="alert alert-danger"><i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*10.84*/error/*10.89*/.message)),format.raw/*10.97*/("""</div>
	""")))})),format.raw/*11.3*/("""
	
	<div id="alert-success" class="alert alert-success hide"></div>
	<div id="alert-danger" class="alert alert-danger hide"></div>
	
	<div class="row">
		<div class="col-sm-3">
			<div class="form-group """),_display_(Seq[Any](/*18.28*/if(formBuscador.error("paguese") != null)/*18.69*/ {_display_(Seq[Any](format.raw/*18.71*/("""has-error""")))})),format.raw/*18.81*/("""">
				<label for="inputFechaPago" class="control-label">Paguese A</label> 
				"""),_display_(Seq[Any](/*20.6*/inputText(formBuscador("paguese"), 'class -> "form-control", 'id -> "pagueseMosidicar", 'autofocus -> "autofocus"))),format.raw/*20.120*/("""
			</div>
				"""),_display_(Seq[Any](/*22.6*/formBuscador("paguese")/*22.29*/.error.map/*22.39*/{ error =>_display_(Seq[Any](format.raw/*22.49*/("""
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
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/pagos/acciones/modalModificarPaguese.scala.html
                    HASH: 4ffe51115a4a4b2f7254cf2d3df70b7294594a81
                    MATRIX: 823->1|953->49|985->73|1059->28|1088->117|1128->123|1141->129|1271->250|1311->252|1352->259|1364->264|1410->289|1451->296|1482->319|1500->329|1547->339|1668->424|1682->429|1712->437|1753->447|2000->658|2050->699|2090->701|2132->711|2250->794|2387->908|2440->926|2472->949|2491->959|2539->969|2607->1001|2621->1006|2651->1014|2695->1027|2929->1230|2967->1233|2982->1240
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|35->7|35->7|35->7|37->9|37->9|37->9|37->9|38->10|38->10|38->10|39->11|46->18|46->18|46->18|46->18|48->20|48->20|50->22|50->22|50->22|50->22|51->23|51->23|51->23|52->24|60->32|61->33|61->33
                    -- GENERATED --
                */
            