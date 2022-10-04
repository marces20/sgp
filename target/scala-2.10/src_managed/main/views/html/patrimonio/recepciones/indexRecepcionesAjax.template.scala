
package views.html.patrimonio.recepciones

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
object indexRecepcionesAjax extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[Recepcion],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[Recepcion], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import models.auth._

import utils._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.79*/("""
"""),format.raw/*5.70*/(""" 

<div id="resultadoRecepciones">

<p><a class="btn btn-default btn-xs" href=""""),_display_(Seq[Any](/*9.45*/controllers/*9.56*/.patrimonio.routes.RecepcionesController.crear(formBuscador.get("orden_provision_id").toLong))),format.raw/*9.149*/("""" id="crearRecepcion"><i class="glyphicon glyphicon-plus"></i> Crear recepción</a></p>

	"""),_display_(Seq[Any](/*11.3*/views/*11.8*/.html.tags.successError())),format.raw/*11.33*/("""
"""),_display_(Seq[Any](/*12.2*/helper/*12.8*/.form(action = controllers.patrimonio.routes.RecepcionesController.indexAjax(), 'id -> "buscadorRecepciones")/*12.117*/ {_display_(Seq[Any](format.raw/*12.119*/("""
<div class="row">	
		
	"""),_display_(Seq[Any](/*15.3*/inputText(formBuscador("orden_provision_id"), 'type -> "hidden"))),format.raw/*15.67*/("""
	<div class="col-sm-2 input-group">
		<label class="control-label">Fecha</label>
		<div>
			"""),_display_(Seq[Any](/*19.5*/inputText(formBuscador("fecha_desde"), 'class -> "form-control inputDateMascara", 'id -> "desde", 'placeholder -> "Desde", 'autofocus -> "autofocus"))),format.raw/*19.154*/("""
			"""),_display_(Seq[Any](/*20.5*/inputText(formBuscador("fecha_hasta"), 'class -> "form-control inputDateMascara", 'id -> "hasta", 'placeholder -> "Hasta"))),format.raw/*20.127*/("""
		</div>
	</div>

	<div class="form-group col-sm-2">
		<label for="nombre" class="control-label">Remito
		"""),_display_(Seq[Any](/*26.4*/inputText(formBuscador("remito"), 'class -> "form-control"))),format.raw/*26.63*/("""
		</label>
	</div>

	<div class="form-group col-sm-2">
		<label for="nombre" class="control-label">Acta
		"""),_display_(Seq[Any](/*32.4*/inputText(formBuscador("acta_numero"), 'class -> "form-control"))),format.raw/*32.68*/("""
		</label>
	</div>

	<div class="col-sm-3">
		<div class="checkbox">
			<label class="control-label"> """),_display_(Seq[Any](/*38.35*/checkbox(formBuscador("sinActa")))),format.raw/*38.68*/(""" Sin acta asignada</label>
		</div>
	</div>

	<div class="col-sm-2">
		<div class="form-group">
		<label for="nombre" class="control-label">&nbsp;</label>
		<button  class="form-control btn btn-primary"><i class="glyphicon glyphicon-search"></i> Buscar</button>
		</div>
	</div>	
	
	
</div>
""")))})),format.raw/*51.2*/("""


   """),_display_(Seq[Any](/*54.5*/if(buscador.getTotalRowCount == 0)/*54.39*/ {_display_(Seq[Any](format.raw/*54.41*/("""
        
       <div class="well">
           <em>No se encuentran órdenes de recepción</em>
       </div>
        
    """)))}/*60.7*/else/*60.12*/{_display_(Seq[Any](format.raw/*60.13*/("""
		
		Mostrando """),_display_(Seq[Any](/*62.14*/buscador/*62.22*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*62.54*/(""" resultado(s).   
		<table id="listaRecepciones" class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th width="30"><input type="checkbox" class="check_all" data-check=".check_recepcion" /></th>
					<th width="100">Número</th>
					<th width="100">Total</th>
					<th width="100">Acta</th>
					<th width="100">Fecha</th>
					<th>Responsable</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
		        """),_display_(Seq[Any](/*76.12*/for(recepcion <- buscador.getList) yield /*76.46*/ {_display_(Seq[Any](format.raw/*76.48*/("""
				<tr class="pointer" data-url=""""),_display_(Seq[Any](/*77.36*/controllers/*77.47*/.patrimonio.routes.RemitosController.indexAjax())),format.raw/*77.95*/("""?recepcion_id="""),_display_(Seq[Any](/*77.110*/recepcion/*77.119*/.id)),format.raw/*77.122*/("""">
					<td class="notSeleccion"><input name="check_listado[]" value=""""),_display_(Seq[Any](/*78.69*/recepcion/*78.78*/.id)),format.raw/*78.81*/("""" type="checkbox" class="check_recepcion" /></td>
					<td>"""),_display_(Seq[Any](/*79.11*/(recepcion.numero))),format.raw/*79.29*/("""</td>
					<td>"""),_display_(Seq[Any](/*80.11*/(utils.NumberUtils.moneda(recepcion.total)))),format.raw/*80.54*/("""</td>
					<td>"""),_display_(Seq[Any](/*81.11*/if(recepcion.acta != null)/*81.37*/ {_display_(Seq[Any](format.raw/*81.39*/(""" """),_display_(Seq[Any](/*81.41*/recepcion/*81.50*/.acta.numero)),format.raw/*81.62*/(""" """)))})),format.raw/*81.64*/("""</td>
					<td>"""),_display_(Seq[Any](/*82.11*/(DateUtils.formatDate(recepcion.create_date)))),format.raw/*82.56*/("""</td>
					<td>"""),_display_(Seq[Any](/*83.11*/(recepcion.create_usuario.nombre))),format.raw/*83.44*/("""</td>
					<td class="notSeleccion"><a class="btn btn-default btn-xs eliminarRecepcion delete-confirm" href=""""),_display_(Seq[Any](/*84.105*/controllers/*84.116*/.patrimonio.routes.RecepcionesController.eliminar(recepcion.id))),format.raw/*84.179*/(""""><i class="glyphicon glyphicon-trash icono-eliminar"></i></a></td>
				</tr>
              	""")))})),format.raw/*86.17*/("""
			</tbody>
		</table>
		
		<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*91.8*/views/*91.13*/.html.helpers.paginador(buscador, controllers.patrimonio.routes.OrdenesProvisionController.index()))),format.raw/*91.112*/("""
		</div>
        
    """)))})),format.raw/*94.6*/("""
</div>

<script>
$( function()"""),format.raw/*98.14*/("""{"""),format.raw/*98.15*/("""
	
	
	$('.check_all').on('change', function()"""),format.raw/*101.41*/("""{"""),format.raw/*101.42*/("""
		var c = $(this).prop("checked");
		var target = $(this).attr('data-check');
		if(c) $(target).prop( "checked", true );
		else $(target).prop( "checked", false );
	"""),format.raw/*106.2*/("""}"""),format.raw/*106.3*/(""");
	
	

"""),format.raw/*110.1*/("""}"""),format.raw/*110.2*/(""")
</script>

"""),_display_(Seq[Any](/*113.2*/flash()/*113.9*/.clear())),format.raw/*113.17*/("""

"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[Recepcion],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[Recepcion],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:31 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/recepciones/indexRecepcionesAjax.scala.html
                    HASH: 05a84d78d4698de5eb410466ccf3128164d7f292
                    MATRIX: 856->1|1076->139|1108->163|1182->78|1211->207|1330->291|1349->302|1464->395|1591->487|1604->492|1651->517|1689->520|1703->526|1822->635|1863->637|1926->665|2012->729|2145->827|2317->976|2358->982|2503->1104|2652->1218|2733->1277|2882->1391|2968->1455|3114->1565|3169->1598|3505->1903|3550->1913|3593->1947|3633->1949|3779->2078|3792->2083|3831->2084|3886->2103|3903->2111|3957->2143|4444->2594|4494->2628|4534->2630|4607->2667|4627->2678|4697->2726|4749->2741|4768->2750|4794->2753|4902->2825|4920->2834|4945->2837|5042->2898|5082->2916|5135->2933|5200->2976|5253->2993|5288->3019|5328->3021|5366->3023|5384->3032|5418->3044|5452->3046|5505->3063|5572->3108|5625->3125|5680->3158|5828->3269|5849->3280|5935->3343|6063->3439|6175->3516|6189->3521|6311->3620|6369->3647|6432->3682|6461->3683|6538->3731|6568->3732|6767->3903|6796->3904|6836->3916|6865->3917|6918->3934|6934->3941|6965->3949
                    LINES: 26->1|33->5|33->5|34->1|35->5|39->9|39->9|39->9|41->11|41->11|41->11|42->12|42->12|42->12|42->12|45->15|45->15|49->19|49->19|50->20|50->20|56->26|56->26|62->32|62->32|68->38|68->38|81->51|84->54|84->54|84->54|90->60|90->60|90->60|92->62|92->62|92->62|106->76|106->76|106->76|107->77|107->77|107->77|107->77|107->77|107->77|108->78|108->78|108->78|109->79|109->79|110->80|110->80|111->81|111->81|111->81|111->81|111->81|111->81|111->81|112->82|112->82|113->83|113->83|114->84|114->84|114->84|116->86|121->91|121->91|121->91|124->94|128->98|128->98|131->101|131->101|136->106|136->106|140->110|140->110|143->113|143->113|143->113
                    -- GENERATED --
                */
            