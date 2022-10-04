
package views.html.presupuesto.lineaRecursoPresupuestario

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
object formLineaRecurso extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[LineaRecursoPresupuestario],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[LineaRecursoPresupuestario]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.47*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/if(flash.containsKey("error"))/*5.32*/ {_display_(Seq[Any](format.raw/*5.34*/("""
	<div class="alert alert-danger">
		<i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*7.52*/flash/*7.57*/.get("error"))),format.raw/*7.70*/("""
	</div>
""")))})),format.raw/*9.2*/("""

 <div class="row">
	"""),_display_(Seq[Any](/*12.3*/inputText(lineaForm("credito_presupuestario_id"), 'type -> "hidden"))),format.raw/*12.71*/("""
	<div class="col-sm-6">
		<div class="form-group """),_display_(Seq[Any](/*14.27*/if(lineaForm.error("cuenta_analitica_id") != null)/*14.77*/ {_display_(Seq[Any](format.raw/*14.79*/("""has-error""")))}/*14.90*/else/*14.95*/{_display_(Seq[Any](format.raw/*14.96*/("""has-required""")))})),format.raw/*14.109*/("""">
			<label for="cliente" class="control-label">Cuenta Analitica</label>
			<div class="input-group">
				"""),_display_(Seq[Any](/*17.6*/inputText(lineaForm("cuentaAnalitica.nombre"), 'class -> "form-control", 'autofocus -> "autofocus", 'id -> "cuentaAnalitica"))),format.raw/*17.131*/("""
				"""),_display_(Seq[Any](/*18.6*/inputText(lineaForm("cuenta_analitica_id"), 'hidden -> "hidden", 'id -> "cuenta_analitica_id"))),format.raw/*18.100*/("""
				<span class="input-group-addon">
					<a href="#" 
					   id="searchCuentaAnalitica" 
					   class="searchModal"
					   data-title="Selección de Cuenta Analitica" 
					   data-url=""""),_display_(Seq[Any](/*24.20*/controllers/*24.31*/.contabilidad.routes.CuentasAnaliticasController.modalBuscar())),format.raw/*24.93*/("""" 
					   data-height="650" 
					   data-width="700" 
					   data-listen="modal.seleccion.cuentaAnalitica.simple" 
					   data-label="#cuentaAnalitica" data-field="#cuenta_analitica_id">
					   <i class="glyphicon glyphicon-search"></i>
					 </a>
				</span>
			</div>
			"""),_display_(Seq[Any](/*33.5*/lineaForm("cuenta_analitica_id")/*33.37*/.error.map/*33.47*/{ error =>_display_(Seq[Any](format.raw/*33.57*/(""" <div class="text-error">"""),_display_(Seq[Any](/*33.83*/error/*33.88*/.message)),format.raw/*33.96*/("""</div>""")))})),format.raw/*33.103*/("""
		</div>
	</div>
	<div class="col-sm-3">
		<div class="form-group """),_display_(Seq[Any](/*37.27*/if(lineaForm.error("monto") != null)/*37.63*/ {_display_(Seq[Any](format.raw/*37.65*/("""has-error""")))}/*37.76*/else/*37.81*/{_display_(Seq[Any](format.raw/*37.82*/("""has-required""")))})),format.raw/*37.95*/("""">
			<label for="monton" class="control-label">Monto</label>
			"""),_display_(Seq[Any](/*39.5*/inputText(lineaForm("monto"), 'class -> "form-control", 'id -> "monto"))),format.raw/*39.76*/("""
			"""),_display_(Seq[Any](/*40.5*/lineaForm("monto")/*40.23*/.error.map/*40.33*/{ error =>_display_(Seq[Any](format.raw/*40.43*/(""" <div class="text-error">"""),_display_(Seq[Any](/*40.69*/error/*40.74*/.message)),format.raw/*40.82*/("""</div>""")))})),format.raw/*40.89*/("""
		</div>	
	</div>
</div>
<div class="row">
	<div class="col-sm-9">
		<div class="form-group">
			<label for="monton" class="control-label">Observacion</label>
			"""),_display_(Seq[Any](/*48.5*/inputText(lineaForm("nombre"), 'class -> "form-control", 'id -> "nombre"))),format.raw/*48.78*/("""
			"""),_display_(Seq[Any](/*49.5*/lineaForm("nombre")/*49.24*/.error.map/*49.34*/{ error =>_display_(Seq[Any](format.raw/*49.44*/(""" <div class="text-error">"""),_display_(Seq[Any](/*49.70*/error/*49.75*/.message)),format.raw/*49.83*/("""</div>""")))})),format.raw/*49.90*/("""
		</div>	
	</div>
</div>

<script>
$(function()"""),format.raw/*55.13*/("""{"""),format.raw/*55.14*/("""
	$('#searchCuentaAnalitica').modalSearch();
"""),format.raw/*57.1*/("""}"""),format.raw/*57.2*/(""");
</script>"""))}
    }
    
    def render(lineaForm:Form[LineaRecursoPresupuestario]): play.api.templates.HtmlFormat.Appendable = apply(lineaForm)
    
    def f:((Form[LineaRecursoPresupuestario]) => play.api.templates.HtmlFormat.Appendable) = (lineaForm) => apply(lineaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/presupuesto/lineaRecursoPresupuestario/formLineaRecurso.scala.html
                    HASH: 0407251f941dbfc8cdeb1828f7a56b2dc0a24831
                    MATRIX: 850->1|998->67|1030->91|1104->46|1133->135|1173->141|1211->171|1250->173|1373->261|1386->266|1420->279|1462->291|1523->317|1613->385|1702->438|1761->488|1801->490|1830->501|1843->506|1882->507|1928->520|2074->631|2222->756|2264->763|2381->857|2614->1054|2634->1065|2718->1127|3041->1415|3082->1447|3101->1457|3149->1467|3211->1493|3225->1498|3255->1506|3295->1513|3403->1585|3448->1621|3488->1623|3517->1634|3530->1639|3569->1640|3614->1653|3717->1721|3810->1792|3851->1798|3878->1816|3897->1826|3945->1836|4007->1862|4021->1867|4051->1875|4090->1882|4297->2054|4392->2127|4433->2133|4461->2152|4480->2162|4528->2172|4590->2198|4604->2203|4634->2211|4673->2218|4755->2272|4784->2273|4858->2320|4886->2321
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|35->7|35->7|35->7|37->9|40->12|40->12|42->14|42->14|42->14|42->14|42->14|42->14|42->14|45->17|45->17|46->18|46->18|52->24|52->24|52->24|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|65->37|65->37|65->37|65->37|65->37|65->37|65->37|67->39|67->39|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|76->48|76->48|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|83->55|83->55|85->57|85->57
                    -- GENERATED --
                */
            