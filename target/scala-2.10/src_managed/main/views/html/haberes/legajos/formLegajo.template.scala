
package views.html.haberes.legajos

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
object formLegajo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.haberes.Legajo],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(legajoForm: Form[models.haberes.Legajo]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

import models.haberes._

implicit def /*6.2*/implicitFieldConstructor/*6.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.43*/("""
"""),format.raw/*6.70*/(""" 
	
	<div class="row menu-acciones">
		<div class="col-sm-10">
			<button type="submit" class="btn btn-default" title="Guardar legajo"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>
			<a href=""""),_display_(Seq[Any](/*11.14*/if(request().getHeader("referer"))/*11.48*/{_display_(Seq[Any](format.raw/*11.49*/(""" """),_display_(Seq[Any](/*11.51*/request()/*11.60*/.getHeader("referer"))),format.raw/*11.81*/(""" """)))}/*11.84*/else/*11.89*/{_display_(Seq[Any](_display_(Seq[Any](/*11.91*/controllers/*11.102*/.haberes.routes.LegajosController.index())),_display_(Seq[Any](/*11.144*/UriTrack/*11.152*/.decode()))))})),format.raw/*11.162*/("""" title="Cancelar editar" class="btn btn-default"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
		</div>
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*14.14*/UriTrack/*14.22*/.decode())),format.raw/*14.31*/("""" title="Volver al listado" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
		</div>	
	</div>
	<div class="row">
		 
		<div class="col-sm-5">
			<div class="form-group """),_display_(Seq[Any](/*20.28*/if(legajoForm.error("numero") != null)/*20.66*/ {_display_(Seq[Any](format.raw/*20.68*/("""has-error""")))}/*20.78*/else/*20.82*/{_display_(Seq[Any](format.raw/*20.83*/("""has-required""")))})),format.raw/*20.96*/("""">
				<label for="inputNumero" class="control-label">Numero</label> 
				"""),_display_(Seq[Any](/*22.6*/inputText(legajoForm("numero"), 'class -> "form-control"))),format.raw/*22.63*/("""
				"""),_display_(Seq[Any](/*23.6*/legajoForm("numero")/*23.26*/.error.map/*23.36*/{ error =>_display_(Seq[Any](format.raw/*23.46*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*24.31*/error/*24.36*/.message)),format.raw/*24.44*/("""</div>
				""")))})),format.raw/*25.6*/("""
			</div>
		</div>
		 
	</div>
	"""))}
    }
    
    def render(legajoForm:Form[models.haberes.Legajo]): play.api.templates.HtmlFormat.Appendable = apply(legajoForm)
    
    def f:((Form[models.haberes.Legajo]) => play.api.templates.HtmlFormat.Appendable) = (legajoForm) => apply(legajoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/legajos/formLegajo.scala.html
                    HASH: 8992f5ec5638efaf43c298097706bc837f6ec63d
                    MATRIX: 816->1|1022->124|1054->148|1128->42|1156->192|1405->405|1448->439|1487->440|1525->442|1543->451|1586->472|1607->475|1620->480|1668->482|1689->493|1762->535|1780->543|1817->553|2013->713|2030->721|2061->730|2288->921|2335->959|2375->961|2404->971|2417->975|2456->976|2501->989|2611->1064|2690->1121|2731->1127|2760->1147|2779->1157|2827->1167|2894->1198|2908->1203|2938->1211|2981->1223
                    LINES: 26->1|35->6|35->6|36->1|37->6|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|42->11|45->14|45->14|45->14|51->20|51->20|51->20|51->20|51->20|51->20|51->20|53->22|53->22|54->23|54->23|54->23|54->23|55->24|55->24|55->24|56->25
                    -- GENERATED --
                */
            