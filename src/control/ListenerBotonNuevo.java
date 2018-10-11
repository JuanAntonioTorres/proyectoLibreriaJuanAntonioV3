package control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.LogicaGrafica;

public class ListenerBotonNuevo implements ActionListener{

	private LogicaGrafica logicaGrafica;
	private Logica logica;
	
	public ListenerBotonNuevo(Logica logica , LogicaGrafica logicaGrafica) {
		super();
		this.logicaGrafica = logicaGrafica;
		this.logica = logica;
	}

	@Override
	public void actionPerformed(ActionEvent botonPulsado) {
		logicaGrafica.ponerListenerEnAumentarUnidades(null, false);
		logicaGrafica.resetearMensajeError();
		logicaGrafica.resetearInformacion();
		logicaGrafica.cambiarListenerBoton("Alta", new ListenerBotonAlta(logica, logicaGrafica));
	}
}
