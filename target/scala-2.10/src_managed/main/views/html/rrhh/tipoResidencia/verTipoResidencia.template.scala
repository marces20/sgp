
package views.html.rrhh.tipoResidencia

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
object verTipoResidencia extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[TipoResidencia],TipoResidencia,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lcForm: Form[TipoResidencia],lc:TipoResidencia):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

def /*5.2*/scripts/*5.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*5.13*/("""
	 
""")))};implicit def /*8.2*/implicitFieldConstructor/*8.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.50*/("""
"""),format.raw/*7.2*/("""
"""),format.raw/*8.70*/(""" 

"""),_display_(Seq[Any](/*10.2*/views/*10.7*/.html.rrhh.mainRrhh("Tipo Residencia")/*10.45*/ {_display_(Seq[Any](format.raw/*10.47*/("""
	<div class="page-header">
		<div class="row">
			<div class="col-sm-3">
				<h1>Vista Tipo Residencia</h1>
			</div>
			<div class="col-sm-2">
				<a href=""""),_display_(Seq[Any](/*17.15*/controllers/*17.26*/.rrhh.routes.TipoResidenciasController.indexTipoResidencia())),format.raw/*17.86*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
				<a href="#" class="btn btn-default"><i class="glyphicon glyphicon-align-justify"></i></a> 
			</div>
			
		</div>
	</div>		
"""),_display_(Seq[Any](/*23.2*/views/*23.7*/.html.tags.successError())),format.raw/*23.32*/("""	
	<div class="row menu-acciones">
		<div class="col-sm-4">
			<a href=""""),_display_(Seq[Any](/*26.14*/controllers/*26.25*/.rrhh.routes.TipoResidenciasController.editarTipoResidencia(lc.id))),format.raw/*26.91*/(""""  class="btn btn-default"><i class="glyphicon glyphicon-edit"></i> Editar</a>
			<a href=""""),_display_(Seq[Any](/*27.14*/controllers/*27.25*/.rrhh.routes.TipoResidenciasController.eliminarTipoResidencia(lc.id))),format.raw/*27.93*/(""""  class="btn btn-default delete-confirm-link"><i class="glyphicon glyphicon-trash icono-eliminar"></i> Eliminar</a>
			 
		</div>
	 
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*32.14*/UriTrack/*32.22*/.getOnNull(controllers.rrhh.routes.TipoResidenciasController.indexTipoResidencia().absoluteURL()))),format.raw/*32.119*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
		</div> 
	</div>	
	
	
	<div class="row">
		<div class="col-sm-4">
			<div class="form-group">
				<label class="control-label">Nombre</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*41.50*/lcForm/*41.56*/.field("nombre").value)),format.raw/*41.78*/("""</p>
			</div>
		</div>
		<div class="col-sm-4">
			<div class="form-group">
				<label class="control-label">Tipo</label>
				<p class="form-control-static form-control">"""),_display_(Seq[Any](/*47.50*/lcForm/*47.56*/.field("tipo").value)),format.raw/*47.76*/("""</p>
			</div>
		</div>
	</div>
	
	 
""")))})))}
    }
    
    def render(lcForm:Form[TipoResidencia],lc:TipoResidencia): play.api.templates.HtmlFormat.Appendable = apply(lcForm,lc)
    
    def f:((Form[TipoResidencia],TipoResidencia) => play.api.templates.HtmlFormat.Appendable) = (lcForm,lc) => apply(lcForm,lc)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:29 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/tipoResidencia/verTipoResidencia.scala.html
                    HASH: 1801252a0e3618e65763bfb2def9524a6464455c
                    MATRIX: 835->1|1014->106|1028->113|1112->117|1148->124|1180->148|1254->49|1281->122|1309->192|1348->196|1361->201|1408->239|1448->241|1643->400|1663->411|1745->471|1981->672|1994->677|2041->702|2150->775|2170->786|2258->852|2386->944|2406->955|2496->1023|2704->1195|2721->1203|2841->1300|3141->1564|3156->1570|3200->1592|3408->1764|3423->1770|3465->1790
                    LINES: 26->1|33->5|33->5|35->5|37->8|37->8|38->1|39->7|40->8|42->10|42->10|42->10|42->10|49->17|49->17|49->17|55->23|55->23|55->23|58->26|58->26|58->26|59->27|59->27|59->27|64->32|64->32|64->32|73->41|73->41|73->41|79->47|79->47|79->47
                    -- GENERATED --
                */
            