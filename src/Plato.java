import java.util.ArrayList;

public class Plato {

	private String nombreCompleto;
	private double precio;
	private boolean esBebida;
	private ArrayList<Ingrediente> ingredientes;
	
	public Plato() {
		
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public boolean getEsBebida() {
		return esBebida;
	}

	public void setEsBebida(String esBebida) {

		if (esBebida.equalsIgnoreCase("SI")) {
			
			this.esBebida = true;
			
		} else {
			
			this.esBebida = false;
			
		}
		
	}

	public ArrayList<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	public void agregarIngredientes(Ingrediente ingrediente) {
		
		if (this.ingredientes == null) {
			
			this.ingredientes = new ArrayList<Ingrediente>();
			
		}
		this.ingredientes.add(ingrediente);
		
	}
	
}
