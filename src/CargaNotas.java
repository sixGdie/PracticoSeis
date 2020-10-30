import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Scanner;

import javax.print.attribute.standard.PrinterMoreInfoManufacturer;

public class CargaNotas {

	public static void main(String[] args) {
	
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		int contador = 0;
		String salida;
		
		while (true) {
			
			Alumno alumno = new Alumno();
			System.out.println("Ingrese nombre y apellido del alumno:");
			String nombreCompleto = new Scanner(System.in).nextLine();
			System.out.println("Ingrese número de legajo:");
			long legajo = new Scanner(System.in).nextLong();
			
			System.out.println("Ingrese la catedra:");
			String catedra = new Scanner(System.in).nextLine();
			alumno.setNombreCompleto(nombreCompleto);
			alumno.setLegajo(legajo);
			contador++;
			alumnos.add(alumno);
			
			System.out.println("[INFO]: Para finalizar la carga de notas, ingrese un número negativo.");
			
			while (true) {
				
				Nota nota = new Nota();
				System.out.println("Ingrese nota:");
				double notaExamen = new Scanner(System.in).nextDouble();
				if (notaExamen >= 0) {
					
					nota.setNotaExamen(notaExamen);
					nota.setCatedra(catedra);
					alumno.agregarNotas(nota);
					
				}
				
				
				if (notaExamen < 0) {
					
					System.out.println("[INFO]: Ha salido del programa.");
					break;
					
				}
				
			}

			if (contador >= 1) {
				
				System.out.println("¿ Desea seguir cargando alumnos ? SI/NO");
				salida = new Scanner(System.in).nextLine();
				
				if (salida.equalsIgnoreCase("NO")) {
					
					System.out.println("[INFO]: Ha finalizado la carga de alumnos.");
					break;
					
				}
				
			}
			
			
		}
		for (Alumno a : alumnos) {
			
			System.out.println("Alumno: " + a.getNombreCompleto() + "\n" + "Legajo: " + a.getLegajo());
			System.out.print("Notas: ");
			
			for (Nota n : a.getNotas()) {
				
				System.out.print(n.getNotaExamen() + " ");
				
			}
			System.out.println();
			
		}
		
	}

}
