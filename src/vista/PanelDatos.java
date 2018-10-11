package vista;

import javax.swing.JPanel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class PanelDatos extends JPanel{
	private static final long serialVersionUID = 1L;
	private JTextField txtAutor;
	private JTextField txtNumPaginas;
	private JTextField txtTitulo;
	private JComboBox<String> cmbTemas;
	private JTextFieldIsbn txtISBN;
	private JSpinner spnUnidades;
	
	
	public PanelDatos() {
		setMaximumSize(new Dimension(400, 550));
		setMinimumSize(new Dimension(120, 320));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{134, 151, 70, 0};
		gridBagLayout.rowHeights = new int[] {0, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22,0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
		setLayout(gridBagLayout);
		
		JLabel lblLib = new JLabel("ISBN");
		lblLib.setMaximumSize(new Dimension(125, 35));
		lblLib.setHorizontalAlignment(SwingConstants.CENTER);
		lblLib.setMinimumSize(new Dimension(45, 25));
		lblLib.setFont(new Font("Dialog", Font.BOLD, 12));
		GridBagConstraints gbc_lblLib = new GridBagConstraints();
		gbc_lblLib.fill = GridBagConstraints.BOTH;
		gbc_lblLib.insets = new Insets(0, 0, 5, 5);
		gbc_lblLib.gridx = 0;
		gbc_lblLib.gridy = 1;
		add(lblLib, gbc_lblLib);
		
		txtISBN = new JTextFieldIsbn();
		txtISBN.setName("txtIsbn");
		txtISBN.setToolTipText("numero identificacion 13 digitos Ej 1234567890123");
		txtISBN.setMinimumSize(new Dimension(45, 25));
		txtISBN.setMaximumSize(new Dimension(125, 35));
		txtISBN.setFont(new Font("Dialog", Font.BOLD, 11));
		txtISBN.setColumns(10);
		GridBagConstraints gbc_txtLib = new GridBagConstraints();
		gbc_txtLib.insets = new Insets(0, 0, 5, 5);
		gbc_txtLib.fill = GridBagConstraints.BOTH;
		gbc_txtLib.gridx = 1;
		gbc_txtLib.gridy = 1;
		add(txtISBN, gbc_txtLib);
		
		JLabel lblTtulo = new JLabel("T\u00EDtulo");
		lblTtulo.setMaximumSize(new Dimension(122, 33));
		lblTtulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTtulo.setMinimumSize(new Dimension(55, 25));
		lblTtulo.setToolTipText("");
		lblTtulo.setFont(new Font("Dialog", Font.BOLD, 15));
		GridBagConstraints gbclblTtulo = new GridBagConstraints();
		gbclblTtulo.insets = new Insets(0, 0, 5, 5);
		gbclblTtulo.fill = GridBagConstraints.BOTH;
		gbclblTtulo.gridx = 0;
		gbclblTtulo.gridy = 3;
		add(lblTtulo, gbclblTtulo);
		
		txtTitulo = new JTextField();
		txtTitulo.setMaximumSize(new Dimension(122, 33));
		txtTitulo.setMinimumSize(new Dimension(45, 25));
		txtTitulo.setToolTipText("Introduce el titulo\r\n");
		txtTitulo.setHorizontalAlignment(SwingConstants.LEFT);
		txtTitulo.setFont(new Font("Dialog", Font.BOLD, 11));
		txtTitulo.setColumns(10);
		GridBagConstraints gbc_txtTitulo = new GridBagConstraints();
		gbc_txtTitulo.insets = new Insets(0, 0, 5, 5);
		gbc_txtTitulo.fill = GridBagConstraints.BOTH;
		gbc_txtTitulo.gridx = 1;
		gbc_txtTitulo.gridy = 3;
		add(txtTitulo, gbc_txtTitulo);
		
		JLabel lblAutorLibro = new JLabel("Autor");
		lblAutorLibro.setMaximumSize(new Dimension(125, 33));
		lblAutorLibro.setHorizontalAlignment(SwingConstants.CENTER);
		lblAutorLibro.setMinimumSize(new Dimension(45, 24));
		lblAutorLibro.setFont(new Font("Dialog", Font.BOLD, 15));
		GridBagConstraints gbclblAutorLibro = new GridBagConstraints();
		gbclblAutorLibro.fill = GridBagConstraints.BOTH;
		gbclblAutorLibro.insets = new Insets(0, 0, 5, 5);
		gbclblAutorLibro.gridx = 0;
		gbclblAutorLibro.gridy = 5;
		add(lblAutorLibro, gbclblAutorLibro);
		
		txtAutor = new JTextField();
		txtAutor.setMaximumSize(new Dimension(125, 35));
		txtAutor.setMinimumSize(new Dimension(45, 25));
		txtAutor.setToolTipText("Introduce el Autor del Libro");
		txtAutor.setFont(new Font("Dialog", Font.BOLD, 11));
		txtAutor.setColumns(10);
		GridBagConstraints gbctxtAutor = new GridBagConstraints();
		gbctxtAutor.insets = new Insets(0, 0, 5, 5);
		gbctxtAutor.fill = GridBagConstraints.BOTH;
		gbctxtAutor.gridx = 1;
		gbctxtAutor.gridy = 5;
		add(txtAutor, gbctxtAutor);
		
		JLabel lblTemaLibro = new JLabel("Tema");
		lblTemaLibro.setMaximumSize(new Dimension(125, 35));
		lblTemaLibro.setHorizontalAlignment(SwingConstants.CENTER);
		lblTemaLibro.setMinimumSize(new Dimension(45, 25));
		lblTemaLibro.setFont(new Font("Dialog", Font.BOLD, 15));
		GridBagConstraints gbclblTemaLibro = new GridBagConstraints();
		gbclblTemaLibro.fill = GridBagConstraints.BOTH;
		gbclblTemaLibro.insets = new Insets(0, 0, 5, 5);
		gbclblTemaLibro.gridx = 0;
		gbclblTemaLibro.gridy = 7;
		add(lblTemaLibro, gbclblTemaLibro);
		
		cmbTemas = new JComboBox<>();
		cmbTemas.setMinimumSize(new Dimension(45, 25));
		cmbTemas.setMaximumSize(new Dimension(125, 35));
		cmbTemas.setPreferredSize(new Dimension(45, 25));
		cmbTemas.setToolTipText("Elige un Tema para tu Libro");
		cmbTemas.setFont(new Font("Dialog", Font.PLAIN, 11));
		cmbTemas.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		cmbTemas.setModel(new DefaultComboBoxModel<String>(new String[] {"","Accion", "Aventuras", "Biograf\u00EDa", "Ciencia", "Ciencia Ficci\u00F3n", "Cine", "Econom\u00EDa", "Gastronom\u00EDa", "Historia", "Inform\u00E1tica", "Medicina", "Misterio", "Naturaleza", "Polic\u00EDaco", "Pol\u00EDtica", "Rom\u00E1ntica", "Teatro", "Terror"}));
		GridBagConstraints gbccmbTemas = new GridBagConstraints();
		gbccmbTemas.insets = new Insets(0, 0, 5, 5);
		gbccmbTemas.fill = GridBagConstraints.BOTH;
		gbccmbTemas.gridx = 1;
		gbccmbTemas.gridy = 7;
		add(cmbTemas, gbccmbTemas);
		
		JLabel lblNumPaginas = new JLabel("Num.Pag");
		lblNumPaginas.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumPaginas.setMinimumSize(new Dimension(45, 25));
		lblNumPaginas.setMaximumSize(new Dimension(125, 35));
		lblNumPaginas.setFont(new Font("Dialog", Font.BOLD, 13));
		GridBagConstraints gbclblNumPaginas = new GridBagConstraints();
		gbclblNumPaginas.fill = GridBagConstraints.BOTH;
		gbclblNumPaginas.insets = new Insets(0, 0, 5, 5);
		gbclblNumPaginas.gridx = 0;
		gbclblNumPaginas.gridy = 9;
		add(lblNumPaginas, gbclblNumPaginas);
		
		txtNumPaginas = new JTextField();
		txtNumPaginas.setName("txtNumPaginas");
		txtNumPaginas.setMaximumSize(new Dimension(125, 35));
		txtNumPaginas.setMinimumSize(new Dimension(45, 25));
		txtNumPaginas.setToolTipText("Introduce las P\u00E1ginas Solo numeros Ej 123");
		txtNumPaginas.setFont(new Font("Dialog", Font.BOLD, 11));
		txtNumPaginas.setColumns(10);
		GridBagConstraints gbc_txtNumPaginas = new GridBagConstraints();
		gbc_txtNumPaginas.insets = new Insets(0, 0, 5, 5);
		gbc_txtNumPaginas.fill = GridBagConstraints.BOTH;
		gbc_txtNumPaginas.gridx = 1;
		gbc_txtNumPaginas.gridy = 9;
		add(txtNumPaginas, gbc_txtNumPaginas);
		
		JLabel lblUnidades = new JLabel("Unidades");
		lblUnidades.setMaximumSize(new Dimension(125, 35));
		lblUnidades.setMinimumSize(new Dimension(45, 25));
		lblUnidades.setHorizontalAlignment(SwingConstants.CENTER);
		lblUnidades.setFont(new Font("Dialog", Font.BOLD, 12));
		GridBagConstraints gbc_lblUnidades = new GridBagConstraints();
		gbc_lblUnidades.fill = GridBagConstraints.BOTH;
		gbc_lblUnidades.insets = new Insets(0, 0, 5, 5);
		gbc_lblUnidades.gridx = 0;
		gbc_lblUnidades.gridy = 11;
		add(lblUnidades, gbc_lblUnidades);
		
		spnUnidades = new JSpinner();
		spnUnidades.setName("Unidades");
		GridBagConstraints gbc_spnUnidades = new GridBagConstraints();
		gbc_spnUnidades.fill = GridBagConstraints.HORIZONTAL;
		gbc_spnUnidades.insets = new Insets(0, 0, 5, 5);
		gbc_spnUnidades.gridx = 1;
		gbc_spnUnidades.gridy = 11;
		add(spnUnidades, gbc_spnUnidades);
		spnUnidades.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
	}

	
	//GETTERS AND SETTERS
	
	public JTextField getTxtAutor() {
		return txtAutor;
	}

	public JTextFieldIsbn getTxtISBN() {
		return txtISBN;
	}

	public JTextField getTxtNumPaginas() {
		return txtNumPaginas;
	}

	public JTextField getTxtTitulo() {
		return txtTitulo;
	}

	public JComboBox<String> getCmbTemas() {
		return cmbTemas;
	}

	public JSpinner getSpnUnidades() {
		return spnUnidades;
	}
	
}
