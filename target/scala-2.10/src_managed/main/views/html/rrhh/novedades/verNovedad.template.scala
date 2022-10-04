
package views.html.rrhh.novedades

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
object verNovedad extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Novedad,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea:  Novedad):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.19*/("""

<div class="row menu-acciones">
	<div class="col-sm-10">
		<a href=""""),_display_(Seq[Any](/*5.13*/controllers/*5.24*/.rrhh.routes.NovedadesController.editar(linea.id))),format.raw/*5.73*/(""""  class="btn btn-default" id="btnModificar"><i class="glyphicon glyphicon-edit"></i> Editar</a>
		<a href=""""),_display_(Seq[Any](/*6.13*/controllers/*6.24*/.rrhh.routes.NovedadesController.eliminar(linea.id))),format.raw/*6.75*/(""""  class="btn btn-default delete-confirm-link"><i class="glyphicon glyphicon-trash icono-eliminar"></i> Eliminar</a>
	</div>
</div>	


<div class="row">

	<div class="col-sm-6">
		<label class="control-label">Nombre</label>
		<p class="form-control-static form-control">"""),_display_(Seq[Any](/*15.48*/linea/*15.53*/.agente.apellido)),format.raw/*15.69*/("""</p>
	</div>

	<div class="col-sm-3">
		<label class="control-label">Fecha y hora de inicio</label>
		<p class="form-control-static form-control">"""),_display_(Seq[Any](/*20.48*/utils/*20.53*/.DateUtils.formatDate(linea.fecha_inicio, "dd-MM-yyyy HH:mm"))),format.raw/*20.114*/("""</p>
	</div>

	<div class="col-sm-3">
		<label class="control-label">Total de horas</label>
		<p class="form-control-static form-control">"""),_display_(Seq[Any](/*25.48*/utils/*25.53*/.DateUtils.formatDate(linea.horas, "HH:mm"))),format.raw/*25.96*/("""</p>
	</div>


	<div class="col-sm-6">
		<label class="control-label">Servicio</label>
		<p class="form-control-static form-control">"""),_display_(Seq[Any](/*31.48*/linea/*31.53*/.servicio.nombre)),format.raw/*31.69*/("""</p>
	</div>

</div>


<div class="row ">

	<div class="col-sm-12">
		<label for="obs" class="control-label">Descripción</label> 
		<p class="form-control-static form-control">"""),_display_(Seq[Any](/*41.48*/linea/*41.53*/.descripcion)),format.raw/*41.65*/("""</p>
	</div>

</div>"""))}
    }
    
    def render(linea:Novedad): play.api.templates.HtmlFormat.Appendable = apply(linea)
    
    def f:((Novedad) => play.api.templates.HtmlFormat.Appendable) = (linea) => apply(linea)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:31 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/novedades/verNovedad.scala.html
                    HASH: ca6fa545095244df17d4bd1bb91029c0b1763183
                    MATRIX: 795->1|906->18|1016->93|1035->104|1105->153|1250->263|1269->274|1341->325|1657->605|1671->610|1709->626|1897->778|1911->783|1995->844|2175->988|2189->993|2254->1036|2430->1176|2444->1181|2482->1197|2705->1384|2719->1389|2753->1401
                    LINES: 26->1|29->1|33->5|33->5|33->5|34->6|34->6|34->6|43->15|43->15|43->15|48->20|48->20|48->20|53->25|53->25|53->25|59->31|59->31|59->31|69->41|69->41|69->41
                    -- GENERATED --
                */
            