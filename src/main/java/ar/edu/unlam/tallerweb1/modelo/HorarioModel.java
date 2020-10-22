package ar.edu.unlam.tallerweb1.modelo;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "horario")
public class HorarioModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_horario")
	private Long idHorario;
	
	@Column(name = "horario")
    private Time horario;
	
    @OneToMany(mappedBy = "horarioModel", cascade = CascadeType.ALL)
    private List<RestauranteHorarioModel> restauranteHorarioList;
    
    public HorarioModel() {
    	restauranteHorarioList = new ArrayList<RestauranteHorarioModel>();
    }

	public Long getIdHorario() {
		return idHorario;
	}

	public void setIdHorario(Long idHorario) {
		this.idHorario = idHorario;
	}

	public Time getHorario() {
		return horario;
	}

	public void setHorario(Time horario) {
		this.horario = horario;
	}

	public List<RestauranteHorarioModel> getRestauranteHorarioList() {
		return restauranteHorarioList;
	}

	public void setRestauranteHorarioList(List<RestauranteHorarioModel> restauranteHorarioList) {
		this.restauranteHorarioList = restauranteHorarioList;
	}
    
}
