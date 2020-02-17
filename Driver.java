/*
 * Christian Perez De Leon
 * 
 * 
 */

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Sort sort = new Sort();
		Archivos archivo = new Archivos();
		// crear numero al azar
		int[] numeros = archivo.numerosAzar(20, 1000);
		//Crear y leer archivos txt con los numeros generados al azar
		archivo.escribir(numeros);
		Integer[] lista1 = archivo.leer();
		
		
		//Ingresar los datos necesarios para Seleccion Sort y probar con JProfiler
		Integer[] resultado = lista1.clone();
		Integer[] dat = new Integer[19];
		
		for (int o = 0; o <= 19 -1;o++) {
			dat[o] = resultado[o];
		}
		
		sort.SelectionSort(dat);
		sort.printArray(dat);
		
		
		
		
		
	}

}
