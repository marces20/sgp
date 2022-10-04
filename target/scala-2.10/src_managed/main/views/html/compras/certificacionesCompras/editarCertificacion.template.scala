
package views.html.compras.certificacionesCompras

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
object editarCertificacion extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Form[CertificacionCompra],CertificacionCompra,Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(certificacionForm: Form[CertificacionCompra],certificacion:CertificacionCompra,obras:Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

def /*5.2*/scripts/*5.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*5.13*/("""
	<script src=""""),_display_(Seq[Any](/*6.16*/routes/*6.22*/.Assets.at("javascripts/compras/certificacionesCompras.js"))),format.raw/*6.81*/("""" type="text/javascript"></script>
""")))};implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.96*/("""
"""),format.raw/*3.70*/("""

"""),format.raw/*7.2*/("""

"""),_display_(Seq[Any](/*9.2*/views/*9.7*/.html.compras.mainCompras("Modificar Certificacion", scripts)/*9.68*/ {_display_(Seq[Any](format.raw/*9.70*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Editar Certificacion """),_display_(Seq[Any](/*14.31*/if(obras)/*14.40*/{_display_(Seq[Any](format.raw/*14.41*/("""Obras""")))}/*14.47*/else/*14.51*/{_display_(Seq[Any](format.raw/*14.52*/("""Compras""")))})),format.raw/*14.60*/("""</h1>
			</div>

			<div class="col-sm-5">
				<div class="dropdown pull-right">
				 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 	<i class="glyphicon glyphicon-list-alt"></i>
				    Reportes
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				    
				  </ul>
				</div>
				
				<div class="dropdown pull-right btn-header">
				 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
				 	<i class="glyphicon glyphicon-cog"></i>
				    Acciones
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				  	<li role="presentation">
				  		"""),_display_(Seq[Any](/*37.10*/if(obras)/*37.19*/{_display_(Seq[Any](format.raw/*37.20*/("""
				  		
				  		""")))}/*39.10*/else/*39.14*/{_display_(Seq[Any](format.raw/*39.15*/("""
					    	<a role="menuitem" tabindex="-1" href="#" id="editarCuentaAnalitica" data-url=""""),_display_(Seq[Any](/*40.91*/controllers/*40.102*/.compras.routes.CertificacionesComprasController.modalEditarCuentaAnalica())),format.raw/*40.177*/("""">
					    		Editar cuenta analitica
					    	</a>
				    	""")))})),format.raw/*43.11*/("""
				    </li>	
				  </ul>
				</div>
					
				<div class="pull-right btn-header">
					"""),_display_(Seq[Any](/*49.7*/if(obras)/*49.16*/{_display_(Seq[Any](format.raw/*49.17*/("""
				  		<a href=""""),_display_(Seq[Any](/*50.19*/controllers/*50.30*/.compras.routes.CertificacionesObrasController.crear())),format.raw/*50.84*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nueva Certificacion</a>
				  	""")))}/*51.9*/else/*51.13*/{_display_(Seq[Any](format.raw/*51.14*/("""
						<a href=""""),_display_(Seq[Any](/*52.17*/controllers/*52.28*/.compras.routes.CertificacionesComprasController.crear())),format.raw/*52.84*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nueva Certificacion</a>
					""")))})),format.raw/*53.7*/("""
				</div>
			</div>
			
			
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*61.3*/if(flash.containsKey("error"))/*61.33*/ {_display_(Seq[Any](format.raw/*61.35*/("""
		<div class="alert alert-danger">
			"""),_display_(Seq[Any](/*63.5*/flash/*63.10*/.get("error"))),format.raw/*63.23*/("""
		</div>
	""")))})),format.raw/*65.3*/("""
	
	 """),_display_(Seq[Any](/*67.4*/if(obras)/*67.13*/{_display_(Seq[Any](format.raw/*67.14*/("""
	   """),_display_(Seq[Any](/*68.6*/helper/*68.12*/.form(action = controllers.compras.routes.CertificacionesObrasController.actualizar(certificacion.id))/*68.114*/ {_display_(Seq[Any](format.raw/*68.116*/("""
			"""),_display_(Seq[Any](/*69.5*/inputText(certificacionForm("id"), 'hidden -> "hidden"))),format.raw/*69.60*/("""
			"""),_display_(Seq[Any](/*70.5*/views/*70.10*/.html.compras.certificacionesCompras.formCertificacion(certificacionForm))),format.raw/*70.83*/("""
			"""),_display_(Seq[Any](/*71.5*/views/*71.10*/.html.compras.certificacionesCompras.tabsCertificacion(true, certificacionForm))),format.raw/*71.89*/("""	
		""")))})),format.raw/*72.4*/("""
		
	""")))}/*74.3*/else/*74.7*/{_display_(Seq[Any](format.raw/*74.8*/("""
		"""),_display_(Seq[Any](/*75.4*/helper/*75.10*/.form(action = controllers.compras.routes.CertificacionesComprasController.actualizar(certificacion.id))/*75.114*/ {_display_(Seq[Any](format.raw/*75.116*/("""
			"""),_display_(Seq[Any](/*76.5*/inputText(certificacionForm("id"), 'hidden -> "hidden"))),format.raw/*76.60*/("""
			"""),_display_(Seq[Any](/*77.5*/views/*77.10*/.html.compras.certificacionesCompras.formCertificacion(certificacionForm))),format.raw/*77.83*/("""
			"""),_display_(Seq[Any](/*78.5*/views/*78.10*/.html.compras.certificacionesCompras.tabsCertificacion(true, certificacionForm))),format.raw/*78.89*/("""	
		""")))})),format.raw/*79.4*/("""
	""")))})),format.raw/*80.3*/("""
		<h4>Base: 		<b>"""),_display_(Seq[Any](/*81.19*/utils/*81.24*/.NumberUtils.moneda(certificacion.getBase()))),format.raw/*81.68*/("""</b></h4>	
		<h4>Descuento: 	<b>"""),_display_(Seq[Any](/*82.23*/utils/*82.28*/.NumberUtils.moneda(certificacion.getDescuento()))),format.raw/*82.77*/("""</b></h4>	
		<h4>Total: 		<b>"""),_display_(Seq[Any](/*83.20*/utils/*83.25*/.NumberUtils.moneda(certificacion.getTotal()))),format.raw/*83.70*/("""</b></h4>	
		<h4>Estado actual: 	<b>"""),_display_(Seq[Any](/*84.27*/certificacion/*84.40*/.estado.nombre)),format.raw/*84.54*/("""</b></h4>
		<div class="row margin-bottom-25">	
			
		</div>
	

""")))})))}
    }
    
    def render(certificacionForm:Form[CertificacionCompra],certificacion:CertificacionCompra,obras:Boolean): play.api.templates.HtmlFormat.Appendable = apply(certificacionForm,certificacion,obras)
    
    def f:((Form[CertificacionCompra],CertificacionCompra,Boolean) => play.api.templates.HtmlFormat.Appendable) = (certificacionForm,certificacion,obras) => apply(certificacionForm,certificacion,obras)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:44 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/certificacionesCompras/editarCertificacion.scala.html
                    HASH: 3199408a6d50df0aa55a36a3304d8f739266b065
                    MATRIX: 866->1|1053->185|1067->192|1151->196|1202->212|1216->218|1296->277|1363->114|1395->138|1469->95|1497->182|1525->313|1562->316|1574->321|1643->382|1682->384|1823->489|1841->498|1880->499|1905->505|1918->509|1957->510|1997->518|2851->1336|2869->1345|2908->1346|2946->1365|2959->1369|2998->1370|3125->1461|3146->1472|3244->1547|3339->1610|3465->1701|3483->1710|3522->1711|3577->1730|3597->1741|3673->1795|3796->1900|3809->1904|3848->1905|3901->1922|3921->1933|3999->1989|4133->2092|4220->2144|4259->2174|4299->2176|4374->2216|4388->2221|4423->2234|4466->2246|4507->2252|4525->2261|4564->2262|4605->2268|4620->2274|4732->2376|4773->2378|4813->2383|4890->2438|4930->2443|4944->2448|5039->2521|5079->2526|5093->2531|5194->2610|5230->2615|5254->2621|5266->2625|5304->2626|5343->2630|5358->2636|5472->2740|5513->2742|5553->2747|5630->2802|5670->2807|5684->2812|5779->2885|5819->2890|5833->2895|5934->2974|5970->2979|6004->2982|6059->3001|6073->3006|6139->3050|6208->3083|6222->3088|6293->3137|6359->3167|6373->3172|6440->3217|6513->3254|6535->3267|6571->3281
                    LINES: 26->1|29->5|29->5|31->5|32->6|32->6|32->6|33->3|33->3|34->1|35->3|37->7|39->9|39->9|39->9|39->9|44->14|44->14|44->14|44->14|44->14|44->14|44->14|67->37|67->37|67->37|69->39|69->39|69->39|70->40|70->40|70->40|73->43|79->49|79->49|79->49|80->50|80->50|80->50|81->51|81->51|81->51|82->52|82->52|82->52|83->53|91->61|91->61|91->61|93->63|93->63|93->63|95->65|97->67|97->67|97->67|98->68|98->68|98->68|98->68|99->69|99->69|100->70|100->70|100->70|101->71|101->71|101->71|102->72|104->74|104->74|104->74|105->75|105->75|105->75|105->75|106->76|106->76|107->77|107->77|107->77|108->78|108->78|108->78|109->79|110->80|111->81|111->81|111->81|112->82|112->82|112->82|113->83|113->83|113->83|114->84|114->84|114->84
                    -- GENERATED --
                */
            