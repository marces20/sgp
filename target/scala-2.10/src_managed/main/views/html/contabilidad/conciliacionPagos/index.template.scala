
package views.html.contabilidad.conciliacionPagos

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
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.4*/("""

"""),_display_(Seq[Any](/*3.2*/views/*3.7*/.html.contabilidad.mainContabilidad(title = "Conciliación cheques")/*3.74*/ {_display_(Seq[Any](format.raw/*3.76*/("""

<div class="page-header">
	<div class="row">
		<div class="col-sm-9">
			<h1>Conciliación cheques</h1>
		</div>
	</div>
</div>

"""),_display_(Seq[Any](/*13.2*/views/*13.7*/.html.tags.successError())),format.raw/*13.32*/("""
        
	<div class="content">
	"""),_display_(Seq[Any](/*16.3*/helper/*16.9*/.form(action = controllers.contabilidad.routes.ConciliacionPagosController.analisisConciliacionCheques(), 'enctype -> "multipart/form-data")/*16.149*/ {_display_(Seq[Any](format.raw/*16.151*/("""

		<input type="file" name="archivo">
	
		<div class="row form-actions">
		    <div class="col-lg-offset-4 col-lg-8">
		      <button type="submit" class="btn btn-sistema">Verificar</button>
		    </div>
		</div>

	""")))})),format.raw/*26.3*/("""
	</div>


""")))})))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:41 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/conciliacionPagos/index.scala.html
                    HASH: c38279c7c8efcc45def9ee10533e12263914a49b
                    MATRIX: 798->1|893->3|932->8|944->13|1019->80|1058->82|1234->223|1247->228|1294->253|1367->291|1381->297|1531->437|1572->439|1830->666
                    LINES: 26->1|29->1|31->3|31->3|31->3|31->3|41->13|41->13|41->13|44->16|44->16|44->16|44->16|54->26
                    -- GENERATED --
                */
            