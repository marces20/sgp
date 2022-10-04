
package views.html.rrhh.agenteAsistenciaLicencia

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
object listadoLicenciasEnFecha extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[List[com.avaje.ebean.SqlRow],DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lista:List[com.avaje.ebean.SqlRow], formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import java.math.BigDecimal;var dx =new java.math.BigDecimal(15);

def /*19.2*/scripts/*19.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*19.13*/("""
	<script src=""""),_display_(Seq[Any](/*20.16*/routes/*20.22*/.Assets.at("javascripts/rrhh/agentes.js"))),format.raw/*20.63*/("""" type="text/javascript"></script>
""")))};def /*4.2*/getClassEstado/*4.16*/(i:Integer) = {{
	var classEstado:String = new String()
	
	if(i  != null && (i == 93) ){
		classEstado = "borrador"
	}else if(i != null && i == 95){
		classEstado = "cancelada"
	}else if(i != null && i == 94){
		classEstado = "autorizado"
	}else if(i != null && i == 96){
		classEstado = "licenciaPreaprobado"
	}
	
	classEstado
}};implicit def /*22.2*/implicitFieldConstructor/*22.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.65*/("""
"""),format.raw/*18.2*/("""
"""),format.raw/*21.2*/("""
"""),format.raw/*22.70*/(""" 
"""),_display_(Seq[Any](/*24.2*/views/*24.7*/.html.rrhh.mainRrhh("Lista Agentes Asistencias",scripts)/*24.63*/ {_display_(Seq[Any](format.raw/*24.65*/("""
	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Lista de Licencias Por ejercicio</h1>
			</div>
			<div class="col-sm-5">
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*35.3*/views/*35.8*/.html.tags.successError())),format.raw/*35.33*/("""
	
	<div id="actions">
		<form action="" id="formSearchAgenteAsistencia" method="GET">
			 
			<div class="row" >
				<div class="col-sm-2">
					<div class="form-group">
						<label for="cuit" class="control-label">Estado
						"""),_display_(Seq[Any](/*44.8*/select(formBuscador("estado_id"), 
						Estado.find.where.eq("tipo",20).findList().map { p => p.id.toString -> p.nombre}, 
						'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*46.67*/("""
						</label>
					</div>
				</div>
			 	  
					 
				
				<div class="col-sm-4">
					<label for="inputOrgranigrama" class="control-label">Departamento/Servicio</label> 
					<div class="input-group">
						"""),_display_(Seq[Any](/*56.8*/inputText(formBuscador("organigrama.nombre"),'class -> "form-control",'id -> "organigrama"))),format.raw/*56.99*/("""
						"""),_display_(Seq[Any](/*57.8*/inputText(formBuscador("organigrama_id"),'hidden -> "hidden",'id -> "organigrama_id"))),format.raw/*57.93*/("""
						<span class="input-group-addon">
		                	<a href="#" id="searchOrganigrama" data-title="Selección de Departamento/Servicio" 
		                				data-url=""""),_display_(Seq[Any](/*60.34*/controllers/*60.45*/.administracion.routes.OrganigramasController.modalBuscarServicios())),format.raw/*60.113*/("""" 
		                				data-height="650" data-width="700" 
		                				data-listen="modal.seleccion.servicio.simple" 
		                				data-label="#organigrama" data-field="#organigrama_id" /> <i class="glyphicon glyphicon-search"></i></a>
		                </span>
					</div>
				</div>
				
				
				<div class="col-sm-3">
						<div class="form-group">
							<label for="cuit" class="control-label">Tipo Relacion
							"""),_display_(Seq[Any](/*72.9*/select(formBuscador("tipo_relacion_laboral"), 
							TipoRelacionLaboral.find.all().map { p => p.id.toString -> p.nombre}, 
							'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*74.68*/("""
							</label>
						</div>
					</div>
				<div class="col-sm-3 input-group">
					<label for="desde" class="control-label">Fecha </label>
					<div>
					"""),_display_(Seq[Any](/*81.7*/inputText(formBuscador("desde"), 
							  'class -> "form-control inputDateMascara", 
							  'id -> "desde", 
							  'placeholder -> "Desde"))),format.raw/*84.34*/("""
					"""),_display_(Seq[Any](/*85.7*/inputText(formBuscador("hasta"), 
					 		   'class -> "form-control inputDateMascara", 
					 		   'id -> "hasta", 
					 		   'placeholder -> "Hasta"))),format.raw/*88.36*/("""
					</div>
				</div>
			</div>
			<div class="row">	  	
			 	<div class="col-sm-2">
					<div class="form-group">
						<label for="nombre" class="control-label">Descripcion
						"""),_display_(Seq[Any](/*96.8*/inputText(formBuscador("descripcion"), 'class -> "form-control", 'autofocus -> "autofocus"))),format.raw/*96.99*/("""
						</label>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="form-group">
						<label for="" class="control-label">Tipo Licencia</label>
						"""),_display_(Seq[Any](/*103.8*/select(formBuscador("tipo_licencia_id"), 
									TipoLicencia.find.all().map { p => p.id.toString -> p.nombre},
									'class -> "form-control select", 
									'_default -> "Seleccionar"))),format.raw/*106.37*/(""" 
					</div>
				</div>
				<div class="col-sm-2">
					<div class="form-group">
					<label for="nombre" class="control-label">&nbsp;</label>
					<button  class="form-control btn btn-primary">Buscar</button>
					</div>
				</div>
				<div class="col-sm-2">
					<div class="form-group">
					<label for="nombre" class="control-label">&nbsp;</label>
					<a href=""""),_display_(Seq[Any](/*118.16*/controllers/*118.27*/.rrhh.routes.AgentesAsistenciasLicenciasController.getListaLicenciasPendientes())),format.raw/*118.107*/(""""  class="form-control btn btn-default">Limpiar</a>
					</div>
				</div>
				
			</div>
		</form>
	</div>
	"""),_display_(Seq[Any](/*125.3*/if(lista.size() == 0)/*125.24*/ {_display_(Seq[Any](format.raw/*125.26*/("""
        
        <div class="well">
            <em>No se encuentran Agentes</em>
        </div>
        
    """)))}/*131.7*/else/*131.12*/{_display_(Seq[Any](format.raw/*131.13*/("""
    	
		
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>Apellido y Nombre</th>
					<th>DNI</th>
					<th>Organigrama</th>
					<th>Profesion</th>
					<th>Puesto</th>
					<th>Relacion</th>
					<th>Fecha Inicio</th>
					<th>Fecha Fin</th>
					<th>Tipo Licencia</th>
					<th>Estado</th>
				</tr>
			</thead>
			<tbody>
			"""),_display_(Seq[Any](/*150.5*/for(sql <- lista) yield /*150.22*/ {_display_(Seq[Any](format.raw/*150.24*/("""
				<tr class='"""),_display_(Seq[Any](/*151.17*/getClassEstado(sql.getInteger("idestado")))),format.raw/*151.59*/("""'>
					<td>"""),_display_(Seq[Any](/*152.11*/sql/*152.14*/.getString("apellido"))),format.raw/*152.36*/("""</td>
					<td>"""),_display_(Seq[Any](/*153.11*/sql/*153.14*/.getString("dni"))),format.raw/*153.31*/("""</td>
					<td>"""),_display_(Seq[Any](/*154.11*/sql/*154.14*/.getString("organigrama"))),format.raw/*154.39*/("""</td>
					<td>"""),_display_(Seq[Any](/*155.11*/sql/*155.14*/.getString("profesion"))),format.raw/*155.37*/("""</td>
					<td>"""),_display_(Seq[Any](/*156.11*/sql/*156.14*/.getString("puesto"))),format.raw/*156.34*/("""</td>
					<td>
						"""),_display_(Seq[Any](/*158.8*/sql/*158.11*/.getString("tipo_relacion_laboral")/*158.46*/ match/*158.52*/ {/*159.10*/case "1" =>/*159.21*/ {_display_(Seq[Any](format.raw/*159.23*/("""Contrato Relacion Parque de la salud""")))}/*160.7*/case "2" =>/*160.18*/ {_display_(Seq[Any](format.raw/*160.20*/("""Monotributo Parque de la salud""")))}/*161.7*/case "3" =>/*161.18*/ {_display_(Seq[Any](format.raw/*161.20*/("""Contrato Relacion Convenio Ministerio Salud""")))}/*162.7*/case "4" =>/*162.18*/ {_display_(Seq[Any](format.raw/*162.20*/("""Planta Ministerio Salud""")))}/*163.7*/case "5" =>/*163.18*/ {_display_(Seq[Any](format.raw/*163.20*/("""Contrato Relacion Ministerio Salud""")))}/*164.7*/case "6" =>/*164.18*/ {_display_(Seq[Any](format.raw/*164.20*/("""Adscripto Otras Entidades""")))}/*165.10*/case _ =>/*165.19*/ {}})),format.raw/*166.8*/("""		
					</td>
					<td>"""),_display_(Seq[Any](/*168.11*/(utils.DateUtils.formatDate(sql.getDate("finicio"))))),format.raw/*168.63*/("""</td>
					<td>"""),_display_(Seq[Any](/*169.11*/(utils.DateUtils.formatDate(sql.getDate("ffin"))))),format.raw/*169.60*/("""</td>
					<td>"""),_display_(Seq[Any](/*170.11*/sql/*170.14*/.getString("tipoLicencia"))),format.raw/*170.40*/("""</td>
					<td align="center">
						"""),_display_(Seq[Any](/*172.8*/sql/*172.11*/.getString("estado"))),format.raw/*172.31*/("""
						"""),_display_(Seq[Any](/*173.8*/if(sql.getString("nota") != null && !sql.getString("nota").isEmpty())/*173.77*/{_display_(Seq[Any](format.raw/*173.78*/("""
							<div class='tip-top pointer' style="display: inline;" title='"""),_display_(Seq[Any](/*174.70*/sql/*174.73*/.getString("nota"))),format.raw/*174.91*/("""'>
								<i class="glyphicon glyphicon-list-alt"></i></div>
						""")))})),format.raw/*176.8*/("""
					</td>
				</tr>	
			""")))})),format.raw/*179.5*/("""		 
			</tbody>
        </table>
		
    """)))})),format.raw/*183.6*/("""



""")))})))}
    }
    
    def render(lista:List[com.avaje.ebean.SqlRow],formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(lista,formBuscador)
    
    def f:((List[com.avaje.ebean.SqlRow],DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (lista,formBuscador) => apply(lista,formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:30 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agenteAsistenciaLicencia/listadoLicenciasEnFecha.scala.html
                    HASH: ea1b3f1d1cabbba0e9e83cc5e4c4c690eda963b8
                    MATRIX: 856->1|1096->444|1111->451|1196->455|1248->471|1263->477|1326->518|1384->99|1406->113|1758->556|1791->580|1865->64|1893->442|1921->554|1950->624|1988->694|2001->699|2066->755|2106->757|2328->944|2341->949|2388->974|2654->1205|2866->1395|3114->1608|3227->1699|3270->1707|3377->1792|3589->1968|3609->1979|3700->2047|4178->2490|4392->2682|4586->2841|4754->2987|4796->2994|4970->3146|5189->3330|5302->3421|5505->3588|5721->3781|6126->4149|6147->4160|6251->4240|6397->4350|6428->4371|6469->4373|6600->4486|6614->4491|6654->4492|7054->4856|7088->4873|7129->4875|7183->4892|7248->4934|7298->4947|7311->4950|7356->4972|7409->4988|7422->4991|7462->5008|7515->5024|7528->5027|7576->5052|7629->5068|7642->5071|7688->5094|7741->5110|7754->5113|7797->5133|7856->5156|7869->5159|7914->5194|7930->5200|7942->5212|7963->5223|8004->5225|8060->5269|8081->5280|8122->5282|8172->5320|8193->5331|8234->5333|8297->5384|8318->5395|8359->5397|8402->5428|8423->5439|8464->5441|8518->5483|8539->5494|8580->5496|8626->5532|8645->5541|8671->5552|8732->5576|8807->5628|8860->5644|8932->5693|8985->5709|8998->5712|9047->5738|9121->5776|9134->5779|9177->5799|9221->5807|9300->5876|9340->5877|9447->5947|9460->5950|9501->5968|9602->6037|9661->6064|9734->6105
                    LINES: 26->1|33->19|33->19|35->19|36->20|36->20|36->20|37->4|37->4|51->22|51->22|52->1|53->18|54->21|55->22|56->24|56->24|56->24|56->24|67->35|67->35|67->35|76->44|78->46|88->56|88->56|89->57|89->57|92->60|92->60|92->60|104->72|106->74|113->81|116->84|117->85|120->88|128->96|128->96|135->103|138->106|150->118|150->118|150->118|157->125|157->125|157->125|163->131|163->131|163->131|182->150|182->150|182->150|183->151|183->151|184->152|184->152|184->152|185->153|185->153|185->153|186->154|186->154|186->154|187->155|187->155|187->155|188->156|188->156|188->156|190->158|190->158|190->158|190->158|190->159|190->159|190->159|190->160|190->160|190->160|190->161|190->161|190->161|190->162|190->162|190->162|190->163|190->163|190->163|190->164|190->164|190->164|190->165|190->165|190->166|192->168|192->168|193->169|193->169|194->170|194->170|194->170|196->172|196->172|196->172|197->173|197->173|197->173|198->174|198->174|198->174|200->176|203->179|207->183
                    -- GENERATED --
                */
            