package principal;

import com.utils.database.Database;
import com.utils.database.interfaces.IDatabase;

public class Principal {

	public static void main(String[] args) {
		
	Database fabrica = new Database();
    
    IDatabase DB = fabrica.getConexion("src/main/resources/docker/PG/database.properties");
    
    DB.Connect();
    DB.Disconnect();
		
	}
	

}
