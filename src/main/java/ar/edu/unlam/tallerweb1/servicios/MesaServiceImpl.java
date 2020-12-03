package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.MesaModel;
import ar.edu.unlam.tallerweb1.modelo.RestauranteModel;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioNuevaMesa;
import ar.edu.unlam.tallerweb1.repositorios.MesaRepository;

@Service("mesaService")
@Transactional
public class MesaServiceImpl implements MesaService {

	@Autowired
	private MesaRepository mesaRepository;

	@Override
	public List<MesaModel> getMesasDisponiblesParaReservaByRestaurante(Long idRestaurante) {
		return mesaRepository.getMesasByRestaurante(idRestaurante);
	}

	@Override
	public MesaModel getMesaById(Long idMesa) {
		return mesaRepository.getMesaById(idMesa);
	}

	@Override
	public void guardarMesa(MesaModel mesa) {
		mesaRepository.guardarMesa(mesa);
	}

	@Override
	public MesaModel ProcesarNuevaMesa(FormularioNuevaMesa formulario) {
		MesaModel mesa = new MesaModel();
		mesa.setNumeroDeMesa(formulario.getNumeroDeMesa());
		mesa.setCantidad(formulario.getCantidad());
		mesa.setRestaurante(new RestauranteModel(formulario.getIdRestaurante()));
		
		guardarMesa(mesa);
		
		return mesa;
	}

	@Override
	public Integer getMaximaUbicacionFilaByRestaurante(Long idRestaurante) {
		return mesaRepository.getMaximaUbicacionFilaByRestaurante(idRestaurante);
	}

	@Override
	public Integer getMaximaUbicacionColumnaByRestaurante(Long idRestaurante) {
		return mesaRepository.getMaximaUbicacionColumnaByRestaurante(idRestaurante);
	}

	@Override
	public MesaModel[][] generarMapaDeMesas(List<MesaModel> mesas) {
		Long idRestaurante = mesas.get(0).getRestaurante().getIdRestaurante();
		Integer filaMaxima = getMaximaUbicacionFilaByRestaurante(idRestaurante);
		Integer columnaMaxima = getMaximaUbicacionColumnaByRestaurante(idRestaurante);
		
		MesaModel[][] matrizMesas = new MesaModel[filaMaxima][columnaMaxima];
		
		for (MesaModel mesa : mesas)
			matrizMesas[mesa.getUbicacionFila() - 1][mesa.getUbicacionColumna() - 1] = mesa;
		
		return matrizMesas;
	}

}
