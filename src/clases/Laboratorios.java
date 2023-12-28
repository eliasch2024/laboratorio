
package clases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringJoiner;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Laboratorios {
	
String codigoLaboratorio;
String nombreLaboratorio;
String tipoLaboratorio;

public String getCodigoLaboratorio() {
	return codigoLaboratorio;
}
public void setCodigoLaboratorio(String codigoLaboratorio) {
	this.codigoLaboratorio = codigoLaboratorio;
}
public String getNombreLaboratorio() {
	return nombreLaboratorio;
}
public void setNombreLaboratorio(String nombreLaboratorio) {
	this.nombreLaboratorio = nombreLaboratorio;
}
public String getTipoLaboratorio() {
	return tipoLaboratorio;
}
public void setTipoLaboratorio(String tipoLaboratorio) {
	this.tipoLaboratorio = tipoLaboratorio;
}

public void crearArchivoLaboratorios() {
	try {
		File objetoArchivo = new File("Laboratorios.txt");
		if(objetoArchivo.createNewFile()) {
			JOptionPane.showMessageDialog(null,"Se ha creado correctamente el archivo: "+  objetoArchivo.getName());
		}
		else {
			JOptionPane.showMessageDialog(null, "El archivo ya existe");
		}
		
	} catch (Exception e) {
		System.out.println("Ocurrió un error al crear el archivo");
		
	}
}
public void agregarRegistrosLaboratorios() {
	try {
		FileWriter fw = new FileWriter("Laboratorios.txt",true);
		
		
		fw.write(getCodigoLaboratorio());
		fw.write(",");
		fw.write(getNombreLaboratorio());
		fw.write(",");
		fw.write(getTipoLaboratorio());
		fw.write("\n");
		fw.close();
		
		JOptionPane.showMessageDialog(null,"Se registr� correctamente");
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null,"Ocurrió un error al registrar" + e.toString());
	}
}

public void MostrarTotalLaboratorios(JTable tablaTotalMedicamentos) {
	
	String nombreArchivo = "Laboratorios.txt";
	
	File file = new File(nombreArchivo);
	
	try {
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		String primeraLinea = br.readLine().trim();
		
		DefaultTableModel model = new DefaultTableModel();
		
		model.addColumn("Codigo");
		model.addColumn("NombreLaboratorio");
		model.addColumn("TipoLaboratorio");
		
		tablaTotalLaboratorios.setModel(model);
		
		Object[] tableLines = br.lines().toArray();
		
		for (int i = 0; i < tableLines.length; i++) {
			
			String line = tableLines[i].toString().trim();
			String[] datarow= line.split(",");
			model.addRow(datarow);
			tablaTotalLaboratorios.setModel(model);
		}
		
		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null,"Ocurrio un error"+ e.toString());
		
	}
}

public void seleccionarLaboratorios(JTable tablaLaboratorios) {
	
	try {
		
		int  fila = tablaLaboratorios.getSelectedRow();
		
		if (fila>=0) {
			
			setCodigoLaboratorio(tablaLaboratorios.getValueAt(fila, 0).toString());
			setNombreLaboratorio(tablaLaboratorios.getValueAt(fila, 1).toString());
			setTipoLaboratorio(tablaLaboratorios.getValueAt(fila, 2).toString());
		}
		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null,"Ocurrio un error"+ e.toString());
	}
	
}

public void EliminarLaboratorios (JTable tablaLaboratorios, JTextField codigoLaboratorio) {
	
	//Eliminaci�n visual de la tabla
	DefaultTableModel model = (DefaultTableModel)tablaLaboratorios.getModel();
	
	for (int i = 0; i < model.getRowCount(); i++) {
		
		if(((String)model.getValueAt(i, 0)).equals(codigoLaboratorio.getText())) {	
			model.removeRow(i);
			break;
			
		}
	}
	//Limpieza del archivo .txt
	
	try {
		PrintWriter writer = new PrintWriter("Laboratorios.txt");
		writer.print("");
		writer.close();
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null,"Ocurrió un problema"+ e.toString());
	}
	
	//Creaci�n de los nuevos registros luego de la eliminaci�n
	
	try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("Laboratorios.txt")))) {
		StringJoiner joiner = new StringJoiner(",");
		
		for (int col = 0; col < tablaLaboratorios.getColumnCount(); col++) {
			joiner.add(tablaLaboratorios.getColumnName(col));
		}
		
		System.out.println(joiner.toString());
		bw.write(joiner.toString());
		bw.newLine();
		
		for (int row = 0; row < tablaLaboratorios.getRowCount(); row++) {
			 joiner = new StringJoiner(",");		
			for (int col = 0; col < tablaLaboratorios.getColumnCount(); col++) {
				
				Object obj = tablaLaboratorios.getValueAt(row, col);
				String value = obj == null ? "null" :obj.toString();
				joiner.add(value);
				
			}
			
			
			bw.write(joiner.toString());
			bw.newLine();
			JOptionPane.showMessageDialog(null, "Se elimin� correctamente");
		}

		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Ocurrio un error");
	}
	
	
	
}

public void EditarLaboratorios(JTable tablaLaboratorios) {
	
	//Limpieza del archivo .txt
	
		try {
			PrintWriter writer = new PrintWriter("Laboratorios.txt");
			writer.print("");
			writer.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Ocurrió un problema"+ e.toString());
		}
		
		//Creaci�n de los nuevos registros luego de la eliminaci�n
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("Laboratorios.txt")))) {
			StringJoiner joiner = new StringJoiner(",");
			for (int col = 0; col < tablaLaboratorios.getColumnCount(); col++) {
				joiner.add(tablaLaboratorios.getColumnName(col));
			}
			
			System.out.println(joiner.toString());
			bw.write(joiner.toString());
			bw.newLine();
			
			for (int row = 0; row < tablaLaboratorios.getRowCount(); row++) {
				joiner = new StringJoiner(",");
				for (int col = 0; col < tablaLaboratorios.getColumnCount(); col++) {
					
					Object obj = tablaLaboratorios.getValueAt(row, col);
					String value = obj == null ? "null" :obj.toString();
					joiner.add(value);
					
				}
				
				System.out.println(joiner.toString());
				bw.write(joiner.toString());
				bw.newLine();
				//JOptionPane.showMessageDialog(null, "Se modific� correctamente");
			}

			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocurrio un error");
		}
		
}


}
