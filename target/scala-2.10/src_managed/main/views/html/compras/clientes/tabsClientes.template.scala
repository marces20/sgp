
package views.html.compras.clientes

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
object tabsClientes extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[Cliente],Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(clienteForm: Form[Cliente],vista:Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.44*/("""
"""),format.raw/*3.1*/("""	<ul class="nav nav-tabs">
	  <li class="active"><a href="#contenedorContactos" data-toggle="tab">Contactos del cliente</a></li>
	</ul>
	
	<div class="tab-content">
		<div class="tab-pane active" id="contenedorContactos">
			"""),_display_(Seq[Any](/*9.5*/if( clienteForm("id").value == null )/*9.42*/{_display_(Seq[Any](format.raw/*9.43*/("""
				<p>Para agregar el contacto primero debe dar de alta el cliente.<p>
			""")))})),format.raw/*11.5*/(""" 
			"""),_display_(Seq[Any](/*12.5*/if(clienteForm("id").value != null)/*12.40*/{_display_(Seq[Any](format.raw/*12.41*/("""
				"""),_display_(Seq[Any](/*13.6*/views/*13.11*/.html.compras.clientes.contacto_cliente(clienteForm, false))),format.raw/*13.70*/(""" 
			""")))})),format.raw/*14.5*/("""
		</div>		
	</div>"""))}
    }
    
    def render(clienteForm:Form[Cliente],vista:Boolean): play.api.templates.HtmlFormat.Appendable = apply(clienteForm,vista)
    
    def f:((Form[Cliente],Boolean) => play.api.templates.HtmlFormat.Appendable) = (clienteForm,vista) => apply(clienteForm,vista)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:41 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/clientes/tabsClientes.scala.html
                    HASH: ecddd6771f160a94f45fbbd443880313a6f9bbac
                    MATRIX: 813->1|966->43|994->63|1260->295|1305->332|1343->333|1453->412|1495->419|1539->454|1578->455|1620->462|1634->467|1715->526|1753->533
                    LINES: 26->1|30->1|31->3|37->9|37->9|37->9|39->11|40->12|40->12|40->12|41->13|41->13|41->13|42->14
                    -- GENERATED --
                */
            