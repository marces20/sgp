
package views.html.recupero.recuperoFactura

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
object formRecuperoFactura extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.recupero.RecuperoFactura],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(recuperoFacturaForm: Form[models.recupero.RecuperoFactura]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.62*/("""
"""),format.raw/*4.70*/(""" 
	
	
	<div class="row menu-acciones">
		<div class="col-sm-10">
			<button type="submit" class="btn btn-default" title="Guardar orden"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>	
																																   
	    	<a href=""""),_display_(Seq[Any](/*11.17*/if(request().getHeader("referer"))/*11.51*/{_display_(Seq[Any](format.raw/*11.52*/(""" """),_display_(Seq[Any](/*11.54*/request()/*11.63*/.getHeader("referer"))),format.raw/*11.84*/(""" """)))}/*11.87*/else/*11.92*/{_display_(Seq[Any](_display_(Seq[Any](/*11.94*/controllers/*11.105*/.recupero.routes.RecuperoFacturasController.index())),_display_(Seq[Any](/*11.157*/UriTrack/*11.165*/.decode()))))})),format.raw/*11.175*/("""" title="Cancelar editar" class="btn btn-default"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
	    </div>
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*14.14*/UriTrack/*14.22*/.decode())),format.raw/*14.31*/("""" title="Volver al listado" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
			"""),_display_(Seq[Any](/*15.5*/if(recuperoFacturaForm.field("id").value)/*15.46*/{_display_(Seq[Any](format.raw/*15.47*/("""<a href=""""),_display_(Seq[Any](/*15.57*/controllers/*15.68*/.recupero.routes.RecuperoFacturasController.ver(recuperoFacturaForm.field("id").value.toLong))),_display_(Seq[Any](/*15.162*/UriTrack/*15.170*/.get("&"))),format.raw/*15.179*/("""" title="Ver factura" class="btn btn-default"><i class="glyphicon glyphicon-align-justify"></i></a>""")))})),format.raw/*15.279*/("""
		</div>
	</div>
	
	
	"""),_display_(Seq[Any](/*20.3*/inputText(recuperoFacturaForm("id"), 'type -> "hidden", 'id -> "recuperoFacturaId"))),format.raw/*20.86*/("""
	<input type="hidden" name="""),_display_(Seq[Any](/*21.29*/UriTrack/*21.37*/.getKey())),format.raw/*21.46*/(""" value=""""),_display_(Seq[Any](/*21.55*/UriTrack/*21.63*/.code())),format.raw/*21.70*/("""" />
	<div class="row">
		<div class="col-sm-2">
			<label class="control-label">Nombre</label> 
			<div class="form-group """),_display_(Seq[Any](/*25.28*/if(recuperoFacturaForm.error("nombre") != null)/*25.75*/ {_display_(Seq[Any](format.raw/*25.77*/("""has-error""")))})),format.raw/*25.87*/("""">
				"""),_display_(Seq[Any](/*26.6*/inputText(recuperoFacturaForm("nombre"), 'class -> "form-control",'readOnly -> "readOnly"))),format.raw/*26.96*/("""
				
				"""),_display_(Seq[Any](/*28.6*/recuperoFacturaForm("nombre")/*28.35*/.error.map/*28.45*/{ error =>_display_(Seq[Any](format.raw/*28.55*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*29.31*/error/*29.36*/.message)),format.raw/*29.44*/("""</div>
				""")))})),format.raw/*30.6*/("""
			</div>
		</div>
		
		<div class="col-sm-3">
		 	<label class="control-label">Numero</label> 
			<div class="input-group """),_display_(Seq[Any](/*36.29*/if(recuperoFacturaForm.error("numero") != null || recuperoFacturaForm.error("puntoventa_id") != null)/*36.130*/ {_display_(Seq[Any](format.raw/*36.132*/("""has-error""")))}/*36.142*/else/*36.146*/{_display_(Seq[Any](format.raw/*36.147*/("""has-required""")))})),format.raw/*36.160*/("""">
			    <span class="input-group-btn">
			      """),_display_(Seq[Any](/*38.11*/select(recuperoFacturaForm("serie"), options("C"->"C"), 'id -> "serie",'class -> "form-control select"))),format.raw/*38.114*/("""
			      <i class="input-group-addon" style="display:none"></i>
			    </span>
			    <span class="input-group-btn">
			      """),_display_(Seq[Any](/*42.11*/select(recuperoFacturaForm("puntoventa_id"),PuntoVenta.find.all().map { p => p.id.toString -> p.numero}, 
					'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*43.66*/("""
			      <i class="input-group-addon" style="display:none"></i>
			    </span>
			    <span class="input-group-btn">
			    <i class="input-group-addon" style="display:none"></i>
			      """),_display_(Seq[Any](/*48.11*/inputText(recuperoFacturaForm("numero"), 'class -> "form-control",'id->"numero_factura"))),format.raw/*48.99*/("""
			    </span>
			   
		  	</div>	
		  	 """),_display_(Seq[Any](/*52.8*/recuperoFacturaForm("puntoventa_id")/*52.44*/.error.map/*52.54*/{ error =>_display_(Seq[Any](format.raw/*52.64*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*53.31*/error/*53.36*/.message)),format.raw/*53.44*/("""</div>
				""")))})),format.raw/*54.6*/("""
				 """),_display_(Seq[Any](/*55.7*/recuperoFacturaForm("numero")/*55.36*/.error.map/*55.46*/{ error =>_display_(Seq[Any](format.raw/*55.56*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*56.31*/error/*56.36*/.message)),format.raw/*56.44*/("""</div>
				""")))})),format.raw/*57.6*/("""
		</div>
		
		<div class="col-sm-4">
			<label class="control-label">Cliente</label> 
			<div class="input-group """),_display_(Seq[Any](/*62.29*/if(recuperoFacturaForm.error("cliente_id") != null)/*62.80*/ {_display_(Seq[Any](format.raw/*62.82*/("""has-error""")))}/*62.92*/else/*62.96*/{_display_(Seq[Any](format.raw/*62.97*/("""has-required""")))})),format.raw/*62.110*/("""">	
				"""),_display_(Seq[Any](/*63.6*/inputText(recuperoFacturaForm("cliente.nombre"), 'class -> "form-control", 'id -> "cliente_nombre"))),format.raw/*63.105*/("""
				"""),_display_(Seq[Any](/*64.6*/inputText(recuperoFacturaForm("cliente_id"), 'hidden -> "hidden", 'id -> "cliente_id"))),format.raw/*64.92*/("""
				<span class="input-group-addon">
                	<a href="#" id="searchCliente" 
                	data-title="Selección de cliente" 
                	data-url=""""),_display_(Seq[Any](/*68.29*/controllers/*68.40*/.compras.routes.ClientesController.modalBuscar())),format.raw/*68.88*/("""" 
                	data-height="650" data-width="700" 
                	data-listen="modal.seleccion.cliente.simple" 
                	data-label="#cliente_nombre" data-field="#cliente_id" /> 
                	<i class="glyphicon glyphicon-search"></i></a>
                </span>
                <span class="input-group-addon">
                	<a href="#" id="searchPacienteCarga" 
			                	data-title="Carga de paciente" 
			                	data-url=""""),_display_(Seq[Any](/*77.32*/controllers/*77.43*/.compras.routes.ClientesController.modalCarga())),format.raw/*77.90*/("""" 
			                	data-height="650" 
			                	data-width="700" 
			                	data-listen="modal.carga.cliente.simple" 
			                	data-label="#paciente" 
			                	data-field="#paciente_id" /> 
			                	<i class="glyphicon glyphicon-plus"></i></a>
                </span>
			</div>
			"""),_display_(Seq[Any](/*86.5*/recuperoFacturaForm("cliente_id")/*86.38*/.error.map/*86.48*/{ error =>_display_(Seq[Any](format.raw/*86.58*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*87.30*/error/*87.35*/.message)),format.raw/*87.43*/("""</div>
			""")))})),format.raw/*88.5*/("""
		</div>
	</div>	
	<div class="row">	
		<div class="col-sm-2">
			<label for="expediente" class="control-label">Planilla</label> 
			<div class="input-group """),_display_(Seq[Any](/*94.29*/if(recuperoFacturaForm.error("planilla_id") != null)/*94.81*/ {_display_(Seq[Any](format.raw/*94.83*/("""has-error""")))}/*94.93*/else/*94.97*/{_display_(Seq[Any](format.raw/*94.98*/("""has-required""")))})),format.raw/*94.111*/("""">
				"""),_display_(Seq[Any](/*95.6*/inputText(recuperoFacturaForm("planilla.recuperoPlanillaEjercicio"),'class -> "form-control", 'id -> "planilla"))),format.raw/*95.118*/("""
				"""),_display_(Seq[Any](/*96.6*/inputText(recuperoFacturaForm("planilla_id"),'hidden -> "hidden", 'id -> "planilla_id"))),format.raw/*96.93*/("""

				<span class="input-group-addon">
				<a href="#" 
				id="searchPlanilla" data-title="Selección de Planilla" 
				data-url=""""),_display_(Seq[Any](/*101.16*/controllers/*101.27*/.recupero.routes.RecuperoPlanillasController.modalBuscar())),format.raw/*101.85*/("""" 
				data-height="650" data-width="700" 
				data-listen="modal.seleccion.planilla.simple" 
				data-label="#planilla" 
				data-field="#planilla_id">
				<i class="glyphicon glyphicon-search"></i></a></span>
				
			</div>
			"""),_display_(Seq[Any](/*109.5*/recuperoFacturaForm("planilla_id")/*109.39*/.error.map/*109.49*/{ error =>_display_(Seq[Any](format.raw/*109.59*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*110.31*/error/*110.36*/.message)),format.raw/*110.44*/("""</div>
				""")))})),format.raw/*111.6*/("""
		</div>
		<div class="col-sm-2">
			<label class="control-label">Fecha factura</label> 
			<div class="form-group """),_display_(Seq[Any](/*115.28*/if(recuperoFacturaForm.error("fecha")  != null)/*115.75*/ {_display_(Seq[Any](format.raw/*115.77*/("""has-error""")))}/*115.87*/else/*115.91*/{_display_(Seq[Any](format.raw/*115.92*/("""has-required""")))})),format.raw/*115.105*/("""">
				"""),_display_(Seq[Any](/*116.6*/inputText(recuperoFacturaForm("fecha"),'class -> "form-control date", 'autocomplete -> "off"))),format.raw/*116.99*/("""
			</div>
			"""),_display_(Seq[Any](/*118.5*/recuperoFacturaForm("fecha")/*118.33*/.error.map/*118.43*/{ error =>_display_(Seq[Any](format.raw/*118.53*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*119.30*/error/*119.35*/.message)),format.raw/*119.43*/("""</div>
			""")))})),format.raw/*120.5*/("""
		</div>
	</div>
	 """))}
    }
    
    def render(recuperoFacturaForm:Form[models.recupero.RecuperoFactura]): play.api.templates.HtmlFormat.Appendable = apply(recuperoFacturaForm)
    
    def f:((Form[models.recupero.RecuperoFactura]) => play.api.templates.HtmlFormat.Appendable) = (recuperoFacturaForm) => apply(recuperoFacturaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:35 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/recupero/recuperoFactura/formRecuperoFactura.scala.html
                    HASH: 9f3abbf8f7a7a918f804cd5cd36337120d75636a
                    MATRIX: 844->1|1022->96|1054->120|1128->61|1156->164|1446->418|1489->452|1528->453|1566->455|1584->464|1627->485|1648->488|1661->493|1709->495|1730->506|1813->558|1831->566|1868->576|2067->739|2084->747|2115->756|2252->858|2302->899|2341->900|2387->910|2407->921|2532->1015|2550->1023|2582->1032|2715->1132|2774->1156|2879->1239|2944->1268|2961->1276|2992->1285|3037->1294|3054->1302|3083->1309|3243->1433|3299->1480|3339->1482|3381->1492|3424->1500|3536->1590|3582->1601|3620->1630|3639->1640|3687->1650|3754->1681|3768->1686|3798->1694|3841->1706|4002->1831|4113->1932|4154->1934|4184->1944|4198->1948|4238->1949|4284->1962|4371->2013|4497->2116|4661->2244|4854->2415|5080->2605|5190->2693|5268->2736|5313->2772|5332->2782|5380->2792|5447->2823|5461->2828|5491->2836|5534->2848|5576->2855|5614->2884|5633->2894|5681->2904|5748->2935|5762->2940|5792->2948|5835->2960|5986->3075|6046->3126|6086->3128|6115->3138|6128->3142|6167->3143|6213->3156|6257->3165|6379->3264|6420->3270|6528->3356|6731->3523|6751->3534|6821->3582|7326->4051|7346->4062|7415->4109|7789->4448|7831->4481|7850->4491|7898->4501|7964->4531|7978->4536|8008->4544|8050->4555|8245->4714|8306->4766|8346->4768|8375->4778|8388->4782|8427->4783|8473->4796|8516->4804|8651->4916|8692->4922|8801->5009|8969->5140|8990->5151|9071->5209|9337->5439|9381->5473|9401->5483|9450->5493|9518->5524|9533->5529|9564->5537|9608->5549|9762->5666|9819->5713|9860->5715|9890->5725|9904->5729|9944->5730|9991->5743|10035->5751|10151->5844|10202->5859|10240->5887|10260->5897|10309->5907|10376->5937|10391->5942|10422->5950|10465->5961
                    LINES: 26->1|31->4|31->4|32->1|33->4|40->11|40->11|40->11|40->11|40->11|40->11|40->11|40->11|40->11|40->11|40->11|40->11|40->11|43->14|43->14|43->14|44->15|44->15|44->15|44->15|44->15|44->15|44->15|44->15|44->15|49->20|49->20|50->21|50->21|50->21|50->21|50->21|50->21|54->25|54->25|54->25|54->25|55->26|55->26|57->28|57->28|57->28|57->28|58->29|58->29|58->29|59->30|65->36|65->36|65->36|65->36|65->36|65->36|65->36|67->38|67->38|71->42|72->43|77->48|77->48|81->52|81->52|81->52|81->52|82->53|82->53|82->53|83->54|84->55|84->55|84->55|84->55|85->56|85->56|85->56|86->57|91->62|91->62|91->62|91->62|91->62|91->62|91->62|92->63|92->63|93->64|93->64|97->68|97->68|97->68|106->77|106->77|106->77|115->86|115->86|115->86|115->86|116->87|116->87|116->87|117->88|123->94|123->94|123->94|123->94|123->94|123->94|123->94|124->95|124->95|125->96|125->96|130->101|130->101|130->101|138->109|138->109|138->109|138->109|139->110|139->110|139->110|140->111|144->115|144->115|144->115|144->115|144->115|144->115|144->115|145->116|145->116|147->118|147->118|147->118|147->118|148->119|148->119|148->119|149->120
                    -- GENERATED --
                */
            