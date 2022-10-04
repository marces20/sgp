
package views.html.contabilidad.cuentas

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
object editarCuenta extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[Cuenta],Cuenta,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(cuentaForm: Form[Cuenta], cuentaPadre: Cuenta):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.49*/("""
"""),format.raw/*3.70*/(""" 
"""),_display_(Seq[Any](/*4.2*/views/*4.7*/.html.contabilidad.mainContabilidad("Modificar cuenta")/*4.62*/ {_display_(Seq[Any](format.raw/*4.64*/("""

<div class="page-header">
	<div class="row">
		<div class="col-sm-9">
			<h1>Editar cuenta</h1>
		</div>
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*12.14*/controllers/*12.25*/.contabilidad.routes.CuentasController.index(cuentaForm.get().id))),format.raw/*12.90*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
			<a href="#" class="btn btn-default"><i class="glyphicon glyphicon-align-justify"></i></a> 
		</div>
	</div>
</div>

"""),_display_(Seq[Any](/*18.2*/if(flash.containsKey("success"))/*18.34*/ {_display_(Seq[Any](format.raw/*18.36*/("""
	<div class="alert alert-success">
		<i class="glyphicon glyphicon-ok-circle"></i> """),_display_(Seq[Any](/*20.50*/flash/*20.55*/.get("success"))),format.raw/*20.70*/("""
	</div>
""")))})),format.raw/*22.2*/("""
"""),_display_(Seq[Any](/*23.2*/if(flash.containsKey("error"))/*23.32*/ {_display_(Seq[Any](format.raw/*23.34*/("""
	<div class="alert alert-danger">
		<i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*25.52*/flash/*25.57*/.get("error"))),format.raw/*25.70*/("""
	</div>
""")))})),format.raw/*27.2*/("""

"""),_display_(Seq[Any](/*29.2*/helper/*29.8*/.form(action = controllers.contabilidad.routes.CuentasController.actualizar())/*29.86*/ {_display_(Seq[Any](format.raw/*29.88*/("""
	"""),_display_(Seq[Any](/*30.3*/inputText(cuentaForm("id"), 'hidden -> "hidden"))),format.raw/*30.51*/("""
	"""),_display_(Seq[Any](/*31.3*/inputText(cuentaForm("parent_id"), 'hidden -> "hidden"))),format.raw/*31.58*/("""
	"""),_display_(Seq[Any](/*32.3*/views/*32.8*/.html.contabilidad.cuentas.form(cuentaForm, cuentaPadre))),format.raw/*32.64*/("""
	<div class="row form-actions">
	    <div class="col-lg-offset-4 col-lg-8">
	      <a href=""""),_display_(Seq[Any](/*35.18*/controllers/*35.29*/.contabilidad.routes.CuentasController.index(cuentaForm.get().id))),format.raw/*35.94*/("""" class="btn btn-default">Cancelar</a>
	      <button type="submit" class="btn btn-sistema">Editar</button>
	    </div>
	</div>
""")))})),format.raw/*39.2*/("""


""")))})),format.raw/*42.2*/("""
"""))}
    }
    
    def render(cuentaForm:Form[Cuenta],cuentaPadre:Cuenta): play.api.templates.HtmlFormat.Appendable = apply(cuentaForm,cuentaPadre)
    
    def f:((Form[Cuenta],Cuenta) => play.api.templates.HtmlFormat.Appendable) = (cuentaForm,cuentaPadre) => apply(cuentaForm,cuentaPadre)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/cuentas/editarCuenta.scala.html
                    HASH: 0fd9c3159a3e05afd0964eb16ed61abfb3cfc2a1
                    MATRIX: 815->1|965->69|997->93|1071->48|1100->137|1138->141|1150->146|1213->201|1252->203|1441->356|1461->367|1548->432|1781->630|1822->662|1862->664|1985->751|1999->756|2036->771|2079->783|2117->786|2156->816|2196->818|2320->906|2334->911|2369->924|2412->936|2452->941|2466->947|2553->1025|2593->1027|2632->1031|2702->1079|2741->1083|2818->1138|2857->1142|2870->1147|2948->1203|3081->1300|3101->1311|3188->1376|3352->1509|3390->1516
                    LINES: 26->1|29->3|29->3|30->1|31->3|32->4|32->4|32->4|32->4|40->12|40->12|40->12|46->18|46->18|46->18|48->20|48->20|48->20|50->22|51->23|51->23|51->23|53->25|53->25|53->25|55->27|57->29|57->29|57->29|57->29|58->30|58->30|59->31|59->31|60->32|60->32|60->32|63->35|63->35|63->35|67->39|70->42
                    -- GENERATED --
                */
            