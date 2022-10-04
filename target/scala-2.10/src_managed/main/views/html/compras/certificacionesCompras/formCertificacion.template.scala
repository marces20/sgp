
package views.html.compras.certificacionesCompras

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
object formCertificacion extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[CertificacionCompra],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(certificacionForm: Form[CertificacionCompra]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.48*/("""
"""),format.raw/*4.70*/(""" 
	
	
	<div class="row menu-acciones">
		<div class="col-sm-5">
			<button type="submit" class="btn btn-default" title="Guardar orden"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>	
			<a href=""""),_display_(Seq[Any](/*10.14*/if(request().getHeader("referer"))/*10.48*/{_display_(Seq[Any](format.raw/*10.49*/(""" """),_display_(Seq[Any](/*10.51*/request()/*10.60*/.getHeader("referer"))),format.raw/*10.81*/(""" """)))}/*10.84*/else/*10.89*/{_display_(Seq[Any](_display_(Seq[Any](/*10.91*/controllers/*10.102*/.compras.routes.CertificacionesComprasController.index())),_display_(Seq[Any](/*10.159*/UriTrack/*10.167*/.decode()))))})),format.raw/*10.177*/("""" title="Cancelar editar" class="btn btn-default"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
	    </div>
	    <div class="col-sm-4">
			"""),_display_(Seq[Any](/*13.5*/if(certificacionForm("tipoCuenta").value != null)/*13.54*/{_display_(Seq[Any](format.raw/*13.55*/("""
				<span style="color:red;font-size: 25px;font-weight: bold;">"""),_display_(Seq[Any](/*14.65*/certificacionForm("tipoCuenta.nombre")/*14.103*/.value)),format.raw/*14.109*/("""</span>
			""")))})),format.raw/*15.5*/("""
		</div>
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*18.14*/UriTrack/*18.22*/.decode())),format.raw/*18.31*/("""" title="Volver al listado" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
			"""),_display_(Seq[Any](/*19.5*/if(certificacionForm.field("id").value)/*19.44*/{_display_(Seq[Any](format.raw/*19.45*/("""<a href=""""),_display_(Seq[Any](/*19.55*/controllers/*19.66*/.compras.routes.CertificacionesComprasController.ver(certificacionForm.field("id").value.toLong))),_display_(Seq[Any](/*19.163*/UriTrack/*19.171*/.get("&"))),format.raw/*19.180*/("""" title="Ver orden" class="btn btn-default"><i class="glyphicon glyphicon-align-justify"></i></a>""")))})),format.raw/*19.278*/("""
		</div>
	</div>
	
	
	"""),_display_(Seq[Any](/*24.3*/inputText(certificacionForm("id"), 'type -> "hidden", 'id -> "certificacionId"))),format.raw/*24.82*/("""
	<input type="hidden" name="""),_display_(Seq[Any](/*25.29*/UriTrack/*25.37*/.getKey())),format.raw/*25.46*/(""" value=""""),_display_(Seq[Any](/*25.55*/UriTrack/*25.63*/.code())),format.raw/*25.70*/("""" />
	<div class="row">
		<div class="col-sm-2">
			<label class="control-label">Referencia</label> 
			<div class="form-group """),_display_(Seq[Any](/*29.28*/if(certificacionForm.error("nombre") != null)/*29.73*/ {_display_(Seq[Any](format.raw/*29.75*/("""has-error""")))})),format.raw/*29.85*/("""">
				"""),_display_(Seq[Any](/*30.6*/inputText(certificacionForm("nombre"), 'class -> "form-control",'readOnly -> "readOnly"))),format.raw/*30.94*/("""
				
				"""),_display_(Seq[Any](/*32.6*/certificacionForm("nombre")/*32.33*/.error.map/*32.43*/{ error =>_display_(Seq[Any](format.raw/*32.53*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*33.31*/error/*33.36*/.message)),format.raw/*33.44*/("""</div>
				""")))})),format.raw/*34.6*/("""
			</div>
		</div>
		<div class="col-sm-4">
			<label class="control-label">Proveedor</label> 
			<div class="input-group """),_display_(Seq[Any](/*39.29*/if(certificacionForm.error("proveedor_id") != null)/*39.80*/ {_display_(Seq[Any](format.raw/*39.82*/("""has-error""")))}/*39.92*/else/*39.96*/{_display_(Seq[Any](format.raw/*39.97*/("""has-required""")))})),format.raw/*39.110*/("""">	
				"""),_display_(Seq[Any](/*40.6*/inputText(certificacionForm("proveedor.nombre"), 'class -> "form-control", 'id -> "proveedor"))),format.raw/*40.100*/("""
				"""),_display_(Seq[Any](/*41.6*/inputText(certificacionForm("proveedor_id"), 'hidden -> "hidden", 'id -> "proveedor_id"))),format.raw/*41.94*/("""
				<span class="input-group-addon">
                	<a href="#" id="searchProveedor" data-title="Selección de proveedor" data-url=""""),_display_(Seq[Any](/*43.98*/controllers/*43.109*/.compras.routes.ProveedoresController.modalBuscar())),format.raw/*43.160*/("""" data-height="650" data-width="700" data-listen="modal.seleccion.proveedor.simple" data-label="#proveedor" data-field="#proveedor_id" /> <i class="glyphicon glyphicon-search"></i></a>
                </span>
			</div>
			"""),_display_(Seq[Any](/*46.5*/certificacionForm("proveedor_id")/*46.38*/.error.map/*46.48*/{ error =>_display_(Seq[Any](format.raw/*46.58*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*47.30*/error/*47.35*/.message)),format.raw/*47.43*/("""</div>
			""")))})),format.raw/*48.5*/("""
		</div>
		<div class="col-sm-2">
			<label for="expediente" class="control-label">Expediente</label> 
			<div class="input-group """),_display_(Seq[Any](/*52.29*/if(certificacionForm.error("expediente_id") != null)/*52.81*/ {_display_(Seq[Any](format.raw/*52.83*/("""has-error""")))}/*52.93*/else/*52.97*/{_display_(Seq[Any](format.raw/*52.98*/("""has-required""")))})),format.raw/*52.111*/("""">
				"""),_display_(Seq[Any](/*53.6*/inputText(certificacionForm("expediente.expedienteEjercicio"),'class -> "form-control", 'id -> "expediente"))),format.raw/*53.114*/("""
				"""),_display_(Seq[Any](/*54.6*/inputText(certificacionForm("expediente_id"),'hidden -> "hidden", 'id -> "expediente_id"))),format.raw/*54.95*/("""
				<span class="input-group-addon"><a href="#" id="searchExpediente" data-title="Selección de expediente" data-url=""""),_display_(Seq[Any](/*55.119*/controllers/*55.130*/.expediente.routes.ExpedientesController.modalBuscar())),format.raw/*55.184*/("""" data-height="650" data-width="700" data-listen="modal.seleccion.expediente.simple" data-label="#expediente" data-field="#expediente_id"><i class="glyphicon glyphicon-search"></i></a></span>
			</div>
			"""),_display_(Seq[Any](/*57.5*/certificacionForm("expediente_id")/*57.39*/.error.map/*57.49*/{ error =>_display_(Seq[Any](format.raw/*57.59*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*58.30*/error/*58.35*/.message)),format.raw/*58.43*/("""</div>
			""")))})),format.raw/*59.5*/("""
		</div>
		
		<div class="col-sm-2">
			<label for="inputPeriodo" class="control-label">Periodo</label> 
			<div class="input-group """),_display_(Seq[Any](/*64.29*/if(certificacionForm.error("periodo_id") != null)/*64.78*/ {_display_(Seq[Any](format.raw/*64.80*/("""has-error""")))}/*64.90*/else/*64.94*/{_display_(Seq[Any](format.raw/*64.95*/("""has-required""")))})),format.raw/*64.108*/("""">
				
				"""),_display_(Seq[Any](/*66.6*/inputText(certificacionForm("periodo.nombre"),'class -> "form-control",'id -> "periodo"))),format.raw/*66.94*/("""
				"""),_display_(Seq[Any](/*67.6*/inputText(certificacionForm("periodo_id"),'hidden -> "hidden",'id -> "periodo_id"))),format.raw/*67.88*/("""
				<span class="input-group-addon">
				<a href="#" class="searchModal"
							id="searchPeriodo" 
							data-title="Selección de Periodo" 
							data-url=""""),_display_(Seq[Any](/*72.19*/controllers/*72.30*/.contabilidad.routes.PeriodosController.modalBuscar())),format.raw/*72.83*/("""" 
							data-height="650" 
							data-width="700" 
							data-listen="modal.seleccion.periodo.simple" 
							data-label="#periodo" 
							data-field="#periodo_id">
					<i class="glyphicon glyphicon-search"></i>
				</a>
				</span>
			</div>
			"""),_display_(Seq[Any](/*82.5*/certificacionForm("periodo_id")/*82.36*/.error.map/*82.46*/{ error =>_display_(Seq[Any](format.raw/*82.56*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*83.30*/error/*83.35*/.message)),format.raw/*83.43*/("""</div>
			""")))})),format.raw/*84.5*/("""
		</div>
	</div>
	
	<div class="row">
		<div class="col-sm-2">
			<label class="control-label">Orden de Compras</label> 
			<div class="input-group """),_display_(Seq[Any](/*91.29*/if(certificacionForm.error("orden_id") != null)/*91.76*/ {_display_(Seq[Any](format.raw/*91.78*/("""has-error""")))})),format.raw/*91.88*/("""">
				"""),_display_(Seq[Any](/*92.6*/inputText(certificacionForm("orden.nombre"),'class -> "form-control", 'id -> "orden"))),format.raw/*92.91*/("""
				"""),_display_(Seq[Any](/*93.6*/inputText(certificacionForm("orden_id"),'hidden -> "hidden", 'id -> "orden_id"))),format.raw/*93.85*/("""
				
				<span class="input-group-addon"><a href="#" 
				id="searchOrden" 
				data-title="Selección de orden" 
				data-url=""""),_display_(Seq[Any](/*98.16*/controllers/*98.27*/.compras.routes.OrdenesController.modalBuscar())),format.raw/*98.74*/("""" 
				data-height="650" data-width="700" 
				data-listen="modal.seleccion.orden.simple" 
				data-label="#orden" 
				data-field="#orden_id"><i class="glyphicon glyphicon-search"></i></a></span>
				
			</div>
		</div>
		
		<div class="col-sm-2">
			<label class="control-label">Fecha certificacion</label> 
			<div class="form-group """),_display_(Seq[Any](/*109.28*/if(certificacionForm.error("fecha_certificacion")  != null)/*109.87*/ {_display_(Seq[Any](format.raw/*109.89*/("""has-error""")))})),format.raw/*109.99*/("""">
				"""),_display_(Seq[Any](/*110.6*/inputText(certificacionForm("fecha_certificacion"),'class -> "form-control date", 'autocomplete -> "off"))),format.raw/*110.111*/("""
			</div>
			"""),_display_(Seq[Any](/*112.5*/certificacionForm("fecha_certificacion")/*112.45*/.error.map/*112.55*/{ error =>_display_(Seq[Any](format.raw/*112.65*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*113.30*/error/*113.35*/.message)),format.raw/*113.43*/("""</div>
			""")))})),format.raw/*114.5*/("""
		</div>
		
		<!--<div class="col-sm-1">
			<div class="checkbox">
				<label class="control-label"> 
					Profe
					"""),_display_(Seq[Any](/*121.7*/checkbox(certificacionForm("profe")))),format.raw/*121.43*/("""
				</label>
			</div>
		</div>-->
		<div class="col-sm-2">
			<div class="form-group """),_display_(Seq[Any](/*126.28*/if(certificacionForm.error("tipo_cuenta_id") != null)/*126.81*/ {_display_(Seq[Any](format.raw/*126.83*/("""has-error""")))})),format.raw/*126.93*/("""">
				<label class="control-label">Tipo Cuenta</label>
				"""),_display_(Seq[Any](/*128.6*/select(certificacionForm("tipo_cuenta_id"),TipoCuenta.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*128.170*/("""
				"""),_display_(Seq[Any](/*129.6*/certificacionForm("tipo_cuenta_id")/*129.41*/.error.map/*129.51*/{ error =>_display_(Seq[Any](format.raw/*129.61*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*130.31*/error/*130.36*/.message)),format.raw/*130.44*/("""</div>
				""")))})),format.raw/*131.6*/("""
			</div>
		</div>	
		<div class="col-sm-2">
			<div class="checkbox">
				<label class="control-label">Creacion Automatica
				"""),_display_(Seq[Any](/*137.6*/checkbox(certificacionForm("creacion_automatica")))),format.raw/*137.56*/("""</label> 
			</div>
		</div>
				
	</div>
	
	
	<div class="row">
		 
		
		
	 
		 
	</div>
	
"""))}
    }
    
    def render(certificacionForm:Form[CertificacionCompra]): play.api.templates.HtmlFormat.Appendable = apply(certificacionForm)
    
    def f:((Form[CertificacionCompra]) => play.api.templates.HtmlFormat.Appendable) = (certificacionForm) => apply(certificacionForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:44 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/certificacionesCompras/formCertificacion.scala.html
                    HASH: 47d7e7f54f22174c80cfb5b8a901f5b5bc28d85e
                    MATRIX: 836->1|1000->82|1032->106|1106->47|1134->150|1384->364|1427->398|1466->399|1504->401|1522->410|1565->431|1586->434|1599->439|1647->441|1668->452|1756->509|1774->517|1811->527|2003->684|2061->733|2100->734|2201->799|2249->837|2278->843|2321->855|2405->903|2422->911|2453->920|2590->1022|2638->1061|2677->1062|2723->1072|2743->1083|2871->1180|2889->1188|2921->1197|3052->1295|3111->1319|3212->1398|3277->1427|3294->1435|3325->1444|3370->1453|3387->1461|3416->1468|3580->1596|3634->1641|3674->1643|3716->1653|3759->1661|3869->1749|3915->1760|3951->1787|3970->1797|4018->1807|4085->1838|4099->1843|4129->1851|4172->1863|4332->1987|4392->2038|4432->2040|4461->2050|4474->2054|4513->2055|4559->2068|4603->2077|4720->2171|4761->2177|4871->2265|5042->2400|5063->2411|5137->2462|5395->2685|5437->2718|5456->2728|5504->2738|5570->2768|5584->2773|5614->2781|5656->2792|5824->2924|5885->2976|5925->2978|5954->2988|5967->2992|6006->2993|6052->3006|6095->3014|6226->3122|6267->3128|6378->3217|6534->3336|6555->3347|6632->3401|6873->3607|6916->3641|6935->3651|6983->3661|7049->3691|7063->3696|7093->3704|7135->3715|7305->3849|7363->3898|7403->3900|7432->3910|7445->3914|7484->3915|7530->3928|7578->3941|7688->4029|7729->4035|7833->4117|8030->4278|8050->4289|8125->4342|8413->4595|8453->4626|8472->4636|8520->4646|8586->4676|8600->4681|8630->4689|8672->4700|8858->4850|8914->4897|8954->4899|8996->4909|9039->4917|9146->5002|9187->5008|9288->5087|9453->5216|9473->5227|9542->5274|9916->5611|9985->5670|10026->5672|10069->5682|10113->5690|10242->5795|10293->5810|10343->5850|10363->5860|10412->5870|10479->5900|10494->5905|10525->5913|10568->5924|10724->6044|10783->6080|10908->6168|10971->6221|11012->6223|11055->6233|11152->6294|11340->6458|11382->6464|11427->6499|11447->6509|11496->6519|11564->6550|11579->6555|11610->6563|11654->6575|11820->6705|11893->6755
                    LINES: 26->1|31->4|31->4|32->1|33->4|39->10|39->10|39->10|39->10|39->10|39->10|39->10|39->10|39->10|39->10|39->10|39->10|39->10|42->13|42->13|42->13|43->14|43->14|43->14|44->15|47->18|47->18|47->18|48->19|48->19|48->19|48->19|48->19|48->19|48->19|48->19|48->19|53->24|53->24|54->25|54->25|54->25|54->25|54->25|54->25|58->29|58->29|58->29|58->29|59->30|59->30|61->32|61->32|61->32|61->32|62->33|62->33|62->33|63->34|68->39|68->39|68->39|68->39|68->39|68->39|68->39|69->40|69->40|70->41|70->41|72->43|72->43|72->43|75->46|75->46|75->46|75->46|76->47|76->47|76->47|77->48|81->52|81->52|81->52|81->52|81->52|81->52|81->52|82->53|82->53|83->54|83->54|84->55|84->55|84->55|86->57|86->57|86->57|86->57|87->58|87->58|87->58|88->59|93->64|93->64|93->64|93->64|93->64|93->64|93->64|95->66|95->66|96->67|96->67|101->72|101->72|101->72|111->82|111->82|111->82|111->82|112->83|112->83|112->83|113->84|120->91|120->91|120->91|120->91|121->92|121->92|122->93|122->93|127->98|127->98|127->98|138->109|138->109|138->109|138->109|139->110|139->110|141->112|141->112|141->112|141->112|142->113|142->113|142->113|143->114|150->121|150->121|155->126|155->126|155->126|155->126|157->128|157->128|158->129|158->129|158->129|158->129|159->130|159->130|159->130|160->131|166->137|166->137
                    -- GENERATED --
                */
            