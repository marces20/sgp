package controllers.haberes;

import static play.data.Form.form;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Formatter;
import java.util.List;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import utils.EmailUtilis;

public class PrestaFacilController extends Controller {

  public static Result enviarArchivo() {
    DynamicForm d = form().bindFromRequest();

    Integer periodo_id = null;

    if (d.get("periodo_id") != null) {
      periodo_id = Integer.parseInt(d.get("periodo_id"));
    }
    String periodo = null;

    Connection conn = null;
    ResultSet rs;
    PreparedStatement stmt;

    System.out.println("111111111111111111111111");
    try {

      if (periodo_id == null) {
        Calendar cal = Calendar.getInstance();
        Formatter f = new Formatter();
        periodo = f.format("%02d", cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.YEAR);
        periodo_id = getIdPeriodoActualFromNombre(periodo);
      } else {
        periodo = getNombrePeriodoActualFromId(periodo_id);
      }

      if (periodo == null || periodo_id == null) {
        return ok("No se encuentra periodo válido.");
      }

      String nombreArchivoEmpleados = "archivo_empleados_" + periodo + ".txt";
      String nombreArchivoDescuentos = "archivo_descuentos_" + periodo + ".txt";

      String pathArchivoEmpleados = System.getProperty("java.io.tmpdir") +"/"+ nombreArchivoEmpleados.replace("/", "-");
      String pathArchivoDescuentos = System.getProperty("java.io.tmpdir") +"/"+ nombreArchivoDescuentos.replace("/", "-");

      conn = play.db.DB.getConnection();
      stmt = conn.prepareStatement("select * from view_datos_empleados_presta_facil where periodo_id = ?");
      stmt.setInt(1, periodo_id);
      rs = stmt.executeQuery();

      if (!rs.isBeforeFirst()) {
        return ok("No hay registros para empleados en el periodo " + periodo);
      }

      stmt = conn.prepareStatement("select * from view_datos_empleados_presta_facil where periodo_id = ?");
      stmt.setInt(1, periodo_id);
      rs = stmt.executeQuery();
      // Creo el archivo de empleados con los resultados
      PrintWriter achivoEmpleados = new PrintWriter(new FileWriter(pathArchivoEmpleados));
      while (rs.next()) {
        achivoEmpleados.println(rs.getString("linea"));
      }
      achivoEmpleados.close();


      conn = play.db.DB.getConnection();
      stmt = conn.prepareStatement("select * from view_datos_descuentos_presta_facil where periodo_id = ?");
      stmt.setInt(1, periodo_id);
      rs = stmt.executeQuery();

      if (!rs.isBeforeFirst()) {
        return ok("No hay registros para descuentos en el periodo " + periodo);
      }

      // Creo el archivo de descuentos con los resultados
      PrintWriter achivoDescuentos = new PrintWriter(new FileWriter(pathArchivoDescuentos));
      while (rs.next()) {
        achivoDescuentos.println(rs.getString("linea"));
      }
      achivoDescuentos.close();


      HtmlEmail mail = new HtmlEmail();
      
      
      List<EmailAttachment> attachmentList = new ArrayList<>();
      EmailAttachment attachment = null;
      attachment = new EmailAttachment();
      attachment.setPath(pathArchivoEmpleados);
      attachment.setDisposition(EmailAttachment.ATTACHMENT);
      attachment.setDescription("Archivo empleados");
      attachment.setName(nombreArchivoEmpleados);
      //mail.attach(attachment);
      attachmentList.add(attachment);

      EmailAttachment attachment2 = new EmailAttachment();
      attachment2.setPath(pathArchivoDescuentos);
      attachment2.setDisposition(EmailAttachment.ATTACHMENT);
      attachment2.setDescription("Archivo descuentos");
      attachment2.setName(nombreArchivoDescuentos);
      attachmentList.add(attachment2);
      //mail.attach(attachment2);
      
      


      EmailUtilis eu = new EmailUtilis();
      eu.setSubject("Bases de " + periodo);
      eu.setHtmlMsg("Archivos correspondientes al periodo " + periodo);
      eu.setFrom("liquidacionesparque@gmail.com");
      eu.setAttach(attachmentList);
      
      
      
      
      List<String> adds = new ArrayList<>();
      //adds.add("sdmsoporte@improntasolutions.com");
      //adds.add("pgarcia@improntasolutions.com");
      //adds.add("klug.alejandro@gmail.com");
      adds.add("palaciosmatias@gmail.com");
      //adds.add("marces2000@gmail.com");
      //adds.add("dnl1802@gmail.com");
      eu.setAdds(adds);
      eu.enviar();

      return ok("ok");
    } catch (SQLException e) {
      // TODO Auto-generated catch block
    	System.out.println("11111111111111122222 "+e);
      e.printStackTrace();
    } catch (EmailException e) {
      // TODO Auto-generated catch block
    	System.out.println("111111111111111333333 "+e);
      e.printStackTrace();
    } catch (IOException e) {
    	System.out.println("11111111111111144444443 "+e);
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {

    }
    
    System.out.println("5555555 ");

    return ok("okk");
  }

  private static Integer getIdPeriodoActualFromNombre(String periodo) throws SQLException {
    Connection conn = play.db.DB.getConnection();
    ResultSet res = conn.prepareStatement("select id from periodos where nombre = '" + periodo + "'").executeQuery();
    if (res == null)
      return null;
    res.next();
    Integer periodo_id = res.getInt("id");
    res.close();
    return periodo_id;
  }

  private static String getNombrePeriodoActualFromId(Integer periodo_id) throws SQLException {
    Connection conn = play.db.DB.getConnection();
    ResultSet res = conn.prepareStatement("select nombre from periodos where id = " + periodo_id).executeQuery();
    if (res == null)
      return null;
    res.next();
    String nombre_periodo = res.getString("nombre");
    res.close();
    return nombre_periodo;
  }

}
