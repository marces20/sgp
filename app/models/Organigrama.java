package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Expr;
import com.avaje.ebean.Query;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
@Table(name = "organigramas")
public class Organigrama extends Model {
	private static final long serialVersionUID = 1L;
	
	public static final long TESORERIA = 71;
	public static final long CONTABILIDAD = 72;
	public static final long RENDICIONES = 116;
	public static final long HEARM = 1;
	public static final long MINISTERIO_SALUD = 109;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="organigramas_id_seq")
    public Integer id;
	
	@Required(message="Debe escribir el nombre")
	public String nombre;
	
	public String color;
	
	@ManyToOne
	@JoinColumn(name="padre_id", referencedColumnName="id", insertable=false, updatable=false)
	public Organigrama organigramaPadre; 
	@Column(name="padre_id")
	public Long padre_id;
	
	@ManyToOne
	@JoinColumn(name="tipo_id", referencedColumnName="id", insertable=false, updatable=false)
	public OrganigramaTipo tipoOrganigrama; 
	public Long tipo_id;
	
	@Column(name="circuito_expediente")
	public boolean circuitoExpediente;
	
	@ManyToOne
	@JoinColumn(name="deposito_id", referencedColumnName="id", insertable=false, updatable=false)
	public Deposito deposito;
	@Required(message="Requiere una Institucion")
	public Long deposito_id;
	
	public static Model.Finder<Long,Organigrama> find = new Model.Finder<Long,Organigrama>(Long.class, Organigrama.class);
	
	public List<Organigrama> getDataSuggest(String input,Integer limit){
		
		Query<Organigrama> subQuery =   
	       	    Ebean.createQuery(Organigrama.class)  
	       	        .select("padre_id")  
	       	        .where()
	       	        .isNotNull("padre_id")
	       	        .ne("padre_id", 1)
	       	        .query();
	       	 		
		
		
		List<Organigrama> l = find.where()
				.ilike("nombre", "%"+input+"%")
				//.not(Expr.in("id",subQuery) )
				.setMaxRows(limit).orderBy("nombre")
			    .findList();  
		return l;
	}
	
	  
	
}
