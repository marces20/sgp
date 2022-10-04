
package views.html.rrhh.agente

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
object tabsAgente extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template4[Boolean,Form[Agente],Agente,List[models.haberes.PuestoLaboral],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formularioCarga: Boolean, agenteForm: Form[Agente] = null,agente:Agente,pl:List[models.haberes.PuestoLaboral]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.113*/("""
 
<div class="row">
	<div class="col-sm-12">
		<hr>
		<h3>Datos Estudios</h3>
	</div>
</div>
<div class="row">
	<div class="col-sm-12">
		"""),_display_(Seq[Any](/*11.4*/views/*11.9*/.html.rrhh.agente.contenidoTabEstudio(formularioCarga, agenteForm, agente:Agente))),format.raw/*11.90*/("""
	</div>
</div>		
<!-- <div class="row">
	<div class="col-sm-12">
		<hr>
		<h3>Datos Hijos</h3>
	</div>
</div>
<div class="row">
	<div class="col-sm-12">
		"""),_display_(Seq[Any](/*22.4*/views/*22.9*/.html.rrhh.agente.contenidoTabHijo(formularioCarga, agenteForm, agente:Agente))),format.raw/*22.87*/("""
	</div>
</div>	 -->

<div class="row">
	<div class="col-sm-12">
		<hr>
		<h3>Datos Familiares</h3>
	</div>
</div>
<div class="row">
	<div class="col-sm-12">
		"""),_display_(Seq[Any](/*34.4*/views/*34.9*/.html.rrhh.agente.contenidoTabFamilia(formularioCarga, agenteForm, agente:Agente))),format.raw/*34.90*/("""
	</div>
</div>	

<div class="row">
	<div class="col-sm-12">
		<hr>
		<h3>Datos RUL</h3>
	</div>
</div>
<div class="row">
	<div class="col-sm-12">
		"""),_display_(Seq[Any](/*46.4*/views/*46.9*/.html.rrhh.agente.contenidoTabRul(formularioCarga, agenteForm, agente:Agente))),format.raw/*46.86*/("""
	</div>
</div>	

"""),_display_(Seq[Any](/*50.2*/if(pl != null && pl.size() > 0)/*50.33*/{_display_(Seq[Any](format.raw/*50.34*/("""
<div class="row">
	<div class="col-sm-12">
		<hr>
		<h3>Datos Puestos Laborales</h3>
	</div>
</div>
<div class="row">
	<div class="col-sm-12">
		"""),_display_(Seq[Any](/*59.4*/views/*59.9*/.html.rrhh.agente.contenidoTabPuestoLaboral(formularioCarga, agenteForm, agente:Agente,pl))),format.raw/*59.99*/("""
	</div>
</div>
""")))})),format.raw/*62.2*/("""
"""))}
    }
    
    def render(formularioCarga:Boolean,agenteForm:Form[Agente],agente:Agente,pl:List[models.haberes.PuestoLaboral]): play.api.templates.HtmlFormat.Appendable = apply(formularioCarga,agenteForm,agente,pl)
    
    def f:((Boolean,Form[Agente],Agente,List[models.haberes.PuestoLaboral]) => play.api.templates.HtmlFormat.Appendable) = (formularioCarga,agenteForm,agente,pl) => apply(formularioCarga,agenteForm,agente,pl)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:30 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agente/tabsAgente.scala.html
                    HASH: d3248d3d464c0c88355c98bc2f6480859aede0fe
                    MATRIX: 847->1|1053->112|1228->252|1241->257|1344->338|1536->495|1549->500|1649->578|1845->739|1858->744|1961->825|2146->975|2159->980|2258->1057|2312->1076|2352->1107|2391->1108|2573->1255|2586->1260|2698->1350|2746->1367
                    LINES: 26->1|29->1|39->11|39->11|39->11|50->22|50->22|50->22|62->34|62->34|62->34|74->46|74->46|74->46|78->50|78->50|78->50|87->59|87->59|87->59|90->62
                    -- GENERATED --
                */
            