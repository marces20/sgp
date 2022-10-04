
package views.html.delegacion.depositos

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
object formDeposito extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Deposito],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(depositoForm: Form[Deposito]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.32*/("""
"""),format.raw/*3.70*/(""" 

	<div class="row menu-acciones">
		<div class="col-sm-10">
			<button type="submit" class="btn btn-default" title="Guardar solicitud"><i class="glyphicon glyphicon-floppy-disk"></i> Guardar</button>	
	    	<a href=""""),_display_(Seq[Any](/*8.17*/if(request().getHeader("referer"))/*8.51*/{_display_(Seq[Any](format.raw/*8.52*/(""" """),_display_(Seq[Any](/*8.54*/request()/*8.63*/.getHeader("referer"))),format.raw/*8.84*/(""" """)))}/*8.87*/else/*8.92*/{_display_(Seq[Any](_display_(Seq[Any](/*8.94*/controllers/*8.105*/.delegacion.routes.DepositosController.index()))))})),format.raw/*8.152*/("""" title="Cancelar editar" class="btn btn-default"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
	    </div>
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*11.14*/controllers/*11.25*/.delegacion.routes.DepositosController.index())),format.raw/*11.71*/("""" title="Volver al listado" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
		</div>
	</div>


	<div class="row">
		<div class="col-sm-4">
			<div class="form-group """),_display_(Seq[Any](/*18.28*/if(depositoForm.error("nombre") != null)/*18.68*/ {_display_(Seq[Any](format.raw/*18.70*/("""has-error""")))}/*18.80*/else/*18.84*/{_display_(Seq[Any](format.raw/*18.85*/("""has-required""")))})),format.raw/*18.98*/("""">
				<label for="inputNombre" class="control-label">Nombre</label> 
				"""),_display_(Seq[Any](/*20.6*/inputText(depositoForm("nombre"), 'class -> "form-control"))),format.raw/*20.65*/("""
				"""),_display_(Seq[Any](/*21.6*/depositoForm("nombre")/*21.28*/.error.map/*21.38*/{ error =>_display_(Seq[Any](format.raw/*21.48*/("""
					<div class="text-error">"""),_display_(Seq[Any](/*22.31*/error/*22.36*/.message)),format.raw/*22.44*/("""</div>
				""")))})),format.raw/*23.6*/("""
			</div>
		</div>
	</div>"""))}
    }
    
    def render(depositoForm:Form[Deposito]): play.api.templates.HtmlFormat.Appendable = apply(depositoForm)
    
    def f:((Form[Deposito]) => play.api.templates.HtmlFormat.Appendable) = (depositoForm) => apply(depositoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:29 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/delegacion/depositos/formDeposito.scala.html
                    HASH: b39a08cf5ec5a2b420ba8cb2df31cd7e7e333424
                    MATRIX: 810->1|942->50|974->74|1048->31|1076->118|1330->337|1372->371|1410->372|1447->374|1464->383|1506->404|1526->407|1538->412|1585->414|1605->425|1678->472|1877->635|1897->646|1965->692|2189->880|2238->920|2278->922|2307->932|2320->936|2359->937|2404->950|2514->1025|2595->1084|2636->1090|2667->1112|2686->1122|2734->1132|2801->1163|2815->1168|2845->1176|2888->1188
                    LINES: 26->1|29->3|29->3|30->1|31->3|36->8|36->8|36->8|36->8|36->8|36->8|36->8|36->8|36->8|36->8|36->8|39->11|39->11|39->11|46->18|46->18|46->18|46->18|46->18|46->18|46->18|48->20|48->20|49->21|49->21|49->21|49->21|50->22|50->22|50->22|51->23
                    -- GENERATED --
                */
            