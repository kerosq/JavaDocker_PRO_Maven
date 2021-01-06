package com.utils.database;

import com.utils.database.factory.ConexionPG;
import com.utils.database.factory.ConexionVacia;
import com.utils.database.interfaces.IDatabase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Database {

	public IDatabase getConexion(String path, String motor) {

		if (motor.equalsIgnoreCase("PG")) {
			return new ConexionPG(LeerProperties(path));
		} else {
			return new ConexionVacia();
		}

	}

	public static Properties LeerProperties(String path) {

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