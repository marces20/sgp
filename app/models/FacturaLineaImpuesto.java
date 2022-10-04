package models;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.avaje.ebean.ExpressionList;

import play.Logger;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import server.Configuracion2;
import utils.DateUtils;
import utils.NumeroALetra;
import utils.formatters.DecimalComa;
import utils.pagination.Pagination;

@Entity 
@Table(name = "factura_linea_impuestos")
public class FacturaLineaImpuesto extends Model{
	
	public static final BigDecimal MONTO_CALCULO_NETO = new BigDecimal(1.21);
	public static final BigDecimal MONTO_ALICUOTA_10 = new BigDecimal(1.105); 
	public static final BigDecimal MONTO_GANANCIAS = new BigDecimal(0.02);
	//public static final BigDecimal MONTO_GANANCIAS_BIENES_4245 = new BigDecimal(142400);
	//public static final BigDecimal MONTO_GANANCIAS_SERVICIOS_4245 = new BigDecimal(42700);
	//public static final BigDecimal MONTO_GANANCIAS_SERVICIOS_AGENTES_4245 = new BigDecimal(10700);
	
	public static final BigDecimal MONTO_GANANCIAS_BIENES_4245_19 = new BigDecimal(224000);
	public static final BigDecimal MONTO_GANANCIAS_SERVICIOS_4245_19 = new BigDecimal(67170);
	public static final BigDecimal MONTO_GANANCIAS_SERVICIOS_AGENTES_4245_19 = new BigDecimal(16830);
	
	//public static final BigDecimal MONTO_GANANCIAS_BIENES_3884 = new BigDecimal(100000);
	//public static final BigDecimal MONTO_GANANCIAS_SERVICIOS_3884 = new BigDecimal(30000);
	
	public static final BigDecimal MONTO_SELLOS = new BigDecimal(0.005);
	public static final BigDecimal MONTO_SUSS = new BigDecimal(0.01);
	public static final BigDecimal MONTO_SUSS_LIMPIEZA = new BigDecimal(0.06);
	public static final BigDecimal MONTO_SUSS_SEGURIDAD = new BigDecimal(0.06);
	public static final BigDecimal MONTO_SUSS_CONSTRUCTORA = new BigDecimal(0.025);
	
	public static final BigDecimal MONTO_MUNICIPAL_DERECHO_INSPECCION = new BigDecimal(0.007);
	
	public static final BigDecimal MONTO_DGR_CM = new BigDecimal(0.0196);
	public static final BigDecimal MONTO_DGR_DIRECTO= new BigDecimal(0);
	public static final BigDecimal MONTO_DGR_NO_CM= new BigDecimal(0.0331);
	public static final BigDecimal MONTO_IVA = new BigDecimal(0.0868);
	
	 
	//public static final BigDecimal MONTO_MINIMO_GANANCIAS_3884 = new BigDecimal(90);
	//public static final BigDecimal MONTO_MINIMO_GANANCIAS_4245 = new BigDecimal(150);
	public static final BigDecimal MONTO_MINIMO_GANANCIAS_4245_19 = new BigDecimal(240);
	public static final BigDecimal MONTO_MINIMO_SUSS_3883 = new BigDecimal(400);
	public static final BigDecimal MONTO_MINIMO_DGR = new BigDecimal(50);
	public static final BigDecimal MONTO_MINIMO_MUNICIPAL_DERECHO_INSPECCION = new BigDecimal(10000);
	
	public static final int TIPO_SERVICIOS = 1;
	public static final int TIPO_BIENES = 2;
	public static final int TIPO_SERVICIOS_AGENTES = 3;
	
