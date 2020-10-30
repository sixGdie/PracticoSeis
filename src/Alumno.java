import java.util.ArrayList;

public class Alumno {

	private String nombreCompleto;
	private long legajo;
	private ArrayList<Nota> notasAlumno;

	public Alumno(String nombreCompleto, long legajo, ArrayList<Nota> notasAlumno) {

		this.nombreCompleto = nombreCompleto;
		this.legajo = legajo;
		if (this.notasAlumno == null) {

			this.notasAlumno = new ArrayList<Nota>();

		}

	}

	public Alumno() {

	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public long getLegajo() {
		return legajo;
	}

	public void setLegajo(long legajo) {
		this.legajo = legajo;
	}

	public ArrayList<Nota> getNotas() {
		return notasAlumno;
	}

	public void setNotas(ArrayList<Nota> notasAlumno) {
		this.notasAlumno = notasAlumno;
	}

	public String promedioNotas() {

		double promedio = 0;
		double sumaNotas = 0;

		for (Nota nota : notasAlumno) {

			sumaNotas += nota.getNotaExamen();

		}
		promedio = sumaNotas / notasAlumno.size();

		return "\nPromedio: " + promedio;
	}

	public void agregarNotas(Nota nota) {

		if (this.notasAlumno == null) {

			this.notasAlumno = new ArrayList<Nota>();

		}
		this.notasAlumno.add(nota);

	}

}
