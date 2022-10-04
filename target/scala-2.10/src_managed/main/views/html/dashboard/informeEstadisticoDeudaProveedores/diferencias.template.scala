
package views.html.dashboard.informeEstadisticoDeudaProveedores

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
object diferencias extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[List[String],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lista: List[String]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.23*/("""

"""),_display_(Seq[Any](/*3.2*/views/*3.7*/.html.contabilidad.mainContabilidad(title = "Diferencias")/*3.65*/ {_display_(Seq[Any](format.raw/*3.67*/("""

<div class="page-header">
	<div class="row">
		<div class="col-sm-9">
			<h1>Diferencias</h1>
		</div>
	</div>
</div>

"""),_display_(Seq[Any](/*13.2*/views/*13.7*/.html.tags.successError())),format.raw/*13.32*/("""
        
<div class="content">
"""),_display_(Seq[Any](/*16.2*/helper/*16.8*/.form(action = controllers.dashboard.routes.InformeEstadisticoDeudaProveedoresController.procesarDiferencias(), 'enctype -> "multipart/form-data")/*16.154*/ {_display_(Seq[Any](format.raw/*16.156*/("""



	<input type="file" name="archivo">

	<div class="row form-actions">
	    <div class="col-lg-offset-4 col-lg-8">
	      <button type="submit" class="btn btn-sistema">Procesar</button>
	    </div>
	</div>


	"""),_display_(Seq[Any](/*29.3*/if(!lista.isEmpty())/*29.23*/ {_display_(Seq[Any](format.raw/*29.25*/("""
	
		<h4>Diferencias ("""),_display_(Seq[Any](/*31.21*/lista/*31.26*/.size())),format.raw/*31.33*/(""")</h4>
	
		"""),_display_(Seq[Any](/*33.4*/for(l <- lista) yield /*33.19*/ {_display_(Seq[Any](format.raw/*33.21*/("""
			"""),_display_(Seq[Any](/*34.5*/l)),format.raw/*34.6*/(""" <br />
		""")))})),format.raw/*35.4*/("""
	""")))})),format.raw/*36.3*/("""


""")))})),format.raw/*39.2*/("""
</div>

""")))})),format.raw/*42.2*/("""
"""))}
    }
    
    def render(lista:List[String]): play.api.templates.HtmlFormat.Appendable = apply(lista)
    
    def f:((List[String]) => play.api.templates.HtmlFormat.Appendable) = (lista) => apply(lista)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:56 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/informeEstadisticoDeudaProveedores/diferencias.scala.html
                    HASH: c34a02cfe32b879eec55887a74f822bb3ee561c3
                    MATRIX: 831->1|946->22|985->27|997->32|1063->90|1102->92|1269->224|1282->229|1329->254|1400->290|1414->296|1570->442|1611->444|1871->669|1900->689|1940->691|2001->716|2015->721|2044->728|2093->742|2124->757|2164->759|2205->765|2227->766|2270->778|2305->782|2343->789|2387->802
                    LINES: 26->1|29->1|31->3|31->3|31->3|31->3|41->13|41->13|41->13|44->16|44->16|44->16|44->16|57->29|57->29|57->29|59->31|59->31|59->31|61->33|61->33|61->33|62->34|62->34|63->35|64->36|67->39|70->42
                    -- GENERATED --
                */
            