package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
@Table(name = "mesa")
public class MesaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_mesa")
	private Long idMesa;
	
	@Column(name = "numero_mesa")
	private Integer numeroDeMesa;
	
	@Column(name = "cantidad")
    private Integer cantidad;
	
	@Column(name = "ubicacion_fila")
	private Integer ubicacionFila;
	
	@Column(name = "ubicacion_columna")
	private Integer ubicacionColumna;
	
	@ManyToOne
	@JoinColumn(name = "id_restaurante")
	private RestauranteModel restaurante;
    
    public MesaModel() {
    	
    }
    
    public MesaModel(Long idMesa) {
    	this.idMesa = idMesa;
    }

	public Long getIdMesa() {
		return idMesa;
	}

	public void setIdMesa(Long idMesa) {
		this.idMesa = idMesa;
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

	public RestauranteModel getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(RestauranteModel restaurante) {
		this.restaurante = restaurante;
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
