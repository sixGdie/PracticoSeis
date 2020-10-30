import java.util.Date;
import java.util.Scanner;

public class CargaDDJJStockAgroquimico {

	private static String[][] agroquimicos = { { "1001", "2EC JEBAGRO", "A" }, { "1002", "D 60 GREEN CROPS", "V" },
			{ "1003", "ESTER 97", "A" }, { "1004", "AMINA ICONA SL", "A" }, { "1005", "ABAMECTINA AGRO", "A" },
			{ "1006", "FURACARB 31 TS", "R" }, { "1007", "FURAFARM 48 F", "R" }, { "1008", "ACETOCLOR ASSA", "A" },
			{ "1009", "GLIFOSATO ACTIVE SIL", "R" }, { "1010", "ABRIGO PLUS", "V" } };
	private static int cantidadAgroquimicos;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DDJJStockAgroquimico ddjj = new DDJJStockAgroquimico();

		System.out.println("==================================");
		System.out.println("INGRESAR DATOS");
		System.out.println("==================================");
		System.out.println();

		String razonSocial = leerRazonSocial();
		long cuit = leerCuit();
		int anioDeclaracion = leerAnio();
		int mesDeclaracion = leerMes(anioDeclaracion);
		mostrarDatosIngresados(razonSocial, cuit, anioDeclaracion, mesDeclaracion);

		ddjj.setEmpresa(razonSocial);
		ddjj.setCuit(cuit);
		ddjj.setAnioDeclaracion(anioDeclaracion);
		ddjj.setMesDeclaracion(mesDeclaracion);

