
package views.html.patrimonio.remitos

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
object modalCambiarRecepcion extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[DynamicForm,Long,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm,idOrdenProvision:Long = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.58*/("""
"""),format.raw/*3.70*/(""" 
	
"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.tags.successError())),format.raw/*5.32*/("""
	
"""),_display_(Seq[Any](/*7.2*/if(idOrdenProvision != null)/*7.30*/{_display_(Seq[Any](format.raw/*7.31*/("""	
	"""),_display_(Seq[Any](/*8.3*/helper/*8.9*/.form(action = controllers.patrimonio.routes.RemitosController.cambiarRecepcion(), 'id -> "formCambiarRecepcion")/*8.122*/ {_display_(Seq[Any](format.raw/*8.124*/("""	

		
		<div class="row">
			<div class="col-sm-3">
				<div class="input-group">
					<input type="text" name="recepcion_modal" id="recepcion_modal" class="form-control" value=""/>
					<input type="hidden" name="recepcion_id_modal" id="recepcion_id_modal" class="" value=""/>
					<input type="hidden" name="idOrdenProvision_modal" id="idOrdenProvision_modal" class="" value=""""),_display_(Seq[Any](/*16.102*/idOrdenProvision)),format.raw/*16.118*/(""""/>
					<span class="input-group-addon">
						<a href="#" class="searchModal"
									id="searchRecepciones" 
									data-title="Selección de recepcion" 
									data-url=""""),_display_(Seq[Any](/*21.21*/controllers/*21.32*/.patrimonio.routes.RecepcionesController.modalBuscarRecepcionesDeOrdenes(idOrdenProvision))),format.raw/*21.122*/("""" 
									data-height="650" 
									data-width="700" 
									data-listen="modal.seleccion.recepcion.simple" 
									data-label="#recepcion_modal" 
									data-field="#recepcion_id_modal">
							<i class="glyphicon glyphicon-search"></i>
						</a>
					</span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-5"><br />
				<button type="submit" class="btn btn-default" title="Cambiar Recepcion"><i class="glyphicon glyphicon-arrow-right"></i> Cambiar Recepcion</button>
			</div>
		</div>
	""")))})),format.raw/*38.3*/("""
""")))})),format.raw/*39.2*/("""
<script>
$( function()"""),format.raw/*41.14*/("""{"""),format.raw/*41.15*/("""
	$('#searchRecepciones').modalSearch();
"""),format.raw/*43.1*/("""}"""),format.raw/*43.2*/(""");
</script>
"""),_display_(Seq[Any](/*45.2*/flash()/*45.9*/.clear())))}
    }
    
    def render(formBuscador:DynamicForm,idOrdenProvision:Long): play.api.templates.HtmlFormat.Appendable = apply(formBuscador,idOrdenProvision)
    
    def f:((DynamicForm,Long) => play.api.templates.HtmlFormat.Appendable) = (formBuscador,idOrdenProvision) => apply(formBuscador,idOrdenProvision)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/remitos/modalCambiarRecepcion.scala.html
                    HASH: dcf31401cbf730998518dd0de927e75edda85810
                    MATRIX: 819->1|977->76|1009->100|1083->57|1111->144|1150->149|1162->154|1208->179|1246->183|1282->211|1320->212|1358->216|1371->222|1493->335|1533->337|1949->716|1988->732|2203->911|2223->922|2336->1012|2893->1538|2926->1540|2977->1563|3006->1564|3074->1605|3102->1606|3151->1620|3166->1627
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|35->7|35->7|35->7|36->8|36->8|36->8|36->8|44->16|44->16|49->21|49->21|49->21|66->38|67->39|69->41|69->41|71->43|71->43|73->45|73->45
                    -- GENERATED --
                */
            