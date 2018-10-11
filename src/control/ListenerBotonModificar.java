package control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.LogicaGrafica;

public class ListenerBotonModificar implements ActionListener{
	
	private Logica logica;
	private LogicaGrafica logicaGrafica;
	
	public ListenerBotonModificar(Logica logica,LogicaGrafica logicaGrafica) {
		super();
		this.logica = logica;
		this.logicaGrafica = logicaGrafica;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		logicaGrafica.ponerListenerEnAumentarUnidades(null, false);
		logicaGrafica.activarPanelesInformacion(true);
		logicaGrafica.cambiarListenerBoton("Alta",new ListenerBotonAlta(logica, logicaGrafica));
		logicaGrafica.cambiarTextoBoton("Alta","guardar");
		logicaGrafica.cambiarTextoBoton("Nuevo", "cancelar");
		logicaGrafica.activarBoton("Alta", true);
		logicaGrafica.cambiarListenerBoton("Alta", new ListenerGuardar(logica, logicaGrafica));
		logicaGrafica.activarIsbn(false);
	}


}
