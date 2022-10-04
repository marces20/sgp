
package views.html.compras.certificacionesCompras

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
object tabsCertificacion extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Boolean,Form[CertificacionCompra],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formularioCarga: Boolean, certificacionForm: Form[CertificacionCompra] = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.81*/("""

<ul id="certificacionTab" class="nav nav-tabs">
	<li class="active"><a class="tabProducto" href="#contenedorProductos" data-toggle="tab">Productos</a></li>
	<li><a class="tabLineaAjuste" href="#contenedorLineasAjuste" data-toggle="tab">Ajustes</a></li>
	<li><a class="tabNotas" href="#contenedorNotas" data-toggle="tab">Notas</a></li>
</ul>

<div class="tab-content">

	<div class="tab-pane active" id="contenedorProductos">
		"""),_display_(Seq[Any](/*12.4*/views/*12.9*/.html.compras.certificacionesCompras.contenidoTabProducto(formularioCarga, certificacionForm))),format.raw/*12.102*/("""	
	</div>
	<div class="tab-pane" id="contenedorLineasAjuste">
		"""),_display_(Seq[Any](/*15.4*/views/*15.9*/.html.compras.certificacionesCompras.contenidoTabAjuste(formularioCarga, certificacionForm))),format.raw/*15.100*/("""	
	</div> 
	<div class="tab-pane" id="contenedorNotas">
		"""),_display_(Seq[Any](/*18.4*/if(formularioCarga)/*18.23*/{_display_(Seq[Any](format.raw/*18.24*/("""
			<textarea name="descripcion" class="form-control" rows="5">"""),_display_(Seq[Any](/*19.64*/certificacionForm/*19.81*/.field("descripcion").value)),format.raw/*19.108*/("""</textarea>
		""")))}/*20.5*/else/*20.10*/{_display_(Seq[Any](format.raw/*20.11*/("""
			<textarea name="descripcion" disabled="disabled" class="form-control" rows="5">"""),_display_(Seq[Any](/*21.84*/certificacionForm/*21.101*/.field("descripcion").value)),format.raw/*21.128*/("""</textarea>
		""")))})),format.raw/*22.4*/("""
	</div>
</div>
"""))}
    }
    
    def render(formularioCarga:Boolean,certificacionForm:Form[CertificacionCompra]): play.api.templates.HtmlFormat.Appendable = apply(formularioCarga,certificacionForm)
    
    def f:((Boolean,Form[CertificacionCompra]) => play.api.templates.HtmlFormat.Appendable) = (formularioCarga,certificacionForm) => apply(formularioCarga,certificacionForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:44 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/certificacionesCompras/tabsCertificacion.scala.html
                    HASH: 668ac70baf81e7d2f8906732ae0801efece21c0c
                    MATRIX: 844->1|1017->80|1493->521|1506->526|1622->619|1725->687|1738->692|1852->783|1949->845|1977->864|2016->865|2117->930|2143->947|2193->974|2227->991|2240->996|2279->997|2400->1082|2427->1099|2477->1126|2524->1142
                    LINES: 26->1|29->1|40->12|40->12|40->12|43->15|43->15|43->15|46->18|46->18|46->18|47->19|47->19|47->19|48->20|48->20|48->20|49->21|49->21|49->21|50->22
                    -- GENERATED --
                */
            