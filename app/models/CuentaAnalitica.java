package models;

import java.util.ArrayList;
import java.util.Arrays;
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
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlRow;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity 
@Table(name = "cuentas_analiticas")
public class CuentaAnalitica extends Model {
	private static final long serialVersionUID = 1L;
	public static String BIENES_CONSUMO_NOMBRE = "BIENES DE CONSUMO";
	public static Integer BIENES_CONSUMO_ID = 50;
	public static String FALTA_ASIGNAR_PARTIDA_NOMBRE = "Falta Asignar Partida";
	public static Integer FALTA_ASIGNAR_PARTIDA_ID = 11;
	public static Integer ARANCELAMIENTO_ID = 478;
	public static String ARANCELAMIENTO = "ARANCELAMIENTO LEY XVII N 17";
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cuenta_analiticas_id_seq")
	public Long id;
	@Required(message="Nombre requerido")
	public String nombre;
	@Required(message="Cuenta padre requerida")
	public Long parent_id;
	@Required(message="Código requerido")
	public String codigo;
	public String tipo_partida;
	public Boolean ejecutable = false;
	public Boolean carga_credito = false;
	@OneToOne(fetch=FetchType.EAGER, optional=true)
	@JoinColumn(insertable=false, updatable=false, name="parent_id")
	public CuentaAnalitica padre;
	
	@ManyToOne
	@JoinColumn(name="cuenta_reporta_id", referencedColumnName="id", insertable=false, updatable=false)
	public CuentaAnalitica cuentaReporta; 
	@Column(name="cuenta_reporta_id")
	public Long cuenta_reporta_id;
	
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
	
	public static Finder<Long,CuentaAnalitica> find = new Finder<Long,CuentaAnalitica>(Long.class, CuentaAnalitica.class);
	
	public List<CuentaAnalitica> getDataSuggest(String input,Integer limit){
		List<CuentaAnalitica> l = find.where()
				.disjunction()
				.ilike("nombre", "%"+input+"%")
				.ilike("codigo", "%"+input+"%")
				.endJunction()
				.setMaxRows(limit).orderBy("orden,nombre")
			    .findList();  

		return l;
	}
	
	public static List<Integer> getCuentasAnaliticasServicios(){
		List<Integer>  lu = new ArrayList<Integer>(); 
		
		String sql = " WITH RECURSIVE recursetree AS (  "+
			    " SELECT d.id,d.parent_id,d.nombre  "+
			    " FROM cuentas_analiticas d "+ 
			    " WHERE parent_id NOT IN (50,164,260,275) "+
				" UNION ALL "+
			    " SELECT c.id,c.parent_id,c.nombre "+
			    " FROM recursetree t , cuentas_analiticas AS c "+
			    " WHERE c.parent_id = t.id )"+
			    " SELECT * FROM recursetree; ";
		
		List<SqlRow> s = Ebean.createSqlQuery(sql).findList();
		for(SqlRow m : s){
			lu.add(new Integer(m.getString("id")));
		}
		
		return lu;
	}
	
	public static List<Integer> getCuentasAnaliticasBienes(){
		List<Integer>  lu = new ArrayList<Integer>(); 
		
		String sql = " WITH RECURSIVE recursetree AS (  "+
			    " SELECT d.id,d.parent_id,d.nombre  "+
			    " FROM cuentas_analiticas d "+ 
			    " WHERE parent_id IN (50,164,260,275) "+
				" UNION ALL "+
			    " SELECT c.id,c.parent_id,c.nombre "+
			    " FROM recursetree t , cuentas_analiticas AS c "+
			    " WHERE c.parent_id = t.id )"+
			    " SELECT * FROM recursetree; ";
		
		List<SqlRow> s = Ebean.createSqlQuery(sql).findList();
		lu.add(new Integer(50));
		lu.add(new Integer(164));
		lu.add(new Integer(260));
		lu.add(new Integer(275));
		for(SqlRow m : s){
			lu.add(new Integer(m.getString("id")));
		}
		
		return lu;
	}
	
	public static List<Integer> getCuentasAnaliticasHijas(Integer cuentaId){
		
		List<Integer>  lu = new ArrayList<Integer>(); 
		String sql = " WITH RECURSIVE recursetree AS (  "+
			    " SELECT d.id,d.parent_id,d.nombre  "+
			    " FROM cuentas_analiticas d "+ 
			    " WHERE parent_id = :cuentaId "+
				" UNION ALL "+
			    " SELECT c.id,c.parent_id,c.nombre "+
			    " FROM recursetree t , cuentas_analiticas AS c "+
			    " WHERE c.parent_id = t.id )"+
			    " SELECT * FROM recursetree; ";
		
				
		
		
		List<SqlRow> s = Ebean.createSqlQuery(sql)
				.setParameter("cuentaId", cuentaId)
				.findList();
		for(SqlRow m : s){
			lu.add(new Integer(m.getString("id")));
		}
		
		return lu;
	}
	
	public static List<Integer> getCuentasParaInventario() {
		return Arrays.asList(
				218,217,272,560,624,665,706,//BIENES DE CAPITAL
				201,202,206,204,205,203,207,//EQUIPAMIENTO (PROFE)
				456,458,459,460,461,462,457,//EQUIPAMIENTO (IGH)
				106,109,107,108,111,110,34,//EQUIPAMIENTO
				561,564,566,567,565,562,563,//EQUIPAMIENTO (PTM)
				582,583,584,585,586,587,588,//EQUIPAMIENTO(PLAN SUMAR)
				625,626,627,628,629,630,631,//EQUIPAMIENTO (LACMI)
				666,667,668,669,670,671,672,//EQUIPAMIENTO (FATIMA)
				707,710,711,709,712,708,713,//EQUIPAMIENTO (JME)
				726,783,784,785,786,787,788,//EQUIPAMIENTO(PLAN SUMAR FATIMA
				730,777,778,779,780,781,782//EQUIPAMIENTO(PLAN SUMAR LACMI
				);
	}
 
	public static List<Integer> getCuentasProfe() {
		return Arrays.asList(144,146,200,217,163,164,145,199,201,356,377,143,175,230,
				62,72,63,64,167,165,166,418,70,77,73,65,68,69,71,174,172,173,168,169,170,171,202,206,204,205,203,207,233);
	}

	
	
	public static Boolean isCuentasAnliticasHijas(Long id) {
		boolean r = true;
		
		String sql = " SELECT parent_id FROM cuentas_analiticas WHERE parent_id = :id ";
		
		List<SqlRow> s = Ebean.createSqlQuery(sql)
				.setParameter("id",id)		
				.findList();
		
		String sql1 = " SELECT id FROM cuentas_analiticas WHERE id = :id AND id = cuenta_reporta_id ";
		
		List<SqlRow> s1 = Ebean.createSqlQuery(sql1)
				.setParameter("id",id)		
				.findList();

		
		if(s.size() > 0 || s1.size() > 0){
			r = false;
		}
		
		return r;
	}
	
}
