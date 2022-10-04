
package views.html.compras.proveedoresDatosDgr

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
object formLineaDatosDgr extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[ProveedorDatoDgr],ProveedorDatoDgr,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[ProveedorDatoDgr],linea:ProveedorDatoDgr):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.60*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/if(flash.containsKey("error"))/*5.32*/ {_display_(Seq[Any](format.raw/*5.34*/("""
	<div class="alert alert-danger">
		<i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*7.52*/flash/*7.57*/.get("error"))),format.raw/*7.70*/("""
	</div>
""")))})),format.raw/*9.2*/("""

<script>
$(function()"""),format.raw/*12.13*/("""{"""),format.raw/*12.14*/("""
	$("#descuento, #cantidad").numeric_input();
	$("#periodo_fiscal").mask("999999");
	$("#regimen").mask("999");
	$("#alicuota").mask("99.99");
	$("#numero_documento").mask("99999999");
"""),format.raw/*18.1*/("""}"""),format.raw/*18.2*/(""");
</script>
 <div class="row">
	"""),_display_(Seq[Any](/*21.3*/inputText(lineaForm("cuit"), 'type -> "hidden"))),format.raw/*21.50*/("""
	 
	<div class="col-sm-2">
		<label class="control-label">Periodo</label>
		<div class="form-group """),_display_(Seq[Any](/*25.27*/if(lineaForm.error("periodo_fiscal") != null)/*25.72*/ {_display_(Seq[Any](format.raw/*25.74*/("""has-error""")))}/*25.85*/else/*25.90*/{_display_(Seq[Any](format.raw/*25.91*/("""has-required""")))})),format.raw/*25.104*/("""">
			"""),_display_(Seq[Any](/*26.5*/inputText(lineaForm("periodo_fiscal"), 'class -> "form-control", 'id -> "periodo_fiscal"))),format.raw/*26.94*/("""
			"""),_display_(Seq[Any](/*27.5*/lineaForm("periodo_fiscal")/*27.32*/.error.map/*27.42*/{ error =>_display_(Seq[Any](format.raw/*27.52*/(""" <div class="text-error">"""),_display_(Seq[Any](/*27.78*/error/*27.83*/.message)),format.raw/*27.91*/("""</div>""")))})),format.raw/*27.98*/("""
		</div>
	</div> 
	
	<div class="col-sm-2">
		 
		<div class="form-group """),_display_(Seq[Any](/*33.27*/if(lineaForm.error("proveedor_dgr_dato_regimen_id") != null)/*33.87*/ {_display_(Seq[Any](format.raw/*33.89*/("""has-error""")))}/*33.99*/else/*33.103*/{_display_(Seq[Any](format.raw/*33.104*/("""has-required""")))})),format.raw/*33.117*/("""">
			<label for=""""),_display_(Seq[Any](/*34.17*/lineaForm("proveedor_dgr_dato_regimen_id"))),format.raw/*34.59*/("""" class="control-label">Regimen</label>
			"""),_display_(Seq[Any](/*35.5*/select(lineaForm("proveedor_dgr_dato_regimen_id"), 
			ProveedorDatoDgrRegimen.find.all().map { p => p.id.toString -> p.descripcion}, 
			'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*37.64*/(""", 
			
			"""),_display_(Seq[Any](/*39.5*/lineaForm("proveedor_dgr_dato_regimen_id")/*39.47*/.error.map/*39.57*/{ error =>_display_(Seq[Any](format.raw/*39.67*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*40.30*/error/*40.35*/.message)),format.raw/*40.43*/("""</div>
			""")))})),format.raw/*41.5*/("""
		</div>
	</div> 
	<div class="col-sm-2">
		<label class="control-label">Alicuota</label>
		<div class="form-group """),_display_(Seq[Any](/*46.27*/if(lineaForm.error("alicuota") != null)/*46.66*/ {_display_(Seq[Any](format.raw/*46.68*/("""has-error""")))}/*46.79*/else/*46.84*/{_display_(Seq[Any](format.raw/*46.85*/("""has-required""")))})),format.raw/*46.98*/("""">
			"""),_display_(Seq[Any](/*47.5*/inputText(lineaForm("alicuota"), 'class -> "form-control", 'id -> "alicuota"))),format.raw/*47.82*/("""
			"""),_display_(Seq[Any](/*48.5*/lineaForm("alicuota")/*48.26*/.error.map/*48.36*/{ error =>_display_(Seq[Any](format.raw/*48.46*/(""" <div class="text-error">"""),_display_(Seq[Any](/*48.72*/error/*48.77*/.message)),format.raw/*48.85*/("""</div>""")))})),format.raw/*48.92*/("""
		</div>
	</div> 
	<div class="col-sm-6">
		<label class="control-label">Razon Social</label>
		<div class="form-group """),_display_(Seq[Any](/*53.27*/if(lineaForm.error("razon_social") != null)/*53.70*/ {_display_(Seq[Any](format.raw/*53.72*/("""has-error""")))}/*53.83*/else/*53.88*/{_display_(Seq[Any](format.raw/*53.89*/("""has-required""")))})),format.raw/*53.102*/("""">
			"""),_display_(Seq[Any](/*54.5*/inputText(lineaForm("razon_social"), 'class -> "form-control", 'id -> "razon_social"))),format.raw/*54.90*/("""
			"""),_display_(Seq[Any](/*55.5*/lineaForm("razon_social")/*55.30*/.error.map/*55.40*/{ error =>_display_(Seq[Any](format.raw/*55.50*/(""" <div class="text-error">"""),_display_(Seq[Any](/*55.76*/error/*55.81*/.message)),format.raw/*55.89*/("""</div>""")))})),format.raw/*55.96*/("""
		</div>
	</div> 
	 
</div>	
<div class="row">	
	 
	<div class="col-sm-2">
		<div class="form-group """),_display_(Seq[Any](/*63.27*/if(lineaForm.error("proveedor_dgr_dato_motivo_id") != null)/*63.86*/ {_display_(Seq[Any](format.raw/*63.88*/("""has-error""")))}/*63.98*/else/*63.102*/{_display_(Seq[Any](format.raw/*63.103*/("""has-required""")))})),format.raw/*63.116*/("""">
			<label for=""""),_display_(Seq[Any](/*64.17*/lineaForm("proveedor_dgr_dato_motivo_id"))),format.raw/*64.58*/("""" class="control-label">Motivo</label>
			"""),_display_(Seq[Any](/*65.5*/select(lineaForm("proveedor_dgr_dato_motivo_id"), 
			ProveedorDatoDgrMotivo.find.all().map { p => p.id.toString -> p.descripcion}, 
			'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*67.64*/(""", 
			
			"""),_display_(Seq[Any](/*69.5*/lineaForm("proveedor_dgr_dato_motivo_id")/*69.46*/.error.map/*69.56*/{ error =>_display_(Seq[Any](format.raw/*69.66*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*70.30*/error/*70.35*/.message)),format.raw/*70.43*/("""</div>
			""")))})),format.raw/*71.5*/("""
		</div>
	</div> 
	
	<div class="col-sm-4">
		<label class="control-label">Tipo Contr.</label>
		<div class="form-group """),_display_(Seq[Any](/*77.27*/if(lineaForm.error("tipo_contribuyente") != null)/*77.76*/ {_display_(Seq[Any](format.raw/*77.78*/("""has-error""")))}/*77.89*/else/*77.94*/{_display_(Seq[Any](format.raw/*77.95*/("""has-required""")))})),format.raw/*77.108*/("""">
			"""),_display_(Seq[Any](/*78.5*/inputText(lineaForm("tipo_contribuyente"), 'class -> "form-control", 'id -> "tipo_contribuyente"))),format.raw/*78.102*/("""
			"""),_display_(Seq[Any](/*79.5*/lineaForm("tipo_contribuyente")/*79.36*/.error.map/*79.46*/{ error =>_display_(Seq[Any](format.raw/*79.56*/(""" <div class="text-error">"""),_display_(Seq[Any](/*79.82*/error/*79.87*/.message)),format.raw/*79.95*/("""</div>""")))})),format.raw/*79.102*/("""
		</div>
	</div> 
	
	<div class="col-sm-2">
		<label class="control-label">Tipo Doc.</label>
		<div class="form-group """),_display_(Seq[Any](/*85.27*/if(lineaForm.error("tipo_documento") != null)/*85.72*/ {_display_(Seq[Any](format.raw/*85.74*/("""has-error""")))}/*85.85*/else/*85.90*/{_display_(Seq[Any](format.raw/*85.91*/("""has-required""")))})),format.raw/*85.104*/("""">
			"""),_display_(Seq[Any](/*86.5*/inputText(lineaForm("tipo_documento"), 'class -> "form-control", 'id -> "tipo_documento"))),format.raw/*86.94*/("""
			"""),_display_(Seq[Any](/*87.5*/lineaForm("tipo_documento")/*87.32*/.error.map/*87.42*/{ error =>_display_(Seq[Any](format.raw/*87.52*/(""" <div class="text-error">"""),_display_(Seq[Any](/*87.78*/error/*87.83*/.message)),format.raw/*87.91*/("""</div>""")))})),format.raw/*87.98*/("""
		</div>
	</div>
	
	<div class="col-sm-2">
		<label class="control-label">N° Doc.</label>
		<div class="form-group """),_display_(Seq[Any](/*93.27*/if(lineaForm.error("numero_documento") != null)/*93.74*/ {_display_(Seq[Any](format.raw/*93.76*/("""has-error""")))}/*93.87*/else/*93.92*/{_display_(Seq[Any](format.raw/*93.93*/("""has-required""")))})),format.raw/*93.106*/("""">
			"""),_display_(Seq[Any](/*94.5*/inputText(lineaForm("numero_documento"), 'class -> "form-control", 'id -> "numero_documento"))),format.raw/*94.98*/("""
			"""),_display_(Seq[Any](/*95.5*/lineaForm("numero_documento")/*95.34*/.error.map/*95.44*/{ error =>_display_(Seq[Any](format.raw/*95.54*/(""" <div class="text-error">"""),_display_(Seq[Any](/*95.80*/error/*95.85*/.message)),format.raw/*95.93*/("""</div>""")))})),format.raw/*95.100*/("""
		</div>
	</div>
	
</div>


<div class="row margin-top-20">
	<div class="col-sm-4 col-sm-offset-4">
		<button type="submit" class="btn btn-default"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>
		<a href="" class="btn btn-default cancelar"><i class="glyphicon glyphicon-floppy-remove"></i>Cancelar</a>
	</div>
</div>
"""))}
    }
    
    def render(lineaForm:Form[ProveedorDatoDgr],linea:ProveedorDatoDgr): play.api.templates.HtmlFormat.Appendable = apply(lineaForm,linea)
    
    def f:((Form[ProveedorDatoDgr],ProveedorDatoDgr) => play.api.templates.HtmlFormat.Appendable) = (lineaForm,linea) => apply(lineaForm,linea)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:42 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/proveedoresDatosDgr/formLineaDatosDgr.scala.html
                    HASH: 6f2d7935afa6399197b2c67a5a32e14a0f073756
                    MATRIX: 847->1|1008->80|1040->104|1114->59|1143->148|1183->154|1221->184|1260->186|1383->274|1396->279|1430->292|1472->304|1526->330|1555->331|1773->522|1801->523|1873->560|1942->607|2083->712|2137->757|2177->759|2206->770|2219->775|2258->776|2304->789|2347->797|2458->886|2499->892|2535->919|2554->929|2602->939|2664->965|2678->970|2708->978|2747->985|2864->1066|2933->1126|2973->1128|3002->1138|3016->1142|3056->1143|3102->1156|3158->1176|3222->1218|3302->1263|3524->1463|3572->1476|3623->1518|3642->1528|3690->1538|3757->1569|3771->1574|3801->1582|3844->1594|4002->1716|4050->1755|4090->1757|4119->1768|4132->1773|4171->1774|4216->1787|4259->1795|4358->1872|4399->1878|4429->1899|4448->1909|4496->1919|4558->1945|4572->1950|4602->1958|4641->1965|4803->2091|4855->2134|4895->2136|4924->2147|4937->2152|4976->2153|5022->2166|5065->2174|5172->2259|5213->2265|5247->2290|5266->2300|5314->2310|5376->2336|5390->2341|5420->2349|5459->2356|5605->2466|5673->2525|5713->2527|5742->2537|5756->2541|5796->2542|5842->2555|5898->2575|5961->2616|6040->2660|6260->2858|6308->2871|6358->2912|6377->2922|6425->2932|6492->2963|6506->2968|6536->2976|6579->2988|6743->3116|6801->3165|6841->3167|6870->3178|6883->3183|6922->3184|6968->3197|7011->3205|7131->3302|7172->3308|7212->3339|7231->3349|7279->3359|7341->3385|7355->3390|7385->3398|7425->3405|7587->3531|7641->3576|7681->3578|7710->3589|7723->3594|7762->3595|7808->3608|7851->3616|7962->3705|8003->3711|8039->3738|8058->3748|8106->3758|8168->3784|8182->3789|8212->3797|8251->3804|8410->3927|8466->3974|8506->3976|8535->3987|8548->3992|8587->3993|8633->4006|8676->4014|8791->4107|8832->4113|8870->4142|8889->4152|8937->4162|8999->4188|9013->4193|9043->4201|9083->4208
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|35->7|35->7|35->7|37->9|40->12|40->12|46->18|46->18|49->21|49->21|53->25|53->25|53->25|53->25|53->25|53->25|53->25|54->26|54->26|55->27|55->27|55->27|55->27|55->27|55->27|55->27|55->27|61->33|61->33|61->33|61->33|61->33|61->33|61->33|62->34|62->34|63->35|65->37|67->39|67->39|67->39|67->39|68->40|68->40|68->40|69->41|74->46|74->46|74->46|74->46|74->46|74->46|74->46|75->47|75->47|76->48|76->48|76->48|76->48|76->48|76->48|76->48|76->48|81->53|81->53|81->53|81->53|81->53|81->53|81->53|82->54|82->54|83->55|83->55|83->55|83->55|83->55|83->55|83->55|83->55|91->63|91->63|91->63|91->63|91->63|91->63|91->63|92->64|92->64|93->65|95->67|97->69|97->69|97->69|97->69|98->70|98->70|98->70|99->71|105->77|105->77|105->77|105->77|105->77|105->77|105->77|106->78|106->78|107->79|107->79|107->79|107->79|107->79|107->79|107->79|107->79|113->85|113->85|113->85|113->85|113->85|113->85|113->85|114->86|114->86|115->87|115->87|115->87|115->87|115->87|115->87|115->87|115->87|121->93|121->93|121->93|121->93|121->93|121->93|121->93|122->94|122->94|123->95|123->95|123->95|123->95|123->95|123->95|123->95|123->95
                    -- GENERATED --
                */
            