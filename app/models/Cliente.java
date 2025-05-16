package models;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;

import com.avaje.ebean.ExpressionList;

import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import utils.pagination.Pagination;

@Entity
@Table(name = "clientes")
public class Cliente extends Model {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="clientes_id_seq")
	public Long id;
	@Required(message="Nombre requerido")
	public String nombre;


	@ManyToOne
	@JoinColumn(name="cliente_tipo_id", referencedColumnName="id", insertable=false, updatable=false)
	public ClienteTipo tipo;
	@Required(message="Tipo Cliente requerido")
	@Column(name="cliente_tipo_id")
	public Long cliente_tipo_id;

	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fnacimiento;
	public String sexo;


	public String cuit2;
	//@Required(message="DNI requerido")
	public Integer dni;
	public String cie;
	public String referencia;
	public String referencia_2;
	public String id_paciente_rismi;
	public String nafiliado;

	public Boolean activo = false;
	public Boolean profe = false;

	@ManyToOne
	@JoinColumn(name="obrasocial_id", referencedColumnName="id", insertable=false, updatable=false)
	public Obrasocial obrasocial;
	@Column(name="obrasocial_id")
	public Long obrasocial_id;

	@ManyToOne
	@JoinColumn(name="create_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario create_usuario;
	@Column(name="create_usuario_id")
	public Long create_usuario_id;

	public Date create_date;
	public Date write_date;

	@ManyToOne
	@JoinColumn(name="write_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario write_usuario;
	@Column(name="write_usuario_id")
	public Long write_usuario_id;

	@ManyToOne
	@JoinColumn(name="condicioniva_id", referencedColumnName="id", insertable=false, updatable=false)
	public CondicionIva condicionIva;
	public Integer condicioniva_id;

	@Valid
	@OneToMany(cascade=CascadeType.PERSIST)
	public List<DireccionCliente> direcciones;

	public static Finder<Long,Cliente> find = new Finder<Long,Cliente>(Long.class, Cliente.class);

	public List<Cliente> getDataSuggest(String input,Integer limit){
		List<Cliente> e = find.where()
				.disjunction()
				.ilike("nombre", "%"+input+"%")
				.ilike("id_paciente_rismi", "%"+input+"%")
				.ilike("cuit2", "%"+input+"%")
				.endJunction()
				.setMaxRows(limit).orderBy("nombre")
				.findList();

		return e;
	}

	public static Pagination<Cliente> page(String nombre,
										   String idPaciente,
										   String dni,
										   String cuit,
										   String cliente_tipo_id
										   ) {
    	Pagination<Cliente> p = new Pagination<Cliente>();
    	p.setOrderDefault("ASC");
    	p.setSortByDefault("nombre");

    	ExpressionList<Cliente> e = find
    			.fetch("obrasocial", "nombre")
    			.fetch("direcciones")
    			.where();
    	if(!nombre.isEmpty()){
    		e.ilike("nombre", "%" + nombre + "%");
    	}

    	if(!cliente_tipo_id.isEmpty()){
    		e.eq("cliente_tipo_id", Integer.parseInt(cliente_tipo_id));
    	}

    	if(!dni.isEmpty()){
    		e.eq("dni",  Integer.parseInt(dni));
    	}

    	if(!cuit.isEmpty()){
    		e.ilike("cuit2", "%" + cuit + "%");
    	}
    	if(!idPaciente.isEmpty()){
    		e.ilike("id_paciente_rismi", "%" + idPaciente + "%");
    	}

    	p.setExpressionList(e);

    	return p;
    }

	public int getTipoDocAfip() {
		int docTipo = 80;
		Long doc = null;

		if(this.cliente_tipo_id.compareTo(ClienteTipo.EXTRANJEROS) == 0 || this.cliente_tipo_id.compareTo(ClienteTipo.EXTRANJEROS_SIN_RESIDENCIA) == 0) {
			docTipo = 91;
		}

		if(this.cie != null && !this.cie.isEmpty()) {

			docTipo = 91;
		}else if(this.cuit2 != null && !this.cuit2.isEmpty()) {
			doc = new Long(this.cuit2);
		}else if(this.dni != null) {
			docTipo = 96;
		}

		return docTipo;

	}

	public Long getDocAfip() {

		Long doc = null;

		if(this.cie != null && !this.cie.isEmpty()) {
			doc = new Long(this.cie);
		}else if(this.cuit2 != null && !this.cuit2.isEmpty()) {
			doc = new Long(this.cuit2);
		}else if(this.dni != null) {
			doc = new Long(this.dni);
		}

		return doc;

	}

	public int getEdad(){
		int edad = -1;
		if(fnacimiento != null){
			Calendar fechaNacimiento = Calendar.getInstance();
	        //Se crea un objeto con la fecha actual
	        Calendar fechaActual = Calendar.getInstance();
	        //Se asigna la fecha recibida a la fecha de nacimiento.
	        fechaNacimiento.setTime(fnacimiento);
	        //Se restan la fecha actual y la fecha de nacimiento
	        int año = fechaActual.get(Calendar.YEAR)- fechaNacimiento.get(Calendar.YEAR);
	        int mes =fechaActual.get(Calendar.MONTH)- fechaNacimiento.get(Calendar.MONTH);
	        int dia = fechaActual.get(Calendar.DATE)- fechaNacimiento.get(Calendar.DATE);
	        //Se ajusta el año dependiendo el mes y el día
	        if(mes<0 || (mes==0 && dia<0)){
	            año--;
	        }
	        //Regresa la edad en base a la fecha de nacimiento
	        return año;
		}

		return edad;
	}

	public DireccionCliente getFirstDireccionObj(){
		DireccionCliente ret = null ;

		List<DireccionCliente> listaDireccionProveedor = DireccionCliente.find.where().eq("cliente_id", id).findList();
    	if(listaDireccionProveedor.size() > 0){
    		DireccionCliente dp = listaDireccionProveedor.get(0);
	    	if(dp != null){
	    		ret = dp ;
	    	}
    	}

    	return ret;
	}

	public String getFirstDireccion(){
    	String direccion = "";

    	List<DireccionCliente> listaDireccionProveedor = DireccionCliente.find.where().eq("cliente_id", id).findList();
    	if(listaDireccionProveedor.size() > 0){
    		DireccionCliente dp = listaDireccionProveedor.get(0);
	    	if(dp != null){
	    		String calle = (dp.calle != null)?dp.calle:"";
	    		String numero = (dp.numero != null)?dp.numero:"";
	    		String localidad = (dp.localidad != null && !dp.localidad.id.equals(new Integer(442)))?dp.localidad.nombre:"";
	    		String provincia = (dp.localidad != null && dp.localidad.provincia != null)?dp.localidad.provincia.nombre:"";
	    		String pais = (dp.localidad != null && dp.localidad.provincia != null && dp.localidad.provincia.pais != null)?dp.localidad.provincia.pais.nombre:"";
	    		direccion = calle+" "+numero+" - "+localidad+" - "+provincia+" - "+pais;
	    	}
    	}
    	return direccion;
    }

}
