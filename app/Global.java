import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.xml.datatype.DatatypeConfigurationException;

import org.apache.commons.mail.EmailException;

import akka.actor.Cancellable;
import controllers.afip.AfipController;
import jobs.DeudasInformesMails;
import models.InventarioRismi;
import models.Usuario;
import models.haberes.LiquidacionMes;
import models.informes.HistorialDeudaProveedores;
import play.Application;
import play.GlobalSettings;
import play.Logger;
import play.data.format.Formatters;
import play.libs.Akka;
import scala.concurrent.duration.Duration;
import utils.EmailUtilis;
import utils.formatters.AnnotationDecimalComaFormatter;


public class Global extends GlobalSettings {

  private Cancellable jobActualizarInventario;
  private Cancellable jobPreliquidar;
  private Cancellable jobHistorialDeuda;
  private Cancellable jobMailDeuda;
  // private Cancellable jobMailDeuda2;
  private Cancellable jobMailDeuda3;
  private Cancellable authAfip;
  private Cancellable comprobanteAfip;
  // private Cancellable jobActualizarVistasMaterizalizadas;

  @Override
  public void onStart(Application arg0) {
    Formatters.register(BigDecimal.class, new AnnotationDecimalComaFormatter());

    if (play.Play.isProd()) {

      Logger.info("--------------------Application has started");

   // JOBS COMPROBANTE AFIP
      Long timeDelayCOMPROBANTEAFIP = null;
      int timeGapBetweenMemoryLogsInMinutesCOMPROBANTEAFIP = 1;


      timeDelayCOMPROBANTEAFIP = getTimeDelay(0, 5, Calendar.AM, 0, 0, 0);// ACTUALIZAR INVENTARIO


      Logger.info("Cron Job COMPROBANTE AFIP ---- " + timeDelayCOMPROBANTEAFIP);


      comprobanteAfip = Akka.system()
          .scheduler()
          .schedule(Duration.create(new Long(60000), TimeUnit.MILLISECONDS),Duration.create(timeGapBetweenMemoryLogsInMinutesCOMPROBANTEAFIP, TimeUnit.MINUTES),

              new Runnable() {
                @Override
                public void run() {
                  System.out.println("Cron Job COMPROBANTE AFIP");
                  try {

                	  	List<Usuario> u = Usuario.find.where().eq("nombre","Administrator").findList();
                	  	if(u.size() > 0) {
                	  		AfipController a = new AfipController();
                	  		a.crearComprobantesAutomaticos();
                	  	}

                  } catch ( IOException e) {
                    e.printStackTrace();
                  }
                }
              },
              Akka.system().dispatcher());
      // ------------------- FIN JOBS COMPROBANTE AFIP

      // JOBS AUTH AFIP
      Long timeDelayAUTHAFIP = null;
      int timeGapBetweenMemoryLogsInMinutesAUTHAFIP = 12;


      timeDelayAUTHAFIP = getTimeDelay(0, 5, Calendar.AM, 0, 0, 0);// ACTUALIZAR INVENTARIO


      Logger.info("Cron Job AUTH AFIP ---- " + timeDelayAUTHAFIP);


      authAfip = Akka.system()
          .scheduler()
          .schedule(Duration.create(timeDelayAUTHAFIP, TimeUnit.MILLISECONDS),Duration.create(timeGapBetweenMemoryLogsInMinutesAUTHAFIP, TimeUnit.HOURS),

              new Runnable() {
                @Override
                public void run() {
                  System.out.println("Cron Job AUTH AFIP");
                  try {
                	  	AfipController a = new AfipController();
              			a.getAuth();

              			 Calendar calendar2 = Calendar.getInstance();
                         calendar2.setTime(new Date());

              			EmailUtilis eu = new EmailUtilis();
                        eu.setSubject("LOGUEO AFIP JOBS " + calendar2.get(Calendar.DAY_OF_WEEK));
                        eu.setHtmlMsg("LOGUEO AFIP JOBS:" + calendar2.get(Calendar.DAY_OF_WEEK));
                        eu.setFrom("marces2000@gmail.com");

                        List<String> adds = new ArrayList<>();
                        adds.add("marces2000@gmail.com");
                        eu.setAdds(adds);
                        eu.enviar();

                  } catch (EmailException | IOException | DatatypeConfigurationException e) {
                    e.printStackTrace();
                  }
                }
              },
              Akka.system().dispatcher());
      // ------------------- FIN JOBS AUTH AFIP

      // JOBS ACTUALIZAR INVENTARIO
      Long timeDelayFromAppStartToLogFirstLogInMs = null;
      int timeGapBetweenMemoryLogsInMinutes = 1;


      timeDelayFromAppStartToLogFirstLogInMs = getTimeDelay(0, 9, Calendar.PM, 0, 0, 0);// ACTUALIZAR INVENTARIO


      Logger.info("Cron Job INVENTARIO ---- " + timeDelayFromAppStartToLogFirstLogInMs);


      jobActualizarInventario = Akka.system()
          .scheduler()
          .schedule(Duration.create(timeDelayFromAppStartToLogFirstLogInMs, TimeUnit.MILLISECONDS),
              Duration.create(timeGapBetweenMemoryLogsInMinutes, TimeUnit.DAYS),

              new Runnable() {
                @Override
                public void run() {
                  System.out.println("Cron Job");
                  try {
                	LiquidacionMes.actualizarVistaMaterializadaPuestosLaborales();
                    InventarioRismi.actualizarInventarioRismi();
                  } catch (EmailException e) {
                    e.printStackTrace();
                  }
                }
              },
              Akka.system().dispatcher());
      // ------------------- FIN JOBS ACTUALIZAR INVENTARIO
      // ------------------- JOBS HISTORIAL DEUDA


      timeDelayFromAppStartToLogFirstLogInMs = getTimeDelay(0, 9, Calendar.PM, 10, 0, 0);// PRELIQUIDAR

      Logger.info("Cron Job HISTORIAL DEUDA ---- " + timeDelayFromAppStartToLogFirstLogInMs);
      jobHistorialDeuda = Akka.system()
          .scheduler()
          .schedule(Duration.create(timeDelayFromAppStartToLogFirstLogInMs, TimeUnit.MILLISECONDS),
              Duration.create(timeGapBetweenMemoryLogsInMinutes, TimeUnit.DAYS),

              new Runnable() {
                @Override
                public void run() {
                  System.out.println("Cron Job de HISTORIAL DEUDA");
                  try {
                    Date now = new Date();


                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(now);
                    System.out.println(calendar.get(Calendar.DAY_OF_WEEK));


                    EmailUtilis eu = new EmailUtilis();
                    eu.setSubject("HISTORIAL DEUDA EMPIEZA " + calendar.get(Calendar.DAY_OF_WEEK));
                    eu.setHtmlMsg("HISTORIAL DEUDA EMPIEZA:" + calendar.get(Calendar.DAY_OF_WEEK));
                    eu.setFrom("marces2000@gmail.com");

                    List<String> adds = new ArrayList<>();
                    adds.add("marces2000@gmail.com");
                    eu.setAdds(adds);
                    eu.enviar();


                    // ----------------------------------------
                    HistorialDeudaProveedores.insertHistorialDeuda();
                    // ----------------------------------------


                    EmailUtilis eu2 = new EmailUtilis();
                    eu2.setSubject("TERMINA DEUDA EMPIEZA:");
                    eu2.setHtmlMsg("TERMINA DEUDA EMPIEZA:");
                    eu2.setFrom("marces2000@gmail.com");


                    eu2.setAdds(adds);
                    eu2.enviar();


                  } catch (EmailException e) {
                    e.printStackTrace();
                  }
                }
              },
              Akka.system().dispatcher());
      // ------------------- FIN JOBS HISTORIAL DEUDA


      // ------------------- JOBS PRELIQUIDAR


      timeDelayFromAppStartToLogFirstLogInMs = getTimeDelay(0, 9, Calendar.PM, 20, 0, 0);// PRELIQUIDAR

      Logger.info("Cron Job PRELIQUIDAR ---- " + timeDelayFromAppStartToLogFirstLogInMs);
      jobPreliquidar = Akka.system()
          .scheduler()
          .schedule(Duration.create(timeDelayFromAppStartToLogFirstLogInMs, TimeUnit.MILLISECONDS),
              Duration.create(timeGapBetweenMemoryLogsInMinutes, TimeUnit.DAYS),

              new Runnable() {
                @Override
                public void run() {
                  System.out.println("Cron Job de liquidaciones");
                  try {
                    LiquidacionMes.preliquidarEspera();
                  } catch (EmailException e) {
                    e.printStackTrace();
                  }
                }
              },
              Akka.system().dispatcher());
      // ------------------- FIN JOBS PRELIQUIDAR


      // ------------------- JOBS MAIL INFORME DEUDA

      timeDelayFromAppStartToLogFirstLogInMs = getTimeDelay(0, 4, Calendar.PM, 0, 0, 0);// MAIL DEUDA 4PM

      Logger.info("Cron Job   MAIL INFORME DEUDA ---- " + timeDelayFromAppStartToLogFirstLogInMs);
      jobMailDeuda = Akka.system()
          .scheduler()
          .schedule(Duration.create(timeDelayFromAppStartToLogFirstLogInMs, TimeUnit.MILLISECONDS),
              Duration.create(timeGapBetweenMemoryLogsInMinutes, TimeUnit.DAYS),

              new Runnable() {
                @Override
                public void run() {
                  Logger.info("Cron Job de MAIL INFORME DEUDA2");
                  new DeudasInformesMails().envioMailsDeudasRA();
                  new DeudasInformesMails().envioMailsDeudasDestacados();
                  new DeudasInformesMails().envioMailsDeudasOtros();
                }
              },
              Akka.system().dispatcher());
      // -------------------------------------------------------

      // ------------------- JOBS MAIL INFORME DEUDA

      timeDelayFromAppStartToLogFirstLogInMs = getTimeDelay(0, 7, Calendar.AM, 0, 0, 0);// MAIL DEUDA 4PM

      Logger.info("Cron Job   MAIL INFORME PAGADO NO ENTREGADO ---- " + timeDelayFromAppStartToLogFirstLogInMs);
      jobMailDeuda3 = Akka.system()
          .scheduler()
          .schedule(Duration.create(timeDelayFromAppStartToLogFirstLogInMs, TimeUnit.MILLISECONDS),
              Duration.create(timeGapBetweenMemoryLogsInMinutes, TimeUnit.DAYS),

              new Runnable() {
                @Override
                public void run() {
                  Logger.info("Cron Job de MAIL INFORME PAGADO NO ENTREGADO");
                  new DeudasInformesMails().envioMailsPagadoNoEntregado();
                }
              },
              Akka.system().dispatcher());
      // -------------------------------------------------------

      /*
       * timeDelayFromAppStartToLogFirstLogInMs = getTimeDelay(0,6,Calendar.AM,6,0,0);//MAIL DEUDA 6AM
       *
       * System.out.println("Cron Job   MAIL INFORME DEUDA ---- "+timeDelayFromAppStartToLogFirstLogInMs);
       * jobMailDeuda2 = Akka.system().scheduler().schedule(
       * Duration.create(timeDelayFromAppStartToLogFirstLogInMs, TimeUnit.MILLISECONDS),
       * Duration.create(timeGapBetweenMemoryLogsInMinutes, TimeUnit.DAYS),
       *
       * new Runnable() {
       *
       * @Override
       * public void run() {
       * Logger.info("Cron Job de MAIL INFORME DEUDA");
       * new DeudasInformesMails().envioMailsDeudasRA();
       * new DeudasInformesMails().envioMailsDeudasDestacados();
       * new DeudasInformesMails().envioMailsDeudasOtros();
       * }
       * },Akka.system().dispatcher());
       */

      // ------------------- JOBS MAIL INFORME DEUDA

      // ------------------- JOBS ACTUALIZAR VISTAS MATERIALIZADAS

      // System.out.println("Cron Job VISTAS ---- "+timeDelayFromAppStartToLogFirstLogInMs);

      /*
       * jobActualizarVistasMaterizalizadas = Akka.system().scheduler().schedule(
       * Duration.Zero(), Duration.create(5, TimeUnit.MINUTES),
       *
       * new Runnable() {
       *
       * @Override
       * public void run() {
       * System.out.println("Cron Job de VISTAS MATERIZALIZADAS");
       * Logger.info("Cron Job de VISTAS MATERIZALIZADAS");
       * try {
       * InformeDeudaProveedoresMaterializada.actualizarVistaMaterializada();
       * InformeDeudaPorActaMaterializada.actualizarVistaMaterializada();
       * } catch (Exception e) {
       * e.printStackTrace();
       * }
       * }
       * },Akka.system().dispatcher());
       */
      // ------------------- FIN JOBS ACTUALIZAR VISTAS MATERIALIZADAS

      Logger.debug("prdooooo");
    }
    super.onStart(arg0);


  }

