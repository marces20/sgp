
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
object tabsProveedores extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[Proveedor],Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(provForm: Form[Proveedor],vista:Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.43*/("""
"""),format.raw/*3.1*/("""	<ul class="nav nav-tabs">
	  <li class="active"><a href="#contenedorContactos" data-toggle="tab">Contactos del proveedor</a></li>
	  <li><a href="#contenedorObservaciones" data-toggle="tab">Observaciones</a></li>
	</ul>
	
	<div class="tab-content">
		<div class="tab-pane active" id="contenedorContactos">
			"""),_display_(Seq[Any](/*10.5*/if( provForm("id").value == null )/*10.39*/{_display_(Seq[Any](format.raw/*10.40*/("""
				<p>Para agregar el contacto primero debe dar de alta el proveedor.<p>
			""")))})),format.raw/*12.5*/(""" 
			"""),_display_(Seq[Any](/*13.5*/if(provForm("id").value != null)/*13.37*/{_display_(Seq[Any](format.raw/*13.38*/("""
				"""),_display_(Seq[Any](/*14.6*/views/*14.11*/.html.compras.proveedores.contacto_proveedor(provForm, false))),format.raw/*14.72*/(""" 
			""")))})),format.raw/*15.5*/("""
		</div>
		<div class="tab-pane" id="contenedorObservaciones">
			 """),_display_(Seq[Any](/*18.6*/textarea(provForm("observaciones"), 'rows -> 4, 'cols -> 50, '_label -> "observacionesLabel"))),format.raw/*18.99*/("""
		</div>
		
	</div>"""))}
    }
    
    def render(provForm:Form[Proveedor],vista:Boolean): play.api.templates.HtmlFormat.Appendable = apply(provForm,vista)
    
    def f:((Form[Proveedor],Boolean) => play.api.templates.HtmlFormat.Appendable) = (provForm,vista) => apply(provForm,vista)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:46 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/proveedores/tabsProveedores.scala.html
                    HASH: 0b180af2ea588f70a2dd47d8309de2a7b386f2bd
                    MATRIX: 821->1|973->42|1001->62|1354->380|1397->414|1436->415|1548->496|1590->503|1631->535|1670->536|1712->543|1726->548|1809->609|1847->616|1954->688|2069->781
                    LINES: 26->1|30->1|31->3|38->10|38->10|38->10|40->12|41->13|41->13|41->13|42->14|42->14|42->14|43->15|46->18|46->18
                    -- GENERATED --
                */
            