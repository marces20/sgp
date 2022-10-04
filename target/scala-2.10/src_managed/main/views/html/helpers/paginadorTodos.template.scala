
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
object paginadorTodos extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[_$1] forSome { 
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
					<option """),_display_(Seq[Any](/*20.15*/if(paginador.getPageSize() == 500)/*20.49*/{_display_(Seq[Any](format.raw/*20.50*/("""selected="selected"""")))})),format.raw/*20.70*/(""">500</option>
					<option """),_display_(Seq[Any](/*21.15*/if(paginador.getPageSize() == 1000)/*21.50*/{_display_(Seq[Any](format.raw/*21.51*/("""selected="selected"""")))})),format.raw/*21.71*/(""">1000</option>
					<option """),_display_(Seq[Any](/*22.15*/if(paginador.getPageSize() == 2000)/*22.50*/{_display_(Seq[Any](format.raw/*22.51*/("""selected="selected"""")))})),format.raw/*22.71*/(""">2000</option>
					<option """),_display_(Seq[Any](/*23.15*/if(paginador.getPageSize() == 3000)/*23.50*/{_display_(Seq[Any](format.raw/*23.51*/("""selected="selected"""")))})),format.raw/*23.71*/(""">3000</option>
					<option """),_display_(Seq[Any](/*24.15*/if(paginador.getPageSize() == 5000)/*24.50*/{_display_(Seq[Any](format.raw/*24.51*/("""selected="selected"""")))})),format.raw/*24.71*/(""">5000</option>
					<option """),_display_(Seq[Any](/*25.15*/if(paginador.getPageSize == paginador.getTotalRowCount())/*25.72*/{_display_(Seq[Any](format.raw/*25.73*/("""selected="selected"""")))})),format.raw/*25.93*/(""" value=""""),_display_(Seq[Any](/*25.102*/paginador/*25.111*/.getTotalRowCount())),format.raw/*25.130*/("""">Todos</option> 
				</select>
			</form>
			<script>
				$( function()"""),format.raw/*29.18*/("""{"""),format.raw/*29.19*/("""
					
					$('.ajaxPaginador ul li:not(".disabled") a, .ajaxPaginador a.ordenPaginador').on('click', function()"""),format.raw/*31.106*/("""{"""),format.raw/*31.107*/("""
						var href = $(this).attr("href");
						var contenedor = $(this).closest('.contenedorPaginador');
						cargarContenido(href, contenedor);
						return false;
					"""),format.raw/*36.6*/("""}"""),format.raw/*36.7*/(""");
					
					$('.pagination select[name=pageSize]').on('change', function()"""),format.raw/*38.68*/("""{"""),format.raw/*38.69*/("""
						if($(this).closest('.ajaxPaginador').length) """),format.raw/*39.52*/("""{"""),format.raw/*39.53*/("""
							var url = $(this).closest('form').attr("action");
							var query =  $(this).closest('form').serialize();
							var contenedor = $(this).closest('.contenedorPaginador');
							cargarContenido(url+"?"+query, contenedor);
						"""),format.raw/*44.7*/("""}"""),format.raw/*44.8*/(""" else """),format.raw/*44.14*/("""{"""),format.raw/*44.15*/("""
							$(this).closest('form').submit();
						"""),format.raw/*46.7*/("""}"""),format.raw/*46.8*/("""
						
					"""),format.raw/*48.6*/("""}"""),format.raw/*48.7*/(""");
				
					
					
					function cargarContenido(href, contenedor)"""),format.raw/*52.48*/("""{"""),format.raw/*52.49*/("""
						$.get(href, function(data)"""),format.raw/*53.33*/("""{"""),format.raw/*53.34*/("""
							contenedor.parent().html(data);
						"""),format.raw/*55.7*/("""}"""),format.raw/*55.8*/(""");
					"""),format.raw/*56.6*/("""}"""),format.raw/*56.7*/("""
				"""),format.raw/*57.5*/("""}"""),format.raw/*57.6*/(""");
			</script>
	        </div>
		</li>
    """),_display_(Seq[Any](/*61.6*/if(paginador.hasNext)/*61.27*/ {_display_(Seq[Any](format.raw/*61.29*/("""
        <li><a href=""""),_display_(Seq[Any](/*62.23*/link)),format.raw/*62.27*/("""?"""),_display_(Seq[Any](/*62.29*/paginador/*62.38*/.getNextLink())),format.raw/*62.52*/("""">Siguiente &raquo;</a></li>
    """)))}/*63.7*/else/*63.12*/{_display_(Seq[Any](format.raw/*63.13*/("""
    	<li class="disabled"><a>Siguiente &raquo;</a></li>
    """)))})),format.raw/*65.6*/("""
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
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/helpers/paginadorTodos.scala.html
                    HASH: 901c8a9d768ae78acb5024169ca4d54b8622d693
                    MATRIX: 891->1|1040->56|1103->85|1132->106|1171->108|1226->128|1251->132|1288->134|1305->143|1340->157|1392->193|1403->198|1441->199|1529->257|1618->310|1644->314|1735->369|1795->413|1835->415|1884->428|1948->483|1987->484|2064->525|2074->526|2105->535|2151->545|2161->546|2194->557|2243->574|2287->586|2377->640|2420->674|2459->675|2511->695|2575->723|2619->758|2658->759|2710->779|2775->808|2819->843|2858->844|2910->864|2975->893|3019->928|3058->929|3110->949|3175->978|3219->1013|3258->1014|3310->1034|3375->1063|3441->1120|3480->1121|3532->1141|3578->1150|3597->1159|3639->1178|3739->1250|3768->1251|3909->1363|3939->1364|4136->1534|4164->1535|4268->1611|4297->1612|4377->1664|4406->1665|4670->1902|4698->1903|4732->1909|4761->1910|4836->1958|4864->1959|4904->1972|4932->1973|5027->2040|5056->2041|5117->2074|5146->2075|5219->2121|5247->2122|5282->2130|5310->2131|5342->2136|5370->2137|5450->2182|5480->2203|5520->2205|5579->2228|5605->2232|5643->2234|5661->2243|5697->2257|5749->2292|5762->2297|5801->2298|5894->2360
                    LINES: 28->1|31->1|35->5|35->5|35->5|36->6|36->6|36->6|36->6|36->6|37->7|37->7|37->7|39->9|42->12|42->12|43->13|43->13|43->13|44->14|44->14|44->14|45->15|45->15|45->15|45->15|45->15|45->15|46->16|47->17|50->20|50->20|50->20|50->20|51->21|51->21|51->21|51->21|52->22|52->22|52->22|52->22|53->23|53->23|53->23|53->23|54->24|54->24|54->24|54->24|55->25|55->25|55->25|55->25|55->25|55->25|55->25|59->29|59->29|61->31|61->31|66->36|66->36|68->38|68->38|69->39|69->39|74->44|74->44|74->44|74->44|76->46|76->46|78->48|78->48|82->52|82->52|83->53|83->53|85->55|85->55|86->56|86->56|87->57|87->57|91->61|91->61|91->61|92->62|92->62|92->62|92->62|92->62|93->63|93->63|93->63|95->65
                    -- GENERATED --
                */
            