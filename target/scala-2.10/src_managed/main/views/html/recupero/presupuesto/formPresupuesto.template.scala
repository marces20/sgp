
package views.html.recupero.presupuesto

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
object formPresupuesto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.recupero.Presupuesto],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(presupuestoForm: Form[models.recupero.Presupuesto]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.54*/("""
"""),format.raw/*4.70*/(""" 
	
	
	<div class="row menu-acciones">
		<div class="col-sm-10">
			<button type="submit" class="btn btn-default" title="Guardar orden"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>	
																																   
	    	<a href=""""),_display_(Seq[Any](/*11.17*/if(request().getHeader("referer"))/*11.51*/{_display_(Seq[Any](format.raw/*11.52*/(""" """),_display_(Seq[Any](/*11.54*/request()/*11.63*/.getHeader("referer"))),format.raw/*11.84*/(""" """)))}/*11.87*/else/*11.92*/{_display_(Seq[Any](_display_(Seq[Any](/*11.94*/controllers/*11.105*/.recupero.routes.PresupuestosController.index())),_display_(Seq[Any](/*11.153*/UriTrack/*11.161*/.decode()))))})),format.raw/*11.171*/("""" title="Cancelar editar" class="btn btn-default"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
	    </div>
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*14.14*/UriTrack/*14.22*/.decode())),format.raw/*14.31*/("""" title="Volver al listado" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
			"""),_display_(Seq[Any](/*15.5*/if(presupuestoForm.field("id").value)/*15.42*/{_display_(Seq[Any](format.raw/*15.43*/("""<a href=""""),_display_(Seq[Any](/*15.53*/controllers/*15.64*/.recupero.routes.PresupuestosController.ver(presupuestoForm.field("id").value.toLong))),_display_(Seq[Any](/*15.150*/UriTrack/*15.158*/.get("&"))),format.raw/*15.167*/("""" title="Ver presupuesto" class="btn btn-default"><i class="glyphicon glyphicon-align-justify"></i></a>""")))})),format.raw/*15.271*/("""
		</div>
	</div>
	
	
	"""),_display_(Seq[Any](/*20.3*/inputText(presupuestoForm("id"), 'type -> "hidden", 'id -> "presupuestoId"))),format.raw/*20.78*/("""
	<input type="hidden" name="""),_display_(Seq[Any](/*21.29*/UriTrack/*21.37*/.getKey())),format.raw/*21.46*/(""" value=""""),_display_(Seq[Any](/*21.55*/UriTrack/*21.63*/.code())),format.raw/*21.70*/("""" />
	<div class="row">
		<div class="col-sm-2">
			<label class="control-label">Nombre</label> 
			<div class="form-group """),_display_(Seq[Any](/*25.28*/if(presupuestoForm.error("nombre") != null)/*25.71*/ {_display_(Seq[Any](format.raw/*25.73*/("""has-error""")))})),format.raw/*25.83*/("""">
				"""),_display_(Seq[Any](/*26.6*/inputText(presupuestoForm("nombre"), 'class -> "form-control",'readOnly -> "readOnly"))),format.raw/*26.92*/("""
				
				"""),_display_(Seq[Any](/*28.6*/presupuestoForm("nombre")/*28.31*/.error.map/*28.41*/{ error =>_display_(Seq[Any](format.raw/*28.51*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*29.31*/error/*29.36*/.message)),format.raw/*29.44*/("""</div>
				""")))})),format.raw/*30.6*/("""
			</div>
		</div>
		<div class="col-sm-4">
			<label class="control-label">Cliente</label> 
			<div class="input-group """),_display_(Seq[Any](/*35.29*/if(presupuestoForm.error("cliente_id") != null)/*35.76*/ {_display_(Seq[Any](format.raw/*35.78*/("""has-error""")))}/*35.88*/else/*35.92*/{_display_(Seq[Any](format.raw/*35.93*/("""has-required""")))})),format.raw/*35.106*/("""">	
				"""),_display_(Seq[Any](/*36.6*/inputText(presupuestoForm("cliente.nombre"), 'class -> "form-control", 'id -> "cliente_nombre"))),format.raw/*36.101*/("""
				"""),_display_(Seq[Any](/*37.6*/inputText(presupuestoForm("cliente_id"), 'hidden -> "hidden", 'id -> "cliente_id"))),format.raw/*37.88*/("""
				<span class="input-group-addon">
                	<a href="#" id="searchCliente" 
                	data-title="Selección de cliente" 
                	data-url=""""),_display_(Seq[Any](/*41.29*/controllers/*41.40*/.compras.routes.ClientesController.modalBuscar())),format.raw/*41.88*/("""" 
                	data-height="650" data-width="700" 
                	data-listen="modal.seleccion.cliente.simple" 
                	data-label="#cliente_nombre" data-field="#cliente_id" /> 
                	<i class="glyphicon glyphicon-search"></i></a>
                </span>
                <span class="input-group-addon">
                	<a href="#" id="searchPacienteCarga" 
			                	data-title="Carga de paciente" 
			                	data-url=""""),_display_(Seq[Any](/*50.32*/controllers/*50.43*/.compras.routes.ClientesController.modalCarga())),format.raw/*50.90*/("""" 
			                	data-height="650" 
			                	data-width="700" 
			                	data-listen="modal.carga.cliente.simple" 
			                	data-label="#paciente" 
			                	data-field="#paciente_id" /> 
			                	<i class="glyphicon glyphicon-plus"></i></a>
                </span>
			</div>
			"""),_display_(Seq[Any](/*59.5*/presupuestoForm("cliente_id")/*59.34*/.error.map/*59.44*/{ error =>_display_(Seq[Any](format.raw/*59.54*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*60.30*/error/*60.35*/.message)),format.raw/*60.43*/("""</div>
			""")))})),format.raw/*61.5*/("""
		</div>
		<div class="col-sm-2">
			<label class="control-label">Fecha presupuesto</label> 
			<div class="form-group """),_display_(Seq[Any](/*65.28*/if(presupuestoForm.error("fecha")  != null)/*65.71*/ {_display_(Seq[Any](format.raw/*65.73*/("""has-error""")))}/*65.83*/else/*65.87*/{_display_(Seq[Any](format.raw/*65.88*/("""has-required""")))})),format.raw/*65.101*/("""">
				"""),_display_(Seq[Any](/*66.6*/inputText(presupuestoForm("fecha"),'class -> "form-control date", 'autocomplete -> "off"))),format.raw/*66.95*/("""
			</div>
			"""),_display_(Seq[Any](/*68.5*/presupuestoForm("fecha")/*68.29*/.error.map/*68.39*/{ error =>_display_(Seq[Any](format.raw/*68.49*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*69.30*/error/*69.35*/.message)),format.raw/*69.43*/("""</div>
			""")))})),format.raw/*70.5*/("""
		</div>
		
		<div class="col-sm-4">
			<label for="deposito" class="control-label">Institucion</label> 
			<div class="input-group """),_display_(Seq[Any](/*75.29*/if(presupuestoForm.error("deposito_id") != null)/*75.77*/ {_display_(Seq[Any](format.raw/*75.79*/("""has-error""")))}/*75.89*/else/*75.93*/{_display_(Seq[Any](format.raw/*75.94*/("""has-required""")))})),format.raw/*75.107*/("""">
				"""),_display_(Seq[Any](/*76.6*/inputText(presupuestoForm("deposito.nombre"),'class -> "form-control", 'id -> "deposito_nombre", 'autocomplete -> "off"))),format.raw/*76.126*/("""
				"""),_display_(Seq[Any](/*77.6*/inputText(presupuestoForm("deposito_id"),'hidden -> "hidden", 'id -> "deposito_id"))),format.raw/*77.89*/("""
				<span class="input-group-addon">
                	<a href="#" id="searchDeposito" data-title="Selección de Institucion" 
                	data-url=""""),_display_(Seq[Any](/*80.29*/controllers/*80.40*/.delegacion.routes.DepositosController.modalBuscar())),format.raw/*80.92*/("""" 
                	data-height="650" data-width="700" 
                	data-listen="modal.seleccion.deposito.simple" 
                	data-label="#deposito_nombre" data-field="#deposito_id" /> <i class="glyphicon glyphicon-search"></i></a>
                </span>
			</div>
			"""),_display_(Seq[Any](/*86.5*/presupuestoForm("deposito_id")/*86.35*/.error.map/*86.45*/{ error =>_display_(Seq[Any](format.raw/*86.55*/("""
				<div class="text-error">"""),_display_(Seq[Any](/*87.30*/error/*87.35*/.message)),format.raw/*87.43*/("""</div>
			""")))})),format.raw/*88.5*/("""
		</div>
	</div>"""))}
    }
    
    def render(presupuestoForm:Form[models.recupero.Presupuesto]): play.api.templates.HtmlFormat.Appendable = apply(presupuestoForm)
    
    def f:((Form[models.recupero.Presupuesto]) => play.api.templates.HtmlFormat.Appendable) = (presupuestoForm) => apply(presupuestoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:35 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/recupero/presupuesto/formPresupuesto.scala.html
                    HASH: b42a20d4f8da8d4292d34cb1c2f5494a1542e80f
                    MATRIX: 832->1|1002->88|1034->112|1108->53|1136->156|1426->410|1469->444|1508->445|1546->447|1564->456|1607->477|1628->480|1641->485|1689->487|1710->498|1789->546|1807->554|1844->564|2043->727|2060->735|2091->744|2228->846|2274->883|2313->884|2359->894|2379->905|2496->991|2514->999|2546->1008|2683->1112|2742->1136|2839->1211|2904->1240|2921->1248|2952->1257|2997->1266|3014->1274|3043->1281|3203->1405|3255->1448|3295->1450|3337->1460|3380->1468|3488->1554|3534->1565|3568->1590|3587->1600|3635->1610|3702->1641|3716->1646|3746->1654|3789->1666|3947->1788|4003->1835|4043->1837|4072->1847|4085->1851|4124->1852|4170->1865|4214->1874|4332->1969|4373->1975|4477->2057|4680->2224|4700->2235|4770->2283|5275->2752|5295->2763|5364->2810|5738->3149|5776->3178|5795->3188|5843->3198|5909->3228|5923->3233|5953->3241|5995->3252|6152->3373|6204->3416|6244->3418|6273->3428|6286->3432|6325->3433|6371->3446|6414->3454|6525->3543|6575->3558|6608->3582|6627->3592|6675->3602|6741->3632|6755->3637|6785->3645|6827->3656|6997->3790|7054->3838|7094->3840|7123->3850|7136->3854|7175->3855|7221->3868|7264->3876|7407->3996|7448->4002|7553->4085|7743->4239|7763->4250|7837->4302|8153->4583|8192->4613|8211->4623|8259->4633|8325->4663|8339->4668|8369->4676|8411->4687
                    LINES: 26->1|31->4|31->4|32->1|33->4|40->11|40->11|40->11|40->11|40->11|40->11|40->11|40->11|40->11|40->11|40->11|40->11|40->11|43->14|43->14|43->14|44->15|44->15|44->15|44->15|44->15|44->15|44->15|44->15|44->15|49->20|49->20|50->21|50->21|50->21|50->21|50->21|50->21|54->25|54->25|54->25|54->25|55->26|55->26|57->28|57->28|57->28|57->28|58->29|58->29|58->29|59->30|64->35|64->35|64->35|64->35|64->35|64->35|64->35|65->36|65->36|66->37|66->37|70->41|70->41|70->41|79->50|79->50|79->50|88->59|88->59|88->59|88->59|89->60|89->60|89->60|90->61|94->65|94->65|94->65|94->65|94->65|94->65|94->65|95->66|95->66|97->68|97->68|97->68|97->68|98->69|98->69|98->69|99->70|104->75|104->75|104->75|104->75|104->75|104->75|104->75|105->76|105->76|106->77|106->77|109->80|109->80|109->80|115->86|115->86|115->86|115->86|116->87|116->87|116->87|117->88
                    -- GENERATED --
                */
            