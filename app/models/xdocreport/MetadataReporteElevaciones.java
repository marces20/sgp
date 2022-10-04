package models.xdocreport;

import java.util.ArrayList;
import java.util.List;

public class MetadataReporteElevaciones {
	private String orden;
	private String nombre;
	private String cuit;
	private String subTotal;
	private String subDescuento;
	private List<MetadataReporteElevacionesProductos> productos;
	
	public MetadataReporteElevaciones() {
		this.productos = new ArrayList<MetadataReporteElevacionesProductos>();
	}
	
	public MetadataReporteElevaciones(String orden, String nombre, String cuit,String subTotal,String subDescuento) {
		this.orden = orden;
		this.nombre = nombre;
		this.cuit = cuit;
		this.subTotal = subTotal;
		this.subDescuento = subDescuento;
		this.productos = new ArrayList<MetadataReporteElevacionesProductos>();
	}
	
	public String getOrden() {
	    return orden;
	}
	public String getNombre() {
	    return nombre;
	}
	public String getCuit() {
	    return cuit;
	}
	public String getSubTotal() {
	    return subTotal;
	}
	public String getSubDescuento() {
	    return subDescuento;
	}
	public void setOrden(String v) {
	    orden = v;
	}
	public void setNombre(String v) {
	    nombre = v;
	}
	public void setCuit(String v) {
	    cuit = v;
	}
	public void setSubTotal(String v) {
	    subTotal = v;
	}
	
	public void setSubDescuento(String v) {
	    subDescuento = v;
	}
	
	public MetadataReporteElevaciones addMetadataReporteElevacionesProductos(MetadataReporteElevacionesProductos mp) {
		productos.add(mp);
		return this;
	}
	
	public List<MetadataReporteElevacionesProductos> getProductos() {
		return productos;
	}
}
