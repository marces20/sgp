
package views.html.compras.proveedores

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
object formProvDirecciones extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Form[DireccionProveedor],Long,Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(provForm: Form[DireccionProveedor], proveedorId: Long, proveedorExiste: Boolean = true):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.90*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.compras.routes.ProveedoresController.actualizarContacto(), 'id -> "formularioContacto")/*5.122*/ {_display_(Seq[Any](format.raw/*5.124*/("""
"""),_display_(Seq[Any](/*6.2*/views/*6.7*/.html.tags.successError())),format.raw/*6.32*/("""
<div id="formularioContacto">

<p>
	"""),_display_(Seq[Any](/*10.3*/if(proveedorExiste)/*10.22*/{_display_(Seq[Any](format.raw/*10.23*/("""
		<a class="btn btn-xs btn-default" id="guardarContacto" href="#"><i class="glyphicon glyphicon-floppy-saved"></i> Guardar</a>
		<a class="btn btn-xs btn-default" id="cancelarEdicion" href="#"><i class="glyphicon glyphicon-remove-sign"></i> Cancelar</a>
	""")))})),format.raw/*13.3*/("""
</p>

  	"""),_display_(Seq[Any](/*16.5*/inputText(provForm("id"), 'hidden -> "hidden"))),format.raw/*16.51*/("""
  	<input type="hidden" name="proveedor_id" value=""""),_display_(Seq[Any](/*17.53*/proveedorId)),format.raw/*17.64*/("""" />
  	
  	<div class="row">
  		<div class="col-sm-5">
	   		<div class="form-group """),_display_(Seq[Any](/*21.31*/if(provForm.error("nombre") != null)/*21.67*/  {_display_(Seq[Any](format.raw/*21.70*/("""has-error""")))}/*21.81*/else/*21.86*/{_display_(Seq[Any](format.raw/*21.87*/("""has-required""")))})),format.raw/*21.100*/("""">
	   			<label for=""""),_display_(Seq[Any](/*22.21*/provForm("nombre")/*22.39*/.id)),format.raw/*22.42*/("""" class="control-label">Nombre del contacto</label>
	   				"""),_display_(Seq[Any](/*23.10*/inputText(provForm("nombre"), 'class -> "direccion form-control"))),format.raw/*23.75*/("""
	   				"""),_display_(Seq[Any](/*24.10*/provForm("nombre")/*24.28*/.error.map/*24.38*/{ error =>_display_(Seq[Any](format.raw/*24.48*/("""
						<div class="text-error">"""),_display_(Seq[Any](/*25.32*/error/*25.37*/.message)),format.raw/*25.45*/("""</div>
					""")))})),format.raw/*26.7*/("""
			</div>
		</div>
  	</div>
  	
  	
  	<div class="row">
  		<div class="col-sm-6">
  			<legend>Dirección postal</legend>
  				<div class="row">
				<div class="col-sm-6">
					<div class="form-group """),_display_(Seq[Any](/*37.30*/if(provForm.error("calle") != null)/*37.65*/  {_display_(Seq[Any](format.raw/*37.68*/("""has-error""")))}/*37.79*/else/*37.84*/{_display_(Seq[Any](format.raw/*37.85*/("""has-required""")))})),format.raw/*37.98*/("""">
						<label for=""""),_display_(Seq[Any](/*38.20*/provForm("calle")/*38.37*/.id)),format.raw/*38.40*/("""" class="control-label">Calle</label>
						"""),_display_(Seq[Any](/*39.8*/inputText(provForm("calle"), 'class -> "form-control"))),format.raw/*39.62*/("""
						"""),_display_(Seq[Any](/*40.8*/provForm("calle")/*40.25*/.error.map/*40.35*/{ error =>_display_(Seq[Any](format.raw/*40.45*/("""
							<div class="text-error">"""),_display_(Seq[Any](/*41.33*/error/*41.38*/.message)),format.raw/*41.46*/("""</div>
						""")))})),format.raw/*42.8*/("""
					</div>
				</div>
			
				<div class="col-sm-3">
					<div class="form-group """),_display_(Seq[Any](/*47.30*/if(provForm.error("numero") != null)/*47.66*/  {_display_(Seq[Any](format.raw/*47.69*/("""has-error""")))}/*47.80*/else/*47.85*/{_display_(Seq[Any](format.raw/*47.86*/("""has-required""")))})),format.raw/*47.99*/("""">
						<label for="provForm("numero").id" class="control-label">Número</label>
						"""),_display_(Seq[Any](/*49.8*/inputText(provForm("numero"), 'class -> "form-control"))),format.raw/*49.63*/("""
						"""),_display_(Seq[Any](/*50.8*/provForm("numero")/*50.26*/.error.map/*50.36*/{ error =>_display_(Seq[Any](format.raw/*50.46*/("""
							<div class="text-error">"""),_display_(Seq[Any](/*51.33*/error/*51.38*/.message)),format.raw/*51.46*/("""</div>
						""")))})),format.raw/*52.8*/("""
					</div>
				</div>
				
				<div class="col-sm-3">
					<div class="form-group """),_display_(Seq[Any](/*57.30*/if(provForm.error("zip") != null)/*57.63*/ {_display_(Seq[Any](format.raw/*57.65*/("""has-error""")))})),format.raw/*57.75*/("""">
						<label for=""""),_display_(Seq[Any](/*58.20*/provForm("zip")/*58.35*/.id)),format.raw/*58.38*/("""" class="control-label">C. Postal</label>
						"""),_display_(Seq[Any](/*59.8*/inputText(provForm("zip"), 'class -> "form-control"))),format.raw/*59.60*/("""
						"""),_display_(Seq[Any](/*60.8*/provForm("zip")/*60.23*/.error.map/*60.33*/{ error =>_display_(Seq[Any](format.raw/*60.43*/("""
							<div class="text-error">"""),_display_(Seq[Any](/*61.33*/error/*61.38*/.message)),format.raw/*61.46*/("""</div>
						""")))})),format.raw/*62.8*/("""
					</div>
				</div>
				
 				</div>

				<div class="row contenedorUbicacion">
					<div class="col-sm-4">
						<div class="seleccionPais form-group """),_display_(Seq[Any](/*70.45*/if(provForm.error("localidad.provincia.pais.id") != null)/*70.102*/ {_display_(Seq[Any](format.raw/*70.104*/("""has-error""")))})),format.raw/*70.114*/("""">
							<label for=""""),_display_(Seq[Any](/*71.21*/provForm("localidad.provincia.pais.id")/*71.60*/.id)),format.raw/*71.63*/("""" class="control-label">País</label>
							"""),_display_(Seq[Any](/*72.9*/select(provForm("localidad.provincia.pais.id"), Pais.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*72.172*/("""
							"""),_display_(Seq[Any](/*73.9*/provForm("localidad.provincia.pais.id")/*73.48*/.error.map/*73.58*/{ error =>_display_(Seq[Any](format.raw/*73.68*/("""
								<div class="text-error">"""),_display_(Seq[Any](/*74.34*/error/*74.39*/.message)),format.raw/*74.47*/("""</div>
							""")))})),format.raw/*75.9*/("""
						</div>
					</div>
		
					<div class="col-sm-4">
						<div class="seleccionProvincia form-group """),_display_(Seq[Any](/*80.50*/if(provForm.error("localidad.provincia.id") != null)/*80.102*/ {_display_(Seq[Any](format.raw/*80.104*/("""has-error""")))})),format.raw/*80.114*/("""">
							<label for=""""),_display_(Seq[Any](/*81.21*/provForm("provincia.id")/*81.45*/.id)),format.raw/*81.48*/("""" class="control-label">Provincia</label>
							"""),_display_(Seq[Any](/*82.9*/select(provForm("localidad.provincia.id"), 
								provForm("localidad.provincia.pais.id").value match {
									case null => {options()}
									case v if v.matches("\\d+") => {Provincia.getProvincias(v.toInt).map { p => p.id.toString -> p.nombre}}
									case _ => {options()}
								}, 
							'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*88.68*/("""
							"""),_display_(Seq[Any](/*89.9*/provForm("localidad.provincia.id")/*89.43*/.error.map/*89.53*/{ error =>_display_(Seq[Any](format.raw/*89.63*/("""
								<div class="text-error">"""),_display_(Seq[Any](/*90.34*/error/*90.39*/.message)),format.raw/*90.47*/("""</div>
							""")))})),format.raw/*91.9*/("""
						</div>
					</div>

					<div class="col-sm-4">
						<div class="seleccionLocalidad form-group """),_display_(Seq[Any](/*96.50*/if(provForm.error("localidad_id") != null)/*96.92*/ {_display_(Seq[Any](format.raw/*96.94*/("""has-error""")))}/*96.105*/else/*96.110*/{_display_(Seq[Any](format.raw/*96.111*/("""has-required""")))})),format.raw/*96.124*/("""">
							<label for=""""),_display_(Seq[Any](/*97.21*/provForm("localidad_id")/*97.45*/.id)),format.raw/*97.48*/("""" class="control-label">Localidad</label>
							"""),_display_(Seq[Any](/*98.9*/select(provForm("localidad_id"), 
								provForm("localidad.provincia.id").value match {
									case null => {options()}
									case v if v.matches("\\d+") => {Localidad.getLocalidades(v.toInt).map { p => p.id.toString -> p.nombre}}
									case _ => {options()}
								}, 
							'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*104.68*/("""
							"""),_display_(Seq[Any](/*105.9*/provForm("localidad_id")/*105.33*/.error.map/*105.43*/{ error =>_display_(Seq[Any](format.raw/*105.53*/("""
								<div class="text-error">"""),_display_(Seq[Any](/*106.34*/error/*106.39*/.message)),format.raw/*106.47*/("""</div>
							""")))})),format.raw/*107.9*/("""
						</div>
					</div>
				</div>

  		</div>
  		
  		<div class="col-sm-6">
  			<legend>Comunicación</legend>
  			
  			<div class="row">
				<div class="col-sm-12">
			   		<div class="form-group """),_display_(Seq[Any](/*119.33*/if(provForm.error("email") != null)/*119.68*/ {_display_(Seq[Any](format.raw/*119.70*/("""has-error""")))})),format.raw/*119.80*/("""">
			   			<label for=""""),_display_(Seq[Any](/*120.23*/provForm("email")/*120.40*/.id)),format.raw/*120.43*/("""" class="control-label">Correo electrónico</label>
			   				"""),_display_(Seq[Any](/*121.12*/inputText(provForm("email"), 'class -> "direccion form-control"))),format.raw/*121.76*/("""
			   				"""),_display_(Seq[Any](/*122.12*/provForm("email")/*122.29*/.error.map/*122.39*/{ error =>_display_(Seq[Any](format.raw/*122.49*/("""
								<div class="text-error">"""),_display_(Seq[Any](/*123.34*/error/*123.39*/.message)),format.raw/*123.47*/("""</div>
							""")))})),format.raw/*124.9*/("""
					</div>
		  		</div>
  			</div>
  			
  			<div class="row">
					<div class="col-sm-4">
				   		<div class="form-group """),_display_(Seq[Any](/*131.34*/if(provForm.error("telefono") != null)/*131.72*/ {_display_(Seq[Any](format.raw/*131.74*/("""has-error""")))})),format.raw/*131.84*/("""">
				   			<label for=""""),_display_(Seq[Any](/*132.24*/provForm("telefono")/*132.44*/.id)),format.raw/*132.47*/("""" class="control-label">Teléfono fijo</label>
				   				"""),_display_(Seq[Any](/*133.13*/inputText(provForm("telefono"), 'class -> "direccion form-control"))),format.raw/*133.80*/("""
				   				"""),_display_(Seq[Any](/*134.13*/provForm("telefono")/*134.33*/.errors.map/*134.44*/{ error =>_display_(Seq[Any](format.raw/*134.54*/("""
									<div class="text-error">"""),_display_(Seq[Any](/*135.35*/error/*135.40*/.message)),format.raw/*135.48*/("""</div>
								""")))})),format.raw/*136.10*/("""
						</div>
			  		</div>
			  		
			  		<div class="col-sm-4">
				   		<div class="form-group """),_display_(Seq[Any](/*141.34*/if(provForm.error("mobile") != null)/*141.70*/ {_display_(Seq[Any](format.raw/*141.72*/("""has-error""")))})),format.raw/*141.82*/("""">
				   			<label for=""""),_display_(Seq[Any](/*142.24*/provForm("mobile")/*142.42*/.id)),format.raw/*142.45*/("""" class="control-label">Teléfono celular</label>
				   				"""),_display_(Seq[Any](/*143.13*/inputText(provForm("mobile"), 'class -> "direccion form-control"))),format.raw/*143.78*/("""
				   				"""),_display_(Seq[Any](/*144.13*/provForm("mobile")/*144.31*/.error.map/*144.41*/{ error =>_display_(Seq[Any](format.raw/*144.51*/("""
									<div class="text-error">"""),_display_(Seq[Any](/*145.35*/error/*145.40*/.message)),format.raw/*145.48*/("""</div>
								""")))})),format.raw/*146.10*/("""
						</div>
			  		</div>
			  		
			  		<div class="col-sm-4">
				   		<div class="form-group """),_display_(Seq[Any](/*151.34*/if(provForm.error("fax") != null)/*151.67*/ {_display_(Seq[Any](format.raw/*151.69*/("""has-error""")))})),format.raw/*151.79*/("""">
				   			<label for=""""),_display_(Seq[Any](/*152.24*/provForm("fax")/*152.39*/.id)),format.raw/*152.42*/("""" class="control-label">Fax</label>
				   				"""),_display_(Seq[Any](/*153.13*/inputText(provForm("fax"), 'class -> "direccion form-control"))),format.raw/*153.75*/("""
				   				"""),_display_(Seq[Any](/*154.13*/provForm("fax")/*154.28*/.error.map/*154.38*/{ error =>_display_(Seq[Any](format.raw/*154.48*/("""
									<div class="text-error">"""),_display_(Seq[Any](/*155.35*/error/*155.40*/.message)),format.raw/*155.48*/("""</div>
								""")))})),format.raw/*156.10*/("""
						</div>
			  		</div>
  			</div>

  		</div>
  	</div>
</div>
""")))})),format.raw/*164.2*/("""
"""),_display_(Seq[Any](/*165.2*/flash()/*165.9*/.clear())))}
    }
    
    def render(provForm:Form[DireccionProveedor],proveedorId:Long,proveedorExiste:Boolean): play.api.templates.HtmlFormat.Appendable = apply(provForm,proveedorId,proveedorExiste)
    
    def f:((Form[DireccionProveedor],Long,Boolean) => play.api.templates.HtmlFormat.Appendable) = (provForm,proveedorId,proveedorExiste) => apply(provForm,proveedorId,proveedorExiste)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:46 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/proveedores/formProvDirecciones.scala.html
                    HASH: c00bd902ac1d3c015bfe156d35593e6f3233bbec
                    MATRIX: 839->1|1030->110|1062->134|1136->89|1165->178|1205->184|1218->190|1341->304|1381->306|1418->309|1430->314|1476->339|1553->381|1581->400|1620->401|1911->661|1960->675|2028->721|2118->775|2151->786|2278->877|2323->913|2364->916|2393->927|2406->932|2445->933|2491->946|2551->970|2578->988|2603->991|2701->1053|2788->1118|2835->1129|2862->1147|2881->1157|2929->1167|2998->1200|3012->1205|3042->1213|3087->1227|3339->1443|3383->1478|3424->1481|3453->1492|3466->1497|3505->1498|3550->1511|3609->1534|3635->1551|3660->1554|3741->1600|3817->1654|3861->1663|3887->1680|3906->1690|3954->1700|4024->1734|4038->1739|4068->1747|4114->1762|4239->1851|4284->1887|4325->1890|4354->1901|4367->1906|4406->1907|4451->1920|4576->2010|4653->2065|4697->2074|4724->2092|4743->2102|4791->2112|4861->2146|4875->2151|4905->2159|4951->2174|5077->2264|5119->2297|5159->2299|5201->2309|5260->2332|5284->2347|5309->2350|5394->2400|5468->2452|5512->2461|5536->2476|5555->2486|5603->2496|5673->2530|5687->2535|5717->2543|5763->2558|5963->2722|6030->2779|6071->2781|6114->2791|6174->2815|6222->2854|6247->2857|6328->2903|6514->3066|6559->3076|6607->3115|6626->3125|6674->3135|6745->3170|6759->3175|6789->3183|6836->3199|6983->3310|7045->3362|7086->3364|7129->3374|7189->3398|7222->3422|7247->3425|7333->3476|7724->3845|7769->3855|7812->3889|7831->3899|7879->3909|7950->3944|7964->3949|7994->3957|8041->3973|8186->4082|8237->4124|8277->4126|8307->4137|8321->4142|8361->4143|8407->4156|8467->4180|8500->4204|8525->4207|8611->4258|8989->4613|9035->4623|9069->4647|9089->4657|9138->4667|9210->4702|9225->4707|9256->4715|9304->4731|9558->4948|9603->4983|9644->4985|9687->4995|9750->5021|9777->5038|9803->5041|9903->5104|9990->5168|10040->5181|10067->5198|10087->5208|10136->5218|10208->5253|10223->5258|10254->5266|10302->5282|10474->5417|10522->5455|10563->5457|10606->5467|10670->5494|10700->5514|10726->5517|10822->5576|10912->5643|10963->5657|10993->5677|11014->5688|11063->5698|11136->5734|11151->5739|11182->5747|11232->5764|11373->5868|11419->5904|11460->5906|11503->5916|11567->5943|11595->5961|11621->5964|11720->6026|11808->6091|11859->6105|11887->6123|11907->6133|11956->6143|12029->6179|12044->6184|12075->6192|12125->6209|12266->6313|12309->6346|12350->6348|12393->6358|12457->6385|12482->6400|12508->6403|12594->6452|12679->6514|12730->6528|12755->6543|12775->6553|12824->6563|12897->6599|12912->6604|12943->6612|12993->6629|13103->6707|13142->6710|13158->6717
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|34->6|34->6|34->6|38->10|38->10|38->10|41->13|44->16|44->16|45->17|45->17|49->21|49->21|49->21|49->21|49->21|49->21|49->21|50->22|50->22|50->22|51->23|51->23|52->24|52->24|52->24|52->24|53->25|53->25|53->25|54->26|65->37|65->37|65->37|65->37|65->37|65->37|65->37|66->38|66->38|66->38|67->39|67->39|68->40|68->40|68->40|68->40|69->41|69->41|69->41|70->42|75->47|75->47|75->47|75->47|75->47|75->47|75->47|77->49|77->49|78->50|78->50|78->50|78->50|79->51|79->51|79->51|80->52|85->57|85->57|85->57|85->57|86->58|86->58|86->58|87->59|87->59|88->60|88->60|88->60|88->60|89->61|89->61|89->61|90->62|98->70|98->70|98->70|98->70|99->71|99->71|99->71|100->72|100->72|101->73|101->73|101->73|101->73|102->74|102->74|102->74|103->75|108->80|108->80|108->80|108->80|109->81|109->81|109->81|110->82|116->88|117->89|117->89|117->89|117->89|118->90|118->90|118->90|119->91|124->96|124->96|124->96|124->96|124->96|124->96|124->96|125->97|125->97|125->97|126->98|132->104|133->105|133->105|133->105|133->105|134->106|134->106|134->106|135->107|147->119|147->119|147->119|147->119|148->120|148->120|148->120|149->121|149->121|150->122|150->122|150->122|150->122|151->123|151->123|151->123|152->124|159->131|159->131|159->131|159->131|160->132|160->132|160->132|161->133|161->133|162->134|162->134|162->134|162->134|163->135|163->135|163->135|164->136|169->141|169->141|169->141|169->141|170->142|170->142|170->142|171->143|171->143|172->144|172->144|172->144|172->144|173->145|173->145|173->145|174->146|179->151|179->151|179->151|179->151|180->152|180->152|180->152|181->153|181->153|182->154|182->154|182->154|182->154|183->155|183->155|183->155|184->156|192->164|193->165|193->165
                    -- GENERATED --
                */
            