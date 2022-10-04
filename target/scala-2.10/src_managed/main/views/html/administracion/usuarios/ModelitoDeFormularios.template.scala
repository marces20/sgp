
package views.html.administracion.usuarios

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
object ModelitoDeFormularios extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](_display_(Seq[Any](/*1.2*/main("Crear usuario")/*1.23*/ {_display_(Seq[Any](format.raw/*1.25*/("""

<div class="page-header">
	<h1>Crear nuevo usuario</h1>
</div>

<div class="alert alert-danger">
	Verifique los errores en el
	formulario
</div>
<div class="alert alert-success">
	El registro se ha almacenado
	correctamente
</div>

<form class="">

	<div class="row">
		<div class="col-sm-2">
			<div class="form-group  has-error">
				<label for="inputPassword1" class="control-label">Nombre</label>
				<input type="text" class="form-control" id="inputPassword1"
				placeholder="">
				<span class="help-block">El nombre es obligatorio.</span>
			</div>
		</div>
		<div class="col-sm-4">
			<div class="form-group  has-required">
				<label for="inputPassword1" class="control-label">Nombre</label>
				<input type="text" class="form-control" id="inputPassword3" placeholder="Nombre" />
			</div>
		</div>

		<div class="col-sm-4">
			<div class="form-group  has-required">
				<label for="inputPassword1" class="control-label">Nombre</label>
				<input
				type="text" class="form-control" id="inputPassword2" placeholder="Nombre">
			</div>
		</div>

		<div class="col-sm-2">
			<label class="control-label">Label</label>
			<p class="form-control-static">
				Texto estático
			</p>
		</div>

	</div>

	<div class="row">

		<div class="col-sm-2">
			<div class="form-group">
				<label for="inputPassword1" class="control-label">Nombre</label>
				<input
				type="text" class="form-control" disabled="disabled" id="inputPassword11" placeholder="Nombre">
			</div>
		</div>
		<div class="col-sm-4">
			<div class="form-group">
				<label for="inputPassword1" class="control-label">Nombre</label>
				<input
				type="text" class="form-control" id="inputPassword19" placeholder="Nombre">
			</div>
		</div>

		<div class="col-sm-4">
			<label for="localidad" class="control-label">Localidad</label>
			<select
			id="localidad" class="form-control">
				<option>Posadas</option>
				<option>Eldorado</option>
				<option>Puerto Rico</option>
			</select>
		</div>
	</div>

	<div class="row form-horizontal">
		<div class="form-group">
			<div class="col-sm-3">
				<label for="inputPassword1" class="col-sm-3 control-label">Nombre</label>
				<div class="col-sm-9">
					<input type="password" class="form-control" id="inputPassword15"
					placeholder="Nombre">
				</div>
			</div>
			<div class="col-sm-3">
				<label for="inputPassword1" class="col-sm-3 control-label">Localidad</label>
				<div class="col-sm-9">
					<select id="localidad2" class="form-control">
						<option>Posadas</option>
						<option>Eldorado</option>
						<option>Puerto Rico</option>
					</select>
				</div>
			</div>
			<div class="col-sm-3">
				<label for="inputPassword1" class="col-sm-3 control-label">Sexo</label>
				<div class="col-sm-9">
					<div class="radio radio-inline">
						<label>
							<input type="radio" name="optionsRadios" id="optionsRadios10" value="option1" checked>Máscuino</label>
					</div>
					<div class="radio radio-inline">
						<label>
							<input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
							Femenino</label>
					</div>
				</div>
			</div>
			<div class="col-sm-3">
				<label for="inputPassword1" class="col-sm-3 control-label">Rol</label>
				<div class="col-sm-9">
					<div class="radio checkbox-inline">
						<label>
							<input type="checkbox" id="inlineCheckbox1" value="option2">
							Admin</label>
					</div>
					<div class="radio checkbox-inline">
						<label>
							<input type="checkbox" id="inlineCheckbox2" value="option2">
							Operador</label>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="form-horizontal">
		<div class="form-group">
			<label for="inputPassword1" class="col-sm-2 control-label">Nombre</label>
			<div class="col-sm-8">
				<input type="password" class="form-control" id="inputPassword1"
				placeholder="Nombre">
			</div>
		</div>

		<div class="form-group">
			<label for="inputEmail1" class="col-sm-2 control-label">Email</label>
			<div class="col-sm-6">
				<input type="email" class="form-control" id="inputEmail1"
				placeholder="Email">
			</div>
		</div>

		<div class="form-group">
			<label for="localidad" class="col-sm-2 control-label">Email</label>
			<div class="col-sm-2">
				<select id="localidad" class="form-control">
					<option>Posadas</option>
					<option>Eldorado</option>
					<option>Puerto Rico</option>
				</select>
			</div>
		</div>

		<div class="form-group has-success">
			<div class="col-sm-offset-2 col-sm-10">
				<div class="checkbox">
					<label class="control-label">
						<input type="checkbox">
						Usuario activo </label>
				</div>
			</div>
		</div>

		<div class="form-group has-error">
			<div class="col-sm-offset-2 col-sm-10">
				<div class="checkbox">
					<label>
						<input type="checkbox">
						Denegar </label>
					<div class="help-block">
						Acción obligatoria
					</div>
				</div>
			</div>
		</div>

	</div>

	<div class="form-group has-error">
		<div class="radio">
			<label>
				<input type="radio" name="optionsRadios"
				id="optionsRadios1" value="option1" checked>
				Masculino </label>
		</div>
		<div class="radio">
			<label>
				<input type="radio" name="optionsRadios"
				id="optionsRadios2" value="option2">
				Femenino </label>
		</div>
		<div class="help-block">
			Debe seleccionar el sexo
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-default">
				Botón defualt
			</button>
			<button type="submit" class="btn btn-sistema">
				Botón sistema
			</button>
			<button type="submit" class="btn btn-primary">
				Botón primario
			</button>
			<button type="submit" class="btn btn-success">
				Botón exito
			</button>
			<button type="submit" class="btn btn-info">
				Botón información
			</button>
			<button type="submit" class="btn btn-warning">
				Botón advertencia
			</button>
			<button type="submit" class="btn btn-danger">
				Botón peligro
			</button>
		</div>
	</div>
	<br />
	<br />
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-default"  disabled="disabled">
				Botón defualt
			</button>
			<button type="submit" class="btn btn-sistema"  disabled="disabled">
				Botón sistema
			</button>
			<button type="submit" class="btn btn-primary"  disabled="disabled">
				Botón primario
			</button>
			<button type="submit" class="btn btn-success"  disabled="disabled">
				Botón exito
			</button>
			<button type="submit" class="btn btn-info"  disabled="disabled">
				Botón información
			</button>
			<button type="submit" class="btn btn-warning"  disabled="disabled">
				Botón advertencia
			</button>
			<button type="submit" class="btn btn-danger"  disabled="disabled">
				Botón peligro
			</button>
		</div>
	</div>

</form>

<h1> Título h1 <small>acompaña título</small></h1>
<h2> Título h2 <small>acompaña título</small></h2>
<h3> Título h3 <small>acompaña título</small></h3>
<h4> Título h4 <small>acompaña título</small></h4>
<h5> Título h5 <small>acompaña título</small></h5>
<h6> Título h6 <small>acompaña título</small></h6>

asd """)))})),format.raw/*263.6*/("""
"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/administracion/usuarios/ModelitoDeFormularios.scala.html
                    HASH: b1845bc80b401b39d7f756b2922599c3d093b89f
                    MATRIX: 904->1|933->22|972->24|8393->7413
                    LINES: 29->1|29->1|29->1|291->263
                    -- GENERATED --
                */
            