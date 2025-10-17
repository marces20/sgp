package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
@Table(name = "agentes_organigramas")
public class AgenteOrganigrama extends Model{

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="agentes_organigramas_id_seq")
	public Long id;

	@ManyToOne
	@JoinColumn(name="agente_id", referencedColumnName="id", insertable=false, updatable=false)
	public Agente agente;
	@Required(message="Debe tener un agente asociado.")
	public Long agente_id;

	@ManyToOne
	@JoinColumn(name="organigrama_id", referencedColumnName="id", insertable=false, updatable=false)
	public Organigrama organigrama;
	@Column(name="organigrama_id")
	@Required(message="Debe seleccionar un departamento/servicio")
	public Long organigrama_id;

	public static Finder<Long,AgenteOrganigrama> find = new Finder<Long,AgenteOrganigrama>(Long.class, AgenteOrganigrama.class);

	public static List<Long> getIdsAgentesByOrganigrama(Long organigramaId){

		List<AgenteOrganigrama> agentesOrgaList = AgenteOrganigrama.find.where().eq("organigrama_id",organigramaId).findList();
		List<Long> agentesByOrga = new ArrayList<>();
		for(AgenteOrganigrama aox: agentesOrgaList) {
			agentesByOrga.add(aox.agente_id);
		}

		return agentesByOrga;
	}
}
