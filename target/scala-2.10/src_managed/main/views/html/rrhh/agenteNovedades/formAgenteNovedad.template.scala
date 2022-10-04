
package views.html.rrhh.agenteNovedades

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
object formAgenteNovedad extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[AgenteNovedad],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[AgenteNovedad]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.34*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/if(flash.containsKey("error"))/*5.32*/ {_display_(Seq[Any](format.raw/*5.34*/("""
	<div class="alert alert-danger">
		<i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*7.52*/flash/*7.57*/.get("error"))),format.raw/*7.70*/("""
	</div>
""")))})),format.raw/*9.2*/("""

<div class="row">
	"""),_display_(Seq[Any](/*12.3*/inputText(lineaForm("agente_id"), 'type -> "hidden"))),format.raw/*12.55*/("""
	
	<div class="col-sm-2">
		<div class="form-group """),_display_(Seq[Any](/*15.27*/if(lineaForm.error("fecha_inicio") != null)/*15.70*/ {_display_(Seq[Any](format.raw/*15.72*/("""has-error""")))}/*15.82*/else/*15.86*/{_display_(Seq[Any](format.raw/*15.87*/("""has-required""")))})),format.raw/*15.100*/("""">
			<label for="inputFinicio" class="control-label">Fecha</label> 
			"""),_display_(Seq[Any](/*17.5*/inputText(lineaForm("fecha_inicio"), 'class -> "form-control", 'id -> "fecha_inicio"))),format.raw/*17.90*/("""
			"""),_display_(Seq[Any](/*18.5*/lineaForm("fecha_inicio")/*18.30*/.error.map/*18.40*/{ error =>_display_(Seq[Any](format.raw/*18.50*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*19.30*/error/*19.35*/.message)),format.raw/*19.43*/("""</div>
			""")))})),format.raw/*20.5*/("""
		</div>
	</div>
	
	<div class="col-sm-3">
		<div class="form-group """),_display_(Seq[Any](/*25.27*/if(lineaForm.error("carga_horaria") != null)/*25.71*/ {_display_(Seq[Any](format.raw/*25.73*/("""has-error""")))}/*25.83*/else/*25.87*/{_display_(Seq[Any](format.raw/*25.88*/("""has-required""")))})),format.raw/*25.101*/("""">
			<label for="carga horaria" class="control-label">Horas Semanales</label> 
			"""),_display_(Seq[Any](/*27.5*/inputText(lineaForm("carga_horaria"), 'class -> "form-control", 'id -> "carga_horaria"))),format.raw/*27.92*/("""
			"""),_display_(Seq[Any](/*28.5*/lineaForm("carga_horaria")/*28.31*/.error.map/*28.41*/{ error =>_display_(Seq[Any](format.raw/*28.51*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*29.30*/error/*29.35*/.message)),format.raw/*29.43*/("""</div>
			""")))})),format.raw/*30.5*/("""
		</div>
	</div>
</div>
<div class="row">
	<div class="col-sm-4">
		<div class="form-group """),_display_(Seq[Any](/*36.27*/if(lineaForm.error("tipo_novedad_agente_id") != null)/*36.80*/ {_display_(Seq[Any](format.raw/*36.82*/("""has-error""")))}/*36.92*/else/*36.96*/{_display_(Seq[Any](format.raw/*36.97*/("""has-required""")))})),format.raw/*36.110*/("""">
			<label for=""""),_display_(Seq[Any](/*37.17*/lineaForm("tipo_novedad_agente_id"))),format.raw/*37.52*/("""" class="control-label">Tipo Modificacion</label>
			"""),_display_(Seq[Any](/*38.5*/select(lineaForm("tipo_novedad_agente_id"), 
			TipoNovedadAgente.find.orderBy("id asc").findList().map { p => p.id.toString -> p.nombre}, 
			'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*40.64*/("""
			
			"""),_display_(Seq[Any](/*42.5*/lineaForm("tipo_novedad_agente_id")/*42.40*/.error.map/*42.50*/{ error =>_display_(Seq[Any](format.raw/*42.60*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*43.30*/error/*43.35*/.message)),format.raw/*43.43*/("""</div>
			""")))})),format.raw/*44.5*/("""
		</div>
	</div>
	
	<div class="col-sm-4">
		<div class="form-group """),_display_(Seq[Any](/*49.27*/if(lineaForm.error("escala_laboral_id") != null)/*49.75*/ {_display_(Seq[Any](format.raw/*49.77*/("""has-error""")))}/*49.87*/else/*49.91*/{_display_(Seq[Any](format.raw/*49.92*/("""has-required""")))})),format.raw/*49.105*/("""">
			<label for=""""),_display_(Seq[Any](/*50.17*/lineaForm("escala_laboral_id"))),format.raw/*50.47*/("""" class="control-label">Agrupamiento</label>
			"""),_display_(Seq[Any](/*51.5*/select(lineaForm("escala_laboral_id"), 
			models.haberes.EscalaLaboral.find.orderBy("id asc").findList().map { p => p.id.toString -> p.nombre}, 
			'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*53.64*/("""
			
			"""),_display_(Seq[Any](/*55.5*/lineaForm("escala_laboral_id")/*55.35*/.error.map/*55.45*/{ error =>_display_(Seq[Any](format.raw/*55.55*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*56.30*/error/*56.35*/.message)),format.raw/*56.43*/("""</div>
			""")))})),format.raw/*57.5*/("""
		</div>
	</div>
	<div class="col-sm-3">
		<label class="control-label">Categoria Interna</label>
			<div class="input-group """),_display_(Seq[Any](/*62.29*/if(lineaForm.error("categoria_laboral_id") != null)/*62.80*/ {_display_(Seq[Any](format.raw/*62.82*/("""has-error""")))}/*62.92*/else/*62.96*/{_display_(Seq[Any](format.raw/*62.97*/("""has-required""")))})),format.raw/*62.110*/("""">
				"""),_display_(Seq[Any](/*63.6*/inputText(lineaForm("categoriaLaboral.nombre"), 'name -> "", 'class -> "form-control", 'id -> "categoria_laboral"))),format.raw/*63.120*/("""
				"""),_display_(Seq[Any](/*64.6*/inputText(lineaForm("categoria_laboral_id"), 'hidden -> "hidden", 'id -> "categoria_laboral_id"))),format.raw/*64.102*/("""
				<span class="input-group-addon">
				<a href="#" class="searchModal" id="searchCategoriaLaboral" 
						 	data-title="Selección de categoria" 
						 	data-url=""""),_display_(Seq[Any](/*68.20*/controllers/*68.31*/.haberes.routes.CategoriasLaboralesController.modalBuscar())),format.raw/*68.90*/("""" 
						 	data-height="650" data-width="700" 
						 	data-listen="modal.seleccion.categoriaLaboral.simple" 
						 	data-label="#categoria_laboral" data-field="#categoria_laboral_id">
				<i class="glyphicon glyphicon-search"></i></a></span>
			</div>
			"""),_display_(Seq[Any](/*74.5*/lineaForm("categoria_laboral_id")/*74.38*/.error.map/*74.48*/{ error =>_display_(Seq[Any](format.raw/*74.58*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*75.30*/error/*75.35*/.message)),format.raw/*75.43*/("""</div>
			""")))})),format.raw/*76.5*/("""
	</div> 
</div>	

<div class="row">
	

	<div class="col-sm-8">
		<div class="form-group">
			<label for="inputNota" class="control-label">Observacion</label> 
			"""),_display_(Seq[Any](/*86.5*/inputText(lineaForm("observaciones"), 'class -> "form-control"))),format.raw/*86.68*/("""
		</div>
	</div>
</div>
<div class="row">
	<div class="col-sm-8">
		<div class="form-group">
			<label for="inputNota" class="control-label">Situación Contractual</label> 
			"""),_display_(Seq[Any](/*94.5*/inputText(lineaForm("situacion"), 'class -> "form-control"))),format.raw/*94.64*/("""
		</div>
	</div>
</div>

<div class="row form-actions">
    <div class="col-lg-offset-4 col-lg-8">
    	<a href="" class="btn btn-default cancelar"><i class="glyphicon glyphicon-floppy-remove"></i>Cancelar</a>
     	<button type="submit" class="btn btn-default"><i class="glyphicon glyphicon-floppy-disk"></i>Guardar</button>	
    </div>
</div>
<script>
$( function()"""),format.raw/*106.14*/("""{"""),format.raw/*106.15*/("""
	$("#fecha_inicio").mask("99/99/9999");
	$("#carga_horaria").mask("99");
	$('#searchCategoriaLaboral').modalSearch();
	if($("#categoria_laboral").length)"""),format.raw/*110.36*/("""{"""),format.raw/*110.37*/("""
		var options = """),format.raw/*111.17*/("""{"""),format.raw/*111.18*/("""
				script:"/haberes/categoriaLaboral/suggestCategoriaLaboral/",
				varname:"",
				json:true,
				shownoresults:true,
				maxresults:6,
				callback: function (obj) """),format.raw/*117.30*/("""{"""),format.raw/*117.31*/(""" 
											$("#categoria_laboral_id").val(obj.id); 
										 """),format.raw/*119.12*/("""}"""),format.raw/*119.13*/("""
			"""),format.raw/*120.4*/("""}"""),format.raw/*120.5*/(""";
		var as_json = new bsn.AutoSuggest('categoria_laboral', options);
	"""),format.raw/*122.2*/("""}"""),format.raw/*122.3*/("""
"""),format.raw/*123.1*/("""}"""),format.raw/*123.2*/(""");
</script>	


"""),_display_(Seq[Any](/*127.2*/flash()/*127.9*/.clear())))}
    }
    
    def render(lineaForm:Form[AgenteNovedad]): play.api.templates.HtmlFormat.Appendable = apply(lineaForm)
    
    def f:((Form[AgenteNovedad]) => play.api.templates.HtmlFormat.Appendable) = (lineaForm) => apply(lineaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:31 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agenteNovedades/formAgenteNovedad.scala.html
                    HASH: f2cab63a5e773add729af4dbb5e685a6c5068337
                    MATRIX: 820->1|955->54|987->78|1061->33|1090->122|1130->128|1168->158|1207->160|1330->248|1343->253|1377->266|1419->278|1479->303|1553->355|1645->411|1697->454|1737->456|1766->466|1779->470|1818->471|1864->484|1974->559|2081->644|2122->650|2156->675|2175->685|2223->695|2290->726|2304->731|2334->739|2377->751|2488->826|2541->870|2581->872|2610->882|2623->886|2662->887|2708->900|2829->986|2938->1073|2979->1079|3014->1105|3033->1115|3081->1125|3148->1156|3162->1161|3192->1169|3235->1181|3370->1280|3432->1333|3472->1335|3501->1345|3514->1349|3553->1350|3599->1363|3655->1383|3712->1418|3802->1473|4029->1678|4075->1689|4119->1724|4138->1734|4186->1744|4253->1775|4267->1780|4297->1788|4340->1800|4451->1875|4508->1923|4548->1925|4577->1935|4590->1939|4629->1940|4675->1953|4731->1973|4783->2003|4868->2053|5101->2264|5147->2275|5186->2305|5205->2315|5253->2325|5320->2356|5334->2361|5364->2369|5407->2381|5575->2513|5635->2564|5675->2566|5704->2576|5717->2580|5756->2581|5802->2594|5846->2603|5983->2717|6025->2724|6144->2820|6351->2991|6371->3002|6452->3061|6751->3325|6793->3358|6812->3368|6860->3378|6927->3409|6941->3414|6971->3422|7014->3434|7223->3608|7308->3671|7528->3856|7609->3915|8018->4295|8048->4296|8235->4454|8265->4455|8312->4473|8342->4474|8545->4648|8575->4649|8671->4716|8701->4717|8734->4722|8763->4723|8863->4795|8892->4796|8922->4798|8951->4799|9008->4820|9024->4827
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|35->7|35->7|35->7|37->9|40->12|40->12|43->15|43->15|43->15|43->15|43->15|43->15|43->15|45->17|45->17|46->18|46->18|46->18|46->18|47->19|47->19|47->19|48->20|53->25|53->25|53->25|53->25|53->25|53->25|53->25|55->27|55->27|56->28|56->28|56->28|56->28|57->29|57->29|57->29|58->30|64->36|64->36|64->36|64->36|64->36|64->36|64->36|65->37|65->37|66->38|68->40|70->42|70->42|70->42|70->42|71->43|71->43|71->43|72->44|77->49|77->49|77->49|77->49|77->49|77->49|77->49|78->50|78->50|79->51|81->53|83->55|83->55|83->55|83->55|84->56|84->56|84->56|85->57|90->62|90->62|90->62|90->62|90->62|90->62|90->62|91->63|91->63|92->64|92->64|96->68|96->68|96->68|102->74|102->74|102->74|102->74|103->75|103->75|103->75|104->76|114->86|114->86|122->94|122->94|134->106|134->106|138->110|138->110|139->111|139->111|145->117|145->117|147->119|147->119|148->120|148->120|150->122|150->122|151->123|151->123|155->127|155->127
                    -- GENERATED --
                */
            