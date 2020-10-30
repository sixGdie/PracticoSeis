import java.util.ArrayList;

public class DDJJStockAgroquimico {

	private int anioDeclaracion;
	private int mesDeclaracion;
	private double totalKiloLitros;
	private String empresa;
	private long cuit;
	private ArrayList<DDJJStockAgroquimicoDetalle> detallesAgroquimicos;
	
	public DDJJStockAgroquimico() {
		
	}

	public int getAnioDeclaracion() {
		return anioDeclaracion;
	}

	public void setAnioDeclaracion(int anioDeclaracion) {
		this.anioDeclaracion = anioDeclaracion;
	}

	public int getMesDeclaracion() {
		return mesDeclaracion;
	}

	public void setMesDeclaracion(int mesDeclaracion) {
		this.mesDeclaracion = mesDeclaracion;
	}

	public double getTotalKiloLitros() {
		return totalKiloLitros;
	}

	public void setTotalKiloLitros(double totalKiloLitros) {
		this.totalKiloLitros = totalKiloLitros;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public long getCuit() {
		return cuit;
	}

	public void setCuit(long cuit) {
		this.cuit = cuit;
	}
	
	public ArrayList<DDJJStockAgroquimicoDetalle> getDetallesAgroquimicos() {
		return detallesAgroquimicos;
	}

	public void setDetallesAgroquimicos(ArrayList<DDJJStockAgroquimicoDetalle> detallesAgroquimicos) {
		this.detallesAgroquimicos = detallesAgroquimicos;
	}

	public void calcularTotalKiloLitros() {
		
		double total = 0;
		for (DDJJStockAgroquimicoDetalle detalle : this.detallesAgroquimicos) {
			
			total += detalle.getSubTotal();
			
		}
		this.totalKiloLitros = total;
		
	}
	
	public void asignarDatos(String codigoAgroquimico, String nombreAgroquimico, double capacidadEnvase, int cantidadEnvases, double subTotal, String numeroLote) {
		
		DDJJStockAgroquimicoDetalle detalle = new DDJJStockAgroquimicoDetalle();
		detalle.setCodigoAgroquimico(codigoAgroquimico);
		detalle.setNombreAgroquimico(nombreAgroquimico);
		detalle.setCantidadEnvases(cantidadEnvases);
		detalle.setCantidadEnvases(cantidadEnvases);
		detalle.setSubTotal(subTotal);
		detalle.setNumeroLote(numeroLote);
		
		if (this.detallesAgroquimicos == null) {
			
			this.detallesAgroquimicos = new ArrayList<DDJJStockAgroquimicoDetalle>();
			
		}
		
		this.detallesAgroquimicos.add(detalle);
		
	}
	
	
	
}
