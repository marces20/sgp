
package views.html.haberes.novedades

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
object crearNovedades extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.haberes.Novedad],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(nForm: Form[models.haberes.Novedad]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import utils._

def /*4.2*/scripts/*4.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*4.13*/("""
	<script src=""""),_display_(Seq[Any](/*5.16*/routes/*5.22*/.Assets.at("javascripts/haberes/novedades.js"))),format.raw/*5.68*/("""" type="text/javascript"></script>
""")))};
Seq[Any](format.raw/*1.39*/("""
"""),format.raw/*6.2*/("""

"""),_display_(Seq[Any](/*8.2*/views/*8.7*/.html.haberes.mainHaberes("Crear novedades", scripts)/*8.60*/ {_display_(Seq[Any](format.raw/*8.62*/("""

	<div class="page-header">
		<div class="row">
			<div class="col-sm-10">
				<h1>Crear novedades</h1>
			</div>
		</div>
	</div>
	"""),_display_(Seq[Any](/*17.3*/views/*17.8*/.html.tags.successError())),format.raw/*17.33*/("""
    
    """),_display_(Seq[Any](/*19.6*/helper/*19.12*/.form(action = controllers.haberes.routes.NovedadesController.guardar(), 'id -> "formNovedades")/*19.108*/ {_display_(Seq[Any](format.raw/*19.110*/("""
	<div class="row menu-acciones">
		<div class="col-sm-10">
			<button type="submit" class="btn btn-default" title="Guardar novedad"><i class="glyphicon glyphicon-floppy-disk"></i> Crear novedad</button>
			<a href=""""),_display_(Seq[Any](/*23.14*/UriTrack/*23.22*/.getOnNull(controllers.haberes.routes.NovedadesController.crear().absoluteURL()))),format.raw/*23.102*/("""" title="Cancelar" class="btn btn-default"><i class="glyphicon glyphicon-floppy-remove"></i> Cancelar</a>
		</div>
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*26.14*/UriTrack/*26.22*/.getOnNull(controllers.haberes.routes.NovedadesController.index().absoluteURL()))),format.raw/*26.102*/("""" title="Volver al listado" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
		</div>	
	</div> 
		"""),_display_(Seq[Any](/*29.4*/views/*29.9*/.html.haberes.novedades.formNovedades(nForm))),format.raw/*29.53*/(""" 	
	""")))})),format.raw/*30.3*/("""
""")))})),format.raw/*31.2*/("""

<script>
$( function() """),format.raw/*34.15*/("""{"""),format.raw/*34.16*/("""
/*
	$('#formNovedades').submit( function() """),format.raw/*36.41*/("""{"""),format.raw/*36.42*/("""
		var form = $(this);
		var data = form.serialize();
		var url = form.attr("action");
		
		$.post(url, data, function(data)"""),format.raw/*41.35*/("""{"""),format.raw/*41.36*/("""
			if(data.success) """),format.raw/*42.21*/("""{"""),format.raw/*42.22*/("""
				
			"""),format.raw/*44.4*/("""}"""),format.raw/*44.5*/(""" else """),format.raw/*44.11*/("""{"""),format.raw/*44.12*/("""
				form.html(data.html);
			"""),format.raw/*46.4*/("""}"""),format.raw/*46.5*/("""
			
		"""),format.raw/*48.3*/("""}"""),format.raw/*48.4*/(""");

		return false;
	"""),format.raw/*51.2*/("""}"""),format.raw/*51.3*/(""");
	*/
"""),format.raw/*53.1*/("""}"""),format.raw/*53.2*/(""");
</script>"""))}
    }
    
    def render(nForm:Form[models.haberes.Novedad]): play.api.templates.HtmlFormat.Appendable = apply(nForm)
    
    def f:((Form[models.haberes.Novedad]) => play.api.templates.HtmlFormat.Appendable) = (nForm) => apply(nForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:35 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/novedades/crearNovedades.scala.html
                    HASH: 15194e1a0b88631b46b7ec6f35e92dab3a9ee918
                    MATRIX: 823->1|971->76|985->83|1069->87|1121->104|1135->110|1202->156|1278->38|1306->193|1345->198|1357->203|1418->256|1457->258|1635->401|1648->406|1695->431|1743->444|1758->450|1864->546|1905->548|2162->769|2179->777|2282->857|2474->1013|2491->1021|2594->1101|2752->1224|2765->1229|2831->1273|2868->1279|2902->1282|2958->1310|2987->1311|3061->1357|3090->1358|3247->1487|3276->1488|3326->1510|3355->1511|3393->1522|3421->1523|3455->1529|3484->1530|3543->1562|3571->1563|3607->1572|3635->1573|3686->1597|3714->1598|3750->1607|3778->1608
                    LINES: 26->1|31->4|31->4|33->4|34->5|34->5|34->5|36->1|37->6|39->8|39->8|39->8|39->8|48->17|48->17|48->17|50->19|50->19|50->19|50->19|54->23|54->23|54->23|57->26|57->26|57->26|60->29|60->29|60->29|61->30|62->31|65->34|65->34|67->36|67->36|72->41|72->41|73->42|73->42|75->44|75->44|75->44|75->44|77->46|77->46|79->48|79->48|82->51|82->51|84->53|84->53
                    -- GENERATED --
                */
            