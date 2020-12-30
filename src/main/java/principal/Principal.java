package principal;

import fileManager.FileManager;

import java.util.ArrayList;
import java.util.List;

public class Principal {

	public static void main(String[] args) {

		String fichero = "hola.dat";
		FileManager Archivo = new FileManager(fichero);

		Archivo.CrearFichero(fichero);
		System.out.println("Nombre fichero: " + Archivo.getNombreFichero());
		System.out.println("PATH: " + Archivo.getPathFichero());

		List<String[]> lista = new ArrayList<String[]>();
		String[] registro = new String[3];
		registro[0] = "hola kevin";
		registro[1] = "como estas";
		registro[2] = "todo bien?";

		lista.add(registro);
		Archivo.EscribirArchivo(lista);
	}

}