	private static final long serialVersionUID = 1L;
	@Id  														 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="factura_linea_impuestos_id_seq")
	public Long id;
	
	@Required(message="Requiere monto")
	@DecimalComa(value="")
	public BigDecimal monto;
	
	@Required(message="Requiere Base")
	@DecimalComa(value="")
	public BigDecimal base;
	@Required(message="Requiere Descripcion")
	public String nombre;
	
	public Integer tipo;
	
	@ManyToOne
	@JoinColumn(name="cuenta_id", referencedColumnName="id", insertable=false, updatable=false)
	public Cuenta cuenta;
	@Required(message="Requiere Cuenta")
	public Long cuenta_id;
	
	@ManyToOne
	@JoinColumn(name="factura_id", referencedColumnName="id", insertable=false, updatable=false)
	public Factura factura;
	@Required(message="Debe tener una factura asociada")
	public Long factura_id;
	
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
	
	public String getMontoMoneda(){
		return  utils.NumberUtils.moneda(monto);
	}
	
	public String getMontoLetra(){
		return new NumeroALetra().convertNumberToLetter(String.valueOf(monto));
	}
	
	public String getBaseMoneda(){
		if(base != null){
			return  utils.NumberUtils.moneda(base);
		}else{
			return "";
		}
	}
	
	public String getBaseLetra(){
		if(base != null){
			return new NumeroALetra().convertNumberToLetter(String.valueOf(base));
		}else{
			return "";
		}
	}
	
	public BigDecimal getBase(){
		if (base == null)
			return new BigDecimal(0);
		return base;
	}
	
	public BigDecimal getBaseRetencionIIBB(){
		if (monto == null)
			return new BigDecimal(0);
		return monto.divide(new BigDecimal(0.0169), 2, RoundingMode.HALF_UP);
	}
	
	public BigDecimal getBaseRetencionIIBB370(){
		if (monto == null)
			return new BigDecimal(0);
		return monto.divide(new BigDecimal(0.0370), 2, RoundingMode.HALF_UP);
	}
	
	public BigDecimal getBaseRetencionSeguridad(){
		if (monto == null)
			return new BigDecimal(0);
		return monto.divide(new BigDecimal(0.06), 2, RoundingMode.HALF_UP);
	}
	
	public BigDecimal getBaseRetencionLimpieza(){
		if (monto == null)
			return new BigDecimal(0);
		return monto.divide(new BigDecimal(0.06), 2, RoundingMode.HALF_UP);
	}
	
	public BigDecimal getBaseRetencionReggral(){
		if (monto == null)
			return new BigDecimal(0);
		return monto.divide(new BigDecimal(0.02), 2, RoundingMode.HALF_UP);
	}
	
	public String  getFechaPago(){
		List<Pago> lp = Pago.find.where()
				//.eq("factura_id", facturasSeleccionados.get(0))
				.in("factura_id",factura_id)
				.ne("estado_id", Estado.PAGO_ESTADO_BORRADOR)
				.ne("estado_id",Estado.PAGO_ESTADO_CANCELADO)
				.eq("tipo","payment")
				.findList();
		
		if(lp.size() >0) {
			return  DateUtils.formatDate(lp.get(0).fecha_pago,"dd/MM/yyyy") ;
		}else  if(factura.fecha_orden_pago != null){
			return DateUtils.formatDate(factura.fecha_orden_pago,"dd/MM/yyyy") ;
		}else {
			return null;
		}
			
	}
	
	
	public static Model.Finder<Long,FacturaLineaImpuesto> find = new Finder<Long,FacturaLineaImpuesto>(Long.class, FacturaLineaImpuesto.class);
	
	public static Pagination<FacturaLineaImpuesto> page(Long facturaId) {    	
    	Pagination<FacturaLineaImpuesto> p = new Pagination<FacturaLineaImpuesto>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");
    	
    	p.setExpressionList(find.where().eq("factura_id", facturaId));
    	return p;
	}
	
	public static Long getSecuenciaSellos(){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Long ret = new Long(0);
		try {
			
			conn = play.db.DB.getConnection();
			
			stmt = conn.prepareStatement("SELECT nextval('retencion_sellos_id_seq')");
			 
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				ret = (long) rs.getInt(1);
			}
			
		}catch (SQLException e) {
			Logger.error("Error duplicar: "+e);
        } finally {
        	if (stmt != null) try { stmt.close(); } catch (Exception e) { }
        	if (rs != null) try { rs.close(); } catch (Exception e) { }
            if (conn != null) try { conn.close(); } catch (Exception e) { }
        }
		 
		return ret;
	}
	
	public static Long getSecuenciaGanancias(){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Long ret = new Long(0);
		try {
			
			conn = play.db.DB.getConnection();
			
			//stmt = conn.prepareStatement("SELECT nextval('retencion_ganacias_id_seq')");
			 
			stmt = conn.prepareStatement("select (max( cast(REPLACE(REPLACE(REPLACE(nombre, 'ganancias', '0' ), 'GCIAS', '0' ), 'GANANCIAS', '0' )as integer)) +1) as n  "
					+ "from factura_linea_impuestos where cuenta_id = ? or cuenta_id = ?");
			stmt.setLong(1, Cuenta.RET_GCIAS_4245);
			stmt.setLong(2, Cuenta.RET_GCIAS_4245_19);
			
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				ret = (long) rs.getInt(1);
			}
			
		}catch (SQLException e) {
			Logger.error("Error duplicar: "+e);
        } finally {
        	if (stmt != null) try { stmt.close(); } catch (Exception e) { }
        	if (rs != null) try { rs.close(); } catch (Exception e) { }
            if (conn != null) try { conn.close(); } catch (Exception e) { }
        }
		 
		return ret;
	}
	
	public static Long getSecuenciaIIBB(){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Long ret = new Long(0);
		try {
			
			conn = play.db.DB.getConnection();
			
			//stmt = conn.prepareStatement("SELECT nextval('retencion_ganacias_id_seq')");
			 
			stmt = conn.prepareStatement("select (max( cast(REPLACE(nombre, 'IIBB', '0' )as integer)) +1) as n "
					+ "from factura_linea_impuestos where cuenta_id = ? or cuenta_id = ? ");
			stmt.setLong(1, Cuenta.RET_IIBB);
			stmt.setLong(2, Cuenta.RET_IIBB_331);
			
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				ret = (long) rs.getInt(1);
			}
			
		}catch (SQLException e) {
			Logger.error("Error duplicar: "+e);
        } finally {
        	if (stmt != null) try { stmt.close(); } catch (Exception e) { }
        	if (rs != null) try { rs.close(); } catch (Exception e) { }
            if (conn != null) try { conn.close(); } catch (Exception e) { }
        }
		 
		return ret;
	}
	
	public static Long getSecuenciaIva(){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Long ret = new Long(0);
		try {
			
			conn = play.db.DB.getConnection();
			
			//stmt = conn.prepareStatement("SELECT nextval('retencion_ganacias_id_seq')");
			 
			stmt = conn.prepareStatement("select (max( cast(REPLACE(nombre, 'IVA', '0' ) as integer)) +1) as n "
					+ "from factura_linea_impuestos where cuenta_id = ? ");
			stmt.setLong(1, Cuenta.RET_IVA);
			
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				ret = (long) rs.getInt(1);
			}
			
		}catch (SQLException e) {
			Logger.error("Error duplicar: "+e);
        } finally {
        	if (stmt != null) try { stmt.close(); } catch (Exception e) { }
        	if (rs != null) try { rs.close(); } catch (Exception e) { }
            if (conn != null) try { conn.close(); } catch (Exception e) { }
        }
		 
		return ret;
	}
	
	public static Long getSecuenciaRetMunicipal(){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Long ret = new Long(0);
		try {
			
			conn = play.db.DB.getConnection();
			
			stmt = conn.prepareStatement("SELECT nextval('retencion_municipal_id_seq')");
			 
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				ret = (long) rs.getInt(1);
			}
			
		}catch (SQLException e) {
			Logger.error("Error duplicar: "+e);
        } finally {
        	if (stmt != null) try { stmt.close(); } catch (Exception e) { }
        	if (rs != null) try { rs.close(); } catch (Exception e) { }
            if (conn != null) try { conn.close(); } catch (Exception e) { }
        }
		 
		return ret;
	}
	
	public static BigDecimal preCalcularMontoNeto(Factura f,BigDecimal base,boolean isServicio,boolean isAgenteContratado,BigDecimal alicuota){
		
		BigDecimal rDescuento = new BigDecimal(0); 
		
		BigDecimal r1 =  preCalcularLlevaIva(base,f.proveedor.getLastAtributo().exento_iva,alicuota);
		
		 
		if(Factura.facturasDelMismoMes(f).size() == 0){
			if(isServicio){
				if(isAgenteContratado){
					rDescuento = MONTO_GANANCIAS_SERVICIOS_AGENTES_4245_19;
				}else {
					rDescuento = MONTO_GANANCIAS_SERVICIOS_4245_19;
				}
			}else{
				rDescuento = MONTO_GANANCIAS_BIENES_4245_19;
			}
		}
		
		return r1.subtract(rDescuento).setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	
	public static BigDecimal preCalcularLlevaIva(BigDecimal monto,boolean exento,BigDecimal alicuota){
		if(exento || alicuota == null){
			return monto.setScale(2, BigDecimal.ROUND_HALF_UP);
		}else{
			return monto.divide(alicuota, 2, RoundingMode.HALF_UP).setScale(2, BigDecimal.ROUND_HALF_UP);
		}
	}
	
	public static BigDecimal preCalcularMontoNetoRetMunicipal(BigDecimal monto){
		return monto.divide(MONTO_CALCULO_NETO, 2, RoundingMode.HALF_UP).setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	
	public static BigDecimal preCalcularMontoSinIva(Factura f,BigDecimal alicuota){
		 return preCalcularLlevaIva(f.getBase(),f.proveedor.getLastAtributo().exento_iva,alicuota);
	}
	
	public static BigDecimal preCalcularGanacias(BigDecimal base){
		return base.multiply(MONTO_GANANCIAS).setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	
	public static BigDecimal preCalcularSellos(Factura f){
		BigDecimal r = new BigDecimal(0);
		
		if(Factura.facturasConSellosMismaOrden(f).size() == 0 && f.orden != null && f.orden.tipo_moneda == null){
			r = f.orden.getTotal().multiply(MONTO_SELLOS).setScale(2, BigDecimal.ROUND_HALF_UP);
		//}else if(Factura.facturasConSellosMismaOrden(f).size() == 0 && f.produccion != null && f.produccion){
		}else if((f.produccion != null && f.produccion) || (f.orden.tipo_moneda != null) ){
			r = f.getBase().multiply(MONTO_SELLOS).setScale(2, BigDecimal.ROUND_HALF_UP);
		}
		
		return r;
	}
	
	public static BigDecimal preCalcularSuss(Factura f,BigDecimal alicuota){
		return preCalcularMontoSinIva(f,alicuota).multiply(MONTO_SUSS).setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	
	public static BigDecimal preCalcularSussLimpieza(Factura f,BigDecimal alicuota){
		return preCalcularMontoSinIva(f,alicuota).multiply(MONTO_SUSS_LIMPIEZA).setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	
	public static BigDecimal preCalcularSussSeguridad(Factura f,BigDecimal alicuota){
		return preCalcularMontoSinIva(f,alicuota).multiply(MONTO_SUSS_SEGURIDAD).setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	
	public static BigDecimal preCalcularSussConstructora(Factura f,BigDecimal alicuota){
		return preCalcularMontoSinIva(f,alicuota).multiply(MONTO_SUSS_CONSTRUCTORA).setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	
	public static BigDecimal preCalcularDgrCm(Factura f,BigDecimal alicuota){
		if(f.proveedor.getLastAtributo().afip_condicion == 1) {
			return f.getBase().multiply(MONTO_DGR_CM).setScale(2, BigDecimal.ROUND_HALF_UP);
		}else {
			return preCalcularMontoSinIva(f,alicuota).multiply(MONTO_DGR_CM).setScale(2, BigDecimal.ROUND_HALF_UP);
		}
		
	}
	
	public static BigDecimal preCalcularDgrDirecto(Factura f,BigDecimal alicuota){
		return preCalcularMontoSinIva(f,alicuota).multiply(MONTO_DGR_DIRECTO).setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	
	public static BigDecimal preCalcularDgrNoCm(Factura f,BigDecimal alicuota){
		return preCalcularMontoSinIva(f,alicuota).multiply(MONTO_DGR_NO_CM).setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	
	public static BigDecimal preCalcularIva(Factura f){
		return f.base.multiply(MONTO_IVA).setScale(2, BigDecimal.ROUND_HALF_UP);
	}
}
