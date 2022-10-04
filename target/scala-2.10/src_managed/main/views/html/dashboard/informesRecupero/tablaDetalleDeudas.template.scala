
package views.html.dashboard.informesRecupero

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
object tablaDetalleDeudas extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(tipoCliente:String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.22*/("""
<thead>
	<th colspan="8" align="center" style="font-size:20px;text-align:center;">"""),_display_(Seq[Any](/*3.76*/tipoCliente)),format.raw/*3.87*/("""</th>
</thead>
<thead>
	<th>FINANCIADOR-PACIENTE</th>
	<th>IMPORTE</th>
	<th>DEBITOS</th>
	<th>A COBRAR</th>
</thead>
"""))}
    }
    
    def render(tipoCliente:String): play.api.templates.HtmlFormat.Appendable = apply(tipoCliente)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (tipoCliente) => apply(tipoCliente)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:44:00 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/informesRecupero/tablaDetalleDeudas.scala.html
                    HASH: 0d55f6d8c50233f8b54ec9ff0cacb8380ff75e3c
                    MATRIX: 814->1|928->21|1047->105|1079->116
                    LINES: 26->1|29->1|31->3|31->3
                    -- GENERATED --
                */
            