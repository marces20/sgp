
package views.html.haberes.unidadesLaborales

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
object formUnidadLaboral extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.haberes.UnidadLaboral],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(unidadForm: Form[models.haberes.UnidadLaboral]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

import models.haberes._

implicit def /*6.2*/implicitFieldConstructor/*6.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.50*/("""
"""),format.raw/*6.70*/(""" 
	
	<div class="row menu-acciones">
		<div class="col-sm-10">
			<button type="submit" class="btn btn-default" title="Guardar unidad"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>
			<a href=""""),_display_(Seq[Any](/*11.14*/if(request().getHeader("referer"))/*11.48*/{_display_(Seq[Any](format.raw/*11.49*/(""" """),_display_(Seq[Any](/*11.51*/request()/*11.60*/.getHeader("referer"))),format.raw/*11.81*/(""" """)))}/*11.84*/else/*11.89*/{_display_(Seq[Any](_display_(Seq[Any](/*11.91*/controllers/*11.102*/.haberes.routes.UnidadesLaboralesController.index())),_display_(Seq[Any](/*11.154*/UriTrack/*11.162*/.decode()))))})),format.raw/*11.172*/("""" title="Cancelar editar" class="btn btn-default"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
		</div>
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*14.14*/UriTrack/*14.22*/.decode())),format.raw/*14.31*/("""" title="Volver al listado" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
		</div>	
	</div>
	<div class="row">
		 
		<div class="col-sm-5">
			<div class="form-group """),_display_(Seq[Any](/*20.28*/if(unidadForm.error("nombre") != null)/*20.66*/ {_display_(Seq[Any](format.raw/*20.68*/("""has-error""")))}/*20.78*/else/*20.82*/{_display_(Seq[Any](format.raw/*20.83*/("""has-required""")))})),format.raw/*20.96*/("""">
				<label for="inputDenominacion" class="control-label">Denominacion</label> 
				"""),_display_(Seq[Any](/*22.6*/inputText(unidadForm("nombre"), 'class -> "form-control"))),format.raw/*22.63*/("""
				"""),_display_(Seq[Any](/*23.6*/unidadForm("nombre")/*23.26*/.error.map/*23.36*/{ error =>_display_(Seq[Any](format.raw/*23.46*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*24.31*/error/*24.36*/.message)),format.raw/*24.44*/("""</div>
				""")))})),format.raw/*25.6*/("""
			</div>
		</div>
		 
	</div>
	"""))}
    }
    
    def render(unidadForm:Form[models.haberes.UnidadLaboral]): play.api.templates.HtmlFormat.Appendable = apply(unidadForm)
    
    def f:((Form[models.haberes.UnidadLaboral]) => play.api.templates.HtmlFormat.Appendable) = (unidadForm) => apply(unidadForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/unidadesLaborales/formUnidadLaboral.scala.html
                    HASH: 6dc635f7daa6102c567402ccb00a0a9c70628e7e
                    MATRIX: 840->1|1053->131|1085->155|1159->49|1187->199|1436->412|1479->446|1518->447|1556->449|1574->458|1617->479|1638->482|1651->487|1699->489|1720->500|1803->552|1821->560|1858->570|2054->730|2071->738|2102->747|2329->938|2376->976|2416->978|2445->988|2458->992|2497->993|2542->1006|2664->1093|2743->1150|2784->1156|2813->1176|2832->1186|2880->1196|2947->1227|2961->1232|2991->1240|3034->1252
                    LINES: 26->1|35->6|35->6|36->1|37->6|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|45->14|45->14|45->14|51->20|51->20|51->20|51->20|51->20|51->20|51->20|53->22|53->22|54->23|54->23|54->23|54->23|55->24|55->24|55->24|56->25
                    -- GENERATED --
                */
            