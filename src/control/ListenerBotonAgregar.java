package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Libro;
import vista.LogicaGrafica;

public class ListenerBotonAgregar implements ActionListener {

	
	private Logica logica;
	private LogicaGrafica logicaGrafica;
	
	public ListenerBotonAgregar(Logica logica, LogicaGrafica logicaGrafica) {
		super();
		this.logica = logica;
		this.logicaGrafica = logicaGrafica;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String isbn = logicaGrafica.obtenerIsbn();
		int unidadesMas=logicaGrafica.obtenerUnidades();
		Libro libro = logica.borrarLibro(logicaGrafica.getPosicionLibroActual());
		libro.setUnidades(libro.getUnidades()+unidadesMas);
		logica.altaLibro(libro);
		logicaGrafica.pintarLista(logica.getLibros());
		logicaGrafica.resetearInformacion();
		logicaGrafica.pintarLibro(logica.obtenerLibro(isbn));
	}

}
