
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
object crearCuenta extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[Cuenta],Cuenta,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(cuentaForm: Form[Cuenta], cuentaPadre: Cuenta):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.49*/("""
"""),format.raw/*3.70*/(""" 
"""),_display_(Seq[Any](/*4.2*/views/*4.7*/.html.contabilidad.mainContabilidad("Agregar cuenta")/*4.60*/ {_display_(Seq[Any](format.raw/*4.62*/("""

<div class="page-header">
	<div class="row">
		<div class="col-sm-10">
			<h1>Agregar cuenta</h1>
		</div>
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*12.14*/controllers/*12.25*/.contabilidad.routes.CuentasController.index(cuentaPadre.id))),format.raw/*12.85*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
			<a href="#" class="btn btn-default"><i class="glyphicon glyphicon-align-justify"></i></a> 
		</div>
	</div>
</div>



"""),_display_(Seq[Any](/*20.2*/if(flash.containsKey("success"))/*20.34*/ {_display_(Seq[Any](format.raw/*20.36*/("""
	<div class="alert alert-success">
		<i class="glyphicon glyphicon-ok-circle"></i> """),_display_(Seq[Any](/*22.50*/flash/*22.55*/.get("success"))),format.raw/*22.70*/("""
	</div>
""")))})),format.raw/*24.2*/("""
"""),_display_(Seq[Any](/*25.2*/if(flash.containsKey("error"))/*25.32*/ {_display_(Seq[Any](format.raw/*25.34*/("""
	<div class="alert alert-danger">
		<i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*27.52*/flash/*27.57*/.get("error"))),format.raw/*27.70*/("""
	</div>
""")))})),format.raw/*29.2*/("""

"""),_display_(Seq[Any](/*31.2*/helper/*31.8*/.form(action = controllers.contabilidad.routes.CuentasController.guardar(cuentaPadre.id))/*31.97*/ {_display_(Seq[Any](format.raw/*31.99*/("""
	"""),_display_(Seq[Any](/*32.3*/views/*32.8*/.html.contabilidad.cuentas.form(cuentaForm, cuentaPadre))),format.raw/*32.64*/("""
	
<div class="row form-actions">
    <div class="col-lg-offset-4 col-lg-8">
      <a href=""""),_display_(Seq[Any](/*36.17*/controllers/*36.28*/.contabilidad.routes.CuentasController.index(cuentaPadre.id))),format.raw/*36.88*/("""" class="btn btn-default">Cancelar</a>
      <button type="submit" class="btn btn-sistema">Agregar</button>
    </div>
</div>
	
""")))})),format.raw/*41.2*/("""

""")))})))}
    }
    
    def render(cuentaForm:Form[Cuenta],cuentaPadre:Cuenta): play.api.templates.HtmlFormat.Appendable = apply(cuentaForm,cuentaPadre)
    
    def f:((Form[Cuenta],Cuenta) => play.api.templates.HtmlFormat.Appendable) = (cuentaForm,cuentaPadre) => apply(cuentaForm,cuentaPadre)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/cuentas/crearCuenta.scala.html
                    HASH: 7104217174ed0304b20c88fceacc18066a3c5824
                    MATRIX: 814->1|964->69|996->93|1070->48|1099->137|1137->141|1149->146|1210->199|1249->201|1440->356|1460->367|1542->427|1779->629|1820->661|1860->663|1983->750|1997->755|2034->770|2077->782|2115->785|2154->815|2194->817|2318->905|2332->910|2367->923|2410->935|2450->940|2464->946|2562->1035|2602->1037|2641->1041|2654->1046|2732->1102|2865->1199|2885->1210|2967->1270|3132->1404
                    LINES: 26->1|29->3|29->3|30->1|31->3|32->4|32->4|32->4|32->4|40->12|40->12|40->12|48->20|48->20|48->20|50->22|50->22|50->22|52->24|53->25|53->25|53->25|55->27|55->27|55->27|57->29|59->31|59->31|59->31|59->31|60->32|60->32|60->32|64->36|64->36|64->36|69->41
                    -- GENERATED --
                */
            