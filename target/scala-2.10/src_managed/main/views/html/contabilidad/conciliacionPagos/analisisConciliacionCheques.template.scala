
package views.html.contabilidad.conciliacionPagos

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
object analisisConciliacionCheques extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[List[HashMap[String, Object]],List[Integer],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lista: List[HashMap[String, Object]], conciliar: List[Integer]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.66*/("""

"""),_display_(Seq[Any](/*3.2*/views/*3.7*/.html.contabilidad.mainContabilidad(title = "Analisis de información de cheques")/*3.88*/ {_display_(Seq[Any](format.raw/*3.90*/("""

<div class="page-header">
	<div class="row">
		<div class="col-sm-9">
			<h1>Analisis de información de cheques</h1>
		</div>
	</div>
</div>

"""),_display_(Seq[Any](/*13.2*/views/*13.7*/.html.tags.successError())),format.raw/*13.32*/("""
        
<div class="content">

	"""),_display_(Seq[Any](/*17.3*/if(!lista.isEmpty())/*17.23*/ {_display_(Seq[Any](format.raw/*17.25*/("""
	

		<div class="alert alert-error" role="alert">Se han encontrado algunas incidencias <b>("""),_display_(Seq[Any](/*20.90*/lista/*20.95*/.size())),format.raw/*20.102*/(""")</b></div>
		
		<table id="listaActasRecepcion" class="table table-striped table-bordered table-hover">
			<thead>	
				<tr>
					
					<th width="100">Referencia</th>
					<th width="100">Débito</th>
					<th width="100">Pago</th>
					<th>Mensaje</th>
					
				</tr>
			</thead>
			<tbody>
				"""),_display_(Seq[Any](/*34.6*/for(l <- lista) yield /*34.21*/ {_display_(Seq[Any](format.raw/*34.23*/("""
				<tr>
					<td>"""),_display_(Seq[Any](/*36.11*/l/*36.12*/.get("referencia"))),format.raw/*36.30*/("""</td>
					<td>"""),_display_(Seq[Any](/*37.11*/l/*37.12*/.get("debito"))),format.raw/*37.26*/("""</td>
					<td>"""),_display_(Seq[Any](/*38.11*/l/*38.12*/.get("total"))),format.raw/*38.25*/("""</td>
					<td>"""),_display_(Seq[Any](/*39.11*/l/*39.12*/.get("mensajes"))),format.raw/*39.28*/("""</td>
				</tr>
				""")))})),format.raw/*41.6*/("""
			</tbody>
		</table>
		
		<a href=""""),_display_(Seq[Any](/*45.13*/controllers/*45.24*/.contabilidad.routes.ConciliacionPagosController.index())),format.raw/*45.80*/(""""  class="form-control btn btn-default"><i class="glyphicon glyphicon-repeat"></i> Volver a procesar el archivo</a>

	""")))}/*47.4*/else/*47.9*/{_display_(Seq[Any](format.raw/*47.10*/("""
	
		"""),_display_(Seq[Any](/*49.4*/helper/*49.10*/.form(action = controllers.contabilidad.routes.ConciliacionPagosController.conciliarCheques())/*49.104*/ {_display_(Seq[Any](format.raw/*49.106*/("""
		
			"""),_display_(Seq[Any](/*51.5*/for(c <- conciliar) yield /*51.24*/ {_display_(Seq[Any](format.raw/*51.26*/("""
				<input type="hidden" name="referencia" value=""""),_display_(Seq[Any](/*52.52*/c)),format.raw/*52.53*/("""" />
			""")))})),format.raw/*53.5*/("""

			<div class="alert alert-success"><i class="glyphicon glyphicon-ok-sign"></i> Archivo procesado correctamente! <button type="submit" class="btn btn-success">Conciliar pagos</button></div>
		""")))})),format.raw/*56.4*/("""
	
	""")))})),format.raw/*58.3*/("""


</div>

""")))})),format.raw/*63.2*/("""
"""))}
    }
    
    def render(lista:List[HashMap[String, Object]],conciliar:List[Integer]): play.api.templates.HtmlFormat.Appendable = apply(lista,conciliar)
    
    def f:((List[HashMap[String, Object]],List[Integer]) => play.api.templates.HtmlFormat.Appendable) = (lista,conciliar) => apply(lista,conciliar)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:41 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/conciliacionPagos/analisisConciliacionCheques.scala.html
                    HASH: d2a007b9e819aa2a9bf5b015c0e932f9d4bd606b
                    MATRIX: 864->1|1022->65|1061->70|1073->75|1162->156|1201->158|1391->313|1404->318|1451->343|1525->382|1554->402|1594->404|1726->500|1740->505|1770->512|2118->825|2149->840|2189->842|2247->864|2257->865|2297->883|2350->900|2360->901|2396->915|2449->932|2459->933|2494->946|2547->963|2557->964|2595->980|2649->1003|2728->1046|2748->1057|2826->1113|2965->1235|2977->1240|3016->1241|3059->1249|3074->1255|3178->1349|3219->1351|3264->1361|3299->1380|3339->1382|3428->1435|3451->1436|3492->1446|3721->1644|3759->1651|3807->1668
                    LINES: 26->1|29->1|31->3|31->3|31->3|31->3|41->13|41->13|41->13|45->17|45->17|45->17|48->20|48->20|48->20|62->34|62->34|62->34|64->36|64->36|64->36|65->37|65->37|65->37|66->38|66->38|66->38|67->39|67->39|67->39|69->41|73->45|73->45|73->45|75->47|75->47|75->47|77->49|77->49|77->49|77->49|79->51|79->51|79->51|80->52|80->52|81->53|84->56|86->58|91->63
                    -- GENERATED --
                */
            