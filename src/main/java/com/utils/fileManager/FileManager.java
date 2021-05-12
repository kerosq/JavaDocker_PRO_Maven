package com.utils.fileManager;


import java.io.File;
import java.io.FileWriter;


import com.utils.fileManager.factory.LeeFichero;
import com.utils.fileManager.interfaces.IFichero;

import lombok.Data;

@Data
public class FileManager {

	private String NombreFichero;
	private String PathFichero;
	File file;
	FileWriter flwriter;

	/**
	 * 
	 * @param Path Ruta fichero
	 * @param Nombrefichero Nombre del fichero
	 */
	public FileManager(String Path, String Nombrefichero) {
		this.file = new File(Path+Nombrefichero);
	}

	
	public IFichero LeerFichero() {
		return new LeeFichero(this.file.getAbsolutePath());
	}


}
