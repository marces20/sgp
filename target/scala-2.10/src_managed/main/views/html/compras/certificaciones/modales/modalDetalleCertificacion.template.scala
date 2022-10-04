
package views.html.compras.certificaciones.modales

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
object modalDetalleCertificacion extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Certificacion,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(c:Certificacion):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.19*/("""

<div class="row">
	<div class="col-sm-6">
		<h4>Expediente: <b>"""),_display_(Seq[Any](/*5.23*/c/*5.24*/.expediente.getExpedienteEjercicio())),format.raw/*5.60*/("""</b></h4>
		<h4>Periodo: <b>"""),_display_(Seq[Any](/*6.20*/c/*6.21*/.periodo.nombre)),format.raw/*6.36*/("""</b></h4>
		<h4>Fecha certificacion: <b>"""),_display_(Seq[Any](/*7.32*/utils/*7.37*/.DateUtils.formatDate(c.fecha_certificacion))),format.raw/*7.81*/("""</b></h4>
		<h4>Tipo Cuenta: <b>"""),_display_(Seq[Any](/*8.24*/c/*8.25*/.tipoCuenta.nombre)),format.raw/*8.43*/("""</b></h4>
	</div>
	<div class="col-sm-6">
		<h4>Base: 	   <b>"""),_display_(Seq[Any](/*11.21*/utils/*11.26*/.NumberUtils.moneda(c.getBase()))),format.raw/*11.58*/("""</b></h4>	
		<h4>Descuento: <b>"""),_display_(Seq[Any](/*12.22*/utils/*12.27*/.NumberUtils.moneda(c.getDescuento()))),format.raw/*12.64*/("""</b></h4>	
		<h4>Total: 	   <b>"""),_display_(Seq[Any](/*13.22*/utils/*13.27*/.NumberUtils.moneda(c.getTotal()))),format.raw/*13.60*/("""</b></h4>	
		<h4>Estado actual: 	<b>"""),_display_(Seq[Any](/*14.27*/c/*14.28*/.estado.nombre)),format.raw/*14.42*/("""</b></h4>
	</div>
</div>
<div class="row">
	<div class="col-sm-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<b>Lineas</b>
			</div>
			<div class="panel-body">
				<table class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>Producto</th>
							<th>Cantidad</th>
							<th>UDM</th>
							<th>Precio</th>
							<th>Descuento (%)</th>
							<th>Subtotal desc.</th>
							<th>Subtotal</th>
						</tr>
					</thead>
					"""),_display_(Seq[Any](/*36.7*/for(linea <- c.certificacionLinea) yield /*36.41*/ {_display_(Seq[Any](format.raw/*36.43*/("""
						<tr>
							<td>"""),_display_(Seq[Any](/*38.13*/linea/*38.18*/.producto.nombre)),format.raw/*38.34*/("""</td>
							<td>"""),_display_(Seq[Any](/*39.13*/linea/*39.18*/.cantidad)),format.raw/*39.27*/("""</td>
							<td>"""),_display_(Seq[Any](/*40.13*/linea/*40.18*/.udm.nombre)),format.raw/*40.29*/("""</td>
							<td>"""),_display_(Seq[Any](/*41.13*/utils/*41.18*/.NumberUtils.moneda(linea.precio, 10))),format.raw/*41.55*/("""</td>
							<td>"""),_display_(Seq[Any](/*42.13*/linea/*42.18*/.descuento)),format.raw/*42.28*/("""</td>
							<td>"""),_display_(Seq[Any](/*43.13*/utils/*43.18*/.NumberUtils.moneda(linea.getTotalDescuento(),10))),format.raw/*43.67*/("""</td>
							<td>"""),_display_(Seq[Any](/*44.13*/utils/*44.18*/.NumberUtils.moneda(linea.getTotal(), 10))),format.raw/*44.59*/("""</td>
						</tr>
					""")))})),format.raw/*46.7*/("""
				</table>
			</div>
		</div>	
	</div>
</div>

	"""))}
    }
    
    def render(c:Certificacion): play.api.templates.HtmlFormat.Appendable = apply(c)
    
    def f:((Certificacion) => play.api.templates.HtmlFormat.Appendable) = (c) => apply(c)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:43 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/certificaciones/modales/modalDetalleCertificacion.scala.html
                    HASH: 4c67eb398ba57bb42167d3f6dfb7f9df20f98138
                    MATRIX: 833->1|944->18|1045->84|1054->85|1111->121|1175->150|1184->151|1220->166|1296->207|1309->212|1374->256|1442->289|1451->290|1490->308|1588->370|1602->375|1656->407|1724->439|1738->444|1797->481|1865->513|1879->518|1934->551|2007->588|2017->589|2053->603|2569->1084|2619->1118|2659->1120|2719->1144|2733->1149|2771->1165|2825->1183|2839->1188|2870->1197|2924->1215|2938->1220|2971->1231|3025->1249|3039->1254|3098->1291|3152->1309|3166->1314|3198->1324|3252->1342|3266->1347|3337->1396|3391->1414|3405->1419|3468->1460|3523->1484
                    LINES: 26->1|29->1|33->5|33->5|33->5|34->6|34->6|34->6|35->7|35->7|35->7|36->8|36->8|36->8|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|64->36|64->36|64->36|66->38|66->38|66->38|67->39|67->39|67->39|68->40|68->40|68->40|69->41|69->41|69->41|70->42|70->42|70->42|71->43|71->43|71->43|72->44|72->44|72->44|74->46
                    -- GENERATED --
                */
            