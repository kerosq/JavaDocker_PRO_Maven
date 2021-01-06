package principal;


import java.util.Properties;

import com.utils.database.Database;
import com.utils.database.interfaces.IDatabase;

public class Principal {

	public static void main(String[] args) {
		
	Database fabrica = new Database();
	Properties properties = new Properties();

    properties.setProperty("DATABASE_DRIVER","org.postgresql.Driver");
    properties.setProperty("DATABASE_URL","jdbc:postgresql://localhost:5432/Athena");
    properties.setProperty("user", "admin_db");
    properties.setProperty("password", "admin_12345678");
    properties.setProperty("MAX_POOL","250");
    properties.setProperty("MOTOR", "POSTGRE");

    IDatabase cx1 = fabrica.getConexion(properties);
    cx1.Connect();
    cx1.Disconnect();
		
	}

}
