package control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.LogicaGrafica;

public class ListenerBotonBaja implements ActionListener{
	Logica logica;
	LogicaGrafica logicaGrafica;

	public ListenerBotonBaja(Logica logica, LogicaGrafica logicaGrafica) {
		super();
		this.logica = logica;
		this.logicaGrafica = logicaGrafica;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		logicaGrafica.ponerListenerEnAumentarUnidades(null, false);
		logica.borrarLibro(logicaGrafica.getPosicionLibroActual());
		logicaGrafica.pintarLista(logica.getLibros());
		logicaGrafica.activarBoton("Baja", false);
		logicaGrafica.resetearInformacion();
		logicaGrafica.mostrarMensajeError("libro eliminado", false);
	}

}
