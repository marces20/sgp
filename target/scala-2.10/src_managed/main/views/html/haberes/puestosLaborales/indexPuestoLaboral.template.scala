
package views.html.haberes.puestosLaborales

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
object indexPuestoLaboral extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[utils.pagination.Pagination[models.haberes.PuestoLaboral],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(buscador: utils.pagination.Pagination[models.haberes.PuestoLaboral], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

def /*8.2*/scripts/*8.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*8.13*/("""
	<script src=""""),_display_(Seq[Any](/*9.16*/routes/*9.22*/.Assets.at("javascripts/haberes/puestosLaborales.js"))),format.raw/*9.75*/("""" type="text/javascript"></script>
""")))};implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(simpleInput.render) }};def /*12.2*/getClassEstado/*12.16*/(i:Estado) = {{
	var classEstado:String = new String()
	if(i != null && i.id == 55){
		classEstado = "borrador"
	}else if(i != null && i.id == 56){
		classEstado = "cancelada"
	}else if(i != null && i.id == 109){
		classEstado = "autorizado"
	} 
	classEstado
	
}};
Seq[Any](format.raw/*1.98*/("""
"""),format.raw/*5.70*/(""" 


"""),format.raw/*10.2*/("""

"""),format.raw/*23.2*/("""

"""),_display_(Seq[Any](/*25.2*/views/*25.7*/.html.haberes.mainHaberes("Lista de puestos laborales", scripts)/*25.71*/ {_display_(Seq[Any](format.raw/*25.73*/("""

<script>
$( function()"""),format.raw/*28.14*/("""{"""),format.raw/*28.15*/(""" $('.searchModal').modalSearch();"""),format.raw/*28.48*/("""}"""),format.raw/*28.49*/(""")

</script>


	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Lista de Puestos Laborales</h1>
			</div>
	
			<div class="col-sm-5">

				<div class="btn-header pull-right">
					<a href=""""),_display_(Seq[Any](/*42.16*/controllers/*42.27*/.haberes.routes.PuestosLaboralesController.crear())),format.raw/*42.77*/("""?"""),_display_(Seq[Any](/*42.79*/UriTrack/*42.87*/.encode())),format.raw/*42.96*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-plus-sign"></i> Nuevo Puesto Laboral</a>
				</div>
				
				
			<div class="dropdown pull-right btn-header">
			  	<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-expanded="true">
			    	<i class="glyphicon glyphicon-list-alt"></i> 
			    	Reportes
			    	<span class="caret"></span>
			  	</button>
				<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
					<!--<li role="presentation"><a data-title="Altas masivas" role="menuitem" tabindex="-1" data-url=""""),_display_(Seq[Any](/*53.105*/controllers/*53.116*/.haberes.routes.PuestosLaboralesReportesController.altasMacroSueldo(false))),format.raw/*53.190*/("""" id="altasMasivas">Archivo altas MACRO SUELDOS</a></li>-->
					<li role="presentation"><a data-title="Altas masivas" role="menuitem" tabindex="-1" data-url=""""),_display_(Seq[Any](/*54.101*/controllers/*54.112*/.haberes.routes.PuestosLaboralesReportesController.altasMacroSueldo(true))),format.raw/*54.185*/("""" id="altasMasivasNuevo">Archivo altas MACRO SUELDOS NUEVO</a></li>
					<!-- <li role="presentation"><a data-title="Altas masivas" role="menuitem" tabindex="-1" data-url=""""),_display_(Seq[Any](/*55.106*/controllers/*55.117*/.haberes.routes.PuestosLaboralesReportesController.altasMasivas())),format.raw/*55.182*/("""" id="altasMasivas">Archivo altas masivas</a></li> -->
					<li role="presentation"><a data-title="Listado General" role="menuitem" tabindex="-1" data-url=""""),_display_(Seq[Any](/*56.103*/controllers/*56.114*/.haberes.routes.PuestosLaboralesReportesController.listadoPuestosLaborales())),format.raw/*56.190*/("""" id="listadoGeneral">Listado General</a></li>
				</ul>
			</div>

			<div class="dropdown pull-right btn-header ">
			  	<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-expanded="true">
			  		 <i class="glyphicon glyphicon-cog"></i>
			    	Acciones
			    	<span class="caret"></span>
			  	</button>
				<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
					"""),_display_(Seq[Any](/*67.7*/if(Permiso.check("puestoLaboralActivarDesactivarMasivo"))/*67.64*/ {_display_(Seq[Any](format.raw/*67.66*/("""
					<li role="presentation"><a data-title="Activar puesto laboral" role="menuitem" tabindex="-1" data-url=""""),_display_(Seq[Any](/*68.110*/controllers/*68.121*/.haberes.routes.PuestosLaboralesAccionesController.activar())),format.raw/*68.181*/("""" id="accionActivar">Activar</a></li>
					<li role="presentation"><a  data-title="Desactivar puesto laboral" role="menuitem" tabindex="-1" data-url=""""),_display_(Seq[Any](/*69.114*/controllers/*69.125*/.haberes.routes.PuestosLaboralesAccionesController.desactivar())),format.raw/*69.188*/("""" id="accionDesactivar">Desactivar</a></li>
				 	""")))})),format.raw/*70.8*/("""
				 	"""),_display_(Seq[Any](/*71.8*/if(Permiso.check("puestoLaboralCrearNovedadesBasicas"))/*71.63*/ {_display_(Seq[Any](format.raw/*71.65*/("""
				 	<li role="presentation"><a  data-title="Crear Novedades Basicas" role="menuitem" tabindex="-1" data-url=""""),_display_(Seq[Any](/*72.113*/controllers/*72.124*/.haberes.routes.PuestosLaboralesAccionesController.modalCrearNovedades())),format.raw/*72.196*/("""" id="accionCrearNovedadesBasica">Crear Noveades Basicas</a></li>
					""")))})),format.raw/*73.7*/("""
					"""),_display_(Seq[Any](/*74.7*/if(Permiso.check("puestoLaboralCrearNovedadesBasicas"))/*74.62*/ {_display_(Seq[Any](format.raw/*74.64*/("""
						<li> <a id="buscarDatosGananciasEnArchivos" href="#" data-url=""""),_display_(Seq[Any](/*75.71*/controllers/*75.82*/.haberes.routes.GananciasAccionesController.modalBuscarDatosGananciasEnArchivos())),format.raw/*75.163*/("""">Importar datos ganancias</a></li>
					""")))})),format.raw/*76.7*/("""
					"""),_display_(Seq[Any](/*77.7*/if(Permiso.check("puestoLaboralCrearNovedadesBasicas"))/*77.62*/ {_display_(Seq[Any](format.raw/*77.64*/("""
						<li> <a id="formularioF649" href="#" data-title="Formulario F649" data-url=""""),_display_(Seq[Any](/*78.84*/controllers/*78.95*/.haberes.routes.GananciasAccionesController.modalFormularioF649())),format.raw/*78.160*/("""">Formulario F649</a></li>
					""")))})),format.raw/*79.7*/("""
					 """),_display_(Seq[Any](/*80.8*/if(Permiso.check("puestoLaboralPasarBorrador"))/*80.55*/ {_display_(Seq[Any](format.raw/*80.57*/("""
				    	<li role="presentation"><a role="menuitem" id="accionPasarBorrador" tabindex="-1" href="#" 
				    	data-url=""""),_display_(Seq[Any](/*82.21*/controllers/*82.32*/.haberes.routes.PuestosLaboralesAccionesController.modalPasarABorrador())),format.raw/*82.104*/("""">Pasar a Borrador</a></li>
				    """)))})),format.raw/*83.10*/("""
				    """),_display_(Seq[Any](/*84.10*/if(Permiso.check("puestoLaboralPasarControlado"))/*84.59*/ {_display_(Seq[Any](format.raw/*84.61*/("""
				    	<li role="presentation"><a role="menuitem" id="accionPasarControlado" tabindex="-1" href="#" 
				    	data-url=""""),_display_(Seq[Any](/*86.21*/controllers/*86.32*/.haberes.routes.PuestosLaboralesAccionesController.modalPasarAControlado())),format.raw/*86.106*/("""">Pasar a Controlado</a></li>
				    """)))})),format.raw/*87.10*/("""
				</ul>
			</div>


			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*96.3*/views/*96.8*/.html.tags.successError())),format.raw/*96.33*/("""
	
	<div id="actions">
		<form action="" method="GET">
			<div class="row" >
					<div class="col-sm-10 filtrosEstados" id="filtrosEstados">
						<div class="btn-group">
						  <button type="button" rel="borrador" class="btn btn-default btn-filtros">
						  	<i class="glyphicon glyphicon-pencil size-14"></i><br>Borrador
						  	"""),_display_(Seq[Any](/*105.11*/checkbox(formBuscador("btnFiltro[0]"), 'hidden -> "hidden"))),format.raw/*105.70*/("""
						  </button>
						  
						 <button type="button" rel="aprobado" class="btn btn-default btn-filtros">
						  	<i class="glyphicon glyphicon-ok"></i><br>Controlado
						  	"""),_display_(Seq[Any](/*110.11*/checkbox(formBuscador("btnFiltro[1]"), 'hidden -> "hidden"))),format.raw/*110.70*/("""
						 </button>
						  
						</div>
					</div>
				</div>
				
			<div class="row">

				<div class="col-sm-4">
					<label class="control-label">Puesto laboral</label>
					<div class="input-group">
						"""),_display_(Seq[Any](/*122.8*/inputText(formBuscador("puestoLaboral.legajo.agente.apellido"),'class -> "form-control", 'id -> "puesto_laboral_todos"))),format.raw/*122.127*/("""
						"""),_display_(Seq[Any](/*123.8*/inputText(formBuscador("puesto_laboral_id"), 'hidden -> "hidden", 'id -> "puesto_laboral_todos_id"))),format.raw/*123.107*/("""
						<span class="input-group-addon">
							<a href="#" class="searchModal"
										id="searchPuestoLaboral" 
										data-title="Selección de puesto laboral" 
										data-url=""""),_display_(Seq[Any](/*128.22*/controllers/*128.33*/.haberes.routes.PuestosLaboralesController.modalBuscarTodos())),format.raw/*128.94*/("""" 
										data-height="650" 
										data-width="700" 
										data-listen="modal.seleccion.puestoLaboral.simple" 
										data-label="#puesto_laboral_todos" 
										data-field="#puesto_laboral_todos_id">
								<i class="glyphicon glyphicon-search"></i>
							</a>
						</span>
					</div>	
				</div>
				
				<div class="col-sm-2">
					<div class="form-group">
						<label for="nombre" class="control-label">Estado
						"""),_display_(Seq[Any](/*143.8*/select(formBuscador("activo"), options(""->"Indiferente", "true"->"Activos", "false"->"Inactivos"), 'class -> "form-control"))),format.raw/*143.133*/("""
						</label>
					</div>
				</div>
				
				<div class="col-sm-2 input-group">
					<label class="control-label">Fecha Posesion</label>
					<div>
					"""),_display_(Seq[Any](/*151.7*/inputText(formBuscador("fecha_desde"), 'class -> "form-control inputDateMascara", 'id -> "desde", 'placeholder -> "Desde"))),format.raw/*151.129*/("""
					"""),_display_(Seq[Any](/*152.7*/inputText(formBuscador("fecha_hasta"), 'class -> "form-control inputDateMascara", 'id -> "hasta", 'placeholder -> "Hasta"))),format.raw/*152.129*/("""
					</div>
				</div>	
				<div class="col-sm-2 input-group">
					<label class="control-label">Fecha Baja</label>
					<div>
					"""),_display_(Seq[Any](/*158.7*/inputText(formBuscador("fecha_desde_baja"), 'class -> "form-control inputDateMascara", 'id -> "desde_baja", 'placeholder -> "Desde"))),format.raw/*158.139*/("""
					"""),_display_(Seq[Any](/*159.7*/inputText(formBuscador("fecha_hasta_baja"), 'class -> "form-control inputDateMascara", 'id -> "hasta_baja", 'placeholder -> "Hasta"))),format.raw/*159.139*/("""
					</div>
				</div>	
				<div class="col-sm-2">
					<label class="control-label"> 
						C/M
						"""),_display_(Seq[Any](/*165.8*/select(formBuscador("cm"),options(""->"","SI"->"SI","NO"->"NO"), 'class -> "form-control select"))),format.raw/*165.105*/("""
					</label>
				</div>
			</div>					
			<div class="row">	
				<div class="col-sm-2">
					<div class="form-group">
					<label for="buscar" class="control-label">&nbsp;</label>
					<button  class="form-control btn btn-primary">Buscar</button>
					</div>
				</div>
				<div class="col-sm-2">
					<div class="form-group">
					<label for="limpiar" class="control-label">&nbsp;</label>
					<a href=""""),_display_(Seq[Any](/*179.16*/controllers/*179.27*/.haberes.routes.PuestosLaboralesController.index())),format.raw/*179.77*/(""""  class="form-control btn btn-default">Limpiar</a>
					</div>
				</div>
			</div>
		</form>
	</div>
	
	"""),_display_(Seq[Any](/*186.3*/if(buscador.getTotalRowCount == 0)/*186.37*/ {_display_(Seq[Any](format.raw/*186.39*/("""
        
        <div class="well">
            <em>No se encuentran Puestos Laborales</em>
        </div>
        
    """)))}/*192.7*/else/*192.12*/{_display_(Seq[Any](format.raw/*192.13*/("""
    
    	Mostrando """),_display_(Seq[Any](/*194.17*/buscador/*194.25*/.getDisplayXtoYofZ(" a "," de "))),format.raw/*194.57*/(""" resultado(s). 
		
		<table id="listaDePuesto" class="table table-striped table-bordered">
			<thead>
				<tr>
					<th width="30">
						<input type="checkbox" name="checkAll" id="checkAll"/>
					</th>
					<th width="30">#</th>
					<th>Agente</th>
					<th>Escala</th>
					<th>Cargo</th>
					<th>Departamento</th>
					<th>Fecha Posesion</th>
					<th>Fecha Baja</th>
					<th width="30">#</th>
				</tr>
			</thead>
			<tbody>
			"""),_display_(Seq[Any](/*213.5*/for(lc <- buscador.getList) yield /*213.32*/ {_display_(Seq[Any](format.raw/*213.34*/("""
				<tr data-estado=""""),_display_(Seq[Any](/*214.23*/lc/*214.25*/.estado_id)),format.raw/*214.35*/("""" class="pointer """),_display_(Seq[Any](/*214.53*/getClassEstado(lc.estado))),format.raw/*214.78*/("""" data-href=""""),_display_(Seq[Any](/*214.92*/controllers/*214.103*/.haberes.routes.PuestosLaboralesController.ver(lc.id))),format.raw/*214.156*/("""&"""),_display_(Seq[Any](/*214.158*/UriTrack/*214.166*/.encode())),format.raw/*214.175*/("""">
					<td><input type="checkbox" name="check_listado[]" value=""""),_display_(Seq[Any](/*215.64*/lc/*215.66*/.id)),format.raw/*215.69*/("""" class="notSeleccion" id="check-"""),_display_(Seq[Any](/*215.103*/lc/*215.105*/.id)),format.raw/*215.108*/(""""/></td>
					<td>
						"""),_display_(Seq[Any](/*217.8*/if(Permiso.check("puestoLaboralEditar"))/*217.48*/ {_display_(Seq[Any](format.raw/*217.50*/("""
						<a class="btn btn-default btn-xs notSeleccion"  href=""""),_display_(Seq[Any](/*218.62*/controllers/*218.73*/.haberes.routes.PuestosLaboralesController.editar(lc.id))),format.raw/*218.129*/("""&"""),_display_(Seq[Any](/*218.131*/UriTrack/*218.139*/.encode())),format.raw/*218.148*/("""">
							<i class="glyphicon glyphicon-edit"></i>
						</a>
						""")))})),format.raw/*221.8*/("""
					</td>
					<td>"""),_display_(Seq[Any](/*223.11*/(lc.legajo.agente.apellido))),format.raw/*223.38*/("""</td>
					<td>"""),_display_(Seq[Any](/*224.11*/(lc.escalaLaboral.nombre))),format.raw/*224.36*/("""</td>
					<td>"""),_display_(Seq[Any](/*225.11*/(lc.cargoLaboral.nombre))),format.raw/*225.35*/("""</td>
					<td>"""),_display_(Seq[Any](/*226.11*/if(lc.departamento_id != null)/*226.41*/{_display_(Seq[Any](_display_(Seq[Any](/*226.43*/lc/*226.45*/.departamento.nombre))))})),format.raw/*226.66*/("""</td>
					<td>"""),_display_(Seq[Any](/*227.11*/(utils.DateUtils.formatDate(lc.fecha_posesion)))),format.raw/*227.58*/("""</td>
					<td>"""),_display_(Seq[Any](/*228.11*/(utils.DateUtils.formatDate(lc.fecha_baja)))),format.raw/*228.54*/("""</td>
					<td>
						"""),_display_(Seq[Any](/*230.8*/if(Permiso.check("puestoLaboralEliminar"))/*230.50*/ {_display_(Seq[Any](format.raw/*230.52*/("""
						<a class="btn btn-default btn-xs delete-confirm-link notSeleccion"  href=""""),_display_(Seq[Any](/*231.82*/controllers/*231.93*/.haberes.routes.PuestosLaboralesController.eliminar(lc.id))),format.raw/*231.151*/("""&"""),_display_(Seq[Any](/*231.153*/UriTrack/*231.161*/.encode())),format.raw/*231.170*/("""">
							<i class="glyphicon glyphicon-trash icono-eliminar"></i>
						</a>
						""")))})),format.raw/*234.8*/("""
					</td>
				</tr>
             """)))})),format.raw/*237.15*/("""
	        </tbody>
        </table>
        
        <div class="pagination pull-right">
		    """),_display_(Seq[Any](/*242.8*/views/*242.13*/.html.helpers.paginador(buscador, controllers.haberes.routes.PuestosLaboralesController.index()))),format.raw/*242.109*/("""
		</div>
 	 """)))})),format.raw/*244.5*/("""
""")))})))}
    }
    
    def render(buscador:utils.pagination.Pagination[models.haberes.PuestoLaboral],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(buscador,formBuscador)
    
    def f:((utils.pagination.Pagination[models.haberes.PuestoLaboral],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (buscador,formBuscador) => apply(buscador,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/puestosLaborales/indexPuestoLaboral.scala.html
                    HASH: cd60d39157f8a59a5efa60ae33cd7a91bff25787
                    MATRIX: 875->1|1102->228|1116->235|1200->239|1251->255|1265->261|1339->314|1406->154|1438->178|1496->353|1519->367|1811->97|1839->222|1871->350|1900->629|1939->633|1952->638|2025->702|2065->704|2117->728|2146->729|2207->762|2236->763|2495->986|2515->997|2587->1047|2625->1049|2642->1057|2673->1066|3311->1667|3332->1678|3429->1752|3626->1912|3647->1923|3743->1996|3953->2169|3974->2180|4062->2245|4256->2402|4277->2413|4376->2489|4858->2936|4924->2993|4964->2995|5111->3105|5132->3116|5215->3176|5403->3327|5424->3338|5510->3401|5592->3452|5635->3460|5699->3515|5739->3517|5889->3630|5910->3641|6005->3713|6108->3785|6150->3792|6214->3847|6254->3849|6361->3920|6381->3931|6485->4012|6558->4054|6600->4061|6664->4116|6704->4118|6824->4202|6844->4213|6932->4278|6996->4311|7039->4319|7095->4366|7135->4368|7293->4490|7313->4501|7408->4573|7477->4610|7523->4620|7581->4669|7621->4671|7781->4795|7801->4806|7898->4880|7969->4919|8058->4973|8071->4978|8118->5003|8490->5338|8572->5397|8790->5578|8872->5637|9121->5850|9264->5969|9308->5977|9431->6076|9656->6264|9677->6275|9761->6336|10239->6778|10388->6903|10581->7060|10727->7182|10770->7189|10916->7311|11086->7445|11242->7577|11285->7584|11441->7716|11582->7821|11703->7918|12147->8325|12168->8336|12241->8386|12384->8493|12428->8527|12469->8529|12610->8652|12624->8657|12664->8658|12723->8680|12741->8688|12796->8720|13270->9158|13314->9185|13355->9187|13415->9210|13427->9212|13460->9222|13515->9240|13563->9265|13614->9279|13636->9290|13713->9343|13753->9345|13772->9353|13805->9362|13908->9428|13920->9430|13946->9433|14018->9467|14031->9469|14058->9472|14120->9498|14170->9538|14211->9540|14310->9602|14331->9613|14411->9669|14451->9671|14470->9679|14503->9688|14604->9757|14663->9779|14713->9806|14766->9822|14814->9847|14867->9863|14914->9887|14967->9903|15007->9933|15056->9935|15068->9937|15116->9958|15169->9974|15239->10021|15292->10037|15358->10080|15417->10103|15469->10145|15510->10147|15629->10229|15650->10240|15732->10298|15772->10300|15791->10308|15824->10317|15941->10402|16010->10438|16142->10534|16157->10539|16277->10635|16323->10649
                    LINES: 26->1|33->8|33->8|35->8|36->9|36->9|36->9|37->5|37->5|37->12|37->12|49->1|50->5|53->10|55->23|57->25|57->25|57->25|57->25|60->28|60->28|60->28|60->28|74->42|74->42|74->42|74->42|74->42|74->42|85->53|85->53|85->53|86->54|86->54|86->54|87->55|87->55|87->55|88->56|88->56|88->56|99->67|99->67|99->67|100->68|100->68|100->68|101->69|101->69|101->69|102->70|103->71|103->71|103->71|104->72|104->72|104->72|105->73|106->74|106->74|106->74|107->75|107->75|107->75|108->76|109->77|109->77|109->77|110->78|110->78|110->78|111->79|112->80|112->80|112->80|114->82|114->82|114->82|115->83|116->84|116->84|116->84|118->86|118->86|118->86|119->87|128->96|128->96|128->96|137->105|137->105|142->110|142->110|154->122|154->122|155->123|155->123|160->128|160->128|160->128|175->143|175->143|183->151|183->151|184->152|184->152|190->158|190->158|191->159|191->159|197->165|197->165|211->179|211->179|211->179|218->186|218->186|218->186|224->192|224->192|224->192|226->194|226->194|226->194|245->213|245->213|245->213|246->214|246->214|246->214|246->214|246->214|246->214|246->214|246->214|246->214|246->214|246->214|247->215|247->215|247->215|247->215|247->215|247->215|249->217|249->217|249->217|250->218|250->218|250->218|250->218|250->218|250->218|253->221|255->223|255->223|256->224|256->224|257->225|257->225|258->226|258->226|258->226|258->226|258->226|259->227|259->227|260->228|260->228|262->230|262->230|262->230|263->231|263->231|263->231|263->231|263->231|263->231|266->234|269->237|274->242|274->242|274->242|276->244
                    -- GENERATED --
                */
            