package br.edu.ifms.cad.professor;

import java.util.List;

public interface ProfessorDAO {

	public void salvar(Professor usuario);

	public void atualizar(Professor usuario);

	public void excluir(Professor usuario);

	public Professor carregar(Integer codigo);

	public Professor buscarPorLogin(String login);

	public List<Professor> listar();
}
