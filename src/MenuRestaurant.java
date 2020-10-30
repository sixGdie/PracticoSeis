import java.util.ArrayList;
import java.util.Scanner;

public class MenuRestaurant {

	public static void main(String[] args) {
		ArrayList<Plato> platosMenu = new ArrayList<Plato>();
		while (true) {

			Plato plato = new Plato();
			String nombrePlato = leerNombrePlato();
			double precioPlato = leerPrecioPlato();
			System.out.println("Si es una bebida, ingrese 'SI'.");
			plato.setNombreCompleto(nombrePlato);
			plato.setPrecio(precioPlato);
			plato.setEsBebida(new Scanner(System.in).nextLine());

			if (!plato.getEsBebida()) {

				while (true) {

					Ingrediente ingrediente = new Ingrediente();
					String nombreIngrediente = leerNombreIngrediente();
					String unidadMedida = leerUnidadMedida();
					double cantidadIngrediente = leerCantidadIngrediente();
					ingrediente.setNombre(nombreIngrediente);
					ingrediente.setUnidadMedida(unidadMedida);
					ingrediente.setCantidad(cantidadIngrediente);
					plato.agregarIngredientes(ingrediente);
					System.out.println("¿ Desea seguir agregando ingredientes ? SI/NO");
					String salirIngrediente = new Scanner(System.in).nextLine();
					if (!deseaSeguir(salirIngrediente))
						break;

				}

			}
			platosMenu.add(plato);
			System.out.println("¿ Desea seguir cargando platos al menú ? SI/NO");
			String salirPlato = new Scanner(System.in).nextLine();
			if (!deseaSeguir(salirPlato))
				break;

		}
		imprimirPlatos(platosMenu);

	}

	static String leerNombrePlato() {

		System.out.println("Ingrese el nombre del plato:");
		String nombrePlato = new Scanner(System.in).nextLine();

		if (nombrePlato.isEmpty()) {

			System.out.println("[ERROR]: El nombre del plato no puede estar vacío, inténtelo nuevamente.");
			leerNombrePlato();

		}

		return nombrePlato;
	}

	static double leerPrecioPlato() {

		System.out.println("Ingrese el precio del plato:");
		double precioPlato = new Scanner(System.in).nextDouble();

		if (precioPlato <= 0) {

			System.out.println("[ERROR]: El precio del plato debe ser mayor a cero, inténtelo nuevamente.");
			leerPrecioPlato();

		}

		return precioPlato;
	}

	static String leerNombreIngrediente() {

		System.out.println("Ingrese el nombre del ingrediente:");
		String nombreIngrediente = new Scanner(System.in).nextLine();

		if (nombreIngrediente.isEmpty()) {

			System.out.println("[ERROR]: El nombre del ingrediente no puede estar vacío, inténtelo nuevamente.");
			leerNombreIngrediente();

		}

		return nombreIngrediente;
	}

	static String leerUnidadMedida() {

		System.out.println("Ingrese la unidad de medida:");
		String unidadMedida = new Scanner(System.in).nextLine();

		if (unidadMedida.isEmpty()) {

			System.out.println("[ERROR]: La unidad de medida no puede estar vacía, inténtelo nuevamente.");
			leerUnidadMedida();

		}

		return unidadMedida;
	}

	static double leerCantidadIngrediente() {

		System.out.println("Ingrese la cantidad del ingrediente elegido:");
		double cantidadIngrediente = new Scanner(System.in).nextDouble();

		if (cantidadIngrediente <= 0) {

			System.out.println("[ERROR]: La cantidad ingresada no es válida, inténtelo nuevamente.");
			leerCantidadIngrediente();

		}

		return cantidadIngrediente;
	}

	static boolean deseaSeguir(String seguir) {

		if (seguir.equalsIgnoreCase("SI")) {

			return true;

		} else if (seguir.equalsIgnoreCase("NO")) {

			System.out.println("[INFO]: Ha finalizado la carga de platos/ingredientes.");
			return false;

		}

		return true;

	}

	static void imprimirPlatos(ArrayList<Plato> platosMenu) {

		System.out.println("--------------MENÚ--------------");

		for (Plato p : platosMenu) {

			System.out.println(p.getNombreCompleto());
			System.out.println("Precio: $ " + p.getPrecio());
			if (!p.getEsBebida()) {

				System.out.println("====================");
				System.out.println("INGREDIENTES");
				System.out.println("====================");
				System.out.println("Ingrediente " + "\t" + completarConEspacios("Cantidad") + "\t"
						+ completarConEspacios("Unidad de Medida"));
				System.out.println();
				for (Ingrediente i : p.getIngredientes()) {

					System.out.println(i.getNombre() + "\t\t" + completarConEspacios(
							Double.toString(i.getCantidad()) + "\t\t" + completarConEspacios(i.getUnidadMedida())));

				}

			}

		}

	}

	public static String completarConEspacios(String cadena) {
		int cantidadEspacios = 7 - cadena.length();
		for (int i = 0; i < cantidadEspacios; i++) {
			cadena += " ";
		}
		return cadena;
	}

}
