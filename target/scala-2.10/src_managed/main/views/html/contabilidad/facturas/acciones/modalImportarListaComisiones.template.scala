
package views.html.contabilidad.facturas.acciones

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
object modalImportarListaComisiones extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.29*/("""
"""),format.raw/*3.70*/(""" 
<style>
form """),format.raw/*5.6*/("""{"""),format.raw/*5.7*/(""" display: block; margin: 20px auto; background: #eee; border-radius: 10px; padding: 15px """),format.raw/*5.96*/("""}"""),format.raw/*5.97*/("""
#progress """),format.raw/*6.11*/("""{"""),format.raw/*6.12*/(""" position:relative; width:400px; border: 1px solid #ddd; padding: 1px; border-radius: 3px; float: left;margin: 0 10px 0 0;"""),format.raw/*6.134*/("""}"""),format.raw/*6.135*/("""
#bar """),format.raw/*7.6*/("""{"""),format.raw/*7.7*/(""" background-color: #B4F5B4; width:0%; height:20px; border-radius: 3px; """),format.raw/*7.78*/("""}"""),format.raw/*7.79*/("""
#percent """),format.raw/*8.10*/("""{"""),format.raw/*8.11*/(""" position:absolute; display:inline-block; top:3px; left:48%; """),format.raw/*8.72*/("""}"""),format.raw/*8.73*/("""
</style>

<script src=""""),_display_(Seq[Any](/*11.15*/routes/*11.21*/.Assets.at("plugins/ajax-file-upload/jquery.form.js"))),format.raw/*11.74*/(""""></script>


<form id="myForm" action=""""),_display_(Seq[Any](/*14.28*/controllers/*14.39*/.contabilidad.routes.FacturasAccionesController.importarListaComisiones())),format.raw/*14.112*/("""" method="post" enctype="multipart/form-data">	
	<div id="" class="contenedorPaginador ajaxPaginador">
		
			<div class="row margin-bottom-10">
				<div class="col-sm-6">
				"""),_display_(Seq[Any](/*19.6*/inputFile(formBuscador("myfile"), 'id -> "myfile"))),format.raw/*19.56*/("""
				"""),_display_(Seq[Any](/*20.6*/inputText(formBuscador("idFac"), 'hidden -> "hidden",'id -> "idFac"))),format.raw/*20.74*/("""
				</div>
				<div class="col-sm-6">
					<a href="/assets/templates/comisiones.xls" style="color:blue;">Descargar Template</a>
				</div>
			</div>
		    <div class="row margin-bottom-10">
		    	<div class="col-sm-12">
		    		<input type="submit" class="btn btn-default" id="procesar" value="Procesar" />
		    		<div id="progress">
						<div id="bar"></div>
						<div id="percent">0%</div >
					</div>
		    	</div>
		    </div>
	</div> 
</form>

    
<div id="message"></div>

<script>
$(document).ready(function()
"""),format.raw/*43.1*/("""{"""),format.raw/*43.2*/("""
	$('#idFac').val($('#facturaId').val());
	var options = """),format.raw/*45.16*/("""{"""),format.raw/*45.17*/(""" 
    beforeSend: function() 
    """),format.raw/*47.5*/("""{"""),format.raw/*47.6*/("""
    	$("#progress").show();
    	//clear everything
    	$("#bar").width('0%');
    	$("#message").html("");
		$("#percent").html("0%");
		$("#procesar").attr('disabled', 'disabled');
    """),format.raw/*54.5*/("""}"""),format.raw/*54.6*/(""",
    uploadProgress: function(event, position, total, percentComplete) 
    """),format.raw/*56.5*/("""{"""),format.raw/*56.6*/("""
    	$("#bar").width(percentComplete+'%');
    	$("#percent").html(percentComplete+'%');

    
    """),format.raw/*61.5*/("""}"""),format.raw/*61.6*/(""",
    success: function() 
    """),format.raw/*63.5*/("""{"""),format.raw/*63.6*/("""
        $("#bar").width('100%');
    	$("#percent").html('100%');

    """),format.raw/*67.5*/("""}"""),format.raw/*67.6*/(""",
	complete: function(response) 
	"""),format.raw/*69.2*/("""{"""),format.raw/*69.3*/("""
		$("#message").html("<font color='green'>"+response.responseText+"</font>");
	"""),format.raw/*71.2*/("""}"""),format.raw/*71.3*/(""",
	error: function()
	"""),format.raw/*73.2*/("""{"""),format.raw/*73.3*/("""
		$("#message").html("<font color='red'> ERROR: unable to upload files</font>");

	"""),format.raw/*76.2*/("""}"""),format.raw/*76.3*/("""
     
"""),format.raw/*78.1*/("""}"""),format.raw/*78.2*/("""; 

     $("#myForm").ajaxForm(options);

"""),format.raw/*82.1*/("""}"""),format.raw/*82.2*/(""");

</script>  
"""))}
    }
    
    def render(formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(formBuscador)
    
    def f:((DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (formBuscador) => apply(formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:40 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/facturas/acciones/modalImportarListaComisiones.scala.html
                    HASH: d83d4773e596e2508ec4409fb52cdfb113f5dd76
                    MATRIX: 833->1|962->47|994->71|1068->28|1096->115|1137->130|1164->131|1280->220|1308->221|1346->232|1374->233|1524->355|1553->356|1585->362|1612->363|1710->434|1738->435|1775->445|1803->446|1891->507|1919->508|1980->533|1995->539|2070->592|2147->633|2167->644|2263->717|2474->893|2546->943|2587->949|2677->1017|3229->1542|3257->1543|3342->1600|3371->1601|3432->1635|3460->1636|3676->1825|3704->1826|3808->1903|3836->1904|3963->2004|3991->2005|4049->2036|4077->2037|4176->2109|4204->2110|4265->2144|4293->2145|4400->2225|4428->2226|4477->2248|4505->2249|4616->2333|4644->2334|4678->2341|4706->2342|4775->2384|4803->2385
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|34->6|34->6|34->6|34->6|35->7|35->7|35->7|35->7|36->8|36->8|36->8|36->8|39->11|39->11|39->11|42->14|42->14|42->14|47->19|47->19|48->20|48->20|71->43|71->43|73->45|73->45|75->47|75->47|82->54|82->54|84->56|84->56|89->61|89->61|91->63|91->63|95->67|95->67|97->69|97->69|99->71|99->71|101->73|101->73|104->76|104->76|106->78|106->78|110->82|110->82
                    -- GENERATED --
                */
            