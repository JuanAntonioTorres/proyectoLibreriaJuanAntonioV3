package control;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import vista.LogicaGrafica;

public class ListenerAumentarUnidad implements ChangeListener {

	private Logica logica;
	private LogicaGrafica logicaGrafica;
	
	public ListenerAumentarUnidad(Logica logica, LogicaGrafica logicaGrafica) {
		super();
		this.logica = logica;
		this.logicaGrafica = logicaGrafica;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		logicaGrafica.resetearMensajeError();
		logicaGrafica.cambiarTextoBoton("Alta","guardar");
		logicaGrafica.cambiarTextoBoton("Nuevo","Cancelar");
		logicaGrafica.activarBoton("Alta", true);
		logicaGrafica.cambiarListenerBoton("Alta", new ListenerGuardar(logica, logicaGrafica));
		logicaGrafica.pintarLista(logica.getLibros());
	}
	
}
