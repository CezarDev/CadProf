package br.edu.ifms.cad.professor;

import java.util.List;

import br.edu.ifms.cad.util.DAOFactory;


public class ProfessorRN {

	private ProfessorDAO	usuarioDAO;

	public ProfessorRN() {
		this.usuarioDAO = DAOFactory.criarUsuarioDAO();
	}

	public Professor carregar(Integer codigo) {
		return this.usuarioDAO.carregar(codigo);
	}

	public Professor buscarPorLogin(String login) {
		return this.usuarioDAO.buscarPorLogin(login);
	}

	public void salvar(Professor usuario) {

		Integer codigo = usuario.getCodigo();
		if (codigo == null || codigo == 0) {
			this.usuarioDAO.salvar(usuario);
		} else {
			this.usuarioDAO.atualizar(usuario);
		}
	}

	public void excluir(Professor usuario) {		
		this.usuarioDAO.excluir(usuario);
	}

	public List<Professor> listar() {
		return this.usuarioDAO.listar();
	}
	
	
}