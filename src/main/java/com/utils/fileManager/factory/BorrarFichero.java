package com.utils.fileManager.factory;

import java.io.File;
import java.util.Properties;

import com.utils.fileManager.interfaces.IFichero;

public class BorrarFichero implements IFichero {

	File file;

	@Override
	public Properties Properties() {
		return null;
	}

	@Override
	public void EscribeFicheros() {
		
	}
	
	
	@Override
	public void BorrarFicheros() {
		if (this.file.delete()) {
			System.out.println("Borrando Fichero: " + this.file.getName());
		} else {
			System.out.println("No se pudo borrar el fichero: " + this.file.getName());
		}
		
	}

	@Override
	public void ZipearFicheros() {
		
	}

}
