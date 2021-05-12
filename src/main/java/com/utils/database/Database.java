package com.utils.database;

import com.utils.database.factory.ConexionPG;
import com.utils.database.factory.ConexionVacia;
import com.utils.database.interfaces.IDatabase;
import com.utils.fileManager.FileManager;

import java.util.Properties;

public class Database {
	
	private FileManager file;
	
	public Database (String Path, String Nombrefichero) {
		file = new FileManager(Path,Nombrefichero);
	}
	
	public IDatabase getConexion() {

		Properties properties = file.LeerFichero().Properties();
		
		if (properties.getProperty("MOTOR").equalsIgnoreCase("PG")) {
			return new ConexionPG(properties);
		} else {
			return new ConexionVacia();
		}

	}


}