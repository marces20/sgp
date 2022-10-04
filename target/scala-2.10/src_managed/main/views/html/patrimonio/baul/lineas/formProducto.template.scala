
package views.html.patrimonio.baul.lineas

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
object formProducto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[RemitoLineaBaul],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[RemitoLineaBaul]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.36*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/if(flash.containsKey("error"))/*5.32*/ {_display_(Seq[Any](format.raw/*5.34*/("""
	<div class="alert alert-danger">
		<i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*7.52*/flash/*7.57*/.get("error"))),format.raw/*7.70*/("""
	</div>
""")))})),format.raw/*9.2*/("""

<div class="row">
	"""),_display_(Seq[Any](/*12.3*/inputText(lineaForm("id"), 'type -> "hidden"))),format.raw/*12.48*/("""
	"""),_display_(Seq[Any](/*13.3*/inputText(lineaForm("remito_baul_id"), 'type -> "hidden"))),format.raw/*13.60*/("""
	
	<div class="col-sm-8">
		<label for="producto_nombre" class="control-label">Producto</label>
		<div class="input-group """),_display_(Seq[Any](/*17.28*/if(lineaForm.error("producto_id") != null)/*17.70*/ {_display_(Seq[Any](format.raw/*17.72*/("""has-error""")))}/*17.83*/else/*17.88*/{_display_(Seq[Any](format.raw/*17.89*/("""has-required""")))})),format.raw/*17.102*/("""">
			
			"""),_display_(Seq[Any](/*19.5*/inputText(lineaForm("producto.nombre"), 'class -> "form-control", 'autofocus -> "autofocus", 'id -> "producto"))),format.raw/*19.116*/("""
			"""),_display_(Seq[Any](/*20.5*/inputText(lineaForm("producto_id"), 'hidden -> "hidden", 'id -> "producto_id"))),format.raw/*20.83*/("""
			<span class="input-group-addon"><a href="#" id="searchProducto" data-title="Selección de producto" data-url=""""),_display_(Seq[Any](/*21.114*/controllers/*21.125*/.compras.routes.ProductosController.modalBuscar())),format.raw/*21.174*/("""" data-height="650" data-width="700" data-listen="modal.seleccion.producto.simple" data-label="#producto" data-field="#producto_id"><i class="glyphicon glyphicon-search"></i></a></span>
		</div>
		"""),_display_(Seq[Any](/*23.4*/lineaForm("producto_id")/*23.28*/.error.map/*23.38*/{ error =>_display_(Seq[Any](format.raw/*23.48*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*24.29*/error/*24.34*/.message)),format.raw/*24.42*/("""</div>
		""")))})),format.raw/*25.4*/("""
	</div>
	
	<div class="col-sm-4">
		<div class="form-group """),_display_(Seq[Any](/*29.27*/if(lineaForm.error("cantidad") != null)/*29.66*/ {_display_(Seq[Any](format.raw/*29.68*/("""has-error""")))}/*29.78*/else/*29.82*/{_display_(Seq[Any](format.raw/*29.83*/("""has-required""")))})),format.raw/*29.96*/("""">
			<label for="inputNombre" class="control-label">Cantidad</label> 
			"""),_display_(Seq[Any](/*31.5*/inputText(lineaForm("cantidad"), 'class -> "form-control", 'id -> "cantidad"))),format.raw/*31.82*/("""
			"""),_display_(Seq[Any](/*32.5*/lineaForm("cantidad")/*32.26*/.error.map/*32.36*/{ error =>_display_(Seq[Any](format.raw/*32.46*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*33.30*/error/*33.35*/.message)),format.raw/*33.43*/("""</div>
			""")))})),format.raw/*34.5*/("""
		</div>
	</div>
</div>

<div class="row form-actions">
    <div class="col-lg-offset-4 col-lg-8">
      <button type="submit" class="btn btn-default"><i class="glyphicon glyphicon-floppy-disk"></i>Guardar</button>	
      <a href="" class="btn btn-default cancelar"><i class="glyphicon glyphicon-floppy-remove"></i>Cancelar</a>
    </div>
</div>
<script>
$( function()"""),format.raw/*46.14*/("""{"""),format.raw/*46.15*/("""
	$("#cantidad").numeric_input();
	$('#searchProducto').modalSearch();
	
	var options = """),format.raw/*50.16*/("""{"""),format.raw/*50.17*/("""
			script:"/suggestProducto/",
			varname:"",
			json:true,
			shownoresults:true,
			maxresults:6,
			callback: function (obj) """),format.raw/*56.29*/("""{"""),format.raw/*56.30*/(""" 
				$("#producto").next().val(obj.id); 
			"""),format.raw/*58.4*/("""}"""),format.raw/*58.5*/("""
		"""),format.raw/*59.3*/("""}"""),format.raw/*59.4*/(""";
	var as_json = new bsn.AutoSuggest('producto', options);
"""),format.raw/*61.1*/("""}"""),format.raw/*61.2*/(""");
</script>	


"""),_display_(Seq[Any](/*65.2*/flash()/*65.9*/.clear())))}
    }
    
    def render(lineaForm:Form[RemitoLineaBaul]): play.api.templates.HtmlFormat.Appendable = apply(lineaForm)
    
    def f:((Form[RemitoLineaBaul]) => play.api.templates.HtmlFormat.Appendable) = (lineaForm) => apply(lineaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/baul/lineas/formProducto.scala.html
                    HASH: f1522b53fcd45a63a17adb74288de7170b02acd9
                    MATRIX: 819->1|956->56|988->80|1062->35|1091->124|1131->130|1169->160|1208->162|1331->250|1344->255|1378->268|1420->280|1480->305|1547->350|1586->354|1665->411|1829->539|1880->581|1920->583|1949->594|1962->599|2001->600|2047->613|2095->626|2229->737|2270->743|2370->821|2522->936|2543->947|2615->996|2850->1196|2883->1220|2902->1230|2950->1240|3016->1270|3030->1275|3060->1283|3102->1294|3203->1359|3251->1398|3291->1400|3320->1410|3333->1414|3372->1415|3417->1428|3529->1505|3628->1582|3669->1588|3699->1609|3718->1619|3766->1629|3833->1660|3847->1665|3877->1673|3920->1685|4329->2066|4358->2067|4478->2159|4507->2160|4670->2295|4699->2296|4773->2343|4801->2344|4832->2348|4860->2349|4948->2410|4976->2411|5032->2432|5047->2439
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|35->7|35->7|35->7|37->9|40->12|40->12|41->13|41->13|45->17|45->17|45->17|45->17|45->17|45->17|45->17|47->19|47->19|48->20|48->20|49->21|49->21|49->21|51->23|51->23|51->23|51->23|52->24|52->24|52->24|53->25|57->29|57->29|57->29|57->29|57->29|57->29|57->29|59->31|59->31|60->32|60->32|60->32|60->32|61->33|61->33|61->33|62->34|74->46|74->46|78->50|78->50|84->56|84->56|86->58|86->58|87->59|87->59|89->61|89->61|93->65|93->65
                    -- GENERATED --
                */
            