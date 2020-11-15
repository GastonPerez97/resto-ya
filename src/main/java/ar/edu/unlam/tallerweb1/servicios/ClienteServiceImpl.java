package ar.edu.unlam.tallerweb1.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.repositorios.ClienteRepository;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioRegistro;
import ar.edu.unlam.tallerweb1.modelo.resultadoBusqueda.ResultadoRegistro;

@Service("servicioCliente")
@Transactional
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public void guardarClienteRegistrado(FormularioRegistro registro) {
		registro.getClienteBuscado().setUsuario(registro.getDatoBuscado());
		clienteRepository.guardarCliente(registro.getClienteBuscado());

	}

	@Override
	public ResultadoRegistro consultarClienteRegistrado(FormularioRegistro registro) {
		// TODO Auto-generated method stub
		return null;
	}

}
