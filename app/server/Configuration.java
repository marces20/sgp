package server;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//import org.apache.log4j.Logger;
import play.Play;

public class Configuration {

	//final static Logger log = Logger.getLogger(Configuration.class);
	static Configuration config = null;
	static String CONFIG_FILE_PATH = "conf/conf.properties";
	
	public static Configuration get() {
		if (config == null) {
			config = new Configuration();
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
	
	protected Configuration() {
		this(CONFIG_FILE_PATH);
	}
	
	protected Configuration(String path) {
		try {
			/*Properties props = Play.configuration;
			
			if (props == null) {
				props = new Properties();
				FileInputStream is = new FileInputStream(path);
				props.load(is);
				is.close();
			}
			System.out.println("aaaaaaaaaaaaaaaa "+props.getProperty("dbConnectionString"));
			*/
			/*this.dbDriver = props.getProperty("dbDriver");
			this.dbConnectionString = props.getProperty("dbConnectionString");
			this.dbUser = props.getProperty("dbUser");
			this.dbPass = props.getProperty("dbPass");
			*/
			
			this.dbDriver = "org.postgresql.Driver";
			this.dbConnectionString = Play.application().configuration().getString("base.dev.url");
			this.dbUser = Play.application().configuration().getString("base.dev.user");
			this.dbPass = Play.application().configuration().getString("base.dev.pass");
					
			 
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

	

	public Connection getConnection() throws SQLException {
		System.out.println("aaaaaaaaaaaaaaaa "+this.dbConnectionString);
		Connection conn = DriverManager.getConnection(this.dbConnectionString, this.dbUser, this.dbPass);
		conn.setAutoCommit(false);
		return conn;
	}
	
}
