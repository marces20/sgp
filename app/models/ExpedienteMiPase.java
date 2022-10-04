package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.Query;
import com.avaje.ebean.RawSql;
import com.avaje.ebean.RawSqlBuilder;
import com.avaje.ebean.SqlRow;
import com.avaje.ebean.annotation.Sql;

import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.DateUtils;
import utils.pagination.Pagination;

@Entity
@Sql
public class ExpedienteMiPase extends Model {
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario usuario; 
	@Column(name="usuario_id")
	public Long usuario_id;
	
	@ManyToOne
	@JoinColumn(name="organigrama_id", referencedColumnName="id", insertable=false, updatable=false)
	public Organigrama organigrama; 
	@Column(name="organigrama_id")
	@Required(message="Debe seleccionar un departamento/servicio")
	public Long organigrama_id;
	
	@Formats .DateTime(pattern="dd/MM/yyyy hh:mm:ss")
	public Date fecha_llegada;
	
	public Integer codigo;
	
	public List<SqlRow> getExpedienteMiPases(){
		
		String sql = "SELECT e.nombre||'/'||ej.nombre nombreExpediente " +
				"FROM expedientes_movimientos em " +
				"INNER JOIN expedientes e ON e.id = em.expediente_id " +
				"INNER JOIN ejercicios ej ON ej.id = e.ejercicio_id " +
				"WHERE codigo = :codigo ";
				
		List<SqlRow> s = Ebean.createSqlQuery(sql)
				   .setParameter("codigo", codigo)
				   .findList();
		
		return s;
	}
	
	
	public static Query<ExpedienteMiPase> getQuery() {
    	RawSql rawSql;
    	
    	rawSql = RawSqlBuilder.parse("SELECT usuario_id, organigrama_id, codigo, fecha_llegada " + 
    								 " FROM expedientes_movimientos " +
    								 " WHERE cancelado <> TRUE " + 
    								 " GROUP BY usuario_id, organigrama_id, codigo, fecha_llegada ")
    								 .columnMapping("usuario_id", "usuario.id")
    								 .columnMapping("organigrama_id", "organigrama.id")
    								 .columnMapping("codigo", "codigo")
    								 .columnMapping("fecha_llegada", "fecha_llegada")
    								 .create();
    	
    	return Ebean.find(ExpedienteMiPase.class).setRawSql(rawSql);
	}
	
	public List<ExpedienteMiPase> getLineas() {
		ExpressionList<ExpedienteMiPase> e = getQuery().where();
		return e.findList();
	}
	
	public static Finder<Long,ExpedienteMiPase> find = new Finder<Long,ExpedienteMiPase>(Long.class, ExpedienteMiPase.class);
	
	public static Pagination<ExpedienteMiPase> page(String usuario_id,String organigrama_id,String fecha_desde,String fecha_hasta) {
		Pagination<ExpedienteMiPase> p = new Pagination<ExpedienteMiPase>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("fecha_llegada");

    	ExpressionList<ExpedienteMiPase> e = getQuery().where();
    	    	
    	if(!organigrama_id.isEmpty()) {
    		e.eq("organigrama_id", Integer.parseInt(organigrama_id));
    	}
    	
    	System.out.println("11111111 "+fecha_desde);
    	
    	if(!fecha_desde.isEmpty()){
    		Date ffcd = DateUtils.formatDate(fecha_desde+" 00:00:00", "dd/MM/yyyy HH:mm:ss");
    		System.out.println("222222222222 "+ffcd);
    		e.ge("fecha_llegada", ffcd);
    	}
    	
		if(!fecha_hasta.isEmpty()){
    		Date ffch = DateUtils.formatDate(fecha_hasta+" 23:59:59", "dd/MM/yyyy HH:mm:ss");
    		e.le("fecha_llegada", ffch);
    	}
    	
    	if(!usuario_id.isEmpty()) {
    		e.eq("usuario.id", Integer.parseInt(usuario_id));
    	}
    	
    	p.setExpressionList(e);
    	p.parcheCountAllFormula = true;
		p.setTotalRowCount(e.findList().size());
    	
    	return p;
    	
	}
}
