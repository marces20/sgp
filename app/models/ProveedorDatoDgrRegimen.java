package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity 
@Table(name = "proveedor_datos_dgr_regimen")
public class ProveedorDatoDgrRegimen extends Model{
	
	private static final long serialVersionUID = 1L;

	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="proveedor_datos_dgr_motivo_id_seq")
	public Long id;
	
	@Required(message="Debe escribir un descripcion")
	public String descripcion;
	
	@Required(message="Debe escribir un motivo")
	public Integer regimen;
	
	public static Model.Finder<Long,ProveedorDatoDgrRegimen> find = new Model.Finder<Long,ProveedorDatoDgrRegimen>(Long.class, ProveedorDatoDgrRegimen.class);

	
	
}

