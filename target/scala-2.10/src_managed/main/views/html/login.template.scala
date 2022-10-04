
package views.html

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
object login extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.auth.LoginForm],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(form: Form[models.auth.LoginForm]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.37*/("""
<!DOCTYPE html>
<html lang="es">
	<head>
		<link rel="shortcut icon" href="/assets/images/favicon.png" />
		<link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*6.48*/routes/*6.54*/.Assets.at("plugins/bootstrap/css/bootstrap.min.css"))),format.raw/*6.107*/("""">
		<link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*7.48*/routes/*7.54*/.Assets.at("stylesheets/login.css"))),format.raw/*7.89*/("""">
	</head>
<body>
"""),_display_(Seq[Any](/*10.2*/helper/*10.8*/.form(routes.Authentication.authenticate, 'class -> "form-signin")/*10.74*/ {_display_(Seq[Any](format.raw/*10.76*/("""
    <div class="container">
      <form class="form-signin">
        <h2 class="form-signin-heading">Autentificación</h2>
        
		"""),_display_(Seq[Any](/*15.4*/if(form.hasGlobalErrors)/*15.28*/ {_display_(Seq[Any](format.raw/*15.30*/("""
	    	<p class="alert alert-danger">
	      		<i class="glyphicon glyphicon-info-sign"></i> """),_display_(Seq[Any](/*17.57*/form/*17.61*/.globalError.message)),format.raw/*17.81*/("""
	     	</p>
	    """)))})),format.raw/*19.7*/("""
	    

        
        <input type="nick" class="form-control" name="nick" placeholder="Usuario" value=""""),_display_(Seq[Any](/*23.91*/form("nick")/*23.103*/.value)),format.raw/*23.109*/("""" autofocus>
        <input type="password" class="form-control" name="password" placeholder="Password">

        <div class="row">
        	<div class="col-sm-3">
        		<img alt="Logo" src="/assets/images/logo.png" />
        	</div>
        	<div class="col-sm-9">
        		<button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
        	</div>
        </div>
        
      </form>
    </div>
""")))})),format.raw/*37.2*/("""
  </body>
</html>"""))}
    }
    
    def render(form:Form[models.auth.LoginForm]): play.api.templates.HtmlFormat.Appendable = apply(form)
    
    def f:((Form[models.auth.LoginForm]) => play.api.templates.HtmlFormat.Appendable) = (form) => apply(form)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:27 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/login.scala.html
                    HASH: 55425b4a6ae3a46d6a16cb91218621f3731e1aa6
                    MATRIX: 795->1|924->36|1113->190|1127->196|1202->249|1287->299|1301->305|1357->340|1412->360|1426->366|1501->432|1541->434|1711->569|1744->593|1784->595|1914->689|1927->693|1969->713|2019->732|2162->839|2184->851|2213->857|2670->1283
                    LINES: 26->1|29->1|34->6|34->6|34->6|35->7|35->7|35->7|38->10|38->10|38->10|38->10|43->15|43->15|43->15|45->17|45->17|45->17|47->19|51->23|51->23|51->23|65->37
                    -- GENERATED --
                */
            