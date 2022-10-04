
package views.html.dashboard.controlDeuda

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
object autorizadoDistintoDePagado extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[List[models.informes.InformeDeudaProveedoresMaterializada],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(r:List[models.informes.InformeDeudaProveedoresMaterializada]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.64*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.dashboard.mainDashboard(title = "Listado Deuda Autorizado Distinto de Pagado")/*5.91*/ {_display_(Seq[Any](format.raw/*5.93*/("""
    
<div class="page-header">
	<div class="row">
		<div class="col-sm-9">
			<h1>Listado Deuda Autorizado Distinto de Pagado</h1>
		</div>
		<div class="col-sm-3">
		</div>
	</div>
</div>

<table class="table table-striped table-bordered" id="listaInforme">
	<thead>
		<tr>
			<th width="40">Orden</th>
			<th width="60">Expediente</th>
			<th width="30">Cuenta</th>
			<th width="130">Rubro</th>
			<th width="80">Inst.</th>
			<th>Proveedor</th>
			<th width="90">Orden</th>
			<th width="90">Autorizado</th>
			<th width="90">Pagado</th>
			<th width="90">Deuda</th>
			<th width="30">Compromiso</th>
		</tr>
	</thead>
	<tbody>
	
		"""),_display_(Seq[Any](/*35.4*/for(informe <- r) yield /*35.21*/ {_display_(Seq[Any](format.raw/*35.23*/("""
         
		<tr>
			<td>"""),_display_(Seq[Any](/*38.9*/informe/*38.16*/.numero_orden_provision)),format.raw/*38.39*/("""
			<br>"""),_display_(Seq[Any](/*39.9*/if(informe.tipo_moneda != null)/*39.40*/{_display_(Seq[Any](format.raw/*39.41*/("""<span style="color:green;font-weight:bold;font-size: 12px;">M.E.</span>""")))})),format.raw/*39.113*/("""
			</td>
			<td>"""),_display_(Seq[Any](/*41.9*/informe/*41.16*/.expediente)),format.raw/*41.27*/("""</td>
			<td>"""),_display_(Seq[Any](/*42.9*/if(informe.tipoCuenta != null)/*42.39*/ {_display_(Seq[Any](_display_(Seq[Any](/*42.42*/informe/*42.49*/.tipoCuenta.nombre))))})),format.raw/*42.68*/("""</td>
			<td>"""),_display_(Seq[Any](/*43.9*/informe/*43.16*/.rubro)),format.raw/*43.22*/("""</td>
			<td>"""),_display_(Seq[Any](/*44.9*/informe/*44.16*/.deposito.nombre)),format.raw/*44.32*/("""</td>
			<td>"""),_display_(Seq[Any](/*45.9*/informe/*45.16*/.nombreProveedor)),format.raw/*45.32*/("""</td>
			<td class="totalOrden" data-valor=""""),_display_(Seq[Any](/*46.40*/informe/*46.47*/.totalOrden)),format.raw/*46.58*/("""">"""),_display_(Seq[Any](/*46.61*/utils/*46.66*/.NumberUtils.moneda(informe.totalOrden))),format.raw/*46.105*/("""</td>
			<td class="totalAutorizado" data-valor=""""),_display_(Seq[Any](/*47.45*/informe/*47.52*/.totalAutorizado)),format.raw/*47.68*/("""">"""),_display_(Seq[Any](/*47.71*/utils/*47.76*/.NumberUtils.moneda(informe.totalAutorizado))),format.raw/*47.120*/("""</td>
			<td class="totalPagado" data-valor=""""),_display_(Seq[Any](/*48.41*/informe/*48.48*/.totalPagado)),format.raw/*48.60*/("""">"""),_display_(Seq[Any](/*48.63*/utils/*48.68*/.NumberUtils.moneda(informe.totalPagado))),format.raw/*48.108*/("""</td>
			<td class="totalDeuda" data-valor=""""),_display_(Seq[Any](/*49.40*/informe/*49.47*/.totalDeuda)),format.raw/*49.58*/("""">

					"""),_display_(Seq[Any](/*51.7*/utils/*51.12*/.NumberUtils.moneda(informe.totalDeuda))),format.raw/*51.51*/("""

			</td>
			<td class="totalCompromiso" data-valor=""""),_display_(Seq[Any](/*54.45*/informe/*54.52*/.totalCompromiso)),format.raw/*54.68*/("""">
			

					"""),_display_(Seq[Any](/*57.7*/utils/*57.12*/.NumberUtils.moneda(informe.totalCompromiso))),format.raw/*57.56*/("""

				
			</td>		
		</tr>
        """)))})),format.raw/*62.10*/("""
	</tbody>
	</table>
 """)))})))}
    }
    
    def render(r:List[models.informes.InformeDeudaProveedoresMaterializada]): play.api.templates.HtmlFormat.Appendable = apply(r)
    
    def f:((List[models.informes.InformeDeudaProveedoresMaterializada]) => play.api.templates.HtmlFormat.Appendable) = (r) => apply(r)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:46 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/controlDeuda/autorizadoDistintoDePagado.scala.html
                    HASH: 995ffad104b7d27027a2cc6ad17753dd35194a84
                    MATRIX: 870->1|1034->82|1066->106|1140->63|1168->150|1206->154|1218->159|1310->243|1349->245|2022->883|2055->900|2095->902|2156->928|2172->935|2217->958|2261->967|2301->998|2340->999|2445->1071|2498->1089|2514->1096|2547->1107|2596->1121|2635->1151|2684->1154|2700->1161|2745->1180|2794->1194|2810->1201|2838->1207|2887->1221|2903->1228|2941->1244|2990->1258|3006->1265|3044->1281|3125->1326|3141->1333|3174->1344|3213->1347|3227->1352|3289->1391|3375->1441|3391->1448|3429->1464|3468->1467|3482->1472|3549->1516|3631->1562|3647->1569|3681->1581|3720->1584|3734->1589|3797->1629|3878->1674|3894->1681|3927->1692|3972->1702|3986->1707|4047->1746|4138->1801|4154->1808|4192->1824|4241->1838|4255->1843|4321->1887|4388->1922
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|63->35|63->35|63->35|66->38|66->38|66->38|67->39|67->39|67->39|67->39|69->41|69->41|69->41|70->42|70->42|70->42|70->42|70->42|71->43|71->43|71->43|72->44|72->44|72->44|73->45|73->45|73->45|74->46|74->46|74->46|74->46|74->46|74->46|75->47|75->47|75->47|75->47|75->47|75->47|76->48|76->48|76->48|76->48|76->48|76->48|77->49|77->49|77->49|79->51|79->51|79->51|82->54|82->54|82->54|85->57|85->57|85->57|90->62
                    -- GENERATED --
                */
            