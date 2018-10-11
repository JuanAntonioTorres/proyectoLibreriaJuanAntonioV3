package vista;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import control.ListenerAumentarUnidad;
import modelo.Libro;

public class LogicaGrafica{
	private Puente vistaPrincipal;
	private Validador validador;
	private int libroSeleccionado;

	public LogicaGrafica(Puente vistaPrincipal) {
		super();
		this.vistaPrincipal = vistaPrincipal;
		this.validador = new Validador(new GestorErrores(vistaPrincipal.lblMensajeError));
	}
	
	public boolean comprobarTodos() {
		return validador.comprobarTodos(this.vistaPrincipal);
	}

	/**
	 * muestra los datos de un libro en los mismos campos
	 * donde se introducen esos datos con los controles desactivados
	 * @param libro el libro que queremos detallar en pantalla
	 */
	public void pintarLibro(Libro libro) {
		pintarDatos(libro);
		rellenarPanelEstado(libro);
		rellenarPanelFormato(libro);
	}

	/**
	 * limpia el contenido de la lista y lo rellena con 
	 * el titulo del array de libros pasado por parametro
	 * @param arrayList array de libros que queremos mostrar en la lista
	 */
	
	public void pintarLista(ArrayList<Libro> arrayList ) {
		vistaPrincipal.librosDisponibles.removeAll();
		DefaultListModel<String>modeloLista=new DefaultListModel<>();
		for (int i = 0; i < arrayList.size(); i++) {
			modeloLista.addElement(arrayList.get(i).getTitulo());
		}
		vistaPrincipal.librosDisponibles.setModel(modeloLista);
	}
	
	/**
	 * crea un libro nuevo usando los datos introducidos los 
	 * los datos han sido validados antes de activar el boton alta
	 * que llama a este metodo
	 * @param modificando 
	 * @return libro si ISBN bien// null si ISBN mal
	 */
	public Libro crearLibro(ArrayList<Libro> arrayList) {
		PanelDatos panelDatos = vistaPrincipal.panelDatos;
		String datosLibro [] = new String[7];
		datosLibro [0] = panelDatos .getTxtTitulo().getText();
		datosLibro [1] = panelDatos.getTxtAutor().getText();
		datosLibro [2] = (String) panelDatos.getCmbTemas().getSelectedItem();
		datosLibro [3] = panelDatos.getTxtNumPaginas().getText();
		String[] formato = obtenerFormatos();
		datosLibro [4] = obtenerEstados();
		datosLibro [5] = panelDatos.getTxtISBN().getText();
		datosLibro [6] = panelDatos.getSpnUnidades().getValue().toString();
		if(validador.validarISBN(datosLibro [5],arrayList)) {
			return new Libro(datosLibro, formato);
		}
		else return null;
	}
	
	/**
	 * resetea todos los campos del formulario
	 */
	public void resetearInformacion() {
		activarPanelesInformacion(true);
		restablecerTextoBotones();
		resetearPanelDatos();
		ponerTodoPanelEstadoAFalse();
		ponerTodoPanelFormatoAFalse();
		activarBoton("Alta", false);
	}
	
	/**
	 * activa o desactiva el boton con el name enviado
	 * @param nombreBoton getName() del boton objetivo
	 * @param activar activar/true  desactivar/false
	 */
	public void activarBoton(String nombreBoton, boolean activar) {
		for (int i = 0; i < vistaPrincipal.panelBotones .getComponentCount(); i++) {
			if(((JButton)vistaPrincipal.panelBotones.getComponent(i)).getName().equals(nombreBoton)){
				((JButton)vistaPrincipal.panelBotones.getComponent(i)).setEnabled(activar);
			}
		}
	}
	
	
	/**
	 * activa o desctiva los paneles de la vista principal
	 * @param activar activar/true   desactivar/false
	 */
	public void activarPanelesInformacion(boolean activar) {
		activarPanelTodos(activar,vistaPrincipal.panelChecks.getPanelEstado());
		activarPanelTodos(activar,vistaPrincipal.panelChecks.getPanelFormato());
		activarPanelTodos(activar,vistaPrincipal.panelDatos);
		activarAumentarUnidades(true);
	}


