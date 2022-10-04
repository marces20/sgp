
package views.html.patrimonio.baul

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
object verRemitoBaul extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[RemitoBaul,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(remito: RemitoBaul):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import models.auth._

import utils._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.22*/("""
"""),format.raw/*5.70*/(""" 

"""),_display_(Seq[Any](/*7.2*/views/*7.7*/.html.patrimonio.mainPatrimonio("Vista de remito en baúl")/*7.65*/ {_display_(Seq[Any](format.raw/*7.67*/("""
	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Vista de remito en baúl</h1>
			</div>
			"""),_display_(Seq[Any](/*13.5*/if(Permiso.check("remitosVer"))/*13.36*/ {_display_(Seq[Any](format.raw/*13.38*/("""
			<div class="pull-right btn-header">
				<a href=""""),_display_(Seq[Any](/*15.15*/controllers/*15.26*/.patrimonio.routes.RemitosBaulController.crear())),format.raw/*15.74*/("""" class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Crear remito</a>
			</div>
			""")))})),format.raw/*17.5*/("""
		</div>	
	</div>

	
	"""),_display_(Seq[Any](/*22.3*/views/*22.8*/.html.tags.successError())),format.raw/*22.33*/("""

<div class="row menu-acciones">
	<div class="col-sm-10">
		"""),_display_(Seq[Any](/*26.4*/if(Permiso.check("remitosCrear"))/*26.37*/ {_display_(Seq[Any](format.raw/*26.39*/("""
		<a href=""""),_display_(Seq[Any](/*27.13*/controllers/*27.24*/.patrimonio.routes.RemitosBaulController.editar(remito.id))),_display_(Seq[Any](/*27.83*/UriTrack/*27.91*/.get("&"))),format.raw/*27.100*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-edit"></i> Editar</a>
		""")))})),format.raw/*28.4*/("""
		"""),_display_(Seq[Any](/*29.4*/if(Permiso.check("remitosEliminar"))/*29.40*/ {_display_(Seq[Any](format.raw/*29.42*/("""
		<a href=""""),_display_(Seq[Any](/*30.13*/controllers/*30.24*/.patrimonio.routes.RemitosBaulController.eliminar(remito.id))),_display_(Seq[Any](/*30.85*/UriTrack/*30.93*/.get("&"))),format.raw/*30.102*/(""""  class="btn btn-default delete-confirm-link"><i class="glyphicon glyphicon-trash icono-eliminar"></i> Eliminar</a>
		""")))})),format.raw/*31.4*/("""
	</div>
	<div class="col-sm-2">
		<a href=""""),_display_(Seq[Any](/*34.13*/UriTrack/*34.21*/.getOnNull(controllers.patrimonio.routes.RemitosBaulController.index().absoluteURL()))),format.raw/*34.106*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a>
	</div>
</div>



	<div class="row">
		<div class="col-sm-2">
			<label class="control-label">Número</label>
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*43.49*/remito/*43.55*/.numero)),format.raw/*43.62*/("""</p>
		</div>
		
		<div class="col-sm-2">
			<label class="control-label">Fecha</label> 
			<p class="form-control-static form-control" style="height: 25px; overflow: hidden;">"""),_display_(Seq[Any](/*48.89*/(DateUtils.formatDate(remito.create_date)))),format.raw/*48.131*/("""</p>
		</div>
	
		<div class="col-sm-3">
			<label class="control-label">Proveedor</label> 
			<p class="form-control-static form-control" style="height: 25px; overflow: hidden;">"""),_display_(Seq[Any](/*53.89*/remito/*53.95*/.proveedor.nombre)),format.raw/*53.112*/("""</p>
		</div>
		
		<div class="col-sm-3">
			<label class="control-label">Responsable</label> 
			<p class="form-control-static form-control" style="height: 25px; overflow: hidden;">"""),_display_(Seq[Any](/*58.89*/remito/*58.95*/.create_usuario.nombre)),format.raw/*58.117*/("""</p>
		</div>
		
	</div>
	
	<div class="row">
		<div class="col-sm-12">
			<label class="control-label">Observaciones</label> 
			<p class="form-control-static form-control">"""),_display_(Seq[Any](/*66.49*/remito/*66.55*/.observaciones)),format.raw/*66.69*/("""</p>
		</div>
	</div>

<hr />

"""),_display_(Seq[Any](/*72.2*/views/*72.7*/.html.patrimonio.baul.tabsProductoRemitoBaul(false, remito.id))),format.raw/*72.69*/("""	
	
	
""")))})),format.raw/*75.2*/("""
"""))}
    }
    
    def render(remito:RemitoBaul): play.api.templates.HtmlFormat.Appendable = apply(remito)
    
    def f:((RemitoBaul) => play.api.templates.HtmlFormat.Appendable) = (remito) => apply(remito)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/baul/verRemitoBaul.scala.html
                    HASH: d6019b48f45c1f0425312fb9757fe35c344ffc9d
                    MATRIX: 802->1|965->82|997->106|1071->21|1100->150|1140->156|1152->161|1218->219|1257->221|1423->352|1463->383|1503->385|1595->441|1615->452|1685->500|1821->605|1885->634|1898->639|1945->664|2046->730|2088->763|2128->765|2178->779|2198->790|2287->849|2304->857|2336->866|2450->949|2490->954|2535->990|2575->992|2625->1006|2645->1017|2736->1078|2753->1086|2785->1095|2937->1216|3021->1264|3038->1272|3146->1357|3419->1594|3434->1600|3463->1607|3681->1789|3746->1831|3967->2016|3982->2022|4022->2039|4246->2227|4261->2233|4306->2255|4525->2438|4540->2444|4576->2458|4649->2496|4662->2501|4746->2563|4787->2573
                    LINES: 26->1|33->5|33->5|34->1|35->5|37->7|37->7|37->7|37->7|43->13|43->13|43->13|45->15|45->15|45->15|47->17|52->22|52->22|52->22|56->26|56->26|56->26|57->27|57->27|57->27|57->27|57->27|58->28|59->29|59->29|59->29|60->30|60->30|60->30|60->30|60->30|61->31|64->34|64->34|64->34|73->43|73->43|73->43|78->48|78->48|83->53|83->53|83->53|88->58|88->58|88->58|96->66|96->66|96->66|102->72|102->72|102->72|105->75
                    -- GENERATED --
                */
            