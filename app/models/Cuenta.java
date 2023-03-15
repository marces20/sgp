package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity 
@Table(name = "cuentas")
public class Cuenta extends Model{
	private static final long serialVersionUID = 1L;
	
	public static Long[] CUENTAS_INACTIVAS = {new Long(284),new Long(281),new Long(108),new Long(282),new Long(264)};
	
	public static long RET_DGR_SELLOS = 263;
	public static long RET_DGR_SELLOS_ART21 = 540;
	public static long RET_DGR_SELLOS_ART22 = 541;
	public static long RET_IIBB = 110;
	public static long RET_IIBB_331 = 276;
	public static long RET_IIBB_370 = 261;
	public static long RET_SEGURIDAD = 109;
	public static long RET_LIMPIEZA = 260;
	public static long RET_REGGRAL = 259;
	public static long RET_SUSS1 = 277;
	public static long RET_GCIAS = 108;
	public static long RET_GCIAS_3884 = 281;
	public static long RET_GCIAS_4245 = 284;
	public static long RET_GCIAS_4245_ANEXO = 565;
	public static long RET_GCIAS_4245_19 = 544;
	public static long RET_SUSS_2682_09 = 545;//SUSS 2.5% Res AFIP 2682/09
	public static long RET_SUSS_3883 = 282;
	public static long RET_MUNICIPAL_DERECHO_INSPECCION = 283;
	public static long RET_IVA = 258;
	public static String OTROS_INGRESOS = "OTROS INGRESOS";
	public static Integer OTROS_INGRESOS_ID = 226;
	
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cuentas_id_seq")
	public Long id;
	@Required(message="Debe escribir un nombre")
	public String nombre;
	@Required(message="Debe escribir un Codigo")
	public String code;
	
	@Required
	public Long parent_id;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(insertable=false, updatable=false, name="parent_id")
	public Cuenta padre;
	
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
	
	public static Model.Finder<Long,Cuenta> find = new Finder<Long,Cuenta>(Long.class, Cuenta.class);
	
	public static List<Cuenta> getHijos(Long id){
		return Cuenta.find.order("code").where().eq("parent_id", id).findList();
	}
	
	public static List<Cuenta> getHijos(){
		return Cuenta.find.order("code").where()
				.isNull("parent_id")
				.findList();
	}
	
	public List<Cuenta> getDataSuggest(String input,Integer limit){
		List<Cuenta> l = find.where()
				.ilike("nombre", "%"+input+"%")
				.setMaxRows(limit).orderBy("nombre")
			    .findList();  
		
		return l;
	}
}
