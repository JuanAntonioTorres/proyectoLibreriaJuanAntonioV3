package vista;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import modelo.Libro;

public class Validador {
	private static final int LONGITUD_ISBN = 13;
	private GestorErrores gestorErrores;
	
	public Validador(GestorErrores gestorErrores) {
		super();
		this.gestorErrores = gestorErrores;
	}
	
	/**
	 * comprueba que los datos del formulario son correctos
	 * y que no hay opciones sin seleccionar y ningun campo 
	 * de texto esta vacio
	 * @return
	 */
	public boolean comprobarTodos(Puente vistaPrincipal) {
		return validaDatos(vistaPrincipal.panelDatos)&&
				comprobarCajasVacias(vistaPrincipal)&&
				comprobarTextosVacios(vistaPrincipal);
	}
	
	public void mostrarMensajeError(String mensaje, boolean error) {
		gestorErrores.mostrarMensaje(mensaje,error);
	}
	 
	
	
	private boolean comprobarTextosVacios(Puente vistaPrincipal) {
		boolean retorno = true;
		for (int i = 0; i < vistaPrincipal.panelDatos.getComponentCount(); i++) {
			if((isJTxtfield(vistaPrincipal, i)||
					isJTxtfieldIsbn(vistaPrincipal, i))&&
					(isEmpty(vistaPrincipal, i))){
				retorno = false;
			}
		}
		if(vistaPrincipal.panelDatos.getCmbTemas().getSelectedIndex()<1)retorno = false;
		return retorno;
	}

	private boolean isJTxtfieldIsbn(Puente vistaPrincipal, int i) {
		return vistaPrincipal.panelDatos.getComponent(i).getClass().equals(JTextFieldIsbn.class);
	}

	private boolean isEmpty(Puente vistaPrincipal, int i) {
		return ((JTextField)vistaPrincipal.panelDatos.getComponent(i)).getText().isEmpty();
	}

	private boolean isJTxtfield(Puente vistaPrincipal, int i) {
		return vistaPrincipal.panelDatos.getComponent(i).getClass().equals(JTextField.class);
	}
	
	private boolean comprobarCajasVacias(Puente vistaPrincipal) {
		return ((!comprobarEstadosVacios(vistaPrincipal.panelChecks))&&
				(!comprobarFormatosVacio(vistaPrincipal.panelChecks)));
	}
	
	private boolean comprobarEstadosVacios(PanelChecks panelChecks) {
		boolean vacio = true;
		for (int i = 0; i < panelChecks.getPanelEstado().getComponentCount(); i++) {
			if(((JRadioButton)panelChecks.getPanelEstado().getComponent(i)).isSelected()){
				vacio = false;
			}
		}
		return vacio;
	}
	
	private boolean comprobarFormatosVacio(PanelChecks panelChecks) {
		boolean vacio = true;
		for (int i = 0; i < panelChecks.getPanelFormato().getComponentCount(); i++) {
			if(((JCheckBox)panelChecks.getPanelFormato().getComponent(i)).isSelected()){
				vacio = false;
			}
		}
		return vacio;
	}
	
	public boolean validaDatos(PanelDatos panelDatos) {
		boolean datosCorrectos = true;
		datosCorrectos = comprobarNumPaginas(panelDatos, datosCorrectos);
		if(datosCorrectos)datosCorrectos = comprobarIsbn(panelDatos, datosCorrectos);
		return datosCorrectos;
	}

	private boolean comprobarNumPaginas(PanelDatos panelDatos, boolean datosCorrectos) {
		if(!validarSoloNumeros(panelDatos.getTxtNumPaginas().getText())) {
			datosCorrectos = gestorErrores.gestionarErrorNumeroPagina(panelDatos);			
		}
		else {
			gestorErrores.pintarError(panelDatos.getTxtNumPaginas(),false);
		}
		return datosCorrectos;
	}

	private boolean comprobarIsbn(PanelDatos panelDatos, boolean datosCorrectos) {
		String textoIsbn = panelDatos.getTxtISBN().getText();
		if(!validarLongitud(textoIsbn,LONGITUD_ISBN)|| !validarSoloNumeros(textoIsbn)) {
			 datosCorrectos = false;
			 if(siHaEscritoAlgoNoCorrecto(textoIsbn)){
				 ponerRojoCuadroIsbn(panelDatos);
			 }
			 else {
				 ponerBlancoCuadroIsbn(panelDatos);
			 }
		}
		else {
			ponerBlancoCuadroIsbn(panelDatos);
		}
		return datosCorrectos;
	}

	private void ponerBlancoCuadroIsbn(PanelDatos panelDatos) {
		gestorErrores.pintarError(panelDatos.getTxtISBN(),false);
	}

	private void ponerRojoCuadroIsbn(PanelDatos panelDatos) {
		gestorErrores.pintarError(panelDatos.getTxtISBN(),true);
	}

	private boolean siHaEscritoAlgoNoCorrecto(String textoIsbn) {
		return textoIsbn.length()>0 && textoIsbn.length()!=LONGITUD_ISBN;
	}

	public boolean validarISBN(String ISBN,ArrayList<Libro> arrayList) {
		boolean retorno = true;
		for (int i = 0; i < arrayList.size(); i++) {
			if(arrayList.get(i) != null && arrayList.get(i).getIsbn().equals(ISBN)) {
				retorno=false;
				gestorErrores.mostrarMensaje("ISBN REPETIDO",true);
			}
		}
		return retorno;
	}
	
	public boolean validarSoloNumeros(String texto) {
		boolean retorno = true;
		for (int i = 0; i < texto.length(); i++) {
			if(!Character.isDigit(texto.charAt(i))) {
				retorno = false;
			}
		}
	return retorno;
	}

	public boolean validarLongitud(String string, int longitudNib) {
		return string.length()==longitudNib;
	}
}