  private Long getTimeDelay(int d, int h, int ampm, int m, int s, int ml) {
    Long timeDelayFromAppStartToLogFirstLogInMs = null;

    Calendar now2 = Calendar.getInstance();
    now2.add(Calendar.DATE, d);
    now2.set(Calendar.HOUR, h);
    now2.set(Calendar.AM_PM, ampm);
    now2.set(Calendar.MINUTE, m);
    now2.set(Calendar.SECOND, s);
    now2.set(Calendar.MILLISECOND, ml);
    timeDelayFromAppStartToLogFirstLogInMs = now2.getTime().getTime() - Calendar.getInstance().getTime().getTime();

    if (timeDelayFromAppStartToLogFirstLogInMs < 0) {
      d = d + 1;
      now2 = Calendar.getInstance();
      now2.add(Calendar.DATE, d);
      now2.set(Calendar.HOUR, h);
      now2.set(Calendar.AM_PM, ampm);
      now2.set(Calendar.MINUTE, m);
      now2.set(Calendar.SECOND, s);
      now2.set(Calendar.MILLISECOND, ml);
      timeDelayFromAppStartToLogFirstLogInMs = now2.getTime().getTime() - Calendar.getInstance().getTime().getTime();
    }

    return timeDelayFromAppStartToLogFirstLogInMs;
  }

  @Override
  public void onStop(Application app) {
    Logger.info("-----------------Application shutdown...");
    jobActualizarInventario.cancel();
    jobPreliquidar.cancel();
    jobMailDeuda.cancel();
    // jobMailDeuda2.cancel();
    jobMailDeuda3.cancel();
    // jobActualizarVistasMaterizalizadas.cancel();
    jobHistorialDeuda.cancel();
    authAfip.cancel();
    comprobanteAfip.cancel();
    super.onStop(app);
  }
}
