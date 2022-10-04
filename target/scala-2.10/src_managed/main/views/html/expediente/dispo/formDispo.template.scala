
package views.html.expediente.dispo

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
object formDispo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Dispo],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(dispoForm: Form[Dispo]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.26*/("""
"""),format.raw/*3.70*/(""" 


	<div class="row menu-acciones">
		<div class="col-sm-10">
			<button type="submit" class="btn btn-default" title="Guardar Dispo"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>	
	    	<a href=""""),_display_(Seq[Any](/*9.17*/controllers/*9.28*/.expediente.routes.DisposController.index())),format.raw/*9.71*/("""" title="Cancelar operación" class="btn btn-default"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
	    </div>
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*12.14*/controllers/*12.25*/.expediente.routes.DisposController.index())),format.raw/*12.68*/("""" title="Volver al listado" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
		</div>
	</div>

	<div class="row">
		"""),_display_(Seq[Any](/*17.4*/inputText(dispoForm("id"), 'type -> "hidden", 'id -> "dispoId"))),format.raw/*17.67*/("""
		<div class="col-sm-2">
			"""),_display_(Seq[Any](/*19.5*/if(dispoForm("id").value == null)/*19.38*/{_display_(Seq[Any](format.raw/*19.39*/(""" 
				
					 
					<label for="inputNombre" class="control-label">Numero</label> 
					<div class="input-group """),_display_(Seq[Any](/*23.31*/if(dispoForm.error("numero") != null)/*23.68*/ {_display_(Seq[Any](format.raw/*23.70*/("""has-error""")))}/*23.80*/else/*23.84*/{_display_(Seq[Any](format.raw/*23.85*/("""has-required""")))})),format.raw/*23.98*/("""">
					"""),_display_(Seq[Any](/*24.7*/inputText(dispoForm("numero"), 'class -> "form-control inputNumericMask"))),format.raw/*24.80*/("""
					<span class="input-group-addon">
					<a href="#" id="getLastNumeroDispo" data-url=""""),_display_(Seq[Any](/*26.53*/controllers/*26.64*/.expediente.routes.DisposController.getLastNumeroDispo())),format.raw/*26.120*/(""""/><i class="glyphicon glyphicon-record"></i></a></span>
					</div>
					"""),_display_(Seq[Any](/*28.7*/dispoForm("numero")/*28.26*/.error.map/*28.36*/{ error =>_display_(Seq[Any](format.raw/*28.46*/("""
						<div class="text-error">"""),_display_(Seq[Any](/*29.32*/error/*29.37*/.message)),format.raw/*29.45*/("""</div>
					""")))})),format.raw/*30.7*/("""
					<div class="hide errorOp text-error"></div>
					 
				 
			""")))}/*34.5*/else/*34.9*/{_display_(Seq[Any](format.raw/*34.10*/("""
				 
				<div class="form-group">
					<label class="control-label">Numero</label>
					 
					"""),_display_(Seq[Any](/*39.7*/inputText(dispoForm("numero"), 'class -> "form-control",'readOnly -> "readOnly"))),format.raw/*39.87*/(""" 
				</div>
				
			""")))})),format.raw/*42.5*/("""
		</div>
		<div class="col-sm-2">
			<label for="expediente" class="control-label">Expediente</label> 
			<div class="input-group """),_display_(Seq[Any](/*46.29*/if(dispoForm.error("expediente_id") != null)/*46.73*/ {_display_(Seq[Any](format.raw/*46.75*/("""has-error""")))}/*46.85*/else/*46.89*/{_display_(Seq[Any](format.raw/*46.90*/("""has-required""")))})),format.raw/*46.103*/("""">
				"""),_display_(Seq[Any](/*47.6*/inputText(dispoForm("expediente.expedienteEjercicio"),'class -> "form-control", 'id -> "expediente"))),format.raw/*47.106*/("""
				"""),_display_(Seq[Any](/*48.6*/inputText(dispoForm("expediente_id"),'hidden -> "hidden", 'id -> "expediente_id"))),format.raw/*48.87*/("""

				<span class="input-group-addon"><a href="#" id="searchExpediente" 
				data-title="Selección de expediente" data-url=""""),_display_(Seq[Any](/*51.53*/controllers/*51.64*/.expediente.routes.ExpedientesController.modalBuscar())),format.raw/*51.118*/("""" data-height="650" data-width="700" data-listen="modal.seleccion.expediente.simple" data-label="#expediente" data-field="#expediente_id"><i class="glyphicon glyphicon-search"></i></a></span>
				
			</div>
			"""),_display_(Seq[Any](/*54.5*/dispoForm("expediente_id")/*54.31*/.error.map/*54.41*/{ error =>_display_(Seq[Any](format.raw/*54.51*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*55.31*/error/*55.36*/.message)),format.raw/*55.44*/("""</div>
				""")))})),format.raw/*56.6*/("""
		</div>
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*59.28*/if(dispoForm.error("fecha") != null)/*59.64*/ {_display_(Seq[Any](format.raw/*59.66*/("""has-error""")))}/*59.76*/else/*59.80*/{_display_(Seq[Any](format.raw/*59.81*/("""has-required""")))})),format.raw/*59.94*/("""">
				<label for="fecha" class="control-label">Fecha</label> 
				"""),_display_(Seq[Any](/*61.6*/inputText(dispoForm("fecha"),'class -> "form-control date", 'id -> "fecha"))),format.raw/*61.81*/("""
				"""),_display_(Seq[Any](/*62.6*/dispoForm("fecha")/*62.24*/.error.map/*62.34*/{ error =>_display_(Seq[Any](format.raw/*62.44*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*63.31*/error/*63.36*/.message)),format.raw/*63.44*/("""</div>
				""")))})),format.raw/*64.6*/("""
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*68.28*/if(dispoForm.error("organigrama_id") != null)/*68.73*/ {_display_(Seq[Any](format.raw/*68.75*/("""has-error""")))}/*68.85*/else/*68.89*/{_display_(Seq[Any](format.raw/*68.90*/("""has-required""")))})),format.raw/*68.103*/("""">
				<label for=""""),_display_(Seq[Any](/*69.18*/dispoForm("organigrama_id"))),format.raw/*69.45*/("""" class="control-label">Institucion</label>
				"""),_display_(Seq[Any](/*70.6*/select(dispoForm("organigrama_id"), options("1"->"PARQUE","3"->"HEARM"), 
				'class -> "form-control select", 'id -> "organigrama_id"))),format.raw/*71.62*/("""
				"""),_display_(Seq[Any](/*72.6*/dispoForm("organigrama_id")/*72.33*/.error.map/*72.43*/{ error =>_display_(Seq[Any](format.raw/*72.53*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*73.31*/error/*73.36*/.message)),format.raw/*73.44*/("""</div>
				""")))})),format.raw/*74.6*/("""
			</div>
		</div>
		
	</div>
	<div class="row">
		<div class="col-sm-7">
			<div class="form-group">
				<label for="inputNombre" class="control-label">Descripción</label> 
				"""),_display_(Seq[Any](/*83.6*/inputText(dispoForm("descripcion"), 'class -> "form-control"))),format.raw/*83.67*/("""
				 
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="col-sm-7">
			<div class="form-group">
				<label for="inputNombre" class="control-label">Motivo Baja</label> 
				"""),_display_(Seq[Any](/*93.6*/inputText(dispoForm("motivo_baja"), 'class -> "form-control"))),format.raw/*93.67*/("""
				 
			</div>
		</div>
	</div>
	
<script>
$( function()"""),format.raw/*100.14*/("""{"""),format.raw/*100.15*/("""
	
	$('#getLastNumeroDispo').click( function() """),format.raw/*102.45*/("""{"""),format.raw/*102.46*/("""  
		if($("#expediente_id").val() == "")"""),format.raw/*103.38*/("""{"""),format.raw/*103.39*/("""
			alert ("Debe tener asignado un expediente para poder sugerir el N° disposicion.");
		"""),format.raw/*105.3*/("""}"""),format.raw/*105.4*/("""else"""),format.raw/*105.8*/("""{"""),format.raw/*105.9*/(""" 
			if($("#organigrama_id").val() == "")"""),format.raw/*106.40*/("""{"""),format.raw/*106.41*/("""
				alert ("Debe tener asignado una institucion para poder sugerir el N° disposicion.");
			"""),format.raw/*108.4*/("""}"""),format.raw/*108.5*/("""else"""),format.raw/*108.9*/("""{"""),format.raw/*108.10*/(""" 
				var url = $(this).attr("data-url");
				var data = $("#expediente_id").serialize();
				data += "&"+$("#organigrama_id").serialize();
				 
				$.post(url, data, function(data)"""),format.raw/*113.37*/("""{"""),format.raw/*113.38*/("""
					if(data.success) """),format.raw/*114.23*/("""{"""),format.raw/*114.24*/("""
						$(".errorOp").html("N° sugerido: "+data.numero);
						$(".errorOp").removeClass("hide");
					"""),format.raw/*117.6*/("""}"""),format.raw/*117.7*/(""" else """),format.raw/*117.13*/("""{"""),format.raw/*117.14*/("""
						$(".errorOp").html(data.message)
						$(".errorOp").removeClass("hide");
					"""),format.raw/*120.6*/("""}"""),format.raw/*120.7*/("""
				"""),format.raw/*121.5*/("""}"""),format.raw/*121.6*/(""");
			"""),format.raw/*122.4*/("""}"""),format.raw/*122.5*/(""" 
		"""),format.raw/*123.3*/("""}"""),format.raw/*123.4*/("""
	"""),format.raw/*124.2*/("""}"""),format.raw/*124.3*/(""");
	
	$('#searchExpediente').modalSearch();	
"""),format.raw/*127.1*/("""}"""),format.raw/*127.2*/(""");
</script>	"""))}
    }
    
    def render(dispoForm:Form[Dispo]): play.api.templates.HtmlFormat.Appendable = apply(dispoForm)
    
    def f:((Form[Dispo]) => play.api.templates.HtmlFormat.Appendable) = (dispoForm) => apply(dispoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:36 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/expediente/dispo/formDispo.scala.html
                    HASH: 2b35828e892fd99858d45c14566149ed8e63e9e8
                    MATRIX: 800->1|926->44|958->68|1032->25|1060->112|1311->328|1330->339|1394->382|1596->548|1616->559|1681->602|1854->740|1939->803|2004->833|2046->866|2085->867|2233->979|2279->1016|2319->1018|2348->1028|2361->1032|2400->1033|2445->1046|2489->1055|2584->1128|2711->1219|2731->1230|2810->1286|2920->1361|2948->1380|2967->1390|3015->1400|3083->1432|3097->1437|3127->1445|3171->1458|3256->1525|3268->1529|3307->1530|3440->1628|3542->1708|3595->1730|3763->1862|3816->1906|3856->1908|3885->1918|3898->1922|3937->1923|3983->1936|4026->1944|4149->2044|4190->2050|4293->2131|4454->2256|4474->2267|4551->2321|4797->2532|4832->2558|4851->2568|4899->2578|4966->2609|4980->2614|5010->2622|5053->2634|5151->2696|5196->2732|5236->2734|5265->2744|5278->2748|5317->2749|5362->2762|5465->2830|5562->2905|5603->2911|5630->2929|5649->2939|5697->2949|5764->2980|5778->2985|5808->2993|5851->3005|5959->3077|6013->3122|6053->3124|6082->3134|6095->3138|6134->3139|6180->3152|6236->3172|6285->3199|6369->3248|6526->3383|6567->3389|6603->3416|6622->3426|6670->3436|6737->3467|6751->3472|6781->3480|6824->3492|7039->3672|7122->3733|7342->3918|7425->3979|7512->4037|7542->4038|7618->4085|7648->4086|7717->4126|7747->4127|7864->4216|7893->4217|7925->4221|7954->4222|8024->4263|8054->4264|8175->4357|8204->4358|8236->4362|8266->4363|8477->4545|8507->4546|8559->4569|8589->4570|8719->4672|8748->4673|8783->4679|8813->4680|8927->4766|8956->4767|8989->4772|9018->4773|9052->4779|9081->4780|9113->4784|9142->4785|9172->4787|9201->4788|9274->4833|9303->4834
                    LINES: 26->1|29->3|29->3|30->1|31->3|37->9|37->9|37->9|40->12|40->12|40->12|45->17|45->17|47->19|47->19|47->19|51->23|51->23|51->23|51->23|51->23|51->23|51->23|52->24|52->24|54->26|54->26|54->26|56->28|56->28|56->28|56->28|57->29|57->29|57->29|58->30|62->34|62->34|62->34|67->39|67->39|70->42|74->46|74->46|74->46|74->46|74->46|74->46|74->46|75->47|75->47|76->48|76->48|79->51|79->51|79->51|82->54|82->54|82->54|82->54|83->55|83->55|83->55|84->56|87->59|87->59|87->59|87->59|87->59|87->59|87->59|89->61|89->61|90->62|90->62|90->62|90->62|91->63|91->63|91->63|92->64|96->68|96->68|96->68|96->68|96->68|96->68|96->68|97->69|97->69|98->70|99->71|100->72|100->72|100->72|100->72|101->73|101->73|101->73|102->74|111->83|111->83|121->93|121->93|128->100|128->100|130->102|130->102|131->103|131->103|133->105|133->105|133->105|133->105|134->106|134->106|136->108|136->108|136->108|136->108|141->113|141->113|142->114|142->114|145->117|145->117|145->117|145->117|148->120|148->120|149->121|149->121|150->122|150->122|151->123|151->123|152->124|152->124|155->127|155->127
                    -- GENERATED --
                */
            