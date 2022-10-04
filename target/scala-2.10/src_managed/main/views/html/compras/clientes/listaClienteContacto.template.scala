
package views.html.compras.clientes

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
object listaClienteContacto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Cliente],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(clienteForm: Form[Cliente]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.30*/("""
"""),format.raw/*3.70*/(""" 

<div id="listaContactos" class=""""),_display_(Seq[Any](/*5.34*/if(clienteForm.data().containsKey("direcciones[0].calle"))/*5.92*/{_display_(Seq[Any](format.raw/*5.93*/("""hide""")))})),format.raw/*5.98*/("""">
	
"""),_display_(Seq[Any](/*7.2*/for(direccion <- DireccionCliente.getDireccionesById(clienteForm("id").value.toInt)) yield /*7.86*/  {_display_(Seq[Any](format.raw/*7.89*/("""
	<p>
		<div class="btn-group">
			<a class="btn btn-xs btn-default" id="nuevoContacto" href="#"><i class="glyphicon glyphicon-plus"></i> Agregar</a>
			<a class="btn btn-xs btn-default" id='modificarDireccion' href=""""),_display_(Seq[Any](/*11.69*/controllers/*11.80*/.compras.routes.ClientesController.formularioContacto(direccion.id))),format.raw/*11.147*/(""""><i class="glyphicon glyphicon-pencil"></i> Modificar</a>
			
			<a class="btn btn-xs btn-default" href=""""),_display_(Seq[Any](/*13.45*/controllers/*13.56*/.compras.routes.ClientesController.eliminarContacto(clienteForm("id").value.toInt, direccion.id))),format.raw/*13.152*/(""""><i class="glyphicon glyphicon-remove-circle"></i> Eliminar</a>
		</div>
	</p>

	<div class="panel panel-default">
	  	<div class="panel-body">
	  	
	  	<div class="row">
	  		<div class="col-sm-6">
	  			<legend>Dirección</legend>
	  			
	  			<div class="row">
	  				<div class="col-sm-7"><b>Calle:</b> """),_display_(Seq[Any](/*25.45*/direccion/*25.54*/.calle)),format.raw/*25.60*/("""</div>
	  				<div class="col-sm-3"><b>Número:</b> """),_display_(Seq[Any](/*26.46*/direccion/*26.55*/.numero)),format.raw/*26.62*/("""</div>
	  				<div class="col-sm-2"><b>CP:</b>  """),_display_(Seq[Any](/*27.43*/direccion/*27.52*/.cp)),format.raw/*27.55*/("""</div>
	  			</div>
	  			<div class=""><b>Localidad:</b>  """),_display_(Seq[Any](/*29.41*/direccion/*29.50*/.localidad.nombre)),format.raw/*29.67*/(""". """),_display_(Seq[Any](/*29.70*/direccion/*29.79*/.localidad.provincia.nombre)),format.raw/*29.106*/(""", """),_display_(Seq[Any](/*29.109*/direccion/*29.118*/.localidad.provincia.pais.nombre)),format.raw/*29.150*/(""".</div>
	  			
	  		</div>	
	  		<div class="col-sm-6">
	  			<legend>Comunicación</legend>
			  	<div class="row">
			  		<div class="col-sm-7"><b>Email:</b> """),_display_(Seq[Any](/*35.45*/direccion/*35.54*/.email)),format.raw/*35.60*/("""</div>
			  		<div class="col-sm-5"><b>Fijo:</b>  """),_display_(Seq[Any](/*36.45*/direccion/*36.54*/.telefono)),format.raw/*36.63*/("""</div>
			  	</div>
			  	<div class="row">
			  		<div class="col-sm-6"><b>Celular:</b>  """),_display_(Seq[Any](/*39.48*/direccion/*39.57*/.mobile)),format.raw/*39.64*/("""</div>
			  		<div class="col-sm-6"><b>Fax:</b>  """),_display_(Seq[Any](/*40.44*/direccion/*40.53*/.fax)),format.raw/*40.57*/("""</div>
			  	</div>
	  		</div>  	
	  	</div>
	  	
	  	
	  	

	  	
	  	</div>
	</div>
""")))})),format.raw/*51.2*/("""
</div>"""))}
    }
    
    def render(clienteForm:Form[Cliente]): play.api.templates.HtmlFormat.Appendable = apply(clienteForm)
    
    def f:((Form[Cliente]) => play.api.templates.HtmlFormat.Appendable) = (clienteForm) => apply(clienteForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:41 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/clientes/listaClienteContacto.scala.html
                    HASH: c0a810e048ed6b623bb7058600b011cacdcf9e46
                    MATRIX: 813->1|944->50|976->74|1050->29|1079->118|1152->156|1218->214|1256->215|1292->220|1334->228|1433->312|1473->315|1731->537|1751->548|1841->615|1986->724|2006->735|2125->831|2481->1151|2499->1160|2527->1166|2616->1219|2634->1228|2663->1235|2749->1285|2767->1294|2792->1297|2890->1359|2908->1368|2947->1385|2986->1388|3004->1397|3054->1424|3094->1427|3113->1436|3168->1468|3370->1634|3388->1643|3416->1649|3504->1701|3522->1710|3553->1719|3683->1813|3701->1822|3730->1829|3817->1880|3835->1889|3861->1893|3990->1991
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|35->7|35->7|35->7|39->11|39->11|39->11|41->13|41->13|41->13|53->25|53->25|53->25|54->26|54->26|54->26|55->27|55->27|55->27|57->29|57->29|57->29|57->29|57->29|57->29|57->29|57->29|57->29|63->35|63->35|63->35|64->36|64->36|64->36|67->39|67->39|67->39|68->40|68->40|68->40|79->51
                    -- GENERATED --
                */
            