package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
@Table(name = "provincias")
public class Provincia extends Model {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="provincia_id_seq")
    public Integer id;
	
	@Required(message="Debe escribir el nombre")
	public String nombre;

	@ManyToOne
	public Pais pais = new Pais();
	
	public static Model.Finder<Long,Provincia> find = new Model.Finder<Long,Provincia>(Long.class, Provincia.class);
	
	public static List<Provincia> getProvincias(int paisId){
		return find.where().eq("pais_id", paisId).orderBy("nombre").findList();
	}

	public static String getBancoId(Integer id) {
        switch (id) {
            case 52: //Capital
                return "01"; 
            case 53: //Buenos Aires
            	return "02";     
            case 54: //Catamarca
                return "03";
            case 57: //Chaco
                return "06";
            case 58: //Chubut
                return "07";
            case 55: //Córdoba
                return "04";
            case 56: //Chaco
                return "05";
            case 59: //Entre Ríos
                return "08";
            case 60: //Formosa
                return "09";
            case 61: //Jujuy
                return "10";
            case 62: //La Pampa
                return "11";
            case 63: //La Rioja
                return "12";
            case 64: //Mendoza
                return "13";
            case 65: //Misiones
                return "14";
            case 66: //Neuquén
                return "15";
            case 67: //Río Negro
                return "16";
            case 68: //Salta
                return "17";
            case 69: //San Juan
                return "18";
            case 70: //San Luis
                return "19";
            case 71: //Santa Cruz
                return "20";
            case 72: //Santa Fé
                return "21";
            case 73: //Santiago del Estero
                return "22";
            case 74: //Tierra del Fuego
                return "40";
            case 75: //Tucumán
                return "23";
                default:
                	return "00";
        }
}
	
}