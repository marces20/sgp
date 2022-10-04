
package views.html.administracion.usuarios

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
object listarUsuario extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](_display_(Seq[Any](/*1.2*/main(title = "Prueba")/*1.24*/ {_display_(Seq[Any](format.raw/*1.26*/("""
"""),_display_(Seq[Any](/*2.2*/views/*2.7*/.html.tags.header())),format.raw/*2.26*/("""
"""),_display_(Seq[Any](/*3.2*/views/*3.7*/.html.tags.navigator())),format.raw/*3.29*/("""
<div id="content">

	"""),_display_(Seq[Any](/*6.3*/views/*6.8*/.html.tags.barraIzqAdministracion("marcelo"))),format.raw/*6.52*/("""
	
	<div id="content-center">
		<div id="titulado"><h1>Buscar: Usuarios</h1></div>
		<!-- --SEARCH--- -->
		<div id="form">
			<form class="form-search" method="GET" action="">
			 	<table>
					<tr>
						<td><label for="name">Nombre de usuario:</label></td>
						<td><label for="login">Usuario:</label></td>
						<!--<td><label for="name">Dirección:</label></td>
						<td><label for="name">Compañía:</label></td> -->
					</tr>
					<tr>
						<td><input type="text" name="name" value="" maxlength="" /></td>
						<td><input type="text" name="login" value="" maxlength="" /></td>
					</tr>
					<tr>
						<td>
							<input type="hidden" name="row" value=""/>
							<input type="hidden" name="fetch" value=""/>
							<input type="hidden" name="page" value=""/>
							<input type="hidden" name="accion" value=""/>
							<input type="submit" name="buscar" class="button" value="Buscar"/>
							<input type="button" id="limpiarFormSearch" class="button" value="Limpiar"/>
						</td>
						<td>&nbsp;</td>
					</tr>
				</table>
			</form>
		</div>
		<!-- --FIN SEARCH--- -->
		<!-- --LISTADO--- -->
		<div id="listado">
			<table class="tablas-listado-1">
				<thead>
					<tr>
						<th colspan="6" class="text-align-left">
							<span>USUARIOS</span> 
							<a title="Nuevo" href="" class="button">Nuevo</a>
						</th>
						<th class="">
							<div id="barra-paginador-listado">
								<div id="paginador">
									<!--<a href="#"><span  class="flechas-botones barra-pager-last">r</span></a>-->
									<a href="#"><span  class="flechas-botones barra-pager-right">r</span></a>
									<a href="#"><span class="contadores">10 - 1 a 10</span></a>
									<!-- <a href="#"><span class="flechas-botones barra-pager-left-inactive">l</span></a> -->
									<a href="#"><span class="flechas-botones barra-pager-left">l</span></a>
									<!--<a href="#"><span class="flechas-botones barra-first-inactive">l</span></a>-->
								</div>
								<div id="opciones-paginador">
									<span>Cambiar Limite:</span>
									<select id="selector-limite-paginador">
							            <option value=""></option>
						                <option value="20">20</option>
						                <option value="50">50</option>
						                <option value="100">100</option>
						                <option value="500">500</option>
							            <option value="-1">Todos</option>
							        </select>
						        </div>
							</div>
						</th>
					</tr>
					<tr class="encabezado">
						<th><input type="checkbox" class="checkboxListadoPadre" value="false"/></th>
						<th>&nbsp;</th>
						<th>NOMBRE DE USUARIO</th>
						<th>USUARIO</th>
						<th>ULTIMA CONEXION</th>
						<th>&nbsp;</th>
					</tr>
				</thead>
				<tbody>
					 
						<tr class="">
							<td class="text-align-center"><input type="checkbox" class="checkboxListadoHijos" value="false"/></td>
							<td><img src="/public/images/iconset-b-edit.gif" alt="Editar" /></td>
							<td class="left"></td>
							<td></td>
							<td></td>
							<td><a href="#"></a></td>
						</tr>
						
					 
				</tbody>
			</table>
		</div>
		<!-- --FIN LISTADO--- -->
	
	
	<div id="content-right">
		33333
	</div>
</div>
""")))})))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/administracion/usuarios/listarUsuario.scala.html
                    HASH: 15ea5cb1b7b02c2099cebbd87b0cd5d4d45706df
                    MATRIX: 896->1|926->23|965->25|1002->28|1014->33|1054->52|1091->55|1103->60|1146->82|1206->108|1218->113|1283->157
                    LINES: 29->1|29->1|29->1|30->2|30->2|30->2|31->3|31->3|31->3|34->6|34->6|34->6
                    -- GENERATED --
                */
            