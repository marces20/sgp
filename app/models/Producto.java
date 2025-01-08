package models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.avaje.ebean.ExpressionList;

import play.Logger;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import utils.RequestVar;
import utils.formatters.DecimalComa;
import utils.pagination.Pagination;


@Entity
@Table(name = "productos")
public class Producto extends Model{

	private static final long serialVersionUID = 1L;
	public static final long CATEGORIA_IPS = 33;
	final static Long ID_UDM_PREDETERMINADO = (long) 1;
	final static Long ID_CUENTA_INGRESO = (long) 226;
	final static Long ID_CUENTA_GASTO = (long) 255;
	final static double PRECIO_COSTE = (double) 1.00;

	public final static Long ID_PRODUCTO_DIFERENCIA_CAMBIO_1 = (long) 30653;
	public final static Long ID_PRODUCTO_DIFERENCIA_CAMBIO_2 = (long) 40276;
	public final static Long ID_PRODUCTO_DIFERENCIA_CAMBIO_3 = (long) 40277;

	public static final List<Long> LISTA_PRODUCTOS_DIFERENCIA_CAMBIO = new ArrayList<Long>() {{
	        add((long) 30653);
	        add((long) 40276);
	        add((long) 40277);
	    }};

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="productos_id_seq")
	public Long id;
	@Required(message="Debe escribir un nombre")
	public String nombre;
	public String referencia;
	public String codigo_rismi;
	public String codigo_ips;

	public String slug;

	@ManyToOne
	@JoinColumn(name="categoria_id", referencedColumnName="id", insertable=false, updatable=false)
	public Categoria categoria;
	public Integer categoria_id;

	@ManyToOne
	@JoinColumn(name="tipo_producto_id", referencedColumnName="id", insertable=false, updatable=false)
	public TipoProducto tipo_producto;
	public Integer tipo_producto_id;

	@ManyToOne
	@JoinColumn(name="articulo_id", referencedColumnName="id", insertable=false, updatable=false)
	public Articulo articulo;
	public Integer articulo_id;

	@ManyToOne
	@JoinColumn(name="udm_id", referencedColumnName="id", insertable=false, updatable=false)
	public Udm udm;
	public Integer udm_id;

	@Required(message="Debe escribir un precio")
	@DecimalComa(value="")
	public BigDecimal precio_coste;

	@DecimalComa(value="")
	public BigDecimal precio_extranjero;


	public boolean venta = false;
	public boolean compra = false;
	public boolean activo = false;

	@ManyToOne
	@JoinColumn(name="cuenta_ingreso_id", referencedColumnName="id", insertable=false, updatable=false)
	public Cuenta cuenta_ingreso;
	public Integer cuenta_ingreso_id;

	@ManyToOne
	@JoinColumn(name="cuenta_gasto_id", referencedColumnName="id", insertable=false, updatable=false)
	public Cuenta cuenta_gasto;
	public Integer cuenta_gasto_id;

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

	@OneToMany
	public List<ProductoDeposito> productosDepositos;

	public static Model.Finder<Long,Producto> find = new Model.Finder<Long,Producto>(Long.class, Producto.class);

	public static  Producto cargarProductosDesdeRismi(Producto pr,List<Long> dominios){

		Producto p= null;
		try{

    		String codigo_rismi = (pr.codigo_rismi != null)?pr.codigo_rismi.toString():null;

    		p = Producto.find.where().eq("codigo_rismi",codigo_rismi).findUnique();

    		String nombre = (pr.nombre != null && !pr.nombre.isEmpty())?pr.nombre:p.nombre;
    		Integer tipoProductoId = (pr.tipo_producto_id != null)?pr.tipo_producto_id:(p.tipo_producto_id != null)?p.tipo_producto_id:2;
    		Integer categoriaId = (pr.categoria_id != null)?pr.categoria_id:(p.categoria_id != null)?p.categoria_id:14;
    		Integer articuloId = (pr.articulo_id != null)?pr.articulo_id:(p.articulo_id != null)?p.articulo_id:null;
    		Integer udmId = (pr.udm_id != null)?pr.udm_id:(p.udm_id != null)?p.udm_id:1;
    		Boolean activo = pr.activo;



    		if(udmId != null){
    			Udm u = Udm.find.byId(udmId.longValue());
    			if(u == null){
    				udmId = null;
    			}
    		}


    		if(articuloId != null){
    			Articulo a = Articulo.find.byId((long)articuloId);
    			if(a == null){
    				articuloId = 1537;
    			}
    		}

    		if(categoriaId != null){
    			Categoria c = Categoria.find.byId((long)categoriaId);
    			if(c == null){
    				categoriaId = 14;
    			}
    		}

    		if(p != null){
    			Logger.debug("UPDATE");
    			p.activo =  activo;
        		p.write_date =  new Date();
        		p.nombre = nombre;
        		p.slug = nombre.replace(" ", "").replace(".","").replace("-","").toUpperCase();
        		p.articulo_id = articuloId;
        		p.categoria_id = categoriaId;
        		p.tipo_producto_id = tipoProductoId;
        		p.udm_id = udmId;
        		p.write_date = new Date();
        		p.cuenta_ingreso_id = ID_CUENTA_INGRESO.intValue();
        		p.cuenta_gasto_id = ID_CUENTA_GASTO.intValue();
        		p.update();
    		}else{

    			p = Producto.find.where().ilike("nombre",nombre.replace("%", "\\%")).setMaxRows(1).findUnique();

    			if(p != null){
    				Logger.debug("UPDATE POR NOMBRE");
    				p.activo =  activo;
            		p.write_date =  new Date();
            		p.nombre = nombre;
            		p.slug = nombre.replace(" ", "").replace(".","").replace("-","").toUpperCase();
            		p.articulo_id = articuloId;
            		p.categoria_id = categoriaId;
            		p.tipo_producto_id = tipoProductoId;
            		p.udm_id = udmId;
            		p.write_date = new Date();
            		p.cuenta_ingreso_id = ID_CUENTA_INGRESO.intValue();
            		p.cuenta_gasto_id = ID_CUENTA_GASTO.intValue();
            		p.codigo_rismi = codigo_rismi;
            		p.update();
    			}else{
	    			Logger.debug("INSERT");
	    			Producto p2 = new Producto();
	    			p2.activo =  activo;
	        		p2.create_date =  new Date();
	        		p2.nombre = nombre;
	        		p2.slug = nombre.replace(" ", "").replace(".","").replace("-","").toUpperCase();
	        		p2.articulo_id = articuloId;
	        		p2.categoria_id = categoriaId;
	        		p2.tipo_producto_id = tipoProductoId;
	        		p2.udm_id = udmId;
	        		p2.cuenta_ingreso_id = ID_CUENTA_INGRESO.intValue();
	        		p2.cuenta_gasto_id = ID_CUENTA_GASTO.intValue();
	        		p2.codigo_rismi = codigo_rismi;
	    			p2.save();
	    			p= p2;
    			}
    		}

    		List<ProductoDeposito> pd = ProductoDeposito.find.where().eq("producto_id", p.id).findList();
    		for(ProductoDeposito pdx : pd){
    			pdx.delete();
    		}


    		for(Long x : dominios){
    			Long idDeposito = x;
    			if(idDeposito.compareTo(new Long(3)) == 0){
					idDeposito = (long) 25;
				}else if(idDeposito.compareTo(new Long(6)) == 0){
					idDeposito = (long) 3;
				}else if(idDeposito.compareTo(new Long(15)) == 0){
					idDeposito = (long) 30;
				}else if(idDeposito.compareTo(new Long(22)) == 0){
					idDeposito = (long) 32;
				}else if(idDeposito.compareTo(new Long(25)) == 0){
					idDeposito = (long) 37;
				}else if(idDeposito.compareTo(new Long(16)) == 0){
					idDeposito = (long) 31;
				}else if(idDeposito.compareTo(new Long(27)) == 0){
					idDeposito = (long) 38;
				}else if(idDeposito.compareTo(new Long(20)) == 0){
					idDeposito = (long) 39;
				}else if(idDeposito.compareTo(new Long(24)) == 0){
					idDeposito = (long) 40;
				}else if(idDeposito.compareTo(new Long(23)) == 0){
					idDeposito = (long) 41;
				}else if(idDeposito.compareTo(new Long(26)) == 0){
					idDeposito = (long) 42;
				}else if(idDeposito.compareTo(new Long(19)) == 0){
					idDeposito = (long) 35;
				}else if(idDeposito.compareTo(new Long(17)) == 0){
					idDeposito = (long) 43;
				}else if(idDeposito.compareTo(new Long(18)) == 0){
					idDeposito = (long) 44;
				}else if(idDeposito.compareTo(new Long(82)) == 0){
					idDeposito = (long) 34;
				}else {
					idDeposito = (long) 1;
				}


    			ProductoDeposito pdi = new ProductoDeposito();
    			pdi.producto_id = p.id;
    			pdi.deposito_id = idDeposito;
    			pdi.save();
    		}


    	}catch(Exception e){
    		Logger.debug("------------------------------ "+e);
    	}


		return p;

	}

	public List<Producto> getDataSuggest(String input,Integer limit){
		ExpressionList<Producto> l = find.where().eq("activo", true).ilike("nombre", "%"+input+"%");

		if(Usuario.getUsurioSesion().organigrama_id != null && Usuario.getUsurioSesion().organigrama_id.compareTo(new Long(90)) == 0){
			l= l.disjunction();
			l= l.eq("categoria_id", 20);
			l= l.eq("categoria_id", 21);
			l= l.eq("categoria_id", 24);
			l= l.endJunction();
		}

		List<Producto>	r =	l.setMaxRows(limit).orderBy("nombre").findList();

		return r;
	}

	public List<Producto> getDataSuggestSolicitud(String input,Integer limit,Long idDeposito){
		ExpressionList<Producto> l = find.where().eq("activo", true).ilike("nombre", "%"+input+"%");

		if(Usuario.getUsurioSesion().organigrama_id != null && Usuario.getUsurioSesion().organigrama_id.compareTo(new Long(90)) == 0){
			l= l.disjunction();
			l= l.eq("categoria_id", 20);
			l= l.eq("categoria_id", 21);
			l= l.eq("categoria_id", 24);
			l= l.endJunction();
		}

		//l.in("productosDepositos.deposito_id", idDeposito);

		List<Producto>	r =	l.setMaxRows(limit).orderBy("nombre").findList();

		return r;
	}

	public static Pagination<Producto> page(String nombre,String categoria_id) {
    	Pagination<Producto> p = new Pagination<Producto>();
    	p.setOrderDefault(" ");
    	p.setSortByDefault("id DESC,nombre ASC");

    	ExpressionList<Producto> e = find.where();

    	if(!nombre.isEmpty()){
    		e.ilike("nombre", "%" + nombre + "%");
    	}

    	if(!categoria_id.isEmpty()){
    		e.eq("categoria_id", Integer.parseInt(categoria_id));
    	}

    	p.setExpressionList(e);
    	return p;
    }
}
