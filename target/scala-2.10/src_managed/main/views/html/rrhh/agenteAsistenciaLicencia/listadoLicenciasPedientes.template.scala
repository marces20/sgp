
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
object listadoLicenciasPedientes extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[List[com.avaje.ebean.SqlRow],DynamicForm,String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lista:List[com.avaje.ebean.SqlRow], formBuscador: DynamicForm,ejercicio:String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import java.math.BigDecimal;var dx =new java.math.BigDecimal(15);

def /*4.2*/scripts/*4.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*4.13*/("""
	<script src=""""),_display_(Seq[Any](/*5.16*/routes/*5.22*/.Assets.at("javascripts/rrhh/agentes.js"))),format.raw/*5.63*/("""" type="text/javascript"></script>
""")))};implicit def /*7.2*/implicitFieldConstructor/*7.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.82*/("""
"""),format.raw/*6.2*/("""
"""),format.raw/*7.70*/(""" 
"""),_display_(Seq[Any](/*9.2*/views/*9.7*/.html.rrhh.mainRrhh("Lista Agentes Asistencias",scripts)/*9.63*/ {_display_(Seq[Any](format.raw/*9.65*/("""
	<div class="page-header">
		<div class="row">
			<div class="col-sm-7">
				<h1>Lista de Licencias Por ejercicio</h1>
			</div>
			<div class="col-sm-5">
			</div>
		</div>
	</div>
	
	"""),_display_(Seq[Any](/*20.3*/views/*20.8*/.html.tags.successError())),format.raw/*20.33*/("""
	
	<div id="actions">
		<form action="" id="formSearchAgenteAsistencia" method="GET">
			 
			<div class="row">	  
				<div class="col-sm-2">
					<div class="form-group">
						<label for="nombre" class="control-label">Nombre
						"""),_display_(Seq[Any](/*29.8*/inputText(formBuscador("apellido"), 'class -> "form-control"))),format.raw/*29.69*/("""
						</label>
					</div>
				</div>
				<div class="col-sm-2">
					<div class="form-group">
						<label for="cuit" class="control-label">Cuit
						"""),_display_(Seq[Any](/*36.8*/inputText(formBuscador("cuit"), 'class -> "form-control"))),format.raw/*36.65*/("""
						</label>
					</div>
				</div>
				<div class="col-sm-2">
					<div class="form-group">
						<label for="cuit" class="control-label">DNI
						"""),_display_(Seq[Any](/*43.8*/inputText(formBuscador("dni"), 'class -> "form-control"))),format.raw/*43.64*/("""
						</label>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="col-sm-6">
						<label class="control-label">Ejercicio
						"""),_display_(Seq[Any](/*50.8*/select(formBuscador("ejercicio"), Ejercicio.getEjercicios().map { p => p.id.toString -> p.nombre}, 
						'class -> "form-control select"))),format.raw/*51.39*/("""
						</label>
					</div>
					<div class="col-sm-6">
						<label class="control-label"> 
							Activo
							"""),_display_(Seq[Any](/*57.9*/select(formBuscador("activo"),options(""->"","SI"->"SI","NO"->"NO"), 'class -> "form-control select"))),format.raw/*57.110*/("""
						</label>
					</div>
				</div>
				<div class="col-sm-2">
					<div class="form-group">
						<label class="control-label">Tipo Relacion
						"""),_display_(Seq[Any](/*64.8*/select(formBuscador("tipo_relacion_laboral"), 
						TipoRelacionLaboral.find.all().map { p => p.id.toString -> p.nombre}, 
						'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*66.67*/("""
						</label>
					</div>
				</div>
				
				
			</div>
				
			<div class="row" >	
				<div class="col-sm-5">
					<div class="form-group">
						<label for="inputOrganigrama" class="control-label">Departamento/Servicio</label> 
						"""),_display_(Seq[Any](/*78.8*/inputText(formBuscador("organigrama.nombre"),'class -> "form-control",'id -> "organigrama"))),format.raw/*78.99*/("""
						"""),_display_(Seq[Any](/*79.8*/inputText(formBuscador("organigrama_id"),'hidden -> "hidden"))),format.raw/*79.69*/("""
					</div>
				</div>
				<div class="col-sm-2">
					 
					<label class="control-label"> 
						Completas
						"""),_display_(Seq[Any](/*86.8*/select(formBuscador("completas"),options(""->"","SI"->"SI","NO"->"NO"), 'class -> "form-control select"))),format.raw/*86.112*/("""
					</label>
					 
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
					<a href=""""),_display_(Seq[Any](/*99.16*/controllers/*99.27*/.rrhh.routes.AgentesAsistenciasLicenciasController.getListaLicenciasPendientes())),format.raw/*99.107*/(""""  class="form-control btn btn-default">Limpiar</a>
					</div>
				</div>
				
			</div>
		</form>
	</div>
	"""),_display_(Seq[Any](/*106.3*/if(lista.size() == 0)/*106.24*/ {_display_(Seq[Any](format.raw/*106.26*/("""
        
        <div class="well">
            <em>No se encuentran Agentes</em>
        </div>
        
    """)))}/*112.7*/else/*112.12*/{_display_(Seq[Any](format.raw/*112.13*/("""
    	
		
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>Apellido y Nombre</th>
					<th>DNI</th>
					<th>Cuit</th>
					<th>Organigrama</th>
					<th>Profesion</th>
					<th>Relacion</th>
					<th>Ejercicio</th>
					<th>dias</th>
					<th>faltan</th>
				</tr>
			</thead>
			<tbody>
			"""),_display_(Seq[Any](/*130.5*/for(sql <- lista) yield /*130.22*/ {_display_(Seq[Any](format.raw/*130.24*/("""
				<tr>
					<td>"""),_display_(Seq[Any](/*132.11*/sql/*132.14*/.getString("apellido"))),format.raw/*132.36*/("""</td>
					<td>"""),_display_(Seq[Any](/*133.11*/sql/*133.14*/.getString("dni"))),format.raw/*133.31*/("""</td>
					<td>"""),_display_(Seq[Any](/*134.11*/sql/*134.14*/.getString("cuit"))),format.raw/*134.32*/("""</td>
					<td>"""),_display_(Seq[Any](/*135.11*/sql/*135.14*/.getString("organigrama"))),format.raw/*135.39*/("""</td>
					<td>"""),_display_(Seq[Any](/*136.11*/sql/*136.14*/.getString("profesion"))),format.raw/*136.37*/("""</td>
					
					<td>
						"""),_display_(Seq[Any](/*139.8*/sql/*139.11*/.getString("tipo_relacion_laboral")/*139.46*/ match/*139.52*/ {/*140.10*/case "1" =>/*140.21*/ {_display_(Seq[Any](format.raw/*140.23*/("""Contrato Relacion Parque de la salud""")))}/*141.7*/case "2" =>/*141.18*/ {_display_(Seq[Any](format.raw/*141.20*/("""Monotributo Parque de la salud""")))}/*142.7*/case "3" =>/*142.18*/ {_display_(Seq[Any](format.raw/*142.20*/("""Contrato Relacion Convenio Ministerio Salud""")))}/*143.7*/case "4" =>/*143.18*/ {_display_(Seq[Any](format.raw/*143.20*/("""Planta Ministerio Salud""")))}/*144.7*/case "5" =>/*144.18*/ {_display_(Seq[Any](format.raw/*144.20*/("""Contrato Relacion Ministerio Salud""")))}/*145.7*/case "6" =>/*145.18*/ {_display_(Seq[Any](format.raw/*145.20*/("""Adscripto Otras Entidades""")))}/*146.10*/case _ =>/*146.19*/ {}})),format.raw/*147.8*/("""		
					</td>
					<td>"""),_display_(Seq[Any](/*149.11*/ejercicio)),format.raw/*149.20*/("""</td>
					<td>"""),_display_(Seq[Any](/*150.11*/sql/*150.14*/.getInteger("dias"))),format.raw/*150.33*/("""/15</td>
					"""),_display_(Seq[Any](/*151.7*/{dx = new java.math.BigDecimal(15)})),format.raw/*151.42*/(""" 
					"""),_display_(Seq[Any](/*152.7*/{dx = dx.subtract(sql.getBigDecimal("dias")) })),format.raw/*152.53*/("""
					<td>"""),_display_(Seq[Any](/*153.11*/dx)),format.raw/*153.13*/(""" </td>
				</tr>	
			""")))})),format.raw/*155.5*/("""		
			</tbody>
        </table>
		
    """)))})),format.raw/*159.6*/("""



""")))})))}
    }
    
    def render(lista:List[com.avaje.ebean.SqlRow],formBuscador:DynamicForm,ejercicio:String): play.api.templates.HtmlFormat.Appendable = apply(lista,formBuscador,ejercicio)
    
    def f:((List[com.avaje.ebean.SqlRow],DynamicForm,String) => play.api.templates.HtmlFormat.Appendable) = (lista,formBuscador,ejercicio) => apply(lista,formBuscador,ejercicio)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:30 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agenteAsistenciaLicencia/listadoLicenciasPedientes.scala.html
                    HASH: 23b009902c39f6f44290205097a357c789b4657e
                    MATRIX: 865->1|1121->116|1135->123|1219->127|1270->143|1284->149|1346->190|1413->228|1445->252|1519->81|1546->226|1574->296|1611->366|1623->371|1687->427|1726->429|1948->616|1961->621|2008->646|2278->881|2361->942|2550->1096|2629->1153|2817->1306|2895->1362|3076->1508|3236->1646|3386->1761|3510->1862|3697->2014|3909->2204|4184->2444|4297->2535|4340->2543|4423->2604|4575->2721|4702->2825|5114->3201|5134->3212|5237->3292|5383->3402|5414->3423|5455->3425|5586->3538|5600->3543|5640->3544|6002->3870|6036->3887|6077->3889|6134->3909|6147->3912|6192->3934|6245->3950|6258->3953|6298->3970|6351->3986|6364->3989|6405->4007|6458->4023|6471->4026|6519->4051|6572->4067|6585->4070|6631->4093|6696->4122|6709->4125|6754->4160|6770->4166|6782->4178|6803->4189|6844->4191|6900->4235|6921->4246|6962->4248|7012->4286|7033->4297|7074->4299|7137->4350|7158->4361|7199->4363|7242->4394|7263->4405|7304->4407|7358->4449|7379->4460|7420->4462|7466->4498|7485->4507|7511->4518|7572->4542|7604->4551|7657->4567|7670->4570|7712->4589|7763->4604|7821->4639|7865->4647|7934->4693|7982->4704|8007->4706|8061->4728|8133->4768
                    LINES: 26->1|33->4|33->4|35->4|36->5|36->5|36->5|37->7|37->7|38->1|39->6|40->7|41->9|41->9|41->9|41->9|52->20|52->20|52->20|61->29|61->29|68->36|68->36|75->43|75->43|82->50|83->51|89->57|89->57|96->64|98->66|110->78|110->78|111->79|111->79|118->86|118->86|131->99|131->99|131->99|138->106|138->106|138->106|144->112|144->112|144->112|162->130|162->130|162->130|164->132|164->132|164->132|165->133|165->133|165->133|166->134|166->134|166->134|167->135|167->135|167->135|168->136|168->136|168->136|171->139|171->139|171->139|171->139|171->140|171->140|171->140|171->141|171->141|171->141|171->142|171->142|171->142|171->143|171->143|171->143|171->144|171->144|171->144|171->145|171->145|171->145|171->146|171->146|171->147|173->149|173->149|174->150|174->150|174->150|175->151|175->151|176->152|176->152|177->153|177->153|179->155|183->159
                    -- GENERATED --
                */
            