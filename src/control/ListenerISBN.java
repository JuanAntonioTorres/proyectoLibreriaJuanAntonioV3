package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import modelo.Libro;
import vista.JTextFieldIsbn;
import vista.LogicaGrafica;

public class ListenerISBN implements KeyListener{

	private Logica logica;
	private LogicaGrafica logicaGrafica;
	
	public ListenerISBN(Logica logica, LogicaGrafica logicaGrafica) {
		this.logica = logica;
		this.logicaGrafica = logicaGrafica;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		logicaGrafica.ponerListenerEnAumentarUnidades(new ListenerAumentarUnidad(logica,logicaGrafica), false);
		logicaGrafica.activarPanelesInformacion(true);
		logicaGrafica.borrarTodoMenosIsbn();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		logicaGrafica.comprobarTodos();
		logicaGrafica.comprobarSIActivarAlta();
		String isbnNumber = ((JTextFieldIsbn)e.getSource()).obtenerTexto();
		Libro libroTemp = logica.obtenerLibro(isbnNumber);
		if(libroTemp!=null) {
			logicaGrafica.pintarLibro(libroTemp);
			logicaGrafica.activarPanelesInformacion(false);
			logicaGrafica.activarIsbn(true);
			logicaGrafica.ponerListenerEnAumentarUnidades(new ListenerAumentarUnidad(logica, logicaGrafica), true);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		//para que sonarLint este contento
	}

}
