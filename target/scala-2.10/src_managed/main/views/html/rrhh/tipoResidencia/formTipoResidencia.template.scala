
package views.html.rrhh.tipoResidencia

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
object formTipoResidencia extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[TipoResidencia],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(tpForm: Form[TipoResidencia]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.32*/("""
"""),format.raw/*4.70*/(""" 
	
	<div class="row menu-acciones">
		<div class="col-sm-10">
			<button type="submit" class="btn btn-default" title="Guardar agente"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>
			<a href=""""),_display_(Seq[Any](/*9.14*/if(request().getHeader("referer"))/*9.48*/{_display_(Seq[Any](format.raw/*9.49*/(""" """),_display_(Seq[Any](/*9.51*/request()/*9.60*/.getHeader("referer"))),format.raw/*9.81*/(""" """)))}/*9.84*/else/*9.89*/{_display_(Seq[Any](_display_(Seq[Any](/*9.91*/controllers/*9.102*/.rrhh.routes.TipoResidenciasController.indexTipoResidencia())),_display_(Seq[Any](/*9.163*/UriTrack/*9.171*/.decode()))))})),format.raw/*9.181*/("""" title="Cancelar editar" class="btn btn-default"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
		</div>
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*12.14*/UriTrack/*12.22*/.decode())),format.raw/*12.31*/("""" title="Volver al listado" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
			"""),_display_(Seq[Any](/*13.5*/if(tpForm.field("id").value)/*13.33*/{_display_(Seq[Any](format.raw/*13.34*/("""<a href=""""),_display_(Seq[Any](/*13.44*/controllers/*13.55*/.rrhh.routes.TipoResidenciasController.ver(tpForm.field("id").value.toLong))),_display_(Seq[Any](/*13.131*/UriTrack/*13.139*/.get("&"))),format.raw/*13.148*/("""" title="Ver residencia" class="btn btn-default"><i class="glyphicon glyphicon-align-justify"></i></a>""")))})),format.raw/*13.251*/("""
		</div>
	</div>

	<div class="row">
		<div class="col-sm-4">
			<div class="form-group """),_display_(Seq[Any](/*19.28*/if(tpForm.error("nombre") != null)/*19.62*/ {_display_(Seq[Any](format.raw/*19.64*/("""has-error""")))}/*19.74*/else/*19.78*/{_display_(Seq[Any](format.raw/*19.79*/("""has-required""")))})),format.raw/*19.92*/("""">
				<label for="inputNombre" class="control-label">Nombre</label> 
				"""),_display_(Seq[Any](/*21.6*/inputText(tpForm("nombre"), 'class -> "form-control"))),format.raw/*21.59*/("""
				"""),_display_(Seq[Any](/*22.6*/tpForm("nombre")/*22.22*/.error.map/*22.32*/{ error =>_display_(Seq[Any](format.raw/*22.42*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*23.31*/error/*23.36*/.message)),format.raw/*23.44*/("""</div>
				""")))})),format.raw/*24.6*/("""
			</div>
		</div>
		<div class="col-sm-2">
			<label class="control-label"> 
				Tipo
				"""),_display_(Seq[Any](/*30.6*/select(tpForm("tipo"),options("basica"->"Basica","posbasica"->"Posbasica"), 'class -> "form-control select"))),format.raw/*30.114*/("""
			</label>
		</div>
	</div>
	"""))}
    }
    
    def render(tpForm:Form[TipoResidencia]): play.api.templates.HtmlFormat.Appendable = apply(tpForm)
    
    def f:((Form[TipoResidencia]) => play.api.templates.HtmlFormat.Appendable) = (tpForm) => apply(tpForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:29 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/tipoResidencia/formTipoResidencia.scala.html
                    HASH: eb30527a79bd56775ab244406f015ee97e9046a4
                    MATRIX: 821->1|969->66|1001->90|1075->31|1103->134|1351->347|1393->381|1431->382|1468->384|1485->393|1527->414|1547->417|1559->422|1606->424|1626->435|1717->496|1734->504|1770->514|1966->674|1983->682|2014->691|2151->793|2188->821|2227->822|2273->832|2293->843|2400->919|2418->927|2450->936|2586->1039|2712->1129|2755->1163|2795->1165|2824->1175|2837->1179|2876->1180|2921->1193|3031->1268|3106->1321|3147->1327|3172->1343|3191->1353|3239->1363|3306->1394|3320->1399|3350->1407|3393->1419|3521->1512|3652->1620
                    LINES: 26->1|31->4|31->4|32->1|33->4|38->9|38->9|38->9|38->9|38->9|38->9|38->9|38->9|38->9|38->9|38->9|38->9|38->9|41->12|41->12|41->12|42->13|42->13|42->13|42->13|42->13|42->13|42->13|42->13|42->13|48->19|48->19|48->19|48->19|48->19|48->19|48->19|50->21|50->21|51->22|51->22|51->22|51->22|52->23|52->23|52->23|53->24|59->30|59->30
                    -- GENERATED --
                */
            