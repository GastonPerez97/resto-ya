package ar.edu.unlam.tallerweb1.modelo.form;

public class FormularioNuevaMesa {

	private Long idRestaurante;
	private Integer numeroDeMesa;
	private Integer cantidad;
	private Integer ubicacionFila;
	private Integer ubicacionColumna;
	
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

	public Integer getUbicacionFila() {
		return ubicacionFila;
	}

	public void setUbicacionFila(Integer ubicacionFila) {
		this.ubicacionFila = ubicacionFila;
	}

	public Integer getUbicacionColumna() {
		return ubicacionColumna;
	}

	public void setUbicacionColumna(Integer ubicacionColumna) {
		this.ubicacionColumna = ubicacionColumna;
	}
	
}