	/**
	 * restablece el texto de los botones que hay en panel botones 
	 * mostrando el texto original guardado en el getName() de cada boton 
	 */
	public void restablecerTextoBotones() {
		for (int i = 0; i < vistaPrincipal.panelBotones.getComponentCount(); i++) {
			JButton botonTmp = (JButton)vistaPrincipal.panelBotones.getComponent(i);
			botonTmp.setText(botonTmp.getName());
		}
	}
	
	public void activarAumentarUnidades(boolean activar) {
		vistaPrincipal.panelDatos.getSpnUnidades().setEnabled(activar);
	}
	
	//metodos privados
	
	private void resetearPanelDatos() {
		for (int i = 0; i < vistaPrincipal.panelDatos.getComponentCount(); i++) {
			if(vistaPrincipal.panelDatos.getComponent(i).getClass().equals(JComboBox.class)) {
				((JComboBox<?>)vistaPrincipal.panelDatos.getComponent(i)).setSelectedIndex(0);
			}
			else if (vistaPrincipal.panelDatos.getComponent(i).getClass().equals(JSpinner.class)) {
				((JSpinner)vistaPrincipal.panelDatos.getComponent(i)).getModel().setValue(0);
			}
			else if(vistaPrincipal.panelDatos.getComponent(i).getClass().equals(JTextField.class)) {
				((JTextField)vistaPrincipal.panelDatos.getComponent(i)).setText("");
			}
			else if(vistaPrincipal.panelDatos.getComponent(i).getClass().equals(JTextFieldIsbn.class)) {
				((JTextFieldIsbn)vistaPrincipal.panelDatos.getComponent(i)).setText("");
			}
		}
		
	}
	
	private void pintarDatos(Libro libro) {
		vistaPrincipal.panelDatos.getTxtTitulo().setText(libro.getTitulo());
		vistaPrincipal.panelDatos.getTxtAutor().setText(libro.getAutor());
		pintarComboBox(libro);
		vistaPrincipal.panelDatos.getTxtNumPaginas().setText(String.valueOf(libro.getNumPaginas()));
		vistaPrincipal.panelDatos.getTxtISBN().setText(String.valueOf(libro.getIsbn()));
		vistaPrincipal.panelDatos.getSpnUnidades().setValue(libro.getUnidades());
	}

	private void pintarComboBox(Libro libro) {
		for (int i = 0; i < vistaPrincipal.panelDatos.getCmbTemas().getModel().getSize(); i++) {
			if(libro.getTema().equals(String.valueOf(vistaPrincipal.panelDatos.getCmbTemas().getModel().getElementAt(i)))) {
				vistaPrincipal.panelDatos.getCmbTemas().setSelectedItem(vistaPrincipal.panelDatos.getCmbTemas().getItemAt(i));
			}
		}
	}
	
	private void rellenarPanelEstado(Libro libro) {
		ponerTodoPanelEstadoAFalse();
		for (int i = 0; i < vistaPrincipal.panelChecks.getPanelEstado().getComponentCount(); i++) {
			if(libro.getEstado().equals(((JRadioButton)vistaPrincipal.panelChecks.getPanelEstado().getComponent(i)).getText())) {
				((JRadioButton)vistaPrincipal.panelChecks.getPanelEstado().getComponent(i)).setSelected(true);
			}
		}
	}
	
	private void ponerTodoPanelEstadoAFalse() {
		vistaPrincipal.panelChecks.getBotonGrupo().clearSelection();
	}

	
	private void ponerTodoPanelFormatoAFalse() {
		vistaPrincipal.panelChecks.getBotonGrupoDos().clearSelection();
	}
	
	private void rellenarPanelFormato(Libro libro) {
		ponerTodoPanelFormatoAFalse();
		for (int i = 0; i < libro.getFormato().length; i++) {
			for (int j = 0; j < vistaPrincipal.panelChecks.getPanelFormato().getComponentCount(); j++) {
				if(libro.getFormato()[i].equals(((JCheckBox)vistaPrincipal.panelChecks.getPanelFormato().getComponent(j)).getText())) {
					((JCheckBox)vistaPrincipal.panelChecks.getPanelFormato().getComponent(j)).setSelected(true);
				}
			}
		}
	}

