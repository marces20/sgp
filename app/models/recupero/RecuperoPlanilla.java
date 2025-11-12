package models.recupero;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.avaje.ebean.Expr;
import com.avaje.ebean.ExpressionList;

import models.Deposito;
import models.Ejercicio;
import models.Expediente;
import models.Feriado;
import models.Periodo;
import models.PuntoVenta;
import models.Usuario;
import models.auth.Permiso;
import play.Logger;
import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.DateUtils;
import utils.pagination.Pagination;

@Entity
@Table(name = "recupero_planillas")
public class RecuperoPlanilla extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="recupero_planillas_id_seq")
	public Long id;

	@Required(message="Debe escribir un numero")
	public Integer numero;

	@Transient
	public String recuperoPlanillaEjercicio;

	@ManyToOne
	@JoinColumn(name="deposito_id", referencedColumnName="id", insertable=false, updatable=false)
	public Deposito deposito;
	@Required(message="Requiere una Institucion")
	public Long deposito_id;

	@ManyToOne
	@JoinColumn(name="expediente_id", referencedColumnName="id", insertable=false, updatable=false)
	public Expediente expediente;
	@Required(message="Seleccion Expediente")
	public Integer expediente_id;

	@Required(message="Debe escribir una fecha")
	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha;

	public static Model.Finder<Long,RecuperoPlanilla> find = new Finder<Long,RecuperoPlanilla>(Long.class, RecuperoPlanilla.class);

	public static Pagination<RecuperoPlanilla> page(String numero,
													String expediente_id,
													String fecha_desde,
													String fecha_hasta,
													String deposito){
		Pagination<RecuperoPlanilla> p = new Pagination<RecuperoPlanilla>();
    	p.setOrderDefault("DESC");
    	p.setSortByDefault("id");

    	ExpressionList<RecuperoPlanilla> e = find.where();
    	if(!numero.isEmpty()) {
    		e.eq("numero",  Integer.parseInt(numero));

    	}

    	if(!fecha_desde.isEmpty()){
    		Date fd = DateUtils.formatDate(fecha_desde, "dd/MM/yyyy");
    		e.ge("fecha", fd);
    	}

		if(!fecha_hasta.isEmpty()){
    		Date fh = DateUtils.formatDate(fecha_hasta, "dd/MM/yyyy");
    		e.le("fecha", fh);
    	}

    	if(!deposito.isEmpty()) {
    		e.eq("deposito_id", Integer.parseInt(deposito));
    	}

    	if(!Permiso.check("verTodoRecupero")){
    		if(Usuario.getUsurioSesion().organigrama != null && Usuario.getUsurioSesion().organigrama.deposito != null){
    			e.eq("deposito_id", Usuario.getUsurioSesion().organigrama.deposito_id.intValue());
    		}else{
    			e.isNull("deposito_id");
    		}
    	}

    	p.setExpressionList(e);
    	return p;
	}

	public String getRecuperoPlanillaEjercicio(){
		return numero != null ? expediente != null ? numero + " / " + expediente.ejercicio.nombre : "" : "";
	}

	public String getRecuperoPlanillaEjercicioDeposito(){
		return numero != null ? expediente != null ? numero + " / " + expediente.ejercicio.nombre+" - "+deposito.sigla : "" : "";
	}

	public boolean controlPermisoDeposito() {
		boolean r = true;

		if(!Permiso.check("verTodoRecupero")){
			if(Usuario.getUsurioSesion().organigrama != null && Usuario.getUsurioSesion().organigrama.deposito != null){
				if(Usuario.getUsurioSesion().organigrama.deposito_id.compareTo(deposito_id) != 0) {
					r = false;
				}
			}else {
				r = false;
			}
		}

		return r;
	}

	public List<RecuperoPlanilla> getDataSuggest(String input,Integer limit){

		ExpressionList<RecuperoPlanilla> e= find.fetch("expediente").where();
		Integer[] aa = {new Integer(1),new Integer(2),new Integer(3),new Integer(4),new Integer(5),new Integer(6),
				new Integer(7),new Integer(8),new Integer(9),new Integer(10),new Integer(11),new Integer(12),new Integer(13),new Integer(14)};

		List<RecuperoPlanilla> l = e.eq("numero", Integer.parseInt(input))
									.not(Expr.in("expediente.ejercicio_id",aa))
								.setMaxRows(limit).orderBy("numero")
								.findList();

		return l;
	}

	public static void correCrearPlanillas (Long periodoId) {

		crearPlanilasByPeriodo(periodoId,new Long(1),208);
		crearPlanilasByPeriodo(periodoId,new Long(2),208);
		crearPlanilasByPeriodo(periodoId,new Long(3),208);
		crearPlanilasByPeriodo(periodoId,new Long(4),208);
		crearPlanilasByPeriodo(periodoId,new Long(21),146);
		crearPlanilasByPeriodo(periodoId,new Long(32),208);
		crearPlanilasByPeriodo(periodoId,new Long(35),208);
		crearPlanilasByPeriodo(periodoId,new Long(34),2);
	}

	public static void crearPlanilasByPeriodo(Long periodoId,Long dep,int n) {
		Periodo p = Periodo.find.byId(periodoId);

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 2025);
        calendar.set(Calendar.MONTH, Calendar.NOVEMBER); // Month is 0-indexed
        calendar.set(Calendar.DAY_OF_MONTH, 4);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

		Calendar calendarInicio = Calendar.getInstance();
		calendarInicio.setTime(calendar.getTime());

		Calendar calendarInicio2 = Calendar.getInstance();
		calendarInicio2.setTime(p.date_stop);

		Calendar calendarFin = Calendar.getInstance();
		calendarFin.setTime(p.date_stop);

		List<Feriado> f = Feriado.find.findList();
		ArrayList<Date> feriadosList = new ArrayList<>();
		for(Feriado fx :f) {
			feriadosList.add(fx.fecha);
		}




		while (calendarInicio.before(calendarFin) || calendarInicio.equals(calendarFin)) {

			Logger.debug(calendarInicio.getTime().toString());
			Logger.debug(calendarInicio2.getTime().toString());


				boolean a = feriadosList.contains(calendarInicio.getTime());
				Logger.debug((a)?"true":"false");
				if(!feriadosList.contains(calendarInicio.getTime() ) ) {
					Logger.debug("yyyyyyyyyyyyyyyyyyyyyyyyyyy");
					if (calendarInicio.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY && calendarInicio.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY) {
						Logger.debug("xxxxxxxxxxxxxxxxxxxxxxx");
					}
				}


				if(!feriadosList.contains(calendarInicio.getTime() ) ) {
					if (calendarInicio.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY && calendarInicio.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY) {
			            //se aumentan los dias de diferencia entre min y max

			            RecuperoPlanilla rp = new RecuperoPlanilla();
			            rp.numero = n;
			            rp.expediente_id = 50118;
			            rp.fecha = calendarInicio.getTime();
			            rp.deposito_id = dep;
			            rp.save();

			            n++;

					}
				}

			calendarInicio.add(Calendar.DATE, 1);
		}
	}
}
