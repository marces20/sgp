
package views.html.patrimonio.ordenesProvision

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
object modalAnularProductosPedientes extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[DynamicForm,Long,List[Factura],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm,ordenId:Long,listaFacturas:List[Factura]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.70*/("""
"""),format.raw/*3.70*/(""" 
	
"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.patrimonio.routes.OrdenesProvisionController.anularProductosPediente(), 'id -> "formAnularProductosPediente")/*5.144*/ {_display_(Seq[Any](format.raw/*5.146*/("""	
	
	"""),_display_(Seq[Any](/*7.3*/if(listaFacturas.size() > 0)/*7.31*/{_display_(Seq[Any](format.raw/*7.32*/("""
		<p style="font-weight:bold;font-size:20px; color:red;">ESTA ORDEN POSEE FACTURAS O PAGOS EN PROCESO !!!</p>	
	""")))})),format.raw/*9.3*/("""  
	
	"""),_display_(Seq[Any](/*11.3*/views/*11.8*/.html.tags.successError())),format.raw/*11.33*/("""
	<input type="hidden" value=""""),_display_(Seq[Any](/*12.31*/ordenId)),format.raw/*12.38*/("""" name="id"/>
	<div class="row">

		<div class="col-sm-12">
			<label for="obs" class="control-label">Observaciones</label> 
			"""),_display_(Seq[Any](/*17.5*/textarea(formBuscador("observaciones"), 'class -> "form-control", 'rows -> "2", 'id -> "observaciones"))),format.raw/*17.108*/("""
		</div>

	</div>
	<div class="col-sm-5"><br />
		<button type="submit" class="btn btn-default" title="Anular Productos"><i class="glyphicon glyphicon-arrow-right"></i> Anular</button>
	</div>

""")))})),format.raw/*25.2*/("""
"""),_display_(Seq[Any](/*26.2*/flash()/*26.9*/.clear())),format.raw/*26.17*/("""
<script>
</script>	"""))}
    }
    
    def render(formBuscador:DynamicForm,ordenId:Long,listaFacturas:List[Factura]): play.api.templates.HtmlFormat.Appendable = apply(formBuscador,ordenId,listaFacturas)
    
    def f:((DynamicForm,Long,List[Factura]) => play.api.templates.HtmlFormat.Appendable) = (formBuscador,ordenId,listaFacturas) => apply(formBuscador,ordenId,listaFacturas)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/ordenesProvision/modalAnularProductosPedientes.scala.html
                    HASH: 4f36586cd1bb94cb1727949864d2d97e7b332c68
                    MATRIX: 850->1|1020->88|1052->112|1126->69|1154->156|1193->161|1206->167|1351->303|1391->305|1431->311|1467->339|1505->340|1649->454|1691->461|1704->466|1751->491|1818->522|1847->529|2011->658|2137->761|2364->957|2401->959|2416->966|2446->974
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|35->7|35->7|35->7|37->9|39->11|39->11|39->11|40->12|40->12|45->17|45->17|53->25|54->26|54->26|54->26
                    -- GENERATED --
                */
            