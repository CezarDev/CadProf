package br.edu.ifms.cad.professor;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class ProfessorDAOHibernate implements ProfessorDAO {

	private Session	session;

	public void setSession(Session session) {
		this.session = session;
	}

	public void salvar(Professor usuario) {
		this.session.save(usuario);
	}

	public void atualizar(Professor usuario) {
		this.session.update(usuario);
	}

	public void excluir(Professor usuario) {
		this.session.delete(usuario);
	}

	public Professor carregar(Integer codigo) {
		//TODO o hibernate nao conseguira fazer a carga caso seja passado o Usuario
		// no parametro, tem que ser diretamente a chave (integer)
		return (Professor) this.session.get(Professor.class, codigo);
	}

	public Professor buscarPorLogin(String login) {
		String hql = "select u from Usuario u where u.login = :login";
		Query consulta = this.session.createQuery(hql);
		consulta.setString("login", login);

		//TODO mostrar primeiramente com o list e depois apresentar o uniqueResult
		return (Professor) consulta.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Professor> listar() {
		return this.session.createCriteria(Professor.class).list();
	}
}
