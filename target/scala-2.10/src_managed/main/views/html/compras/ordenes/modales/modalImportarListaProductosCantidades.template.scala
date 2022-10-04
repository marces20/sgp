
package views.html.compras.ordenes.modales

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
<form id="myForm" action="/compras/orden/importarListaProductos" method="post" enctype="multipart/form-data">	
	<div id="modalEditarCuentaAnalitica" class="contenedorPaginador ajaxPaginador">
		
			<div class="row margin-bottom-10">
				<div class="col-sm-6">
				"""),_display_(Seq[Any](/*17.6*/inputFile(formBuscador("myfile"), 'id -> "myfile"))),format.raw/*17.56*/("""
				"""),_display_(Seq[Any](/*18.6*/inputText(formBuscador("idOrd"), 'hidden -> "hidden",'id -> "idOrd"))),format.raw/*18.74*/("""
				</div>
				<div class="col-sm-6">
					<a href="/assets/templates/ordenLineas.xls" style="color:blue;">Descargar Template</a>
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
	$('#idOrd').val($('#id').val());
	var options = """),format.raw/*43.16*/("""{"""),format.raw/*43.17*/(""" 
    beforeSend: function() 
    """),format.raw/*45.5*/("""{"""),format.raw/*45.6*/("""
    	$("#progress").show();
    	//clear everything
    	$("#bar").width('0%');
    	$("#message").html("");
		$("#percent").html("0%");
		
		$("#procesar").attr('disabled', 'disabled'); 
    """),format.raw/*53.5*/("""}"""),format.raw/*53.6*/(""",
    uploadProgress: function(event, position, total, percentComplete) 
    """),format.raw/*55.5*/("""{"""),format.raw/*55.6*/("""
    	$("#bar").width(percentComplete+'%');
    	$("#percent").html(percentComplete+'%');

    
    """),format.raw/*60.5*/("""}"""),format.raw/*60.6*/(""",
    success: function() 
    """),format.raw/*62.5*/("""{"""),format.raw/*62.6*/("""
        $("#bar").width('100%');
    	$("#percent").html('100%');

    """),format.raw/*66.5*/("""}"""),format.raw/*66.6*/(""",
	complete: function(response) 
	"""),format.raw/*68.2*/("""{"""),format.raw/*68.3*/("""
		$("#message").html("<font color='green'>"+response.responseText+"</font>");
	"""),format.raw/*70.2*/("""}"""),format.raw/*70.3*/(""",
	error: function()
	"""),format.raw/*72.2*/("""{"""),format.raw/*72.3*/("""
		$("#message").html("<font color='red'> ERROR: unable to upload files</font>");

	"""),format.raw/*75.2*/("""}"""),format.raw/*75.3*/("""
     
"""),format.raw/*77.1*/("""}"""),format.raw/*77.2*/("""; 

     $("#myForm").ajaxForm(options);

"""),format.raw/*81.1*/("""}"""),format.raw/*81.2*/(""");

</script>  
"""))}
    }
    
    def render(formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(formBuscador)
    
    def f:((DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (formBuscador) => apply(formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:44 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/ordenes/modales/modalImportarListaProductosCantidades.scala.html
                    HASH: 13199d6904e943821b3649a11a71e84afb47871d
                    MATRIX: 835->1|964->47|996->71|1070->28|1098->115|1139->130|1166->131|1282->220|1310->221|1348->232|1376->233|1526->355|1555->356|1587->362|1614->363|1712->434|1740->435|1777->445|1805->446|1893->507|1921->508|1982->533|1997->539|2072->592|2384->869|2456->919|2497->925|2587->993|3140->1519|3168->1520|3246->1570|3275->1571|3336->1605|3364->1606|3584->1799|3612->1800|3716->1877|3744->1878|3871->1978|3899->1979|3957->2010|3985->2011|4084->2083|4112->2084|4173->2118|4201->2119|4308->2199|4336->2200|4385->2222|4413->2223|4524->2307|4552->2308|4586->2315|4614->2316|4683->2358|4711->2359
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|34->6|34->6|34->6|34->6|35->7|35->7|35->7|35->7|36->8|36->8|36->8|36->8|39->11|39->11|39->11|45->17|45->17|46->18|46->18|69->41|69->41|71->43|71->43|73->45|73->45|81->53|81->53|83->55|83->55|88->60|88->60|90->62|90->62|94->66|94->66|96->68|96->68|98->70|98->70|100->72|100->72|103->75|103->75|105->77|105->77|109->81|109->81
                    -- GENERATED --
                */
            