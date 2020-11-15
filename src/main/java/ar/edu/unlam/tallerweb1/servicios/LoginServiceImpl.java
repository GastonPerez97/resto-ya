package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioRegistro;
import ar.edu.unlam.tallerweb1.modelo.resultadoBusqueda.ResultadoRegistro;

// Implelemtacion del Servicio de usuarios, la anotacion @Service indica a Spring que esta clase es un componente que debe
// ser manejado por el framework, debe indicarse en applicationContext que busque en el paquete ar.edu.unlam.tallerweb1.servicios
// para encontrar esta clase.
// La anotacion @Transactional indica que se debe iniciar una transaccion de base de datos ante la invocacion de cada metodo del servicio,
// dicha transaccion esta asociada al transaction manager definido en el archivo spring-servlet.xml y el mismo asociado al session factory definido
// en hibernateCOntext.xml. De esta manera todos los metodos de cualquier dao invocados dentro de un servicio se ejecutan en la misma transaccion
@Service("servicioLogin")
@Transactional
public class LoginServiceImpl implements LoginService {

	private RepositorioUsuario servicioLoginDao;

	@Autowired
	public LoginServiceImpl(RepositorioUsuario servicioLoginDao) {
		this.servicioLoginDao = servicioLoginDao;
	}

	@Autowired
	private RepositorioUsuario repositorioUsuario;

	@Override
	public void guardarUsuarioRegistrado(Usuario usuario) {
		repositorioUsuario.guardarUsuarioRegistrado(usuario);

	}

	@Override
	public Usuario consultarUsuarioRegistrado(FormularioRegistro registro) {
		return repositorioUsuario.consultarUsuarioRegistrado(registro.getDatoBuscado());
	}

	@Override
	public Usuario consultarUsuario2(Usuario usuario) {
		return repositorioUsuario.consultarUsuarioRegistrado(usuario);
	}

}
