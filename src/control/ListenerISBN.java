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
		//para que sonarLint este contento
	}

	@Override
	public void keyReleased(KeyEvent e) {
		String isbnNumber = ((JTextFieldIsbn)e.getSource()).obtenerTexto();
		if(isbnNumber.length()==13) {
			Libro libroTemp = logica.obtenerLibro(isbnNumber);
			if(libroTemp!=null) {
				logicaGrafica.pintarLibro(libroTemp);
				logicaGrafica.activarPanelesInformacion(false);
				logicaGrafica.mostrarMensajeError("El libro ya existe", true);
			}
			else if(logicaGrafica.comprobarIsbn()){
				logicaGrafica.activarPanelesInformacion(true);
			}
			else {
				logicaGrafica.borrarTodoMenosIsbn();
				logicaGrafica.activarPanelesInformacion(false);
				logicaGrafica.activarIsbn(true);
			}
		}
		else {
			logicaGrafica.borrarTodoMenosIsbn();
			logicaGrafica.activarPanelesInformacion(false);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}
