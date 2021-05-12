package principal;

import com.utils.database.Database;
import com.utils.database.interfaces.IDatabase;

public class Principal {

	public static void main(String[] args) {
					
	Database fabrica = new Database("src/main/resources/docker/PG/", "database.properties");
    
    IDatabase DB = fabrica.getConexion();
     
    DB.Connect();
   
    DB.Disconnect();
		
	}

}
