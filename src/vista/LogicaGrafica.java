package vista;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

import control.ListenerBotonAgregar;
import control.ListenerBotonAlta;
import control.ListenerBotonBaja;
import control.ListenerBotonModificar;
import control.ListenerCompruebaAlta;
import control.ListenerISBN;
import control.ListenerVenta;
import control.Logica;
import control.MouseListenerLista;
import modelo.Libro;

public class LogicaGrafica extends VistaPrincipal{
	private static final long serialVersionUID = 1L;
	private Validador validador;
	private int libroSeleccionado;

	public LogicaGrafica() {
		super();
		this.validador = new Validador(new GestorErrores(lblMensajeError));
		asignarListeners();
	}
	
	public Libro crearLibro(ArrayList<Libro> arrayList) {
		String [] datosLibro  = new String[8];
		datosLibro [0] = panelDatos .getTxtTitulo().getText();
		datosLibro [1] = panelDatos.getTxtAutor().getText();
		datosLibro [2] = (String) panelDatos.getCmbTemas().getSelectedItem();
		datosLibro [3] = panelDatos.getTxtNumPaginas().getText();
		datosLibro [4] = obtenerFormatos();
		datosLibro [5] = obtenerEstados();
		datosLibro [6] = panelDatos.getTxtISBN().getText();
		datosLibro [7] = panelDatos.getTxtUnidades().getText();
		if(validador.comprobarIsbnRepetido(datosLibro [6],arrayList)) {
			return new Libro(datosLibro);
		}
		else return null;
	}
	
	public void mostrarMensajeError(String mensaje, boolean error) {
		this.validador.mostrarMensajeError(mensaje,error);
	}

	public void actualizarLibroActual() {
		this.libroSeleccionado = librosDisponibles.getSelectedIndex();
	}

	public int getPosicionLibroActual() {
		return this.libroSeleccionado;
	}
	
	private boolean comprobarTodos() {
		return validador.comprobarTodos(this);
	}
	
	
	
	public boolean comprobarIsbn() {
		return validador.comprobarIsbn(panelDatos);
	}
	
	public boolean comprobarSIActivarAlta() {
		resetearMensajeError();
		return comprobarTodos();
	}
	
	private void asignarListeners() {
		Logica logica = new Logica();
		ponerListenerEnBotones(logica);
		ponerMouseListenerEnListaLibro(logica);
		ponerListenerEnPanelDatos(logica);
		ponerListenerEnChecks();
	}

	private void ponerMouseListenerEnListaLibro(Logica logica) {
		this.librosDisponibles.addMouseListener(new MouseListenerLista(logica , this));
	}

	private void ponerListenerEnChecks() {
		ponerListenerEnFormato();
		ponerListenerEnEstado();
	}

	private void ponerListenerEnBotones(Logica logica) {
		this.panelParaBotones.getBtnAlta().addActionListener(new ListenerBotonAlta(logica, this));
		this.panelParaBotones.getBtnBaja().addActionListener(new ListenerBotonBaja(logica, this));
		this.panelParaBotones.getBtnModificar().addActionListener(new ListenerBotonModificar(logica, this));
		this.panelParaBotones.getBtnVenta().addActionListener(new ListenerVenta(logica,this));
		this.panelParaBotones.getBtnAgregar().addActionListener(new ListenerBotonAgregar(logica, this));
	}

	private void ponerListenerEnPanelDatos(Logica logica) {
		for (int i = 0; i < panelDatos.getComponentCount(); i++) {
			if(isIsbnTxtField(i)) {
				ponerListenerIsbn(logica, i);
			}
			else if(isJTxtField(i)) {
				ponerListenerEnJtxFields(i);
			}
		}
	}

	private void ponerListenerEnJtxFields(int i) {
		((JTextField)panelDatos.getComponent(i)).addKeyListener(new ListenerCompruebaAlta(this));
	}

	private boolean isJTxtField(int i) {
		return panelDatos.getComponent(i).getClass().equals(JTextField.class);
	}

	private void ponerListenerIsbn(Logica logica, int i) {
		((JTextFieldIsbn)panelDatos.getComponent(i)).addKeyListener(new ListenerISBN(logica,this));
	}

	private boolean isIsbnTxtField(int i) {
		return panelDatos.getComponent(i).getClass().equals(JTextFieldIsbn.class);
	}
	
	private void ponerListenerEnEstado() {
		for (int i = 0; i < panelChecks.getPanelEstado().getComponentCount(); i++) {
			((JCheckBox)panelChecks.getPanelEstado().getComponent(i)).addActionListener(new ListenerCompruebaAlta(this));
		}
	}

	private void ponerListenerEnFormato() {
		for (int i = 0; i < panelChecks.getPanelFormato().getComponentCount(); i++) {
			((JCheckBox)panelChecks.getPanelFormato().getComponent(i)).addActionListener(new ListenerCompruebaAlta(this));
		}
	}

	public String obtenerIsbn() {
		return panelDatos.getTxtISBN().getText();
	}

	public int obtenerUnidades() {
		return Integer.parseInt(panelDatos.getTxtUnidadesAdd().getText());
	}
	
	
}
