
package views.html.contabilidad.pagos.acciones

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
object modalDetallePago extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Pago,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(f:Pago):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.10*/("""

<div class="row">
	<div class="col-sm-6">
		<h4>Expediente: <b>"""),_display_(Seq[Any](/*5.23*/f/*5.24*/.expediente.getExpedienteEjercicio())),format.raw/*5.60*/("""</b></h4>
		<h4>Periodo: <b>"""),_display_(Seq[Any](/*6.20*/f/*6.21*/.periodo.nombre)),format.raw/*6.36*/("""</b></h4>
		<h4>Tipo Cuenta: <b>"""),_display_(Seq[Any](/*7.24*/if(f.tipoCuenta != null)/*7.48*/{_display_(Seq[Any](_display_(Seq[Any](/*7.50*/f/*7.51*/.tipoCuenta.nombre))))})),format.raw/*7.70*/("""</b></h4>
		<h4>Estado actual: 	<b>"""),_display_(Seq[Any](/*8.27*/(f.estado.nombre))),format.raw/*8.44*/("""</b>
		</h4>
	</div>
	<div class="col-sm-6">
		<h4>Fecha de Pago: 	   <b>"""),_display_(Seq[Any](/*12.30*/utils/*12.35*/.DateUtils.formatDate(f.fecha_pago))),format.raw/*12.70*/("""</b></h4>	
		<h4>Total: 	   <b>"""),_display_(Seq[Any](/*13.22*/utils/*13.27*/.NumberUtils.moneda(f.total))),format.raw/*13.55*/("""</b></h4>	
		
	</div>
</div>"""))}
    }
    
    def render(f:Pago): play.api.templates.HtmlFormat.Appendable = apply(f)
    
    def f:((Pago) => play.api.templates.HtmlFormat.Appendable) = (f) => apply(f)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:38 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/pagos/acciones/modalDetallePago.scala.html
                    HASH: 1fb72766788afa3339143bc8d0a96464b4a75490
                    MATRIX: 811->1|913->9|1014->75|1023->76|1080->112|1144->141|1153->142|1189->157|1257->190|1289->214|1336->216|1345->217|1389->236|1460->272|1498->289|1608->363|1622->368|1679->403|1747->435|1761->440|1811->468
                    LINES: 26->1|29->1|33->5|33->5|33->5|34->6|34->6|34->6|35->7|35->7|35->7|35->7|35->7|36->8|36->8|40->12|40->12|40->12|41->13|41->13|41->13
                    -- GENERATED --
                */
            