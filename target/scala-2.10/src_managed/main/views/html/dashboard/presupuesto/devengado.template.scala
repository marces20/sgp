
package views.html.dashboard.presupuesto

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
object devengado extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[List[com.avaje.ebean.SqlRow],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(datos:List[com.avaje.ebean.SqlRow]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

import java.math.BigDecimal;var totalDeudaOtros=new java.math.BigDecimal(0);

import java.lang.Integer;var proveedorId =0; 

import java.lang.String;var proveedorNombre =""

implicit def /*6.2*/implicitFieldConstructor/*6.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.38*/("""

"""),format.raw/*6.70*/("""
"""),_display_(Seq[Any](/*10.2*/views/*10.7*/.html.dashboard.mainDashboard("Devengado")/*10.49*/ {_display_(Seq[Any](format.raw/*10.51*/("""
"""),_display_(Seq[Any](/*11.2*/views/*11.7*/.html.dashboard.presupuesto.navPresupuesto())),format.raw/*11.51*/("""

<div class="page-header">
	<div class="row">
		<div class="col-sm-7">
			<h1>Devengado</h1>
		</div>
		<div class="col-sm-5">
			<div class="dropdown pull-right">
			 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
			 	<i class="glyphicon glyphicon-list-alt"></i>
			    Reportes
			    <span class="caret"></span>
			  </button>
			  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
			  	<li role="presentation">
			</ul>
			</div>
		</div>
	</div>
</div>




""")))})))}
    }
    
    def render(datos:List[com.avaje.ebean.SqlRow]): play.api.templates.HtmlFormat.Appendable = apply(datos)
    
    def f:((List[com.avaje.ebean.SqlRow]) => play.api.templates.HtmlFormat.Appendable) = (datos) => apply(datos)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:44:00 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/presupuesto/devengado.scala.html
                    HASH: bd40c9e48950d696a31f7d652285289181caab14
                    MATRIX: 822->1|1172->95|1204->119|1278->37|1307->163|1344->339|1357->344|1408->386|1448->388|1485->390|1498->395|1564->439
                    LINES: 26->1|39->6|39->6|40->1|42->6|43->10|43->10|43->10|43->10|44->11|44->11|44->11
                    -- GENERATED --
                */
            