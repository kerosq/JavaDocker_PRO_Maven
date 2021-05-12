package com.utils.fileManager.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.utils.fileManager.interfaces.IFichero;

public class LeeFichero implements IFichero {

	
	private Properties prop_fichero;
	private String path;
	
	public LeeFichero(String path) {
		this.path = path;
	}
	
	@Override
	public Properties Properties() {
		
		FileInputStream fis = null;
		this.prop_fichero = null;
		try {
			fis = new FileInputStream(this.path);
			this.prop_fichero = new Properties();
			this.prop_fichero.load(fis);
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
		return this.prop_fichero;
		
	}
	
	
	@Override
	public void EscribeFicheros() {	}

	@Override
	public void BorrarFicheros() { }

	@Override
	public void ZipearFicheros() { }

}
