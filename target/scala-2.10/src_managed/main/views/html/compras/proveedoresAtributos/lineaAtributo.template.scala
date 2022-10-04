
package views.html.compras.proveedoresAtributos

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
object lineaAtributo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[ProveedorAtributo,Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea: ProveedorAtributo, editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.47*/("""

<tr data-id=""""),_display_(Seq[Any](/*3.15*/linea/*3.20*/.id)),format.raw/*3.23*/("""">
	
	<td>
		"""),_display_(Seq[Any](/*6.4*/if(linea.afip_ganancia)/*6.27*/{_display_(Seq[Any](format.raw/*6.28*/("""SI""")))}/*6.31*/else/*6.35*/{_display_(Seq[Any](format.raw/*6.36*/("""NO""")))})),format.raw/*6.39*/("""
	</td>
	<td>
		"""),_display_(Seq[Any](/*9.4*/if(linea.exento_iva)/*9.24*/{_display_(Seq[Any](format.raw/*9.25*/("""SI""")))}/*9.28*/else/*9.32*/{_display_(Seq[Any](format.raw/*9.33*/("""NO""")))})),format.raw/*9.36*/("""
	</td>
	<td>
		"""),_display_(Seq[Any](/*12.4*/if(linea.afip_condicion == 1)/*12.33*/{_display_(Seq[Any](format.raw/*12.34*/("""Monotribulo""")))}/*12.46*/else/*12.50*/{_display_(Seq[Any](format.raw/*12.51*/("""
			"""),_display_(Seq[Any](/*13.5*/if(linea.afip_condicion == 2)/*13.34*/{_display_(Seq[Any](format.raw/*13.35*/("""Responsable""")))})),format.raw/*13.47*/("""
		""")))})),format.raw/*14.4*/("""
	</td>
	<td>"""),_display_(Seq[Any](/*16.7*/if(linea.suss_tipo == 1)/*16.31*/{_display_(Seq[Any](format.raw/*16.32*/("""
			Comun
		""")))}/*18.5*/else/*18.9*/{_display_(Seq[Any](format.raw/*18.10*/(""" 
			"""),_display_(Seq[Any](/*19.5*/if(linea.suss_tipo == 2)/*19.29*/{_display_(Seq[Any](format.raw/*19.30*/("""
				Limpieza
			""")))}/*21.5*/else/*21.9*/{_display_(Seq[Any](format.raw/*21.10*/(""" 
				"""),_display_(Seq[Any](/*22.6*/if(linea.suss_tipo == 3)/*22.30*/{_display_(Seq[Any](format.raw/*22.31*/("""
					Seguridad
				""")))}/*24.6*/else/*24.10*/{_display_(Seq[Any](format.raw/*24.11*/("""
					"""),_display_(Seq[Any](/*25.7*/if(linea.suss_tipo == 4)/*25.31*/{_display_(Seq[Any](format.raw/*25.32*/("""
						Constructora
					""")))})),format.raw/*27.7*/("""
				""")))})),format.raw/*28.6*/(""" 
			""")))})),format.raw/*29.5*/("""
		""")))})),format.raw/*30.4*/("""
	</td>
	<td>"""),_display_(Seq[Any](/*32.7*/if(linea.dgr_condicion == 1)/*32.35*/{_display_(Seq[Any](format.raw/*32.36*/("""CM""")))}/*32.40*/else/*32.44*/{_display_(Seq[Any](format.raw/*32.45*/(""" 
			"""),_display_(Seq[Any](/*33.5*/if(linea.dgr_condicion == 2)/*33.33*/{_display_(Seq[Any](format.raw/*33.34*/("""DIRECTO""")))}/*33.42*/else/*33.46*/{_display_(Seq[Any](format.raw/*33.47*/(""" 
				"""),_display_(Seq[Any](/*34.6*/if(linea.dgr_condicion == 3)/*34.34*/{_display_(Seq[Any](format.raw/*34.35*/("""NO CM""")))})),format.raw/*34.41*/(""" """)))})),format.raw/*34.43*/("""
		""")))})),format.raw/*35.4*/("""</td>
	<!-- <td>
		"""),_display_(Seq[Any](/*37.4*/if(linea.exento_municipal == 0)/*37.35*/{_display_(Seq[Any](format.raw/*37.36*/("""Gravado""")))}/*37.44*/else/*37.48*/{_display_(Seq[Any](format.raw/*37.49*/("""
			"""),_display_(Seq[Any](/*38.5*/if(linea.exento_municipal == 1)/*38.36*/{_display_(Seq[Any](format.raw/*38.37*/("""Exento""")))})),format.raw/*38.44*/("""
		""")))})),format.raw/*39.4*/("""
	</td> -->	
	<td>
		"""),_display_(Seq[Any](/*42.4*/if(linea.exento_sello)/*42.26*/{_display_(Seq[Any](format.raw/*42.27*/("""SI""")))}/*42.30*/else/*42.34*/{_display_(Seq[Any](format.raw/*42.35*/("""NO""")))})),format.raw/*42.38*/("""
		
	</td>
	<!-- <td> </td> -->
	<td>"""),_display_(Seq[Any](/*46.7*/(utils.DateUtils.formatDate(linea.fecha_extento_afip_gcia)))),format.raw/*46.66*/("""</td>
	<td>"""),_display_(Seq[Any](/*47.7*/(utils.DateUtils.formatDate(linea.fecha_extento_afip_suss)))),format.raw/*47.66*/("""</td>
	<td>"""),_display_(Seq[Any](/*48.7*/(utils.DateUtils.formatDate(linea.fecha_extento_dgr_iibb)))),format.raw/*48.65*/("""</td>
	<td>"""),_display_(Seq[Any](/*49.7*/(utils.DateUtils.formatDate(linea.fecha_extento_dgr_sellos)))),format.raw/*49.67*/("""</td>
	
	<td>"""),_display_(Seq[Any](/*51.7*/(utils.DateUtils.formatDate(linea.create_date)))),format.raw/*51.54*/("""</td>
		
	 
</tr>"""))}
    }
    
    def render(linea:ProveedorAtributo,editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(linea,editable)
    
    def f:((ProveedorAtributo,Boolean) => play.api.templates.HtmlFormat.Appendable) = (linea,editable) => apply(linea,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:43 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/proveedoresAtributos/lineaAtributo.scala.html
                    HASH: d4827a570eec6407081be3466ae3f66cd96a2e13
                    MATRIX: 830->1|969->46|1022->64|1035->69|1059->72|1110->89|1141->112|1179->113|1200->116|1212->120|1250->121|1284->124|1338->144|1366->164|1404->165|1425->168|1437->172|1475->173|1509->176|1564->196|1602->225|1641->226|1672->238|1685->242|1724->243|1765->249|1803->278|1842->279|1886->291|1922->296|1973->312|2006->336|2045->337|2078->353|2090->357|2129->358|2171->365|2204->389|2243->390|2281->410|2293->414|2332->415|2375->423|2408->447|2447->448|2488->471|2501->475|2540->476|2583->484|2616->508|2655->509|2714->537|2752->544|2790->551|2826->556|2877->572|2914->600|2953->601|2975->605|2988->609|3027->610|3069->617|3106->645|3145->646|3172->654|3185->658|3224->659|3267->667|3304->695|3343->696|3381->702|3415->704|3451->709|3508->731|3548->762|3587->763|3614->771|3627->775|3666->776|3707->782|3747->813|3786->814|3825->821|3861->826|3921->851|3952->873|3991->874|4013->877|4026->881|4065->882|4100->885|4177->927|4258->986|4306->999|4387->1058|4435->1071|4515->1129|4563->1142|4645->1202|4696->1218|4765->1265
                    LINES: 26->1|29->1|31->3|31->3|31->3|34->6|34->6|34->6|34->6|34->6|34->6|34->6|37->9|37->9|37->9|37->9|37->9|37->9|37->9|40->12|40->12|40->12|40->12|40->12|40->12|41->13|41->13|41->13|41->13|42->14|44->16|44->16|44->16|46->18|46->18|46->18|47->19|47->19|47->19|49->21|49->21|49->21|50->22|50->22|50->22|52->24|52->24|52->24|53->25|53->25|53->25|55->27|56->28|57->29|58->30|60->32|60->32|60->32|60->32|60->32|60->32|61->33|61->33|61->33|61->33|61->33|61->33|62->34|62->34|62->34|62->34|62->34|63->35|65->37|65->37|65->37|65->37|65->37|65->37|66->38|66->38|66->38|66->38|67->39|70->42|70->42|70->42|70->42|70->42|70->42|70->42|74->46|74->46|75->47|75->47|76->48|76->48|77->49|77->49|79->51|79->51
                    -- GENERATED --
                */
            