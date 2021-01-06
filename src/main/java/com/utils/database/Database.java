package com.utils.database;

import com.utils.database.factory.ConexionPG;
import com.utils.database.factory.ConexionVacia;
import com.utils.database.interfaces.IDatabase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Database {

	public IDatabase getConexion(String path) {

		Properties properties = LeerProperties(path);
		
		if (properties.getProperty("MOTOR").equalsIgnoreCase("PG")) {
			return new ConexionPG(properties);
		} else {
			return new ConexionVacia();
		}

	}

	private Properties LeerProperties(String path) {

		FileInputStream fis = null;
		Properties prop = null;
		try {
			fis = new FileInputStream(path);
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return prop;

	}

}