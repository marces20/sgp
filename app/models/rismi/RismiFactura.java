package models.rismi;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.mail.EmailException;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.annotation.Formula;
import com.fasterxml.jackson.databind.JsonNode;

import models.Organigrama;
import models.recupero.RecuperoFactura;
import play.Logger;
import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import utils.DateUtils;
import utils.EmailUtilis;
import utils.pagination.Pagination;
import utils.rismi.ApiController;

@Entity
@Table(name = "rismi_facturas")
public class RismiFactura extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="rismi_facturas_id_seq")
	public Long id;

	public String nombre_paciente;
	public String dominio;
	public String episodio_id;
	public String paciente_id;

	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha_ingreso;

	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date fecha_egreso;

	@Formats .DateTime(pattern="dd/MM/yyyy")
	public Date create_date;

	public BigDecimal total_total;

	public boolean activo = true;

	public boolean obrasocial = false;

	public String numero_factura;
	public String id_dominio;
	public String estado;
	public String tipo_documento;
	public String numero_documento;
	public String id_programa_medico;
	public String nombre_programa_medico;
	public String fecha_creacion;
	public String tipo;
	public String id_servicio_cargo;
	public String nombre_servicio_cargo;

	@ManyToOne
	@JoinColumn(name="organigrama_id", referencedColumnName="id", insertable=false, updatable=false)
	public Organigrama organigrama;
	@Column(name="organigrama_id")
	@Required(message="Debe seleccionar un departamento/servicio")
	public Long organigrama_id;

	@Formula(select = "_c${ta}.total", join = "left outer join (select rismi_factura_id, round(sum(monto)::numeric,2) as total from rismi_factura_detalle group by rismi_factura_id) as _c${ta} on _c${ta}.rismi_factura_id = ${ta}.id")
	public BigDecimal total;//total
	public BigDecimal getTotal(){
		if (total == null)
			return new BigDecimal(0);
		return total;
	}

	public static Model.Finder<Long,RismiFactura> find = new Finder<Long,RismiFactura>(Long.class, RismiFactura.class);

	public static Pagination<RismiFactura> page(String fecha_desde,String fecha_hasta,String organigrama_id){

		Pagination<RismiFactura> p = new Pagination<RismiFactura>();
    	p.setOrderDefault("ASC");
    	p.setSortByDefault("fecha_egreso,id");

    	ExpressionList<RismiFactura> e = find
				.where();

    	e.eq("activo", true);


    	if(!organigrama_id.isEmpty()){
    		e.eq("organigrama_id", Integer.parseInt(organigrama_id));
    	}

    	if(!fecha_desde.isEmpty()){
    		Date fod = DateUtils.formatDate(fecha_desde, "dd/MM/yyyy");
    		e.ge("fecha_egreso", fod);
    	}

		if(!fecha_hasta.isEmpty()){
    		Date foh = DateUtils.formatDate(fecha_hasta, "dd/MM/yyyy");
    		e.le("fecha_egreso", foh);
    	}

    	if(p.parcheCountAllFormula)
    		p.setTotalRowCount(e.findList().size());



    	p.setExpressionList(e);
    	return p;
	}

	public static Boolean importarFacturasDesdeRismi() throws IOException, EmailException{

		boolean ret = false;
		List<String> adds = new ArrayList<>();
		adds.add("marces2000@gmail.com");

		try {


			String  login = ApiController.loginBloqueante();




	        Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DAY_OF_MONTH, -1);
			Date yesterday = cal.getTime();

			String yesterdayStr = DateUtils.formatDate(yesterday, "yyyy-MM-dd");

			Logger.debug("########################### "+yesterdayStr);

	        String fdesde = yesterdayStr;
	        //fdesde = "2026-07-02";
	        String fhasta = yesterdayStr;

	        List<String> dominios = new ArrayList<>();
	        dominios.add("1");//madariaga
	        dominios.add("82");//imc
	        dominios.add("22");//fatima?
	        dominios.add("2");//materno

	        for(String d : dominios) {
		        Integer page = 1;

		        JsonNode jn = ApiController.getCostoInternacionBloqueante(login,page.toString(),d,fdesde,fdesde);
		        int last_page = 1;


		        while (page <= last_page) {

		        	jn = ApiController.getCostoInternacionBloqueante(login,page.toString(),d,fdesde,fdesde);
		            last_page = jn.get("meta").get("last_page").asInt();


		        	for(JsonNode jnx : jn.get("data")) {

		        		Logger.debug("id_episodio: "+jnx.get("dominio"));
		        		Logger.debug("total: "+jnx.get("total"));

		        		Long proximaSec = Ebean.createSqlQuery("SELECT nextval('rismi_facturas_id_seq') id").findUnique().getLong("id");
						RismiFactura rf = new RismiFactura();
						rf.id = proximaSec;
						rf.dominio = jnx.get("dominio").asText();
						rf.episodio_id = jnx.get("id_episodio").asText();

						String ff = jnx.get("fecha_egreso").asText();
						Date fechaEgreso = DateUtils.formatDate(ff, "yyyy-MM-dd");
						rf.fecha_egreso =fechaEgreso;

						String ff2 = jnx.get("fecha_ingreso").asText();
						Date fechaIngreso = DateUtils.formatDate(ff2, "yyyy-MM-dd");
						rf.fecha_ingreso = fechaIngreso;

						rf.nombre_paciente = jnx.get("nombre_apellido").asText();
						rf.paciente_id =jnx.get("id_paciente").asText();

						Logger.debug("total: "+jnx.get("total").toString().replace(".", ","));
						BigDecimal tot = new BigDecimal(jnx.get("total").asText()).setScale(2, BigDecimal.ROUND_HALF_UP);

						rf.total_total = tot;
						rf.create_date = new Date();
						rf.activo = true;
						rf.obrasocial = (jnx.get("obra_social").toString().compareToIgnoreCase("SI") == 0)?true:false;
						rf.numero_factura = jnx.get("numero_factura").asText();//: 1,
						rf.id_dominio = jnx.get("id_dominio").asText();//: 1,
						rf.estado = jnx.get("estado").asText();//: "A",
						rf.tipo_documento = jnx.get("tipo_documento").asText();//: "DNI",
						rf.numero_documento = jnx.get("numero_documento").asText();//: "30524860",
						rf.id_programa_medico = jnx.get("id_programa_medico").asText();//: 574,
						rf.nombre_programa_medico = jnx.get("nombre_programa_medico").asText();//: "PLAN SUMAR",
						rf.fecha_creacion = jnx.get("fecha_creacion").asText();//: "2026-05-12 17:43:33",
						rf.tipo = jnx.get("tipo").asText();//: "internacion",
						rf.id_servicio_cargo = jnx.get("id_servicio_cargo").asText();//: 149,
						rf.nombre_servicio_cargo = jnx.get("nombre_servicio_cargo").asText();//: "AREA DE HEMODIALISIS",


						switch (rf.dominio) {
						case "HOSPITAL MADARIAGA":
							rf.organigrama_id = Organigrama.HEARM;
							break;
						case "INSTITUTO MISIONERO DEL CANCER - IMC":
							rf.organigrama_id = Organigrama.IMC;
							break;
						case "LACMI":
							rf.organigrama_id = Organigrama.LACMI;
							break;
						case "PET":
							rf.organigrama_id = new Long(182);
							break;
						case "HOSPITAL DE FATIMA":
							rf.organigrama_id = new Long(92);
							break;
						case "HOSPITAL MATERNO NEONATAL":
							rf.organigrama_id = Organigrama.HM;
							break;

						}


						rf.save();

						RismiFacturaDetalle rdf = new RismiFacturaDetalle();
						rdf.monto = new BigDecimal(jnx.get("total_prestaciones").asText()).setScale(2, BigDecimal.ROUND_HALF_UP);
						rdf.producto = "Total Prestaciones";
						rdf.rismi_factura_id  = proximaSec;
						rdf.save();

						RismiFacturaDetalle rdf2 = new RismiFacturaDetalle();
						rdf2.monto = new BigDecimal(jnx.get("total_farmacos").asText()).setScale(2, BigDecimal.ROUND_HALF_UP);
						rdf2.producto = "Total Fármacos";
						rdf2.rismi_factura_id  = proximaSec;
						rdf2.save();

						RismiFacturaDetalle rdf3 = new RismiFacturaDetalle();
						rdf3.monto = new BigDecimal(jnx.get("total_dias_cama").asText()).setScale(2, BigDecimal.ROUND_HALF_UP);
						rdf3.producto = "Total Días Cama";
						rdf3.rismi_factura_id  = proximaSec;
						rdf3.save();

		        	}

		        	Logger.debug("page: "+page);
		        	page++;
		        }
	        }

	        EmailUtilis eu = new EmailUtilis();

	        eu.setSubject("MIGRACION DATOS ATENCION RISMI OK - " + yesterdayStr);
	        eu.setHtmlMsg("MIGRACION DATOS ATENCION RISMI OK - " + yesterdayStr);
	        eu.setFrom("admin@parquesaludmnes.org.ar");
	        eu.setAdds(adds);
	        eu.enviar();

		}catch (Exception e) {

			EmailUtilis eu = new EmailUtilis();

			StackTraceElement origin = e.getStackTrace()[0];
		    String x = "Exception at {"+origin.getFileName()+"}:{"+origin.getLineNumber()+"} — {"+e.getMessage()+"}";


	        eu.setSubject("MIGRACION DATOS ATENCION RISMI ERROR - " + x);
	        eu.setHtmlMsg("MIGRACION DATOS ATENCION RISMI ERROR - " + x);
	        eu.setFrom("admin@parquesaludmnes.org.ar");
	        eu.setAdds(adds);
	        eu.enviar();
		}





        Logger.debug("==============================================");


		return ret;
	}

}
