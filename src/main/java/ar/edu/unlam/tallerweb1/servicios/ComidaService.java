package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.ComidaModel;

public interface ComidaService {

	public ArrayList<ComidaModel> buscarComida();

	public List<ComidaModel> buscarComidaDeseada(String nombre);

}
