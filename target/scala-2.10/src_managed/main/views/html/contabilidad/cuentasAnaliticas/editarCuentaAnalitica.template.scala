
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
object editarCuentaAnalitica extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[CuentaAnalitica],CuentaAnalitica,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(cuentaForm: Form[CuentaAnalitica], cuentaPadre: CuentaAnalitica):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.67*/("""
"""),format.raw/*3.70*/(""" 
"""),_display_(Seq[Any](/*4.2*/views/*4.7*/.html.contabilidad.mainContabilidad("Modificar cuenta")/*4.62*/ {_display_(Seq[Any](format.raw/*4.64*/("""

<div class="page-header">
	<div class="row">
		<div class="col-sm-9">
			<h1>Editar cuenta</h1>
		</div>
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*12.14*/controllers/*12.25*/.contabilidad.routes.CuentasAnaliticasController.index(cuentaForm.get().id))),format.raw/*12.100*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
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

"""),_display_(Seq[Any](/*29.2*/helper/*29.8*/.form(action = controllers.contabilidad.routes.CuentasAnaliticasController.actualizar())/*29.96*/ {_display_(Seq[Any](format.raw/*29.98*/("""
	"""),_display_(Seq[Any](/*30.3*/inputText(cuentaForm("id"), 'hidden -> "hidden"))),format.raw/*30.51*/("""
	"""),_display_(Seq[Any](/*31.3*/inputText(cuentaForm("parent_id"), 'hidden -> "hidden"))),format.raw/*31.58*/("""
	"""),_display_(Seq[Any](/*32.3*/views/*32.8*/.html.contabilidad.cuentasAnaliticas.form(cuentaForm, cuentaPadre))),format.raw/*32.74*/("""
	<div class="row form-actions">
	    <div class="col-lg-offset-4 col-lg-8">
	      <a href=""""),_display_(Seq[Any](/*35.18*/controllers/*35.29*/.contabilidad.routes.CuentasAnaliticasController.index(cuentaForm.get().id))),format.raw/*35.104*/("""" class="btn btn-default">Cancelar</a>
	      <button type="submit" class="btn btn-sistema">Editar</button>
	    </div>
	</div>
""")))})),format.raw/*39.2*/("""


""")))})),format.raw/*42.2*/("""
"""))}
    }
    
    def render(cuentaForm:Form[CuentaAnalitica],cuentaPadre:CuentaAnalitica): play.api.templates.HtmlFormat.Appendable = apply(cuentaForm,cuentaPadre)
    
    def f:((Form[CuentaAnalitica],CuentaAnalitica) => play.api.templates.HtmlFormat.Appendable) = (cuentaForm,cuentaPadre) => apply(cuentaForm,cuentaPadre)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:41 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/cuentasAnaliticas/editarCuentaAnalitica.scala.html
                    HASH: 030140f219f04082aa02c5a884e0da9b16057435
                    MATRIX: 852->1|1020->87|1052->111|1126->66|1155->155|1193->159|1205->164|1268->219|1307->221|1496->374|1516->385|1614->460|1847->658|1888->690|1928->692|2051->779|2065->784|2102->799|2145->811|2183->814|2222->844|2262->846|2386->934|2400->939|2435->952|2478->964|2518->969|2532->975|2629->1063|2669->1065|2708->1069|2778->1117|2817->1121|2894->1176|2933->1180|2946->1185|3034->1251|3167->1348|3187->1359|3285->1434|3449->1567|3487->1574
                    LINES: 26->1|29->3|29->3|30->1|31->3|32->4|32->4|32->4|32->4|40->12|40->12|40->12|46->18|46->18|46->18|48->20|48->20|48->20|50->22|51->23|51->23|51->23|53->25|53->25|53->25|55->27|57->29|57->29|57->29|57->29|58->30|58->30|59->31|59->31|60->32|60->32|60->32|63->35|63->35|63->35|67->39|70->42
                    -- GENERATED --
                */
            