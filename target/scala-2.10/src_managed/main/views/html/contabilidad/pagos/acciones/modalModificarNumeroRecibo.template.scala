
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
object modalModificarNumeroRecibo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[DynamicForm,Long,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm,id:Long):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.37*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.contabilidad.routes.PagosAccionesController.modificarNumeroRecibo(), 'id -> "formModificarNumeroRecibo")/*5.139*/ {_display_(Seq[Any](format.raw/*5.141*/("""
	
	"""),_display_(Seq[Any](/*7.3*/views/*7.8*/.html.tags.successError())),format.raw/*7.33*/("""
	
	"""),_display_(Seq[Any](/*9.3*/formBuscador("id_pago")/*9.26*/.error.map/*9.36*/{ error =>_display_(Seq[Any](format.raw/*9.46*/("""
		<div class="alert alert-danger"><i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*10.84*/error/*10.89*/.message)),format.raw/*10.97*/("""</div>
	""")))})),format.raw/*11.3*/("""
	
	<div id="alert-success" class="alert alert-success hide"></div>
	<div id="alert-danger" class="alert alert-danger hide"></div>
	
	<div class="row">
		<div class="col-sm-3">
			<div class="form-group """),_display_(Seq[Any](/*18.28*/if(formBuscador.error("numero_recibo") != null)/*18.75*/ {_display_(Seq[Any](format.raw/*18.77*/("""has-error""")))})),format.raw/*18.87*/("""">
				<label for="inputNumeroRecibo" class="control-label">N° Recibo</label> 
				"""),_display_(Seq[Any](/*20.6*/inputText(formBuscador("numero_recibo"), 'class -> "form-control", 'id -> "numero_recibo", 'autofocus -> "autofocus"))),format.raw/*20.123*/("""
			</div>
			<input type="hidden" name="id" value=""""),_display_(Seq[Any](/*22.43*/id)),format.raw/*22.45*/("""" />
				"""),_display_(Seq[Any](/*23.6*/formBuscador("numero_recibo")/*23.35*/.error.map/*23.45*/{ error =>_display_(Seq[Any](format.raw/*23.55*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*24.31*/error/*24.36*/.message)),format.raw/*24.44*/("""</div>
				""")))})),format.raw/*25.6*/("""
		</div>
		
		<div class="col-sm-5"><br />
			<button type="submit" class="btn btn-default" title="Guardar"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>
		</div>
		
	</div>
""")))})),format.raw/*33.2*/("""
"""),_display_(Seq[Any](/*34.2*/flash()/*34.9*/.clear())))}
    }
    
    def render(formBuscador:DynamicForm,id:Long): play.api.templates.HtmlFormat.Appendable = apply(formBuscador,id)
    
    def f:((DynamicForm,Long) => play.api.templates.HtmlFormat.Appendable) = (formBuscador,id) => apply(formBuscador,id)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:38 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/pagos/acciones/modalModificarNumeroRecibo.scala.html
                    HASH: 51d8b64eb87b8b02845949335364f606e80588a0
                    MATRIX: 833->1|970->55|1002->79|1076->36|1104->123|1142->127|1155->133|1295->264|1335->266|1374->271|1386->276|1432->301|1471->306|1502->329|1520->339|1567->349|1687->433|1701->438|1731->446|1771->455|2011->659|2067->706|2107->708|2149->718|2268->802|2408->919|2497->972|2521->974|2566->984|2604->1013|2623->1023|2671->1033|2738->1064|2752->1069|2782->1077|2825->1089|3051->1284|3088->1286|3103->1293
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|35->7|35->7|35->7|37->9|37->9|37->9|37->9|38->10|38->10|38->10|39->11|46->18|46->18|46->18|46->18|48->20|48->20|50->22|50->22|51->23|51->23|51->23|51->23|52->24|52->24|52->24|53->25|61->33|62->34|62->34
                    -- GENERATED --
                */
            