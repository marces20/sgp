
package views.html.expediente.dispo

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
object listaDispos extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[Dispo],Long,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(paginador:  utils.pagination.Pagination[Dispo],expedienteId:Long):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.68*/("""
"""),format.raw/*5.70*/(""" 
<div id="listaDispos" class="contenedorPaginador ajaxPaginador">

	<p>
		<b>Disposiciones</b>
	</p>
	
	"""),_display_(Seq[Any](/*12.3*/if(paginador.getTotalRowCount() > 0)/*12.39*/ {_display_(Seq[Any](format.raw/*12.41*/("""
		Mostrando """),_display_(Seq[Any](/*13.14*/paginador/*13.23*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*13.55*/(""" resultado(s).
	""")))})),format.raw/*14.3*/("""
	
	<table id="listaDeDispos" class="table table-striped table-bordered">
		<thead>
			<tr>
	
				<th width="30">#</th>
				<th width="30">Número</th>
				<th width="30">Expediente</th>
				<th width="30">Fecha</th>
				<th>Descripcion</th>
				<th width="30">#</th>
			<tr>	
		</thead>
		<tbody>
		"""),_display_(Seq[Any](/*29.4*/for(dispo <- paginador.getList) yield /*29.35*/ {_display_(Seq[Any](format.raw/*29.37*/("""
			 <tr>
					
				<td class="notSeleccion">
					 
				</td>
				<td align="center"><b>"""),_display_(Seq[Any](/*35.28*/dispo/*35.33*/.numero)),format.raw/*35.40*/("""</b></td>
				<td>"""),_display_(Seq[Any](/*36.10*/dispo/*36.15*/.expediente.getExpedienteEjercicio())),format.raw/*36.51*/("""</td>
				<td>"""),_display_(Seq[Any](/*37.10*/DateUtils/*37.19*/.formatDate(dispo.fecha))),format.raw/*37.43*/("""</td>
				<td>"""),_display_(Seq[Any](/*38.10*/dispo/*38.15*/.descripcion)),format.raw/*38.27*/("""</td>
				<td>
					 
					 
				</td>
			</tr>
		""")))})),format.raw/*44.4*/("""
		</tbody>
	</table>
	
	
	<div class="pagination pull-right">
	    """),_display_(Seq[Any](/*50.7*/views/*50.12*/.html.helpers.paginador(paginador, controllers.expediente.routes.DisposController.getDisposPorExpediente()))),format.raw/*50.119*/("""
	</div>
</div>

<script>
$( function()"""),format.raw/*55.14*/("""{"""),format.raw/*55.15*/("""
	
	 


		 
	
		
"""),format.raw/*63.1*/("""}"""),format.raw/*63.2*/(""");	
</script>"""))}
    }
    
    def render(paginador:utils.pagination.Pagination[Dispo],expedienteId:Long): play.api.templates.HtmlFormat.Appendable = apply(paginador,expedienteId)
    
    def f:((utils.pagination.Pagination[Dispo],Long) => play.api.templates.HtmlFormat.Appendable) = (paginador,expedienteId) => apply(paginador,expedienteId)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:36 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/expediente/dispo/listaDispos.scala.html
                    HASH: ade96354064e94d8d4987ebe7b41cd7329241afc
                    MATRIX: 830->1|1036->124|1068->148|1142->67|1170->192|1311->298|1356->334|1396->336|1446->350|1464->359|1518->391|1566->408|1901->708|1948->739|1988->741|2114->831|2128->836|2157->843|2212->862|2226->867|2284->903|2335->918|2353->927|2399->951|2450->966|2464->971|2498->983|2580->1034|2684->1103|2698->1108|2828->1215|2895->1254|2924->1255|2968->1272|2996->1273
                    LINES: 26->1|33->5|33->5|34->1|35->5|42->12|42->12|42->12|43->13|43->13|43->13|44->14|59->29|59->29|59->29|65->35|65->35|65->35|66->36|66->36|66->36|67->37|67->37|67->37|68->38|68->38|68->38|74->44|80->50|80->50|80->50|85->55|85->55|93->63|93->63
                    -- GENERATED --
                */
            