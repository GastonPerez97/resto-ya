package ar.edu.unlam.tallerweb1.modelo.enums;

public enum Rol {
	ADMIN("Admin", 1L), 
	CLIENTE("Cliente", 2L);
	
	private String descripcion;
	private Long id;
	
	Rol(String descripcion, Long id) {
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
