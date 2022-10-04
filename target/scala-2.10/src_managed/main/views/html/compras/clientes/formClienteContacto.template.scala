
package views.html.compras.clientes

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
object formClienteContacto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Form[DireccionCliente],Long,Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(clienteForm: Form[DireccionCliente], clienteId: Long, clienteExiste: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.80*/("""
"""),format.raw/*3.70*/(""" 




"""),_display_(Seq[Any](/*8.2*/helper/*8.8*/.form(action = controllers.compras.routes.ClientesController.actualizarContacto(), 'id -> "formularioContacto")/*8.119*/ {_display_(Seq[Any](format.raw/*8.121*/("""
<div id="formularioContacto">
<p>
	"""),_display_(Seq[Any](/*11.3*/if(clienteExiste)/*11.20*/{_display_(Seq[Any](format.raw/*11.21*/("""
		<a class="btn btn-xs btn-default" id="guardarContacto" href="#"><i class="glyphicon glyphicon-floppy-saved"></i> Guardar</a>
		<a class="btn btn-xs btn-default" id="cancelarEdicion" href="#"><i class="glyphicon glyphicon-remove-sign"></i> Cancelar</a>
	""")))})),format.raw/*14.3*/("""
</p>

  	"""),_display_(Seq[Any](/*17.5*/inputText(clienteForm("id"), 'hidden -> "hidden"))),format.raw/*17.54*/(""" 	
  	<input type="hidden" name="cliente_id" value=""""),_display_(Seq[Any](/*18.51*/clienteId)),format.raw/*18.60*/("""" />
  	<div class="row">
  		<div class="col-sm-6">
  			<legend>Dirección postal</legend>
  				<div class="row">
				<div class="col-sm-6">
					<div class="form-group """),_display_(Seq[Any](/*24.30*/if(clienteForm.error("calle") != null)/*24.68*/  {_display_(Seq[Any](format.raw/*24.71*/("""has-error""")))}/*24.82*/else/*24.87*/{_display_(Seq[Any](format.raw/*24.88*/("""has-required""")))})),format.raw/*24.101*/("""">
						<label for=""""),_display_(Seq[Any](/*25.20*/clienteForm("calle")/*25.40*/.id)),format.raw/*25.43*/("""" class="control-label">Calle</label>
						"""),_display_(Seq[Any](/*26.8*/inputText(clienteForm("calle"), 'class -> "form-control"))),format.raw/*26.65*/("""
						"""),_display_(Seq[Any](/*27.8*/clienteForm("calle")/*27.28*/.error.map/*27.38*/{ error =>_display_(Seq[Any](format.raw/*27.48*/("""
							<div class="text-error">"""),_display_(Seq[Any](/*28.33*/error/*28.38*/.message)),format.raw/*28.46*/("""</div>
						""")))})),format.raw/*29.8*/("""
					</div>
				</div>
			
				<div class="col-sm-3">
					<div class="form-group """),_display_(Seq[Any](/*34.30*/if(clienteForm.error("numero") != null)/*34.69*/  {_display_(Seq[Any](format.raw/*34.72*/("""has-error""")))}/*34.83*/else/*34.88*/{_display_(Seq[Any](format.raw/*34.89*/("""has-required""")))})),format.raw/*34.102*/("""">
						<label for=""""),_display_(Seq[Any](/*35.20*/clienteForm("numero")/*35.41*/.id)),format.raw/*35.44*/("""" class="control-label">Número</label>
						"""),_display_(Seq[Any](/*36.8*/inputText(clienteForm("numero"), 'class -> "form-control"))),format.raw/*36.66*/("""
						"""),_display_(Seq[Any](/*37.8*/clienteForm("numero")/*37.29*/.error.map/*37.39*/{ error =>_display_(Seq[Any](format.raw/*37.49*/("""
							<div class="text-error">"""),_display_(Seq[Any](/*38.33*/error/*38.38*/.message)),format.raw/*38.46*/("""</div>
						""")))})),format.raw/*39.8*/("""
					</div>
				</div>
				
				<div class="col-sm-3">
					<div class="form-group """),_display_(Seq[Any](/*44.30*/if(clienteForm.error("cp") != null)/*44.65*/ {_display_(Seq[Any](format.raw/*44.67*/("""has-error""")))})),format.raw/*44.77*/("""">
						<label for=""""),_display_(Seq[Any](/*45.20*/clienteForm("cp")/*45.37*/.id)),format.raw/*45.40*/("""" class="control-label">C. Postal</label>
						"""),_display_(Seq[Any](/*46.8*/inputText(clienteForm("cp"), 'class -> "form-control"))),format.raw/*46.62*/("""
						"""),_display_(Seq[Any](/*47.8*/clienteForm("cp")/*47.25*/.error.map/*47.35*/{ error =>_display_(Seq[Any](format.raw/*47.45*/("""
							<div class="text-error">"""),_display_(Seq[Any](/*48.33*/error/*48.38*/.message)),format.raw/*48.46*/("""</div>
						""")))})),format.raw/*49.8*/("""
					</div>
				</div>
				
 				</div>

				<div class="row contenedorUbicacion">
					<div class="col-sm-4">
						<div class="seleccionPais form-group """),_display_(Seq[Any](/*57.45*/if(clienteForm.error("localidad.provincia.pais.id") != null)/*57.105*/ {_display_(Seq[Any](format.raw/*57.107*/("""has-error""")))})),format.raw/*57.117*/("""">
							<label for=""""),_display_(Seq[Any](/*58.21*/clienteForm("localidad.provincia.pais.id")/*58.63*/.id)),format.raw/*58.66*/("""" class="control-label">País</label>
							"""),_display_(Seq[Any](/*59.9*/select(clienteForm("localidad.provincia.pais.id"), Pais.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*59.175*/("""
							"""),_display_(Seq[Any](/*60.9*/clienteForm("localidad.provincia.pais.id")/*60.51*/.error.map/*60.61*/{ error =>_display_(Seq[Any](format.raw/*60.71*/("""
								<div class="text-error">"""),_display_(Seq[Any](/*61.34*/error/*61.39*/.message)),format.raw/*61.47*/("""</div>
							""")))})),format.raw/*62.9*/("""
						</div>
					</div>
		
					<div class="col-sm-4">
						<div class="seleccionProvincia form-group """),_display_(Seq[Any](/*67.50*/if(clienteForm.error("localidad.provincia.id") != null)/*67.105*/ {_display_(Seq[Any](format.raw/*67.107*/("""has-error""")))})),format.raw/*67.117*/("""">
							<label for=""""),_display_(Seq[Any](/*68.21*/clienteForm("localidad.provincia.id")/*68.58*/.id)),format.raw/*68.61*/("""" class="control-label">Provincia</label>
							"""),_display_(Seq[Any](/*69.9*/select(clienteForm("localidad.provincia.id"), 
								clienteForm("localidad.provincia.pais.id").value match {
									case null => {options()}
									case v if v.matches("\\d+") => {Provincia.getProvincias(v.toInt).map { p => p.id.toString -> p.nombre}}
									case _ => {options()}
								}, 
							'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*75.68*/("""
							"""),_display_(Seq[Any](/*76.9*/clienteForm("localidad.provincia.id")/*76.46*/.error.map/*76.56*/{ error =>_display_(Seq[Any](format.raw/*76.66*/("""
								<div class="text-error">"""),_display_(Seq[Any](/*77.34*/error/*77.39*/.message)),format.raw/*77.47*/("""</div>
							""")))})),format.raw/*78.9*/("""
						</div>
					</div>

					<div class="col-sm-4">
						<div class="seleccionLocalidad form-group """),_display_(Seq[Any](/*83.50*/if(clienteForm.error("localidad_id") != null)/*83.95*/ {_display_(Seq[Any](format.raw/*83.97*/("""has-error""")))}/*83.108*/else/*83.113*/{_display_(Seq[Any](format.raw/*83.114*/("""has-required""")))})),format.raw/*83.127*/("""">
							<label for=""""),_display_(Seq[Any](/*84.21*/clienteForm("localidad.id")/*84.48*/.id)),format.raw/*84.51*/("""" class="control-label">Localidad</label>
							"""),_display_(Seq[Any](/*85.9*/select(clienteForm("localidad_id"), 
								clienteForm("localidad.provincia.id").value match {
									case null => {options()}
									case v if v.matches("\\d+") => {Localidad.getLocalidades(v.toInt).map { p => p.id.toString -> p.nombre}}
									case _ => {options()}
								}, 
							'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*91.68*/("""
							"""),_display_(Seq[Any](/*92.9*/clienteForm("localidad_id")/*92.36*/.error.map/*92.46*/{ error =>_display_(Seq[Any](format.raw/*92.56*/("""
								<div class="text-error">"""),_display_(Seq[Any](/*93.34*/error/*93.39*/.message)),format.raw/*93.47*/("""</div>
							""")))})),format.raw/*94.9*/("""
						</div>
					</div>
				</div>

  		</div>
  		
  		<div class="col-sm-6">
  			<legend>Comunicación</legend>
  			
  			<div class="row">
				<div class="col-sm-12">
			   			<label for=""""),_display_(Seq[Any](/*106.23*/clienteForm("nombre")/*106.44*/.id)),format.raw/*106.47*/("""" class="control-label">Nombre del contacto</label>
			   				"""),_display_(Seq[Any](/*107.12*/inputText(clienteForm("nombre"), 'class -> "direccion form-control"))),format.raw/*107.80*/("""
			   				"""),_display_(Seq[Any](/*108.12*/clienteForm("nombre")/*108.33*/.errors.map/*108.44*/{ error =>_display_(Seq[Any](format.raw/*108.54*/("""
								<div class="text-error">"""),_display_(Seq[Any](/*109.34*/error/*109.39*/.message)),format.raw/*109.47*/("""</div>
							""")))})),format.raw/*110.9*/("""
				</div>
			</div>
  			
  			
  			<div class="row">
				<div class="col-sm-7">
			   		<div class="form-group """),_display_(Seq[Any](/*117.33*/if(clienteForm.error("email") != null)/*117.71*/ {_display_(Seq[Any](format.raw/*117.73*/("""has-error""")))})),format.raw/*117.83*/("""">
			   			<label for=""""),_display_(Seq[Any](/*118.23*/clienteForm("email")/*118.43*/.id)),format.raw/*118.46*/("""" class="control-label">Correo electrónico</label>
			   				"""),_display_(Seq[Any](/*119.12*/inputText(clienteForm("email"), 'class -> "direccion form-control"))),format.raw/*119.79*/("""
			   				"""),_display_(Seq[Any](/*120.12*/clienteForm("email")/*120.32*/.error.map/*120.42*/{ error =>_display_(Seq[Any](format.raw/*120.52*/("""
								<div class="text-error">"""),_display_(Seq[Any](/*121.34*/error/*121.39*/.message)),format.raw/*121.47*/("""</div>
							""")))})),format.raw/*122.9*/("""
					</div>
		  		</div>
				<div class="col-sm-5">
			   		<div class="form-group """),_display_(Seq[Any](/*126.33*/if(clienteForm.error("telefono") != null)/*126.74*/ {_display_(Seq[Any](format.raw/*126.76*/("""has-error""")))})),format.raw/*126.86*/("""">
			   			<label for=""""),_display_(Seq[Any](/*127.23*/clienteForm("telefono")/*127.46*/.id)),format.raw/*127.49*/("""" class="control-label">Teléfono fijo</label>
			   				"""),_display_(Seq[Any](/*128.12*/inputText(clienteForm("telefono"), 'class -> "direccion form-control"))),format.raw/*128.82*/("""
			   				"""),_display_(Seq[Any](/*129.12*/clienteForm("telefono")/*129.35*/.errors.map/*129.46*/{ error =>_display_(Seq[Any](format.raw/*129.56*/("""
								<div class="text-error">"""),_display_(Seq[Any](/*130.34*/error/*130.39*/.message)),format.raw/*130.47*/("""</div>
							""")))})),format.raw/*131.9*/("""
					</div>
		  		</div>
  			</div>
  			
  			<div class="row">
		  		<div class="col-sm-6">
			   		<div class="form-group """),_display_(Seq[Any](/*138.33*/if(clienteForm.error("mobile") != null)/*138.72*/ {_display_(Seq[Any](format.raw/*138.74*/("""has-error""")))})),format.raw/*138.84*/("""">
			   			<label for=""""),_display_(Seq[Any](/*139.23*/clienteForm("mobile")/*139.44*/.id)),format.raw/*139.47*/("""" class="control-label">Teléfono celular</label>
			   				"""),_display_(Seq[Any](/*140.12*/inputText(clienteForm("mobile"), 'class -> "direccion form-control"))),format.raw/*140.80*/("""
			   				"""),_display_(Seq[Any](/*141.12*/clienteForm("mobile")/*141.33*/.error.map/*141.43*/{ error =>_display_(Seq[Any](format.raw/*141.53*/("""
								<div class="text-error">"""),_display_(Seq[Any](/*142.34*/error/*142.39*/.message)),format.raw/*142.47*/("""</div>
							""")))})),format.raw/*143.9*/("""
					</div>
		  		</div>
		  		
		  		<div class="col-sm-6">
			   		<div class="form-group """),_display_(Seq[Any](/*148.33*/if(clienteForm.error("fax") != null)/*148.69*/ {_display_(Seq[Any](format.raw/*148.71*/("""has-error""")))})),format.raw/*148.81*/("""">
			   			<label for=""""),_display_(Seq[Any](/*149.23*/clienteForm("fax")/*149.41*/.id)),format.raw/*149.44*/("""" class="control-label">Fax</label>
			   				"""),_display_(Seq[Any](/*150.12*/inputText(clienteForm("fax"), 'class -> "direccion form-control"))),format.raw/*150.77*/("""
			   				"""),_display_(Seq[Any](/*151.12*/clienteForm("fax")/*151.30*/.error.map/*151.40*/{ error =>_display_(Seq[Any](format.raw/*151.50*/("""
								<div class="text-error">"""),_display_(Seq[Any](/*152.34*/error/*152.39*/.message)),format.raw/*152.47*/("""</div>
							""")))})),format.raw/*153.9*/("""
					</div>
		  		</div>
  			</div>
  		</div>
  	</div>
</div>
""")))})))}
    }
    
    def render(clienteForm:Form[DireccionCliente],clienteId:Long,clienteExiste:Boolean): play.api.templates.HtmlFormat.Appendable = apply(clienteForm,clienteId,clienteExiste)
    
    def f:((Form[DireccionCliente],Long,Boolean) => play.api.templates.HtmlFormat.Appendable) = (clienteForm,clienteId,clienteExiste) => apply(clienteForm,clienteId,clienteExiste)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:41 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/clientes/formClienteContacto.scala.html
                    HASH: 0d2045207263784a44da58bdcd3a7662ac1147ee
                    MATRIX: 834->1|1015->100|1047->124|1121->79|1150->168|1196->180|1209->186|1329->297|1369->299|1444->339|1470->356|1509->357|1800->617|1849->631|1920->680|2010->734|2041->743|2255->921|2302->959|2343->962|2372->973|2385->978|2424->979|2470->992|2529->1015|2558->1035|2583->1038|2664->1084|2743->1141|2787->1150|2816->1170|2835->1180|2883->1190|2953->1224|2967->1229|2997->1237|3043->1252|3168->1341|3216->1380|3257->1383|3286->1394|3299->1399|3338->1400|3384->1413|3443->1436|3473->1457|3498->1460|3580->1507|3660->1565|3704->1574|3734->1595|3753->1605|3801->1615|3871->1649|3885->1654|3915->1662|3961->1677|4087->1767|4131->1802|4171->1804|4213->1814|4272->1837|4298->1854|4323->1857|4408->1907|4484->1961|4528->1970|4554->1987|4573->1997|4621->2007|4691->2041|4705->2046|4735->2054|4781->2069|4981->2233|5051->2293|5092->2295|5135->2305|5195->2329|5246->2371|5271->2374|5352->2420|5541->2586|5586->2596|5637->2638|5656->2648|5704->2658|5775->2693|5789->2698|5819->2706|5866->2722|6013->2833|6078->2888|6119->2890|6162->2900|6222->2924|6268->2961|6293->2964|6379->3015|6776->3390|6821->3400|6867->3437|6886->3447|6934->3457|7005->3492|7019->3497|7049->3505|7096->3521|7241->3630|7295->3675|7335->3677|7365->3688|7379->3693|7419->3694|7465->3707|7525->3731|7561->3758|7586->3761|7672->3812|8055->4173|8100->4183|8136->4210|8155->4220|8203->4230|8274->4265|8288->4270|8318->4278|8365->4294|8609->4501|8640->4522|8666->4525|8767->4589|8858->4657|8908->4670|8939->4691|8960->4702|9009->4712|9081->4747|9096->4752|9127->4760|9175->4776|9335->4899|9383->4937|9424->4939|9467->4949|9530->4975|9560->4995|9586->4998|9686->5061|9776->5128|9826->5141|9856->5161|9876->5171|9925->5181|9997->5216|10012->5221|10043->5229|10091->5245|10217->5334|10268->5375|10309->5377|10352->5387|10415->5413|10448->5436|10474->5439|10569->5497|10662->5567|10712->5580|10745->5603|10766->5614|10815->5624|10887->5659|10902->5664|10933->5672|10981->5688|11153->5823|11202->5862|11243->5864|11286->5874|11349->5900|11380->5921|11406->5924|11504->5985|11595->6053|11645->6066|11676->6087|11696->6097|11745->6107|11817->6142|11832->6147|11863->6155|11911->6171|12047->6270|12093->6306|12134->6308|12177->6318|12240->6344|12268->6362|12294->6365|12379->6413|12467->6478|12517->6491|12545->6509|12565->6519|12614->6529|12686->6564|12701->6569|12732->6577|12780->6593
                    LINES: 26->1|29->3|29->3|30->1|31->3|36->8|36->8|36->8|36->8|39->11|39->11|39->11|42->14|45->17|45->17|46->18|46->18|52->24|52->24|52->24|52->24|52->24|52->24|52->24|53->25|53->25|53->25|54->26|54->26|55->27|55->27|55->27|55->27|56->28|56->28|56->28|57->29|62->34|62->34|62->34|62->34|62->34|62->34|62->34|63->35|63->35|63->35|64->36|64->36|65->37|65->37|65->37|65->37|66->38|66->38|66->38|67->39|72->44|72->44|72->44|72->44|73->45|73->45|73->45|74->46|74->46|75->47|75->47|75->47|75->47|76->48|76->48|76->48|77->49|85->57|85->57|85->57|85->57|86->58|86->58|86->58|87->59|87->59|88->60|88->60|88->60|88->60|89->61|89->61|89->61|90->62|95->67|95->67|95->67|95->67|96->68|96->68|96->68|97->69|103->75|104->76|104->76|104->76|104->76|105->77|105->77|105->77|106->78|111->83|111->83|111->83|111->83|111->83|111->83|111->83|112->84|112->84|112->84|113->85|119->91|120->92|120->92|120->92|120->92|121->93|121->93|121->93|122->94|134->106|134->106|134->106|135->107|135->107|136->108|136->108|136->108|136->108|137->109|137->109|137->109|138->110|145->117|145->117|145->117|145->117|146->118|146->118|146->118|147->119|147->119|148->120|148->120|148->120|148->120|149->121|149->121|149->121|150->122|154->126|154->126|154->126|154->126|155->127|155->127|155->127|156->128|156->128|157->129|157->129|157->129|157->129|158->130|158->130|158->130|159->131|166->138|166->138|166->138|166->138|167->139|167->139|167->139|168->140|168->140|169->141|169->141|169->141|169->141|170->142|170->142|170->142|171->143|176->148|176->148|176->148|176->148|177->149|177->149|177->149|178->150|178->150|179->151|179->151|179->151|179->151|180->152|180->152|180->152|181->153
                    -- GENERATED --
                */
            