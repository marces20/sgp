
package views.html.dashboard.informeEstadisticoPagoProveedores

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
object informeProveedor extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[DynamicForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formBuscador: DynamicForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import java.math.BigDecimal;var total=new java.math.BigDecimal(0);var totalf=new java.math.BigDecimal(0);var totali=new java.math.BigDecimal(0);

import java.util.Map;var li = new java.util.ArrayList[Long];

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.29*/("""
"""),format.raw/*3.70*/(""" 
"""),format.raw/*6.1*/("""
 
 
"""),_display_(Seq[Any](/*9.2*/views/*9.7*/.html.dashboard.mainDashboard(title = "Informe Proveedor")/*9.65*/ {_display_(Seq[Any](format.raw/*9.67*/("""

<div class="page-header">
	<div class="row">
		<div class="col-sm-4">
			<h1>Informe Proveedor</h1>
		</div>

		
		<form action="" method="GET" id="filtroInforme">
			<div class="col-sm-4">
				<label class="control-label">Proveedor
					<div class="input-group">	
						"""),_display_(Seq[Any](/*22.8*/inputText(formBuscador("proveedor_nombre"), 'name -> "", 'autofocus -> "autofocus", 'class -> "form-control", 'id -> "proveedor"))),format.raw/*22.137*/("""
						"""),_display_(Seq[Any](/*23.8*/inputText(formBuscador("proveedor_id"), 'hidden -> "hidden", 'id -> "proveedor_id"))),format.raw/*23.91*/("""
						<span class="input-group-addon">
							<a href="#" class="searchModal"
										id="searchProveedor" 
										data-title="Selección de Proveedores" 
										data-url=""""),_display_(Seq[Any](/*28.22*/controllers/*28.33*/.compras.routes.ProveedoresController.modalBuscar())),format.raw/*28.84*/("""" 
										data-height="650" 
										data-width="700" 
										data-listen="modal.seleccion.proveedor.simple" 
										data-label="#proveedor" 
										data-field="#proveedor_id">
								<i class="glyphicon glyphicon-search"></i>
							</a>
						</span>
					</div>
				</label>
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
					<a href=""""),_display_(Seq[Any](/*49.16*/controllers/*49.27*/.dashboard.routes.InformeEstadisticoPagoProveedoresController.informePeriodoProveedor())),format.raw/*49.114*/(""""  class="form-control btn btn-default">Limpiar</a>
				</div>
			</div>
		</form>
		
	</div>
</div>

"""),_display_(Seq[Any](/*57.2*/views/*57.7*/.html.tags.successError())),format.raw/*57.32*/("""

<div class="row seccion">
   	 <div class="col-sm-4">
	  	 <div class="small-box bg-green">
	  	  	<div class="inner">
	          <h3>Total Pagado - 12/21</h3>
	          <p>$44.524.411,89</p>
	  	  	</div>
		 </div>
	 </div>
	 <div class="col-sm-4">
	  	 <div class="small-box bg-green">
	  	  	<div class="inner">
	          <h3>Total Deuda</h3>
	          <p>$44.524.411,89</p>
	  	  	</div>
		 </div>
	 </div>
	 <div class="col-sm-4">
	  	 <div class="small-box bg-green">
	  	  	<div class="inner">
	          <h3>Total Deuda en Tramite</h3>
	          <p>$44.524.411,89</p>
	  	  	</div>
		 </div>
	 </div>   
</div>
   <hr>



<script type="text/javascript">
$( function() """),format.raw/*90.15*/("""{"""),format.raw/*90.16*/("""
	$('#searchProveedor,#searchPeriodo').modalSearch();
"""),format.raw/*92.1*/("""}"""),format.raw/*92.2*/(""");
</script>
""")))})))}
    }
    
    def render(formBuscador:DynamicForm): play.api.templates.HtmlFormat.Appendable = apply(formBuscador)
    
    def f:((DynamicForm) => play.api.templates.HtmlFormat.Appendable) = (formBuscador) => apply(formBuscador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:44:00 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/informeEstadisticoPagoProveedores/informeProveedor.scala.html
                    HASH: 826227df00c99637eb2bc69fa0213f8e6abf9063
                    MATRIX: 834->1|1171->47|1203->71|1277->28|1305->115|1333->325|1373->331|1385->336|1451->394|1490->396|1799->670|1951->799|1994->807|2099->890|2316->1071|2336->1082|2409->1133|3101->1789|3121->1800|3231->1887|3369->1990|3382->1995|3429->2020|4139->2702|4168->2703|4249->2757|4277->2758
                    LINES: 26->1|33->3|33->3|34->1|35->3|36->6|39->9|39->9|39->9|39->9|52->22|52->22|53->23|53->23|58->28|58->28|58->28|79->49|79->49|79->49|87->57|87->57|87->57|120->90|120->90|122->92|122->92
                    -- GENERATED --
                */
            