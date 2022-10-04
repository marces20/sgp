
package views.html.contabilidad.cuentasAnaliticas

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
object crearCuentaAnalitica extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[CuentaAnalitica],CuentaAnalitica,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(cuentaForm: Form[CuentaAnalitica], cuentaPadre: CuentaAnalitica):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.67*/("""
"""),format.raw/*3.70*/(""" 
"""),_display_(Seq[Any](/*4.2*/views/*4.7*/.html.contabilidad.mainContabilidad(title = "Cuentas presupuestarias")/*4.77*/ {_display_(Seq[Any](format.raw/*4.79*/("""

<div class="page-header">
	<div class="row">
		<div class="col-sm-10">
			<h1>Agregar cuenta</h1>
		</div>
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*12.14*/controllers/*12.25*/.contabilidad.routes.CuentasAnaliticasController.index(cuentaPadre.id))),format.raw/*12.95*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
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

"""),_display_(Seq[Any](/*31.2*/helper/*31.8*/.form(action = controllers.contabilidad.routes.CuentasAnaliticasController.guardar(cuentaPadre.id))/*31.107*/ {_display_(Seq[Any](format.raw/*31.109*/("""
	"""),_display_(Seq[Any](/*32.3*/views/*32.8*/.html.contabilidad.cuentasAnaliticas.form(cuentaForm, cuentaPadre))),format.raw/*32.74*/("""
	
<div class="row form-actions">
    <div class="col-lg-offset-4 col-lg-8">
      <a href=""""),_display_(Seq[Any](/*36.17*/controllers/*36.28*/.contabilidad.routes.CuentasAnaliticasController.index(cuentaPadre.id))),format.raw/*36.98*/("""" class="btn btn-default">Cancelar</a>
      <button type="submit" class="btn btn-sistema">Agregar</button>
    </div>
</div>
	
""")))})),format.raw/*41.2*/("""

""")))})))}
    }
    
    def render(cuentaForm:Form[CuentaAnalitica],cuentaPadre:CuentaAnalitica): play.api.templates.HtmlFormat.Appendable = apply(cuentaForm,cuentaPadre)
    
    def f:((Form[CuentaAnalitica],CuentaAnalitica) => play.api.templates.HtmlFormat.Appendable) = (cuentaForm,cuentaPadre) => apply(cuentaForm,cuentaPadre)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:41 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/cuentasAnaliticas/crearCuentaAnalitica.scala.html
                    HASH: 5471115e161f93f648b18ad7af9b0f06175f1d74
                    MATRIX: 851->1|1019->87|1051->111|1125->66|1154->155|1192->159|1204->164|1282->234|1321->236|1512->391|1532->402|1624->472|1861->674|1902->706|1942->708|2065->795|2079->800|2116->815|2159->827|2197->830|2236->860|2276->862|2400->950|2414->955|2449->968|2492->980|2532->985|2546->991|2655->1090|2696->1092|2735->1096|2748->1101|2836->1167|2969->1264|2989->1275|3081->1345|3246->1479
                    LINES: 26->1|29->3|29->3|30->1|31->3|32->4|32->4|32->4|32->4|40->12|40->12|40->12|48->20|48->20|48->20|50->22|50->22|50->22|52->24|53->25|53->25|53->25|55->27|55->27|55->27|57->29|59->31|59->31|59->31|59->31|60->32|60->32|60->32|64->36|64->36|64->36|69->41
                    -- GENERATED --
                */
            