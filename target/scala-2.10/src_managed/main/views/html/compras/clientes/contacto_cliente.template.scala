
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
object contacto_cliente extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[Cliente],Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(clienteForm: Form[Cliente],vista:Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.44*/("""

<div id="listaContactos" class=""""),_display_(Seq[Any](/*3.34*/if(clienteForm.data().containsKey("direcciones[0].nombre"))/*3.93*/{_display_(Seq[Any](format.raw/*3.94*/("""hide""")))})),format.raw/*3.99*/("""">
"""),_display_(Seq[Any](/*4.2*/if(!vista)/*4.12*/{_display_(Seq[Any](format.raw/*4.13*/("""
	<p><a class="btn btn-xs btn-default" id="nuevoContacto" href="#"><i class="glyphicon glyphicon-plus"></i> Agregar nuevo</a></p>
""")))})),format.raw/*6.2*/("""	

"""),_display_(Seq[Any](/*8.2*/for(direccion <- DireccionCliente.find.fetch("localidad").where().eq("cliente_id", clienteForm("id").value.toInt).findList()) yield /*8.127*/  {_display_(Seq[Any](format.raw/*8.130*/("""


	<div class="panel panel-default">

	  	<div class="panel-body">
	  	
		"""),_display_(Seq[Any](/*15.4*/if(!vista)/*15.14*/{_display_(Seq[Any](format.raw/*15.15*/("""
			<p>
			<div class="btn-group">
				<a class="btn btn-xs btn-default" id='modificarDireccion' href=""""),_display_(Seq[Any](/*18.70*/controllers/*18.81*/.compras.routes.ClientesController.formularioContacto(direccion.cliente_id, direccion.id))),format.raw/*18.170*/(""""><i class="glyphicon glyphicon-pencil"></i> Modificar</a>
				<a class="btn btn-xs btn-default" href=""""),_display_(Seq[Any](/*19.46*/controllers/*19.57*/.compras.routes.ClientesController.eliminarContacto(clienteForm("id").value.toInt, direccion.id))),format.raw/*19.153*/(""""><i class="glyphicon glyphicon-remove-circle"></i> Eliminar</a>
			</div>
			</p>
		""")))})),format.raw/*22.4*/("""
		  	
	  	<div class="row">
	  		<div class="col-sm-4"><b>Nombre:</b> """),_display_(Seq[Any](/*25.44*/direccion/*25.53*/.nombre)),format.raw/*25.60*/("""</div>
	  		<div class="col-sm-3"><b>Calle:</b>  """),_display_(Seq[Any](/*26.44*/direccion/*26.53*/.calle)),format.raw/*26.59*/("""</div>
	  		<div class="col-sm-2"><b>Número:</b>  """),_display_(Seq[Any](/*27.45*/direccion/*27.54*/.numero)),format.raw/*27.61*/("""</div>
	  		<div class="col-sm-3"><b>CP:</b>  """),_display_(Seq[Any](/*28.41*/direccion/*28.50*/.cp)),format.raw/*28.53*/("""</div>
	  		<div class="col-sm-3"><b>Localidad:</b>  """),_display_(Seq[Any](/*29.48*/if(direccion.localidad != null)/*29.79*/{_display_(Seq[Any](_display_(Seq[Any](/*29.81*/direccion/*29.90*/.localidad.nombre))))})),format.raw/*29.108*/("""</div>
	  	</div>
	  	
	  	<div class="row">
	  		<div class="col-sm-4"><b>Email:</b> """),_display_(Seq[Any](/*33.43*/direccion/*33.52*/.email)),format.raw/*33.58*/("""</div>
	  		<div class="col-sm-3"><b>Celular:</b>  """),_display_(Seq[Any](/*34.46*/direccion/*34.55*/.mobile)),format.raw/*34.62*/("""</div>
	  		<div class="col-sm-2"><b>Fijo:</b>  """),_display_(Seq[Any](/*35.43*/direccion/*35.52*/.telefono)),format.raw/*35.61*/("""</div>
	  		<div class="col-sm-3"><b>Fax:</b>  """),_display_(Seq[Any](/*36.42*/direccion/*36.51*/.fax)),format.raw/*36.55*/("""</div>
	  	</div>
	  	
	  	</div>
	</div>
""")))})),format.raw/*41.2*/("""
</div>
"""))}
    }
    
    def render(clienteForm:Form[Cliente],vista:Boolean): play.api.templates.HtmlFormat.Appendable = apply(clienteForm,vista)
    
    def f:((Form[Cliente],Boolean) => play.api.templates.HtmlFormat.Appendable) = (clienteForm,vista) => apply(clienteForm,vista)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:41 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/clientes/contacto_cliente.scala.html
                    HASH: ea2ed72bd0c4c217d6fdd2fc84943a59ee4dc7df
                    MATRIX: 817->1|953->43|1025->80|1092->139|1130->140|1166->145|1205->150|1223->160|1261->161|1424->294|1464->300|1605->425|1646->428|1764->511|1783->521|1822->522|1965->629|1985->640|2097->729|2238->834|2258->845|2377->941|2497->1030|2608->1105|2626->1114|2655->1121|2742->1172|2760->1181|2788->1187|2876->1239|2894->1248|2923->1255|3007->1303|3025->1312|3050->1315|3141->1370|3181->1401|3229->1403|3247->1412|3292->1430|3419->1521|3437->1530|3465->1536|3554->1589|3572->1598|3601->1605|3687->1655|3705->1664|3736->1673|3821->1722|3839->1731|3865->1735|3944->1783
                    LINES: 26->1|29->1|31->3|31->3|31->3|31->3|32->4|32->4|32->4|34->6|36->8|36->8|36->8|43->15|43->15|43->15|46->18|46->18|46->18|47->19|47->19|47->19|50->22|53->25|53->25|53->25|54->26|54->26|54->26|55->27|55->27|55->27|56->28|56->28|56->28|57->29|57->29|57->29|57->29|57->29|61->33|61->33|61->33|62->34|62->34|62->34|63->35|63->35|63->35|64->36|64->36|64->36|69->41
                    -- GENERATED --
                */
            