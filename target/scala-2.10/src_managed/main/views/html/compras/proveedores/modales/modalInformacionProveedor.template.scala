
package views.html.compras.proveedores.modales

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
object modalInformacionProveedor extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Proveedor,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(proveedor:Proveedor):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.23*/("""

<div class="row">
	<div class="col-sm-12">
		<h3>Datos</h3>
		<p>Nombre: """),_display_(Seq[Any](/*6.15*/(proveedor.nombre))),format.raw/*6.33*/("""</p>
		<p>Cuit: """),_display_(Seq[Any](/*7.13*/(proveedor.cuit))),format.raw/*7.29*/("""</p>
		<hr>
		<h3>Informacion Cuentas</h3>
		"""),_display_(Seq[Any](/*10.4*/for(c <- proveedor.cuenta) yield /*10.30*/ {_display_(Seq[Any](format.raw/*10.32*/("""
			<p>Numero Cuenta: """),_display_(Seq[Any](/*11.23*/(c.numero_cuenta))),format.raw/*11.40*/("""</p>
			<p>Estado: """),_display_(Seq[Any](/*12.16*/if(c.activo)/*12.28*/{_display_(Seq[Any](format.raw/*12.29*/("""activo""")))}/*12.36*/else/*12.40*/{_display_(Seq[Any](format.raw/*12.41*/("""inactivo""")))})),format.raw/*12.50*/("""</p>
			<p>Predeterminada: """),_display_(Seq[Any](/*13.24*/if(c.predeterminada)/*13.44*/{_display_(Seq[Any](format.raw/*13.45*/("""si""")))}/*13.48*/else/*13.52*/{_display_(Seq[Any](format.raw/*13.53*/("""no""")))})),format.raw/*13.56*/("""</p>
		""")))})),format.raw/*14.4*/("""
		<hr>
		<h3>Informacion Direcciones</h3>
		"""),_display_(Seq[Any](/*17.4*/for(d <- proveedor.direcciones) yield /*17.35*/ {_display_(Seq[Any](format.raw/*17.37*/("""
			<p>Dirección: """),_display_(Seq[Any](/*18.19*/(d.calle))),format.raw/*18.28*/(""" """),_display_(Seq[Any](/*18.30*/(d.numero))),format.raw/*18.40*/(""" - """),_display_(Seq[Any](/*18.44*/if(d.localidad != null)/*18.67*/{_display_(Seq[Any](_display_(Seq[Any](/*18.69*/(d.localidad.nombre))),format.raw/*18.89*/(""" - """),_display_(Seq[Any](/*18.93*/(d.localidad.provincia.nombre))),format.raw/*18.123*/(""" - """),_display_(Seq[Any](/*18.127*/(d.localidad.provincia.pais.nombre)))))})),format.raw/*18.163*/("""</p>
			<p>Email: """),_display_(Seq[Any](/*19.15*/(d.email))),format.raw/*19.24*/("""</p>
			<p>Telefono: """),_display_(Seq[Any](/*20.18*/(d.telefono))),format.raw/*20.30*/("""</p>
			<p>Celular: """),_display_(Seq[Any](/*21.17*/(d.mobile))),format.raw/*21.27*/("""</p>
			<p>Fax: """),_display_(Seq[Any](/*22.13*/(d.fax))),format.raw/*22.20*/("""</p>
		""")))})),format.raw/*23.4*/("""
		<h3>Observaciones</h3>	
		<p>"""),_display_(Seq[Any](/*25.7*/(proveedor.observaciones))),format.raw/*25.32*/("""</p>
	</div>



</div>"""))}
    }
    
    def render(proveedor:Proveedor): play.api.templates.HtmlFormat.Appendable = apply(proveedor)
    
    def f:((Proveedor) => play.api.templates.HtmlFormat.Appendable) = (proveedor) => apply(proveedor)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:46 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/proveedores/modales/modalInformacionProveedor.scala.html
                    HASH: 3002d6cd0219f0ec78fd3848f84e1bcaba846e22
                    MATRIX: 825->1|940->22|1051->98|1090->116|1142->133|1179->149|1260->195|1302->221|1342->223|1401->246|1440->263|1496->283|1517->295|1556->296|1582->303|1595->307|1634->308|1675->317|1739->345|1768->365|1807->366|1829->369|1842->373|1881->374|1916->377|1955->385|2036->431|2083->462|2123->464|2178->483|2209->492|2247->494|2279->504|2319->508|2351->531|2399->533|2441->553|2481->557|2534->587|2575->591|2638->627|2693->646|2724->655|2782->677|2816->689|2873->710|2905->720|2958->737|2987->744|3026->752|3094->785|3141->810
                    LINES: 26->1|29->1|34->6|34->6|35->7|35->7|38->10|38->10|38->10|39->11|39->11|40->12|40->12|40->12|40->12|40->12|40->12|40->12|41->13|41->13|41->13|41->13|41->13|41->13|41->13|42->14|45->17|45->17|45->17|46->18|46->18|46->18|46->18|46->18|46->18|46->18|46->18|46->18|46->18|46->18|46->18|47->19|47->19|48->20|48->20|49->21|49->21|50->22|50->22|51->23|53->25|53->25
                    -- GENERATED --
                */
            