package models.recupero;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
@Table(name = "recupero_tipo_pagos")
public class RecuperoTipoPago  extends Model{

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="recupero_tipo_pagos_id_seq")
	public Long id;
	@Required(message="Debe escribir un nombre")
	public String nombre;

	public static Model.Finder<Long,RecuperoTipoPago> find = new Model.Finder<Long,RecuperoTipoPago>(Long.class, RecuperoTipoPago.class);
}
