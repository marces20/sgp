
package views.html.compras.proveedores

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
object tabsAtributos extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[Proveedor],Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(provForm: Form[Proveedor] = null,formularioCarga: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import java.util.List


Seq[Any](format.raw/*1.61*/("""
"""),format.raw/*3.1*/("""	
	<ul class="nav nav-tabs">
	  <li class="active"><a href="#contenedorAtributos" data-toggle="tab">Atributos</a></li>
	   <li><a href="#contenedorDatosDgr" data-toggle="tab">Datos DGR 44/2018</a></li>
	</ul>
	<div class="tab-content">
		<div class="tab-pane active" id="contenedorAtributos">
			<div class="row">
				<div class="col-sm-12">
					"""),_display_(Seq[Any](/*12.7*/views/*12.12*/.html.compras.proveedores.contenidoTabAtributos(formularioCarga, provForm))),format.raw/*12.86*/("""
				</div>
			</div>	
		</div>
		
		<div class="tab-pane" id="contenedorDatosDgr">
			<div class="row">
				<div class="col-sm-12">
					"""),_display_(Seq[Any](/*20.7*/views/*20.12*/.html.compras.proveedores.contenidoTabDatosDgr(formularioCarga, provForm))),format.raw/*20.85*/("""
				</div>
			</div>	
		</div>
	</div>
"""))}
    }
    
    def render(provForm:Form[Proveedor],formularioCarga:Boolean): play.api.templates.HtmlFormat.Appendable = apply(provForm,formularioCarga)
    
    def f:((Form[Proveedor],Boolean) => play.api.templates.HtmlFormat.Appendable) = (provForm,formularioCarga) => apply(provForm,formularioCarga)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:46 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/proveedores/tabsAtributos.scala.html
                    HASH: 2ba3f164c9d6523b0a96e6d58198c3ab9480ade8
                    MATRIX: 819->1|994->60|1021->84|1404->432|1418->437|1514->511|1688->650|1702->655|1797->728
                    LINES: 26->1|30->1|31->3|40->12|40->12|40->12|48->20|48->20|48->20
                    -- GENERATED --
                */
            