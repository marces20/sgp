
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
object formProvDirecciones2 extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[Proveedor],Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(provForm: Form[Proveedor], proveedorExiste: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.55*/("""
"""),format.raw/*3.70*/(""" 

<div id="formularioContacto">

<p>
	"""),_display_(Seq[Any](/*8.3*/if(proveedorExiste)/*8.22*/{_display_(Seq[Any](format.raw/*8.23*/("""
		<a class="btn btn-xs btn-default" id="cancelarEdicion" href="#"> Cancelar</a>
	""")))})),format.raw/*10.3*/("""
</p>

  	"""),_display_(Seq[Any](/*13.5*/inputText(provForm("direcciones[0].id"), 'hidden -> "hidden"))),format.raw/*13.66*/("""
  	
  	<div class="row">
  		<div class="col-sm-5">
	   		<div class="form-group """),_display_(Seq[Any](/*17.31*/if(provForm.error("direcciones[0].nombre") != null)/*17.82*/  {_display_(Seq[Any](format.raw/*17.85*/("""has-error""")))}/*17.96*/else/*17.101*/{_display_(Seq[Any](format.raw/*17.102*/("""has-required""")))})),format.raw/*17.115*/("""">
	   			<label for=""""),_display_(Seq[Any](/*18.21*/provForm("direcciones[0].nombre")/*18.54*/.id)),format.raw/*18.57*/("""" class="control-label">Nombre del contacto</label>
	   				"""),_display_(Seq[Any](/*19.10*/inputText(provForm("direcciones[0].nombre"), 'class -> "direccion form-control"))),format.raw/*19.90*/("""
	   				"""),_display_(Seq[Any](/*20.10*/provForm("direcciones[0].nombre")/*20.43*/.error.map/*20.53*/{ error =>_display_(Seq[Any](format.raw/*20.63*/("""
						<div class="text-error">"""),_display_(Seq[Any](/*21.32*/error/*21.37*/.message)),format.raw/*21.45*/("""</div>
					""")))})),format.raw/*22.7*/("""
			</div>
		</div>
  	</div>
  	
  	
  	<div class="row">
  		<div class="col-sm-6">
  			<legend>Dirección postal</legend>
  				<div class="row">
				<div class="col-sm-6">
					<div class="form-group """),_display_(Seq[Any](/*33.30*/if(provForm.error("direcciones[0].calle") != null)/*33.80*/  {_display_(Seq[Any](format.raw/*33.83*/("""has-error""")))}/*33.94*/else/*33.99*/{_display_(Seq[Any](format.raw/*33.100*/("""has-required""")))})),format.raw/*33.113*/("""">
						<label for=""""),_display_(Seq[Any](/*34.20*/provForm("direcciones[0].calle")/*34.52*/.id)),format.raw/*34.55*/("""" class="control-label">Calle</label>
						"""),_display_(Seq[Any](/*35.8*/inputText(provForm("direcciones[0].calle"), 'class -> "form-control"))),format.raw/*35.77*/("""
						"""),_display_(Seq[Any](/*36.8*/provForm("direcciones[0].calle")/*36.40*/.error.map/*36.50*/{ error =>_display_(Seq[Any](format.raw/*36.60*/("""
							<div class="text-error">"""),_display_(Seq[Any](/*37.33*/error/*37.38*/.message)),format.raw/*37.46*/("""</div>
						""")))})),format.raw/*38.8*/("""
					</div>
				</div>
			
				<div class="col-sm-3">
					<div class="form-group """),_display_(Seq[Any](/*43.30*/if(provForm.error("direcciones[0].numero") != null)/*43.81*/  {_display_(Seq[Any](format.raw/*43.84*/("""has-error""")))}/*43.95*/else/*43.100*/{_display_(Seq[Any](format.raw/*43.101*/("""has-required""")))})),format.raw/*43.114*/("""">
						<label for="provForm("direcciones[0].numero").id" class="control-label">Número</label>
						"""),_display_(Seq[Any](/*45.8*/inputText(provForm("direcciones[0].numero"), 'class -> "form-control"))),format.raw/*45.78*/("""
						"""),_display_(Seq[Any](/*46.8*/provForm("direcciones[0].numero")/*46.41*/.error.map/*46.51*/{ error =>_display_(Seq[Any](format.raw/*46.61*/("""
							<div class="text-error">"""),_display_(Seq[Any](/*47.33*/error/*47.38*/.message)),format.raw/*47.46*/("""</div>
						""")))})),format.raw/*48.8*/("""
					</div>
				</div>
				
				<div class="col-sm-3">
					<div class="form-group """),_display_(Seq[Any](/*53.30*/if(provForm.error("direcciones[0].zip") != null)/*53.78*/ {_display_(Seq[Any](format.raw/*53.80*/("""has-error""")))})),format.raw/*53.90*/("""">
						<label for=""""),_display_(Seq[Any](/*54.20*/provForm("direcciones[0].zip")/*54.50*/.id)),format.raw/*54.53*/("""" class="control-label">C. Postal</label>
						"""),_display_(Seq[Any](/*55.8*/inputText(provForm("direcciones[0].zip"), 'class -> "form-control"))),format.raw/*55.75*/("""
						"""),_display_(Seq[Any](/*56.8*/provForm("direcciones[0].zip")/*56.38*/.error.map/*56.48*/{ error =>_display_(Seq[Any](format.raw/*56.58*/("""
							<div class="text-error">"""),_display_(Seq[Any](/*57.33*/error/*57.38*/.message)),format.raw/*57.46*/("""</div>
						""")))})),format.raw/*58.8*/("""
					</div>
				</div>
				
 				</div>

				<div class="row contenedorUbicacion">
					<div class="col-sm-4">
						<div class="seleccionPais form-group """),_display_(Seq[Any](/*66.45*/if(provForm.error("direcciones[0].localidad.provincia.pais.id") != null)/*66.117*/ {_display_(Seq[Any](format.raw/*66.119*/("""has-error""")))})),format.raw/*66.129*/("""">
							<label for=""""),_display_(Seq[Any](/*67.21*/provForm("direcciones[0].localidad.provincia.pais.id")/*67.75*/.id)),format.raw/*67.78*/("""" class="control-label">País</label>
							"""),_display_(Seq[Any](/*68.9*/select(provForm("direcciones[0].localidad.provincia.pais.id"), Pais.find.all().map { p => p.id.toString -> p.nombre}, 'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*68.187*/("""
							"""),_display_(Seq[Any](/*69.9*/provForm("direcciones[0].localidad.provincia.pais.id")/*69.63*/.error.map/*69.73*/{ error =>_display_(Seq[Any](format.raw/*69.83*/("""
								<div class="text-error">"""),_display_(Seq[Any](/*70.34*/error/*70.39*/.message)),format.raw/*70.47*/("""</div>
							""")))})),format.raw/*71.9*/("""
						</div>
					</div>
		
					<div class="col-sm-4">
						<div class="seleccionProvincia form-group """),_display_(Seq[Any](/*76.50*/if(provForm.error("direcciones[0].localidad.provincia.id") != null)/*76.117*/ {_display_(Seq[Any](format.raw/*76.119*/("""has-error""")))})),format.raw/*76.129*/("""">
							<label for=""""),_display_(Seq[Any](/*77.21*/provForm("direcciones[0].localidad.provincia.id")/*77.70*/.id)),format.raw/*77.73*/("""" class="control-label">Provincia</label>
							"""),_display_(Seq[Any](/*78.9*/select(provForm("direcciones[0].localidad.provincia.id"), 
								provForm("direcciones[0].localidad.provincia.pais.id").value match {
									case null => {options()}
									case v if v.matches("\\d+") => {Provincia.getProvincias(v.toInt).map { p => p.id.toString -> p.nombre}}
									case _ => {options()}
								}, 
							'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*84.68*/("""
							"""),_display_(Seq[Any](/*85.9*/provForm("direcciones[0].localidad.provincia.id")/*85.58*/.error.map/*85.68*/{ error =>_display_(Seq[Any](format.raw/*85.78*/("""
								<div class="text-error">"""),_display_(Seq[Any](/*86.34*/error/*86.39*/.message)),format.raw/*86.47*/("""</div>
							""")))})),format.raw/*87.9*/("""
						</div>
					</div>

					<div class="col-sm-4">
						<div class="seleccionLocalidad form-group """),_display_(Seq[Any](/*92.50*/if(provForm.error("direcciones[0].localidad.id") != null)/*92.107*/ {_display_(Seq[Any](format.raw/*92.109*/("""has-error""")))}/*92.120*/else/*92.125*/{_display_(Seq[Any](format.raw/*92.126*/("""has-required""")))})),format.raw/*92.139*/("""">
							<label for=""""),_display_(Seq[Any](/*93.21*/provForm("direcciones[0].localidad.id")/*93.60*/.id)),format.raw/*93.63*/("""" class="control-label">Localidad</label>
							"""),_display_(Seq[Any](/*94.9*/select(provForm("direcciones[0].localidad.id"), 
								provForm("direcciones[0].localidad.provincia.id").value match {
									case null => {options()}
									case v if v.matches("\\d+") => {Localidad.getLocalidades(v.toInt).map { p => p.id.toString -> p.nombre}}
									case _ => {options()}
								}, 
							'class -> "form-control select", '_default -> "Seleccionar"))),format.raw/*100.68*/("""
							"""),_display_(Seq[Any](/*101.9*/provForm("direcciones[0].localidad.id")/*101.48*/.error.map/*101.58*/{ error =>_display_(Seq[Any](format.raw/*101.68*/("""
								<div class="text-error">"""),_display_(Seq[Any](/*102.34*/error/*102.39*/.message)),format.raw/*102.47*/("""</div>
							""")))})),format.raw/*103.9*/("""
						</div>
					</div>
				</div>

  		</div>
  		
  		<div class="col-sm-6">
  			<legend>Comunicación</legend>
  			
  			<div class="row">
				<div class="col-sm-12">
			   		<div class="form-group """),_display_(Seq[Any](/*115.33*/if(provForm.error("direcciones[0].email") != null)/*115.83*/ {_display_(Seq[Any](format.raw/*115.85*/("""has-error""")))})),format.raw/*115.95*/("""">
			   			<label for=""""),_display_(Seq[Any](/*116.23*/provForm("direcciones[0].email")/*116.55*/.id)),format.raw/*116.58*/("""" class="control-label">Correo electrónico</label>
			   				"""),_display_(Seq[Any](/*117.12*/inputText(provForm("direcciones[0].email"), 'class -> "direccion form-control"))),format.raw/*117.91*/("""
			   				"""),_display_(Seq[Any](/*118.12*/provForm("direcciones[0].email")/*118.44*/.error.map/*118.54*/{ error =>_display_(Seq[Any](format.raw/*118.64*/("""
								<div class="text-error">"""),_display_(Seq[Any](/*119.34*/error/*119.39*/.message)),format.raw/*119.47*/("""</div>
							""")))})),format.raw/*120.9*/("""
					</div>
		  		</div>
  			</div>
  			
  			<div class="row">
					<div class="col-sm-4">
				   		<div class="form-group """),_display_(Seq[Any](/*127.34*/if(provForm.error("direcciones[0].telefono") != null)/*127.87*/ {_display_(Seq[Any](format.raw/*127.89*/("""has-error""")))})),format.raw/*127.99*/("""">
				   			<label for=""""),_display_(Seq[Any](/*128.24*/provForm("direcciones[0].telefono")/*128.59*/.id)),format.raw/*128.62*/("""" class="control-label">Teléfono fijo</label>
				   				"""),_display_(Seq[Any](/*129.13*/inputText(provForm("direcciones[0].telefono"), 'class -> "direccion form-control"))),format.raw/*129.95*/("""
				   				"""),_display_(Seq[Any](/*130.13*/provForm("direcciones[0].telefono")/*130.48*/.errors.map/*130.59*/{ error =>_display_(Seq[Any](format.raw/*130.69*/("""
									<div class="text-error">"""),_display_(Seq[Any](/*131.35*/error/*131.40*/.message)),format.raw/*131.48*/("""</div>
								""")))})),format.raw/*132.10*/("""
						</div>
			  		</div>
			  		
			  		<div class="col-sm-4">
				   		<div class="form-group """),_display_(Seq[Any](/*137.34*/if(provForm.error("direcciones[0].mobile") != null)/*137.85*/ {_display_(Seq[Any](format.raw/*137.87*/("""has-error""")))})),format.raw/*137.97*/("""">
				   			<label for=""""),_display_(Seq[Any](/*138.24*/provForm("direcciones[0].mobile")/*138.57*/.id)),format.raw/*138.60*/("""" class="control-label">Teléfono celular</label>
				   				"""),_display_(Seq[Any](/*139.13*/inputText(provForm("direcciones[0].mobile"), 'class -> "direccion form-control"))),format.raw/*139.93*/("""
				   				"""),_display_(Seq[Any](/*140.13*/provForm("direcciones[0].mobile")/*140.46*/.error.map/*140.56*/{ error =>_display_(Seq[Any](format.raw/*140.66*/("""
									<div class="text-error">"""),_display_(Seq[Any](/*141.35*/error/*141.40*/.message)),format.raw/*141.48*/("""</div>
								""")))})),format.raw/*142.10*/("""
						</div>
			  		</div>
			  		
			  		<div class="col-sm-4">
				   		<div class="form-group """),_display_(Seq[Any](/*147.34*/if(provForm.error("direcciones[0].fax") != null)/*147.82*/ {_display_(Seq[Any](format.raw/*147.84*/("""has-error""")))})),format.raw/*147.94*/("""">
				   			<label for=""""),_display_(Seq[Any](/*148.24*/provForm("direcciones[0].fax")/*148.54*/.id)),format.raw/*148.57*/("""" class="control-label">Fax</label>
				   				"""),_display_(Seq[Any](/*149.13*/inputText(provForm("direcciones[0].fax"), 'class -> "direccion form-control"))),format.raw/*149.90*/("""
				   				"""),_display_(Seq[Any](/*150.13*/provForm("direcciones[0].fax")/*150.43*/.error.map/*150.53*/{ error =>_display_(Seq[Any](format.raw/*150.63*/("""
									<div class="text-error">"""),_display_(Seq[Any](/*151.35*/error/*151.40*/.message)),format.raw/*151.48*/("""</div>
								""")))})),format.raw/*152.10*/("""
						</div>
			  		</div>
  			</div>

  		</div>
  	</div>
</div>"""))}
    }
    
    def render(provForm:Form[Proveedor],proveedorExiste:Boolean): play.api.templates.HtmlFormat.Appendable = apply(provForm,proveedorExiste)
    
    def f:((Form[Proveedor],Boolean) => play.api.templates.HtmlFormat.Appendable) = (provForm,proveedorExiste) => apply(provForm,proveedorExiste)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:46 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/proveedores/formProvDirecciones2.scala.html
                    HASH: a861bb78c7658c3b63f314333a0f50fd6ee1dd65
                    MATRIX: 826->1|982->75|1014->99|1088->54|1117->143|1196->188|1223->207|1261->208|1377->293|1426->307|1509->368|1632->455|1692->506|1733->509|1762->520|1776->525|1816->526|1862->539|1922->563|1964->596|1989->599|2087->661|2189->741|2236->752|2278->785|2297->795|2345->805|2414->838|2428->843|2458->851|2503->865|2755->1081|2814->1131|2855->1134|2884->1145|2897->1150|2937->1151|2983->1164|3042->1187|3083->1219|3108->1222|3189->1268|3280->1337|3324->1346|3365->1378|3384->1388|3432->1398|3502->1432|3516->1437|3546->1445|3592->1460|3717->1549|3777->1600|3818->1603|3847->1614|3861->1619|3901->1620|3947->1633|4087->1738|4179->1808|4223->1817|4265->1850|4284->1860|4332->1870|4402->1904|4416->1909|4446->1917|4492->1932|4618->2022|4675->2070|4715->2072|4757->2082|4816->2105|4855->2135|4880->2138|4965->2188|5054->2255|5098->2264|5137->2294|5156->2304|5204->2314|5274->2348|5288->2353|5318->2361|5364->2376|5564->2540|5646->2612|5687->2614|5730->2624|5790->2648|5853->2702|5878->2705|5959->2751|6160->2929|6205->2939|6268->2993|6287->3003|6335->3013|6406->3048|6420->3053|6450->3061|6497->3077|6644->3188|6721->3255|6762->3257|6805->3267|6865->3291|6923->3340|6948->3343|7034->3394|7455->3793|7500->3803|7558->3852|7577->3862|7625->3872|7696->3907|7710->3912|7740->3920|7787->3936|7932->4045|7999->4102|8040->4104|8070->4115|8084->4120|8124->4121|8170->4134|8230->4158|8278->4197|8303->4200|8389->4251|8797->4636|8843->4646|8892->4685|8912->4695|8961->4705|9033->4740|9048->4745|9079->4753|9127->4769|9381->4986|9441->5036|9482->5038|9525->5048|9588->5074|9630->5106|9656->5109|9756->5172|9858->5251|9908->5264|9950->5296|9970->5306|10019->5316|10091->5351|10106->5356|10137->5364|10185->5380|10357->5515|10420->5568|10461->5570|10504->5580|10568->5607|10613->5642|10639->5645|10735->5704|10840->5786|10891->5800|10936->5835|10957->5846|11006->5856|11079->5892|11094->5897|11125->5905|11175->5922|11316->6026|11377->6077|11418->6079|11461->6089|11525->6116|11568->6149|11594->6152|11693->6214|11796->6294|11847->6308|11890->6341|11910->6351|11959->6361|12032->6397|12047->6402|12078->6410|12128->6427|12269->6531|12327->6579|12368->6581|12411->6591|12475->6618|12515->6648|12541->6651|12627->6700|12727->6777|12778->6791|12818->6821|12838->6831|12887->6841|12960->6877|12975->6882|13006->6890|13056->6907
                    LINES: 26->1|29->3|29->3|30->1|31->3|36->8|36->8|36->8|38->10|41->13|41->13|45->17|45->17|45->17|45->17|45->17|45->17|45->17|46->18|46->18|46->18|47->19|47->19|48->20|48->20|48->20|48->20|49->21|49->21|49->21|50->22|61->33|61->33|61->33|61->33|61->33|61->33|61->33|62->34|62->34|62->34|63->35|63->35|64->36|64->36|64->36|64->36|65->37|65->37|65->37|66->38|71->43|71->43|71->43|71->43|71->43|71->43|71->43|73->45|73->45|74->46|74->46|74->46|74->46|75->47|75->47|75->47|76->48|81->53|81->53|81->53|81->53|82->54|82->54|82->54|83->55|83->55|84->56|84->56|84->56|84->56|85->57|85->57|85->57|86->58|94->66|94->66|94->66|94->66|95->67|95->67|95->67|96->68|96->68|97->69|97->69|97->69|97->69|98->70|98->70|98->70|99->71|104->76|104->76|104->76|104->76|105->77|105->77|105->77|106->78|112->84|113->85|113->85|113->85|113->85|114->86|114->86|114->86|115->87|120->92|120->92|120->92|120->92|120->92|120->92|120->92|121->93|121->93|121->93|122->94|128->100|129->101|129->101|129->101|129->101|130->102|130->102|130->102|131->103|143->115|143->115|143->115|143->115|144->116|144->116|144->116|145->117|145->117|146->118|146->118|146->118|146->118|147->119|147->119|147->119|148->120|155->127|155->127|155->127|155->127|156->128|156->128|156->128|157->129|157->129|158->130|158->130|158->130|158->130|159->131|159->131|159->131|160->132|165->137|165->137|165->137|165->137|166->138|166->138|166->138|167->139|167->139|168->140|168->140|168->140|168->140|169->141|169->141|169->141|170->142|175->147|175->147|175->147|175->147|176->148|176->148|176->148|177->149|177->149|178->150|178->150|178->150|178->150|179->151|179->151|179->151|180->152
                    -- GENERATED --
                */
            