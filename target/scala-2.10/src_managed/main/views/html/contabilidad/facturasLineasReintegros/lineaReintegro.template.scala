
package views.html.contabilidad.facturasLineasReintegros

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
object lineaReintegro extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[FacturaLineaReintegro,Boolean,Factura,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea: FacturaLineaReintegro, editable: Boolean,factura:Factura):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import models.auth._


Seq[Any](format.raw/*1.67*/("""
"""),format.raw/*3.1*/("""
<tr data-id=""""),_display_(Seq[Any](/*4.15*/linea/*4.20*/.id)),format.raw/*4.23*/("""">
	"""),_display_(Seq[Any](/*5.3*/if(factura.estado.id ==  models.Estado.FACTURA_ESTADO_APROBADO && Permiso.check("facturasEditarReintegros"))/*5.111*/{_display_(Seq[Any](format.raw/*5.112*/("""
		<td class="accion-editar"><a class="btn btn-default btn-xs modificarReintegro" href=""""),_display_(Seq[Any](/*6.89*/controllers/*6.100*/.contabilidad.routes.FacturasLineasReintegrosController.editar(linea.id))),format.raw/*6.172*/(""""><i class="glyphicon glyphicon-edit"></i></a></td>
	""")))})),format.raw/*7.3*/("""
		<td>"""),_display_(Seq[Any](/*8.8*/linea/*8.13*/.cuenta.nombre)),format.raw/*8.27*/("""</td>
		<td>"""),_display_(Seq[Any](/*9.8*/linea/*9.13*/.cuentaAnalitica.codigo)),format.raw/*9.36*/(""" """),_display_(Seq[Any](/*9.38*/linea/*9.43*/.cuentaAnalitica.nombre)),format.raw/*9.66*/("""</td>
		<td>"""),_display_(Seq[Any](/*10.8*/if(linea.cuentaImpuesto != null)/*10.40*/{_display_(Seq[Any](_display_(Seq[Any](/*10.42*/linea/*10.47*/.cuentaImpuesto.nombre))))})),format.raw/*10.70*/("""</td>
		<td>"""),_display_(Seq[Any](/*11.8*/utils/*11.13*/.NumberUtils.moneda(linea.monto))),format.raw/*11.45*/("""</td>
		<td>"""),_display_(Seq[Any](/*12.8*/linea/*12.13*/.descripcion)),format.raw/*12.25*/("""</td>
	"""),_display_(Seq[Any](/*13.3*/if(factura.estado.id ==  models.Estado.FACTURA_ESTADO_APROBADO && Permiso.check("facturasEliminarReintegros"))/*13.113*/{_display_(Seq[Any](format.raw/*13.114*/("""
		<td><a class="btn btn-default btn-xs delete-confirm-link eliminarReintegro" href=""""),_display_(Seq[Any](/*14.86*/controllers/*14.97*/.contabilidad.routes.FacturasLineasReintegrosController.eliminar(linea.id))),format.raw/*14.171*/(""""><i class="glyphicon glyphicon-trash icono-eliminar"></i></a></td>
	""")))})),format.raw/*15.3*/("""
</tr>"""))}
    }
    
    def render(linea:FacturaLineaReintegro,editable:Boolean,factura:Factura): play.api.templates.HtmlFormat.Appendable = apply(linea,editable,factura)
    
    def f:((FacturaLineaReintegro,Boolean,Factura) => play.api.templates.HtmlFormat.Appendable) = (linea,editable,factura) => apply(linea,editable,factura)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:38 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/facturasLineasReintegros/lineaReintegro.scala.html
                    HASH: df4e4d8271a2f28912e548d01723390ccf7f290b
                    MATRIX: 852->1|1033->66|1061->91|1112->107|1125->112|1149->115|1189->121|1306->229|1345->230|1470->320|1490->331|1584->403|1669->458|1712->467|1725->472|1760->486|1808->500|1821->505|1865->528|1902->530|1915->535|1959->558|2008->572|2049->604|2097->606|2111->611|2160->634|2209->648|2223->653|2277->685|2326->699|2340->704|2374->716|2418->725|2538->835|2578->836|2701->923|2721->934|2818->1008|2920->1079
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|33->5|33->5|33->5|34->6|34->6|34->6|35->7|36->8|36->8|36->8|37->9|37->9|37->9|37->9|37->9|37->9|38->10|38->10|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|43->15
                    -- GENERATED --
                */
            