	private String obtenerEstados() {
		String estado = null;
		for (int i = 0; i < vistaPrincipal.panelChecks.getPanelEstado().getComponentCount(); i++) {
			if(((JRadioButton)vistaPrincipal.panelChecks.getPanelEstado().getComponent(i)).isSelected()){
				estado = ((JRadioButton)vistaPrincipal.panelChecks.getPanelEstado().getComponent(i)).getText();
			}
		}
		return estado;
	}

	private String[] obtenerFormatos() {
		String[] formatos = new String[sacarTamanoCadenaFormato()];
		int posicion = 0;
		for (int i = 0; i < vistaPrincipal.panelChecks.getPanelFormato().getComponentCount(); i++) {
			if(((JCheckBox)vistaPrincipal.panelChecks.getPanelFormato().getComponent(i)).isSelected()){
				formatos[posicion] = String.valueOf(((JCheckBox)vistaPrincipal.panelChecks.getPanelFormato().getComponent(i)).getText());
				posicion++;
			}
		}
		return formatos;
	}
	
	private int sacarTamanoCadenaFormato() {
		int retorno = 0;
		for (int i = 0; i < vistaPrincipal.panelChecks.getPanelFormato().getComponentCount(); i++) {
			if(((JCheckBox)vistaPrincipal.panelChecks.getPanelFormato().getComponent(i)).isSelected())retorno++;
		}
		return retorno;
	}

	private void activarPanelTodos(boolean activar,JPanel panel) {
		for (int i = 0; i < panel.getComponentCount(); i++) {
			panel.getComponent(i).setEnabled(activar);
		}
	}

	public void cambiarListenerBoton(String nameBoton,ActionListener listener) {
		for (int i = 0; i < vistaPrincipal.panelBotones.getComponentCount(); i++) {
			JButton boton = (JButton)vistaPrincipal.panelBotones.getComponent(i);
			if(boton.getName().equals(nameBoton)) {
				removerListener(boton);
				boton.addActionListener(listener);
			}
		}
	}

	private void removerListener(JButton boton) {
		for (int i = 0; i < boton.getActionListeners().length; i++) {
			boton.removeActionListener(boton.getActionListeners()[i]);
		}
	}

	public void cambiarTextoBoton(String nameBoton, String texto) {
		for (int i = 0; i < vistaPrincipal.panelBotones.getComponentCount(); i++) {
			JButton boton = (JButton)vistaPrincipal.panelBotones.getComponent(i);
			if(boton.getName().equals(nameBoton)) {
				boton.setText(texto);
			}
		}
	}

	public void ponerListenerEnAumentarUnidades(ListenerAumentarUnidad listener,boolean poner) {
		JSpinner spinner = vistaPrincipal.panelDatos.getSpnUnidades();
		removerListenerUnidades(spinner);
		if(poner){
			spinner.addChangeListener(listener);
		}
	}

	private void removerListenerUnidades(JSpinner spinner) {
		for (int i = 0; i < spinner.getChangeListeners().length; i++) {
			if(spinner.getChangeListeners()[i].getClass().equals(ListenerAumentarUnidad.class)) {
				spinner.removeChangeListener(spinner.getChangeListeners()[i]);
			}
		}
	}

	public void resetearMensajeError() {
		this.vistaPrincipal.lblMensajeError.setText("");
	}
	
	public void mostrarMensajeError(String mensaje, boolean error) {
		this.validador.mostrarMensajeError(mensaje,error);
	}
	
	public void actualizarLibroActual() {
		this.libroSeleccionado = vistaPrincipal.librosDisponibles.getSelectedIndex();
	}

	public int getPosicionLibroActual() {
		return this.libroSeleccionado;
	}

	public void comprobarSIActivarAlta() {
		resetearMensajeError();
		if(comprobarTodos())activarBoton("Alta", true);
		else activarBoton("Alta", false);
	}

	public void activarIsbn(boolean activar) {
		vistaPrincipal.panelDatos.getTxtISBN().setEnabled(activar);
	}

	public void borrarTodoMenosIsbn() {
		String isbn = vistaPrincipal.panelDatos.getTxtISBN().getText();
		resetearInformacion();
		this.vistaPrincipal.panelDatos.getTxtISBN().setText(isbn);
	}
	
}
