
package views.html.dashboard.autorizados

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
object tabsAutorizados extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Boolean,Form[Autorizado],Autorizado,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formularioCarga: Boolean, autorizadoForm: Form[Autorizado] = null,autorizado:Autorizado= null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.97*/("""
<hr />
<input type="hidden" id="formularioCarga" value=""""),_display_(Seq[Any](/*3.51*/formularioCarga)),format.raw/*3.66*/(""""/>

<ul id="ordenTab" class="nav nav-tabs">
	<li class="active"><a class="tabLineas" href="#contenedorLineas" data-toggle="tab">Detalles</a></li>
	"""),_display_(Seq[Any](/*7.3*/if(formularioCarga && autorizado != null)/*7.44*/{_display_(Seq[Any](format.raw/*7.45*/("""
		<li><a class="tabCarga" href="#contenedorCarga" data-toggle="tab">Carga Autorizado por OP</a></li>
		<li><a class="tabCargaActa" href="#contenedorCargaActa" data-toggle="tab">Carga Autorizado por Acta</a></li>
	""")))})),format.raw/*10.3*/("""
	<li><a class="tabResumen" href="#contenedorResumen" data-toggle="tab">Resumen</a></li>
	<li><a class="tabNota" href="#contenedorNotas" data-toggle="tab">Notas</a></li>
</ul>



<div class="tab-content">

	<div class="tab-pane active" id="contenedorLineas">
		"""),_display_(Seq[Any](/*20.4*/views/*20.9*/.html.dashboard.autorizados.contenidoTabLineas(formularioCarga, autorizadoForm,autorizado))),format.raw/*20.99*/("""	
	</div>
	
	"""),_display_(Seq[Any](/*23.3*/if(formularioCarga && autorizado != null)/*23.44*/{_display_(Seq[Any](format.raw/*23.45*/("""
		<div class="tab-pane" id="contenedorCarga">
			 
		</div>
		<div class="tab-pane" id="contenedorCargaActa">
			 
		</div>
	""")))})),format.raw/*30.3*/("""
	
	<div class="tab-pane" id="contenedorResumen">
		<div id="contenedorResumenDiv"></div>
	</div>
	
	<div class="tab-pane" id="contenedorNotas">
		"""),_display_(Seq[Any](/*37.4*/if(formularioCarga)/*37.23*/{_display_(Seq[Any](format.raw/*37.24*/("""
			<textarea name="descripcion" class="form-control" rows="5">"""),_display_(Seq[Any](/*38.64*/autorizadoForm/*38.78*/.field("notas").value)),format.raw/*38.99*/("""</textarea>
		""")))}/*39.5*/else/*39.10*/{_display_(Seq[Any](format.raw/*39.11*/("""
			<textarea name="descripcion" disabled="disabled" class="form-control" rows="5">"""),_display_(Seq[Any](/*40.84*/autorizadoForm/*40.98*/.field("notas").value)),format.raw/*40.119*/("""</textarea>
		""")))})),format.raw/*41.4*/("""
	</div>

</div>
<script>
$( function () """),format.raw/*46.16*/("""{"""),format.raw/*46.17*/("""
	
"""),format.raw/*48.1*/("""}"""),format.raw/*48.2*/(""");
</script>"""))}
    }
    
    def render(formularioCarga:Boolean,autorizadoForm:Form[Autorizado],autorizado:Autorizado): play.api.templates.HtmlFormat.Appendable = apply(formularioCarga,autorizadoForm,autorizado)
    
    def f:((Boolean,Form[Autorizado],Autorizado) => play.api.templates.HtmlFormat.Appendable) = (formularioCarga,autorizadoForm,autorizado) => apply(formularioCarga,autorizadoForm,autorizado)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:58 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/autorizados/tabsAutorizados.scala.html
                    HASH: 453c36656dba70289d4f6b328823ae854d76a2d9
                    MATRIX: 835->1|1024->96|1117->154|1153->169|1336->318|1385->359|1423->360|1669->575|1966->837|1979->842|2091->932|2140->946|2190->987|2229->988|2387->1115|2570->1263|2598->1282|2637->1283|2737->1347|2760->1361|2803->1382|2836->1398|2849->1403|2888->1404|3008->1488|3031->1502|3075->1523|3121->1538|3190->1579|3219->1580|3249->1583|3277->1584
                    LINES: 26->1|29->1|31->3|31->3|35->7|35->7|35->7|38->10|48->20|48->20|48->20|51->23|51->23|51->23|58->30|65->37|65->37|65->37|66->38|66->38|66->38|67->39|67->39|67->39|68->40|68->40|68->40|69->41|74->46|74->46|76->48|76->48
                    -- GENERATED --
                */
            