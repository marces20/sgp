
package views.html.compras.proveedores

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
object contacto_proveedor extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[Proveedor],Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(provForm: Form[Proveedor],vista:Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.43*/("""
"""),format.raw/*3.70*/(""" 
<div id="listaContactos" class=""""),_display_(Seq[Any](/*4.34*/if(provForm.data().containsKey("direcciones[0].nombre"))/*4.90*/{_display_(Seq[Any](format.raw/*4.91*/("""hide""")))})),format.raw/*4.96*/("""">
	
"""),_display_(Seq[Any](/*6.2*/if(!vista)/*6.12*/{_display_(Seq[Any](format.raw/*6.13*/("""
	<p><a class="btn btn-xs btn-default" id="nuevoContacto" href="#"><i class="glyphicon glyphicon-plus"></i> Agregar nuevo</a></p>
""")))})),format.raw/*8.2*/("""	
	
"""),_display_(Seq[Any](/*10.2*/for(direccion <- DireccionProveedor.find.fetch("localidad").where().eq("proveedor_id", provForm("id").value.toInt).findList()) yield /*10.128*/  {_display_(Seq[Any](format.raw/*10.131*/("""


	<div class="panel panel-default">

	  	<div class="panel-body">
	  	
		"""),_display_(Seq[Any](/*17.4*/if(!vista)/*17.14*/{_display_(Seq[Any](format.raw/*17.15*/("""
			<p>
			<div class="btn-group">
				<a class="btn btn-xs btn-default" id='modificarDireccion' href=""""),_display_(Seq[Any](/*20.70*/controllers/*20.81*/.compras.routes.ProveedoresController.formularioContacto(direccion.proveedor_id, direccion.id))),format.raw/*20.175*/(""""><i class="glyphicon glyphicon-pencil"></i> Modificar</a>
				<a class="btn btn-xs btn-default" href=""""),_display_(Seq[Any](/*21.46*/controllers/*21.57*/.compras.routes.ProveedoresController.eliminarContacto(provForm("id").value.toInt, direccion.id))),format.raw/*21.153*/(""""><i class="glyphicon glyphicon-remove-circle"></i> Eliminar</a>
			</div>
			</p>
		""")))})),format.raw/*24.4*/("""
		  	<div class="row">
		  	<div class="col-sm-6"><b>Nombre:</b> """),_display_(Seq[Any](/*26.44*/direccion/*26.53*/.nombre)),format.raw/*26.60*/("""</div>
		  	</div>
		  	<div class="row">
		  		<div class="col-sm-4"><b>Calle:</b>  """),_display_(Seq[Any](/*29.45*/direccion/*29.54*/.calle)),format.raw/*29.60*/("""</div>
		  		<div class="col-sm-3"><b>CP:</b>  """),_display_(Seq[Any](/*30.42*/direccion/*30.51*/.zip)),format.raw/*30.55*/("""</div>
		  		<div class="col-sm-3"><b>Número:</b>  """),_display_(Seq[Any](/*31.46*/direccion/*31.55*/.numero)),format.raw/*31.62*/("""</div>
		  	</div>
		  	<div class="row">
		  		<div class="col-sm-4"><b>Pais:</b>  """),_display_(Seq[Any](/*34.44*/if(direccion.localidad != null)/*34.75*/{_display_(Seq[Any](_display_(Seq[Any](/*34.77*/direccion/*34.86*/.localidad.provincia.pais.nombre))))})),format.raw/*34.119*/("""</div>
		  		<div class="col-sm-3"><b>Provincia:</b>  """),_display_(Seq[Any](/*35.49*/if(direccion.localidad != null)/*35.80*/{_display_(Seq[Any](_display_(Seq[Any](/*35.82*/direccion/*35.91*/.localidad.provincia.nombre))))})),format.raw/*35.119*/("""</div>
		  		<div class="col-sm-3"><b>Localidad:</b>  """),_display_(Seq[Any](/*36.49*/if(direccion.localidad != null)/*36.80*/{_display_(Seq[Any](_display_(Seq[Any](/*36.82*/direccion/*36.91*/.localidad.nombre))))})),format.raw/*36.109*/("""</div>
		  	</div>
		  	<div class="row">
		  		<div class="col-sm-4"><b>Email:</b> """),_display_(Seq[Any](/*39.44*/if(direccion.email != null)/*39.71*/{_display_(Seq[Any](_display_(Seq[Any](/*39.73*/direccion/*39.82*/.email))))})),format.raw/*39.89*/("""</div>
		  		<div class="col-sm-3"><b>Celular:</b>  """),_display_(Seq[Any](/*40.47*/if(direccion.mobile != null)/*40.75*/{_display_(Seq[Any](_display_(Seq[Any](/*40.77*/direccion/*40.86*/.mobile))))})),format.raw/*40.94*/("""</div>
		  		<div class="col-sm-2"><b>Fijo:</b>  """),_display_(Seq[Any](/*41.44*/if(direccion.telefono != null)/*41.74*/{_display_(Seq[Any](_display_(Seq[Any](/*41.76*/direccion/*41.85*/.telefono))))})),format.raw/*41.95*/("""</div>
		  		<div class="col-sm-3"><b>Fax:</b>  """),_display_(Seq[Any](/*42.43*/if(direccion.fax != null)/*42.68*/{_display_(Seq[Any](_display_(Seq[Any](/*42.70*/direccion/*42.79*/.fax))))})),format.raw/*42.84*/("""</div>
		  	</div>
	  	
	  	</div>
	</div>
""")))})),format.raw/*47.2*/("""
</div>"""))}
    }
    
    def render(provForm:Form[Proveedor],vista:Boolean): play.api.templates.HtmlFormat.Appendable = apply(provForm,vista)
    
    def f:((Form[Proveedor],Boolean) => play.api.templates.HtmlFormat.Appendable) = (provForm,vista) => apply(provForm,vista)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:46 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/proveedores/contacto_proveedor.scala.html
                    HASH: e23a75f6651ac1226eecfb1214b5c61f25637c20
                    MATRIX: 824->1|968->63|1000->87|1074->42|1103->131|1174->167|1238->223|1276->224|1312->229|1354->237|1372->247|1410->248|1573->381|1615->388|1758->514|1800->517|1918->600|1937->610|1976->611|2119->718|2139->729|2256->823|2397->928|2417->939|2536->1035|2656->1124|2761->1193|2779->1202|2808->1209|2933->1298|2951->1307|2979->1313|3064->1362|3082->1371|3108->1375|3197->1428|3215->1437|3244->1444|3368->1532|3408->1563|3456->1565|3474->1574|3534->1607|3626->1663|3666->1694|3714->1696|3732->1705|3787->1733|3879->1789|3919->1820|3967->1822|3985->1831|4030->1849|4154->1937|4190->1964|4238->1966|4256->1975|4289->1982|4379->2036|4416->2064|4464->2066|4482->2075|4516->2083|4603->2134|4642->2164|4690->2166|4708->2175|4744->2185|4830->2235|4864->2260|4912->2262|4930->2271|4961->2276|5041->2325
                    LINES: 26->1|29->3|29->3|30->1|31->3|32->4|32->4|32->4|32->4|34->6|34->6|34->6|36->8|38->10|38->10|38->10|45->17|45->17|45->17|48->20|48->20|48->20|49->21|49->21|49->21|52->24|54->26|54->26|54->26|57->29|57->29|57->29|58->30|58->30|58->30|59->31|59->31|59->31|62->34|62->34|62->34|62->34|62->34|63->35|63->35|63->35|63->35|63->35|64->36|64->36|64->36|64->36|64->36|67->39|67->39|67->39|67->39|67->39|68->40|68->40|68->40|68->40|68->40|69->41|69->41|69->41|69->41|69->41|70->42|70->42|70->42|70->42|70->42|75->47
                    -- GENERATED --
                */
            