
package views.html.informes

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
object navInformes extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*3.70*/(""" 

<div class="row"  style="">

	<nav class="navbar navbar-default" role="navigation">
		<div class="container-fluid">
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		      <ul class="nav navbar-nav">
		      	<li>
		        <!--  <a href=""""),_display_(Seq[Any](/*12.27*/controllers/*12.38*/.informes.routes.InformesObligacionController.obligacion())),format.raw/*12.96*/("""" >OBLIGACIONES</a>-->
		        </li>
		        <li>
		        	<a href="#" class="dropdown-toggle" data-toggle="dropdown">HONORARIOS <b class="caret"></b></a>
		        	<ul class="dropdown-menu">
			        	<li><a href=""""),_display_(Seq[Any](/*17.27*/controllers/*17.38*/.informes.routes.InformesHonorariosController.honorario())),format.raw/*17.95*/("""" >Costos Por periodos</a></li>
			        	<li><a href=""""),_display_(Seq[Any](/*18.27*/controllers/*18.38*/.informes.routes.InformesHonorariosController.honorarioRrhhPorPeriodo())),format.raw/*18.109*/("""" >RRHH Por periodos</a></li>
		        	</ul>
		        </li>
		        <li>
		        	<a href="#" class="dropdown-toggle" data-toggle="dropdown">DEUDAS <b class="caret"></b></a>
		        	<ul class="dropdown-menu">
			        	<li><a href=""""),_display_(Seq[Any](/*24.27*/controllers/*24.38*/.informes.routes.InformesDeudasController.deudasFotoPorFecha())),format.raw/*24.100*/("""" >Corte Por Fecha Otros Proveedores</a></li>
			        </ul>
		        </li>
		        <!--<li class="dropdown">
		         	
		           <a href="#" class="dropdown-toggle" data-toggle="dropdown">PRESUPUESTO <b class="caret"></b></a>
		          <ul class="dropdown-menu">
		          	<li><a href=""""),_display_(Seq[Any](/*31.28*/controllers/*31.39*/.informes.routes.InformesPresupuestoController.creditos(-1))),format.raw/*31.98*/("""">Todos</a></li>
		          	<li><a href=""""),_display_(Seq[Any](/*32.28*/controllers/*32.39*/.informes.routes.InformesPresupuestoController.creditos(0))),format.raw/*32.97*/("""">PRESUPUESTOS OPERATIVOS</a></li>
		          	<li><a href=""""),_display_(Seq[Any](/*33.28*/controllers/*33.39*/.informes.routes.InformesPresupuestoController.creditos(1))),format.raw/*33.97*/("""">PROGRAMA FEDERAL DE SALUD</a></li>
		          	<li><a href=""""),_display_(Seq[Any](/*34.28*/controllers/*34.39*/.informes.routes.InformesPresupuestoController.creditos(2))),format.raw/*34.97*/("""">INSTITUTO MISIONERO DEL CANCER</a></li>
		          	<li><a href=""""),_display_(Seq[Any](/*35.28*/controllers/*35.39*/.informes.routes.InformesPresupuestoController.creditos(3))),format.raw/*35.97*/("""">INSTITUTO GENETICA HUMANA</a></li>
		          	<li><a href=""""),_display_(Seq[Any](/*36.28*/controllers/*36.39*/.informes.routes.InformesPresupuestoController.creditos(4))),format.raw/*36.97*/("""">PROGRAMA TRANSPLANTE DE MEDULA</a></li>
		          	<li><a href=""""),_display_(Seq[Any](/*37.28*/controllers/*37.39*/.informes.routes.InformesPresupuestoController.creditos(5))),format.raw/*37.97*/("""">LABORATORIO DE ALTA COMPLEJIDA</a></li>
		          	<li><a href=""""),_display_(Seq[Any](/*38.28*/controllers/*38.39*/.informes.routes.InformesPresupuestoController.creditos(6))),format.raw/*38.97*/("""">HOSPITAL NUESTRA SEÑORA DE FATIMA</a></li>
		          	<li><a href=""""),_display_(Seq[Any](/*39.28*/controllers/*39.39*/.informes.routes.InformesPresupuestoController.creditos(7))),format.raw/*39.97*/("""">JARDIN MATERNAL EVITA</a></li>
		          	<li><a href=""""),_display_(Seq[Any](/*40.28*/controllers/*40.39*/.informes.routes.InformesPresupuestoController.creditos(8))),format.raw/*40.97*/("""">CONVENIO CON FDO. FEDERAL DE INSFRAESTRUCTURA REGIONAL</a></li>
		          </ul>
		        </li> -->
		     </ul>
		      	
		    </div>  
	   		
		</div>
		 
	</nav>
</div>
<script type="text/javascript">
	$(function()"""),format.raw/*52.14*/("""{"""),format.raw/*52.15*/("""
		$('#searchProveedor').modalSearch();
	"""),format.raw/*54.2*/("""}"""),format.raw/*54.3*/(""");
</script>


"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:28 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/informes/navInformes.scala.html
                    HASH: c442e48dad992bd1cb929ee868a3176d5e38c9cf
                    MATRIX: 879->20|911->44|985->88|1292->359|1312->370|1392->428|1653->653|1673->664|1752->721|1846->779|1866->790|1960->861|2241->1106|2261->1117|2346->1179|2686->1483|2706->1494|2787->1553|2867->1597|2887->1608|2967->1666|3065->1728|3085->1739|3165->1797|3265->1861|3285->1872|3365->1930|3470->1999|3490->2010|3570->2068|3670->2132|3690->2143|3770->2201|3875->2270|3895->2281|3975->2339|4080->2408|4100->2419|4180->2477|4288->2549|4308->2560|4388->2618|4484->2678|4504->2689|4584->2747|4834->2969|4863->2970|4931->3011|4959->3012
                    LINES: 29->3|29->3|30->3|39->12|39->12|39->12|44->17|44->17|44->17|45->18|45->18|45->18|51->24|51->24|51->24|58->31|58->31|58->31|59->32|59->32|59->32|60->33|60->33|60->33|61->34|61->34|61->34|62->35|62->35|62->35|63->36|63->36|63->36|64->37|64->37|64->37|65->38|65->38|65->38|66->39|66->39|66->39|67->40|67->40|67->40|79->52|79->52|81->54|81->54
                    -- GENERATED --
                */
            