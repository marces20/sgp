
package views.html.compras.pedidosFondos

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
object formPedidoFondo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[PedidoFondo],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(pedidoForm: Form[PedidoFondo]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.33*/("""
"""),format.raw/*4.70*/(""" 
	
	<div class="row menu-acciones">
		<div class="col-sm-10">
			<button type="submit" class="btn btn-default" title="Guardar orden"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>	
																																   
	    	<a href=""""),_display_(Seq[Any](/*10.17*/if(request().getHeader("referer"))/*10.51*/{_display_(Seq[Any](format.raw/*10.52*/(""" """),_display_(Seq[Any](/*10.54*/request()/*10.63*/.getHeader("referer"))),format.raw/*10.84*/(""" """)))}/*10.87*/else/*10.92*/{_display_(Seq[Any](_display_(Seq[Any](/*10.94*/controllers/*10.105*/.compras.routes.PedidosFondosController.index())),_display_(Seq[Any](/*10.153*/UriTrack/*10.161*/.decode()))))})),format.raw/*10.171*/("""" title="Cancelar editar" class="btn btn-default"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
	    </div>
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*13.14*/UriTrack/*13.22*/.decode())),format.raw/*13.31*/("""" title="Volver al listado" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
			"""),_display_(Seq[Any](/*14.5*/if(pedidoForm.field("id").value)/*14.37*/{_display_(Seq[Any](format.raw/*14.38*/("""<a href=""""),_display_(Seq[Any](/*14.48*/controllers/*14.59*/.compras.routes.PedidosFondosController.ver(pedidoForm.field("id").value.toLong))),_display_(Seq[Any](/*14.140*/UriTrack/*14.148*/.get("&"))),format.raw/*14.157*/("""" title="Ver orden" class="btn btn-default"><i class="glyphicon glyphicon-align-justify"></i></a>""")))})),format.raw/*14.255*/("""
		</div>
	</div>
	
	<input type="hidden" name="""),_display_(Seq[Any](/*18.29*/UriTrack/*18.37*/.getKey())),format.raw/*18.46*/(""" value=""""),_display_(Seq[Any](/*18.55*/UriTrack/*18.63*/.code())),format.raw/*18.70*/("""" />
	<div class="row">
		<div class="col-sm-2">
			<label class="control-label">ID</label> 
			<div class="form-group """),_display_(Seq[Any](/*22.28*/if(pedidoForm.error("id") != null)/*22.62*/ {_display_(Seq[Any](format.raw/*22.64*/("""has-error""")))})),format.raw/*22.74*/("""">
				"""),_display_(Seq[Any](/*23.6*/inputText(pedidoForm("id"), 'id -> "id", 'class -> "form-control",'readOnly -> "readOnly"))),format.raw/*23.96*/("""
			</div>
		</div>
		
		<div class="col-sm-2">
			<label class="control-label">Fecha pedido</label> 
			<div class="form-group """),_display_(Seq[Any](/*29.28*/if(pedidoForm.error("fecha_pedido")  != null)/*29.73*/ {_display_(Seq[Any](format.raw/*29.75*/("""has-error""")))})),format.raw/*29.85*/("""">
				"""),_display_(Seq[Any](/*30.6*/inputText(pedidoForm("fecha_pedido"),'class -> "form-control date", 'autocomplete -> "off"))),format.raw/*30.97*/("""
			</div>
			"""),_display_(Seq[Any](/*32.5*/pedidoForm("fecha_pedido")/*32.31*/.error.map/*32.41*/{ error =>_display_(Seq[Any](format.raw/*32.51*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*33.30*/error/*33.35*/.message)),format.raw/*33.43*/("""</div>
			""")))})),format.raw/*34.5*/("""
		</div>
		
		<div class="col-sm-1">
			<div class="checkbox">
				<label class="control-label"> 
					Profe
					"""),_display_(Seq[Any](/*41.7*/checkbox(pedidoForm("profe")))),format.raw/*41.36*/("""
				</label>
			</div>
		</div>
	</div>"""))}
    }
    
    def render(pedidoForm:Form[PedidoFondo]): play.api.templates.HtmlFormat.Appendable = apply(pedidoForm)
    
    def f:((Form[PedidoFondo]) => play.api.templates.HtmlFormat.Appendable) = (pedidoForm) => apply(pedidoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:42 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/pedidosFondos/formPedidoFondo.scala.html
                    HASH: f799bc797c44333b3f1536af3a58efc33a98b4f9
                    MATRIX: 817->1|966->67|998->91|1072->32|1100->135|1388->387|1431->421|1470->422|1508->424|1526->433|1569->454|1590->457|1603->462|1651->464|1672->475|1751->523|1769->531|1806->541|2005->704|2022->712|2053->721|2190->823|2231->855|2270->856|2316->866|2336->877|2448->958|2466->966|2498->975|2629->1073|2713->1121|2730->1129|2761->1138|2806->1147|2823->1155|2852->1162|3008->1282|3051->1316|3091->1318|3133->1328|3176->1336|3288->1426|3453->1555|3507->1600|3547->1602|3589->1612|3632->1620|3745->1711|3795->1726|3830->1752|3849->1762|3897->1772|3963->1802|3977->1807|4007->1815|4049->1826|4200->1942|4251->1971
                    LINES: 26->1|31->4|31->4|32->1|33->4|39->10|39->10|39->10|39->10|39->10|39->10|39->10|39->10|39->10|39->10|39->10|39->10|39->10|42->13|42->13|42->13|43->14|43->14|43->14|43->14|43->14|43->14|43->14|43->14|43->14|47->18|47->18|47->18|47->18|47->18|47->18|51->22|51->22|51->22|51->22|52->23|52->23|58->29|58->29|58->29|58->29|59->30|59->30|61->32|61->32|61->32|61->32|62->33|62->33|62->33|63->34|70->41|70->41
                    -- GENERATED --
                */
            