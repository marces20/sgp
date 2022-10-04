
package views.html.compras.proveedoresAtributos

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
object formLineaAtributo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[ProveedorAtributo],ProveedorAtributo,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[ProveedorAtributo],linea:ProveedorAtributo):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.62*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/if(flash.containsKey("error"))/*5.32*/ {_display_(Seq[Any](format.raw/*5.34*/("""
	<div class="alert alert-danger">
		<i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*7.52*/flash/*7.57*/.get("error"))),format.raw/*7.70*/("""
	</div>
""")))})),format.raw/*9.2*/("""

<script>
$(function()"""),format.raw/*12.13*/("""{"""),format.raw/*12.14*/("""
	$( ".date" ).mask("99/99/9999");	
"""),format.raw/*14.1*/("""}"""),format.raw/*14.2*/(""");
</script>

 <div class="row">
	"""),_display_(Seq[Any](/*18.3*/inputText(lineaForm("proveedor_id"), 'type -> "hidden"))),format.raw/*18.58*/("""
	 
	<div class="col-sm-3">
		<div class="checkbox">
			<label>
				AFIP Ganacias """),_display_(Seq[Any](/*23.20*/checkbox(lineaForm("afip_ganancia")))),format.raw/*23.56*/("""
			</label>
		</div> 
	</div>
	<div class="col-sm-3">
		<div class="checkbox">
			<label>
				Exento IVA """),_display_(Seq[Any](/*30.17*/checkbox(lineaForm("exento_iva")))),format.raw/*30.50*/("""
			</label>
		</div> 
	</div>
	
	<div class="col-sm-3">
		<div class="checkbox">
			<label>
				Exento sellos """),_display_(Seq[Any](/*38.20*/checkbox(lineaForm("exento_sello")))),format.raw/*38.55*/("""
			</label>
		</div> 
	</div>
	<!-- <div class="col-sm-3">
		<div class="form-group """),_display_(Seq[Any](/*43.27*/if(lineaForm.error("fecha_extento_dgr") != null)/*43.75*/ {_display_(Seq[Any](format.raw/*43.77*/("""has-error""")))})),format.raw/*43.87*/("""">
			<label for="fecha" class="control-label">Fecha Ext. DGR</label> 
			"""),_display_(Seq[Any](/*45.5*/inputText(lineaForm("fecha_extento_dgr"),'class -> "form-control date", 'id -> "fecha_extento_dgr"))),format.raw/*45.104*/("""
			 
		</div>
	</div> --> 
	
</div>	
<div class="row">	
	 
	<div class="col-sm-3">
		<div class="form-group """),_display_(Seq[Any](/*54.27*/if(lineaForm.error("afip_condicion") != null)/*54.72*/ {_display_(Seq[Any](format.raw/*54.74*/("""has-error""")))})),format.raw/*54.84*/("""">
			<label for="afip_condicion" class="control-label">Condicion Afip</label>
			"""),_display_(Seq[Any](/*56.5*/select(lineaForm("afip_condicion"), options("1"->"Monotributo","2"->"Responsable"), 'id -> "prioridad", 
			'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*57.64*/("""
		</div>
		"""),_display_(Seq[Any](/*59.4*/lineaForm("afip_condicion")/*59.31*/.error.map/*59.41*/{ error =>_display_(Seq[Any](format.raw/*59.51*/("""
			<div class="text-error">"""),_display_(Seq[Any](/*60.29*/error/*60.34*/.message)),format.raw/*60.42*/("""</div>
		""")))})),format.raw/*61.4*/("""
	</div> 
	<div class="col-sm-3">
		<div class="form-group """),_display_(Seq[Any](/*64.27*/if(lineaForm.error("suss_tipo") != null)/*64.67*/ {_display_(Seq[Any](format.raw/*64.69*/("""has-error""")))})),format.raw/*64.79*/("""">
			<label for="suss_tipo" class="control-label">Suss Tipo</label>
			"""),_display_(Seq[Any](/*66.5*/select(lineaForm("suss_tipo"), options("1"->"Comun","2"->"Limpieza","3"->"Seguridad","4"->"Constructora"), 'id -> "suss_tipo", 
			'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*67.64*/("""
		</div>
	</div> 
	<div class="col-sm-3">
		<div class="form-group """),_display_(Seq[Any](/*71.27*/if(lineaForm.error("dgr_condicion") != null)/*71.71*/ {_display_(Seq[Any](format.raw/*71.73*/("""has-error""")))})),format.raw/*71.83*/("""">
			<label for="dgr_condicion" class="control-label">DGR Condicion</label>
			"""),_display_(Seq[Any](/*73.5*/select(lineaForm("dgr_condicion"), options("1"->"CM","2"->"Directo","3"->"NO CM"), 'id -> "dgr_condicion", 
			'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*74.64*/("""
		</div>
	</div> 
</div>
<div class="row">
	<div class="col-sm-3">
		<div class="form-group """),_display_(Seq[Any](/*80.27*/if(lineaForm.error("fecha_extento_afip_gcia") != null)/*80.81*/ {_display_(Seq[Any](format.raw/*80.83*/("""has-error""")))})),format.raw/*80.93*/("""">
			<label for="fecha" class="control-label">Fecha Ext. Afip gcia</label> 
			"""),_display_(Seq[Any](/*82.5*/inputText(lineaForm("fecha_extento_afip_gcia"),'class -> "form-control date", 'id -> "fecha_extento_afip_gcia"))),format.raw/*82.116*/("""
			 
		</div>
	</div> 
	<div class="col-sm-3">
		<div class="form-group """),_display_(Seq[Any](/*87.27*/if(lineaForm.error("fecha_extento_afip_suss") != null)/*87.81*/ {_display_(Seq[Any](format.raw/*87.83*/("""has-error""")))})),format.raw/*87.93*/("""">
			<label for="fecha" class="control-label">Fecha Ext. Afip Suss</label> 
			"""),_display_(Seq[Any](/*89.5*/inputText(lineaForm("fecha_extento_afip_suss"),'class -> "form-control date", 'id -> "fecha_extento_afip_suss"))),format.raw/*89.116*/("""
			 
		</div>
	</div> 
	<div class="col-sm-3">
		<div class="form-group """),_display_(Seq[Any](/*94.27*/if(lineaForm.error("fecha_extento_dgr_iibb") != null)/*94.80*/ {_display_(Seq[Any](format.raw/*94.82*/("""has-error""")))})),format.raw/*94.92*/("""">
			<label for="fecha" class="control-label">Fecha Ext. DGR IIBB</label> 
			"""),_display_(Seq[Any](/*96.5*/inputText(lineaForm("fecha_extento_dgr_iibb"),'class -> "form-control date", 'id -> "fecha_extento_dgr_iibb"))),format.raw/*96.114*/("""
			 
		</div>
	</div> 
	<div class="col-sm-3">
		<div class="form-group """),_display_(Seq[Any](/*101.27*/if(lineaForm.error("fecha_extento_dgr_sellos") != null)/*101.82*/ {_display_(Seq[Any](format.raw/*101.84*/("""has-error""")))})),format.raw/*101.94*/("""">
			<label for="fecha" class="control-label">Fecha Ext. DGR Sellos</label> 
			"""),_display_(Seq[Any](/*103.5*/inputText(lineaForm("fecha_extento_dgr_sellos"),'class -> "form-control date", 'id -> "fecha_extento_dgr_sellos"))),format.raw/*103.118*/("""
			 
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
    
    def render(lineaForm:Form[ProveedorAtributo],linea:ProveedorAtributo): play.api.templates.HtmlFormat.Appendable = apply(lineaForm,linea)
    
    def f:((Form[ProveedorAtributo],ProveedorAtributo) => play.api.templates.HtmlFormat.Appendable) = (lineaForm,linea) => apply(lineaForm,linea)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:43 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/proveedoresAtributos/formLineaAtributo.scala.html
                    HASH: 06e9b52cf1afcb58373ad19ee56e5906ca04fc35
                    MATRIX: 850->1|1013->82|1045->106|1119->61|1148->150|1188->156|1226->186|1265->188|1388->276|1401->281|1435->294|1477->306|1531->332|1560->333|1625->371|1653->372|1727->411|1804->466|1928->554|1986->590|2136->704|2191->737|2347->857|2404->892|2531->983|2588->1031|2628->1033|2670->1043|2782->1120|2904->1219|3059->1338|3113->1383|3153->1385|3195->1395|3315->1480|3506->1649|3556->1664|3592->1691|3611->1701|3659->1711|3725->1741|3739->1746|3769->1754|3811->1765|3910->1828|3959->1868|3999->1870|4041->1880|4151->1955|4365->2147|4474->2220|4527->2264|4567->2266|4609->2276|4727->2359|4921->2531|5057->2631|5120->2685|5160->2687|5202->2697|5320->2780|5454->2891|5569->2970|5632->3024|5672->3026|5714->3036|5832->3119|5966->3230|6081->3309|6143->3362|6183->3364|6225->3374|6342->3456|6474->3565|6590->3644|6655->3699|6696->3701|6739->3711|6859->3795|6996->3908
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|35->7|35->7|35->7|37->9|40->12|40->12|42->14|42->14|46->18|46->18|51->23|51->23|58->30|58->30|66->38|66->38|71->43|71->43|71->43|71->43|73->45|73->45|82->54|82->54|82->54|82->54|84->56|85->57|87->59|87->59|87->59|87->59|88->60|88->60|88->60|89->61|92->64|92->64|92->64|92->64|94->66|95->67|99->71|99->71|99->71|99->71|101->73|102->74|108->80|108->80|108->80|108->80|110->82|110->82|115->87|115->87|115->87|115->87|117->89|117->89|122->94|122->94|122->94|122->94|124->96|124->96|129->101|129->101|129->101|129->101|131->103|131->103
                    -- GENERATED --
                */
            