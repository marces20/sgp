
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
object paginadorProductosSolicitud extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},Call,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(paginador: utils.pagination.Pagination[_], link: Call):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.57*/("""


<ul class="pagination">
	"""),_display_(Seq[Any](/*5.3*/if(paginador.hasPrev)/*5.24*/ {_display_(Seq[Any](format.raw/*5.26*/("""
	    <li><a href=""""),_display_(Seq[Any](/*6.20*/link)),format.raw/*6.24*/("""&"""),_display_(Seq[Any](/*6.26*/paginador/*6.35*/.getPrevLink())),format.raw/*6.49*/("""">&laquo; Anterior</a></li></li>
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
					<option """),_display_(Seq[Any](/*20.15*/if(paginador.getPageSize() == 20)/*20.48*/{_display_(Seq[Any](format.raw/*20.49*/("""selected="selected"""")))})),format.raw/*20.69*/(""">25</option>
					<option """),_display_(Seq[Any](/*21.15*/if(paginador.getPageSize() == 50)/*21.48*/{_display_(Seq[Any](format.raw/*21.49*/("""selected="selected"""")))})),format.raw/*21.69*/(""">50</option>
					<option """),_display_(Seq[Any](/*22.15*/if(paginador.getPageSize() == 100)/*22.49*/{_display_(Seq[Any](format.raw/*22.50*/("""selected="selected"""")))})),format.raw/*22.70*/(""">100</option>
					<option """),_display_(Seq[Any](/*23.15*/if(paginador.getPageSize() == 200)/*23.49*/{_display_(Seq[Any](format.raw/*23.50*/("""selected="selected"""")))})),format.raw/*23.70*/(""">200</option>
					<option """),_display_(Seq[Any](/*24.15*/if(paginador.getPageSize() == 500)/*24.49*/{_display_(Seq[Any](format.raw/*24.50*/("""selected="selected"""")))})),format.raw/*24.70*/(""">500</option>
					<option """),_display_(Seq[Any](/*25.15*/if(paginador.getPageSize() == 1000)/*25.50*/{_display_(Seq[Any](format.raw/*25.51*/("""selected="selected"""")))})),format.raw/*25.71*/(""">1000</option>
					<option """),_display_(Seq[Any](/*26.15*/if(paginador.getPageSize() == 2000)/*26.50*/{_display_(Seq[Any](format.raw/*26.51*/("""selected="selected"""")))})),format.raw/*26.71*/(""">2000</option>
					<option """),_display_(Seq[Any](/*27.15*/if(paginador.getPageSize() == 3000)/*27.50*/{_display_(Seq[Any](format.raw/*27.51*/("""selected="selected"""")))})),format.raw/*27.71*/(""">3000</option>
					<option """),_display_(Seq[Any](/*28.15*/if(paginador.getPageSize() == 5000)/*28.50*/{_display_(Seq[Any](format.raw/*28.51*/("""selected="selected"""")))})),format.raw/*28.71*/(""">5000</option>
				</select>
			</form>
			<script>
				$( function()"""),format.raw/*32.18*/("""{"""),format.raw/*32.19*/("""
					
					$('.ajaxPaginador ul li:not(".disabled") a, .ajaxPaginador a.ordenPaginador').on('click', function()"""),format.raw/*34.106*/("""{"""),format.raw/*34.107*/("""
						var href = $(this).attr("href");
						var contenedor = $(this).closest('.contenedorPaginador');
						cargarContenido(href, contenedor);
						return false;
					"""),format.raw/*39.6*/("""}"""),format.raw/*39.7*/(""");
					
					$('.pagination select[name=pageSize]').on('change', function()"""),format.raw/*41.68*/("""{"""),format.raw/*41.69*/("""
						if($(this).closest('.ajaxPaginador').length) """),format.raw/*42.52*/("""{"""),format.raw/*42.53*/("""
							var url = $(this).closest('form').attr("action");
							var query =  $(this).closest('form').serialize();
							var contenedor = $(this).closest('.contenedorPaginador');
							cargarContenido(url+"&"+query, contenedor);
						"""),format.raw/*47.7*/("""}"""),format.raw/*47.8*/(""" else """),format.raw/*47.14*/("""{"""),format.raw/*47.15*/("""
							$(this).closest('form').submit();
						"""),format.raw/*49.7*/("""}"""),format.raw/*49.8*/("""
						
					"""),format.raw/*51.6*/("""}"""),format.raw/*51.7*/(""");
				
					
					
					function cargarContenido(href, contenedor)"""),format.raw/*55.48*/("""{"""),format.raw/*55.49*/("""
						$.get(href, function(data)"""),format.raw/*56.33*/("""{"""),format.raw/*56.34*/("""
							contenedor.parent().html(data);
						"""),format.raw/*58.7*/("""}"""),format.raw/*58.8*/(""");
					"""),format.raw/*59.6*/("""}"""),format.raw/*59.7*/("""
				"""),format.raw/*60.5*/("""}"""),format.raw/*60.6*/(""");
			</script>
	        </div>
		</li>
    """),_display_(Seq[Any](/*64.6*/if(paginador.hasNext)/*64.27*/ {_display_(Seq[Any](format.raw/*64.29*/("""
        <li><a href=""""),_display_(Seq[Any](/*65.23*/link)),format.raw/*65.27*/("""&"""),_display_(Seq[Any](/*65.29*/paginador/*65.38*/.getNextLink())),format.raw/*65.52*/("""">Siguiente &raquo;</a></li>
    """)))}/*66.7*/else/*66.12*/{_display_(Seq[Any](format.raw/*66.13*/("""
    	<li class="disabled"><a>Siguiente &raquo;</a></li>
    """)))})),format.raw/*68.6*/("""
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
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/helpers/paginadorProductosSolicitud.scala.html
                    HASH: 80db6b6b26e87ae97fc711cb764f5a6195b388c2
                    MATRIX: 904->1|1053->56|1116->85|1145->106|1184->108|1239->128|1264->132|1301->134|1318->143|1353->157|1405->193|1416->198|1454->199|1542->257|1631->310|1657->314|1748->369|1808->413|1848->415|1897->428|1961->483|2000->484|2077->525|2087->526|2118->535|2164->545|2174->546|2207->557|2256->574|2300->586|2390->640|2432->673|2471->674|2523->694|2586->721|2628->754|2667->755|2719->775|2782->802|2825->836|2864->837|2916->857|2980->885|3023->919|3062->920|3114->940|3178->968|3221->1002|3260->1003|3312->1023|3376->1051|3420->1086|3459->1087|3511->1107|3576->1136|3620->1171|3659->1172|3711->1192|3776->1221|3820->1256|3859->1257|3911->1277|3976->1306|4020->1341|4059->1342|4111->1362|4208->1431|4237->1432|4378->1544|4408->1545|4605->1715|4633->1716|4737->1792|4766->1793|4846->1845|4875->1846|5139->2083|5167->2084|5201->2090|5230->2091|5305->2139|5333->2140|5373->2153|5401->2154|5496->2221|5525->2222|5586->2255|5615->2256|5688->2302|5716->2303|5751->2311|5779->2312|5811->2317|5839->2318|5919->2363|5949->2384|5989->2386|6048->2409|6074->2413|6112->2415|6130->2424|6166->2438|6218->2473|6231->2478|6270->2479|6363->2541
                    LINES: 28->1|31->1|35->5|35->5|35->5|36->6|36->6|36->6|36->6|36->6|37->7|37->7|37->7|39->9|42->12|42->12|43->13|43->13|43->13|44->14|44->14|44->14|45->15|45->15|45->15|45->15|45->15|45->15|46->16|47->17|50->20|50->20|50->20|50->20|51->21|51->21|51->21|51->21|52->22|52->22|52->22|52->22|53->23|53->23|53->23|53->23|54->24|54->24|54->24|54->24|55->25|55->25|55->25|55->25|56->26|56->26|56->26|56->26|57->27|57->27|57->27|57->27|58->28|58->28|58->28|58->28|62->32|62->32|64->34|64->34|69->39|69->39|71->41|71->41|72->42|72->42|77->47|77->47|77->47|77->47|79->49|79->49|81->51|81->51|85->55|85->55|86->56|86->56|88->58|88->58|89->59|89->59|90->60|90->60|94->64|94->64|94->64|95->65|95->65|95->65|95->65|95->65|96->66|96->66|96->66|98->68
                    -- GENERATED --
                */
            