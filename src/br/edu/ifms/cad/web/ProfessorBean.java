package br.edu.ifms.cad.web;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.edu.ifms.cad.professor.Professor;
import br.edu.ifms.cad.professor.ProfessorRN;

@ManagedBean(name = "professorBean")
@RequestScoped
public class ProfessorBean {

	//PARTE 1
	private Professor usuario = new Professor();
	private String confirmarSenha;
	
	//PARTE 2
	private List<Professor> lista;
	private String destinoSalvar;

	public String novo() {
		
		//PARTE 2
		this.destinoSalvar = "usuarioSucesso";
		
		//PARTE 1
		this.usuario = new Professor();
		this.usuario.setAtivo(true);
		return "usuario";
	}
	
	//PARTE 2
	public String editar() {
		this.confirmarSenha = this.usuario.getSenha();
		return "/publico/usuario";
	}

	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();

		String senha = this.usuario.getSenha();
		if (!senha.equals(this.confirmarSenha)) {
			FacesMessage facesMessage = new FacesMessage
					("A senha não foi confirmada corretamente");
			context.addMessage(null, facesMessage);
			return null;
		}

		ProfessorRN usuarioRN = new ProfessorRN();
		usuarioRN.salvar(this.usuario);
		
		this.destinoSalvar = "usuarioSucesso";
		//PARTE 2
		//return "usuarioSucesso"; //tirar parte 1
		return this.destinoSalvar;
	}
	
	//PARTE 2
	public String excluir() {
		ProfessorRN usuarioRN = new ProfessorRN();
		usuarioRN.excluir(this.usuario);
		this.lista = null;
		
		return null;
	}
	
	//PARTE 2
	public String ativar() {
		if(this.usuario.isAtivo()) {
			this.usuario.setAtivo(false);
		}
		else
			this.usuario.setAtivo(true);
		
		ProfessorRN usuarioRN = new ProfessorRN();
		usuarioRN.salvar(this.usuario);
		return null;
	}
	
	//PARTE 2
	public List<Professor> getLista() {
		if (this.lista == null) {
			ProfessorRN usuarioRN = new ProfessorRN();
			this.lista = usuarioRN.listar();
		}
		
		
		return lista;
	}
		
	public Professor getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Professor usuario) {
		this.usuario = usuario;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

	public void setLista(List<Professor> lista) {
		this.lista = lista;
	}

	public String getDestinoSalvar() {
		return destinoSalvar;
	}

	public void setDestinoSalvar(String destinoSalvar) {
		this.destinoSalvar = destinoSalvar;
	}

	
}
