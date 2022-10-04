
package views.html.helpers

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
object paginador extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},Call,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(paginador: utils.pagination.Pagination[_], link: Call):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.57*/("""


<ul class="pagination">
	"""),_display_(Seq[Any](/*5.3*/if(paginador.hasPrev)/*5.24*/ {_display_(Seq[Any](format.raw/*5.26*/("""
	    <li><a href=""""),_display_(Seq[Any](/*6.20*/link)),format.raw/*6.24*/("""?"""),_display_(Seq[Any](/*6.26*/paginador/*6.35*/.getPrevLink())),format.raw/*6.49*/("""">&laquo; Anterior</a></li></li>
	""")))}/*7.4*/else/*7.9*/{_display_(Seq[Any](format.raw/*7.10*/("""
	    <li class="disabled"><a>&laquo; Anterior</a></li>
	""")))})),format.raw/*9.3*/("""
        <li>
	        <div>
	        <form action=""""),_display_(Seq[Any](/*12.25*/link)),format.raw/*12.29*/("""" method="get" class="paginador-page-size">
	        	"""),_display_(Seq[Any](/*13.12*/for(q <- paginador.getQueryMap().entrySet()) yield /*13.56*/ {_display_(Seq[Any](format.raw/*13.58*/("""
	        		"""),_display_(Seq[Any](/*14.13*/if(q.getKey() != "pageSize" && q.getKey() != "pageNum")/*14.68*/{_display_(Seq[Any](format.raw/*14.69*/("""
	        			<input type="hidden" name=""""),_display_(Seq[Any](/*15.41*/q/*15.42*/.getKey())),format.raw/*15.51*/("""" value=""""),_display_(Seq[Any](/*15.61*/q/*15.62*/.getValue())),format.raw/*15.73*/("""" />
	        		""")))})),format.raw/*16.13*/("""
	        	""")))})),format.raw/*17.12*/("""
	        
				<select name="pageSize">
					<!--<option """),_display_(Seq[Any](/*20.19*/if(paginador.getPageSize() == 10)/*20.52*/{_display_(Seq[Any](format.raw/*20.53*/("""selected="selected"""")))})),format.raw/*20.73*/(""">10</option>-->
					<option """),_display_(Seq[Any](/*21.15*/if(paginador.getPageSize() == 20)/*21.48*/{_display_(Seq[Any](format.raw/*21.49*/("""selected="selected"""")))})),format.raw/*21.69*/(""">25</option>
					<option """),_display_(Seq[Any](/*22.15*/if(paginador.getPageSize() == 50)/*22.48*/{_display_(Seq[Any](format.raw/*22.49*/("""selected="selected"""")))})),format.raw/*22.69*/(""">50</option>
					<option """),_display_(Seq[Any](/*23.15*/if(paginador.getPageSize() == 100)/*23.49*/{_display_(Seq[Any](format.raw/*23.50*/("""selected="selected"""")))})),format.raw/*23.70*/(""">100</option>
					<option """),_display_(Seq[Any](/*24.15*/if(paginador.getPageSize() == 200)/*24.49*/{_display_(Seq[Any](format.raw/*24.50*/("""selected="selected"""")))})),format.raw/*24.70*/(""">200</option>
					<option """),_display_(Seq[Any](/*25.15*/if(paginador.getPageSize() == 500)/*25.49*/{_display_(Seq[Any](format.raw/*25.50*/("""selected="selected"""")))})),format.raw/*25.70*/(""">500</option>
					<option """),_display_(Seq[Any](/*26.15*/if(paginador.getPageSize() == 1000)/*26.50*/{_display_(Seq[Any](format.raw/*26.51*/("""selected="selected"""")))})),format.raw/*26.71*/(""">1000</option>
					<option """),_display_(Seq[Any](/*27.15*/if(paginador.getPageSize() == 2000)/*27.50*/{_display_(Seq[Any](format.raw/*27.51*/("""selected="selected"""")))})),format.raw/*27.71*/(""">2000</option>
					<option """),_display_(Seq[Any](/*28.15*/if(paginador.getPageSize() == 3000)/*28.50*/{_display_(Seq[Any](format.raw/*28.51*/("""selected="selected"""")))})),format.raw/*28.71*/(""">3000</option>
					<option """),_display_(Seq[Any](/*29.15*/if(paginador.getPageSize() == 5000)/*29.50*/{_display_(Seq[Any](format.raw/*29.51*/("""selected="selected"""")))})),format.raw/*29.71*/(""">5000</option>
					<!-- <option """),_display_(Seq[Any](/*30.20*/if(paginador.getPageSize == paginador.getTotalRowCount())/*30.77*/{_display_(Seq[Any](format.raw/*30.78*/("""selected="selected"""")))})),format.raw/*30.98*/(""" value=""""),_display_(Seq[Any](/*30.107*/paginador/*30.116*/.getTotalRowCount())),format.raw/*30.135*/("""">Todos</option> -->
				</select>
			</form>
			<script>
				$( function()"""),format.raw/*34.18*/("""{"""),format.raw/*34.19*/("""
					
					$('.ajaxPaginador ul li:not(".disabled") a, .ajaxPaginador a.ordenPaginador').on('click', function()"""),format.raw/*36.106*/("""{"""),format.raw/*36.107*/("""
						var href = $(this).attr("href");
						var contenedor = $(this).closest('.contenedorPaginador');
						cargarContenido(href, contenedor);
						return false;
					"""),format.raw/*41.6*/("""}"""),format.raw/*41.7*/(""");
					
					$('.pagination select[name=pageSize]').on('change', function()"""),format.raw/*43.68*/("""{"""),format.raw/*43.69*/("""
						if($(this).closest('.ajaxPaginador').length) """),format.raw/*44.52*/("""{"""),format.raw/*44.53*/("""
							var url = $(this).closest('form').attr("action");
							var query =  $(this).closest('form').serialize();
							var contenedor = $(this).closest('.contenedorPaginador');
							cargarContenido(url+"?"+query, contenedor);
						"""),format.raw/*49.7*/("""}"""),format.raw/*49.8*/(""" else """),format.raw/*49.14*/("""{"""),format.raw/*49.15*/("""
							$(this).closest('form').submit();
						"""),format.raw/*51.7*/("""}"""),format.raw/*51.8*/("""
						
					"""),format.raw/*53.6*/("""}"""),format.raw/*53.7*/(""");
				
					
					
					function cargarContenido(href, contenedor)"""),format.raw/*57.48*/("""{"""),format.raw/*57.49*/("""
						$.get(href, function(data)"""),format.raw/*58.33*/("""{"""),format.raw/*58.34*/("""
							contenedor.parent().html(data);
						"""),format.raw/*60.7*/("""}"""),format.raw/*60.8*/(""");
					"""),format.raw/*61.6*/("""}"""),format.raw/*61.7*/("""
				"""),format.raw/*62.5*/("""}"""),format.raw/*62.6*/(""");
			</script>
	        </div>
		</li>
    """),_display_(Seq[Any](/*66.6*/if(paginador.hasNext)/*66.27*/ {_display_(Seq[Any](format.raw/*66.29*/("""
        <li><a href=""""),_display_(Seq[Any](/*67.23*/link)),format.raw/*67.27*/("""?"""),_display_(Seq[Any](/*67.29*/paginador/*67.38*/.getNextLink())),format.raw/*67.52*/("""">Siguiente &raquo;</a></li>
    """)))}/*68.7*/else/*68.12*/{_display_(Seq[Any](format.raw/*68.13*/("""
    	<li class="disabled"><a>Siguiente &raquo;</a></li>
    """)))})),format.raw/*70.6*/("""
</ul>"""))}
    }
    
    def render(paginador:utils.pagination.Pagination[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},link:Call): play.api.templates.HtmlFormat.Appendable = apply(paginador,link)
    
    def f:((utils.pagination.Pagination[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},Call) => play.api.templates.HtmlFormat.Appendable) = (paginador,link) => apply(paginador,link)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:44:02 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/helpers/paginador.scala.html
                    HASH: ddf89c39ae2ac044d07605b11f8453fb4b1973fa
                    MATRIX: 886->1|1035->56|1102->89|1131->110|1170->112|1226->133|1251->137|1288->139|1305->148|1340->162|1393->199|1404->204|1442->205|1532->265|1624->321|1650->325|1742->381|1802->425|1842->427|1892->441|1956->496|1995->497|2073->539|2083->540|2114->549|2160->559|2170->560|2203->571|2253->589|2298->602|2395->663|2437->696|2476->697|2528->717|2595->748|2637->781|2676->782|2728->802|2792->830|2834->863|2873->864|2925->884|2989->912|3032->946|3071->947|3123->967|3188->996|3231->1030|3270->1031|3322->1051|3387->1080|3430->1114|3469->1115|3521->1135|3586->1164|3630->1199|3669->1200|3721->1220|3787->1250|3831->1285|3870->1286|3922->1306|3988->1336|4032->1371|4071->1372|4123->1392|4189->1422|4233->1457|4272->1458|4324->1478|4395->1513|4461->1570|4500->1571|4552->1591|4598->1600|4617->1609|4659->1628|4766->1707|4795->1708|4938->1822|4968->1823|5170->1998|5198->1999|5304->2077|5333->2078|5414->2131|5443->2132|5712->2374|5740->2375|5774->2381|5803->2382|5880->2432|5908->2433|5950->2448|5978->2449|6077->2520|6106->2521|6168->2555|6197->2556|6272->2604|6300->2605|6336->2614|6364->2615|6397->2621|6425->2622|6509->2671|6539->2692|6579->2694|6639->2718|6665->2722|6703->2724|6721->2733|6757->2747|6810->2783|6823->2788|6862->2789|6957->2853
                    LINES: 28->1|31->1|35->5|35->5|35->5|36->6|36->6|36->6|36->6|36->6|37->7|37->7|37->7|39->9|42->12|42->12|43->13|43->13|43->13|44->14|44->14|44->14|45->15|45->15|45->15|45->15|45->15|45->15|46->16|47->17|50->20|50->20|50->20|50->20|51->21|51->21|51->21|51->21|52->22|52->22|52->22|52->22|53->23|53->23|53->23|53->23|54->24|54->24|54->24|54->24|55->25|55->25|55->25|55->25|56->26|56->26|56->26|56->26|57->27|57->27|57->27|57->27|58->28|58->28|58->28|58->28|59->29|59->29|59->29|59->29|60->30|60->30|60->30|60->30|60->30|60->30|60->30|64->34|64->34|66->36|66->36|71->41|71->41|73->43|73->43|74->44|74->44|79->49|79->49|79->49|79->49|81->51|81->51|83->53|83->53|87->57|87->57|88->58|88->58|90->60|90->60|91->61|91->61|92->62|92->62|96->66|96->66|96->66|97->67|97->67|97->67|97->67|97->67|98->68|98->68|98->68|100->70
                    -- GENERATED --
                */
            