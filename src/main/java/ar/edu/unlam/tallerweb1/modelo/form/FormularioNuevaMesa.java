package ar.edu.unlam.tallerweb1.modelo.form;

public class FormularioNuevaMesa {

	private Long idRestaurante;
	private Integer numeroDeMesa;
	private Integer cantidad;
	
	public FormularioNuevaMesa() {
		
	}

	public Long getIdRestaurante() {
		return idRestaurante;
	}

	public void setIdRestaurante(Long idRestaurante) {
		this.idRestaurante = idRestaurante;
	}
	
	public Integer getNumeroDeMesa() {
		return numeroDeMesa;
	}

	public void setNumeroDeMesa(Integer numeroDeMesa) {
		this.numeroDeMesa = numeroDeMesa;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
}
