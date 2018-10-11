package modelo;
import java.util.Arrays;

public class Libro {
	private String titulo;
	private String autor;
	private String tema;
	private int numPaginas;
	private String isbn;
	private String[] formato=new String[3];
	private String estado;
	private int unidades;
	
	public Libro(String[]datos,String[] formato) {
		super();
		this.titulo = datos[0];
		this.autor =datos[1];
		this.tema = datos[2];
		this.numPaginas = Integer.parseInt(datos[3]);
		this.formato = formato;
		this.estado = datos[4];
		this.isbn = datos[5];
		this.unidades = Integer.parseInt(datos[6]);
	}

	public boolean esIgualQue(Libro libro) {
		if(this.autor.equals(libro.getAutor()))return false;
		if(this.estado.equals(libro.getEstado()))return false;
		if(Arrays.equals(this.formato,libro.getFormato()))return false;
		if(this.numPaginas==libro.getNumPaginas())return false;
		if(this.tema.equals(libro.getTema()))return false;
		if(this.titulo.equals(libro.getTitulo()))return false;
		return (this.unidades==libro.getUnidades());
	}

	public String getIsbn() {
		return isbn;
	}
	
	public int getUnidades() {
		return unidades;
	}

	public String getTitulo() {
		return titulo;
	}
	public String getAutor() {
		return autor;
	}
	public String getTema() {
		return tema;
	}
	public int getNumPaginas() {
		return numPaginas;
	}
	public String[] getFormato() {
		return formato;
	}
	public String getEstado() {
		return estado;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

}
