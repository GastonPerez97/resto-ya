package ar.edu.unlam.tallerweb1.repositorios;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unlam.tallerweb1.modelo.ClienteModel;


public interface ClienteRepositoryImpl {

	ClienteModel consultarClientePorId();


}