package control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import vista.LogicaGrafica;

public class ListenerCompruebaAlta implements ActionListener,KeyListener{
	
	private LogicaGrafica logicaGragica;
	
	public ListenerCompruebaAlta(LogicaGrafica logicaGragica) {
		super();
		this.logicaGragica = logicaGragica;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		logicaGragica.comprobarTodos();
		logicaGragica.comprobarSIActivarAlta();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		logicaGragica.comprobarTodos();
		logicaGragica.comprobarSIActivarAlta();
	}
	
	@Override
	public void keyPressed(KeyEvent arg0){
		//para que sonarLint este contento
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		//para que sonarLint este contento
	}
	
}
