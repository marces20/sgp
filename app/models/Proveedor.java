package models;

import java.util.ArrayList;
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
@Table(name = "proveedores")
public class Proveedor extends Model {
	private static final long serialVersionUID = 1L;

	public static final String TIPO_EXTERNO = "externo";
	public static final String TIPO_INTERNO = "interno";
	public static final String TIPO_AGENTE_INTERNO = "agente_interno";
	public static final String TIPO_AGENTE_PLANTA = "agente_externo";

	public static final long PROVEEDOR_COMODIN_PERSONAL = 1387;
	public static final long HABERES_VARIOS = 15631;
	public static final long PROVEEDOR_AFIP = 1366;
	public static final long RA = 14947;

	public static final int FONDO_PERMANENTE = 17100;

	public static final Long[] PROVEEDOR_SIN_FACTURAS = { new Long(1366),new Long(1366),new Long(11081),new Long(15631),new Long(12770),new Long(15669),new Long(3172)};


	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="proveedores_id_seq")
	public Long id;

	@Required(message="El nombre es requerido")
	public String nombre;

	public String referencia;

	@Valid
	@OneToMany(cascade={CascadeType.REMOVE})
	public List<DireccionProveedor> direcciones;

	@Required(message="El cuit es requerido")
	public Long cuit;


	public Long dni;

	@ManyToOne
	@JoinColumn(name="agente_id", referencedColumnName="id", insertable=false, updatable=false)
	public Agente agente;

	public Long agente_id;

	@OneToMany
	public List<CuentaBancaria> cuenta;

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

	@Column(name = "nro_inscripcion")
	public String numero_inscripcion;
	public boolean activo = false;
	public String observaciones;


	public boolean afip_iva = false;
	public boolean afip_ganancia_minima_presunta = false;
	public boolean afip_ganancias_sociedades = false;
	public boolean afip_reg_seg_social_empleador = false;
	public boolean iibb_directo = false;
	public boolean iibb_cm = false;
	public boolean oficio = false;

	@ManyToOne
	@JoinColumn(name="proveedor_padre_id", referencedColumnName="id", insertable=false, updatable=false)
	public Proveedor proveedor_padre;
	@Column(name="proveedor_padre_id")
	public Long proveedor_padre_id;


	public static Model.Finder<Long,Proveedor> find = new Model.Finder<Long,Proveedor>(Long.class, Proveedor.class);

	public static Pagination<Proveedor> page(String nombre, String cuit, String proveedor) {
		Pagination<Proveedor> p = new Pagination<Proveedor>();
    	p.setOrderDefault("ASC");
    	p.setSortByDefault("nombre");

    	ExpressionList<Proveedor> e = find.where();

    	if(!nombre.isEmpty()) {
    		e.ilike("nombre", "%"+nombre+"%");
    	}

    	if(!cuit.isEmpty()) {
    		e.ilike("CAST(cuit AS TEXT)", "%"+cuit+"%");
    	}

    	switch (proveedor) {
			case Proveedor.TIPO_INTERNO:
				e.isNotNull("agente_id");
				break;
			case Proveedor.TIPO_EXTERNO:
				e.isNull("agente_id");
				break;
			case Proveedor.TIPO_AGENTE_INTERNO:
				e.isNotNull("agente_id").eq("agente.planta", false);
				break;
			case Proveedor.TIPO_AGENTE_PLANTA:
				e.eq("agente.planta", true);
				break;
		}


    	p.setExpressionList(e);
    	return p;
    }

    public List<Proveedor> getDataSuggest(String input,Integer limit){
		List<Proveedor> l = find.where()
				.ilike("nombre", "%"+input+"%")
				.setMaxRows(limit).orderBy("id")
			    .findList();

		return l;
	}

    public ProveedorAtributo getLastAtributo(){
    	ProveedorAtributo l = ProveedorAtributo.find.where()
				.eq("proveedor_id", id)
				.setMaxRows(1).orderBy("id DESC").findUnique();

		return l;
	}

    public String getCuitConGuiones(){
    	String r = "";

    	if(cuit != null){

    		String x = cuit.toString();

    		String a = x.substring(0, 2);
    		String b = x.substring(2, 10);
    		String c = x.substring(10, 11);

    		r = a+"-"+b+"-"+c;
    	}

    	return r;
    }

    public String getFirstDireccion(){
    	String direccion = "";

    	List<DireccionProveedor> listaDireccionProveedor = DireccionProveedor.find.where().eq("proveedor_id", id).findList();
    	if(listaDireccionProveedor.size() > 0){
	    	DireccionProveedor dp = listaDireccionProveedor.get(0);
	    	if(dp != null){
	    		String calle = (dp.calle != null)?dp.calle:"";
	    		String numero = (dp.numero != null)?dp.numero:"";
	    		String localidad = (dp.localidad != null)?dp.localidad.nombre:"";
	    		String provincia = (dp.localidad != null && dp.localidad.provincia != null)?dp.localidad.provincia.nombre:"";
	    		String pais = (dp.localidad != null && dp.localidad.provincia != null && dp.localidad.provincia.pais != null)?dp.localidad.provincia.pais.nombre:"";
	    		direccion = calle+" "+numero+" - "+localidad+" - "+provincia+" - "+pais;
	    	}
    	}
    	return direccion;
    }

    public static List getProveedoresDestacadosRA(){
    	List<Long> ret = new ArrayList<Long>();
    	ret.add((long)2050);//"DROGUERIA SAN MIGUEL de Alfonzo Ramón Dario"
    	ret.add((long)1430);//"DROGUERIA POSADAS de Colombo Rene Jorge Eduardo"
    	ret.add((long)3045);//"FARMACIA GROBLI de Alfonzo Ramón Dario"
    	ret.add((long)2176);//"AT.ME.DO. S.R.L."
    	ret.add((long)14106);//"DROGUERIA POSADAS S.R.L."
    	ret.add((long)14441);//"DROGUERIA GEMPRO  de GENESIS S.A.S."
    	ret.add((long)14971);//"FARMACIA GP de Genesis SAS"
    	ret.add((long)16359);//"BIOFIX de Ezcurra Mariel Cristina"
    	return ret;
    }

    public static List getProveedoresTejedor(){
    	List<Long> ret = new ArrayList<Long>();
    	ret.add((long)15890);//LAS MISIONES DROGUERIA de Servicios Farmaceuticos S.R.L.
    	ret.add((long)2749);//"IMPLANTEJ DE TEJEDOR FACUNDO
    	ret.add((long)15080);//"PRESTACIONES NEFROLOGICAS S.R.L.
    	return ret;
    }

    public static List getProveedoresYacaro(){
    	List<Long> ret = new ArrayList<Long>();
    	ret.add((long)17217);//MISSION GROUP S.R.L.
    	ret.add((long)16727);//YAKARO S.A.
    	return ret;
    }

    public static List<Integer> getProveedoresDestacadosRAInt(){
    	List<Integer> ret = new ArrayList<Integer>();
    	ret.add(2050);
    	ret.add(1430);
    	ret.add(3045);
    	ret.add(2176);
    	ret.add(14106);
    	ret.add(14441);
    	ret.add(14971);
    	ret.add(16359);

    	return ret;
    }

    public static List<Integer> getProveedoresDestacadosYRA (){
    	List<Integer> listaProveedores = new ArrayList<Integer>();
    	listaProveedores.add(2050);//DROGUERIA SAN MIGUEL de Alfonzo Ramón Dario
		listaProveedores.add(1430);//DROGUERIA POSADAS de Colombo Rene Jorge Eduardo
		listaProveedores.add(3045);//FARMACIA GROBLI de Alfonzo Ramón Dario
		listaProveedores.add(2176);//AT.ME.DO. S.R.L.
		listaProveedores.add(14441);//DROGUERIA GEMPRO de GENESIS S.A.S.
		listaProveedores.add(14971);//FARMACIA GP de Genesis SAS
		listaProveedores.add(14106);//DROGUERIA POSADAS S.R.L.
		listaProveedores.add(16359);//BIOFIX de Ezcurra Mariel Cristina
		///////////////////////////////////////////////////
		//listaProveedores.add(7348);//CONSTRUCTORA TABAY SA
		listaProveedores.add(1589);//NR CONSTRUCCIONES S.A.
		//listaProveedores.add(1530);//MOFAR S.A.
		listaProveedores.add(4359);//DROGUERIA SAN JORGE S.A.
		listaProveedores.add(2749);//IMPLANTEJ DE TEJEDOR FACUNDO
		//listaProveedores.add(15156);//MACROFAR

		//listaProveedores.add(1498);//MEDICALPRO
		listaProveedores.add(14733);//BISIONES S.R.L.

		listaProveedores.add(11081);//IPS
		listaProveedores.add((int)Proveedor.HABERES_VARIOS);//Sin Proveedor Asignado
		//////////////////////////////

		listaProveedores.add(15890);//	15890	"LAS MISIONES DROGUERIA de Servicios Farmaceuticos S.R.L."
		listaProveedores.add(15080);//	15080	"PRESTACIONES NEFROLOGICAS S.R.L."
		listaProveedores.add(16727);//	16727	"YAKARO S.A."
		listaProveedores.add(17217);//	17217	"MISSION GROUP S.R.L."
		listaProveedores.add(1838);// 	1838	"PACIFIC OCEAN S.A."
		listaProveedores.add(1588);// 	1588	"COMPAÑIA MISIONERA DE SEGURIDAD S.R.L."
		listaProveedores.add(2713);// 	2713	"SAFITA S.R.L."
		listaProveedores.add(1592);// 	1592	Constructora Pindoi S.R.L.

		return listaProveedores;
    }

    public static List<Integer> getProveedoresDestacados (){
    	List<Integer> listaProveedores = new ArrayList<Integer>();


		//listaProveedores.add(7348);//CONSTRUCTORA TABAY SA
		listaProveedores.add(1589);//NR CONSTRUCCIONES S.A.
		//listaProveedores.add(1530);//MOFAR S.A.
		listaProveedores.add(4359);//DROGUERIA SAN JORGE S.A.
		listaProveedores.add(2749);//IMPLANTEJ DE TEJEDOR FACUNDO
		listaProveedores.add(14733);//BISIONES S.R.L.
		listaProveedores.add(11081);//IPS
		//listaProveedores.add(15156);//MACROFAR
		listaProveedores.add((int)Proveedor.HABERES_VARIOS);//Sin Proveedor Asignado

		listaProveedores.add(15890);//	15890	"LAS MISIONES DROGUERIA de Servicios Farmaceuticos S.R.L."
		listaProveedores.add(15080);//	15080	"PRESTACIONES NEFROLOGICAS S.R.L."
		listaProveedores.add(16727);//	16727	"YAKARO S.A."
		listaProveedores.add(17217);//	17217	"MISSION GROUP S.R.L."
		listaProveedores.add(1838);// 	1838	"PACIFIC OCEAN S.A."
		listaProveedores.add(1588);// 	1588	"COMPAÑIA MISIONERA DE SEGURIDAD S.R.L."
		listaProveedores.add(2713);// 	2713	"SAFITA S.R.L."
		listaProveedores.add(1592);// 	1592	Constructora Pindoi S.R.L.

		//listaProveedores.add(1498);

    	return listaProveedores;
    }

    public static Integer getTipoProveedor(Proveedor proveedor){
    	//AGENTE_CONTRATADO(1, "Agentes contratados"),
    	//AGENTE_PLANTA(2, "Agentes planta"),
    	//PROVEEDORES_EXTERNOS(3, "Proveedores externos");
    	Integer tipo;
    	if(proveedor.agente_id != null){
    		if(proveedor.agente.planta != null && proveedor.agente.planta){
				tipo = 2;
			}else{
				tipo = 1;
			}
		}else{
			tipo = 3;
		}
    	return tipo;
    }

}
