
package views.html.patrimonio.ordenesProvision

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
object listadoRecepciones extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Long,utils.pagination.Pagination[Recepcion],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(orden_provision_id: Long, buscador: utils.pagination.Pagination[Recepcion]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import models.auth._

import utils._


Seq[Any](format.raw/*1.78*/("""
"""),format.raw/*5.1*/("""

<div class="contenedorPaginador ajaxPaginador">

	"""),_display_(Seq[Any](/*9.3*/if(buscador.getTotalRowCount == 0)/*9.37*/ {_display_(Seq[Any](format.raw/*9.39*/("""
       <div class="well">
           <em>No se encuentran resultados</em>
       </div>
       
   """)))}/*14.6*/else/*14.11*/{_display_(Seq[Any](format.raw/*14.12*/("""
   	Mostrando """),_display_(Seq[Any](/*15.16*/buscador/*15.24*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*15.56*/(""" resultado(s). 
   
	<table class="table table-striped table-bordered table-hover" style="margin-top: 20px">
		<thead>
			<tr>
				<th>Numero</th>
				<th>Fecha</th>
				<th>Acta</th>
			</tr>
		</thead>
		<tbody>
		"""),_display_(Seq[Any](/*26.4*/for(o <- buscador.getList) yield /*26.30*/ {_display_(Seq[Any](format.raw/*26.32*/("""
			<tr class="pointer" data-href=""""),_display_(Seq[Any](/*27.36*/controllers/*27.47*/.patrimonio.routes.RecepcionesController.ver(o.id))),format.raw/*27.97*/("""">
				<td>"""),_display_(Seq[Any](/*28.10*/o/*28.11*/.numero)),format.raw/*28.18*/("""</td>
				<td>"""),_display_(Seq[Any](/*29.10*/if(o.create_date != null)/*29.35*/{_display_(Seq[Any](_display_(Seq[Any](/*29.37*/(utils.DateUtils.formatDate(o.create_date))))))})),format.raw/*29.81*/("""</td>
				<td>"""),_display_(Seq[Any](/*30.10*/if(o.acta != null)/*30.28*/{_display_(Seq[Any](_display_(Seq[Any](/*30.30*/o/*30.31*/.acta.numero))))})),format.raw/*30.44*/("""</td>
			</tr>
		""")))})),format.raw/*32.4*/("""
		</tbody>
	</table>
	<div class="pagination pull-right">
	    """),_display_(Seq[Any](/*36.7*/views/*36.12*/.html.helpers.paginador(buscador, controllers.patrimonio.routes.OrdenesProvisionController.getRecepciones()))),format.raw/*36.120*/("""
	</div>
   """)))})),format.raw/*38.5*/("""
		   
</div>
<script>
$('table tr.pointer td:not(:has(.notSeleccion))').click( function()"""),format.raw/*42.68*/("""{"""),format.raw/*42.69*/("""
	window.location.href = $(this).closest('tr').attr('data-href');
"""),format.raw/*44.1*/("""}"""),format.raw/*44.2*/(""");
</script>
"""))}
    }
    
    def render(orden_provision_id:Long,buscador:utils.pagination.Pagination[Recepcion]): play.api.templates.HtmlFormat.Appendable = apply(orden_provision_id,buscador)
    
    def f:((Long,utils.pagination.Pagination[Recepcion]) => play.api.templates.HtmlFormat.Appendable) = (orden_provision_id,buscador) => apply(orden_provision_id,buscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/ordenesProvision/listadoRecepciones.scala.html
                    HASH: 1142487165f7da01ff6fa57f365267375fab8d83
                    MATRIX: 852->1|1076->77|1103->133|1190->186|1232->220|1271->222|1390->324|1403->329|1442->330|1494->346|1511->354|1565->386|1817->603|1859->629|1899->631|1971->667|1991->678|2063->728|2111->740|2121->741|2150->748|2201->763|2235->788|2283->790|2353->834|2404->849|2431->867|2479->869|2489->870|2528->883|2577->901|2677->966|2691->971|2822->1079|2866->1092|2984->1182|3013->1183|3106->1249|3134->1250
                    LINES: 26->1|34->1|35->5|39->9|39->9|39->9|44->14|44->14|44->14|45->15|45->15|45->15|56->26|56->26|56->26|57->27|57->27|57->27|58->28|58->28|58->28|59->29|59->29|59->29|59->29|60->30|60->30|60->30|60->30|60->30|62->32|66->36|66->36|66->36|68->38|72->42|72->42|74->44|74->44
                    -- GENERATED --
                */
            