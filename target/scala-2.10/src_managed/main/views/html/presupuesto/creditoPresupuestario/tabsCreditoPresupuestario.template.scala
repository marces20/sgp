
package views.html.presupuesto.creditoPresupuestario

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
object tabsCreditoPresupuestario extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Boolean,CreditoPresupuestario,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formularioCarga: Boolean, creditoPresupuestario: CreditoPresupuestario = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.81*/("""

<ul id="solicitudTab" class="nav nav-tabs">
	<li class="active"><a class="tabCredito" href="#contenedorCreditoOriginal" data-toggle="tab">Crédito original</a></li>
	<li><a class="tabRecurso" href="#contenedorRecursos" data-toggle="tab">Célculo de recursos</a></li>
</ul>

<div class="tab-content">

	<div class="tab-pane active" id="contenedorCreditoOriginal">
		<h3>Credito Original</h3>
		"""),_display_(Seq[Any](/*12.4*/views/*12.9*/.html.presupuesto.creditoPresupuestario.contenidoTabCredito(formularioCarga, creditoPresupuestario))),format.raw/*12.108*/("""	
	</div>
	
	<div class="tab-pane" id="contenedorRecursos">
		<h3>Calculo de Recursos</h3>
		"""),_display_(Seq[Any](/*17.4*/views/*17.9*/.html.presupuesto.creditoPresupuestario.contenidoTabRecurso(formularioCarga, creditoPresupuestario))),format.raw/*17.108*/("""	
		
	</div>
	

	
</div>
"""))}
    }
    
    def render(formularioCarga:Boolean,creditoPresupuestario:CreditoPresupuestario): play.api.templates.HtmlFormat.Appendable = apply(formularioCarga,creditoPresupuestario)
    
    def f:((Boolean,CreditoPresupuestario) => play.api.templates.HtmlFormat.Appendable) = (formularioCarga,creditoPresupuestario) => apply(formularioCarga,creditoPresupuestario)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:36 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/presupuesto/creditoPresupuestario/tabsCreditoPresupuestario.scala.html
                    HASH: 3bae6fb69329de6128a5007d29936e2bda372bec
                    MATRIX: 851->1|1024->80|1464->485|1477->490|1599->589|1733->688|1746->693|1868->792
                    LINES: 26->1|29->1|40->12|40->12|40->12|45->17|45->17|45->17
                    -- GENERATED --
                */
            