package br.edu.ifms.cad.util;

import br.edu.ifms.cad.professor.ProfessorDAO;
import br.edu.ifms.cad.professor.ProfessorDAOHibernate;

public class DAOFactory {

	public static ProfessorDAO criarUsuarioDAO() {
		ProfessorDAOHibernate usuarioDAO = new ProfessorDAOHibernate();
		usuarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return usuarioDAO;
	}

	
}