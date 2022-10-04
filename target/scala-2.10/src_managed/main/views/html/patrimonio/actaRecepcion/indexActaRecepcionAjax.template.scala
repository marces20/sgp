
package views.html.patrimonio.actaRecepcion

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
object indexActaRecepcionAjax extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[ActaRecepcion],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[ActaRecepcion], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import models.auth._

import utils._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.83*/("""
"""),format.raw/*5.70*/(""" 


<div id="resultadoActasRecepcion">	
"""),_display_(Seq[Any](/*9.2*/views/*9.7*/.html.tags.successError())),format.raw/*9.32*/("""
"""),_display_(Seq[Any](/*10.2*/helper/*10.8*/.form(action = controllers.patrimonio.routes.ActasRecepcionController.indexAjax(), 'id -> "buscadorActasRecepcion")/*10.123*/ {_display_(Seq[Any](format.raw/*10.125*/("""
<div class="row">	
		
	"""),_display_(Seq[Any](/*13.3*/inputText(formBuscador("orden_provision_id"), 'type -> "hidden"))),format.raw/*13.67*/("""

	<div class="form-group col-sm-2">
		<label for="nombre" class="control-label">Remito
		"""),_display_(Seq[Any](/*17.4*/inputText(formBuscador("remito_numero"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*17.97*/("""
		</label>
	</div>


	<div class="col-sm-2">
		<div class="form-group">
		<label for="nombre" class="control-label">&nbsp;</label>
		<button  class="form-control btn btn-primary"><i class="glyphicon glyphicon-search"></i> Buscar</button>
		</div>
	</div>	
	
</div>
""")))})),format.raw/*30.2*/("""

   """),_display_(Seq[Any](/*32.5*/if(buscador.getTotalRowCount == 0)/*32.39*/ {_display_(Seq[Any](format.raw/*32.41*/("""
        
       <div class="well">
           <em>No se encuentran actas de recepción</em>
       </div>
        
    """)))}/*38.7*/else/*38.12*/{_display_(Seq[Any](format.raw/*38.13*/("""
		
		Mostrando """),_display_(Seq[Any](/*40.14*/buscador/*40.22*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*40.54*/(""" resultado(s).   
		<table id="listaActasRecepcion" class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th width="100">Número</th>
					<th width="100">Recepciones</th>
					<th>Total</th>
					<th>Responsable</th>
					<th width="100">Fecha</th>
					<th width="80">Tipo</th>
				</tr>
			</thead>
			<tbody>
		        """),_display_(Seq[Any](/*53.12*/for(acta <- buscador.getList) yield /*53.41*/ {_display_(Seq[Any](format.raw/*53.43*/("""
				<tr class="pointer" data-url=""""),_display_(Seq[Any](/*54.36*/controllers/*54.47*/.patrimonio.routes.ActasRecepcionLineasController.index())),format.raw/*54.104*/("""?acta_id="""),_display_(Seq[Any](/*54.114*/acta/*54.118*/.id)),format.raw/*54.121*/("""">
					<td>"""),_display_(Seq[Any](/*55.11*/acta/*55.15*/.numero)),format.raw/*55.22*/("""</td>
					<td>"""),_display_(Seq[Any](/*56.11*/acta/*56.15*/.recepciones.size())),format.raw/*56.34*/("""</td>
					<td>"""),_display_(Seq[Any](/*57.11*/utils/*57.16*/.NumberUtils.moneda(acta.total))),format.raw/*57.47*/("""</td>
					<td>"""),_display_(Seq[Any](/*58.11*/acta/*58.15*/.create_usuario.nombre)),format.raw/*58.37*/("""</td>
					<td>"""),_display_(Seq[Any](/*59.11*/DateUtils/*59.20*/.formatDate(acta.fecha))),format.raw/*59.43*/("""</td>
					<td>"""),_display_(Seq[Any](/*60.11*/if(acta.cierre)/*60.26*/ {_display_(Seq[Any](format.raw/*60.28*/("""Cierre""")))}/*60.36*/else/*60.41*/{_display_(Seq[Any](format.raw/*60.42*/("""Parcial""")))})),format.raw/*60.50*/("""</td>

				</tr>
              	""")))})),format.raw/*63.17*/("""
			</tbody>
		</table>
		
		<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*68.8*/views/*68.13*/.html.helpers.paginador(buscador, controllers.patrimonio.routes.OrdenesProvisionController.index()))),format.raw/*68.112*/("""
		</div>
        
    """)))})),format.raw/*71.6*/("""
</div>

<script>
$( function()"""),format.raw/*75.14*/("""{"""),format.raw/*75.15*/("""
	
	$("#desde, #hasta").mask("99/99/9999");
	
	var resultados = $('#resultadoActasRecepcion');
	
	$('#buscadorActasRecepcion').submit( function() """),format.raw/*81.50*/("""{"""),format.raw/*81.51*/("""
		var url = $(this).attr('action');
		
		$.get(url, $(this).serialize(), function(data)"""),format.raw/*84.49*/("""{"""),format.raw/*84.50*/("""
			resultados.replaceWith(data);
		"""),format.raw/*86.3*/("""}"""),format.raw/*86.4*/(""");
		
		return false;
	"""),format.raw/*89.2*/("""}"""),format.raw/*89.3*/(""");
	
	$('#listaActasRecepcion tbody tr').click( function()"""),format.raw/*91.54*/("""{"""),format.raw/*91.55*/("""
		var url = $(this).attr("data-url");
		var dialogo = $('<div></div>');

		dialogo.dialog("""),format.raw/*95.18*/("""{"""),format.raw/*95.19*/("""
			title: "Productos de la acta de recepción",
	    	resizable: false,
			autoOpen: true,
			modal: true,
			height: 500,
			width:850,
	        buttons: """),format.raw/*102.19*/("""{"""),format.raw/*102.20*/("""
		          Cerrar: function() """),format.raw/*103.32*/("""{"""),format.raw/*103.33*/(""" 
		            $( this ).dialog( "destroy" );
		          """),format.raw/*105.13*/("""}"""),format.raw/*105.14*/("""
		    """),format.raw/*106.7*/("""}"""),format.raw/*106.8*/(""",
	    	close: function(event, ui )"""),format.raw/*107.34*/("""{"""),format.raw/*107.35*/("""
	    		$(this).dialog( "destroy" );
	    	"""),format.raw/*109.7*/("""}"""),format.raw/*109.8*/(""",
		    open: function( event, ui ) """),format.raw/*110.35*/("""{"""),format.raw/*110.36*/("""
				$.get(url, function(data)"""),format.raw/*111.30*/("""{"""),format.raw/*111.31*/("""
					dialogo.html(data);
				"""),format.raw/*113.5*/("""}"""),format.raw/*113.6*/(""");	
		    """),format.raw/*114.7*/("""}"""),format.raw/*114.8*/("""
	    """),format.raw/*115.6*/("""}"""),format.raw/*115.7*/(""");
	"""),format.raw/*116.2*/("""}"""),format.raw/*116.3*/(""");
	
	
"""),format.raw/*119.1*/("""}"""),format.raw/*119.2*/(""")
</script>"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[ActaRecepcion],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[ActaRecepcion],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/actaRecepcion/indexActaRecepcionAjax.scala.html
                    HASH: 76c240feb8bc85b93642fbece2dc9e589c9eceba
                    MATRIX: 864->1|1088->143|1120->167|1194->82|1223->211|1302->256|1314->261|1360->286|1398->289|1412->295|1537->410|1578->412|1641->440|1727->504|1857->599|1972->692|2283->972|2326->980|2369->1014|2409->1016|2553->1143|2566->1148|2605->1149|2660->1168|2677->1176|2731->1208|3131->1572|3176->1601|3216->1603|3289->1640|3309->1651|3389->1708|3436->1718|3450->1722|3476->1725|3526->1739|3539->1743|3568->1750|3621->1767|3634->1771|3675->1790|3728->1807|3742->1812|3795->1843|3848->1860|3861->1864|3905->1886|3958->1903|3976->1912|4021->1935|4074->1952|4098->1967|4138->1969|4164->1977|4177->1982|4216->1983|4256->1991|4324->2027|4436->2104|4450->2109|4572->2208|4630->2235|4693->2270|4722->2271|4902->2423|4931->2424|5050->2515|5079->2516|5144->2554|5172->2555|5225->2581|5253->2582|5341->2642|5370->2643|5493->2738|5522->2739|5713->2901|5743->2902|5805->2935|5835->2936|5925->2997|5955->2998|5991->3006|6020->3007|6085->3043|6115->3044|6188->3089|6217->3090|6283->3127|6313->3128|6373->3159|6403->3160|6463->3192|6492->3193|6531->3204|6560->3205|6595->3212|6624->3213|6657->3218|6686->3219|6724->3229|6753->3230
                    LINES: 26->1|33->5|33->5|34->1|35->5|39->9|39->9|39->9|40->10|40->10|40->10|40->10|43->13|43->13|47->17|47->17|60->30|62->32|62->32|62->32|68->38|68->38|68->38|70->40|70->40|70->40|83->53|83->53|83->53|84->54|84->54|84->54|84->54|84->54|84->54|85->55|85->55|85->55|86->56|86->56|86->56|87->57|87->57|87->57|88->58|88->58|88->58|89->59|89->59|89->59|90->60|90->60|90->60|90->60|90->60|90->60|90->60|93->63|98->68|98->68|98->68|101->71|105->75|105->75|111->81|111->81|114->84|114->84|116->86|116->86|119->89|119->89|121->91|121->91|125->95|125->95|132->102|132->102|133->103|133->103|135->105|135->105|136->106|136->106|137->107|137->107|139->109|139->109|140->110|140->110|141->111|141->111|143->113|143->113|144->114|144->114|145->115|145->115|146->116|146->116|149->119|149->119
                    -- GENERATED --
                */
            