package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import models.auth.Permiso;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
@Table(name = "punto_ventas")
public class PuntoVenta extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="punto_ventas_id_seq")
	public Long id;

	@ManyToOne
	@JoinColumn(name="deposito_id", referencedColumnName="id", insertable=false, updatable=false)
	public Deposito deposito;
	@Required(message="Requiere una Institucion")
	public Long deposito_id;

	@Required(message="Requiere una numero")
	public String numero;

	@Required(message="Requiere tipo facturacion")
	public String tipo_facturacion;

	public boolean habilitado;

	public static Finder<Long,PuntoVenta> find = new Finder<Long,PuntoVenta>(Long.class, PuntoVenta.class);

	public static List<PuntoVenta> getPuntoVentaPermisos(){

		if(Usuario.getUsuarioSesion().equals(83)){//GRaciela traid
			List<Integer> ids = new ArrayList<Integer>();
			ids.add(9);
			ids.add(13);
			return find.where().in("id", ids).orderBy("numero asc").findList();
		}else {


			if(Permiso.check("verTodosPuntoVenta")){
				if(Permiso.check("verTodosComodinPuntoVenta")){
					return find.orderBy("numero asc").findList();
				}else {
					return find.where().eq("comodin", false).orderBy("numero asc").findList();
				}
			}else {
				Integer deptoId = 0;
				List<Integer> l = null;
				if( Usuario.getUsurioSesion().organigrama_id != null){
					deptoId = Usuario.getUsurioSesion().organigrama.deposito.id.intValue();
					return find.where().eq("comodin", false).eq("deposito_id", deptoId).orderBy("numero asc").findList();
				}
			}
		}
		return find.where().eq("deposito_id", 0).eq("comodin", false).orderBy("numero asc").findList();

	}
}
