
package views.html.haberes.puestosLaborales.acciones

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
object modalBuscarDatosGananciasEnArchivos extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.29*/("""
"""),format.raw/*3.70*/(""" 
<div id="contenidoGanancias">
<style>
form """),format.raw/*6.6*/("""{"""),format.raw/*6.7*/(""" display: block; margin: 20px auto; background: #eee; border-radius: 10px; padding: 15px """),format.raw/*6.96*/("""}"""),format.raw/*6.97*/("""
#progress """),format.raw/*7.11*/("""{"""),format.raw/*7.12*/(""" position:relative; width:400px; border: 1px solid #ddd; padding: 1px; border-radius: 3px; float: left;margin: 0 10px 0 0;"""),format.raw/*7.134*/("""}"""),format.raw/*7.135*/("""
#bar """),format.raw/*8.6*/("""{"""),format.raw/*8.7*/(""" background-color: #B4F5B4; width:0%; height:20px; border-radius: 3px; """),format.raw/*8.78*/("""}"""),format.raw/*8.79*/("""
#percent """),format.raw/*9.10*/("""{"""),format.raw/*9.11*/(""" position:absolute; display:inline-block; top:3px; left:48%; """),format.raw/*9.72*/("""}"""),format.raw/*9.73*/("""
</style>

<script src=""""),_display_(Seq[Any](/*12.15*/routes/*12.21*/.Assets.at("plugins/ajax-file-upload/jquery.form.js"))),format.raw/*12.74*/(""""></script>
"""),_display_(Seq[Any](/*13.2*/helper/*13.8*/.form(action = controllers.haberes.routes.GananciasAccionesController.buscarDatosGananciasEnArchivos(),'enctype -> "multipart/form-data", 'id -> "myForm")/*13.162*/ {_display_(Seq[Any](format.raw/*13.164*/("""
	
	<div id="mensajes">"""),_display_(Seq[Any](/*15.22*/views/*15.27*/.html.tags.successError())),format.raw/*15.52*/("""</div>
		
	<div id="modalEditarCuentaAnalitica" class="contenedorPaginador ajaxPaginador">
		
			<div class="row margin-bottom-10">
				<div class="col-sm-6">
				"""),_display_(Seq[Any](/*21.6*/inputFile(formBuscador("myfile"), 'id -> "myfile"))),format.raw/*21.56*/("""
				"""),_display_(Seq[Any](/*22.6*/inputText(formBuscador("idSol"), 'hidden -> "hidden",'id -> "idSol"))),format.raw/*22.74*/("""
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
	<div id="message"></div>
""")))})),format.raw/*37.2*/("""
<script>
$(document).ready(function()
"""),format.raw/*40.1*/("""{"""),format.raw/*40.2*/("""
	 
	var options = """),format.raw/*42.16*/("""{"""),format.raw/*42.17*/(""" 
    beforeSend: function() 
    """),format.raw/*44.5*/("""{"""),format.raw/*44.6*/("""
    	$("#progress").show();
    	$("#mensajes").remove();
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
		$("#contenidoGanancias").html(response.responseText);
	"""),format.raw/*69.2*/("""}"""),format.raw/*69.3*/(""",
	error: function()
	"""),format.raw/*71.2*/("""{"""),format.raw/*71.3*/("""
		$("#message").html("<font color='red'> ERROR: unable to upload files</font>");

	"""),format.raw/*74.2*/("""}"""),format.raw/*74.3*/("""
     
"""),format.raw/*76.1*/("""}"""),format.raw/*76.2*/("""; 

     $("#myForm").ajaxForm(options);

"""),format.raw/*80.1*/("""}"""),format.raw/*80.2*/(""");

</script>  

</div>"""))}
    }
    
    def render(formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(formBuscador)
    
    def f:((DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (formBuscador) => apply(formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/puestosLaborales/acciones/modalBuscarDatosGananciasEnArchivos.scala.html
                    HASH: bfb447d2593c6e33723d931aecf74b2ebf5666f6
                    MATRIX: 843->1|972->47|1004->71|1078->28|1106->115|1177->160|1204->161|1320->250|1348->251|1386->262|1414->263|1564->385|1593->386|1625->392|1652->393|1750->464|1778->465|1815->475|1843->476|1931->537|1959->538|2020->563|2035->569|2110->622|2158->635|2172->641|2336->795|2377->797|2437->821|2451->826|2498->851|2697->1015|2769->1065|2810->1071|2900->1139|3281->1489|3347->1528|3375->1529|3422->1548|3451->1549|3512->1583|3540->1584|3786->1803|3814->1804|3918->1881|3946->1882|4073->1982|4101->1983|4159->2014|4187->2015|4286->2087|4314->2088|4375->2122|4403->2123|4488->2181|4516->2182|4565->2204|4593->2205|4704->2289|4732->2290|4766->2297|4794->2298|4863->2340|4891->2341
                    LINES: 26->1|29->3|29->3|30->1|31->3|34->6|34->6|34->6|34->6|35->7|35->7|35->7|35->7|36->8|36->8|36->8|36->8|37->9|37->9|37->9|37->9|40->12|40->12|40->12|41->13|41->13|41->13|41->13|43->15|43->15|43->15|49->21|49->21|50->22|50->22|65->37|68->40|68->40|70->42|70->42|72->44|72->44|80->52|80->52|82->54|82->54|87->59|87->59|89->61|89->61|93->65|93->65|95->67|95->67|97->69|97->69|99->71|99->71|102->74|102->74|104->76|104->76|108->80|108->80
                    -- GENERATED --
                */
            