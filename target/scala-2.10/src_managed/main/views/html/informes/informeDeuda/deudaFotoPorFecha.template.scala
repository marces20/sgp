
package views.html.informes.informeDeuda

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
object deudaFotoPorFecha extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template12[DynamicForm,String,String,java.math.BigDecimal,java.math.BigDecimal,java.math.BigDecimal,java.math.BigDecimal,java.math.BigDecimal,java.math.BigDecimal,java.math.BigDecimal,java.math.BigDecimal,java.math.BigDecimal,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm,
fecha:String,
fechaHoy:String,
totalCorte:java.math.BigDecimal,
totalHoy:java.math.BigDecimal,
totalDiferencia:java.math.BigDecimal,
totalCorteE:java.math.BigDecimal,
totalHoyE:java.math.BigDecimal,
totalDiferenciaE:java.math.BigDecimal,
totalCorteO:java.math.BigDecimal,
totalHoyO:java.math.BigDecimal,
totalDiferenciaO:java.math.BigDecimal):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

import models.auth._

implicit def /*16.2*/implicitFieldConstructor/*16.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*12.39*/("""
"""),format.raw/*16.70*/("""

"""),_display_(Seq[Any](/*18.2*/views/*18.7*/.html.informes.mainInformes("Deudas - Corte por Fecha")/*18.62*/ {_display_(Seq[Any](format.raw/*18.64*/("""

"""),_display_(Seq[Any](/*20.2*/views/*20.7*/.html.informes.navInformes())),format.raw/*20.35*/("""

"""),_display_(Seq[Any](/*22.2*/views/*22.7*/.html.tags.successError())),format.raw/*22.32*/("""
<div class="row">
	<div class="col-sm-10">
		<h1>Deudas  - Corte por Fecha Otros Proveedores - <span style="font-size: 12px;">(Fecha inicial de registro 21/06/2022)</span></h1>
		 
	
	</div>
	<div class="col-sm-4">
		
	</div>

	<div class="col-sm-4">
		
		 
	
	</div>
</div>

<form action="" method="GET" id="filtroInforme">
    	 
	<div class="row seccion">
		 
		<div class="col-sm-2 input-group">
			<label class="control-label">Fecha Corte</label>
			<div>
				"""),_display_(Seq[Any](/*47.6*/inputText(formBuscador("fecha_corte"), 'class -> "form-control date", 'id -> "fecha_corte", 'placeholder -> "Desde"))),format.raw/*47.122*/("""
			</div>
		</div>
		 
		
		<div class="col-sm-2">
			<div class="form-group">
				<label for="nombre" class="control-label">&nbsp;</label>
				<button  class="form-control btn btn-primary" id="btn-buscar">Buscar</button>
			</div>
		</div>
		<div class="col-sm-2">
			<div class="form-group">
				<label for="nombre" class="control-label">&nbsp;</label>
				<a href=""""),_display_(Seq[Any](/*61.15*/controllers/*61.26*/.informes.routes.InformesDeudasController.deudasFotoPorFecha())),format.raw/*61.88*/(""""  class="form-control btn btn-default">Limpiar</a>
			</div>
		</div>
		
	</div>
</form>
<hr>
"""),_display_(Seq[Any](/*68.2*/if(fecha != null)/*68.19*/{_display_(Seq[Any](format.raw/*68.20*/("""
<div class="row seccion">
<h3>Otros Proveedores - Totales</h3>
</div>
<div class="row seccion">
   	 <div class="col-sm-4">
	  	  <div class="small-box bg-green">
	  	  	<div class="inner">
	          <h3>Deuda al """),_display_(Seq[Any](/*76.26*/fecha)),format.raw/*76.31*/("""</h3>
	          <p>"""),_display_(Seq[Any](/*77.16*/utils/*77.21*/.NumberUtils.moneda(totalCorte))),format.raw/*77.52*/("""</p>
	  	  </div>
		 </div>
	 </div>
	 <div class="col-sm-4">
	  	  <div class="small-box bg-green">
	  	  	<div class="inner">
	          <h3>Deuda hoy """),_display_(Seq[Any](/*84.27*/fechaHoy)),format.raw/*84.35*/("""</h3>
	          <p>"""),_display_(Seq[Any](/*85.16*/utils/*85.21*/.NumberUtils.moneda(totalHoy))),format.raw/*85.50*/("""</p> 
	  	  </div>
		 </div>
	 </div> 
	 <div class="col-sm-4">
	  	  <div class="small-box bg-green">
	  	  	<div class="inner">
	          <h3>Diferencia entre Deudas</h3>
	          <p>"""),_display_(Seq[Any](/*93.16*/utils/*93.21*/.NumberUtils.moneda(totalDiferencia))),format.raw/*93.57*/("""</p>
	  	  </div>
		 </div>
	 </div> 
</div>
<hr>
<div class="row seccion">
<h3>Otros Proveedores Sin Equipamientos</h3>
</div>
<div class="row seccion">
   	 <div class="col-sm-4">
	  	  <div class="small-box bg-green">
	  	  	<div class="inner">
	          <h3>Deuda al """),_display_(Seq[Any](/*106.26*/fecha)),format.raw/*106.31*/("""</h3>
	          <p>"""),_display_(Seq[Any](/*107.16*/utils/*107.21*/.NumberUtils.moneda(totalCorteO))),format.raw/*107.53*/("""</p>
	  	  </div>
		 </div>
	 </div>
	 <div class="col-sm-4">
	  	  <div class="small-box bg-green">
	  	  	<div class="inner">
	          <h3>Deuda hoy """),_display_(Seq[Any](/*114.27*/fechaHoy)),format.raw/*114.35*/("""</h3>
	          <p>"""),_display_(Seq[Any](/*115.16*/utils/*115.21*/.NumberUtils.moneda(totalHoyO))),format.raw/*115.51*/("""</p> 
	  	  </div>
		 </div>
	 </div> 
	 <div class="col-sm-4">
	  	  <div class="small-box bg-green">
	  	  	<div class="inner">
	          <h3>Diferencia entre Deudas</h3>
	          <p>"""),_display_(Seq[Any](/*123.16*/utils/*123.21*/.NumberUtils.moneda(totalDiferenciaO))),format.raw/*123.58*/("""</p>
	  	  </div>
		 </div>
	 </div> 
</div>
<hr>
<div class="row seccion">
<h3>Otros Proveedores Equipamientos</h3>
</div>
<div class="row seccion">
   	 <div class="col-sm-4">
	  	  <div class="small-box bg-green">
	  	  	<div class="inner">
	          <h3>Deuda al """),_display_(Seq[Any](/*136.26*/fecha)),format.raw/*136.31*/("""</h3>
	          <p>"""),_display_(Seq[Any](/*137.16*/utils/*137.21*/.NumberUtils.moneda(totalCorteE))),format.raw/*137.53*/("""</p>
	  	  </div>
		 </div>
	 </div>
	 <div class="col-sm-4">
	  	  <div class="small-box bg-green">
	  	  	<div class="inner">
	          <h3>Deuda hoy """),_display_(Seq[Any](/*144.27*/fechaHoy)),format.raw/*144.35*/("""</h3>
	          <p>"""),_display_(Seq[Any](/*145.16*/utils/*145.21*/.NumberUtils.moneda(totalHoyE))),format.raw/*145.51*/("""</p> 
	  	  </div>
		 </div>
	 </div> 
	 <div class="col-sm-4">
	  	  <div class="small-box bg-green">
	  	  	<div class="inner">
	          <h3>Diferencia entre Deudas</h3>
	          <p>"""),_display_(Seq[Any](/*153.16*/utils/*153.21*/.NumberUtils.moneda(totalDiferenciaE))),format.raw/*153.58*/("""</p>
	  	  </div>
		 </div>
	 </div> 
</div>
<hr>
""")))})),format.raw/*159.2*/("""
""")))})))}
    }
    
    def render(formBuscador:DynamicForm,fecha:String,fechaHoy:String,totalCorte:java.math.BigDecimal,totalHoy:java.math.BigDecimal,totalDiferencia:java.math.BigDecimal,totalCorteE:java.math.BigDecimal,totalHoyE:java.math.BigDecimal,totalDiferenciaE:java.math.BigDecimal,totalCorteO:java.math.BigDecimal,totalHoyO:java.math.BigDecimal,totalDiferenciaO:java.math.BigDecimal): play.api.templates.HtmlFormat.Appendable = apply(formBuscador,fecha,fechaHoy,totalCorte,totalHoy,totalDiferencia,totalCorteE,totalHoyE,totalDiferenciaE,totalCorteO,totalHoyO,totalDiferenciaO)
    
    def f:((DynamicForm,String,String,java.math.BigDecimal,java.math.BigDecimal,java.math.BigDecimal,java.math.BigDecimal,java.math.BigDecimal,java.math.BigDecimal,java.math.BigDecimal,java.math.BigDecimal,java.math.BigDecimal) => play.api.templates.HtmlFormat.Appendable) = (formBuscador,fecha,fechaHoy,totalCorte,totalHoy,totalDiferencia,totalCorteE,totalHoyE,totalDiferenciaE,totalCorteO,totalHoyO,totalDiferenciaO) => apply(formBuscador,fecha,fechaHoy,totalCorte,totalHoy,totalDiferencia,totalCorteE,totalHoyE,totalDiferenciaE,totalCorteO,totalHoyO,totalDiferenciaO)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:28 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/informes/informeDeuda/deudaFotoPorFecha.scala.html
                    HASH: bfa868f178ff1f1139fe33c962fe6b4e5061f844
                    MATRIX: 1017->1|1528->428|1561->452|1636->371|1665->496|1703->499|1716->504|1780->559|1820->561|1858->564|1871->569|1921->597|1959->600|1972->605|2019->630|2521->1097|2660->1213|3066->1583|3086->1594|3170->1656|3301->1752|3327->1769|3366->1770|3618->1986|3645->1991|3702->2012|3716->2017|3769->2048|3959->2202|3989->2210|4046->2231|4060->2236|4111->2265|4336->2454|4350->2459|4408->2495|4718->2768|4746->2773|4804->2794|4819->2799|4874->2831|5065->2985|5096->2993|5154->3014|5169->3019|5222->3049|5448->3238|5463->3243|5523->3280|5829->3549|5857->3554|5915->3575|5930->3580|5985->3612|6176->3766|6207->3774|6265->3795|6280->3800|6333->3830|6559->4019|6574->4024|6634->4061|6717->4112
                    LINES: 26->1|44->16|44->16|45->12|46->16|48->18|48->18|48->18|48->18|50->20|50->20|50->20|52->22|52->22|52->22|77->47|77->47|91->61|91->61|91->61|98->68|98->68|98->68|106->76|106->76|107->77|107->77|107->77|114->84|114->84|115->85|115->85|115->85|123->93|123->93|123->93|136->106|136->106|137->107|137->107|137->107|144->114|144->114|145->115|145->115|145->115|153->123|153->123|153->123|166->136|166->136|167->137|167->137|167->137|174->144|174->144|175->145|175->145|175->145|183->153|183->153|183->153|189->159
                    -- GENERATED --
                */
            