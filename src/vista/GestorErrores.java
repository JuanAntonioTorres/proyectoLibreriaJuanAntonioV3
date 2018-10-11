package vista;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;

public class GestorErrores {
	private static final Color COLOR_ERROR = Color.pink;
	private static final Color COLOR_ERROR_TEXT = Color.red;
	private static final Color COLOR_INFO = Color.green;
	private JLabel lblMensajeError;
	
	public GestorErrores(JLabel lblMensajeError) {
		super();
		this.lblMensajeError = lblMensajeError;
	}

	public void pintarError(Component component,boolean error) {
		if(error)component.setBackground(COLOR_ERROR);
		else component.setBackground(Color.white);
	}
	
	/**
	 * muestra un mensaje en el texto del boton alta
	 * @param string mensaje para mostrar en el boton
	 * @param error 
	 */
	public void mostrarMensaje(String string, boolean error) {
		if(error) lblMensajeError.setForeground(COLOR_ERROR_TEXT);
		else lblMensajeError.setForeground(COLOR_INFO);
		lblMensajeError.setText(string);
	}

	public boolean gestionarErrorNumeroPagina(PanelDatos panelDatos) {
		pintarError(panelDatos.getTxtNumPaginas(),true);
		mostrarMensaje("numero de paginas incorrecto",true);
		return false;
	}
}
