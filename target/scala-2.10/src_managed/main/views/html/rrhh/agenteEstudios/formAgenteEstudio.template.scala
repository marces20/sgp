
package views.html.rrhh.agenteEstudios

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
object formAgenteEstudio extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[AgenteEstudio],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[AgenteEstudio]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.34*/("""
"""),format.raw/*3.70*/(""" 

<script>
$(function()"""),format.raw/*6.13*/("""{"""),format.raw/*6.14*/("""
	$("#monto, #base").numeric_input();
"""),format.raw/*8.1*/("""}"""),format.raw/*8.2*/(""");
</script>

"""),_display_(Seq[Any](/*11.2*/if(flash.containsKey("error"))/*11.32*/ {_display_(Seq[Any](format.raw/*11.34*/("""
	<div class="alert alert-danger">
		<i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*13.52*/flash/*13.57*/.get("error"))),format.raw/*13.70*/("""
	</div>
""")))})),format.raw/*15.2*/("""

<div class="row">
	"""),_display_(Seq[Any](/*18.3*/inputText(lineaForm("agente_id"), 'type -> "hidden"))),format.raw/*18.55*/("""
	<div class="col-sm-4">
		<div class="form-group """),_display_(Seq[Any](/*20.27*/if(lineaForm.error("estudio_nivel_id") != null)/*20.74*/ {_display_(Seq[Any](format.raw/*20.76*/("""has-error""")))}/*20.86*/else/*20.90*/{_display_(Seq[Any](format.raw/*20.91*/("""has-required""")))})),format.raw/*20.104*/("""">
			<label for=""""),_display_(Seq[Any](/*21.17*/lineaForm("estudio_nivel_id"))),format.raw/*21.46*/("""" class="control-label">Estudio Nivel</label>
			"""),_display_(Seq[Any](/*22.5*/select(lineaForm("estudio_nivel_id"), 
			EstudioNivel.find.orderBy("orden asc").findList().map { p => p.id.toString -> p.nombre}, 
			'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*24.64*/("""
			
			"""),_display_(Seq[Any](/*26.5*/lineaForm("estudio_nivel_id")/*26.34*/.error.map/*26.44*/{ error =>_display_(Seq[Any](format.raw/*26.54*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*27.30*/error/*27.35*/.message)),format.raw/*27.43*/("""</div>
			""")))})),format.raw/*28.5*/("""
		</div>
	</div>
	<div class="col-sm-5">
		<div class="form-group """),_display_(Seq[Any](/*32.27*/if(lineaForm.error("titulo") != null)/*32.64*/ {_display_(Seq[Any](format.raw/*32.66*/("""has-error""")))}/*32.76*/else/*32.80*/{_display_(Seq[Any](format.raw/*32.81*/("""has-required""")))})),format.raw/*32.94*/("""">
			<label for="inputTitulo" class="control-label">Titulo</label> 
			"""),_display_(Seq[Any](/*34.5*/inputText(lineaForm("titulo"), 'class -> "form-control", 'id -> "titulo"))),format.raw/*34.78*/("""
			"""),_display_(Seq[Any](/*35.5*/lineaForm("titulo")/*35.24*/.error.map/*35.34*/{ error =>_display_(Seq[Any](format.raw/*35.44*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*36.30*/error/*36.35*/.message)),format.raw/*36.43*/("""</div>
			""")))})),format.raw/*37.5*/("""
		</div>
	</div>
	<div class="col-sm-3">
		<div class="form-group """),_display_(Seq[Any](/*41.27*/if(lineaForm.error("estudio_estado_id") != null)/*41.75*/ {_display_(Seq[Any](format.raw/*41.77*/("""has-error""")))}/*41.87*/else/*41.91*/{_display_(Seq[Any](format.raw/*41.92*/("""has-required""")))})),format.raw/*41.105*/("""">
			<label for=""""),_display_(Seq[Any](/*42.17*/lineaForm("estudio_estado_id"))),format.raw/*42.47*/("""" class="control-label">Estudio Estado</label>
			"""),_display_(Seq[Any](/*43.5*/select(lineaForm("estudio_estado_id"), 
			EstudioEstado.find.all().map { p => p.id.toString -> p.nombre}, 
			'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*45.64*/("""
			
			"""),_display_(Seq[Any](/*47.5*/lineaForm("estudio_estado_id")/*47.35*/.error.map/*47.45*/{ error =>_display_(Seq[Any](format.raw/*47.55*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*48.30*/error/*48.35*/.message)),format.raw/*48.43*/("""</div>
			""")))})),format.raw/*49.5*/("""
		</div>
	</div>
	
	
</div>	
<div class="row contenedorAreas">	
	<div class="col-sm-6">
		
		<div class="seleccionArea form-group """),_display_(Seq[Any](/*58.41*/if(lineaForm.error("estudioSubarea.estudioArea.id") != null)/*58.101*/ {_display_(Seq[Any](format.raw/*58.103*/("""has-error""")))}/*58.113*/else/*58.117*/{_display_(Seq[Any](format.raw/*58.118*/("""has-required""")))})),format.raw/*58.131*/("""">
			<label for=""""),_display_(Seq[Any](/*59.17*/lineaForm("estudioSubarea.estudioArea.id")/*59.59*/.id)),format.raw/*59.62*/("""" class="control-label">Estudio Area</label>
			 
							    
			"""),_display_(Seq[Any](/*62.5*/select(lineaForm("estudioSubarea.estudioArea.id"), 
			EstudioArea.find.orderBy("nombre").findList().map { p => p.id.toString -> p.nombre}, 
			'class -> "form-control select", 
			'_default -> "Seleccionar"))),format.raw/*65.31*/("""
			
			"""),_display_(Seq[Any](/*67.5*/lineaForm("estudioSubarea.estudioArea.id")/*67.47*/.error.map/*67.57*/{ error =>_display_(Seq[Any](format.raw/*67.67*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*68.30*/error/*68.35*/.message)),format.raw/*68.43*/("""</div>
			""")))})),format.raw/*69.5*/("""
		</div>
	</div>
	<div class="col-sm-6">
		<div class="seleccionSubArea form-group """),_display_(Seq[Any](/*73.44*/if(lineaForm.error("estudio_subarea_id") != null)/*73.93*/ {_display_(Seq[Any](format.raw/*73.95*/("""has-error""")))}/*73.105*/else/*73.109*/{_display_(Seq[Any](format.raw/*73.110*/("""has-required""")))})),format.raw/*73.123*/("""">
			<label for=""""),_display_(Seq[Any](/*74.17*/lineaForm("estudio_subarea_id"))),format.raw/*74.48*/("""" class="control-label">Estudio Subarea</label>
			"""),_display_(Seq[Any](/*75.5*/select(lineaForm("estudio_subarea_id"), 
					lineaForm("estudioSubarea.estudioArea.id").value match {
						case null => {options()}
						case v if v.matches("\\d+") => {EstudioSubarea.getEstudioSubarea(v.toInt).map { p => p.id.toString -> p.nombre}}
						case _ => {options()}
					}, 
				'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*81.65*/(""" 
			
			"""),_display_(Seq[Any](/*83.5*/lineaForm("estudio_subarea_id")/*83.36*/.error.map/*83.46*/{ error =>_display_(Seq[Any](format.raw/*83.56*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*84.30*/error/*84.35*/.message)),format.raw/*84.43*/("""</div>
			""")))})),format.raw/*85.5*/("""
		</div>
		
		
	</div>
</div>
<div class="row">
	<div class="col-sm-5">
		<div class="form-group """),_display_(Seq[Any](/*93.27*/if(lineaForm.error("estudio_institucion_id") != null)/*93.80*/ {_display_(Seq[Any](format.raw/*93.82*/("""has-error""")))}/*93.92*/else/*93.96*/{_display_(Seq[Any](format.raw/*93.97*/("""has-required""")))})),format.raw/*93.110*/("""">
			<label for=""""),_display_(Seq[Any](/*94.17*/lineaForm("estudio_institucion_id"))),format.raw/*94.52*/("""" class="control-label">Institucion</label>
			"""),_display_(Seq[Any](/*95.5*/select(lineaForm("estudio_institucion_id"), 
			EstudioInstitucion.find.all().map { p => p.id.toString -> p.nombre}, 
			'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*97.64*/("""
			
			"""),_display_(Seq[Any](/*99.5*/lineaForm("estudio_institucion_id")/*99.40*/.error.map/*99.50*/{ error =>_display_(Seq[Any](format.raw/*99.60*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*100.30*/error/*100.35*/.message)),format.raw/*100.43*/("""</div>
			""")))})),format.raw/*101.5*/("""
		</div>
	</div>
	<div class="col-sm-4">
		<div class="form-group """),_display_(Seq[Any](/*105.27*/if(lineaForm.error("otra_institucion") != null)/*105.74*/ {_display_(Seq[Any](format.raw/*105.76*/("""has-error""")))}/*105.86*/else/*105.90*/{_display_(Seq[Any](format.raw/*105.91*/("""has-required""")))})),format.raw/*105.104*/("""">
			<label for="inputOtraInstitucion" class="control-label">Otra Institucion</label> 
			"""),_display_(Seq[Any](/*107.5*/inputText(lineaForm("otra_institucion"), 'class -> "form-control", 'id -> "otra_institucion"))),format.raw/*107.98*/("""
			"""),_display_(Seq[Any](/*108.5*/lineaForm("otra_institucion")/*108.34*/.error.map/*108.44*/{ error =>_display_(Seq[Any](format.raw/*108.54*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*109.30*/error/*109.35*/.message)),format.raw/*109.43*/("""</div>
			""")))})),format.raw/*110.5*/("""
		</div>
	</div>
	<div class="col-sm-3">
		<div class="form-group """),_display_(Seq[Any](/*114.27*/if(lineaForm.error("pais_id") != null)/*114.65*/ {_display_(Seq[Any](format.raw/*114.67*/("""has-error""")))}/*114.77*/else/*114.81*/{_display_(Seq[Any](format.raw/*114.82*/("""has-required""")))})),format.raw/*114.95*/("""">
			<label for=""""),_display_(Seq[Any](/*115.17*/lineaForm("pais_id"))),format.raw/*115.37*/("""" class="control-label">Pais</label>
			"""),_display_(Seq[Any](/*116.5*/select(lineaForm("pais_id"), 
			Pais.find.all().map { p => p.id.toString -> p.nombre}, 
			'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*118.64*/("""
			
			"""),_display_(Seq[Any](/*120.5*/lineaForm("pais_id")/*120.25*/.error.map/*120.35*/{ error =>_display_(Seq[Any](format.raw/*120.45*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*121.30*/error/*121.35*/.message)),format.raw/*121.43*/("""</div>
			""")))})),format.raw/*122.5*/("""
		</div>
	</div>
</div> 
<div class="row">
	<div class="col-sm-2">
		<div class="form-group """),_display_(Seq[Any](/*128.27*/if(lineaForm.error("finicio") != null)/*128.65*/ {_display_(Seq[Any](format.raw/*128.67*/("""has-error""")))}/*128.77*/else/*128.81*/{_display_(Seq[Any](format.raw/*128.82*/("""has-required""")))})),format.raw/*128.95*/("""">
			<label for="inputFinicio" class="control-label">Inicio</label> 
			"""),_display_(Seq[Any](/*130.5*/inputText(lineaForm("finicio"), 'class -> "form-control", 'id -> "finicio"))),format.raw/*130.80*/("""
			"""),_display_(Seq[Any](/*131.5*/lineaForm("finicio")/*131.25*/.error.map/*131.35*/{ error =>_display_(Seq[Any](format.raw/*131.45*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*132.30*/error/*132.35*/.message)),format.raw/*132.43*/("""</div>
			""")))})),format.raw/*133.5*/("""
		</div>
	</div>
	<div class="col-sm-2">
		<div class="form-group">
			<label for="inputFfin" class="control-label">Fin</label> 
			"""),_display_(Seq[Any](/*139.5*/inputText(lineaForm("ffin"), 'class -> "form-control", 'id -> "ffin"))),format.raw/*139.74*/("""
		</div>
	</div>
	<div class="col-sm-8">
		<div class="form-group">
			<label for="inputDescripcion" class="control-label">Descripcion</label> 
			"""),_display_(Seq[Any](/*145.5*/inputText(lineaForm("descripcion"), 'class -> "form-control", 'id -> "descripcion"))),format.raw/*145.88*/("""
		</div>
	</div>
</div>
<div class="row">
	<div class="col-sm-4">
		<div class="form-group">
			<label for="inputPromedio" class="control-label">Promedio</label> 
			"""),_display_(Seq[Any](/*153.5*/inputText(lineaForm("promedio"), 'class -> "form-control", 'id -> "promedio"))),format.raw/*153.82*/("""
		</div>
	</div>
	<div class="col-sm-4">
		<div class="form-group">
			<label for="inputMateriaCarrera" class="control-label">Materias Carrera</label> 
			"""),_display_(Seq[Any](/*159.5*/inputText(lineaForm("materia_carrera"), 'class -> "form-control", 'id -> "materia_carrera"))),format.raw/*159.96*/("""
		</div>
	</div>
	<div class="col-sm-4">
		<div class="form-group">
			<label for="inputMateriaAprobada" class="control-label">Materias Aprobadas</label> 
			"""),_display_(Seq[Any](/*165.5*/inputText(lineaForm("materia_aprobadas"), 'class -> "form-control", 'id -> "materia_aprobadas"))),format.raw/*165.100*/("""
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
$( function()"""),format.raw/*176.14*/("""{"""),format.raw/*176.15*/("""
	$("#promedio, #materia_carrera, #materia_aprobadas").numeric_input();
	$("#ffin, #finicio").mask("99/99/9999");
	urlSubAreas  = '"""),_display_(Seq[Any](/*179.19*/controllers/*179.30*/.rrhh.routes.AgentesEstudiosController.listOptionsEstudioSubareas())),format.raw/*179.97*/("""';
	$('.seleccionArea .select').on('change', function()"""),format.raw/*180.53*/("""{"""),format.raw/*180.54*/("""
		var id = $(this).find('option:selected').val();
		var contenedor = $(this).closest('.contenedorAreas');
		contenedor.find('.seleccionSubarea .select').find('option:gt(0)').remove();
		
		if(id == "") return false;

		$.get(urlSubAreas + '?estudioAreaId='+id, function(data)"""),format.raw/*187.59*/("""{"""),format.raw/*187.60*/("""
			contenedor.find('.seleccionSubArea .select').html(data);
		"""),format.raw/*189.3*/("""}"""),format.raw/*189.4*/(""");
	"""),format.raw/*190.2*/("""}"""),format.raw/*190.3*/(""");

"""),format.raw/*192.1*/("""}"""),format.raw/*192.2*/(""");
</script>	


"""),_display_(Seq[Any](/*196.2*/flash()/*196.9*/.clear())))}
    }
    
    def render(lineaForm:Form[AgenteEstudio]): play.api.templates.HtmlFormat.Appendable = apply(lineaForm)
    
    def f:((Form[AgenteEstudio]) => play.api.templates.HtmlFormat.Appendable) = (lineaForm) => apply(lineaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:30 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agenteEstudios/formAgenteEstudio.scala.html
                    HASH: 6a1c26264c535dd1c1c5306746b6215c73685abb
                    MATRIX: 819->1|954->54|986->78|1060->33|1089->122|1143->149|1171->150|1237->190|1264->191|1317->209|1356->239|1396->241|1520->329|1534->334|1569->347|1612->359|1672->384|1746->436|1835->489|1891->536|1931->538|1960->548|1973->552|2012->553|2058->566|2114->586|2165->615|2251->666|2470->863|2516->874|2554->903|2573->913|2621->923|2688->954|2702->959|2732->967|2775->979|2883->1051|2929->1088|2969->1090|2998->1100|3011->1104|3050->1105|3095->1118|3205->1193|3300->1266|3341->1272|3369->1291|3388->1301|3436->1311|3503->1342|3517->1347|3547->1355|3590->1367|3698->1439|3755->1487|3795->1489|3824->1499|3837->1503|3876->1504|3922->1517|3978->1537|4030->1567|4117->1619|4312->1792|4358->1803|4397->1833|4416->1843|4464->1853|4531->1884|4545->1889|4575->1897|4618->1909|4795->2050|4865->2110|4906->2112|4936->2122|4950->2126|4990->2127|5036->2140|5092->2160|5143->2202|5168->2205|5272->2274|5505->2485|5551->2496|5602->2538|5621->2548|5669->2558|5736->2589|5750->2594|5780->2602|5823->2614|5948->2703|6006->2752|6046->2754|6076->2764|6090->2768|6130->2769|6176->2782|6232->2802|6285->2833|6373->2886|6755->3246|6802->3258|6842->3289|6861->3299|6909->3309|6976->3340|6990->3345|7020->3353|7063->3365|7206->3472|7268->3525|7308->3527|7337->3537|7350->3541|7389->3542|7435->3555|7491->3575|7548->3610|7632->3659|7837->3842|7883->3853|7927->3888|7946->3898|7994->3908|8062->3939|8077->3944|8108->3952|8152->3964|8261->4036|8318->4083|8359->4085|8389->4095|8403->4099|8443->4100|8490->4113|8620->4207|8736->4300|8778->4306|8817->4335|8837->4345|8886->4355|8954->4386|8969->4391|9000->4399|9044->4411|9153->4483|9201->4521|9242->4523|9272->4533|9286->4537|9326->4538|9372->4551|9429->4571|9472->4591|9550->4633|9727->4787|9774->4798|9804->4818|9824->4828|9873->4838|9941->4869|9956->4874|9987->4882|10031->4894|10168->4994|10216->5032|10257->5034|10287->5044|10301->5048|10341->5049|10387->5062|10499->5138|10597->5213|10639->5219|10669->5239|10689->5249|10738->5259|10806->5290|10821->5295|10852->5303|10896->5315|11072->5455|11164->5524|11355->5679|11461->5762|11673->5938|11773->6015|11972->6178|12086->6269|12288->6435|12407->6530|12815->6909|12845->6910|13017->7045|13038->7056|13128->7123|13213->7179|13243->7180|13555->7463|13585->7464|13678->7529|13707->7530|13740->7535|13769->7536|13803->7542|13832->7543|13889->7564|13905->7571
                    LINES: 26->1|29->3|29->3|30->1|31->3|34->6|34->6|36->8|36->8|39->11|39->11|39->11|41->13|41->13|41->13|43->15|46->18|46->18|48->20|48->20|48->20|48->20|48->20|48->20|48->20|49->21|49->21|50->22|52->24|54->26|54->26|54->26|54->26|55->27|55->27|55->27|56->28|60->32|60->32|60->32|60->32|60->32|60->32|60->32|62->34|62->34|63->35|63->35|63->35|63->35|64->36|64->36|64->36|65->37|69->41|69->41|69->41|69->41|69->41|69->41|69->41|70->42|70->42|71->43|73->45|75->47|75->47|75->47|75->47|76->48|76->48|76->48|77->49|86->58|86->58|86->58|86->58|86->58|86->58|86->58|87->59|87->59|87->59|90->62|93->65|95->67|95->67|95->67|95->67|96->68|96->68|96->68|97->69|101->73|101->73|101->73|101->73|101->73|101->73|101->73|102->74|102->74|103->75|109->81|111->83|111->83|111->83|111->83|112->84|112->84|112->84|113->85|121->93|121->93|121->93|121->93|121->93|121->93|121->93|122->94|122->94|123->95|125->97|127->99|127->99|127->99|127->99|128->100|128->100|128->100|129->101|133->105|133->105|133->105|133->105|133->105|133->105|133->105|135->107|135->107|136->108|136->108|136->108|136->108|137->109|137->109|137->109|138->110|142->114|142->114|142->114|142->114|142->114|142->114|142->114|143->115|143->115|144->116|146->118|148->120|148->120|148->120|148->120|149->121|149->121|149->121|150->122|156->128|156->128|156->128|156->128|156->128|156->128|156->128|158->130|158->130|159->131|159->131|159->131|159->131|160->132|160->132|160->132|161->133|167->139|167->139|173->145|173->145|181->153|181->153|187->159|187->159|193->165|193->165|204->176|204->176|207->179|207->179|207->179|208->180|208->180|215->187|215->187|217->189|217->189|218->190|218->190|220->192|220->192|224->196|224->196
                    -- GENERATED --
                */
            