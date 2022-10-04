
package views.html.rrhh

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
object mainRrhh extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,Html,Html,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(title: String, scripts: Html = Html(""))(content: Html):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import models.auth._


Seq[Any](format.raw/*1.58*/("""
"""),_display_(Seq[Any](/*3.2*/main(title: String, scripts)/*3.30*/{_display_(Seq[Any](format.raw/*3.31*/("""
	<div class="row">
		<div class="col-sm-2">
			<div class="menu-contenido"> 
			<ul class="nav nav-pills nav-stacked">
				<li class="titulo">Agentes</li>
				"""),_display_(Seq[Any](/*9.6*/if(Componente.check("agentes"))/*9.37*/ {_display_(Seq[Any](format.raw/*9.39*/("""
					<li><a href=""""),_display_(Seq[Any](/*10.20*/controllers/*10.31*/.rrhh.routes.AgentesController.indexAgente())),format.raw/*10.75*/("""">Agentes </a></li>
				""")))})),format.raw/*11.6*/("""
				
				"""),_display_(Seq[Any](/*13.6*/if(Componente.check("agentes") && Permiso.check("agentesLicencias"))/*13.74*/ {_display_(Seq[Any](format.raw/*13.76*/("""
								   
					<li><a href=""""),_display_(Seq[Any](/*15.20*/controllers/*15.31*/.rrhh.routes.AgentesAsistenciasController.index())),format.raw/*15.80*/("""">Licencias</a></li>
					<!-- <li><a href=""""),_display_(Seq[Any](/*16.25*/controllers/*16.36*/.rrhh.routes.AgentesAsistenciasLicenciasController.getListaLicenciasPendientes())),format.raw/*16.116*/("""">Licencias Pendientes</a></li> -->
					<li><a href=""""),_display_(Seq[Any](/*17.20*/controllers/*17.31*/.rrhh.routes.AgentesAsistenciasLicenciasController.getListaLicenciasEnFecha())),format.raw/*17.108*/("""">Licencias en Fecha</a></li>
					
				
				""")))})),format.raw/*20.6*/("""
				
				"""),_display_(Seq[Any](/*22.6*/if(Componente.check("agentes") && Permiso.check("agentesSeguimientos"))/*22.77*/ {_display_(Seq[Any](format.raw/*22.79*/("""
					<li><a href=""""),_display_(Seq[Any](/*23.20*/controllers/*23.31*/.rrhh.routes.AgentesSeguimientoController.index())),format.raw/*23.80*/("""">Seguimientos</a></li>
				""")))})),format.raw/*24.6*/("""
		 
				
				<li class="titulo">Configuración</li>
				"""),_display_(Seq[Any](/*28.6*/if(Componente.check("departamentos"))/*28.43*/ {_display_(Seq[Any](format.raw/*28.45*/("""
					<li><a href=""""),_display_(Seq[Any](/*29.20*/controllers/*29.31*/.rrhh.routes.DepartamentosController.indexDepartamento())),format.raw/*29.87*/("""">Departamentos</a></li>
				""")))})),format.raw/*30.6*/("""
				"""),_display_(Seq[Any](/*31.6*/if(Componente.check("especialidades"))/*31.44*/ {_display_(Seq[Any](format.raw/*31.46*/("""
					<li><a href=""""),_display_(Seq[Any](/*32.20*/controllers/*32.31*/.rrhh.routes.EspecialidadesController.indexEspecialidad())),format.raw/*32.88*/("""">Especialidades</a></li>
				""")))})),format.raw/*33.6*/("""
				"""),_display_(Seq[Any](/*34.6*/if(Componente.check("puestos"))/*34.37*/ {_display_(Seq[Any](format.raw/*34.39*/("""
					<li><a href=""""),_display_(Seq[Any](/*35.20*/controllers/*35.31*/.rrhh.routes.PuestosController.indexPuesto())),format.raw/*35.75*/("""">Puestos</a></li>
				""")))})),format.raw/*36.6*/("""
				"""),_display_(Seq[Any](/*37.6*/if(Componente.check("puestos"))/*37.37*/ {_display_(Seq[Any](format.raw/*37.39*/("""
					<li><a href=""""),_display_(Seq[Any](/*38.20*/controllers/*38.31*/.rrhh.routes.TipoResidenciasController.indexTipoResidencia())),format.raw/*38.91*/("""">Tipos Residencias</a></li>
				""")))})),format.raw/*39.6*/("""
			</ul>
			</div>
		</div>
		<div id="contenido" class="col-sm-10">"""),_display_(Seq[Any](/*43.42*/content)),format.raw/*43.49*/("""</div>
	</div>
""")))})),format.raw/*45.2*/("""
"""))}
    }
    
    def render(title:String,scripts:Html,content:Html): play.api.templates.HtmlFormat.Appendable = apply(title,scripts)(content)
    
    def f:((String,Html) => (Html) => play.api.templates.HtmlFormat.Appendable) = (title,scripts) => (content) => apply(title,scripts)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:29 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/mainRrhh.scala.html
                    HASH: 9d4121317665e54b555ed98d0222f1851187e549
                    MATRIX: 792->1|963->57|999->81|1035->109|1073->110|1268->271|1307->302|1346->304|1402->324|1422->335|1488->379|1544->404|1590->415|1667->483|1707->485|1775->517|1795->528|1866->577|1947->622|1967->633|2070->713|2161->768|2181->779|2281->856|2358->902|2404->913|2484->984|2524->986|2580->1006|2600->1017|2671->1066|2731->1095|2823->1152|2869->1189|2909->1191|2965->1211|2985->1222|3063->1278|3124->1308|3165->1314|3212->1352|3252->1354|3308->1374|3328->1385|3407->1442|3469->1473|3510->1479|3550->1510|3590->1512|3646->1532|3666->1543|3732->1587|3787->1611|3828->1617|3868->1648|3908->1650|3964->1670|3984->1681|4066->1741|4131->1775|4237->1845|4266->1852|4313->1868
                    LINES: 26->1|30->1|31->3|31->3|31->3|37->9|37->9|37->9|38->10|38->10|38->10|39->11|41->13|41->13|41->13|43->15|43->15|43->15|44->16|44->16|44->16|45->17|45->17|45->17|48->20|50->22|50->22|50->22|51->23|51->23|51->23|52->24|56->28|56->28|56->28|57->29|57->29|57->29|58->30|59->31|59->31|59->31|60->32|60->32|60->32|61->33|62->34|62->34|62->34|63->35|63->35|63->35|64->36|65->37|65->37|65->37|66->38|66->38|66->38|67->39|71->43|71->43|73->45
                    -- GENERATED --
                */
            