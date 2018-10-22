package control;
import java.util.ArrayList;

import modelo.Libro;

public class Logica {
	private static final String RUTA_LIBROS = "Libros";
	private ArrayList<Libro> libros;
	private AlmacenUnico almacenUnico;
	
	public Logica() {
		super();
		this.almacenUnico = new AlmacenUnico(RUTA_LIBROS);
		this.libros = getLibros();
	}

	public void altaLibro(Libro libro) {
		assert libro != null;
		libros = getLibros();
		libros.add(libro);
		almacenUnico.almacena(libros);
	}

	public Libro borrarLibro(int selectedIndex) {
		assert selectedIndex > -1:"no hay libros en la lista";
		libros = getLibros();
		Libro libroBorrado = libros.remove(selectedIndex);
		almacenUnico.almacena(libros);
		return libroBorrado;
	}

	public ArrayList<Libro> getLibros() {
		try {
			this.libros = (ArrayList<Libro>) almacenUnico.recuperar();
		} catch (Exception e) {
			this.libros = new ArrayList<>();
			almacenUnico.almacena(this.libros);
		}
		return this.libros;
	}

	public boolean modificarLibro(Libro original,Libro modificado) {
		boolean retorno;
		libros = getLibros();
		if(!original.esIgualQue(modificado)){
			libros.add(modificado);
			almacenUnico.almacena(libros);
			retorno = true;
		}
		else {
			libros.add(original);
			almacenUnico.almacena(libros);
			retorno = false;
		}
		return retorno;
	}

	public Libro obtenerLibro(String isbnNumber) {
		assert isbnNumber.length()==13:"longitud isbn incorrecta";
		for (Libro libro : libros) {
			if(libro.getIsbn().equals(isbnNumber))return libro;
		}
		return null;
	}
}
