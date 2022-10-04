
package views.html.patrimonio.certificaciones

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
object indexCertificacionAjax extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[CertificacionServicio],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[CertificacionServicio], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};def /*7.2*/getClassEstado/*7.16*/(i:CertificacionServicio) = {{
	var classEstado:String = new String()
	 
	if(i.estado != null && i.estado.id == 43){
		classEstado = "borrador"
	}else if(i.estado != null && i.estado.id == 44){
		classEstado = "cancelada"
	}else if(i.estado != null && i.estado.id == 42){
		classEstado = "autorizado"
	}
	 
	classEstado
}};
Seq[Any](format.raw/*1.91*/("""
"""),format.raw/*5.70*/(""" 

"""),format.raw/*19.2*/("""


	"""),_display_(Seq[Any](/*22.3*/if(buscador.getTotalRowCount == 0)/*22.37*/ {_display_(Seq[Any](format.raw/*22.39*/("""
        
       <div class="well">
           <em>No se encuentran certificaciones</em>
       </div>
        
    """)))}/*28.7*/else/*28.12*/{_display_(Seq[Any](format.raw/*28.13*/("""
		
		Mostrando """),_display_(Seq[Any](/*30.14*/buscador/*30.22*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*30.54*/(""" resultado(s).   
		<table id="listaCertificaciones" class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th width="30"></th>
					<th width="60">Número</th>
					<th width="100">Ord. provisión</th>
					<th width="80">Acta</th>
					<th width="70">Periodo</th>
					<th>Proveedor</th>
					<th width="110">Base</th>
					<th width="110">Descuento</th>
					<th width="110">Total</th>
					<th width="80">Fecha</th>
					<th width="80">Estado</th>
				</tr>
			</thead>
			<tbody>
		        """),_display_(Seq[Any](/*48.12*/for(certificacion <- buscador.getList) yield /*48.50*/ {_display_(Seq[Any](format.raw/*48.52*/("""
				<tr class="pointer """),_display_(Seq[Any](/*49.25*/getClassEstado(certificacion))),format.raw/*49.54*/("""" data-href=""""),_display_(Seq[Any](/*49.68*/controllers/*49.79*/.patrimonio.routes.CertificacionesServiciosController.ver(certificacion.id))),format.raw/*49.154*/("""">
					
					<td class="notSeleccion" align="center">
						<a class="btn btn-default btn-xs notSeleccion" href=""""),_display_(Seq[Any](/*52.61*/controllers/*52.72*/.patrimonio.routes.CertificacionesServiciosController.editar(certificacion.id))),format.raw/*52.150*/("""&"""),_display_(Seq[Any](/*52.152*/UriTrack/*52.160*/.encode())),format.raw/*52.169*/("""">
							<i class="glyphicon glyphicon-edit"></i>
						</a>
					</td>
					<td>"""),_display_(Seq[Any](/*56.11*/certificacion/*56.24*/.id)),format.raw/*56.27*/("""</td>
					<td>"""),_display_(Seq[Any](/*57.11*/certificacion/*57.24*/.ordenProvision.numero)),format.raw/*57.46*/("""</td>
					<td>"""),_display_(Seq[Any](/*58.11*/if(certificacion.acta != null)/*58.41*/ {_display_(Seq[Any](_display_(Seq[Any](/*58.44*/certificacion/*58.57*/.acta.numero))))})),format.raw/*58.70*/("""</td>
					<td>"""),_display_(Seq[Any](/*59.11*/if(certificacion.periodo != null)/*59.44*/ {_display_(Seq[Any](_display_(Seq[Any](/*59.47*/certificacion/*59.60*/.periodo.nombre))))})),format.raw/*59.76*/("""</td>
					<td>"""),_display_(Seq[Any](/*60.11*/certificacion/*60.24*/.ordenProvision.ordenCompra.proveedor.nombre)),format.raw/*60.68*/("""</td>
					<td>"""),_display_(Seq[Any](/*61.11*/(utils.NumberUtils.moneda(certificacion.getBase())))),format.raw/*61.62*/("""</td>
					<td>"""),_display_(Seq[Any](/*62.11*/(utils.NumberUtils.moneda(certificacion.getDescuento())))),format.raw/*62.67*/("""</td>
					<td>"""),_display_(Seq[Any](/*63.11*/(utils.NumberUtils.moneda(certificacion.getTotal())))),format.raw/*63.63*/("""</td>
					<td>"""),_display_(Seq[Any](/*64.11*/if(certificacion.fecha_certificacion != null)/*64.56*/ {_display_(Seq[Any](format.raw/*64.58*/(""" """),_display_(Seq[Any](/*64.60*/DateUtils/*64.69*/.formatDate(certificacion.fecha_certificacion)))))})),format.raw/*64.116*/("""</td>
					<td>"""),_display_(Seq[Any](/*65.11*/certificacion/*65.24*/.estado.nombre)),format.raw/*65.38*/("""</td>
				</tr>
              	""")))})),format.raw/*67.17*/("""
			</tbody>
		</table>
		
		<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*72.8*/views/*72.13*/.html.helpers.paginador(buscador, controllers.patrimonio.routes.CertificacionesServiciosController.index()))),format.raw/*72.120*/("""
		</div>
        
    """)))})),format.raw/*75.6*/("""
"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[CertificacionServicio],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[CertificacionServicio],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/certificaciones/indexCertificacionAjax.scala.html
                    HASH: 5b185c8b7f7aa65700e606c1c980bcaaf1a97c2e
                    MATRIX: 874->1|1106->151|1138->175|1195->225|1217->239|1580->90|1609->219|1641->572|1684->580|1727->614|1767->616|1908->740|1921->745|1960->746|2015->765|2032->773|2086->805|2661->1344|2715->1382|2755->1384|2817->1410|2868->1439|2918->1453|2938->1464|3036->1539|3190->1657|3210->1668|3311->1746|3350->1748|3368->1756|3400->1765|3523->1852|3545->1865|3570->1868|3623->1885|3645->1898|3689->1920|3742->1937|3781->1967|3830->1970|3852->1983|3891->1996|3944->2013|3986->2046|4035->2049|4057->2062|4099->2078|4152->2095|4174->2108|4240->2152|4293->2169|4366->2220|4419->2237|4497->2293|4550->2310|4624->2362|4677->2379|4731->2424|4771->2426|4809->2428|4827->2437|4901->2484|4954->2501|4976->2514|5012->2528|5078->2562|5190->2639|5204->2644|5334->2751|5392->2778
                    LINES: 26->1|33->5|33->5|33->7|33->7|46->1|47->5|49->19|52->22|52->22|52->22|58->28|58->28|58->28|60->30|60->30|60->30|78->48|78->48|78->48|79->49|79->49|79->49|79->49|79->49|82->52|82->52|82->52|82->52|82->52|82->52|86->56|86->56|86->56|87->57|87->57|87->57|88->58|88->58|88->58|88->58|88->58|89->59|89->59|89->59|89->59|89->59|90->60|90->60|90->60|91->61|91->61|92->62|92->62|93->63|93->63|94->64|94->64|94->64|94->64|94->64|94->64|95->65|95->65|95->65|97->67|102->72|102->72|102->72|105->75
                    -- GENERATED --
                */
            