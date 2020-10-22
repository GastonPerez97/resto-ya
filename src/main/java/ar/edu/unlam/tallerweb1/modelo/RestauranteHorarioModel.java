package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
@Table(name = "restaurante_horario")
public class RestauranteHorarioModel {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_restaurante_horario")
	private Long idRestauranteHorario;
	
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_restaurante", nullable = false)
    private RestauranteModel restauranteModel;
	
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_horario", nullable = false)
    private HorarioModel horarioModel;
    
    public RestauranteHorarioModel() {
    	
    }

	public Long getIdRestauranteHorario() {
		return idRestauranteHorario;
	}

	public void setIdRestauranteHorario(Long idRestauranteHorario) {
		this.idRestauranteHorario = idRestauranteHorario;
	}

	public RestauranteModel getRestauranteModel() {
		return restauranteModel;
	}

	public void setRestauranteModel(RestauranteModel restauranteModel) {
		this.restauranteModel = restauranteModel;
	}

	public HorarioModel getHorarioModel() {
		return horarioModel;
	}

	public void setHorarioModel(HorarioModel horarioModel) {
		this.horarioModel = horarioModel;
	}

}
