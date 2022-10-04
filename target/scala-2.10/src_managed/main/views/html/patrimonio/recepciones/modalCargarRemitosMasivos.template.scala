
package views.html.patrimonio.recepciones

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
object modalCargarRemitosMasivos extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[DynamicForm,Long,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm,id:Long):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.37*/("""
"""),format.raw/*3.70*/(""" 
<style>
form """),format.raw/*5.6*/("""{"""),format.raw/*5.7*/(""" display: block; margin: 20px auto; background: #eee; border-radius: 10px; padding: 15px """),format.raw/*5.96*/("""}"""),format.raw/*5.97*/("""
#progress """),format.raw/*6.11*/("""{"""),format.raw/*6.12*/(""" position:relative; width:400px; border: 1px solid #ddd; padding: 1px; border-radius: 3px; float: left;margin: 0 10px 0 0;"""),format.raw/*6.134*/("""}"""),format.raw/*6.135*/("""
#bar """),format.raw/*7.6*/("""{"""),format.raw/*7.7*/(""" background-color: #B4F5B4; width:0%; height:20px; border-radius: 3px; """),format.raw/*7.78*/("""}"""),format.raw/*7.79*/("""
#percent """),format.raw/*8.10*/("""{"""),format.raw/*8.11*/(""" position:absolute; display:inline-block; top:3px; left:48%; """),format.raw/*8.72*/("""}"""),format.raw/*8.73*/("""
</style>

<script src=""""),_display_(Seq[Any](/*11.15*/routes/*11.21*/.Assets.at("plugins/ajax-file-upload/jquery.form.js"))),format.raw/*11.74*/(""""></script>
<form id="myForm" action="/patrimonio/recepciones/cargarRemitosMasivos" method="post" enctype="multipart/form-data">	
	<div id="" class="contenedorPaginador ajaxPaginador">
		
			<div class="row margin-bottom-10">
				<div class="col-sm-6">
					"""),_display_(Seq[Any](/*17.7*/inputFile(formBuscador("myfile"), 'id -> "myfile"))),format.raw/*17.57*/("""
					<input type="hidden" id="idRecepcion" name="idRecepcion" value=""""),_display_(Seq[Any](/*18.71*/id)),format.raw/*18.73*/("""" />
				 
				</div>
				<div class="col-sm-6">
					<a href="/assets/templates/remitosMasivos.xls" style="color:blue;">Descargar Template</a>
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
"""),format.raw/*42.1*/("""{"""),format.raw/*42.2*/("""
	 
	var options = """),format.raw/*44.16*/("""{"""),format.raw/*44.17*/(""" 
    beforeSend: function() 
    """),format.raw/*46.5*/("""{"""),format.raw/*46.6*/("""
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
    
    def render(formBuscador:DynamicForm,id:Long): play.api.templates.HtmlFormat.Appendable = apply(formBuscador,id)
    
    def f:((DynamicForm,Long) => play.api.templates.HtmlFormat.Appendable) = (formBuscador,id) => apply(formBuscador,id)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:31 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/recepciones/modalCargarRemitosMasivos.scala.html
                    HASH: 93f5d687a2d24de6369009c550f2071fe17a1703
                    MATRIX: 827->1|964->55|996->79|1070->36|1098->123|1139->138|1166->139|1282->228|1310->229|1348->240|1376->241|1526->363|1555->364|1587->370|1614->371|1712->442|1740->443|1777->453|1805->454|1893->515|1921->516|1982->541|1997->547|2072->600|2366->859|2438->909|2545->980|2569->982|3135->1521|3163->1522|3210->1541|3239->1542|3300->1576|3328->1577|3544->1766|3572->1767|3676->1844|3704->1845|3831->1945|3859->1946|3917->1977|3945->1978|4044->2050|4072->2051|4133->2085|4161->2086|4268->2166|4296->2167|4345->2189|4373->2190|4484->2274|4512->2275|4546->2282|4574->2283|4643->2325|4671->2326
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|34->6|34->6|34->6|34->6|35->7|35->7|35->7|35->7|36->8|36->8|36->8|36->8|39->11|39->11|39->11|45->17|45->17|46->18|46->18|70->42|70->42|72->44|72->44|74->46|74->46|81->53|81->53|83->55|83->55|88->60|88->60|90->62|90->62|94->66|94->66|96->68|96->68|98->70|98->70|100->72|100->72|103->75|103->75|105->77|105->77|109->81|109->81
                    -- GENERATED --
                */
            