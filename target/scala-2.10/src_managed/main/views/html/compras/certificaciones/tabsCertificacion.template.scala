
package views.html.compras.certificaciones

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
object tabsCertificacion extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Boolean,Form[Certificacion],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formularioCarga: Boolean, certificacionForm: Form[Certificacion] = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.75*/("""

<ul id="certificacionTab" class="nav nav-tabs">
	<li class="active"><a class="tabProducto" href="#contenedorProductos" data-toggle="tab">Productos</a></li>
	<li><a class="tabNotas" href="#contenedorNotas" data-toggle="tab">Notas</a></li>
</ul>

<div class="tab-content">

	<div class="tab-pane active" id="contenedorProductos">
		"""),_display_(Seq[Any](/*11.4*/views/*11.9*/.html.compras.certificaciones.contenidoTabProducto(formularioCarga, certificacionForm))),format.raw/*11.95*/("""	
	</div>
	 

</div>
"""))}
    }
    
    def render(formularioCarga:Boolean,certificacionForm:Form[Certificacion]): play.api.templates.HtmlFormat.Appendable = apply(formularioCarga,certificacionForm)
    
    def f:((Boolean,Form[Certificacion]) => play.api.templates.HtmlFormat.Appendable) = (formularioCarga,certificacionForm) => apply(formularioCarga,certificacionForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:42 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/certificaciones/tabsCertificacion.scala.html
                    HASH: 7f2c8696d826b177e7b103ca48f6453c3d911f65
                    MATRIX: 831->1|998->74|1376->417|1389->422|1497->508
                    LINES: 26->1|29->1|39->11|39->11|39->11
                    -- GENERATED --
                */
            