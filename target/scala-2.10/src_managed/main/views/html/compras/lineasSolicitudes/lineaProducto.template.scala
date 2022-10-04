
package views.html.compras.lineasSolicitudes

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
object lineaProducto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[SolicitudLinea,Boolean,Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea: SolicitudLinea, editable: Boolean,btnEliminar:Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._


Seq[Any](format.raw/*1.64*/("""
"""),format.raw/*5.1*/("""<tr data-id=""""),_display_(Seq[Any](/*5.15*/linea/*5.20*/.id)),format.raw/*5.23*/("""">
	"""),_display_(Seq[Any](/*6.3*/if(editable)/*6.15*/{_display_(Seq[Any](format.raw/*6.16*/("""
		<td><input type="checkbox" name="check_listado[]" value=""""),_display_(Seq[Any](/*7.61*/linea/*7.66*/.id)),format.raw/*7.69*/("""" class="check_listado notSeleccion" id="check-"""),_display_(Seq[Any](/*7.117*/linea/*7.122*/.id)),format.raw/*7.125*/(""""/></td>
		<td class="accion-editar"><a class="btn btn-default btn-xs modificarProducto" href=""""),_display_(Seq[Any](/*8.88*/controllers/*8.99*/.compras.routes.LineasSolicitudesController.editar(linea.id,0))),format.raw/*8.161*/(""""><i class="glyphicon glyphicon-edit"></i></a></td>
	""")))})),format.raw/*9.3*/("""
	<td>"""),_display_(Seq[Any](/*10.7*/linea/*10.12*/.producto.nombre)),format.raw/*10.28*/("""</td>
	<td>"""),_display_(Seq[Any](/*11.7*/if(linea.cantidad != null)/*11.33*/{_display_(Seq[Any](_display_(Seq[Any](/*11.35*/linea/*11.40*/.cantidad))))}/*11.50*/else/*11.54*/{_display_(Seq[Any](format.raw/*11.55*/("""0""")))})),format.raw/*11.57*/("""</td>
	<td>
	"""),_display_(Seq[Any](/*13.3*/if(!Permiso.check("noVerPrecios"))/*13.37*/ {_display_(Seq[Any](format.raw/*13.39*/("""
		"""),_display_(Seq[Any](/*14.4*/utils/*14.9*/.NumberUtils.moneda(linea.precio_estimado, 2))),format.raw/*14.54*/("""
	""")))})),format.raw/*15.3*/("""
	</td>
	<td class="cuentaAnaliticaEnLinea">"""),_display_(Seq[Any](/*17.38*/if(linea.cuentaAnalitica == null)/*17.71*/{_display_(Seq[Any](format.raw/*17.72*/("""No asociada""")))}/*17.85*/else/*17.90*/{_display_(Seq[Any](_display_(Seq[Any](/*17.92*/linea/*17.97*/.cuentaAnalitica.codigo)),format.raw/*17.120*/(""" """),_display_(Seq[Any](/*17.122*/linea/*17.127*/.cuentaAnalitica.nombre))))})),format.raw/*17.151*/("""</td>
	<td>"""),_display_(Seq[Any](/*18.7*/linea/*18.12*/.udm.nombre)),format.raw/*18.23*/("""</td>
	<td>
	"""),_display_(Seq[Any](/*20.3*/if(!Permiso.check("noVerPrecios"))/*20.37*/ {_display_(Seq[Any](format.raw/*20.39*/("""
		"""),_display_(Seq[Any](/*21.4*/if(linea.precio_estimado != null)/*21.37*/{_display_(Seq[Any](_display_(Seq[Any](/*21.39*/(utils.NumberUtils.moneda(linea.cantidad.multiply(linea.precio_estimado), 2))))))}/*21.117*/else/*21.121*/{_display_(Seq[Any](_display_(Seq[Any](/*21.123*/(utils.NumberUtils.moneda(new java.math.BigDecimal(0),2))))))})),format.raw/*21.181*/("""
	""")))})),format.raw/*22.3*/("""
	</td>
	
	"""),_display_(Seq[Any](/*25.3*/if(editable && btnEliminar)/*25.30*/{_display_(Seq[Any](format.raw/*25.31*/("""
		<td>
			<a class="btn btn-default btn-xs eliminarProducto delete-confirm-link" href=""""),_display_(Seq[Any](/*27.82*/controllers/*27.93*/.compras.routes.LineasSolicitudesController.eliminar(linea.id))),format.raw/*27.155*/(""""><i class="glyphicon glyphicon-trash icono-eliminar"></i></a></td>
	""")))})),format.raw/*28.3*/("""
</tr>
"""))}
    }
    
    def render(linea:SolicitudLinea,editable:Boolean,btnEliminar:Boolean): play.api.templates.HtmlFormat.Appendable = apply(linea,editable,btnEliminar)
    
    def f:((SolicitudLinea,Boolean,Boolean) => play.api.templates.HtmlFormat.Appendable) = (linea,editable,btnEliminar) => apply(linea,editable,btnEliminar)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:43 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/lineasSolicitudes/lineaProducto.scala.html
                    HASH: 60e5eb3241bc6f3590981d51c19208cdcf2c6a6b
                    MATRIX: 832->1|1045->63|1073->123|1122->137|1135->142|1159->145|1199->151|1219->163|1257->164|1354->226|1367->231|1391->234|1475->282|1489->287|1514->290|1646->387|1665->398|1749->460|1834->515|1877->523|1891->528|1929->544|1977->557|2012->583|2060->585|2074->590|2097->600|2110->604|2149->605|2183->607|2234->623|2277->657|2317->659|2357->664|2370->669|2437->714|2472->718|2555->765|2597->798|2636->799|2667->812|2680->817|2728->819|2742->824|2788->847|2827->849|2842->854|2893->878|2941->891|2955->896|2988->907|3039->923|3082->957|3122->959|3162->964|3204->997|3252->999|3344->1077|3358->1081|3407->1083|3492->1141|3527->1145|3577->1160|3613->1187|3652->1188|3779->1279|3799->1290|3884->1352|3986->1423
                    LINES: 26->1|34->1|35->5|35->5|35->5|35->5|36->6|36->6|36->6|37->7|37->7|37->7|37->7|37->7|37->7|38->8|38->8|38->8|39->9|40->10|40->10|40->10|41->11|41->11|41->11|41->11|41->11|41->11|41->11|41->11|43->13|43->13|43->13|44->14|44->14|44->14|45->15|47->17|47->17|47->17|47->17|47->17|47->17|47->17|47->17|47->17|47->17|47->17|48->18|48->18|48->18|50->20|50->20|50->20|51->21|51->21|51->21|51->21|51->21|51->21|51->21|52->22|55->25|55->25|55->25|57->27|57->27|57->27|58->28
                    -- GENERATED --
                */
            