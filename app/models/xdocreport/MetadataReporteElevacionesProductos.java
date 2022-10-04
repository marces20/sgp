package models.xdocreport;

public class MetadataReporteElevacionesProductos {

	private final String nombre;
	private final String cantidad;
	private final String precio;

	public MetadataReporteElevacionesProductos(String nombre,String cantidad,String precio) {
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
	}
	
	public String getNombre() {
		return nombre;
	}
	public String getCantidad() {
		return cantidad;
	}
	public String getPrecio() {
		return precio;
	}
}
