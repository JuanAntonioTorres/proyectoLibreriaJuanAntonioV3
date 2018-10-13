package control;
import java.util.ArrayList;

import modelo.Libro;

public class Logica {
	private ArrayList<Libro> libros;
	
	public Logica() {
		super();
		this.libros = new ArrayList<>();
	}

	public void altaLibro(Libro libro) {
		libros.add(libro);
	}

	public Libro borrarLibro(int selectedIndex) {
		return libros.remove(selectedIndex);
	}

	public ArrayList<Libro> getLibros() {
		return libros;
	}

	public boolean modificarLibro(Libro original,Libro modificado,int posicion) {
		boolean retorno;
		if(!original.esIgualQue(modificado)){
			libros.add(posicion, modificado);
			retorno = true;
		}
		else retorno = false;
		return retorno;
	}

	public Libro obtenerLibro(String isbnNumber) {
		for (Libro libro : libros) {
			if(libro.getIsbn().equals(isbnNumber))return libro;
		}
		return null;
	}
}