		while (true) {

			String[] agroquimicosInformados = buscarAgroquimico();
			System.out.println("Ingrese la capacidad del envase a informar:");
			double capacidadEnvase = new Scanner(System.in).nextDouble();

			if (capacidadEnvase <= 0) {

				System.out.println("[ERROR]: La capacidad del envase debe ser mayor a cero, inténtelo nuevamente.");
				capacidadEnvase = new Scanner(System.in).nextDouble();

			}

			System.out.println("Ingrese la cantidad de envases a informar:");
			int cantidadEnvases = new Scanner(System.in).nextInt();

			if (cantidadEnvases <= 0) {

				System.out.println("[ERROR]: La capacidad del envase debe ser mayor a cero, inténtelo nuevamente.");
				cantidadEnvases = new Scanner(System.in).nextInt();

			}

			String numeroLote = "";
			if (agroquimicosInformados[2].equals("R")) {

				System.out.println(
						"Ingrese el número de lote del agroquímico " + agroquimicosInformados[1].toUpperCase() + ":");
				numeroLote = new Scanner(System.in).nextLine();

			}
			double subTotal = capacidadEnvase * cantidadEnvases;
			ddjj.asignarDatos(agroquimicosInformados[0], agroquimicosInformados[1], capacidadEnvase, cantidadEnvases,
					subTotal, numeroLote);

			System.out.println(
					"Si desea continuar cargando agroquímico escriba 'SI'. De lo contrario, ingrese cualquier letra.");
			String salir = new Scanner(System.in).nextLine();

			if (salirPrograma(salir)) {

				System.out.println("[INFO]: Ha salido del programa.");
				break;

			}
		}
		ddjj.calcularTotalKiloLitros();
		imprimirDDJJ(ddjj);

	}

	static String leerRazonSocial() {

		System.out.println("Ingrese razón social:");
		String razonSocial = new Scanner(System.in).nextLine();

		if (razonSocial.isEmpty()) {

			System.out.println("[ERROR]: La razón social no puede estar vacía, inténtelo nuevamente.");
			leerRazonSocial();

		}

		return razonSocial;
	}

	static long leerCuit() {

		System.out.println("Ingrese CUIT:");
		long cuit = new Scanner(System.in).nextLong();

		if (Long.toString(cuit).length() != 11) {

			System.out.println("[ERROR]: El CUIT debe tener 11 dígitos, inténtelo nuevamente.");
			leerCuit();

		}

		return cuit;
	}

	static int leerAnio() {

		System.out.println("Ingrese el año de declaración:");
		int anioDeclaracion = new Scanner(System.in).nextInt();

		if (anioDeclaracion > (new Date().getYear() + 1900)) {

			System.out.println("[ERROR]: El año de declaración no puede superar el año actual, inténtelo nuevamente.");
			leerAnio();

		}

		return anioDeclaracion;
	}

	static int leerMes(int anioDeclaracion) {

		System.out.println("Ingrese el mes de declaración:");
		int mesDeclaracion = new Scanner(System.in).nextInt();

		if (anioDeclaracion == (new Date().getYear() + 1900) && mesDeclaracion > (new Date().getMonth() + 1)) {

			System.out.println("[ERROR]: El mes de declaración no puede superar el mes actual, inténtelo nuevamente.");
			leerMes(anioDeclaracion);

		}

		return mesDeclaracion;
	}

	static void mostrarDatosIngresados(String razonSocial, long cuit, int anioDeclaracion, int mesDeclaracion) {

		System.out.println();
		System.out.println("==================================");
		System.out.println("DATOS INGRESADOS");
		System.out.println("==================================");
		System.out.println("Razón Social: " + razonSocial);
		System.out.println("CUIT: " + cuit);
		System.out.println("Año Declarión: " + anioDeclaracion);
		System.out.println("Mes Declaración: " + mesDeclaracion);
		System.out.println();

	}

	static boolean salirPrograma(String salida) {

		if (salida.toUpperCase().equals("SI")) {

			return false;

		}

		return true;
	}

	static String[] buscarAgroquimico() {

		System.out.println("Ingrese el código del agroquímico a informar:");
		String codigoAgroquimico = new Scanner(System.in).nextLine();
		boolean agroquimicoEncontrado = false;
		String[] agroquimicoBuscado = new String[3];

		for (int i = 0; i < agroquimicos.length; i++) {

			if (agroquimicos[i][0].equals(codigoAgroquimico)) {

				agroquimicoBuscado[0] = agroquimicos[i][0];
				agroquimicoBuscado[1] = agroquimicos[i][1];
				agroquimicoBuscado[2] = agroquimicos[i][2];
				agroquimicoEncontrado = true;
				break;

			}
		}

		if (!agroquimicoEncontrado) {

			System.out.println("[ERROR]: El código ingresado no existe, inténtelo nuevamente.");
			buscarAgroquimico();

		}

		return agroquimicoBuscado;

	}

	private static String completarConEspacios(String cadena) {
		int cantidadEspacios = 20 - cadena.length();
		for (int i = 0; i < cantidadEspacios; i++) {
			cadena += " ";
		}
		return cadena;
	}

	private static void imprimirDDJJ(DDJJStockAgroquimico ddjj) {
		System.out.println("--------------------------------------------------------");
		System.out.println("CUIT: " + ddjj.getCuit());
		System.out.println("Mes: " + ddjj.getMesDeclaracion());
		System.out.println("Año: " + ddjj.getAnioDeclaracion());
		System.out
				.println(completarConEspacios("Código Agroquímico") + "\t" + completarConEspacios("Nombre Agroquímico")
						+ "\t" + completarConEspacios("Capacidad") + "\t" + completarConEspacios("Cantidad") + "\t"
						+ completarConEspacios("Subtotal") + "\t" + completarConEspacios("N° de Lote") + "");
		for (DDJJStockAgroquimicoDetalle detalle : ddjj.getDetallesAgroquimicos()) {
			System.out.println(completarConEspacios(detalle.getCodigoAgroquimico()) + "\t "
					+ completarConEspacios(detalle.getNombreAgroquimico()) + " \t "
					+ completarConEspacios(Double.toString(detalle.getCapacidadEnvase())) + " \t "
					+ completarConEspacios(Integer.toString(detalle.getCantidadEnvases())) + " \t "
					+ completarConEspacios(Double.toString(detalle.getSubTotal())) + " \t "
					+ completarConEspacios(detalle.getNumeroLote()) + "");
		}
		System.out.println("\t\t\t\t\t\t\t\tTotal: " + ddjj.getTotalKiloLitros());
		System.out.println("--------------------------------------------------------");
	}

}
