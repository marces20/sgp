
package views.html.informes.informeDeuda

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
object deudaGeneral extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.29*/("""
"""),format.raw/*5.70*/("""

"""),_display_(Seq[Any](/*7.2*/views/*7.7*/.html.informes.mainInformes("Creditos Presupuestarios")/*7.62*/ {_display_(Seq[Any](format.raw/*7.64*/("""

<script src=""""),_display_(Seq[Any](/*9.15*/routes/*9.21*/.Assets.at("javascripts/informes/deudasGenerales.js"))),format.raw/*9.74*/("""" type="text/javascript"></script>


<div class="page-header">
	<div class="row">
		<div class="col-sm-7">
			<h1>Deudas Generales</h1>
		</div>
	</div>
</div>
 



<div  id="contenedorGraficos">
	
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					<b>Deuda por Antiguedad</b>
				</div>
				<div class="panel-body">
					<div id="chart_deudaPorAntiguedadPorInstitucion">
						 
						<!-- <div id="loading"></div>-->
					</div>
				</div>
			</div>
		</div>
		 
		
	</div>
	
	
</div>

""")))})))}
    }
    
    def render(formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(formBuscador)
    
    def f:((DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (formBuscador) => apply(formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:28 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/informes/informeDeuda/deudaGeneral.scala.html
                    HASH: c75e6354187b39aa2c0eab8adb3f3cc022a798b9
                    MATRIX: 808->1|975->85|1007->109|1081->28|1109->153|1146->156|1158->161|1221->216|1260->218|1311->234|1325->240|1399->293
                    LINES: 26->1|33->5|33->5|34->1|35->5|37->7|37->7|37->7|37->7|39->9|39->9|39->9
                    -- GENERATED --
                */
            