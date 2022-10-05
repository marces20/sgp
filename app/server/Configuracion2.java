package server;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//import org.apache.log4j.Logger;

import play.Play;

public class Configuracion2 {
  // final static Logger log = Logger.getLogger(Configuracion2.class);
  static Configuracion2 config = null;
  static String CONFIG_FILE_PATH = "conf/conf.properties";

  public static Configuracion2 get2() {
    if (config == null) {
      config = new Configuracion2();
    }

    return config;
  }

  String dbDriver;
  String dbConnectionString;
  String dbUser;
  String dbPass;

  String picturesDir;
  String emailsDir;

  String emailConsultas;
  String emailMensajes;

  String warRoot;

  protected Configuracion2() {
    this(CONFIG_FILE_PATH);
  }

  protected Configuracion2(String path) {
		try {
			/*Properties props = Play.configuration;
			
			if (props == null) {
				props = new Properties();
				FileInputStream is = new FileInputStream(path);
				props.load(is);
				is.close();
			}*/
			//System.out.println("aaaaaaaaaaaaaaaa "+props.getProperty("dbConnectionString"));
			/*this.dbDriver = props.getProperty("dbDriver");
			this.dbConnectionString = props.getProperty("dbConnectionString");
			this.dbUser = props.getProperty("dbUser");
			this.dbPass = props.getProperty("dbPass");
			*/
			

			int x =2;
			if(x == 1){		
				this.dbDriver = "org.postgresql.Driver";
				this.dbConnectionString = Play.application().configuration().getString("base.dev.url");
				this.dbUser = Play.application().configuration().getString("base.dev.user");
				this.dbPass = Play.application().configuration().getString("base.dev.pass");
			}
			
			if(x == 2){
				this.dbDriver = "org.postgresql.Driver";
				this.dbConnectionString = Play.application().configuration().getString("base.prod.url");
				this.dbUser = Play.application().configuration().getString("base.prod.user");
				this.dbPass = Play.application().configuration().getString("base.prod.pass");
			}
			
	 
			
			Class.forName(this.dbDriver);
			
		} catch (Exception e) {
			//log.error(e);
		}
	}

  public String getWarRoot() {
    return warRoot;
  }

  public String getDbDriver() {
    return dbDriver;
  }

  public String getDbConnectionString() {
    return dbConnectionString;
  }

  public String getDbUser() {
    return dbUser;
  }

  public String getDbPass() {
    return dbPass;
  }


  public Connection getConnection2() throws SQLException {
    Connection conn = DriverManager.getConnection(this.dbConnectionString, this.dbUser, this.dbPass);
    conn.setAutoCommit(true);
    return conn;
  }
}
