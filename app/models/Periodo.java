package models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlRow;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import utils.DateUtils;
import utils.pagination.Pagination;

@Entity
@Table(name = "periodos")
public class Periodo extends Model{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="periodos_id_seq")
	public Long id;
	@Required(message="Debe escribir un nombre")
	public String nombre;
	public Date date_start;
	public Date date_stop;

	public String mes;

	public BigDecimal patronal_obrasocial_porcentaje;
	public BigDecimal patronal_jubilacion_porcentaje;

	@ManyToOne
	public Ejercicio ejercicio;

	@ManyToOne
	public Usuario create_usuario;
	public Date create_date;
	public Date write_date;
	@ManyToOne
	public Usuario write_usuario;

	public BigDecimal getPatronalObraSocialPorcentaje() {
		return patronal_obrasocial_porcentaje;
	}

	public BigDecimal getPatronalJubilacionPorcentaje() {
		return patronal_jubilacion_porcentaje;
	}

	public Integer getMesPeriodo() {
		System.out.println(nombre.split("\\/")[0]);
		return Integer.parseInt(nombre.split("\\/")[0]);
	}

	public String getMesAnioStringPeriodo() {
		String ret ="";

		ret += mes+" de ";

		ret += nombre.split("\\/")[1];

		return ret;
	}

	public Integer getAnioPeriodo() {
		return Integer.parseInt(nombre.split("\\/")[1]);
	}

	public static Periodo getPeriodoByDate(Date f){

		String fecha = DateUtils.formatDate(f, "MM-yyyy");

		String sql = "SELECT id FROM periodos " +
					 "WHERE to_char(date_start,'MM-yyyy') = :fecha ";

		SqlRow s = Ebean.createSqlQuery(sql)
				  .setParameter("fecha",fecha)
				  .findUnique();
		if(s.getLong("id") != null){
			return Periodo.find.byId(s.getLong("id"));
		}else{
			return null;
		}
	}

	public static List<Integer> getPeriodoAtras(Periodo p,int limit){



		String sql = "SELECT id FROM periodos " +
					 "WHERE id <= :id  order by id desc LIMIT :limit";

		List<SqlRow> s = Ebean.createSqlQuery(sql).setParameter("id",p.id).setParameter("limit",limit).findList();

		List<Integer> idsReturn = new ArrayList<Integer>();
		if(s.size() >0 ){

			for(SqlRow ss :s) {
				idsReturn.add(ss.getLong("id").intValue());
			}


			return idsReturn;
		}else{
			return null;
		}
	}

	public static Model.Finder<Long,Periodo> find = new Finder<Long,Periodo>(Long.class, Periodo.class);

	public List<Periodo> getDataSuggest(String input,Integer limit){
		List<Periodo> l = find.where()
				.ilike("nombre", "%"+input+"%")
				.setMaxRows(limit).orderBy("nombre")
				.order("ejercicio_id desc")
			    .findList();

		return l;
	}

	public static Pagination<Periodo> page(String nombre) {
    	Pagination<Periodo> p = new Pagination<Periodo>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");

    	p.setExpressionList(
    			find.where()
                .ilike("nombre", "%" + nombre + "%")
	            );
    	return p;
    }
}
