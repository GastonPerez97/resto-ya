package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
@Table(name = "restaurante")
public class RestauranteModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_restaurante")
	private Long idRestaurante;
	
    @Column(name = "nombre")
    private String nombre;
    
	private String direccion;
	private String horario;
	private String telefono;
	private String imageName;

    public RestauranteModel() {
    	
    }
    
	public Long getIdRestaurante() {
		return idRestaurante;
	}
	
	public void setIdRestaurante(Long idRestaurante) {
		this.idRestaurante = idRestaurante;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

//	public RestauranteModel buscarRestaurantePorId(Long codigo) {
//		// TODO Auto-generated method stub
//		return null;
//	}                                  ?????????????????

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imagen) {
		this.imageName = imagen;
	}
	
}
