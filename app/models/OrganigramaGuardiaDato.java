package models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import models.novedades.TipoPlanificacion;
import play.cache.Cache;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
@Table(name = "organigrama_guardia_datos")
public class OrganigramaGuardiaDato extends Model {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="organigrama_guardia_datos_id_seq")
    public Integer id;

	@ManyToOne
	@JoinColumn(name="organigrama_id", referencedColumnName="id", insertable=false, updatable=false)
	public Organigrama organigrama;
	public Long organigrama_id;

	public Integer personas_habiles;
	public Integer habiles_horas;
	public Integer personas_inhabiles;
	public Integer inhabiles_horas;
	public Integer horasxdia_habiles;
	public Integer horasxdia_inhabiles;
	public Boolean activo = false;
	public Boolean critica = false;

	@ManyToOne
	@JoinColumn(name="tipo_planificacion_id", referencedColumnName="id", insertable=false, updatable=false)
	public TipoPlanificacion tipoPlanificacion;
	@Required(message="Debe seleccionar un tipo")
	public Integer tipo_planificacion_id;

	@ManyToOne
	@JoinColumn(name="create_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario create_usuario;
	@Column(name="create_usuario_id")
	public Long create_usuario_id;

	public Date create_date;

	public static Model.Finder<Long,OrganigramaGuardiaDato> find = new Model.Finder<Long,OrganigramaGuardiaDato>(Long.class, OrganigramaGuardiaDato.class);


	public Map<String, Integer> getDiasHorasHabilesInhabilesPorPeriodo(Periodo periodo,Date finicio,Date ffin){
		Integer daysHabiles = 0;
		Integer daysInHabiles = 0;

		Map<String, Integer> ret = new HashMap<>();

		ArrayList<Date> feriadosList = Feriado.getFeriados();

		if(periodo != null) {
			finicio = periodo.date_start;
			ffin = periodo.date_stop;
		}

		Calendar calendarInicio = Calendar.getInstance();
		calendarInicio.setTime(finicio);

		Calendar calendarFin = Calendar.getInstance();
		calendarFin.setTime(ffin);

		while (calendarInicio.before(calendarFin) || calendarInicio.equals(calendarFin)) {

				if(!feriadosList.contains(calendarInicio.getTime() ) ) {
					if (calendarInicio.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY && calendarInicio.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY) {
			            //se aumentan los dias de diferencia entre min y max
						daysHabiles++;
					}else {
						daysInHabiles++;
					}
				}else {
					daysInHabiles++;
				}


			calendarInicio.add(Calendar.DATE, 1);
		}
		ret.put("habiles", daysHabiles);
		ret.put("inhabiles", daysInHabiles);
		ret.put("habilesHoras", daysHabiles * habiles_horas * horasxdia_habiles);
		ret.put("inhabilesHoras", daysInHabiles * inhabiles_horas * horasxdia_inhabiles);


		return ret;
	}


}
