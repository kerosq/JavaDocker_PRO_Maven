package fileManager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileManager {

	private String NombreFichero;
	private String PathFichero;

	File f;
	FileWriter flwriter;

	/**
	 * 
	 * @param Path Ruta fichero
	 * @param Nombrefichero Nombre del fichero
	 */
	public FileManager(String Path, String Nombrefichero) {

		this.f = new File(Nombrefichero);

	}

	public void CrearFichero(String NombreFichero) {

		try {

			if (!this.f.exists()) {
				f.createNewFile();
				this.NombreFichero = this.f.getPath();
				this.PathFichero = this.f.getAbsolutePath();

			} else {
				this.NombreFichero = this.f.getPath();
				this.PathFichero = this.f.getAbsolutePath();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void BorrarFichero(String NombreFichero) {

		if (this.f.delete()) {
			System.out.println("Borrando Fichero: " + this.f.getName());
			this.NombreFichero = this.f.getPath();
			this.PathFichero = this.f.getAbsolutePath();
		} else {
			System.out.println("No se pudo borrar el fichero: " + this.f.getName());
		}
	}

	public void EscribirArchivo(List<String[]> lista) {

		try {
			flwriter = new FileWriter(this.getPathFichero());
			BufferedWriter bfwriter = new BufferedWriter(flwriter);

			for (int i = 0; i < lista.size(); i++) {

				for (int j = 0; j < lista.get(i).length; j++) {
					bfwriter.write(lista.get(i)[j]);
					bfwriter.newLine();
				}

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

	public void EscribirArchivo(List<String[]> lista1, List<String[]> lista) {

		try {
			flwriter = new FileWriter(this.getPathFichero());
			BufferedWriter bfwriter = new BufferedWriter(flwriter);

			for (int i = 0; i < lista.size(); i++) {

				for (int j = 0; j < lista.get(i).length; j++) {
					bfwriter.write(lista.get(i)[j]);
					bfwriter.newLine();
				}

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

	/**
	 * @return the nombreFichero
	 */
	public String getNombreFichero() {
		return NombreFichero;
	}

	/**
	 * @return the pathFichero
	 */
	public String getPathFichero() {
		return PathFichero;
	}

	@Override
	public String toString() {
		return "FileManager [NombreFichero=" + this.NombreFichero + ", PathFichero=" + this.PathFichero + "]";
	}

}
