/*
 * Christian Daniel Perez De Leon
 * 
 * fuentes consultadas: http://decodigo.com/
 */


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;


public class Archivos {
//Metodo para crear numeros al azar y guardarlos en un array
	public int[] numerosAzar(int cantidad, int maximo) {
		int[] x = new int[cantidad];
		for(int i=0; i < cantidad; i++) {
			x[i] = (int)(Math.random()* maximo+1);
		}
		
		return x;
	}
	
	// metodo para crear un txt y/o escribir en un txt
	public void escribir(int[] numeros) {
		
		try {
			File file = new File("numeros.txt");
			
			
			if(!file.exists()) {
				file.createNewFile();
			}
			
			FileWriter writer = new FileWriter(file);
			BufferedWriter bwriter = new BufferedWriter(writer);
			
			for (int i: numeros) {
				bwriter.write(i + ",");
				
			}
			
			bwriter.close();
			writer.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
			
	}
	
	// metodo para leer un txt y guardar los numeros en un Integer[]
	public Integer[] leer() {
		
		Integer[] x = null;
		
		try {
			
			File file = new File("numeros.txt");
			FileReader reader = new FileReader(file);
			BufferedReader breader = new BufferedReader(reader);
			String a = "";
			String b = "";
			
			while((b = breader.readLine()) != null) {
				a = b;
			}
			
			
			String[] separar = a.split(",");
			x = new Integer[separar.length];
			
			for(int i=0; i< separar.length -1; i++) {
				
				x[i] = Integer.parseInt(separar[i]);
			}
			
			breader.close();
			reader.close();
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return x;
	}
	
	
}
