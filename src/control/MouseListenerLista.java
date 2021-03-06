package control;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import vista.LogicaGrafica;

public class MouseListenerLista implements MouseListener{

	private Logica logica;
	private LogicaGrafica logicaGrafica;
	
	public MouseListenerLista(Logica logica, LogicaGrafica logicaGrafica) {
		super();
		this.logica = logica;
		this.logicaGrafica = logicaGrafica;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		logicaGrafica.resetearMensajeError();
		logicaGrafica.actualizarLibroActual();
		logicaGrafica.pintarLibro(logica.getLibros().get((logicaGrafica.getPosicionLibroActual())));
		logicaGrafica.activarPanelesInformacion(false);
		Component boton = logicaGrafica.getPanelParaBotones().getComponent(0);
		if(boton.getName().equals("Alta")) {
			boton.setEnabled(false);
		}
		else if (boton.getName().equals("Modificar")) {
			logicaGrafica.activarPanelesInformacion(true);
			logicaGrafica.activarIsbn(false);
		}
		else boton.setEnabled(true);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		//para que sonarLint este contento
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		//para que sonarLint este contento
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		//para que sonarLint este contento
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		//para que sonarLint este contento
	}

}
