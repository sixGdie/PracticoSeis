
public class Nota {

	private String catedra;
	private double notaExamen;
	
	public Nota(String catedra, double notaExamen) {
		
		this.catedra = catedra;
		this.notaExamen = notaExamen;
		
	}
	
	public Nota() {
		
	}

	public String getCatedra() {
		return catedra;
	}

	public void setCatedra(String catedra) {
		this.catedra = catedra;
	}

	public double getNotaExamen() {
		return notaExamen;
	}

	public void setNotaExamen(double notaExamen) {
		this.notaExamen = notaExamen;
	}
	
}
