
package views.html.patrimonio.baul

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
object tabsProductoRemitoBaul extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Boolean,Long,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(formularioCarga: Boolean, id: Long = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.45*/("""

	<ul id="ordenTab" class="nav nav-tabs">
		<li class="active"><a id="listaRemitos" data-href=""""),_display_(Seq[Any](/*4.55*/controllers/*4.66*/.patrimonio.routes.RemitosLineasBaulController.index(if(id != null) {id} else {0}, formularioCarga))),format.raw/*4.165*/("""" href="#contenedorRemitos" data-toggle="tab">Lista de productos</a></li>
	</ul>


	<div class="tab-content">
		<div id="contenedorProductos" class="tab-pane active">
		
		</div>
	</div>
	
	
	<script>
	$( function()"""),format.raw/*16.15*/("""{"""),format.raw/*16.16*/("""
		var urlRemitos = $('#listaRemitos').attr("data-href");
		$.get(urlRemitos, function(data)"""),format.raw/*18.35*/("""{"""),format.raw/*18.36*/("""
			$('#contenedorProductos').html(data);
		"""),format.raw/*20.3*/("""}"""),format.raw/*20.4*/(""");
	"""),format.raw/*21.2*/("""}"""),format.raw/*21.3*/(""");
	</script>

"""))}
    }
    
    def render(formularioCarga:Boolean,id:Long): play.api.templates.HtmlFormat.Appendable = apply(formularioCarga,id)
    
    def f:((Boolean,Long) => play.api.templates.HtmlFormat.Appendable) = (formularioCarga,id) => apply(formularioCarga,id)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/baul/tabsProductoRemitoBaul.scala.html
                    HASH: 84da2368678736c6602e9dbb6b256d57ed739e59
                    MATRIX: 813->1|950->44|1085->144|1104->155|1225->254|1480->481|1509->482|1631->576|1660->577|1733->623|1761->624|1793->629|1821->630
                    LINES: 26->1|29->1|32->4|32->4|32->4|44->16|44->16|46->18|46->18|48->20|48->20|49->21|49->21
                    -- GENERATED --
                */
            