import java.util.ArrayList;

public class DDJJStockAgroquimicoDetalle {

	private String codigoAgroquimico;
	private String nombreAgroquimico;
	private double capacidadEnvase;
	private int cantidadEnvases;
	private double subTotal;
	private String numeroLote;

	public DDJJStockAgroquimicoDetalle() {

	}

	public String getCodigoAgroquimico() {
		return codigoAgroquimico;
	}

	public void setCodigoAgroquimico(String codigoAgroquimico) {
		this.codigoAgroquimico = codigoAgroquimico;
	}

	public String getNombreAgroquimico() {
		return nombreAgroquimico;
	}

	public void setNombreAgroquimico(String nombreAgroquimico) {
		this.nombreAgroquimico = nombreAgroquimico;
	}

	public double getCapacidadEnvase() {
		return capacidadEnvase;
	}

	public void setCapacidadEnvase(double capacidadEnvase) {
		this.capacidadEnvase = capacidadEnvase;
	}

	public int getCantidadEnvases() {
		return cantidadEnvases;
	}

	public void setCantidadEnvases(int cantidadEnvases) {
		this.cantidadEnvases = cantidadEnvases;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public String getNumeroLote() {
		return numeroLote;
	}

	public void setNumeroLote(String numeroLote) {
		this.numeroLote = numeroLote;
	}

}
