package ar.edu.unlam.tallerweb1.modelo.enums;

public enum EstadoReserva {
	PENDIENTE_DE_CONFIRMACION("Pendiente", 1L), 
	CONFIRMADA("Confimada", 2L), 
	CANCELADA("Cancelada", 3L);
	
	private String descripcion;
	private Long id;
	
	EstadoReserva(String descripcion, Long id) {
		this.descripcion = descripcion;
		this.id = id;		
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
