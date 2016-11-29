package br.com.sysfinanceiro.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.sysfinanceiro.model.dao.DAOException;
import br.com.sysfinanceiro.model.entity.Categoria;
import br.com.sysfinanceiro.model.entity.Usuario;
import br.com.sysfinanceiro.model.service.CategoriaService;
import br.com.sysfinanceiro.model.service.ServiceException;

@Controller
@ViewScoped
public class CategoriaBean {
	
	/**
	 * Objeto que contera os dados da tela para salvar
	 * Objeto Vinculado ou Bindable com componente da tela
	 */
	private Categoria categoria = new Categoria();
	
	
	private List<Categoria> categoriaList;
	@Inject
	private CategoriaService categoriaService;
	
	@PostConstruct
	public void inicializar(){
		categoriaList = categoriaService.buscarTodos();
	}
	
	public void limpar(){
		categoria = new Categoria();
	}
	
	public void salvar() {
		try {
			categoriaService.salvar(categoria);
			// Limpar os dados
			categoria = new Categoria();
			// Atualiza lista
			categoriaList = categoriaService.buscarTodos();
			// Envia Mensagem para Tela
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Salvo com Sucesso!", null));
		} catch (ServiceException e) {
			// C�digo da mensagem de erro para Tela
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Erro ao Salvar: " + e.getMessage(), null));
			e.printStackTrace();
		}
	}

	public void excluir() {
		categoriaService.excluir(categoria);
		// Nova inst�ncia para limpar formul�rio
		categoria = new Categoria();
		// Atualiza lista
		categoriaList = categoriaService.buscarTodos();
	}
	
	public void buscarTodos(){
		categoriaService.buscarTodos();
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Categoria> getCategoriaList() {
		return categoriaList;
	}

	public void setCategoriaList(List<Categoria> categoriaList) {
		this.categoriaList = categoriaList;
	}
	
	public boolean isEditando() {
		return this.categoria.getId() != null;
	}
	
	

}
