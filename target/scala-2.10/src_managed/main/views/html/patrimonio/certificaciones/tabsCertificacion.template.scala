
package views.html.patrimonio.certificaciones

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
object tabsCertificacion extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Boolean,Form[CertificacionServicio],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formularioCarga: Boolean, certificacionForm: Form[CertificacionServicio] = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.83*/("""

<ul id="certificacionTab" class="nav nav-tabs">
	<li class="active"><a class="tabProducto" href="#contenedorProductos" data-toggle="tab">Servicios</a></li>
	<li><a class="tabPaciente" href="#contenedorPacientes" data-toggle="tab">Pacientes</a></li>
	
</ul>

<div class="tab-content">

	<div class="tab-pane active" id="contenedorProductos">
		"""),_display_(Seq[Any](/*12.4*/views/*12.9*/.html.patrimonio.certificaciones.contenidoTabProducto(formularioCarga, certificacionForm))),format.raw/*12.98*/("""	
	</div>
	<div class="tab-pane" id="contenedorPacientes">
		"""),_display_(Seq[Any](/*15.4*/views/*15.9*/.html.patrimonio.certificaciones.contenidoTabPaciente(certificacionForm))),format.raw/*15.81*/("""	
	</div>
	 

</div>
"""))}
    }
    
    def render(formularioCarga:Boolean,certificacionForm:Form[CertificacionServicio]): play.api.templates.HtmlFormat.Appendable = apply(formularioCarga,certificacionForm)
    
    def f:((Boolean,Form[CertificacionServicio]) => play.api.templates.HtmlFormat.Appendable) = (formularioCarga,certificacionForm) => apply(formularioCarga,certificacionForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/certificaciones/tabsCertificacion.scala.html
                    HASH: b557134c4964b9325763a406a4428959cadc2164
                    MATRIX: 842->1|1017->82|1409->439|1422->444|1533->533|1633->598|1646->603|1740->675
                    LINES: 26->1|29->1|40->12|40->12|40->12|43->15|43->15|43->15
                    -- GENERATED --
                */
            