
package views.html.compras.certificaciones

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
object editarCertificacion extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[Certificacion],Certificacion,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(certificacionForm: Form[Certificacion],certificacion:Certificacion):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

def /*5.2*/scripts/*5.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*5.13*/("""
	<script src=""""),_display_(Seq[Any](/*6.16*/routes/*6.22*/.Assets.at("javascripts/compras/certificaciones.js"))),format.raw/*6.74*/("""" type="text/javascript"></script>
""")))};implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.70*/("""
"""),format.raw/*3.70*/("""

"""),format.raw/*7.2*/("""

"""),_display_(Seq[Any](/*9.2*/views/*9.7*/.html.compras.mainCompras("Modificar certificacion Personal", scripts)/*9.77*/ {_display_(Seq[Any](format.raw/*9.79*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Editar certificacion Personal</h1>
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
				    	<a role="menuitem" tabindex="-1" href="#" id="editarCuentaAnalitica" data-url=""""),_display_(Seq[Any](/*37.90*/controllers/*37.101*/.compras.routes.CertificacionesController.modalEditarCuentaAnalica())),format.raw/*37.169*/("""">
				    		Editar cuenta analitica
				    	</a>
				    </li>	
				  </ul>
				</div>
					
				<div class="pull-right btn-header">
					<a href=""""),_display_(Seq[Any](/*45.16*/controllers/*45.27*/.compras.routes.CertificacionesController.crear())),format.raw/*45.76*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nueva Certificacion</a>
				</div>
			</div>
			
			
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*53.3*/if(flash.containsKey("error"))/*53.33*/ {_display_(Seq[Any](format.raw/*53.35*/("""
		<div class="alert alert-danger">
			"""),_display_(Seq[Any](/*55.5*/flash/*55.10*/.get("error"))),format.raw/*55.23*/("""
		</div>
	""")))})),format.raw/*57.3*/("""
	

	"""),_display_(Seq[Any](/*60.3*/helper/*60.9*/.form(action = controllers.compras.routes.CertificacionesController.actualizar(certificacion.id))/*60.106*/ {_display_(Seq[Any](format.raw/*60.108*/("""

	
		"""),_display_(Seq[Any](/*63.4*/inputText(certificacionForm("id"), 'hidden -> "hidden"))),format.raw/*63.59*/("""
		"""),_display_(Seq[Any](/*64.4*/views/*64.9*/.html.compras.certificaciones.formCertificacion(certificacionForm))),format.raw/*64.75*/("""
		"""),_display_(Seq[Any](/*65.4*/views/*65.9*/.html.compras.certificaciones.tabsCertificacion(true, certificacionForm))),format.raw/*65.81*/("""	
		
		<h4>Base: 		<b>"""),_display_(Seq[Any](/*67.19*/utils/*67.24*/.NumberUtils.moneda(certificacion.getBase()))),format.raw/*67.68*/("""</b></h4>	
		<h4>Descuento: 	<b>"""),_display_(Seq[Any](/*68.23*/utils/*68.28*/.NumberUtils.moneda(certificacion.getDescuento()))),format.raw/*68.77*/("""</b></h4>	
		<h4>Total: 		<b>"""),_display_(Seq[Any](/*69.20*/utils/*69.25*/.NumberUtils.moneda(certificacion.getTotal()))),format.raw/*69.70*/("""</b></h4>	
		<h4>Estado actual: 	<b>"""),_display_(Seq[Any](/*70.27*/certificacion/*70.40*/.estado.nombre)),format.raw/*70.54*/("""</b></h4>
		<div class="row margin-bottom-25">	
			
		</div>
		
	""")))})),format.raw/*75.3*/("""

""")))})))}
    }
    
    def render(certificacionForm:Form[Certificacion],certificacion:Certificacion): play.api.templates.HtmlFormat.Appendable = apply(certificacionForm,certificacion)
    
    def f:((Form[Certificacion],Certificacion) => play.api.templates.HtmlFormat.Appendable) = (certificacionForm,certificacion) => apply(certificacionForm,certificacion)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:43 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/certificaciones/editarCertificacion.scala.html
                    HASH: cdf4e58202f934506eff50e161d46685264b3cfc
                    MATRIX: 839->1|1000->159|1014->166|1098->170|1149->186|1163->192|1236->244|1303->88|1335->112|1409->69|1437->156|1465->280|1502->283|1514->288|1592->358|1631->360|2677->1370|2698->1381|2789->1449|2975->1599|2995->1610|3066->1659|3249->1807|3288->1837|3328->1839|3403->1879|3417->1884|3452->1897|3495->1909|3536->1915|3550->1921|3657->2018|3698->2020|3740->2027|3817->2082|3856->2086|3869->2091|3957->2157|3996->2161|4009->2166|4103->2238|4162->2261|4176->2266|4242->2310|4311->2343|4325->2348|4396->2397|4463->2428|4477->2433|4544->2478|4617->2515|4639->2528|4675->2542|4772->2608
                    LINES: 26->1|29->5|29->5|31->5|32->6|32->6|32->6|33->3|33->3|34->1|35->3|37->7|39->9|39->9|39->9|39->9|67->37|67->37|67->37|75->45|75->45|75->45|83->53|83->53|83->53|85->55|85->55|85->55|87->57|90->60|90->60|90->60|90->60|93->63|93->63|94->64|94->64|94->64|95->65|95->65|95->65|97->67|97->67|97->67|98->68|98->68|98->68|99->69|99->69|99->69|100->70|100->70|100->70|105->75
                    -- GENERATED --
                */
            