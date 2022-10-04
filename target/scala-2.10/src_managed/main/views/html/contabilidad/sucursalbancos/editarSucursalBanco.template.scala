
package views.html.contabilidad.sucursalbancos

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
object editarSucursalBanco extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[SucursalBanco],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(sucursalBancoForm: Form[SucursalBanco]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.42*/("""
"""),format.raw/*3.70*/("""

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.contabilidad.mainContabilidad("Modificar sucursal de banco")/*5.73*/ {_display_(Seq[Any](format.raw/*5.75*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Editar sucursal</h1>
			</div>
			
			<div class="col-sm-2">
				<a href=""""),_display_(Seq[Any](/*14.15*/controllers/*14.26*/.contabilidad.routes.SucursalBancosController.indexSucursalBanco())),format.raw/*14.92*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
				<a href="#" class="btn btn-default"><i class="glyphicon glyphicon-align-justify"></i></a> 
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*20.3*/if(flash.containsKey("error"))/*20.33*/ {_display_(Seq[Any](format.raw/*20.35*/("""
		<div class="alert alert-danger">
			"""),_display_(Seq[Any](/*22.5*/flash/*22.10*/.get("error"))),format.raw/*22.23*/("""
		</div>
	""")))})),format.raw/*24.3*/("""
	
	"""),_display_(Seq[Any](/*26.3*/helper/*26.9*/.form(action = controllers.contabilidad.routes.SucursalBancosController.actualizarSucursalBanco())/*26.107*/ {_display_(Seq[Any](format.raw/*26.109*/("""
		"""),_display_(Seq[Any](/*27.4*/inputText(sucursalBancoForm("id"), 'hidden -> "hidden"))),format.raw/*27.59*/("""
		"""),_display_(Seq[Any](/*28.4*/views/*28.9*/.html.contabilidad.sucursalbancos.formSucursalBanco(sucursalBancoForm))),format.raw/*28.79*/("""
		<div class="row form-actions">
		    <div class="col-lg-offset-4 col-lg-8">
		      <a href=""""),_display_(Seq[Any](/*31.19*/controllers/*31.30*/.contabilidad.routes.SucursalBancosController.indexSucursalBanco())),format.raw/*31.96*/("""" class="btn btn-default">Cancelar</a>
		      <button type="submit" class="btn btn-sistema">Editar</button>
		    </div>
		</div>
	""")))})),format.raw/*35.3*/("""

""")))})))}
    }
    
    def render(sucursalBancoForm:Form[SucursalBanco]): play.api.templates.HtmlFormat.Appendable = apply(sucursalBancoForm)
    
    def f:((Form[SucursalBanco]) => play.api.templates.HtmlFormat.Appendable) = (sucursalBancoForm) => apply(sucursalBancoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:38 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/sucursalbancos/editarSucursalBanco.scala.html
                    HASH: 2df261e8c9c0b6433ab50128a15809bcb057e57a
                    MATRIX: 829->1|971->60|1003->84|1077->41|1105->128|1142->131|1154->136|1228->202|1267->204|1462->363|1482->374|1570->440|1803->638|1842->668|1882->670|1957->710|1971->715|2006->728|2049->740|2089->745|2103->751|2211->849|2252->851|2291->855|2368->910|2407->914|2420->919|2512->989|2645->1086|2665->1097|2753->1163|2917->1296
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|42->14|42->14|42->14|48->20|48->20|48->20|50->22|50->22|50->22|52->24|54->26|54->26|54->26|54->26|55->27|55->27|56->28|56->28|56->28|59->31|59->31|59->31|63->35
                    -- GENERATED --
                */
            