
package views.html.compras.solicitudes.modales

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
object modalImportarListaProductosCantidades extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[DynamicForm,play.api.templates.HtmlFormat.Appendable] {

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
<form id="myForm" action="/compras/solicitud/importarListaProductos" method="post" enctype="multipart/form-data">	
	<div id="modalEditarCuentaAnalitica" class="contenedorPaginador ajaxPaginador">
		
			<div class="row margin-bottom-10">
				<div class="col-sm-6">
				"""),_display_(Seq[Any](/*17.6*/inputFile(formBuscador("myfile"), 'id -> "myfile"))),format.raw/*17.56*/("""
				"""),_display_(Seq[Any](/*18.6*/inputText(formBuscador("idSol"), 'hidden -> "hidden",'id -> "idSol"))),format.raw/*18.74*/("""
				</div>
				<div class="col-sm-6">
					<a href="/assets/templates/solicitudLineas.xls" style="color:blue;">Descargar Template</a>
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
"""),format.raw/*41.1*/("""{"""),format.raw/*41.2*/("""
	$('#idSol').val($('#id').val());
	var options = """),format.raw/*43.16*/("""{"""),format.raw/*43.17*/(""" 
    beforeSend: function() 
    """),format.raw/*45.5*/("""{"""),format.raw/*45.6*/("""
    	$("#progress").show();
    	//clear everything
    	$("#bar").width('0%');
    	$("#message").html("");
		$("#percent").html("0%");
		$("#procesar").attr('disabled', 'disabled');
    """),format.raw/*52.5*/("""}"""),format.raw/*52.6*/(""",
    uploadProgress: function(event, position, total, percentComplete) 
    """),format.raw/*54.5*/("""{"""),format.raw/*54.6*/("""
    	$("#bar").width(percentComplete+'%');
    	$("#percent").html(percentComplete+'%');

    
    """),format.raw/*59.5*/("""}"""),format.raw/*59.6*/(""",
    success: function() 
    """),format.raw/*61.5*/("""{"""),format.raw/*61.6*/("""	 
        $("#bar").width('100%');
    	$("#percent").html('100%');

    """),format.raw/*65.5*/("""}"""),format.raw/*65.6*/(""",
	complete: function(response) 
	"""),format.raw/*67.2*/("""{"""),format.raw/*67.3*/("""
		$("#message").html("<font color='green'>"+response.responseText+"</font>");
	"""),format.raw/*69.2*/("""}"""),format.raw/*69.3*/(""",
	error: function()
	"""),format.raw/*71.2*/("""{"""),format.raw/*71.3*/("""
		$("#message").html("<font color='red'> ERROR: unable to upload files</font>");

	"""),format.raw/*74.2*/("""}"""),format.raw/*74.3*/("""
     
"""),format.raw/*76.1*/("""}"""),format.raw/*76.2*/("""; 

     $("#myForm").ajaxForm(options);

"""),format.raw/*80.1*/("""}"""),format.raw/*80.2*/(""");

</script>  
"""))}
    }
    
    def render(formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(formBuscador)
    
    def f:((DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (formBuscador) => apply(formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:46 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/solicitudes/modales/modalImportarListaProductosCantidades.scala.html
                    HASH: 7a639cf7fcaa9a2dfac1c81a7ec6fca72cd50682
                    MATRIX: 839->1|968->47|1000->71|1074->28|1102->115|1143->130|1170->131|1286->220|1314->221|1352->232|1380->233|1530->355|1559->356|1591->362|1618->363|1716->434|1744->435|1781->445|1809->446|1897->507|1925->508|1986->533|2001->539|2076->592|2392->873|2464->923|2505->929|2595->997|3152->1527|3180->1528|3258->1578|3287->1579|3348->1613|3376->1614|3592->1803|3620->1804|3724->1881|3752->1882|3879->1982|3907->1983|3965->2014|3993->2015|4094->2089|4122->2090|4183->2124|4211->2125|4318->2205|4346->2206|4395->2228|4423->2229|4534->2313|4562->2314|4596->2321|4624->2322|4693->2364|4721->2365
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|34->6|34->6|34->6|34->6|35->7|35->7|35->7|35->7|36->8|36->8|36->8|36->8|39->11|39->11|39->11|45->17|45->17|46->18|46->18|69->41|69->41|71->43|71->43|73->45|73->45|80->52|80->52|82->54|82->54|87->59|87->59|89->61|89->61|93->65|93->65|95->67|95->67|97->69|97->69|99->71|99->71|102->74|102->74|104->76|104->76|108->80|108->80
                    -- GENERATED --
                */
            