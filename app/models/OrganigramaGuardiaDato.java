package models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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

	public Integer personas;
	public Integer habiles_horas;
	public Integer inhabiles_horas;
	public Boolean activo = false;

	@ManyToOne
	@JoinColumn(name="create_usuario_id", referencedColumnName="id", insertable=false, updatable=false)
	public Usuario create_usuario;
	@Column(name="create_usuario_id")
	public Long create_usuario_id;

	public Date create_date;

	public static Model.Finder<Long,OrganigramaGuardiaDato> find = new Model.Finder<Long,OrganigramaGuardiaDato>(Long.class, OrganigramaGuardiaDato.class);



}
