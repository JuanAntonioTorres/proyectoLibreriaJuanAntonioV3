package control;
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
		logicaGrafica.activarBoton("Baja", true);
		logicaGrafica.restablecerTextoBotones();
		logicaGrafica.cambiarListenerBoton("Alta",new ListenerBotonModificar(logica, logicaGrafica));
		logicaGrafica.cambiarTextoBoton("Alta","Modificar");
		logicaGrafica.activarBoton("Alta", true);
		logicaGrafica.ponerListenerEnAumentarUnidades(new ListenerAumentarUnidad(logica, logicaGrafica), true);
		logicaGrafica.activarPanelesInformacion(false);
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
