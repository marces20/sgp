
package views.html.expediente.dispo

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
object indexDispo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[Dispo],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[Dispo], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

def /*6.2*/scripts/*6.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*6.13*/("""
	<script src=""""),_display_(Seq[Any](/*7.16*/routes/*7.22*/.Assets.at("javascripts/expediente/dispos.js"))),format.raw/*7.68*/("""" type="text/javascript"></script>
""")))};implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};def /*9.2*/getClassEstado/*9.16*/(i:Estado) = {{
	var classEstado:String = new String()
	if(i != null && i.id == 107){
		classEstado = "cancelada"
	}else if(i != null && i.id == 106){
		classEstado = "autorizado"
	}
	classEstado
	
}};
Seq[Any](format.raw/*1.75*/("""
"""),format.raw/*5.70*/(""" 
"""),format.raw/*8.2*/("""
"""),format.raw/*18.2*/("""
"""),_display_(Seq[Any](/*19.2*/views/*19.7*/.html.expediente.mainExpediente("Lista de Disposiciones", scripts)/*19.73*/ {_display_(Seq[Any](format.raw/*19.75*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Lista de Disposiciones</h1>
			</div>
			<div class="col-sm-2">
				<div class="pull-right btn-header">
					<a href=""""),_display_(Seq[Any](/*28.16*/controllers/*28.27*/.expediente.routes.DisposController.crear())),format.raw/*28.70*/("""?"""),_display_(Seq[Any](/*28.72*/UriTrack/*28.80*/.encode())),format.raw/*28.89*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nueva Dispo</a>
				</div>
			</div>
		</div>
	</div>
	<div id="actions">
		<form action="" method="GET"> 
			<div class="row">
				<div class="col-sm-2 filtrosEstados" id="filtrosEstados">
				 	<div class="btn-group">
					   
					  <button type="button" id="btn-filtro-certificado" rel="certificado" class="btn btn-default btn-filtros"><i class="glyphicon glyphicon-ok"></i><br>Activo 
					  	"""),_display_(Seq[Any](/*40.10*/checkbox(formBuscador("btnFiltro[0]"), 'hidden -> "hidden"))),format.raw/*40.69*/("""
					  </button>
					  <button type="button" id="btn-filtro-cancelado" rel="cancelado" class="btn btn-default btn-filtros"><i class="glyphicon glyphicon-minus-sign"></i><br>No Activo 
					  	"""),_display_(Seq[Any](/*43.10*/checkbox(formBuscador("btnFiltro[1]"), 'hidden -> "hidden"))),format.raw/*43.69*/("""
					  </button>
					</div>
				</div>
			 
				
				<div class="col-sm-2">
					<div class="form-group">
						<label class="control-label">Número
						"""),_display_(Seq[Any](/*52.8*/inputText(formBuscador("numero"), 'class -> "form-control"))),format.raw/*52.67*/("""
						</label>
					</div>
				</div>
				<div class="col-sm-2">
				<label class="control-label">Expediente
					<div class="input-group">
						"""),_display_(Seq[Any](/*59.8*/inputText(formBuscador("expediente.id"), 'hidden -> "hidden", 'id -> "expediente_id"))),format.raw/*59.93*/("""
						"""),_display_(Seq[Any](/*60.8*/inputText(formBuscador("expediente.nombre"), 'name -> "", 'class -> "form-control", 'id -> "expediente"))),format.raw/*60.112*/("""
						<span class="input-group-addon">
							<a href="#" class="searchModal"
										id="searchExpediente" 
										data-title="Selección de expediente" 
										data-url=""""),_display_(Seq[Any](/*65.22*/controllers/*65.33*/.expediente.routes.ExpedientesController.modalBuscar())),format.raw/*65.87*/("""" 
										data-height="650" 
										data-width="700" 
										data-listen="modal.seleccion.expediente.simple" 
										data-label="#expediente" 
										data-field="#expediente_id">
								<i class="glyphicon glyphicon-search"></i>
							</a>
						</span>
					</div>
				</label>
				</div>
					
				<div class="col-sm-2">
					<label class="control-label">Ejercicio
					"""),_display_(Seq[Any](/*80.7*/select(formBuscador("ejercicio"), Ejercicio.getEjercicios().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*80.166*/("""
					</label>
				</div>
				<div class="col-sm-2 input-group">
					<label class="control-label">Fecha</label>
					<div>
					"""),_display_(Seq[Any](/*86.7*/inputText(formBuscador("fecha_desde"), 'class -> "form-control inputDateMascara", 'id -> "fecha_desde", 'placeholder -> "Desde"))),format.raw/*86.135*/("""
					"""),_display_(Seq[Any](/*87.7*/inputText(formBuscador("fecha_hasta"), 'class -> "form-control inputDateMascara", 'id -> "fecha_hasta", 'placeholder -> "Hasta"))),format.raw/*87.135*/("""
					</div>
				</div>
				<div class="col-sm-2">
					<div class="form-group">
						<label for="" class="control-label">Institucion</label>
						"""),_display_(Seq[Any](/*93.8*/select(formBuscador("organigrama_id"), options("1"->"PARQUE","3"->"HEARM"), 
						'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*94.67*/("""
						 
					</div>
				</div>
			</div>		
			<div class="row">
				<div class="col-sm-2">
					<div class="form-group">
						<label class="control-label">Descripcion
						"""),_display_(Seq[Any](/*103.8*/inputText(formBuscador("desc"), 'class -> "form-control"))),format.raw/*103.65*/("""
						</label>
					</div>
				</div>	
				<div class="col-sm-2">
					<div class="form-group">
					<label for="nombre" class="control-label">&nbsp;</label>
					<button  class="form-control btn btn-primary"><i class="glyphicon glyphicon-search"></i> Buscar</button>
					</div>
				</div>
				<div class="col-sm-2">
					<div class="form-group">
					<label for="nombre" class="control-label">&nbsp;</label>
					<a href=""""),_display_(Seq[Any](/*116.16*/controllers/*116.27*/.expediente.routes.DisposController.index())),format.raw/*116.70*/(""""  class="form-control btn btn-default">Limpiar</a>
					</div>
				</div>
			</div>
		</form>
	</div>
	
	"""),_display_(Seq[Any](/*123.3*/if(buscador.getTotalRowCount == 0)/*123.37*/ {_display_(Seq[Any](format.raw/*123.39*/("""
        
        <div class="well">
            <em>No se encuentran dispos</em>
        </div>
        
    """)))}/*129.7*/else/*129.12*/{_display_(Seq[Any](format.raw/*129.13*/("""
		
		Mostrando """),_display_(Seq[Any](/*131.14*/buscador/*131.22*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*131.54*/(""" resultado(s). 
		
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th width="30"><input type="checkbox" name="checkAll" id="checkAll"/></th>
					<th width="30">#</th>
					<th width="30">Número</th>
					<th width="30">Expediente</th>
					<th width="30">Fecha</th>
					<th width="30">Fecha Creacion</th>
					<th>Descripcion</th>
					<th>Insti</th>
					<th>Estado</th>
					<th width="30">#</th>
				</tr>
			</thead>
			<tbody>
			"""),_display_(Seq[Any](/*149.5*/for(dispo <- buscador.getList) yield /*149.35*/ {_display_(Seq[Any](format.raw/*149.37*/("""
				<tr class="pointer """),_display_(Seq[Any](/*150.25*/getClassEstado(dispo.estado))),format.raw/*150.53*/("""" data-estado=""""),_display_(Seq[Any](/*150.69*/dispo/*150.74*/.estado_id)),format.raw/*150.84*/("""" 
				data-href=""""),_display_(Seq[Any](/*151.17*/controllers/*151.28*/.expediente.routes.DisposController.ver(dispo.id))),format.raw/*151.77*/("""&"""),_display_(Seq[Any](/*151.79*/UriTrack/*151.87*/.encode())),format.raw/*151.96*/(""""> 
					
					<td><input type="checkbox" name="check_listado[]" value=""""),_display_(Seq[Any](/*153.64*/dispo/*153.69*/.id)),format.raw/*153.72*/("""" class="notSeleccion" id="check-"""),_display_(Seq[Any](/*153.106*/dispo/*153.111*/.id)),format.raw/*153.114*/(""""/></td>
					
					<td class="notSeleccion">
						<a class="btn btn-default btn-xs notSeleccion" href=""""),_display_(Seq[Any](/*156.61*/controllers/*156.72*/.expediente.routes.DisposController.editar(dispo.id))),format.raw/*156.124*/("""&"""),_display_(Seq[Any](/*156.126*/UriTrack/*156.134*/.encode())),format.raw/*156.143*/("""">
							<i class="glyphicon glyphicon-edit"></i>
						</a>
					</td>
					<td align="center"><b>"""),_display_(Seq[Any](/*160.29*/dispo/*160.34*/.numero)),format.raw/*160.41*/("""</b></td>
					<td>"""),_display_(Seq[Any](/*161.11*/dispo/*161.16*/.expediente.getExpedienteEjercicio())),format.raw/*161.52*/("""</td>
					<td>"""),_display_(Seq[Any](/*162.11*/DateUtils/*162.20*/.formatDate(dispo.fecha))),format.raw/*162.44*/("""</td>
					<td>"""),_display_(Seq[Any](/*163.11*/DateUtils/*163.20*/.formatDate(dispo.create_date))),format.raw/*163.50*/("""</td>
					<td>"""),_display_(Seq[Any](/*164.11*/dispo/*164.16*/.descripcion)),format.raw/*164.28*/("""</td>
					<td>"""),_display_(Seq[Any](/*165.11*/if(dispo.organigrama_id.compareTo(new Long(1)) ==0)/*165.62*/{_display_(Seq[Any](format.raw/*165.63*/("""PARQUE""")))}/*165.70*/else/*165.74*/{_display_(Seq[Any](format.raw/*165.75*/("""HEARM""")))})),format.raw/*165.81*/("""</td>
					<td class="estado">"""),_display_(Seq[Any](/*166.26*/if(dispo.estado != null)/*166.50*/{_display_(Seq[Any](_display_(Seq[Any](/*166.52*/(dispo.estado.nombre)))))})),format.raw/*166.74*/("""</td>
					<td>
						<a class="btn btn-default btn-xs delete-confirm-link notSeleccion" 
							href=""""),_display_(Seq[Any](/*169.15*/controllers/*169.26*/.expediente.routes.DisposController.eliminar(dispo.id))),format.raw/*169.80*/("""&"""),_display_(Seq[Any](/*169.82*/UriTrack/*169.90*/.encode())),format.raw/*169.99*/("""">
							<i class="glyphicon glyphicon-trash icono-eliminar"></i>
						</a>
						 
					</td>
				</tr>
             """)))})),format.raw/*175.15*/("""
	        </tbody>
        </table>
		
		<div class="pagination pull-right">
		    """),_display_(Seq[Any](/*180.8*/views/*180.13*/.html.helpers.paginador(buscador, controllers.expediente.routes.DisposController.index()))),format.raw/*180.102*/("""
		</div>
 	 """)))})),format.raw/*182.5*/("""
<script>
$( function()"""),format.raw/*184.14*/("""{"""),format.raw/*184.15*/("""
	$('#searchExpediente').modalSearch();	
"""),format.raw/*186.1*/("""}"""),format.raw/*186.2*/(""");
</script>	 	 
""")))})),format.raw/*188.2*/("""	"""))}
    }
    
    def render(buscador:utils.pagination.Pagination[Dispo],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[Dispo],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:36 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/expediente/dispo/indexDispo.scala.html
                    HASH: 9bdbda39592f2d3f9d9ef15da4d6959d16a23d26
                    MATRIX: 836->1|1043->207|1057->214|1141->218|1193->235|1207->241|1274->287|1342->135|1374->159|1431->327|1453->341|1691->74|1720->203|1749->324|1778->549|1816->552|1829->557|1904->623|1944->625|2192->837|2212->848|2277->891|2315->893|2332->901|2363->910|2883->1394|2964->1453|3198->1651|3279->1710|3480->1876|3561->1935|3751->2090|3858->2175|3902->2184|4029->2288|4251->2474|4271->2485|4347->2539|4787->2944|4969->3103|5140->3239|5291->3367|5334->3375|5485->3503|5676->3659|5842->3803|6063->3988|6143->4045|6619->4484|6640->4495|6706->4538|6856->4652|6900->4686|6941->4688|7077->4806|7091->4811|7131->4812|7187->4831|7205->4839|7260->4871|7783->5358|7830->5388|7871->5390|7934->5416|7985->5444|8038->5460|8053->5465|8086->5475|8143->5495|8164->5506|8236->5555|8275->5557|8293->5565|8325->5574|8437->5649|8452->5654|8478->5657|8550->5691|8566->5696|8593->5699|8739->5808|8760->5819|8836->5871|8876->5873|8895->5881|8928->5890|9070->5995|9085->6000|9115->6007|9173->6028|9188->6033|9247->6069|9301->6086|9320->6095|9367->6119|9421->6136|9440->6145|9493->6175|9547->6192|9562->6197|9597->6209|9651->6226|9712->6277|9752->6278|9779->6285|9793->6289|9833->6290|9872->6296|9941->6328|9975->6352|10024->6354|10073->6376|10217->6483|10238->6494|10315->6548|10354->6550|10372->6558|10404->6567|10564->6694|10689->6783|10704->6788|10817->6877|10865->6893|10919->6918|10949->6919|11020->6962|11049->6963|11101->6983
                    LINES: 26->1|33->6|33->6|35->6|36->7|36->7|36->7|37->5|37->5|37->9|37->9|47->1|48->5|49->8|50->18|51->19|51->19|51->19|51->19|60->28|60->28|60->28|60->28|60->28|60->28|72->40|72->40|75->43|75->43|84->52|84->52|91->59|91->59|92->60|92->60|97->65|97->65|97->65|112->80|112->80|118->86|118->86|119->87|119->87|125->93|126->94|135->103|135->103|148->116|148->116|148->116|155->123|155->123|155->123|161->129|161->129|161->129|163->131|163->131|163->131|181->149|181->149|181->149|182->150|182->150|182->150|182->150|182->150|183->151|183->151|183->151|183->151|183->151|183->151|185->153|185->153|185->153|185->153|185->153|185->153|188->156|188->156|188->156|188->156|188->156|188->156|192->160|192->160|192->160|193->161|193->161|193->161|194->162|194->162|194->162|195->163|195->163|195->163|196->164|196->164|196->164|197->165|197->165|197->165|197->165|197->165|197->165|197->165|198->166|198->166|198->166|198->166|201->169|201->169|201->169|201->169|201->169|201->169|207->175|212->180|212->180|212->180|214->182|216->184|216->184|218->186|218->186|220->188
                    -- GENERATED --
                */
            