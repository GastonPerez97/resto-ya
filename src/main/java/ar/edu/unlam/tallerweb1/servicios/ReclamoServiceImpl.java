package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.modelo.ReclamoModel;
import ar.edu.unlam.tallerweb1.repositorios.ReclamoRepository;

@Service
@Transactional
public class ReclamoServiceImpl implements ReclamoService{

	@Inject
	private ReclamoRepository repositorioReclamo;
	
	@Override
	public void guardarReclamo(ReclamoModel reclamo) {
		repositorioReclamo.guardarReclamo(reclamo);
	}


}
