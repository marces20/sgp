
package views.html.patrimonio.actaRecepcion

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
object formActaRecepcion extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[ActaRecepcion],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(actaForm: Form[ActaRecepcion]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.33*/("""
"""),format.raw/*4.70*/(""" 


"""),_display_(Seq[Any](/*7.2*/views/*7.7*/.html.tags.successError())),format.raw/*7.32*/("""

	<div class="row menu-acciones">
		<div class="col-sm-10">
			<button type="submit" class="btn btn-default" title="Guardar"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>	
	    	<a href=""""),_display_(Seq[Any](/*12.17*/controllers/*12.28*/.patrimonio.routes.ActasRecepcionController.index())),format.raw/*12.79*/("""" title="Cancelar" class="btn btn-default"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
	    </div>
	</div>

"""),_display_(Seq[Any](/*16.2*/inputText(actaForm("id"), 'type -> "hidden",'id->"acta_id"))),format.raw/*16.61*/("""

"""),_display_(Seq[Any](/*18.2*/inputText(actaForm("auto_creacion"), 'type -> "hidden"))),format.raw/*18.57*/("""
<input type="hidden" name="""),_display_(Seq[Any](/*19.28*/UriTrack/*19.36*/.getKey())),format.raw/*19.45*/(""" value=""""),_display_(Seq[Any](/*19.54*/UriTrack/*19.62*/.code())),format.raw/*19.69*/("""" />
 <div class="row">
	<div class="col-sm-3">
		<div class="col-sm-6">
			<div class="form-group """),_display_(Seq[Any](/*23.28*/if(actaForm.error("numero") != null)/*23.64*/ {_display_(Seq[Any](format.raw/*23.66*/("""has-error""")))}/*23.76*/else/*23.80*/{_display_(Seq[Any](format.raw/*23.81*/("""has-required""")))})),format.raw/*23.94*/("""">
				<label for="nombre" class="control-label">Número</label>
				"""),_display_(Seq[Any](/*25.6*/inputText(actaForm("numero"), 'class -> "form-control"))),format.raw/*25.61*/("""
				"""),_display_(Seq[Any](/*26.6*/actaForm("numero")/*26.24*/.error.map/*26.34*/{ error =>_display_(Seq[Any](format.raw/*26.44*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*27.31*/error/*27.36*/.message)),format.raw/*27.44*/("""</div>
				""")))})),format.raw/*28.6*/("""
			</div>
		</div>
		<div class="col-sm-6">
			<div class="checkbox">
				<label class="control-label"> """),_display_(Seq[Any](/*33.36*/checkbox(actaForm("cierre"), 'value -> "true"))),format.raw/*33.82*/(""" Acta de cierre</label>
			</div>
		</div>
	</div>
	
	<div class="col-sm-3">
		
		<div class="col-sm-6">
			<label class="control-label """),_display_(Seq[Any](/*41.33*/if(actaForm.error("ejercicio_id") != null)/*41.75*/ {_display_(Seq[Any](format.raw/*41.77*/("""has-error""")))}/*41.87*/else/*41.91*/{_display_(Seq[Any](format.raw/*41.92*/("""has-required""")))})),format.raw/*41.105*/("""">Ejercicio
				"""),_display_(Seq[Any](/*42.6*/select(actaForm("ejercicio_id"), Ejercicio.getEjercicios().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*42.164*/("""
			</label>
				"""),_display_(Seq[Any](/*44.6*/actaForm("ejercicio_id")/*44.30*/.error.map/*44.40*/{ error =>_display_(Seq[Any](format.raw/*44.50*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*45.31*/error/*45.36*/.message)),format.raw/*45.44*/("""</div>
				""")))})),format.raw/*46.6*/("""	
		</div>
		<div class="col-sm-6 """),_display_(Seq[Any](/*48.25*/if(actaForm.error("fecha") != null)/*48.60*/ {_display_(Seq[Any](format.raw/*48.62*/("""has-error""")))}/*48.72*/else/*48.76*/{_display_(Seq[Any](format.raw/*48.77*/("""has-required""")))})),format.raw/*48.90*/("""">
			<label class="control-label">Fecha acta</label> 
			<div class="form-group ">
				"""),_display_(Seq[Any](/*51.6*/inputText(actaForm("fecha"),'class -> "form-control date", 'autocomplete -> "off"))),format.raw/*51.88*/("""
			</div>
			"""),_display_(Seq[Any](/*53.5*/actaForm("fecha")/*53.22*/.error.map/*53.32*/{ error =>_display_(Seq[Any](format.raw/*53.42*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*54.30*/error/*54.35*/.message)),format.raw/*54.43*/("""</div>
			""")))})),format.raw/*55.5*/("""
		</div>
	</div> 
	
	 
	
	<div class="col-sm-2">
		<label class="control-label">Orden Provision</label> 
		<div class="input-group """),_display_(Seq[Any](/*63.28*/if(actaForm.error("orden_provision_id") != null)/*63.76*/ {_display_(Seq[Any](format.raw/*63.78*/("""has-error""")))}/*63.88*/else/*63.92*/{_display_(Seq[Any](format.raw/*63.93*/("""has-required""")))})),format.raw/*63.106*/("""">	
			"""),_display_(Seq[Any](/*64.5*/inputText(actaForm("orden_provision_id"), 'hidden -> "hidden", 'id -> "ordenProvision_id"))),format.raw/*64.95*/("""
			"""),_display_(Seq[Any](/*65.5*/inputText(actaForm("ordenProvision.numero"), 'class -> "form-control", 'id -> "ordenProvision"))),format.raw/*65.100*/("""
			
			<span class="input-group-addon">
               	<a href="#" id="searchOrdenProvision" 
               				data-title="Selección de Orden Provision" 
               				data-url=""""),_display_(Seq[Any](/*70.31*/controllers/*70.42*/.patrimonio.routes.OrdenesProvisionController.modalBuscar())),format.raw/*70.101*/("""" 
               				data-height="650" data-width="700" 
               				data-listen="modal.seleccion.ordenProvision.simple" 
               				data-label="#ordenProvision" 
               				data-field="#ordenProvision_id"/> 
               				<i class="glyphicon glyphicon-search"></i></a>
               </span>
		</div>
		"""),_display_(Seq[Any](/*78.4*/actaForm("orden_provision_id")/*78.34*/.error.map/*78.44*/{ error =>_display_(Seq[Any](format.raw/*78.54*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*79.29*/error/*79.34*/.message)),format.raw/*79.42*/("""</div>
		""")))})),format.raw/*80.4*/("""
	</div>
	
	<div class="col-sm-3">
		<div class="col-sm-6">
			<div class="form-group """),_display_(Seq[Any](/*85.28*/if(actaForm.error("periodo_id") != null)/*85.68*/ {_display_(Seq[Any](format.raw/*85.70*/("""has-error""")))})),format.raw/*85.80*/("""">
				<label for="periodo" class="control-label">Periodo</label>
					<div class="input-group">
						"""),_display_(Seq[Any](/*88.8*/inputText(actaForm("periodo.nombre"), 'class -> "form-control", 'id -> "periodo"))),format.raw/*88.89*/("""
						"""),_display_(Seq[Any](/*89.8*/inputText(actaForm("periodo_id"),'hidden -> "hidden", 'id -> "periodo_id"))),format.raw/*89.82*/("""
						<span class="input-group-addon">
							<a href="#" class="searchModal"
										id="searchPeriodo" 
										data-title="Selección de Periodo" 
										data-url=""""),_display_(Seq[Any](/*94.22*/controllers/*94.33*/.contabilidad.routes.PeriodosController.modalBuscar())),format.raw/*94.86*/("""" 
										data-height="650" 
										data-width="700" 
										data-listen="modal.seleccion.periodo.simple" 
										data-label="#periodo" 
										data-field="#periodo_id">
								<i class="glyphicon glyphicon-search"></i>
							</a>
						</span>
					</div>
			</div>
		</div>
		<div class="col-sm-6">
			<div class="form-group">
				<label for="nombre" class="control-label">Cotización</label>
				"""),_display_(Seq[Any](/*109.6*/inputText(actaForm("cot_dolar"), 'class -> "form-control"))),format.raw/*109.64*/("""
				 
			</div>
		</div>
	</div>
	
</div>	


<div class="row">
	

	<div class="col-sm-6">
		<label for="obs" class="control-label">Observaciones</label> 
		"""),_display_(Seq[Any](/*123.4*/textarea(actaForm("observaciones"), 'class -> "form-control", 'rows -> "4", 'id -> "obs"))),format.raw/*123.93*/("""
	</div>
	<div class="col-sm-6">
		<label for="nota" class="control-label">Nota Interna</label> 
		"""),_display_(Seq[Any](/*127.4*/textarea(actaForm("nota_interna"), 'class -> "form-control", 'rows -> "4", 'id -> "nota"))),format.raw/*127.93*/("""
	</div>
</div>
 

"""),_display_(Seq[Any](/*132.2*/flash()/*132.9*/.clear())))}
    }
    
    def render(actaForm:Form[ActaRecepcion]): play.api.templates.HtmlFormat.Appendable = apply(actaForm)
    
    def f:((Form[ActaRecepcion]) => play.api.templates.HtmlFormat.Appendable) = (actaForm) => apply(actaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/actaRecepcion/formActaRecepcion.scala.html
                    HASH: 2adcc9e369a91469c71440f4a152372093bc19ff
                    MATRIX: 824->1|975->70|1007->94|1081->32|1110->138|1152->146|1164->151|1210->176|1459->389|1479->400|1552->451|1719->583|1800->642|1840->647|1917->702|1982->731|1999->739|2030->748|2075->757|2092->765|2121->772|2261->876|2306->912|2346->914|2375->924|2388->928|2427->929|2472->942|2578->1013|2655->1068|2697->1075|2724->1093|2743->1103|2791->1113|2859->1145|2873->1150|2903->1158|2947->1171|3094->1282|3162->1328|3343->1473|3394->1515|3434->1517|3463->1527|3476->1531|3515->1532|3561->1545|3614->1563|3795->1721|3850->1741|3883->1765|3902->1775|3950->1785|4018->1817|4032->1822|4062->1830|4106->1843|4179->1880|4223->1915|4263->1917|4292->1927|4305->1931|4344->1932|4389->1945|4516->2037|4620->2119|4672->2136|4698->2153|4717->2163|4765->2173|4832->2204|4846->2209|4876->2217|4919->2229|5096->2370|5153->2418|5193->2420|5222->2430|5235->2434|5274->2435|5320->2448|5364->2457|5476->2547|5517->2553|5635->2648|5864->2841|5884->2852|5966->2911|6343->3253|6382->3283|6401->3293|6449->3303|6515->3333|6529->3338|6559->3346|6601->3357|6729->3449|6778->3489|6818->3491|6860->3501|7002->3608|7105->3689|7149->3698|7245->3772|7461->3952|7481->3963|7556->4016|8023->4447|8104->4505|8312->4677|8424->4766|8564->4870|8676->4959|8737->4984|8753->4991
                    LINES: 26->1|31->4|31->4|32->1|33->4|36->7|36->7|36->7|41->12|41->12|41->12|45->16|45->16|47->18|47->18|48->19|48->19|48->19|48->19|48->19|48->19|52->23|52->23|52->23|52->23|52->23|52->23|52->23|54->25|54->25|55->26|55->26|55->26|55->26|56->27|56->27|56->27|57->28|62->33|62->33|70->41|70->41|70->41|70->41|70->41|70->41|70->41|71->42|71->42|73->44|73->44|73->44|73->44|74->45|74->45|74->45|75->46|77->48|77->48|77->48|77->48|77->48|77->48|77->48|80->51|80->51|82->53|82->53|82->53|82->53|83->54|83->54|83->54|84->55|92->63|92->63|92->63|92->63|92->63|92->63|92->63|93->64|93->64|94->65|94->65|99->70|99->70|99->70|107->78|107->78|107->78|107->78|108->79|108->79|108->79|109->80|114->85|114->85|114->85|114->85|117->88|117->88|118->89|118->89|123->94|123->94|123->94|138->109|138->109|152->123|152->123|156->127|156->127|161->132|161->132
                    -- GENERATED --
                */
            