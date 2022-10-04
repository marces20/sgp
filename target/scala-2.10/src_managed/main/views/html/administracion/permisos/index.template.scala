
package views.html.administracion.permisos

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
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Usuario,HashSet[String],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(usuario: Usuario = null, permisos: HashSet[String] = null):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.61*/("""
"""),format.raw/*3.70*/(""" 
"""),_display_(Seq[Any](/*4.2*/views/*4.7*/.html.administracion.mainAdministracion("Asignación de permisos")/*4.72*/ {_display_(Seq[Any](format.raw/*4.74*/("""

<div class="page-header">
	<div class="row">
		<div class="col-sm-10">
			<h1>Asignación de permisos</h1>
		</div>
		
		<div class="col-sm-2">
			<a href=""""),_display_(Seq[Any](/*13.14*/controllers/*13.25*/.administracion.routes.UsuariosController.index())),format.raw/*13.74*/("""" class="btn btn-default"><i class="glyphicon glyphicon-list"></i></a> 
			<a href="#" class="btn btn-default"><i class="glyphicon glyphicon-align-justify"></i></a> 
		</div>
	</div>
</div>

"""),_display_(Seq[Any](/*19.2*/if(flash.containsKey("success"))/*19.34*/ {_display_(Seq[Any](format.raw/*19.36*/("""
	<div class="alert alert-success"><i class="glyphicon glyphicon-ok-sign"></i> """),_display_(Seq[Any](/*20.80*/flash/*20.85*/.get("success"))),format.raw/*20.100*/("""</div>
""")))})),format.raw/*21.2*/("""
"""),_display_(Seq[Any](/*22.2*/if(flash.containsKey("error"))/*22.32*/ {_display_(Seq[Any](format.raw/*22.34*/("""
	<div class="alert alert-danger"><i class="glyphicon glyphicon-remove-sign"></i> """),_display_(Seq[Any](/*23.83*/flash/*23.88*/.get("error"))),format.raw/*23.101*/("""</div>
""")))})),format.raw/*24.2*/("""


"""),_display_(Seq[Any](/*27.2*/helper/*27.8*/.form(action = controllers.administracion.routes.PermisosController.index( if(usuario != null){usuario.id} else {0} ))/*27.126*/ {_display_(Seq[Any](format.raw/*27.128*/("""

<div class="row">
	<div class="col-sm-3">
		<div class="form-group">
			<label for="inputPeriodo" class="control-label">Usuario</label> 
			<div class="input-group">
				
				<input type="text" class="form-control" id="usuario" value=""""),_display_(Seq[Any](/*35.66*/if(usuario != null)/*35.85*/ {_display_(Seq[Any](_display_(Seq[Any](/*35.88*/usuario/*35.95*/.nombre))))})),format.raw/*35.103*/("""" />
				<input type="hidden" id="usuario_id" value=""""),_display_(Seq[Any](/*36.50*/if(usuario != null)/*36.69*/ {_display_(Seq[Any](_display_(Seq[Any](/*36.72*/usuario/*36.79*/.id))))})),format.raw/*36.83*/("""" />
				<span class="input-group-addon">
				<a href="#" class="searchModal"
							id="searchPeriodo" 
							data-title="Selección de usuarios" 
							data-url=""""),_display_(Seq[Any](/*41.19*/controllers/*41.30*/.administracion.routes.UsuariosController.modalBuscar())),format.raw/*41.85*/("""" 
							data-height="650" 
							data-width="700" 
							data-listen="modal.seleccion.usuario.simple" 
							data-label="#usuario" 
							data-field="#usuario_id">
					<i class="glyphicon glyphicon-search"></i>
				</a>
				</span>
			</div>
		</div>
	</div>
</div>
	"""),_display_(Seq[Any](/*54.3*/if(usuario != null)/*54.22*/{_display_(Seq[Any](format.raw/*54.23*/("""
		<ul class="list-unstyled">
		"""),_display_(Seq[Any](/*56.4*/for(modulo <- models.auth.Modulo.find.all()) yield /*56.48*/ {_display_(Seq[Any](format.raw/*56.50*/("""
			<li><h3>"""),_display_(Seq[Any](/*57.13*/modulo/*57.19*/.nombre)),format.raw/*57.26*/("""</h3>
				<ul class="list-unstyled">
				"""),_display_(Seq[Any](/*59.6*/for(componente <- models.auth.Componente.find.where().eq("modulo_id", modulo.id).findList()) yield /*59.98*/ {_display_(Seq[Any](format.raw/*59.100*/("""
					<li style="margin-left: 30px"><h5>"""),_display_(Seq[Any](/*60.41*/componente/*60.51*/.nombre)),format.raw/*60.58*/("""</h5>
						<ul class="list-unstyled">
						"""),_display_(Seq[Any](/*62.8*/for(permiso <- models.auth.Permiso.find.where().eq("componente_id", componente.id).findList()) yield /*62.102*/ {_display_(Seq[Any](format.raw/*62.104*/("""
							<li style="margin-left: 30px"><div class="checkbox"><label><input type="checkbox" class="permiso" name="permiso" """),_display_(Seq[Any](/*63.122*/if(permisos.contains(permiso.id))/*63.155*/ {_display_(Seq[Any](format.raw/*63.157*/("""checked""")))})),format.raw/*63.165*/(""" value=""""),_display_(Seq[Any](/*63.174*/permiso/*63.181*/.id)),format.raw/*63.184*/("""" />"""),_display_(Seq[Any](/*63.189*/permiso/*63.196*/.descripcion)),format.raw/*63.208*/("""</label></div></li>
						""")))})),format.raw/*64.8*/("""
						</ul>
					</li>
				""")))})),format.raw/*67.6*/("""
				</ul>
			</li>
		""")))})),format.raw/*70.4*/("""
		</ul>
	""")))})),format.raw/*72.3*/("""
""")))})),format.raw/*73.2*/("""

""")))})),format.raw/*75.2*/("""

<script>
$( function() """),format.raw/*78.15*/("""{"""),format.raw/*78.16*/("""
	$('.searchModal').modalSearch();
	usuarioId = $('#usuario_id').val();
	$('.permiso').change( function(e) """),format.raw/*81.36*/("""{"""),format.raw/*81.37*/("""
		check = $(this);
		ec = e;
		if(check.is(':checked')) """),format.raw/*84.28*/("""{"""),format.raw/*84.29*/("""
			url = '"""),_display_(Seq[Any](/*85.12*/controllers/*85.23*/.administracion.routes.PermisosController.asignar())),format.raw/*85.74*/("""';
		"""),format.raw/*86.3*/("""}"""),format.raw/*86.4*/(""" else """),format.raw/*86.10*/("""{"""),format.raw/*86.11*/("""
			url = '"""),_display_(Seq[Any](/*87.12*/controllers/*87.23*/.administracion.routes.PermisosController.desasignar())),format.raw/*87.77*/("""';
		"""),format.raw/*88.3*/("""}"""),format.raw/*88.4*/("""
		$.get(url,"""),format.raw/*89.13*/("""{"""),format.raw/*89.14*/("""usuario:usuarioId,permiso:check.val()"""),format.raw/*89.51*/("""}"""),format.raw/*89.52*/(""",function(data)"""),format.raw/*89.67*/("""{"""),format.raw/*89.68*/("""
			if(!data.success) """),format.raw/*90.22*/("""{"""),format.raw/*90.23*/("""
				if(check.is(':checked'))"""),format.raw/*91.29*/("""{"""),format.raw/*91.30*/("""
					check.removeAttr('checked');
				"""),format.raw/*93.5*/("""}"""),format.raw/*93.6*/(""" else """),format.raw/*93.12*/("""{"""),format.raw/*93.13*/("""
					check.prop('checked', true);
				"""),format.raw/*95.5*/("""}"""),format.raw/*95.6*/("""
				alert("No se pudo modificar el permiso.");
			"""),format.raw/*97.4*/("""}"""),format.raw/*97.5*/("""
		"""),format.raw/*98.3*/("""}"""),format.raw/*98.4*/(""");
		
	"""),format.raw/*100.2*/("""}"""),format.raw/*100.3*/(""");
	
	$(document).on('modal.seleccion.usuario.simple', function(event, respuesta)"""),format.raw/*102.77*/("""{"""),format.raw/*102.78*/("""
		window.location.href = '"""),_display_(Seq[Any](/*103.28*/controllers/*103.39*/.administracion.routes.PermisosController.index())),format.raw/*103.88*/("""?id='+respuesta.id;
	"""),format.raw/*104.2*/("""}"""),format.raw/*104.3*/(""");
	
	
"""),format.raw/*107.1*/("""}"""),format.raw/*107.2*/(""")
</script>



"""))}
    }
    
    def render(usuario:Usuario,permisos:HashSet[String]): play.api.templates.HtmlFormat.Appendable = apply(usuario,permisos)
    
    def f:((Usuario,HashSet[String]) => play.api.templates.HtmlFormat.Appendable) = (usuario,permisos) => apply(usuario,permisos)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/administracion/permisos/index.scala.html
                    HASH: 5064cf609660ad82c191b6840dccabb7c50b5030
                    MATRIX: 815->1|977->81|1009->105|1083->60|1112->149|1150->153|1162->158|1235->223|1274->225|1477->392|1497->403|1568->452|1801->650|1842->682|1882->684|1999->765|2013->770|2051->785|2091->794|2129->797|2168->827|2208->829|2328->913|2342->918|2378->931|2418->940|2460->947|2474->953|2602->1071|2643->1073|2925->1319|2953->1338|3002->1341|3018->1348|3053->1356|3144->1411|3172->1430|3221->1433|3237->1440|3267->1444|3474->1615|3494->1626|3571->1681|3894->1969|3922->1988|3961->1989|4031->2024|4091->2068|4131->2070|4181->2084|4196->2090|4225->2097|4304->2141|4412->2233|4453->2235|4531->2277|4550->2287|4579->2294|4662->2342|4773->2436|4814->2438|4974->2561|5017->2594|5058->2596|5099->2604|5145->2613|5162->2620|5188->2623|5230->2628|5247->2635|5282->2647|5341->2675|5404->2707|5461->2733|5505->2746|5539->2749|5575->2754|5631->2782|5660->2783|5798->2893|5827->2894|5915->2954|5944->2955|5993->2968|6013->2979|6086->3030|6119->3036|6147->3037|6181->3043|6210->3044|6259->3057|6279->3068|6355->3122|6388->3128|6416->3129|6458->3143|6487->3144|6552->3181|6581->3182|6624->3197|6653->3198|6704->3221|6733->3222|6791->3252|6820->3253|6888->3294|6916->3295|6950->3301|6979->3302|7047->3343|7075->3344|7155->3397|7183->3398|7214->3402|7242->3403|7279->3412|7308->3413|7420->3496|7450->3497|7516->3526|7537->3537|7609->3586|7659->3608|7688->3609|7726->3619|7755->3620
                    LINES: 26->1|29->3|29->3|30->1|31->3|32->4|32->4|32->4|32->4|41->13|41->13|41->13|47->19|47->19|47->19|48->20|48->20|48->20|49->21|50->22|50->22|50->22|51->23|51->23|51->23|52->24|55->27|55->27|55->27|55->27|63->35|63->35|63->35|63->35|63->35|64->36|64->36|64->36|64->36|64->36|69->41|69->41|69->41|82->54|82->54|82->54|84->56|84->56|84->56|85->57|85->57|85->57|87->59|87->59|87->59|88->60|88->60|88->60|90->62|90->62|90->62|91->63|91->63|91->63|91->63|91->63|91->63|91->63|91->63|91->63|91->63|92->64|95->67|98->70|100->72|101->73|103->75|106->78|106->78|109->81|109->81|112->84|112->84|113->85|113->85|113->85|114->86|114->86|114->86|114->86|115->87|115->87|115->87|116->88|116->88|117->89|117->89|117->89|117->89|117->89|117->89|118->90|118->90|119->91|119->91|121->93|121->93|121->93|121->93|123->95|123->95|125->97|125->97|126->98|126->98|128->100|128->100|130->102|130->102|131->103|131->103|131->103|132->104|132->104|135->107|135->107
                    -- GENERATED --
                */
            