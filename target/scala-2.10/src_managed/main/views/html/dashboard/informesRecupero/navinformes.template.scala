
package views.html.dashboard.informesRecupero

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
object navinformes extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.1*/("""<div class="row"  style="">
	<nav class="navbar navbar-default" role="navigation">
		<div class="container-fluid">
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		      <ul class="nav navbar-nav">
		      	<li class="dropdown">
		         	
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Deudas <b class="caret"></b></a>
		          <ul class="dropdown-menu">
		          	<li><a href=""""),_display_(Seq[Any](/*10.28*/controllers/*10.39*/.dashboard.routes.InformesRecuperoController.deudasPorTipoDeCliente(-1))),format.raw/*10.110*/("""">Deudas Generales</a></li>
		          	<li><a href=""""),_display_(Seq[Any](/*11.28*/controllers/*11.39*/.dashboard.routes.InformesRecuperoController.deudasPorTipoDeCliente(models.ClienteTipo.PACIENTES))),format.raw/*11.136*/("""">Deudas Pacientes</a></li>
		          	<li><a href=""""),_display_(Seq[Any](/*12.28*/controllers/*12.39*/.dashboard.routes.InformesRecuperoController.deudasPorTipoDeCliente(models.ClienteTipo.EXTRANJEROS))),format.raw/*12.138*/("""">Deudas Extrajeros</a></li>
		            <li><a href=""""),_display_(Seq[Any](/*13.29*/controllers/*13.40*/.dashboard.routes.InformesRecuperoController.deudasPorTipoDeCliente(models.ClienteTipo.OBRAS_SOCIALES))),format.raw/*13.142*/("""">Deudas Obras Sociales</a></li>
		            <li><a href=""""),_display_(Seq[Any](/*14.29*/controllers/*14.40*/.dashboard.routes.InformesRecuperoController.deudasPorTipoDeCliente(models.ClienteTipo.SEGUROS))),format.raw/*14.135*/("""">Deudas Seguros</a></li>
		            <li><a href=""""),_display_(Seq[Any](/*15.29*/controllers/*15.40*/.dashboard.routes.InformesRecuperoController.deudasPorTipoDeCliente(models.ClienteTipo.ART))),format.raw/*15.131*/("""">Deudas ART</a></li>
		            
		          </ul>
		        </li>
		       
		      </ul>
		    </div>  
		</div>
	</nav>
</div>"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:44:00 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/informesRecupero/navinformes.scala.html
                    HASH: 67738d40f43ad2b0018ee6d72d22e3df9ff21517
                    MATRIX: 888->0|1365->441|1385->452|1479->523|1570->578|1590->589|1710->686|1801->741|1821->752|1943->851|2036->908|2056->919|2181->1021|2278->1082|2298->1093|2416->1188|2506->1242|2526->1253|2640->1344
                    LINES: 29->1|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15
                    -- GENERATED --
                */
            