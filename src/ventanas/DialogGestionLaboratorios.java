
package ventanas;

/**
 *
 * @author Elias Chipana
 */
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogGestionLaboratorios extends JDialog {
	private JTextField txtCodigoLaboratorios;
	private JTextField txtNombreLaboratorio;
	private JTextField txtTipoLaboratorio;
	private JTable tbListaLaboratorios;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogGestionLaboratorios dialog = new DialogGestionLaboratorios();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogGestionLaboratorios() {
            setTitle("GESTION DE LABORATORIOS");
		setBounds(100, 100, 633, 313);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos de Laboratorios", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 55, 239, 214);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		txtCodigoLaboratorios = new JTextField();
		txtCodigoLaboratorios.setBounds(132, 24, 86, 20);
		panel.add(txtCodigoLaboratorios);
		txtCodigoLaboratorios.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Codigo");
		lblNewLabel_3.setBounds(10, 27, 46, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Nombre Laboratorio");
		lblNewLabel_4.setBounds(10, 68, 112, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Tipo Laboratorio");
		lblNewLabel_5.setBounds(10, 106, 112, 14);
		panel.add(lblNewLabel_5);
		
		txtNombreLaboratorio = new JTextField();
		txtNombreLaboratorio.setBounds(132, 65, 86, 20);
		panel.add(txtNombreLaboratorio);
		txtNombreLaboratorio.setColumns(10);
		
		txtTipoLaboratorio = new JTextField();
		txtTipoLaboratorio.setBounds(132, 103, 86, 20);
		panel.add(txtTipoLaboratorio);
		txtTipoLaboratorio.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clases.Laboratorios objetoLaboratorios = new clases.Medicamentos();
				objetoLaboratorios.setCodigoLaboratorio(txtCodigoMedicamentos.getText());
				objetoLaboratorios.setNombreLaboratorio(txtNombreMedicamento.getText());
				objetoLaboratorios.setTipoLaboratorio(txtTipoMedicamento.getText());
				objetoLaboratorios.agregarRegistrosLaboratorios();
			}
		});
		btnGuardar.setBounds(10, 140, 99, 23);
		panel.add(btnGuardar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clases.Laboratorios objetoLaboratorios = new clases.Laboratorios();
				objetoLaboratorios.EditarLaboratorios(tbListaLaboratorios);
			}
		});
		btnEditar.setBounds(109, 140, 112, 23);
		panel.add(btnEditar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clases.Laboratorios objetoLaboratorios = new clases.Laboratorios();
				objetoLaboratorios.EliminarLaboratorios(tbListaLaboratorios, txtCodigoLaboratorios);
			}
		});
		btnEliminar.setBounds(10, 168, 208, 29);
		panel.add(btnEliminar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Lista de Laboratorios", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(275, 54, 338, 177);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 30, 318, 136);
		panel_1.add(scrollPane);
		
		tbListaLaboratorios = new JTable();
		scrollPane.setViewportView(tbListaLaboratorios);
		
		JButton btnCrearArchivoLaboratorios = new JButton("Crear Archivo de Laboratorios");
		btnCrearArchivoLaboratorios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clases.Laboratorios objetoLaboratorios= new clases.Laboratorios();
				objetoLaboratorios.crearArchivoLaboratorios();
			}
		});
		btnCrearArchivoLaboratorios.setBounds(10, 21, 239, 23);
		getContentPane().add(btnCrearArchivoLaboratorios);
		
		JButton btnMostrarLaboratorios = new JButton("Mostrar Laboratorios");
		btnMostrarLaboratorios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clases.Laboratorios objetoLaboratorios = new clases.Laboratorios();
				objetoLaboratorios.MostrarTotalLaboratorios(tbListaLaboratorios);
			}
		});
		btnMostrarLaboratorios.setBounds(275, 21, 158, 23);
		getContentPane().add(btnMostrarLaboratorios);
		
		JButton btnSeleccionar = new JButton("Seleccionar Laboratorio");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clases.Laboratorios objetoLaboratorios = new clases.Laboratorios();
				
				objetoLaboratorios.seleccionarLaboratorios(tbListaLaboratorios);
				txtCodigoLaboratorios.setText(objetoLaboratorios.getCodigoLaboratorio());
				txtNombreLaboratorio.setText(objetoLaboratorio.getNombreLaboratorio());
				txtTipoLaboratorio.setText(objetoLaboratorios.getTipoLaboratorio());
			}
		});
		btnSeleccionar.setBounds(443, 20, 164, 23);
		getContentPane().add(btnSeleccionar);
	}
}
