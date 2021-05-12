package com.utils.fileManager.factory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EscribeFichero {
	
	private String path;
	FileWriter flwriter;
	
	public void EscribirArchivo(List<String> lista) {

	
		try {
			flwriter = new FileWriter(this.path);
			BufferedWriter bfwriter = new BufferedWriter(flwriter);

			for(String linea : lista) {
				bfwriter.write(linea);
				bfwriter.newLine();
			}	
			
			bfwriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (flwriter != null) {
				try {
					flwriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
