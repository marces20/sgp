package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlUpdate;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
@Entity 
@Table(name = "facturas_motivos_rechazos")
public class FacturaMotivoRechazo extends Model{
	
	private static final long serialVersionUID = 1L;
	@Id  														 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="facturas_motivos_rechazos_id_seq")
	public Long id;
	
	@Required(message="Requiere descripcion")
	public String descripcion;
	
	public static Model.Finder<Long,FacturaMotivoRechazo> find = new Model.Finder<Long,FacturaMotivoRechazo>(Long.class, FacturaMotivoRechazo.class);
	
	public static List<FacturaMotivoRechazo> getFacturaMotivoRechazo(){	
		return FacturaMotivoRechazo.find.findList();
	}
	
	public static Integer delete(List<Integer> idsfactura){
		
		SqlUpdate update = Ebean.createSqlUpdate("DELETE FROM facturas_rechazos WHERE factura_id IN (:ids)");
		update.setParameter("ids", idsfactura);
		
		return update.execute();
	}
}
